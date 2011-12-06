package org.omidbiz.model;

import java.util.Date;

public interface CalendarDataModel {
	
	/**
	 * @return array of CalendarDataModelItems for selected dates.
	 * This method will be called every time when components will need next block of CalendarDataItems.
	 * That may happens when calendar rendered, or when user navigate to next(previous) month or in any other case when calendar renders.
	 * This method will be called in Ajax mode when Calendar renders new page.
	 * */
	public CalendarDataModelItem[] getData(Date[] dateArray);
	
	/**
	 * @return tool tip when it's used in "single" mode
	 * This method used when tool tips are displayed in "single" mode
	 * */
	public Object getToolTip(Date date);
}