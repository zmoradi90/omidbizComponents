package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIPersianDateLabelConvertor;

public class HtmlPersianDateLabelConvertor extends UIPersianDateLabelConvertor{

static final public  String COMPONENT_FAMILY = "org.omidbiz.PersianDateLabelConvertor";

static final public  String COMPONENT_TYPE = "org.omidbiz.PersianDateLabelConvertor";

/*
* 
*/
private  String _datePattern = null;

/*
* possible values 
					block : generate div
					inline : generate span
					none : generate nothing
*/
private  String _layout = null;

/*
* 
*/
private  String _styleClass = null;

/*
* 
*/
private  Object _value = null;


public HtmlPersianDateLabelConvertor(){
setRendererType("org.omidbiz.PersianDateLabelConvertorRenderer");
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

    return null;
	

}

public void setDatePattern(String _datePattern){
this._datePattern = _datePattern;
}

public String getLayout(){
	if (this._layout != null) {
		return this._layout;
	}
	ValueExpression ve = getValueExpression("layout");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return "none";
	

}

public void setLayout(String _layout){
this._layout = _layout;
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

public Object getValue(){
	if (this._value != null) {
		return this._value;
	}
	ValueExpression ve = getValueExpression("value");
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

public void setValue(Object _value){
this._value = _value;
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[5];
state[0] = super.saveState(context);
state[1] = _datePattern;
state[2] = _layout;
state[3] = _styleClass;
state[4] = saveAttachedState(context, _value);
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_datePattern = (String)states[1];;
		_layout = (String)states[2];;
		_styleClass = (String)states[3];;
		_value = (Object)restoreAttachedState(context, states[4]);
	
}

}
