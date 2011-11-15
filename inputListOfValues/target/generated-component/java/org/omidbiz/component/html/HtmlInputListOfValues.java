package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIInputListOfValues;

public class HtmlInputListOfValues extends UIInputListOfValues{

public static final  String COMPONENT_FAMILY = "org.omidbiz.InputListOfValues";

public static final  String COMPONENT_TYPE = "org.omidbiz.InputListOfValues";

/*
* the most important attribute use for setting and retrieving value via javascript
*/
private  String _objectName = null;

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
* define how comonent being rendered 
				dialog
				link
*/
private  String _type = null;

/*
* used when type is dialog to define which page should load in iframe
*/
private  String _view = null;


public HtmlInputListOfValues(){
setRendererType("org.omidbiz.InputListOfValuesRenderer");
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
Object [] state = new Object[8];
state[0] = super.saveState(context);
state[1] = _objectName;
state[2] = _pValueText;
state[3] = saveAttachedState(context, _pid);
state[4] = _selectedText;
state[5] = _sendRequestToServer;
state[6] = _type;
state[7] = _view;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_objectName = (String)states[1];;
		_pValueText = (String)states[2];;
		_pid = (Object)restoreAttachedState(context, states[3]);
		_selectedText = (String)states[4];;
		_sendRequestToServer = (Boolean)states[5];;
		_type = (String)states[6];;
		_view = (String)states[7];;
	
}

}
