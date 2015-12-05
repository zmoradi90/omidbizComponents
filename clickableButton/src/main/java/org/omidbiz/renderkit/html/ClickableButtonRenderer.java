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
package org.omidbiz.renderkit.html;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.renderkit.RendererUtils;
import org.omidbiz.component.UIClickableButton;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class ClickableButtonRenderer extends HeaderResourcesRendererBase
{

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        Object forClientId = component.getAttributes().get("forClientId");
        if (forClientId != null)
        {            
            //
            UIComponent result = RendererUtils.getInstance().findComponentFor(component, (String) forClientId);
            if (result != null)
            {
                String clientId = result.getClientId(context);
                String functionName = "clickOn" + (String) forClientId + "()";
				createButton(context.getResponseWriter(), component, context, functionName, clientId);
                // result.setRendered(false);
                String jQueryClientId = "#" + clientId.replace(":", "\\\\:");
                StringBuilder sb = new StringBuilder("function ").append(functionName).append("{");
                sb.append("jQuery('").append(jQueryClientId).append("').").append("trigger('click')");
                sb.append("}");
                getUtils().writeScript(context, component, sb.toString());
            }

        }
    }

    private void createButton(ResponseWriter writer, UIComponent component, FacesContext context, String fname, String clientId) throws IOException
    {
        writer.startElement("button", null);
        getUtils().writeAttribute(writer, "type", "button");
        getUtils().writeAttribute(writer, "id", clientId+"_helper");
        getUtils().writeAttribute(writer, "onclick", fname);
        //
        Object styleClass = component.getAttributes().get("styleClass");
        if (styleClass != null)
        {
            getUtils().writeAttribute(writer, "class", (String) styleClass);
        }
        //
        Object style = component.getAttributes().get("style");
        if (style != null)
        {
            getUtils().writeAttribute(writer, "style", (String) style);
        }
        //
        Boolean disabled = (Boolean) component.getAttributes().get("disabled");
        if(disabled != null && disabled)
			getUtils().writeAttribute(writer, "disabled", "disabled");
        //
        Object msg = component.getAttributes().get("textMessage");
        if(msg != null)
			writer.write((String) msg);		
        writer.endElement("button");
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIClickableButton.class;
    }

}
