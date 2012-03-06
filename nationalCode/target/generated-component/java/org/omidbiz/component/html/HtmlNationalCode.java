package org.omidbiz.component.html;

import javax.faces.context.FacesContext;
import org.omidbiz.component.UINationalCode;

public class HtmlNationalCode extends UINationalCode{

public static final  String COMPONENT_FAMILY = "org.omidbiz.NationalCode";

public static final  String COMPONENT_TYPE = "org.omidbiz.NationalCode";


public HtmlNationalCode(){
setRendererType("org.omidbiz.NationalCodeRenderer");
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
