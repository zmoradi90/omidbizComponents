package org.omidbiz.handler;

import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionValueChangeListener;
import javax.faces.event.ValueChangeEvent;

import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;

public class LovTagHandler extends ComponentHandler {
	
	public LovTagHandler(ComponentConfig config) {
		super(config);
	}

	@Override
	protected MetaRuleset createMetaRuleset(Class type) {
		
		return super.createMetaRuleset(type)
		.addRule(new MethodRule("customEvent", Void.class, 
	               new Class<?>[] { ValueChangeEvent.class } ));
	}


}
