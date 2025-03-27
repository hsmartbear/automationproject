package com.qmetry.constants;

/**
 * This interface defines TestDataSetupConstants.
 * 
 * @author nidhi.shah
 */
public interface TestDataSetupConstants extends CommonConstants {

    // JSON attribute properties
    public static final String ATTRIBUTE_SUCCESS = "success";
    public static final String ATTRIBUTE_CODE = "code";
    public static final String ATTRIBUTE_MESSAGE = "message";
    public static final String ATTRIBUTE_DATA = "data";
    public static final String ATTRIBUTE_PROJECT_ID = "projectID";
    public static final String ATTRIBUTE_RELEASE_ID = "releaseID";
    public static final String ATTRIBUTE_ROOT_FOLDERS = "rootFolders";
    public static final String ATTRIBUTE_RQ = "RQ";
    public static final String ATTRIBUTE_TC = "TC";
    public static final String ATTRIBUTE_TS = "TS";
    public static final String ATTRIBUTE_ID = "id";
    public static final String ATTRIBUTE_CUSTOM_LIST_OBJS = "customListObjs";
    public static final String ATTRIBUTE_PRIORITY = "priority";
    public static final String ATTRIBUTE_ISSUE_PRIORITY = "issuePriority";
    public static final String ATTRIBUTE_NAME = "name";
    public static final String ATTRIBUTE_ISSUE_TYPE = "issueType";
    public static final String ATTRIBUTE_DFID = "dfId";
    public static final String ATTRIBUTE_RQ_STATE = "requirementState";
    public static final String ATTRIBUTE_TC_STATE = "testCaseState";
    public static final String ATTRIBUTE_TS_STATE = "testSuiteState";
    public static final String ATTRIBUTE_ENTITY_KEY = "entityKey";
    public static final String STRING_RESPONSE_DOESNT_HAVE = "Response doesn't have ";
    public static final String ATTRIBUTE_TC_VERSION_ID = "tcVersionId";
    public static final String ATTRIBUTE_TS_ENTITY_KEY = "ENTITY_KEY";
    public static final String ATTRIBUTE_BUILD_ID = "buildID";
    public static final String ATTRIBUTE_BUILDS = "builds";
    public static final String ATTRIBUTE_PLATFORM_ID = "platformID";
    public static final String ATTRIBUTE_CURRENT_PROJECT_ID = "currentProjectId";
    public static final String ATTRIBUTE_REQUEST_ID = "requestId";
    public static final String ATTRIBUTE_STATUS = "status";
    public static final String ATTRIBUTE_AGENT_ID = "agentId";
    public static final String ATTRIBUTE_UID = "uid";
    public static final String ATTRIBUTE_RQ_VERSION_ID = "rqVersionId";
    public static final String ATTRIBUTE_DROP_ID = "dropID";
    public static final String ATTRIBUTE_TS_RUN_ID = "tsRunID";
    public static final String ATTRIBUTE_TC_RUN_ID = "tcRunID";

    public static final String ATTRIBUTE_CURRENT_BUILD_ID = "currentBuildId";
    public static final String ATTRIBUTE_LATESTVIEWS = "latestViews";
    public static final String ATTRIBUTE_TE = "TE";
    public static final String ATTRIBUTE_VIEW_ID = "viewId";
    public static final String ATTRIBUTE_ALL_STATUS = "allstatus";

    // Response payload
    // Project
    public static final String ADD_PROJECT_SUCCESSFUL_CODE = "AD.PROJECT_SUCCESSFUL";
    public static final String ADD_RELEASE_SUCCESSFUL_CODE = "AD.RELEASE_SUCCESSFUL";
    public static final String ADD_FOLDER_SUCCESSFUL_CODE = "CO.ADD_FOLDER_SUCCESS";
    public static final String ADD_ISSUE_SUCCESSFUL_CODE = "IS.ADD_ENTITY_SUCCESS";
    public static final String ADD_REQUIREMENT_SUCCESSFUL_CODE = "RQ.ADD_ENTITY_SUCCESS";
    public static final String ADD_TESTCASE_SUCCESSFUL_CODE = "TC.ADD_ENTITY_SUCCESS";
    public static final String ADD_RELEASE_SUCCESSFUL_MESSAGE = "Release added successfully.";
    public static final String ADD_FOLDER_SUCCESSFUL_MESSAGE = "Folder added successfully.";
    public static final String ADD_TESTSUITE_SUCCESSFUL_CODE = "TS.ADD_TS_SUCCESS";
    public static final String LINK_TESTCASE_TO_TESTSUITE_SUCCESSFUL_MESSAGE = "Selected entities linked successfully.";
    public static final String ADD_DROP_SUCCESSFUL_CODE = "AD.ADD_DROP_SUCCESS";
    public static final String ADD_BUILD_SUCCESSFUL_MESSAGE = "Build added successfully.";

    // Request paylod attributes
    public static final String TD_PROJECT_NAME = "td.project.name";
    public static final String TD_PROJECT_KEY = "td.project.key";
    public static final String TD_PROJECT_ID = "td.project.id";
    public static final String TD_RELEASE_NAME = "td.release.name";
    public static final String TD_RQ_ROOT_FOLDER_ID = "td.rq.root.folder.id";
    public static final String TD_RQ_FOLDER_NAME = "td.rq.folder.name";
    public static final String TD_RQ_PARENT_FOLDER_ID = "td.rq.parent.folder.id";
    public static final String TD_RQ_FOLDER_ID = "td.rq.folder.id";
    public static final String TD_IS_SUMMARY = "td.issue.summary";
    public static final String TD_IS_KEY = "td.issue.key";
    public static final String TD_IS_ID = "td.issue.id";
    public static final String TD_IS_PRIORITY = "td.issue.priority";
    public static final String TD_IS_TYPE = "td.issue.type";
    public static final String TD_AZURE_PROJECT_NAME = "td.azure.project.name";
    public static final String TD_AZURE_ALIAS_NAME = "td.azure.alias.name";
    public static final String TD_RALLY_PROJECT_NAME = "td.rally.project.name";
    public static final String TD_RALLY_ALIAS_NAME = "td.rally.alias.name";
    public static final String TD_JIRA_PROJECT_NAME = "td.jira.project.name";
    public static final String TD_TC_FOLDER_NAME = "td.tc.folder.name";
    public static final String TD_TC_PARENT_FOLDER_ID = "td.tc.parent.folder.id";
    public static final String TD_TC_FOLDER_ID = "td.tc.folder.id";
    public static final String TD_RQ_SUMMARY = "td.rq.summary";
    public static final String TD_RQ_PRIORITY_ID = "td.rq.priority.id";
    public static final String TD_RQ_STATE_ID = "td.rq.state.id";
    public static final String TD_RQ_KEY = "td.requirement.key";
    public static final String TD_RQ_ID = "td.requirement.id";
    public static final String TD_TC_SUMMARY = "td.tc.summary";
    public static final String TD_TC_PRIORITY_ID = "td.tc.priority.id";
    public static final String TD_TC_STATE_ID = "td.tc.state.id";
    public static final String TD_TC_KEY = "td.testcase.key";
    public static final String TD_TC_ID = "td.testcase.id";
    public static final String TD_TS_FOLDER_NAME = "td.ts.folder.name";
    public static final String TD_TS_PARENT_FOLDER_ID = "td.ts.parent.folder.id";
    public static final String TD_TS_FOLDER_ID = "td.ts.folder.id";
    public static final String TD_TS_SUMMARY = "td.ts.summary";
    public static final String TD_TS_STATE_ID = "td.ts.state.id";
    public static final String TD_TS_KEY = "td.testsuite.key";
    public static final String TD_TS_ID = "td.testsuite.id";
    public static final String TD_TC_VERSION_ID = "td.testcase.version.id";
    public static final String TD_RELEASE_ID = "td.release.id";
    public static final String TD_BUILD_ID = "td.build.id";
    public static final String TD_PLATFORM_NAME = "td.platform.name";
    public static final String TD_PLATFORM_ID = "td.platform.id";
    public static final String TD_AZURE_ENTITY_KEY = "td.azure.entity.key";
    public static final String TD_AZURE_EXTERNAL_KEY = "td.azure.external.key";
    public static final String TD_AZURE_EXTERNAL_ISSUE_SUMMARY = "td.azure.external.issue.summary";
    public static final String TD_RALLY_ENTITY_KEY = "td.rally.entity.key";
    public static final String TD_RALLY_EXTERNAL_KEY = "td.rally.external.key";
    public static final String TD_RALLY_EXTERNAL_ISSUE_SUMMARY = "td.rally.external.issue.summary";
    public static final String TD_JIRA_ENTITY_KEY = "td.jira.entity.key";
    public static final String TD_JIRA_EXTERNAL_KEY = "td.jira.external.key";
    public static final String TD_JIRA_EXTERNAL_ISSUE_SUMMARY = "td.jira.external.issue.summary";
    public static final String TD_AGENT_NAME = "td.agent.name";
    public static final String TD_AGENT_ID = "td.agent.id";
    public static final String TD_OS_NAME = "td.os.name";
    public static final String TD_UID = "td.uid";
    public static final String TD_RQ_VERSION_ID = "td.requirement.version.id";
    public static final String TD_BUILD_NAME = "td.build.name";
    public static final String TD_TS_RUN_ID = "td.ts.run.id";
    public static final String TD_DROP_ID = "td.drop.id";
    public static final String TD_TC_RUN_ID = "td.tc.run.id";
    public static final String TD_RUN_STATUS_ID = "td.run.status.id";

    // Data Attributes
    public static final String PROJECT_NAME = "project.name";
    public static final String PROJECT_KEY = "project.key";
    public static final String PROJECT_ID = "project.id";
    public static final String RQ_ROOT_FOLDER_ID = "rq.root.folder.id";
    public static final String TC_ROOT_FOLDER_ID = "tc.root.folder.id";
    public static final String TS_ROOT_FOLDER_ID = "ts.root.folder.id";
    public static final String IS_TYPE_BUG_ID = "is.type.bug.id";
    public static final String USER_ALIAS = "user.alias";
    public static final String REQUEST_ID = "request.id";

    // UDF Data Attributes
    public static final String UDF_STRING_FIELD_NAME = "udf.string.field.name";
    public static final String UDF_STRING_FIELD_LABEL = "udf.string.field.label";
    public static final String UDF_STRING_FIELD_LENGTH = "udf.string.field.length";

    public static final String UDF_LARGETEXT_FIELD_NAME = "udf.largetext.field.name";
    public static final String UDF_LARGETEXT_FIELD_LABEL = "udf.largetext.field.label";

    public static final String UDF_LOOKUPLIST_FIELD_NAME = "udf.lookuplist.field.name";
    public static final String UDF_LOOKUPLIST_FIELD_LABEL = "udf.lookuplist.field.label";
    public static final String UDF_LOOKUPLIST_LIST_NAME = "udf.lookuplist.list.name";
    public static final String UDF_LOOKUPLIST_VALUE = "udf.lookuplist.value";
    public static final String UDF_LOOKUPLIST_ALIAS = "udf.lookuplist.alias";

    public static final String UDF_MULTI_LOOKUPLIST_FIELD_NAME = "udf.multilookuplist.field.name";
    public static final String UDF_MULTI_LOOKUPLIST_FIELD_LABEL = "udf.multilookuplist.field.label";
    public static final String UDF_MULTI_LOOKUPLIST_LIST_NAME = "udf.multilookuplist.list.name";
    public static final String UDF_MULTI_LOOKUPLIST_VALUE = "udf.multilookuplist.value";
    public static final String UDF_MULTI_LOOKUPLIST_ALIAS = "udf.multilookuplist.alias";

    public static final String UDF_NUMBER_FIELD_NAME = "udf.number.field.name";
    public static final String UDF_NUMBER_FIELD_LABEL = "udf.number.field.label";

    public static final String UDF_DATE_TIME_PICKER_FIELD_NAME = "udf.datetimepicker.field.name";
    public static final String UDF_DATE_TIME_PICKER_FIELD_LABEL = "udf.datetimepicker.field.label";

    // Issue Constants

    public static final String KEY_ISSUE_PRIORITY_MINOR_ID = "issue.priority.minor.id";
    public static final String KEY_ISSUE_PRIORITY_MAJOR_ID = "issue.priority.major.id";
    public static final String KEY_ISSUE_PRIORITY_CRITICAL_ID = "issue.priority.critical.id";
    public static final String KEY_ISSUE_PRIORITY_BLOCKER_ID = "issue.priority.blocker.id";
    public static final String KEY_ISSUE_PRIORITY_TRIVIAL_ID = "issue.priority.trivial.id";

    public static final String KEY_ISSUE_TYPE_ENHANCEMENT_ID = "issue.type.enhancement.id";
    public static final String KEY_ISSUE_TYPE_BUG_ID = "issue.type.bug.id";
    public static final String KEY_ISSUE_TYPE_NEW_FEATURE_ID = "issue.type.new.feature.id";

    // Priority
    public static final String KEY_PRIORITY_MINOR_ID = "priority.minor.id";
    public static final String KEY_PRIORITY_MAJOR_ID = "priority.major.id";
    public static final String KEY_PRIORITY_CRITICAL_ID = "priority.critical.id";
    public static final String KEY_PRIORITY_BLOCKER_ID = "priority.blocker.id";
    public static final String KEY_PRIORITY_TRIVIAL_ID = "priority.trivial.id";

    // Requirement Constants

    public static final String KEY_REQUIREMENT_STATE_NEW_ID = "rq.state.new.id";
    public static final String KEY_REQUIREMENT_STATE_OPEN_ID = "rq.state.open.id";
    public static final String KEY_REQUIREMENT_STATE_ON_HOLD_ID = "rq.state.on.hold.id";
    public static final String KEY_REQUIREMENT_STATE_REJECTED_ID = "rq.state.rejected.id";
    public static final String KEY_REQUIREMENT_STATE_APPROVED_ID = "rq.state.approved.id";
    public static final String KEY_REQUIREMENT_STATE_IN_PROGRESS_ID = "rq.state.inprogress.id";

    // Testcase Constants

    public static final String KEY_TESTCASE_STATE_NEW_ID = "tc.state.new.id";
    public static final String KEY_TESTCASE_STATE_OPEN_ID = "tc.state.open.id";
    public static final String KEY_TESTCASE_STATE_ON_HOLD_ID = "tc.state.on.hold.id";
    public static final String KEY_TESTCASE_STATE_REJECTED_ID = "tc.state.rejected.id";
    public static final String KEY_TESTCASE_STATE_APPROVED_ID = "tc.state.approved.id";
    public static final String KEY_TESTCASE_STATE_IN_PROGRESS_ID = "tc.state.inprogress.id";

    // Testsuite Constants

    public static final String KEY_TESTSUITE_STATE_NEW_ID = "ts.state.new.id";
    public static final String KEY_TESTSUITE_STATE_OPEN_ID = "ts.state.open.id";
    public static final String KEY_TESTSUITE_STATE_ON_HOLD_ID = "ts.state.on.hold.id";
    public static final String KEY_TESTSUITE_STATE_REJECTED_ID = "ts.state.rejected.id";
    public static final String KEY_TESTSUITE_STATE_IN_PROGRESS_ID = "ts.state.inprogress.id";

    public static final String KEY_TESTCASE_RUN_STATUS_PASSED_ID = "tc.run.status.passed.id";
    public static final String KEY_TESTCASE_RUN_STATUS_FAILED_ID = "tc.run.status.failed.id";
    public static final String KEY_TESTCASE_RUN_STATUS_BLOCKED_ID = "tc.run.status.blocked.id";
    public static final String KEY_TESTCASE_RUN_STATUS_NOT_APPLICABLE_ID = "tc.run.status.notapplicable.id";

    // Data Attributes with shareable testcase
    public static final String STC_PROJECT_NAME = "stc.project.name";
    public static final String STC_PROJECT_KEY = "stc.project.key";
    public static final String STC_PROJECT_ID = "stc.project.id";
    public static final String STC_RQ_ROOT_FOLDER_ID = "rq.root.folder.id";
    public static final String STC_TC_ROOT_FOLDER_ID = "tc.root.folder.id";
    public static final String STC_TS_ROOT_FOLDER_ID = "ts.root.folder.id";
    public static final String STC_IS_TYPE_BUG_ID = "is.type.bug.id";
    public static final String STC_USER_ALIAS = "user.alias";
    public static final String STC_REQUEST_ID = "request.id";
    public static final String STC_ENTITY_KEY = "shareable.tc.entityKey";
    public static final String TC_ENTITY_KEY_1 = "tc.entity.key.1";
    public static final String TC_ENTITY_KEY_2 = "tc.entity.key.2";
    public static final String TC_SUMMARY_2 = "tc.summary.2";
    public static final String STC_NAME = "stc.name";

    public static final String DATA_PARAM_NAME = "data.param.name";
    public static final String DATA_PARAM_VALUE = "data.param.value";

    public static final String TD_PARAM_NAME = "td.param.name";
    public static final String TD_PARAM_DES = "td.param.description";
    public static final String TD_PROJECT_IDS = "td.project.ids";
    public static final String TD_PARAM_VALUES = "td.param.values";
    public static final String TD_PARAM_ID = "td.param.id";
    public static final String TD_DATA_GRID_NAME = "td.data.grid.name";
    public static final String TD_AWF_PROJECT_NAME = "td.awf.project.name";
    public static final String TD_AWF_PROJECT_KEY = "td.awf.project.key";
    public static final String TD_AWF_PROJECT_ID = "td.awf.project.id";

    public static final String TD_DEFAULT_CYCLE_ID = "td.default.cycle.id";
    public static final String TE_VIEW_ID = "te.view.id";

}