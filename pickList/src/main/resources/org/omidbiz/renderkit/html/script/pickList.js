if (!window.Fanpardaz) {
window.Fanpardaz = {};
}

if (!Fanpardaz.pickList) {
	Fanpardaz.pickList = {};
}

Fanpardaz.pickList.updateTargetValues = function updateTargetValues(updatedInputId, dest){
	var inputServer = jQuery(updatedInputId);	
	var opts = jQuery(dest).children();
	var arr=[];
	opts.each(function(index, opt) {
		arr.push(opt.value);
	});
	inputServer.val(arr.join(','));
}

Fanpardaz.pickList.moveAllItems = function moveAllItems(origin, dest, updatedInputId) {
	var opts = jQuery(origin).children();	
    opts.appendTo(dest);
    //
    Fanpardaz.pickList.updateTargetValues(updatedInputId, dest);
}

Fanpardaz.pickList.moveItems = function moveItems(origin, dest, updatedInputId) {
	var opt = jQuery(origin).find(':selected');
	opt.appendTo(dest);
	//
	Fanpardaz.pickList.updateTargetValues(updatedInputId, dest);
}