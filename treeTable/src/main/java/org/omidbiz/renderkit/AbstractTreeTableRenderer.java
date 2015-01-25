package org.omidbiz.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UITreeTable;

public abstract class AbstractTreeTableRenderer extends HeaderResourcesRendererBase
{

	public void encodeTBody(FacesContext context, UITreeTable table) throws IOException
	{
		String clientId = table.getClientId(context);
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("tbody", table);
		writer.writeAttribute("id", clientId + ":tb", null);

		encodeRows(context, table);

		writer.endElement("tbody");
	}
	
	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	    	encodeTBody(context, (UITreeTable) component);
	}

	private void encodeRows(FacesContext context, UITreeTable table) throws IOException
	{
		int first = table.getFirst();
		System.out.println("#################################################################");
		System.out.println("first :  " + first);
		ResponseWriter out = context.getResponseWriter();
		int rows = table.getRowCount();
		System.out.println("rows :  " + rows);
		for (int i = first, n = 0; n < rows; i++, n++)
		{
			table.setRowIndex(i);
			if (!table.isRowAvailable())
			{
				break;
			}
			
			Iterator childIterator = table.getChildren( ).iterator( );
			while(childIterator.hasNext()){
				UIComponent comp = (UIComponent) childIterator.next();
				if(comp instanceof UIColumn){
					System.out.println("UICOLUMN");
					out.startElement("tr", null);
					out.startElement("td", null);
					
					out.endElement("td");
					out.endElement("tr");
				}
			}
		}
	}

}
