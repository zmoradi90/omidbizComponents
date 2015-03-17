package org.omidbiz.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.javascript.JSFunctionDefinition;
import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UITreeColumn;
import org.omidbiz.component.UITreeTable;

public abstract class AbstractTreeTableRenderer extends HeaderResourcesRendererBase
{

    public void scriptGenerator(FacesContext context, UITreeTable table) throws IOException
    {
        //
        String clientId = table.getClientId(context);
        StringBuffer script = new StringBuffer("\n");
        script.append("jQuery(document).ready(function () {");
        String id = (String) table.getAttributes().get("forceId");
        if (id != null)
            script.append("jQuery(\"#").append(id).append("\")");
        else
            script.append("jQuery(\"#").append(clientId.replace(":", "\\\\:")).append("\")");
        script.append(".treetable({\n").append("expandable: true,\n").append("onNodeExpand: function() {\n");
        // script.append("alert( \"A branch has collapsed\" + jQuery(this.row).data(\"tt-id\") );");
        script.append("}\n});\n});");
        script.append("\n");
        getUtils().writeScript(context, table, script);
        //
    }

    public void encodeTBody(FacesContext context, UITreeTable table) throws IOException
    {
        String clientId = table.getClientId(context);
        scriptGenerator(context, table);
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("table", table);
        String id = (String) table.getAttributes().get("forceId");
        if (id != null)
            getUtils().writeAttribute(writer, "id", id);
        else
            getUtils().writeAttribute(writer, "id", clientId);
        writer.startElement("thead", null);
        encodeHeaders(context, table);
        writer.endElement("thead");

        writer.startElement("tbody", null);
        writer.writeAttribute("id", clientId + ":tb", null);

        encodeRows(context, table);

        writer.endElement("tbody");
        writer.endElement("table");
    }

    private void encodeHeaders(FacesContext context, UITreeTable table) throws IOException
    {
        Iterator childIterator = table.getChildren().iterator();
        while (childIterator.hasNext())
        {
            UIComponent comp = (UIComponent) childIterator.next();
            if (comp instanceof UITreeColumn)
            {
                ((UITreeColumn) comp).encodeBegin(context);
            }
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException
    {
        encodeTBody(context, (UITreeTable) component);
    }

    private void encodeRows(FacesContext context, UITreeTable table) throws IOException
    {
        int first = table.getFirst();
        ResponseWriter out = context.getResponseWriter();
        int rows = table.getRowCount();
        for (int i = first, n = 0; n < rows; i++, n++)
        {
            table.setRowIndex(i);
            if (!table.isRowAvailable())
            {
                break;
            }
            Iterator childIterator = table.getChildren().iterator();
            while (childIterator.hasNext())
            {
                UIComponent comp = (UIComponent) childIterator.next();
                if (comp instanceof UITreeColumn)
                {
                    out.startElement("tr", null);
                    comp = (UITreeColumn) comp;
                    getUtils().writeAttribute(out, "data-tt-id",
                            getValueAsExpression(comp.getValueExpression("dataId"), context));
                    String expression = getValueAsExpression(comp.getValueExpression("dataParentId"), context);
                    if (expression.length() > 0)
                        getUtils().writeAttribute(out, "data-tt-parent-id", expression);
                    out.startElement("td", null);
                    ((UITreeColumn) comp).encodeChildren(context);
                    out.endElement("td");
                    out.endElement("tr");
                }
            }

        }
    }

    public static String getValueAsExpression(ValueExpression value, FacesContext context)
    {
        return (String) (value.getValue(context.getELContext()) == null ? "" : value.getValue(context.getELContext()));
    }

}
