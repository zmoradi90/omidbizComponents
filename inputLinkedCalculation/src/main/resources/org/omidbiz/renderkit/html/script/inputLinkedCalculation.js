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
			dateId : '',
			outputIds : '#o1',
			calculationPattern:'#s1+#t1*$100',
			seperator:"/",
			convertDateCallbackFuncInput:'',
			convertDateCallbackFuncOutput:''
		};
		var elm = $(this);
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
		var hasDate = false;
		var formuleBuilder = function(){
			if(elm.val() == undefined || elm.val() == "")
				return;
			hasDate = options.dateId.length <= 0? false : true;
			var patt = new RegExp(regEx);
			var targetIdsList = options.targetIds.split(",");
			var res = patt.exec(options.calculationPattern);
				var date="";
				var duration="";
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
					if(hasDate)
						if(sourceId == options.dateId)
							date = $(colonIgonore(sourceId)).is("input")?$(colonIgonore(sourceId)).val():$(colonIgonore(sourceId)).html();
						else
							duration += $(colonIgonore(sourceId)).is("input")?$(colonIgonore(sourceId)).val():$(colonIgonore(sourceId)).html();
					else
						newFormula += $(colonIgonore(sourceId)).is("input")?$(colonIgonore(sourceId)).val():$(colonIgonore(sourceId)).html();
				}
				else if(res[i] == defaultOperator.PLUS)
				{
					if(hasDate)
						duration += defaultOperator.PLUS;
					else
						newFormula += defaultOperator.PLUS;
				}
				else if(res[i] == defaultOperator.MINUS)
				{
					if(hasDate)
						duration += defaultOperator.MINUS;
					else
						newFormula += defaultOperator.MINUS;
				}
				else if(res[i] == defaultOperator.MULTI)
				{
					if(hasDate)
						duration += defaultOperator.MULTI;
					else
						newFormula += defaultOperator.MULTI;
				}
				else if(res[i] == defaultOperator.DIV)
				{
					if(hasDate)
						duration += defaultOperator.DIV;
					else
						newFormula += defaultOperator.DIV;
				}
				else
				{
					for(var j = 0 ; j < targetIdsList.length ; j++)
					{
						if(res[i] == targetIdsList[j])
						{
							if(hasDate)
								if(targetIdsList[j] == options.dateId)
									date = $(colonIgonore(targetIdsList[j])).is("input")?$(colonIgonore(targetIdsList[j])).val():$(colonIgonore(targetIdsList[j])).html();
								else
									duration += $(colonIgonore(targetIdsList[j])).is("input")?$(colonIgonore(targetIdsList[j])).val():$(colonIgonore(targetIdsList[j])).html();
							else	
								newFormula += $(colonIgonore(targetIdsList[j])).is("input")?$(colonIgonore(targetIdsList[j])).val():$(colonIgonore(targetIdsList[j])).html();
							break;
						}
					}
				}
				
			}
			if(hasDate)
			{
				if(dateValidation(date)) // when user date type is completed
				{
					if(typeof options.convertDateCallbackFuncInput == "function")
					{
						date = date.split(options.seperator);
						newFormula = "new Date (new Date('"+options.convertDateCallbackFuncInput(date[0],date[1],date[2])+"').setDate(new Date('"+options.convertDateCallbackFuncInput(date[0],date[1],date[2])+"').getDate()"+duration+"))"
					}
					else
					{
						newFormula = "new Date (new Date('"+date+"').setDate(new Date('"+date+"').getDate()"+duration+"))"
					}
				}
			}
		};
		var output = function(){
			if(elm.val() == undefined || elm.val() == "" || newFormula == "" || newFormula == undefined)
				return;
			var outputIdsList = options.outputIds.split(",");
			var result = convertStringToFunction(newFormula);
			if(hasDate)
			{
				if(typeof options.convertDateCallbackFuncOutput == "function")
				{
					result = options.convertDateCallbackFuncOutput(result.getFullYear(), parseInt(result.getMonth()+1), result.getDate(), options.seperator);
				}
				else
				{
					result = result.getFullYear()+"-"+parseInt(result.getMonth()+1)+"-"+result.getDate();
				}
			}
			for(var i = 0 ; i < outputIdsList.length ; i++)
			{ 
				$(colonIgonore(outputIdsList[i])).is("input")?$(colonIgonore(outputIdsList[i])).val(result):$(colonIgonore(outputIdsList[i])).html(result); 
			}
		};
		var convertStringToFunction = function (strFn){
			return new Function("return(" + strFn + ")")();
		};
		var colonIgonore = function(str){
			return str.replace(/\:/g,"\\:");
		};
		var dateValidation = function(str){
			var regEx = "[1-9]{4}[\/|-]{1}([1-9]|[1][1-2])[\/|-]{1}([0-9]|[0-1-2][0-9]|[3][0-1])$";
			var pattern = new RegExp(regEx);
			var res = pattern.exec(str);
			if(res != null)
				return true;
			else 
				return false;
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