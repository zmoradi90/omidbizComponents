package org.omidbiz.renderkit;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UICheckbox;


public class CheckboxRenderBase extends HeaderResourcesRendererBase {

	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decode(context, component);
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UICheckbox checkBox = (UICheckbox) component;
		String clientId = checkBox.getClientId(context);
		String submittedValue = (String) requestParams.get(clientId+"-chk");		
		if(submittedValue == null){
			checkBox.setSubmittedValue("N");
		}else{
			checkBox.setSubmittedValue("Y");
		}
	}

	@Override
	protected Class getComponentClass() {		
		return UICheckbox.class;
	}
	

}
