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
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.servlet.http.HttpServletRequest;

import org.ajax4jsf.renderkit.ComponentVariables;
import org.ajax4jsf.renderkit.ComponentsVariableResolver;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.util.InputUtils;
import org.omidbiz.component.UIInputListOfValues;
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
        if(submittedValue != null)
            inputLov.setSubmittedValue(submittedValue);

        if (JSFUtil.isNotEmpty(submittedValue))
        {
            inputLov.setValueName(nameValue);
            inputLov.setValueId(submittedValue);
            inputLov.setValid(true);
        }
        else
        {
            inputLov.setValueName(null);
            inputLov.setValueId(null);
        }

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
        return InputUtils.getConvertedStringValue(context, component, String.valueOf(selectValue));
    }

    public Object getValueName(FacesContext context, UIComponent component)
    {
        UIInputListOfValues lov = (UIInputListOfValues) component;
        Object valueName = lov.getValueName();

        if (valueName == null)
            return valueName;

        return InputUtils.getConvertedStringValue(context, component, String.valueOf(valueName));
    }

    public String getViewObjectName(FacesContext context, UIComponent component)
    {
        Object viewAttr = component.getAttributes().get("view");
        Object objectName = ((UIInputListOfValues)component).getObjectName();
        if (viewAttr == null)
            return "#";
        String view = (String) viewAttr;
        if (objectName != null)
        {

            if (view.contains("?"))
            {
                view = view + "&objectName=" + objectName;
            }
            else
            {
                view = view + "?objectName=" + objectName;
            }
        }
        return view;
    }

    public void initializeAutoNumeric(FacesContext context, UIInputListOfValues component) throws IOException
    {
        String type = (String) component.getAttributes().get("type");
        Boolean autoNumeric = (Boolean) component.getAttributes().get("autoNumeric");
        Object objectNameAttr = component.getObjectName();
        if (type != null && "dialog".equalsIgnoreCase(type))
        {
            if (autoNumeric)
            {
                String script = "jQuery(document).ready(function(){";
                script += String
                        .format("jQuery('%s').autoNumeric('init', {aSep: ',', vMax: '999999999999999999999999999.99',vMin: '0000000000000000000000000.00'});",
                                "#"+objectNameAttr + "Name");
                script += "});";
                getUtils().writeScript(context, component, script);
            }
        }
    }

    public void initializeLovInput(FacesContext context, UIInputListOfValues component) throws IOException
    {
        String type = (String) component.getAttributes().get("type");
        String styleClass = (String) component.getAttributes().get("styleClass");
        Object objectNameAttr = component.getObjectName();
        Object autocompleteUrl = component.getAttributes().get("autocompleteUrl");
        Object onchange = component.getAttributes().get("onchange");
        Object title = component.getAttributes().get("title");
        ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
        if (type != null && "dialog".equalsIgnoreCase(type))
        {
            ResponseWriter writer = context.getResponseWriter();
            // <input type="hidden" name="#{objectName}Id" id="#{objectName}Id"
            // value="#{valueId}"/>
            writer.startElement("input", null);
            getUtils().writeAttribute(writer, "type", "hidden");
            getUtils().writeAttribute(writer, "name", objectNameAttr + "Id");
            getUtils().writeAttribute(writer, "id", objectNameAttr + "Id");
            getUtils().writeAttribute(writer, "value", component.getValueId());
            writer.endElement("input");
            /*
             * <input readonly="readonly" onchange="#{onchange}"
             * class="#{objectName}Name"
             * title="#{component.attributes['title']}" type="text"
             * name="#{objectName}Name" id="#{objectName}Name"
             * value="#{this:getValueName(context, component)}"/>
             */
            writer.startElement("input", null);
            if (autocompleteUrl == null)
                getUtils().writeAttribute(writer, "readonly", "readonly");
            if (onchange != null)
                getUtils().writeAttribute(writer, "onchange", onchange);
            getUtils().writeAttribute(writer, "class", objectNameAttr + "Name");
            if (title != null)
                getUtils().writeAttribute(writer, "title", title);
            getUtils().writeAttribute(writer, "type", "text");
            getUtils().writeAttribute(writer, "name", objectNameAttr + "Name");
            getUtils().writeAttribute(writer, "id", objectNameAttr + "Name");
            getUtils().writeAttribute(writer, "value", getValueName(context, component));
            writer.endElement("input");
            //
            
            // <a rel="rel#{objectName}" class="#{objectName}lovClass"
            // href='#{this:getViewObjectName(context, component)}'>
            writer.startElement("a", null);
            getUtils().writeAttribute(writer, "rel", "rel" + objectNameAttr);
            getUtils().writeAttribute(writer, "class", objectNameAttr + "lovClass");
            getUtils().writeAttribute(writer, "href", getViewObjectName(context, component));
            // <img alt="Open Colorbox" src="#{icon}"
            // style="border: 0;vertical-align: middle;cursor: pointer;"/>
            writer.startElement("img", null);
            getUtils().writeAttribute(writer, "src", variables.getVariable("icon"));
            getUtils().writeAttribute(writer, "alt", "open");
            getUtils().writeAttribute(writer, "style", "border: 0;vertical-align: middle;cursor: pointer;");
            writer.endElement("img");
            writer.endElement("a");
            /*
             * <img style="border: 0;vertical-align: middle;cursor: pointer;"
             * alt="clear" src="#{removeIcon}"
             * onclick="Richfaces.colorboxControl.removeValue('#{objectName}');"
             * />
             */
            writer.startElement("img", null);
            getUtils().writeAttribute(writer, "style", "border: 0;vertical-align: middle;cursor: pointer;");
            getUtils().writeAttribute(writer, "alt", "clear");
            getUtils().writeAttribute(writer, "src", variables.getVariable("removeIcon"));
            getUtils().writeAttribute(writer, "onclick", String.format("Richfaces.colorboxControl.removeValue('%s');", objectNameAttr));
            writer.endElement("img");
        }
    }

    public void initializeCloseLink(FacesContext context, UIInputListOfValues component) throws IOException
    {
        String type = (String) component.getAttributes().get("type");
        Boolean srts = (Boolean) component.getAttributes().get("sendRequestToServer");
        Object parentId = component.getAttributes().get("pid");
        Object pValueText = component.getAttributes().get("pValueText");
        String styleClass = (String) component.getAttributes().get("styleClass");
        Object objectNameAttr = component.getObjectName();
        Object extraInfo = component.getAttributes().get("extraInfo");
        Boolean autoNumeric = (Boolean) component.getAttributes().get("autoNumeric");
        Object data = component.getAttributes().get("data");
        Object onCloseLink = component.getAttributes().get("onCloseLink");
        extraInfo = extraInfo == null ? "" : extraInfo;
        if (type != null && "link".equalsIgnoreCase(type))
        {
            ResponseWriter writer = context.getResponseWriter();
            ExternalContext external = context.getExternalContext();
            Map requestParams = external.getRequestParameterMap();
            String objectName = (String) requestParams.get("objectName");
            if (objectName == null)
                objectName = (String) objectNameAttr;
            if (srts != null && srts)
            {
                writer.startElement("a", component);
                String view = (String) component.getAttributes().get("view");
                String onclick = String.format("Richfaces.colorboxControl.extendedRequestClose(%s, '%s', '%s', '%s');", parentId,
                        pValueText, objectName, view);                
                getUtils().writeAttribute(writer, "onclick", onclick);
                getUtils().writeAttribute(writer, "style", "cursor:pointer;");
                if (JSFUtil.isNotEmpty(styleClass))
                    getUtils().writeAttribute(writer, "class", styleClass);
                writer.write(String.valueOf(getSelectedTextConvertedValue(context, component)));
                writer.endElement("a");

            }
            if (objectName != null && objectName.trim().length() > 0)
            {
                writer.startElement("a", component);
                String onclick = String.format("Richfaces.colorboxControl.extendedClose(%s, '%s', '%s', '%s');", parentId, pValueText,
                        objectName, extraInfo);
                if (autoNumeric)
                    onclick += String.format("Richfaces.colorboxControl.applyAutoNumeric('%s');", objectNameAttr);
                onclick += "Richfaces.colorboxControl.extendedCloseBox();";
                if(data != null && onCloseLink != null)
                    onclick += onCloseLink+"('"+objectName+"','"+data+"');";
                else if(onCloseLink != null)
                    onclick += onCloseLink+"('"+objectName+"');";
                getUtils().writeAttribute(writer, "onclick", onclick);
                getUtils().writeAttribute(writer, "style", "cursor:pointer;");
                if (JSFUtil.isNotEmpty(styleClass))
                    getUtils().writeAttribute(writer, "class", styleClass);
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
                    //if (uiComponent instanceof UIInputTipsy)
                    //{
                        uiComponent.encodeAll(context);
                    //}              
                }
            }

        }
    }

}
