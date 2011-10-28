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
import org.omidbiz.component.html.HtmlPager;

public class PagerTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 		 	  			  		  	  
		/*
		 * dataTableId
		 * 
		 */
		private ValueExpression _dataTableId;
		/**
		 * 
		 * Setter for dataTableId
		 * @param dataTableId - new value
		 */
		 public void setDataTableId( ValueExpression  __dataTableId ){
			this._dataTableId = __dataTableId;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * pages
		 * 
		 */
		private ValueExpression _pages;
		/**
		 * 
		 * Setter for pages
		 * @param pages - new value
		 */
		 public void setPages( ValueExpression  __pages ){
			this._pages = __pages;
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
        		 		 		    this._dataTableId = null;
	 		 		 		 		    this._pages = null;
	 		 		 		    this._view = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlPager comp = (HtmlPager) component;
  		 			 
						if (this._dataTableId != null) {
				if (this._dataTableId.isLiteralText()) {
					try {
												
						java.lang.String __dataTableId = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._dataTableId.getExpressionString(), 
											java.lang.String.class);
					
												comp.setDataTableId(__dataTableId);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("dataTableId", this._dataTableId);
				}
			}
					     		 			 
						if (this._pages != null) {
				if (this._pages.isLiteralText()) {
					try {
												
						Integer __pages = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._pages.getExpressionString(), 
											Integer.class);
					
												comp.setPages(__pages.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("pages", this._pages);
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
		return "org.omidbiz.Pager";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.PagerRenderer";
			}

}
