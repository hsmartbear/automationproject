package com.qmetry.bean;

import java.util.List;
import java.util.Map;

/**
 * This class defines RolesBean.
 * 
 * @author rahul.patil
 */
public class RolesBean extends CommonBean {
    String roleTitle;
    String roleDescription;
    String updatedRoleTitle;
    Map<String,List<String>> modulePermission;

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getUpdatedRoleTitle() {
        return updatedRoleTitle;
    }

    public void setUpdatedRoleTitle(String updatedRoleTitle) {
        this.updatedRoleTitle = updatedRoleTitle;
    }

    public Map<String, List<String>> getModulePermission() {
		return modulePermission;
	}
	public void setModulePermission(Map<String, List<String>> modulePermission) {
		this.modulePermission = modulePermission;
	}

}