var sm = {
		createQtip : function(compId, url) {
			jQuery('#'+compId).qtip({
			    content: {
			        text: '<iframe src="%URL%" width="1000" height="600" frameborder="0" id="%UUID%"></iframe>'.replace(new RegExp('%URL%', 'g'), url).replace(new RegExp('%UUID%', 'g'), compId+"_iframe"),
							title: {
								text: '  ',
								button: true
							}
			    },position: {
							at: 'bottom right',
							my: 'top right'
						},show: 'click',
						hide: 'unfocus'
						
				});
		},
		searchAndReload : function(compId, baseUrl, mapParam)
		{					
			var frame_url = baseUrl + sm.serialize(mapParam);			
			jQuery("#"+compId+"_iframe").attr('src', frame_url);
		},
		serialize : function(mapObj) {
			  var str = [];
			  for(var p in mapObj)
			    if (mapObj.hasOwnProperty(p)) {
			      str.push(encodeURIComponent(p) + "=" + encodeURIComponent(mapObj[p]));
			    }
			  return str.join("&");
		}
}