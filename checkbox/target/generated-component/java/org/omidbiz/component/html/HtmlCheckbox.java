package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UICheckbox;

public class HtmlCheckbox extends UICheckbox{

final public static  String COMPONENT_FAMILY = "org.omidbiz.Checkbox";

final public static  String COMPONENT_TYPE = "org.omidbiz.Checkbox";

/*
* 
*/
private  boolean _checked = false;

private  boolean _checkedSet = false;


public HtmlCheckbox(){
setRendererType("org.omidbiz.CheckboxRenderer");
}

public boolean isChecked(){
	if (this._checkedSet) {
	    return (this._checked);
	}
	ValueExpression ve = getValueExpression("checked");
	if (ve != null) {
	    Boolean value = null;
	    
	    try {
			value = (Boolean) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._checked);
	    }
	    
	    return value;
	} else {
	    return (this._checked);
	}

}

public void setChecked(boolean _checked){
this._checked = _checked;
this._checkedSet = true;
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[3];
state[0] = super.saveState(context);
state[1] = Boolean.valueOf(_checked);
state[2] = Boolean.valueOf(_checkedSet);
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_checked = ((Boolean)states[1]).booleanValue();
		_checkedSet = ((Boolean)states[2]).booleanValue();
	
}

}
