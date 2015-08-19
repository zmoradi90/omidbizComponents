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

import org.ajax4jsf.context.AjaxContext;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIDonut;

/**
 * 
 * @author Shahrad Kashani
 * @version $Revision: 1.0
 * 
 */
public class DonutRenderBase extends HeaderResourcesRendererBase
{

    public void initializeMask(FacesContext context, UIDonut component) throws IOException
    {
    	String clientId = component.getClientId(context);
    	ResponseWriter writer = context.getResponseWriter();
    	writer.startElement("div", null);
    	getUtils().writeAttribute(writer, "class", "donut-window");
    		writer.startElement("div", null);
        		getUtils().writeAttribute(writer, "class", "donut-frame");
        		writer.startElement("div", null);
        			getUtils().writeAttribute(writer, "class", "donut-panel-up");
        				writer.startElement("canvas", null);
        					getUtils().writeAttribute(writer, "width", "50");
        					getUtils().writeAttribute(writer, "height", "50");
        					getUtils().writeAttribute(writer, "id",clientId+"_cv");
        				writer.endElement("canvas");
        				writer.startElement("div", null);
    						getUtils().writeAttribute(writer, "class", "donut-value");
    							Object value = (Object) component.getAttributes().get("value");
    							if(value != null)
    								writer.writeText("%"+String.valueOf(value), null);
    				        	if(component.getAttributes().get("title")!=null)
    				        	{
    				        		writer.startElement("div", null);
    				        		getUtils().writeAttribute(writer, "id",clientId);
    				        		getUtils().writeAttribute(writer, "class","donut-title");
    				        		getUtils().writeAttribute(writer, "title",component.getAttributes().get("title"));
    				        		
    				        		writer.endElement("div");
    				        	}
        				writer.endElement("div");
        		writer.endElement("div");
        		writer.startElement("div", null);
    				getUtils().writeAttribute(writer, "class", "donut-panel-down");
    					writer.startElement("div", null);
    						getUtils().writeAttribute(writer, "class", "donut-caption");
    						Object caption = (Object) component.getAttributes().get("caption");
							if(caption != null)
								writer.writeText(String.valueOf(caption), null);
							else
								writer.writeText("بدون عنوان", null);
    					writer.endElement("div");
    			writer.endElement("div");

        	writer.endElement("div");
    	writer.endElement("div");
    	
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        
    }

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        
    }
    
    
    public String getJQueryId(FacesContext context, UIDonut component)
    {
    	return component.getClientId(context).replace(":", "\\\\:");
    }

    @Override
    protected Class getComponentClass()
    {
        return UIDonut.class;
    }

}
