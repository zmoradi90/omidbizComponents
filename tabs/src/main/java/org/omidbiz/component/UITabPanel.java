package org.omidbiz.component;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponentBase;

public abstract class UITabPanel extends UIComponentBase
{

    public static final String COMPONENT_FAMILY = "org.omidbiz.UITabPanel";

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

    private Object title;

    private Object link;

    private Object content;

    private boolean disabled;

    private boolean includePageParams;

    public boolean isIncludePageParams()
    {
        return includePageParams;
    }

    public void setIncludePageParams(boolean includePageParams)
    {
        this.includePageParams = includePageParams;
    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }

    public Object getLink()
    {
        ValueExpression ve = getValueExpression("link");
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
            return link;
        }
    }

    public void setLink(Object link)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("link");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, link);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.link = link;
        }
    }

    public Object getTitle()
    {
        ValueExpression ve = getValueExpression("title");
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
            return title;
        }
    }

    public void setTitle(Object title)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("title");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, title);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.title = title;
        }
    }

    public Object getContent()
    {
        ValueExpression ve = getValueExpression("content");
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
            return content;
        }
    }

    public void setContent(Object content)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("content");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, content);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.content = content;
        }
    }

}