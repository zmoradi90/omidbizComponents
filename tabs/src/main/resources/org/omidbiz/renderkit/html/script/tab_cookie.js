"use strict";
var cookieManager = {
		write: function(cname, cvalue){
			document.cookie = cname + "=" + cvalue + "; "
		}, 
		read: function read(cname){
			var name = cname + "=";
		    var ca = document.cookie.split(';');
		    for(var i=0; i<ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0)==' ') c = c.substring(1);
		        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
		    }
		    return "";
		}
};  

