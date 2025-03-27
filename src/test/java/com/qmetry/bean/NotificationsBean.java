package com.qmetry.bean;

/**
 * This class defines NotificationsBean.
 * 
 * @author rahul.patil
 */
public class NotificationsBean extends CommonBean {
    String event;
    String email;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}