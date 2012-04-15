package org.omidbiz.renderkit;

import javax.faces.component.UIComponent;

import org.ajax4jsf.renderkit.AjaxCommandRendererBase;
import org.omidbiz.component.UILovCloseButton;

public class CloseButtonRendererBase extends AjaxCommandRendererBase
{

	@Override	
	protected Class<? extends UIComponent> getComponentClass()
	{
		return UILovCloseButton.class;
	}

	
}
