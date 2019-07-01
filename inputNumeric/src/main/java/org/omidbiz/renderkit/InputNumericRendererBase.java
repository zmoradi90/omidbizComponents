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
import java.math.BigDecimal;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
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
        String typeOfValue = (String) inputDate.getAttributes().get("typeOfValue");
        String clientId = inputDate.getClientId(context);
        if (forceId != null && forceId.length() > 0)
            clientId = forceId;
        String submittedValue = (String) requestParams.get(clientId);
        String formatedString = null;
        if (submittedValue != null)
        {
            Converter converter = inputDate.getConverter();
            if (converter != null)
                inputDate.setSubmittedValue(converter.getAsObject(context, component, submittedValue));
            else
            {
                if (submittedValue.indexOf(",") > 0)
                {
                    formatedString = submittedValue.replaceAll(",", "");
                }
                else
                {
                    formatedString = submittedValue;
                }
                if(("double").equalsIgnoreCase(typeOfValue))
                {
                    inputDate.setSubmittedValue(Double.valueOf(formatedString));
                }
                else if(("integer").equalsIgnoreCase(typeOfValue))
                {
                    inputDate.setSubmittedValue(Integer.valueOf(formatedString));
                }
                else
                    inputDate.setSubmittedValue(new BigDecimal(formatedString));
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
    
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        renderChildren(context, component);
    }

    
    protected String getValueAsString(FacesContext context, UIComponent component) throws IOException
    {

        UIInputNumeric inputDate = (UIInputNumeric) component;
        Object valueString = inputDate.getSubmittedValue();

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
        return valueString == null ? "" : String.valueOf(valueString);
    }
    
    public String getInputId(FacesContext context, UIComponent component)
    {
        String forceId = (String) component.getAttributes().get("forceId");
        if (forceId != null)
            return "#" + forceId;
        String clientId = component.getClientId(context);
        return "#" + clientId.replace(":", "\\\\:");
    }

    public String getMaxDigit(FacesContext context, UIComponent component)
    {
        Object digitObject = component.getAttributes().get("digit");
        Object digitDecimalObject = component.getAttributes().get("decimalDigit");
        if (digitObject == null && digitDecimalObject == null)
            return "999999999999999999999999999.99";
        Integer digit = (Integer) digitObject;
        Integer decimalDigit = (Integer) digitDecimalObject;
        String num = "";
        if (digit == null)
            digit = 10;
        if (decimalDigit == null)
            decimalDigit = 2;
        for (int i = 0; i < digit; i++)
        {
            num = num + "9";
        }
        num = num + ".";
        for (int i = 0; i < decimalDigit; i++)
        {
            num = num + "9";
        }
        return num;
    }

    public String getMinDigit(FacesContext context, UIComponent component)
    {
        Object digitObject = component.getAttributes().get("digit");
        Object digitDecimalObject = component.getAttributes().get("decimalDigit");
        if (digitObject == null && digitDecimalObject == null)
            return "000000000000000000000000000.00";
        Integer digit = (Integer) digitObject;
        Integer decimalDigit = (Integer) digitDecimalObject;
        String num = "";
        if (digit == null)
            digit = 10;
        if (decimalDigit == null)
            decimalDigit = 2;
        for (int i = 0; i < digit; i++)
        {
            num = num + "0";
        }
        num = num + ".";
        for (int i = 0; i < decimalDigit; i++)
        {
            num = num + "0";
        }
        return num;
    }

}
