package com.qmetry.bean;

import com.qmetry.page.LdapSamlPage.DefaultAccessTypeMenuOptions;

/**
 * This class defines LdapSamlBean.
 * 
 * @author rahul.patil
 */
public class LdapSamlBean extends CommonBean {

    String hostName;
    String baseName;
    String bindName;
    String ldapPassword;
    String dataAttribute;
    String firstNameAttribute;
    String lastNameAttribute;
    String emailAttribute;
    String sampleUser;
    String sampleUserPassword;
    String idpProviderName;
    String activeType;
    String accessType;
    String idpMetaDataFile;
    String samlUsername;
    String samlPassword;
    boolean ldapUserActive;
    DefaultAccessTypeMenuOptions menuOption;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBindName() {
        return bindName;
    }

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }

    public String getLdapPassword() {
        return ldapPassword;
    }

    public void setLdapPassword(String ldapPassword) {
        this.ldapPassword = ldapPassword;
    }

    public String getDataAttribute() {
        return dataAttribute;
    }

    public void setDataAttribute(String dataAttribute) {
        this.dataAttribute = dataAttribute;
    }

    public String getFirstNameAttribute() {
        return firstNameAttribute;
    }

    public void setFirstNameAttribute(String firstNameAttribute) {
        this.firstNameAttribute = firstNameAttribute;
    }

    public String getLastNameAttribute() {
        return lastNameAttribute;
    }

    public void setLastNameAttribute(String lastNameAttribute) {
        this.lastNameAttribute = lastNameAttribute;
    }

    public String getEmailAttribute() {
        return emailAttribute;
    }

    public void setEmailAttribute(String emailAttribute) {
        this.emailAttribute = emailAttribute;
    }

    public String getSampleUser() {
        return sampleUser;
    }

    public void setSampleUser(String sampleUser) {
        this.sampleUser = sampleUser;
    }

    public String getSampleUserPassword() {
        return sampleUserPassword;
    }

    public void setSampleUserPassword(String sampleUserPassword) {
        this.sampleUserPassword = sampleUserPassword;
    }

    public String getIdpProviderName() {
        return idpProviderName;
    }

    public void setIdpProviderName(String idpProviderName) {
        this.idpProviderName = idpProviderName;
    }

    public String getActiveType() {
        return activeType;
    }

    public void setActiveType(String activeType) {
        this.activeType = activeType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getIdpMetaDataFile() {
        return idpMetaDataFile;
    }

    public void setIdpMetaDataFile(String idpMetaDataFile) {
        this.idpMetaDataFile = idpMetaDataFile;
    }

    public String getSamlUsername() {
        return samlUsername;
    }

    public void setSamlUsername(String samlUsername) {
        this.samlUsername = samlUsername;
    }

    public String getSamlPassword() {
        return samlPassword;
    }

    public void setSamlPassword(String samlPassword) {
        this.samlPassword = samlPassword;
    }
    
    public Boolean getLdapUserActive() {
        return ldapUserActive;
    }

    public void setLdapUserActive(Boolean ldapUserActive) {
        this.ldapUserActive = ldapUserActive;
    }

    public DefaultAccessTypeMenuOptions getLdapAccessTypeMenuOption() {
        return menuOption;
    }

    public void setLdapAccessTypeMenuOption(DefaultAccessTypeMenuOptions menuOption) {
        this.menuOption = menuOption;
    }

}