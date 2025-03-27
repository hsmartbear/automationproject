package com.qmetry.bean;

/**
 * This class defines ExecutionStatusBean.
 * 
 * @author rahul.patil
 */
public class ExecutionStatusBean extends CommonBean {
    String executionStatusName;
    String statusLevel;
    String statusTo;
    String updatedExecutionStatusName;

    public String getExecutionStatusName() {
        return executionStatusName;
    }

    public void setExecutionStatusName(String executionStatusName) {
        this.executionStatusName = executionStatusName;
    }

    public String getStatusLevel() {
        return statusLevel;
    }

    public void setStatusLevel(String statusLevel) {
        this.statusLevel = statusLevel;
    }

    public String getStatusTo() {
        return statusTo;
    }

    public void setStatusTo(String statusTo) {
        this.statusTo = statusTo;
    }

    public String getUpdatedExecutionStatusName() {
        return updatedExecutionStatusName;
    }

    public void setUpdatedExecutionStatusName(String updatedExecutionStatusName) {
        this.updatedExecutionStatusName = updatedExecutionStatusName;
    }

}