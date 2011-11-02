/**
 * GENERATED FILE - DO NOT EDIT
 *
 */
package org.omidbiz.taglib;

import javax.faces.component.UIComponent ;
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
import org.omidbiz.component.html.HtmlInputExtra;

public class InputExtraTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 		 		 		 	  			  		  	  
		/*
		 * maskPattern
		 * 
		 */
		private ValueExpression _maskPattern;
		/**
		 * 
		 * Setter for maskPattern
		 * @param maskPattern - new value
		 */
		 public void setMaskPattern( ValueExpression  __maskPattern ){
			this._maskPattern = __maskPattern;
	     }
	  
	 	 		 	
	
    public void release()
    {
        // TODO Auto-generated method stub
        super.release();
        		 		 		 		 		    this._maskPattern = null;
	 		 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlInputExtra comp = (HtmlInputExtra) component;
    		 			 
						if (this._maskPattern != null) {
				if (this._maskPattern.isLiteralText()) {
					try {
												
						java.lang.String __maskPattern = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._maskPattern.getExpressionString(), 
											java.lang.String.class);
					
												comp.setMaskPattern(__maskPattern);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("maskPattern", this._maskPattern);
				}
			}
					      }
	
	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getComponentType()
	 */
	public String getComponentType() {
		// TODO Auto-generated method stub
		return "org.omidbiz.InputExtra";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.InputExtraRenderer";
			}

}
