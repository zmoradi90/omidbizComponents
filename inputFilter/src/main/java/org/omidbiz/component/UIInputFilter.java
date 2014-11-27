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

package org.omidbiz.component;

import javax.el.MethodExpression;
import javax.faces.component.ActionSource2;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.FacesEvent;

import org.ajax4jsf.component.AjaxComponent;
import org.ajax4jsf.context.AjaxContext;
import org.ajax4jsf.event.AjaxEvent;
import org.ajax4jsf.event.AjaxListener;
import org.ajax4jsf.event.AjaxSource;

/**
 * JSF component class
 * 
 */
public abstract class UIInputFilter extends UIInput implements AjaxComponent, AjaxSource, ActionSource2
{

    public static final String COMPONENT_TYPE = "org.omidbiz.InputFilter";

    public static final String COMPONENT_FAMILY = "org.omidbiz.InputFilter";

    public static String getComponentFamily()
    {
        return COMPONENT_FAMILY;
    }

    public static String getComponentType()
    {
        return COMPONENT_TYPE;
    }

    public void removeActionListener(ActionListener listener)
    {

        removeFacesListener(listener);

    }

    public void addActionListener(ActionListener listener)
    {

        addFacesListener(listener);

    }

    public ActionListener[] getActionListeners()
    {

        ActionListener al[] = (ActionListener[]) getFacesListeners(ActionListener.class);
        return (al);

    }

    public void broadcast(FacesEvent event) throws AbortProcessingException
    {
        // perform default
        super.broadcast(event);
        if (event instanceof AjaxEvent)
        {
            FacesContext context = getFacesContext();
            MethodExpression actionExpression = getActionExpression();
            if(actionExpression != null)
                actionExpression.invoke(context.getELContext(), new Object[]{event});
//            ActionListener actionListener = context.getApplication().getActionListener();
//            if(actionListener != null)
//                actionListener.processAction((AjaxEvent)event);
            // complete re-Render fields. AjaxEvent deliver before render
            // response.
            System.out.println("omad");
            setupReRender(context);
            // Put data for send in response
            Object data = getData();
            AjaxContext ajaxContext = AjaxContext.getCurrentInstance(context);
            if (null != data)
            {
                ajaxContext.setResponseData(data);
            }

            ajaxContext.setOncomplete(getOncomplete());
        }
    }

    public void queueEvent(FacesEvent event)
    {

        super.queueEvent(event);

    }

    public void addAjaxListener(final AjaxListener listener)
    {
        addFacesListener(listener);
    }

    public AjaxListener[] getAjaxListeners()
    {
        return (AjaxListener[]) getFacesListeners(AjaxListener.class);
    }

    public void removeAjaxListener(final AjaxListener listener)
    {
        removeFacesListener(listener);
    }

    protected void setupReRender(FacesContext facesContext)
    {
        AjaxContext.getCurrentInstance(facesContext).addRegionsFromComponent(this);
        setupReRender();
    }

    protected void setupReRender()
    {
    }

}
