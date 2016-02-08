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
public abstract class UISuggestion extends UIComponentBase
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

    

}
