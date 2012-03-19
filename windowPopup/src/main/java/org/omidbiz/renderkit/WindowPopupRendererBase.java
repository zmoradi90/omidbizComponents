/*******************************************************************************
 * Copyright 2012 Omid Pourhadi
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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

public class WindowPopupRendererBase extends HeaderResourcesRendererBase
{

	@Override
	public void preDecode(FacesContext context, UIComponent component)
	{
		UIWindowPopup windowPopup = (UIWindowPopup) component;
		ActionListener listener = null;
		MethodExpression minMethod = (MethodExpression) windowPopup.getAttributes().get("atMin");
		listener = new MethodExpressionActionListener(minMethod);
		FacesEvent event = new ActionEvent(windowPopup);
		event.setPhaseId(PhaseId.INVOKE_APPLICATION);
		windowPopup.queueEvent(event);

	}

	@Override
	protected Class getComponentClass()
	{
		return UIWindowPopup.class;
	}

}
