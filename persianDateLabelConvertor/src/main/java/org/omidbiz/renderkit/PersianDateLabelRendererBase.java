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

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIPersianDateLabelConvertor;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public abstract class PersianDateLabelRendererBase extends HeaderResourcesRendererBase
{

	PersianCalendar pc = new PersianCalendar();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected Object getSolarValueAsString(FacesContext context, UIComponent component) throws IOException
	{

		UIPersianDateLabelConvertor inputDate = (UIPersianDateLabelConvertor) component;
		Object valueString = (Object) inputDate.getAttributes().get("value");

		if (valueString != null)
		{
			String gDate = null;
			if (valueString instanceof Timestamp)
			{
				gDate = valueString.toString();
			}
			else
			{
				// TODO if user pass another time
				gDate = valueString.toString();
			}

			try
			{
				valueString = pc.GregorianToSolar(sdf.format(sdf.parse(gDate)));
			}
			catch (ParseException e)
			{
				try
				{
					valueString = pc.GregorianToSolar(dateFormat.format(dateFormat.parse(gDate)));
				}
				catch (ParseException e1)
				{
					try
					{
						valueString = pc.GregorianToSolar(dateTimeFormat.format(dateTimeFormat.parse(gDate)));
					}
					catch (ParseException e2)
					{
						e2.printStackTrace();
					}
				}

			}

		}

		String datePattern = (String) inputDate.getAttributes().get("datePattern");

		if (datePattern != null)
		{
			SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
			try
			{
				String gregorianDate = pc.SolarToGregorian(valueString.toString());
				valueString = pc.GregorianToSolar(formatter.format(formatter.parse(gregorianDate)));
			}
			catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return valueString;
	}

}
