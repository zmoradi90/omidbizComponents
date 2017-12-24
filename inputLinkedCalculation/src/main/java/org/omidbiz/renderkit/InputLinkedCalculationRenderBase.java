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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.renderkit.RendererUtils;
import org.omidbiz.component.UIInputLinkedCalculation;

/**
 * 
 * @author Shahrad Kashani
 * @version $Revision: 1.0
 * 
 */
public class InputLinkedCalculationRenderBase extends HeaderResourcesRendererBase
{
    private Object id = new Object();

    public void initializeMask(FacesContext context, UIInputLinkedCalculation component) throws IOException
    {


    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIInputLinkedCalculation.class;
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
    protected void doDecode(FacesContext context, UIComponent component)
    {
        
        
    } 
    public String getId(FacesContext context, UIInputLinkedCalculation component)
    {
        UIComponent parentComponent = component.getParent();
        if(component.getAttributes().get("forceId") != null)
        {
            String clientId = (String) component.getAttributes().get("forceId");
            return clientId;
        }
        else if(parentComponent != null)
        {
            String clientId = parentComponent.getClientId(context).replace(":", "\\\\:");
            return clientId;
        }
        return "";
    }
    public String getTargetIds(FacesContext context, UIInputLinkedCalculation component)
    {
        String targetIds = (String) component.getAttributes().get("targetIds");
        String result = null;
        if (targetIds != null)
        {            
            String[] targetIdsList = targetIds.split(",");
            for (String str : targetIdsList)
            {
                result += "#"+RendererUtils.getInstance().findComponentFor(component, (String) targetIds).getClientId(context).replace(":", "\\\\:")+",";
            }
            return result;
        }
        return "";
    }
    public String getOutputIds(FacesContext context, UIInputLinkedCalculation component)
    {
        String outputIds = (String) component.getAttributes().get("outputIds");
        String result = null;
        if (outputIds != null)
        {            
            String[] targetIdsList = outputIds.split(",");
            for (String str : targetIdsList)
            {
                result += "#"+RendererUtils.getInstance().findComponentFor(component, (String) outputIds).getClientId(context).replace(":", "\\\\:")+",";
            }
            return result;
        }
        return "";
    }
    public String getDateId(FacesContext context, UIInputLinkedCalculation component)
    {
        String dateId = (String) component.getAttributes().get("dateId");
        String result = null;
        if (dateId != null)
        {            
            result += "#"+RendererUtils.getInstance().findComponentFor(component, (String) dateId).getClientId(context).replace(":", "\\\\:");
            return result;
        }
        return "";
    }

}
