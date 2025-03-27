package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines IssueConstants.
 * 
 * @author rahul.patil
 */
public interface IssueConstants extends CommonConstants {

	// Issue type properties
	public static final String ISSUE_TYPE_BUG = "Bug";
	public static final String ISSUE_TYPE_ENHANCEMENT = "Enhancement";
	public static final String ISSUE_TYPE_NEW_FEATURE = "New Feature";

	// Issue priority properties
	public static final String ISSUE_PRIORITY_BLOCKER = "Blocker";
	public static final String ISSUE_PRIORITY_CRITICAL = "Critical";
	public static final String ISSUE_PRIORITY_MAJOR = "Major";
	public static final String ISSUE_PRIORITY_MINOR = "Minor";
	public static final String ISSUE_PRIORITY_TRIVIAL = "Trivial";

	// Issue state properties
	public static final String ISSUE_STATE_OPEN = "Open";
	public static final String ISSUE_STATE_REOPENED = "Reopened";
	public static final String ISSUE_STATE_RESOLVED = "Resolved";
	public static final String ISSUE_STATE_CLOSED = "Closed";
	public static final String ISSUE_STATUS_TO_DO = "TO DO";
	public static final String ISSUE_STATUS_DONE = "Done";

	// Resolved status properties
	public static final String RESOLVED_STATUS_CLOSED = "Closed";
	public static final String RESOLVED_STATUS_OPEN = "Open";
	public static final String RESOLVED_STATUS_REOPENED = "Reopened";
	public static final String RESOLVED_STATUS_RESOLVED = "Resolved";

	static final String ISSUE_SOURCE_PROJECT_BULK_COPY_SUCCESS = "Bulk copied issues are available in source project.";
	static final String ISSUE_SOURCE_PROJECT_BULK_COPY_FAILED = "Bulk copied issues are not available in source project.";

	static final String ISSUE_DESTINATION_PROJECT_BULK_COPY_SUCCESS = "Bulk copied issues are available in destination project.";
	static final String ISSUE_DESTINATION_PROJECT_BULK_COPY_FAILED = "Bulk copied issues are not available in destination project.";

	static final String ISSUE_BULK_MOVE_SUCCESS = "Bulk move operation performed successfully";
	static final String ISSUE_BULK_MOVE_FAILED = "Bulk move operation not performed successfully";

	static final String ISSUE_BULK_DELETE_SUCCESS = "Bulk delete operation performed successfully";
	static final String ISSUE_BULK_DELETE_FAILED = "Bulk delete operation not performed successfully";

	static final String ISSUE_BULK_EDIT_SUCCESS = "Bulk edit operation performed successfully";
	static final String ISSUE_BULK_EDIT_FAILED = "Bulk edit operation not performed successfully";

	static final String QMETRY_FILTER_TYPE_BUG_SUCCESS = "Qmetry filter applied successfully for issue type bug.";
	static final String QMETRY_FILTER_TYPE_BUG_FAILED = "Qmetry filter is not applied successfully for issue type bug.";

	static final String QMETRY_FILTER_TYPE_ENHANCEMENT_SUCCESS = "Qmetry filter applied successfully for issue type enhancement.";
	static final String QMETRY_FILTER_TYPE_ENHANCEMENT_FAILED = "Qmetry filter is not applied successfully for issue type enhancement.";

	static final String QMETRY_FILTER_TYPE_BUG_AND_ENHANCEMENT_SUCCESS = "Qmetry filter applied successfully for both issue type bug, enhancement.";
	static final String QMETRY_FILTER_TYPE_BUG_AND_ENHANCEMENT_FAILED = "Qmetry filter is not applied successfully for both issue type bug, enhancement.";

	static final String ARRANGE_COLUMN_FOR_ISSUE_SUCCESS = "Issues list columns enabled successfully.";
	static final String ARRANGE_COLUMN_FOR_ISSUE_FAILED = "Issues list columns not enabled successfully";

	static final String LINK_REQUIREMENTS_TO_ISSUE_SUCCESS = "Requirements successfully linked to issue";
	static final String LINK_REQUIREMENTS_TO_ISSUE_FAILED = "Requirements could not be linked to issue";

	static final String UNLINK_REQUIREMENTS_FROM_ISSUE_SUCCESS = "Requirements successfully unlinked from issue";
	static final String UNLINK_REQUIREMENTS_FROM_ISSUE_FAILED = "Requirements could not be unlinked from issue";

	static final String ISSUE_ADD_COMMENT_SUCCESS = "Issue add comment operation performed successfully";
	static final String ISSUE_ADD_COMMENT_FAILED = "Issue add comment operation not performed successfully";

	static final String ISSUE_UPDATE_COMMENT_SUCCESS = "Issue update comment operation performed successfully";
	static final String ISSUE_UPDATE_COMMENT_FAILED = "Issue update comment operation not performed successfully";

	static final String ISSUE_DELETE_COMMENT_SUCCESS = "Issue delete comment operation performed successfully";
	static final String ISSUE_DELETE_COMMENT_FAILED = "Issue delete comment operation not performed successfully";

	static final String ISSUE_ADD_ATTACHMENT_SUCCESS = "Issue add attachment operation performed successfully";
	static final String ISSUE_ADD_ATTACHMENT_FAILED = "Issue add attachment operation not performed successfully";
	static final String ISSUE_DELETE_ATTACHMENT_SUCCESS = "Issue delete attachment operation performed successfully";
	static final String ISSUE_DELETE_ATTACHMENT_FAILED = "Issue delete attachment operation not performed successfully";

	static final String SORTING_IS_COLUMN_VALUES_IN_ASC_SUCCESS = "Issue column values sorted in ascending order.";
	static final String SORTING_IS_COLUMN_VALUES_IN_ASC_FAILED = "Issue column values not sorted in ascending order.";

	static final String SORTING_IS_COLUMN_VALUES_IN_DESC_SUCCESS = "Issue column values sorted in descending order.";
	static final String SORTING_IS_COLUMN_VALUES_IN_DESC_FAILED = "Issue column values not sorted in descending order.";

	static final String ISSUE_SOURCE_PROJECT_BULK_MOVE_SUCCESS = "Bulk moved issues are not available in source project.";
	static final String ISSUE_SOURCE_PROJECT_BULK_MOVE_FAILED = "Bulk moved issues are available in source project.";

	static final String ISSUE_DESTINATION_PROJECT_BULK_MOVE_SUCCESS = "Bulk moved issues are available in destination project.";
	static final String ISSUE_DESTINATION_PROJECT_BULK_MOVE_FAILED = "Bulk moved issues are not available in destination project.";

	static final String ISSUE_EDIT_SUCCESS = "Issue summary edited successfully.";
	static final String ISSUE_EDIT_FAILED = "Issue summary could not be edited successfully.";

	static final String ARRANGE_COLUMN_ENABLE_FOR_ISSUE_SUCCESS = "Issues list columns enabled successfully.";
	static final String ARRANGE_COLUMN_ENABLE_FOR_ISSUE_FAILED = "Issues list columns not enabled successfully";
	static final String ARRANGE_COLUMN_DISABLE_FOR_ISSUE_SUCCESS = "Issues list columns disabled successfully.";
	static final String ARRANGE_COLUMN_DISABLE_FOR_ISSUE_FAILED = "Issues list columns not disabled successfully";

	static final String EXECUTION_RUNS_FILTER_STATUS_PASSED_SUCCESS = "Execution runs filter applied successfully for test run status passed.";
	static final String EXECUTION_RUNS_FILTER_STATUS_PASSED_FAILED = "Execution runs Qmetry filter is not applied successfully for test run status passed.";
	static final String EXECUTION_RUNS_FILTER_STATUS_NOT_RUN_SUCCESS = "Execution runs Qmetry filter applied successfully for test run status not run.";
	static final String EXECUTION_RUNS_FILTER_STATUS_NOT_RUN_FAILED = "Execution runs Qmetry filter is not applied successfully for test run status not run.";
	static final String EXECUTION_RUNS_FILTER_STATUS_PASSED_AND_NOT_RUN_SUCCESS = "Execution runs Qmetry filter applied successfully for both test run status passed and not run.";
	static final String EXECUTION_RUNS_FILTER_STATUS_PASSED_AND_NOT_RUN_FAILED = "Execution runs Qmetry filter is not applied successfully for both test run status passed and not run.";

	static final String ISSUE_UDF_VALUE_SUCCESS = "UDF values for issue verified successfully.";
	static final String ISSUE_UDF_VALUE_FAILED = "UDF values for issue could not be verified successfully.";

	static final String QMETRY_FILTER_ISSUE_ENTITY_KEY_SUCCESS = "Qmetry filter applied successfully using issue entity key.";
	static final String QMETRY_FILTER_ISSUE_ENTITY_KEY_FAILED = "Qmetry filter is not applied successfully using issue entity key.";

	static final String QMETRY_FILTER_ISSUE_SUMMARY_SUCCESS = "Qmetry filter applied successfully using issue summary.";
	static final String QMETRY_FILTER_ISSUE_SUMMARY_FAILED = "Qmetry filter is not applied successfully using issue summary.";

	static final String QMETRY_FILTER_OWNER1_SUCCESS = "Qmetry filter applied successfully using issue owner1.";
	static final String QMETRY_FILTER_OWNER1_FAILED = "Qmetry filter is not applied successfully using issue owner1.";
	static final String QMETRY_FILTER_OWNER2_SUCCESS = "Qmetry filter applied successfully using issue owner2.";
	static final String QMETRY_FILTER_OWNER2_FAILED = "Qmetry filter is not applied successfully using issue owner2.";
	static final String QMETRY_FILTER_OWNER1_AND_OWNER2_SUCCESS = "Qmetry filter applied successfully using both issue owner1 and owner2.";
	static final String QMETRY_FILTER_OWNER1_AND_OWNER2_FAILED = "Qmetry filter is not applied successfully using both issue owner1 and owner2.";

	static final String QMETRY_FILTER_STATE_REOPENED_SUCCESS = "Qmetry filter applied successfully for issue state reopened.";
	static final String QMETRY_FILTER_STATE_REOPENED_FAILED = "Qmetry filter is not applied successfully for issue state reopened.";

	static final String QMETRY_FILTER_STATE_OPEN_SUCCESS = "Qmetry filter applied successfully for issue state open.";
	static final String QMETRY_FILTER_STATE_OPEN_FAILED = "Qmetry filter is not applied successfully for issue state open.";

	static final String QMETRY_FILTER_STATE_REOPENED_AND_OPEN_SUCCESS = "Qmetry filter applied successfully for both issue state reopened and open.";
	static final String QMETRY_FILTER_STATE_REOPENED_AND_OPEN_FAILED = "Qmetry filter is not applied successfully for both issue state reopened and open.";

	static final String QMETRY_FILTER_PRIORITY_CRITICAL_SUCCESS = "Qmetry filter applied successfully for issue priority critical.";
	static final String QMETRY_FILTER_PRIORITY_CRITICAL_FAILED = "Qmetry filter is not applied successfully for issue priority critical.";

	static final String QMETRY_FILTER_PRIORITY_MINOR_SUCCESS = "Qmetry filter applied successfully for issue priority minor.";
	static final String QMETRY_FILTER_PRIORITY_MINOR_FAILED = "Qmetry filter is not applied successfully for issue priority minor.";

	static final String QMETRY_FILTER_PRIORITY_CRITICAL_AND_MINOR_SUCCESS = "Qmetry filter applied successfully for both issue priority critical and minor.";
	static final String QMETRY_FILTER_PRIORITY_CRITICAL_AND_MINOR_FAILED = "Qmetry filter is not applied successfully for both issue priority critical and minor.";

	// Custom Verification Messages for report
	static final String ISSUE_CREATE_SUCCESS = "Issue created successfully.";
	static final String ISSUE_CREATE_FAILED = "Issue could not be created successfully.";
	static final String ISSUE_DELETE_SUCCESS = "Issue deleted successfully";
	static final String ISSUE_DELETE_FAILED = "Issue could not be deleted successfully";
	static final String ISSUE_IMPORT_SUCCESS = "Issue imported successfully";
	static final String ISSUE_IMPORT_FAILED = "Issue could not be imported successfully";

	ArrayList<String> defaultNonEditableCheckedColumnsLinkIssuesModel = new ArrayList<>(
			Arrays.asList("Entity Key", "Summary"));

	ArrayList<String> defaultCheckedColumnsLinkIssuesModel = new ArrayList<>(Arrays.asList("Priority", "Type", "Status",
			"Associated Release(s)", "Associated Cycle(s)", "Label(s)", "Owner", "Created By", "Environment"));

	// pagination
	static final String ISSUE_PAGINATION_SUCCESS = "Issue Pagination verified successfully.";
	static final String ISSUE_PAGINATION_FAILED = "Issue Pagination could not be verified successfully.";

	// change log
	static final String ISSUE_CHANGE_LOG_FILTER_SUCCESS = "Issue Change Log Filter is working as expected.";
	static final String ISSUE_CHANGE_LOG_FILTER_FAILED = "Issue Change Log Filter is not working as expected.";

	static final String ISSUE_CHANGE_LOG_TABLE_UPDATE_SUCCESS = "Issue Change Log table values updated as expected.";
	static final String ISSUE_CHANGE_LOG_TABLE_UPDATE_FAILED = "Issue Change Log table values not updated as expected.";

	// Jira External Issue priority properties
	public static final String JIRA_INTEGRATED_ISSUE_PRIORITY_LOW = "Low";
	public static final String JIRA_INTEGRATED_ISSUE_PRIORITY_LOWEST = "Lowest";
	public static final String JIRA_INTEGRATED_ISSUE_PRIORITY_MEDIUM = "Medium";
	public static final String JIRA_INTEGRATED_ISSUE_PRIORITY_HIGH = "High";
	public static final String JIRA_INTEGRATED_ISSUE_PRIORITY_HIGHEST = "Highest";

}