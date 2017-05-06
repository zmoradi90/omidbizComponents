(function ($) {
    $.fn.durationPicker = function(option) {
    	this.modeEnum = {
    			both : "both",
    			date : "date",
    			time : "time"
    	}
    	var self = this;
    	var $el = $(this);

        var defaults = {
                id:'#dp',
                applayButtonCaption:'apply',
                mode:self.modeEnum.both,
                hourSummary:'h',
                hourCaption:'hour',
                minuteSummary:'m',
                minuteCaption:'minute',
                daySummary:'d',
                dayCaption:'day',
                monthSummary:'M',
                monthCaption:'month',
                yearCaption:'year',
                yearSummary:'y',
                outPutInputId:'#dpText',
                doplicateErrorMessage:"doplicate",
                inputFeildErrorClass:"input-error",
                durationInputKeyPressCallBackFunc:undefined,
                showPopupCallBackFunc:undefined
            };
            var notEmptyOption={};
            $.each(option,function(i,val){
            	if(val!=null && val!=""){
            		notEmptyOption[i]=val;
            	}
            });
	        var options = $.extend({},defaults, notEmptyOption);
	    	this.resutl=0;
	    	this.importantName = {
	    			popupPostNameId : "Popup"
	    	}
	    	this.popup = options.id.split("#").last()+this.importantName.popupPostNameId;
	    	this.timeConverter = {
                	year : 12,
                	month : 30,	    			
                	day : 24,
                	hour :60
            }
        this.init = function(){
        	var renderForm = self.renderInsidePopup();
        	if(typeof options.showPopupCallBackFunc == "function")
        	{
        		options.showPopupCallBackFunc(options.id,renderForm);
        		self.eventHandler();
        	}
        	else
        	{
        		console.error("Duration Picker: use a well formed popup for this plugin!")
        	}
        };
    	this.renderInsidePopup = function(){
    		var windowPicker = jQuery(self.renderWrapperPopup());
    		if(self.modeEnum[options.mode]!= "undefined")
    			{
	    			if(options.mode == self.modeEnum.date)
	    			{
	    				windowPicker.append(self.renderDateDuration());
	    			}
	    			else if (options.mode == self.modeEnum.time)
	    			{
	    				windowPicker.append(self.renderTimeDuration());
	    			}
	    			else 
	    			{
	    				windowPicker.append(self.renderDateDuration());
	    				windowPicker.append(self.renderTimeDuration());
	    				windowPicker.append(self.renderLegend());
	    			}
    			}
    		else
    		{
    			console.error("Duration Picker: you can use only both date or time");
    		}
    		//windowPicker.append(self.renderButtonPopup());
    		return windowPicker;
    	};
    	
 //=============================== Event Handler ===========================///
    	this.eventHandler = function(){
    		var allInputs = $("#"+self.popup).find("input[type='text']");
    		allInputs.on("keyup",function(e){
    			if(self.inputDurationNumberOnly(e),"")
    				return;
    			if(typeof self.durationInputKeyPressCallBackFunc == "function")
    				 self.durationInputKeyPressCallBackFunc(e);
    			self.bindDuration();
    		}); 
    		allInputs.on("keydown",function(e){
    			self.inputDurationNumberOnly(e,"keydown");
    		}); 
    		$(options.outPutInputId).on("keyup",function(){
    			self.retriveDuration();
    		});
    		$(options.outPutInputId).on("blur",function(){
    			self.bindDuration();
    		});
    	};
    	this.bindDuration = function(){
    		self.removeFieldError($("#"+self.popup).find("input[type='text']"));
    		var year = $("#"+self.popup).find("[type='year'] input[type='text']");
    		var month = $("#"+self.popup).find("[type='month'] input[type='text']");
    		var day = $("#"+self.popup).find("[type='day'] input[type='text']");
    		var hour = $("#"+self.popup).find("[type='hour'] input[type='text']");
    		var minute = $("#"+self.popup).find("[type='minute'] input[type='text']");
    		var result="";
			if(year.val()!="" && year.val()!=undefined)
				result=year.val()+options.yearSummary;
			if(month.val()!="" && month.val()!=undefined)
				result+=month.val()+options.monthSummary;
			if(day.val()!=""&& day.val()!=undefined)
				result+=day.val()+options.daySummary;
			if(hour.val()!="" && hour.val()!=undefined)
				result+=hour.val()+options.hourSummary;
			if(minute.val()!="" && minute.val()!=undefined)
				result+=minute.val()+options.minuteSummary;
			$(options.outPutInputId).val(result);

    	};
    	this.retriveDuration = function(){
    		self.removeFieldError($("#"+self.popup).find("input[type='text']"));
    		var year = $("#"+self.popup).find("[type='year'] input[type='text']");
    		var month = $("#"+self.popup).find("[type='month'] input[type='text']");
    		var day = $("#"+self.popup).find("[type='day'] input[type='text']");
    		var hour = $("#"+self.popup).find("[type='hour'] input[type='text']");
    		var minute = $("#"+self.popup).find("[type='minute'] input[type='text']");
    		var values = [];
    		var regex = "(([1-9]+("+options.yearSummary+"|"+options.monthSummary+"|"+options.daySummary+"|"+options.hourSummary+"|"+options.minuteSummary+"){1})){1}";
    		var str = $(options.outPutInputId).val();
    		var patt = new RegExp(regex,"g");

			values =  str.match(patt);
			
			var result = self.resutlMapCreator(values);
			if(result !=undefined)
			{
				
				if(result[options.yearSummary]!=undefined && result[options.yearSummary]!="DouplicateError")
				{
					year.val(result[options.yearSummary]);
				}
				else if(result[options.yearSummary]==undefined)
				{
					year.val("");
				}
				else if (result[options.yearSummary]=="DouplicateError")
				{
					alert(options.yearCaption+" "+options.doplicateErrorMessage);
					self.addFieldError(year);
				}
				if(result[options.monthSummary]!=undefined && result[options.monthSummary]!="DouplicateError")
				{
					month.val(result[options.monthSummary]);
				}
				else if(result[options.monthSummary]==undefined)
				{
					month.val("");
				}
				else if (result[options.monthSummary]=="DouplicateError")
				{
					alert(options.monthCaption+" "+options.doplicateErrorMessage);
					self.addFieldError(month);
				}
				if(result[options.daySummary]!=undefined && result[options.daySummary]!="DouplicateError")
				{
					day.val(result[options.daySummary]);
				}
				else if(result[options.daySummary]==undefined)
				{
					day.val("");
				}
				else if (result[options.daySummary]=="DouplicateError")
				{
					alert(options.dayCaption+" "+options.doplicateErrorMessage);
					self.addFieldError(day);
				}
				if(result[options.hourSummary]!=undefined && result[options.hourSummary]!="DouplicateError")
				{
					hour.val(result[options.hourSummary]);
				}
				else if(result[options.hourSummary]==undefined)
				{
					hour.val("");
				}
				else if (result[options.hourSummary]=="DouplicateError")
				{
					alert(options.hourCaption+" "+options.doplicateErrorMessage);
					self.addFieldError(hour);
				}
				if(result[options.minuteSummary]!=undefined && result[options.minuteSummary]!="DouplicateError")
				{
					minute.val(result[options.minuteSummary]);
				}
				else if(result[options.minuteSummary]==undefined)
				{
					minute.val("");
				}
				else if (result[options.minuteSummary]=="DouplicateError")
				{
					alert(options.minuteCaption+" "+options.doplicateErrorMessage);
					self.addFieldError(minute);
				}
			}
			else
			{
				year.val("");month.val("");day.val("");hour.val("");minute.val("");
			}
				
    	};
    	
//================================================= util function ============================================////    	
    	this.resutlMapCreator = function(strArray)
    	{
    		if(strArray==undefined)
    			return undefined;
    		var resultMap = new Object();
    		for(var i=0;i<strArray.length;i++)
    		{
    			if((new RegExp(""+options.yearSummary+"(?!(.)+)","g")).test(strArray[i]))
    			{
    				if(resultMap[options.yearSummary]==undefined)
    					resultMap[options.yearSummary] = (strArray[i].match(/[0-9]+/g));
    				else 
    					resultMap[options.yearSummary]="DouplicateError";
    			}
    			if((new RegExp(""+options.monthSummary+"(?!(.)+)","g")).test(strArray[i]))
    			{
    				if(resultMap[options.monthSummary]==undefined)
    					resultMap[options.monthSummary] = (strArray[i].match(/[0-9]+/g));
    				else 
    					resultMap[options.monthSummary]="DouplicateError";
    			}
    			if((new RegExp(""+options.daySummary+"(?!(.)+)","g")).test(strArray[i]))
    			{
    				if(resultMap[options.daySummary]==undefined)
    					resultMap[options.daySummary] = (strArray[i].match(/[0-9]+/g));
    				else 
    					resultMap[options.daySummary]="DouplicateError";
    			}
    			if((new RegExp(""+options.hourSummary+"(?!(.)+)","g")).test(strArray[i]))
    			{
    				if(resultMap[options.hourSummary]==undefined)
    					resultMap[options.hourSummary] = (strArray[i].match(/[0-9]+/g));
    				else 
    					resultMap[options.hourSummary]="DouplicateError";
    			}
    			if((new RegExp(""+options.minuteSummary+"(?!(.)+)","g")).test(strArray[i]))
    			{
    				if(resultMap[options.minuteSummary]==undefined)
    					resultMap[options.minuteSummary] = (strArray[i].match(/[0-9]+/g));
    				else 
    					resultMap[options.minuteSummary]="DouplicateError";
    			}
    		}
    		return resultMap;
    		
    	};
    	this.inputDurationNumberOnly =  function(e,mode){
    		if(mode == "keydown")
    		{
                if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
                        // Allow: Ctrl+A, Command+A
                       (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
                        // Allow: home, end, left, right, down, up
                       (e.keyCode >= 35 && e.keyCode <= 40)) {
                            // let it happen, don't do anything
                            return;
                   }
                   // Ensure that it is a number and stop the keypress
                   if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                	  e.preventDefault()
                   }
    		}
    		else 
    		{
    			// Ensure that it is a number and stop the keypress
    			if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
    				return true;
    			}
    		}
    	};
// ================================================ render function ==========================================////
    	 this.renderButtonPopup = function(){
    		return applyBtn =  "<div class='row'><div class='col s4 pull-s8 btn-small btn-blue' style='height:20px;cursor:pointer;line-height: 20px;text-align: center;'>apply</div></div>"
    	};
    	this.renderWrapperPopup = function(){
    		return wrapper = "<div id='"+self.popup+"' class='duration-picker-popup'></div>";
    	};
    	this.renderTimeDuration = function(hourCaption,minuteCapation){
    		return timeDuration="<div class='row'><div class='col s4' type='minute'><div class='label'>"+options.minuteCaption+"</div><input type='text' /></div><div class='col s4' type='hour'><div class='label'>"+options.hourCaption+"</div><input type='text' /></div></div>";
    	};
    	this.renderDateDuration = function(yearCaption,monthCaption,dayCaption){
    		return dateDuration="<div class='row'><div class='col s4' type='day'><div class='label'>"+options.dayCaption+"</div><input type='text' /></div><div class='col s4' type='month'><div class='label'>"+options.monthCaption+"</div><input type='text' /></div><div class='col s4' type='year'><div class='label'>"+options.yearCaption+"</div><input type='text' /></div></div>";
    	};
    	this.renderLegend = function(){
    		return legend="<div class='col s4' type='legend'></div>";
    	};
    	this.addFieldError = function(feild){
    		feild.addClass(options.inputFeildErrorClass);
    	};
    	this.removeFieldError = function(feild){
    		feild.removeClass(options.inputFeildErrorClass);
    	};
        this.init();
    }
}( jQuery ));
