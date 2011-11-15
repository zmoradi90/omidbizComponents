/**
 *
 */

package org.omidbiz.component;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 * JSF component class
 * 
 */
public abstract class UIInputListOfValues extends UIInput {

	public static final String COMPONENT_TYPE = "org.omidbiz.InputListOfValues";

	public static final String COMPONENT_FAMILY = "org.omidbiz.InputListOfValues";

	private Object valueName;

	public Object getValueName() {
		return valueName;
	}

	public void setValueName(Object valueName) {
		this.valueName = valueName;
	}

	@Override
	public Object saveState(FacesContext context) {
		Object values[] = new Object[3];
		values[0] = super.saveState(context);
		values[1] = valueName;
		return values;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		valueName = (String) values[1];
	}

}
