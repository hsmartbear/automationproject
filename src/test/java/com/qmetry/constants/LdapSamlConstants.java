package com.qmetry.constants;

/**
 * This interface defines LdapSamlConstants.
 * 
 * @author rahul.patil
 */
public interface LdapSamlConstants extends CommonConstants {

    static final String TEST_LDAP_MESSAGE = "Sample User Authenticated.";
    static final String SAVE_LDAP_MESSAGE = "LDAP settings saved successfully.";
    static final String SAVE_SAML_MESSAGE = "SAML settings saved successfully.";
    static final String SAML_NOT_CONFIGURED_ERROR_MESSAGE = "SAML is not configured with given organization code";
    static final String LDAP_NOT_CONFIGURED_ERROR_MESSAGE = "LDAP is disabled so, you are not allowed to Login";
    static final String SETTINGS_REMOVED_MESSAGE = "Settings removed successfully.";

}
