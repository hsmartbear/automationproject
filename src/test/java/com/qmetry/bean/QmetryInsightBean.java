package com.qmetry.bean;

/**
 * This class defines QmetryInsightBean.
 * 
 * @author rahul.patil
 */
public class QmetryInsightBean extends CommonBean {
    String gadgetName;
    String gadgetDescription;
    String summary;
    String fieldName;
    String entityKey;
    String sharedGadgetUser;
    
    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public String getGadgetDescription() {
        return gadgetDescription;
    }

    public void setGadgetDescription(String gadgetDescription) {
        this.gadgetDescription = gadgetDescription;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }

    public String getSharedGadgetUser() {
        return sharedGadgetUser;
    }

    public void setSharedGadgetUser(String sharedGadgetUser) {
        this.sharedGadgetUser = sharedGadgetUser;
    }


}