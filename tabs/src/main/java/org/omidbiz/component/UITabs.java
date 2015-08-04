/**
 *
 */

package org.omidbiz.component;

import javax.faces.component.UIComponentBase;

/**
 * JSF component class
 * 
 */
public abstract class UITabs extends UIComponentBase
{

    public static final String COMPONENT_TYPE = "org.omidbiz.Tabs";

    public static final String COMPONENT_FAMILY = "org.omidbiz.Tabs";

    @Override
    public boolean getRendersChildren()
    {
        return false;
    }

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

    private int active;
    private boolean keepState;

    public boolean isKeepState()
    {
        return keepState;
    }

    public void setKeepState(boolean keepState)
    {
        this.keepState = keepState;
    }

    public int getActive()
    {
        return active;
    }

    public void setActive(int active)
    {
        this.active = active;
    }

}
