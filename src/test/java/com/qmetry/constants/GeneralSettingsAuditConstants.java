package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines GeneralSettingsAuditConstants.
 * 
 * @author rahul.patil
 */
public interface GeneralSettingsAuditConstants extends CommonConstants {

    // Tab
    static final String TAB_AUDIT = "Audit";
    static final String TAB_CONFIGURE_LOGO = "Configure Logo";
    static final String TAB_QI_CONFIGURATIONS = "AI Configurations";
    static final String TAB_GENERAL_SETTINGS = "General Settings";

    // Constance message
    static final String RETENTION_POLICY_PARAGRAPH = "Retain information for operational or regulatory compliance needs.";
    static final String RETENTION_POLICY_INFO_CIRCLE_POPOVER_CONTAINER = "QMetry automatically deletes all Audit and changelog that have been in a queue for more than maximum log retention period. The default log retention period is 180 days. However, you can set the log retention period to a value from 30 days to 1095 days.";

    static final String ADD_RQ_EVENT_NOTIFICATION_RECEIVER_SUCCESS = "Notification receiver successfully added for add requirement event.";
    static final String ADD_RQ_EVENT_NOTIFICATION_RECEIVER_FAILED = "Notification receiver could not be successfully added for add requirement event.";

    ArrayList<String> changeLogColumnList = new ArrayList<>(Arrays.asList("Changed By", "Entity Key",
            "Changed Field in JSON", "New Value", "Old Value", "Changed Date", "Change History ID", "Entity ID",
            "New Version", "Old Version", "Changed Field", "Module", "project ID", "Client ID"));

    ArrayList<String> auditLogColumnList = new ArrayList<>(Arrays.asList("Access User", "Action Name", "Message",
            "Project Name", "Screen Name", "Access Date", "Access Log ID", "Module Name", "Service Name",
            "Remote Address", "Entity Key", "ID", "Project ID"));

    ArrayList<String> testResultLogColumnList = new ArrayList<>(Arrays.asList("Test Case ExecHistoryID",
            "Test Case Summary", "Test Suite Summary", "Test Suite EntityKey", "Test Case EntityKey",
            "Test Case version", "Release Name", "Cycle Executed", "Build Executed", "Test Case Comment", "Issue IDs",
            "Execution Status", "Executed By", "Platform Name", "Start Time", "End Time", "Test Case stepNumber",
            "Test Case Step Description", "Test Case Step Description(Plain Text)", "Test Case Step Input Data",
            "Test Case Step Input Data(Plain Text)", "Test Case Step Expected Outcome",
            "Test Case Step Expected Outcome(Plain Text)", "Test Case Step Actual Outcome", "Test Case Step comment",
            "Test Case Step Execution Status"));
}
