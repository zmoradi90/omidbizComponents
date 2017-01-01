package org.omidbiz.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
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

    public static List<Long> convertStringToLong(String commaSeparated)
    {
        List<Long> longList = new ArrayList<Long>();
        if (commaSeparated.contains(","))
        {
            String[] split = commaSeparated.split(",");
            if (split != null && split.length > 0)
            {
                for (int i = 0; i < split.length; i++)
                {
                    String val = split[i].trim().replace(" ", "");
                    if (isNotEmpty(val))
                        longList.add(Long.valueOf(val));
                }

            }
        }
        else
        {
            if (isNotEmpty(commaSeparated))
            {
                try
                {
                    longList.add(Long.valueOf(commaSeparated.trim().replace(" ", "")));
                }
                catch (Exception e)
                {
                }
            }
        }
        return longList;
    }

    public static boolean isNotEmpty(String input)
    {
        return (input != null && input.trim().length() > 0);
    }

    public static boolean isEmpty(String input)
    {
        if (input == null)
        {
            return true;
        }
        return input.trim().length() == 0;
    }

    public static boolean isNotEmpty(Collection<?> input)
    {
        return input != null && input.size() > 0;
    }

    public static boolean isEmpty(Collection<?> input)
    {
        return isNotEmpty(input) == false;
    }

    public static Object castTo(Class clazz, Object value)
    {
        if (value == null)
            return null;
        if (value instanceof String)
        {
            String val = (String) value;
            if (isEmpty(val))
                return null;
        }
        if (Boolean.class == clazz || boolean.class == clazz)
            return (Boolean) value;
        if (Date.class == clazz)
            return (Date) value;
        if (Byte.class == clazz || byte.class == clazz)
            return Byte.parseByte(String.valueOf(value));
        if (Short.class == clazz || short.class == clazz)
            return Short.parseShort(String.valueOf(value));
        if (BigDecimal.class == clazz)
            return new BigDecimal(String.valueOf(value));
        if (Integer.class == clazz || int.class == clazz)
            return Integer.parseInt(String.valueOf(value));
        if (Long.class == clazz || long.class == clazz)
            return Long.parseLong(String.valueOf(value));
        if (Float.class == clazz || float.class == clazz)
            return Float.parseFloat(String.valueOf(value));
        if (Double.class == clazz || double.class == clazz)
            return Double.parseDouble(String.valueOf(value));
        if (String.class == clazz)
            return String.valueOf(value);
        return value;
    }

    public static UIForm getEnclosingForm(UIComponent component)
    {
        UIComponent result = component;
        while (result != null)
        {
            if (result instanceof UIForm)
            {
                return (UIForm) result;
            }
            result = result.getParent();
        }
        return null;
    }

}
