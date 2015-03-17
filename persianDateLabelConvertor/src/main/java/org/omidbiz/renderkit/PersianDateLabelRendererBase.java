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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIPersianDateLabelConvertor;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public abstract class PersianDateLabelRendererBase extends HeaderResourcesRendererBase
{

    private String[] formats = { "yyyy/MM/dd", "EEE MMM d HH:mm:ss z yyyy", "yyyy-MM-dd HH:mm:ss",
            "EEE, d MMM yyyy HH:mm:ss", "EEE MMM d HH:mm:ss z yyyy", };

    protected Object getSolarValueAsString(FacesContext context, UIComponent component) throws IOException
    {

        UIPersianDateLabelConvertor inputDate = (UIPersianDateLabelConvertor) component;
        Object valueString = (Object) inputDate.getAttributes().get("value");
        ReturnValue returnValue = parseValue(valueString);
        if (returnValue != null)
        {
            PersianCalendar pc = new PersianCalendar();
            Date d = returnValue.getDate();
            String datePattern = (String) inputDate.getAttributes().get("datePattern");
            if (datePattern == null)
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
                return pc.GregorianToSolar(sdf.format(d));
            }
            else
            {
                SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
                return pc.GregorianToSolar(formatter.format(d));
            }
        }

        return null;
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
                Date dateValue = sdf.parse(val.toString());
                return new ReturnValue(sdf, dateValue);
            }
            catch (ParseException e)
            {
                // DO NOTHING
            }
        }
        return null;
    }

    public class ReturnValue
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
