package org.omidbiz.handler;

import javax.faces.event.ActionEvent;

import org.ajax4jsf.webapp.taglib.AjaxComponentHandler;

import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;

public class WindowPopupTagHandler extends ComponentHandler {

	public WindowPopupTagHandler(ComponentConfig config) {
		super(config);
	}

	@Override
	protected MetaRuleset createMetaRuleset(Class type) {
		
		return super.createMetaRuleset(type)
		.addRule(new MethodRule("atMin", Void.class, 
	               new Class<?>[] { ActionEvent.class } ));
	}
	

}
