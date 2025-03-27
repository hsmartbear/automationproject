package com.qmetry.bean;

/**
 * This class defines PlatformBean.
 * 
 * @author rahul.patil
 */
public class PlatformBean extends CommonBean {
    String platformName;
    String updatedPlatformName;
    long platformID;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getUpdatedPlatformName() {
        return updatedPlatformName;
    }

    public void setUpdatedPlatformName(String updatedPlatformName) {
        this.updatedPlatformName = updatedPlatformName;
    }

    public long getPlatformID() {
        return platformID;
    }

    public void setPlatformID(long platformID) {
        this.platformID = platformID;
    }
}