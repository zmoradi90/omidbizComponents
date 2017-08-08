(function($) {
	$.durationPicker = function(option) {
		var modeEnum = {
			both : "both",
			date : "date",
			time : "time"
		}

		var defaults = {
			id : '#dp',
			applayButtonCaption : 'apply',
			mode : modeEnum.both,
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
			doplicateErrorMessage : 'doplicate',
			inputFeildErrorClass : 'input-error',
			durationInputKeyPressCallBackFunc : undefined,
			showPopupCallBackFunc : undefined
		};
		var notEmptyOption = {};
		$.each(option, function(i, val) {
			if (val != null && val != "") {
				notEmptyOption[i] = val;
			}
		});
		var options = $.extend({}, defaults, notEmptyOption);
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
				console
						.error("Duration Picker: use a well formed popup for this plugin!")
			}
		};
		var renderInsidePopup = function() {
			var windowPicker = jQuery(renderWrapperPopup());
			if (modeEnum[options.mode] != "undefined") {
				if (options.mode == modeEnum.date) {
					windowPicker.append(renderDateDuration());
				} else if (options.mode == modeEnum.time) {
					windowPicker.append(renderTimeDuration());
				} else {
					windowPicker.append(renderDateDuration());
					windowPicker.append(renderTimeDuration());
					windowPicker.append(renderLegend());
				}
			} else {
				console
						.error("Duration Picker: you can use only both date or time");
			}
			// windowPicker.append(self.renderButtonPopup());
			return windowPicker;
		};

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
			var regex = "((" + options.negativeSummary + "?[0-9]+("
					+ options.yearSummary + "|" + options.monthSummary + "|"
					+ options.daySummary + "|" + options.hourSummary + "|"
					+ options.minuteSummary + "){1})){1}";
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
								+ options.doplicateErrorMessage);
					}
				}

				if (result[options.yearSummary] != undefined
						&& result[options.yearSummary] != "DouplicateError") {
					year.val(result[options.yearSummary]);
				} else if (result[options.yearSummary] == undefined) {
					year.val("");
				} else if (result[options.yearSummary] == "DouplicateError") {
					alert(options.yearCaption + " "
							+ options.doplicateErrorMessage);
					addFieldError(year);
				}
				if (result[options.monthSummary] != undefined
						&& result[options.monthSummary] != "DouplicateError") {
					month.val(result[options.monthSummary]);
				} else if (result[options.monthSummary] == undefined) {
					month.val("");
				} else if (result[options.monthSummary] == "DouplicateError") {
					alert(options.monthCaption + " "
							+ options.doplicateErrorMessage);
					addFieldError(month);
				}
				if (result[options.daySummary] != undefined
						&& result[options.daySummary] != "DouplicateError") {
					day.val(result[options.daySummary]);
				} else if (result[options.daySummary] == undefined) {
					day.val("");
				} else if (result[options.daySummary] == "DouplicateError") {
					alert(options.dayCaption + " "
							+ options.doplicateErrorMessage);
					addFieldError(day);
				}
				if (result[options.hourSummary] != undefined
						&& result[options.hourSummary] != "DouplicateError") {
					hour.val(result[options.hourSummary]);
				} else if (result[options.hourSummary] == undefined) {
					hour.val("");
				} else if (result[options.hourSummary] == "DouplicateError") {
					alert(options.hourCaption + " "
							+ options.doplicateErrorMessage);
					addFieldError(hour);
				}
				if (result[options.minuteSummary] != undefined
						&& result[options.minuteSummary] != "DouplicateError") {
					minute.val(result[options.minuteSummary]);
				} else if (result[options.minuteSummary] == undefined) {
					minute.val("");
				} else if (result[options.minuteSummary] == "DouplicateError") {
					alert(options.minuteCaption + " "
							+ options.doplicateErrorMessage);
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
				return undefined;
			var resultMap = new Object();
			for (var i = 0; i < strArray.length; i++) {
				if ((new RegExp("^" + options.negativeSummary))
						.test(strArray[i])) {
					if (resultMap[options.negativeSummary] == undefined)
						resultMap[options.negativeSummary] = options.negativeSummary;
					else
						resultMap[options.negativeSummary] = "DouplicateError";
				}
				if ((new RegExp("" + options.yearSummary + "(?!(.)+)", "g"))
						.test(strArray[i])) {
					if (resultMap[options.yearSummary] == undefined)
						resultMap[options.yearSummary] = (strArray[i]
								.match(/[0-9]+/g));
					else
						resultMap[options.yearSummary] = "DouplicateError";
				}
				if ((new RegExp("" + options.monthSummary + "(?!(.)+)", "g"))
						.test(strArray[i])) {
					if (resultMap[options.monthSummary] == undefined)
						resultMap[options.monthSummary] = (strArray[i]
								.match(/[0-9]+/g));
					else
						resultMap[options.monthSummary] = "DouplicateError";
				}
				if ((new RegExp("" + options.daySummary + "(?!(.)+)", "g"))
						.test(strArray[i])) {
					if (resultMap[options.daySummary] == undefined)
						resultMap[options.daySummary] = (strArray[i]
								.match(/[0-9]+/g));
					else
						resultMap[options.daySummary] = "DouplicateError";
				}
				if ((new RegExp("" + options.hourSummary + "(?!(.)+)", "g"))
						.test(strArray[i])) {
					if (resultMap[options.hourSummary] == undefined)
						resultMap[options.hourSummary] = (strArray[i]
								.match(/[0-9]+/g));
					else
						resultMap[options.hourSummary] = "DouplicateError";
				}
				if ((new RegExp("" + options.minuteSummary + "(?!(.)+)", "g"))
						.test(strArray[i])) {
					if (resultMap[options.minuteSummary] == undefined)
						resultMap[options.minuteSummary] = (strArray[i]
								.match(/[0-9]+/g));
					else
						resultMap[options.minuteSummary] = "DouplicateError";
				}
			}
			return resultMap;

		};
		var inputDurationNumberOnly = function(e, mode) {
			if (mode == "keydown") {
				if ($.inArray(e.keyCode, [ 46, 8, 9, 27, 13, 110, 190 ]) !== -1
						||
						// Allow: Ctrl+A, Command+A
						(e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true))
						||
						// Allow: home, end, left, right, down, up
						(e.keyCode >= 35 && e.keyCode <= 40)) {
					// let it happen, don't do anything
					return;
				}
				// Ensure that it is a number and stop the keypress
				if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57))
						&& (e.keyCode < 96 || e.keyCode > 105)) {
					e.preventDefault()
				}
			} else {
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
					+ "' class='duration-picker-popup'></div>";
		};
		var renderTimeDuration = function(hourCaption, minuteCapation) {
			return timeDuration = "<div class='row'><div class='col s4' type='minute'><div class='label'>"
					+ options.minuteCaption
					+ "</div><input type='text' /></div><div class='col s4' type='hour'><div class='label'>"
					+ options.hourCaption
					+ "</div><input type='text' /></div><div class='col s4'>"
					+ renderNegativeButton() + "</div></div>";
		};
		var renderDateDuration = function(yearCaption, monthCaption, dayCaption) {
			return dateDuration = "<div class='row'><div class='col s4' type='day'><div class='label'>"
					+ options.dayCaption
					+ "</div><input type='text' /></div><div class='col s4' type='month'><div class='label'>"
					+ options.monthCaption
					+ "</div><input type='text' /></div><div class='col s4' type='year'><div class='label'>"
					+ options.yearCaption
					+ "</div><input type='text' /></div></div>";
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
