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
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputDurationPicker;

/**
 * 
 * @author Shahrad Kashani
 * @version $Revision: 1.0
 * 
 */
public class InputDurationPickerRenderBase extends HeaderResourcesRendererBase
{
    private Object id = new Object();

    public void initializeMask(FacesContext context, UIInputDurationPicker component) throws IOException
    {
        
        Object id = new Object();
        Number value = null;
        String unit = (String) component.getAttributes().get("unit");
        String valueType = (String) component.getAttributes().get("valueType");
        String negativeToggleButtonId = (String) component.getAttributes().get("negativeToggleButtonId");
        String m = (String) component.getAttributes().get("minuteSummary");
        String h = (String) component.getAttributes().get("hourSummary");
        String d = (String) component.getAttributes().get("daySummary");
        String M = (String) component.getAttributes().get("monthSummary");
        String y = (String) component.getAttributes().get("yearSummary");
        String n = (String) component.getAttributes().get("negativeSummary");
        
        if("Integer".equals(valueType) && component.getAttributes().get("value")!=null)
        {
            value = Integer.valueOf((String)component.getAttributes().get("value"));
        }
        if("Double".equals(valueType) && component.getAttributes().get("value")!=null)
        {
            value = (Double) component.getAttributes().get("value");
        }
        else if(component.getAttributes().get("value")!=null)
        {
            value = (BigDecimal)component.getAttributes().get("value");
        }
        else
        {
        	value = 0;
        }
        if (component.getAttributes().get("forceId") != null)
            id = (Object) component.getAttributes().get("forceId");
        else
            id = component.getClientId(context);

        
        

        
        Integer wrapperWidth = Integer.parseInt((String) component.getAttributes().get("width"));
        Integer inputWidth = (Integer.parseInt((String) component.getAttributes().get("width"))) - 30;
        Integer inputHeight = Integer.parseInt((String) component.getAttributes().get("height"));
        
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", null);
        getUtils().writeAttribute(writer, "class","duration-picker");
        getUtils().writeAttribute(writer, "style","width:"+wrapperWidth+";");
        writer.startElement("div", null);
        getUtils().writeAttribute(writer, "id",id+"Dp");
        getUtils().writeAttribute(writer, "onclick","durationInit"+negativeToggleButtonId+"(event,this)");
        getUtils().writeAttribute(writer, "class","type-indicator");
            writer.startElement("div", null);
            getUtils().writeAttribute(writer, "class","duration-icon");
                writer.startElement("img", null);
                getUtils().writeAttribute(writer, "width","15px");
                getUtils().writeAttribute(writer, "src","data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhLS0gR2VuZXJhdG9yOiBBZG9iZSBJbGx1c3RyYXRvciAxNi4wLjAsIFNWRyBFeHBvcnQgUGx1Zy1JbiAuIFNWRyBWZXJzaW9uOiA2LjAwIEJ1aWxkIDApICAtLT4NCjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DQo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IkxheWVyXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB3aWR0aD0iNTEycHgiIGhlaWdodD0iNTEycHgiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCA1MTIgNTEyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxwYXRoIGQ9Ik0yNTYsMEMxMTQuNjA5LDAsMCwxMTQuNjI1LDAsMjU2czExNC42MDksMjU2LDI1NiwyNTZjMTQxLjM3NSwwLDI1Ni0xMTQuNjI1LDI1Ni0yNTZTMzk3LjM3NSwwLDI1NiwweiBNMjU2LDQ0OA0KCWMtMTA1Ljg3NSwwLTE5Mi04Ni4xMjUtMTkyLTE5MlMxNTAuMTI1LDY0LDI1Niw2NHMxOTIsODYuMTI1LDE5MiwxOTJTMzYxLjg3NSw0NDgsMjU2LDQ0OHogTTQxNiwyNTZjMCwxNy42ODgtMTQuMzEzLDMyLTMyLDMySDI1Ng0KCWMtMTcuNjcyLDAtMzItMTQuMzEzLTMyLTMyVjEyOGMwLTE3LjY4OCwxNC4zMjgtMzIsMzItMzJzMzIsMTQuMzEzLDMyLDMydjk2aDk2QzQwMS42ODgsMjI0LDQxNiwyMzguMzEzLDQxNiwyNTZ6Ii8+DQo8L3N2Zz4NCg==");
                    
                writer.endElement("img");

            writer.endElement("div");
        writer.endElement("div");
            writer.startElement("input", null);
            getUtils().writeAttribute(writer, "type","text");
            getUtils().writeAttribute(writer, "id",id);
            if(value != null)
            {
                String resultValue = "";
                if( value.doubleValue() < 0)
                    resultValue = "n";
                resultValue = String.valueOf(Math.abs(value.doubleValue()));
                if(m.equals(unit))
                    resultValue += m;
                else if(d.equals(unit))
                    resultValue += d;
                else if(M.equals(unit))
                    resultValue += M;
                else if(y.equals(unit))
                    resultValue += y;
                else 
                    resultValue += h;
                
            		getUtils().writeAttribute(writer, "value",resultValue);
            }
            getUtils().writeAttribute(writer, "name",id);
            getUtils().writeAttribute(writer, "class","duration-picker-input");
            getUtils().writeAttribute(writer, "style","width:"+inputWidth+"px;height:"+inputHeight+"px;");

            writer.endElement("input");
            
            
            writer.startElement("div", null);
            getUtils().writeAttribute(writer, "class","measure");
            writer.endElement("div");

        writer.endElement("div");

    }

    private Map<String, Object> getAttributes()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIInputDurationPicker.class;
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
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIInputDurationPicker inputDurationPicker = (UIInputDurationPicker) component;
        String clientId;
        if (component.getAttributes().get("forceId") != null)
            clientId = (String) component.getAttributes().get("forceId");
        else
            clientId = component.getClientId(context);
        String submittedValue = (String) requestParams.get(clientId);
        if (submittedValue != null)
        {
            String valueType = (String) component.getAttributes().get("valueType");
            if(("Integer").equals(valueType))
            {
                inputDurationPicker.setSubmittedValue(decodeTime(context,inputDurationPicker,submittedValue).intValue());
            }
            if(("Double").equals(valueType))
            {
                inputDurationPicker.setSubmittedValue(decodeTime(context,inputDurationPicker,submittedValue).doubleValue());
            }
            else
            {
                inputDurationPicker.setSubmittedValue(decodeTime(context,inputDurationPicker,submittedValue));
            }
        }
    }
    public BigDecimal decodeTime(FacesContext context, UIInputDurationPicker component,String enCodeTime){
        
        String unit = (String) component.getAttributes().get("unit");
        BigDecimal resultTime = BigDecimal.ZERO;
        BigDecimal hourPerDay = new BigDecimal((String) component.getAttributes().get("hourPerDay"));
        BigDecimal dayPerMonth = new BigDecimal((String)component.getAttributes().get("dayPerMonth"));
        BigDecimal monthPerYear = new BigDecimal((String) component.getAttributes().get("monthPerYear"));
        BigDecimal dayPerYear = new BigDecimal((String)component.getAttributes().get("dayPerYear"));
        if(((String) component.getAttributes().get("hourPerDay")).equals("0") ||
                ((String) component.getAttributes().get("dayPerMonth")).equals("0") || 
                ((String) component.getAttributes().get("monthPerYear")).equals("0"))
        {
            try
            {
                throw new Exception("input duration picker: convert unit like hour per day x per y must not be zero");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return new BigDecimal(0);
        }
        String m = (String) component.getAttributes().get("minuteSummary");
        String h = (String) component.getAttributes().get("hourSummary");
        String d = (String) component.getAttributes().get("daySummary");
        String M = (String) component.getAttributes().get("monthSummary");
        String y = (String) component.getAttributes().get("yearSummary");
        String n = (String) component.getAttributes().get("negativeSummary");
        Boolean negativeSignFlag = false;
        Pattern p = Pattern.compile("(["+n+"])?([0-9|.|0-9]+)(["+y+"|"+M+
                "|"+d+"|"+h+"|"+m+
                "])+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(enCodeTime);
        while (matcher.find())
        {
            if(m.equals(unit))
            {
                if(matcher.group(3).equals(y))
                {
                    resultTime =  resultTime.add(new BigDecimal(matcher.group(2)).multiply(dayPerYear).multiply(hourPerDay).multiply(new BigDecimal(60)));
                }
                if(matcher.group(3).equals(M))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).multiply(dayPerMonth.multiply(hourPerDay).multiply(new BigDecimal(60)))));
                }
                if(matcher.group(3).equals(d))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).multiply(hourPerDay).multiply(new BigDecimal(60))));
                }
                if(matcher.group(3).equals(h))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2))));
                }
            }
            else if(h.equals(unit))
            {
                if(matcher.group(3).equals(y))
                {
                    resultTime =  resultTime.add(new BigDecimal(matcher.group(2)).multiply(dayPerYear).multiply(hourPerDay));
                }
                if(matcher.group(3).equals(M))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).multiply(dayPerMonth.multiply(hourPerDay))));
                }
                if(matcher.group(3).equals(d))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).multiply(hourPerDay)));
                }
                if(matcher.group(3).equals(h))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2))));
                }
                if(matcher.group(3).equals(m))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(new BigDecimal(60),2, RoundingMode.HALF_UP)));
                }
            }
            else if(d.equals(unit))
            {
                if(matcher.group(3).equals(y))
                {
                    resultTime =  resultTime.add(new BigDecimal(matcher.group(2)).multiply(dayPerYear));
                }
                if(matcher.group(3).equals(M))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).multiply(dayPerMonth)));
                }
                if(matcher.group(3).equals(d))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2))));
                }
                if(matcher.group(3).equals(h))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(hourPerDay,2, RoundingMode.HALF_UP)));
                }
                if(matcher.group(3).equals(m))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(hourPerDay,2, RoundingMode.HALF_UP).divide(new BigDecimal(60),2, RoundingMode.HALF_UP)));
                }
            }
            else if(M.equals(unit))
            {
                if(matcher.group(3).equals(y))
                {
                    resultTime =  resultTime.add(new BigDecimal(matcher.group(2)).multiply(monthPerYear));
                }
                if(matcher.group(3).equals(M))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2))));
                }
                if(matcher.group(3).equals(d))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(dayPerMonth,2, RoundingMode.HALF_UP)));
                }
                if(matcher.group(3).equals(h))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(dayPerMonth,2, RoundingMode.HALF_UP).divide(hourPerDay,2, RoundingMode.HALF_UP)));
                }
                if(matcher.group(3).equals(m))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(dayPerMonth,2, RoundingMode.HALF_UP).divide(hourPerDay,2, RoundingMode.HALF_UP).divide(new BigDecimal(60),2, RoundingMode.HALF_UP)));
                }
            }
            else if(y.equals(unit))
            {
                if(matcher.group(3).equals(y))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2))));
                }
                if(matcher.group(3).equals(M))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(monthPerYear,2, RoundingMode.HALF_UP)));
                }
                if(matcher.group(3).equals(d))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(dayPerYear,2, RoundingMode.HALF_UP)));
                }
                if(matcher.group(3).equals(h))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(dayPerYear,2, RoundingMode.HALF_UP).divide(hourPerDay,2, RoundingMode.HALF_UP)));
                }
                if(matcher.group(3).equals(m))
                {
                    resultTime =  resultTime.add((new BigDecimal(matcher.group(2)).divide(dayPerYear,2, RoundingMode.HALF_UP).divide(hourPerDay,2, RoundingMode.HALF_UP).divide(new BigDecimal(60),2, RoundingMode.HALF_UP)));
                }
            }
            if(matcher.group(1)!=null && matcher.group(1).equals(n))
            {
            	negativeSignFlag = true;
            }
            
        }   
        return negativeSignFlag? resultTime.multiply(new BigDecimal(-1)) : resultTime;
        
    }
    public String getJQueryId(FacesContext context, UIInputDurationPicker component)
    {
        return getId(context, component).replace(":", "\\\\:");
    }

    public String getId(FacesContext context, UIInputDurationPicker component)
    {
        if (component.getAttributes().get("forceId") != null)
            id = (Object) component.getAttributes().get("forceId");
        else
            id = component.getClientId(context);
        return id.toString();
    }
}