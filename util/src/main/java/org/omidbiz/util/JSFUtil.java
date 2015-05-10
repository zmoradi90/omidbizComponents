package org.omidbiz.util;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * @author Omid Pourhadi
 *
 */
public class JSFUtil
{

    public static boolean set(UIComponent component, String propertyName, Object value)
    {
        ValueExpression ve = component.getValueExpression(propertyName);
        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elContext = context.getELContext();
        if (ve == null || ve.isReadOnly(elContext))
            return false;

        ve.setValue(elContext, value);
        return true;
    }

    public static <T> T get(UIComponent component, String property, T fieldValue, T defaultValue, boolean allowNullBinding, Class<T> cls)
    {
        if (fieldValue != null)
            return fieldValue;
        ValueExpression ve = component.getValueExpression(property);
        if (ve == null)
            return defaultValue;
        Object value = ve.getValue(FacesContext.getCurrentInstance().getELContext());
        if (value == null)
        {
            return allowNullBinding ? null : defaultValue;
        }

        checkValueClass(value, cls, component, ve);
        return (T) value;
    }

    public static void checkValueClass(Object value, Class expectedClass, UIComponent component, ValueExpression expression)
    {
        Class valueClass = value.getClass();
        if (!expectedClass.isAssignableFrom(valueClass))
            throw new ClassCastException("The value received through expression \"" + expression.getExpressionString()
                    + "\" of component with id=\"" + component.getId() + "\" should be of type \"" + expectedClass.getName()
                    + "\" but was of type: \"" + valueClass.getName() + "\"");
    }

}
