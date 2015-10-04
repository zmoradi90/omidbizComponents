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
import javax.faces.convert.Converter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputNumeric;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class InputNumericRendererBase extends HeaderResourcesRendererBase
{

    @Override
    public void decode(FacesContext context, UIComponent component)
    {
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIInputNumeric inputDate = (UIInputNumeric) component;
        String forceId = (String) inputDate.getAttributes().get("forceId");
        String clientId = inputDate.getClientId(context);
        if (forceId != null && forceId.length() > 0)
            clientId = forceId;
        String submittedValue = (String) requestParams.get(clientId);

        if (submittedValue != null)
        {
            Converter converter = inputDate.getConverter();
            if (converter != null)
                inputDate.setSubmittedValue(converter.getAsObject(context, component, submittedValue));
            else
            {
                if (submittedValue.indexOf(",") > 0)
                {
                    inputDate.setSubmittedValue(submittedValue.replaceAll(",", ""));
                }
                else
                {
                    inputDate.setSubmittedValue(submittedValue);
                }
            }
        }
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIInputNumeric.class;
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
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
                Converter converter = inputDate.getConverter();
                if (converter != null)
                    valueString = converter.getAsString(context, component, String.valueOf(value));
                else
                    valueString = value.toString();
            }
        }
        return valueString;
    }
    
    
    public String getInputId(FacesContext context, UIComponent component)
    {
        String forceId = (String) component.getAttributes().get("forceId");
        if(forceId != null)
            return "#"+forceId;
        String clientId = component.getClientId(context);
        return "#"+clientId.replace(":", "\\\\:");
    }

}
