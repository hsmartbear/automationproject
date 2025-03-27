package com.qmetry.tests.webservice;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;
import com.qmetry.bean.AutomationAgentBean;
import com.qmetry.bean.BuildBean;
import com.qmetry.bean.DataGridBean;
import com.qmetry.bean.DataParameterBean;
import com.qmetry.bean.IssueBean;
import com.qmetry.bean.PlatformBean;
import com.qmetry.bean.ProjectBean;
import com.qmetry.bean.RequirementBean;
import com.qmetry.bean.TestCaseBean;
import com.qmetry.bean.TestSuiteBean;
import com.qmetry.constants.CommonConstants;
import com.qmetry.constants.IssueConstants;
import com.qmetry.constants.RequirementConstants;
import com.qmetry.constants.TestCaseConstants;
import com.qmetry.constants.TestDataSetupConstants;
import com.qmetry.page.CommonPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.WsStep;
import com.qmetry.qaf.automation.util.RandomStringGenerator;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.qaf.automation.ws.RestWSTestCase;
import com.qmetry.qaf.automation.ws.rest.RestTestBase;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * This class defines the TestDataSetupTestSuite.
 * 
 * @author nidhi.shah
 */
public class TestDataSetupTestSuite extends RestWSTestCase implements TestDataSetupConstants {

	static ProjectBean projectBean;
	static RequirementBean requirementBean;

	/**
	 * A method to call Get Info API
	 * 
	 * @author nidhi.shah
	 */
	public static void getInfo() {
		Reporter.log("TD:Get Info - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			WsStep.userRequests("GET.rest.admin.project.getinfo");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			/*
			 * WsStep.sayValueAtJsonPath(RQ_ROOT_FOLDER_ID, TestDataSetupSupport
			 * .getRootFolderId("$." + ATTRIBUTE_ROOT_FOLDERS + "." + ATTRIBUTE_RQ + "." +
			 * ATTRIBUTE_ID)); WsStep.sayValueAtJsonPath(TC_ROOT_FOLDER_ID, "$." +
			 * ATTRIBUTE_ROOT_FOLDERS + "." + ATTRIBUTE_TC + "." + ATTRIBUTE_ID);
			 * WsStep.sayValueAtJsonPath(TS_ROOT_FOLDER_ID, "$." + ATTRIBUTE_ROOT_FOLDERS +
			 * "." + ATTRIBUTE_TS + "." + ATTRIBUTE_ID);
			 * WsStep.sayValueAtJsonPath(PROJECT_ID, "$." + ATTRIBUTE_CURRENT_PROJECT_ID);
			 */

			CommonPage.storeProperties(RQ_ROOT_FOLDER_ID, TestDataSetupSupport
					.getRootFolderId("$." + ATTRIBUTE_ROOT_FOLDERS + "." + ATTRIBUTE_RQ + "." + ATTRIBUTE_ID));
			CommonPage.storeProperties(TC_ROOT_FOLDER_ID, TestDataSetupSupport
					.getRootFolderId("$." + ATTRIBUTE_ROOT_FOLDERS + "." + ATTRIBUTE_TC + "." + ATTRIBUTE_ID));
			CommonPage.storeProperties(TS_ROOT_FOLDER_ID, TestDataSetupSupport
					.getRootFolderId("$." + ATTRIBUTE_ROOT_FOLDERS + "." + ATTRIBUTE_TS + "." + ATTRIBUTE_ID));
			CommonPage.storeProperties(PROJECT_ID,
					TestDataSetupSupport.getRootFolderId("$." + ATTRIBUTE_CURRENT_PROJECT_ID));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_BLOCKER_ID,
					TestDataSetupSupport.getIssuePriorityId(IssueConstants.ISSUE_PRIORITY_BLOCKER));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_TRIVIAL_ID,
					TestDataSetupSupport.getIssuePriorityId(IssueConstants.ISSUE_PRIORITY_TRIVIAL));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_CRITICAL_ID,
					TestDataSetupSupport.getIssuePriorityId(IssueConstants.ISSUE_PRIORITY_CRITICAL));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_MINOR_ID,
					TestDataSetupSupport.getIssuePriorityId(IssueConstants.ISSUE_PRIORITY_MINOR));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_MAJOR_ID,
					TestDataSetupSupport.getIssuePriorityId(IssueConstants.ISSUE_PRIORITY_MAJOR));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_TYPE_BUG_ID,
					TestDataSetupSupport.getIssueTypeId(IssueConstants.ISSUE_TYPE_BUG));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_TYPE_ENHANCEMENT_ID,
					TestDataSetupSupport.getIssueTypeId(IssueConstants.ISSUE_TYPE_ENHANCEMENT));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_TYPE_NEW_FEATURE_ID,
					TestDataSetupSupport.getIssueTypeId(IssueConstants.ISSUE_TYPE_NEW_FEATURE));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_BLOCKER_ID,
					TestDataSetupSupport.getPriorityId(CommonConstants.PRIORITY_BLOCKER));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_CRITICAL_ID,
					TestDataSetupSupport.getPriorityId(CommonConstants.PRIORITY_CRITICAL));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_MAJOR_ID,
					TestDataSetupSupport.getPriorityId(CommonConstants.PRIORITY_MAJOR));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_MINOR_ID,
					TestDataSetupSupport.getPriorityId(CommonConstants.PRIORITY_MINOR));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_TRIVIAL_ID,
					TestDataSetupSupport.getPriorityId(CommonConstants.PRIORITY_TRIVIAL));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_NEW_ID,
					TestDataSetupSupport.getRequirementStateId(RequirementConstants.REQUIREMENT_STATE_NEW));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_OPEN_ID,
					TestDataSetupSupport.getRequirementStateId(RequirementConstants.REQUIREMENT_STATE_OPEN));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_ON_HOLD_ID,
					TestDataSetupSupport.getRequirementStateId(RequirementConstants.REQUIREMENT_STATE_ON_HOLD));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_REJECTED_ID,
					TestDataSetupSupport.getRequirementStateId(RequirementConstants.REQUIREMENT_STATE_REJECTED));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_IN_PROGRESS_ID,
					TestDataSetupSupport.getRequirementStateId(RequirementConstants.REQUIREMENT_STATE_IN_PROGRESS));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_APPROVED_ID,
					TestDataSetupSupport.getRequirementStateId(RequirementConstants.REQUIREMENT_STATE_APPROVED));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_NEW_ID,
					TestDataSetupSupport.getTestcaseStateId(TestCaseConstants.TESTCASE_STATE_NEW));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_OPEN_ID,
					TestDataSetupSupport.getTestcaseStateId(TestCaseConstants.TESTCASE_STATE_OPEN));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_ON_HOLD_ID,
					TestDataSetupSupport.getTestcaseStateId(TestCaseConstants.TESTCASE_STATE_ON_HOLD));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_REJECTED_ID,
					TestDataSetupSupport.getTestcaseStateId(TestCaseConstants.TESTCASE_STATE_REJECTED));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_IN_PROGRESS_ID,
					TestDataSetupSupport.getTestcaseStateId(TestCaseConstants.TESTCASE_STATE_IN_PROGRESS));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_APPROVED_ID,
					TestDataSetupSupport.getTestcaseStateId(TestCaseConstants.TESTCASE_STATE_CLOSED));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_NEW_ID,
					TestDataSetupSupport.getTestsuiteStateId(TestCaseConstants.TESTSUITE_STATE_NEW));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_OPEN_ID,
					TestDataSetupSupport.getTestsuiteStateId(TestCaseConstants.TESTSUITE_STATE_OPEN));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_ON_HOLD_ID,
					TestDataSetupSupport.getTestsuiteStateId(TestCaseConstants.TESTSUITE_STATE_ON_HOLD));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_REJECTED_ID,
					TestDataSetupSupport.getTestsuiteStateId(TestCaseConstants.TESTSUITE_STATE_REJECTED));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_IN_PROGRESS_ID,
					TestDataSetupSupport.getTestsuiteStateId(TestCaseConstants.TESTSUITE_STATE_IN_PROGRESS));
			CommonPage.storeProperties(TestDataSetupConstants.TD_DEFAULT_CYCLE_ID,
					JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CURRENT_BUILD_ID));
			CommonPage.storeProperties(TestDataSetupConstants.TE_VIEW_ID,
					JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
							ATTRIBUTE_LATESTVIEWS + "." + ATTRIBUTE_TE + "." + ATTRIBUTE_VIEW_ID));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_RUN_STATUS_PASSED_ID,
					TestDataSetupSupport.getRunStatusId(TestCaseConstants.TESTCASE_RUN_STATUS_PASSED));
			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_RUN_STATUS_FAILED_ID,
					TestDataSetupSupport.getRunStatusId(TestCaseConstants.TESTCASE_RUN_STATUS_FAILED));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_RUN_STATUS_BLOCKED_ID,
					TestDataSetupSupport.getRunStatusId(TestCaseConstants.TESTCASE_RUN_STATUS_BLOCKED));

			CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_RUN_STATUS_NOT_APPLICABLE_ID,
					TestDataSetupSupport.getRunStatusId(TestCaseConstants.TESTCASE_RUN_STATUS_NOT_APPLICABLE));

		} catch (Exception e) {
			Reporter.log("TD:Error happened calling 'Get Info' Service - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Get Info - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create a project
	 * 
	 * @return ProjectBean
	 * @author nidhi.shah
	 */
	public static ProjectBean createProject() {
		Reporter.log("TD:Create Project - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			projectBean = new ProjectBean();
			projectBean.fillFromConfig("data.createproject");
			String projectName = projectBean.getProjectName() + RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			String projectKey = RandomStringGenerator.get(10, RandomizerTypes.MIXED);

			ConfigurationManager.getBundle().setProperty(TD_PROJECT_NAME, projectName);
			ConfigurationManager.getBundle().setProperty(TD_PROJECT_KEY, projectKey);

			WsStep.userRequests("POST.rest.admin.project.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_PROJECT_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath("Project(" + projectName + ") added successfully.",
					"$." + ATTRIBUTE_MESSAGE);
			WsStep.sayValueAtJsonPath(TD_PROJECT_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_PROJECT_ID);

			projectBean.setProjectName(projectName);
			projectBean.setProjectKey(projectKey);
			projectBean.setProjectID(ConfigurationManager.getBundle().getLong(TD_PROJECT_ID));

			Reporter.log("TD:Created Project Name - " + projectName, MessageTypes.Info);
			Reporter.log("TD:Created Project Key - " + projectKey, MessageTypes.Info);
			Reporter.log("TD:Created Project ID - " + projectBean.getProjectID(), MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_PROJECT_NAME, projectName);
			CommonPage.storeTestDataProperties(TD_PROJECT_KEY, projectKey);
			CommonPage.storeTestDataProperties(TD_PROJECT_ID, projectBean.getProjectID());
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Project - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Project - WS Call - COMPLETED", MessageTypes.Info);
		}
		return projectBean;
	}

	/**
	 * A method to create a release
	 * 
	 * @return ProjectBean
	 * @author rahul.patil
	 * @Updated by nidhi.shah
	 */
	public static ProjectBean createRelease(ProjectBean projectBean) {
		Reporter.log("TD:Create Release - WS Call - STARTED", MessageTypes.Info);
		ProjectBean _projectBean = new ProjectBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			projectBean = new ProjectBean();
			projectBean.fillFromConfig("data.createRelease");
			String releaseName = projectBean.getReleaseName()
					+ RandomStringGenerator.get(4, RandomizerTypes.DIGITS_ONLY);

			ConfigurationManager.getBundle().setProperty(TD_RELEASE_NAME, releaseName);

			WsStep.userRequests("POST.rest.admin.release.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_RELEASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_RELEASE_SUCCESSFUL_MESSAGE, ATTRIBUTE_MESSAGE);
			WsStep.sayValueAtJsonPath(TD_RELEASE_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_RELEASE_ID);
			WsStep.sayValueAtJsonPath(TD_BUILD_ID,
					"$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_BUILDS + "[0]." + ATTRIBUTE_BUILD_ID);

			_projectBean.setReleaseName(releaseName);
			_projectBean.setReleaseID(ConfigurationManager.getBundle().getLong(TD_RELEASE_ID));
			_projectBean.setBuildID(ConfigurationManager.getBundle().getLong(TD_BUILD_ID));
			Reporter.log("TD:Created Release Name - " + releaseName, MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_RELEASE_NAME, releaseName);
			CommonPage.storeTestDataProperties(TD_RELEASE_ID, ConfigurationManager.getBundle().getLong(TD_RELEASE_ID));
			CommonPage.storeTestDataProperties(TD_BUILD_ID, ConfigurationManager.getBundle().getLong(TD_BUILD_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Release - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Release - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _projectBean;
	}

	/**
	 * A method to create a RQ Folder
	 * 
	 * @return requirementBean
	 * @author by nidhi.shah
	 */
	public static RequirementBean createRQFolder(RequirementBean requirementBean) {
		Reporter.log("TD:Create RQ Folder - WS Call - STARTED", MessageTypes.Info);
		RequirementBean _requirementBean = new RequirementBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			String rqFolderName = "WS_" + requirementBean.getFolderName() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_RQ_FOLDER_NAME, rqFolderName);
			ConfigurationManager.getBundle().setProperty(TD_RQ_PARENT_FOLDER_ID,
					requirementBean.getRequirementParentFolderID());

			WsStep.userRequests("POST.rest.requirements.create.folder");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_FOLDER_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_FOLDER_SUCCESSFUL_MESSAGE, ATTRIBUTE_MESSAGE);

			WsStep.sayValueAtJsonPath(TD_RQ_FOLDER_ID, "$." + ATTRIBUTE_ID);

			_requirementBean.setFolderName(rqFolderName);
			_requirementBean.setRequirementFolderID(ConfigurationManager.getBundle().getLong(TD_RQ_FOLDER_ID));

			Reporter.log("TD:Created Folder Name - " + rqFolderName, MessageTypes.Info);
			CommonPage.storeTestDataProperties(TD_RQ_FOLDER_NAME, rqFolderName);
			CommonPage.storeTestDataProperties(TD_RQ_FOLDER_ID,
					ConfigurationManager.getBundle().getLong(TD_RQ_FOLDER_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a RQ Folder - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create RQ Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _requirementBean;
	}

	/**
	 * A method to create an Issue
	 * 
	 * @return IssueBean
	 * @author nidhi.shah
	 */
	public static IssueBean createIssue(IssueBean issueBean) {
		Reporter.log("TD:Create Issue - WS Call - STARTED", MessageTypes.Info);
		IssueBean _issueBean = new IssueBean();
		try {
			String issueName = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			issueName = "WS_" + issueBean.getIssueSummary() + "_" + RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_IS_SUMMARY, issueName);
			ConfigurationManager.getBundle().setProperty(TD_IS_PRIORITY, issueBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_IS_TYPE, issueBean.getType());
			WsStep.userRequests("POST.rest.create.issue");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_ISSUE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_IS_KEY, "$." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_IS_ID, "$." + ATTRIBUTE_DFID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Issue " + ConfigurationManager.getBundle().getString(TD_IS_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_issueBean.setIssueSummary(issueName);
			_issueBean.setIssueEntityKey(ConfigurationManager.getBundle().getString(TD_IS_KEY));
			_issueBean.setDefectID(ConfigurationManager.getBundle().getLong(TD_IS_ID));

			Reporter.log("TD:Created Issue Summary - " + issueName, MessageTypes.Info);
			Reporter.log("TD:Created Issue Key - " + ConfigurationManager.getBundle().getString(TD_IS_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Issue ID - " + ConfigurationManager.getBundle().getLong(TD_IS_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_IS_SUMMARY, issueName);
			CommonPage.storeTestDataProperties(TD_IS_KEY, ConfigurationManager.getBundle().getString(TD_IS_KEY));
			CommonPage.storeTestDataProperties(TD_IS_ID, ConfigurationManager.getBundle().getLong(TD_IS_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating an Issue - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Issue - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _issueBean;
	}

	/**
	 * A method to create a TC Folder
	 * 
	 * @return testCaseBean
	 * @author by nidhi.shah
	 */
	public static TestCaseBean createTCFolder(TestCaseBean testCaseBean) {
		Reporter.log("TD:Create TC Folder - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testCaseBean = new TestCaseBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			String tcFolderName = "WS_" + testCaseBean.getFolderName() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_FOLDER_NAME, tcFolderName);
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID,
					testCaseBean.getTestcaseParentFolderID());

			WsStep.userRequests("POST.rest.testcases.create.folder");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_FOLDER_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_FOLDER_SUCCESSFUL_MESSAGE, ATTRIBUTE_MESSAGE);

			WsStep.sayValueAtJsonPath(TD_TC_FOLDER_ID, "$.data[0]." + ATTRIBUTE_ID);

			_testCaseBean.setFolderName(tcFolderName);
			_testCaseBean.setTestcaseFolderID(ConfigurationManager.getBundle().getLong(TD_TC_FOLDER_ID));

			Reporter.log("TD:Created Folder Name - " + tcFolderName, MessageTypes.Info);
			CommonPage.storeTestDataProperties(TD_TC_FOLDER_NAME, tcFolderName);
			CommonPage.storeTestDataProperties(TD_TC_FOLDER_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_FOLDER_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a TC Folder - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create TC Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testCaseBean;
	}

	/**
	 * A method to create an Requirement
	 * 
	 * @param requirementBean
	 * @return RequirementBean
	 * @author nidhi.shah
	 */
	public static RequirementBean createRequirement(RequirementBean requirementBean) {
		Reporter.log("TD:Create Requirement - WS Call - STARTED", MessageTypes.Info);
		RequirementBean _requirementBean = new RequirementBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + requirementBean.getRequirementSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_RQ_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_RQ_PRIORITY_ID, requirementBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_RQ_STATE_ID, requirementBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_RQ_PARENT_FOLDER_ID,
					requirementBean.getRequirementFolderID());

			WsStep.userRequests("POST.rest.requirements.create.rq");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_REQUIREMENT_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_RQ_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_RQ_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_RQ_VERSION_ID, "$.data[0]." + ATTRIBUTE_RQ_VERSION_ID);
			WsStep.responseShouldHaveValueAtJsonpath("New Requirement "
					+ ConfigurationManager.getBundle().getString(TD_RQ_KEY) + " created successfully",
					"$." + ATTRIBUTE_MESSAGE);

			_requirementBean.setRequirementSummary(rqSummary);
			_requirementBean.setRequirementEntityKey(ConfigurationManager.getBundle().getString(TD_RQ_KEY));
			_requirementBean.setRequirementID(ConfigurationManager.getBundle().getLong(TD_RQ_ID));
			_requirementBean.setrequirementVersionID(ConfigurationManager.getBundle().getLong(TD_RQ_VERSION_ID));

			Reporter.log("TD:Created Requirement Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Requirement Key - " + ConfigurationManager.getBundle().getString(TD_RQ_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Requirement ID - " + ConfigurationManager.getBundle().getLong(TD_RQ_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Requirement Vesion ID - " + ConfigurationManager.getBundle().getLong(TD_RQ_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_RQ_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_RQ_KEY, ConfigurationManager.getBundle().getString(TD_RQ_KEY));
			CommonPage.storeTestDataProperties(TD_RQ_ID, ConfigurationManager.getBundle().getLong(TD_RQ_ID));
			CommonPage.storeTestDataProperties(TD_RQ_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_RQ_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Requirement - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Requirement - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _requirementBean;
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static TestCaseBean createTestcase(TestCaseBean testcaseBean) {
		Reporter.log("TD:Create Testcase - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testcaseBean = new TestCaseBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + testcaseBean.getTestCaseSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_TC_PRIORITY_ID, testcaseBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_TC_STATE_ID, testcaseBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID, testcaseBean.getTestcaseFolderID());

			WsStep.userRequests("POST.rest.testcases.create.tc");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTCASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_TC_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TC_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_TC_VERSION_ID, "$.data[0]." + ATTRIBUTE_TC_VERSION_ID);
			// WsStep.responseShouldHaveValueAtJsonpath(
			// "New Test Case " + ConfigurationManager.getBundle().getString(TD_TC_KEY) + "
			// created successfully.",
			// "$." + ATTRIBUTE_MESSAGE);

			_testcaseBean.setTestCaseSummary(rqSummary);
			_testcaseBean.setTestCaseEntityKey(ConfigurationManager.getBundle().getString(TD_TC_KEY));
			_testcaseBean.setTestCaseID(ConfigurationManager.getBundle().getLong(TD_TC_ID));
			_testcaseBean.setTestCaseVersionID(ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));

			Reporter.log("TD:Created Testcase Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testcase Key - " + ConfigurationManager.getBundle().getString(TD_TC_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testcase ID - " + ConfigurationManager.getBundle().getLong(TD_TC_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Testcase version ID - " + ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TC_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_TC_KEY, ConfigurationManager.getBundle().getString(TD_TC_KEY));
			CommonPage.storeTestDataProperties(TD_TC_ID, ConfigurationManager.getBundle().getLong(TD_TC_ID));
			CommonPage.storeTestDataProperties(TD_TC_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testcase - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testcase - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testcaseBean;
	}

	/**
	 * A method to create a TS Folder
	 * 
	 * @return testSuiteBean
	 * @author by rahul.patil
	 */
	public static TestSuiteBean createTSFolder(TestSuiteBean testSuiteBean) {
		Reporter.log("TD:Create TS Folder - WS Call - STARTED", MessageTypes.Info);
		TestSuiteBean _testSuiteBean = new TestSuiteBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			String tsFolderName = "WS_" + testSuiteBean.getFolderName() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TS_FOLDER_NAME, tsFolderName);
			ConfigurationManager.getBundle().setProperty(TD_TS_PARENT_FOLDER_ID,
					testSuiteBean.getTestsuiteParentFolderID());

			WsStep.userRequests("POST.rest.testsuites.create.folder");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_FOLDER_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_FOLDER_SUCCESSFUL_MESSAGE, ATTRIBUTE_MESSAGE);

			WsStep.sayValueAtJsonPath(TD_TS_FOLDER_ID, "$.data[0]." + ATTRIBUTE_ID);

			_testSuiteBean.setFolderName(tsFolderName);
			_testSuiteBean.setTestsuiteFolderID(ConfigurationManager.getBundle().getLong(TD_TS_FOLDER_ID));

			Reporter.log("TD:Created Folder Name - " + tsFolderName, MessageTypes.Info);
			CommonPage.storeTestDataProperties(TD_TS_FOLDER_NAME, tsFolderName);
			CommonPage.storeTestDataProperties(TD_TS_FOLDER_ID,
					ConfigurationManager.getBundle().getLong(TD_TS_FOLDER_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a TS Folder - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create TC Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testSuiteBean;
	}

	/**
	 * A method to create an Testsuite
	 * 
	 * @param testSuiteBean
	 * @return testSuiteBean
	 * @author rahul.patil
	 */
	public static TestSuiteBean createTestsuite(TestSuiteBean testSuiteBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		TestSuiteBean _testsuiteBean = new TestSuiteBean();
		try {
			String tsSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			tsSummary = "WS_" + testSuiteBean.getTestSuiteSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.DIGITS_ONLY);
			ConfigurationManager.getBundle().setProperty(TD_TS_SUMMARY, tsSummary);
			ConfigurationManager.getBundle().setProperty(TD_TS_STATE_ID, testSuiteBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TS_PARENT_FOLDER_ID, testSuiteBean.getTestsuiteFolderID());

			WsStep.userRequests("POST.rest.testsuites.create.ts");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);

			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTSUITE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);

			WsStep.sayValueAtJsonPath(TD_TS_KEY, "$.data[0]." + ATTRIBUTE_TS_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TS_ID, "$.data[0]." + ATTRIBUTE_ID);

			_testsuiteBean.setTestSuiteSummary(tsSummary);
			_testsuiteBean.setTestSuiteEntityKey(ConfigurationManager.getBundle().getString(TD_TS_KEY));
			_testsuiteBean.setTestsuiteID(ConfigurationManager.getBundle().getLong(TD_TS_ID));

			Reporter.log("TD:Created Testsuite Summary - " + tsSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testsuite Key - " + ConfigurationManager.getBundle().getString(TD_TS_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testsuite ID - " + ConfigurationManager.getBundle().getLong(TD_TS_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TS_SUMMARY, tsSummary);
			CommonPage.storeTestDataProperties(TD_TS_KEY, ConfigurationManager.getBundle().getString(TD_TS_KEY));
			CommonPage.storeTestDataProperties(TD_TS_ID, ConfigurationManager.getBundle().getLong(TD_TS_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testsuiteBean;
	}

	/**
	 * A method to link testcase to testsuite.
	 * 
	 * @param testSuiteBean
	 * @param testCaseBean
	 * @author rahul.patil
	 */
	public static void linkTestcaseToTestsuite(TestSuiteBean testSuiteBean, TestCaseBean testCaseBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty(TD_TS_ID, testSuiteBean.getTestsuiteID());
			ConfigurationManager.getBundle().setProperty(TD_TC_VERSION_ID, testCaseBean.getTestCaseVersionID());

			WsStep.userRequests("POST.rest.link.tc.to.ts");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath(LINK_TESTCASE_TO_TESTSUITE_SUCCESSFUL_MESSAGE,
					"$." + ATTRIBUTE_MESSAGE);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while linking testcase to testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Link testcase to testsuite completed - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to map release cycle to testsuite
	 * 
	 * @param testSuiteBean
	 * @param projectBean
	 * @author rahul.patil
	 */
	public static void mapReleaseCycleToTestsuite(TestSuiteBean testSuiteBean, ProjectBean projectBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty(TD_TS_ID, testSuiteBean.getTestsuiteID());
			ConfigurationManager.getBundle().setProperty(TD_RELEASE_ID, projectBean.getReleaseID());
			ConfigurationManager.getBundle().setProperty(TD_BUILD_ID, projectBean.getBuildID());

			WsStep.userRequests("POST.rest.testsuite.map.release.cycle");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath("Release(s) and Cycle(s) associated successfully.",
					"$." + ATTRIBUTE_MESSAGE);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create a RQ Folder
	 * 
	 * @return PlatformBean
	 * @author by nidhi.shah
	 */
	public static PlatformBean createPlatform(PlatformBean platformBean) {
		Reporter.log("TD:Create RQ Folder - WS Call - STARTED", MessageTypes.Info);
		PlatformBean _platformBean = new PlatformBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			String platformName = "WS_" + platformBean.getPlatformName() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.DIGITS_ONLY);
			ConfigurationManager.getBundle().setProperty(TD_PLATFORM_NAME, platformName);

			WsStep.userRequests("POST.rest.admin.platform.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath("Platform added successfully.", ATTRIBUTE_MESSAGE);

			WsStep.sayValueAtJsonPath(TD_PLATFORM_ID, "$." + ATTRIBUTE_PLATFORM_ID);

			_platformBean.setPlatformName(platformName);
			_platformBean.setPlatformID(ConfigurationManager.getBundle().getLong(TD_PLATFORM_ID));

			Reporter.log("TD:Created Platform Name - " + platformName, MessageTypes.Info);
			CommonPage.storeTestDataProperties(TD_PLATFORM_NAME, platformName);
			CommonPage.storeTestDataProperties(TD_PLATFORM_ID,
					ConfigurationManager.getBundle().getLong(TD_PLATFORM_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a RQ Folder - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create RQ Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _platformBean;
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static void linkPlatformToTestsuite(TestSuiteBean testSuiteBean, PlatformBean platformBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty(TD_TS_ID, testSuiteBean.getTestsuiteID());
			ConfigurationManager.getBundle().setProperty(TD_PLATFORM_ID, platformBean.getPlatformID());

			WsStep.userRequests("POST.rest.link.platform.to.ts");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath("Platform(s) linked successfully.", "$." + ATTRIBUTE_MESSAGE);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to import TestResult
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static void importTestResult() {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			WsStep.userRequests("POST.rest.importTestResult");
			WsStep.responseShouldHaveValueAtJsonpath("Part 11 compliance is enabled for "
					+ ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME) + " Project.",
					"$." + ATTRIBUTE_MESSAGE);
		} catch (Exception e) {
			Reporter.log("TD:test result imported successfully - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create a project with spanish language preference
	 * 
	 * @return ProjectBean
	 * @author priyanka.devaliya
	 */
	public static ProjectBean createProject_spanish() {
		Reporter.log("TD:Create Project - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			projectBean = new ProjectBean();
			projectBean.fillFromConfig("data.createproject");
			String projectName = projectBean.getProjectName() + RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			String projectKey = RandomStringGenerator.get(5, RandomizerTypes.MIXED);

			ConfigurationManager.getBundle().setProperty(TD_PROJECT_NAME, projectName);
			ConfigurationManager.getBundle().setProperty(TD_PROJECT_KEY, projectKey);

			WsStep.userRequests("POST.rest.admin.project.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_PROJECT_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath("Proyecto (" + projectName + ") agregado correctamente.",
					"$." + ATTRIBUTE_MESSAGE);
			WsStep.sayValueAtJsonPath(TD_PROJECT_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_PROJECT_ID);

			projectBean.setProjectName(projectName);
			projectBean.setProjectKey(projectKey);
			projectBean.setProjectID(ConfigurationManager.getBundle().getLong(TD_PROJECT_ID));

			Reporter.log("TD:Created Project Name - " + projectName, MessageTypes.Info);
			Reporter.log("TD:Created Project Key - " + projectKey, MessageTypes.Info);
			Reporter.log("TD:Created Project ID - " + projectBean.getProjectID(), MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_PROJECT_NAME, projectName);
			CommonPage.storeTestDataProperties(TD_PROJECT_KEY, projectKey);
			CommonPage.storeTestDataProperties(TD_PROJECT_ID, projectBean.getProjectID());
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Project - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Project - WS Call - COMPLETED", MessageTypes.Info);
		}
		return projectBean;
	}

	/**
	 * A method to create an Testcase with spanish reference.
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author priyanka.devaliya
	 */
	public static TestCaseBean createTestcase_spanish(TestCaseBean testcaseBean) {
		Reporter.log("TD:Create Testcase - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testcaseBean = new TestCaseBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + testcaseBean.getTestCaseSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_TC_PRIORITY_ID, testcaseBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_TC_STATE_ID, testcaseBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID, testcaseBean.getTestcaseFolderID());

			WsStep.userRequests("POST.rest.testcases.create.tc");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTCASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_TC_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TC_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_TC_VERSION_ID, "$.data[0]." + ATTRIBUTE_TC_VERSION_ID);
			WsStep.responseShouldHaveValueAtJsonpath("Nuevo caso de prueba "
					+ ConfigurationManager.getBundle().getString(TD_TC_KEY) + " creado correctamente.",
					"$." + ATTRIBUTE_MESSAGE);

			_testcaseBean.setTestCaseSummary(rqSummary);
			_testcaseBean.setTestCaseEntityKey(ConfigurationManager.getBundle().getString(TD_TC_KEY));
			_testcaseBean.setTestCaseID(ConfigurationManager.getBundle().getLong(TD_TC_ID));
			_testcaseBean.setTestCaseVersionID(ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));

			Reporter.log("TD:Created Testcase Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testcase Key - " + ConfigurationManager.getBundle().getString(TD_TC_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testcase ID - " + ConfigurationManager.getBundle().getLong(TD_TC_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Testcase version ID - " + ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TC_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_TC_KEY, ConfigurationManager.getBundle().getString(TD_TC_KEY));
			CommonPage.storeTestDataProperties(TD_TC_ID, ConfigurationManager.getBundle().getLong(TD_TC_ID));
			CommonPage.storeTestDataProperties(TD_TC_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testcase - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testcase - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testcaseBean;
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static TestCaseBean createTestcaseWithTwoStep(TestCaseBean testcaseBean) {
		Reporter.log("TD:Create Testcase - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testcaseBean = new TestCaseBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + testcaseBean.getTestCaseSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_TC_PRIORITY_ID, testcaseBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_TC_STATE_ID, testcaseBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID, testcaseBean.getTestcaseFolderID());

			WsStep.userRequests("POST.rest.testcases.create.two.step.tc");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTCASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_TC_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TC_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_TC_VERSION_ID, "$.data[0]." + ATTRIBUTE_TC_VERSION_ID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Test Case " + ConfigurationManager.getBundle().getString(TD_TC_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_testcaseBean.setTestCaseSummary(rqSummary);
			_testcaseBean.setTestCaseEntityKey(ConfigurationManager.getBundle().getString(TD_TC_KEY));
			_testcaseBean.setTestCaseID(ConfigurationManager.getBundle().getLong(TD_TC_ID));
			_testcaseBean.setTestCaseVersionID(ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));

			Reporter.log("TD:Created Testcase Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testcase Key - " + ConfigurationManager.getBundle().getString(TD_TC_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testcase ID - " + ConfigurationManager.getBundle().getLong(TD_TC_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Testcase version ID - " + ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TC_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_TC_KEY, ConfigurationManager.getBundle().getString(TD_TC_KEY));
			CommonPage.storeTestDataProperties(TD_TC_ID, ConfigurationManager.getBundle().getLong(TD_TC_ID));
			CommonPage.storeTestDataProperties(TD_TC_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testcase - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testcase - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testcaseBean;
	}

	/**
	 * This method will clear all stored properties.
	 * 
	 * @author yogesh.pathrabe
	 */
	public static void clearProperties() {

		CommonPage.storeProperties(RQ_ROOT_FOLDER_ID, "");
		CommonPage.storeProperties(TC_ROOT_FOLDER_ID, "");
		CommonPage.storeProperties(TS_ROOT_FOLDER_ID, "");
		CommonPage.storeProperties(PROJECT_ID, "");
		CommonPage.storeProperties(PROJECT_NAME, "");
		CommonPage.storeProperties(PROJECT_KEY, "");

		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_BLOCKER_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_TRIVIAL_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_CRITICAL_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_MINOR_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_PRIORITY_MAJOR_ID, "");

		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_TYPE_BUG_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_TYPE_ENHANCEMENT_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_ISSUE_TYPE_NEW_FEATURE_ID, "");

		CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_BLOCKER_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_CRITICAL_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_MAJOR_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_MINOR_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_PRIORITY_TRIVIAL_ID, "");

		CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_NEW_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_OPEN_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_ON_HOLD_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_REJECTED_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_IN_PROGRESS_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_REQUIREMENT_STATE_APPROVED_ID, "");

		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_NEW_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_OPEN_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_ON_HOLD_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_REJECTED_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_IN_PROGRESS_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTCASE_STATE_APPROVED_ID, "");

		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_NEW_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_OPEN_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_ON_HOLD_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_REJECTED_ID, "");
		CommonPage.storeProperties(TestDataSetupConstants.KEY_TESTSUITE_STATE_IN_PROGRESS_ID, "");
	}

	/**
	 * This method will clear all stored properties.
	 * 
	 * @author yogesh.pathrabe
	 */
	public static void clearUDFProperties() {
		CommonPage.storeUDFProperties(UDF_STRING_FIELD_NAME, "");
		CommonPage.storeUDFProperties(UDF_STRING_FIELD_LABEL, "");
		CommonPage.storeUDFProperties(UDF_STRING_FIELD_LENGTH, "");
		CommonPage.storeUDFProperties(UDF_LARGETEXT_FIELD_NAME, "");
		CommonPage.storeUDFProperties(UDF_LARGETEXT_FIELD_LABEL, "");
		CommonPage.storeUDFProperties(UDF_LOOKUPLIST_FIELD_NAME, "");
		CommonPage.storeUDFProperties(UDF_LOOKUPLIST_FIELD_LABEL, "");
		CommonPage.storeUDFProperties(UDF_LOOKUPLIST_LIST_NAME, "");
		CommonPage.storeUDFProperties(UDF_LOOKUPLIST_VALUE, "");
		CommonPage.storeUDFProperties(UDF_LOOKUPLIST_ALIAS, "");
		CommonPage.storeUDFProperties(UDF_MULTI_LOOKUPLIST_FIELD_NAME, "");
		CommonPage.storeUDFProperties(UDF_MULTI_LOOKUPLIST_FIELD_LABEL, "");
		CommonPage.storeUDFProperties(UDF_MULTI_LOOKUPLIST_LIST_NAME, "");
		CommonPage.storeUDFProperties(UDF_MULTI_LOOKUPLIST_VALUE, "");
		CommonPage.storeUDFProperties(UDF_MULTI_LOOKUPLIST_ALIAS, "");
		CommonPage.storeUDFProperties(UDF_NUMBER_FIELD_NAME, "");
		CommonPage.storeUDFProperties(UDF_NUMBER_FIELD_LABEL, "");
		CommonPage.storeUDFProperties(UDF_DATE_TIME_PICKER_FIELD_NAME, "");
		CommonPage.storeUDFProperties(UDF_DATE_TIME_PICKER_FIELD_LABEL, "");
	}

	/**
	 * A method to import TestResult
	 * 
	 * @return int
	 * @author rahul.patil
	 */
	public static int importTestResultWithBuildSelectionMandatoryProject() {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		WsStep.userRequests("POST.rest.importTestResult");
		WsStep.responseShouldHaveValueAtJsonpath("Import has begun. Go to Scheduled Task to view progress.",
				"$." + ATTRIBUTE_MESSAGE);
		return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_REQUEST_ID);
	}

	/**
	 * A method to import TestResult
	 * 
	 * @return int
	 * @author rahul.patil
	 */
	public static int importTestResultWithBuild() {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		WsStep.userRequests("POST.rest.importTestResultwithbuild");
		WsStep.responseShouldHaveValueAtJsonpath("Import has begun. Go to Scheduled Task to view progress.",
				"$." + ATTRIBUTE_MESSAGE);
		return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_REQUEST_ID);
	}

	/**
	 * A method to import TestResult
	 * 
	 * @return int
	 * @author rahul.patil
	 */
	public static int importTestResultWithoutTestrunBuildAndWithTestsuiteid() {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		WsStep.userRequests("POST.rest.importTestResultwithtestsuiteid");
		WsStep.responseShouldHaveValueAtJsonpath("Import has begun. Go to Scheduled Task to view progress.",
				"$." + ATTRIBUTE_MESSAGE);
		return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_REQUEST_ID);
	}

	/**
	 * A method to import TestResult
	 * 
	 * @return int
	 * @author rahul.patil
	 */
	public static int importTestResultWithTestrunBuildAndWithTestsuiteid() {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		WsStep.userRequests("POST.rest.importTestResultwithtestsuiteid");
		WsStep.responseShouldHaveValueAtJsonpath("Import has begun. Go to Scheduled Task to view progress.",
				"$." + ATTRIBUTE_MESSAGE);
		return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_REQUEST_ID);
	}

	/**
	 * A method to create a project
	 * 
	 * @return ProjectBean
	 * @author nidhi.shah
	 */
	public static ProjectBean createProject(ProjectBean projectBean) {
		Reporter.log("TD:Create Project - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			String projectName = projectBean.getProjectName();
			String projectKey = projectBean.getProjectKey();

			ConfigurationManager.getBundle().setProperty(TD_PROJECT_NAME, projectName);
			ConfigurationManager.getBundle().setProperty(TD_PROJECT_KEY, projectKey);

			WsStep.userRequests("POST.rest.admin.project.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_PROJECT_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath("Project(" + projectName + ") added successfully.",
					"$." + ATTRIBUTE_MESSAGE);
			WsStep.sayValueAtJsonPath(TD_PROJECT_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_PROJECT_ID);

			projectBean.setProjectName(projectName);
			projectBean.setProjectKey(projectKey);
			projectBean.setProjectID(ConfigurationManager.getBundle().getLong(TD_PROJECT_ID));

			Reporter.log("TD:Created Project Name - " + projectName, MessageTypes.Info);
			Reporter.log("TD:Created Project Key - " + projectKey, MessageTypes.Info);
			Reporter.log("TD:Created Project ID - " + projectBean.getProjectID(), MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_PROJECT_NAME, projectName);
			CommonPage.storeTestDataProperties(TD_PROJECT_KEY, projectKey);
			CommonPage.storeTestDataProperties(TD_PROJECT_ID, projectBean.getProjectID());
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Project - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Project - WS Call - COMPLETED", MessageTypes.Info);
		}
		return projectBean;
	}

	/**
	 * A method to create a release
	 * 
	 * @return ProjectBean
	 * @author rahul.patil
	 * @Updated by nidhi.shah
	 */
	public static ProjectBean createCycle(ProjectBean projectBean) {
		Reporter.log("TD:Create Release - WS Call - STARTED", MessageTypes.Info);
		ProjectBean _projectBean = new ProjectBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			projectBean = new ProjectBean();
			projectBean.fillFromConfig("data.createRelease");
			String releaseName = projectBean.getReleaseName() + RandomStringGenerator.get(4, RandomizerTypes.MIXED);

			ConfigurationManager.getBundle().setProperty(TD_RELEASE_NAME, releaseName);

			WsStep.userRequests("POST.rest.admin.release.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_RELEASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_RELEASE_SUCCESSFUL_MESSAGE, ATTRIBUTE_MESSAGE);
			WsStep.sayValueAtJsonPath(TD_RELEASE_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_RELEASE_ID);
			WsStep.sayValueAtJsonPath(TD_BUILD_ID,
					"$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_BUILDS + "[0]." + ATTRIBUTE_BUILD_ID);

			_projectBean.setReleaseName(releaseName);
			_projectBean.setReleaseID(ConfigurationManager.getBundle().getLong(TD_RELEASE_ID));
			_projectBean.setBuildID(ConfigurationManager.getBundle().getLong(TD_BUILD_ID));
			Reporter.log("TD:Created Release Name - " + releaseName, MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_RELEASE_NAME, releaseName);
			CommonPage.storeTestDataProperties(TD_RELEASE_ID, ConfigurationManager.getBundle().getLong(TD_RELEASE_ID));
			CommonPage.storeTestDataProperties(TD_BUILD_ID, ConfigurationManager.getBundle().getLong(TD_BUILD_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Release - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Release - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _projectBean;
	}

	/**
	 * A method to get status of import result operation
	 * 
	 * @param requestId
	 * @return String
	 * @author rahul.patil
	 */
	public static String importAutomationResult(int requestId) {
		Reporter.log("TD:Import Automation Result - WS Call - STARTED", MessageTypes.Info);
		ConfigurationManager.getBundle().setProperty(REQUEST_ID, requestId);
		WsStep.userRequests("GET.rest.importAutomationResult");
		WsStep.responseShouldHaveValueAtJsonpath(requestId, "$." + ATTRIBUTE_REQUEST_ID);
		return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_STATUS);
	}

	@Test(enabled = true)
	public void clear_data_properties() {
		clearProperties();
	}

	@Test(enabled = true)
	public void clear_udf_data_properties() {
		clearUDFProperties();
	}

	public static void createDataParameter() {
		Reporter.log("TD:Create Data Parameter - WS Call - STARTED", MessageTypes.Info);
		ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
		WsStep.userRequests("POST.rest.new.parameter");

		/*
		 * Reporter.log("Response body:\n" + JsonFormatter.prettyPrint(new
		 * RestTestBase().getResponse().getMessageBody()));
		 * System.out.println(JsonFormatter.prettyPrint(new
		 * RestTestBase().getResponse().getMessageBody()) + "");
		 * System.out.println(JsonFormatter.prettyPrint(new
		 * RestTestBase().getResponse().toString()) + "");
		 */
		WsStep.responseShouldHaveStatusCode(STATUS_OK);
		WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
	}

	public static void createDataParameter1() {
		WebResource webResource = new RestTestBase().getWebResource("https://qtm8-qacloud.qmetry.com",
				"/rest/parameter");

		String body = "{\"paramName\":\"TestApiMK18023waaeerabc\",\"values\": [\"value\"],\"projectIDs\": [14092]}}";

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("apikey", ConfigurationManager.getBundle().getString("user.open.api.key"))
				.header("project", "QTMUIProjectG4a0").header("Accept-Language", "en-US")
				.header("Accept-Encoding", "gzip, deflate").post(ClientResponse.class, body);

		System.out.println("===>" + response.getStatus());
		System.out.println("===>" + new RestTestBase().getResponse().getMessageBody());
	}

	public static Object getDataParameterId(String paramName) {
		Reporter.log("TD:Create Data Parameter - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			WsStep.userRequests("POST.rest.testcases.parameter.list");
			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));
			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					"Data" + "[*]." + "Name");
			int foundCount = 0;
			for (Object value : actualValues) {
				if (paramName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
							"Data" + "[" + foundCount + "]." + "paramID");
				}
				foundCount++;
			}
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Requirement - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Requirement - WS Call - COMPLETED", MessageTypes.Info);
		}
		return paramName;
	}

	/**
	 * A method to create an Issue
	 * 
	 * @return IssueBean
	 * @author nidhi.shah
	 */
	public static IssueBean createIssue1(IssueBean issueBean) {
		Reporter.log("TD:Create Issue - WS Call - STARTED", MessageTypes.Info);
		IssueBean _issueBean = new IssueBean();
		try {
			String issueName = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			issueName = "WS_" + issueBean.getIssueSummary() + "_" + RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_IS_SUMMARY, issueName);
			ConfigurationManager.getBundle().setProperty(TD_IS_PRIORITY, issueBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_IS_TYPE, issueBean.getType());
			WsStep.userRequests("PUT.rest.save.data.grid");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_ISSUE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_IS_KEY, "$." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_IS_ID, "$." + ATTRIBUTE_DFID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Issue " + ConfigurationManager.getBundle().getString(TD_IS_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_issueBean.setIssueSummary(issueName);
			_issueBean.setIssueEntityKey(ConfigurationManager.getBundle().getString(TD_IS_KEY));
			_issueBean.setDefectID(ConfigurationManager.getBundle().getLong(TD_IS_ID));

			Reporter.log("TD:Created Issue Summary - " + issueName, MessageTypes.Info);
			Reporter.log("TD:Created Issue Key - " + ConfigurationManager.getBundle().getString(TD_IS_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Issue ID - " + ConfigurationManager.getBundle().getLong(TD_IS_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_IS_SUMMARY, issueName);
			CommonPage.storeTestDataProperties(TD_IS_KEY, ConfigurationManager.getBundle().getString(TD_IS_KEY));
			CommonPage.storeTestDataProperties(TD_IS_ID, ConfigurationManager.getBundle().getLong(TD_IS_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating an Issue - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Issue - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _issueBean;
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static TestCaseBean createTestcaseWithoutStep(TestCaseBean testcaseBean) {
		Reporter.log("TD:Create Testcase - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testcaseBean = new TestCaseBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + testcaseBean.getTestCaseSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_TC_PRIORITY_ID, testcaseBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_TC_STATE_ID, testcaseBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID, testcaseBean.getTestcaseFolderID());

			WsStep.userRequests("POST.rest.testcases.create.tc.without.step");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTCASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_TC_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TC_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_TC_VERSION_ID, "$.data[0]." + ATTRIBUTE_TC_VERSION_ID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Test Case " + ConfigurationManager.getBundle().getString(TD_TC_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_testcaseBean.setTestCaseSummary(rqSummary);
			_testcaseBean.setTestCaseEntityKey(ConfigurationManager.getBundle().getString(TD_TC_KEY));
			_testcaseBean.setTestCaseID(ConfigurationManager.getBundle().getLong(TD_TC_ID));
			_testcaseBean.setTestCaseVersionID(ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));

			Reporter.log("TD:Created Testcase Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testcase Key - " + ConfigurationManager.getBundle().getString(TD_TC_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testcase ID - " + ConfigurationManager.getBundle().getLong(TD_TC_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Testcase version ID - " + ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TC_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_TC_KEY, ConfigurationManager.getBundle().getString(TD_TC_KEY));
			CommonPage.storeTestDataProperties(TD_TC_ID, ConfigurationManager.getBundle().getLong(TD_TC_ID));
			CommonPage.storeTestDataProperties(TD_TC_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testcase - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testcase - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testcaseBean;
	}

	/**
	 * A method to create an Issue
	 * 
	 * @return IssueBean
	 * @author nidhi.shah
	 */
	public static IssueBean createIssueWithRelease(IssueBean issueBean, ProjectBean projectBean) {
		Reporter.log("TD:Create Issue - WS Call - STARTED", MessageTypes.Info);
		IssueBean _issueBean = new IssueBean();
		try {
			String issueName = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			issueName = "WS_" + issueBean.getIssueSummary() + "_" + RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_IS_SUMMARY, issueName);
			ConfigurationManager.getBundle().setProperty(TD_IS_PRIORITY, issueBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_IS_TYPE, issueBean.getType());
			ConfigurationManager.getBundle().setProperty(TD_RELEASE_ID, projectBean.getReleaseID());
			WsStep.userRequests("POST.rest.withrelease.create.issue");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_ISSUE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_IS_KEY, "$." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_IS_ID, "$." + ATTRIBUTE_DFID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Issue " + ConfigurationManager.getBundle().getString(TD_IS_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_issueBean.setIssueSummary(issueName);
			_issueBean.setIssueEntityKey(ConfigurationManager.getBundle().getString(TD_IS_KEY));
			_issueBean.setDefectID(ConfigurationManager.getBundle().getLong(TD_IS_ID));

			Reporter.log("TD:Created Issue Summary - " + issueName, MessageTypes.Info);
			Reporter.log("TD:Created Issue Key - " + ConfigurationManager.getBundle().getString(TD_IS_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Issue ID - " + ConfigurationManager.getBundle().getLong(TD_IS_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_IS_SUMMARY, issueName);
			CommonPage.storeTestDataProperties(TD_IS_KEY, ConfigurationManager.getBundle().getString(TD_IS_KEY));
			CommonPage.storeTestDataProperties(TD_IS_ID, ConfigurationManager.getBundle().getLong(TD_IS_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating an Issue - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Issue - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _issueBean;
	}

	/**
	 * A method to create a RQ Folder
	 * 
	 * @return PlatformBean
	 * @author by nidhi.shah
	 */
	public static AutomationAgentBean createAutomationAgent() {
		Reporter.log("TD:Create RQ Folder - WS Call - STARTED", MessageTypes.Info);
		AutomationAgentBean automationAgentBean = new AutomationAgentBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			String agentName = "WS_Auto_Agent_" + RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_AGENT_NAME, agentName);

			WsStep.userRequests("POST.rest.admin.create.agent");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath("Agent alias created successfully.", ATTRIBUTE_MESSAGE);

			WsStep.sayValueAtJsonPath(TD_AGENT_ID, "$." + ATTRIBUTE_AGENT_ID);

			automationAgentBean.setAgentName(agentName);
			automationAgentBean.setAgentID(ConfigurationManager.getBundle().getLong(TD_AGENT_ID));

			Reporter.log("TD:Created Agent Name - " + agentName, MessageTypes.Info);
			CommonPage.storeTestDataProperties(TD_AGENT_NAME, agentName);
			CommonPage.storeTestDataProperties(TD_AGENT_ID, ConfigurationManager.getBundle().getLong(TD_AGENT_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a RQ Folder - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create RQ Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return automationAgentBean;
	}

	/**
	 * A method to create a RQ Folder
	 * 
	 * @return PlatformBean
	 * @author by nidhi.shah
	 */
	public static AutomationAgentBean registerAutomationAgent(AutomationAgentBean automationAgentBean) {
		Reporter.log("TD:Create RQ Folder - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			ConfigurationManager.getBundle().setProperty(TD_OS_NAME, automationAgentBean.getOSName());
			ConfigurationManager.getBundle().setProperty(TD_AGENT_ID, automationAgentBean.getAgentID());

			WsStep.userRequests("POST.rest.admin.register.agent");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.sayValueAtJsonPath(TD_UID, "$." + ATTRIBUTE_UID);
			automationAgentBean.setAgentUID(ConfigurationManager.getBundle().getString(TD_UID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while registaring agent - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create RQ Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return automationAgentBean;
	}

	/**
	 * A method to create a RQ Folder
	 * 
	 * @return PlatformBean
	 * @author by nidhi.shah
	 */
	public static AutomationAgentBean inactiveAutomationAgent(AutomationAgentBean automationAgentBean) {
		Reporter.log("TD:Create RQ Folder - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			ConfigurationManager.getBundle().setProperty(TD_AGENT_ID, automationAgentBean.getAgentID());

			WsStep.userRequests("POST.rest.admin.inactive.agent");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath("Agent Stopped Successfully", ATTRIBUTE_MESSAGE);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while registaring agent - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create RQ Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return automationAgentBean;
	}

	/**
	 * A method to create a RQ Folder
	 * 
	 * @return PlatformBean
	 * @author by nidhi.shah
	 */
	public static AutomationAgentBean deleteAutomationAgent(AutomationAgentBean automationAgentBean) {
		Reporter.log("TD:Create RQ Folder - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			ConfigurationManager.getBundle().setProperty(TD_AGENT_ID, automationAgentBean.getAgentID());

			WsStep.userRequests("POST.rest.admin.delete.agent");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveValueAtJsonpath("Agent deleted successfully.", ATTRIBUTE_MESSAGE);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while registaring agent - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create RQ Folder - WS Call - COMPLETED", MessageTypes.Info);
		}
		return automationAgentBean;
	}

	/**
	 * A method to link Testcase To Requirement1
	 * 
	 * @param requestId
	 * @return String
	 * @author priyanka.devaliya
	 */

	public static void linkTestcaseToRequirement1(RequirementBean requirementBean, TestCaseBean testCaseBean) {

		// RequirementBean _RequirementBean = new RequirementBean();
		WebResource webResource = new RestTestBase().getWebResource("/rest/requirements/link/testcases");

		ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

		String body = "{\"rqID\":\"" + requirementBean.getRequirementEntityKey() + "\",\"rqVersionId\":"
				+ requirementBean.getrequirementVersionID() + ",\"tcVersionIds\":\""
				+ testCaseBean.getTestCaseVersionID() + "\"}";

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("apikey", ConfigurationManager.getBundle().getString("user.open.api.key"))
				.header("project", ConfigurationManager.getBundle().getString("project.name"))
				.header("Accept-Language", "en-US").header("Accept-Encoding", "gzip, deflate")
				.put(ClientResponse.class, body);

		System.out.println("===>" + response.getStatus());

		System.out.println("===>" + new RestTestBase().getResponse().getMessageBody());

	}

	public static DataParameterBean createDataParameter1(DataParameterBean dataParameterBean) {

		DataParameterBean _dataParameterBean = new DataParameterBean();
		WebResource webResource = new RestTestBase().getWebResource("rest/parameter");

		ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

		String rqSummary = "WS_" + dataParameterBean.getParamName() + "_"
				+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
		ConfigurationManager.getBundle().setProperty(TD_PARAM_DES, rqSummary);
		ConfigurationManager.getBundle().setProperty(TD_PARAM_NAME, dataParameterBean.getParamName());
		ConfigurationManager.getBundle().setProperty(TD_PARAM_VALUES, dataParameterBean.getValues());
		ConfigurationManager.getBundle().setProperty(TD_PROJECT_IDS, dataParameterBean.getParamProject());

		String body = "{\"paramName\":\"" + dataParameterBean.getParamName() + "\",\"values\":[\""
				+ dataParameterBean.getValues() + "\"],\"projectIDs\": [" + dataParameterBean.getParamProject() + "]}";
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("apikey", ConfigurationManager.getBundle().getString("user.open.api.key"))
				.header("project", ConfigurationManager.getBundle().getString("project.name"))
				.header("Accept-Language", "en-US").header("Accept-Encoding", "gzip, deflate")
				.post(ClientResponse.class, body);

		System.out.println("===>" + response.getStatus());

		System.out.println("===>" + new RestTestBase().getResponse().getMessageBody());

		// WsStep.responseShouldHaveValueAtJsonpath(dataParameterBean.getParamName(),
		// "$.data[0]." + ATTRIBUTE_NAME);
		// WsStep.sayValueAtJsonPath(TD_PARAM_ID, "$." + ATTRIBUTE_DATA + "[0]." +
		// ATTRIBUTE_PARAM_ID);

		_dataParameterBean.setParamName(dataParameterBean.getParamName());
		_dataParameterBean.setparamID(ConfigurationManager.getBundle().getString("td.param.id"));
		// _dataParameterBean.setparamID(ConfigurationManager.getBundle().getString("td.param.values"));

		return _dataParameterBean;

	}

	public static void createDataGrid(DataParameterBean dataParameterBean, DataGridBean dataGridBean) {

		WebResource webResource = new RestTestBase().getWebResource("/rest/datagrid/create");

		ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

		String body = "{\"name\":\"" + dataGridBean.getDataGridName() + "\",\"projectIDs\": ["
				+ dataParameterBean.getParamProject() + "],\"parameters\":[{\"orderID\":" + 1 + ",\"paramID\":" + 10930
				+ ",\"parameterValues\":[{\"orderID\":" + 1 + ",\"value\":\"" + dataParameterBean.getParamValue()
				+ "\"}]}]}";

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("apikey", ConfigurationManager.getBundle().getString("user.open.api.key"))
				.header("project", ConfigurationManager.getBundle().getString("project.name"))
				.header("Accept-Language", "en-US").header("Accept-Encoding", "gzip, deflate")
				.post(ClientResponse.class, body);

		System.out.println("===>" + response.getStatus());

		System.out.println("===>" + new RestTestBase().getResponse().getMessageBody());

	}

	/** parameter with multiple project */
	public static DataParameterBean createDataParameter3(DataParameterBean dataParameterBean) {

		DataParameterBean _dataParameterBean = new DataParameterBean();
		WebResource webResource = new RestTestBase().getWebResource("rest/parameter");

		ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

		String rqSummary = "WS_" + dataParameterBean.getParamName() + "_"
				+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
		ConfigurationManager.getBundle().setProperty(TD_PARAM_DES, rqSummary);
		ConfigurationManager.getBundle().setProperty(TD_PARAM_NAME, dataParameterBean.getParamName());
		ConfigurationManager.getBundle().setProperty(TD_PARAM_VALUES, dataParameterBean.getValues());
		ConfigurationManager.getBundle().setProperty(TD_PROJECT_IDS, dataParameterBean.getParamProjects());

		String body = "{\"paramName\":\"" + dataParameterBean.getParamName() + "\",\"values\":[\""
				+ dataParameterBean.getValues() + "\"],\"projectIDs\": " + dataParameterBean.getParamProjects() + "}";
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("apikey", ConfigurationManager.getBundle().getString("user.open.api.key"))
				.header("project", ConfigurationManager.getBundle().getString("project.name"))
				.header("Accept-Language", "en-US").header("Accept-Encoding", "gzip, deflate")
				.post(ClientResponse.class, body);

		System.out.println("===>" + response.getStatus());

		System.out.println("===>" + new RestTestBase().getResponse().getMessageBody());
		_dataParameterBean.setParamName(dataParameterBean.getParamName());
		_dataParameterBean.setparamID(ConfigurationManager.getBundle().getString("td.param.id"));
		// _dataParameterBean.setparamID(ConfigurationManager.getBundle().getString("td.param.values"));

		return _dataParameterBean;
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author priyanka.devaliya
	 */
	public static TestCaseBean createTestcaseWithFourStep(TestCaseBean testcaseBean) {
		Reporter.log("TD:Create Testcase - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testcaseBean = new TestCaseBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + testcaseBean.getTestCaseSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_TC_PRIORITY_ID, testcaseBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_TC_STATE_ID, testcaseBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID, testcaseBean.getTestcaseFolderID());

			WsStep.userRequests("POST.rest.testcases.create.four.step.tc");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTCASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_TC_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TC_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_TC_VERSION_ID, "$.data[0]." + ATTRIBUTE_TC_VERSION_ID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Test Case " + ConfigurationManager.getBundle().getString(TD_TC_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_testcaseBean.setTestCaseSummary(rqSummary);
			_testcaseBean.setTestCaseEntityKey(ConfigurationManager.getBundle().getString(TD_TC_KEY));
			_testcaseBean.setTestCaseID(ConfigurationManager.getBundle().getLong(TD_TC_ID));
			_testcaseBean.setTestCaseVersionID(ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));

			Reporter.log("TD:Created Testcase Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testcase Key - " + ConfigurationManager.getBundle().getString(TD_TC_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testcase ID - " + ConfigurationManager.getBundle().getLong(TD_TC_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Testcase version ID - " + ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TC_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_TC_KEY, ConfigurationManager.getBundle().getString(TD_TC_KEY));
			CommonPage.storeTestDataProperties(TD_TC_ID, ConfigurationManager.getBundle().getLong(TD_TC_ID));
			CommonPage.storeTestDataProperties(TD_TC_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testcase - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testcase - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testcaseBean;
	}

	/**
	 * A method to link Requirement To Testcase
	 * 
	 * @param requestId
	 * @return String
	 * @author priyanka.devaliya
	 */

	public static void linkRequirementToTestcase(RequirementBean requirementBean, TestCaseBean testCaseBean) {

		// RequirementBean _RequirementBean = new RequirementBean();
		WebResource webResource = new RestTestBase().getWebResource("/rest/testcases/link/requirements");

		ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

		String body = "{\"tcID\":\"" + testCaseBean.getTestCaseEntityKey() + "\",\"rqVersionIds\":"
				+ requirementBean.getrequirementVersionID() + ",\"tcVersionId\":\""
				+ testCaseBean.getTestCaseVersionID() + "\"}";

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("apikey", ConfigurationManager.getBundle().getString("user.open.api.key"))
				.header("project", ConfigurationManager.getBundle().getString("project.name"))
				.header("Accept-Language", "en-US").header("Accept-Encoding", "gzip, deflate")
				.put(ClientResponse.class, body);

		System.out.println("===>" + response.getStatus());

		System.out.println("===>" + new RestTestBase().getResponse().getMessageBody());

	}

	/**
	 * A method to create a release
	 * 
	 * @return BuildBean
	 * @author rahul.patil
	 * @Updated by rahul.patil
	 */
	public static BuildBean createBuild(ProjectBean projectBean) {
		Reporter.log("TD:Create Build - WS Call - STARTED", MessageTypes.Info);
		BuildBean _buildBean = new BuildBean();
		try {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");
			BuildBean buildBean = new BuildBean();
			buildBean.fillFromConfig("data.createbuild");
			String buildName = buildBean.getBuildName() + RandomStringGenerator.get(4, RandomizerTypes.MIXED);

			ConfigurationManager.getBundle().setProperty(TD_BUILD_NAME, buildName);
			ConfigurationManager.getBundle().setProperty(TD_RELEASE_ID, projectBean.getReleaseID());
			ConfigurationManager.getBundle().setProperty(TD_BUILD_ID, projectBean.getBuildID());

			WsStep.userRequests("POST.rest.admin.build.create");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_DROP_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_BUILD_SUCCESSFUL_MESSAGE, ATTRIBUTE_MESSAGE);
			WsStep.sayValueAtJsonPath(TD_DROP_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_DROP_ID);

			_buildBean.setBuildName(buildName);
			_buildBean.setDropID(ConfigurationManager.getBundle().getLong(TD_DROP_ID));
			Reporter.log("TD:Created Build Name - " + buildName, MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_BUILD_NAME, buildName);
			CommonPage.storeTestDataProperties(TD_DROP_ID, ConfigurationManager.getBundle().getLong(TD_DROP_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Build - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Release - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _buildBean;
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static void getExecutionRunId(TestSuiteBean testSuiteBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty(TD_TS_ID, testSuiteBean.getTestsuiteID());

			WsStep.userRequests("POST.rest.execution.list");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.sayValueAtJsonPath(TD_TS_RUN_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_TS_RUN_ID);

			CommonPage.storeTestDataProperties(TD_TS_RUN_ID, ConfigurationManager.getBundle().getLong(TD_TS_RUN_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static void setBuildToTestRun(BuildBean buildBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty(TD_DROP_ID, buildBean.getDropID());

			WsStep.userRequests("POST.rest.set.build");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));
			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static void getTestCaseRunId() {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {

			WsStep.userRequests("POST.rest.get.testcase.run.id");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.sayValueAtJsonPath(TD_TC_RUN_ID, "$." + ATTRIBUTE_DATA + "[0]." + ATTRIBUTE_TC_RUN_ID);

			CommonPage.storeTestDataProperties(TD_TC_RUN_ID, ConfigurationManager.getBundle().getLong(TD_TC_RUN_ID));

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author nidhi.shah
	 */
	public static void setStatusToTestRun(TestSuiteBean testSuiteBean) {
		Reporter.log("TD:Create Testsuite - WS Call - STARTED", MessageTypes.Info);
		try {
			ConfigurationManager.getBundle().setProperty(TD_RUN_STATUS_ID, testSuiteBean.getTestcaseRunStatusID());

			WsStep.userRequests("POST.rest.set.testcase.run.status");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));
			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);

		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testsuite - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testsuite - WS Call - COMPLETED", MessageTypes.Info);
		}
	}

	/**
	 * A method to create an Testcase
	 * 
	 * @param testcaseBean
	 * @return TestcaseBean
	 * @author priyanka.devaliya
	 */
	public static TestCaseBean createTestcaseWithTwentyTwoStep(TestCaseBean testcaseBean) {
		Reporter.log("TD:Create Testcase - WS Call - STARTED", MessageTypes.Info);
		TestCaseBean _testcaseBean = new TestCaseBean();
		try {
			String rqSummary = null;
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/webservice");

			rqSummary = "WS_" + testcaseBean.getTestCaseSummary() + "_"
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED);
			ConfigurationManager.getBundle().setProperty(TD_TC_SUMMARY, rqSummary);
			ConfigurationManager.getBundle().setProperty(TD_TC_PRIORITY_ID, testcaseBean.getPriority());
			ConfigurationManager.getBundle().setProperty(TD_TC_STATE_ID, testcaseBean.getStatus());
			ConfigurationManager.getBundle().setProperty(TD_TC_PARENT_FOLDER_ID, testcaseBean.getTestcaseFolderID());

			WsStep.userRequests("POST.rest.testcases.create.twentytwo.step.tc");

			Reporter.log(
					"Response body:\n" + JsonFormatter.prettyPrint(new RestTestBase().getResponse().getMessageBody()));

			WsStep.responseShouldHaveStatusCode(STATUS_OK);
			WsStep.responseShouldHaveValueAtJsonpath(SUCCESS_TRUE, "$." + ATTRIBUTE_SUCCESS);
			WsStep.responseShouldHaveValueAtJsonpath(ADD_TESTCASE_SUCCESSFUL_CODE, "$." + ATTRIBUTE_CODE);
			WsStep.sayValueAtJsonPath(TD_TC_KEY, "$.data[0]." + ATTRIBUTE_ENTITY_KEY);
			WsStep.sayValueAtJsonPath(TD_TC_ID, "$.data[0]." + ATTRIBUTE_ID);
			WsStep.sayValueAtJsonPath(TD_TC_VERSION_ID, "$.data[0]." + ATTRIBUTE_TC_VERSION_ID);
			WsStep.responseShouldHaveValueAtJsonpath(
					"New Test Case " + ConfigurationManager.getBundle().getString(TD_TC_KEY) + " created successfully.",
					"$." + ATTRIBUTE_MESSAGE);

			_testcaseBean.setTestCaseSummary(rqSummary);
			_testcaseBean.setTestCaseEntityKey(ConfigurationManager.getBundle().getString(TD_TC_KEY));
			_testcaseBean.setTestCaseID(ConfigurationManager.getBundle().getLong(TD_TC_ID));
			_testcaseBean.setTestCaseVersionID(ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));

			Reporter.log("TD:Created Testcase Summary - " + rqSummary, MessageTypes.Info);
			Reporter.log("TD:Created Testcase Key - " + ConfigurationManager.getBundle().getString(TD_TC_KEY),
					MessageTypes.Info);
			Reporter.log("TD:Created Testcase ID - " + ConfigurationManager.getBundle().getLong(TD_TC_ID),
					MessageTypes.Info);
			Reporter.log(
					"TD:Created Testcase version ID - " + ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID),
					MessageTypes.Info);

			CommonPage.storeTestDataProperties(TD_TC_SUMMARY, rqSummary);
			CommonPage.storeTestDataProperties(TD_TC_KEY, ConfigurationManager.getBundle().getString(TD_TC_KEY));
			CommonPage.storeTestDataProperties(TD_TC_ID, ConfigurationManager.getBundle().getLong(TD_TC_ID));
			CommonPage.storeTestDataProperties(TD_TC_VERSION_ID,
					ConfigurationManager.getBundle().getLong(TD_TC_VERSION_ID));
		} catch (Exception e) {
			Reporter.log("TD:Error happened while Creating a Testcase - ", MessageTypes.Fail);
			Reporter.log(e.getMessage(), MessageTypes.Fail);
			Reporter.log(e.getStackTrace().toString(), MessageTypes.Fail);
		} finally {
			ConfigurationManager.getBundle().setProperty("env.resources", "resources/web");
			Reporter.log("TD:Create Testcase - WS Call - COMPLETED", MessageTypes.Info);
		}
		return _testcaseBean;
	}

}
