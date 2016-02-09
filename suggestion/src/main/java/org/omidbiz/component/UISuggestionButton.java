/**
 *
 */

package org.omidbiz.component;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIOutput;

import org.omidbiz.util.JSFUtil;

/**
 * JSF component class
 * 
 */
public abstract class UISuggestionButton extends UIOutput
{

    public static final String COMPONENT_TYPE = "org.omidbiz.SuggestionButton";

    public static final String COMPONENT_FAMILY = "org.omidbiz.SuggestionButton";

    @Override
    public boolean getRendersChildren()
    {
        return false;
    }

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

    private Object forceId;

    private Object valueName;

    private Object valueId;

    private Object textMessage;

    public Object getTextMessage()
    {
        ValueExpression ve = getValueExpression("textMessage");
        if (ve != null)
        {
            String value = null;
            try
            {
                value = (String) ve.getValue(getFacesContext().getELContext());
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
            return value;
        }
        else
        {
            return textMessage;
        }
    }

    public void setTextMessage(Object textMessage)
    {
        this.textMessage = textMessage;
    }

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
                // TODO : DO nothing //FIXME: throw new FacesException(e);
            }
            catch (Exception e)
            {

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
                // TODO : DO nothing //FIXME: throw new FacesException(e);
            }
            catch (Exception e)
            {

            }

            return value;
        }

        return null;
    }

    public void setValueId(Object valueId)
    {
        this.valueId = valueId;
    }

    public Object getForceId()
    {
        ValueExpression ve = getValueExpression("forceId");
        if (ve != null)
        {
            String value = null;
            try
            {
                value = (String) ve.getValue(getFacesContext().getELContext());
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
            return value;
        }
        else
        {
            return forceId;
        }
    }

    public void setForceId(Object forceId)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("forceId");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, forceId);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.forceId = forceId;
        }
    }

}
