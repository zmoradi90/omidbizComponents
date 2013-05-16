package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UIPager;

public class HtmlPager extends UIPager{

static final public  String COMPONENT_FAMILY = "org.omidbiz.Pager";

static final public  String COMPONENT_TYPE = "org.omidbiz.Pager";

/*
* 
*/
private  String _dataTableId = null;

/*
* 
*/
private  int _pages = Integer.MIN_VALUE;

private  boolean _pagesSet = false;

/*
* 
*/
private  String _view = null;


public HtmlPager(){
setRendererType("org.omidbiz.PagerRenderer");
}

public String getDataTableId(){
	if (this._dataTableId != null) {
		return this._dataTableId;
	}
	ValueExpression ve = getValueExpression("dataTableId");
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

public void setDataTableId(String _dataTableId){
this._dataTableId = _dataTableId;
}

public int getPages(){
	if (this._pagesSet) {
	    return (this._pages);
	}
	ValueExpression ve = getValueExpression("pages");
	if (ve != null) {
	    Integer value = null;
	    
	    try {
			value = (Integer) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    if (null == value) {
			return (this._pages);
	    }
	    
	    return value;
	} else {
	    return (this._pages);
	}

}

public void setPages(int _pages){
this._pages = _pages;
this._pagesSet = true;
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
state[1] = _dataTableId;
state[2] = Integer.valueOf(_pages);
state[3] = Boolean.valueOf(_pagesSet);
state[4] = _view;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_dataTableId = (String)states[1];;
		_pages = ((Integer)states[2]).intValue();
		_pagesSet = ((Boolean)states[3]).booleanValue();
		_view = (String)states[4];;
	
}

}
