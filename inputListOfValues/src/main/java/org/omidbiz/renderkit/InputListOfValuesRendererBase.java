package org.omidbiz.renderkit;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputListOfValues;


public abstract class InputListOfValuesRendererBase extends HeaderResourcesRendererBase{
	
	
	
	
	@Override
	public void decode(FacesContext context, UIComponent component){
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIInputListOfValues inputDate = (UIInputListOfValues)component;
		String clientId = inputDate.getClientId(context);
		String id = (String) inputDate.getAttributes().get("objectName");
		String nameId = clientId;
		if(id != null){
			clientId = id+"Id";
			nameId = id+"Name";
		}
				
		String submittedValue = (String)requestParams.get(clientId);
		String nameValue = (String)requestParams.get(nameId);
		
		if (submittedValue != null) {			
			inputDate.setValueName(nameValue);
			inputDate.setSubmittedValue(submittedValue);
		}
	}	


	protected String getValueForName(FacesContext context,
			UIComponent component) throws IOException {

		UIInputListOfValues inputDate = (UIInputListOfValues) component;
		String valueString = (String) inputDate.getValueName();
		
		
		return valueString;
	}

	protected String getValueForId(FacesContext context,
			UIComponent component) throws IOException {

		UIInputListOfValues inputDate = (UIInputListOfValues) component;
		String valueId = (String) inputDate.getSubmittedValue();
		
		if (valueId == null) {
			Object value = inputDate.getValue();
			if (value != null) {				
					valueId = value.toString();
				}
			}
		
		return valueId;
	}
	
	
	


}
