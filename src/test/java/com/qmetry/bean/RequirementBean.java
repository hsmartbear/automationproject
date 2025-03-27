package com.qmetry.bean;

/**
 * This class defines RequirementBean.
 * 
 * @author rahul.patil
 */
public class RequirementBean extends CommonBean {
    String requirementSummary;
    String rquirementDescription;
    String priority;
    String label;
    String owner;
    String status;
    String associatedRelease;
    String associatedCycle;
    String requirementEntityKey;
    Long requirementFolderID;
    Long requirementParentFolderID;
    Long requirementID;
    String updatedRequirementSummary;
    String versionControlSystem;
    String repository;
    String branch;
    String folderPath;
    String fileName;
    String pullData;
    String pushData;
    String requirementExternalKey;
    String integrationInstance;
    String externalProject;
    String user;
    Long requirementVersionID;

    public String getRequirementSummary() {
        return requirementSummary;
    }
    public void setRequirementSummary(String requirementSummary) {
        this.requirementSummary = requirementSummary;
    }
   
    public String getTestCaseDescription() {
        return rquirementDescription;
    }
    public void setTestCaseDescription(String rquirementDescription) {
        this.rquirementDescription = rquirementDescription;
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

    public String getRequirementEntityKey() {
        return requirementEntityKey;
    }
    public void setRequirementEntityKey(String requirementEntityKey) {
        this.requirementEntityKey = requirementEntityKey;
    }

    public Long getRequirementFolderID() {
        return requirementFolderID;
    }
    public void setRequirementFolderID(Long requirementFolderID) {
        this.requirementFolderID = requirementFolderID;
    }

    public Long getRequirementParentFolderID() {
        return requirementParentFolderID;
    }
    public void setRequirementParentFolderID(Long requirementParentFolderID) {
        this.requirementParentFolderID = requirementParentFolderID;
    }

    public Long getRequirementID() {
        return requirementID;
    }
    public void setRequirementID(Long requirementID) {
        this.requirementID = requirementID;
    }

    public String getUpdatedRequirementSummary() {
        return updatedRequirementSummary;
    }
    
    public void setUpdatedRequirementSummary(String updatedRequirementSummary) {
        this.updatedRequirementSummary = updatedRequirementSummary;
    }

    public String getVersionControlSystem() {
        return versionControlSystem;
    }
    
    public void setVersionControlSystem(String versionControlSystem) {
        this.versionControlSystem = versionControlSystem;
    }

    public String getRepository() {
        return repository;
    }
    
    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFolderPath() {
        return folderPath;
    }
    
    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPullData() {
        return pullData;
    }
    
    public void setPullData(String pullData) {
        this.pullData = pullData;
    }

    public String getPushData() {
        return pushData;
    }
    
    public void setPushData(String pushData) {
        this.pushData = pushData;
    }

    public String getRequirementExternalKey() {
        return requirementExternalKey;
    }

    public void setRequirementExternalKey(String requirementExternalKey) {
        this.requirementExternalKey = requirementExternalKey;
    }

    public String getIntegrationInstance() {
        return integrationInstance;
    }

    public void setIntegrationInstance(String integrationInstance) {
        this.integrationInstance = integrationInstance;
    }

    public String getExternalProject() {
        return externalProject;
    }

    public void setExternalProject(String externalProject) {
        this.externalProject = externalProject;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public Long getrequirementVersionID() {
        return requirementVersionID;
    }

    public void setrequirementVersionID(Long requirementVersionID) {
        this.requirementVersionID = requirementVersionID;
    }

}