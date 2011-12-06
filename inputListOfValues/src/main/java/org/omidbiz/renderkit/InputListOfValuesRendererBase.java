package org.omidbiz.renderkit;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputListOfValues;

public class InputListOfValuesRendererBase extends HeaderResourcesRendererBase {

	
//	@Override
//	public void preDecode(FacesContext context, UIComponent component) {				
//		UIInputListOfValues inputLov = (UIInputListOfValues) component;
//		MethodExpressionValueChangeListener listener = null;
//		MethodExpression methodExpression
//		= (MethodExpression) inputLov.getAttributes().get("customEvent");
//		listener =  new MethodExpressionValueChangeListener(methodExpression);
//		FacesEvent event = new ActionEvent(inputLov);
//		event.setPhaseId(PhaseId.INVOKE_APPLICATION);
//		inputLov.queueEvent(event);
//
//
//	}

	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIInputListOfValues inputLov = (UIInputListOfValues) component;
		String clientId = inputLov.getClientId(context);
		String id = (String) inputLov.getAttributes().get("objectName");
		String nameId = clientId;
		if (id != null) {
			clientId = id + "Id";
			nameId = id + "Name";
		}

		String submittedValue = (String) requestParams.get(clientId);
		String nameValue = (String) requestParams.get(nameId);

		if (submittedValue != null && submittedValue.length() < 1) {
			inputLov.setNameValue(nameValue);			
			inputLov.setSubmittedValue(submittedValue);
		}
	}

	protected String getValueForName(FacesContext context, UIComponent component)
			throws IOException {

		UIInputListOfValues inputLov = (UIInputListOfValues) component;
		String value = (String) inputLov.getAttributes().get("valueName");

		if (value == null) {
			Object valueString = inputLov.getNameValue();
			if (valueString != null) {
				value = valueString.toString();
			}
		}

		return value;
	}

	@Override
	protected Class<? extends UIComponent> getComponentClass() {
		return UIInputListOfValues.class;
	}

	@Override
	public Object getConvertedValue(FacesContext context,
			UIComponent component, Object submittedValue)
			throws ConverterException {
		return super.getConvertedValue(context, component, submittedValue);
	}

//	protected String getConvertedStringValue(FacesContext context,
//			UIInputListOfValues component, Object value) {
//		return InputUtils.getConvertedStringValue(context, component, value);
//	}

	protected Object getValueForId(FacesContext context, UIComponent component)
			throws IOException {

		UIInputListOfValues inputLov = (UIInputListOfValues) component;
		Object value = inputLov.getAttributes().get("valueId");
		
		if(value==null)
			value = inputLov.getSubmittedValue();
		
		return value;
	}

}
