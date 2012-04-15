package org.omidbiz.component.html;

import java.util.TimeZone;
import javax.el.ELException;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIPersianCalendar;
import org.omidbiz.model.CalendarDataModel;

public class HtmlPersianCalendar extends UIPersianCalendar{

public static final  String COMPONENT_FAMILY = "org.omidbiz.PersianCalendar";

public static final  String COMPONENT_TYPE = "org.omidbiz.PersianCalendar";

/*
* boolean attribute which provides possibility to limit JSF tree processing(decoding, conversion/validation, value applying) to the component which send the request only.
				Default value is "true"
*/
private  boolean _ajaxSingle = true;

private  boolean _ajaxSingleSet = false;

/*
* This attribute is responsible for behaviour of dates 
				from the previous and next months which are displayed in the current month. Valid values
				are "inactive" (Default) dates inactive and
				gray colored, "scroll" boundaries work as
				month scrolling controls, and "select"
				boundaries work in the same way as "scroll"
				but with the date clicked selection. Default value is "inactive".
*/
private  String _boundaryDatesMode = null;

/*
* Style Class attribute for the popup button
*/
private  String _buttonClass = null;

/*
* Defines icon for the popup button element. The attribute
				is ignored if the "buttonLabel" is set
*/
private  String _buttonIcon = null;

/*
* Defines disabled icon for the popup button element. The
				attribute is ignored if the "buttonLabel" is set
*/
private  String _buttonIconDisabled = null;

/*
* Defines label for the popup button element. If the
				attribute is set "buttonIcon" and "buttonIconDisabled"
				are ignored
*/
private  String _buttonLabel = null;

/*
* If "true", after process validations phase it skips updates of model beans on a force render response. It can be used for validating components input
*/
private  boolean _bypassUpdates = false;

private  boolean _bypassUpdatesSet = false;

/*
* attribute to set fixed cells height
*/
private  String _cellHeight = null;

/*
* attribute to set fixed cells width
*/
private  String _cellWidth = null;

/*
* Defines current date
*/
private  Object _currentDate = null;

/*
* MethodExpression representing an action listener method
				that will be notified after date selection
*/
private  MethodExpression _currentDateChangeListener = null;

/*
* data
*/
private  Object _data = null;

/*
* Used to provide data for calendar elements. If data is
				not provided, all Data Model related functions are
				disabled
*/
private  CalendarDataModel _dataModel = null;

/*
* Defines date pattern. Default value is "MMM d, yyyy".
*/
private  String _datePattern = null;

/*
* Should be binded to some JS function that will provide style classes
				for special sets of days highlighting.
*/
private  String _dayStyleClass = null;

/*
* Defines time that will be used:
			1) to set time when the value is empty
			2) to set time when date changes and flag "resetTimeOnDateSelect" is true. Default value is "getDefaultValueOfDefaultTime()"
*/
private  Object _defaultTime = null;

/*
* Defines direction of the calendar popup ("top-left",
				"top-right", "bottom-left", "bottom-right" (Default), "auto"). Default value is "bottom-right".
*/
private  String _direction = null;

/*
* If "true", rendered is disabled. In
				"popup" mode both controls are disabled. Default value is "false".
*/
private  boolean _disabled = false;

private  boolean _disabledSet = false;

/*
* If "true" calendar input will be editable and
				it will be possible to change the date manualy. If
				"false" value for this attribute makes a text
				field "read-only", so the value can be changed
				only from a handle. Default value is "false".
*/
private  boolean _enableManualInput = false;

private  boolean _enableManualInputSet = false;

/*
* Name of requests queue to avoid send next request before complete other from same event. Can be used to reduce number of requests of frequently events (key press, mouse move etc.)
*/
private  String _eventsQueue = null;

/*
* id of element to set focus after request completed on client side
*/
private  String _focus = null;

/*
* Sets the horizontal offset between button and calendar
				element conjunction point. Default value is "0".
*/
private  int _horizontalOffset = 0;

private  boolean _horizontalOffsetSet = false;

/*
* Attribute allows to ignore an Ajax Response produced by a request if the newest 'similar' request is
in a queue already. ignoreDupResponses="true" does not cancel the request while it is processed on the server,
but just allows to avoid unnecessary updates on the client side if the response isn't actual now
*/
private  boolean _ignoreDupResponses = false;

private  boolean _ignoreDupResponsesSet = false;

/*
* Style Class attribute for the text field
*/
private  String _inputClass = null;

/*
* Defines the size of an input field. Similar to the "size" attribute of &amp;lt;h:inputText/&amp;gt;
*/
private  int _inputSize = Integer.MIN_VALUE;

private  boolean _inputSizeSet = false;

/*
* Style attribute for text field
*/
private  String _inputStyle = null;

/*
* Should be binded to some JS function that returns day state.
*/
private  String _isDayEnabled = null;

/*
* Set the corner of the button for the popup to be
				connected with (top-left, top-right, bottom-left
				(Default), bottom-right, auto). Default value is "bottom-left".
*/
private  String _jointPoint = null;

/*
* A localized user presentable name for this component.
*/
private  String _label = null;

/*
* If "true", then of all AJAX-rendered on the page components only those will be updated, 
		which ID's are passed to the "reRender" attribute of the describable component. 
		"false"-the default value-means that all components with ajaxRendered="true" will be updated.
*/
private  boolean _limitToList = false;

private  boolean _limitToListSet = false;

/*
* Used for locale definition.   Default value is "getDefaultLocale()".
*/
private  Object _locale = null;

/*
* Valid values: ajax or client. Default value is "client".
*/
private  String _mode = null;

/*
* Attribute that allows to customize names of the months.
				Should accept list with the month names
*/
private  Object _monthLabels = null;

/*
* Attribute that allows to customize short names of the
				months. Should accept list with the month names
*/
private  Object _monthLabelsShort = null;

/*
* The client side script method to be called before DOM is updated
*/
private  String _onbeforedomupdate = null;

/*
* The client side script method to be called when the date or time is changed and applied to input
*/
private  String _onchanged = null;

/*
* The client side script method to be called before the calendar popup is closed
*/
private  String _oncollapse = null;

/*
* The client side script method to be called after the request is completed
*/
private  String _oncomplete = null;

/*
* The client side script method to be called when the current month or year is changed
*/
private  String _oncurrentdateselect = null;

/*
* The client side script method to be called after the current month or year is changed
*/
private  String _oncurrentdateselected = null;

/*
* The client side script method to be called when a pointer is moved away from the date cell
*/
private  String _ondatemouseout = null;

/*
* The client side script method to be called when a pointer is moved onto the date cell
*/
private  String _ondatemouseover = null;

/*
* The client side script method to be called when some date cell is selected
*/
private  String _ondateselect = null;

/*
* The client side script method to be called after some date cell is selected
*/
private  String _ondateselected = null;

/*
* The client side script method to be called before the calendar popup is opened
*/
private  String _onexpand = null;

/*
* The client side script method to be called when the input field loses the focus
*/
private  String _oninputblur = null;

/*
* The client side script method to be called when the input field value is changed manually
*/
private  String _oninputchange = null;

/*
* The client side script method to be called when the input field is clicked
*/
private  String _oninputclick = null;

/*
* The client side script method to be called when the input field gets the focus
*/
private  String _oninputfocus = null;

/*
* The client side script method to be called when a key is pressed down in the input field
*/
private  String _oninputkeydown = null;

/*
* The client side script method to be called when a key is pressed and released in the input field
*/
private  String _oninputkeypress = null;

/*
* The client side script method to be called when a key is released in the input field
*/
private  String _oninputkeyup = null;

/*
* The client side script method to be called when a pointer is moved away from the input field
*/
private  String _oninputmouseout = null;

/*
* The client side script method to be called when a pointer is moved onto the input field
*/
private  String _oninputmouseover = null;

/*
* The client side script method to be called when the input field value is selected
*/
private  String _oninputselect = null;

/*
* The client side script method to be called before new time is selected
*/
private  String _ontimeselect = null;

/*
* The client side script method to be called after time is selected
*/
private  String _ontimeselected = null;

/*
* If "true", the calendar will be rendered initially
				as hidden with additional elements for calling as popup. Default value is "true".
*/
private  boolean _popup = true;

private  boolean _popupSet = false;

/*
* Define the initial range of date which will be loaded to
				client from dataModel under rendering. Default value is "getDefaultPreloadBegin(getCurrentDateOrDefault())".
*/
private  Object _preloadDateRangeBegin = null;

/*
* Defines the last range of date which will be loaded to
				client from dataModel under rendering. Default value is "getDefaultPreloadEnd(getCurrentDateOrDefault())".
*/
private  Object _preloadDateRangeEnd = null;

/*
* Id['s] (in format of call  UIComponent.findComponent()) of components, processed at the phases 2-5 in case of AjaxRequest  caused by this component. Can be single id, comma-separated list of Id's, or EL Expression  with array or Collection
*/
private  Object _process = null;

/*
* Id['s] (in format of call  UIComponent.findComponent()) of components, rendered in case of AjaxRequest  caused by this component. Can be single id, comma-separated list of Id's, or EL Expression  with array or Collection
*/
private  Object _reRender = null;

/*
* If "true". Date and time are not selectable.  In
				"popup" mode input is disabled and button is enabled. Default value is "false".
*/
private  boolean _readonly = false;

private  boolean _readonlySet = false;

/*
* Attribute defines the time (in ms.) that the request will be wait in the queue before it is ready to send.
When the delay time is over, the request will be sent to the server or removed if the newest 'similar' request is in a queue already
*/
private  int _requestDelay = Integer.MIN_VALUE;

private  boolean _requestDelaySet = false;

/*
* If value is true then calendar should change time to defaultTime for newly-selected dates. Default value is "false"
*/
private  boolean _resetTimeOnDateSelect = false;

private  boolean _resetTimeOnDateSelectSet = false;

/*
* If false ApplyButton should not be shown. Default value is "false".
*/
private  boolean _showApplyButton = false;

private  boolean _showApplyButtonSet = false;

/*
* If false Calendar's footer should not be shown. Default value is "true".
*/
private  boolean _showFooter = true;

private  boolean _showFooterSet = false;

/*
* If false Calendar's header should not be shown. Default value is "true".
*/
private  boolean _showHeader = true;

private  boolean _showHeaderSet = false;

/*
* "false" value for this attribute makes text
				field invisible. It works only if popupMode="true"
				If showInput is "true" - input field will
				be shown. Default value is "true".
*/
private  boolean _showInput = true;

private  boolean _showInputSet = false;

/*
* If false this bar should not be shown. Default value is "true".
*/
private  boolean _showWeekDaysBar = true;

private  boolean _showWeekDaysBarSet = false;

/*
* If false this bar should not be shown. Default value is "true".
*/
private  boolean _showWeeksBar = true;

private  boolean _showWeeksBarSet = false;

/*
* If there are any component requests with identical IDs then these requests will be grouped.
*/
private  String _similarityGroupingId = null;

/*
* ID (in format of call UIComponent.findComponent()) of Request status component
*/
private  String _status = null;

/*
* CSS style(s) is/are to be applied when this component is
				rendered
*/
private  String _style = null;

/*
* Corresponds to the HTML class attribute
*/
private  String _styleClass = null;

/*
* This attribute specifies the position of the current element in the tabbing order for the current document. This value must be a number between 0 and 32767. User agents should ignore leading zeros
*/
private  String _tabindex = null;

/*
* Used for current date calculations. Default value is "getDefaultTimeZone()".
*/
private  TimeZone _timeZone = null;

/*
* Response waiting time on a particular request. If a response is not received during this time, the request is aborted
*/
private  int _timeout = Integer.MIN_VALUE;

private  boolean _timeoutSet = false;

/*
* This attribute defines the mode for "today" control. Possible values are "scroll", "select", "hidden". Default value is "select".
*/
private  String _todayControlMode = null;

/*
* Used to specify mode to load tooltips. Valid values are
				"none", "single" and
				"batch" Default value is "batch".
*/
private  String _toolTipMode = null;

/*
* Sets the vertical offset between button and calendar
				element conjunction point. Default value is "0".
*/
private  int _verticalOffset = 0;

private  boolean _verticalOffsetSet = false;

/*
* List of the day names displays on the days bar in the
				following way "Sun, Mon, Tue, Wed, "
*/
private  Object _weekDayLabels = null;

/*
* Attribute that allows to customize short names of the
				weeks. Should accept list with the weeks names.
*/
private  Object _weekDayLabelsShort = null;

/*
* Attribute is similar to the standard HTML attribute and
				can specify window placement relative to the content. Default value is "3".
*/
private  int _zindex = 3;

private  boolean _zindexSet = false;


public HtmlPersianCalendar(){
setRendererType("org.omidbiz.PersianCalendarRenderer");
}

public boolean isAjaxSingle(){
	if (this._ajaxSingleSet) {
	    return (this._ajaxSingle);
	}
	ValueExpression ve = getValueExpression("ajaxSingle");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._ajaxSingle);
	    }
	    
	    return value;
	} else {
	    return (this._ajaxSingle);
	}

}

public void setAjaxSingle(boolean _ajaxSingle){
this._ajaxSingle = _ajaxSingle;
this._ajaxSingleSet = true;
}

public String getBoundaryDatesMode(){
	if (this._boundaryDatesMode != null) {
		return this._boundaryDatesMode;
	}
	ValueExpression ve = getValueExpression("boundaryDatesMode");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "inactive";
	

}

public void setBoundaryDatesMode(String _boundaryDatesMode){
this._boundaryDatesMode = _boundaryDatesMode;
}

public String getButtonClass(){
	if (this._buttonClass != null) {
		return this._buttonClass;
	}
	ValueExpression ve = getValueExpression("buttonClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setButtonClass(String _buttonClass){
this._buttonClass = _buttonClass;
}

public String getButtonIcon(){
	if (this._buttonIcon != null) {
		return this._buttonIcon;
	}
	ValueExpression ve = getValueExpression("buttonIcon");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setButtonIcon(String _buttonIcon){
this._buttonIcon = _buttonIcon;
}

public String getButtonIconDisabled(){
	if (this._buttonIconDisabled != null) {
		return this._buttonIconDisabled;
	}
	ValueExpression ve = getValueExpression("buttonIconDisabled");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setButtonIconDisabled(String _buttonIconDisabled){
this._buttonIconDisabled = _buttonIconDisabled;
}

public String getButtonLabel(){
	if (this._buttonLabel != null) {
		return this._buttonLabel;
	}
	ValueExpression ve = getValueExpression("buttonLabel");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setButtonLabel(String _buttonLabel){
this._buttonLabel = _buttonLabel;
}

public boolean isBypassUpdates(){
	if (this._bypassUpdatesSet) {
	    return (this._bypassUpdates);
	}
	ValueExpression ve = getValueExpression("bypassUpdates");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._bypassUpdates);
	    }
	    
	    return value;
	} else {
	    return (this._bypassUpdates);
	}

}

public void setBypassUpdates(boolean _bypassUpdates){
this._bypassUpdates = _bypassUpdates;
this._bypassUpdatesSet = true;
}

public String getCellHeight(){
	if (this._cellHeight != null) {
		return this._cellHeight;
	}
	ValueExpression ve = getValueExpression("cellHeight");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setCellHeight(String _cellHeight){
this._cellHeight = _cellHeight;
}

public String getCellWidth(){
	if (this._cellWidth != null) {
		return this._cellWidth;
	}
	ValueExpression ve = getValueExpression("cellWidth");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setCellWidth(String _cellWidth){
this._cellWidth = _cellWidth;
}

public Object getCurrentDate(){
	if (this._currentDate != null) {
		return this._currentDate;
	}
	ValueExpression ve = getValueExpression("currentDate");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setCurrentDate(Object _currentDate){
this._currentDate = _currentDate;
}

public MethodExpression getCurrentDateChangeListener(){
	if (this._currentDateChangeListener != null) {
		return this._currentDateChangeListener;
	}
	ValueExpression ve = getValueExpression("currentDateChangeListener");
	if (ve != null) {
	    MethodExpression value = null;
	    
	    try {
			value = (MethodExpression) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setCurrentDateChangeListener(MethodExpression _currentDateChangeListener){
this._currentDateChangeListener = _currentDateChangeListener;
}

public Object getData(){
	if (this._data != null) {
		return this._data;
	}
	ValueExpression ve = getValueExpression("data");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setData(Object _data){
this._data = _data;
}

public CalendarDataModel getDataModel(){
	if (this._dataModel != null) {
		return this._dataModel;
	}
	ValueExpression ve = getValueExpression("dataModel");
	if (ve != null) {
	    CalendarDataModel value = null;
	    
	    try {
			value = (CalendarDataModel) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setDataModel(CalendarDataModel _dataModel){
this._dataModel = _dataModel;
}

public String getDatePattern(){
	if (this._datePattern != null) {
		return this._datePattern;
	}
	ValueExpression ve = getValueExpression("datePattern");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "MMM d, yyyy";
	

}

public void setDatePattern(String _datePattern){
this._datePattern = _datePattern;
}

public String getDayStyleClass(){
	if (this._dayStyleClass != null) {
		return this._dayStyleClass;
	}
	ValueExpression ve = getValueExpression("dayStyleClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setDayStyleClass(String _dayStyleClass){
this._dayStyleClass = _dayStyleClass;
}

public Object getDefaultTime(){
	if (this._defaultTime != null) {
		return this._defaultTime;
	}
	ValueExpression ve = getValueExpression("defaultTime");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return getDefaultValueOfDefaultTime();
	

}

public void setDefaultTime(Object _defaultTime){
this._defaultTime = _defaultTime;
}

public String getDirection(){
	if (this._direction != null) {
		return this._direction;
	}
	ValueExpression ve = getValueExpression("direction");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "bottom-right";
	

}

public void setDirection(String _direction){
this._direction = _direction;
}

public boolean isDisabled(){
	if (this._disabledSet) {
	    return (this._disabled);
	}
	ValueExpression ve = getValueExpression("disabled");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._disabled);
	    }
	    
	    return value;
	} else {
	    return (this._disabled);
	}

}

public void setDisabled(boolean _disabled){
this._disabled = _disabled;
this._disabledSet = true;
}

public boolean isEnableManualInput(){
	if (this._enableManualInputSet) {
	    return (this._enableManualInput);
	}
	ValueExpression ve = getValueExpression("enableManualInput");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._enableManualInput);
	    }
	    
	    return value;
	} else {
	    return (this._enableManualInput);
	}

}

public void setEnableManualInput(boolean _enableManualInput){
this._enableManualInput = _enableManualInput;
this._enableManualInputSet = true;
}

public String getEventsQueue(){
	if (this._eventsQueue != null) {
		return this._eventsQueue;
	}
	ValueExpression ve = getValueExpression("eventsQueue");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setEventsQueue(String _eventsQueue){
this._eventsQueue = _eventsQueue;
}

public String getFocus(){
	if (this._focus != null) {
		return this._focus;
	}
	ValueExpression ve = getValueExpression("focus");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setFocus(String _focus){
this._focus = _focus;
}

public int getHorizontalOffset(){
	if (this._horizontalOffsetSet) {
	    return (this._horizontalOffset);
	}
	ValueExpression ve = getValueExpression("horizontalOffset");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._horizontalOffset);
	    }
	    
	    return value;
	} else {
	    return (this._horizontalOffset);
	}

}

public void setHorizontalOffset(int _horizontalOffset){
this._horizontalOffset = _horizontalOffset;
this._horizontalOffsetSet = true;
}

public boolean isIgnoreDupResponses(){
	if (this._ignoreDupResponsesSet) {
	    return (this._ignoreDupResponses);
	}
	ValueExpression ve = getValueExpression("ignoreDupResponses");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._ignoreDupResponses);
	    }
	    
	    return value;
	} else {
	    return (this._ignoreDupResponses);
	}

}

public void setIgnoreDupResponses(boolean _ignoreDupResponses){
this._ignoreDupResponses = _ignoreDupResponses;
this._ignoreDupResponsesSet = true;
}

public String getInputClass(){
	if (this._inputClass != null) {
		return this._inputClass;
	}
	ValueExpression ve = getValueExpression("inputClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setInputClass(String _inputClass){
this._inputClass = _inputClass;
}

public int getInputSize(){
	if (this._inputSizeSet) {
	    return (this._inputSize);
	}
	ValueExpression ve = getValueExpression("inputSize");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._inputSize);
	    }
	    
	    return value;
	} else {
	    return (this._inputSize);
	}

}

public void setInputSize(int _inputSize){
this._inputSize = _inputSize;
this._inputSizeSet = true;
}

public String getInputStyle(){
	if (this._inputStyle != null) {
		return this._inputStyle;
	}
	ValueExpression ve = getValueExpression("inputStyle");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setInputStyle(String _inputStyle){
this._inputStyle = _inputStyle;
}

public String getIsDayEnabled(){
	if (this._isDayEnabled != null) {
		return this._isDayEnabled;
	}
	ValueExpression ve = getValueExpression("isDayEnabled");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setIsDayEnabled(String _isDayEnabled){
this._isDayEnabled = _isDayEnabled;
}

public String getJointPoint(){
	if (this._jointPoint != null) {
		return this._jointPoint;
	}
	ValueExpression ve = getValueExpression("jointPoint");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "bottom-left";
	

}

public void setJointPoint(String _jointPoint){
this._jointPoint = _jointPoint;
}

public String getLabel(){
	if (this._label != null) {
		return this._label;
	}
	ValueExpression ve = getValueExpression("label");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setLabel(String _label){
this._label = _label;
}

public boolean isLimitToList(){
	if (this._limitToListSet) {
	    return (this._limitToList);
	}
	ValueExpression ve = getValueExpression("limitToList");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._limitToList);
	    }
	    
	    return value;
	} else {
	    return (this._limitToList);
	}

}

public void setLimitToList(boolean _limitToList){
this._limitToList = _limitToList;
this._limitToListSet = true;
}

public Object getLocale(){
	if (this._locale != null) {
		return this._locale;
	}
	ValueExpression ve = getValueExpression("locale");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return getDefaultLocale();
	

}

public void setLocale(Object _locale){
this._locale = _locale;
}

public String getMode(){
	if (this._mode != null) {
		return this._mode;
	}
	ValueExpression ve = getValueExpression("mode");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return UIPersianCalendar.CLIENT_MODE;
	

}

public void setMode(String _mode){
this._mode = _mode;
}

public Object getMonthLabels(){
	if (this._monthLabels != null) {
		return this._monthLabels;
	}
	ValueExpression ve = getValueExpression("monthLabels");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setMonthLabels(Object _monthLabels){
this._monthLabels = _monthLabels;
}

public Object getMonthLabelsShort(){
	if (this._monthLabelsShort != null) {
		return this._monthLabelsShort;
	}
	ValueExpression ve = getValueExpression("monthLabelsShort");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setMonthLabelsShort(Object _monthLabelsShort){
this._monthLabelsShort = _monthLabelsShort;
}

public String getOnbeforedomupdate(){
	if (this._onbeforedomupdate != null) {
		return this._onbeforedomupdate;
	}
	ValueExpression ve = getValueExpression("onbeforedomupdate");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnbeforedomupdate(String _onbeforedomupdate){
this._onbeforedomupdate = _onbeforedomupdate;
}

public String getOnchanged(){
	if (this._onchanged != null) {
		return this._onchanged;
	}
	ValueExpression ve = getValueExpression("onchanged");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnchanged(String _onchanged){
this._onchanged = _onchanged;
}

public String getOncollapse(){
	if (this._oncollapse != null) {
		return this._oncollapse;
	}
	ValueExpression ve = getValueExpression("oncollapse");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOncollapse(String _oncollapse){
this._oncollapse = _oncollapse;
}

public String getOncomplete(){
	if (this._oncomplete != null) {
		return this._oncomplete;
	}
	ValueExpression ve = getValueExpression("oncomplete");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOncomplete(String _oncomplete){
this._oncomplete = _oncomplete;
}

public String getOncurrentdateselect(){
	if (this._oncurrentdateselect != null) {
		return this._oncurrentdateselect;
	}
	ValueExpression ve = getValueExpression("oncurrentdateselect");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOncurrentdateselect(String _oncurrentdateselect){
this._oncurrentdateselect = _oncurrentdateselect;
}

public String getOncurrentdateselected(){
	if (this._oncurrentdateselected != null) {
		return this._oncurrentdateselected;
	}
	ValueExpression ve = getValueExpression("oncurrentdateselected");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOncurrentdateselected(String _oncurrentdateselected){
this._oncurrentdateselected = _oncurrentdateselected;
}

public String getOndatemouseout(){
	if (this._ondatemouseout != null) {
		return this._ondatemouseout;
	}
	ValueExpression ve = getValueExpression("ondatemouseout");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOndatemouseout(String _ondatemouseout){
this._ondatemouseout = _ondatemouseout;
}

public String getOndatemouseover(){
	if (this._ondatemouseover != null) {
		return this._ondatemouseover;
	}
	ValueExpression ve = getValueExpression("ondatemouseover");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOndatemouseover(String _ondatemouseover){
this._ondatemouseover = _ondatemouseover;
}

public String getOndateselect(){
	if (this._ondateselect != null) {
		return this._ondateselect;
	}
	ValueExpression ve = getValueExpression("ondateselect");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOndateselect(String _ondateselect){
this._ondateselect = _ondateselect;
}

public String getOndateselected(){
	if (this._ondateselected != null) {
		return this._ondateselected;
	}
	ValueExpression ve = getValueExpression("ondateselected");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOndateselected(String _ondateselected){
this._ondateselected = _ondateselected;
}

public String getOnexpand(){
	if (this._onexpand != null) {
		return this._onexpand;
	}
	ValueExpression ve = getValueExpression("onexpand");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnexpand(String _onexpand){
this._onexpand = _onexpand;
}

public String getOninputblur(){
	if (this._oninputblur != null) {
		return this._oninputblur;
	}
	ValueExpression ve = getValueExpression("oninputblur");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputblur(String _oninputblur){
this._oninputblur = _oninputblur;
}

public String getOninputchange(){
	if (this._oninputchange != null) {
		return this._oninputchange;
	}
	ValueExpression ve = getValueExpression("oninputchange");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputchange(String _oninputchange){
this._oninputchange = _oninputchange;
}

public String getOninputclick(){
	if (this._oninputclick != null) {
		return this._oninputclick;
	}
	ValueExpression ve = getValueExpression("oninputclick");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputclick(String _oninputclick){
this._oninputclick = _oninputclick;
}

public String getOninputfocus(){
	if (this._oninputfocus != null) {
		return this._oninputfocus;
	}
	ValueExpression ve = getValueExpression("oninputfocus");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputfocus(String _oninputfocus){
this._oninputfocus = _oninputfocus;
}

public String getOninputkeydown(){
	if (this._oninputkeydown != null) {
		return this._oninputkeydown;
	}
	ValueExpression ve = getValueExpression("oninputkeydown");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputkeydown(String _oninputkeydown){
this._oninputkeydown = _oninputkeydown;
}

public String getOninputkeypress(){
	if (this._oninputkeypress != null) {
		return this._oninputkeypress;
	}
	ValueExpression ve = getValueExpression("oninputkeypress");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputkeypress(String _oninputkeypress){
this._oninputkeypress = _oninputkeypress;
}

public String getOninputkeyup(){
	if (this._oninputkeyup != null) {
		return this._oninputkeyup;
	}
	ValueExpression ve = getValueExpression("oninputkeyup");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputkeyup(String _oninputkeyup){
this._oninputkeyup = _oninputkeyup;
}

public String getOninputmouseout(){
	if (this._oninputmouseout != null) {
		return this._oninputmouseout;
	}
	ValueExpression ve = getValueExpression("oninputmouseout");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputmouseout(String _oninputmouseout){
this._oninputmouseout = _oninputmouseout;
}

public String getOninputmouseover(){
	if (this._oninputmouseover != null) {
		return this._oninputmouseover;
	}
	ValueExpression ve = getValueExpression("oninputmouseover");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputmouseover(String _oninputmouseover){
this._oninputmouseover = _oninputmouseover;
}

public String getOninputselect(){
	if (this._oninputselect != null) {
		return this._oninputselect;
	}
	ValueExpression ve = getValueExpression("oninputselect");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOninputselect(String _oninputselect){
this._oninputselect = _oninputselect;
}

public String getOntimeselect(){
	if (this._ontimeselect != null) {
		return this._ontimeselect;
	}
	ValueExpression ve = getValueExpression("ontimeselect");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOntimeselect(String _ontimeselect){
this._ontimeselect = _ontimeselect;
}

public String getOntimeselected(){
	if (this._ontimeselected != null) {
		return this._ontimeselected;
	}
	ValueExpression ve = getValueExpression("ontimeselected");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOntimeselected(String _ontimeselected){
this._ontimeselected = _ontimeselected;
}

public boolean isPopup(){
	if (this._popupSet) {
	    return (this._popup);
	}
	ValueExpression ve = getValueExpression("popup");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._popup);
	    }
	    
	    return value;
	} else {
	    return (this._popup);
	}

}

public void setPopup(boolean _popup){
this._popup = _popup;
this._popupSet = true;
}

public Object getPreloadDateRangeBegin(){
	if (this._preloadDateRangeBegin != null) {
		return this._preloadDateRangeBegin;
	}
	ValueExpression ve = getValueExpression("preloadDateRangeBegin");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return getDefaultPreloadBegin(getCurrentDateOrDefault());
	

}

public void setPreloadDateRangeBegin(Object _preloadDateRangeBegin){
this._preloadDateRangeBegin = _preloadDateRangeBegin;
}

public Object getPreloadDateRangeEnd(){
	if (this._preloadDateRangeEnd != null) {
		return this._preloadDateRangeEnd;
	}
	ValueExpression ve = getValueExpression("preloadDateRangeEnd");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return getDefaultPreloadEnd(getCurrentDateOrDefault());
	

}

public void setPreloadDateRangeEnd(Object _preloadDateRangeEnd){
this._preloadDateRangeEnd = _preloadDateRangeEnd;
}

public Object getProcess(){
	if (this._process != null) {
		return this._process;
	}
	ValueExpression ve = getValueExpression("process");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setProcess(Object _process){
this._process = _process;
}

public Object getReRender(){
	if (this._reRender != null) {
		return this._reRender;
	}
	ValueExpression ve = getValueExpression("reRender");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setReRender(Object _reRender){
this._reRender = _reRender;
}

public boolean isReadonly(){
	if (this._readonlySet) {
	    return (this._readonly);
	}
	ValueExpression ve = getValueExpression("readonly");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._readonly);
	    }
	    
	    return value;
	} else {
	    return (this._readonly);
	}

}

public void setReadonly(boolean _readonly){
this._readonly = _readonly;
this._readonlySet = true;
}

public int getRequestDelay(){
	if (this._requestDelaySet) {
	    return (this._requestDelay);
	}
	ValueExpression ve = getValueExpression("requestDelay");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._requestDelay);
	    }
	    
	    return value;
	} else {
	    return (this._requestDelay);
	}

}

public void setRequestDelay(int _requestDelay){
this._requestDelay = _requestDelay;
this._requestDelaySet = true;
}

public boolean isResetTimeOnDateSelect(){
	if (this._resetTimeOnDateSelectSet) {
	    return (this._resetTimeOnDateSelect);
	}
	ValueExpression ve = getValueExpression("resetTimeOnDateSelect");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._resetTimeOnDateSelect);
	    }
	    
	    return value;
	} else {
	    return (this._resetTimeOnDateSelect);
	}

}

public void setResetTimeOnDateSelect(boolean _resetTimeOnDateSelect){
this._resetTimeOnDateSelect = _resetTimeOnDateSelect;
this._resetTimeOnDateSelectSet = true;
}

public boolean isShowApplyButton(){
	if (this._showApplyButtonSet) {
	    return (this._showApplyButton);
	}
	ValueExpression ve = getValueExpression("showApplyButton");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._showApplyButton);
	    }
	    
	    return value;
	} else {
	    return (this._showApplyButton);
	}

}

public void setShowApplyButton(boolean _showApplyButton){
this._showApplyButton = _showApplyButton;
this._showApplyButtonSet = true;
}

public boolean isShowFooter(){
	if (this._showFooterSet) {
	    return (this._showFooter);
	}
	ValueExpression ve = getValueExpression("showFooter");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._showFooter);
	    }
	    
	    return value;
	} else {
	    return (this._showFooter);
	}

}

public void setShowFooter(boolean _showFooter){
this._showFooter = _showFooter;
this._showFooterSet = true;
}

public boolean isShowHeader(){
	if (this._showHeaderSet) {
	    return (this._showHeader);
	}
	ValueExpression ve = getValueExpression("showHeader");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._showHeader);
	    }
	    
	    return value;
	} else {
	    return (this._showHeader);
	}

}

public void setShowHeader(boolean _showHeader){
this._showHeader = _showHeader;
this._showHeaderSet = true;
}

public boolean isShowInput(){
	if (this._showInputSet) {
	    return (this._showInput);
	}
	ValueExpression ve = getValueExpression("showInput");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._showInput);
	    }
	    
	    return value;
	} else {
	    return (this._showInput);
	}

}

public void setShowInput(boolean _showInput){
this._showInput = _showInput;
this._showInputSet = true;
}

public boolean isShowWeekDaysBar(){
	if (this._showWeekDaysBarSet) {
	    return (this._showWeekDaysBar);
	}
	ValueExpression ve = getValueExpression("showWeekDaysBar");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._showWeekDaysBar);
	    }
	    
	    return value;
	} else {
	    return (this._showWeekDaysBar);
	}

}

public void setShowWeekDaysBar(boolean _showWeekDaysBar){
this._showWeekDaysBar = _showWeekDaysBar;
this._showWeekDaysBarSet = true;
}

public boolean isShowWeeksBar(){
	if (this._showWeeksBarSet) {
	    return (this._showWeeksBar);
	}
	ValueExpression ve = getValueExpression("showWeeksBar");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._showWeeksBar);
	    }
	    
	    return value;
	} else {
	    return (this._showWeeksBar);
	}

}

public void setShowWeeksBar(boolean _showWeeksBar){
this._showWeeksBar = _showWeeksBar;
this._showWeeksBarSet = true;
}

public String getSimilarityGroupingId(){
	if (this._similarityGroupingId != null) {
		return this._similarityGroupingId;
	}
	ValueExpression ve = getValueExpression("similarityGroupingId");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setSimilarityGroupingId(String _similarityGroupingId){
this._similarityGroupingId = _similarityGroupingId;
}

public String getStatus(){
	if (this._status != null) {
		return this._status;
	}
	ValueExpression ve = getValueExpression("status");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setStatus(String _status){
this._status = _status;
}

public String getStyle(){
	if (this._style != null) {
		return this._style;
	}
	ValueExpression ve = getValueExpression("style");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setStyle(String _style){
this._style = _style;
}

public String getStyleClass(){
	if (this._styleClass != null) {
		return this._styleClass;
	}
	ValueExpression ve = getValueExpression("styleClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setStyleClass(String _styleClass){
this._styleClass = _styleClass;
}

public String getTabindex(){
	if (this._tabindex != null) {
		return this._tabindex;
	}
	ValueExpression ve = getValueExpression("tabindex");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setTabindex(String _tabindex){
this._tabindex = _tabindex;
}

public TimeZone getTimeZone(){
	if (this._timeZone != null) {
		return this._timeZone;
	}
	ValueExpression ve = getValueExpression("timeZone");
	if (ve != null) {
	    TimeZone value = null;
	    
	    try {
			value = (TimeZone) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return getDefaultTimeZone();
	

}

public void setTimeZone(TimeZone _timeZone){
this._timeZone = _timeZone;
}

public int getTimeout(){
	if (this._timeoutSet) {
	    return (this._timeout);
	}
	ValueExpression ve = getValueExpression("timeout");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._timeout);
	    }
	    
	    return value;
	} else {
	    return (this._timeout);
	}

}

public void setTimeout(int _timeout){
this._timeout = _timeout;
this._timeoutSet = true;
}

public String getTodayControlMode(){
	if (this._todayControlMode != null) {
		return this._todayControlMode;
	}
	ValueExpression ve = getValueExpression("todayControlMode");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "select";
	

}

public void setTodayControlMode(String _todayControlMode){
this._todayControlMode = _todayControlMode;
}

public String getToolTipMode(){
	if (this._toolTipMode != null) {
		return this._toolTipMode;
	}
	ValueExpression ve = getValueExpression("toolTipMode");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "batch";
	

}

public void setToolTipMode(String _toolTipMode){
this._toolTipMode = _toolTipMode;
}

public int getVerticalOffset(){
	if (this._verticalOffsetSet) {
	    return (this._verticalOffset);
	}
	ValueExpression ve = getValueExpression("verticalOffset");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._verticalOffset);
	    }
	    
	    return value;
	} else {
	    return (this._verticalOffset);
	}

}

public void setVerticalOffset(int _verticalOffset){
this._verticalOffset = _verticalOffset;
this._verticalOffsetSet = true;
}

public Object getWeekDayLabels(){
	if (this._weekDayLabels != null) {
		return this._weekDayLabels;
	}
	ValueExpression ve = getValueExpression("weekDayLabels");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setWeekDayLabels(Object _weekDayLabels){
this._weekDayLabels = _weekDayLabels;
}

public Object getWeekDayLabelsShort(){
	if (this._weekDayLabelsShort != null) {
		return this._weekDayLabelsShort;
	}
	ValueExpression ve = getValueExpression("weekDayLabelsShort");
	if (ve != null) {
	    Object value = null;
	    
	    try {
			value = (Object) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setWeekDayLabelsShort(Object _weekDayLabelsShort){
this._weekDayLabelsShort = _weekDayLabelsShort;
}

public int getZindex(){
	if (this._zindexSet) {
	    return (this._zindex);
	}
	ValueExpression ve = getValueExpression("zindex");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._zindex);
	    }
	    
	    return value;
	} else {
	    return (this._zindex);
	}

}

public void setZindex(int _zindex){
this._zindex = _zindex;
this._zindexSet = true;
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[106];
state[0] = super.saveState(context);
state[1] = Boolean.valueOf(_ajaxSingle);
state[2] = Boolean.valueOf(_ajaxSingleSet);
state[3] = _boundaryDatesMode;
state[4] = _buttonClass;
state[5] = _buttonIcon;
state[6] = _buttonIconDisabled;
state[7] = _buttonLabel;
state[8] = Boolean.valueOf(_bypassUpdates);
state[9] = Boolean.valueOf(_bypassUpdatesSet);
state[10] = _cellHeight;
state[11] = _cellWidth;
state[12] = saveAttachedState(context, _currentDate);
state[13] = saveAttachedState(context, _currentDateChangeListener);
state[14] = saveAttachedState(context, _data);
state[15] = saveAttachedState(context, _dataModel);
state[16] = _datePattern;
state[17] = _dayStyleClass;
state[18] = saveAttachedState(context, _defaultTime);
state[19] = _direction;
state[20] = Boolean.valueOf(_disabled);
state[21] = Boolean.valueOf(_disabledSet);
state[22] = Boolean.valueOf(_enableManualInput);
state[23] = Boolean.valueOf(_enableManualInputSet);
state[24] = _eventsQueue;
state[25] = _focus;
state[26] = Integer.valueOf(_horizontalOffset);
state[27] = Boolean.valueOf(_horizontalOffsetSet);
state[28] = Boolean.valueOf(_ignoreDupResponses);
state[29] = Boolean.valueOf(_ignoreDupResponsesSet);
state[30] = _inputClass;
state[31] = Integer.valueOf(_inputSize);
state[32] = Boolean.valueOf(_inputSizeSet);
state[33] = _inputStyle;
state[34] = _isDayEnabled;
state[35] = _jointPoint;
state[36] = _label;
state[37] = Boolean.valueOf(_limitToList);
state[38] = Boolean.valueOf(_limitToListSet);
state[39] = saveAttachedState(context, _locale);
state[40] = _mode;
state[41] = saveAttachedState(context, _monthLabels);
state[42] = saveAttachedState(context, _monthLabelsShort);
state[43] = _onbeforedomupdate;
state[44] = _onchanged;
state[45] = _oncollapse;
state[46] = _oncomplete;
state[47] = _oncurrentdateselect;
state[48] = _oncurrentdateselected;
state[49] = _ondatemouseout;
state[50] = _ondatemouseover;
state[51] = _ondateselect;
state[52] = _ondateselected;
state[53] = _onexpand;
state[54] = _oninputblur;
state[55] = _oninputchange;
state[56] = _oninputclick;
state[57] = _oninputfocus;
state[58] = _oninputkeydown;
state[59] = _oninputkeypress;
state[60] = _oninputkeyup;
state[61] = _oninputmouseout;
state[62] = _oninputmouseover;
state[63] = _oninputselect;
state[64] = _ontimeselect;
state[65] = _ontimeselected;
state[66] = Boolean.valueOf(_popup);
state[67] = Boolean.valueOf(_popupSet);
state[68] = saveAttachedState(context, _preloadDateRangeBegin);
state[69] = saveAttachedState(context, _preloadDateRangeEnd);
state[70] = saveAttachedState(context, _process);
state[71] = saveAttachedState(context, _reRender);
state[72] = Boolean.valueOf(_readonly);
state[73] = Boolean.valueOf(_readonlySet);
state[74] = Integer.valueOf(_requestDelay);
state[75] = Boolean.valueOf(_requestDelaySet);
state[76] = Boolean.valueOf(_resetTimeOnDateSelect);
state[77] = Boolean.valueOf(_resetTimeOnDateSelectSet);
state[78] = Boolean.valueOf(_showApplyButton);
state[79] = Boolean.valueOf(_showApplyButtonSet);
state[80] = Boolean.valueOf(_showFooter);
state[81] = Boolean.valueOf(_showFooterSet);
state[82] = Boolean.valueOf(_showHeader);
state[83] = Boolean.valueOf(_showHeaderSet);
state[84] = Boolean.valueOf(_showInput);
state[85] = Boolean.valueOf(_showInputSet);
state[86] = Boolean.valueOf(_showWeekDaysBar);
state[87] = Boolean.valueOf(_showWeekDaysBarSet);
state[88] = Boolean.valueOf(_showWeeksBar);
state[89] = Boolean.valueOf(_showWeeksBarSet);
state[90] = _similarityGroupingId;
state[91] = _status;
state[92] = _style;
state[93] = _styleClass;
state[94] = _tabindex;
state[95] = saveAttachedState(context, _timeZone);
state[96] = Integer.valueOf(_timeout);
state[97] = Boolean.valueOf(_timeoutSet);
state[98] = _todayControlMode;
state[99] = _toolTipMode;
state[100] = Integer.valueOf(_verticalOffset);
state[101] = Boolean.valueOf(_verticalOffsetSet);
state[102] = saveAttachedState(context, _weekDayLabels);
state[103] = saveAttachedState(context, _weekDayLabelsShort);
state[104] = Integer.valueOf(_zindex);
state[105] = Boolean.valueOf(_zindexSet);
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_ajaxSingle = ((Boolean)states[1]).booleanValue();
		_ajaxSingleSet = ((Boolean)states[2]).booleanValue();
		_boundaryDatesMode = (String)states[3];;
		_buttonClass = (String)states[4];;
		_buttonIcon = (String)states[5];;
		_buttonIconDisabled = (String)states[6];;
		_buttonLabel = (String)states[7];;
		_bypassUpdates = ((Boolean)states[8]).booleanValue();
		_bypassUpdatesSet = ((Boolean)states[9]).booleanValue();
		_cellHeight = (String)states[10];;
		_cellWidth = (String)states[11];;
		_currentDate = (Object)restoreAttachedState(context, states[12]);
		_currentDateChangeListener = (MethodExpression)restoreAttachedState(context, states[13]);
		_data = (Object)restoreAttachedState(context, states[14]);
		_dataModel = (CalendarDataModel)restoreAttachedState(context, states[15]);
		_datePattern = (String)states[16];;
		_dayStyleClass = (String)states[17];;
		_defaultTime = (Object)restoreAttachedState(context, states[18]);
		_direction = (String)states[19];;
		_disabled = ((Boolean)states[20]).booleanValue();
		_disabledSet = ((Boolean)states[21]).booleanValue();
		_enableManualInput = ((Boolean)states[22]).booleanValue();
		_enableManualInputSet = ((Boolean)states[23]).booleanValue();
		_eventsQueue = (String)states[24];;
		_focus = (String)states[25];;
		_horizontalOffset = ((Integer)states[26]).intValue();
		_horizontalOffsetSet = ((Boolean)states[27]).booleanValue();
		_ignoreDupResponses = ((Boolean)states[28]).booleanValue();
		_ignoreDupResponsesSet = ((Boolean)states[29]).booleanValue();
		_inputClass = (String)states[30];;
		_inputSize = ((Integer)states[31]).intValue();
		_inputSizeSet = ((Boolean)states[32]).booleanValue();
		_inputStyle = (String)states[33];;
		_isDayEnabled = (String)states[34];;
		_jointPoint = (String)states[35];;
		_label = (String)states[36];;
		_limitToList = ((Boolean)states[37]).booleanValue();
		_limitToListSet = ((Boolean)states[38]).booleanValue();
		_locale = (Object)restoreAttachedState(context, states[39]);
		_mode = (String)states[40];;
		_monthLabels = (Object)restoreAttachedState(context, states[41]);
		_monthLabelsShort = (Object)restoreAttachedState(context, states[42]);
		_onbeforedomupdate = (String)states[43];;
		_onchanged = (String)states[44];;
		_oncollapse = (String)states[45];;
		_oncomplete = (String)states[46];;
		_oncurrentdateselect = (String)states[47];;
		_oncurrentdateselected = (String)states[48];;
		_ondatemouseout = (String)states[49];;
		_ondatemouseover = (String)states[50];;
		_ondateselect = (String)states[51];;
		_ondateselected = (String)states[52];;
		_onexpand = (String)states[53];;
		_oninputblur = (String)states[54];;
		_oninputchange = (String)states[55];;
		_oninputclick = (String)states[56];;
		_oninputfocus = (String)states[57];;
		_oninputkeydown = (String)states[58];;
		_oninputkeypress = (String)states[59];;
		_oninputkeyup = (String)states[60];;
		_oninputmouseout = (String)states[61];;
		_oninputmouseover = (String)states[62];;
		_oninputselect = (String)states[63];;
		_ontimeselect = (String)states[64];;
		_ontimeselected = (String)states[65];;
		_popup = ((Boolean)states[66]).booleanValue();
		_popupSet = ((Boolean)states[67]).booleanValue();
		_preloadDateRangeBegin = (Object)restoreAttachedState(context, states[68]);
		_preloadDateRangeEnd = (Object)restoreAttachedState(context, states[69]);
		_process = (Object)restoreAttachedState(context, states[70]);
		_reRender = (Object)restoreAttachedState(context, states[71]);
		_readonly = ((Boolean)states[72]).booleanValue();
		_readonlySet = ((Boolean)states[73]).booleanValue();
		_requestDelay = ((Integer)states[74]).intValue();
		_requestDelaySet = ((Boolean)states[75]).booleanValue();
		_resetTimeOnDateSelect = ((Boolean)states[76]).booleanValue();
		_resetTimeOnDateSelectSet = ((Boolean)states[77]).booleanValue();
		_showApplyButton = ((Boolean)states[78]).booleanValue();
		_showApplyButtonSet = ((Boolean)states[79]).booleanValue();
		_showFooter = ((Boolean)states[80]).booleanValue();
		_showFooterSet = ((Boolean)states[81]).booleanValue();
		_showHeader = ((Boolean)states[82]).booleanValue();
		_showHeaderSet = ((Boolean)states[83]).booleanValue();
		_showInput = ((Boolean)states[84]).booleanValue();
		_showInputSet = ((Boolean)states[85]).booleanValue();
		_showWeekDaysBar = ((Boolean)states[86]).booleanValue();
		_showWeekDaysBarSet = ((Boolean)states[87]).booleanValue();
		_showWeeksBar = ((Boolean)states[88]).booleanValue();
		_showWeeksBarSet = ((Boolean)states[89]).booleanValue();
		_similarityGroupingId = (String)states[90];;
		_status = (String)states[91];;
		_style = (String)states[92];;
		_styleClass = (String)states[93];;
		_tabindex = (String)states[94];;
		_timeZone = (TimeZone)restoreAttachedState(context, states[95]);
		_timeout = ((Integer)states[96]).intValue();
		_timeoutSet = ((Boolean)states[97]).booleanValue();
		_todayControlMode = (String)states[98];;
		_toolTipMode = (String)states[99];;
		_verticalOffset = ((Integer)states[100]).intValue();
		_verticalOffsetSet = ((Boolean)states[101]).booleanValue();
		_weekDayLabels = (Object)restoreAttachedState(context, states[102]);
		_weekDayLabelsShort = (Object)restoreAttachedState(context, states[103]);
		_zindex = ((Integer)states[104]).intValue();
		_zindexSet = ((Boolean)states[105]).booleanValue();
	
}

}
