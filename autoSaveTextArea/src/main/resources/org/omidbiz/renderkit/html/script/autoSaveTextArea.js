(function($) {
	 $.fn.autoSaveTextArea = function(options) {
	    var defaults = {
            interval: 5,
            saveOnCookie: "true",
            cookieKeyParameter:"",
            width:null,
            height:null,
            callBackFunction:null
        };
	    options = $.extend(defaults, options);
	    return this.each(function() {
	    	var $this = $(this);
	    	var style = ("style=width:"+options.width+";height:"+options.height+";")&&(options.width!=null&&options.height!=null);
	    	var $parent = $this.wrap("<div "+style+" class='auto-save-textArea'></div>").parent();
	    	var $timer;
	    	var timeScale = 1000;
	    	var $CurrentId = $this.attr("id");
	    	var $isDirty = false;
	    	var $isFirstKey =true;
	    	var $restoreButton; 
	    	var $saveButton;
	    	init();
	    	function isCookieExists(){
	    		if (readCookies() == "")
	    		{
	    			$restoreButton.attr("disabled","disabled");
	    			return false; 
	    		}
	    		else
	    		{
	    			$restoreButton.removeAttr("disabled");
	    			return true;
	    		}
	    	}
	    	function init(){
	    		var $panel = $("<div class='control-panel'></div>");
		    	var $buttonSave =$( "<div class='timer-Button save' disabled='disabled' status='off'><img src=' data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAfklEQVRIie3UwRHAEBCFYSUoQSlK0kHSSVrTQdLBnwu3ZWysnLwZMw6PDwfO7WgCROBGn2sUeD5sPo7UpuLGOsQA6CNGQHv9b8BsNrAMSIAvI1kDSeieloAXut4SCEI3WALn6icCOMqpQ5k30wNmvuua3AMikGc2B2IT2JHyAnZdBHtDYqfeAAAAAElFTkSuQmCC' height='13px'/></div>");
		    	var $buttonRecover = $("<div class='timer-Button restore' status='on'><img src=' data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAABFklEQVRIie2U3W3DMAyEM4JH0AgZQRskG0Ub1CN4g2SDeIN0g2QDe4OvDz0iiixLMpo+tQQECOSJxz9xt/uXdwjggRNwBSadq3T+J4474ExdPoBuq/O9IgWYgV6ZOB0v3SzMHdhvidycj4ArYJ0wRlLPBLiY8w0ZG0lfAx6jsiwily2sZGLl8iWCUIpkjUC2vmQ30FiKokLgZb+UCCzNbLMqBJ01OzUMrMuQIbiRGcmI4JFjz5EMGZwHHrK/fLBqiRKShfMEG1TOz0jX1OSh5jzCOhsG3e1z+pb3m4TWj5Y8CnxvTVfAOGFQb9qWnibCmjmpoQeey+4g3RQ5b1t2CYntpZL0zZGvEHmVa9TkzLqHX2no35IvyTh/UgDDZeIAAAAASUVORK5CYII=' height='13px' /></div>");
		    	var $timerDisplay = $("<div class='timer-display'></div>");
		    	$panel.append($buttonSave); 
		    	$panel.append($buttonRecover);
		    	$parent.append($panel);
		    	$restoreButton = $parent.find(".timer-Button.restore");
		    	$saveButton =  $parent.find(".timer-Button.save");
		    	isCookieExists();
	    	}
	    	function dirtyTextAreaRender(){
	    		$this.removeClass("persisted-textarea");
	    		$this.addClass("dirty-textarea");
	    	}
	    	function persistedTextAreaRender(){
	    		$this.removeClass("dirty-textarea");
	    		$this.addClass("persisted-textarea");
	    	}
	    	function saveCookies(){
	    		var currentTextArea=$CurrentId;
	    		var textAreaVal = replaceEnterChar();
	    	    var d = new Date();
	    	    d.setTime(d.getTime() + (30*24*60*60*1000));
	    	    var expires = "expires=" + d.toGMTString();
	    	    if(options.cookieKeyParameter != "")
	    	    	document.cookie = "autoSaveTextArea_"+$CurrentId+"_"+options.cookieKeyParameter+"="+textAreaVal+"; "+expires;
	    	    else
	    	    	document.cookie = "autoSaveTextArea_"+$CurrentId+"="+textAreaVal+"; "+expires;
	    	}
	    	function readCookies(){
	    	    if(options.cookieKeyParameter != "")
	    	    	var name = "autoSaveTextArea_"+$CurrentId+"_"+options.cookieKeyParameter + "=";
	    	    else
	    	    	var name = "autoSaveTextArea_"+$CurrentId+ "=";
	    	    var ca = document.cookie.split(';');
	    	    for(var i=0; i<ca.length; i++) {
	    	        var c = ca[i];
	    	        while (c.charAt(0)==' ') c = c.substring(1);
	    	        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
	    	    }
	    	    return "";
	    	}
	    	function showControlPanel(){
	    		var cpanel = $parent.find(".control-panel");
	    		cpanel.css("opacity",1.0);
	    	}
	    	function hideControlPanel(){
	    		var cpanel = $parent.find(".control-panel");
	    		cpanel.css("opacity",0.0);
	    	}
	    	function timerStart(){
	    		$timer = setTimeout(function(){
	    			saveValue();
	    		},timeScale * options.interval);
	    	};
	    	function restoreValue(){
	    		$this.val("");
	    		$this.val(readCookies().replace(/\%0A/g, "\n"));
	    	}
	    	function saveValue(){
	    		if($isDirty)
    			{
    				if(options.saveOnCookie == "true")
    					saveCookies();
    				else if(typeof callBackFunction == "function")
    					options.callBackFunction();
    				persistedTextAreaRender();	    				
    				$saveButton.attr("disabled","true");
    				$restoreButton.removeAttr("disabled");
    			}
    			$isDirty = false;
    			$isFirstKey = true;
	    	}
	    	function replaceEnterChar(){
	    		var textAreaVal = $this.val();
	    		if(textAreaVal.contains("\n"))
	    		{
	    			var splitEnterInputTextArea = textAreaVal.split("\n");
	    			var resultString = "";
	    			console.log("splitEnterInputTextArea: "+splitEnterInputTextArea);
	    			for(var i = 0; i < splitEnterInputTextArea.length ; i++)
	    			{
	    				if(i != textAreaVal.length-1)
	    					resultString += splitEnterInputTextArea[i]+encodeURIComponent("\n");
	    				else
	    					resultString += splitEnterInputTextArea[i];
	    				console.log("resultString1: "+resultString);
	    			}
	    			console.log("resultString2: "+resultString);
	    			return resultString;
	    		}
	    		else 
	    		   return textAreaVal;
	    	}
	    	function timerStop(){
	    		clearTimeout($timer);
	    	}
	    	$saveButton.on("click",function(){
	    		if($saveButton.attr("disabled")!=="disabled")
	    			saveValue();
	    	});
	    	$restoreButton.on("click",function(){
	    		if($restoreButton.attr("disabled")!=="disabled")
	    			restoreValue();
	    	});
	    	$parent.on("mouseenter",function(){
	    		 showControlPanel();
	    	});
	    	$parent.on("mouseleave",function(){
	    		 hideControlPanel();
	    	});
	    	$parent.on("keypress",function(e){
	    		$isDirty = true;
	    		dirtyTextAreaRender();
	    		isCookieExists(); 
	    		$saveButton.removeAttr("disabled");
	    		if($isFirstKey)
	    		{
	    			timerStart();
	    		}
	    		$isFirstKey =false;
	    	});

	    });
	 }
})(jQuery);