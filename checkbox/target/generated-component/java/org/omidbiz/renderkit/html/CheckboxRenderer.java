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


import org.omidbiz.renderkit.CheckboxRenderBase;



/**
 * Renderer for component class org.omidbiz.renderkit.html.CheckboxRenderer
 */
public class CheckboxRenderer extends CheckboxRenderBase {

	public CheckboxRenderer () {
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
		return org.omidbiz.component.UICheckbox.class;
	}


	public void doEncodeEnd(ResponseWriter writer, FacesContext context, org.omidbiz.component.UICheckbox component, ComponentVariables variables) throws IOException {
	  java.lang.String clientId = component.getClientId(context);
variables.setVariable("value", component.getAttributes().get("value") );

 
			String value = (String) variables.getVariable("value");


 if (value != null && !"".equals(value.trim()) && value.equalsIgnoreCase("Y") ) { 
writer.startElement("input", component);
			getUtils().writeAttribute(writer, "checked", "checked" );
						getUtils().writeAttribute(writer, "id", convertToString(clientId) + "-chk" );
						getUtils().writeAttribute(writer, "name", convertToString(clientId) + "-chk" );
						getUtils().writeAttribute(writer, "type", "checkbox" );
						getUtils().writeAttribute(writer, "value", "Y" );
			
writer.endElement("input");
 } else { 
writer.startElement("input", component);
			getUtils().writeAttribute(writer, "id", convertToString(clientId) + "-chk" );
						getUtils().writeAttribute(writer, "name", convertToString(clientId) + "-chk" );
						getUtils().writeAttribute(writer, "onclick", "setYvalue();" );
						getUtils().writeAttribute(writer, "type", "checkbox" );
						getUtils().writeAttribute(writer, "value", "N" );
			
writer.endElement("input");
writer.startElement("script", component);
			getUtils().writeAttribute(writer, "type", "text/javascript" );
			
writer.writeText(convertToString("function setYvalue(){\n				var chkCmp = document.getElementById(\"" + convertToString(clientId) + "-chk\");\n				var chkVal = chkCmp.value;\n				if(chkVal == 'N'){\n					chkCmp.value = 'Y' \n				}\n			}"),null);

writer.endElement("script");
 } 

	}		
	
	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (org.omidbiz.component.UICheckbox)component, variables );

		ComponentsVariableResolver.removeVariables(this, component);
	}		
	

}
