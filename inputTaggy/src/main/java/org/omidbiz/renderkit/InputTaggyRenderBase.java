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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputTaggy;

/**
 * 
 * @author Shahrad Kashani
 * @version $Revision: 1.0
 * 
 */
public class InputTaggyRenderBase extends HeaderResourcesRendererBase
{
    private Object id = new Object();

    public void initializeMask(FacesContext context, UIInputTaggy component) throws IOException
    {
        String onStartLoadFunc = component.getAttributes().get("onStartLoadFunc") != null ? String.valueOf(component.getAttributes().get("onStartLoadFunc")):null;
        String onStopLoadFunc = component.getAttributes().get("onStopLoadFunc") != null ? String.valueOf(component.getAttributes().get("onStopLoadFunc")):null;

        String onAddChips = component.getAttributes().get("onAddChips") != null ? String.valueOf(component.getAttributes().get("onAddChips")):"";
        String onCloseChips = component.getAttributes().get("onCloseChips") != null ? String.valueOf(component.getAttributes().get("onCloseChips")):"";
        String onSelectChips = component.getAttributes().get("onSelectChips") != null ? String.valueOf(component.getAttributes().get("onSelectChips")):"";

        
        String seperator = component.getAttributes().get("seperator") != null ?
                String.valueOf(component.getAttributes().get("seperator")): ",";
        String value = component.getAttributes().get("value") != null ? 
                String.valueOf(component.getAttributes().get("value")) : "";
        String jsonValue = getInputJsonValue(context, component);
        String styleClass = component.getAttributes().get("styleClass")!=null ? String.valueOf(component.getAttributes().get("styleClass")): "";
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", null);
            getUtils().writeAttribute(writer, "class","chips-wrapper");
            writer.startElement("div", null);
                getUtils().writeAttribute(writer, "id",component.getClientId(context));
                getUtils().writeAttribute(writer, "class","chips-initial"+styleClass);
            writer.endElement("div");
            writer.startElement("input", null);
                getUtils().writeAttribute(writer, "id",getId(context, component));
                getUtils().writeAttribute(writer, "name",getId(context, component));
                getUtils().writeAttribute(writer, "type","hidden");
                getUtils().writeAttribute(writer, "value",value);
            writer.endElement("input");
            
            writer.startElement("div", null);
                getUtils().writeAttribute(writer, "class","chips-toolbar chips-removeAll");
                getUtils().writeAttribute(writer, "title","حذف همه");
            writer.endElement("div");
            
            writer.startElement("div", null);
                getUtils().writeAttribute(writer, "class","chips-toolbar chips-copyAll");
                getUtils().writeAttribute(writer, "title","کپی");
                getUtils().writeAttribute(writer, "onclick","document.execCommand('Copy')");
            writer.endElement("div");
        
        writer.endElement("div");
        StringBuilder sb = new StringBuilder("jQuery(document).ready(function(){jQuery('#"+component.getClientId(context).replace(":", "\\\\:")+"').material_chip({");
        sb.append("seperator:'"+seperator+"',");
        sb.append("data:["+jsonValue+"],");
        if(onStartLoadFunc != null)
            sb.append("onStartLoadFunc:"+onStartLoadFunc+",");
        if(onStopLoadFunc != null)
            sb.append("onStopLoadFunc:"+onStopLoadFunc+",");
        sb.append("});");
            if(onAddChips.isEmpty()!=true)
            {
                sb.append("jQuery('.chips').on('chip.add', function(e, chip){");
                sb.append(onAddChips+"(e,chip);");
                // you have the added chip here
                sb.append("});");
            }
            if(onCloseChips.isEmpty()!=true)
            {
                sb.append("jQuery('.chips').on('chip.delete', function(e, chip){");
                sb.append(onCloseChips+"(e,chip);");
                // you have the deleted chip here     
                sb.append("});");
            }
            if(onSelectChips.isEmpty()!=true)
            {
                sb.append("jQuery('.chips').on('chip.select', function(e, chip){");
                sb.append(onSelectChips+"(e,chip);");
                // you have the selected chip here
                sb.append("});");
            }
        sb.append("});");
        getUtils().writeScript(context, component, sb.toString());

    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIInputTaggy.class;
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    @Override
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        renderChildren(context, component);
    }

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIInputTaggy inputTaggy = (UIInputTaggy) component;
        String forceId = (String) inputTaggy.getAttributes().get("forceId");
        String clientId = inputTaggy.getClientId(context);
        if (forceId != null && forceId.length() > 0)
            clientId = forceId;
        String submittedValue = (String) requestParams.get(clientId);
        if (submittedValue != null)
        {
            inputTaggy.setSubmittedValue(submittedValue);
        }
    }

    public String getJQueryId(FacesContext context, UIInputTaggy component)
    {

        return getId(context, component).replace(":", "\\\\:");
    }
    public String getInputJsonValue(FacesContext context, UIInputTaggy component)
    {
        String value = component.getAttributes().get("value") != null ? 
                            String.valueOf(component.getAttributes().get("value")) : "";
        String seperator = component.getAttributes().get("seperator") != null ?
                            String.valueOf(component.getAttributes().get("seperator")): ",";
        String formatedString = "";
        if(value.isEmpty() == false)
        {
            String[] seperatedValueArray = value.split(seperator);
            for (String seperatedValue : seperatedValueArray)
                formatedString += "{ tag:'"+seperatedValue+"',},";
            return formatedString;
        }
        else
            return formatedString;
    }
    public String getId(FacesContext context, UIInputTaggy component)
    {
        if (component.getAttributes().get("forceId") != null)
            id = (Object) component.getAttributes().get("forceId");
        else
            id = component.getClientId(context);
        return id.toString();
    }

}
