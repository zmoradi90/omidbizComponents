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
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.context.AjaxContext;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIProgressbar;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class ProgressbarRenderBase extends HeaderResourcesRendererBase
{

    public void initializeMask(FacesContext context, UIProgressbar component) throws IOException
    {

        String clientId = component.getClientId(context);
        String loadingMode = component.getAttributes().get("loadingMode") == null ? "determinate" : "indeterminate";
        ResponseWriter writer = context.getResponseWriter();
        Object precisionAttr = (Object)component.getAttributes().get("precision");
        Integer precisionInt = null;
        String precisionStr = null;
        if(precisionAttr instanceof Integer)
            precisionInt = (Integer) precisionAttr;
        if(precisionAttr instanceof String)
        {
            precisionStr = (String) precisionAttr;
            precisionInt = Math.round(Float.valueOf(precisionStr));
        }
        
        Object valueAttr = (Object) component.getAttributes().get("value");
        BigDecimal valueBig = BigDecimal.ZERO;
        if(valueAttr == null)
            valueAttr = BigDecimal.ZERO;
        if(valueAttr instanceof String)
        {
            valueBig = new BigDecimal((String)valueAttr);
        }
        if(valueAttr instanceof BigDecimal)
        {
            valueBig = (BigDecimal) valueAttr;
        }
        if(valueAttr instanceof Long)
        {
            valueBig = BigDecimal.valueOf((Long)valueAttr);
        }
        if(valueAttr instanceof Double)
        {
            valueBig = BigDecimal.valueOf((Double)valueAttr);
        }
        if(valueBig.compareTo(BigDecimal.ZERO) < 0)
            throw new IOException("value attribute could not be less than zero (negative number) in progressbar component.");
        if(precisionAttr == null)
            throw new IOException("precision attribute could not be null / empty in progressbar component.");
        BigDecimal value = valueBig.divide(BigDecimal.ONE, precisionInt, RoundingMode.HALF_UP);
        writer.startElement("div", null);
            getUtils().writeAttribute(writer, "id", clientId);
            getUtils().writeAttribute(writer, "class", "row");
            getUtils().writeAttribute(writer, "style", "float:none");

            writer.startElement("div", null);
                getUtils().writeAttribute(writer, "class"," col s"+component.getAttributes().get("width"));
                    writer.startElement("div", null);
                    getUtils().writeAttribute(writer, "class", "progress");

                        writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "class", "percentage");
                            if(new BigDecimal(60).compareTo(value) > 0)
                                getUtils().writeAttribute(writer, "style", "left:"+value+"%");
                            else
                                getUtils().writeAttribute(writer, "style", "right:"+(new BigDecimal(100)).subtract(value)+"%");
                            writer.writeText("%"+value, null);
                        writer.endElement("div");
                        writer.startElement("div", null);
                            getUtils().writeAttribute(writer, "class", loadingMode);
                            if(String.valueOf(component.getAttributes().get("isSematicValue")).equals("true"))
                                getUtils().writeAttribute(writer, "style", "width:"+value+"%;background-color:"+isSemanticvalue(value));
                            else 
                                getUtils().writeAttribute(writer, "style", "width:"+value+"%");
                        writer.endElement("div");
                        
                    writer.endElement("div");

                writer.endElement("div");
        writer.endElement("div");
    }

    public String isSemanticvalue(BigDecimal value){
        
        if(value.compareTo(new BigDecimal(70)) > 0)
            return "#22B573";
        else if (value.compareTo(new BigDecimal(40)) > 0)
            return "#FABB72";
        else 
            return "#ED1C24";
    }
    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {

    }

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {

    }

    @Override
    protected Class getComponentClass()
    {
        return UIProgressbar.class;
    }

}
