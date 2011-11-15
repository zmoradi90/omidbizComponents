package org.omidbiz.renderkit;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputNumeric;

public abstract class InputNumericRendererBase extends HeaderResourcesRendererBase {
	
	@Override
	public void decode(FacesContext context, UIComponent component){
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIInputNumeric inputDate = (UIInputNumeric)component;
		String clientId = inputDate.getClientId(context);
		String submittedValue = (String)requestParams.get(clientId);
		
		if (submittedValue != null) {			
			inputDate.setSubmittedValue(submittedValue);
		}
	}	
	
	protected String getValueAsString(FacesContext context,
			UIComponent component) throws IOException {

		UIInputNumeric inputDate = (UIInputNumeric) component;
		String valueString = (String) inputDate.getSubmittedValue();

		if (valueString == null) {
			Object value = inputDate.getValue();
			if (value != null) {
//				Converter converter = getConverter(context, inputDate);
//				valueString = converter.getAsString(context, component, value);
				valueString = value.toString();
			}
		}
		return valueString;
	}


}
