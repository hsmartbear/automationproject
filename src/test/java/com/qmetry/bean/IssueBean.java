package com.qmetry.bean;

import java.util.List;

/**
 * This class defines IssueBean.
 * 
 * @author rahul.patil
 */
public class IssueBean extends CommonBean {
    String issueSummary;
    String issueDescription;
    String priority;
    String label;
    String owner;
    String type;
    String associatedRelease;
    String associatedCycle;
    String issueEntityKey;
    String integrationInstance;
    String apiKey;
    String externalIssueSummary;
    String defectLookupList;
    String scheduleState;
    String defectText;
    Long defectID;
    List<String> issueTypes;
    String updatedIssueSummary;
    String issueExternalKey;
    String externalProject;
    String status;
    String environment;
    String parentIssueSummary;
    String parentIssueEntityKey;


    public String getIssueSummary() {
        return issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssociatedRelease() {
        return associatedRelease;
    }

    public void setAssociatedRelease(String associatedRelease) {
        this.associatedRelease = associatedRelease;
    }

    public String getIssueEntityKey() {
        return issueEntityKey;
    }

    public void setIssueEntityKey(String issueEntityKey) {
        this.issueEntityKey = issueEntityKey;
    }

    public String getIntegrationInstance() {
        return integrationInstance;
    }

    public void setIntegrationInstance(String integrationInstance) {
        this.integrationInstance = integrationInstance;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getExternalIssueSummary() {
        return externalIssueSummary;
    }

    public void setExternalIssueSummary(String externalIssueSummary) {
        this.externalIssueSummary = externalIssueSummary;
    }

    public String getDefectLookupList() {
        return defectLookupList;
    }

    public void setDefectLookupList(String defectLookupList) {
        this.defectLookupList = defectLookupList;
    }

    public String getScheduleState() {
        return scheduleState;
    }

    public void setScheduleState(String scheduleState) {
        this.scheduleState = scheduleState;
    }

    public String getDefectText() {
        return defectText;
    }

    public void setDefectText(String defectText) {
        this.defectText = defectText;
    }

    public Long getDefectID() {
        return defectID;
    }

    public void setDefectID(Long defectID) {
        this.defectID = defectID;
    }

    public List<String> getIssueTypes() {
		return issueTypes;
    }
    
	public void setIssueTypes(List<String> issueTypes) {
		this.issueTypes = issueTypes;
    }

    public String getUpdatedIssueSummary() {
        return updatedIssueSummary;
    }

    public void setUpdatedIssueSummary(String updatedIssueSummary) {
        this.updatedIssueSummary = updatedIssueSummary;
    }

    public String getIssueExternalKey() {
        return issueExternalKey;
    }

    public void setIssueExternalKey(String issueExternalKey) {
        this.issueExternalKey = issueExternalKey;
    }

    public String getExternalProject() {
        return externalProject;
    }

    public void setExternalProject(String externalProject) {
        this.externalProject = externalProject;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getAssociatedCycle() {
        return associatedCycle;
    }

    public void setAssociatedCycle(String associatedCycle) {
        this.associatedCycle = associatedCycle;
    }
    

    public String getParentIssueSummary() {
        return parentIssueSummary;
    }

    public void setParentIssueSummary(String parentIssueSummary) {
        this.parentIssueSummary = parentIssueSummary;
    }

    public String getParentIssueEntityKey() {
        return parentIssueEntityKey;
    }

    public void setParentIssueEntityKey(String parentIssueEntityKey) {
        this.parentIssueEntityKey = parentIssueEntityKey;
    }

}