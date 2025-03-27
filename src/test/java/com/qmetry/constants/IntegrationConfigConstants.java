package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines IntegrationConfigConstants.
 * 
 * @author rahul.patil
 */
public interface IntegrationConfigConstants extends CommonConstants {
    static final String TEST_INTEGRATION_MESSAGE = "Integration is successfully authenticated.";
    static final String SAVE_INTEGRATION_MESSAGE = "Instance details saved successfully.";
    static final String NO_RECORD_AVAILABLE_TEXT = "No records available.";
    static final String RALLY_DELETION_TEXT = "Deletion of Rally integration is in progress. You can check integration scheduler for progress of it.";
    static final String AZURE_DELETION_TEXT = "Deletion of Azure integration is in progress. You can check integration scheduler for progress of it.";

    static final String AZURE_INTEGRATION_SAVE_SUCCESS = "Azure integration saved successfully";
    static final String AZURE_INTEGRATION_SAVE_FAILED = "Azure integration could not be saved successfully";

    static final String AZURE_INTEGRATION_STATUS_SUCCESS = "Azure integration status verified successfully";
    static final String AZURE_INTEGRATION_STATUS_FAILED = "Azure integration status could not be verified successfully";

    static final String AZURE_PEOJECT_CONFIGURATION_SUCCESS = "Project configuration for azure integration is done successfully.";
    static final String AZURE_PEOJECT_CONFIGURATION_FAILED = "Project configuration for azure integration is not done successfully.";

    static final String AZURE_AUTHENTICATION_SUCCESS = "User authentication for azure integration is done successfully.";
    static final String AZURE_AUTHENTICATION_FAILED = "User authentication for azure integration is not done successfully.";

    static final String AZURE_EXTERNAL_ISSUE_SUCCESS = "External issues for azure integration is available in issues page.";
    static final String AZURE_EXTERNAL_ISSUE_FAILED = "External issues for azure integration is not available in issues page.";

    static final String AZURE_EXTERNAL_RQ_SUCCESS = "External requirement for azure integration is available in requirement page.";
    static final String AZURE_EXTERNAL_RQ_FAILED = "External requirement for azure integration is not available in requirement page.";

    static final String RALLY_INTEGRATION_SAVE_SUCCESS = "Rally integration saved successfully";
    static final String RALLY_INTEGRATION_SAVE_FAILED = "Rally integration could not be saved successfully";

    static final String RALLY_INTEGRATION_STATUS_SUCCESS = "Rally integration status verified successfully";
    static final String RALLY_INTEGRATION_STATUS_FAILED = "Rally integration status could not be verified successfully";

    static final String RALLY_PEOJECT_CONFIGURATION_SUCCESS = "Project configuration for Rally integration is done successfully.";
    static final String RALLY_PEOJECT_CONFIGURATION_FAILED = "Project configuration for Rally integration is not done successfully.";

    static final String RALLY_AUTHENTICATION_SUCCESS = "User authentication for Rally integration is done successfully.";
    static final String RALLY_AUTHENTICATION_FAILED = "User authentication for Rally integration is not done successfully.";

    static final String RALLY_EXTERNAL_ISSUE_SUCCESS = "External issues for Rally integration is available in issues page.";
    static final String RALLY_EXTERNAL_ISSUE_FAILED = "External issues for Rally integration is not available in issues page.";

    static final String RALLY_EXTERNAL_RQ_SUCCESS = "External requirement for Rally integration is available in requirement page.";
    static final String RALLY_EXTERNAL_RQ_FAILED = "External requirement for Rally integration is not available in requirement page.";

    static final String JIRA_PEOJECT_CONFIGURATION_SUCCESS = "Project configuration for jira integration is done successfully.";
    static final String JIRA_PEOJECT_CONFIGURATION_FAILED = "Project configuration for jira integration is not done successfully.";

    static final String JIRA_AUTHENTICATION_SUCCESS = "User authentication for jira integration is done successfully.";
    static final String JIRA_AUTHENTICATION_FAILED = "User authentication for jira integration is not done successfully.";

    static final String JIRA_EXTERNAL_ISSUE_SUCCESS = "External issues for jira integration is available in issues page.";
    static final String JIRA_EXTERNAL_ISSUE_FAILED = "External issues for jira integration is not available in issues page.";

    static final String JIRA_EXTERNAL_RQ_SUCCESS = "External requirement for jira integration is available in requirement page.";
    static final String JIRA_EXTERNAL_RQ_FAILED = "External requirement for jira integration is not available in requirement page.";

    static final String AZURE_EXTERNAL_ISSUE_CREATE_SUCCESS = "External issue for azure integration created successfully.";
    static final String AZURE_EXTERNAL_ISSUE_CREATE_FAILED = "External issue for azure integration could not be created succesfully.";

    static final String AZURE_EXTERNAL_ISSUE_UPDATE_SUCCESS = "External issue for azure integration updated successfully.";
    static final String AZURE_EXTERNAL_ISSUE_UPDATE_FAILED = "External issue for azure integration could not be updated succesfully.";

    static final String ISSUE_ADD_COMMENT_SUCCESS = "Issue add comment operation performed successfully";
    static final String ISSUE_ADD_COMMENT_FAILED = "Issue add comment operation not performed successfully";

    static final String ISSUE_DELETE_COMMENT_SUCCESS = "Issue delete comment operation performed successfully";
    static final String ISSUE_DELETE_COMMENT_FAILED = "Issue delete comment operation not performed successfully";

    static final String ISSUE_ADD_ATTACHMENT_SUCCESS = "Issue add attachment operation performed successfully";
    static final String ISSUE_ADD_ATTACHMENT_FAILED = "Issue add attachment operation not performed successfully";

    static final String RALLY_EXTERNAL_ISSUE_CREATE_SUCCESS = "External issue for rally integration created successfully.";
    static final String RALLY_EXTERNAL_ISSUE_CREATE_FAILED = "External issue for rally integration could not be created succesfully.";

    static final String RALLY_EXTERNAL_ISSUE_UPDATE_SUCCESS = "External issue for rally integration updated successfully.";
    static final String RALLY_EXTERNAL_ISSUE_UPDATE_FAILED = "External issue for rally integration could not be updated succesfully.";

    static final String JIRA_EXTERNAL_ISSUE_CREATE_SUCCESS = "External issue for jira integration created successfully.";
    static final String JIRA_EXTERNAL_ISSUE_CREATE_FAILED = "External issue for jira integration could not be created succesfully.";

    static final String JIRA_EXTERNAL_ISSUE_UPDATE_SUCCESS = "External issue for jira integration updated successfully.";
    static final String JIRA_EXTERNAL_ISSUE_UPDATE_FAILED = "External issue for jira integration could not be updated succesfully.";

    static final String EXTERNAL_JIRA_FILTER_SUCCESS = "External filter for jira integration applied successfully";
    static final String EXTERNAL_JIRA_FILTER_FAILED = "External filter for jira integration not applied successfully";

    static final String EXTERNAL_AZURE_FILTER_SUCCESS = "External filter for azure integration applied successfully";
    static final String EXTERNAL_AZURE_FILTER_FAILED = "External filter for azure integration not applied successfully";

    static final String EXTERNAL_RALLY_FILTER_SUCCESS = "External filter for rally integration applied successfully";
    static final String EXTERNAL_RALLY_FILTER_FAILED = "External filter for rally integration not applied successfully";

    static final String JIRA_INTEGRATION_STATUS_SUCCESS = "JIRA integration status verified successfully";
    static final String JIRA_INTEGRATION_STATUS_FAILED = "JIra integration status could not be verified successfully";

    // Intergration status
    static final String INTEGRATION_STATUS_ACTIVE = "Active";
    static final String INTEGRATION_STATUS_INACTIVE = "Inactive";

    static final String TAB_INTEGRATION_SCHEDULER_STATUS = "Integration Scheduler Status";

    static final String JIRA_INTEGRATION_TYPE = "Jira";

    static final String ISSUE_MODULE = "Issue";
    static final String BUG_ISSUE_TYPE = "Bug";

    static final String REQUIREMENT_MODULE = "Requirement";
    static final String STORY_REQUIREMENT_TYPE = "Story";

    static final String SYNC_IN_PROG_MSG = "Syncing with JIRA is in-progress at the moment. Please wait until the process is finished.";

    static final String REFRESH_ATTRIBUTE = "Refresh Attribute";
    static final String METADATA = "METADATA";

    ArrayList<String> registeredAgentsTableColumnNames = new ArrayList<>(
            Arrays.asList("Alias", "Os", "Mac Address", "Status", "Scheduled", "In Progress", "Actions"));

    ArrayList<String> schedulesTableColumnNames = new ArrayList<>(Arrays.asList("Execution Command", "Status",
            "Scheduled By", "Schedule Time", "Schedule Type", "Start Date", "End date", "Recurring Type",
            "Test Suite Key", "Release", "Cycle", "Platform", "Updated By", "Action"));

}
