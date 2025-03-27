package com.qmetry.tests.webservice;

import java.util.ArrayList;
import com.jayway.jsonpath.JsonPath;
import com.qmetry.constants.TestDataSetupConstants;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.ws.rest.RestTestBase;

/**
 * This class defines the TestDataSetupSupport.
 * 
 * @author nidhi.shah
 */
public class TestDataSetupSupport implements TestDataSetupConstants {

	public static int getIssuePriorityId(String priorityName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_CUSTOM_LIST_OBJS + "." + ATTRIBUTE_ISSUE_PRIORITY + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (priorityName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CUSTOM_LIST_OBJS
							+ "." + ATTRIBUTE_ISSUE_PRIORITY + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + priorityName + " issue priority name", MessageTypes.Fail);
		return 0;
	}

	public static int getIssueTypeId(String typeName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_CUSTOM_LIST_OBJS + "." + ATTRIBUTE_ISSUE_TYPE + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (typeName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CUSTOM_LIST_OBJS
							+ "." + ATTRIBUTE_ISSUE_TYPE + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + typeName + " issue type name", MessageTypes.Fail);
		return 0;
	}

	public static int getPriorityId(String priorityName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_CUSTOM_LIST_OBJS + "." + ATTRIBUTE_PRIORITY + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (priorityName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CUSTOM_LIST_OBJS
							+ "." + ATTRIBUTE_PRIORITY + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + priorityName + " priority name", MessageTypes.Fail);
		return 0;
	}

	public static int getRequirementStateId(String requirementStateName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_CUSTOM_LIST_OBJS + "." + ATTRIBUTE_RQ_STATE + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (requirementStateName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CUSTOM_LIST_OBJS
							+ "." + ATTRIBUTE_RQ_STATE + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + requirementStateName + " requirement state", MessageTypes.Fail);
		return 0;
	}

	public static int getTestcaseStateId(String testcaseStateName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_CUSTOM_LIST_OBJS + "." + ATTRIBUTE_TC_STATE + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (testcaseStateName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CUSTOM_LIST_OBJS
							+ "." + ATTRIBUTE_TC_STATE + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + testcaseStateName + " requirement state", MessageTypes.Fail);
		return 0;
	}

	public static int getTestsuiteStateId(String testsuiteStateName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_CUSTOM_LIST_OBJS + "." + ATTRIBUTE_TS_STATE + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (testsuiteStateName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), ATTRIBUTE_CUSTOM_LIST_OBJS
							+ "." + ATTRIBUTE_TS_STATE + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + testsuiteStateName + " testsuite state", MessageTypes.Fail);
		return 0;
	}

	public static int getRootFolderId(String path) {
		return JsonPath.read(new RestTestBase().getResponse().getMessageBody(), path);
	}

	public static int getRunStatusId(String statusName) {
		try {
			ArrayList<Object> actualValues = JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
					ATTRIBUTE_ALL_STATUS + "[*]." + ATTRIBUTE_NAME);
			int foundCount = 0;
			for (Object value : actualValues) {
				if (statusName.equalsIgnoreCase(value.toString())) {
					return JsonPath.read(new RestTestBase().getResponse().getMessageBody(),
							ATTRIBUTE_ALL_STATUS + "[" + foundCount + "]." + ATTRIBUTE_ID);
				}
				foundCount++;
			}
		} catch (Exception exception) {
			exception.fillInStackTrace();
		}
		Reporter.log(STRING_RESPONSE_DOESNT_HAVE + statusName + " requirement state", MessageTypes.Fail);
		return 0;
	}
}
