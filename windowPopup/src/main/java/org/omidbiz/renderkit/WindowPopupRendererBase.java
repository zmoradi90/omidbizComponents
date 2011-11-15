package org.omidbiz.renderkit;

import javax.el.MethodExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.FacesEvent;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.event.PhaseId;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIWindowPopup;

public class WindowPopupRendererBase extends HeaderResourcesRendererBase {

	
	
	
	
	@Override
	public void preDecode(FacesContext context, UIComponent component) {				
		UIWindowPopup windowPopup = (UIWindowPopup) component;
		ActionListener listener = null;
		MethodExpression minMethod
		= (MethodExpression) windowPopup.getAttributes().get("atMin");
		listener = new MethodExpressionActionListener(minMethod);
		FacesEvent event = new ActionEvent(windowPopup);
		event.setPhaseId(PhaseId.INVOKE_APPLICATION);
		windowPopup.queueEvent(event);


	}

	@Override
	protected Class getComponentClass() {
		return UIWindowPopup.class;
	}

}
