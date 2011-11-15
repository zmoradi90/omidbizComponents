package org.omidbiz.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.AjaxRendererUtils;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputListOfValues;


public abstract class InputListOfValuesRendererBase extends HeaderResourcesRendererBase{
	
	protected String getValueAsString(FacesContext context,
			UIComponent component) throws IOException {

		UIInputListOfValues inputDate = (UIInputListOfValues) component;
		String valueString = (String) component.getAttributes().get("valueName");
		
		Boolean required = (Boolean) component.getAttributes().get("required");
		
		if(required){
			inputDate.setRequired(true);
		}

		
		return valueString;
	}

	protected Integer getValueAsInt(FacesContext context,
			UIComponent component) throws IOException {

		UIInputListOfValues inputDate = (UIInputListOfValues) component;
		Integer valueInteger = (Integer) inputDate.getSubmittedValue();
		
		if (valueInteger == null) {
			Object value = inputDate.getValue();
			if (value != null) {				
					valueInteger = Integer.parseInt(value.toString());
				}
			}
		
		return valueInteger;
	}


}
