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

import javax.faces.component.UIComponentBase;

/**
 * JSF component class
 * 
 */
public abstract class UITooltip extends UIComponentBase
{

    public static final String COMPONENT_TYPE = "org.omidbiz.InputExtra";

    public static final String COMPONENT_FAMILY = "org.omidbiz.InputExtra";

    private boolean html;

    private String gravity;

    private int delayOut;

    public int getDelayOut()
    {
        return delayOut;
    }

    public void setDelayOut(int delayOut)
    {
        this.delayOut = delayOut;
    }

    public String getGravity()
    {
        return gravity;
    }

    public void setGravity(String gravity)
    {
        this.gravity = gravity;
    }

    public boolean isHtml()
    {
        return html;
    }

    public void setHtml(boolean html)
    {
        this.html = html;
    }

}
