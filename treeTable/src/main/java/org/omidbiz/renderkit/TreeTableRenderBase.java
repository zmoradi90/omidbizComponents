package org.omidbiz.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.ComponentVariables;
import org.ajax4jsf.renderkit.ComponentsVariableResolver;
import org.ajax4jsf.resource.InternetResource;
import org.omidbiz.component.UITreeTable;

public class TreeTableRenderBase extends AbstractTreeTableRenderer
{

	private final InternetResource[] styles = { getResource("css/treeTable.xcss") };

	public TreeTableRenderBase()
	{
		super();
	}

	public void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
	{
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeBegin(writer, context, (UITreeTable) component, variables);
	}

	private void doEncodeBegin(ResponseWriter writer, FacesContext context, UITreeTable component,
			ComponentVariables variables) throws IOException
	{
		java.lang.String clientId = component.getClientId(context);
		writer.startElement("table", component);
		getUtils().writeAttribute(writer, "id", clientId);

		

	}

	public void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
	{
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeChildren(writer, context, (UITreeTable) component, variables);
	}

	private void doEncodeChildren(ResponseWriter writer, FacesContext context, UITreeTable component,
			ComponentVariables variables) throws IOException
	{
		encodeTBody(context, component);
	}

	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
	{
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (UITreeTable) component, variables);

		ComponentsVariableResolver.removeVariables(this, component);
	}

	private void doEncodeEnd(ResponseWriter writer, FacesContext context, UITreeTable component, ComponentVariables variables) throws IOException
	{
		writer.endElement("table");
	}

	public boolean getRendersChildren()
	{
		return true;
	}

	protected Class getComponentClass() {
		return UITreeTable.class;
	}

}
