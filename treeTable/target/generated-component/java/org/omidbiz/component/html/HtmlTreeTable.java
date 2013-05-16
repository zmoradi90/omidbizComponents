package org.omidbiz.component.html;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.omidbiz.component.UITreeTable;

public class HtmlTreeTable extends UITreeTable{

static final public  String COMPONENT_FAMILY = "org.omidbiz.TreeTable";

static final public  String COMPONENT_TYPE = "org.omidbiz.TreeTable";

/*
* Deprecated. This attribute specifies the position of the table with respect to the document. 
            The possible values are "left", "center" and "right". The default value is "left".
*/
private  String _align = null;

/*
* Deprecated. This attribute sets the background color for the document body or table cells.
            
            This attribute sets the background color of the canvas for the document body (the BODY element) or for tables (the TABLE, TR, TH, and TD elements). Additional attributes for specifying text color can be used with the BODY element.
            
            This attribute has been deprecated in favor of style sheets for specifying background color information
*/
private  String _bgcolor = null;

/*
* This attributes specifies the width (in pixels only) of the frame around a table
*/
private  String _border = null;

/*
* This attribute specifies the amount of space between the border of the cell and its contents. If the value of this attribute is a pixel length, all four margins should be this distance from the contents. If the value of the attribute is percentage length, the top and bottom margins should be equally separated from the content based on percentage of the available vertical space, and the left and right margins should be equally separated from the content based on percentage of the available horizontal space
*/
private  String _cellpadding = null;

/*
* This attribute specifies how much space the user agent should leave between the left side of the table and the left-hand side of the leftmost column, the top of the table and the top side of the topmost row, and so on for the right and bottom of the table. The attribute also specifies the amount of space to leave between cells
*/
private  String _cellspacing = null;

/*
* Comma-delimited list of CSS style classes that are be applied to the columns of this table. A space separated list of classes may also be specified for any individual column. If the number of elements in this list is less than the number of columns specified in the "columns" attribute, no "class" attribute is output for each column greater than the number of elements in the list. If the number of elements in the list is greater than the number of columns specified in the "columns" attribute, the elements at the position in the list after the value of the "columns" attribute are ignored
*/
private  String _columnClasses = null;

/*
* Direction indication for text that does not inherit
			directionality. Valid values are "LTR" (left-to-right)
			and "RTL" (right-to-left)
*/
private  String _dir = null;

/*
* Space-separated list of CSS style class(es) that are be applied to any footer generated for this table
*/
private  String _footerClass = null;

/*
* This attribute specifies which sides of the frame surrounding a table will be visible. Possible values:  "void", "above", "below", "hsides", "lhs", "rhs", "vsides", "box" and "border".
        The default value is "void".
*/
private  String _frame = null;

/*
* Space-separated list of CSS style class(es) that are be applied to any header generated for this table
*/
private  String _headerClass = null;

/*
* Code describing the language used in the generated markup for this component
*/
private  String _lang = null;

/*
* The clientside script method to be called when the element is clicked
*/
private  String _onclick = null;

/*
* The client side script method to be called when the element is double-clicked
*/
private  String _ondblclick = null;

/*
* The client side script method to be called when a key is pressed down over the element
*/
private  String _onkeydown = null;

/*
* The client side script method to be called when a key is pressed over the element and released
*/
private  String _onkeypress = null;

/*
* The client side script method to be called when a key is released
*/
private  String _onkeyup = null;

/*
* The client side script method to be called when a mouse button is pressed down over the element
*/
private  String _onmousedown = null;

/*
* The client side script method to be called when a pointer is moved within the element
*/
private  String _onmousemove = null;

/*
* The client side script method to be called when a pointer is moved away from the element
*/
private  String _onmouseout = null;

/*
* The client side script method to be called when a pointer is moved onto the element
*/
private  String _onmouseover = null;

/*
* The client side script method to be called when a mouse button is released
*/
private  String _onmouseup = null;

/*
* A comma-delimited list of CSS style classes that is applied to popup table rows. A space separated list of classes may also be specified for any individual row. The styles are applied, in turn, to each row in the table. For example, if the list has two elements, the first style class in the list is applied to the first row, the second to the second row, the first to the third row, the second to the fourth row, etc. In other words, we keep iterating through the list until we reach the end, and then we start at the beginning again
*/
private  String _rowClasses = null;

/*
* This attribute specifies which rules will appear between cells within a table. The rendering of rules is user agent dependent. Possible values:
            
            * none: No rules. This is the default value.
            * groups: Rules will appear between row groups (see THEAD, TFOOT, and TBODY) and column groups (see COLGROUP and COL) only.
            * rows: Rules will appear between rows only.
            * cols: Rules will appear between columns only.
            * all: Rules will appear between all rows and columns
*/
private  String _rules = null;

/*
* CSS style(s) is/are to be applied when this component is rendered
*/
private  String _style = null;

/*
* Corresponds to the HTML class attribute
*/
private  String _styleClass = null;

/*
* This attribute provides a summary of the table's purpose and structure for user agents rendering to non-visual media such as speech and Braille
*/
private  String _summary = null;

/*
* Advisory title information about markup elements generated for this component
*/
private  String _title = null;

/*
* This attribute specifies the desired width of the entire table and is intended for visual user agents. When the value is percentage value, the value is relative to the user agent's available horizontal space. In the absence of any width specification, table width is determined by the user agent
*/
private  String _width = null;


public HtmlTreeTable(){
setRendererType("org.omidbiz.TreeTableRenderer");
}

public String getAlign(){
	if (this._align != null) {
		return this._align;
	}
	ValueExpression ve = getValueExpression("align");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setAlign(String _align){
this._align = _align;
}

public String getBgcolor(){
	if (this._bgcolor != null) {
		return this._bgcolor;
	}
	ValueExpression ve = getValueExpression("bgcolor");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setBgcolor(String _bgcolor){
this._bgcolor = _bgcolor;
}

public String getBorder(){
	if (this._border != null) {
		return this._border;
	}
	ValueExpression ve = getValueExpression("border");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setBorder(String _border){
this._border = _border;
}

public String getCellpadding(){
	if (this._cellpadding != null) {
		return this._cellpadding;
	}
	ValueExpression ve = getValueExpression("cellpadding");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setCellpadding(String _cellpadding){
this._cellpadding = _cellpadding;
}

public String getCellspacing(){
	if (this._cellspacing != null) {
		return this._cellspacing;
	}
	ValueExpression ve = getValueExpression("cellspacing");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setCellspacing(String _cellspacing){
this._cellspacing = _cellspacing;
}

public String getColumnClasses(){
	if (this._columnClasses != null) {
		return this._columnClasses;
	}
	ValueExpression ve = getValueExpression("columnClasses");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setColumnClasses(String _columnClasses){
this._columnClasses = _columnClasses;
}

public String getDir(){
	if (this._dir != null) {
		return this._dir;
	}
	ValueExpression ve = getValueExpression("dir");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setDir(String _dir){
this._dir = _dir;
}

public String getFooterClass(){
	if (this._footerClass != null) {
		return this._footerClass;
	}
	ValueExpression ve = getValueExpression("footerClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setFooterClass(String _footerClass){
this._footerClass = _footerClass;
}

public String getFrame(){
	if (this._frame != null) {
		return this._frame;
	}
	ValueExpression ve = getValueExpression("frame");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setFrame(String _frame){
this._frame = _frame;
}

public String getHeaderClass(){
	if (this._headerClass != null) {
		return this._headerClass;
	}
	ValueExpression ve = getValueExpression("headerClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setHeaderClass(String _headerClass){
this._headerClass = _headerClass;
}

public String getLang(){
	if (this._lang != null) {
		return this._lang;
	}
	ValueExpression ve = getValueExpression("lang");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setLang(String _lang){
this._lang = _lang;
}

public String getOnclick(){
	if (this._onclick != null) {
		return this._onclick;
	}
	ValueExpression ve = getValueExpression("onclick");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnclick(String _onclick){
this._onclick = _onclick;
}

public String getOndblclick(){
	if (this._ondblclick != null) {
		return this._ondblclick;
	}
	ValueExpression ve = getValueExpression("ondblclick");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOndblclick(String _ondblclick){
this._ondblclick = _ondblclick;
}

public String getOnkeydown(){
	if (this._onkeydown != null) {
		return this._onkeydown;
	}
	ValueExpression ve = getValueExpression("onkeydown");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnkeydown(String _onkeydown){
this._onkeydown = _onkeydown;
}

public String getOnkeypress(){
	if (this._onkeypress != null) {
		return this._onkeypress;
	}
	ValueExpression ve = getValueExpression("onkeypress");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnkeypress(String _onkeypress){
this._onkeypress = _onkeypress;
}

public String getOnkeyup(){
	if (this._onkeyup != null) {
		return this._onkeyup;
	}
	ValueExpression ve = getValueExpression("onkeyup");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnkeyup(String _onkeyup){
this._onkeyup = _onkeyup;
}

public String getOnmousedown(){
	if (this._onmousedown != null) {
		return this._onmousedown;
	}
	ValueExpression ve = getValueExpression("onmousedown");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnmousedown(String _onmousedown){
this._onmousedown = _onmousedown;
}

public String getOnmousemove(){
	if (this._onmousemove != null) {
		return this._onmousemove;
	}
	ValueExpression ve = getValueExpression("onmousemove");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnmousemove(String _onmousemove){
this._onmousemove = _onmousemove;
}

public String getOnmouseout(){
	if (this._onmouseout != null) {
		return this._onmouseout;
	}
	ValueExpression ve = getValueExpression("onmouseout");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnmouseout(String _onmouseout){
this._onmouseout = _onmouseout;
}

public String getOnmouseover(){
	if (this._onmouseover != null) {
		return this._onmouseover;
	}
	ValueExpression ve = getValueExpression("onmouseover");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnmouseover(String _onmouseover){
this._onmouseover = _onmouseover;
}

public String getOnmouseup(){
	if (this._onmouseup != null) {
		return this._onmouseup;
	}
	ValueExpression ve = getValueExpression("onmouseup");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setOnmouseup(String _onmouseup){
this._onmouseup = _onmouseup;
}

public String getRowClasses(){
	if (this._rowClasses != null) {
		return this._rowClasses;
	}
	ValueExpression ve = getValueExpression("rowClasses");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setRowClasses(String _rowClasses){
this._rowClasses = _rowClasses;
}

public String getRules(){
	if (this._rules != null) {
		return this._rules;
	}
	ValueExpression ve = getValueExpression("rules");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setRules(String _rules){
this._rules = _rules;
}

public String getStyle(){
	if (this._style != null) {
		return this._style;
	}
	ValueExpression ve = getValueExpression("style");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setStyle(String _style){
this._style = _style;
}

public String getStyleClass(){
	if (this._styleClass != null) {
		return this._styleClass;
	}
	ValueExpression ve = getValueExpression("styleClass");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setStyleClass(String _styleClass){
this._styleClass = _styleClass;
}

public String getSummary(){
	if (this._summary != null) {
		return this._summary;
	}
	ValueExpression ve = getValueExpression("summary");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setSummary(String _summary){
this._summary = _summary;
}

public String getTitle(){
	if (this._title != null) {
		return this._title;
	}
	ValueExpression ve = getValueExpression("title");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setTitle(String _title){
this._title = _title;
}

public String getWidth(){
	if (this._width != null) {
		return this._width;
	}
	ValueExpression ve = getValueExpression("width");
	if (ve != null) {
	    String value = null;
	    
	    try {
			value = (String) ve.getValue(getFacesContext().getELContext());
	    } catch (ELException e) {
			throw new FacesException(e);
	    }
	    
	    return value;
	} 

    return null;
	

}

public void setWidth(String _width){
this._width = _width;
}

public String getFamily(){
return COMPONENT_FAMILY;
}

@Override
public Object saveState(FacesContext context){
Object [] state = new Object[29];
state[0] = super.saveState(context);
state[1] = _align;
state[2] = _bgcolor;
state[3] = _border;
state[4] = _cellpadding;
state[5] = _cellspacing;
state[6] = _columnClasses;
state[7] = _dir;
state[8] = _footerClass;
state[9] = _frame;
state[10] = _headerClass;
state[11] = _lang;
state[12] = _onclick;
state[13] = _ondblclick;
state[14] = _onkeydown;
state[15] = _onkeypress;
state[16] = _onkeyup;
state[17] = _onmousedown;
state[18] = _onmousemove;
state[19] = _onmouseout;
state[20] = _onmouseover;
state[21] = _onmouseup;
state[22] = _rowClasses;
state[23] = _rules;
state[24] = _style;
state[25] = _styleClass;
state[26] = _summary;
state[27] = _title;
state[28] = _width;
return state;
}

@Override
public void restoreState(FacesContext context, Object state){
Object[] states = (Object[]) state;
super.restoreState(context, states[0]);
	_align = (String)states[1];;
		_bgcolor = (String)states[2];;
		_border = (String)states[3];;
		_cellpadding = (String)states[4];;
		_cellspacing = (String)states[5];;
		_columnClasses = (String)states[6];;
		_dir = (String)states[7];;
		_footerClass = (String)states[8];;
		_frame = (String)states[9];;
		_headerClass = (String)states[10];;
		_lang = (String)states[11];;
		_onclick = (String)states[12];;
		_ondblclick = (String)states[13];;
		_onkeydown = (String)states[14];;
		_onkeypress = (String)states[15];;
		_onkeyup = (String)states[16];;
		_onmousedown = (String)states[17];;
		_onmousemove = (String)states[18];;
		_onmouseout = (String)states[19];;
		_onmouseover = (String)states[20];;
		_onmouseup = (String)states[21];;
		_rowClasses = (String)states[22];;
		_rules = (String)states[23];;
		_style = (String)states[24];;
		_styleClass = (String)states[25];;
		_summary = (String)states[26];;
		_title = (String)states[27];;
		_width = (String)states[28];;
	
}

}
