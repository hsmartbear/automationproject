package com.qmetry.bean;

/**
 * This class defines QmetrySystemReportsBean.
 * 
 * @author rahul.patil
 */
public class QmetrySystemReportsBean extends CommonBean {
    String gadgetName;
    String releaseName;
    String cycleName;
    String entityKey;
    String testcaseEntityID;
    String testcaseSummary;
    String filterProjectName;

    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public String getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }

    public String getTestcaseEntityID() {
        return testcaseEntityID;
    }

    public void setTestcaseEntityID(String testcaseEntityID) {
        this.testcaseEntityID = testcaseEntityID;
    }
    
    public String getTestcaseSummary() {
        return testcaseSummary;
    }

    public void setTestcaseSummary(String testcaseSummary) {
        this.testcaseSummary = testcaseSummary;
    }
    
    public String getFilterProjectName() {
        return filterProjectName;
    }

    public void setFilterProjectName(String filterProjectName) {
        this.filterProjectName = filterProjectName;
    }
}