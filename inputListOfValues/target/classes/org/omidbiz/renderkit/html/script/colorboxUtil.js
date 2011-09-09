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

Richfaces.colorboxControl.extendedClose = function extendedClose(id, value, obj){		
	parent.document.getElementById(obj+"Id").value = id
	parent.document.getElementById(obj+"Name").value = value;
	parent.jQuery.fn.colorbox.close();
	
}
