/**
 * License Agreement.
 *
 * Ajax4jsf 1.1 - Natural Ajax for Java Server Faces (JSF)
 *
 * Copyright (C) 2007 Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */

package org.omidbiz.renderkit.html;


// 
// Imports
//
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.ajax4jsf.renderkit.ComponentsVariableResolver;
import org.ajax4jsf.renderkit.ComponentVariables;
import org.ajax4jsf.resource.InternetResource;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
//
//
//


import org.omidbiz.renderkit.CloseButtonRendererBase;



/**
 * Renderer for component class org.omidbiz.renderkit.html.LovCloseButtonRenderer
 */
public class LovCloseButtonRenderer extends CloseButtonRendererBase {

	public LovCloseButtonRenderer () {
		super();
	}

	// 
	// Declarations
	//
	private final InternetResource[] scripts = {
						getResource("/org/richfaces/renderkit/html/scripts/jquery/jquery.js")
						,
				new org.ajax4jsf.javascript.PrototypeScript()
						,
				new org.ajax4jsf.javascript.AjaxScript()
						,
				getResource("/org/omidbiz/renderkit/html/script/colorboxUtil.js")
	};

private InternetResource[] scriptsAll = null;

protected InternetResource[] getScripts() {
	synchronized (this) {
		if (scriptsAll == null) {
			InternetResource[] rsrcs = super.getScripts();
			boolean ignoreSuper = rsrcs == null || rsrcs.length == 0;
			boolean ignoreThis = scripts == null || scripts.length == 0;
			
			if (ignoreSuper) {
				if (ignoreThis) {
					scriptsAll = new InternetResource[0];	
				} else {
					scriptsAll = scripts;
				}
			} else {
				if (ignoreThis) {
					scriptsAll = rsrcs;
				} else {
					java.util.Set rsrcsSet = new java.util.LinkedHashSet();

					for (int i = 0; i < rsrcs.length; i++ ) {
						rsrcsSet.add(rsrcs[i]);
					}

					for (int i = 0; i < scripts.length; i++ ) {
						rsrcsSet.add(scripts[i]);
					}

					scriptsAll = (InternetResource[]) rsrcsSet.toArray(new InternetResource[rsrcsSet.size()]);
				}
			}
		}
	}
	
	return scriptsAll;
}
	// 
	// 
	//


	private String convertToString(Object obj ) {
		return ( obj == null ? "" : obj.toString() );
	}
	private String convertToString(boolean b ) {
		return String.valueOf(b);
	}
	private String convertToString(int b ) {
		return b!=Integer.MIN_VALUE?String.valueOf(b):"";
	}
	private String convertToString(long b ) {
		return b!=Long.MIN_VALUE?String.valueOf(b):"";
	}
	
	private boolean isEmpty(Object o) {
		if (null == o) {
			return true;
		}
		if (o instanceof String ) {
			return (0 == ((String)o).length());
		}
		if (o instanceof Collection) {
			return (0 == ((Collection)o).size());
		}
		if (o instanceof Map) {
			return (0 == ((Map)o).size());
		}
		if (o.getClass().isArray()) {
			return (0 == ((Object [])o).length);
		}
		return false;
	}
	
	/**
	 * Get base component class, targetted for this renderer. Used for check arguments in decode/encode.
	 * @return
	 */
	protected Class getComponentClass() {
		return org.omidbiz.component.UILovCloseButton.class;
	}

	
	public void doEncodeBegin(ResponseWriter writer, FacesContext context, UIComponent component ) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeBegin(writer, context, (org.omidbiz.component.UILovCloseButton)component, variables );
	}		

	public void doEncodeBegin(ResponseWriter writer, FacesContext context, org.omidbiz.component.UILovCloseButton component, ComponentVariables variables ) throws IOException {
	    writer.startElement("script", component);
			getUtils().writeAttribute(writer, "type", "text/javascript" );
			
writer.writeText(convertToString("jQuery.noConflict();"),null);

writer.endElement("script");
java.lang.String clientId = component.getClientId(context);
writer.startElement("a", component);
			getUtils().writeAttribute(writer, "class", component.getAttributes().get("styleClass") );
						getUtils().writeAttribute(writer, "href", "#" );
						getUtils().writeAttribute(writer, "id", clientId );
						getUtils().writeAttribute(writer, "name", clientId );
						getUtils().writeAttribute(writer, "onclick", "Richfaces.colorboxControl.extendedClose(" + convertToString(component.getAttributes().get("pid")) + ",'" + convertToString(component.getAttributes().get("pValueText")) + "','" + convertToString(variables.getVariable("objectName")) + "');" + convertToString(getOnClick(context,component)) );
						getUtils().writeAttribute(writer, "type", component.getAttributes().get("type") );
			//
// pass thru attributes
//
getUtils().encodeAttributesFromArray(context,component,new String[] {
    "accesskey" ,
	    "charset" ,
	    "coords" ,
	    "dir" ,
	    "hreflang" ,
	    "lang" ,
	    "onblur" ,
	    "ondblclick" ,
	    "onfocus" ,
	    "onkeydown" ,
	    "onkeypress" ,
	    "onkeyup" ,
	    "onmousedown" ,
	    "onmousemove" ,
	    "onmouseout" ,
	    "onmouseover" ,
	    "onmouseup" ,
	    "rel" ,
	    "rev" ,
	    "shape" ,
	    "style" ,
	    "tabindex" ,
	    "target" ,
	    "title" ,
	    "xml:lang" });
//
//
//

writer.writeText(convertToString(getValue(component)),null);


	}		
	
    public void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeChildren(writer, context, (org.omidbiz.component.UILovCloseButton)component, variables );
	}		

    public void doEncodeChildren(ResponseWriter writer, FacesContext context, org.omidbiz.component.UILovCloseButton component, ComponentVariables variables) throws IOException {
	    
renderChildren(context, component);


	}		

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#getRendersChildren()
	 */
	public boolean getRendersChildren() {
		return true;
	}

	public void doEncodeEnd(ResponseWriter writer, FacesContext context, org.omidbiz.component.UILovCloseButton component, ComponentVariables variables) throws IOException {
	  
writer.endElement("a");

	}		
	
	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (org.omidbiz.component.UILovCloseButton)component, variables );

		ComponentsVariableResolver.removeVariables(this, component);
	}		
	

}
