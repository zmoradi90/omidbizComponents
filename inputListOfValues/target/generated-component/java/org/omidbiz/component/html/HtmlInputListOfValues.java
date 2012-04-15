package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIInputListOfValues;

public class HtmlInputListOfValues extends UIInputListOfValues{

final static public  String COMPONENT_FAMILY = "org.omidbiz.InputListOfValues";

final static public  String COMPONENT_TYPE = "org.omidbiz.InputListOfValues";

/*
* This attribute assigns an access key to an element. An access key is a single character from the document character set. Note: Authors should consider the input method of the expected reader when specifying an accesskey
*/
private  String _accesskey = null;

/*
* Deprecated. This attribute specifies the horizontal alignment of its element with respect to the surrounding context. The  possible values are "left", "center", "right" and "justify".  
            The default depends on the base text direction. For left to right text, the default is align="left", while for right to left text, the default is align="right".
*/
private  String _align = null;

/*
* For a user agents that cannot display images, forms, or applets, this attribute specifies alternate text. The language of the alternate text is specified by the lang attribute
*/
private  String _alt = null;

/*
* When set for a form control, this boolean attribute disables the control for your input
*/
private  boolean _disabled = false;

private  boolean _disabledSet = false;

/*
* 
*/
private  String _height = null;

/*
* 
*/
private  boolean _iframe = true;

private  boolean _iframeSet = false;

/*
* Specifies the maximum number of digits that could be entered into the input field. 
		The maximum number is unlimited by default. 
		If entered value exceeds the value specified in "maxValue" attribute than the slider takes a maximum value position.
*/
private  int _maxlength = Integer.MIN_VALUE;

private  boolean _maxlengthSet = false;

/*
* the most important attribute use for setting and retrieving value via javascript
*/
private  String _objectName = null;

/*
* 
*/
private  String _onCleanup = null;

/*
* 
*/
private  String _onClosed = null;

/*
* 
*/
private  String _onComplete = null;

/*
* 
*/
private  String _onLoad = null;

/*
* 
*/
private  String _onOpen = null;

/*
* The client side script method to be called when the element loses the focus
*/
private  String _onblur = null;

/*
* The client side script method to be called when the element value is changed
*/
private  String _onchange = null;

/*
* The clientside script method to be called when the element is clicked
*/
private  String _onclick = null;

/*
* The client side script method to be called when the element is double-clicked
*/
private  String _ondblclick = null;

/*
* The client side script method to be called when the element gets the focus
*/
private  String _onfocus = null;

/*
* The client side script method to be called when a key is pressed down over the element
*/
private  String _onkeydown = null;

/*
* The client side script method to be called when a key is pressed over the element and released
*/
private  String _onkeypress = null;

/*
* The client side script method to be called when a key is released
*/
private  String _onkeyup = null;

/*
* The client side script method to be called when a mouse button is pressed down over the element
*/
private  String _onmousedown = null;

/*
* The client side script method to be called when a pointer is moved within the element
*/
private  String _onmousemove = null;

/*
* The client side script method to be called when a pointer is moved away from the element
*/
private  String _onmouseout = null;

/*
* The client side script method to be called when a pointer is moved onto the element
*/
private  String _onmouseover = null;

/*
* The client side script method to be called when a mouse button is released
*/
private  String _onmouseup = null;

/*
* The client side script method to be called when some text is selected in the text field. This attribute can be used with the INPUT and TEXTAREA elements.
*/
private  String _onselect = null;

/*
* it is used to show in textbox
*/
private  String _pValueText = null;

/*
* it is used for filling hidden field
*/
private  Object _pid = null;

/*
* text value is used for text link
*/
private  String _selectedText = null;

/*
* send request to url view when close popup modal
*/
private  Boolean _sendRequestToServer = null;

/*
* This attribute tells the user agent the initial width of the control. The width is given in pixels except when type attribute has the value "text" or "password". In that case, its value refers to the (integer) number of characters
*/
private  int _size = Integer.MIN_VALUE;

private  boolean _sizeSet = false;

/*
* CSS style(s) is/are to be applied when this component is rendered
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
* define how comonent being rendered 
				dialog
				link
*/
private  String _type = null;

/*
* The value Id of the component show in hidden
*/
private  Object _valueId = null;

/*
* The value of the component show in textbox
*/
private  Object _valueName = null;

/*
* used when type is dialog to define which page should load in iframe
*/
private  String _view = null;

/*
* 
*/
private  String _width = null;


public HtmlInputListOfValues(){
setRendererType("org.omidbiz.InputListOfValuesRenderer");
}

public String getAccesskey(){
	if (this._accesskey != null) {
		return this._accesskey;
	}
	ValueExpression ve = getValueExpression("accesskey");
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

public void setAccesskey(String _accesskey){
this._accesskey = _accesskey;
}

public String getAlign(){
	if (this._align != null) {
		return this._align;
	}
	ValueExpression ve = getValueExpression("align");
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

public void setAlign(String _align){
this._align = _align;
}

public String getAlt(){
	if (this._alt != null) {
		return this._alt;
	}
	ValueExpression ve = getValueExpression("alt");
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

public void setAlt(String _alt){
this._alt = _alt;
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

public String getHeight(){
	if (this._height != null) {
		return this._height;
	}
	ValueExpression ve = getValueExpression("height");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "85%";
	

}

public void setHeight(String _height){
this._height = _height;
}

public boolean isIframe(){
	if (this._iframeSet) {
	    return (this._iframe);
	}
	ValueExpression ve = getValueExpression("iframe");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._iframe);
	    }
	    
	    return value;
	} else {
	    return (this._iframe);
	}

}

public void setIframe(boolean _iframe){
this._iframe = _iframe;
this._iframeSet = true;
}

public int getMaxlength(){
	if (this._maxlengthSet) {
	    return (this._maxlength);
	}
	ValueExpression ve = getValueExpression("maxlength");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._maxlength);
	    }
	    
	    return value;
	} else {
	    return (this._maxlength);
	}

}

public void setMaxlength(int _maxlength){
this._maxlength = _maxlength;
this._maxlengthSet = true;
}

public String getObjectName(){
	if (this._objectName != null) {
		return this._objectName;
	}
	ValueExpression ve = getValueExpression("objectName");
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

public void setObjectName(String _objectName){
this._objectName = _objectName;
}

public String getOnCleanup(){
	if (this._onCleanup != null) {
		return this._onCleanup;
	}
	ValueExpression ve = getValueExpression("onCleanup");
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

public void setOnCleanup(String _onCleanup){
this._onCleanup = _onCleanup;
}

public String getOnClosed(){
	if (this._onClosed != null) {
		return this._onClosed;
	}
	ValueExpression ve = getValueExpression("onClosed");
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

public void setOnClosed(String _onClosed){
this._onClosed = _onClosed;
}

public String getOnComplete(){
	if (this._onComplete != null) {
		return this._onComplete;
	}
	ValueExpression ve = getValueExpression("onComplete");
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

public void setOnComplete(String _onComplete){
this._onComplete = _onComplete;
}

public String getOnLoad(){
	if (this._onLoad != null) {
		return this._onLoad;
	}
	ValueExpression ve = getValueExpression("onLoad");
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

public void setOnLoad(String _onLoad){
this._onLoad = _onLoad;
}

public String getOnOpen(){
	if (this._onOpen != null) {
		return this._onOpen;
	}
	ValueExpression ve = getValueExpression("onOpen");
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

public void setOnOpen(String _onOpen){
this._onOpen = _onOpen;
}

public String getOnblur(){
	if (this._onblur != null) {
		return this._onblur;
	}
	ValueExpression ve = getValueExpression("onblur");
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

public void setOnblur(String _onblur){
this._onblur = _onblur;
}

public String getOnchange(){
	if (this._onchange != null) {
		return this._onchange;
	}
	ValueExpression ve = getValueExpression("onchange");
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

public void setOnchange(String _onchange){
this._onchange = _onchange;
}

public String getOnclick(){
	if (this._onclick != null) {
		return this._onclick;
	}
	ValueExpression ve = getValueExpression("onclick");
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

public void setOnclick(String _onclick){
this._onclick = _onclick;
}

public String getOndblclick(){
	if (this._ondblclick != null) {
		return this._ondblclick;
	}
	ValueExpression ve = getValueExpression("ondblclick");
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

public void setOndblclick(String _ondblclick){
this._ondblclick = _ondblclick;
}

public String getOnfocus(){
	if (this._onfocus != null) {
		return this._onfocus;
	}
	ValueExpression ve = getValueExpression("onfocus");
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

public void setOnfocus(String _onfocus){
this._onfocus = _onfocus;
}

public String getOnkeydown(){
	if (this._onkeydown != null) {
		return this._onkeydown;
	}
	ValueExpression ve = getValueExpression("onkeydown");
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

public void setOnkeydown(String _onkeydown){
this._onkeydown = _onkeydown;
}

public String getOnkeypress(){
	if (this._onkeypress != null) {
		return this._onkeypress;
	}
	ValueExpression ve = getValueExpression("onkeypress");
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

public void setOnkeypress(String _onkeypress){
this._onkeypress = _onkeypress;
}

public String getOnkeyup(){
	if (this._onkeyup != null) {
		return this._onkeyup;
	}
	ValueExpression ve = getValueExpression("onkeyup");
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

public void setOnkeyup(String _onkeyup){
this._onkeyup = _onkeyup;
}

public String getOnmousedown(){
	if (this._onmousedown != null) {
		return this._onmousedown;
	}
	ValueExpression ve = getValueExpression("onmousedown");
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

public void setOnmousedown(String _onmousedown){
this._onmousedown = _onmousedown;
}

public String getOnmousemove(){
	if (this._onmousemove != null) {
		return this._onmousemove;
	}
	ValueExpression ve = getValueExpression("onmousemove");
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

public void setOnmousemove(String _onmousemove){
this._onmousemove = _onmousemove;
}

public String getOnmouseout(){
	if (this._onmouseout != null) {
		return this._onmouseout;
	}
	ValueExpression ve = getValueExpression("onmouseout");
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

public void setOnmouseout(String _onmouseout){
this._onmouseout = _onmouseout;
}

public String getOnmouseover(){
	if (this._onmouseover != null) {
		return this._onmouseover;
	}
	ValueExpression ve = getValueExpression("onmouseover");
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

public void setOnmouseover(String _onmouseover){
this._onmouseover = _onmouseover;
}

public String getOnmouseup(){
	if (this._onmouseup != null) {
		return this._onmouseup;
	}
	ValueExpression ve = getValueExpression("onmouseup");
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

public void setOnmouseup(String _onmouseup){
this._onmouseup = _onmouseup;
}

public String getOnselect(){
	if (this._onselect != null) {
		return this._onselect;
	}
	ValueExpression ve = getValueExpression("onselect");
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

public void setOnselect(String _onselect){
this._onselect = _onselect;
}

public String getPValueText(){
	if (this._pValueText != null) {
		return this._pValueText;
	}
	ValueExpression ve = getValueExpression("pValueText");
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

public void setPValueText(String _pValueText){
this._pValueText = _pValueText;
}

public Object getPid(){
	if (this._pid != null) {
		return this._pid;
	}
	ValueExpression ve = getValueExpression("pid");
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

public void setPid(Object _pid){
this._pid = _pid;
}

public String getSelectedText(){
	if (this._selectedText != null) {
		return this._selectedText;
	}
	ValueExpression ve = getValueExpression("selectedText");
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

public void setSelectedText(String _selectedText){
this._selectedText = _selectedText;
}

public Boolean getSendRequestToServer(){
	if (this._sendRequestToServer != null) {
		return this._sendRequestToServer;
	}
	ValueExpression ve = getValueExpression("sendRequestToServer");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return false;
	

}

public void setSendRequestToServer(Boolean _sendRequestToServer){
this._sendRequestToServer = _sendRequestToServer;
}

public int getSize(){
	if (this._sizeSet) {
	    return (this._size);
	}
	ValueExpression ve = getValueExpression("size");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._size);
	    }
	    
	    return value;
	} else {
	    return (this._size);
	}

}

public void setSize(int _size){
this._size = _size;
this._sizeSet = true;
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

public String getType(){
	if (this._type != null) {
		return this._type;
	}
	ValueExpression ve = getValueExpression("type");
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

public void setType(String _type){
this._type = _type;
}

public Object getValueId(){
	if (this._valueId != null) {
		return this._valueId;
	}
	ValueExpression ve = getValueExpression("valueId");
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

public void setValueId(Object _valueId){
this._valueId = _valueId;
}

public Object getValueName(){
	if (this._valueName != null) {
		return this._valueName;
	}
	ValueExpression ve = getValueExpression("valueName");
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

public void setValueName(Object _valueName){
this._valueName = _valueName;
}

public String getView(){
	if (this._view != null) {
		return this._view;
	}
	ValueExpression ve = getValueExpression("view");
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

public void setView(String _view){
this._view = _view;
}

public String getWidth(){
	if (this._width != null) {
		return this._width;
	}
	ValueExpression ve = getValueExpression("width");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "85%";
	

}

public void setWidth(String _width){
this._width = _width;
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[45];
state[0] = super.saveState(context);
state[1] = _accesskey;
state[2] = _align;
state[3] = _alt;
state[4] = Boolean.valueOf(_disabled);
state[5] = Boolean.valueOf(_disabledSet);
state[6] = _height;
state[7] = Boolean.valueOf(_iframe);
state[8] = Boolean.valueOf(_iframeSet);
state[9] = Integer.valueOf(_maxlength);
state[10] = Boolean.valueOf(_maxlengthSet);
state[11] = _objectName;
state[12] = _onCleanup;
state[13] = _onClosed;
state[14] = _onComplete;
state[15] = _onLoad;
state[16] = _onOpen;
state[17] = _onblur;
state[18] = _onchange;
state[19] = _onclick;
state[20] = _ondblclick;
state[21] = _onfocus;
state[22] = _onkeydown;
state[23] = _onkeypress;
state[24] = _onkeyup;
state[25] = _onmousedown;
state[26] = _onmousemove;
state[27] = _onmouseout;
state[28] = _onmouseover;
state[29] = _onmouseup;
state[30] = _onselect;
state[31] = _pValueText;
state[32] = saveAttachedState(context, _pid);
state[33] = _selectedText;
state[34] = _sendRequestToServer;
state[35] = Integer.valueOf(_size);
state[36] = Boolean.valueOf(_sizeSet);
state[37] = _style;
state[38] = _styleClass;
state[39] = _tabindex;
state[40] = _type;
state[41] = saveAttachedState(context, _valueId);
state[42] = saveAttachedState(context, _valueName);
state[43] = _view;
state[44] = _width;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_accesskey = (String)states[1];;
		_align = (String)states[2];;
		_alt = (String)states[3];;
		_disabled = ((Boolean)states[4]).booleanValue();
		_disabledSet = ((Boolean)states[5]).booleanValue();
		_height = (String)states[6];;
		_iframe = ((Boolean)states[7]).booleanValue();
		_iframeSet = ((Boolean)states[8]).booleanValue();
		_maxlength = ((Integer)states[9]).intValue();
		_maxlengthSet = ((Boolean)states[10]).booleanValue();
		_objectName = (String)states[11];;
		_onCleanup = (String)states[12];;
		_onClosed = (String)states[13];;
		_onComplete = (String)states[14];;
		_onLoad = (String)states[15];;
		_onOpen = (String)states[16];;
		_onblur = (String)states[17];;
		_onchange = (String)states[18];;
		_onclick = (String)states[19];;
		_ondblclick = (String)states[20];;
		_onfocus = (String)states[21];;
		_onkeydown = (String)states[22];;
		_onkeypress = (String)states[23];;
		_onkeyup = (String)states[24];;
		_onmousedown = (String)states[25];;
		_onmousemove = (String)states[26];;
		_onmouseout = (String)states[27];;
		_onmouseover = (String)states[28];;
		_onmouseup = (String)states[29];;
		_onselect = (String)states[30];;
		_pValueText = (String)states[31];;
		_pid = (Object)restoreAttachedState(context, states[32]);
		_selectedText = (String)states[33];;
		_sendRequestToServer = (Boolean)states[34];;
		_size = ((Integer)states[35]).intValue();
		_sizeSet = ((Boolean)states[36]).booleanValue();
		_style = (String)states[37];;
		_styleClass = (String)states[38];;
		_tabindex = (String)states[39];;
		_type = (String)states[40];;
		_valueId = (Object)restoreAttachedState(context, states[41]);
		_valueName = (Object)restoreAttachedState(context, states[42]);
		_view = (String)states[43];;
		_width = (String)states[44];;
	
}

}
