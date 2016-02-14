package org.omidbiz.renderkit.html;

import java.io.IOException;
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
import org.omidbiz.component.UISuggestionButton;
import org.omidbiz.util.JSFUtil;

public class SuggestionButtonRendererBase extends HeaderResourcesRendererBase
{

    InternetResource[] jsResources = { getResource("/org/omidbiz/renderkit/html/script/qtip.js") };

    @Override
    protected InternetResource[] getScripts()
    {
        return jsResources;
    }

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        String clientId = component.getClientId(context);
        UISuggestionButton sbutton = (UISuggestionButton) component;
        String forceId = (String) sbutton.getForceId();
        String jsFuncName = "closeSuggestion_" + forceId;
        //
        StringBuilder onclick = new StringBuilder(jsFuncName).append("(");
        Object valueId = sbutton.getValueId();
        if (valueId != null)
            onclick.append(valueId).append(",");
        Object valueName = sbutton.getValueName();
        if (valueName instanceof String)
            onclick.append("'").append(valueName).append("'");
        else
            onclick.append(valueName);
        onclick.append(")");

        writer.startElement("span", null);
        getUtils().writeAttribute(writer, "onclick", onclick.toString());
        getUtils().writeAttribute(writer, "style", "cursor:pointer;");
        String txt = (String) sbutton.getTextMessage();
        if(JSFUtil.isNotEmpty(txt))
            writer.write(txt);
        else
            writer.write("select");
        writer.endElement("span");
        StringBuilder script = new StringBuilder();
        script.append("function ").append(jsFuncName).append("(");
        if (valueId != null)
            script.append("valueId").append(",");
        script.append("valueName").append(")");
        script.append("{").append(String.format("jQuery('#%s', window.parent.document).val(valueName);", forceId));
        if (valueId != null)
            script.append(String.format("jQuery('#%s', window.parent.document).val(valueId);", forceId + SuggestionRendererBase.HIDDEN_COMP));
        //
        script.append("}");
        //
        
        getUtils().writeScript(context, component, script.toString());

    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UISuggestionButton.class;
    }

    @Override
    public boolean getRendersChildren()
    {
        return false;
    }

}
