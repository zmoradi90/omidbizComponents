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
//
//
//


import org.omidbiz.renderkit.InputNumericRendererBase;



/**
 * Renderer for component class org.omidbiz.renderkit.html.InputNumericRenderer
 */
public class InputNumericRenderer extends InputNumericRendererBase {

	public InputNumericRenderer () {
		super();
	}

	// 
	// Declarations
	//
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
		return org.omidbiz.component.UIInputNumeric.class;
	}


	public void doEncodeEnd(ResponseWriter writer, FacesContext context, org.omidbiz.component.UIInputNumeric component, ComponentVariables variables) throws IOException {
	  java.lang.String clientId = component.getClientId(context);
writer.startElement("input", component);
			getUtils().writeAttribute(writer, "class", "my-inputDate-input " + convertToString(component.getAttributes().get("inputClass")) );
						getUtils().writeAttribute(writer, "id", clientId );
						getUtils().writeAttribute(writer, "name", clientId );
						getUtils().writeAttribute(writer, "style", component.getAttributes().get("inputStyle") );
						getUtils().writeAttribute(writer, "type", "text" );
						getUtils().writeAttribute(writer, "value", getValueAsString(context,component) );
			
writer.endElement("input");

	}		
	
	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (org.omidbiz.component.UIInputNumeric)component, variables );

		ComponentsVariableResolver.removeVariables(this, component);
	}		
	

}
