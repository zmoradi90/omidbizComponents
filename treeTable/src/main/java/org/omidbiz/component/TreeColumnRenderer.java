package org.omidbiz.component;

import java.io.IOException;
import java.util.Iterator;

import javax.el.ValueExpression;
import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.RendererBase;

public class TreeColumnRenderer extends RendererBase
{

    @Override
    protected void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        writer.startElement("tr", null);
        writer.startElement("th", null);
        ValueExpression valueExpression = component.getValueExpression("value");
        if (valueExpression != null)
        {
            String value = (String) valueExpression.getValue(context.getELContext());
            writer.write(value != null ? value : "");
        }
        writer.endElement("th");
        writer.endElement("tr");
    }

    protected Class<? extends UIComponent> getComponentClass()
    {

        return UIColumn.class;
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
        UITreeColumn treeColumn = (UITreeColumn) component;
        Iterator childIterator = treeColumn.getChildren().iterator();
        while (childIterator.hasNext())
        {
            UIComponent comp = (UIComponent) childIterator.next();
            if (comp instanceof UITreeCell)
            {
                ValueExpression valueExpression = component.getValueExpression("value");
                if (valueExpression != null)
                {
                    String value = (String) valueExpression.getValue(context.getELContext());
                    writer.write(value != null ? value : "");
                }
            }
        }
    }

}
