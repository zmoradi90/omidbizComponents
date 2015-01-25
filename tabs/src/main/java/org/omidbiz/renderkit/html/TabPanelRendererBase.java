package org.omidbiz.renderkit.html;

import java.io.IOException;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UITabPanel;

public class TabPanelRendererBase extends HeaderResourcesRendererBase
{

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UITabPanel.class;
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    
    
    
    @Override
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component)
            throws IOException
    {
       
    }
    
    

    
    
    
  
}
