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
	opts.each(function(){
		jQuery(this).removeAttr('selected');
	});
    opts.appendTo(dest);
    //
    Fanpardaz.pickList.updateTargetValues(updatedInputId, dest);
}

Fanpardaz.pickList.moveItems = function moveItems(origin, dest, updatedInputId) {
	var opt = jQuery(origin).find(':selected');
	opt.removeAttr('selected');
	opt.appendTo(dest);
	//
	Fanpardaz.pickList.updateTargetValues(updatedInputId, dest);
}

Fanpardaz.pickList.sourceClickManager = function sourceClickManager(clientId, forceId){
	Fanpardaz.pickList.moveItems(clientId+'_source', clientId+'_target', forceId);
	var sourceListItems=jQuery(clientId+'_source');
	if(sourceListItems.children().size()===1)
	{
		jQuery(clientId+'_copyall').attr('disabled',true);
		jQuery(clientId+'_copy').attr('disabled',true);
		jQuery(clientId+'_removeall').attr('disabled',false);
	}
	else if(sourceListItems.children().size()>1)
	{
		jQuery(clientId+'_copy').attr('disabled',false);
		jQuery(clientId+'_removeall').attr('disabled',false);
	}
	//
	
}

Fanpardaz.pickList.targetClickManager = function targetClickManager(clientId, forceId){
	Fanpardaz.pickList.moveItems(clientId + "_target",clientId+"_source",forceId);
	var targetId = clientId + "_target";
	var targetListItems=jQuery(targetId);
	if(targetListItems.children().size()===1)
	{
		jQuery(clientId+'_remove').attr('disabled',true);
		jQuery(clientId+'_removeall').attr('disabled',true);
		jQuery(clientId+'_copyall').attr('disabled',false);
	}
	else if(targetListItems.children().size()>1)
	{
		jQuery(clientId+'_removeall').attr('disabled',false);
		jQuery(clientId+'_copyall').attr('disabled',false);
	}
	
}