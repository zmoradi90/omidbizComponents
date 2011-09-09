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
import org.omidbiz.component.html.HtmlInputListOfValues;

public class InputListOfValuesTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 		 		 		 	  			  		  	  
		/*
		 * objectName
		 * the most important attribute use for setting and retrieving value via javascript
		 */
		private ValueExpression _objectName;
		/**
		 * the most important attribute use for setting and retrieving value via javascript
		 * Setter for objectName
		 * @param objectName - new value
		 */
		 public void setObjectName( ValueExpression  __objectName ){
			this._objectName = __objectName;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * pValueText
		 * it is used to show in textbox
		 */
		private ValueExpression _pValueText;
		/**
		 * it is used to show in textbox
		 * Setter for pValueText
		 * @param pValueText - new value
		 */
		 public void setPValueText( ValueExpression  __pValueText ){
			this._pValueText = __pValueText;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * pid
		 * it is used for filling hidden field
		 */
		private ValueExpression _pid;
		/**
		 * it is used for filling hidden field
		 * Setter for pid
		 * @param pid - new value
		 */
		 public void setPid( ValueExpression  __pid ){
			this._pid = __pid;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * selectedText
		 * text value is used for text link
		 */
		private ValueExpression _selectedText;
		/**
		 * text value is used for text link
		 * Setter for selectedText
		 * @param selectedText - new value
		 */
		 public void setSelectedText( ValueExpression  __selectedText ){
			this._selectedText = __selectedText;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * type
		 * define how comonent being rendered 
				dialog
				link
		 */
		private ValueExpression _type;
		/**
		 * define how comonent being rendered 
				dialog
				link
		 * Setter for type
		 * @param type - new value
		 */
		 public void setType( ValueExpression  __type ){
			this._type = __type;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * view
		 * used when type is dialog to define which page should load in iframe
		 */
		private ValueExpression _view;
		/**
		 * used when type is dialog to define which page should load in iframe
		 * Setter for view
		 * @param view - new value
		 */
		 public void setView( ValueExpression  __view ){
			this._view = __view;
	     }
	  
	 	 	
	
    public void release()
    {
        // TODO Auto-generated method stub
        super.release();
        		 		 		 		 		    this._objectName = null;
	 		 		    this._pValueText = null;
	 		 		    this._pid = null;
	 		 		 		    this._selectedText = null;
	 		 		    this._type = null;
	 		 		    this._view = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlInputListOfValues comp = (HtmlInputListOfValues) component;
    		 			 
						if (this._objectName != null) {
				if (this._objectName.isLiteralText()) {
					try {
												
						java.lang.String __objectName = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._objectName.getExpressionString(), 
											java.lang.String.class);
					
												comp.setObjectName(__objectName);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("objectName", this._objectName);
				}
			}
					   		 			 
						if (this._pValueText != null) {
				if (this._pValueText.isLiteralText()) {
					try {
												
						java.lang.String __pValueText = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._pValueText.getExpressionString(), 
											java.lang.String.class);
					
												comp.setPValueText(__pValueText);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("pValueText", this._pValueText);
				}
			}
					   		 			 
						if (this._pid != null) {
				if (this._pid.isLiteralText()) {
					try {
												
						java.lang.Object __pid = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._pid.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setPid(__pid);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("pid", this._pid);
				}
			}
					    		 			 
						if (this._selectedText != null) {
				if (this._selectedText.isLiteralText()) {
					try {
												
						java.lang.String __selectedText = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._selectedText.getExpressionString(), 
											java.lang.String.class);
					
												comp.setSelectedText(__selectedText);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("selectedText", this._selectedText);
				}
			}
					   		 			 
						if (this._type != null) {
				if (this._type.isLiteralText()) {
					try {
												
						java.lang.String __type = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._type.getExpressionString(), 
											java.lang.String.class);
					
												comp.setType(__type);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("type", this._type);
				}
			}
					   		 			 
						if (this._view != null) {
				if (this._view.isLiteralText()) {
					try {
												
						java.lang.String __view = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._view.getExpressionString(), 
											java.lang.String.class);
					
												comp.setView(__view);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("view", this._view);
				}
			}
					     }
	
	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getComponentType()
	 */
	public String getComponentType() {
		// TODO Auto-generated method stub
		return "org.omidbiz.InputListOfValues";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.InputListOfValuesRenderer";
			}

}
