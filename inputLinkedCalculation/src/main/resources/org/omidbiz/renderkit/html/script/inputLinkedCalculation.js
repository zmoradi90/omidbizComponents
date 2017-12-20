(function($) {
	$.fn.inputLinkedCalculation = function(option) {
		var defaultOperator = {
				PLUS : "+",
				MINUS : "-",
				MULTI : "*",
				DIV : "/",
			}
		var defaults = {
			targetIds : '#t1,#t2',
			outputIds : '#o1',
			calculationPattern:'#s1+#t1*$100'
		};
		var sourceId =  $(this).attr("id") != undefined? "#"+$(this).attr("id") : console.error("inputLinkCalculation error : input id must not be null"); 
		var notEmptyOption = {};
		$.each(option, function(i, val) {
			if (val != null && val != "") {
				notEmptyOption[i] = val;
			}
		});
		var options = $.extend({}, defaults, notEmptyOption);
		var regEx = "(([#|$]([A-Z|a-z|0-9|_|:])*)([+,*,/,-]){1})*([#|$]([A-Z|a-z|0-9|_|:])*)([+,*,/,-]){1}([#|$]([A-Z|a-z|0-9|_|:])*)";
		var newFormula = "";
		var formuleBuilder = function(){
			var patt = new RegExp(regEx);
			var targetIdsList = options.targetIds.split(",");
			var res = patt.exec(options.calculationPattern);
			for(var i = 0 ; i < res.length ; i++)
			{
				if(res[i] == undefined || i == 0)
				{
					continue;
				}
				else if(res[i].search("\\$") >= 0)
				{
					newFormula += res[i].split("$")[1];
				}
				else if(res[i] == sourceId) 
				{
					newFormula += $(colonIgonore(sourceId)).is("input")?$(colonIgonore(sourceId)).val():$(colonIgonore(sourceId)).html();
				}
				else if(res[i] == defaultOperator.PLUS)
				{
					newFormula += defaultOperator.PLUS;
				}
				else if(res[i] == defaultOperator.MINUS)
				{
					newFormula += defaultOperator.MINUS;
				}
				else if(res[i] == defaultOperator.MULTI)
				{
					newFormula += defaultOperator.MULTI;
				}
				else if(res[i] == defaultOperator.DIV)
				{
					newFormula += defaultOperator.DIV;
				}
				else
				{
					for(var j = 0 ; j < targetIdsList.length ; j++)
					{
						if(res[i] == targetIdsList[j])
						{
							newFormula += $(colonIgonore(targetIdsList[j])).is("input")?$(colonIgonore(targetIdsList[j])).val():$(colonIgonore(targetIdsList[j])).html();
							break;
						}
					}
				}
				
			}
		};
		var output = function(){
			var outputIdsList = options.outputIds.split(",");
			console.log(newFormula);
			if(newFormula != undefined)
				for(var i = 0 ; i < outputIdsList.length ; i++)
				{ 
					$(colonIgonore(outputIdsList[i])).is("input")?$(colonIgonore(outputIdsList[i])).val(convertStringToFunction(newFormula)):$(colonIgonore(outputIdsList[i])).html(convertStringToFunction(newFormula)); 
				}
		};
		var convertStringToFunction = function (strFn){
			return new Function("return(" + strFn + ")")();
		};
		var colonIgonore = function(str){
			return str.replace(/\:/g,"\\:");
		};
		formuleBuilder();
		output();
		
		$(this).blur(function(){
			newFormula = "";
			formuleBuilder();
			output();
		}); 
		$(this).keyup(function(){
			newFormula = "";
			formuleBuilder();
			output();
		});
	}
}(jQuery));