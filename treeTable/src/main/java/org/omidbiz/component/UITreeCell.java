package org.omidbiz.component;

import javax.faces.component.UIComponentBase;

public class UITreeCell extends UIComponentBase
{

    /**
     * <p>
     * The standard component type for this component.
     * </p>
     */
    public static final String COMPONENT_TYPE = "org.omidbiz.component.UITreeCell";

    /**
     * <p>
     * The standard component family for this component.
     * </p>
     */
    public static final String COMPONENT_FAMILY = "org.omidbiz.component.UITreeCell";

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

}
