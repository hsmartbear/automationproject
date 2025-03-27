package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines ProjectConstants.
 * 
 * @author rahul.patil
 */
public interface TestCaseConstants extends CommonConstants {
	static final String TAB_REQUIREMENTS = "Requirements";

	// Testcase state properties
	public static final String TESTCASE_STATE_NEW = "New";
	public static final String TESTCASE_STATE_OPEN = "Open";
	public static final String TESTCASE_STATE_ON_HOLD = "On Hold";
	public static final String TESTCASE_STATE_REJECTED = "Rejected";
	public static final String TESTCASE_STATE_CLOSED = "Closed";
	public static final String TESTCASE_STATE_IN_PROGRESS = "In Progress";

	// Testcase state properties
	public static final String TESTSUITE_STATE_NEW = "New";
	public static final String TESTSUITE_STATE_OPEN = "Open";
	public static final String TESTSUITE_STATE_ON_HOLD = "On Hold";
	public static final String TESTSUITE_STATE_REJECTED = "Rejected";
	public static final String TESTSUITE_STATE_IN_PROGRESS = "In Progress";

	// Flaky score state properties
	public static final String TESTCASE_LOW_FS = "Low (Between 0 to .40)";
	public static final String TESTCASE_MEDIUM_FS = "Medium (Between .41 to .80)";
	public static final String TESTCASE_HIGH_FS = "High (Between .81 to 1)";

	// Success rate state properties
	public static final String TESTCASE_LOW_SR = "Low (Between 0 to 50 %)";
	public static final String TESTCASE_MEDIUM_SR = "Medium (Between 51 to 80 %)";
	public static final String TESTCASE_HIGH_SR = "High (Between 81 to 100 %)";

	public static final String TESTCASE_RUN_STATUS_PASSED = "Passed";
	public static final String TESTCASE_RUN_STATUS_FAILED = "Failed";
	public static final String TESTCASE_RUN_STATUS_BLOCKED = "Blocked";
	public static final String TESTCASE_RUN_STATUS_NOT_APPLICABLE = "Not Applicable";

	// Custom Verification Messages for report
	static final String TESTCASE_CREATE_SUCCESS = "Testcase created successfully.";
	static final String TESTCASE_CREATE_FAILED = "Testcase could not be created successfully.";
	static final String TESTCASE_ARCHIVE_SUCCESS = "Testcase archived successfully";
	static final String TESTCASE_ARCHIVE_FAILED = "Testcase could not be archived successfully";
	static final String TESTCASE_UNARCHIVE_SUCCESS = "Testcase unarchived successfully";
	static final String TESTCASE_UNARCHIVE_FAILED = "Testcase could not be unarchived successfully";
	static final String TESTCASE_DELETE_SUCCESS = "Testcase deleted successfully";
	static final String TESTCASE_DELETE_FAILED = "Testcase could not be deleted successfully";
	static final String TESTCASE_FOLDER_CREATE_SUCCESS = "Testcase folder created successfully.";
	static final String TESTCASE_FOLDER_CREATE_FAILED = "Testcase folder could not be created successfully.";
	static final String TESTCASE_IMPORT_SUCCESS = "Testcase imported successfully.";
	static final String TESTCASE_IMPORT_FAILED = "Testcase could not be imported successfully.";
	static final String TESTCASE_FOLDER_EDIT_SUCCESS = "Testcase folder edited successfully.";
	static final String TESTCASE_FOLDER_EDIT_FAILED = "Testcase folder could not be edited successfully.";
	static final String TESTCASE_FOLDER_ARCHIVE_SUCCESS = "Testcase folder archived successfully.";
	static final String TESTCASE_FOLDER_ARCHIVE_FAILED = "Testcase folder could not be archived successfully.";
	static final String TESTCASE_FOLDER_DELETE_SUCCESS = "Testcase folder deleted successfully.";
	static final String TESTCASE_FOLDER_DELETE_FAILED = "Testcase folder could not be deleted successfully.";

	static final String TESTCASE_MODULE_QUERY_RECORD_SUCCESS = "Testcase module query record verified successfully.";
	static final String TESTCASE_MODULE_QUERY_RECORD_FAILED = "Testcase module query record could not be verified successfully.";

	static final String LINK_REQUIREMENT_TO_TESTCASE_SUCCESS = "Requirement successfully linked to test case";
	static final String LINK_REQUIREMENT_TO_TESTCASE_FAILED = "Requirement could not be linked to test case";

	static final String TESTCASE_BULK_COPY_SUCCESS = "Testcase bulk copy operation performed successfully.";
	static final String TESTCASE_BULK_COPY_FAILED = "Testcase bulk copy operation could not be performed successfully.";
	static final String TESTCASE_BULK_MOVE_SUCCESS = "Testcase bulk move operation performed successfully.";
	static final String TESTCASE_BULK_MOVE_FAILED = "Testcase bulk move operation could not be performed successfully.";

	static final String TESTCASE_BULK_ARCHIVE_SUCCESS = "Testcase bulk archive operation performed successfully.";
	static final String TESTCASE_BULK_ARCHIVE_FAILED = "Testcase bulk archive operation could not be performed successfully.";
	static final String TESTCASE_BULK_UNARCHIVE_SUCCESS = "Testcase bulk unarchive operation performed successfully.";
	static final String TESTCASE_BULK_UNARCHIVE_FAILED = "Testcase bulk unarchive operation could not be performed successfully.";
	static final String TESTCASE_BULK_DELETE_SUCCESS = "Testcase bulk delete operation performed successfully.";
	static final String TESTCASE_BULK_DELETE_FAILED = "Testcase bulk delete operation could not be performed successfully.";
	static final String TESTCASE_BULK_EDIT_SUCCESS = "Testcase Bulk edit operation performed successfully";
	static final String TESTCASE_BULK_EDIT_FAILED = "Testcase Bulk edit operation not performed successfully";
	static final String TESTCASE_FOLDER_BULK_ARCHIVED_SUCCESS = "Testcase folder Bulk archived operation performed successfully";
	static final String TESTCASE_FOLDER_BULK_ARCHIVED_FAILED = "Testcase folder Bulk archived operation not performed successfully";
	static final String TESTCASE_FOLDER_BULK_UNARCHIVED_SUCCESS = "Testcase folder Bulk unarchived operation performed successfully";
	static final String TESTCASE_FOLDER_BULK_UNARCHIVED_FAILED = "Testcase folder Bulk unarchived operation not performed successfully";

	static final String TESTCASE_ADD_ASSOCIATION_SUCCESS = "Testcase add release cycle association operation performed successfully";
	static final String TESTCASE_ADD_ASSOCIATION_FAILED = "Testcase add release cycle association operation not performed successfully";
	static final String TESTCASE_REMOVE_ASSOCIATION_SUCCESS = "Testcase remove release cycle association operation performed successfully";
	static final String TESTCASE_REMOVE_ASSOCIATION_FAILED = "Testcase remove release cycle association operation not performed successfully";

	static final String TESTCASE_ADD_COMMENT_SUCCESS = "Testcase add comment operation performed successfully";
	static final String TESTCASE_ADD_COMMENT_FAILED = "Testcase add comment operation not performed successfully";
	static final String TESTCASE_UPDATE_COMMENT_SUCCESS = "Testcase update comment operation performed successfully";
	static final String TESTCASE_UPDATE_COMMENT_FAILED = "Testcase update comment operation not performed successfully";

	static final String TESTCASE_ADD_ATTACHMENT_SUCCESS = "Testcase add attachment operation performed successfully";
	static final String TESTCASE_ADD_ATTACHMENT_FAILED = "Testcase add attachment operation not performed successfully";
	static final String TESTCASE_DELETE_ATTACHMENT_SUCCESS = "Testcase delete attachment operation performed successfully";
	static final String TESTCASE_DELETE_ATTACHMENT_FAILED = "Testcase delete attachment operation not performed successfully";

	static final String TESTCASE_VERSION_ARCHIVE_SUCCESS = "Testcase version archived successfully";
	static final String TESTCASE_VERSION_ARCHIVE_FAILED = "Testcase version could not be archived successfully";
	static final String TESTCASE_VERSION_UNARCHIVE_SUCCESS = "Testcase version archived successfully";
	static final String TESTCASE_VERSION_UNARCHIVE_FAILED = "Testcase version could not be archived successfully";

	static final String TESTCASE_CREATE_TEST_SUITE_FROM_TEST_CASE_SUCCESS = "Create test suite from test case operation performed successfully.";
	static final String TESTCASE_CREATE_TEST_SUITE_FROM_TEST_CASE_FAILED = "Create test suite from test case operation could not be performed successfully.";

	static final String UNLINK_REQUIREMENT_FROM_TESTCASE_SUCCESS = "Requirement successfully unlinked from Testcase";
	static final String UNLINK_REQUIREMENT_FROM_TESTCASE_FAILED = "Requirement could not be unlinked from Testcase";

	static final String LINK_TESTSUITE_TO_TESTCASE_SUCCESS = "Testsuite successfully linked to test case";
	static final String LINK_TESTSUITE_TO_TESTCASE_FAILED = "Testsuite could not be linked to test case";

	static final String DETAIL_WINDOW_FIELD_VALUE_SUCCESS = "Detail window has proper value for provided field.";
	static final String DETAIL_WINDOW_FIELD_VALUE_FAILED = "Detail window doesn't have proper value for provided field.";

	static final String ARRANGE_COLUMN_ENABLE_FOR_TC_SUCCESS = "Testcase list columns enabled successfully.";
	static final String ARRANGE_COLUMN_ENABLE_FOR_TC_FAILED = "Testcase list columns not enabled successfully";
	static final String ARRANGE_COLUMN_DISABLE_FOR_TC_SUCCESS = "Testcase list columns disabled successfully.";
	static final String ARRANGE_COLUMN_DISABLE_FOR_TC_FAILED = "Testcase list columns not disabled successfully";

	static final String VERIFY_LINKED_ISSUES_TO_TESTCASE_SUCCESS = "Issues successfully linked to testcase.";
	static final String VERIFY_LINKED_ISSUES_TO_TESTCASE_FAILED = "Issues not successfully linked to testcase.";

	static final String TESTCASE_DELETE_COMMENT_SUCCESS = "Testcase delete comment operation performed successfully";
	static final String TESTCASE_DELETE_COMMENT_FAILED = "Testcase delete comment operation not performed successfully";

	static final String TESTCASE_UDF_VALUE_SUCCESS = "UDF values for testcase verified successfully.";
	static final String TESTCASE_UDF_VALUE_FAILED = "UDF values for testcase could not be verified successfully.";

	static final String TESTCASE_APPROVED_APPROVAL_STATUS_SUCCESS = "Approved approval status for requirement entity verified successfully.";
	static final String TESTCASE_APPROVED_APPROVAL_STATUS_FAILED = "Approved approval status for requirement entity could not be verified successfully.";

	static final String TESTCASE_PENDING_AT_LEVEL_1_APPROVAL_STATUS_SUCCESS = "Pending at level 1 approval status for requirement entity verified successfully.";
	static final String TESTCASE_PENDING_AT_LEVEL_1_APPROVAL_STATUS_FAILED = "Pending at level 1 approval status for requirement entity could not be verified successfully.";

	static final String QMETRY_FILTER_TC_ENTITY_KEY_SUCCESS = "Qmetry filter applied successfully using testcase entity key.";
	static final String QMETRY_FILTER_TC_ENTITY_KEY_FAILED = "Qmetry filter is not applied successfully using testcase entity key.";

	static final String QMETRY_FILTER_TC_SUMMARY_SUCCESS = "Qmetry filter applied successfully using testcase summary.";
	static final String QMETRY_FILTER_TC_SUMMARY_FAILED = "Qmetry filter is not applied successfully using testcase summary.";

	static final String QMETRY_FILTER_STATUS_NEW_SUCCESS = "Qmetry filter applied successfully using testcase status new.";
	static final String QMETRY_FILTER_STATUS_NEW_FAILED = "Qmetry filter is not applied successfully using testcase status new.";
	static final String QMETRY_FILTER_STATUS_OPEN_SUCCESS = "Qmetry filter applied successfully using testcase status open.";
	static final String QMETRY_FILTER_STATUS_OPEN_FAILED = "Qmetry filter is not applied successfully using testcase status open.";
	static final String QMETRY_FILTER_STATUS_NEW_AND_OPEN_SUCCESS = "Qmetry filter applied successfully using both testcase status new and open.";
	static final String QMETRY_FILTER_STATUS_NEW_AND_OPEN_FAILED = "Qmetry filter is not applied successfully using both testcase status new and open.";

	static final String QMETRY_FILTER_OWNER1_SUCCESS = "Qmetry filter applied successfully using testcase owner1.";
	static final String QMETRY_FILTER_OWNER1_FAILED = "Qmetry filter is not applied successfully using testcase owner1.";
	static final String QMETRY_FILTER_OWNER2_SUCCESS = "Qmetry filter applied successfully using testcase owner2.";
	static final String QMETRY_FILTER_OWNER2_FAILED = "Qmetry filter is not applied successfully using testcase owner2.";
	static final String QMETRY_FILTER_OWNER1_AND_OWNER2_SUCCESS = "Qmetry filter applied successfully using both testcase owner1 and owner2.";
	static final String QMETRY_FILTER_OWNER1_AND_OWNER2_FAILED = "Qmetry filter is not applied successfully using both testcase owner1 and owner2.";
	static final String QMETRY_FILTER_STRING_UDF_SUCCESS = "Qmetry filter applied successfully using testcase string type UDF.";
	static final String QMETRY_FILTER_STRING_UDF_FAILED = "Qmetry filter is not applied successfully using testcase string type UDF.";
	static final String QMETRY_FILTER_LOOKUPLIST_UDF_SUCCESS = "Qmetry filter applied successfully using testcase lookup list type UDF.";
	static final String QMETRY_FILTER_LOOKUPLIST_UDF_FAILED = "Qmetry filter is not applied successfully using testcase lookup list type UDF.";

	static final String QMETRY_FILTER_PRIORITY_MINOR_SUCCESS = "Qmetry filter applied successfully for testcase priority minor.";
	static final String QMETRY_FILTER_PRIORITY_MINOR_FAILED = "Qmetry filter is not applied successfully for testcase priority minor.";
	static final String QMETRY_FILTER_PRIORITY_MAJOR_SUCCESS = "Qmetry filter applied successfully for testcase priority major.";
	static final String QMETRY_FILTER_PRIORITY_MAJOR_FAILED = "Qmetry filter is not applied successfully for testcase priority major.";
	static final String QMETRY_FILTER_PRIORITY_MINOR_AND_MAJOR_SUCCESS = "Qmetry filter applied successfully for both testcase priority minor and major.";
	static final String QMETRY_FILTER_PRIORITY_MINOR_AND_MAJOR_FAILED = "Qmetry filter is not applied successfully for both testcase priority minor and major.";

	static final String SORTING_TC_COLUMN_VALUES_IN_ASC_SUCCESS = "Testcase column values sorted in ascending order.";
	static final String SORTING_TC_COLUMN_VALUES_IN_ASC_FAILED = "Testcase column values not sorted in ascending order.";
	static final String SORTING_TC_COLUMN_VALUES_IN_DESC_SUCCESS = "Testcase column values sorted in descending order.";
	static final String SORTING_TC_COLUMN_VALUES_IN_DESC_FAILED = "Testcase column values not sorted in descending order.";

	static final String TESTCASE_TESTRUN_BUILD_VERIFY_SUCCESS = "Testcase testrun build verified successfully.";
	static final String TESTCASE_TESTRUN_BUILD_VERIFY_FAILED = "Testcase testrun build could not be  verified successfully.";

	// Testcase priority properties
	public static final String TESTCASE_PRIORITY_BLOCKER = "Blocker";
	public static final String TESTCASE_PRIORITY_CRITICAL = "Critical";
	public static final String TESTCASE_PRIORITY_MAJOR = "Major";
	public static final String TESTCASE_PRIORITY_MINOR = "Minor";
	public static final String TESTCASE_PRIORITY_TRIVIAL = "Trivial";

	// Data field name
	static final String DATA_FIELD_NEW_VALUE = "newValue";
	static final String DATA_FIELD_NAME_ACTOR = "actor";
	static final String DATA_FIELD_NAME_ACTION = "action";
	static final String DATA_FIELD_NAME_ACTIVITY = "activity";

	// Message
	static final String CHANGE_LOG_UPDATED_UDF_MESSAGE = "Entity Steps Updated Successfully.";
	static final String AUDIT_LOG_TC_UPDATED_MESSAGE = "Test Case(s) was updated.";

	static final String EXPORT_TEST_CASE_DETAILS_AS_PDF = "Export Test Case Details as PDF";
	static final String EXPORT_TEST_CASE_DETAILS_AS_WORD = "Export Test Case Details as Word";

	ArrayList<String> sharableTestcaseDetailsWindowTabs = new ArrayList<>(
			Arrays.asList("Steps", "Test Cases", "Version", "Comments", "Change Log", "Combined View"));

	ArrayList<String> testStepDropdownMenu = new ArrayList<>(
			Arrays.asList("Insert Row", "Insert Shareable Test Case", "Remove Row", "Duplicate Row"));

	ArrayList<String> dataParameterCogDropdownMenu = new ArrayList<>(
			Arrays.asList("Create DataGrid", "Import", "Export", "Archive", "Unarchive"));

	ArrayList<String> flakyScoreDropDownValues = new ArrayList<>(
			Arrays.asList("High (Between .81 to 1)", "Low (Between 0 to .40)", "Medium (Between .41 to .80)"));

	ArrayList<String> successRateDropDownValues = new ArrayList<>(
			Arrays.asList("High (Between 81 to 100 %)", "Low (Between 0 to 50 %)", "Medium (Between 51 to 80 %)"));
}