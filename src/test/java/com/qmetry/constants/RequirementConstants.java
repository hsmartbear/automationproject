package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines RequirementConstants.
 * 
 * @author rahul.patil
 */
public interface RequirementConstants extends CommonConstants {

        static final String TAB_TEST_CASES = "Test Cases";

        // Requirement state properties
        public static final String REQUIREMENT_STATE_NEW = "New";
        public static final String REQUIREMENT_STATE_OPEN = "Open";
        public static final String REQUIREMENT_STATE_ON_HOLD = "On Hold";
        public static final String REQUIREMENT_STATE_REJECTED = "Rejected";
        public static final String REQUIREMENT_STATE_APPROVED = "Approved";
        public static final String REQUIREMENT_STATE_IN_PROGRESS = "In Progress";

        // Alert message
        static final String PULL_DATA_NOTIFICATION_MESSAGE = "File data pulled successfully.";
        static final String PUSH_DATA_NOTIFICATION_MESSAGE = "Data pushed successfully.";
        static final String FILE_NOT_FOUND_IN_REPOSITORY_MESSAGE = "File not found in repository.";
        static final String FAILED_TO_PUSH_DATA_MESSAGE = "Failed to push data.";
        static final String FAILED_TO_PUSH_DATA_DONT_HAVE_SUFFICIENT_RIGHTS_MESSAGE = "Push failed as you don't have sufficient rights.";

        // Custom Verification Messages for report
        static final String REQUIREMENT_CREATE_SUCCESS = "Requirement created successfully.";
        static final String REQUIREMENT_CREATE_FAILED = "Requirement could not be created successfully.";
        static final String REQUIREMENT_ARCHIVE_SUCCESS = "Requirement archived successfully";
        static final String REQUIREMENT_ARCHIVE_FAILED = "Requirement could not be archived successfully";
        static final String REQUIREMENT_UNARCHIVE_SUCCESS = "Requirement unarchived successfully";
        static final String REQUIREMENT_UNARCHIVE_FAILED = "Requirement could not be unarchived successfully";
        static final String REQUIREMENT_DELETE_SUCCESS = "Requirement deleted successfully";
        static final String REQUIREMENT_DELETE_FAILED = "Requirement could not be deleted successfully";
        static final String REQUIREMENT_FOLDER_CREATE_SUCCESS = "Requirement folder created successfully.";
        static final String REQUIREMENT_FOLDER_CREATE_FAILED = "Requirement folder could not be created successfully.";
        static final String REQUIREMENT_IMPORT_SUCCESS = "Requirement imported successfully.";
        static final String REQUIREMENT_IMPORT_FAILED = "Requirement could not be imported successfully.";

        static final String REQUIREMENT_FOLDER_EDIT_SUCCESS = "Requirement folder edited successfully.";
        static final String REQUIREMENT_FOLDER_EDIT_FAILED = "Requirement folder could not be edited successfully.";
        static final String REQUIREMENT_FOLDER_ARCHIVE_SUCCESS = "Requirement folder archived successfully.";
        static final String REQUIREMENT_FOLDER_ARCHIVE_FAILED = "Requirement folder could not be archived successfully.";
        static final String REQUIREMENT_FOLDER_DELETE_SUCCESS = "Requirement folder deleted successfully.";
        static final String REQUIREMENT_FOLDER_DELETE_FAILED = "Requirement folder could not be deleted successfully.";
        static final String REQUIREMENT_FOLDER_CLONE_TO_TESTCASE_SUCCESS = "Requirement folder cloned to Testcase successfully.";
        static final String REQUIREMENT_FOLDER_CLONE_TO_TESTCASE_FAILED = "Requirement folder could not be cloned to Testcase successfully.";
        static final String REQUIREMENT_FOLDER_CLONE_TO_TESTSUITE_SUCCESS = "Requirement folder cloned to Testsuite successfully.";
        static final String REQUIREMENT_FOLDER_CLONE_TO_TESTSUITE_FAILED = "Requirement folder could not be cloned to Testsuite successfully.";
        static final String REQUIREMENT_FOLDER_PRESENT = "Requirement folder is present";
        static final String REQUIREMENT_FOLDER_NOT_PRESENT = "Requirement folder is not present";
        static final String REQUIREMENT_EDIT_SUCCESS = "Requirement edited successfully.";
        static final String REQUIREMENT_EDIT_FAILED = "Requirement could not be edited successfully.";
        static final String ARRANGE_COLUMN_ENABLE_FOR_RQ_SUCCESS = "Requirement list columns enabled successfully.";
        static final String ARRANGE_COLUMN_ENABLE_FOR_RQ_FAILED = "Requirement list columns not enabled successfully";
        static final String ARRANGE_COLUMN_DISABLE_FOR_RQ_SUCCESS = "Requirement list columns disabled successfully.";
        static final String ARRANGE_COLUMN_DISABLE_FOR_RQ_FAILED = "Requirement list columns not disabled successfully";
        static final String SORTING_RQ_COLUMN_VALUES_IN_ASC_SUCCESS = "Requirement column values sorted in ascending order.";
        static final String SORTING_RQ_COLUMN_VALUES_IN_ASC_FAILED = "Requirement column values not sorted in ascending order.";
        static final String SORTING_RQ_COLUMN_VALUES_IN_DESC_SUCCESS = "Requirement column values sorted in descending order.";
        static final String SORTING_RQ_COLUMN_VALUES_IN_DESC_FAILED = "Requirement column values not sorted in descending order.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_SUCCESS = "Qmetry filter applied successfully for requirement priority minor.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_FAILED = "Qmetry filter is not applied successfully for requirement priority minor.";
        static final String QMETRY_FILTER_PRIORITY_MAJOR_SUCCESS = "Qmetry filter applied successfully for requirement priority major.";
        static final String QMETRY_FILTER_PRIORITY_MAJOR_FAILED = "Qmetry filter is not applied successfully for requirement priority major.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_AND_MAJOR_SUCCESS = "Qmetry filter applied successfully for both requirement priority minor and major.";
        static final String QMETRY_FILTER_PRIORITY_MINOR_AND_MAJOR_FAILED = "Qmetry filter is not applied successfully for both requirement priority minor and major.";
        static final String REQUIREMENT_BULK_COPY_SUCCESS = "Requirement bulk copy operation performed successfully.";
        static final String REQUIREMENT_BULK_COPY_FAILED = "Requirement bulk copy operation could not be performed successfully.";
        static final String REQUIREMENT_BULK_MOVE_SUCCESS = "Requirement bulk move operation performed successfully.";
        static final String REQUIREMENT_BULK_MOVE_FAILED = "Requirement bulk move operation could not be performed successfully.";

        static final String REQUIREMENT_BULK_ARCHIVE_SUCCESS = "Requirement bulk archive operation performed successfully.";
        static final String REQUIREMENT_BULK_ARCHIVE_FAILED = "Requirement bulk archive operation could not be performed successfully.";
        static final String REQUIREMENT_BULK_UNARCHIVE_SUCCESS = "Requirement bulk unarchive operation performed successfully.";
        static final String REQUIREMENT_BULK_UNARCHIVE_FAILED = "Requirement bulk unarchive operation could not be performed successfully.";
        static final String REQUIREMENT_BULK_DELETE_SUCCESS = "Requirement bulk delete operation performed successfully.";
        static final String REQUIREMENT_BULK_DELETE_FAILED = "Requirement bulk delete operation could not be performed successfully.";
        static final String REQUIREMENT_BULK_EDIT_SUCCESS = "Requirement Bulk edit operation performed successfully";
        static final String REQUIREMENT_BULK_EDIT_FAILED = "Requirement Bulk edit operation not performed successfully";
        static final String REQUIREMENT_FOLDER_BULK_ARCHIVED_SUCCESS = "Requirement folder Bulk archived operation performed successfully";
        static final String REQUIREMENT_FOLDER_BULK_ARCHIVED_FAILED = "Requirement folder Bulk archived operation not performed successfully";
        static final String REQUIREMENT_FOLDER_BULK_UNARCHIVED_SUCCESS = "Requirement folder Bulk unarchived operation performed successfully";
        static final String REQUIREMENT_FOLDER_BULK_UNARCHIVED_FAILED = "Requirement folder Bulk unarchived operation not performed successfully";
        static final String REQUIREMENT_ADD_ASSOCIATION_SUCCESS = "Requirement add release cycle association operation performed successfully";
        static final String REQUIREMENT_ADD_ASSOCIATION_FAILED = "RequireRequirement add release cycle association operation not performed successfully";
        static final String REQUIREMENT_REMOVE_ASSOCIATION_SUCCESS = "Requirement remove release cycle association operation performed successfully";
        static final String REQUIREMENT_REMOVE_ASSOCIATION_FAILED = "RequireRequirement remove release cycle association operation not performed successfully";
        static final String REQUIREMENT_ADD_COMMENT_SUCCESS = "Requirement add comment operation performed successfully";
        static final String REQUIREMENT_ADD_COMMENT_FAILED = "Requirement add comment operation not performed successfully";
        static final String REQUIREMENT_UPDATE_COMMENT_SUCCESS = "Requirement update comment operation performed successfully";
        static final String REQUIREMENT_UPDATE_COMMENT_FAILED = "Requirement update comment operation not performed successfully";
        static final String REQUIREMENT_DELETE_COMMENT_SUCCESS = "Requirement delete comment operation performed successfully";
        static final String REQUIREMENT_DELETE_COMMENT_FAILED = "Requirement delete comment operation not performed successfully";
        static final String REQUIREMENT_ADD_ATTACHMENT_SUCCESS = "Requirement add attachment operation performed successfully";
        static final String REQUIREMENT_ADD_ATTACHMENT_FAILED = "Requirement add attachment operation not performed successfully";
        static final String REQUIREMENT_DELETE_ATTACHMENT_SUCCESS = "Requirement delete attachment operation performed successfully";
        static final String REQUIREMENT_DELETE_ATTACHMENT_FAILED = "Requirement delete attachment operation not performed successfully";

        static final String REQUIREMENT_VERSION_ARCHIVE_SUCCESS = "Requirement version archived successfully";
        static final String REQUIREMENT_VERSION_ARCHIVE_FAILED = "Requirement version could not be archived successfully";
        static final String REQUIREMENT_VERSION_UNARCHIVE_SUCCESS = "Requirement version archived successfully";
        static final String REQUIREMENT_VERSION_UNARCHIVE_FAILED = "Requirement version could not be archived successfully";

        static final String LINK_ISSUE_TO_REQUIREMENT_SUCCESS = "Issue successfully linked to requirement";
        static final String LINK_ISSUE_TO_REQUIREMENT_FAILED = "Issue could not be linked to requirement";

        static final String UNLINK_ISSUE_FROM_REQUIREMENT_SUCCESS = "Issue successfully unlinked from requirement";
        static final String UNLINK_ISSUE_FROM_REQUIREMENT_FAILED = "Issue could not be unlinked from requirement";

        static final String LINK_TESTCASE_TO_REQUIREMENT_SUCCESS = "Testcase successfully linked to requirement";
        static final String LINK_TESTCASE_TO_REQUIREMENT_FAILED = "Testcase could not be linked to requirement";

        static final String UNLINK_TESTCASE_FROM_REQUIREMENT_SUCCESS = "Testcase successfully unlinked from requirement";
        static final String UNLINK_TESTCASE_FROM_REQUIREMENT_FAILED = "Testcase could not be unlinked from requirement";

        static final String PULL_REQUIREMENT_SUCCESS = "Pull operation performed successfully";
        static final String PULL_REQUIREMENT_FAILED = "Pull operation could not be performed successfully";

        static final String PUSH_REQUIREMENT_SUCCESS = "Push operation performed successfully";
        static final String PUSH_REQUIREMENT_FAILED = "Push operation could not be performed successfully";

        static final String TESTCASE_FILTER_PRIORITY_MINOR_SUCCESS = "Testcase filter applied successfully for testcase priority minor.";
        static final String TESTCASE_FILTER_PRIORITY_MINOR_FAILED = "Testcase filter is not applied successfully for testcase priority minor.";
        static final String TESTCASE_FILTER_PRIORITY_MAJOR_SUCCESS = "Testcase filter applied successfully for testcase priority major.";
        static final String TESTCASE_FILTER_PRIORITY_MAJOR_FAILED = "Testcase filter is not applied successfully for testcase priority major.";
        static final String TESTCASE_FILTER_PRIORITY_MINOR_AND_MAJOR_SUCCESS = "Testcase filter applied successfully for both testcase priority minor and major.";
        static final String TESTCASE_FILTER_PRIORITY_MINOR_AND_MAJOR_FAILED = "Testcase filter is not applied successfully for both testcase priority minor and major.";

        static final String TESTCASE_CREATE_TEST_SUITE_FROM_REQUIREMENT_SUCCESS = "Create test suite from requirement operation performed successfully.";
        static final String TESTCASE_CREATE_TEST_SUITE_FROM_REQUIREMENT_FAILED = "Create test suite from requirement operation could not be performed successfully.";

        static final String REQUIREMENT_UDF_VALUE_SUCCESS = "UDF values for requirement verified successfully.";
        static final String REQUIREMENT_UDF_VALUE_FAILED = "UDF values for requirement could not be verified successfully.";

        static final String REQUIREMENT_REVIEWED_APPROVAL_STATUS_SUCCESS = "Reviewed approval status for requirement entity verified successfully.";
        static final String REQUIREMENT_REVIEWED_APPROVAL_STATUS_FAILED = "Reviewed approval status for requirement entity could not be verified successfully.";

        static final String REQUIREMENT_PENDING_AT_LEVEL_1_APPROVAL_STATUS_SUCCESS = "Pending at level 1 approval status for requirement entity verified successfully.";
        static final String REQUIREMENT_PENDING_AT_LEVEL_1_APPROVAL_STATUS_FAILED = "Pending at level 1 approval status for requirement entity could not be verified successfully.";

        static final String QMETRY_FILTER_RQ_ENTITY_KEY_SUCCESS = "Qmetry filter applied successfully using requirement entity key.";
        static final String QMETRY_FILTER_RQ_ENTITY_KEY_FAILED = "Qmetry filter is not applied successfully using requirement entity key.";

        static final String QMETRY_FILTER_RQ_SUMMARY_SUCCESS = "Qmetry filter applied successfully using requirement summary.";
        static final String QMETRY_FILTER_RQ_SUMMARY_FAILED = "Qmetry filter is not applied successfully using requirement summary.";

        static final String QMETRY_FILTER_STATUS_NEW_SUCCESS = "Qmetry filter applied successfully using requirement status new.";
        static final String QMETRY_FILTER_STATUS_NEW_FAILED = "Qmetry filter is not applied successfully using requirement status new.";
        static final String QMETRY_FILTER_STATUS_OPEN_SUCCESS = "Qmetry filter applied successfully using requirement status open.";
        static final String QMETRY_FILTER_STATUS_OPEN_FAILED = "Qmetry filter is not applied successfully using requirement status open.";
        static final String QMETRY_FILTER_STATUS_NEW_AND_OPEN_SUCCESS = "Qmetry filter applied successfully using both requirement status new and open.";
        static final String QMETRY_FILTER_STATUS_NEW_AND_OPEN_FAILED = "Qmetry filter is not applied successfully using both requirement status new and open.";

        static final String QMETRY_FILTER_OWNER1_SUCCESS = "Qmetry filter applied successfully using requirement owner1.";
        static final String QMETRY_FILTER_OWNER1_FAILED = "Qmetry filter is not applied successfully using requirement owner1.";
        static final String QMETRY_FILTER_OWNER2_SUCCESS = "Qmetry filter applied successfully using requirement owner2.";
        static final String QMETRY_FILTER_OWNER2_FAILED = "Qmetry filter is not applied successfully using requirement owner2.";
        static final String QMETRY_FILTER_OWNER1_AND_OWNER2_SUCCESS = "Qmetry filter applied successfully using both requirement owner1 and owner2.";
        static final String QMETRY_FILTER_OWNER1_AND_OWNER2_FAILED = "Qmetry filter is not applied successfully using both requirement owner1 and owner2.";
        static final String QMETRY_FILTER_STRING_UDF_SUCCESS = "Qmetry filter applied successfully using requirement string type UDF.";
        static final String QMETRY_FILTER_STRING_UDF_FAILED = "Qmetry filter is not applied successfully using requirement string type UDF.";
        static final String QMETRY_FILTER_LOOKUPLIST_UDF_SUCCESS = "Qmetry filter applied successfully using requirement lookup list type UDF.";
        static final String QMETRY_FILTER_LOOKUPLIST_UDF_FAILED = "Qmetry filter is not applied successfully using requirement lookup list type UDF.";

        static final String REQUIREMENT_WATCHING_STARTED_SUCCESS = "Requirement watching started successfully.";
        static final String REQUIREMENT_WATCHING_STARTED_FAILED = "Requirement watching could not be started successfully.";
        static final String REQUIREMENT_WATCHING_STOPPED_SUCCESS = "Requirement watching stopped successfully.";
        static final String REQUIREMENT_WATCHING_STOPPED_FAILED = "Requirement watching could not be stopped successfully.";
        static final String REQUIREMENT_WATCHER_ADDED_SUCCESS = "Requirement watcher added successfully.";
        static final String REQUIREMENT_WATCHER_ADDED_FAILED = "Requirement watcher could not be added successfully.";
        static final String REQUIREMENT_PAGINATION_SUCCESS = "Requirement Pagination verified successfully.";
        static final String REQUIREMENT_PAGINATION_FAILED = "Requirement Pagination could not be verified successfully.";

        static final String PULL_DATA_NOTIFICATION_MSG_SUCCESS = "Pull data notification message verified successfully.";
        static final String PULL_DATA_NOTIFICATION_MSG_FAILED = "Pull data notification message could not be verified successfully.";

        static final String PUSH_DATA_NOTIFICATION_MSG_SUCCESS = "Push data notification message verified successfully.";
        static final String PUSH_DATA_NOTIFICATION_MSG_FAILED = "Push data notification message could not be verified successfully.";

        static final String COMBINED_VIEW_DBB_DATA_SUCCESS = "Combined view bdd data verified successfully.";
        static final String COMBINED_VIEW_DBB_DATA_FAILED = "Combined view bdd data could not be verified successfully.";

        static final String CREATE_RQ_PULL_BTN_NOT_PRESENT_SUCCESS = "Pull repository data btn is not visible on create requirement page";
        static final String CREATE_RQ_PULL_BTN_NOT_PRESENT_FAILED = "Pull repository data btn is not visible on create requirement page";

        static final String CREATE_RQ_PUSH_BTN_NOT_PRESENT_SUCCESS = "Push repository data btn is not visible on create requirement page";
        static final String CREATE_RQ_PUSH_BTN_NOT_PRESENT_FAILED = "Push repository data btn is not visible on create requirement page";

        static final String FOLDER_HIERARCHY_SUCCESS = "Folder hierarchy for repository verified successfully.";
        static final String FOLDER_HIERARCHY_FAILED = "Folder hierarchy for repository could not be verified successfully.";

        static final String BDD_TAB_NOT_MODIFY_RIGHTS_SUCCESS = "User not having modify rights for requirement is not able perform operatios on BDD tab";
        static final String BDD_TAB_NOT_MODIFY_RIGHTS_FAILED = "User not having modify rights for requirement is able perform operatios on BDD tab";

        static final String BDD_CONFIGURATION_TAB_NOT_MODIFY_RIGHTS_SUCCESS = "User not having modify rights for project is not able perform add bdd configuration operation.";
        static final String BDD_CONFIGURATION_TAB_NOT_MODIFY_RIGHTS_FAILED = "User not having modify rights for requirement is able perform add bdd configuration operation.";

        static final String INSUFFICIENT_PERMISSION_TOKEN_SUCCESS = "Due to repository token is having insufficinent permittion to write code, hence we are getting error message while pushing data in vcs.";
        static final String INSUFFICIENT_PERMISSION_TOKEN_FAILED = "Even if we are having token with insufficient permission user is able to push data in VCS.";

        // Requirement priority properties
        public static final String REQUIREMENT_PRIORITY_BLOCKER = "Blocker";
        public static final String REQUIREMENT_PRIORITY_CRITICAL = "Critical";
        public static final String REQUIREMENT_PRIORITY_MAJOR = "Major";
        public static final String REQUIREMENT_PRIORITY_MINOR = "Minor";
        public static final String REQUIREMENT_PRIORITY_TRIVIAL = "Trivial";

        public static final String START_WATCHING_COUNT = "1";
        public static final String STOP_WATCHING_COUNT = "0";

        public static final String PAGINATION_COUNT = "10";

        ArrayList<String> defaultNonEditableCheckedColumns = new ArrayList<>(
                        Arrays.asList("Entity Key", "Summary", "Version"));

        ArrayList<String> defaultCheckedColumns = new ArrayList<>(
                        Arrays.asList("Priority", "Created Date", "Created By", "Updated Date", "Updated By"));

        ArrayList<String> nonDefaultColumns = new ArrayList<>(Arrays.asList("Status", "Linked Test Case(s) Count",
                        "Linked Issue(s) Count", "Created System", "External Key", "Label(s)",
                        "Linked Attachment(s) Count", "Owner", "Folder Path", "Reviewed By", "Parent Key",
                        "Parent Issue Type", "Parent Summary"));

        ArrayList<String> addMoreFilterColumns = new ArrayList<>(Arrays.asList("Entity Key", "Priority", "Created Date",
                        "Created By", "Updated Date", "Updated By", "Status", "Linked Test Case(s) Count",
                        "Linked Issue(s) Count", "Created System", "Label(s)", "Linked Attachment(s) Count", "Owner"));

}