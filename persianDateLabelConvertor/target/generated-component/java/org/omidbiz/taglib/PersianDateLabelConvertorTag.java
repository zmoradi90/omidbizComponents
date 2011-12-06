/**
 * GENERATED FILE - DO NOT EDIT
 *
 */
package org.omidbiz.taglib;

import javax.faces.component.UIComponent ;
import java.lang.Object ;
import java.lang.String ;
import org.ajax4jsf.webapp.taglib.HtmlComponentTagBase ;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.el.MethodExpression;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.el.ValueExpression;
import org.richfaces.webapp.taglib.MethodBindingMethodExpressionAdaptor;
import org.richfaces.webapp.taglib.ValueBindingValueExpressionAdaptor;
import org.omidbiz.component.html.HtmlPersianDateLabelConvertor;

public class PersianDateLabelConvertorTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 		 	  			  		  	  
		/*
		 * datePattern
		 * 
		 */
		private ValueExpression _datePattern;
		/**
		 * 
		 * Setter for datePattern
		 * @param datePattern - new value
		 */
		 public void setDatePattern( ValueExpression  __datePattern ){
			this._datePattern = __datePattern;
	     }
	  
	 	 		 		 		 		 	  			  		  	  
		/*
		 * value
		 * 
		 */
		private ValueExpression _value;
		/**
		 * 
		 * Setter for value
		 * @param value - new value
		 */
		 public void setValue( ValueExpression  __value ){
			this._value = __value;
	     }
	  
	 	 	
	
    public void release()
    {
        // TODO Auto-generated method stub
        super.release();
        		 		 		    this._datePattern = null;
	 		 		 		 		 		    this._value = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlPersianDateLabelConvertor comp = (HtmlPersianDateLabelConvertor) component;
  		 			 
						if (this._datePattern != null) {
				if (this._datePattern.isLiteralText()) {
					try {
												
						java.lang.String __datePattern = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._datePattern.getExpressionString(), 
											java.lang.String.class);
					
												comp.setDatePattern(__datePattern);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("datePattern", this._datePattern);
				}
			}
					      		 			 
						if (this._value != null) {
				if (this._value.isLiteralText()) {
					try {
												
						java.lang.Object __value = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._value.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setValue(__value);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("value", this._value);
				}
			}
					     }
	
	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getComponentType()
	 */
	public String getComponentType() {
		// TODO Auto-generated method stub
		return "org.omidbiz.PersianDateLabelConvertor";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.PersianDateLabelConvertorRenderer";
			}

}
