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
package org.omidbiz.renderkit.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIDropDown;
import org.omidbiz.component.UIDropDownItems;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class DropDownRenderer extends HeaderResourcesRendererBase
{

    @Override
    protected void doDecode(FacesContext context, UIComponent component)
    {
        ExternalContext external = context.getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        UIDropDown dd = (UIDropDown) component;
        Object id = dd.getAttributes().get("forceId");
        if (id != null)
        {
            String submittedValue = (String) requestParams.get((String) id);

            if (submittedValue != null && submittedValue.length() < 1)
            {
                dd.setSubmittedValue(submittedValue);
                dd.setValid(true);
            }
        }

    }

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        writer.startElement("select", component);
        Object forceId = component.getAttributes().get("forceId");
        if (forceId != null)
        {
            getUtils().writeAttribute(writer, "id", forceId);
            getUtils().writeAttribute(writer, "name", forceId);
            Object onchange = component.getAttributes().get("onchange");
            if (onchange != null)
                getUtils().writeAttribute(writer, "onchange", (String) onchange);
            Object disabled = component.getAttributes().get("disabled");
            if (disabled != null && Boolean.TRUE.equals(disabled))
                getUtils().writeAttribute(writer, "disabled", "disabled");
            Object noSelection = component.getAttributes().get("noSelection");
            if (noSelection != null)
            {
                writeOption(writer, null, (String) noSelection);
            }
        }
    }

    private void writeOption(ResponseWriter writer, Object val, String text) throws IOException
    {
        writer.startElement("option", null);
        if (val != null)
            getUtils().writeAttribute(writer, "value", val);
        writer.write(text);
        writer.endElement("option");
    }

    @Override
    protected void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        writer.endElement("select");
    }

    @Override
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        Object value = component.getAttributes().get("value");
        Object items = component.getAttributes().get("items");

        if (component.getChildCount() > 0)
        {
            Iterator<UIComponent> kids = component.getChildren().iterator();
            while (kids.hasNext())
            {
                UIComponent kid = kids.next();
                // child encode
                if (kid instanceof UIDropDownItems)
                {
                    UIDropDownItems ddi = (UIDropDownItems) kid;
                    if (items != null && items instanceof Collection<?>)
                        encodeOptions(ddi, (Collection<?>) items, value, writer, (UIDropDown) component);
                }
                // else if (kid instanceof UISelectItems)
                // {
                // UISelectItems selectitems = (UISelectItems) kid;
                // Object selectItemValue = selectitems.getValue();
                // if (selectItemValue != null && selectItemValue instanceof
                // Collection)
                // encodeOptions((Collection<?>) items, value, writer,
                // (UIDropDown) component, disabled);
                // }
                // else
                // {
                // kid.encodeAll(context);
                // }
            }

        }
    }

    // private void encodeOptions(Collection<?> items, Object value,
    // ResponseWriter writer, UIDropDown component, Object disabled) throws
    // IOException
    // {
    // for (Iterator iterator = items.iterator(); iterator.hasNext();)
    // {
    // javax.faces.model.SelectItem selectItem = (javax.faces.model.SelectItem)
    // iterator.next();
    // writer.startElement("option", null);
    // getUtils().writeAttribute(writer, "value", selectItem.getValue());
    // writer.write(selectItem.getLabel());
    // writer.endElement("option");
    // }
    // }

    private void encodeOptions(UIDropDownItems ddi, Collection<?> itemList, Object value, ResponseWriter writer, UIDropDown dropDown)
            throws IOException
    {
        for (Iterator iterator = itemList.iterator(); iterator.hasNext();)
        {
            Object item = (Object) iterator.next();
            dropDown.putVariables(item);
            writer.startElement("option", ddi);
            //
            Object itemValue = ddi.getAttributes().get("itemValue");
            if (itemValue != null)
                getUtils().writeAttribute(writer, "value", itemValue);
            // value can be object or primitive
            // this code is ugly but what can you do
            try
            {
                if (itemValue instanceof Number && value != null)
                {
                    long val;
                    if (value instanceof String)
                        val = new Long(String.valueOf(value));
                    else
                        val = (Long) value;
                    if (((Number) itemValue).longValue() == val)
                        getUtils().writeAttribute(writer, "selected", "selected");
                }
            }
            catch (NumberFormatException e)
            {
                // DO NOTHING
            }
            catch (ClassCastException cce)
            {
                // DO NOTHING
            }
            if (item.equals(value) || (itemValue != null && itemValue.equals(value)))
            {
                getUtils().writeAttribute(writer, "selected", "selected");
            }
            Object disabled = ddi.getAttributes().get("disabled");
            if (disabled != null && Boolean.TRUE.equals(disabled))
            {
                getUtils().writeAttribute(writer, "disabled", "disabled");
            }
            writer.write((String) ddi.getAttributes().get("itemLabel"));
            writer.endElement("option");
        }
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UIDropDown.class;
    }

    public static void main(String[] args)
    {
        Object str = "50000";
        try
        {
            System.out.println(new Long(String.valueOf(str)));
        }
        catch (NumberFormatException e)
        {
        }
        System.out.println(str.getClass().isAssignableFrom(Number.class));
    }

}
