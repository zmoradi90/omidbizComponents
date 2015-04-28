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
import org.omidbiz.component.UIStatusModal;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class StatusModalRenderBase extends HeaderResourcesRendererBase
{

	public void initializeMask(FacesContext context, UIStatusModal component) throws IOException
	{

		String funcName = (String) component.getAttributes().get("funcName");
		String title = (String) component.getAttributes().get("title");
		String styleClass = (String) component.getAttributes().get("styleClass");
		String text = (String) component.getAttributes().get("text");
		String forAttr = (String) component.getAttributes().get("for");

		UIComponent parentComponent = component.getParent();
		ResponseWriter writer = context.getResponseWriter();

		if (parentComponent != null && funcName != null)
		{
			StringBuilder sb = new StringBuilder();
			String varName = forAttr + "_" + funcName;
			sb.append("var ").append(varName).append("; ");
			sb.append(" function show_");
			sb.append(funcName.replace(":", "\\\\:"));
			sb.append("(){");
			sb.append(" var spin_target = document.getElementById('"+forAttr+"'); ");
			sb.append(varName).append(" = new Spinner(opts).spin(spin_target); ");
			sb.append("}");
			//stop function			
			sb.append(" function stop_");
			sb.append(funcName.replace(":", "\\\\:"));
			sb.append("(){ ");
			sb.append(varName).append(".stop(); ");			
			sb.append(" } ");
			getUtils().writeScript(context, component, sb.toString());						
		}
		writer.startElement("div", component);
		getUtils().writeAttribute(writer, "id", forAttr);		
		writer.endElement("div");
	}

	@Override
	protected Class getComponentClass()
	{
		return UIStatusModal.class;
	}

}
