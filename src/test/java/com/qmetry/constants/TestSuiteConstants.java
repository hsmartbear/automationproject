package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines TestSuiteConstants.
 * 
 * @author rahul.patil
 */
public interface TestSuiteConstants extends CommonConstants {

        // Custom Verification Messages for report
        static final String TESTSUITE_CREATE_SUCCESS = "TestSuite created successfully.";
        static final String TESTSUITE_CREATE_FAILED = "TestSuite could not be created successfully.";
        static final String TESTSUITE_ARCHIVE_SUCCESS = "TestSuite archived successfully";
        static final String TESTSUITE_ARCHIVE_FAILED = "TestSuite could not be archived successfully";
        static final String TESTSUITE_UNARCHIVE_SUCCESS = "TestSuite unarchived successfully";
        static final String TESTSUITE_UNARCHIVE_FAILED = "TestSuite could not be unarchived successfully";
        static final String TESTSUITE_DELETE_SUCCESS = "TestSuite deleted successfully";
        static final String TESTSUITE_DELETE_FAILED = "TestSuite could not be deleted successfully";

        static final String TESTSUITE_FOLDER_CREATE_SUCCESS = "TestSuite folder created successfully.";
        static final String TESTSUITE_FOLDER_CREATE_FAILED = "TestSuite folder could not be created successfully.";
        static final String TESTSUITE_FOLDER_EDIT_SUCCESS = "TestSuite folder edited successfully.";
        static final String TESTSUITE_FOLDER_EDIT_FAILED = "TestSuite folder could not be edited successfully.";
        static final String TESTSUITE_FOLDER_ARCHIVE_SUCCESS = "TestSuite folder archived successfully.";
        static final String TESTSUITE_FOLDER_ARCHIVE_FAILED = "TestSuite folder could not be archived successfully.";
        static final String TESTSUITE_FOLDER_DELETE_SUCCESS = "TestSuite folder deleted successfully.";
        static final String TESTSUITE_FOLDER_DELETE_FAILED = "TestSuite folder could not be deleted successfully.";

        static final String TESTSUITE_SUMMARY_EDIT_SUCCESS = "TestSuite summary edited successfully.";
        static final String TESTSUITE_SUMMARY_EDIT_FAILED = "TestSuite summary could not be edited successfully.";

        static final String ARRANGE_COLUMN_ENABLE_FOR_TS_SUCCESS = "TestSuite list columns enabled successfully.";
        static final String ARRANGE_COLUMN_ENABLE_FOR_TS_FAILED = "TestSuite list columns not enabled successfully";
        static final String ARRANGE_COLUMN_DISABLE_FOR_TS_SUCCESS = "TestSuite list columns disabled successfully.";
        static final String ARRANGE_COLUMN_DISABLE_FOR_TS_FAILED = "TestSuite list columns not disabled successfully";

        static final String SORTING_TS_COLUMN_VALUES_IN_ASC_SUCCESS = "TestSuite column values sorted in ascending order.";
        static final String SORTING_TS_COLUMN_VALUES_IN_ASC_FAILED = "TestSuite column values not sorted in ascending order.";
        static final String SORTING_TS_COLUMN_VALUES_IN_DESC_SUCCESS = "TestSuite column values sorted in descending order.";
        static final String SORTING_TS_COLUMN_VALUES_IN_DESC_FAILED = "TestSuite column values not sorted in descending order.";

        static final String CLONE_FOLDER_STRUCTURE_TS_TO_TC_MODULE_SUCCESS = "Folder structure successfully cloned from testsuite to testcase module.";
        static final String CLONE_FOLDER_STRUCTURE_TS_TO_TC_MODULE_FAILED = "Folder structure could not be able to successfully cloned from testsuite to testcase module.";

        static final String CLONE_FOLDER_STRUCTURE_TS_TO_RQ_MODULE_SUCCESS = "Folder structure successfully cloned from testsuite to requirement module.";
        static final String CLONE_FOLDER_STRUCTURE_TS_TO_RQ_MODULE_FAILED = "Folder structure could not be able to successfully cloned from testsuite to requirement module.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_SUCCESS = "Qmetry filter applied successfully for testsuite priority minor.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_FAILED = "Qmetry filter is not applied successfully for testsuite priority minor.";
        static final String QMETRY_FILTER_PRIORITY_MAJOR_SUCCESS = "Qmetry filter applied successfully for testsuite priority major.";
        static final String QMETRY_FILTER_PRIORITY_MAJOR_FAILED = "Qmetry filter is not applied successfully for testsuite priority major.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_AND_MAJOR_SUCCESS = "Qmetry filter applied successfully for both testsuite priority minor and major.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_AND_MAJOR_FAILED = "Qmetry filter is not applied successfully for both testsuite priority minor and major.";

        static final String TESTSUITE_EXECUTION_LINKED_TESTCASE_SUCCESS = "Test suite execution contains linked testcases to test suite";
        static final String TESTSUITE_EXECUTION_LINKED_TESTCASE_FAILED = "Test suite execution does not contains linked testcases to test suite";

        static final String TESTSUITE_EXECUTION_ASSIGN_TESTER_SUCCESS = "Tester successfully assigned to test suite execution";
        static final String TESTSUITE_EXECUTION_ASSIGN_TESTER_FAILED = "Tester could not be successfully assigned to test suite execution";

        static final String TESTCASE_EXECUTION_ASSIGN_STATUS_SUCCESS = "Status successfully assigned to test case execution";
        static final String TESTCASE_EXECUTION_ASSIGN_STATUS_FAILED = "Status could not be successfully assigned to test case execution";

        static final String LINK_TESTCASE_TO_TESTSUITE_SUCCESS = "Testcase successfully linked to testsuite";
        static final String LINK_TESTCASE_TO_TESTSUITE_FAILED = "Testcase could not be linked to testsuite";

        static final String UNLINK_TESTCASE_FROM_TESTSUITE_SUCCESS = "Testcase successfully unlinked from testsuite";
        static final String UNLINK_TESTCASE_FROM_TESTSUITE_FAILED = "Testcase could not be unlinked from testsuite";

        static final String LINK_PLATFORM_TO_TESTSUITE_SUCCESS = "Platform successfully linked to testsuite";
        static final String LINK_PLATFORM_TO_TESTSUITE_FAILED = "Platform could not be linked to testsuite";

        static final String TESTSUITE_ADD_ASSOCIATION_SUCCESS = "Testsuite add release cycle association operation performed successfully";
        static final String TESTSUITE_ADD_ASSOCIATION_FAILED = "Testsuite add release cycle association operation not performed successfully";
        static final String TESTSUITE_REMOVE_ASSOCIATION_SUCCESS = "Testsuite remove release cycle association operation performed successfully";
        static final String TESTSUITE_REMOVE_ASSOCIATION_FAILED = "Testsuite remove release cycle association operation not performed successfully";

        static final String TESTSUITE_ADD_COMMENT_SUCCESS = "Testsuite add comment operation performed successfully";
        static final String TESTSUITE_ADD_COMMENT_FAILED = "Testsuite add comment operation not performed successfully";
        static final String TESTSUITE_UPDATE_COMMENT_SUCCESS = "Testsuite update comment operation performed successfully";
        static final String TESTSUITE_UPDATE_COMMENT_FAILED = "Testsuite update comment operation not performed successfully";
        static final String TESTSUITE_DELETE_COMMENT_SUCCESS = "Testsuite delete comment operation performed successfully";
        static final String TESTSUITE_DELETE_COMMENT_FAILED = "Testsuite delete comment operation not performed successfully";

        static final String TESTSUITE_ADD_ATTACHMENT_SUCCESS = "Testsuite add attachment operation performed successfully";
        static final String TESTSUITE_ADD_ATTACHMENT_FAILED = "Testsuite add attachment operation not performed successfully";
        static final String TESTSUITE_DELETE_ATTACHMENT_SUCCESS = "Testsuite delete attachment operation performed successfully";
        static final String TESTSUITE_DELETE_ATTACHMENT_FAILED = "Testsuite delete attachment operation not performed successfully";

        static final String TESTSUITE_BULK_COPY_SUCCESS = "Testcase bulk copy operation performed successfully.";
        static final String TESTSUITE_BULK_COPY_FAILED = "Testcase bulk copy operation could not be performed successfully.";
        static final String TESTSUITE_BULK_MOVE_SUCCESS = "Testcase bulk move operation performed successfully.";
        static final String TESTSUITE_BULK_MOVE_FAILED = "Testcase bulk move operation could not be performed successfully.";

        static final String TESTSUITE_BULK_ARCHIVE_SUCCESS = "Testsuite bulk archive operation performed successfully.";
        static final String TESTSUITE_BULK_ARCHIVE_FAILED = "Testsuite bulk archive operation could not be performed successfully.";
        static final String TESTSUITE_BULK_UNARCHIVE_SUCCESS = "Testsuite bulk unarchive operation performed successfully.";
        static final String TESTSUITE_BULK_UNARCHIVE_FAILED = "Testsuite bulk unarchive operation could not be performed successfully.";
        static final String TESTSUITE_BULK_DELETE_SUCCESS = "Testsuite bulk delete operation performed successfully.";
        static final String TESTSUITE_BULK_DELETE_FAILED = "Testsuite bulk delete operation could not be performed successfully.";
        static final String TESTSUITE_BULK_EDIT_SUCCESS = "Testsuite Bulk edit operation performed successfully";
        static final String TESTSUITE_BULK_EDIT_FAILED = "Testsuite Bulk edit operation not performed successfully";
        static final String TESTSUITE_FOLDER_BULK_ARCHIVED_SUCCESS = "Testsuite folder Bulk archived operation performed successfully";
        static final String TESTSUITE_FOLDER_BULK_ARCHIVED_FAILED = "Testsuite folder Bulk archived operation not performed successfully";
        static final String TESTSUITE_FOLDER_BULK_UNARCHIVED_SUCCESS = "Testsuite folder Bulk unarchived operation performed successfully";
        static final String TESTSUITE_FOLDER_BULK_UNARCHIVED_FAILED = "Testsuite folder Bulk unarchived operation not performed successfully";

        static final String TEST_RESULT_LOG_SUCCESS = "Test result log verified successfully";
        static final String TEST_RESULT_LOG_FAILED = "Test result log could not be verified successfully";

        static final String CHANGE_LOG_SUCCESS = "Change log verified successfully";
        static final String CHANGE_LOG_FAILED = "Change log could not be verified successfully";

        static final String LINK_ISSUE_TO_TEST_RUN_SUCCESS = "Issue successfully linked to test run.";
        static final String LINK_ISSUE_TO_TEST_RUN_FAILED = "Issue could not be successfully linked to test run.";

        static final String BULK_ASSIGN_ISSUE_TO_TEST_RUN_SUCCESS = "Bulk assign issue to test run operation performed successfully.";
        static final String BULK_ASSIGN_ISSUE_TO_TEST_RUN_FAILED = "Bulk assign issue to test run operation could not be performed successfully.";

        static final String BULK_UPDATE_ASSIGNEE_TO_TEST_RUN_SUCCESS = "Bulk assignee update to test run operation performed successfully.";
        static final String BULK_UPDATE_ASSIGNEE_TO_TEST_RUN_FAILED = "Bulk assignee update to test run operation could not be performed successfully.";

        static final String BULK_ASSIGN_EXECUTION_TYPE_TO_TEST_RUN_SUCCESS = "Bulk assign execution type to test run operation performed successfully.";
        static final String BULK_ASSIGN_EXECUTION_TYPE_TO_TEST_RUN_FAILED = "Bulk assign execution type to test run operation could not be performed successfully.";

        static final String TESTRUN_QMETRY_FILTER_STATUS_PASSED_SUCCESS = "Test run Qmetry filter applied successfully for test run status passed.";
        static final String TESTRUN_QMETRY_FILTER_STATUS_PASSED_FAILED = "Test run Qmetry filter is not applied successfully for test run status passed.";
        static final String TESTRUN_QMETRY_FILTER_STATUS_NOT_RUN_SUCCESS = "Test run Qmetry filter applied successfully for test run status not run.";
        static final String TESTRUN_QMETRY_FILTER_STATUS_NOT_RUN_FAILED = "Test run Qmetry filter is not applied successfully for test run status not run.";
        static final String TESTRUN_QMETRY_FILTER_STATUS_PASSED_AND_NOT_RUN_SUCCESS = "Test run Qmetry filter applied successfully for both test run status passed and not run.";
        static final String TESTRUN_QMETRY_FILTER_STATUS_PASSED_AND_NOT_RUN_FAILED = "Test run Qmetry filter is not applied successfully for both test run status passed and not run.";

        static final String BULK_EXECUTE_BY_EXECUTION_STATUS_SUCCESS = "Bulk execute by execution status operation performed successfully.";
        static final String BULK_EXECUTE_BY_EXECUTION_STATUS_FAILED = "Bulk execute by execution status operation could not be performed successfully.";

        static final String TEST_RUN_VERSION_SUCCESS = "Test case run is present in execution with required version.";
        static final String TEST_RUN_VERSION_FAILED = "Test case run is not present in execution with required version.";

        static final String EXPAND_STEP_OF_TEST_RUN_SUCCESS = "Expand step of test step run operation performed successfully.";
        static final String EXPAND_STEP_OF_TEST_RUN_FAILED = "Expand step of test step run operation could not be performed successfully.";

        static final String ASSIGN_BUILD_TO_TEST_RUN_SUCCESS = "Assign build to test run operation performed successfully.";
        static final String ASSIGN_BUILD_TO_TEST_RUN_FAILED = "Assign build to test run operation could not be performed successfully.";

        static final String TESTSUITE_UDF_VALUE_SUCCESS = "UDF values for test suite verified successfully.";
        static final String TESTSUITE_UDF_VALUE_FAILED = "UDF values for test suite could not be verified successfully.";

        static final String TESTSUITE_APPROVED_APPROVAL_STATUS_SUCCESS = "Approved approval status for Testsuite entity verified successfully.";
        static final String TESTSUITE_APPROVED_APPROVAL_STATUS_FAILED = "Approved approval status for Testsuite entity could not be verified successfully.";

        static final String TESTSUITE_IN_REVIEW_APPROVAL_STATUS_SUCCESS = "In review approval status for Testsuite entity verified successfully.";
        static final String TESTSUITE_IN_REVIEW_APPROVAL_STATUS_FAILED = "In review status for Testsuite entity could not be verified successfully.";

        static final String QMETRY_FILTER_TS_ENTITY_KEY_SUCCESS = "Qmetry filter applied successfully using testsuite entity key.";
        static final String QMETRY_FILTER_TS_ENTITY_KEY_FAILED = "Qmetry filter is not applied successfully using testsuite entity key.";

        static final String QMETRY_FILTER_TS_SUMMARY_SUCCESS = "Qmetry filter applied successfully using testsuite summary.";
        static final String QMETRY_FILTER_TS_SUMMARY_FAILED = "Qmetry filter is not applied successfully using testsuite summary.";

        static final String QMETRY_FILTER_OWNER1_SUCCESS = "Qmetry filter applied successfully using testsuite owner1.";
        static final String QMETRY_FILTER_OWNER1_FAILED = "Qmetry filter is not applied successfully using testsuite owner1.";
        static final String QMETRY_FILTER_OWNER2_SUCCESS = "Qmetry filter applied successfully using testsuite owner2.";
        static final String QMETRY_FILTER_OWNER2_FAILED = "Qmetry filter is not applied successfully using testsuite owner2.";
        static final String QMETRY_FILTER_OWNER1_AND_OWNER2_SUCCESS = "Qmetry filter applied successfully using both testsuite owner1 and owner2.";
        static final String QMETRY_FILTER_OWNER1_AND_OWNER2_FAILED = "Qmetry filter is not applied successfully using both testsuite owner1 and owner2.";

        static final String QMETRY_FILTER_STRING_UDF_SUCCESS = "Qmetry filter applied successfully using testsuite string type UDF.";
        static final String QMETRY_FILTER_STRING_UDF_FAILED = "Qmetry filter is not applied successfully using testsuite string type UDF.";
        static final String QMETRY_FILTER_LOOKUPLIST_UDF_SUCCESS = "Qmetry filter applied successfully using testsuite lookup list type UDF.";
        static final String QMETRY_FILTER_LOOKUPLIST_UDF_FAILED = "Qmetry filter is not applied successfully using testsuite lookup list type UDF.";

        static final String LINK_ATTACHMENT_TO_TEST_STEP_SUCCESS = "Attachment successfully linked to test step.";
        static final String LINK_ATTACHMENT_TO_TEST_STEP_SUCCESS_FAILED = "Attachment could not be successfully linked to test step.";

        static final String UNLINK_ATTACHMENT_TO_TEST_STEP_SUCCESS = "Attachment successfully Unlinked to test step.";
        static final String UNLINK_ATTACHMENT_TO_TEST_STEP_SUCCESS_FAILED = "Attachment could not be successfully Unlinked to test step.";

        static final String COLUMN_NAME_VERIFICATION_SUCCESS = "column Names Verified successfully";
        static final String COLUMN_NAME_VERIFICATION_FAILED = "column Names Verified not successfully";

        // Testsuite status properties
        public static final String TESTSUITE_STATUS_NEW = "New";
        public static final String TESTSUITE_STATUS_OPEN = "Open";

        // Execution status properties
        public static final String EXECUTION_STATUS_PASSED = "Passed";
        public static final String EXECUTION_STATUS_NOT_RUN = "Not Run";
        public static final String EXECUTION_STATUS_FAILED = "Failed";
        public static final String EXECUTION_STATUS_NOT_APPLICABLE = "Not Applicable";
        public static final String EXECUTION_STATUS_BLOCKED = "Blocked";

        // Detail window tabs
        static final String TAB_TEST_CASES = "Test Cases";
        static final String TAB_PLATFORMS = "Platforms";

        // Message
        static final String CHANGE_LOG_TESTER_ASSIGNED_MESSAGE = "Tester Assigned Successfully.";
        static final String TEST_EXECUTION_UPDATE_MESSAGE = "Test Execution Update is scheduled to run in background. Go to \"Scheduled Task\" to track the process.";
        static final String ACTUAL_OUTCOME_UPDATED_MESSAGE = "Step 1 Actual Outcome Updated Successfully.";
        static final String COMMENT_UPDATED_MESSAGE = "Step 1 Comment Updated Successfully.";
        static final String ISSUE_LINK_MESSAGE = "Issues Linked Successfully at Step 1.";
        static final String ISSUE_UNLINK_MESSAGE = "Issues Unlinked Successfully at Step 1.";
        static final String ATTACHMENT_LINK_MESSAGE = "Attachment Linked Successfully at Step 1.";
        static final String ATTACHMENT_UNLINK_MESSAGE = "Attachment Unlinked Successfully at Step 1.";
        static final String MAX_NO_OF_SELECTED_RECORED_ERROR_MSG = "Maximum number of selected records is 5";

        // Execution type properties
        public static final String EXECUTION_TYPE_MANUAL = "Manual";
        public static final String EXECUTION_TYPE_AUTOMATED = "Automated";

        public static final String DEFAULT_NO_PLATFORM = "No Platform";
        public static final String BUILD_VALUE_TO_NONE = "None";

        static final String LINK_ATLEAST_ONE_TC_ERROR_MSG = "Please link at least one Test Case before executing.";
        static final String BUILD_NOTE_MSG = "Select Test Case(s) to set build for Test Case(s). Not selecting any Test Case(s) will set build for this Test Suite Run only.";

        // text verify
        static final String ISSUE_LINKED_TXT = "Issue Linked";
        static final String ISSUE_UNLINKED_TXT = "Issue Unlinked";
        static final String ATTCHMENT_UNLINKED_TXT = "Attachment Unlinked";
        public static final String ATTACHMENT_LINKED_TXT = "Attachment Linked";

        ArrayList<String> defaultNonEditableCheckedColumnsLinkTestcaseModel = new ArrayList<>(
                        Arrays.asList("Entity Key", "Summary"));

        ArrayList<String> defaultCheckedColumnsLinkTestcaseModel = new ArrayList<>(Arrays.asList("Version", "Priority",
                        "Label(s)", "Release(s)", "Cycle(s)", "Test Category", "Testing Type", "Attachments"));

        ArrayList<String> defaultNonEditableCheckedColumnsLinkTestsuiteModel = new ArrayList<>(
                        Arrays.asList("Entity Key", "Summary"));

        ArrayList<String> defaultCheckedColumnsLinkTestsuiteModel = new ArrayList<>(
                        Arrays.asList("Status", "Platforms", "Created On", "Attachments"));

        ArrayList<String> defaultNonEditableCheckedTestCaseColumnFieldsToBulkExportTestcase = new ArrayList<>(
                        Arrays.asList("Summary"));

        ArrayList<String> defaultEditableCheckedTestCaseColumnFieldsToBulkExportTestcase = new ArrayList<>(
                        Arrays.asList("Associated Release(s)/Cycle(s)", "Label(s)", "Created On", "Description",
                                        "Estimated Time (mins)", "Priority", "Test Case Owner", "Status",
                                        "Test Category", "Testing Type", "Updated On"));

        ArrayList<String> defaultEditableCheckedTestStepColumnFieldsToBulkExportTestcase = new ArrayList<>(
                        Arrays.asList("Step Description", "Step Expected Outcome", "Step Input Data"));

}