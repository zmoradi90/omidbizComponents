require File.join(File.dirname(__FILE__), "../..", 'spec_helper.rb')

module Feather::Admin
  describe Dashboards do
    before(:each) do
      @activity = [mock(:activity)]
    end

    describe "/admin" do
      it "should request dashboard" do
        ::Feather::Activity.should_receive(:all).with(:order => [:created_at.desc], :limit => 5).and_return(@activity)
        controller = dispatch_to(Dashboards, :index) do |controller|
          controller.should_receive(:login_required).and_return(true)
          controller.should_receive(:display).with(@activity)
        end
        controller.assigns(:activity).should == @activity
        controller.should be_successful
      end
    end
  end
end