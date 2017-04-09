package org.omidbiz.renderkit;

public class ProcessStepFieldImpl implements ProcessStepField
{
    private String fieldKey;
    private String fieldCaption;
    private ProcessStepFieldType fieldType;
    
    /**
     * 
     */
    public ProcessStepFieldImpl()
    {
    }

    public ProcessStepFieldImpl(String fieldKey, String fieldCaption, ProcessStepFieldType fieldType)
    {
        this.fieldKey = fieldKey;
        this.setFieldCaption(fieldCaption);
        this.fieldType = fieldType;
    }



    public String getFieldKey()
    {
        return fieldKey;
    }
    
    public void setFieldKey(String stepKey)
    {
        this.fieldKey = stepKey;
    }
    
    public ProcessStepFieldType getFieldType()
    {
        return fieldType;
    }
    
    public void setStepType(ProcessStepFieldType fieldType)
    {
        this.fieldType = fieldType;
    }

    public String getFieldCaption()
    {
        return fieldCaption;
    }

    public void setFieldCaption(String stepCaption)
    {
        this.fieldCaption = stepCaption;
    }

    
}
