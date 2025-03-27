package com.qmetry.bean;

import java.util.List;

/**
 * This class defines ManageFieldsBean.
 * 
 * @author rahul.patil
 */
public class ManageFieldsBean extends CommonBean {

    List<String> udfFieldNames;

    public List<String> getUDFFieldNames() {
        return udfFieldNames;
    }

    public void seUDFFieldNames(List<String> udfFieldNames) {
        this.udfFieldNames = udfFieldNames;
    }

}