package org.omidbiz.component;

import java.io.IOException;

import javax.faces.component.UIColumn;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class UITreeColumn extends UIColumn
{

    public static final String COMPONENT_TYPE = "org.omidbiz.component.TreeColumn";
    public static final String COMPONENT_FAMILY = "org.omidbiz.component.TreeColumn";

    public UITreeColumn()
    {
        setRendererType("org.omidbiz.component.TreeColumnRenderer");
    }

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

}
