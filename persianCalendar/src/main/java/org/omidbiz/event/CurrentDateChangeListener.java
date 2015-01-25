package org.omidbiz.event;

import javax.faces.event.FacesListener;

public interface CurrentDateChangeListener extends FacesListener {

    public void processCurrentDateChange(CurrentDateChangeEvent event);

}