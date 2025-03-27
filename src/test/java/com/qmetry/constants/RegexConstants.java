package com.qmetry.constants;

/**
 * This interface defines RegexConstants.
 * 
 * @author rahul.patil
 */
public interface RegexConstants extends CommonConstants {
    static final String REGEX_MM_DD_YYYY_HH_MM_SS = "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}$";
    static final String REGEX_MM_DD_YYYY_HH_MM_SS_MM_DD_YYYY_HH_MM_SS = "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2} - \\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}$";
}