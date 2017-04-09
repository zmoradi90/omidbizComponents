package org.omidbiz.renderkit;

import java.util.List;

public class ProcessStepImpl implements ProcessStep
{
    private String stepCaption;
    private String stepCaptionKey;
    private List<ProcessStepField> processStepFieldList;

    public ProcessStepImpl()
    {

    }

    public String getStepCaption()
    {
        return stepCaption;
    }

    public void setStepCaption(String stepCaption)
    {
        this.stepCaption = stepCaption;
    }


    public List<ProcessStepField> getProcessStepFieldList()
    {
        return processStepFieldList;
    }

    public void setProcessStepFieldList(List<ProcessStepField> processStepFieldList)
    {
        this.processStepFieldList = processStepFieldList;
    }

    public String getStepCaptionKey()
    {
        return stepCaptionKey;
    }

    public void setStepCaptionKey(String stepCaptionKey)
    {
        this.stepCaptionKey = stepCaptionKey;
    }

}
