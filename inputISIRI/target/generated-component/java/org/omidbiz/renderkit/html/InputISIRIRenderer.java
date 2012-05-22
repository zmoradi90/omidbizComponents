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
//
//
//


import org.ajax4jsf.renderkit.AjaxComponentRendererBase;



/**
 * Renderer for component class org.omidbiz.renderkit.html.InputISIRIRenderer
 */
public class InputISIRIRenderer extends AjaxComponentRendererBase {

	public InputISIRIRenderer () {
		super();
	}

	// 
	// Declarations
	//
	private final InternetResource[] scripts = {
						getResource("script/isiri2901.js")
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
		return org.omidbiz.component.UIInputISIRI.class;
	}


	public void doEncodeEnd(ResponseWriter writer, FacesContext context, org.omidbiz.component.UIInputISIRI component, ComponentVariables variables) throws IOException {
	  java.lang.String clientId = component.getClientId(context);
variables.setVariable("icon", getResource( "images/lang.png" ).getUri(context, component) );

writer.startElement("input", component);
			getUtils().writeAttribute(writer, "id", clientId );
						getUtils().writeAttribute(writer, "name", clientId );
						getUtils().writeAttribute(writer, "onkeydown", "return PersianKeyDown(event)" );
						getUtils().writeAttribute(writer, "onkeypress", "return PersianKeyPress(event)" );
						getUtils().writeAttribute(writer, "type", "text" );
			
writer.endElement("input");
writer.startElement("a", component);
			getUtils().writeAttribute(writer, "href", "javascript:setPersian(document.getElementById('" + convertToString(clientId) + "'))" );
			
writer.writeText(convertToString("Persian"),null);

writer.endElement("a");
writer.writeText(convertToString("/"),null);

writer.startElement("a", component);
			getUtils().writeAttribute(writer, "href", "javascript:setEnglish(document.getElementById('" + convertToString(clientId) + "'))" );
			
writer.writeText(convertToString("English"),null);

writer.endElement("a");

	}		
	
	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (org.omidbiz.component.UIInputISIRI)component, variables );

		ComponentsVariableResolver.removeVariables(this, component);
	}		
	

}
