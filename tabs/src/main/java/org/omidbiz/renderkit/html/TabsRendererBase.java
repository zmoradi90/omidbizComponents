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

    InternetResource[] jsResources = { getResource("/org/omidbiz/renderkit/html/script/tabManager.js"),
            getResource("/org/omidbiz/renderkit/html/script/jquery.ui.core.js"),
            getResource("/org/omidbiz/renderkit/html/script/jquery.ui.widget.js"),
            getResource("/org/omidbiz/renderkit/html/script/jquery.ui.tabs.js") };

    InternetResource[] cssResources = { getResource("/org/omidbiz/renderkit/html/css/jquery.ui.theme.css"),
            getResource("/org/omidbiz/renderkit/html/css/jquery.ui.tabs.css"),
            getResource("org/omidbiz/images/ui-bg_highlight-soft_75_cccccc_1x100.png"),
            getResource("org/omidbiz/images/ui-bg_flat_75_ffffff_40x100.png"),
            getResource("org/omidbiz/images/ui-bg_glass_75_e6e6e6_1x400.png"),
            getResource("org/omidbiz/images/ui-bg_glass_75_dadada_1x400.png"), getResource("org/omidbiz/images/loading.gif"),
            getResource("org/omidbiz/images/ui-bg_glass_65_ffffff_1x400.png") };


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
            js.append(" tabManager.writeCookie('" + tabCookieName + "', ui.index); } ");
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
        boolean hasIframe = false;
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
                    String imageSrc = (String) tp.getImageSrc();
                    String imageOnClick = (String) tp.getImageOnClick();
                    String link = (String) tp.getLink();
                    boolean useIframe = tp.isUseIframe();
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
                    if ((link != null && link.trim().length() > 0) && useIframe == false)
                    {
                        StringBuilder linkWithparams = new StringBuilder(link);
                        if (tp.isIncludePageParams())
                        {
                            addParametersToLink(context, linkWithparams);
                        }
                        getUtils().writeAttribute(writer, "href", linkWithparams.toString());
                    }
                    else if ((link != null && link.trim().length() > 0) && useIframe)
                    {
                        StringBuilder linkWithparams = new StringBuilder(link);
                        if (tp.isIncludePageParams())
                        {
                            addParametersToLink(context, linkWithparams);
                        }
                        getUtils().writeAttribute(writer, "href", "#tabs-iframe-" + i);
                        getUtils().writeAttribute(writer, "rel", linkWithparams.toString());
                        getUtils().writeAttribute(writer, "class", "iframe-tab");
                        getUtils().writeAttribute(writer, "data-tabindex", i);
                    }
                    else
                    {
                        getUtils().writeAttribute(writer, "href", "#tabs-" + i);
                    }
                    writer.append(title == null ? "" : title);
                    //
                    if (imageSrc != null && imageSrc.trim().length() > 0)
                    {
                        writer.startElement("img", null);
                        getUtils().writeAttribute(writer, "src", imageSrc);
                        getUtils().writeAttribute(writer, "alt", title);
                        if (imageOnClick != null)
                            getUtils().writeAttribute(writer, "onclick", imageOnClick);
                        getUtils().writeAttribute(writer, "class", "tab-image");
                        writer.endElement("img");
                    }
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
                    else
                    {
                        if (tp.isUseIframe())
                        {
                            hasIframe = true;
                            writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "id", "tabs-iframe-" + i);
                            writer.endElement("div");
                        }
                    }
                }
            }
            i++;
        }

        //
        writer.startElement("script", null);
        getUtils().writeAttribute(writer, "type", "text/javascript");
        js.append("});");// tab options
        if (tab.isKeepState())
        {
            js.append("jQuery('#").append(jQueryClientId)
                    .append("').tabs('option','selected', parseInt(tabManager.readCookie('" + tabCookieName + "')));\n\r");
        }
        //
        if (hasIframe)
        {
            js.append(String.format(" var tabIndexActive = jQuery('#%s').tabs('option', 'selected'); ", jQueryClientId));
            js.append(String.format(" var beginTab = jQuery('#%s ul li:eq('+%s+')').find('a'); ", jQueryClientId, "tabIndexActive"));
            js.append(" var dataTabIndex = jQuery(beginTab).data( 'tabindex'); ");
            js.append(" if(jQuery(beginTab).attr('rel')) { ");
            js.append(" tabManager.loadTabFrame(jQuery(beginTab).attr('href'), jQuery(beginTab).attr('rel'), dataTabIndex); ");
            js.append(" } ");
            js.append(" jQuery('a.iframe-tab').click(function() { ");
            js.append(" tabManager.loadTabFrame(jQuery(this).attr('href'),jQuery(this).attr('rel'), jQuery(this).data( 'tabindex')); }); "                    );
        }
        // $('.tabs-container ul.tabs').tabs('option','disabled', [0, 1,2]);
        if (disabledTabs != null && disabledTabs.length() > 0)
        {
            js.append("jQuery('#").append(jQueryClientId).append("').tabs('option','disabled', [").append(disabledTabs.toString())
                    .append("]);");
        }
        js.append("});");
        writer.write(js.toString());
        writer.endElement("script");
    }

    private void addParametersToLink(FacesContext context, StringBuilder originalLink)
    {
        ExternalContext external = context.getExternalContext();
        Map<String, String> requestParams = external.getRequestParameterMap();
        if (requestParams != null && requestParams.size() > 0)
        {
            originalLink.append("?");
            int cnt = 0;
            for (Map.Entry<String, String> entry : requestParams.entrySet())
            {
                if (cnt > 0)
                    originalLink.append("&");
                originalLink.append(entry.getKey()).append("=").append(entry.getValue());
                cnt++;
            }
        }
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
