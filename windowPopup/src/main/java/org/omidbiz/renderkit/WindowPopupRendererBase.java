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
import org.ajax4jsf.renderkit.AjaxRendererUtils;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIWindowPopup;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class WindowPopupRendererBase extends HeaderResourcesRendererBase
{

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        String reRender = (String) component.getAttributes().get("render");
        if (reRender != null)
        {
            AjaxContext ajaxContext = AjaxContext.getCurrentInstance();
            ajaxContext.addRegionsFromComponent(component);
            ajaxContext.addComponentToAjaxRender(component);
            ajaxContext.addRegionsFromComponent(component);

            ajaxContext.addRenderedArea(reRender);
        }
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIWindowPopup.class;
    }

    public String getOnClick(FacesContext context, UIComponent component)
    {
        StringBuffer onClick;
        if (!getUtils().isBooleanAttribute(component, "disabled"))
        {
            onClick = AjaxRendererUtils.buildOnClick(component, context);
            if (!"reset".equals(component.getAttributes().get("type")))
            {
                onClick.append(";return false;");
            }
        }
        else
        {
            onClick = new StringBuffer("return false;");
        }
        return onClick.toString();
    }

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        Object t = component.getAttributes().get("type");
        String id = (String) component.getAttributes().get("forceId");
        if (id != null)
            component.setId(id);
        String jsfId = component.getClientId(context);
        id = id == null ? jsfId : id;
        Boolean iframe = (Boolean) component.getAttributes().get("iframe");
        if (t != null && id != null)
        {
            String type = (String) t;
            if ("dialog".equals(type) || "button".equals(type))
            {

                // javascript
                StringBuilder sb = new StringBuilder().append("jQuery(document).ready(function(){");
                sb.append("jQuery(\"a[rel=rel_" + id.replace(":", "\\\\:") + "]\").colorbox({fastIframe:false, width:\"80%\", height:\"80%\", iframe:"
                        + iframe + "});");
                sb.append("jQuery(\"a[rel=rel_" + id.replace(":", "\\\\:") + "]\").colorbox(jQuery.extend({");
                sb.append(String.format("onOpen:function(){ %s },", component.getAttributes().get("onOpen")));
                sb.append(String.format("onLoad:function(){ %s },", component.getAttributes().get("onLoad")));
                sb.append(String.format("onComplete:function(){ %s },", component.getAttributes().get("onComplete")));
                sb.append(String.format("onClosed:function(){ %s },", component.getAttributes().get("onClosed")));
                sb.append("width:\"" + component.getAttributes().get("width") + "\", height:\"" + component.getAttributes().get("height")
                        + "\", speed:0, iframe:" + iframe + "");
                sb.append("}, Richfaces.colorboxControl.getParameters()));");
                sb.append("});");
                getUtils().writeScript(context, component, sb.toString());
                // javascript
                writer.startElement("a", null);
                getUtils().writeAttribute(writer, "rel", String.format("rel_%s", id));
                getUtils().writeAttribute(writer, "id", id);
                getUtils().writeAttribute(writer, "href", component.getAttributes().get("view"));
                getUtils().writeAttribute(writer, "title", component.getAttributes().get("title"));
                Object useImage = component.getAttributes().get("useImage");
                if (useImage != null && (Boolean) useImage)
                {
                    writer.startElement("img", null);
                    getUtils().writeAttribute(writer, "border", "0");
                    getUtils().writeAttribute(writer, "src", component.getAttributes().get("imageSrc"));
                    writer.endElement("img");
                }
                else
                {
                    if ("button".equals(type))
                    {
                        writer.startElement("button", null);
                        getUtils().writeAttribute(writer, "class", String.format("wbtn %s", component.getAttributes().get("styleClass")));
                    }
                    writer.startElement("span", null);
                    getUtils().writeAttribute(writer, "class", "wpopup");
                    writer.write((String) component.getAttributes().get("openText"));
                    writer.endElement("span");
                    if ("button".equals(type))
                    {
                        writer.endElement("button");
                    }
                }
                renderWindowPopupChildren(context, component);
                writer.endElement("a");

            }
            // generate close link
            if ("link".equals(type))
            {
                writer.startElement("a", component);
                getUtils().writeAttribute(writer, "href", "");
                if (iframe)
                {
                    String onclickAction = "parent.jQuery.fn.colorbox.close();" + getOnClick(context, component);
                    getUtils().writeAttribute(writer, "onclick", onclickAction);

                }
                else
                {
                    String onclickAction = "jQuery.fn.colorbox.close();" + getOnClick(context, component);
                    getUtils().writeAttribute(writer, "onclick", onclickAction);
                }
                writer.write((String) component.getAttributes().get("closeText"));
                writer.endElement("a");
            }
        }
    }

    private void renderWindowPopupChildren(FacesContext context, UIComponent component) throws IOException
    {
        int tpCnt = component.getChildCount();
        if (tpCnt > 0)
            renderChildren(context, component);
    }

    @Override
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    public boolean getRendersChildren()
    {
        return false;
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException
    {
    }

}
