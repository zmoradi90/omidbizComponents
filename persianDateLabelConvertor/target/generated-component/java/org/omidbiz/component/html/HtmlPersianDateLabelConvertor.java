package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIPersianDateLabelConvertor;

public class HtmlPersianDateLabelConvertor extends UIPersianDateLabelConvertor{

static public final  String COMPONENT_FAMILY = "org.omidbiz.PersianDateLabelConvertor";

static public final  String COMPONENT_TYPE = "org.omidbiz.PersianDateLabelConvertor";

/*
* 
*/
private  Object _value = null;


public HtmlPersianDateLabelConvertor(){
setRendererType("org.omidbiz.PersianDateLabelConvertorRenderer");
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
Object [] state = new Object[2];
state[0] = super.saveState(context);
state[1] = saveAttachedState(context, _value);
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_value = (Object)restoreAttachedState(context, states[1]);
	
}

}
