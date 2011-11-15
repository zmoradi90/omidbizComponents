package org.omidbiz.renderkit;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIDatePicker;

public class DatePickerRendererBase extends HeaderResourcesRendererBase {

	PersianCalendar pc = new PersianCalendar();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"EEE MMM d HH:mm:ss z yyyy");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");


	public void decode(FacesContext context, UIComponent component) {
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIDatePicker inputDate = (UIDatePicker) component;
		String clientId = inputDate.getClientId(context);
		String submittedValue = (String) requestParams.get(clientId);

		

		if (submittedValue != null && submittedValue.trim().length() > 1) {
			// 1390/6/30
			// inputDate.setSubmittedValue(submittedValue);
			// change submitted value to date

			String gregorianDate = pc.SolarToGregorian(submittedValue);
			try {
				inputDate.setSubmittedValue(dateFormat.parse(gregorianDate));
			} catch (ParseException e) {
				try {
					inputDate.setSubmittedValue(sdf.parse(gregorianDate));
				} catch (ParseException e1) {
					try {
						inputDate.setSubmittedValue(dateTimeFormat
								.parse(gregorianDate));
					} catch (ParseException e2) {
						e2.printStackTrace();
					}
				}
			}
		}else{
			inputDate.setSubmittedValue(submittedValue);
		}
	}

	protected String getSolarValueAsString(FacesContext context,
			UIComponent component) throws IOException {

		UIDatePicker inputDate = (UIDatePicker) component;
		String valueString = (String) inputDate.getSubmittedValue();

		if (valueString == null) {
			Object value = inputDate.getValue();
			if (value != null && value.toString().trim().length() > 1) {
				String gDate = value.toString();
				try {
					valueString = pc.GregorianToSolar(sdf.format(dateFormat
							.parse(gDate)));
				} catch (ParseException e) {
					try {
						valueString = pc.GregorianToSolar(sdf.format(sdf
								.parse(gDate)));
					} catch (ParseException e1) {
						try {
							valueString = pc.GregorianToSolar(sdf
									.format(dateTimeFormat.parse(gDate)));
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
					}

				}
			}
		}

		return valueString;
	}

	protected String getGregorianValueAsString(FacesContext context,
			UIComponent component) throws IOException {

		UIDatePicker inputDate = (UIDatePicker) component;
		String valueString = (String) inputDate.getSubmittedValue();

		if (valueString == null) {
			Object value = inputDate.getValue();
			if (value != null && value.toString().trim().length() > 1) {
				valueString = pc.SolarToGregorian(value.toString());
			}
		}

		return valueString;
	}

	protected Class<? extends UIComponent> getComponentClass() {
		return UIDatePicker.class;
	}

}