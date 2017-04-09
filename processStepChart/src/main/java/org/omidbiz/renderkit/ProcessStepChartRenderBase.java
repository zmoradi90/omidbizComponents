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
import java.util.TreeMap;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIProcessStepChart;

/**
 * 
 * @author Shahrad Kashani
 * @version $Revision: 1.0
 * 
 */
public class ProcessStepChartRenderBase extends HeaderResourcesRendererBase
{
    private Object id = new Object();

    public void initializeMask(FacesContext context, UIProcessStepChart component) throws IOException
    {
        List<ProcessStep> processStepArray = (List<ProcessStep>) component.getAttributes().get("processStepModel");
        ResponseWriter writer = context.getResponseWriter();
        
        writer.startElement("div", null);
            getUtils().writeAttribute(writer, "id",getId(context, component));
            getUtils().writeAttribute(writer, "class","process-step-chart");
            
                writer.startElement("div", null);
                getUtils().writeAttribute(writer, "class","row steps");
                if(processStepArray == null)
                  return;
                
                Boolean notFirstTime = false;
                
                    for (ProcessStep processStep : processStepArray)
                    {
                        writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "class","step");
                            if(notFirstTime)
                                getUtils().writeAttribute(writer, "status","disabled");
                            
                            writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "class","step-sign");
                            
                                writer.startElement("div", null);
                                getUtils().writeAttribute(writer, "class","text");
                                    writer.writeText(processStep.getStepCaption(), null);
                                writer.endElement("div");
                            
                            writer.endElement("div");
                            
                            writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "class","step-items");
                            
                                    writer.startElement("div", null);
                                    getUtils().writeAttribute(writer, "class","step-item");
    
                                            writer.startElement("div", null);
                                            getUtils().writeAttribute(writer, "class","step-form");
                                            
                                                writer.startElement("div", null);
                                                getUtils().writeAttribute(writer, "class","col");
                                                
                                                    writer.startElement("div", null);
                                                    getUtils().writeAttribute(writer, "class","forms");
                                                    
                                                        writer.startElement("label", null);
                                                            
                                                        writer.endElement("label");
                                                        
                                                    writer.endElement("div");
                                                    
                                                    writer.startElement("div", null);
                                                    getUtils().writeAttribute(writer, "class","forms-desc");
                                                    
                                                                                                           
                                                        for (ProcessStepField processStepField :  processStep.getProcessStepFieldList())
                                                        {
                                                            if(processStepField.getFieldType() == ProcessStepFieldType.numeric)
                                                            {
                                                                writer.startElement("input", null);
                                                                getUtils().writeAttribute(writer, "id",processStep.getStepCaptionKey()+"_"+processStepField.getFieldKey());
                                                                getUtils().writeAttribute(writer, "name",processStep.getStepCaptionKey()+"_"+processStepField.getFieldKey());
                                                                getUtils().writeAttribute(writer, "type","text");
                                                                getUtils().writeAttribute(writer, "onkeydown","onlyNumeric(event)");
                                                                getUtils().writeAttribute(writer, "placeholder",processStepField.getFieldCaption());
                                                                writer.endElement("input");                                                                
                                                            }
                                                            else
                                                            {
                                                                writer.startElement("input", null);
                                                                getUtils().writeAttribute(writer, "id",processStep.getStepCaptionKey()+"_"+processStepField.getFieldKey());
                                                                getUtils().writeAttribute(writer, "name",processStep.getStepCaptionKey()+"_"+processStepField.getFieldKey());
                                                                getUtils().writeAttribute(writer, "type","text");
                                                                getUtils().writeAttribute(writer, "placeholder",processStepField.getFieldCaption());
                                                                writer.endElement("input");
                                                            }
                                                        }
                                                    writer.endElement("div");
                                                    
                                                writer.endElement("div");
                                            
                                        writer.endElement("div");
                                writer.endElement("div");
                            writer.endElement("div");
                            
                            writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "class","selector");
                                writer.startElement("input", null);
                                    getUtils().writeAttribute(writer, "type","radio");
                                    getUtils().writeAttribute(writer, "name","stepSelect");
                                    getUtils().writeAttribute(writer, "value",processStep.getStepCaptionKey());
                                    if(!notFirstTime)
                                    {
                                        getUtils().writeAttribute(writer, "checked","checked");
                                        notFirstTime = true; 
                                    }
                                writer.endElement("input");
                            writer.endElement("div");
                        writer.endElement("div");

                    }
                
                writer.endElement("div");
                
        writer.endElement("div");
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIProcessStepChart.class;
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    @Override
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        renderChildren(context, component);
    }

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        List<ProcessStep> processStepList = (List<ProcessStep>) component.getAttributes().get("processStepModel");
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIProcessStepChart processStepChart = (UIProcessStepChart) component;
        String forceId = (String) processStepChart.getAttributes().get("forceId");
        String clientId = processStepChart.getClientId(context);
        Map<String,Object> resultMap = new TreeMap<String, Object>();
        if (forceId != null && forceId.length() > 0)
            clientId = forceId;
        for (ProcessStep processStep : processStepList)
        {
            if(processStep.getProcessStepFieldList() != null && processStep.getProcessStepFieldList().size() > 0)
            {
                for (ProcessStepField processStepField : processStep.getProcessStepFieldList())
                {
                    String key = processStep.getStepCaptionKey()+"_"+processStepField.getFieldKey();
                    String submittedValue = (String) requestParams.get(key);
                    if(processStepField.getFieldType().equals(ProcessStepFieldType.numeric) || processStepField.getFieldType().equals(ProcessStepFieldType.textBox))
                    {
                        resultMap.put(key,submittedValue);
                    }
                }
            }
        }
        if (resultMap != null && resultMap.size() > 0)
        {
            processStepChart.setSubmittedValue(resultMap);
        }
    }

    public String getJQueryId(FacesContext context, UIProcessStepChart component)
    {

        return getId(context, component).replace(":", "\\\\:");
    }

    public String getId(FacesContext context, UIProcessStepChart component)
    {
        if (component.getAttributes().get("forceId") != null)
            id = (Object) component.getAttributes().get("forceId");
        else
            id = component.getClientId(context);
        return id.toString();
    }

}
