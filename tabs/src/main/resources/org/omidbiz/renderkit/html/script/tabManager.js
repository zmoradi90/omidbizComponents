"use strict";
var tabFunc;
var tabManager = {
		writeCookie: function(cname, cvalue){
			document.cookie = cname + "=" + cvalue + "; "
		}, 
		readCookie: function(cname){
			var name = cname + "=";
		    var ca = document.cookie.split(';');
		    for(var i=0; i<ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0)==' ') c = c.substring(1);
		        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
		    }
		    return "";
		},
		loadTabFrame: function(tab, url, uid) {
            if (jQuery(tab).find("iframe").length == 0) {
            	if(typeof tabFunc !== 'undefined')
            	{
            		clearTimeout(tabFunc);
            	}
                var html = [];
                var iframeContent = '<iframe name="_iframeTab_%UID%" id="_iframeTab_%UID%" scrolling="no" onload="javascript:tabManager.onIframeLoadComplete();" frameborder="0" class="ui-tabs-iframe" src="' + url + '">Load Failed?</iframe>';
                html.push('<div class="ui-iframe-holder">');
                html.push(iframeContent.replace(new RegExp('%UID%', 'g'), uid));
                html.push('</div>');
                jQuery(tab).append(html.join(''));
                jQuery(tab).find("iframe").height(jQuery(window).height()-120);
                tabManager.resizeMonitoring(uid);
            }
            return false;
        },
        onIframeLoadComplete: function(){
        	jQuery(".ui-tabs-iframe").css('background-image', 'none');
        },
        resizeMonitoring:function(uid){
        	if(typeof uid !== 'undefined' || uid != '')
        	{
        		var elmId = '_iframeTab_%UID%';
        		var elementFrame = elmId.replace('%UID%', uid);
        		if(typeof document.getElementById(elementFrame) !== 'undefined')
       			{
        			if(window.frames[elementFrame].document.body !== 'undefined' && window.frames[elementFrame].document.body != null)
        			{
        				if(window.frames[elementFrame].document.body.scrollHeight > (jQuery(window).height()-120))
        				{
        					document.getElementById(elementFrame).style.height=window.frames[elementFrame].document.body.scrollHeight + 'px';
        				}
        			}
       			}
        	}
        	tabFunc = setTimeout(function(){tabManager.resizeMonitoring(uid)}, 250);
        }

};  

