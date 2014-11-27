package org.omidbiz.component;

import javax.faces.component.UIComponent;

import org.ajax4jsf.event.AjaxEvent;

public class InputFilterEvent extends AjaxEvent
{

    private Object submittedValue;

    public InputFilterEvent(UIComponent component)
    {
        super(component);
    }

    public InputFilterEvent(UIComponent component, Object submittedValue)
    {
        super(component);
        this.submittedValue = submittedValue;
    }

    public Object getSubmittedValue()
    {
        return submittedValue;
    }

    public void setSubmittedValue(Object submittedValue)
    {
        this.submittedValue = submittedValue;
    }

}
