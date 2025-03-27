package com.qmetry.bean;

import java.util.ArrayList;

/**
 * This class defines BulkOperationBean.
 * 
 * @author rahul.patil
 */
public class BulkOperationBean extends CommonBean {

    ArrayList<String> entityKeys;
    String destFolder;
    String destProject;
    String owner;
    String priority;
    String sourceFolder;
    ArrayList<String> summaries;
    String status;
    String testCategory;
    String estimatedTime;
    String issueType;
    String executionStatus;
    String parentFolder;
    boolean isChild;
    String entityKey;

    public ArrayList<String> getEntityKeys() {
        return entityKeys;
    }

    public void setEntityKeys(ArrayList<String> entityKeys) {
        this.entityKeys = entityKeys;
    }

    public String getDestFolder() {
        return destFolder;
    }

    public void setDestFolder(String destFolder) {
        this.destFolder = destFolder;
    }

    public String getDestProject() {
        return destProject;
    }

    public void setDestProject(String destProject) {
        this.destProject = destProject;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPrority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    public ArrayList<String> getSummaries() {
        return summaries;
    }

    public void setSummaries(ArrayList<String> summaries) {
        this.summaries = summaries;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }

    public String geEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String geIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }
    
    public String getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(String parentFolder) {
        this.parentFolder = parentFolder;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setIsChild(Boolean isChild) {
        this.isChild = isChild;
    }
    
    public String getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }


}