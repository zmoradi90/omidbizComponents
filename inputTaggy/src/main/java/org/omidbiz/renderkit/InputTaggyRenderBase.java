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
        Object componentId = new Object();
        String value = getInputValue(context,component);
        if (component.getAttributes().get("forceId") != null)
            componentId = (Object) component.getAttributes().get("forceId");
        else
            componentId = component.getClientId(context);

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", null);
        if(component.getAttributes().get("styleClass")!=null)
            getUtils().writeAttribute(writer, "class","chips-initial"+component.getAttributes().get("styleClass").toString());
        else
            getUtils().writeAttribute(writer, "class","chips-initial");
        writer.endElement("div");
        writer.startElement("input", null);
            getUtils().writeAttribute(writer, "id",getId(context, component));
            getUtils().writeAttribute(writer, "name",getId(context, component));
            getUtils().writeAttribute(writer, "type","hidden");
            getUtils().writeAttribute(writer, "value",value);
        writer.endElement("input");
        StringBuilder sb = new StringBuilder("jQuery(document).ready(function(){jQuery('.chips-initial').material_chip({");
        sb.append("inputHiddenId:'"+getJQueryId(context,component)+"',");
        if(component.getAttributes().get("seperator") != null)
            sb.append("seperator:'"+component.getAttributes().get("seperator").toString()+"',");
        else
            sb.append("seperator:'"+","+"',");
        sb.append("data:["+value+"]});});");
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
    public String getInputValue(FacesContext context, UIInputTaggy component)
    {
        String value="";
        if(component.getAttributes().get("value").toString() != null)
        {
            if(!component.getAttributes().get("value").toString().isEmpty())
            {
                value= "";
                String str = component.getAttributes().get("value").toString();
                String[] resultList = null;
                if(component.getAttributes().get("seperator")!=null)
                    resultList = str.split(component.getAttributes().get("seperator").toString());
                else
                    resultList = str.split(",");
                for (int i = 0; i < resultList.length; i++)
                {
                        value += "{ tag:'"+resultList[i]+"',},";
                }
            }
            else
            {
                value = component.getAttributes().get("value").toString();
            }
        }
        return value;
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
