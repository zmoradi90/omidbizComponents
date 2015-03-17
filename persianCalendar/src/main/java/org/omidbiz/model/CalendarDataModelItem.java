package org.omidbiz.model;

public interface CalendarDataModelItem {
	
	/**
	 *@return true if date is �selectable� on calendar, default implementation return true 
	 **/
	public boolean isEnabled();
	
	/**
	 * @return String that will be appended to style class for that date span.
	 * For example it may be �relevant holyday� � that mean class will be like �rich-cal-day relevant holyday�.
	 * Default implementation return empty string.
	 * */
	public String getStyleClass();
	
	/**
	 * @return any additional payload that must be JSON-serialazable object.
	 * May be used in custom date representation on calendar (inside custom facet).*/
	public Object getData();
	
	/**
	 * @return true if given date has an associated with it tooltip data.
	 * Default implementation return false.*/
	public boolean hasToolTip();
	
	/**
	 *@return tool tip data that will be used in �batch� tooltip loading mode.
	 **/
	public Object getToolTip();
	
	/**
	 *@return day of the month on which data must be shown.
	 **/
	public int getDay();
	
}
