package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIInputExtra;

public class HtmlInputExtra extends UIInputExtra{

final public static  String COMPONENT_FAMILY = "org.omidbiz.InputExtra";

final public static  String COMPONENT_TYPE = "org.omidbiz.InputExtra";

/*
* 
*/
private  String _maskPattern = null;


public HtmlInputExtra(){
setRendererType("org.omidbiz.InputExtraRenderer");
}

public String getMaskPattern(){
	if (this._maskPattern != null) {
		return this._maskPattern;
	}
	ValueExpression ve = getValueExpression("maskPattern");
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

public void setMaskPattern(String _maskPattern){
this._maskPattern = _maskPattern;
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[2];
state[0] = super.saveState(context);
state[1] = _maskPattern;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_maskPattern = (String)states[1];;
	
}

}
