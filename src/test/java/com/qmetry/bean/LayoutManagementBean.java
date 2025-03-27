package com.qmetry.bean;

/**
 * This class defines LayoutManagementBean.
 * 
 * @author rahul.patil
 */
public class LayoutManagementBean extends CommonBean {
    String layoutModule;
    String layoutPage;

    public String getLayoutModule() {
        return layoutModule;
    }

    public void setLayoutModule(String layoutModule) {
        this.layoutModule = layoutModule;
    }

    public String getLayoutPage() {
        return layoutPage;
    }

    public void setLayoutPage(String layoutPage) {
        this.layoutPage = layoutPage;
    }

}