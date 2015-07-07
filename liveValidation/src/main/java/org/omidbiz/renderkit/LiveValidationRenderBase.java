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
import java.util.Random;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.resource.InternetResource;
import org.omidbiz.component.UILiveValidation;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class LiveValidationRenderBase extends HeaderResourcesRendererBase
{

	
	InternetResource[] jsResources = { getResource("/org/omidbiz/renderkit/html/script/lv.js")
             };

    InternetResource[] cssResources = { getResource("/org/omidbiz/renderkit/html/css/lv.css") };
    
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
	
    public void initializeMask(FacesContext context, UILiveValidation component) throws IOException
    {

        String type = (String) component.getAttributes().get("type");
        UIComponent parent = component.getParent();


        if (type != null && parent != null)
        {
           Boolean onlyOnSubmit = (Boolean) component.getAttributes().get("onlyOnSubmit");
           String failureMessage = (String) component.getAttributes().get("failureMessage");
           failureMessage = failureMessage == null ? "Invalid":failureMessage;
           Random rand = new Random();	
           String lvId = "lv_"+ rand.nextInt(100);
           StringBuilder sb = new StringBuilder("jQuery(document).ready(function(){");
           sb.append(String.format(" var %s = new LiveValidation('%s', {onlyOnSubmit: true}); ", lvId, parent.getClientId(context)));
           sb.append(lvId).append(".add( Validate.").append(type).append(String.format(" , {failureMessage: '%s'}); ", failureMessage));
           sb.append("});");
           getUtils().writeScript(context, component, sb.toString());
        }
    }

   

    @Override
    protected Class getComponentClass()
    {
        return UILiveValidation.class;
    }

}
