package com.qmetry.bean;

/**
 * This class defines ApprovalAccessBean.
 * 
 * @author rahul.patil
 */
public class ApprovalAccessBean extends CommonBean {
    String approvalLevel;
    String approverName;
    String associatedRelease;
    String associatedCycle;
    String updatedBuildName;

    public String getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(String approvalLevel) {
        this.approvalLevel = approvalLevel;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
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

    public String getUpdatedBuildName() {
        return updatedBuildName;
    }

    public void setUpdatedBuildName(String updatedBuildName) {
        this.updatedBuildName = updatedBuildName;
    }

}