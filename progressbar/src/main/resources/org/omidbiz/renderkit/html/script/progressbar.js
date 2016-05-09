function progressBar(inputId,percentage,maxFraction)
{
	var id = inputId.replace(/\:/g, '\\:');
	var pct = percentage;
	var decimalDigit = maxFraction;
	var multipler=1;
	var decimalNumber = pct;
	var integerNumber = parseInt(pct); 
	finalNumber = 0;
	for(var i = 0;i< decimalDigit ; i++)
	{
		multipler = multipler * 10;
	}
	decimalNumber = decimalNumber * multipler;
	decimalNumber = parseInt(decimalNumber % multipler);
	finalNumber = (integerNumber * multipler) + decimalNumber;
	finalNumber = finalNumber / multipler;
	var completeBar=jQuery("#"+id+"_precentage_bar_complete").css("width",finalNumber+"%");
	var remindBar=jQuery("#"+id+"_precentage_bar_remiand").css("width",100-finalNumber+"%");

	completeBar.children().html("%"+finalNumber);
	remindBar.children().html("%"+finalNumber);
	
	if(parseInt(finalNumber)>=75)
		{
			completeBar.children(".progressbar-bar-percentage-complete-text").show();
			remindBar.children(".progressbar-bar-percentage-remiand-text").hide(); 
		}
	if(parseInt(finalNumber)==100)
	{
		completeBar.removeClass("progressbar-bar-percentage-complete-base-color");
		completeBar.addClass("progressbar-bar-percentage-complete-base-color-full"); 
	}
	if(parseInt(finalNumber)>100)
	{
		completeBar.addClass("progressbar-bar-percentage-error-base-color-full");
	}	
}			