/**
 *
 */

package org.omidbiz.component;

import javax.el.ValueExpression;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

/**
 * JSF component class
 * 
 */
public class UITreeTable extends UIData
{

    public static final String COMPONENT_TYPE = "org.omidbiz.TreeTable";

    public static final String COMPONENT_FAMILY = "org.omidbiz.TreeTable";

    public UITreeTable()
    {
        super();
        setRendererType(COMPONENT_TYPE);
    }

    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

    @Override
    public boolean getRendersChildren()
    {
        return true;
    }

   

}
