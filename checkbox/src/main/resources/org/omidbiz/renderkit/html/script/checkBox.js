if (!window.Richfaces) {
window.Richfaces = {};
}

if (!Richfaces.checkboxControl) {
	Richfaces.checkboxControl = {};
}

Richfaces.checkboxControl.setYvalue = function setYvalue(clientId){
	var chkCmp = document.getElementById(clientId+"-chk");
	var chkVal = chkCmp.value;
	if(chkVal == 'N'){
		chkCmp.value = 'Y' 
	}
}

