package com.qmetry.bean;

/**
 * This class defines AutomationAgentBean.
 * 
 * @author rahul.patil
 */
public class AutomationAgentBean extends CommonBean {
    String executionCommand;
    String agentName;
    long agentID;
    String osName;
    String agentUID;

    public String getExecutionCommand() {
        return executionCommand;
    }

    public void setExecutionCommand(String executionCommand) {
        this.executionCommand = executionCommand;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public long getAgentID() {
        return agentID;
    }

    public void setAgentID(long agentID) {
        this.agentID = agentID;
    }

    public String getOSName() {
        return osName;
    }

    public void setOSName(String osName) {
        this.osName = osName;
    }

    public String getAgentUID() {
        return agentUID;
    }

    public void setAgentUID(String agentUID) {
        this.agentUID = agentUID;
    }

}