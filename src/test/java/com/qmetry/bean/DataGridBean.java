package com.qmetry.bean;

/**
 * This class defines DataGridBean.
 * 
 * @author rahul.patil
 */
public class DataGridBean extends CommonBean {
    String dataGridName;
    String dataGridProject;
    String dataGridDescription;
    String updatedDataGridName;

    public String getDataGridName() {
        return dataGridName;
    }

    public void setDataGridName(String dataGridName) {
        this.dataGridName = dataGridName;
    }

    public String getDataGridProject() {
        return dataGridProject;
    }

    public void setDataGridProject(String dataGridProject) {
        this.dataGridProject = dataGridProject;
    }

    public String getDataGridDescription() {
        return dataGridDescription;
    }

    public void setDataGridDescription(String dataGridDescription) {
        this.dataGridDescription = dataGridDescription;
    }

    public String getUpdatedDataGridName() {
        return updatedDataGridName;
    }

    public void setUpdatedDataGridName(String updatedDataGridName) {
        this.updatedDataGridName = updatedDataGridName;
    }

}