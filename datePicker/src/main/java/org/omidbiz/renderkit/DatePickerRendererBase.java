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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.ajax4jsf.util.InputUtils;
import org.omidbiz.component.UIDatePicker;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public abstract class DatePickerRendererBase extends HeaderResourcesRendererBase
{

    final PersianDateConverter pc = PersianDateConverter.getInstance();
    final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd");

    private String[] formats = { "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "EEE MMM d HH:mm:ss z yyyy",
            "yyyy-MM-dd HH:mm:ss", "EEE, d MMM yyyy HH:mm:ss", "EEE MMM d HH:mm:ss z yyyy", "yyyy-MM-dd HH:mm", "yyyy-MM-dd" };

    /**
     * @see UIInput#validate(FacesContext)
     */
    public void decode(FacesContext context, UIComponent component)
    {
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIDatePicker inputDate = (UIDatePicker) component;
        String clientId = null;
        String idname = (String) inputDate.getAttributes().get("idname");
        if (idname != null && idname.length() > 0)
        {
            clientId = idname;
        }
        else
        {
            clientId = inputDate.getClientId(context) + "_date";
        }
        String submittedValue = (String) requestParams.get(clientId);
        Object convertedDate = getConvertedDateValue(submittedValue, context, inputDate);
        if (convertedDate != null)
        {
            inputDate.setSubmittedValue(convertedDate);

        }
    }

    public String getClientScriptIdName(FacesContext context, UIDatePicker component)
    {
        Object idname = component.getAttributes().get("idname");
        if (idname != null)
            return "'#" + idname + "'";
        else
            return null;
    }

    public String getJsfScriptIdName(FacesContext context, UIDatePicker component)
    {
        String jQueryClientId = component.getClientId(context);
        jQueryClientId = jQueryClientId.replace(":", "\\\\:");
        return "'#" + jQueryClientId + "_date'";
    }

    protected String getValueAsString(FacesContext context, UIComponent component) 
    {
        UIDatePicker inputDate = (UIDatePicker) component;

        Object value = inputDate.getValue();
        if (value != null && value.toString().length() > 1)
        {
            Date gDate = parseValue(value).getDate();
            String valuePattern = (String) inputDate.getAttributes().get("valuePattern");
            String solarValue = null;
            if (valuePattern != null)
            {
                SimpleDateFormat sdfVal = new SimpleDateFormat(valuePattern);
                solarValue = pc.GregorianToSolar(sdfVal.format(gDate));
            }
            else
            {
                solarValue = pc.GregorianToSolar(dateTimeFormat.format(gDate));
            }

            return InputUtils.getConvertedStringValue(context, component, solarValue);
        }
        else
        {
            return null;
        }

    }

    

    protected Object getConvertedDateValue(String gregorianDate, FacesContext context, UIDatePicker component)
    {
        if (gregorianDate != null && gregorianDate.trim().length() > 0)
        {
            return pc.SolarToGregorianAsDate(gregorianDate);
        }
        if (gregorianDate != null && gregorianDate.trim().length() == 0)
            return "";
        return null;
    }

    @Override
    public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException
    {
        UIDatePicker inputDate = (UIDatePicker) component;
        Converter converter = inputDate.getConverter();
        if(converter != null)
        {
            return converter.getAsObject(context, component, String.valueOf(submittedValue));
        }
        if(submittedValue != null && String.valueOf(submittedValue).trim().isEmpty())
            return null;
        return submittedValue;
    }

    private Converter getConverter(FacesContext context, UIDatePicker dt)
    {
        Converter converter = dt.getConverter();
        if (converter == null)
        {
            DateTimeConverter datetime = new DateTimeConverter();
            datetime.setLocale(context.getViewRoot().getLocale());
            datetime.setTimeZone(TimeZone.getDefault());
            datetime.setType("date");
            datetime.setDateStyle("medium");
            datetime.setPattern("yyyy/MM/dd");
            converter = datetime;
        }
        return converter;
    }

    private ReturnValue parseValue(Object val)
    {
        if (val == null)
            return null;
        for (String format : formats)
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try
            {
                Date dateValue = sdf.parse(String.valueOf(val));
                return new ReturnValue(sdf, dateValue);
            }
            catch (ParseException e)
            {
                // DO NOTHING
            }
        }
        return null;
    }

    private class ReturnValue
    {
        private SimpleDateFormat sdf;
        private Date date;

        public ReturnValue(SimpleDateFormat sdf, Date date)
        {
            this.sdf = sdf;
            this.date = date;
        }

        public SimpleDateFormat getSdf()
        {
            return sdf;
        }

        public Date getDate()
        {
            return date;
        }

    }

}
