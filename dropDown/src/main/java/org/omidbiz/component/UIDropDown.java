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

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 * JSF component class
 * 
 */
public class UIDropDown extends UIInput
{

    public static final String COMPONENT_TYPE = "org.omidbiz.DropDown";

    public static final String COMPONENT_FAMILY = "org.omidbiz.DropDown";

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

    private String var;

    public String getVar()
    {
        return var;
    }

    public void setVar(String var)
    {
        this.var = var;
    }

    public void putVariables(Object item)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> requestMap = context.getExternalContext().getRequestMap();
        requestMap.put(getVar(), item);
    }

    @Override
    public Object saveState(FacesContext context)
    {
        return new Object[] { super.saveState(context), var };
    }

    @Override
    public void restoreState(FacesContext context, Object state)
    {
        Object values[] = (Object[]) state;
        int i = 0;
        super.restoreState(context, values[i++]);
        var = (String) values[i++];
    }

}
