"use strict";
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
		loadTabFrame: function(tab, url) {
            if (jQuery(tab).find("iframe").length == 0) {
                var html = [];
                html.push('<div class="ui-iframe-holder">');
                html.push('<iframe onload="javascript:tabManager.onIframeLoadComplete();" frameborder="0" class="ui-tabs-iframe" src="' + url + '">Load Failed?</iframe>');
                html.push('</div>');
                jQuery(tab).append(html.join(''));
                jQuery(tab).find("iframe").height(jQuery(window).height()-120);
            }
            return false;
        },
        onIframeLoadComplete: function(){
        	jQuery(".ui-tabs-iframe").css('background-image', 'none');
        }

};  

