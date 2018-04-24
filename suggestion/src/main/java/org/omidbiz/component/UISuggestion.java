/**
 *
 */

package org.omidbiz.component;

import java.util.Map;

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
public abstract class UISuggestion extends UIInput
{

    public static final String COMPONENT_TYPE = "org.omidbiz.Suggestion";

    public static final String COMPONENT_FAMILY = "org.omidbiz.Suggestion";

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

    private Object view;

    private Object forceId;

    private Object valueName;

    private Object valueId;

    private Object styleClass;

    private String clientParametForceId;

    private String style;

    private int width;

    private int height;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
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

    public Object getView()
    {
        ValueExpression ve = getValueExpression("view");
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
            return view;
        }
    }

    public void setView(Object view)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("view");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, view);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.view = view;
        }
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

    public Object getStyleClass()
    {
        ValueExpression ve = getValueExpression("styleClass");
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
            return this.styleClass;
        }
    }

    public void setStyleClass(Object styleClass)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("styleClass");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, styleClass);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.styleClass = styleClass;
        }
    }

    @Override
    public Object saveState(FacesContext context)
    {
        Object superState = super.saveState(context);
        return new Object[] { superState, view, forceId, valueId, valueName };
    }

    @Override
    public void restoreState(FacesContext context, Object stateObj)
    {
        Object[] state = (Object[]) stateObj;
        int i = 0;
        super.restoreState(context, state[i++]);
        view = (String) state[i++];
        forceId = (String) state[i++];
        valueId = (Object) state[i++];
        valueName = (Object) state[i++];
    }

    public String getClientParametForceId()
    {
        return clientParametForceId;
    }

    public void setClientParametForceId(String clientParametForceId)
    {
        this.clientParametForceId = clientParametForceId;
    }

}
