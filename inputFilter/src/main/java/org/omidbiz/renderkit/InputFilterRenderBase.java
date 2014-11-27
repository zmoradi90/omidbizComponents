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
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ajax4jsf.context.AjaxContext;
import org.ajax4jsf.renderkit.AjaxComponentRendererBase;
import org.ajax4jsf.renderkit.AjaxRendererUtils;
import org.omidbiz.component.InputFilterEvent;
import org.omidbiz.component.UIInputFilter;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class InputFilterRenderBase extends AjaxComponentRendererBase
{

    protected void doDecode(FacesContext facesContext, UIComponent uiComponent)
    {
        System.out.println("DFGGGGGGGGGGGGFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFf");
        // super.decode must not be called, because value is handled here
        if (isSubmitted(facesContext, uiComponent))
        {
            UIInputFilter inputFilter = (UIInputFilter) uiComponent;
            ExternalContext external = facesContext.getExternalContext();
            Map requestParams = external.getRequestParameterMap();
            String clientId = inputFilter.getClientId(facesContext);
            String submittedValue = (String) requestParams.get(clientId);
            //
            ActionEvent event;
            event = new ActionEvent(uiComponent);
            uiComponent.queueEvent(event);
            //
            uiComponent.queueEvent(new InputFilterEvent(uiComponent, submittedValue));
            System.out.println("Submited Value : ");
            System.out.println(submittedValue);
            //
            inputFilter.setSubmittedValue(submittedValue);
        }
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

    public void encodeChildren(FacesContext context, UIComponent component) throws IOException
    {
        renderChildren(context, component);
    }

    public Object getValue(UIComponent uiComponent)
    {
        if (uiComponent instanceof ValueHolder)
        {
            return ((ValueHolder) uiComponent).getValue();
        }
        return uiComponent.getAttributes().get("value");
    }

    protected boolean isSubmitted(FacesContext facesContext, UIComponent uiComponent)
    {
        // Componet accept only ajax requests.
        if (!AjaxContext.getCurrentInstance(facesContext).isAjaxRequest())
        {
            return false;
        }
        if (getUtils().isBooleanAttribute(uiComponent, "disabled"))
        {
            return false;
        }
        String clientId = uiComponent.getClientId(facesContext);
        Map<String, String> paramMap = facesContext.getExternalContext().getRequestParameterMap();
        Object value = paramMap.get(clientId);
        boolean submitted = null != value;
        System.out.println("Sbmited : " + submitted);
        return submitted;
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIInputFilter.class;
    }

}
