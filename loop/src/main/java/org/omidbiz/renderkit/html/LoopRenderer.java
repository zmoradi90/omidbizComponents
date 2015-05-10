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
package org.omidbiz.renderkit.html;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.ajax4jsf.renderkit.HeaderResourcesRendererBase;
import org.omidbiz.component.UILoop;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class LoopRenderer extends HeaderResourcesRendererBase
{

  
    @Override
    protected void doEncodeChildren(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException
    {
        UILoop loop = (UILoop) component;
        int begin = (Integer) loop.getAttributes().get("begin");
        int end = (Integer) loop.getAttributes().get("end");
        for (; begin <= end; begin++)
        {
            loop.putVariables(begin);
            if (component.getChildCount() > 0)
            {
                Iterator<UIComponent> kids = component.getChildren().iterator();
                while (kids.hasNext())
                {
                    UIComponent kid = kids.next();
                    kid.encodeAll(context);
                }
            }
        }
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

    @Override
    protected Class<? extends UIComponent> getComponentClass()
    {
        return UILoop.class;
    }

}
