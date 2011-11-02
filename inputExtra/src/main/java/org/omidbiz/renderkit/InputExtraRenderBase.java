package org.omidbiz.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UIInputExtra;

public class InputExtraRenderBase extends HeaderResourcesRendererBase {

	
	public void initializeMask(FacesContext context, UIInputExtra component)
			throws IOException {
		
		String maskPattern = (String)component.getAttributes().get("maskPattern");
		
		UIComponent parentComponent =  component.getParent();
		ResponseWriter writer = context.getResponseWriter();
		
		if(parentComponent !=null && maskPattern != null){
			StringBuilder sb = new StringBuilder("jQuery(document).ready(function(){");
			sb.append(" jQuery(\"#"+parentComponent.getClientId(context).replace(":", "\\\\:")+"\").mask(\""+maskPattern+"\");");
			sb.append("});");
			getUtils().writeScript(context, component, sb.toString());			
		}
	}

	@Override
	protected Class getComponentClass() {
		return UIInputExtra.class;
	}

}
