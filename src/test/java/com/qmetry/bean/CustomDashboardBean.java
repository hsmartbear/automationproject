package com.qmetry.bean;

/**
 * This class defines CustomDashboardBean.
 * 
 * @author rahul.patil
 */
public class CustomDashboardBean extends CommonBean {
    String dashboardName;
    String gadgets;
    String scheduleEmailFrom;
    String scheduleEmailTo;
    String scheduleEmailSubject;
    String sharedDashboardUser;

    public String getDashboardName() {
        return dashboardName;
    }

    public void setDashboardName(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    public String getGadgets() {
        return gadgets;
    }

    public void setGadgets(String gadgets) {
        this.gadgets = gadgets;
    }

    public String getScheduleEmailFrom() {
        return scheduleEmailFrom;
    }

    public void setScheduleEmailFrom(String scheduleEmailFrom) {
        this.scheduleEmailFrom = scheduleEmailFrom;
    }

    public String getScheduleEmailTo() {
        return scheduleEmailTo;
    }

    public void setScheduleEmailTo(String scheduleEmailTo) {
        this.scheduleEmailTo = scheduleEmailTo;
    }

    public String getScheduleEmailSubject() {
        return scheduleEmailSubject;
    }

    public void setScheduleEmailSubject(String scheduleEmailSubject) {
        this.scheduleEmailSubject = scheduleEmailSubject;
    }

    public String getSharedDashboardUser() {
        return sharedDashboardUser;
    }

    public void setSharedDashboardUser(String sharedDashboardUser) {
        this.sharedDashboardUser = sharedDashboardUser;
    }
}