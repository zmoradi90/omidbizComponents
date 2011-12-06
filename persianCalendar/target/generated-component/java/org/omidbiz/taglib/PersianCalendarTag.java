/**
 * GENERATED FILE - DO NOT EDIT
 *
 */
package org.omidbiz.taglib;

import java.util.TimeZone ;
import javax.faces.component.UIComponent ;
import org.omidbiz.model.CalendarDataModel ;
import javax.faces.convert.Converter ;
import java.lang.Object ;
import java.lang.String ;
import javax.el.MethodExpression ;
import org.ajax4jsf.webapp.taglib.HtmlComponentTagBase ;
import javax.faces.el.MethodBinding ;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.el.MethodExpression;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.el.ValueExpression;
import org.richfaces.webapp.taglib.MethodBindingMethodExpressionAdaptor;
import org.richfaces.webapp.taglib.ValueBindingValueExpressionAdaptor;
import org.omidbiz.component.html.HtmlPersianCalendar;

public class PersianCalendarTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 	  			  		  	  
		/*
		 * ajaxSingle
		 * boolean attribute which provides possibility to limit JSF tree processing(decoding, conversion/validation, value applying) to the component which send the request only.
				Default value is "true"
		 */
		private ValueExpression _ajaxSingle;
		/**
		 * boolean attribute which provides possibility to limit JSF tree processing(decoding, conversion/validation, value applying) to the component which send the request only.
				Default value is "true"
		 * Setter for ajaxSingle
		 * @param ajaxSingle - new value
		 */
		 public void setAjaxSingle( ValueExpression  __ajaxSingle ){
			this._ajaxSingle = __ajaxSingle;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * boundaryDatesMode
		 * This attribute is responsible for behaviour of dates 
				from the previous and next months which are displayed in the current month. Valid values
				are "inactive" (Default) dates inactive and
				gray colored, "scroll" boundaries work as
				month scrolling controls, and "select"
				boundaries work in the same way as "scroll"
				but with the date clicked selection. Default value is "inactive".
		 */
		private ValueExpression _boundaryDatesMode;
		/**
		 * This attribute is responsible for behaviour of dates 
				from the previous and next months which are displayed in the current month. Valid values
				are "inactive" (Default) dates inactive and
				gray colored, "scroll" boundaries work as
				month scrolling controls, and "select"
				boundaries work in the same way as "scroll"
				but with the date clicked selection. Default value is "inactive".
		 * Setter for boundaryDatesMode
		 * @param boundaryDatesMode - new value
		 */
		 public void setBoundaryDatesMode( ValueExpression  __boundaryDatesMode ){
			this._boundaryDatesMode = __boundaryDatesMode;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * buttonClass
		 * Style Class attribute for the popup button
		 */
		private ValueExpression _buttonClass;
		/**
		 * Style Class attribute for the popup button
		 * Setter for buttonClass
		 * @param buttonClass - new value
		 */
		 public void setButtonClass( ValueExpression  __buttonClass ){
			this._buttonClass = __buttonClass;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * buttonIcon
		 * Defines icon for the popup button element. The attribute
				is ignored if the "buttonLabel" is set
		 */
		private ValueExpression _buttonIcon;
		/**
		 * Defines icon for the popup button element. The attribute
				is ignored if the "buttonLabel" is set
		 * Setter for buttonIcon
		 * @param buttonIcon - new value
		 */
		 public void setButtonIcon( ValueExpression  __buttonIcon ){
			this._buttonIcon = __buttonIcon;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * buttonIconDisabled
		 * Defines disabled icon for the popup button element. The
				attribute is ignored if the "buttonLabel" is set
		 */
		private ValueExpression _buttonIconDisabled;
		/**
		 * Defines disabled icon for the popup button element. The
				attribute is ignored if the "buttonLabel" is set
		 * Setter for buttonIconDisabled
		 * @param buttonIconDisabled - new value
		 */
		 public void setButtonIconDisabled( ValueExpression  __buttonIconDisabled ){
			this._buttonIconDisabled = __buttonIconDisabled;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * buttonLabel
		 * Defines label for the popup button element. If the
				attribute is set "buttonIcon" and "buttonIconDisabled"
				are ignored
		 */
		private ValueExpression _buttonLabel;
		/**
		 * Defines label for the popup button element. If the
				attribute is set "buttonIcon" and "buttonIconDisabled"
				are ignored
		 * Setter for buttonLabel
		 * @param buttonLabel - new value
		 */
		 public void setButtonLabel( ValueExpression  __buttonLabel ){
			this._buttonLabel = __buttonLabel;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * bypassUpdates
		 * If "true", after process validations phase it skips updates of model beans on a force render response. It can be used for validating components input
		 */
		private ValueExpression _bypassUpdates;
		/**
		 * If "true", after process validations phase it skips updates of model beans on a force render response. It can be used for validating components input
		 * Setter for bypassUpdates
		 * @param bypassUpdates - new value
		 */
		 public void setBypassUpdates( ValueExpression  __bypassUpdates ){
			this._bypassUpdates = __bypassUpdates;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * cellHeight
		 * attribute to set fixed cells height
		 */
		private ValueExpression _cellHeight;
		/**
		 * attribute to set fixed cells height
		 * Setter for cellHeight
		 * @param cellHeight - new value
		 */
		 public void setCellHeight( ValueExpression  __cellHeight ){
			this._cellHeight = __cellHeight;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * cellWidth
		 * attribute to set fixed cells width
		 */
		private ValueExpression _cellWidth;
		/**
		 * attribute to set fixed cells width
		 * Setter for cellWidth
		 * @param cellWidth - new value
		 */
		 public void setCellWidth( ValueExpression  __cellWidth ){
			this._cellWidth = __cellWidth;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * converter
		 * Id of Converter to be used or reference to a Converter
		 */
		private ValueExpression _converter;
		/**
		 * Id of Converter to be used or reference to a Converter
		 * Setter for converter
		 * @param converter - new value
		 */
		 public void setConverter( ValueExpression  __converter ){
			this._converter = __converter;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * converterMessage
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the converter message,
			replacing any message that comes from the converter
		 */
		private ValueExpression _converterMessage;
		/**
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the converter message,
			replacing any message that comes from the converter
		 * Setter for converterMessage
		 * @param converterMessage - new value
		 */
		 public void setConverterMessage( ValueExpression  __converterMessage ){
			this._converterMessage = __converterMessage;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * currentDate
		 * Defines current date
		 */
		private ValueExpression _currentDate;
		/**
		 * Defines current date
		 * Setter for currentDate
		 * @param currentDate - new value
		 */
		 public void setCurrentDate( ValueExpression  __currentDate ){
			this._currentDate = __currentDate;
	     }
	  
	 	 		 	  	  	  
		/*
		 * currentDateChangeListener
		 * MethodExpression representing an action listener method
				that will be notified after date selection
		 */
		private MethodExpression _currentDateChangeListener;
		/**
		 * MethodExpression representing an action listener method
				that will be notified after date selection
		 * Setter for currentDateChangeListener
		 * @param currentDateChangeListener - new value
		 */
		 public void setCurrentDateChangeListener( MethodExpression  __currentDateChangeListener ){
			this._currentDateChangeListener = __currentDateChangeListener;
	     }
	  
	 	 		 		 		 		 	  			  		  	  
		/*
		 * dataModel
		 * Used to provide data for calendar elements. If data is
				not provided, all Data Model related functions are
				disabled
		 */
		private ValueExpression _dataModel;
		/**
		 * Used to provide data for calendar elements. If data is
				not provided, all Data Model related functions are
				disabled
		 * Setter for dataModel
		 * @param dataModel - new value
		 */
		 public void setDataModel( ValueExpression  __dataModel ){
			this._dataModel = __dataModel;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * datePattern
		 * Defines date pattern. Default value is "MMM d, yyyy".
		 */
		private ValueExpression _datePattern;
		/**
		 * Defines date pattern. Default value is "MMM d, yyyy".
		 * Setter for datePattern
		 * @param datePattern - new value
		 */
		 public void setDatePattern( ValueExpression  __datePattern ){
			this._datePattern = __datePattern;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * dayStyleClass
		 * Should be binded to some JS function that will provide style classes
				for special sets of days highlighting.
		 */
		private ValueExpression _dayStyleClass;
		/**
		 * Should be binded to some JS function that will provide style classes
				for special sets of days highlighting.
		 * Setter for dayStyleClass
		 * @param dayStyleClass - new value
		 */
		 public void setDayStyleClass( ValueExpression  __dayStyleClass ){
			this._dayStyleClass = __dayStyleClass;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * defaultTime
		 * Defines time that will be used:
			1) to set time when the value is empty
			2) to set time when date changes and flag "resetTimeOnDateSelect" is true. Default value is "getDefaultValueOfDefaultTime()"
		 */
		private ValueExpression _defaultTime;
		/**
		 * Defines time that will be used:
			1) to set time when the value is empty
			2) to set time when date changes and flag "resetTimeOnDateSelect" is true. Default value is "getDefaultValueOfDefaultTime()"
		 * Setter for defaultTime
		 * @param defaultTime - new value
		 */
		 public void setDefaultTime( ValueExpression  __defaultTime ){
			this._defaultTime = __defaultTime;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * direction
		 * Defines direction of the calendar popup ("top-left",
				"top-right", "bottom-left", "bottom-right" (Default), "auto"). Default value is "bottom-right".
		 */
		private ValueExpression _direction;
		/**
		 * Defines direction of the calendar popup ("top-left",
				"top-right", "bottom-left", "bottom-right" (Default), "auto"). Default value is "bottom-right".
		 * Setter for direction
		 * @param direction - new value
		 */
		 public void setDirection( ValueExpression  __direction ){
			this._direction = __direction;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * disabled
		 * If "true", rendered is disabled. In
				"popup" mode both controls are disabled. Default value is "false".
		 */
		private ValueExpression _disabled;
		/**
		 * If "true", rendered is disabled. In
				"popup" mode both controls are disabled. Default value is "false".
		 * Setter for disabled
		 * @param disabled - new value
		 */
		 public void setDisabled( ValueExpression  __disabled ){
			this._disabled = __disabled;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * enableManualInput
		 * If "true" calendar input will be editable and
				it will be possible to change the date manualy. If
				"false" value for this attribute makes a text
				field "read-only", so the value can be changed
				only from a handle. Default value is "false".
		 */
		private ValueExpression _enableManualInput;
		/**
		 * If "true" calendar input will be editable and
				it will be possible to change the date manualy. If
				"false" value for this attribute makes a text
				field "read-only", so the value can be changed
				only from a handle. Default value is "false".
		 * Setter for enableManualInput
		 * @param enableManualInput - new value
		 */
		 public void setEnableManualInput( ValueExpression  __enableManualInput ){
			this._enableManualInput = __enableManualInput;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * eventsQueue
		 * Name of requests queue to avoid send next request before complete other from same event. Can be used to reduce number of requests of frequently events (key press, mouse move etc.)
		 */
		private ValueExpression _eventsQueue;
		/**
		 * Name of requests queue to avoid send next request before complete other from same event. Can be used to reduce number of requests of frequently events (key press, mouse move etc.)
		 * Setter for eventsQueue
		 * @param eventsQueue - new value
		 */
		 public void setEventsQueue( ValueExpression  __eventsQueue ){
			this._eventsQueue = __eventsQueue;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * firstWeekDay
		 * Gets what the first day of the week is; e.g., SUNDAY in the U.S., MONDAY in France. Default value is "getDefaultFirstWeekDay()". Possible values should be integers from 0 to 6, 0 corresponds to Sunday
		 */
		private ValueExpression _firstWeekDay;
		/**
		 * Gets what the first day of the week is; e.g., SUNDAY in the U.S., MONDAY in France. Default value is "getDefaultFirstWeekDay()". Possible values should be integers from 0 to 6, 0 corresponds to Sunday
		 * Setter for firstWeekDay
		 * @param firstWeekDay - new value
		 */
		 public void setFirstWeekDay( ValueExpression  __firstWeekDay ){
			this._firstWeekDay = __firstWeekDay;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * focus
		 * id of element to set focus after request completed on client side
		 */
		private ValueExpression _focus;
		/**
		 * id of element to set focus after request completed on client side
		 * Setter for focus
		 * @param focus - new value
		 */
		 public void setFocus( ValueExpression  __focus ){
			this._focus = __focus;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * horizontalOffset
		 * Sets the horizontal offset between button and calendar
				element conjunction point. Default value is "0".
		 */
		private ValueExpression _horizontalOffset;
		/**
		 * Sets the horizontal offset between button and calendar
				element conjunction point. Default value is "0".
		 * Setter for horizontalOffset
		 * @param horizontalOffset - new value
		 */
		 public void setHorizontalOffset( ValueExpression  __horizontalOffset ){
			this._horizontalOffset = __horizontalOffset;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * ignoreDupResponses
		 * Attribute allows to ignore an Ajax Response produced by a request if the newest 'similar' request is
in a queue already. ignoreDupResponses="true" does not cancel the request while it is processed on the server,
but just allows to avoid unnecessary updates on the client side if the response isn't actual now
		 */
		private ValueExpression _ignoreDupResponses;
		/**
		 * Attribute allows to ignore an Ajax Response produced by a request if the newest 'similar' request is
in a queue already. ignoreDupResponses="true" does not cancel the request while it is processed on the server,
but just allows to avoid unnecessary updates on the client side if the response isn't actual now
		 * Setter for ignoreDupResponses
		 * @param ignoreDupResponses - new value
		 */
		 public void setIgnoreDupResponses( ValueExpression  __ignoreDupResponses ){
			this._ignoreDupResponses = __ignoreDupResponses;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * immediate
		 * A flag indicating that this component value must be converted
            and validated immediately (that is, during Apply Request Values
            phase), rather than waiting until a Process Validations phase
		 */
		private ValueExpression _immediate;
		/**
		 * A flag indicating that this component value must be converted
            and validated immediately (that is, during Apply Request Values
            phase), rather than waiting until a Process Validations phase
		 * Setter for immediate
		 * @param immediate - new value
		 */
		 public void setImmediate( ValueExpression  __immediate ){
			this._immediate = __immediate;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * inputClass
		 * Style Class attribute for the text field
		 */
		private ValueExpression _inputClass;
		/**
		 * Style Class attribute for the text field
		 * Setter for inputClass
		 * @param inputClass - new value
		 */
		 public void setInputClass( ValueExpression  __inputClass ){
			this._inputClass = __inputClass;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * inputSize
		 * Defines the size of an input field. Similar to the "size" attribute of &amp;lt;h:inputText/&amp;gt;
		 */
		private ValueExpression _inputSize;
		/**
		 * Defines the size of an input field. Similar to the "size" attribute of &amp;lt;h:inputText/&amp;gt;
		 * Setter for inputSize
		 * @param inputSize - new value
		 */
		 public void setInputSize( ValueExpression  __inputSize ){
			this._inputSize = __inputSize;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * inputStyle
		 * Style attribute for text field
		 */
		private ValueExpression _inputStyle;
		/**
		 * Style attribute for text field
		 * Setter for inputStyle
		 * @param inputStyle - new value
		 */
		 public void setInputStyle( ValueExpression  __inputStyle ){
			this._inputStyle = __inputStyle;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * isDayEnabled
		 * Should be binded to some JS function that returns day state.
		 */
		private ValueExpression _isDayEnabled;
		/**
		 * Should be binded to some JS function that returns day state.
		 * Setter for isDayEnabled
		 * @param isDayEnabled - new value
		 */
		 public void setIsDayEnabled( ValueExpression  __isDayEnabled ){
			this._isDayEnabled = __isDayEnabled;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * jointPoint
		 * Set the corner of the button for the popup to be
				connected with (top-left, top-right, bottom-left
				(Default), bottom-right, auto). Default value is "bottom-left".
		 */
		private ValueExpression _jointPoint;
		/**
		 * Set the corner of the button for the popup to be
				connected with (top-left, top-right, bottom-left
				(Default), bottom-right, auto). Default value is "bottom-left".
		 * Setter for jointPoint
		 * @param jointPoint - new value
		 */
		 public void setJointPoint( ValueExpression  __jointPoint ){
			this._jointPoint = __jointPoint;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * label
		 * A localized user presentable name for this component.
		 */
		private ValueExpression _label;
		/**
		 * A localized user presentable name for this component.
		 * Setter for label
		 * @param label - new value
		 */
		 public void setLabel( ValueExpression  __label ){
			this._label = __label;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * limitToList
		 * If "true", then of all AJAX-rendered on the page components only those will be updated, 
		which ID's are passed to the "reRender" attribute of the describable component. 
		"false"-the default value-means that all components with ajaxRendered="true" will be updated.
		 */
		private ValueExpression _limitToList;
		/**
		 * If "true", then of all AJAX-rendered on the page components only those will be updated, 
		which ID's are passed to the "reRender" attribute of the describable component. 
		"false"-the default value-means that all components with ajaxRendered="true" will be updated.
		 * Setter for limitToList
		 * @param limitToList - new value
		 */
		 public void setLimitToList( ValueExpression  __limitToList ){
			this._limitToList = __limitToList;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * locale
		 * Used for locale definition.   Default value is "getDefaultLocale()".
		 */
		private ValueExpression _locale;
		/**
		 * Used for locale definition.   Default value is "getDefaultLocale()".
		 * Setter for locale
		 * @param locale - new value
		 */
		 public void setLocale( ValueExpression  __locale ){
			this._locale = __locale;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * minDaysInFirstWeek
		 * Gets what the minimal days required in the first week of the year 
			are; e.g., if the first week is defined as one that contains the first 
			day of the first month of a year, this method returns 1. If the 
			minimal days required must be a full week, this method returns 7. Default value is "getDefaultMinDaysInFirstWeek()".
		 */
		private ValueExpression _minDaysInFirstWeek;
		/**
		 * Gets what the minimal days required in the first week of the year 
			are; e.g., if the first week is defined as one that contains the first 
			day of the first month of a year, this method returns 1. If the 
			minimal days required must be a full week, this method returns 7. Default value is "getDefaultMinDaysInFirstWeek()".
		 * Setter for minDaysInFirstWeek
		 * @param minDaysInFirstWeek - new value
		 */
		 public void setMinDaysInFirstWeek( ValueExpression  __minDaysInFirstWeek ){
			this._minDaysInFirstWeek = __minDaysInFirstWeek;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * mode
		 * Valid values: ajax or client. Default value is "client".
		 */
		private ValueExpression _mode;
		/**
		 * Valid values: ajax or client. Default value is "client".
		 * Setter for mode
		 * @param mode - new value
		 */
		 public void setMode( ValueExpression  __mode ){
			this._mode = __mode;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * monthLabels
		 * Attribute that allows to customize names of the months.
				Should accept list with the month names
		 */
		private ValueExpression _monthLabels;
		/**
		 * Attribute that allows to customize names of the months.
				Should accept list with the month names
		 * Setter for monthLabels
		 * @param monthLabels - new value
		 */
		 public void setMonthLabels( ValueExpression  __monthLabels ){
			this._monthLabels = __monthLabels;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * monthLabelsShort
		 * Attribute that allows to customize short names of the
				months. Should accept list with the month names
		 */
		private ValueExpression _monthLabelsShort;
		/**
		 * Attribute that allows to customize short names of the
				months. Should accept list with the month names
		 * Setter for monthLabelsShort
		 * @param monthLabelsShort - new value
		 */
		 public void setMonthLabelsShort( ValueExpression  __monthLabelsShort ){
			this._monthLabelsShort = __monthLabelsShort;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onbeforedomupdate
		 * The client side script method to be called before DOM is updated
		 */
		private ValueExpression _onbeforedomupdate;
		/**
		 * The client side script method to be called before DOM is updated
		 * Setter for onbeforedomupdate
		 * @param onbeforedomupdate - new value
		 */
		 public void setOnbeforedomupdate( ValueExpression  __onbeforedomupdate ){
			this._onbeforedomupdate = __onbeforedomupdate;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onchanged
		 * The client side script method to be called when the date or time is changed and applied to input
		 */
		private ValueExpression _onchanged;
		/**
		 * The client side script method to be called when the date or time is changed and applied to input
		 * Setter for onchanged
		 * @param onchanged - new value
		 */
		 public void setOnchanged( ValueExpression  __onchanged ){
			this._onchanged = __onchanged;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oncollapse
		 * The client side script method to be called before the calendar popup is closed
		 */
		private ValueExpression _oncollapse;
		/**
		 * The client side script method to be called before the calendar popup is closed
		 * Setter for oncollapse
		 * @param oncollapse - new value
		 */
		 public void setOncollapse( ValueExpression  __oncollapse ){
			this._oncollapse = __oncollapse;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oncomplete
		 * The client side script method to be called after the request is completed
		 */
		private ValueExpression _oncomplete;
		/**
		 * The client side script method to be called after the request is completed
		 * Setter for oncomplete
		 * @param oncomplete - new value
		 */
		 public void setOncomplete( ValueExpression  __oncomplete ){
			this._oncomplete = __oncomplete;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oncurrentdateselect
		 * The client side script method to be called when the current month or year is changed
		 */
		private ValueExpression _oncurrentdateselect;
		/**
		 * The client side script method to be called when the current month or year is changed
		 * Setter for oncurrentdateselect
		 * @param oncurrentdateselect - new value
		 */
		 public void setOncurrentdateselect( ValueExpression  __oncurrentdateselect ){
			this._oncurrentdateselect = __oncurrentdateselect;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oncurrentdateselected
		 * The client side script method to be called after the current month or year is changed
		 */
		private ValueExpression _oncurrentdateselected;
		/**
		 * The client side script method to be called after the current month or year is changed
		 * Setter for oncurrentdateselected
		 * @param oncurrentdateselected - new value
		 */
		 public void setOncurrentdateselected( ValueExpression  __oncurrentdateselected ){
			this._oncurrentdateselected = __oncurrentdateselected;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * ondatemouseout
		 * The client side script method to be called when a pointer is moved away from the date cell
		 */
		private ValueExpression _ondatemouseout;
		/**
		 * The client side script method to be called when a pointer is moved away from the date cell
		 * Setter for ondatemouseout
		 * @param ondatemouseout - new value
		 */
		 public void setOndatemouseout( ValueExpression  __ondatemouseout ){
			this._ondatemouseout = __ondatemouseout;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * ondatemouseover
		 * The client side script method to be called when a pointer is moved onto the date cell
		 */
		private ValueExpression _ondatemouseover;
		/**
		 * The client side script method to be called when a pointer is moved onto the date cell
		 * Setter for ondatemouseover
		 * @param ondatemouseover - new value
		 */
		 public void setOndatemouseover( ValueExpression  __ondatemouseover ){
			this._ondatemouseover = __ondatemouseover;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * ondateselect
		 * The client side script method to be called when some date cell is selected
		 */
		private ValueExpression _ondateselect;
		/**
		 * The client side script method to be called when some date cell is selected
		 * Setter for ondateselect
		 * @param ondateselect - new value
		 */
		 public void setOndateselect( ValueExpression  __ondateselect ){
			this._ondateselect = __ondateselect;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * ondateselected
		 * The client side script method to be called after some date cell is selected
		 */
		private ValueExpression _ondateselected;
		/**
		 * The client side script method to be called after some date cell is selected
		 * Setter for ondateselected
		 * @param ondateselected - new value
		 */
		 public void setOndateselected( ValueExpression  __ondateselected ){
			this._ondateselected = __ondateselected;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onexpand
		 * The client side script method to be called before the calendar popup is opened
		 */
		private ValueExpression _onexpand;
		/**
		 * The client side script method to be called before the calendar popup is opened
		 * Setter for onexpand
		 * @param onexpand - new value
		 */
		 public void setOnexpand( ValueExpression  __onexpand ){
			this._onexpand = __onexpand;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputblur
		 * The client side script method to be called when the input field loses the focus
		 */
		private ValueExpression _oninputblur;
		/**
		 * The client side script method to be called when the input field loses the focus
		 * Setter for oninputblur
		 * @param oninputblur - new value
		 */
		 public void setOninputblur( ValueExpression  __oninputblur ){
			this._oninputblur = __oninputblur;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputchange
		 * The client side script method to be called when the input field value is changed manually
		 */
		private ValueExpression _oninputchange;
		/**
		 * The client side script method to be called when the input field value is changed manually
		 * Setter for oninputchange
		 * @param oninputchange - new value
		 */
		 public void setOninputchange( ValueExpression  __oninputchange ){
			this._oninputchange = __oninputchange;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputclick
		 * The client side script method to be called when the input field is clicked
		 */
		private ValueExpression _oninputclick;
		/**
		 * The client side script method to be called when the input field is clicked
		 * Setter for oninputclick
		 * @param oninputclick - new value
		 */
		 public void setOninputclick( ValueExpression  __oninputclick ){
			this._oninputclick = __oninputclick;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputfocus
		 * The client side script method to be called when the input field gets the focus
		 */
		private ValueExpression _oninputfocus;
		/**
		 * The client side script method to be called when the input field gets the focus
		 * Setter for oninputfocus
		 * @param oninputfocus - new value
		 */
		 public void setOninputfocus( ValueExpression  __oninputfocus ){
			this._oninputfocus = __oninputfocus;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputkeydown
		 * The client side script method to be called when a key is pressed down in the input field
		 */
		private ValueExpression _oninputkeydown;
		/**
		 * The client side script method to be called when a key is pressed down in the input field
		 * Setter for oninputkeydown
		 * @param oninputkeydown - new value
		 */
		 public void setOninputkeydown( ValueExpression  __oninputkeydown ){
			this._oninputkeydown = __oninputkeydown;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputkeypress
		 * The client side script method to be called when a key is pressed and released in the input field
		 */
		private ValueExpression _oninputkeypress;
		/**
		 * The client side script method to be called when a key is pressed and released in the input field
		 * Setter for oninputkeypress
		 * @param oninputkeypress - new value
		 */
		 public void setOninputkeypress( ValueExpression  __oninputkeypress ){
			this._oninputkeypress = __oninputkeypress;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputkeyup
		 * The client side script method to be called when a key is released in the input field
		 */
		private ValueExpression _oninputkeyup;
		/**
		 * The client side script method to be called when a key is released in the input field
		 * Setter for oninputkeyup
		 * @param oninputkeyup - new value
		 */
		 public void setOninputkeyup( ValueExpression  __oninputkeyup ){
			this._oninputkeyup = __oninputkeyup;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputmouseout
		 * The client side script method to be called when a pointer is moved away from the input field
		 */
		private ValueExpression _oninputmouseout;
		/**
		 * The client side script method to be called when a pointer is moved away from the input field
		 * Setter for oninputmouseout
		 * @param oninputmouseout - new value
		 */
		 public void setOninputmouseout( ValueExpression  __oninputmouseout ){
			this._oninputmouseout = __oninputmouseout;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputmouseover
		 * The client side script method to be called when a pointer is moved onto the input field
		 */
		private ValueExpression _oninputmouseover;
		/**
		 * The client side script method to be called when a pointer is moved onto the input field
		 * Setter for oninputmouseover
		 * @param oninputmouseover - new value
		 */
		 public void setOninputmouseover( ValueExpression  __oninputmouseover ){
			this._oninputmouseover = __oninputmouseover;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * oninputselect
		 * The client side script method to be called when the input field value is selected
		 */
		private ValueExpression _oninputselect;
		/**
		 * The client side script method to be called when the input field value is selected
		 * Setter for oninputselect
		 * @param oninputselect - new value
		 */
		 public void setOninputselect( ValueExpression  __oninputselect ){
			this._oninputselect = __oninputselect;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * ontimeselect
		 * The client side script method to be called before new time is selected
		 */
		private ValueExpression _ontimeselect;
		/**
		 * The client side script method to be called before new time is selected
		 * Setter for ontimeselect
		 * @param ontimeselect - new value
		 */
		 public void setOntimeselect( ValueExpression  __ontimeselect ){
			this._ontimeselect = __ontimeselect;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * ontimeselected
		 * The client side script method to be called after time is selected
		 */
		private ValueExpression _ontimeselected;
		/**
		 * The client side script method to be called after time is selected
		 * Setter for ontimeselected
		 * @param ontimeselected - new value
		 */
		 public void setOntimeselected( ValueExpression  __ontimeselected ){
			this._ontimeselected = __ontimeselected;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * popup
		 * If "true", the calendar will be rendered initially
				as hidden with additional elements for calling as popup. Default value is "true".
		 */
		private ValueExpression _popup;
		/**
		 * If "true", the calendar will be rendered initially
				as hidden with additional elements for calling as popup. Default value is "true".
		 * Setter for popup
		 * @param popup - new value
		 */
		 public void setPopup( ValueExpression  __popup ){
			this._popup = __popup;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * preloadDateRangeBegin
		 * Define the initial range of date which will be loaded to
				client from dataModel under rendering. Default value is "getDefaultPreloadBegin(getCurrentDateOrDefault())".
		 */
		private ValueExpression _preloadDateRangeBegin;
		/**
		 * Define the initial range of date which will be loaded to
				client from dataModel under rendering. Default value is "getDefaultPreloadBegin(getCurrentDateOrDefault())".
		 * Setter for preloadDateRangeBegin
		 * @param preloadDateRangeBegin - new value
		 */
		 public void setPreloadDateRangeBegin( ValueExpression  __preloadDateRangeBegin ){
			this._preloadDateRangeBegin = __preloadDateRangeBegin;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * preloadDateRangeEnd
		 * Defines the last range of date which will be loaded to
				client from dataModel under rendering. Default value is "getDefaultPreloadEnd(getCurrentDateOrDefault())".
		 */
		private ValueExpression _preloadDateRangeEnd;
		/**
		 * Defines the last range of date which will be loaded to
				client from dataModel under rendering. Default value is "getDefaultPreloadEnd(getCurrentDateOrDefault())".
		 * Setter for preloadDateRangeEnd
		 * @param preloadDateRangeEnd - new value
		 */
		 public void setPreloadDateRangeEnd( ValueExpression  __preloadDateRangeEnd ){
			this._preloadDateRangeEnd = __preloadDateRangeEnd;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * process
		 * Id['s] (in format of call  UIComponent.findComponent()) of components, processed at the phases 2-5 in case of AjaxRequest  caused by this component. Can be single id, comma-separated list of Id's, or EL Expression  with array or Collection
		 */
		private ValueExpression _process;
		/**
		 * Id['s] (in format of call  UIComponent.findComponent()) of components, processed at the phases 2-5 in case of AjaxRequest  caused by this component. Can be single id, comma-separated list of Id's, or EL Expression  with array or Collection
		 * Setter for process
		 * @param process - new value
		 */
		 public void setProcess( ValueExpression  __process ){
			this._process = __process;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * reRender
		 * Id['s] (in format of call  UIComponent.findComponent()) of components, rendered in case of AjaxRequest  caused by this component. Can be single id, comma-separated list of Id's, or EL Expression  with array or Collection
		 */
		private ValueExpression _reRender;
		/**
		 * Id['s] (in format of call  UIComponent.findComponent()) of components, rendered in case of AjaxRequest  caused by this component. Can be single id, comma-separated list of Id's, or EL Expression  with array or Collection
		 * Setter for reRender
		 * @param reRender - new value
		 */
		 public void setReRender( ValueExpression  __reRender ){
			this._reRender = __reRender;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * readonly
		 * If "true". Date and time are not selectable.  In
				"popup" mode input is disabled and button is enabled. Default value is "false".
		 */
		private ValueExpression _readonly;
		/**
		 * If "true". Date and time are not selectable.  In
				"popup" mode input is disabled and button is enabled. Default value is "false".
		 * Setter for readonly
		 * @param readonly - new value
		 */
		 public void setReadonly( ValueExpression  __readonly ){
			this._readonly = __readonly;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * requestDelay
		 * Attribute defines the time (in ms.) that the request will be wait in the queue before it is ready to send.
When the delay time is over, the request will be sent to the server or removed if the newest 'similar' request is in a queue already
		 */
		private ValueExpression _requestDelay;
		/**
		 * Attribute defines the time (in ms.) that the request will be wait in the queue before it is ready to send.
When the delay time is over, the request will be sent to the server or removed if the newest 'similar' request is in a queue already
		 * Setter for requestDelay
		 * @param requestDelay - new value
		 */
		 public void setRequestDelay( ValueExpression  __requestDelay ){
			this._requestDelay = __requestDelay;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * required
		 * If "true", this component is checked for non-empty input
		 */
		private ValueExpression _required;
		/**
		 * If "true", this component is checked for non-empty input
		 * Setter for required
		 * @param required - new value
		 */
		 public void setRequired( ValueExpression  __required ){
			this._required = __required;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * requiredMessage
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validation message for
			the "required" facility, if the "required" facility is
			used
		 */
		private ValueExpression _requiredMessage;
		/**
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validation message for
			the "required" facility, if the "required" facility is
			used
		 * Setter for requiredMessage
		 * @param requiredMessage - new value
		 */
		 public void setRequiredMessage( ValueExpression  __requiredMessage ){
			this._requiredMessage = __requiredMessage;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * resetTimeOnDateSelect
		 * If value is true then calendar should change time to defaultTime for newly-selected dates. Default value is "false"
		 */
		private ValueExpression _resetTimeOnDateSelect;
		/**
		 * If value is true then calendar should change time to defaultTime for newly-selected dates. Default value is "false"
		 * Setter for resetTimeOnDateSelect
		 * @param resetTimeOnDateSelect - new value
		 */
		 public void setResetTimeOnDateSelect( ValueExpression  __resetTimeOnDateSelect ){
			this._resetTimeOnDateSelect = __resetTimeOnDateSelect;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * showApplyButton
		 * If false ApplyButton should not be shown. Default value is "false".
		 */
		private ValueExpression _showApplyButton;
		/**
		 * If false ApplyButton should not be shown. Default value is "false".
		 * Setter for showApplyButton
		 * @param showApplyButton - new value
		 */
		 public void setShowApplyButton( ValueExpression  __showApplyButton ){
			this._showApplyButton = __showApplyButton;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * showFooter
		 * If false Calendar's footer should not be shown. Default value is "true".
		 */
		private ValueExpression _showFooter;
		/**
		 * If false Calendar's footer should not be shown. Default value is "true".
		 * Setter for showFooter
		 * @param showFooter - new value
		 */
		 public void setShowFooter( ValueExpression  __showFooter ){
			this._showFooter = __showFooter;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * showHeader
		 * If false Calendar's header should not be shown. Default value is "true".
		 */
		private ValueExpression _showHeader;
		/**
		 * If false Calendar's header should not be shown. Default value is "true".
		 * Setter for showHeader
		 * @param showHeader - new value
		 */
		 public void setShowHeader( ValueExpression  __showHeader ){
			this._showHeader = __showHeader;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * showInput
		 * "false" value for this attribute makes text
				field invisible. It works only if popupMode="true"
				If showInput is "true" - input field will
				be shown. Default value is "true".
		 */
		private ValueExpression _showInput;
		/**
		 * "false" value for this attribute makes text
				field invisible. It works only if popupMode="true"
				If showInput is "true" - input field will
				be shown. Default value is "true".
		 * Setter for showInput
		 * @param showInput - new value
		 */
		 public void setShowInput( ValueExpression  __showInput ){
			this._showInput = __showInput;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * showWeekDaysBar
		 * If false this bar should not be shown. Default value is "true".
		 */
		private ValueExpression _showWeekDaysBar;
		/**
		 * If false this bar should not be shown. Default value is "true".
		 * Setter for showWeekDaysBar
		 * @param showWeekDaysBar - new value
		 */
		 public void setShowWeekDaysBar( ValueExpression  __showWeekDaysBar ){
			this._showWeekDaysBar = __showWeekDaysBar;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * showWeeksBar
		 * If false this bar should not be shown. Default value is "true".
		 */
		private ValueExpression _showWeeksBar;
		/**
		 * If false this bar should not be shown. Default value is "true".
		 * Setter for showWeeksBar
		 * @param showWeeksBar - new value
		 */
		 public void setShowWeeksBar( ValueExpression  __showWeeksBar ){
			this._showWeeksBar = __showWeeksBar;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * similarityGroupingId
		 * If there are any component requests with identical IDs then these requests will be grouped.
		 */
		private ValueExpression _similarityGroupingId;
		/**
		 * If there are any component requests with identical IDs then these requests will be grouped.
		 * Setter for similarityGroupingId
		 * @param similarityGroupingId - new value
		 */
		 public void setSimilarityGroupingId( ValueExpression  __similarityGroupingId ){
			this._similarityGroupingId = __similarityGroupingId;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * status
		 * ID (in format of call UIComponent.findComponent()) of Request status component
		 */
		private ValueExpression _status;
		/**
		 * ID (in format of call UIComponent.findComponent()) of Request status component
		 * Setter for status
		 * @param status - new value
		 */
		 public void setStatus( ValueExpression  __status ){
			this._status = __status;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * tabindex
		 * This attribute specifies the position of the current element in the tabbing order for the current document. This value must be a number between 0 and 32767. User agents should ignore leading zeros
		 */
		private ValueExpression _tabindex;
		/**
		 * This attribute specifies the position of the current element in the tabbing order for the current document. This value must be a number between 0 and 32767. User agents should ignore leading zeros
		 * Setter for tabindex
		 * @param tabindex - new value
		 */
		 public void setTabindex( ValueExpression  __tabindex ){
			this._tabindex = __tabindex;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * timeZone
		 * Used for current date calculations. Default value is "getDefaultTimeZone()".
		 */
		private ValueExpression _timeZone;
		/**
		 * Used for current date calculations. Default value is "getDefaultTimeZone()".
		 * Setter for timeZone
		 * @param timeZone - new value
		 */
		 public void setTimeZone( ValueExpression  __timeZone ){
			this._timeZone = __timeZone;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * timeout
		 * Response waiting time on a particular request. If a response is not received during this time, the request is aborted
		 */
		private ValueExpression _timeout;
		/**
		 * Response waiting time on a particular request. If a response is not received during this time, the request is aborted
		 * Setter for timeout
		 * @param timeout - new value
		 */
		 public void setTimeout( ValueExpression  __timeout ){
			this._timeout = __timeout;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * todayControlMode
		 * This attribute defines the mode for "today" control. Possible values are "scroll", "select", "hidden". Default value is "select".
		 */
		private ValueExpression _todayControlMode;
		/**
		 * This attribute defines the mode for "today" control. Possible values are "scroll", "select", "hidden". Default value is "select".
		 * Setter for todayControlMode
		 * @param todayControlMode - new value
		 */
		 public void setTodayControlMode( ValueExpression  __todayControlMode ){
			this._todayControlMode = __todayControlMode;
	     }
	  
	 	 		 		 		 	  	  	  
		/*
		 * validator
		 * MethodBinding pointing at a method that is called during
            Process Validations phase of the request processing lifecycle,
            to validate the current value of this component
		 */
		private MethodExpression _validator;
		/**
		 * MethodBinding pointing at a method that is called during
            Process Validations phase of the request processing lifecycle,
            to validate the current value of this component
		 * Setter for validator
		 * @param validator - new value
		 */
		 public void setValidator( MethodExpression  __validator ){
			this._validator = __validator;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * validatorMessage
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validator message,
			replacing any message that comes from the validator
		 */
		private ValueExpression _validatorMessage;
		/**
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validator message,
			replacing any message that comes from the validator
		 * Setter for validatorMessage
		 * @param validatorMessage - new value
		 */
		 public void setValidatorMessage( ValueExpression  __validatorMessage ){
			this._validatorMessage = __validatorMessage;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * value
		 * The current value of this component
		 */
		private ValueExpression _value;
		/**
		 * The current value of this component
		 * Setter for value
		 * @param value - new value
		 */
		 public void setValue( ValueExpression  __value ){
			this._value = __value;
	     }
	  
	 	 		 	  	  	  
		/*
		 * valueChangeListener
		 * Listener for value changes
		 */
		private MethodExpression _valueChangeListener;
		/**
		 * Listener for value changes
		 * Setter for valueChangeListener
		 * @param valueChangeListener - new value
		 */
		 public void setValueChangeListener( MethodExpression  __valueChangeListener ){
			this._valueChangeListener = __valueChangeListener;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * verticalOffset
		 * Sets the vertical offset between button and calendar
				element conjunction point. Default value is "0".
		 */
		private ValueExpression _verticalOffset;
		/**
		 * Sets the vertical offset between button and calendar
				element conjunction point. Default value is "0".
		 * Setter for verticalOffset
		 * @param verticalOffset - new value
		 */
		 public void setVerticalOffset( ValueExpression  __verticalOffset ){
			this._verticalOffset = __verticalOffset;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * weekDayLabels
		 * List of the day names displays on the days bar in the
				following way "Sun, Mon, Tue, Wed, "
		 */
		private ValueExpression _weekDayLabels;
		/**
		 * List of the day names displays on the days bar in the
				following way "Sun, Mon, Tue, Wed, "
		 * Setter for weekDayLabels
		 * @param weekDayLabels - new value
		 */
		 public void setWeekDayLabels( ValueExpression  __weekDayLabels ){
			this._weekDayLabels = __weekDayLabels;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * weekDayLabelsShort
		 * Attribute that allows to customize short names of the
				weeks. Should accept list with the weeks names.
		 */
		private ValueExpression _weekDayLabelsShort;
		/**
		 * Attribute that allows to customize short names of the
				weeks. Should accept list with the weeks names.
		 * Setter for weekDayLabelsShort
		 * @param weekDayLabelsShort - new value
		 */
		 public void setWeekDayLabelsShort( ValueExpression  __weekDayLabelsShort ){
			this._weekDayLabelsShort = __weekDayLabelsShort;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * zindex
		 * Attribute is similar to the standard HTML attribute and
				can specify window placement relative to the content. Default value is "3".
		 */
		private ValueExpression _zindex;
		/**
		 * Attribute is similar to the standard HTML attribute and
				can specify window placement relative to the content. Default value is "3".
		 * Setter for zindex
		 * @param zindex - new value
		 */
		 public void setZindex( ValueExpression  __zindex ){
			this._zindex = __zindex;
	     }
	  
	 	 	
	
    public void release()
    {
        // TODO Auto-generated method stub
        super.release();
        		 		    this._ajaxSingle = null;
	 		 		 		    this._boundaryDatesMode = null;
	 		 		    this._buttonClass = null;
	 		 		    this._buttonIcon = null;
	 		 		    this._buttonIconDisabled = null;
	 		 		    this._buttonLabel = null;
	 		 		    this._bypassUpdates = null;
	 		 		 		    this._cellHeight = null;
	 		 		    this._cellWidth = null;
	 		 		    this._converter = null;
	 		 		    this._converterMessage = null;
	 		 		    this._currentDate = null;
	 		 		    this._currentDateChangeListener = null;
	 		 		 		 		 		    this._dataModel = null;
	 		 		    this._datePattern = null;
	 		 		    this._dayStyleClass = null;
	 		 		    this._defaultTime = null;
	 		 		    this._direction = null;
	 		 		    this._disabled = null;
	 		 		    this._enableManualInput = null;
	 		 		    this._eventsQueue = null;
	 		 		 		    this._firstWeekDay = null;
	 		 		    this._focus = null;
	 		 		 		    this._horizontalOffset = null;
	 		 		 		    this._ignoreDupResponses = null;
	 		 		    this._immediate = null;
	 		 		    this._inputClass = null;
	 		 		    this._inputSize = null;
	 		 		    this._inputStyle = null;
	 		 		    this._isDayEnabled = null;
	 		 		    this._jointPoint = null;
	 		 		    this._label = null;
	 		 		    this._limitToList = null;
	 		 		 		 		    this._locale = null;
	 		 		    this._minDaysInFirstWeek = null;
	 		 		    this._mode = null;
	 		 		    this._monthLabels = null;
	 		 		    this._monthLabelsShort = null;
	 		 		    this._onbeforedomupdate = null;
	 		 		    this._onchanged = null;
	 		 		    this._oncollapse = null;
	 		 		    this._oncomplete = null;
	 		 		    this._oncurrentdateselect = null;
	 		 		    this._oncurrentdateselected = null;
	 		 		    this._ondatemouseout = null;
	 		 		    this._ondatemouseover = null;
	 		 		    this._ondateselect = null;
	 		 		    this._ondateselected = null;
	 		 		    this._onexpand = null;
	 		 		    this._oninputblur = null;
	 		 		    this._oninputchange = null;
	 		 		    this._oninputclick = null;
	 		 		    this._oninputfocus = null;
	 		 		    this._oninputkeydown = null;
	 		 		    this._oninputkeypress = null;
	 		 		    this._oninputkeyup = null;
	 		 		    this._oninputmouseout = null;
	 		 		    this._oninputmouseover = null;
	 		 		    this._oninputselect = null;
	 		 		    this._ontimeselect = null;
	 		 		    this._ontimeselected = null;
	 		 		    this._popup = null;
	 		 		 		 		    this._preloadDateRangeBegin = null;
	 		 		    this._preloadDateRangeEnd = null;
	 		 		 		    this._process = null;
	 		 		    this._reRender = null;
	 		 		    this._readonly = null;
	 		 		 		    this._requestDelay = null;
	 		 		    this._required = null;
	 		 		    this._requiredMessage = null;
	 		 		    this._resetTimeOnDateSelect = null;
	 		 		    this._showApplyButton = null;
	 		 		    this._showFooter = null;
	 		 		    this._showHeader = null;
	 		 		    this._showInput = null;
	 		 		    this._showWeekDaysBar = null;
	 		 		    this._showWeeksBar = null;
	 		 		    this._similarityGroupingId = null;
	 		 		    this._status = null;
	 		 		 		 		    this._tabindex = null;
	 		 		    this._timeZone = null;
	 		 		    this._timeout = null;
	 		 		    this._todayControlMode = null;
	 		 		 		 		    this._validator = null;
	 		 		    this._validatorMessage = null;
	 		 		 		    this._value = null;
	 		 		    this._valueChangeListener = null;
	 		 		 		    this._verticalOffset = null;
	 		 		    this._weekDayLabels = null;
	 		 		    this._weekDayLabelsShort = null;
	 		 		    this._zindex = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlPersianCalendar comp = (HtmlPersianCalendar) component;
 		 			 
						if (this._ajaxSingle != null) {
				if (this._ajaxSingle.isLiteralText()) {
					try {
												
						Boolean __ajaxSingle = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ajaxSingle.getExpressionString(), 
											Boolean.class);
					
												comp.setAjaxSingle(__ajaxSingle.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ajaxSingle", this._ajaxSingle);
				}
			}
					    		 			 
						if (this._boundaryDatesMode != null) {
				if (this._boundaryDatesMode.isLiteralText()) {
					try {
												
						java.lang.String __boundaryDatesMode = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._boundaryDatesMode.getExpressionString(), 
											java.lang.String.class);
					
												comp.setBoundaryDatesMode(__boundaryDatesMode);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("boundaryDatesMode", this._boundaryDatesMode);
				}
			}
					   		 			 
						if (this._buttonClass != null) {
				if (this._buttonClass.isLiteralText()) {
					try {
												
						java.lang.String __buttonClass = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._buttonClass.getExpressionString(), 
											java.lang.String.class);
					
												comp.setButtonClass(__buttonClass);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("buttonClass", this._buttonClass);
				}
			}
					   		 			 
						if (this._buttonIcon != null) {
				if (this._buttonIcon.isLiteralText()) {
					try {
												
						java.lang.String __buttonIcon = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._buttonIcon.getExpressionString(), 
											java.lang.String.class);
					
												comp.setButtonIcon(__buttonIcon);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("buttonIcon", this._buttonIcon);
				}
			}
					   		 			 
						if (this._buttonIconDisabled != null) {
				if (this._buttonIconDisabled.isLiteralText()) {
					try {
												
						java.lang.String __buttonIconDisabled = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._buttonIconDisabled.getExpressionString(), 
											java.lang.String.class);
					
												comp.setButtonIconDisabled(__buttonIconDisabled);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("buttonIconDisabled", this._buttonIconDisabled);
				}
			}
					   		 			 
						if (this._buttonLabel != null) {
				if (this._buttonLabel.isLiteralText()) {
					try {
												
						java.lang.String __buttonLabel = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._buttonLabel.getExpressionString(), 
											java.lang.String.class);
					
												comp.setButtonLabel(__buttonLabel);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("buttonLabel", this._buttonLabel);
				}
			}
					   		 			 
						if (this._bypassUpdates != null) {
				if (this._bypassUpdates.isLiteralText()) {
					try {
												
						Boolean __bypassUpdates = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._bypassUpdates.getExpressionString(), 
											Boolean.class);
					
												comp.setBypassUpdates(__bypassUpdates.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("bypassUpdates", this._bypassUpdates);
				}
			}
					    		 			 
						if (this._cellHeight != null) {
				if (this._cellHeight.isLiteralText()) {
					try {
												
						java.lang.String __cellHeight = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._cellHeight.getExpressionString(), 
											java.lang.String.class);
					
												comp.setCellHeight(__cellHeight);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("cellHeight", this._cellHeight);
				}
			}
					   		 			 
						if (this._cellWidth != null) {
				if (this._cellWidth.isLiteralText()) {
					try {
												
						java.lang.String __cellWidth = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._cellWidth.getExpressionString(), 
											java.lang.String.class);
					
												comp.setCellWidth(__cellWidth);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("cellWidth", this._cellWidth);
				}
			}
					   		 			setConverterProperty(comp, this._converter);
		   		 			 
						if (this._converterMessage != null) {
				if (this._converterMessage.isLiteralText()) {
					try {
												
						java.lang.String __converterMessage = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._converterMessage.getExpressionString(), 
											java.lang.String.class);
					
												comp.setConverterMessage(__converterMessage);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("converterMessage", this._converterMessage);
				}
			}
					   		 			 
						if (this._currentDate != null) {
				if (this._currentDate.isLiteralText()) {
					try {
												
						java.lang.Object __currentDate = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._currentDate.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setCurrentDate(__currentDate);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("currentDate", this._currentDate);
				}
			}
					   		 			if(null != this._currentDateChangeListener){
				((HtmlPersianCalendar)component).setCurrentDateChangeListener(this._currentDateChangeListener);
			}		
		      		 			 				if(null != this._dataModel && this._dataModel.isLiteralText()){
					throw new IllegalArgumentException("Component org.omidbiz.PersianCalendar with Id " + component.getClientId(getFacesContext()) +" allows only EL expressions for property dataModel");
				}
			 
						if (this._dataModel != null) {
				if (this._dataModel.isLiteralText()) {
					try {
												
						org.omidbiz.model.CalendarDataModel __dataModel = (org.omidbiz.model.CalendarDataModel) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._dataModel.getExpressionString(), 
											org.omidbiz.model.CalendarDataModel.class);
					
												comp.setDataModel(__dataModel);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("dataModel", this._dataModel);
				}
			}
					   		 			 
						if (this._datePattern != null) {
				if (this._datePattern.isLiteralText()) {
					try {
												
						java.lang.String __datePattern = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._datePattern.getExpressionString(), 
											java.lang.String.class);
					
												comp.setDatePattern(__datePattern);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("datePattern", this._datePattern);
				}
			}
					   		 			 
						if (this._dayStyleClass != null) {
				if (this._dayStyleClass.isLiteralText()) {
					try {
												
						java.lang.String __dayStyleClass = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._dayStyleClass.getExpressionString(), 
											java.lang.String.class);
					
												comp.setDayStyleClass(__dayStyleClass);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("dayStyleClass", this._dayStyleClass);
				}
			}
					   		 			 
						if (this._defaultTime != null) {
				if (this._defaultTime.isLiteralText()) {
					try {
												
						java.lang.Object __defaultTime = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._defaultTime.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setDefaultTime(__defaultTime);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("defaultTime", this._defaultTime);
				}
			}
					   		 			 
						if (this._direction != null) {
				if (this._direction.isLiteralText()) {
					try {
												
						java.lang.String __direction = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._direction.getExpressionString(), 
											java.lang.String.class);
					
												comp.setDirection(__direction);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("direction", this._direction);
				}
			}
					   		 			 
						if (this._disabled != null) {
				if (this._disabled.isLiteralText()) {
					try {
												
						Boolean __disabled = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._disabled.getExpressionString(), 
											Boolean.class);
					
												comp.setDisabled(__disabled.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("disabled", this._disabled);
				}
			}
					   		 			 
						if (this._enableManualInput != null) {
				if (this._enableManualInput.isLiteralText()) {
					try {
												
						Boolean __enableManualInput = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._enableManualInput.getExpressionString(), 
											Boolean.class);
					
												comp.setEnableManualInput(__enableManualInput.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("enableManualInput", this._enableManualInput);
				}
			}
					   		 			 
						if (this._eventsQueue != null) {
				if (this._eventsQueue.isLiteralText()) {
					try {
												
						java.lang.String __eventsQueue = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._eventsQueue.getExpressionString(), 
											java.lang.String.class);
					
												comp.setEventsQueue(__eventsQueue);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("eventsQueue", this._eventsQueue);
				}
			}
					    		 			 
						if (this._firstWeekDay != null) {
				if (this._firstWeekDay.isLiteralText()) {
					try {
												
						Integer __firstWeekDay = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._firstWeekDay.getExpressionString(), 
											Integer.class);
					
												comp.setFirstWeekDay(__firstWeekDay.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("firstWeekDay", this._firstWeekDay);
				}
			}
					   		 			 
						if (this._focus != null) {
				if (this._focus.isLiteralText()) {
					try {
												
						java.lang.String __focus = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._focus.getExpressionString(), 
											java.lang.String.class);
					
												comp.setFocus(__focus);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("focus", this._focus);
				}
			}
					    		 			 
						if (this._horizontalOffset != null) {
				if (this._horizontalOffset.isLiteralText()) {
					try {
												
						Integer __horizontalOffset = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._horizontalOffset.getExpressionString(), 
											Integer.class);
					
												comp.setHorizontalOffset(__horizontalOffset.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("horizontalOffset", this._horizontalOffset);
				}
			}
					    		 			 
						if (this._ignoreDupResponses != null) {
				if (this._ignoreDupResponses.isLiteralText()) {
					try {
												
						Boolean __ignoreDupResponses = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ignoreDupResponses.getExpressionString(), 
											Boolean.class);
					
												comp.setIgnoreDupResponses(__ignoreDupResponses.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ignoreDupResponses", this._ignoreDupResponses);
				}
			}
					   		 			 
						if (this._immediate != null) {
				if (this._immediate.isLiteralText()) {
					try {
												
						Boolean __immediate = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._immediate.getExpressionString(), 
											Boolean.class);
					
												comp.setImmediate(__immediate.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("immediate", this._immediate);
				}
			}
					   		 			 
						if (this._inputClass != null) {
				if (this._inputClass.isLiteralText()) {
					try {
												
						java.lang.String __inputClass = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._inputClass.getExpressionString(), 
											java.lang.String.class);
					
												comp.setInputClass(__inputClass);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("inputClass", this._inputClass);
				}
			}
					   		 			 
						if (this._inputSize != null) {
				if (this._inputSize.isLiteralText()) {
					try {
												
						Integer __inputSize = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._inputSize.getExpressionString(), 
											Integer.class);
					
												comp.setInputSize(__inputSize.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("inputSize", this._inputSize);
				}
			}
					   		 			 
						if (this._inputStyle != null) {
				if (this._inputStyle.isLiteralText()) {
					try {
												
						java.lang.String __inputStyle = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._inputStyle.getExpressionString(), 
											java.lang.String.class);
					
												comp.setInputStyle(__inputStyle);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("inputStyle", this._inputStyle);
				}
			}
					   		 			 
						if (this._isDayEnabled != null) {
				if (this._isDayEnabled.isLiteralText()) {
					try {
												
						java.lang.String __isDayEnabled = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._isDayEnabled.getExpressionString(), 
											java.lang.String.class);
					
												comp.setIsDayEnabled(__isDayEnabled);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("isDayEnabled", this._isDayEnabled);
				}
			}
					   		 			 
						if (this._jointPoint != null) {
				if (this._jointPoint.isLiteralText()) {
					try {
												
						java.lang.String __jointPoint = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._jointPoint.getExpressionString(), 
											java.lang.String.class);
					
												comp.setJointPoint(__jointPoint);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("jointPoint", this._jointPoint);
				}
			}
					   		 			 
						if (this._label != null) {
				if (this._label.isLiteralText()) {
					try {
												
						java.lang.String __label = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._label.getExpressionString(), 
											java.lang.String.class);
					
												comp.setLabel(__label);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("label", this._label);
				}
			}
					   		 			 
						if (this._limitToList != null) {
				if (this._limitToList.isLiteralText()) {
					try {
												
						Boolean __limitToList = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._limitToList.getExpressionString(), 
											Boolean.class);
					
												comp.setLimitToList(__limitToList.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("limitToList", this._limitToList);
				}
			}
					     		 			 
						if (this._locale != null) {
				if (this._locale.isLiteralText()) {
					try {
												
						java.lang.Object __locale = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._locale.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setLocale(__locale);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("locale", this._locale);
				}
			}
					   		 			 
						if (this._minDaysInFirstWeek != null) {
				if (this._minDaysInFirstWeek.isLiteralText()) {
					try {
												
						Integer __minDaysInFirstWeek = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._minDaysInFirstWeek.getExpressionString(), 
											Integer.class);
					
												comp.setMinDaysInFirstWeek(__minDaysInFirstWeek.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("minDaysInFirstWeek", this._minDaysInFirstWeek);
				}
			}
					   		 			 
						if (this._mode != null) {
				if (this._mode.isLiteralText()) {
					try {
												
						java.lang.String __mode = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._mode.getExpressionString(), 
											java.lang.String.class);
					
												comp.setMode(__mode);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("mode", this._mode);
				}
			}
					   		 			 
						if (this._monthLabels != null) {
				if (this._monthLabels.isLiteralText()) {
					try {
												
						java.lang.Object __monthLabels = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._monthLabels.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setMonthLabels(__monthLabels);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("monthLabels", this._monthLabels);
				}
			}
					   		 			 
						if (this._monthLabelsShort != null) {
				if (this._monthLabelsShort.isLiteralText()) {
					try {
												
						java.lang.Object __monthLabelsShort = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._monthLabelsShort.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setMonthLabelsShort(__monthLabelsShort);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("monthLabelsShort", this._monthLabelsShort);
				}
			}
					   		 			 
						if (this._onbeforedomupdate != null) {
				if (this._onbeforedomupdate.isLiteralText()) {
					try {
												
						java.lang.String __onbeforedomupdate = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onbeforedomupdate.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnbeforedomupdate(__onbeforedomupdate);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onbeforedomupdate", this._onbeforedomupdate);
				}
			}
					   		 			 
						if (this._onchanged != null) {
				if (this._onchanged.isLiteralText()) {
					try {
												
						java.lang.String __onchanged = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onchanged.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnchanged(__onchanged);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onchanged", this._onchanged);
				}
			}
					   		 			 
						if (this._oncollapse != null) {
				if (this._oncollapse.isLiteralText()) {
					try {
												
						java.lang.String __oncollapse = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oncollapse.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOncollapse(__oncollapse);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oncollapse", this._oncollapse);
				}
			}
					   		 			 
						if (this._oncomplete != null) {
				if (this._oncomplete.isLiteralText()) {
					try {
												
						java.lang.String __oncomplete = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oncomplete.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOncomplete(__oncomplete);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oncomplete", this._oncomplete);
				}
			}
					   		 			 
						if (this._oncurrentdateselect != null) {
				if (this._oncurrentdateselect.isLiteralText()) {
					try {
												
						java.lang.String __oncurrentdateselect = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oncurrentdateselect.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOncurrentdateselect(__oncurrentdateselect);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oncurrentdateselect", this._oncurrentdateselect);
				}
			}
					   		 			 
						if (this._oncurrentdateselected != null) {
				if (this._oncurrentdateselected.isLiteralText()) {
					try {
												
						java.lang.String __oncurrentdateselected = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oncurrentdateselected.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOncurrentdateselected(__oncurrentdateselected);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oncurrentdateselected", this._oncurrentdateselected);
				}
			}
					   		 			 
						if (this._ondatemouseout != null) {
				if (this._ondatemouseout.isLiteralText()) {
					try {
												
						java.lang.String __ondatemouseout = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ondatemouseout.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOndatemouseout(__ondatemouseout);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ondatemouseout", this._ondatemouseout);
				}
			}
					   		 			 
						if (this._ondatemouseover != null) {
				if (this._ondatemouseover.isLiteralText()) {
					try {
												
						java.lang.String __ondatemouseover = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ondatemouseover.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOndatemouseover(__ondatemouseover);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ondatemouseover", this._ondatemouseover);
				}
			}
					   		 			 
						if (this._ondateselect != null) {
				if (this._ondateselect.isLiteralText()) {
					try {
												
						java.lang.String __ondateselect = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ondateselect.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOndateselect(__ondateselect);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ondateselect", this._ondateselect);
				}
			}
					   		 			 
						if (this._ondateselected != null) {
				if (this._ondateselected.isLiteralText()) {
					try {
												
						java.lang.String __ondateselected = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ondateselected.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOndateselected(__ondateselected);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ondateselected", this._ondateselected);
				}
			}
					   		 			 
						if (this._onexpand != null) {
				if (this._onexpand.isLiteralText()) {
					try {
												
						java.lang.String __onexpand = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onexpand.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnexpand(__onexpand);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onexpand", this._onexpand);
				}
			}
					   		 			 
						if (this._oninputblur != null) {
				if (this._oninputblur.isLiteralText()) {
					try {
												
						java.lang.String __oninputblur = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputblur.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputblur(__oninputblur);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputblur", this._oninputblur);
				}
			}
					   		 			 
						if (this._oninputchange != null) {
				if (this._oninputchange.isLiteralText()) {
					try {
												
						java.lang.String __oninputchange = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputchange.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputchange(__oninputchange);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputchange", this._oninputchange);
				}
			}
					   		 			 
						if (this._oninputclick != null) {
				if (this._oninputclick.isLiteralText()) {
					try {
												
						java.lang.String __oninputclick = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputclick.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputclick(__oninputclick);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputclick", this._oninputclick);
				}
			}
					   		 			 
						if (this._oninputfocus != null) {
				if (this._oninputfocus.isLiteralText()) {
					try {
												
						java.lang.String __oninputfocus = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputfocus.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputfocus(__oninputfocus);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputfocus", this._oninputfocus);
				}
			}
					   		 			 
						if (this._oninputkeydown != null) {
				if (this._oninputkeydown.isLiteralText()) {
					try {
												
						java.lang.String __oninputkeydown = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputkeydown.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputkeydown(__oninputkeydown);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputkeydown", this._oninputkeydown);
				}
			}
					   		 			 
						if (this._oninputkeypress != null) {
				if (this._oninputkeypress.isLiteralText()) {
					try {
												
						java.lang.String __oninputkeypress = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputkeypress.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputkeypress(__oninputkeypress);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputkeypress", this._oninputkeypress);
				}
			}
					   		 			 
						if (this._oninputkeyup != null) {
				if (this._oninputkeyup.isLiteralText()) {
					try {
												
						java.lang.String __oninputkeyup = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputkeyup.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputkeyup(__oninputkeyup);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputkeyup", this._oninputkeyup);
				}
			}
					   		 			 
						if (this._oninputmouseout != null) {
				if (this._oninputmouseout.isLiteralText()) {
					try {
												
						java.lang.String __oninputmouseout = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputmouseout.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputmouseout(__oninputmouseout);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputmouseout", this._oninputmouseout);
				}
			}
					   		 			 
						if (this._oninputmouseover != null) {
				if (this._oninputmouseover.isLiteralText()) {
					try {
												
						java.lang.String __oninputmouseover = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputmouseover.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputmouseover(__oninputmouseover);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputmouseover", this._oninputmouseover);
				}
			}
					   		 			 
						if (this._oninputselect != null) {
				if (this._oninputselect.isLiteralText()) {
					try {
												
						java.lang.String __oninputselect = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._oninputselect.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOninputselect(__oninputselect);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("oninputselect", this._oninputselect);
				}
			}
					   		 			 
						if (this._ontimeselect != null) {
				if (this._ontimeselect.isLiteralText()) {
					try {
												
						java.lang.String __ontimeselect = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ontimeselect.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOntimeselect(__ontimeselect);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ontimeselect", this._ontimeselect);
				}
			}
					   		 			 
						if (this._ontimeselected != null) {
				if (this._ontimeselected.isLiteralText()) {
					try {
												
						java.lang.String __ontimeselected = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._ontimeselected.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOntimeselected(__ontimeselected);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("ontimeselected", this._ontimeselected);
				}
			}
					   		 			 
						if (this._popup != null) {
				if (this._popup.isLiteralText()) {
					try {
												
						Boolean __popup = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._popup.getExpressionString(), 
											Boolean.class);
					
												comp.setPopup(__popup.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("popup", this._popup);
				}
			}
					     		 			 
						if (this._preloadDateRangeBegin != null) {
				if (this._preloadDateRangeBegin.isLiteralText()) {
					try {
												
						java.lang.Object __preloadDateRangeBegin = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._preloadDateRangeBegin.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setPreloadDateRangeBegin(__preloadDateRangeBegin);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("preloadDateRangeBegin", this._preloadDateRangeBegin);
				}
			}
					   		 			 
						if (this._preloadDateRangeEnd != null) {
				if (this._preloadDateRangeEnd.isLiteralText()) {
					try {
												
						java.lang.Object __preloadDateRangeEnd = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._preloadDateRangeEnd.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setPreloadDateRangeEnd(__preloadDateRangeEnd);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("preloadDateRangeEnd", this._preloadDateRangeEnd);
				}
			}
					    		 			 
						if (this._process != null) {
				if (this._process.isLiteralText()) {
					try {
												
						java.lang.Object __process = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._process.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setProcess(__process);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("process", this._process);
				}
			}
					   		 			 
						if (this._reRender != null) {
				if (this._reRender.isLiteralText()) {
					try {
												
						java.lang.Object __reRender = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._reRender.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setReRender(__reRender);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("reRender", this._reRender);
				}
			}
					   		 			 
						if (this._readonly != null) {
				if (this._readonly.isLiteralText()) {
					try {
												
						Boolean __readonly = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._readonly.getExpressionString(), 
											Boolean.class);
					
												comp.setReadonly(__readonly.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("readonly", this._readonly);
				}
			}
					    		 			 
						if (this._requestDelay != null) {
				if (this._requestDelay.isLiteralText()) {
					try {
												
						Integer __requestDelay = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._requestDelay.getExpressionString(), 
											Integer.class);
					
												comp.setRequestDelay(__requestDelay.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("requestDelay", this._requestDelay);
				}
			}
					   		 			 
						if (this._required != null) {
				if (this._required.isLiteralText()) {
					try {
												
						Boolean __required = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._required.getExpressionString(), 
											Boolean.class);
					
												comp.setRequired(__required.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("required", this._required);
				}
			}
					   		 			 
						if (this._requiredMessage != null) {
				if (this._requiredMessage.isLiteralText()) {
					try {
												
						java.lang.String __requiredMessage = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._requiredMessage.getExpressionString(), 
											java.lang.String.class);
					
												comp.setRequiredMessage(__requiredMessage);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("requiredMessage", this._requiredMessage);
				}
			}
					   		 			 
						if (this._resetTimeOnDateSelect != null) {
				if (this._resetTimeOnDateSelect.isLiteralText()) {
					try {
												
						Boolean __resetTimeOnDateSelect = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._resetTimeOnDateSelect.getExpressionString(), 
											Boolean.class);
					
												comp.setResetTimeOnDateSelect(__resetTimeOnDateSelect.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("resetTimeOnDateSelect", this._resetTimeOnDateSelect);
				}
			}
					   		 			 
						if (this._showApplyButton != null) {
				if (this._showApplyButton.isLiteralText()) {
					try {
												
						Boolean __showApplyButton = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._showApplyButton.getExpressionString(), 
											Boolean.class);
					
												comp.setShowApplyButton(__showApplyButton.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("showApplyButton", this._showApplyButton);
				}
			}
					   		 			 
						if (this._showFooter != null) {
				if (this._showFooter.isLiteralText()) {
					try {
												
						Boolean __showFooter = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._showFooter.getExpressionString(), 
											Boolean.class);
					
												comp.setShowFooter(__showFooter.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("showFooter", this._showFooter);
				}
			}
					   		 			 
						if (this._showHeader != null) {
				if (this._showHeader.isLiteralText()) {
					try {
												
						Boolean __showHeader = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._showHeader.getExpressionString(), 
											Boolean.class);
					
												comp.setShowHeader(__showHeader.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("showHeader", this._showHeader);
				}
			}
					   		 			 
						if (this._showInput != null) {
				if (this._showInput.isLiteralText()) {
					try {
												
						Boolean __showInput = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._showInput.getExpressionString(), 
											Boolean.class);
					
												comp.setShowInput(__showInput.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("showInput", this._showInput);
				}
			}
					   		 			 
						if (this._showWeekDaysBar != null) {
				if (this._showWeekDaysBar.isLiteralText()) {
					try {
												
						Boolean __showWeekDaysBar = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._showWeekDaysBar.getExpressionString(), 
											Boolean.class);
					
												comp.setShowWeekDaysBar(__showWeekDaysBar.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("showWeekDaysBar", this._showWeekDaysBar);
				}
			}
					   		 			 
						if (this._showWeeksBar != null) {
				if (this._showWeeksBar.isLiteralText()) {
					try {
												
						Boolean __showWeeksBar = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._showWeeksBar.getExpressionString(), 
											Boolean.class);
					
												comp.setShowWeeksBar(__showWeeksBar.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("showWeeksBar", this._showWeeksBar);
				}
			}
					   		 			 
						if (this._similarityGroupingId != null) {
				if (this._similarityGroupingId.isLiteralText()) {
					try {
												
						java.lang.String __similarityGroupingId = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._similarityGroupingId.getExpressionString(), 
											java.lang.String.class);
					
												comp.setSimilarityGroupingId(__similarityGroupingId);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("similarityGroupingId", this._similarityGroupingId);
				}
			}
					   		 			 
						if (this._status != null) {
				if (this._status.isLiteralText()) {
					try {
												
						java.lang.String __status = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._status.getExpressionString(), 
											java.lang.String.class);
					
												comp.setStatus(__status);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("status", this._status);
				}
			}
					     		 			 
						if (this._tabindex != null) {
				if (this._tabindex.isLiteralText()) {
					try {
												
						java.lang.String __tabindex = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._tabindex.getExpressionString(), 
											java.lang.String.class);
					
												comp.setTabindex(__tabindex);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("tabindex", this._tabindex);
				}
			}
					   		 			 				if(null != this._timeZone && this._timeZone.isLiteralText()){
					throw new IllegalArgumentException("Component org.omidbiz.PersianCalendar with Id " + component.getClientId(getFacesContext()) +" allows only EL expressions for property timeZone");
				}
			 
						if (this._timeZone != null) {
				if (this._timeZone.isLiteralText()) {
					try {
												
						java.util.TimeZone __timeZone = (java.util.TimeZone) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._timeZone.getExpressionString(), 
											java.util.TimeZone.class);
					
												comp.setTimeZone(__timeZone);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("timeZone", this._timeZone);
				}
			}
					   		 			 
						if (this._timeout != null) {
				if (this._timeout.isLiteralText()) {
					try {
												
						Integer __timeout = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._timeout.getExpressionString(), 
											Integer.class);
					
												comp.setTimeout(__timeout.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("timeout", this._timeout);
				}
			}
					   		 			 
						if (this._todayControlMode != null) {
				if (this._todayControlMode.isLiteralText()) {
					try {
												
						java.lang.String __todayControlMode = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._todayControlMode.getExpressionString(), 
											java.lang.String.class);
					
												comp.setTodayControlMode(__todayControlMode);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("todayControlMode", this._todayControlMode);
				}
			}
					     		 			setValidatorProperty(comp, this._validator);
		   		 			 
						if (this._validatorMessage != null) {
				if (this._validatorMessage.isLiteralText()) {
					try {
												
						java.lang.String __validatorMessage = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._validatorMessage.getExpressionString(), 
											java.lang.String.class);
					
												comp.setValidatorMessage(__validatorMessage);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("validatorMessage", this._validatorMessage);
				}
			}
					    		 			 
						if (this._value != null) {
				if (this._value.isLiteralText()) {
					try {
												
						java.lang.Object __value = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._value.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setValue(__value);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("value", this._value);
				}
			}
					   		 			setValueChangeListenerProperty(comp, this._valueChangeListener);
		    		 			 
						if (this._verticalOffset != null) {
				if (this._verticalOffset.isLiteralText()) {
					try {
												
						Integer __verticalOffset = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._verticalOffset.getExpressionString(), 
											Integer.class);
					
												comp.setVerticalOffset(__verticalOffset.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("verticalOffset", this._verticalOffset);
				}
			}
					   		 			 
						if (this._weekDayLabels != null) {
				if (this._weekDayLabels.isLiteralText()) {
					try {
												
						java.lang.Object __weekDayLabels = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._weekDayLabels.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setWeekDayLabels(__weekDayLabels);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("weekDayLabels", this._weekDayLabels);
				}
			}
					   		 			 
						if (this._weekDayLabelsShort != null) {
				if (this._weekDayLabelsShort.isLiteralText()) {
					try {
												
						java.lang.Object __weekDayLabelsShort = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._weekDayLabelsShort.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setWeekDayLabelsShort(__weekDayLabelsShort);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("weekDayLabelsShort", this._weekDayLabelsShort);
				}
			}
					   		 			 
						if (this._zindex != null) {
				if (this._zindex.isLiteralText()) {
					try {
												
						Integer __zindex = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._zindex.getExpressionString(), 
											Integer.class);
					
												comp.setZindex(__zindex.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("zindex", this._zindex);
				}
			}
					     }
	
	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getComponentType()
	 */
	public String getComponentType() {
		// TODO Auto-generated method stub
		return "org.omidbiz.PersianCalendar";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.PersianCalendarRenderer";
			}

}
