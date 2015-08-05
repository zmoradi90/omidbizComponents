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
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.util.InputUtils;
import org.omidbiz.component.UIInputListOfValues;
import org.omidbiz.component.UITooltip;
import org.omidbiz.util.JSFUtil;

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
        inputLov.setSubmittedValue(submittedValue);

        if (JSFUtil.isNotEmpty(submittedValue))
        {
            inputLov.setValueName(nameValue);
            inputLov.setValueId(submittedValue);
            inputLov.setValid(true);
        }
        // else
        // {
        // Boolean required = (Boolean)
        // inputLov.getAttributes().get("required");
        // if (required != null && required.booleanValue())
        // {
        // inputLov.setValid(false);
        // inputLov.setValueName(null);
        // inputLov.setValueId(null);
        // }
        // }
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

    public String getViewObjectName(FacesContext context, UIComponent component)
    {
        Object viewAttr = component.getAttributes().get("view");
        Object objectName = component.getAttributes().get("objectName");
        if (viewAttr == null)
            return "#";
        String view = (String) viewAttr;
        if (view.contains("?"))
        {
            view = view + "&objectName=" + objectName;
        }
        else
        {
            view = view + "?objectName=" + objectName;
        }
        return view;
    }

    public void initializeCloseLink(FacesContext context, UIInputListOfValues component) throws IOException
    {
        String type = (String) component.getAttributes().get("type");
        Boolean srts = (Boolean) component.getAttributes().get("sendRequestToServer");
        Object parentId =  component.getAttributes().get("pid");
        Object pValueText =  component.getAttributes().get("pValueText");
        Object objectNameAttr =  component.getAttributes().get("objectName");
        Object extraInfo =  component.getAttributes().get("extraInfo");
        extraInfo = extraInfo == null ? "" : extraInfo;
        if (type != null && "link".equalsIgnoreCase(type))
        {
            ExternalContext external = context.getExternalContext();
            Map requestParams = external.getRequestParameterMap();
            String objectName = (String) requestParams.get("objectName");
            if(objectName == null)
                objectName = (String)objectNameAttr;
            ResponseWriter writer = context.getResponseWriter();
            if(srts != null && srts)
            {
                writer.startElement("a", component);
                String view = (String) component.getAttributes().get("view");
                String onclick = String.format("Richfaces.colorboxControl.extendedRequestClose(%s, '%s', '%s', '%s');", parentId, pValueText, objectName, view);
                getUtils().writeAttribute(writer, "onclick", onclick);
                getUtils().writeAttribute(writer, "style", "cursor:pointer;");
                writer.write(String.valueOf(getSelectedTextConvertedValue(context, component)));
                writer.endElement("a");

            }
            if(objectName != null && objectName.trim().length() > 0)
            {
                writer.startElement("a", component);
                String onclick = String.format("Richfaces.colorboxControl.extendedClose(%s, '%s', '%s', '%s');", parentId, pValueText, objectName, extraInfo);
                getUtils().writeAttribute(writer, "onclick", onclick);
                getUtils().writeAttribute(writer, "style", "cursor:pointer;");
                writer.write(String.valueOf(getSelectedTextConvertedValue(context, component)));
                writer.endElement("a");
            }
        }
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
