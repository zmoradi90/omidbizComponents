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
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIPickList;
import org.omidbiz.util.JSFUtil;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class PickListRenderBase extends HeaderResourcesRendererBase
{

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIPickList pickList = (UIPickList) component;
        Object forceId = pickList.getAttributes().get("forceId");
        if (forceId != null)
        {
            String submittedValue = (String) requestParams.get((String) forceId);

            if (submittedValue != null && submittedValue.length() < 1)
            {
                pickList.setSubmittedValue(submittedValue);
                pickList.setValid(true);
            }
        }
    }

    private void writeOption(ResponseWriter writer, Object val, String text) throws IOException
    {
        writer.startElement("option", null);
        if (val != null)
            getUtils().writeAttribute(writer, "value", val);
        writer.write(text);
        writer.endElement("option");
    }

    public void encodePickListSource(FacesContext context, UIComponent component) throws IOException
    {
        UIPickList pickList = (UIPickList) component;
        Object forceId = pickList.getAttributes().get("forceId");
        //
        String clientId = component.getClientId(context);
        String sourceId = clientId + "_source";
        String targetId = clientId + "_target";
        ResponseWriter writer = context.getResponseWriter();
        //
        writer.startElement("div", null);
        getUtils().writeAttribute(
                writer,
                "style",
                String.format("width:%s;", component.getAttributes().get("sourceWidth")));
        getUtils().writeAttribute(writer, "class", "pick-list-selection");
        //
        writer.startElement("select", component);
        getUtils().writeAttribute(
                writer,
                "style",
                String.format("height:%s;min-width: %s;", component.getAttributes().get("sourceHeight"), component.getAttributes().get("sourceWidth")));
        getUtils().writeAttribute(writer, "id", sourceId);
        getUtils().writeAttribute(writer, "class", "pick-list-select-scroll");
        getUtils().writeAttribute(writer, "multiple", "multiple");
        //
        Object onclickSwitch = component.getAttributes().get("onClickSwitch");
        String switchType = "ondblclick";
        if (onclickSwitch != null && Boolean.TRUE.equals(onclickSwitch))
        {
            switchType = "onclick";
        }
        getUtils().writeAttribute(
                writer,
                switchType,
                String.format("Fanpardaz.pickList.sourceClickManager('#%s', '#%s')", clientId.replace(":", "\\\\:"), forceId));
        
        
        //
        Object items = component.getAttributes().get("items");
        Object value = component.getAttributes().get("value");
        Collection<?> valueList = null;
        if (value != null)
        {
            if (value instanceof Collection<?>)
            {
                valueList = (Collection<?>) value;
            }
        }
        if (items != null)
        {
            if (items instanceof Collection<?>)
            {
                Collection<?> itemList = (Collection<?>) items;
                if (JSFUtil.isNotEmpty(itemList))
                {
                    for (Iterator iterator = itemList.iterator(); iterator.hasNext();)
                    {
                        Object item = (Object) iterator.next();
                        if (JSFUtil.isEmpty(valueList))
                        {
                            pickList.putVariables(item);
                            Object itemValue = component.getAttributes().get("itemValue");
                            Object itemLabel = component.getAttributes().get("itemLabel");
                            writeOption(writer, itemValue, itemLabel == null ? "" : (String) itemLabel);
                        }
                        else
                        {
                            // exclude items exist in value list
                            if (valueList.contains(item) == false)
                            {
                                pickList.putVariables(item);
                                Object itemValue = component.getAttributes().get("itemValue");
                                Object itemLabel = component.getAttributes().get("itemLabel");
                                writeOption(writer, itemValue, itemLabel == null ? "" : (String) itemLabel);
                            }
                        }
                    }
                }
            }
        }

        writer.endElement("select");
        writer.endElement("div");

    }

    public void encodePickListTarget(FacesContext context, UIComponent component) throws IOException
    {
        UIPickList pickList = (UIPickList) component;
        Object forceId = pickList.getAttributes().get("forceId");
        //
        String clientId = component.getClientId(context);
        String sourceId = clientId + "_source";
        String targetId = clientId + "_target";
        ResponseWriter writer = context.getResponseWriter();
        //
        writer.startElement("div", null);
        getUtils().writeAttribute(
                writer,
                "style",
                String.format("width:%s;", component.getAttributes().get("targetWidth")));
        getUtils().writeAttribute(writer, "class", "pick-list-selection");
        //
        writer.startElement("select", component);
        getUtils().writeAttribute(writer, "id", targetId);
        getUtils().writeAttribute(
                writer,
                "style",
                String.format("height:%s; min-width:%s", component.getAttributes().get("targetHeight"), component.getAttributes().get("targetWidth")));
        getUtils().writeAttribute(writer, "class", "pick-list-select-scroll");
        getUtils().writeAttribute(writer, "multiple", "multiple");
        //
        Object onclickSwitch = component.getAttributes().get("onClickSwitch");
        String switchType = "ondblclick";
        if (onclickSwitch != null && Boolean.TRUE.equals(onclickSwitch))
        {
            switchType = "onclick";
        }
        getUtils().writeAttribute(
                writer,
                switchType,
                String.format("Fanpardaz.pickList.targetClickManager('#%s', '#%s')", clientId.replace(":", "\\\\:"), forceId));
        
        //
        Object value = component.getAttributes().get("value");
        if (value != null)
        {
            if (value instanceof Collection<?>)
            {
                Collection<?> valueList = (Collection<?>) value;
                if (JSFUtil.isNotEmpty(valueList))
                {
                    for (Iterator iterator = valueList.iterator(); iterator.hasNext();)
                    {
                        Object item = (Object) iterator.next();
                        pickList.putVariables(item);
                        Object itemValue = component.getAttributes().get("itemValue");
                        Object itemLabel = component.getAttributes().get("itemLabel");
                        writeOption(writer, itemValue, itemLabel == null ? "" : (String) itemLabel);
                    }
                }
            }
        }
        //
        writer.endElement("select");
        writer.endElement("div");
    }

    public String getJQueryId(FacesContext context, UIComponent component)
    {
        return "#" + component.getClientId(context).replace(":", "\\\\:");
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIPickList.class;
    }

}
