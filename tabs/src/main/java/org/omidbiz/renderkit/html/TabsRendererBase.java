package org.omidbiz.renderkit.html;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.resource.InternetResource;
import org.omidbiz.component.UITabPanel;
import org.omidbiz.component.UITabs;

public class TabsRendererBase extends HeaderResourcesRendererBase
{

    InternetResource[] jsResources = { getResource("/org/omidbiz/renderkit/html/script/tab_cookie.js"), 
            getResource("/org/omidbiz/renderkit/html/script/jquery-ui.js"),
            getResource("/org/omidbiz/renderkit/html/script/jquery.ui.widget.js"),
            getResource("/org/omidbiz/renderkit/html/script/jquery.ui.tabs.js")
            };
    
    
    InternetResource[] cssResources = { 
            getResource("/org/omidbiz/renderkit/html/css/jquery.ui.theme.css"),
            getResource("/org/omidbiz/renderkit/html/css/jquery.ui.tabs.css"),
            getResource("org/omidbiz/images/ui-bg_highlight-soft_75_cccccc_1x100.png"),
            getResource("org/omidbiz/images/ui-bg_flat_75_ffffff_40x100.png"),
            getResource("org/omidbiz/images/ui-bg_glass_75_e6e6e6_1x400.png"),
            getResource("org/omidbiz/images/ui-bg_glass_75_dadada_1x400.png"),
            getResource("org/omidbiz/images/ui-bg_glass_65_ffffff_1x400.png")
            };

    @Override
    protected InternetResource[] getScripts()
    {
        return jsResources;
    }
    
    @Override
    protected InternetResource[] getStyles()
    {
        return cssResources;
    }

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        String clientId = component.getClientId(context);
        StringBuilder disabledTabs = new StringBuilder();
        StringBuilder js = new StringBuilder("jQuery(document).ready(function(){");
        UITabs tab = ((UITabs) component);
        String jQueryClientId = clientId.replace(":", "\\\\:");
        js.append("jQuery('#").append(jQueryClientId).append("').tabs({");
        String tabCookieName = "selected-tab_" + jQueryClientId;
        if (tab.isKeepState())
        {
            js.append(" select: function (e, ui) { ");
            js.append(" cookieManager.write('" + tabCookieName + "', ui.index); } ");
            // js.append(" active: 2");
        }
        else
        {
            js.append("active: ").append(tab.getActive());
        }
        writer.startElement("div", component);
        getUtils().writeAttribute(writer, "id", clientId);
        Iterator childIterator = component.getChildren().iterator();
        writer.startElement("ul", component);
        int i = 0;
        boolean addLoading = false;
        while (childIterator.hasNext())
        {
            UIComponent comp = (UIComponent) childIterator.next();
            if (comp instanceof UITabPanel)
            {
                UITabPanel tp = ((UITabPanel) comp);
                if (tp.isRendered())
                {
                    writer.startElement("li", null);
                    writer.startElement("a", null);
                    String title = (String) tp.getTitle();
                    String link = (String) tp.getLink();
                    if (tp.isDisabled())
                    {
                        if (i > 0)
                            disabledTabs.append(", ");
                        disabledTabs.append(i);
                    }
                    if (addLoading == false)
                    {
                        if (link != null && link.trim().length() > 0)
                        {
                            // not available on jquery ui 1.8.16
                            // js.append(",")
                            // .append(" beforeLoad: function( event, ui ) {ui.panel.html(\"Loading...\");}");
                            addLoading = true;
                        }
                    }
                    if (link != null && link.trim().length() > 0)
                    {
                        StringBuilder linkWithparams = new StringBuilder(link);
                        if (tp.isIncludePageParams())
                        {
                            ExternalContext external = context.getExternalContext();
                            Map<String, String> requestParams = external.getRequestParameterMap();
                            if (requestParams != null && requestParams.size() > 0)
                            {
                                linkWithparams.append("?");
                                int cnt = 0;
                                for (Map.Entry<String, String> entry : requestParams.entrySet())
                                {
                                    if (cnt > 0)
                                        linkWithparams.append("&");
                                    linkWithparams.append(entry.getKey()).append("=").append(entry.getValue());
                                    cnt++;
                                }
                            }
                        }
                        getUtils().writeAttribute(writer, "href", linkWithparams);
                    }
                    else
                    {
                        getUtils().writeAttribute(writer, "href", "#tabs-" + i);
                    }
                    writer.append(title == null ? "" : title);
                    writer.endElement("a");
                    writer.endElement("li");
                }
            }
            i++;
        }
        writer.endElement("ul");
        Iterator tabIterator = component.getChildren().iterator();
        i = 0;
        while (tabIterator.hasNext())
        {
            UIComponent comp = (UIComponent) tabIterator.next();
            if (comp instanceof UITabPanel)
            {
                UITabPanel tp = ((UITabPanel) comp);
                if (tp.isRendered())
                {
                    if (tp.getLink() == null || String.valueOf(tp.getLink()).trim().length() == 0)
                    {
                        writer.startElement("div", null);
                        getUtils().writeAttribute(writer, "id", "tabs-" + i);
                        int tpCnt = tp.getChildCount();
                        if (tpCnt > 0)
                            renderChildren(context, tp);
                        else
                            writer.append(tp.getContent() == null ? "" : String.valueOf(tp.getContent()));
                        writer.endElement("div");
                    }
                }
            }
            i++;
        }

        //
        writer.startElement("script", null);
        getUtils().writeAttribute(writer, "type", "text/javascript");
        js.append("});");// tab options
        // $( ".selector" ).tabs( "option", "active", 1 );
        if (tab.isKeepState())
        {
            js.append("jQuery('#").append(jQueryClientId)
                    .append("').tabs('option','selected', parseInt(cookieManager.read('" + tabCookieName + "')));\n\r");
        }
        // $('.tabs-container ul.tabs').tabs('option','disabled', [0, 1,2]);
        if (disabledTabs != null && disabledTabs.length() > 0)
        {
            js.append("jQuery('#").append(jQueryClientId).append("').tabs('option','disabled', [")
                    .append(disabledTabs.toString()).append("]);");
        }
        js.append("});");
        writer.write(js.toString());
        writer.endElement("script");
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        writer.endElement("div");
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UITabs.class;
    }

    @Override
    public boolean getRendersChildren()
    {
        return false;
    }

}
