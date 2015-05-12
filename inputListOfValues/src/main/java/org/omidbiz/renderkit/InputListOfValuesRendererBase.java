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
import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.util.InputUtils;
import org.omidbiz.component.UIInputListOfValues;
import org.omidbiz.component.UITooltip;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class InputListOfValuesRendererBase extends HeaderResourcesRendererBase
{

    @Override
    public void decode(FacesContext context, UIComponent component)
    {
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIInputListOfValues inputLov = (UIInputListOfValues) component;
        String clientId = inputLov.getClientId(context);
        String id = (String) inputLov.getAttributes().get("objectName");
        String nameId = clientId;
        if (id != null)
        {
            clientId = id + "Id";
            nameId = id + "Name";
        }

        String submittedValue = (String) requestParams.get(clientId);
        String nameValue = (String) requestParams.get(nameId);

        if (submittedValue != null && submittedValue.length() < 1)
        {
            inputLov.setNameValue(nameValue);
            inputLov.setSubmittedValue(submittedValue);
        }
    }

    protected String getValueForName(FacesContext context, UIComponent component) throws IOException
    {

        UIInputListOfValues inputLov = (UIInputListOfValues) component;
        String value = (String) inputLov.getAttributes().get("valueName");

        if (value == null)
        {
            Object valueString = inputLov.getNameValue();
            if (valueString != null)
            {
                value = valueString.toString();
            }
        }

        return value;
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIInputListOfValues.class;
    }

    @Override
    public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException
    {
        return super.getConvertedValue(context, component, submittedValue);
    }

    public Object getSelectedTextConvertedValue(FacesContext context, UIComponent component)
    {
        Object selectValue = component.getAttributes().get("selectedText");
        if (selectValue == null)
            return selectValue;
        return InputUtils.getConvertedValue(context, component, selectValue);
    }

    protected Object getValueForId(FacesContext context, UIComponent component) throws IOException
    {

        UIInputListOfValues inputLov = (UIInputListOfValues) component;
        Object value = inputLov.getAttributes().get("valueId");

        if (value == null)
            value = inputLov.getSubmittedValue();

        return value;
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException
    {
        if (component.getChildCount() > 0)
        {

            if (component.getRendersChildren())
            {
                Iterator<UIComponent> iterator = component.getChildren().iterator();
                while (iterator.hasNext())
                {
                    UIComponent uiComponent = (UIComponent) iterator.next();
                    if (uiComponent instanceof UITooltip)
                    {
                        uiComponent.encodeBegin(context);
                    }
                }
            }

        }
    }

}
