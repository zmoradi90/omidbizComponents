package org.omidbiz.renderkit;

import javax.faces.component.UIComponent;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIWindowPopup;

public class WindowPopupRendererBase extends HeaderResourcesRendererBase {

	@Override
	protected Class getComponentClass() {
		return UIWindowPopup.class;
	}

}
