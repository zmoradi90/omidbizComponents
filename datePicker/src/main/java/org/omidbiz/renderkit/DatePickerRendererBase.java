/*******************************************************************************
 * Copyright 2012 Omid Pourhadi
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.omidbiz.renderkit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.util.InputUtils;
import org.omidbiz.component.UIDatePicker;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class DatePickerRendererBase extends HeaderResourcesRendererBase
{

	final PersianCalendar pc = new PersianCalendar();
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
	final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	final SimpleDateFormat dateInstanceFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss z");

	public void decode(FacesContext context, UIComponent component)
	{
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIDatePicker inputDate = (UIDatePicker) component;
		String clientId = null;
		String idname = (String)inputDate.getAttributes().get("idname");
		if(idname != null && idname.length() >0)
		{
			clientId = idname;
		}
		else
		{
		 clientId = inputDate.getClientId(context) + "_date";
	    }
		String submittedValue = (String) requestParams.get(clientId);
		boolean required = (Boolean) inputDate.getAttributes().get("required");
		Object convertedDate = getConvertedDateValue(submittedValue, context, inputDate);
		if (required && convertedDate == null)
		{
			inputDate.setSubmittedValue("");
		}
		if (!required && convertedDate == null)
		{
			// Null Object doesn't cause update component
			inputDate.resetValue();
			inputDate.setSubmittedValue(null);
			inputDate.setValue(null);

		}
		if (convertedDate != null && convertedDate.toString().length() > 1)
		{
			inputDate.setSubmittedValue(convertedDate);
		}
	}

	protected String getConvertedStringValue(FacesContext context, UIDatePicker component)
	{
		UIDatePicker inputDate = (UIDatePicker) component;

		Object value = inputDate.getValue();
		if (value != null && value.toString().length() > 1)
		{
			Date gDate = (Date) value;
			String solarValue = pc.GregorianToSolar(dateTimeFormat.format(gDate));
			return InputUtils.getConvertedStringValue(context, component, solarValue);
		}
		else
		{
			return null;
		}

	}

	protected Class<? extends UIComponent> getComponentClass()
	{
		return UIDatePicker.class;
	}

	// TODO:Null Object doesn't cause update component
	protected Object getConvertedDateValue(String gregorianDate, FacesContext context, UIDatePicker component)
	{
		if (gregorianDate.length() > 0)
		{
			String gDate = pc.SolarToGregorian(gregorianDate);
			try
			{
				return sdf.parse(gDate);
			}
			catch (ParseException e)
			{
				try
				{
					return dateFormat.parse(gDate);
				}
				catch (ParseException e1)
				{
					try
					{
						return dateTimeFormat.parse(gDate);
					}
					catch (ParseException e2)
					{
						DateTimeConverter datetime = new DateTimeConverter();
						datetime.setPattern("m/y");
						Date newCurrentDate = (Date) datetime.getAsObject(context, component, gregorianDate);
						return newCurrentDate;
					}
				}
			}
		}
		else
		{
			DateTimeConverter datetime = new DateTimeConverter();
			datetime.setPattern("m/y");
			Date newCurrentDate = (Date) datetime.getAsObject(context, component, gregorianDate);
			return newCurrentDate;
		}
	}

}
