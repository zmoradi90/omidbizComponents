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

import org.ajax4jsf.context.AjaxContext;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIDiv;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class DivRenderBase extends HeaderResourcesRendererBase
{

    public void initializeMask(FacesContext context, UIDiv component) throws IOException
    {

        String forceId = (String) component.getAttributes().get("forceId");

        ResponseWriter writer = context.getResponseWriter();

        if (forceId != null)
        {
            writer.startElement("div", component);
            getUtils().writeAttribute(writer, "id", forceId);
            String style = (String) component.getAttributes().get("style");
            if (style != null)
            {
                getUtils().writeAttribute(writer, "style", style);
            }
            String styleClass = (String) component.getAttributes().get("styleClass");
            if (styleClass != null)
            {
                getUtils().writeAttribute(writer, "class", style);
            }
            String title = (String) component.getAttributes().get("title");
            if(title != null)
            {
                getUtils().writeAttribute(writer, "title", title);
            }
        }
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        writer.endElement("div");
    }

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        String forceId = (String) component.getAttributes().get("forceId");
        if (forceId != null)
        {
            AjaxContext ajaxContext = AjaxContext.getCurrentInstance();
            ajaxContext.addRegionsFromComponent(component);
            ajaxContext.addComponentToAjaxRender(component);
            ajaxContext.addRegionsFromComponent(component);

            ajaxContext.addRenderedArea(forceId);
        }
    }

    @Override
    protected Class getComponentClass()
    {
        return UIDiv.class;
    }

}
