package com.qmetry.bean;

/**
 * This class defines LabelBean.
 * 
 * @author rahul.patil
 */
public class LabelBean extends CommonBean {
    String labelAlias;
    String labelName;
    String updatedLabelAlias;

    public String getLabelAlias() {
        return labelAlias;
    }

    public void setLabelAlias(String labelAlias) {
        this.labelAlias = labelAlias;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getUpdatedLabelAlias() {
        return updatedLabelAlias;
    }

    public void setUpdatedLabelAlias(String updatedLabelAlias) {
        this.updatedLabelAlias = updatedLabelAlias;
    }

}