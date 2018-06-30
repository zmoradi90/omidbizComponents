(function($) {
	$.durationPicker = function(option) {
		var defaults = {
			id : '#dp',
			applayButtonCaption : 'apply',
			negativeToggleButtonId : '',
			negativeSummary : 'n',
			negativeToggleButtonCaption:'-',
			hourSummary : 'h',
			hourCaption : 'hour',
			minuteSummary : 'm',
			minuteCaption : 'minute',
			daySummary : 'd',
			dayCaption : 'day',
			monthSummary : 'M',
			monthCaption : 'month',
			yearCaption : 'year',
			yearSummary : 'y',
			outPutInputId : '#dpText',
			closeMessage : 'close',
			duplicateErrorMessage : 'doplicate',
			inputFeildErrorClass : 'input-error',
			durationInputKeyPressCallBackFunc : undefined,
			showPopupCallBackFunc : undefined,
			dateInputFormPattern :undefined
		};
		var notEmptyOption = {};
		$.each(option, function(i, val) {
			if (val != null && val != "") {
				notEmptyOption[i] = val;
			}
		});
		var options = $.extend({}, defaults, notEmptyOption);
		if(options.dateInputFormPattern == undefined)
			options.dateInputFormPattern = options.yearSummary+","+options.monthSummary+","+options.daySummary+","+options.hourSummary+","+options.minuteSummary;
		var resutl = 0;
		var importantName = {
			popupPostNameId : "Popup"
		}
		var popup = options.id.split("#").last()
				+ importantName.popupPostNameId;
		var init = function() {
			var renderForm = renderInsidePopup();
			if (typeof options.showPopupCallBackFunc == "function") {
				options.showPopupCallBackFunc(options.id, renderForm);
				setInitalValue();
				eventHandler();
				$("#" + popup).find("[type='day'] input[type='text']").focus();
			} else {
				console.error("Duration Picker: use a well formed popup for this plugin!")
			}
		};
		var renderInsidePopup = function() {
			var windowPicker = renderWrapperPopup();
			if(options.dateInputFormPattern == undefined)
			{
				console.error("Duration Picker: you can use only both date or time");
				return;
			}
			return jQuery(formDesinger(windowPicker));
		};
		
		var formDesinger = function(windowPicker)
		{
			var resultForm = "";
			var dateInputFormArray = options.dateInputFormPattern.split(",");
			if(dateInputFormArray.length < 0)
			{
				console.error("durationPicker: invalid pattern form!");
				return;
			}
			for(var i= 0 ; i < dateInputFormArray.length ; i++)
			{
				switch(dateInputFormArray[i])
				{
					case options.yearSummary:
						resultForm += renderYear();
					break;
					case options.monthSummary:
						resultForm += renderMonth();
						break;
					case options.daySummary:
						resultForm += renderDay();
						break;
					case options.hourSummary:
						resultForm += renderHour();
						break;
					case options.minuteSummary:
						resultForm += renderMinute();
						break;
				}
			}
			windowPicker = windowPicker.replace(":durationFormPlace",resultForm);
			return windowPicker;
		}
		
		// =============================== Event Handler
		// ===========================///
		var eventHandler = function() {
			var allInputs = $("#" + popup).find("input[type='text']");
			allInputs.on("keyup", function(e) {
				if (inputDurationNumberOnly(e), "")
					return;
				if (typeof durationInputKeyPressCallBackFunc == "function")
					durationInputKeyPressCallBackFunc(e);
				bindDuration();
			});
			allInputs.on("keydown", function(e) {
				inputDurationNumberOnly(e, "keydown");
			});
			$(options.outPutInputId).on("keyup", function() {
				retriveDuration();
			});
			$(options.outPutInputId).on("blur", function() {
				bindDuration();
			});
			if(options.negativeToggleButtonId != '')
			{
				$("#"+options.negativeToggleButtonId).on("click",function(){
					var result = $(options.outPutInputId).val();
					if($(this).attr("active")=="true")
					{
						$(this).removeAttr("active");
						$(options.outPutInputId).val($(options.outPutInputId).val().split(options.negativeSummary)[1]);
					}
					else
					{
						$(options.outPutInputId).val(options.negativeSummary+result);
						$(this).attr("active","true");
					}
					
				});
				
			}
		};
		var setInitalValue = function() {
			if ($(options.outPutInputId).val() != "")
				retriveDuration();
		};
		var bindDuration = function() { // set value dialog textboxes to form
										// textbox
			removeFieldError($("#" + popup).find("input[type='text']"));
			var year = $("#" + popup).find("[type='year'] input[type='text']");
			var month = $("#" + popup)
					.find("[type='month'] input[type='text']");
			var day = $("#" + popup).find("[type='day'] input[type='text']");
			var hour = $("#" + popup).find("[type='hour'] input[type='text']");
			var minute = $("#" + popup).find(
					"[type='minute'] input[type='text']");
			var result = "";
			if(options.negativeToggleButtonId != '')
			{
				var negativeToggleButton = $("#" + options.negativeToggleButtonId)
				if(negativeToggleButton.attr("active")=="true")
					result = "n";
			}
			if (year.val() != "" && year.val() != undefined)
				result += year.val() + options.yearSummary;
			if (month.val() != "" && month.val() != undefined)
				result += month.val() + options.monthSummary;
			if (day.val() != "" && day.val() != undefined)
				result += day.val() + options.daySummary;
			if (hour.val() != "" && hour.val() != undefined)
				result += hour.val() + options.hourSummary;
			if (minute.val() != "" && minute.val() != undefined)
				result += minute.val() + options.minuteSummary;
			$(options.outPutInputId).val(result);

		};
		var retriveDuration = function() {// set value from form textbox to
											// dialog textboxes
			removeFieldError($("#" + popup).find("input[type='text']"));
			var year = $("#" + popup).find("[type='year'] input[type='text']");
			var month = $("#" + popup)
					.find("[type='month'] input[type='text']");
			var day = $("#" + popup).find("[type='day'] input[type='text']");
			var hour = $("#" + popup).find("[type='hour'] input[type='text']");
			var minute = $("#" + popup).find(
					"[type='minute'] input[type='text']");
			var negativeBtn = options.negativeToggleButtonId!=''? $("#" + popup).find(
					"#" + options.negativeToggleButtonId):'';
			var values = [];
			var regex = "(((" + options.negativeSummary + "?([0-9|.|0-9]+)("
					+ options.yearSummary + "|" + options.monthSummary + "|"
					+ options.daySummary + "|" + options.hourSummary + "|"
					+ options.minuteSummary + "){1})))";
			var str = $(options.outPutInputId).val();
			var patt = new RegExp(regex, "g");

			values = str.match(patt);

			var result = resutlMapCreator(values);
			if (result != undefined) {
				if(negativeBtn!='')
				{
					if (result[options.negativeSummary] != undefined
							&& result[options.negativeSummary] != "DouplicateError") {
						negativeBtn.attr("active", "true");
					} else if (result[options.yearSummary] == undefined) {
						negativeBtn.removeAttr("active", "true");
					} else if (result[options.yearSummary] == "DouplicateError") {
						alert(options.yearCaption + " "
								+ options.duplicateErrorMessage);
					}
				}

				if (result[options.yearSummary] != undefined
						&& result[options.yearSummary] != "DouplicateError") {
					year.val(result[options.yearSummary]);
				} else if (result[options.yearSummary] == undefined) {
					year.val("");
				} else if (result[options.yearSummary] == "DouplicateError") {
					alert(options.yearCaption + " "
							+ options.duplicateErrorMessage);
					addFieldError(year);
				}
				if (result[options.monthSummary] != undefined
						&& result[options.monthSummary] != "DouplicateError") {
					month.val(result[options.monthSummary]);
				} else if (result[options.monthSummary] == undefined) {
					month.val("");
				} else if (result[options.monthSummary] == "DouplicateError") {
					alert(options.monthCaption + " "
							+ options.duplicateErrorMessage);
					addFieldError(month);
				}
				if (result[options.daySummary] != undefined
						&& result[options.daySummary] != "DouplicateError") {
					day.val(result[options.daySummary]);
				} else if (result[options.daySummary] == undefined) {
					day.val("");
				} else if (result[options.daySummary] == "DouplicateError") {
					alert(options.dayCaption + " "
							+ options.duplicateErrorMessage);
					addFieldError(day);
				}
				if (result[options.hourSummary] != undefined
						&& result[options.hourSummary] != "DouplicateError") {
					hour.val(result[options.hourSummary]);
				} else if (result[options.hourSummary] == undefined) {
					hour.val("");
				} else if (result[options.hourSummary] == "DouplicateError") {
					alert(options.hourCaption + " "
							+ options.duplicateErrorMessage);
					addFieldError(hour);
				}
				if (result[options.minuteSummary] != undefined
						&& result[options.minuteSummary] != "DouplicateError") {
					minute.val(result[options.minuteSummary]);
				} else if (result[options.minuteSummary] == undefined) {
					minute.val("");
				} else if (result[options.minuteSummary] == "DouplicateError") {
					alert(options.minuteCaption + " "
							+ options.duplicateErrorMessage);
					addFieldError(minute);
				}
			} else {
				year.val("");
				month.val("");
				day.val("");
				hour.val("");
				minute.val("");
			}

		};

		// ================================================= util function
		// ============================================////
		var resutlMapCreator = function(strArray) {
			if (strArray == undefined)
			{
				console.error("durationPicker->mapCreator: strArray is undefined ");
				return;
			}
			var resultMap = new Object();
			for(var i=0 ; i<strArray.length; i++)
			{
					if (strArray[i].search(options.negativeSummary) != -1)
					{
						resultMap[options.negativeSummary] = options.negativeSummary;
					}
					else if(strArray[i].search(options.negativeSummary) >= 2)
						resultMap[options.negativeSummary] = "DouplicateError";
					if(strArray[i].search(options.yearSummary) != -1)
					{
						resultMap[options.yearSummary] = (strArray[i].match(/[0-9]*(\.)*[0-9]/g));
					}
					else if(strArray[i].search(options.yearSummary) >= 2)
						resultMap[options.yearSummary] = "DouplicateError";
					if (strArray[i].search(options.monthSummary) != -1)
					{
						resultMap[options.monthSummary] = (strArray[i].match(/[0-9]*(\.)*[0-9]/g));
					}
					else if(strArray[i].search(options.monthSummary) >= 2)
						resultMap[options.monthSummary] = "DouplicateError";
					if (strArray[i].search(options.daySummary) != -1)
					{
						resultMap[options.daySummary] = (strArray[i].match(/[0-9]*(\.)*[0-9]/g));
					}
					else if(strArray[i].search(options.daySummary) >= 2)
						resultMap[options.daySummary] = "DouplicateError";
					if (strArray[i].search(options.hourSummary) != -1)
					{
						resultMap[options.hourSummary] = (strArray[i].match(/[0-9]*(\.)*[0-9]/g));
					}
					else if(strArray[i].search(options.hourSummary) >= 2)
						resultMap[options.hourSummary] = "DouplicateError";
					if (strArray[i].search(options.minuteSummary) != -1)
					{
						resultMap[options.minuteSummary] = (strArray[i].match(/[0-9]*(\.)*[0-9]/g));
					}
					else if(strArray[i].search(options.minuteSummary) >= 2)
						resultMap[options.minuteSummary] = "DouplicateError";
			}
			return resultMap;

		};
		var inputDurationNumberOnly = function(e, mode) {
			if (mode == "keydown") {
				if ($.inArray(e.keyCode, [ 46, 8, 9, 27, 13 ]) !== -1
						||
						// Allow: Ctrl+A, Command+A
						(e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true))
						||
						// Allow: home, end, left, right, down, up
						(e.keyCode >= 35 && e.keyCode <= 40 || e.keyCode == 110 || e.keyCode == 190 )) {
					// let it happen, don't do anything
					return;
				}
				// Ensure that it is a number and stop the keypress
				if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57))
						&& (e.keyCode < 96 || e.keyCode > 105)) {
					e.preventDefault()
				}
			} 
			else 
			{
				// Ensure that it is a number and stop the keypress
				if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57))
						&& (e.keyCode < 96 || e.keyCode > 105)) {
					return true;
				}
			}
		};
		// ================================================ render function
		// ==========================================////
		var renderButtonPopup = function() {
			return applyBtn = "<div class='row'><div class='col s4 pull-s8 btn-small btn-blue' style='height:20px;cursor:pointer;line-height: 20px;text-align: center;'>apply</div></div>"
		};
		var renderWrapperPopup = function() {
			return wrapper = "<div id='" + popup
					+ "' class='duration-picker-popup'><div class='row'>:durationFormPlace"+renderNegativeButton()+"</div></div>";
		};
		var renderMinute = function() {
			return timeDuration = "<div class='col s4' type='minute'><div class='label'>"
					+ options.minuteCaption
					+ "</div>"
					+ "<input type='text' /></div>";
		};
		var renderHour = function() {
			return timeDuration = "<div class='col s4' type='hour'><div class='label'>"
				+ options.hourCaption
				+ "</div><input type='text' /></div>";
		};
		var renderDay = function() {
			return dateDuration = "<div class='col s4' type='day'><div class='label'>"
				+ options.dayCaption
				+ "</div><input type='text' /></div>";
		};
		var renderMonth = function() {
			return dateDuration = "<div class='col s4' type='month'><div class='label'>"
				+ options.monthCaption
				+ "</div><input type='text' /></div>";
		};
		var renderYear = function() {
			return dateDuration = "<div class='col s4' type='year'><div class='label'>"
					+ options.yearCaption
					+ "</div><input type='text' /></div>";
		};
		var renderLegend = function() {
			return legend = "<div class='col s4' type='legend'></div>";
		};
		var renderNegativeButton = function() {
			return options.negativeToggleButtonId != '' ? "<div id="
					+ options.negativeToggleButtonId
					+ " class='negative-toggle-button'>"+options.negativeToggleButtonCaption+"</div>" : '';
		}
		var addFieldError = function(feild) {
			feild.addClass(options.inputFeildErrorClass);
		};
		var removeFieldError = function(feild) {
			feild.removeClass(options.inputFeildErrorClass);
		};
		init();
	}
}(jQuery))
