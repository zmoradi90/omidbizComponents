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

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.renderkit.ProducerContext;
import org.omidbiz.component.UITooltip;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class TooltipRenderBase extends HeaderResourcesRendererBase
{

    @Override
    public void encodeToHead(FacesContext context, UIComponent component, ProducerContext pc) throws IOException
    {
        super.encodeToHead(context, component, pc);
        UIComponent parentComponent = component.getParent();
        ResponseWriter writer = context.getResponseWriter();

        if (parentComponent != null)
        {
            // only for lov
            Object classForTitle = parentComponent.getAttributes().get("objectName");
            if (classForTitle != null)
            {
                // StringBuilder sb = new StringBuilder();
                // String className = "." + classForTitle + "Name";
                // sb.append(className)
                // .append("{background-color:#000;border:1px solid #fff;padding:10px 15px;width:200px;display:none;color:#fff;text-align:left;font-size:12px;")
                // .append("}");
                // writer.startElement("style", parentComponent);
                // getUtils().writeAttribute(writer, "type", "text/css");
                // writer.write(sb.toString());
                // writer.endElement("style");
            }

        }

    }

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        UIComponent parentComponent = component.getParent();
        if (parentComponent != null)
        {
            UITooltip t = (UITooltip) component;
            StringBuilder sb = new StringBuilder("jQuery(document).ready(function(){");
            // used for lov
            Object classForTitle = parentComponent.getAttributes().get("objectName");
            boolean addSemiColon = false;
            if (classForTitle != null)
            {
                String inputClassName = classForTitle + "Name";
                sb.append(" jQuery(\"#" + inputClassName + "\").tipsy({");
                if (t.getGravity() != null && t.getGravity().length() > 0)
                {
                    sb.append(String.format("gravity: '%s'", t.getGravity()));
                    addSemiColon = true;
                }
                if (t.getDelayOut() > 0)
                {
                    if (addSemiColon)
                        sb.append(", ");
                    sb.append("delayOut: " + t.getDelayOut());
                }
                if (t.isHtml())
                {
                    if (addSemiColon)
                        sb.append(", ");
                    sb.append("html: true");
                    addSemiColon = true;
                }
                sb.append("});");
            }
            else
            {
                sb.append(" jQuery(\"#" + parentComponent.getClientId(context).replace(":", "\\\\:") + "\").tipsy();");
            }
            sb.append("});");
            getUtils().writeScript(context, component, sb.toString());
        }
    }

    @Override
    protected Class getComponentClass()
    {
        return UITooltip.class;
    }

}
