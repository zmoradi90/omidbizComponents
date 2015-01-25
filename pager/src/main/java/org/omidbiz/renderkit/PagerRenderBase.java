package org.omidbiz.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIPager;

public class PagerRenderBase extends HeaderResourcesRendererBase {

	private void generateLinkTag(ResponseWriter writer, UIComponent component,
			 String id, String value, String view)
			throws IOException {

		writer.startElement("a", component);
		writer.writeAttribute("href", view == null ? "#" : view, null);
		writer.writeText(value, null);
		writer.endElement("a");

	}

	public void initializeResources(FacesContext context, UIPager component)
			throws IOException {

		ResponseWriter writer = context.getResponseWriter();
		String id = component.getClientId(context);
		
		UIComponent parent = component.getParent();
		
		
		
		String dataTableId = (String) component.getAttributes().get("dataTableId");

		Integer pageattr = (Integer) component.getAttributes().get("pages");

		int showpages = pageattr == null ? 0 : pageattr.intValue();

		// find component
		UIData data = (UIData) component.findComponent(dataTableId);

		

		int first = data.getFirst();
		int itemcount = data.getRowCount();
//		int pagesize = data.getRows();
		int pagesize = showpages;
		if (pagesize <= 0)
			pagesize = itemcount;

		int pages = itemcount / pagesize;
		if (itemcount % pagesize != 0)
			pages++;

		int currentPage = first / pagesize;
		if (first >= itemcount - pagesize)
			currentPage = pages - 1;
		int startPage = 0;
		int endPage = pages;

		//
		String view = (String) component.getAttributes().get("view");
		//
		//
		if (showpages > 0) {
			startPage = (currentPage / showpages) * showpages;
			endPage = Math.min(startPage + showpages, pages);
		}

		if (currentPage > 0) {
			generateLinkTag(writer, component, id, "<", view);
		}

		if (startPage > 0) {
			generateLinkTag(writer, component, id, "<<", view);
		}
		
		System.out.println("startPage : "+startPage);
		System.out.println("endPage : "+endPage);
		System.out.println("first : "+first);
		System.out.println("itemCnt : "+itemcount);
		System.out.println("pagesize : "+pagesize);
		System.out.println("showpages : "+showpages);

		for (int i = startPage; i < endPage; i++) {
			generateLinkTag(writer, component, id, "" + (i + 1), view);

		}
		//
		if (endPage < pages) {
			generateLinkTag(writer, component, id, ">>", view);
		}

		if (first < itemcount - pagesize) {
			generateLinkTag(writer, component, id, ">", view);
		}
	}

	protected Class getComponentClass() {
		return UIPager.class;
	}

}

