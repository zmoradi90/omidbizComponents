package org.omidbiz.renderkit.html;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.resource.InternetResource;
import org.omidbiz.component.UISuggestion;

public class SuggestionRendererBase extends HeaderResourcesRendererBase
{

    InternetResource[] jsResources = { getResource("/org/omidbiz/renderkit/html/script/qtip.js"),
            getResource("/org/omidbiz/renderkit/html/script/suggestionManager.js") };

    InternetResource[] cssResources = { getResource("/org/omidbiz/renderkit/html/css/qtip.css") };

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
        UISuggestion sugesstion = (UISuggestion) component;
        String forceId = (String) sugesstion.getForceId();//(String) component.getAttributes().get("forceId");
        String componentId = clientId.replace(":", "\\\\:");
        componentId = forceId.replace(":", "\\\\:");
        String view = (String) sugesstion.getView();//(String) component.getAttributes().get("view");
        encodeInput(writer, context, component, componentId);
        generateScripts(context, component, componentId, view);
    }

    private String generateQueryStrings(UIComponent component)
    {        
        List<UIComponent> children = component.getChildren();
        StringBuilder params = null;
        if(children != null && children.size() > 0)
        {
            params = new StringBuilder("?");
            int i =0;
            for (UIComponent uiComponent : children)
            {
                if(uiComponent instanceof UIParameter)
                {
                    if(i > 0)
                        params.append("&");
                    UIParameter param = (UIParameter) uiComponent;
                    //TODO : urlencode
                    params.append(param.getName()).append("=").append(param.getValue());
                    i++;
                }
            }
        }        
        return params == null ? "" : params.toString();
    }

    private void generateScripts(FacesContext context, UIComponent component, String componentId, String baseUrl) throws IOException
    {
        StringBuffer script = new StringBuffer();
        script.append("jQuery(document).ready(function(){");
        script.append("var timer =0;");
        String url = baseUrl + generateQueryStrings(component);
        script.append(String.format("sm.createQtip('%s', '%s');", componentId, url));
        script.append(String.format("jQuery(\"#%s\").keyup(function(){", componentId));
        script.append("if (timer) {clearTimeout(timer);}");
        script.append("var par = {};");
//        script.append("var baseUrl ='").append(baseUrl).append("';");
        List<UIComponent> children = component.getChildren();
        if(children != null && children.size() > 0)
        {
            for (UIComponent uiComponent : children)
            {
                if(uiComponent instanceof UIParameter)
                {
                    UIParameter par = (UIParameter)uiComponent;
                    if(par.getValue() instanceof String)
                        script.append("par[\"").append(par.getName()).append("\"]").append("='").append(par.getValue()).append("'; ");
                    else
                        script.append("par[\"").append(par.getName()).append("\"]").append("=").append(par.getValue()).append("; ");
                }
            }
        }
        script.append("par[\"").append(componentId).append("\"]").append("=").append("jQuery(this).val();");
        script.append(String.format("timer = setTimeout(sm.searchAndReload, 600, '%s', '%s', par);", componentId, baseUrl+"?"));
        script.append("});});");
        getUtils().writeScript(context, component, script);
    }

    private void encodeInput(ResponseWriter writer, FacesContext context, UIComponent component, String componentId) throws IOException
    {
        writer.startElement("input", null);
        getUtils().writeAttribute(writer, "type", "text");
        getUtils().writeAttribute(writer, "id", componentId);
        getUtils().writeAttribute(writer, "name", componentId);
        writer.endElement("input");
        //
        
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UISuggestion.class;
    }

    @Override
    public boolean getRendersChildren()
    {
        return false;
    }

}
