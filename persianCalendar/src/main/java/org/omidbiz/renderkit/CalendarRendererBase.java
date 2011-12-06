
package org.omidbiz.renderkit;

import javax.faces.component.UIComponent;

import org.omidbiz.component.UIPersianCalendar;
import org.richfaces.renderkit.TemplateEncoderRendererBase;

/**
 * @author Omid Pourhadi - mailto:omidpourhadi@gmail.com 
 * 
 */
public class CalendarRendererBase extends TemplateEncoderRendererBase {

	@Override
	protected Class<? extends UIComponent> getComponentClass() {
		return UIPersianCalendar.class;
	}
	

	
}
