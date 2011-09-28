/**
 * GENERATED FILE - DO NOT EDIT
 *
 */
package org.omidbiz.taglib;

import javax.faces.component.UIComponent ;
import javax.faces.convert.Converter ;
import java.lang.Object ;
import java.lang.Boolean ;
import java.lang.String ;
import org.ajax4jsf.webapp.taglib.HtmlComponentTagBase ;
import javax.faces.el.MethodBinding ;

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
		 * converter
		 * converter
		 */
		private ValueExpression _converter;
		/**
		 * converter
		 * Setter for converter
		 * @param converter - new value
		 */
		 public void setConverter( ValueExpression  __converter ){
			this._converter = __converter;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * converterMessage
		 * converterMessage
		 */
		private ValueExpression _converterMessage;
		/**
		 * converterMessage
		 * Setter for converterMessage
		 * @param converterMessage - new value
		 */
		 public void setConverterMessage( ValueExpression  __converterMessage ){
			this._converterMessage = __converterMessage;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * immediate
		 * immediate
		 */
		private ValueExpression _immediate;
		/**
		 * immediate
		 * Setter for immediate
		 * @param immediate - new value
		 */
		 public void setImmediate( ValueExpression  __immediate ){
			this._immediate = __immediate;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * localValueSet
		 * localValueSet
		 */
		private ValueExpression _localValueSet;
		/**
		 * localValueSet
		 * Setter for localValueSet
		 * @param localValueSet - new value
		 */
		 public void setLocalValueSet( ValueExpression  __localValueSet ){
			this._localValueSet = __localValueSet;
	     }
	  
	 	 		 	  			  		  	  
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
		 * required
		 * required
		 */
		private ValueExpression _required;
		/**
		 * required
		 * Setter for required
		 * @param required - new value
		 */
		 public void setRequired( ValueExpression  __required ){
			this._required = __required;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * requiredMessage
		 * requiredMessage
		 */
		private ValueExpression _requiredMessage;
		/**
		 * requiredMessage
		 * Setter for requiredMessage
		 * @param requiredMessage - new value
		 */
		 public void setRequiredMessage( ValueExpression  __requiredMessage ){
			this._requiredMessage = __requiredMessage;
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
		 * sendRequestToServer
		 * send request to url view when close popup modal
		 */
		private ValueExpression _sendRequestToServer;
		/**
		 * send request to url view when close popup modal
		 * Setter for sendRequestToServer
		 * @param sendRequestToServer - new value
		 */
		 public void setSendRequestToServer( ValueExpression  __sendRequestToServer ){
			this._sendRequestToServer = __sendRequestToServer;
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
		 * valid
		 * valid
		 */
		private ValueExpression _valid;
		/**
		 * valid
		 * Setter for valid
		 * @param valid - new value
		 */
		 public void setValid( ValueExpression  __valid ){
			this._valid = __valid;
	     }
	  
	 	 		 	  	  	  
		/*
		 * validator
		 * validator
		 */
		private MethodExpression _validator;
		/**
		 * validator
		 * Setter for validator
		 * @param validator - new value
		 */
		 public void setValidator( MethodExpression  __validator ){
			this._validator = __validator;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * validatorMessage
		 * validatorMessage
		 */
		private ValueExpression _validatorMessage;
		/**
		 * validatorMessage
		 * Setter for validatorMessage
		 * @param validatorMessage - new value
		 */
		 public void setValidatorMessage( ValueExpression  __validatorMessage ){
			this._validatorMessage = __validatorMessage;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * value
		 * The value of the component
		 */
		private ValueExpression _value;
		/**
		 * The value of the component
		 * Setter for value
		 * @param value - new value
		 */
		 public void setValue( ValueExpression  __value ){
			this._value = __value;
	     }
	  
	 	 		 	  	  	  
		/*
		 * valueChangeListener
		 * valueChangeListener
		 */
		private MethodExpression _valueChangeListener;
		/**
		 * valueChangeListener
		 * Setter for valueChangeListener
		 * @param valueChangeListener - new value
		 */
		 public void setValueChangeListener( MethodExpression  __valueChangeListener ){
			this._valueChangeListener = __valueChangeListener;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * valueName
		 * The value of the component show in textbox
		 */
		private ValueExpression _valueName;
		/**
		 * The value of the component show in textbox
		 * Setter for valueName
		 * @param valueName - new value
		 */
		 public void setValueName( ValueExpression  __valueName ){
			this._valueName = __valueName;
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
        		 		 		    this._converter = null;
	 		 		    this._converterMessage = null;
	 		 		 		 		    this._immediate = null;
	 		 		 		    this._localValueSet = null;
	 		 		    this._objectName = null;
	 		 		    this._pValueText = null;
	 		 		    this._pid = null;
	 		 		 		    this._required = null;
	 		 		    this._requiredMessage = null;
	 		 		    this._selectedText = null;
	 		 		    this._sendRequestToServer = null;
	 		 		    this._type = null;
	 		 		    this._valid = null;
	 		 		    this._validator = null;
	 		 		    this._validatorMessage = null;
	 		 		 		    this._value = null;
	 		 		    this._valueChangeListener = null;
	 		 		 		    this._valueName = null;
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
  		 			setConverterProperty(comp, this._converter);
		   		 			 
						if (this._converterMessage != null) {
				if (this._converterMessage.isLiteralText()) {
					try {
												
						java.lang.String __converterMessage = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._converterMessage.getExpressionString(), 
											java.lang.String.class);
					
												comp.setConverterMessage(__converterMessage);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("converterMessage", this._converterMessage);
				}
			}
					     		 			 
						if (this._immediate != null) {
				if (this._immediate.isLiteralText()) {
					try {
												
						Boolean __immediate = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._immediate.getExpressionString(), 
											Boolean.class);
					
												comp.setImmediate(__immediate.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("immediate", this._immediate);
				}
			}
					    		 			 
						if (this._localValueSet != null) {
				if (this._localValueSet.isLiteralText()) {
					try {
												
						Boolean __localValueSet = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._localValueSet.getExpressionString(), 
											Boolean.class);
					
												comp.setLocalValueSet(__localValueSet.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("localValueSet", this._localValueSet);
				}
			}
					   		 			 
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
					    		 			 
						if (this._required != null) {
				if (this._required.isLiteralText()) {
					try {
												
						Boolean __required = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._required.getExpressionString(), 
											Boolean.class);
					
												comp.setRequired(__required.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("required", this._required);
				}
			}
					   		 			 
						if (this._requiredMessage != null) {
				if (this._requiredMessage.isLiteralText()) {
					try {
												
						java.lang.String __requiredMessage = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._requiredMessage.getExpressionString(), 
											java.lang.String.class);
					
												comp.setRequiredMessage(__requiredMessage);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("requiredMessage", this._requiredMessage);
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
					   		 			 
						if (this._sendRequestToServer != null) {
				if (this._sendRequestToServer.isLiteralText()) {
					try {
												
						java.lang.Boolean __sendRequestToServer = (java.lang.Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._sendRequestToServer.getExpressionString(), 
											java.lang.Boolean.class);
					
												comp.setSendRequestToServer(__sendRequestToServer);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("sendRequestToServer", this._sendRequestToServer);
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
					   		 			 
						if (this._valid != null) {
				if (this._valid.isLiteralText()) {
					try {
												
						Boolean __valid = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._valid.getExpressionString(), 
											Boolean.class);
					
												comp.setValid(__valid.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("valid", this._valid);
				}
			}
					   		 			setValidatorProperty(comp, this._validator);
		   		 			 
						if (this._validatorMessage != null) {
				if (this._validatorMessage.isLiteralText()) {
					try {
												
						java.lang.String __validatorMessage = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._validatorMessage.getExpressionString(), 
											java.lang.String.class);
					
												comp.setValidatorMessage(__validatorMessage);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("validatorMessage", this._validatorMessage);
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
					   		 			setValueChangeListenerProperty(comp, this._valueChangeListener);
		    		 			 
						if (this._valueName != null) {
				if (this._valueName.isLiteralText()) {
					try {
												
						java.lang.Object __valueName = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._valueName.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setValueName(__valueName);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("valueName", this._valueName);
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
