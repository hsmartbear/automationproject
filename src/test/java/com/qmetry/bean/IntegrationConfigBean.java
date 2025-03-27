package com.qmetry.bean;

/**
 * This class defines IntegrationConfigBean.
 * 
 * @author rahul.patil
 */
public class IntegrationConfigBean extends CommonBean {
    String integrationType;
    String aliasName;
    String url;
    String apiKey;
    String username;
    String password;
    String integrationProject;

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

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

    public String getIntegrationProject() {
        return integrationProject;
    }

    public void setIntegrationProject(String integrationProject) {
        this.integrationProject = integrationProject;
    }

}