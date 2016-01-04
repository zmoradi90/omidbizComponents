/**
 *
 */

package org.omidbiz.component;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponentBase;

/**
 * JSF component class
 * 
 */
public abstract class UITabs extends UIComponentBase
{

    public static final String COMPONENT_TYPE = "org.omidbiz.Tabs";

    public static final String COMPONENT_FAMILY = "org.omidbiz.Tabs";

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

    private int active;
    private boolean keepState;

    public boolean isKeepState()
    {
        return keepState;
    }

    public void setKeepState(boolean keepState)
    {
        this.keepState = keepState;
    }

    public int getActive()
    {
        ValueExpression ve = getValueExpression("active");
        if (ve != null)
        {
            Integer value = null;
            try
            {
                value = (Integer) ve.getValue(getFacesContext().getELContext());
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
            return value;
        }
        else
        {
            return active;
        }
    }

    public void setActive(int active)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("active");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, active);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.active = active;
        }
    }

}
