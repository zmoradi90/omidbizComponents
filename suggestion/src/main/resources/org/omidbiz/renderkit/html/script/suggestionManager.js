var sm = {		
		createQtip : function(compId, url, w, h) {
			var tooltip = jQuery('#'+compId+'Name').qtip({
			    content: {
			        text: '<iframe src="%URL%" frameborder="0" id="%UUID%" style="height: %HEIGHT%px; width:%WIDTH%px;"></iframe>'.replace(new RegExp('%HEIGHT%','g'), h).replace(new RegExp('%WIDTH%','g'), w).replace(new RegExp('%URL%', 'g'), url).replace(new RegExp('%UUID%', 'g'), compId+"_iframe"),
							title: {
								text: '  ',
								button: true
							}
			    },position: {
							at: 'bottom right',
							my: 'top right'
						},
						show: 'click',
						hide: 'unfocus',
						style: {width: w, height: h, classes: 'qtip-light', def: false}
						
				}).qtip('api');
			
			return tooltip;
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
