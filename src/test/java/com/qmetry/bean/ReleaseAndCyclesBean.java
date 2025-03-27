package com.qmetry.bean;

/**
 * This class defines RequirementBean.
 * 
 * @author rahul.patil
 */
public class ReleaseAndCyclesBean extends CommonBean {
    String version;
    String associatedRelease;
    String associatedCycle;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
}