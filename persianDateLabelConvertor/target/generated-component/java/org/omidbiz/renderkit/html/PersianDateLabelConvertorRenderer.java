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


import org.omidbiz.renderkit.PersianDateLabelRendererBase;



/**
 * Renderer for component class org.omidbiz.renderkit.html.PersianDateLabelConvertorRenderer
 */
public class PersianDateLabelConvertorRenderer extends PersianDateLabelRendererBase {

	public PersianDateLabelConvertorRenderer () {
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
	
	/**
	 * Get base component class, targetted for this renderer. Used for check arguments in decode/encode.
	 * @return
	 */
	protected Class getComponentClass() {
		return org.omidbiz.component.UIPersianDateLabelConvertor.class;
	}


	public void doEncodeEnd(ResponseWriter writer, FacesContext context, org.omidbiz.component.UIPersianDateLabelConvertor component, ComponentVariables variables) throws IOException {
	  java.lang.String clientId = component.getClientId(context);
variables.setVariable("layout", component.getAttributes().get("layout") );
variables.setVariable("styleClass", component.getAttributes().get("styleClass") );

 
			String layout = (String) variables.getVariable("layout");


 if (! "".equals(layout.trim()) && layout.equalsIgnoreCase("block") ) { 
writer.startElement("div", component);
			getUtils().writeAttribute(writer, "class", variables.getVariable("styleClass") );
						getUtils().writeAttribute(writer, "id", clientId );
			
writer.writeText(convertToString(getSolarValueAsString(context,component)),null);

writer.endElement("div");
 } 
 if (! "".equals(layout.trim()) && layout.equalsIgnoreCase("inline") ) { 
writer.startElement("span", component);
			getUtils().writeAttribute(writer, "class", variables.getVariable("styleClass") );
			
writer.writeText(convertToString(getSolarValueAsString(context,component)),null);

writer.endElement("span");
 } 
 if (! "".equals(layout.trim()) && layout.equalsIgnoreCase("none") ) { 
writer.writeText(convertToString(getSolarValueAsString(context,component)),null);

 } 

	}		
	
	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (org.omidbiz.component.UIPersianDateLabelConvertor)component, variables );

		ComponentsVariableResolver.removeVariables(this, component);
	}		
	

}
