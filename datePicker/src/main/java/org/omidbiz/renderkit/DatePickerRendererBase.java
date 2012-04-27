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

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.util.InputUtils;
import org.omidbiz.component.UIDatePicker;

/**
 * @author omidbiz
 * 
 */
public class DatePickerRendererBase extends HeaderResourcesRendererBase
{

	final PersianCalendar pc = new PersianCalendar();
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
	final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void decode(FacesContext context, UIComponent component)
	{
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIDatePicker inputDate = (UIDatePicker) component;
		String clientId = inputDate.getClientId(context);
		String submittedValue = (String) requestParams.get(clientId);
		if (submittedValue != null && submittedValue.length() > 1)
		{
			String gDate = pc.SolarToGregorian(submittedValue);
			try
			{
				inputDate.setSubmittedValue(sdf.parse(gDate));
			}
			catch (ParseException e)
			{
				try
				{
					inputDate.setSubmittedValue(dateFormat.parse(gDate));
				}
				catch (ParseException e1)
				{
					try
					{
						inputDate.setSubmittedValue(dateTimeFormat.parse(gDate));
					}
					catch (ParseException e2)
					{
						e2.printStackTrace();
					}
				}
			}
		}
		else
		{
			inputDate.setSubmittedValue(submittedValue);
		}

	}

	protected String getConvertedStringValue(FacesContext context, UIDatePicker component, Object value)
	{
		Object valueString = component.getValue();
		if (valueString != null)
		{
			Date val = (Date) valueString;
			String gDate = pc.GregorianToSolar(sdf.format(val));
			return gDate;
		}
		else
		{
			return InputUtils.getConvertedStringValue(context, component, value);
		}

	}

	protected Class<? extends UIComponent> getComponentClass()
	{
		return UIDatePicker.class;
	}

}
