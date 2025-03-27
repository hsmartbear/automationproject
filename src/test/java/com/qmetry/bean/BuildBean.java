package com.qmetry.bean;

/**
 * This class defines BuildBean.
 * 
 * @author rahul.patil
 */
public class BuildBean extends CommonBean {
    String buildName;
    String buildDescription;
    String associatedRelease;
    String associatedCycle;
    String updatedBuildName;
    Long dropID;

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildDescription() {
        return buildDescription;
    }

    public void setBuildDescription(String buildDescription) {
        this.buildDescription = buildDescription;
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

    public Long getDropID() {
        return dropID;
    }

    public void setDropID(Long dropID) {
        this.dropID = dropID;
    }

}