if (!window.Richfaces) {
window.Richfaces = {};
}

if (!Richfaces.colorboxControl) {
	Richfaces.colorboxControl = {};
}

Richfaces.colorboxControl.getParameters = function getParameters(){
    var
    settingsObject = {},
    hash,
    hashes = location.search.substring(1).split(/&/);
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        settingsObject[hash[0]] = hash[1];
    }
    return settingsObject;
}

Richfaces.colorboxControl.extendedClose = function extendedClose(id, value, obj, extraInfo){		
	parent.document.getElementById(obj+"Id").value = id;
	parent.document.getElementById(obj+"Name").value = value;
	parent.document.getElementById(obj+"Name").title = extraInfo;	
}

Richfaces.colorboxControl.extendedCloseBox = function extendedCloseBox(){
	parent.jQuery.fn.colorbox.close();
}

Richfaces.colorboxControl.applyAutoNumeric = function applyAutoNumeric(obj){			
	jQuery('#'+obj+"Name",window.parent.document).autoNumeric('init', {aSep: ',', vMax: '999999999999999999999999999.99',vMin: '0000000000000000000000000.00'});
	jQuery('#'+obj+"Name",window.parent.document).autoNumeric('set', parent.document.getElementById(obj+"Name").value);	
}


Richfaces.colorboxControl.extendedRequestClose = function extendedRequestClose(id, value, obj, url){		
	parent.document.getElementById(obj+"Id").value = id
	parent.document.getElementById(obj+"Name").value = value;
    jQuery.ajax({
        type: "POST",
        url: url,
        data: obj+"Id="+id,
        success: function(msg){
    		parent.jQuery.fn.colorbox.close();
        }
       });
	
}

Richfaces.colorboxControl.removeValue = function removeValue(obj){		
	document.getElementById(obj+"Id").value = "";
	document.getElementById(obj+"Name").value = "";	
	
}
