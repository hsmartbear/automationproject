package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines ExportConstants.
 * 
 * @author rahul.patil
 */
public interface ExportConstants extends CommonConstants {
        static final String TESTCASE_EXPORT_MESSAGE = "Test Case Export is scheduled to run in background. Go to \"Scheduled Task\" to track the process.";
        static final String REQUIREMENT_EXPORT_MESSAGE = "Requirement Export is scheduled to run in background. Go to \"Scheduled Task\" to track the process.";
        static final String REQUIREMENT_EXPORT_MODULE_TEXT = "Requirement";
        static final String EXPORT_TEXT = "Export";
        static final String TESTCASE_EXPORT_MODULE_TEXT = "Test Case";
        static final String TESTSUITE_EXPORT_MESSAGE = "Test Suite Export is scheduled to run in background. Go to \"Scheduled Task\" to track the process.";
        static final String TESTSUITE_EXPORT_MODULE_TEXT = "Test Suite";
        static final String ISSUE_EXPORT_MESSAGE = "Issue Export is scheduled to run in background. Go to \"Scheduled Task\" to track the process.";
        static final String ISSUE_EXPORT_MODULE_TEXT = "Issue";
        static final String PARAMETER_EXPORT_MESSAGE = "Export has begun. Go to Scheduled Task to view progress.";
        static final String PARAMETER_EXPORT_MODULE_TEXT = "Parameter";
        static final String DATAGRID_EXPORT_MESSAGE = "Export has begun. Go to Scheduled Task to view progress.";
        static final String DATAGRID_EXPORT_MODULE_TEXT = "Data Grid";
        static final String TEST_EXECUTION_EXPORT_MESSAGE = "Export has begun. Go to Scheduled Task to view progress.";
        static final String TEST_EXECUTION_EXPORT_MODULE_TEXT = "Test Execution";
        static final String CHANGE_LOG_EXPORT_MESSAGE = "Export has begun. Go to Scheduled Task to view progress.";
        static final String CHANGE_LOG_EXPORT_MODULE_TEXT = "CHANGELOG";
        static final String EXPORT_MSG = "Process of Exporting Test Execution(s) has been scheduled to run in background. Go to Scheduled Task to view progress.";
        static final String EXPORT_SUCCESS_MESSAGE = "Would you like to go back or go to scheduled tasks?";

        ArrayList<String> defaultNonEditableCheckedColumnsTestCasesFieldsExportTestExecution = new ArrayList<>(
                        Arrays.asList("Summary", "Test Case Entity Key"));

        ArrayList<String> defaultCheckedColumnsTestCasesFieldsExportTestExecution = new ArrayList<>(
                        Arrays.asList("Associated Release(s)/Cycle(s)", "Label(s)", "Created Date", "Description",
                                        "Estimated Time (mins)", "Priority", "Test Case Owner", "Test Case State",
                                        "Test Category", "Testing Type", "Updated Date", "Test Case Folder Path",
                                        "Test Case Version", "Updated By", "Created By"));

        ArrayList<String> defaultCheckedColumnsTestStepsFieldsExportTestExecution = new ArrayList<>(Arrays.asList(
                        "Step Description", "Step Expected Outcome", "Step Input Data", "Test Case Step Entity Key"));

        ArrayList<String> defaultCheckedColumnsTestCaseExecutionsFieldsExportTestExecution = new ArrayList<>(
                        Arrays.asList("Execution Status", "Assignee", "Issue(s) Count", "Attachment(s) Count",
                                        "Comment(s) Count", "Executed At", "Build Name", "Executed By",
                                        "Duration - Automated TC Execution", "Linked Requirement(s) Count",
                                        "Linked Testsuite(s) Count", "Error Message", "Trace",
                                        "Actual Attended Time (mins)", "Actual Setup Time (mins)", "Execution Type",
                                        "Planned Date", "Latest Test Case Execution Comment"));

        ArrayList<String> defaultCheckedColumnsTestCaseStepExecutionsFieldsExportTestExecution = new ArrayList<>(
                        Arrays.asList("Actual Outcome", "Execution Status", "Comment", "Attachment(s) Count",
                                        "Issue(s) Count", "Duration - Automated Step Execution", "Error Message",
                                        "Trace"));
}