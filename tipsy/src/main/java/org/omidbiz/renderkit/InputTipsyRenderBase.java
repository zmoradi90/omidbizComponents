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

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputTipsy;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class InputTipsyRenderBase extends HeaderResourcesRendererBase
{

	public void initializeMask(FacesContext context, UIInputTipsy component) throws IOException
	{

		

		UIComponent parentComponent = component.getParent();
		ResponseWriter writer = context.getResponseWriter();

		if (parentComponent != null)
		{
			StringBuilder sb = new StringBuilder("jQuery(document).ready(function(){");
			Boolean html = (Boolean)component.getAttributes().get("html");
			String gravity = (String)component.getAttributes().get("gravity");
			if(html != null && html)
				sb.append(" jQuery(\"#" + parentComponent.getClientId(context).replace(":", "\\\\:") + "\").tipsy({fade: true, gravity: '"+gravity+"', html: true})");
			else	
				sb.append(" jQuery(\"#" + parentComponent.getClientId(context).replace(":", "\\\\:") + "\").tipsy({fade: true, gravity: '"+gravity+"'})");
			sb.append("});");
			getUtils().writeScript(context, component, sb.toString());
		}
	}

	@Override
	protected Class getComponentClass()
	{
		return UIInputTipsy.class;
	}

}
