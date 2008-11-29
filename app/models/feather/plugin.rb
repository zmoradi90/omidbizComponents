module Feather
  class Plugin
    include DataMapper::Resource

    property :id, Integer, :key => true, :serial => true
    property :url, String, :length => 255
    property :path, String, :length => 255
    property :name, String, :length => 255
    property :version, String, :length => 255
    property :author_name, String, :length => 255
    property :author_email, String, :length => 255
    property :author_homepage, String, :length => 255
    property :homepage, String, :length => 255
    property :about, String, :length => 255
    property :active, Boolean

    before :save, :download
    after :create, :install
    after :create, :set_create_activity
    after :update, :set_update_activity
    after :destroy, :remove

    class << self
      @@loaded = []
    end

    ##
    # This grabs the plugin using its url, unpacks it, and loads the metadata for it
    def download
      if new_record?
        begin
          # Load the manifest yaml
          manifest = run_or_error("Unable to access manifest!") do
            YAML::load(Net::HTTP.get(::URI.parse(url)))
          end
          # Grab metadata from manifest
          run_or_error("Unable to parse manifest YAML!") do
            self.name = manifest["name"]
            self.author_name = manifest["author"]["name"]
            self.author_email = manifest["author"]["email"]
            self.author_homepage = manifest["author"]["homepage"]
            self.version = manifest["version"]
            self.homepage = manifest["homepage"]
            self.about = manifest["about"]
          end
          # Build the path
          run_or_error("Unable to build plugin path!") do
            self.path = File.join(Merb.root, "app", "plugins", self.name)
          end
          # Remove any existing plugin at the path
          run_or_error("Unable to remove existing plugin path!") do
            FileUtils.rm_rf(self.path)
          end
          # Create new plugin path
          run_or_error("Unable to create new plugin path!") do
            FileUtils.mkdir_p(self.path)
          end
          # Download the package
          package = run_or_error("Unable to retrieve package!") do
            package_url = File.join(url.split('/').slice(0..-2).join('/'), manifest["package"])
            Net::HTTP.get(::URI.parse(package_url))
          end
          # Unzip the package
          run_or_error("Unable to unpack zipped plugin package!") do
            Archive::Tar::Minitar.unpack(Zlib::GzipReader.new(StringIO.new(package)), self.path)
          end
          # Unpack any gems downloaded
          run_or_error("Unable to unpack gems provided by the plugin package!") do
            unpack_gems(Dir.glob(File.join(self.path, "gems", "*.gem")).collect { |p| p.split("/").last })
          end
        rescue Exception => err
          self.errors.add :general, "Error downloading plugin: #{err.message}"
        end
      end
    end
    
    ##
    # This method executes the block provided, and if an exception is thrown by that block, will re-raise
    # it with the specified message - good for trapping lots of code with more friendly error messages
    def run_or_error(message, &block)
      yield
    rescue
      raise message
    end

    ##
    # This loads and installs the plugin
    def install
      # Ensure we don't have any errors while saving already
      if self.errors.empty?
        begin
          # Load the plugin
          self.load
          # Also, if there is an "install.rb" script present, run that to setup anything the plugin needs (database tables etc)
          require File.join(self.path, "install.rb") if File.exists?(File.join(self.path, "install.rb"))
        rescue Exception => err
          # If we have an issue installing, lets destroy the plugin to rollback, and put an error on the object so it displays on the form
          self.destroy
          self.errors.add :general, "Error installing plugin: #{err.message}"
        end
      else
        # If we do, destroy the plugin to rollback, and then the form will display the errors
        self.destroy
      end
    end

    ##
    # This adds the activity to show a plugin has been installed
    def set_create_activity
      if new_record?
        a = Feather::Activity.new
        a.message = "Plugin \"#{self.name}\" installed"
        a.save
      end
    end

    ##
    # This adds the activity to show a plugin has been updated
    def set_update_activity
      unless new_record?
        a = Feather::Activity.new
        a.message = "Plugin \"#{self.name}\" #{self.active ? 'activated' : 'de-activated'}"
        a.save
      end
    end

    ##
    # This removes the plugin, de-registers hooks, and adds an activity to show a plugin has been deleted
    def remove
      FileUtils.rm_rf(self.path) unless self.path.nil?
      Feather::Hooks.remove_plugin_hooks(self.id)
      a = Feather::Activity.new
      a.message = "Plugin \"#{self.name}\" deleted"
      a.save
    end

    ##
    # This loads the plugin, first loading any gems it may have
    def load
      # Plugin dependencies let you load a plugin before this one,
      # so we don't want to load that sucker twice, now do we?
      unless loaded?
        # Setup the Gem path to the plugin
        Gem.use_paths(Gem.dir, ((Gem.path - [Gem.dir]) + [self.path]))
        # Load the plugin init script
        require File.join(self.path, "init.rb")
        # Add the plugin to the array of loaded plugins
        @@loaded << self.name
      end
    end

    ##
    # This returns true if the plugin has been loaded, false otherwise
    def loaded?
      @@loaded.include?(self.name)
    end
  
    def author
      {
        'name' => author_name,
        'email' => author_email,
        'homepage' => author_homepage
      }
    end
  
    def author=(author)
      %W{name email homepage}.each do |k|
        self.send("author_#{k}=".to_sym, author[k])
      end
    end

    private
      ##
      # This recursively uses the yaml to download the files specified in the manifest
      def recurse(yaml, base_dir = self.path, base_url = self.url)
        yaml.keys.each do |dir|
          path = (dir == "." ? base_dir : File.join(base_dir, dir))
          url = (dir == "." ? base_url : File.join(base_url, dir))
          case yaml[dir].class.to_s
          when "Array":
            yaml[dir].each do |file|
              FileUtils.mkdir_p(path)
              f = File.open(File.join(path, file), "w")
              f.write(Net::HTTP.get(URI.parse(File.join(url, file))))
              f.close
              f = nil
            end
          when "Hash":
            recurse(yaml[dir], path, url)
          end
        end
      end

      ##
      # This recursively unpacks the gems used by the plugin
      def unpack_gems(gems)
        gems.each do |gem|
          # Unpack the gem
          `cd #{File.join(self.path, "gems")}; gem unpack #{File.join(File.join(self.path, "gems"), gem)}`
        end
      end
  end
end