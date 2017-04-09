package org.omidbiz.renderkit;

import java.util.List;

public interface ProcessStep
{
    public String getStepCaption();

    public String getStepCaptionKey();
    
    public List<ProcessStepField> getProcessStepFieldList();
}
