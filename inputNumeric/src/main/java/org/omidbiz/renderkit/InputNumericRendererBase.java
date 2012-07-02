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
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputNumeric;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public abstract class InputNumericRendererBase extends HeaderResourcesRendererBase
{

	@Override
	public void decode(FacesContext context, UIComponent component)
	{
		ExternalContext external = context.getExternalContext();
		Map requestParams = external.getRequestParameterMap();
		UIInputNumeric inputDate = (UIInputNumeric) component;
		String clientId = inputDate.getClientId(context);
		String submittedValue = (String) requestParams.get(clientId);

		if (submittedValue != null)
		{
			inputDate.setSubmittedValue(submittedValue);
		}
	}

	protected String getValueAsString(FacesContext context, UIComponent component) throws IOException
	{

		UIInputNumeric inputDate = (UIInputNumeric) component;
		String valueString = (String) inputDate.getSubmittedValue();

		if (valueString == null)
		{
			Object value = inputDate.getValue();
			if (value != null)
			{
				// Converter converter = getConverter(context, inputDate);
				// valueString = converter.getAsString(context, component,
				// value);
				valueString = value.toString();
			}
		}
		return valueString;
	}

}
