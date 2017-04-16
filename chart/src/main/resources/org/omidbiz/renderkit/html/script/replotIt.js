(function($) {
    $.fn.rePlotIt = function() {
		$(this).show();
		var id = $(this).attr("id");
    	jQuery.jqplot(id,dataSets,opt).replot();
    	return $(this);
    }
})(jQuery);