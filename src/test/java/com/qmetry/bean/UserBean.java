package com.qmetry.bean;

/**
 * This class defines UserBean.
 * 
 * @author rahul.patil
 */
public class UserBean extends CommonBean {
    String userName;
    String userAlias;
    String userFirstName;
    String userLastName;
    String userEmail;
    String userRole;
    String userProjectName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserProjectName() {
        return userProjectName;
    }

    public void setUserProjectName(String userProjectName) {
        this.userProjectName = userProjectName;
    }

}