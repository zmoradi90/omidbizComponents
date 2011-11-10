package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIWindowPopup;

public class HtmlWindowPopup extends UIWindowPopup{

static final public  String COMPONENT_FAMILY = "org.omidbiz.WindowPopup";

static final public  String COMPONENT_TYPE = "org.omidbiz.WindowPopup";

/*
* 
*/
private  String _closeText = null;

/*
* 
*/
private  String _openText = null;

/*
* 
*/
private  String _type = null;

/*
* 
*/
private  String _view = null;


public HtmlWindowPopup(){
setRendererType("org.omidbiz.WindowPopupRenderer");
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
Object [] state = new Object[5];
state[0] = super.saveState(context);
state[1] = _closeText;
state[2] = _openText;
state[3] = _type;
state[4] = _view;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_closeText = (String)states[1];;
		_openText = (String)states[2];;
		_type = (String)states[3];;
		_view = (String)states[4];;
	
}

}
