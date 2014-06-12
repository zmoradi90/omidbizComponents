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
		 * autocompleteUrl
		 * 
		 */
		private ValueExpression _autocompleteUrl;
		/**
		 * 
		 * Setter for autocompleteUrl
		 * @param autocompleteUrl - new value
		 */
		 public void setAutocompleteUrl( ValueExpression  __autocompleteUrl ){
			this._autocompleteUrl = __autocompleteUrl;
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
		 * height
		 * 
		 */
		private ValueExpression _height;
		/**
		 * 
		 * Setter for height
		 * @param height - new value
		 */
		 public void setHeight( ValueExpression  __height ){
			this._height = __height;
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
		 * nameValue
		 * nameValue
		 */
		private ValueExpression _nameValue;
		/**
		 * nameValue
		 * Setter for nameValue
		 * @param nameValue - new value
		 */
		 public void setNameValue( ValueExpression  __nameValue ){
			this._nameValue = __nameValue;
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
		 * onCleanup
		 * 
		 */
		private ValueExpression _onCleanup;
		/**
		 * 
		 * Setter for onCleanup
		 * @param onCleanup - new value
		 */
		 public void setOnCleanup( ValueExpression  __onCleanup ){
			this._onCleanup = __onCleanup;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onClosed
		 * 
		 */
		private ValueExpression _onClosed;
		/**
		 * 
		 * Setter for onClosed
		 * @param onClosed - new value
		 */
		 public void setOnClosed( ValueExpression  __onClosed ){
			this._onClosed = __onClosed;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onComplete
		 * 
		 */
		private ValueExpression _onComplete;
		/**
		 * 
		 * Setter for onComplete
		 * @param onComplete - new value
		 */
		 public void setOnComplete( ValueExpression  __onComplete ){
			this._onComplete = __onComplete;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onLoad
		 * 
		 */
		private ValueExpression _onLoad;
		/**
		 * 
		 * Setter for onLoad
		 * @param onLoad - new value
		 */
		 public void setOnLoad( ValueExpression  __onLoad ){
			this._onLoad = __onLoad;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * onOpen
		 * 
		 */
		private ValueExpression _onOpen;
		/**
		 * 
		 * Setter for onOpen
		 * @param onOpen - new value
		 */
		 public void setOnOpen( ValueExpression  __onOpen ){
			this._onOpen = __onOpen;
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
		 * valueId
		 * The value Id of the component show in hidden
		 */
		private ValueExpression _valueId;
		/**
		 * The value Id of the component show in hidden
		 * Setter for valueId
		 * @param valueId - new value
		 */
		 public void setValueId( ValueExpression  __valueId ){
			this._valueId = __valueId;
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
	  
	 	 		 	  			  		  	  
		/*
		 * width
		 * 
		 */
		private ValueExpression _width;
		/**
		 * 
		 * Setter for width
		 * @param width - new value
		 */
		 public void setWidth( ValueExpression  __width ){
			this._width = __width;
	     }
	  
	 	 	
	
    public void release()
    {
        // TODO Auto-generated method stub
        super.release();
        		 		    this._accesskey = null;
	 		 		    this._align = null;
	 		 		    this._alt = null;
	 		 		    this._autocompleteUrl = null;
	 		 		 		    this._converter = null;
	 		 		    this._converterMessage = null;
	 		 		    this._disabled = null;
	 		 		 		    this._height = null;
	 		 		 		    this._iframe = null;
	 		 		    this._immediate = null;
	 		 		 		    this._localValueSet = null;
	 		 		    this._maxlength = null;
	 		 		    this._nameValue = null;
	 		 		    this._objectName = null;
	 		 		    this._onCleanup = null;
	 		 		    this._onClosed = null;
	 		 		    this._onComplete = null;
	 		 		    this._onLoad = null;
	 		 		    this._onOpen = null;
	 		 		    this._onblur = null;
	 		 		    this._onchange = null;
	 		 		 		 		    this._onfocus = null;
	 		 		 		 		 		 		 		 		 		 		    this._onselect = null;
	 		 		    this._pValueText = null;
	 		 		    this._pid = null;
	 		 		 		    this._required = null;
	 		 		    this._requiredMessage = null;
	 		 		    this._selectedText = null;
	 		 		    this._sendRequestToServer = null;
	 		 		    this._size = null;
	 		 		 		 		    this._tabindex = null;
	 		 		 		    this._type = null;
	 		 		    this._valid = null;
	 		 		    this._validator = null;
	 		 		    this._validatorMessage = null;
	 		 		 		    this._value = null;
	 		 		    this._valueChangeListener = null;
	 		 		 		    this._valueId = null;
	 		 		    this._valueName = null;
	 		 		    this._view = null;
	 		 		    this._width = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlInputListOfValues comp = (HtmlInputListOfValues) component;
 		 			 
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
					   		 			 
						if (this._autocompleteUrl != null) {
				if (this._autocompleteUrl.isLiteralText()) {
					try {
												
						java.lang.String __autocompleteUrl = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._autocompleteUrl.getExpressionString(), 
											java.lang.String.class);
					
												comp.setAutocompleteUrl(__autocompleteUrl);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("autocompleteUrl", this._autocompleteUrl);
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
					    		 			 
						if (this._height != null) {
				if (this._height.isLiteralText()) {
					try {
												
						java.lang.String __height = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._height.getExpressionString(), 
											java.lang.String.class);
					
												comp.setHeight(__height);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("height", this._height);
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
					   		 			 
						if (this._nameValue != null) {
				if (this._nameValue.isLiteralText()) {
					try {
												
						java.lang.Object __nameValue = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._nameValue.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setNameValue(__nameValue);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("nameValue", this._nameValue);
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
					   		 			 
						if (this._onCleanup != null) {
				if (this._onCleanup.isLiteralText()) {
					try {
												
						java.lang.String __onCleanup = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onCleanup.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnCleanup(__onCleanup);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onCleanup", this._onCleanup);
				}
			}
					   		 			 
						if (this._onClosed != null) {
				if (this._onClosed.isLiteralText()) {
					try {
												
						java.lang.String __onClosed = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onClosed.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnClosed(__onClosed);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onClosed", this._onClosed);
				}
			}
					   		 			 
						if (this._onComplete != null) {
				if (this._onComplete.isLiteralText()) {
					try {
												
						java.lang.String __onComplete = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onComplete.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnComplete(__onComplete);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onComplete", this._onComplete);
				}
			}
					   		 			 
						if (this._onLoad != null) {
				if (this._onLoad.isLiteralText()) {
					try {
												
						java.lang.String __onLoad = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onLoad.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnLoad(__onLoad);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onLoad", this._onLoad);
				}
			}
					   		 			 
						if (this._onOpen != null) {
				if (this._onOpen.isLiteralText()) {
					try {
												
						java.lang.String __onOpen = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._onOpen.getExpressionString(), 
											java.lang.String.class);
					
												comp.setOnOpen(__onOpen);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("onOpen", this._onOpen);
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
		    		 			 
						if (this._valueId != null) {
				if (this._valueId.isLiteralText()) {
					try {
												
						java.lang.Object __valueId = (java.lang.Object) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._valueId.getExpressionString(), 
											java.lang.Object.class);
					
												comp.setValueId(__valueId);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("valueId", this._valueId);
				}
			}
					   		 			 
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
					   		 			 
						if (this._width != null) {
				if (this._width.isLiteralText()) {
					try {
												
						java.lang.String __width = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._width.getExpressionString(), 
											java.lang.String.class);
					
												comp.setWidth(__width);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("width", this._width);
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
