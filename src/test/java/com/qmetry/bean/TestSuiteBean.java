package com.qmetry.bean;

import java.util.HashMap;

/**
 * This class defines TestSuiteBean.
 * 
 * @author rahul.patil
 */
public class TestSuiteBean extends CommonBean {
    String testSuiteSummary;
    String testSuiteDescription;
    String owner;
    String status;
    String associatedRelease;
    String associatedCycle;
    String testSuiteEntityKey;
    String testerName;
    String updatedTestSuiteSummary;
    String executionStatus;
    String platform;
    String assignee;
    String executionType;
    String buildName;
    Long testsuiteParentFolderID;
    Long testsuiteFolderID;
    Long testsuiteID;
    HashMap<String, Boolean> weeklyDaysSelectionCombo;
    String projectname;
    String entityKey;
    String totalUnAssignedtestcaseExecutions;
    Long testcaseRunStatusID;


    public String getTestSuiteSummary() {
        return testSuiteSummary;
    }

    public void setTestSuiteSummary(String testSuiteSummary) {
        this.testSuiteSummary = testSuiteSummary;
    }

    public String getTestSuiteDescription() {
        return testSuiteDescription;
    }

    public void setTestSuiteDescription(String testSuiteDescription) {
        this.testSuiteDescription = testSuiteDescription;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssociatedRelease() {
        return associatedRelease;
    }

    public void setAssociatedRelease(String associatedRelease) {
        this.associatedRelease = associatedRelease;
    }

    public String getAssociatedCycle() {
        return associatedCycle;
    }

    public void setAssociatedCycle(String associatedCycle) {
        this.associatedCycle = associatedCycle;
    }

    public String getTestSuiteEntityKey() {
        return testSuiteEntityKey;
    }

    public void setTestSuiteEntityKey(String testSuiteEntityKey) {
        this.testSuiteEntityKey = testSuiteEntityKey;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public String getUpdatedTestSuiteSummary() {
        return updatedTestSuiteSummary;
    }

    public void setUpdatedTestSuiteSummary(String updatedTestSuiteSummary) {
        this.updatedTestSuiteSummary = updatedTestSuiteSummary;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Long getTestsuiteParentFolderID() {
        return testsuiteParentFolderID;
    }

    public void setTestsuiteParentFolderID(Long testsuiteParentFolderID) {
        this.testsuiteParentFolderID = testsuiteParentFolderID;
    }

    public Long getTestsuiteFolderID() {
        return testsuiteFolderID;
    }

    public void setTestsuiteFolderID(Long testsuiteFolderID) {
        this.testsuiteFolderID = testsuiteFolderID;
    }

    public Long getTestsuiteID() {
        return testsuiteID;
    }

    public void setTestsuiteID(Long testsuiteID) {
        this.testsuiteID = testsuiteID;
    }
    
    public HashMap<String, Boolean> getWeeklyDaysSelectionCombo() {
        return weeklyDaysSelectionCombo;
    }

    public void setWeeklyDaysSelectionCombo(HashMap<String, Boolean> weeklyDaysSelectionCombo) {
        this.weeklyDaysSelectionCombo = weeklyDaysSelectionCombo;
    }
    

    public String getProjectName(){
        return projectname;
    }

    public void setProjectName(String projectname){
        this.projectname= projectname;
    }

    public String getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }


    public String getTotalUnAssignedtestcaseExecutions() {
        return totalUnAssignedtestcaseExecutions;
    }

    public void setTotalUnAssignedtestcaseExecutions(String totalUnAssignedtestcaseExecutions) {
        this.totalUnAssignedtestcaseExecutions = totalUnAssignedtestcaseExecutions;
    }

    public Long getTestcaseRunStatusID() {
        return testcaseRunStatusID;
    }

    public void setTestcaseRunStatusID(Long testcaseRunStatusID) {
        this.testcaseRunStatusID = testcaseRunStatusID;
    }

}