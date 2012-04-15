/**
 * GENERATED FILE - DO NOT EDIT
 *
 */
package org.omidbiz.taglib;

import javax.faces.component.UIComponent ;
import javax.faces.convert.Converter ;
import java.lang.Object ;
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
import org.omidbiz.component.html.HtmlWindowPopup;

public class WindowPopupTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 	  			  		  	  
		/*
		 * accesskey
		 * This attribute assigns an access key to an element. An access key is a single character from the document character set. Note: Authors should consider the input method of the expected reader when specifying an accesskey
		 */
		private ValueExpression _accesskey;
		/**
		 * This attribute assigns an access key to an element. An access key is a single character from the document character set. Note: Authors should consider the input method of the expected reader when specifying an accesskey
		 * Setter for accesskey
		 * @param accesskey - new value
		 */
		 public void setAccesskey( ValueExpression  __accesskey ){
			this._accesskey = __accesskey;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * align
		 * Deprecated. This attribute specifies the horizontal alignment of its element with respect to the surrounding context. The  possible values are "left", "center", "right" and "justify".  
            The default depends on the base text direction. For left to right text, the default is align="left", while for right to left text, the default is align="right".
		 */
		private ValueExpression _align;
		/**
		 * Deprecated. This attribute specifies the horizontal alignment of its element with respect to the surrounding context. The  possible values are "left", "center", "right" and "justify".  
            The default depends on the base text direction. For left to right text, the default is align="left", while for right to left text, the default is align="right".
		 * Setter for align
		 * @param align - new value
		 */
		 public void setAlign( ValueExpression  __align ){
			this._align = __align;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * alt
		 * For a user agents that cannot display images, forms, or applets, this attribute specifies alternate text. The language of the alternate text is specified by the lang attribute
		 */
		private ValueExpression _alt;
		/**
		 * For a user agents that cannot display images, forms, or applets, this attribute specifies alternate text. The language of the alternate text is specified by the lang attribute
		 * Setter for alt
		 * @param alt - new value
		 */
		 public void setAlt( ValueExpression  __alt ){
			this._alt = __alt;
	     }
	  
	 	 		 	  	  	  
		/*
		 * atMin
		 * MethodExpression representing an action listener method
				that will be notified
		 */
		private MethodExpression _atMin;
		/**
		 * MethodExpression representing an action listener method
				that will be notified
		 * Setter for atMin
		 * @param atMin - new value
		 */
		 public void setAtMin( MethodExpression  __atMin ){
			this._atMin = __atMin;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * closeText
		 * 
		 */
		private ValueExpression _closeText;
		/**
		 * 
		 * Setter for closeText
		 * @param closeText - new value
		 */
		 public void setCloseText( ValueExpression  __closeText ){
			this._closeText = __closeText;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * converter
		 * Id of Converter to be used or reference to a Converter
		 */
		private ValueExpression _converter;
		/**
		 * Id of Converter to be used or reference to a Converter
		 * Setter for converter
		 * @param converter - new value
		 */
		 public void setConverter( ValueExpression  __converter ){
			this._converter = __converter;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * converterMessage
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the converter message,
			replacing any message that comes from the converter
		 */
		private ValueExpression _converterMessage;
		/**
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the converter message,
			replacing any message that comes from the converter
		 * Setter for converterMessage
		 * @param converterMessage - new value
		 */
		 public void setConverterMessage( ValueExpression  __converterMessage ){
			this._converterMessage = __converterMessage;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * disabled
		 * When set for a form control, this boolean attribute disables the control for your input
		 */
		private ValueExpression _disabled;
		/**
		 * When set for a form control, this boolean attribute disables the control for your input
		 * Setter for disabled
		 * @param disabled - new value
		 */
		 public void setDisabled( ValueExpression  __disabled ){
			this._disabled = __disabled;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * iframe
		 * 
		 */
		private ValueExpression _iframe;
		/**
		 * 
		 * Setter for iframe
		 * @param iframe - new value
		 */
		 public void setIframe( ValueExpression  __iframe ){
			this._iframe = __iframe;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * imageSrc
		 * 
		 */
		private ValueExpression _imageSrc;
		/**
		 * 
		 * Setter for imageSrc
		 * @param imageSrc - new value
		 */
		 public void setImageSrc( ValueExpression  __imageSrc ){
			this._imageSrc = __imageSrc;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * immediate
		 * A flag indicating that this component value must be converted
            and validated immediately (that is, during Apply Request Values
            phase), rather than waiting until a Process Validations phase
		 */
		private ValueExpression _immediate;
		/**
		 * A flag indicating that this component value must be converted
            and validated immediately (that is, during Apply Request Values
            phase), rather than waiting until a Process Validations phase
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
		 * maxlength
		 * Specifies the maximum number of digits that could be entered into the input field. 
		The maximum number is unlimited by default. 
		If entered value exceeds the value specified in "maxValue" attribute than the slider takes a maximum value position.
		 */
		private ValueExpression _maxlength;
		/**
		 * Specifies the maximum number of digits that could be entered into the input field. 
		The maximum number is unlimited by default. 
		If entered value exceeds the value specified in "maxValue" attribute than the slider takes a maximum value position.
		 * Setter for maxlength
		 * @param maxlength - new value
		 */
		 public void setMaxlength( ValueExpression  __maxlength ){
			this._maxlength = __maxlength;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onblur
		 * The client side script method to be called when the element loses the focus
		 */
		private ValueExpression _onblur;
		/**
		 * The client side script method to be called when the element loses the focus
		 * Setter for onblur
		 * @param onblur - new value
		 */
		 public void setOnblur( ValueExpression  __onblur ){
			this._onblur = __onblur;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onchange
		 * The client side script method to be called when the element value is changed
		 */
		private ValueExpression _onchange;
		/**
		 * The client side script method to be called when the element value is changed
		 * Setter for onchange
		 * @param onchange - new value
		 */
		 public void setOnchange( ValueExpression  __onchange ){
			this._onchange = __onchange;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * onfocus
		 * The client side script method to be called when the element gets the focus
		 */
		private ValueExpression _onfocus;
		/**
		 * The client side script method to be called when the element gets the focus
		 * Setter for onfocus
		 * @param onfocus - new value
		 */
		 public void setOnfocus( ValueExpression  __onfocus ){
			this._onfocus = __onfocus;
	     }
	  
	 	 		 		 		 		 		 		 		 		 		 	  			  		  	  
		/*
		 * onselect
		 * The client side script method to be called when some text is selected in the text field. This attribute can be used with the INPUT and TEXTAREA elements.
		 */
		private ValueExpression _onselect;
		/**
		 * The client side script method to be called when some text is selected in the text field. This attribute can be used with the INPUT and TEXTAREA elements.
		 * Setter for onselect
		 * @param onselect - new value
		 */
		 public void setOnselect( ValueExpression  __onselect ){
			this._onselect = __onselect;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * openText
		 * 
		 */
		private ValueExpression _openText;
		/**
		 * 
		 * Setter for openText
		 * @param openText - new value
		 */
		 public void setOpenText( ValueExpression  __openText ){
			this._openText = __openText;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * required
		 * If "true", this component is checked for non-empty input
		 */
		private ValueExpression _required;
		/**
		 * If "true", this component is checked for non-empty input
		 * Setter for required
		 * @param required - new value
		 */
		 public void setRequired( ValueExpression  __required ){
			this._required = __required;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * requiredMessage
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validation message for
			the "required" facility, if the "required" facility is
			used
		 */
		private ValueExpression _requiredMessage;
		/**
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validation message for
			the "required" facility, if the "required" facility is
			used
		 * Setter for requiredMessage
		 * @param requiredMessage - new value
		 */
		 public void setRequiredMessage( ValueExpression  __requiredMessage ){
			this._requiredMessage = __requiredMessage;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * size
		 * This attribute tells the user agent the initial width of the control. The width is given in pixels except when type attribute has the value "text" or "password". In that case, its value refers to the (integer) number of characters
		 */
		private ValueExpression _size;
		/**
		 * This attribute tells the user agent the initial width of the control. The width is given in pixels except when type attribute has the value "text" or "password". In that case, its value refers to the (integer) number of characters
		 * Setter for size
		 * @param size - new value
		 */
		 public void setSize( ValueExpression  __size ){
			this._size = __size;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * tabindex
		 * This attribute specifies the position of the current element in the tabbing order for the current document. This value must be a number between 0 and 32767. User agents should ignore leading zeros
		 */
		private ValueExpression _tabindex;
		/**
		 * This attribute specifies the position of the current element in the tabbing order for the current document. This value must be a number between 0 and 32767. User agents should ignore leading zeros
		 * Setter for tabindex
		 * @param tabindex - new value
		 */
		 public void setTabindex( ValueExpression  __tabindex ){
			this._tabindex = __tabindex;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * type
		 * 
		 */
		private ValueExpression _type;
		/**
		 * 
		 * Setter for type
		 * @param type - new value
		 */
		 public void setType( ValueExpression  __type ){
			this._type = __type;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * useImage
		 * 
		 */
		private ValueExpression _useImage;
		/**
		 * 
		 * Setter for useImage
		 * @param useImage - new value
		 */
		 public void setUseImage( ValueExpression  __useImage ){
			this._useImage = __useImage;
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
		 * MethodBinding pointing at a method that is called during
            Process Validations phase of the request processing lifecycle,
            to validate the current value of this component
		 */
		private MethodExpression _validator;
		/**
		 * MethodBinding pointing at a method that is called during
            Process Validations phase of the request processing lifecycle,
            to validate the current value of this component
		 * Setter for validator
		 * @param validator - new value
		 */
		 public void setValidator( MethodExpression  __validator ){
			this._validator = __validator;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * validatorMessage
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validator message,
			replacing any message that comes from the validator
		 */
		private ValueExpression _validatorMessage;
		/**
		 * A ValueExpression enabled attribute that, if present,
			will be used as the text of the validator message,
			replacing any message that comes from the validator
		 * Setter for validatorMessage
		 * @param validatorMessage - new value
		 */
		 public void setValidatorMessage( ValueExpression  __validatorMessage ){
			this._validatorMessage = __validatorMessage;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * value
		 * The current value of this component
		 */
		private ValueExpression _value;
		/**
		 * The current value of this component
		 * Setter for value
		 * @param value - new value
		 */
		 public void setValue( ValueExpression  __value ){
			this._value = __value;
	     }
	  
	 	 		 	  	  	  
		/*
		 * valueChangeListener
		 * Listener for value changes
		 */
		private MethodExpression _valueChangeListener;
		/**
		 * Listener for value changes
		 * Setter for valueChangeListener
		 * @param valueChangeListener - new value
		 */
		 public void setValueChangeListener( MethodExpression  __valueChangeListener ){
			this._valueChangeListener = __valueChangeListener;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * view
		 * 
		 */
		private ValueExpression _view;
		/**
		 * 
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
        		 		    this._accesskey = null;
	 		 		    this._align = null;
	 		 		    this._alt = null;
	 		 		    this._atMin = null;
	 		 		 		    this._closeText = null;
	 		 		    this._converter = null;
	 		 		    this._converterMessage = null;
	 		 		    this._disabled = null;
	 		 		 		 		    this._iframe = null;
	 		 		    this._imageSrc = null;
	 		 		    this._immediate = null;
	 		 		 		    this._localValueSet = null;
	 		 		    this._maxlength = null;
	 		 		    this._onblur = null;
	 		 		    this._onchange = null;
	 		 		 		 		    this._onfocus = null;
	 		 		 		 		 		 		 		 		 		 		    this._onselect = null;
	 		 		    this._openText = null;
	 		 		 		    this._required = null;
	 		 		    this._requiredMessage = null;
	 		 		    this._size = null;
	 		 		 		 		    this._tabindex = null;
	 		 		 		    this._type = null;
	 		 		    this._useImage = null;
	 		 		    this._valid = null;
	 		 		    this._validator = null;
	 		 		    this._validatorMessage = null;
	 		 		 		    this._value = null;
	 		 		    this._valueChangeListener = null;
	 		 		 		    this._view = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlWindowPopup comp = (HtmlWindowPopup) component;
 		 			 
						if (this._accesskey != null) {
				if (this._accesskey.isLiteralText()) {
					try {
												
						java.lang.String __accesskey = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._accesskey.getExpressionString(), 
											java.lang.String.class);
					
												comp.setAccesskey(__accesskey);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("accesskey", this._accesskey);
				}
			}
					   		 			 
						if (this._align != null) {
				if (this._align.isLiteralText()) {
					try {
												
						java.lang.String __align = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._align.getExpressionString(), 
											java.lang.String.class);
					
												comp.setAlign(__align);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("align", this._align);
				}
			}
					   		 			 
						if (this._alt != null) {
				if (this._alt.isLiteralText()) {
					try {
												
						java.lang.String __alt = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._alt.getExpressionString(), 
											java.lang.String.class);
					
												comp.setAlt(__alt);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("alt", this._alt);
				}
			}
					   		 			if(null != this._atMin){
             if (!this._atMin.isLiteralText())
             {
                MethodBinding mb = new MethodBindingMethodExpressionAdaptor(this._atMin);
                ((HtmlWindowPopup)component).setAtMin(mb);
             }
             else
             {
                getFacesContext().getExternalContext().log("Component " + component.getClientId(getFacesContext()) + " has invalid atMin value: " + this._atMin);
             }
			}
		    		 			 
						if (this._closeText != null) {
				if (this._closeText.isLiteralText()) {
					try {
												
						java.lang.String __closeText = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._closeText.getExpressionString(), 
											java.lang.String.class);
					
												comp.setCloseText(__closeText);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("closeText", this._closeText);
				}
			}
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
					   		 			 
						if (this._disabled != null) {
				if (this._disabled.isLiteralText()) {
					try {
												
						Boolean __disabled = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._disabled.getExpressionString(), 
											Boolean.class);
					
												comp.setDisabled(__disabled.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("disabled", this._disabled);
				}
			}
					     		 			 
						if (this._iframe != null) {
				if (this._iframe.isLiteralText()) {
					try {
												
						Boolean __iframe = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._iframe.getExpressionString(), 
											Boolean.class);
					
												comp.setIframe(__iframe.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("iframe", this._iframe);
				}
			}
					   		 			 
						if (this._imageSrc != null) {
				if (this._imageSrc.isLiteralText()) {
					try {
												
						java.lang.String __imageSrc = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._imageSrc.getExpressionString(), 
											java.lang.String.class);
					
												comp.setImageSrc(__imageSrc);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("imageSrc", this._imageSrc);
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
					   		 			 
						if (this._maxlength != null) {
				if (this._maxlength.isLiteralText()) {
					try {
												
						Integer __maxlength = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._maxlength.getExpressionString(), 
											Integer.class);
					
												comp.setMaxlength(__maxlength.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("maxlength", this._maxlength);
				}
			}
					   		 			 
						if (this._onblur != null) {
				if (this._onblur.isLiteralText()) {
					try {
												
						java.lang.String __onblur = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onblur.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnblur(__onblur);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onblur", this._onblur);
				}
			}
					   		 			 
						if (this._onchange != null) {
				if (this._onchange.isLiteralText()) {
					try {
												
						java.lang.String __onchange = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onchange.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnchange(__onchange);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onchange", this._onchange);
				}
			}
					     		 			 
						if (this._onfocus != null) {
				if (this._onfocus.isLiteralText()) {
					try {
												
						java.lang.String __onfocus = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onfocus.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnfocus(__onfocus);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onfocus", this._onfocus);
				}
			}
					           		 			 
						if (this._onselect != null) {
				if (this._onselect.isLiteralText()) {
					try {
												
						java.lang.String __onselect = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onselect.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnselect(__onselect);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onselect", this._onselect);
				}
			}
					   		 			 
						if (this._openText != null) {
				if (this._openText.isLiteralText()) {
					try {
												
						java.lang.String __openText = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._openText.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOpenText(__openText);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("openText", this._openText);
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
					   		 			 
						if (this._size != null) {
				if (this._size.isLiteralText()) {
					try {
												
						Integer __size = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._size.getExpressionString(), 
											Integer.class);
					
												comp.setSize(__size.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("size", this._size);
				}
			}
					     		 			 
						if (this._tabindex != null) {
				if (this._tabindex.isLiteralText()) {
					try {
												
						java.lang.String __tabindex = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._tabindex.getExpressionString(), 
											java.lang.String.class);
					
												comp.setTabindex(__tabindex);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("tabindex", this._tabindex);
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
					   		 			 
						if (this._useImage != null) {
				if (this._useImage.isLiteralText()) {
					try {
												
						Boolean __useImage = (Boolean) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._useImage.getExpressionString(), 
											Boolean.class);
					
												comp.setUseImage(__useImage.booleanValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("useImage", this._useImage);
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
		return "org.omidbiz.WindowPopup";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.WindowPopupRenderer";
			}

}
