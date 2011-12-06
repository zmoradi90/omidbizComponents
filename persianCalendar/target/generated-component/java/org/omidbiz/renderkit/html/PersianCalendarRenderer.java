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
import org.ajax4jsf.resource.InternetResource;
//
//
//


import org.omidbiz.renderkit.CalendarRendererBase;



/**
 * Renderer for component class org.omidbiz.renderkit.html.PersianCalendarRenderer
 */
public class PersianCalendarRenderer extends CalendarRendererBase {

	public PersianCalendarRenderer () {
		super();
	}

	// 
	// Declarations
	//
	private final InternetResource[] scripts = {
						new org.ajax4jsf.javascript.PrototypeScript()
						,
				new org.ajax4jsf.javascript.AjaxScript()
						,
				getResource("/org/richfaces/renderkit/html/scripts/events.js")
						,
				getResource("/org/richfaces/renderkit/html/scripts/utils.js")
						,
				getResource("/org/richfaces/renderkit/html/scripts/json/json-dom.js")
						,
				getResource("/org/richfaces/renderkit/html/scripts/scriptaculous/effects.js")
						,
				getResource("/org/richfaces/renderkit/html/scripts/jquery/jquery.js")
						,
				getResource("/org/richfaces/renderkit/html/scripts/jquery/jquery.js")
						,
				getResource("/org/richfaces/renderkit/html/scripts/JQuerySpinBtn.js")
						,
				getResource("/org/omidbiz/renderkit/html/script/calendar.js")
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
	private final InternetResource[] styles = {
						getResource("/org/richfaces/renderkit/html/css/calendar.xcss")
	};

private InternetResource[] stylesAll = null;

protected InternetResource[] getStyles() {
	synchronized (this) {
		if (stylesAll == null) {
			InternetResource[] rsrcs = super.getStyles();
			boolean ignoreSuper = rsrcs == null || rsrcs.length == 0;
			boolean ignoreThis = styles == null || styles.length == 0;
			
			if (ignoreSuper) {
				if (ignoreThis) {
					stylesAll = new InternetResource[0];	
				} else {
					stylesAll = styles;
				}
			} else {
				if (ignoreThis) {
					stylesAll = rsrcs;
				} else {
					java.util.Set rsrcsSet = new java.util.LinkedHashSet();

					for (int i = 0; i < rsrcs.length; i++ ) {
						rsrcsSet.add(rsrcs[i]);
					}

					for (int i = 0; i < styles.length; i++ ) {
						rsrcsSet.add(styles[i]);
					}

					stylesAll = (InternetResource[]) rsrcsSet.toArray(new InternetResource[rsrcsSet.size()]);
				}
			}
		}
	}
	
	return stylesAll;
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
		return org.omidbiz.component.UIPersianCalendar.class;
	}


	public void doEncodeEnd(ResponseWriter writer, FacesContext context, org.omidbiz.component.UIPersianCalendar component, ComponentVariables variables) throws IOException {
	  java.lang.String clientId = component.getClientId(context);
addPopupToAjaxRendered(context, component);

writer.startElement("span", component);
			getUtils().writeAttribute(writer, "id", convertToString(clientId) + "Popup" );
			//
// pass thru attributes
//
getUtils().encodeAttributesFromArray(context,component,new String[] {
    "dir" ,
	    "lang" ,
	    "onclick" ,
	    "ondblclick" ,
	    "onkeydown" ,
	    "onkeypress" ,
	    "onkeyup" ,
	    "onmousedown" ,
	    "onmousemove" ,
	    "onmouseout" ,
	    "onmouseover" ,
	    "onmouseup" ,
	    "title" ,
	    "xml:lang" });
//
//
//


		
				boolean popup = getUtils().isBooleanAttribute(component, "popup");
				if (!popup) {
					getUtils().writeAttribute(writer, "style", "display: none");
			
		
		
writer.startElement("input", component);
			getUtils().writeAttribute(writer, "id", convertToString(clientId) + "InputDate" );
						getUtils().writeAttribute(writer, "name", convertToString(clientId) + "InputDate" );
						getUtils().writeAttribute(writer, "style", "display:none" );
						getUtils().writeAttribute(writer, "type", "hidden" );
						getUtils().writeAttribute(writer, "value", getInputValue(context,component) );
			
writer.endElement("input");

		
				} else {
				boolean disabled = getUtils().isBooleanAttribute(component, "disabled");				
				boolean showInput = getUtils().isBooleanAttribute(component, "showInput");
				String onfieldclick =null;
			    String type="text";
				if (!showInput){
					type="hidden";
				}
				
				variables.setVariable("type",type);
				variables.setVariable("disabled",new Boolean(disabled));
				
				
		
variables.setVariable("icon", getResource( "org.omidbiz.renderkit.html.iconimages.CalendarIcon" ).getUri(context, component) );

variables.setVariable("disabledIcon", getResource( "org.omidbiz.renderkit.html.iconimages.DisabledCalendarIcon" ).getUri(context, component) );

writer.startElement("input", component);
			getUtils().writeAttribute(writer, "accesskey", component.getAttributes().get("accesskey") );
						getUtils().writeAttribute(writer, "class", "rich-calendar-input " + convertToString(component.getAttributes().get("inputClass")) );
						getUtils().writeAttribute(writer, "disabled", variables.getVariable("disabled") );
						getUtils().writeAttribute(writer, "id", convertToString(clientId) + "InputDate" );
						getUtils().writeAttribute(writer, "maxlength", component.getAttributes().get("maxlength") );
						getUtils().writeAttribute(writer, "name", convertToString(clientId) + "InputDate" );
						getUtils().writeAttribute(writer, "onblur", component.getAttributes().get("oninputblur") );
						getUtils().writeAttribute(writer, "onchange", component.getAttributes().get("oninputchange") );
						getUtils().writeAttribute(writer, "onclick", component.getAttributes().get("oninputclick") );
						getUtils().writeAttribute(writer, "onfocus", component.getAttributes().get("oninputfocus") );
						getUtils().writeAttribute(writer, "onkeydown", component.getAttributes().get("oninputkeydown") );
						getUtils().writeAttribute(writer, "onkeypress", component.getAttributes().get("oninputkeypress") );
						getUtils().writeAttribute(writer, "onkeyup", component.getAttributes().get("oninputkeyup") );
						getUtils().writeAttribute(writer, "onmouseout", component.getAttributes().get("oninputmouseout") );
						getUtils().writeAttribute(writer, "onmouseover", component.getAttributes().get("oninputmouseover") );
						getUtils().writeAttribute(writer, "onselect", component.getAttributes().get("oninputselect") );
						getUtils().writeAttribute(writer, "size", component.getAttributes().get("inputSize") );
						getUtils().writeAttribute(writer, "style", "vertical-align: middle; " + convertToString(component.getAttributes().get("inputStyle")) );
						getUtils().writeAttribute(writer, "tabindex", component.getAttributes().get("tabindex") );
						getUtils().writeAttribute(writer, "type", variables.getVariable("type") );
						getUtils().writeAttribute(writer, "value", getInputValue(context,component) );
			

			
				boolean manualInput = getUtils().isBooleanAttribute(component, "enableManualInput");
				boolean readonly = getUtils().isBooleanAttribute(component, "readonly");
				if(!manualInput || readonly){
						getUtils().writeAttribute(writer, "readonly", "readonly");
					}   
			     	
			
writer.endElement("input");

		 
			String buttonIcon = org.richfaces.component.util.ViewUtil.getResourceURL((String) component.getAttributes().get("buttonIcon"),context);
			String buttonIconDisabled = org.richfaces.component.util.ViewUtil.getResourceURL((String) component.getAttributes().get("buttonIconDisabled"),context);
			String buttonLabel = (String) component.getAttributes().get("buttonLabel");
			variables.setVariable("buttonLabel",buttonLabel);
			variables.setVariable("buttonIconDisabled",buttonIconDisabled);
			variables.setVariable("buttonIcon",buttonIcon);
			if(buttonLabel==null || buttonLabel.length()==0){	
		
		 
writer.startElement("img", component);
			getUtils().writeAttribute(writer, "accesskey", component.getAttributes().get("accesskey") );
						getUtils().writeAttribute(writer, "alt", "" );
						getUtils().writeAttribute(writer, "class", "rich-calendar-button " + convertToString(component.getAttributes().get("buttonClass")) );
						getUtils().writeAttribute(writer, "id", convertToString(clientId) + "PopupButton" );
						getUtils().writeAttribute(writer, "style", "vertical-align: middle" );
						getUtils().writeAttribute(writer, "tabindex", component.getAttributes().get("tabindex") );
			

			
			    if(!disabled){
			    	
			    	//getUtils().writeAttribute(writer, "onclick", "$('"+clientId+"').component.doSwitch();");
			    	if(buttonIcon==null){
						getUtils().writeAttribute(writer, "src", variables.getVariable("icon"));
					}
					else{
						getUtils().writeAttribute(writer, "src", buttonIcon);
					}
			    }
			    else{
			    	
			    		//getUtils().writeAttribute(writer, "onclick", null);
			    		if(buttonIconDisabled==null){
							getUtils().writeAttribute(writer, "src", variables.getVariable("disabledIcon"));
						}
						else{
							getUtils().writeAttribute(writer, "src", buttonIconDisabled);
							}	
			    	}			    
			
		
writer.endElement("img");

		
				}
			else{		
		
	
writer.startElement("button", component);
			getUtils().writeAttribute(writer, "class", "rich-calendar-button " + convertToString(component.getAttributes().get("buttonClass")) );
						getUtils().writeAttribute(writer, "disabled", variables.getVariable("disabled") );
						getUtils().writeAttribute(writer, "id", convertToString(clientId) + "PopupButton" );
						getUtils().writeAttribute(writer, "name", convertToString(clientId) + "PopupButton" );
						getUtils().writeAttribute(writer, "style", "vertical-align: middle" );
						getUtils().writeAttribute(writer, "tabindex", component.getAttributes().get("tabindex") );
						getUtils().writeAttribute(writer, "type", "button" );
			
writer.writeText(convertToString(variables.getVariable("buttonLabel")),null);

writer.endElement("button");

		
				} 
		
	

		
				} 
		
	
java.util.Date currentDate  = component.getCurrentDateOrDefault() ;
writer.startElement("input", component);
			getUtils().writeAttribute(writer, "id", convertToString(clientId) + "InputCurrentDate" );
						getUtils().writeAttribute(writer, "name", convertToString(clientId) + "InputCurrentDate" );
						getUtils().writeAttribute(writer, "style", "display:none" );
						getUtils().writeAttribute(writer, "type", "hidden" );
						getUtils().writeAttribute(writer, "value", getCurrentDateAsString(context,component,currentDate) );
			
writer.endElement("input");
dayCellClass(context, component);

writer.endElement("span");
writer.startElement("div", component);
			getUtils().writeAttribute(writer, "id", convertToString(clientId) + "IFrame" );
						getUtils().writeAttribute(writer, "style", "display: none;" );
			
writer.endElement("div");
writer.startElement("div", component);
			getUtils().writeAttribute(writer, "id", clientId );
						getUtils().writeAttribute(writer, "style", "display: none;" );
			
writer.endElement("div");
writer.startElement("div", component);
			getUtils().writeAttribute(writer, "id", convertToString(clientId) + "Script" );
						getUtils().writeAttribute(writer, "style", "display: none;" );
			
writer.startElement("script", component);
			getUtils().writeAttribute(writer, "type", "text/javascript" );
			
writer.writeText(convertToString("new Calendar('" + convertToString(clientId) + "', {"),null);

/**/
					String mode = (String) component.getAttributes().get("mode");
					if(org.omidbiz.component.UIPersianCalendar.AJAX_MODE.equals(mode)){
			/**/
writer.writeText(convertToString("submitFunction:"),null);

/**/writeSubmitFunction(context, component);/**/
writer.writeText(convertToString(","),null);

/**/
					}
			/**/
writer.writeText(convertToString("dayListTableId: '" + convertToString(clientId) + "Day', \n			weekNumberBarId: '" + convertToString(clientId) + "WeekNum', \n			weekDayBarId: '" + convertToString(clientId) + "WeekDay',\n			currentDate: " + convertToString(getCurrentDate(context,component,currentDate)) + ", \n			selectedDate: " + convertToString(getSelectedDate(context,component)) + ", \n			datePattern: '" + convertToString(component.getDatePattern()) + "',\n			jointPoint: '" + convertToString(component.getJointPoint()) + "',\n			direction: '" + convertToString(component.getDirection()) + "',\n			boundaryDatesMode:'" + convertToString(component.getBoundaryDatesMode()) + "',\n			popup: " + convertToString(component.isPopup()) + ",\n			enableManualInput: " + convertToString(component.getAttributes().get("enableManualInput")) + ",\n			showInput: " + convertToString(component.getAttributes().get("showInput")) + ",\n			disabled: " + convertToString(component.isDisabled()) + ",\n			readonly: " + convertToString(component.getAttributes().get("readonly")) + ",\n			ajaxSingle: " + convertToString(component.getAttributes().get("ajaxSingle")) + ",\n			verticalOffset:" + convertToString(component.getVerticalOffset()) + ",\n			horizontalOffset: " + convertToString(component.getHorizontalOffset()) + ",\n			style:'z-index: " + convertToString(component.getAttributes().get("zindex")) + "; " + convertToString(component.getAttributes().get("style")) + "',\n			firstWeekDay: " + convertToString(getFirstWeekDay(context,component)) + ", \n			minDaysInFirstWeek: " + convertToString(getMinDaysInFirstWeek(context,component)) + ",\n			todayControlMode:'" + convertToString(component.getAttributes().get("todayControlMode")) + "',\n			showHeader:" + convertToString(component.getAttributes().get("showHeader")) + ",\n			showFooter:" + convertToString(component.getAttributes().get("showFooter")) + ",\n			showWeeksBar:" + convertToString(component.getAttributes().get("showWeeksBar")) + ",\n			showWeekDaysBar:" + convertToString(component.getAttributes().get("showWeekDaysBar")) + ",\n			showApplyButton:" + convertToString(component.getAttributes().get("showApplyButton")) + ",\n			resetTimeOnDateSelect:" + convertToString(component.getAttributes().get("resetTimeOnDateSelect")) + ",\n			defaultTime:" + convertToString(getPreparedDefaultTime(component))),null);

writeLabels(context, component);

writeClass(context, component);

writeDayCellClass(context, component);

writeDayStyleClass(context, component);

writeIsDayEnabled(context, component);

writeSymbols(context, component);

writeEventHandlerFunction(context, component, "ondateselected");

writeEventHandlerFunction(context, component, "ondateselect");

writeEventHandlerFunction(context, component, "ontimeselect");

writeEventHandlerFunction(context, component, "ontimeselected");

writeEventHandlerFunction(context, component, "onchanged");

writeEventHandlerFunction(context, component, "ondatemouseover");

writeEventHandlerFunction(context, component, "ondatemouseout");

writeEventHandlerFunction(context, component, "onexpand");

writeEventHandlerFunction(context, component, "oncollapse");

writeEventHandlerFunction(context, component, "oncurrentdateselect");

writeEventHandlerFunction(context, component, "oncurrentdateselected");

/**/
				if (component.getChildCount() != 0) {
			/**/
writer.writeText(convertToString(",\n  dayListMarkup:"),null);

/**/
					writeMarkupScriptBody(context, component, true);
				} 
			/**/
writeOptionalFacetMarkupScriptBody(context, component, "optionalHeader");

writeOptionalFacetMarkupScriptBody(context, component, "optionalFooter");

writeFacetMarkupScriptBody(context, component, "weekDay");

writeFacetMarkupScriptBody(context, component, "weekNumber");

writeFacetMarkupScriptBody(context, component, "header");

writeFacetMarkupScriptBody(context, component, "footer");

writer.writeText(convertToString("}).load("),null);

/**/
				writePreloadBody(context, component);
			/**/
writer.writeText(convertToString(");"),null);

writer.endElement("script");
writer.endElement("div");

	}		
	
	public void doEncodeEnd(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {
		ComponentVariables variables = ComponentsVariableResolver.getVariables(this, component);
		doEncodeEnd(writer, context, (org.omidbiz.component.UIPersianCalendar)component, variables );

		ComponentsVariableResolver.removeVariables(this, component);
	}		
	

}
