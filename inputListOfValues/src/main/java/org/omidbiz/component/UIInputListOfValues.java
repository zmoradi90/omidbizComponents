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
package org.omidbiz.component;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.omidbiz.util.JSFUtil;

/**
 * JSF component class
 * 
 */
public abstract class UIInputListOfValues extends UIInput
{

    public static final String COMPONENT_TYPE = "org.omidbiz.InputListOfValues";

    public static final String COMPONENT_FAMILY = "org.omidbiz.InputListOfValues";

    private Object valueName;

    private Object valueId;

    public Object getValueName()
    {
        if (this.valueName != null)
        {
            return this.valueName;
        }
        ValueExpression ve = getValueExpression("valueName");
        if (ve != null)
        {
            Object value = null;
            try
            {
                ELContext context = getFacesContext().getELContext();
                Class<?> type = ve.getType(context);
                value = JSFUtil.castTo(type, ve.getValue(context));
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }

            return value;
        }

        return null;
    }

    public void setValueName(Object valueName)
    {
        this.valueName = valueName;
    }

    public Object getValueId()
    {
        if (this.valueId != null)
        {
            return this.valueId;
        }
        ValueExpression ve = getValueExpression("valueId");
        if (ve != null)
        {
            Object value = null;
            try
            {
                ELContext context = getFacesContext().getELContext();
                Class<?> type = ve.getType(context);
                value = JSFUtil.castTo(type, ve.getValue(context));
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }

            return value;
        }

        return null;

    }

    public void setValueId(Object valueId)
    {
        this.valueId = valueId;
    }

    @Override
    public Object saveState(FacesContext context)
    {
        Object values[] = new Object[3];
        values[0] = super.saveState(context);
        values[1] = valueName;
        values[2] = valueId;
        return values;
    }

    @Override
    public void restoreState(FacesContext context, Object state)
    {
        Object values[] = (Object[]) state;
        super.restoreState(context, values[0]);
        valueName = values[1];
        valueId = values[2];
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

}
