package com.qmetry.constants;

/**
 * This interface defines LoginConstants.
 * 
 * @author nidhi.shah
 */
public interface LoginConstants extends CommonConstants {

    static final String INVALID_AUTHENTICATION_MESSAGE = "Your authentication information is incorrect. Please try again or contact QMetry admin if the issue persists.";
    static final String MAXIMUM_LOGIN_ATTEMPTS_MESSAGE = "You have reached the maximum login attempts and your account is now locked for 10 minutes. Please retry after 10 mins OR contact your admin if you need help.";
}