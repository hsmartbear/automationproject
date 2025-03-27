package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines QmetrySystemReportsConstants.
 * 
 * @author rahul.patil
 */
public interface QmetrySystemReportsConstants extends CommonConstants {

        static final String GADGET_EXPORT_MESSAGE = "The job has been scheduled in background.Kindly check scheduled tasks after sometime.";
        static final String TRACEABILITY_EXPORT_MESSAGE = "Export has begun. Go to Scheduled Task to view progress.";

        static final String REPORT_MODULE_TEXT = "Report";
        static final String EXPORT_TEXT = "Export";
        static final String TRACEABILITY_MODULE_TEXT = "TRACEABILITY";
        static final String COLUMN_TEST_SUITE_SUMMARY = "Test Suite Summary";
        static final String COLUMN_TEST_CASE_SUMMARY = "Test Case Summary";

        static final String EXPORT_AS_CSV_FORMAT_TEXT = "Export as CSV Format";
        static final String EXPORT_MESSAGE = "Export has begun. Go to Scheduled Task to view progress.";

        static final String TEST_RESULT_MODULE_TEXT = "TESTRESULTLOGS";

        static final String LOGIN_SUMMARY_DASHBOARD_GADGETS_SUCCESS = "Login summary dashboard gadgets verified successfully.";
        static final String LOGIN_SUMMARY_DASHBOARD_DEFAULT_GADGETS_FAILED = "Login summary dashboard gadgets verified not successfully";

        static final String DEFAULT_GADGETS_OF_REPORT_SUCCESS = "All default gadgets header for provided report verified successfully.";
        static final String DEFAULT_GADGETS_OF_REPORT_FAILED = "All default gadgets header for provided report could not be verified successfully.";

        static final String CHART_ENTITY_KEY_RECORD_SUCCESS = "Entity key record for chart verified successfully.";
        static final String CHART_ENTITY_KEY_RECORD_FAILED = "Entity key record for chart could not be verified successfully.";

        static final String EXPORT_ROW_GADGET_OPERATION_SUCCESS = "Export row operation on gadget performed successfully";
        static final String EXPORT_ROW_GADGET_OPERATION_FAILED = "Export row operation on gadget could not be performed successfully";

        static final String GADGET_VALUE_PRESENT_AT_REPORT_SUCCESS = "Gadget value present at report  successfully";
        static final String GADGET_VALUE_PRESENT_AT_REPORT_FAILED = "Gadget value not present at report successfully";

        ArrayList<String> executionDetailTestsuiteWiseGadgetColumnNames = new ArrayList<>(Arrays.asList("Testsuite Key",
                        "Testsuite Summary", "Folder Name", "Folder Path", "Platforms", "Testcases", "Executions",
                        "Blocked", "Blocked %", "Failed", "Failed %", "Not Applicable", "Not Applicable %", "Not Run",
                        "Not Run %", "Passed", "Passed %"));

        ArrayList<String> riskTraceabilityforRequirementsColumnNames = new ArrayList<>(Arrays.asList("Risk Type",
                        "Extent of Testing", "R.P.N.", "Risk Category", "RQ Key", "RQ Summary", "RQ Version",
                        "Likelihood", "Impact", "RQ Issues", "TC Key", "TC Summary", "TC Version", "TC Issues"));

        ArrayList<String> riskTraceabilityforTestcasesColumnNames = new ArrayList<>(Arrays.asList("Risk Type",
                        "Extent of Testing", "R.P.N.", "Risk Category", "TC Key", "TC Summary", "TC Version",
                        "Likelihood", "Impact", "TC Issues", "RQ Key", "RQ Summary", "RQ Version", "RQ Issues"));

}
