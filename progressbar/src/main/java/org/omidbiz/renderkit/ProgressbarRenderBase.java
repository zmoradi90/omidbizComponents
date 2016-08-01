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
        BigDecimal remainPercentage = new BigDecimal(100).subtract(value);
        writer.startElement("div", null);
            getUtils().writeAttribute(writer, "id", clientId);
            getUtils().writeAttribute(writer, "class", "progress-bar-box");
            getUtils().writeAttribute(writer, "style", "height:"+component.getAttributes().get("height")+
                    "px; width:"+component.getAttributes().get("width")+"px;");
            writer.startElement("div", null);
            getUtils().writeAttribute(writer, "class", "progress-bar-percent");
            getUtils().writeAttribute(writer, "style", "width:"+value+"%;");
                writer.startElement("div", null);
                getUtils().writeAttribute(writer, "class", "progress-bar-percent-caption");
                if(value.compareTo(new BigDecimal(70)) > 0)
                {
                    writer.writeText("%"+value, null);
                }
                writer.endElement("div");
            writer.endElement("div");
            
            
            writer.startElement("div", null);
            getUtils().writeAttribute(writer, "class", "progress-bar-percent-remaind");
            getUtils().writeAttribute(writer, "style", "width:"+remainPercentage+"%;");
                writer.startElement("div", null);
                getUtils().writeAttribute(writer, "class", "progress-bar-percent-remaind-caption");
                if(value.compareTo(new BigDecimal(70)) < 0)
                {
                    writer.writeText("%"+value, null);
                }
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

    @Override
    protected Class getComponentClass()
    {
        return UIProgressbar.class;
    }

}
