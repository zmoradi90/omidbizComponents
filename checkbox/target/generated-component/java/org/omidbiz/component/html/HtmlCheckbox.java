package org.omidbiz.component.html;

import javax.faces.context.FacesContext;
import org.omidbiz.component.UICheckbox;

public class HtmlCheckbox extends UICheckbox{

final static public  String COMPONENT_FAMILY = "org.omidbiz.Checkbox";

final static public  String COMPONENT_TYPE = "org.omidbiz.Checkbox";


public HtmlCheckbox(){
setRendererType("org.omidbiz.CheckboxRenderer");
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[1];
state[0] = super.saveState(context);
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);

}

}
