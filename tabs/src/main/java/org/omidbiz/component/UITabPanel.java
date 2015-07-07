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

    private Object imageSrc;

    private Object link;

    private Object content;

    private Object imageOnClick;

    private boolean disabled;

    private boolean includePageParams;

    private boolean useIframe;

    private boolean join;

    public boolean isJoin()
    {
        return join;
    }

    public void setJoin(boolean join)
    {
        this.join = join;
    }

    public boolean isUseIframe()
    {
        return useIframe;
    }

    public void setUseIframe(boolean useIframe)
    {
        this.useIframe = useIframe;
    }

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

    public Object getImageSrc()
    {
        ValueExpression ve = getValueExpression("imageSrc");
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
            return imageSrc;
        }
    }

    public void setImageSrc(Object imageSrc)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("imageSrc");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, imageSrc);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.imageSrc = imageSrc;
        }
    }

    public Object getImageOnClick()
    {
        ValueExpression ve = getValueExpression("imageOnClick");
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
            return imageOnClick;
        }
    }

    public void setImageOnClick(Object imageOnClick)
    {
        ELContext context = getFacesContext().getELContext();
        ValueExpression ve = getValueExpression("imageOnClick");
        if (ve != null && !ve.isReadOnly(context))
        {
            try
            {
                ve.setValue(context, imageOnClick);
            }
            catch (ELException e)
            {
                throw new FacesException(e);
            }
        }
        else
        {
            this.imageOnClick = imageOnClick;
        }

    }

}
