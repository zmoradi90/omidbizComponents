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

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

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
    
}
