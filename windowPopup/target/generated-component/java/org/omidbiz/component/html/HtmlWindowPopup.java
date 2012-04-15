package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import org.omidbiz.component.UIWindowPopup;

public class HtmlWindowPopup extends UIWindowPopup{

static final public  String COMPONENT_FAMILY = "org.omidbiz.WindowPopup";

static final public  String COMPONENT_TYPE = "org.omidbiz.WindowPopup";

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
* MethodExpression representing an action listener method
				that will be notified
*/
private  MethodBinding _atMin = null;

/*
* 
*/
private  String _closeText = null;

/*
* When set for a form control, this boolean attribute disables the control for your input
*/
private  boolean _disabled = false;

private  boolean _disabledSet = false;

/*
* 
*/
private  boolean _iframe = false;

private  boolean _iframeSet = false;

/*
* 
*/
private  String _imageSrc = null;

/*
* Specifies the maximum number of digits that could be entered into the input field. 
		The maximum number is unlimited by default. 
		If entered value exceeds the value specified in "maxValue" attribute than the slider takes a maximum value position.
*/
private  int _maxlength = Integer.MIN_VALUE;

private  boolean _maxlengthSet = false;

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
* 
*/
private  String _openText = null;

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
* Image title if you use image
*/
private  String _title = null;

/*
* 
*/
private  String _type = null;

/*
* 
*/
private  boolean _useImage = false;

private  boolean _useImageSet = false;

/*
* 
*/
private  String _view = null;


public HtmlWindowPopup(){
setRendererType("org.omidbiz.WindowPopupRenderer");
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

public MethodBinding getAtMin(){
	if (this._atMin != null) {
		return this._atMin;
	}
	ValueExpression ve = getValueExpression("atMin");
	if (ve != null) {
	    MethodBinding value = null;
	    
	    try {
			value = (MethodBinding) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setAtMin(MethodBinding _atMin){
this._atMin = _atMin;
}

public String getCloseText(){
	if (this._closeText != null) {
		return this._closeText;
	}
	ValueExpression ve = getValueExpression("closeText");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "Close";
	

}

public void setCloseText(String _closeText){
this._closeText = _closeText;
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

public String getImageSrc(){
	if (this._imageSrc != null) {
		return this._imageSrc;
	}
	ValueExpression ve = getValueExpression("imageSrc");
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

public void setImageSrc(String _imageSrc){
this._imageSrc = _imageSrc;
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

public String getOpenText(){
	if (this._openText != null) {
		return this._openText;
	}
	ValueExpression ve = getValueExpression("openText");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "Open";
	

}

public void setOpenText(String _openText){
this._openText = _openText;
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

public String getTitle(){
	if (this._title != null) {
		return this._title;
	}
	ValueExpression ve = getValueExpression("title");
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

public void setTitle(String _title){
this._title = _title;
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

public boolean isUseImage(){
	if (this._useImageSet) {
	    return (this._useImage);
	}
	ValueExpression ve = getValueExpression("useImage");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._useImage);
	    }
	    
	    return value;
	} else {
	    return (this._useImage);
	}

}

public void setUseImage(boolean _useImage){
this._useImage = _useImage;
this._useImageSet = true;
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

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[38];
state[0] = super.saveState(context);
state[1] = _accesskey;
state[2] = _align;
state[3] = _alt;
state[4] = saveAttachedState(context, _atMin);
state[5] = _closeText;
state[6] = Boolean.valueOf(_disabled);
state[7] = Boolean.valueOf(_disabledSet);
state[8] = Boolean.valueOf(_iframe);
state[9] = Boolean.valueOf(_iframeSet);
state[10] = _imageSrc;
state[11] = Integer.valueOf(_maxlength);
state[12] = Boolean.valueOf(_maxlengthSet);
state[13] = _onblur;
state[14] = _onchange;
state[15] = _onclick;
state[16] = _ondblclick;
state[17] = _onfocus;
state[18] = _onkeydown;
state[19] = _onkeypress;
state[20] = _onkeyup;
state[21] = _onmousedown;
state[22] = _onmousemove;
state[23] = _onmouseout;
state[24] = _onmouseover;
state[25] = _onmouseup;
state[26] = _onselect;
state[27] = _openText;
state[28] = Integer.valueOf(_size);
state[29] = Boolean.valueOf(_sizeSet);
state[30] = _style;
state[31] = _styleClass;
state[32] = _tabindex;
state[33] = _title;
state[34] = _type;
state[35] = Boolean.valueOf(_useImage);
state[36] = Boolean.valueOf(_useImageSet);
state[37] = _view;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_accesskey = (String)states[1];;
		_align = (String)states[2];;
		_alt = (String)states[3];;
		_atMin = (MethodBinding)restoreAttachedState(context, states[4]);
		_closeText = (String)states[5];;
		_disabled = ((Boolean)states[6]).booleanValue();
		_disabledSet = ((Boolean)states[7]).booleanValue();
		_iframe = ((Boolean)states[8]).booleanValue();
		_iframeSet = ((Boolean)states[9]).booleanValue();
		_imageSrc = (String)states[10];;
		_maxlength = ((Integer)states[11]).intValue();
		_maxlengthSet = ((Boolean)states[12]).booleanValue();
		_onblur = (String)states[13];;
		_onchange = (String)states[14];;
		_onclick = (String)states[15];;
		_ondblclick = (String)states[16];;
		_onfocus = (String)states[17];;
		_onkeydown = (String)states[18];;
		_onkeypress = (String)states[19];;
		_onkeyup = (String)states[20];;
		_onmousedown = (String)states[21];;
		_onmousemove = (String)states[22];;
		_onmouseout = (String)states[23];;
		_onmouseover = (String)states[24];;
		_onmouseup = (String)states[25];;
		_onselect = (String)states[26];;
		_openText = (String)states[27];;
		_size = ((Integer)states[28]).intValue();
		_sizeSet = ((Boolean)states[29]).booleanValue();
		_style = (String)states[30];;
		_styleClass = (String)states[31];;
		_tabindex = (String)states[32];;
		_title = (String)states[33];;
		_type = (String)states[34];;
		_useImage = ((Boolean)states[35]).booleanValue();
		_useImageSet = ((Boolean)states[36]).booleanValue();
		_view = (String)states[37];;
	
}

}
