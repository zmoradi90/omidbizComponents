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
import org.omidbiz.component.html.HtmlTreeTable;

public class TreeTableTag extends org.ajax4jsf.webapp.taglib.HtmlComponentTagBase {

		// Fields
		 	  			  		  	  
		/*
		 * align
		 * Deprecated. This attribute specifies the position of the table with respect to the document. 
            The possible values are "left", "center" and "right". The default value is "left".
		 */
		private ValueExpression _align;
		/**
		 * Deprecated. This attribute specifies the position of the table with respect to the document. 
            The possible values are "left", "center" and "right". The default value is "left".
		 * Setter for align
		 * @param align - new value
		 */
		 public void setAlign( ValueExpression  __align ){
			this._align = __align;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * bgcolor
		 * Deprecated. This attribute sets the background color for the document body or table cells.
            
            This attribute sets the background color of the canvas for the document body (the BODY element) or for tables (the TABLE, TR, TH, and TD elements). Additional attributes for specifying text color can be used with the BODY element.
            
            This attribute has been deprecated in favor of style sheets for specifying background color information
		 */
		private ValueExpression _bgcolor;
		/**
		 * Deprecated. This attribute sets the background color for the document body or table cells.
            
            This attribute sets the background color of the canvas for the document body (the BODY element) or for tables (the TABLE, TR, TH, and TD elements). Additional attributes for specifying text color can be used with the BODY element.
            
            This attribute has been deprecated in favor of style sheets for specifying background color information
		 * Setter for bgcolor
		 * @param bgcolor - new value
		 */
		 public void setBgcolor( ValueExpression  __bgcolor ){
			this._bgcolor = __bgcolor;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * border
		 * This attributes specifies the width (in pixels only) of the frame around a table
		 */
		private ValueExpression _border;
		/**
		 * This attributes specifies the width (in pixels only) of the frame around a table
		 * Setter for border
		 * @param border - new value
		 */
		 public void setBorder( ValueExpression  __border ){
			this._border = __border;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * cellpadding
		 * This attribute specifies the amount of space between the border of the cell and its contents. If the value of this attribute is a pixel length, all four margins should be this distance from the contents. If the value of the attribute is percentage length, the top and bottom margins should be equally separated from the content based on percentage of the available vertical space, and the left and right margins should be equally separated from the content based on percentage of the available horizontal space
		 */
		private ValueExpression _cellpadding;
		/**
		 * This attribute specifies the amount of space between the border of the cell and its contents. If the value of this attribute is a pixel length, all four margins should be this distance from the contents. If the value of the attribute is percentage length, the top and bottom margins should be equally separated from the content based on percentage of the available vertical space, and the left and right margins should be equally separated from the content based on percentage of the available horizontal space
		 * Setter for cellpadding
		 * @param cellpadding - new value
		 */
		 public void setCellpadding( ValueExpression  __cellpadding ){
			this._cellpadding = __cellpadding;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * cellspacing
		 * This attribute specifies how much space the user agent should leave between the left side of the table and the left-hand side of the leftmost column, the top of the table and the top side of the topmost row, and so on for the right and bottom of the table. The attribute also specifies the amount of space to leave between cells
		 */
		private ValueExpression _cellspacing;
		/**
		 * This attribute specifies how much space the user agent should leave between the left side of the table and the left-hand side of the leftmost column, the top of the table and the top side of the topmost row, and so on for the right and bottom of the table. The attribute also specifies the amount of space to leave between cells
		 * Setter for cellspacing
		 * @param cellspacing - new value
		 */
		 public void setCellspacing( ValueExpression  __cellspacing ){
			this._cellspacing = __cellspacing;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * columnClasses
		 * Comma-delimited list of CSS style classes that are be applied to the columns of this table. A space separated list of classes may also be specified for any individual column. If the number of elements in this list is less than the number of columns specified in the "columns" attribute, no "class" attribute is output for each column greater than the number of elements in the list. If the number of elements in the list is greater than the number of columns specified in the "columns" attribute, the elements at the position in the list after the value of the "columns" attribute are ignored
		 */
		private ValueExpression _columnClasses;
		/**
		 * Comma-delimited list of CSS style classes that are be applied to the columns of this table. A space separated list of classes may also be specified for any individual column. If the number of elements in this list is less than the number of columns specified in the "columns" attribute, no "class" attribute is output for each column greater than the number of elements in the list. If the number of elements in the list is greater than the number of columns specified in the "columns" attribute, the elements at the position in the list after the value of the "columns" attribute are ignored
		 * Setter for columnClasses
		 * @param columnClasses - new value
		 */
		 public void setColumnClasses( ValueExpression  __columnClasses ){
			this._columnClasses = __columnClasses;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * first
		 * A zero-relative row number of the first row to display
		 */
		private ValueExpression _first;
		/**
		 * A zero-relative row number of the first row to display
		 * Setter for first
		 * @param first - new value
		 */
		 public void setFirst( ValueExpression  __first ){
			this._first = __first;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * footerClass
		 * Space-separated list of CSS style class(es) that are be applied to any footer generated for this table
		 */
		private ValueExpression _footerClass;
		/**
		 * Space-separated list of CSS style class(es) that are be applied to any footer generated for this table
		 * Setter for footerClass
		 * @param footerClass - new value
		 */
		 public void setFooterClass( ValueExpression  __footerClass ){
			this._footerClass = __footerClass;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * frame
		 * This attribute specifies which sides of the frame surrounding a table will be visible. Possible values:  "void", "above", "below", "hsides", "lhs", "rhs", "vsides", "box" and "border".
        The default value is "void".
		 */
		private ValueExpression _frame;
		/**
		 * This attribute specifies which sides of the frame surrounding a table will be visible. Possible values:  "void", "above", "below", "hsides", "lhs", "rhs", "vsides", "box" and "border".
        The default value is "void".
		 * Setter for frame
		 * @param frame - new value
		 */
		 public void setFrame( ValueExpression  __frame ){
			this._frame = __frame;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * headerClass
		 * Space-separated list of CSS style class(es) that are be applied to any header generated for this table
		 */
		private ValueExpression _headerClass;
		/**
		 * Space-separated list of CSS style class(es) that are be applied to any header generated for this table
		 * Setter for headerClass
		 * @param headerClass - new value
		 */
		 public void setHeaderClass( ValueExpression  __headerClass ){
			this._headerClass = __headerClass;
	     }
	  
	 	 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 	  			  		  	  
		/*
		 * rowClasses
		 * A comma-delimited list of CSS style classes that is applied to popup table rows. A space separated list of classes may also be specified for any individual row. The styles are applied, in turn, to each row in the table. For example, if the list has two elements, the first style class in the list is applied to the first row, the second to the second row, the first to the third row, the second to the fourth row, etc. In other words, we keep iterating through the list until we reach the end, and then we start at the beginning again
		 */
		private ValueExpression _rowClasses;
		/**
		 * A comma-delimited list of CSS style classes that is applied to popup table rows. A space separated list of classes may also be specified for any individual row. The styles are applied, in turn, to each row in the table. For example, if the list has two elements, the first style class in the list is applied to the first row, the second to the second row, the first to the third row, the second to the fourth row, etc. In other words, we keep iterating through the list until we reach the end, and then we start at the beginning again
		 * Setter for rowClasses
		 * @param rowClasses - new value
		 */
		 public void setRowClasses( ValueExpression  __rowClasses ){
			this._rowClasses = __rowClasses;
	     }
	  
	 	 		 		 		 		 	  			  		  	  
		/*
		 * rows
		 * A number of rows to display, or zero for all remaining
            rows in the table
		 */
		private ValueExpression _rows;
		/**
		 * A number of rows to display, or zero for all remaining
            rows in the table
		 * Setter for rows
		 * @param rows - new value
		 */
		 public void setRows( ValueExpression  __rows ){
			this._rows = __rows;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * rules
		 * This attribute specifies which rules will appear between cells within a table. The rendering of rules is user agent dependent. Possible values:
            
            * none: No rules. This is the default value.
            * groups: Rules will appear between row groups (see THEAD, TFOOT, and TBODY) and column groups (see COLGROUP and COL) only.
            * rows: Rules will appear between rows only.
            * cols: Rules will appear between columns only.
            * all: Rules will appear between all rows and columns
		 */
		private ValueExpression _rules;
		/**
		 * This attribute specifies which rules will appear between cells within a table. The rendering of rules is user agent dependent. Possible values:
            
            * none: No rules. This is the default value.
            * groups: Rules will appear between row groups (see THEAD, TFOOT, and TBODY) and column groups (see COLGROUP and COL) only.
            * rows: Rules will appear between rows only.
            * cols: Rules will appear between columns only.
            * all: Rules will appear between all rows and columns
		 * Setter for rules
		 * @param rules - new value
		 */
		 public void setRules( ValueExpression  __rules ){
			this._rules = __rules;
	     }
	  
	 	 		 		 		 	  			  		  	  
		/*
		 * summary
		 * This attribute provides a summary of the table's purpose and structure for user agents rendering to non-visual media such as speech and Braille
		 */
		private ValueExpression _summary;
		/**
		 * This attribute provides a summary of the table's purpose and structure for user agents rendering to non-visual media such as speech and Braille
		 * Setter for summary
		 * @param summary - new value
		 */
		 public void setSummary( ValueExpression  __summary ){
			this._summary = __summary;
	     }
	  
	 	 		 		 	  			  		  	  
		/*
		 * value
		 * The current value for this component
		 */
		private ValueExpression _value;
		/**
		 * The current value for this component
		 * Setter for value
		 * @param value - new value
		 */
		 public void setValue( ValueExpression  __value ){
			this._value = __value;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * var
		 * A request-scope attribute via which the data object for the
            current row will be used when iterating
		 */
		private String _var;
		/**
		 * A request-scope attribute via which the data object for the
            current row will be used when iterating
		 * Setter for var
		 * @param var - new value
		 */
		 public void setVar( String  __var ){
			this._var = __var;
	     }
	  
	 	 		 	  			  		  	  
		/*
		 * width
		 * This attribute specifies the desired width of the entire table and is intended for visual user agents. When the value is percentage value, the value is relative to the user agent's available horizontal space. In the absence of any width specification, table width is determined by the user agent
		 */
		private ValueExpression _width;
		/**
		 * This attribute specifies the desired width of the entire table and is intended for visual user agents. When the value is percentage value, the value is relative to the user agent's available horizontal space. In the absence of any width specification, table width is determined by the user agent
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
        		 		    this._align = null;
	 		 		    this._bgcolor = null;
	 		 		 		    this._border = null;
	 		 		    this._cellpadding = null;
	 		 		    this._cellspacing = null;
	 		 		    this._columnClasses = null;
	 		 		 		 		    this._first = null;
	 		 		 		    this._footerClass = null;
	 		 		    this._frame = null;
	 		 		 		    this._headerClass = null;
	 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		 		    this._rowClasses = null;
	 		 		 		 		 		    this._rows = null;
	 		 		    this._rules = null;
	 		 		 		 		    this._summary = null;
	 		 		 		    this._value = null;
	 		 		    this._var = null;
	 		 		    this._width = null;
	 		}
	
    /* (non-Javadoc)
     * @see org.ajax4jsf.components.taglib.html.HtmlCommandButtonTagBase#setProperties(javax.faces.component.UIComponent)
     */
    protected void setProperties(UIComponent component)
    {
        // TODO Auto-generated method stub
        super.setProperties(component);
		HtmlTreeTable comp = (HtmlTreeTable) component;
 		 			 
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
					   		 			 
						if (this._bgcolor != null) {
				if (this._bgcolor.isLiteralText()) {
					try {
												
						java.lang.String __bgcolor = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._bgcolor.getExpressionString(), 
											java.lang.String.class);
					
												comp.setBgcolor(__bgcolor);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("bgcolor", this._bgcolor);
				}
			}
					    		 			 
						if (this._border != null) {
				if (this._border.isLiteralText()) {
					try {
												
						java.lang.String __border = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._border.getExpressionString(), 
											java.lang.String.class);
					
												comp.setBorder(__border);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("border", this._border);
				}
			}
					   		 			 
						if (this._cellpadding != null) {
				if (this._cellpadding.isLiteralText()) {
					try {
												
						java.lang.String __cellpadding = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._cellpadding.getExpressionString(), 
											java.lang.String.class);
					
												comp.setCellpadding(__cellpadding);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("cellpadding", this._cellpadding);
				}
			}
					   		 			 
						if (this._cellspacing != null) {
				if (this._cellspacing.isLiteralText()) {
					try {
												
						java.lang.String __cellspacing = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._cellspacing.getExpressionString(), 
											java.lang.String.class);
					
												comp.setCellspacing(__cellspacing);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("cellspacing", this._cellspacing);
				}
			}
					   		 			 
						if (this._columnClasses != null) {
				if (this._columnClasses.isLiteralText()) {
					try {
												
						java.lang.String __columnClasses = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._columnClasses.getExpressionString(), 
											java.lang.String.class);
					
												comp.setColumnClasses(__columnClasses);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("columnClasses", this._columnClasses);
				}
			}
					     		 			 
						if (this._first != null) {
				if (this._first.isLiteralText()) {
					try {
												
						Integer __first = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._first.getExpressionString(), 
											Integer.class);
					
												comp.setFirst(__first.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("first", this._first);
				}
			}
					    		 			 
						if (this._footerClass != null) {
				if (this._footerClass.isLiteralText()) {
					try {
												
						java.lang.String __footerClass = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._footerClass.getExpressionString(), 
											java.lang.String.class);
					
												comp.setFooterClass(__footerClass);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("footerClass", this._footerClass);
				}
			}
					   		 			 
						if (this._frame != null) {
				if (this._frame.isLiteralText()) {
					try {
												
						java.lang.String __frame = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._frame.getExpressionString(), 
											java.lang.String.class);
					
												comp.setFrame(__frame);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("frame", this._frame);
				}
			}
					    		 			 
						if (this._headerClass != null) {
				if (this._headerClass.isLiteralText()) {
					try {
												
						java.lang.String __headerClass = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._headerClass.getExpressionString(), 
											java.lang.String.class);
					
												comp.setHeaderClass(__headerClass);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("headerClass", this._headerClass);
				}
			}
					                 		 			 
						if (this._rowClasses != null) {
				if (this._rowClasses.isLiteralText()) {
					try {
												
						java.lang.String __rowClasses = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._rowClasses.getExpressionString(), 
											java.lang.String.class);
					
												comp.setRowClasses(__rowClasses);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("rowClasses", this._rowClasses);
				}
			}
					      		 			 
						if (this._rows != null) {
				if (this._rows.isLiteralText()) {
					try {
												
						Integer __rows = (Integer) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._rows.getExpressionString(), 
											Integer.class);
					
												comp.setRows(__rows.intValue());
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("rows", this._rows);
				}
			}
					   		 			 
						if (this._rules != null) {
				if (this._rules.isLiteralText()) {
					try {
												
						java.lang.String __rules = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._rules.getExpressionString(), 
											java.lang.String.class);
					
												comp.setRules(__rules);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("rules", this._rules);
				}
			}
					     		 			 
						if (this._summary != null) {
				if (this._summary.isLiteralText()) {
					try {
												
						java.lang.String __summary = (java.lang.String) getFacesContext().
							getApplication().
								getExpressionFactory().
									coerceToType(this._summary.getExpressionString(), 
											java.lang.String.class);
					
												comp.setSummary(__summary);
											} catch (ELException e) {
						throw new FacesException(e);
					}
				} else {
					component.setValueExpression("summary", this._summary);
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
					   		 			 
											if (this._var != null) {
					comp.setVar(this._var);
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
		return "org.omidbiz.TreeTable";
	}

	/* (non-Javadoc)
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
				return "org.omidbiz.TreeTableRenderer";
			}

}
