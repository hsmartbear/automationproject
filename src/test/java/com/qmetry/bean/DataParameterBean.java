package com.qmetry.bean;

import java.util.ArrayList;

/**
 * This class defines DataParameterBean.
 * 
 * @author rahul.patil
 */
public class DataParameterBean extends CommonBean {
    
    String paramName;
    String paramProject;
    String paramDescription;
    ArrayList<String> paramValue;
    String values;
    String updatedParamName;
    String paramID;
    ArrayList<String> paramProjects;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamProject() {
        return paramProject;
    }

    public void setParamProject(String paramProject) {
        this.paramProject = paramProject;
    }

    public String getParamDescription() {
        return paramDescription;
    }

    public void setParamDescription(String paramDescription) {
        this.paramDescription = paramDescription;
    }

    public ArrayList<String> getParamValue() {
        return paramValue;
    }

    public void setParamValue(ArrayList<String> paramValue) {
        this.paramValue = paramValue;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getUpdatedParamName() {
        return updatedParamName;
    }

    public void setUpdatedParamName(String updatedParamName) {
        this.updatedParamName = updatedParamName;
    }
    
    public String getparamID() {
        return paramID;
    }

    public void setparamID(String paramID) {
        this.paramID = paramID;
    }

    public ArrayList<String> getParamProjects(){
        return paramProjects;
    }

    public void setParamProjects(ArrayList<String> paramProjects){
        this.paramProjects = paramProjects;
    }

}