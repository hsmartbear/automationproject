package com.qmetry.bean;

/**
 * This class defines LoginBean.
 * 
 * @author nidhi.shah
 */
public class LoginBean extends CommonBean {

    String username;
    String password;
    String orgCode;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgCode() {
        return orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}