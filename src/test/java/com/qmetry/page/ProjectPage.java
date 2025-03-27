package com.qmetry.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.qmetry.bean.ProjectBean;
import com.qmetry.component.GridComponent;
import com.qmetry.constants.CommonConstants;
import com.qmetry.constants.ProjectConstants;
import com.qmetry.locators.ProjectPageLocators;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.RandomStringGenerator;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.util.QMetryUtility;

import org.openqa.selenium.Keys;

/**
 * This class defines ProjectPage.
 * 
 * @author nidhi.shah
 */
public class ProjectPage extends CommonPage implements ProjectPageLocators, ProjectConstants {

    /**
     * s
     * 
     * @param driver
     * @return
     * 
     */
    public ProjectPage() {
        driver.manage().window().maximize();
    }

    @FindBy(locator = SWITCH_TO_PROJECT_LOC)
    private QAFWebElement switchToProjectButton;

    @FindBy(locator = TOTAL_ITEMS_COUNT)
    private QAFWebElement totalItemCount;

    @FindBy(locator = PROJECT_NAME_TXT_BOX_LOC)
    private QAFWebElement locProjectNameTxtBox;

    @FindBy(locator = PROJECT_KEY_TXT_BOX_LOC)
    private QAFWebElement locProjectKeyTxtBox;

    @FindBy(locator = PROJECT_DESCRIPTION_TXT_BOX_LOC)
    private QAFWebElement locDescriptionTxtBox;

    @FindBy(locator = CREATE_PROJECT_BUTTON_LOC)
    private QAFWebElement locCreateProjectButton;

    @FindBy(locator = ENABLE_ESIGNATURE_CHECK_BOX_LOC)
    private QAFWebElement locEnableEsignatureTxtBox;

    @FindBy(locator = ENABLE_ESIGNATURE_YES_BUTTON_LOC)
    private QAFWebElement locEnableEsignatureYesButton;

    @FindBy(locator = ADD_RELEASE_CYCLE_BUTTON_LOC)
    private QAFWebElement locAddReleaseCycleButton;

    @FindBy(locator = RELEASE_NAME_TXT_BOX_LOC)
    private QAFWebElement locReleaseNameTxtBox;

    @FindBy(locator = CYCLE_NAME_TXT_BOX_LOC)
    private QAFWebElement locCycleNameTxtBox;

    @FindBy(locator = ADD_BUTTON_LOC)
    private QAFWebElement locAddButton;

    @FindBy(locator = SHOW_ARCHIVED_RELEASE_CHECK_BOX_LOC)
    private QAFWebElement locShowArchivedReleaseCheckBox;

    @FindBy(locator = CYCLE_TABLE_LOC)
    private GridComponent locCycleTable;

    @FindBy(locator = RELEASE_DRP_DWN_LOC)
    private QAFWebElement locReleaseDrpDwn;

    @FindBy(locator = SHOW_ARCHIVED_CYCLE_CHECK_BOX_LOC)
    private QAFWebElement locShowArchivedCycleCheckBox;

    @FindBy(locator = VERSION_CONTROL_SYSTEM_DRP_DWN_BTN_LOC)
    private QAFWebElement locVersionControlSystemDrpDwnBtn;

    @FindBy(locator = REPOSITORY_URL_TXT_BOX_LOC)
    private QAFWebElement locRepositoryUrlTxtBox;

    @FindBy(locator = USER_NAME_TXT_BOX_LOC)
    private QAFWebElement locUserNameTxtBox;

    @FindBy(locator = PASSWORD_TXT_BOX_LOC)
    private QAFWebElement locPasswordTxtBox;

    @FindBy(locator = ACCESS_TOKEN_TXT_BOX_LOC)
    private QAFWebElement locAccessTokenTxtBox;

    @FindBy(locator = TEST_BDD_BTN_LOC)
    private QAFWebElement locTestAddBtn;

    @FindBy(locator = SAVE_BDD_BTN_LOC)
    private QAFWebElement locSaveBddBtn;

    @FindBy(locator = ADD_BDD_CONFIG_BTN_LOC)
    private QAFWebElement locAddBddConfigBtn;

    @FindBy(locator = SELECT_INTEGRATION_TYPE_DRP_DWN_BTN_LOC)
    private QAFWebElement locSelectIntegrationTypeDrpDwnBtn;

    @FindBy(locator = BROWSE_BTN_LOC)
    private QAFWebElement locBrowseFolderBtn;

    @FindBy(locator = SAVE_AND_ACTIVATE_BTN_LOC)
    private QAFWebElement locSaveAndActivateBtn;

    @FindBy(locator = SELECT_BTN_LOC)
    private QAFWebElement locSelectFolderBtn;

    @FindBy(locator = SELECT_WORKSPACE_DRP_DWN_BTN_LOC)
    private QAFWebElement locSelectWorkspaceDrpDwnBtn;

    @FindBy(locator = CYCLE_PAGE_TABLE_LOADER_LOC)
    private QAFWebElement locCyclePageTableLoader;

    @FindBy(locator = RELEASE_PAGE_TABLE_LOADER_LOC)
    private QAFWebElement locReleasePageTableLoader;

    @FindBy(locator = BDD_NO_DATA_LOC)
    private QAFWebElement locBDDNoDataMessage;

    @FindBy(locator = PROJECT_DETAIL_VIEW_LOADER_LOC)
    private QAFWebElement locProjectDetailViewLoader;

    @FindBy(locator = PROJECTS_PAGE_TABLE_LOADER_LOC)
    private QAFWebElement locProjectsPageTableLoader;

    @FindBy(locator = SHOW_ARCHIVED_PROJECT_CHECK_BOX_LOC)
    private QAFWebElement locShowArchivedProjectCheckBox;

    @FindBy(locator = LINK_USER_BTN_LOC)
    private QAFWebElement locLinkUserBtn;

    @FindBy(locator = LINK_USER_FILTER_LOC)
    private QAFWebElement locLinkUserFilter;

    @FindBy(locator = FILTER_FIRST_NAME_TXT_BOX_LOC)
    private QAFWebElement locFilterFirstNameTxtBox;

    @FindBy(locator = FILTER_SEARCH_BTN_LOC)
    private QAFWebElement locFilterSearchBtn;

    @FindBy(locator = LINK_SELECTED_USER_BTN_LOC)
    private QAFWebElement locLinkSelectedUserBtn;

    @FindBy(locator = LINK_USER_TABLE_LOC)
    private GridComponent locLinkUserTable;

    @FindBy(locator = LINK_USER_PAGE_LOADER_LOC)
    private QAFWebElement locLinkUserPageLoader;

    @FindBy(locator = LINK_USER_BTN_SPANISH_LOC)
    private QAFWebElement locLinkUserBtnSpanish;

    @FindBy(locator = LINK_USER_FILTER_SPANISH_LOC)
    private QAFWebElement locLinkUserFilterSpanish;

    @FindBy(locator = FILTER_SEARCH_BTN_SPANISH_LOC)
    private QAFWebElement locFilterSearchBtnSpanish;

    @FindBy(locator = LINK_USER_TABLE_SPANISH_LOC)
    private GridComponent locLinkUserTableSpanish;

    @FindBy(locator = LINK_USER_PAGE_LOADER_SPANISH_LOC)
    private QAFWebElement locLinkUserPageLoaderSpanish;

    @FindBy(locator = LINK_SELECTED_USER_BTN_SPANISH_LOC)
    private QAFWebElement locLinkSelectedUserBtnSpanish;

    @FindBy(locator = BUILD_SELECTION_MANDATORY_ON_OFF_SWITCH_LOC)
    private QAFWebElement locBuildSelectionMandatoryOnOffSwitch;

    @FindBy(locator = CLOUD_VCS_TYPE_RADIO_BTN_LOC)
    private QAFWebElement locCloudVCSTypeRadioBtn;

    @FindBy(locator = SERVER_VCS_TYPE_RADIO_BTN_LOC)
    private QAFWebElement locSelverVCSTypeRadioBtn;

    @FindBy(locator = ADD_CONFIGURATION_WINDOW_CLOSE_BTN_LOC)
    private QAFWebElement locAddConfigurationWindowCloseBtn;

    @FindBy(locator = UPDATE_BDD_BTN_LOC)
    private QAFWebElement locUpdateBddBtn;

    @FindBy(locator = DERIVE_EXECUTION_STATUS_FROM_TESTSTEP_ON_OFF_SWITCH_LOC)
    private QAFWebElement locDeriveExecutionStatusFromTeststepOnOffSwitch;

    @FindBy(locator = DERIVE_EXECUTION_STATUS_FROM_TESTSTEP_CHECKBOX_LOC)
    private QAFWebElement locDeriveExecutionStatusFromTeststepCheckbox;

    @FindBy(locator = DERIVE_EXECUTION_STATUS_FROM_TESTSTEP_LABEL_LOC)
    private QAFWebElement locDeriveExecutionStatusFromTeststepLabel;

    @FindBy(locator = DERIVE_EXECUTION_STATUS_FROM_TESTSTEP_INFO_CIRCLE_LOC)
    private QAFWebElement locDeriveExecutionStatusFromTeststepInfoCircle;

    @FindBy(locator = INFO_POPOVER_CONTAINER_LOC)
    private QAFWebElement locInfoPopoverContainer;

    @FindBy(locator = DERIVE_EXECUTION_STATUS_FROM_TESTSTEP_NEW_PROJECT_INFO_CIRCLE_LOC)
    private QAFWebElement locDeriveExecutionStatusFromTeststepNewProjectInfoCircle;

    @FindBy(locator = CLONE_PROJECT_NAME_TXT_BOX_LOC)
    private QAFWebElement locCloneProjectNameTxtBox;

    @FindBy(locator = CLONE_PROJECT_KEY_TXT_BOX_LOC)
    private QAFWebElement locCloneProjectKeyTxtBox;

    @FindBy(locator = FOLDER_STRUCTURE_ALONG_WITH_DATA_RADIO_BTN_LOC)
    private QAFWebElement locFolderStructureAlongWithDataRadioBtn;

    @FindBy(locator = CLONE_PROJECT_BTN_LOC)
    private QAFWebElement locCloneProjectBtn;

    @FindBy(locator = ENABLE_RICH_TEXT_ON_OFF_SWITCH_LOC)
    private QAFWebElement locEnableRichTextOnOffSwitch;

    @FindBy(locator = ENABLE_RICH_TEXT_INPUT_LOC)
    private QAFWebElement locEnableRichTextInput;

    @FindBy(locator = BUILD_SELECTION_MANDATORY_CHECKBOX_LOC)
    private QAFWebElement locBuildSelectionMandatoryCheckBox;

    @FindBy(locator = PROJECT_FILTER_BTN_LOC)
    private QAFWebElement locProjectFilterBtn;

    @FindBy(locator = FILTER_PROJECT_KEY_TXT_BOX_LOC)
    private QAFWebElement locFilterProjectKeyTxtBox;

    @FindBy(locator = FILTER_PROJECTS_TXT_BOX_LOC)
    private QAFWebElement locFilterProjectsTxtBox;

    @FindBy(locator = PROJECT_FILTER_SEARCH_BTN_LOC)
    private QAFWebElement locProjectFilterSearchBtn;

    @FindBy(locator = PROJECT_FILTER_CLEAR_BTN_LOC)
    private QAFWebElement locProjectFilterClearBtn;

    @FindBy(locator = LINKED_USER_TO_PROJECT_TABLE_LOC)
    private GridComponent locLinkedUserToProjectTable;

    @FindBy(locator = SELECT_AUTOMATION_TOOL_INFO_CIRCLE_LOC)
    private QAFWebElement locSelectAutomationToolInfoCircle;

    @FindBy(locator = AUTOMATION_TOOL_DROP_DOWN_LOC)
    private QAFWebElement locAutomationToolDropDown;

    @FindBy(locator = AUTOMATION_TOOL_DROP_DOWN_VALUES_LOC)
    private List<QAFWebElement> locAutomationToolDropDownValues;

    @FindBy(locator = EDIT_PROJECT_DESCRIPTION_TXT_BOX_LOC)
    private QAFWebElement locEditDescriptionTxtBox;

    @FindBy(locator = EDIT_JIRA_CONFIG_TABLE_LOC)
    private GridComponent locEditJiraConfigTable;

    @FindBy(locator = SAVE_JIRA_CONFIG_CUSTOM_FIELD_BTN_LOC)
    private QAFWebElement locSaveJiraConfigCustomFieldBtn;

    @FindBy(locator = FOLDER_STRUCTURE_RADIO_BTN_LOC)
    private QAFWebElement locFolderStructureRadioBtn;

    @FindBy(locator = RQ_JIRA_FIELD_SETTING_BTN_LOC)
    private QAFWebElement locRQJiraFieldSettingBtn;

    @FindBy(locator = CONTINUE_BTN)
    private QAFWebElement locContinueBtn;

    @FindBy(locator = EXPAND_JIRA_FIELD_CONFIGURATION_POPUP)
    private QAFWebElement locExpandJiraFieldConfigurationPopUp;

    @FindBy(locator = COMPRESS_JIRA_FIELD_CONFIGURATION_POPUP)
    private QAFWebElement locCompressJiraFieldConfigurationPopUp;

    @FindBy(locator = CANCEL_JIRA_CONFIGURATION_BTN)
    private QAFWebElement locCancelJiraConfigurationBtn;

    @FindBy(locator = ADD_NEW_FOLDER_FOR_INTEGRATION_TXT_BOX)
    private QAFWebElement locAddNewFolderForIntegrationTxtBox;

    @FindBy(locator = ADD_NEW_FOLDER_BTN)
    private QAFWebElement locAddNewFolderBtn;

    @FindBy(locator = WORKSOFT_CTM_SAVE_BTN)
    private QAFWebElement locWorksoftCTMSaveBtn;

    @FindBy(locator = WORKSOFT_CTM_DELETE_BTN)
    private QAFWebElement locWorksoftCTMDeleteBtn;

    @FindBy(locator = WORKSOFT_CTM_UPDATE_BTN)
    private QAFWebElement locWorksoftCTMUpdateBtn;

    @FindBy(locator = RISK_BASED_ANALYSIS_LABEL)
    private QAFWebElement locRiskBasedAnalysisLabel;

    @FindBy(locator = ACTIVATE_RISK_BASED_ANALYSIS_INFO)
    private QAFWebElement locActivateRiskBasedAnalysisInfo;

    @FindBy(locator = DISABLE_RISK_BASED_ANALYSIS_INFO)
    private QAFWebElement locDisableRiskBasedAnalysisInfo;

    @FindBy(locator = RISK_BASED_ANAYSIS_IN_THE_PROJECT_FOR_THE_BELOW_ENTITIES_SWITCH_LABEL)
    private QAFWebElement locRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel;

    @FindBy(locator = RISK_BASED_ANAYSIS_IN_THE_PROJECT_FOR_THE_BELOW_ENTITIES_SWITCH)
    private QAFWebElement locRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch;

    @FindBy(locator = REQUIREMENT_RBT_CHECK_BOX)
    private QAFWebElement locRequirementRBTCheckBox;

    @FindBy(locator = TESTCASE_RBT_CHECK_BOX)
    private QAFWebElement locTestcaseRBTCheckBox;

    @FindBy(locator = LATEST_TESTCASE_EXECUTION_STATUS_LABEL_LOC)
    private QAFWebElement locLatestTestcaseExecutionStatusLabel;

    @FindBy(locator = LATEST_TESTCASE_EXECUTION_STATUS_INFO_LOC)
    private QAFWebElement locLatestTestcaseExecutionStatusInfo;

    @FindBy(locator = TEST_EXECUTION_PROJECT_SCOPE_INFO_CIRCLE_LOC)
    private QAFWebElement locTestExecutionProjectScopeInfoCircle;

    @FindBy(locator = CURRENT_PROJECT_TEST_EXECUTION_SCOPE_RADIO_BTN_LOC)
    private QAFWebElement locCurrentProjectTestExecutionScopeRadioBtn;

    @FindBy(locator = ALL_PROJECT_TEST_EXECUTION_SCOPE_RADIO_BTN_LOC)
    private QAFWebElement locAllProjectTestExecutionScopeRadioBtn;

    @FindBy(locator = TEST_CASE_VERSION_INFO_CIRCLE_LOC)
    private QAFWebElement locTestcaseVersionInfoCircle;

    @FindBy(locator = LATEST_TEST_CASE_VERSION_RADIO_BTN_LOC)
    private QAFWebElement locLatestTestcaseVersionRadioBtn;

    @FindBy(locator = ALL_TEST_CASE_VERSION_RADIO_BTN_LOC)
    private QAFWebElement locAllTestcaseVersionRadioBtn;

    @FindBy(locator = APPLY_LATEST_TESTCASE_EXECUTION_SETTING_BTN_LOC)
    private QAFWebElement locApplyLatestTestcaseExecutionSettingBtn;

    @FindBy(locator = DEFINE_DEPENDENCY_BETWEEN_TESTCASES_ON_OFF_SWITCH_LOC)
    private QAFWebElement locDefineDependencyBetweenTestcasesOnOffSwitch;

    @FindBy(locator = DEFINE_DEPENDENCY_BETWEEN_TESTCASES_CHECK_BOX)
    private QAFWebElement locDefineDependencyBetweenTestcasesCheckBox;

    @FindBy(locator = CONFIGURE_EXECUTION_STATUS_LINK)
    private QAFWebElement locConfigureExecutionStatusLink;

    @FindBy(locator = ISSUE_JIRA_FIELD_SETTING_BTN_LOC)
    private QAFWebElement locIssueJiraFieldSettingBtn;

    @FindBy(locator = EDIT_JIRA_FIELDS_CONFIGURATION_HEADER_LOC)
    private QAFWebElement locEditJiraFiledsConfigurationHeader;

    @FindBy(locator = SELECT_ALL_VIEW_JIRA_FIELDS_CHECK_BOX_LOC)
    private QAFWebElement locSelectAllViewJiraFieldsCheckBox;

    @FindBy(locator = SELECT_ALL_CREATE_JIRA_FIELDS_CHECK_BOX_LOC)
    private QAFWebElement locSelectAllCreateJiraFieldsCheckBox;

    @FindBy(locator = EDIT_JIRA_FIELDS_CONFIGURATION_WINDOW_CANCEL_BTN_LOC)
    private QAFWebElement locEditJiraFieldsConfigurationWindowCancelBtn;

    @FindBy(locator = EDIT_JIRA_FIELDS_CONFIGURATION_SAVE_BTN_LOC)
    private QAFWebElement locEditJiraFieldsConfigurationSaveBtn;

    @FindBy(locator = REQUIREMENT_JIRA_FIELD_SETTING_BTN_LOC)
    private QAFWebElement locRequirementJiraFieldSettingBtn;

    @FindBy(locator = SELECT_ALL_STORY_JIRA_FIELDS_CHECK_BOX_LOC)
    private QAFWebElement locSelectAllStoryJiraFieldsCheckBox;

    @FindBy(locator = PROJECT_CLONE_YES_CONTINUE_BTN_LOC)
    private QAFWebElement locProjectCloneYesContinueBtn;

    @FindBy(locator = PROJECT_CLONE_NO_WILL_DO_LATER_BTN_LOC)
    private QAFWebElement locProjectCloneNoWillDoLaterBtn;

    @FindBy(locator = CLONE_CONFIRMATION_SUB_HEADING_TEXT_LOC)
    private QAFWebElement locCloneConfirmationSubHeadingTxt;

    @FindBy(locator = CLONE_CONFIRMATION_TEXT_LOC)
    private QAFWebElement locCloneConfirmationTxt;

    @FindBy(locator = PROJECT_SETTINGS_FOR_AUTO_GENERATION_OF_TEST_CASES_AND_STEPS_USING_QI_LABEL_LOC)
    private QAFWebElement locProjectSettingsforAutoGenerationofTestCasesandStepsusingQILabel;

    @FindBy(locator = PROJECT_SETTINGS_FOR_AUTO_GENERATION_OF_TEST_CASES_AND_STEPS_USING_QI_INFO_LOC)
    private QAFWebElement locProjectSettingsforAutoGenerationofTestCasesandStepsusingQIInfo;

    @FindBy(locator = PROJECT_SETTINGS_FOR_AUTO_GENERATION_OF_TEST_CASES_AND_STEPS_USING_QI_PARA1_INFO_LOC)
    private QAFWebElement locProjectSettingsforAutoGenerationofTestCasesandStepsusingQIPara1Info;

    @FindBy(locator = PROJECT_SETTINGS_FOR_AUTO_GENERATION_OF_TEST_CASES_AND_STEPS_USING_QI_PARA2_INFO_LOC)
    private QAFWebElement locProjectSettingsforAutoGenerationofTestCasesandStepsusingQIPara2Info;

    @FindBy(locator = CHOOSE_THE_TESTCASE_FIELD_THAT_WILL_STORE_PRECONDITIONS_FOR_AUTO_GENERATED_TESTCASES_LABEL_LOC)
    private QAFWebElement locChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesLabel;

    @FindBy(locator = CHOOSE_THE_TESTCASE_FIELD_THAT_WILL_STORE_PRECONDITIONS_FOR_AUTO_GENERATED_TESTCASES_INFO_CIRCLE_LOC)
    private QAFWebElement locChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesInfoCircle;

    @FindBy(locator = CHOOSE_THE_TESTCASE_FIELD_THAT_WILL_STORE_PRECONDITIONS_FOR_AUTO_GENERATED_TESTCASES_DRP_DWN_LOC)
    private QAFWebElement locChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesDrpDwn;

    public QAFWebElement getSwitchToProjectBtn() {
        return switchToProjectButton;
    }

    public QAFWebElement getTotalItemCount() {
        return totalItemCount;
    }

    public QAFWebElement getProjectNameTxtBox() {
        return locProjectNameTxtBox;
    }

    public QAFWebElement getProjectKeyTxtBox() {
        return locProjectKeyTxtBox;
    }

    public QAFWebElement getDescriptionTxtBox() {
        return locDescriptionTxtBox;
    }

    public QAFWebElement getCreateProjectBtn() {
        return locCreateProjectButton;
    }

    public QAFWebElement getEnableEsignatureTxtBox() {
        return locEnableEsignatureTxtBox;
    }

    public QAFWebElement getEnableEsignatureYesBtn() {
        return locEnableEsignatureYesButton;
    }

    public QAFWebElement getAddReleaseCycleBtn() {
        return locAddReleaseCycleButton;
    }

    public QAFWebElement getReleaseNameTxtBox() {
        return locReleaseNameTxtBox;
    }

    public QAFWebElement getCycleNameTxtBox() {
        return locCycleNameTxtBox;
    }

    public QAFWebElement getAddButton() {
        return locAddButton;
    }

    public QAFWebElement getShowArchivedReleaseCheckBox() {
        return locShowArchivedReleaseCheckBox;
    }

    public GridComponent getCycleTable() {
        return locCycleTable;
    }

    public QAFWebElement getReleaseDrpDwn() {
        return locReleaseDrpDwn;
    }

    public QAFWebElement getShowArchivedCycleCheckBox() {
        return locShowArchivedCycleCheckBox;
    }

    public QAFWebElement getVersionControlSystemDrpDwnBtn() {
        return locVersionControlSystemDrpDwnBtn;
    }

    public QAFWebElement getRepositoryUrlTxtBox() {
        return locRepositoryUrlTxtBox;
    }

    public QAFWebElement getUserNameTxtBox() {
        return locUserNameTxtBox;
    }

    public QAFWebElement getPasswordTxtBox() {
        return locPasswordTxtBox;
    }

    public QAFWebElement getAccessTokenTxtBox() {
        return locAccessTokenTxtBox;
    }

    public QAFWebElement getTestAddBtn() {
        return locTestAddBtn;
    }

    public QAFWebElement getSaveBddBtn() {
        return locSaveBddBtn;
    }

    public QAFWebElement getAddBddConfigBtn() {
        return locAddBddConfigBtn;
    }

    public QAFWebElement getSelectIntegrationTypeDrpDwnBtn() {
        return locSelectIntegrationTypeDrpDwnBtn;
    }

    public QAFWebElement getBrowseFolderBtn() {
        return locBrowseFolderBtn;
    }

    public QAFWebElement getSaveAndActivateBtn() {
        return locSaveAndActivateBtn;
    }

    public QAFWebElement getSelectFolderBtn() {
        return locSelectFolderBtn;
    }

    public QAFWebElement getSelectWorkspaceDrpDwnBtn() {
        return locSelectWorkspaceDrpDwnBtn;
    }

    public QAFWebElement getCyclePageTableLoader() {
        return locCyclePageTableLoader;
    }

    public QAFWebElement getReleasePageTableLoader() {
        return locReleasePageTableLoader;
    }

    public QAFWebElement getBDDNoDataMessage() {
        return locBDDNoDataMessage;
    }

    public QAFWebElement getProjectDetailViewLoader() {
        return locProjectDetailViewLoader;
    }

    public QAFWebElement getProjectsPageTableLoader() {
        return locProjectsPageTableLoader;
    }

    public QAFWebElement getShowArchivedProjectCheckBox() {
        return locShowArchivedProjectCheckBox;
    }

    public QAFWebElement getLinkUserBtn() {
        return locLinkUserBtn;
    }

    public QAFWebElement getLinkUserFilter() {
        return locLinkUserFilter;
    }

    public QAFWebElement getFilterFirstNameTxtBox() {
        return locFilterFirstNameTxtBox;
    }

    public QAFWebElement getFilterSearchBtn() {
        return locFilterSearchBtn;
    }

    public QAFWebElement getLinkSelectedUserBtn() {
        return locLinkSelectedUserBtn;
    }

    public GridComponent getLinkUserTable() {
        return locLinkUserTable;
    }

    public QAFWebElement getLinkUserPageLoader() {
        return locLinkUserPageLoader;
    }

    public QAFWebElement getLinkUserBtnSpanish() {
        return locLinkUserBtnSpanish;
    }

    public QAFWebElement getLinkUserFilterSpanish() {
        return locLinkUserFilterSpanish;
    }

    public QAFWebElement getFilterSearchBtnSpanish() {
        return locFilterSearchBtnSpanish;
    }

    public GridComponent getLinkUserTableSpanish() {
        return locLinkUserTableSpanish;
    }

    public QAFWebElement getLinkUserPageLoaderSpanish() {
        return locLinkUserPageLoaderSpanish;
    }

    public QAFWebElement getLinkSelectedUserBtnSpanish() {
        return locLinkSelectedUserBtnSpanish;
    }

    public QAFWebElement getBuildSelectionMandatoryOnOffSwitch() {
        return locBuildSelectionMandatoryOnOffSwitch;
    }

    public QAFWebElement getCloudVCSTypeRadioBtn() {
        return locCloudVCSTypeRadioBtn;
    }

    public QAFWebElement getServerVCSTypeRadioBtn() {
        return locSelverVCSTypeRadioBtn;
    }

    public QAFWebElement getAddConfigurationWindowCloseBtn() {
        return locAddConfigurationWindowCloseBtn;
    }

    public QAFWebElement getUpdateBddBtn() {
        return locUpdateBddBtn;
    }

    public QAFWebElement getDeriveExecutionStatusFromTeststepOnOffSwitch() {
        return locDeriveExecutionStatusFromTeststepOnOffSwitch;
    }

    public QAFWebElement getDeriveExecutionStatusFromTeststepCheckbox() {
        return locDeriveExecutionStatusFromTeststepCheckbox;
    }

    public QAFWebElement getDeriveExecutionStatusFromTeststepLabel() {
        return locDeriveExecutionStatusFromTeststepLabel;
    }

    public QAFWebElement getDeriveExecutionStatusFromTeststepInfoCircle() {
        return locDeriveExecutionStatusFromTeststepInfoCircle;
    }

    public QAFWebElement getInfoPopoverContainer() {
        return locInfoPopoverContainer;
    }

    public QAFWebElement getDeriveExecutionStatusFromTeststepNewProjectInfoCircle() {
        return locDeriveExecutionStatusFromTeststepNewProjectInfoCircle;
    }

    public QAFWebElement getCloneProjectNameTxtBox() {
        return locCloneProjectNameTxtBox;
    }

    public QAFWebElement getCloneProjectKeyTxtBox() {
        return locCloneProjectKeyTxtBox;
    }

    public QAFWebElement getFolderStructureAlongWithDataRadioBtn() {
        return locFolderStructureAlongWithDataRadioBtn;
    }

    public QAFWebElement getCloneProjectBtn() {
        return locCloneProjectBtn;
    }

    public QAFWebElement getEnableRichTextOnOffSwitch() {
        return locEnableRichTextOnOffSwitch;
    }

    public QAFWebElement getEnableRichTextInput() {
        return locEnableRichTextInput;
    }

    public QAFWebElement getBuildSelectionMandatoryCheckBox() {
        return locBuildSelectionMandatoryCheckBox;
    }

    public QAFWebElement getProjectFilterBtn() {
        return locProjectFilterBtn;
    }

    public QAFWebElement getFilterProjectKeyTxtBox() {
        return locFilterProjectKeyTxtBox;
    }

    public QAFWebElement getFilterProjectsTxtBox() {
        return locFilterProjectsTxtBox;
    }

    public QAFWebElement getProjectFilterSearchBtn() {
        return locProjectFilterSearchBtn;
    }

    public QAFWebElement getProjectFilterClearBtn() {
        return locProjectFilterClearBtn;
    }

    public GridComponent getLinkedUserToProjectTable() {
        return locLinkedUserToProjectTable;
    }

    public QAFWebElement getSelectAutomationToolInfoCircle() {
        return locSelectAutomationToolInfoCircle;
    }

    public QAFWebElement getAutomationToolDropDown() {
        return locAutomationToolDropDown;
    }

    public List<QAFWebElement> getAutomationToolDropDownValuesLocList() {
        return locAutomationToolDropDownValues;
    }

    public QAFWebElement getEditDescriptionTxtBox() {
        return locEditDescriptionTxtBox;
    }

    public GridComponent getEditJiraConfigTable() {
        return locEditJiraConfigTable;
    }

    public QAFWebElement getSaveJiraConfigCustomFieldBtn() {
        return locSaveJiraConfigCustomFieldBtn;
    }

    public QAFWebElement getFolderStructureRadioBtn() {
        return locFolderStructureRadioBtn;
    }

    public QAFWebElement getRQJiraFieldSettingBtn() {
        return locRQJiraFieldSettingBtn;
    }

    public QAFWebElement getContinueBtn() {
        return locContinueBtn;
    }

    public QAFWebElement getExpandJiraFieldConfigurationPopUp() {
        return locExpandJiraFieldConfigurationPopUp;
    }

    public QAFWebElement getCompressJiraFieldConfigurationPopUp() {
        return locCompressJiraFieldConfigurationPopUp;
    }

    public QAFWebElement getCancelJiraConfigurationBtn() {
        return locCancelJiraConfigurationBtn;
    }

    public QAFWebElement getAddNewFolderForIntegrationTxtBox() {
        return locAddNewFolderForIntegrationTxtBox;
    }

    public QAFWebElement getAddNewFolderBtn() {
        return locAddNewFolderBtn;
    }

    public QAFWebElement getWorksoftCTMSaveBtn() {
        return locWorksoftCTMSaveBtn;
    }

    public QAFWebElement getWorksoftCTMDeleteBtn() {
        return locWorksoftCTMDeleteBtn;
    }

    public QAFWebElement getWorksoftCTMUpdateBtn() {
        return locWorksoftCTMUpdateBtn;
    }

    public QAFWebElement getRiskBasedAnalysisLabel() {
        return locRiskBasedAnalysisLabel;
    }

    public QAFWebElement getActivateRiskBasedAnalysisInfo() {
        return locActivateRiskBasedAnalysisInfo;
    }

    public QAFWebElement getDisableRiskBasedAnalysisInfo() {
        return locDisableRiskBasedAnalysisInfo;
    }

    public QAFWebElement getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel() {
        return locRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel;
    }

    public QAFWebElement getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch() {
        return locRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch;
    }

    public QAFWebElement getRequirementRBTCheckBox() {
        return locRequirementRBTCheckBox;
    }

    public QAFWebElement getTestcaseRBTCheckBox() {
        return locTestcaseRBTCheckBox;
    }

    public QAFWebElement getLatestTestcaseExecutionStatusLabel() {
        return locLatestTestcaseExecutionStatusLabel;
    }

    public QAFWebElement getLatestTestcaseExecutionStatusInfo() {
        return locLatestTestcaseExecutionStatusInfo;
    }

    public QAFWebElement getTestExecutionProjectScopeInfoCircle() {
        return locTestExecutionProjectScopeInfoCircle;
    }

    public QAFWebElement getCurrentProjectTestExecutionScopeRadioBtn() {
        return locCurrentProjectTestExecutionScopeRadioBtn;
    }

    public QAFWebElement getAllProjectTestExecutionScopeRadioBtn() {
        return locAllProjectTestExecutionScopeRadioBtn;
    }

    public QAFWebElement getTestcaseVersionInfoCircle() {
        return locTestcaseVersionInfoCircle;
    }

    public QAFWebElement getLatestTestcaseVersionRadioBtn() {
        return locLatestTestcaseVersionRadioBtn;
    }

    public QAFWebElement getAllTestcaseVersionRadioBtn() {
        return locAllTestcaseVersionRadioBtn;
    }

    public QAFWebElement getApplyLatestTestcaseExecutionSettingBtn() {
        return locApplyLatestTestcaseExecutionSettingBtn;
    }

    public QAFWebElement getDefineDependencyBetweenTestcasesOnOffSwitch() {
        return locDefineDependencyBetweenTestcasesOnOffSwitch;
    }

    public QAFWebElement getDefineDependencyBetweenTestcasesCheckBox() {
        return locDefineDependencyBetweenTestcasesCheckBox;
    }

    public QAFWebElement getConfigureExecutionStatusLink() {
        return locConfigureExecutionStatusLink;
    }

    public QAFWebElement getIssueJiraFieldSettingBtn() {
        return locIssueJiraFieldSettingBtn;
    }

    public QAFWebElement getEditJiraFiledsConfigurationHeader() {
        return locEditJiraFiledsConfigurationHeader;
    }

    public QAFWebElement getSelectAllViewJiraFieldsCheckBox() {
        return locSelectAllViewJiraFieldsCheckBox;
    }

    public QAFWebElement getSelectAllCreateJiraFieldsCheckBox() {
        return locSelectAllCreateJiraFieldsCheckBox;
    }

    public QAFWebElement getEditJiraFieldsConfigurationWindowCancelBtn() {
        return locEditJiraFieldsConfigurationWindowCancelBtn;
    }

    public QAFWebElement getEditJiraFieldsConfigurationSaveBtn() {
        return locEditJiraFieldsConfigurationSaveBtn;
    }

    public QAFWebElement getRequirementJiraFieldSettingBtn() {
        return locRequirementJiraFieldSettingBtn;
    }

    public QAFWebElement getSelectAllStoryJiraFieldsCheckBox() {
        return locSelectAllStoryJiraFieldsCheckBox;
    }

    public QAFWebElement getProjectCloneYesContinueBtn() {
        return locProjectCloneYesContinueBtn;
    }

    public QAFWebElement getProjectCloneNoWillDoLaterBtn() {
        return locProjectCloneNoWillDoLaterBtn;
    }

    public QAFWebElement getCloneConfirmationSubHeadingTxt() {
        return locCloneConfirmationSubHeadingTxt;
    }

    public QAFWebElement getCloneConfirmationTxt() {
        return locCloneConfirmationTxt;
    }

    public QAFWebElement getProjectSettingsforAutoGenerationofTestCasesandStepsusingQILabel() {
        return locProjectSettingsforAutoGenerationofTestCasesandStepsusingQILabel;
    }

    public QAFWebElement getProjectSettingsforAutoGenerationofTestCasesandStepsusingQIInfo() {
        return locProjectSettingsforAutoGenerationofTestCasesandStepsusingQIInfo;
    }

    public QAFWebElement getProjectSettingsforAutoGenerationofTestCasesandStepsusingQIPara1Info() {
        return locProjectSettingsforAutoGenerationofTestCasesandStepsusingQIPara1Info;
    }

    public QAFWebElement getProjectSettingsforAutoGenerationofTestCasesandStepsusingQIPara2Info() {
        return locProjectSettingsforAutoGenerationofTestCasesandStepsusingQIPara2Info;
    }

    public QAFWebElement getChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesLabel() {
        return locChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesLabel;
    }

    public QAFWebElement getChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesInfoCircle() {
        return locChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesInfoCircle;
    }

    public QAFWebElement getChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesDrpDwn() {
        return locChoosetheTestCaseFieldThatWillStorePreconditionsForAutogeneratedTestCasesDrpDwn;
    }

    /**
     * @param locator
     * @param args
     */
    @Override
    protected void openPage(PageLocator locator, Object... args) {

    }

    /**
     * This method will verify project page opened with selected project name
     * 
     * @param projectName
     * @author rahul.patil
     */
    public void verifyProjectName(String projectName) {
        String locFolder = "xpath=.//span[@title='" + projectName + "']";
        driver.findElement(locFolder).waitForVisible();
        driver.findElement(locFolder).verifyVisible();
    }

    /**
     * This method will update the project name and verify
     * 
     * @param projectName
     * @author rahul.patil
     */
    public ProjectBean updateProjectNameAndVerify(ProjectBean createProjectBean, ProjectBean projectBean) {
        ProjectBean updateProjectBean = new ProjectBean();
        String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
                + RandomStringGenerator.get(3, RandomizerTypes.MIXED)
                + RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
        updateProjectBean.setUpdatedProjectName(projectBean.getUpdatedProjectName() + randomData);
        String locFolder1 = "xpath=.//span[@title='" + createProjectBean.getProjectName()
                + "']/following-sibling::span";
        driver.findElement(locFolder1).waitForEnabled();
        driver.findElement(locFolder1).clear();
        driver.findElement(locFolder1).sendKeys(updateProjectBean.getUpdatedProjectName());
        getTotalItemCount().waitForVisible();
        getTotalItemCount().click();
        String locFolder2 = "xpath=.//span[@title='" + updateProjectBean.getUpdatedProjectName() + "']";
        driver.findElement(locFolder2).waitForEnabled();
        driver.findElement(locFolder2).verifyVisible();
        return updateProjectBean;
    }

    /**
     * This method will navigate to tab in project page
     * 
     * @param tabName
     * @author rahul.patil
     */
    public void switchToTab(String tabName) {
        waitForLoader(getProjectDetailViewLoader());
        String locTab = "xpath=.//ul[@role='tablist']//span[text()='" + tabName + "']//parent::a";
        driver.findElement(locTab).waitForEnabled();
        QMetryUtility.click(driver.findElement(locTab));
        waitForLoader(getProjectDetailViewLoader());
        /* driver.findElement(locTab).waitForAttribute("aria-selected", "true"); */

    }

    /**
     * This method will create new project.
     * 
     * @param isEnableEsignature
     * @return String
     * @author rahul.patil
     * @Updatedby nidhi.shah Removed Random data generation from the method and add
     *            it on to TC level.
     */
    public ProjectBean createProject(ProjectBean projectBean, boolean... isEnableEsignature) {
        getProjectNameTxtBox().waitForEnabled();
        getProjectNameTxtBox().sendKeys(projectBean.getProjectName());
        getProjectKeyTxtBox().waitForEnabled();
        getProjectKeyTxtBox().click();
        getProjectKeyTxtBox().clear();
        getProjectKeyTxtBox().sendKeys(projectBean.getProjectKey());
        getDescriptionTxtBox().waitForEnabled();
        getDescriptionTxtBox().sendKeys(projectBean.getProjectDescription());
        if (isEnableEsignature.length >= 1) {
            getEnableEsignatureTxtBox().waitForEnabled();
            QMetryUtility.click(getEnableEsignatureTxtBox());
            getEnableEsignatureYesBtn().waitForEnabled();
            QMetryUtility.click(getEnableEsignatureYesBtn());
        }
        getCreateProjectBtn().waitForEnabled();
        QMetryUtility.click(getCreateProjectBtn());
        getLocNewBtn().waitForVisible();
        return projectBean;
    }

    /**
     * This method will select add release or add cycle option.
     * 
     * @param entityName
     * @author rahul.patil
     */
    public void selectAddEntity(String entityName) {
        getAddReleaseCycleBtn().waitForEnabled();
        getAddReleaseCycleBtn().click();
        getAddReleaseCycleBtn().waitForAttribute("aria-expanded", "true");
        String locEntity = "xpath=.//*[text()='Add " + entityName + "']/parent::a";
        driver.findElement(locEntity).waitForEnabled();
        driver.findElement(locEntity).click();
    }

    /**
     * This method will select add release or add cycle option.
     * 
     * @param entityName
     * @author rahul.patil
     */
    public void createRelease(ProjectBean projectBean) {
        selectAddEntity("Release");
        getReleaseNameTxtBox().waitForEnabled();
        getReleaseNameTxtBox().sendKeys(projectBean.getReleaseName());
        getAddButton().waitForEnabled();
        QMetryUtility.click(getAddButton());
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
    }

    /**
     * Method will select show archived check box.
     * 
     * @param checkBoxName
     * @author rahul.patil
     */
    public void selectShowArchivedReleaseCheckBox() {
        if (!getShowArchivedReleaseCheckBox().isSelected()) {
            getShowArchivedReleaseCheckBox().waitForEnabled();
            QMetryUtility.click(getShowArchivedReleaseCheckBox());
        }
    }

    /**
     * Method will unselect show archived check box.
     * 
     * @param checkBoxName
     * @author nidhi.shah
     */
    public void unselectShowArchivedReleaseCheckBox() {
        if (getShowArchivedReleaseCheckBox().isSelected()) {
            getShowArchivedReleaseCheckBox().waitForEnabled();
            QMetryUtility.click(getShowArchivedReleaseCheckBox());
        }
    }

    /**
     * This method will select dropdown value.
     * 
     * @param DropDownLabels
     * @param dropDownValue
     * @author rahul.patil
     */
    public void selectReleaseToCreateCycle(String release) {
        getReleaseDrpDwn().waitForEnabled();
        QMetryUtility.click(getReleaseDrpDwn());
        String releaseLoc = "xpath=.//p-multiselectitem//*[text()='" + release + "']";
        driver.findElement(releaseLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(releaseLoc));
    }

    /**
     * This method will select add release or add cycle option.
     * 
     * @param entityName
     * @author rahul.patil
     */
    public void createCycle(ProjectBean projectBean) {
        selectAddEntity("Cycle");
        selectReleaseToCreateCycle(projectBean.getReleaseName());
        getCycleNameTxtBox().waitForEnabled();
        getCycleNameTxtBox().sendKeys(projectBean.getCycleName());
        getAddButton().waitForEnabled();
        QMetryUtility.click(getAddButton());
        waitForLoader(getProjectDetailViewLoader());
    }

    /**
     * Method will select show archived check box.
     * 
     * @param checkBoxName
     * @author rahul.patil
     */
    public void selectShowArchivedCycleCheckBox() {
        if (!getShowArchivedCycleCheckBox().isSelected()) {
            getShowArchivedCycleCheckBox().waitForEnabled();
            QMetryUtility.click(getShowArchivedCycleCheckBox());
        }
    }

    /**
     * Method will inselect show archived check box.
     * 
     * @param checkBoxName
     * @author nidhi.shah
     */
    public void unselectShowArchivedCycleCheckBox() {
        if (getShowArchivedCycleCheckBox().isSelected()) {
            getShowArchivedCycleCheckBox().waitForEnabled();
            QMetryUtility.click(getShowArchivedCycleCheckBox());
        }
    }

    /**
     * Method will wait for table to load after operation.
     * 
     * @author rahul.patil
     */
    public void waitForCycleTableToLoad() {
        // getCyclePageTableLoader().waitForAttribute("class", "table-scroll-wrapper");
        do {
        } while (getCyclePageTableLoader().getAttribute("class").contains("disabled"));
    }

    /**
     * This method will add bdd configuration.
     * 
     * @param entityName
     * @author rahul.patil
     */
    public void addBddConfiguration(ProjectBean projectBean) {
        getAddBddConfigBtn().waitForVisible();
        getAddBddConfigBtn().waitForEnabled();
        /* QMetryUtility.click(getAddBddConfigBtn()); */
        getAddBddConfigBtn().click();
        getVersionControlSystemDrpDwnBtn().waitForVisible();
        getVersionControlSystemDrpDwnBtn().waitForEnabled();
        QMetryUtility.click(getVersionControlSystemDrpDwnBtn());
        if (projectBean.getVersionControlSystem().contains("-")) {
            if (projectBean.getVersionControlSystem().contains("GITHUB")) {
                String vcsLoc = "xpath=.//p-multiselectitem//*[text()='GIT']";
                driver.findElement(vcsLoc).waitForEnabled();
                QMetryUtility.click(driver.findElement(vcsLoc));
            } else {
                String vcsLoc = "xpath=.//p-multiselectitem//*[text()='"
                        + projectBean.getVersionControlSystem().split("-")[0] + "']";
                driver.findElement(vcsLoc).waitForEnabled();
                QMetryUtility.click(driver.findElement(vcsLoc));
            }
        } else {
            String vcsLoc = "xpath=.//p-multiselectitem//*[text()='" + projectBean.getVersionControlSystem() + "']";
            driver.findElement(vcsLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(vcsLoc));
        }
        if (projectBean.getVersionControlSystem().contains("BITBUCKET")
                || projectBean.getVersionControlSystem().contains("GITHUB")) {
            String configTypeLoc = "xpath=.//*[@value='" + projectBean.getVersionControlSystem().split("-")[1] + "']";
            driver.findElement(configTypeLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(configTypeLoc));
        }
        getRepositoryUrlTxtBox().waitForEnabled();
        getRepositoryUrlTxtBox().sendKeys(projectBean.getRepoUrl());
        if (projectBean.getVersionControlSystem().contains("BITBUCKET")
                || projectBean.getVersionControlSystem().contains("SVN")) {
            getUserNameTxtBox().waitForEnabled();
            getUserNameTxtBox().sendKeys(projectBean.getUsername());
            getPasswordTxtBox().waitForEnabled();
            getPasswordTxtBox().sendKeys(projectBean.getPassword());
        }
        if (projectBean.getVersionControlSystem().contains("GITLAB")
                || projectBean.getVersionControlSystem().contains("GITHUB")
                || projectBean.getVersionControlSystem().contains("AZUREDEVOPS")) {
            if (projectBean.getVersionControlSystem().contains("Cloud")) {
            } else if (projectBean.getVersionControlSystem().contains("Server")) {
                getServerVCSTypeRadioBtn().waitForEnabled();
                QMetryUtility.click(getServerVCSTypeRadioBtn());
            }
            getAccessTokenTxtBox().waitForEnabled();
            getAccessTokenTxtBox().sendKeys(projectBean.getAccessToken());
        }
        getTestAddBtn().waitForEnabled();
        QMetryUtility.click(getTestAddBtn());
        verifyAlertDialog(BDD_TEST_MESSAGE);
        getCloseMessageBtn().waitForEnabled();
        QMetryUtility.click(getCloseMessageBtn());
        getSaveBddBtn().waitForEnabled();
        QMetryUtility.click(getSaveBddBtn());
        verifyAlertDialog(BDD_SAVE_MESSAGE);
        getCloseMessageBtn().waitForEnabled();
        getCloseMessageBtn().click();
    }

    /**
     * A enum for drop down VersionControlSystem
     *
     * @author rahul.patil
     */
    public enum VersionControlSystem {
        BITBUCKET("BITBUCKET"), GIT("GIT"), SVN("SVN"), GITLAB("GITLAB");

        private String menuOption;

        private VersionControlSystem(String menuOption) {
            this.menuOption = menuOption;
        }

        @Override
        public String toString() {
            return menuOption;
        }
    }

    /**
     * This method will select dropdown value.
     * 
     * @param module
     * @param azureIssueType
     * @author rahul.patil
     */
    public void selectIssueTypeForModule(String integrationType, String module, String azureIssueType) {
        String azureIssueTypeDrpDwnBtn = "xpath=.//*[text()[normalize-space() = '" + module
                + "']]/following-sibling::td//*[text()='Select " + integrationType + " Type']";
        driver.findElement(azureIssueTypeDrpDwnBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(azureIssueTypeDrpDwnBtn));
        String issueTypeLoc = "xpath=.//p-multiselectitem//*[text()='" + azureIssueType + "']";
        driver.findElement(issueTypeLoc).waitForVisible();
        driver.findElement(issueTypeLoc).waitForEnabled();
        driver.findElement(issueTypeLoc).click();
    }

    /**
     * This method will select dropdown value.
     * 
     * @param instance
     * @author rahul.patil
     */
    public void selectIntegrationInstance(String integrationType, String instance) {
        String integrationInstanceDrpDwnBtn = "xpath=.//*[text()='Select " + integrationType + " Instance']";
        driver.findElement(integrationInstanceDrpDwnBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(integrationInstanceDrpDwnBtn));
        String instanceLoc = "xpath=.//p-multiselectitem//*[text()='" + instance + "']";
        driver.findElement(instanceLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(instanceLoc));
    }

    /**
     * This method will select dropdown value.
     * 
     * @param type
     * @author rahul.patil
     */
    public void selectIntegrationType(String type) {
        getSelectIntegrationTypeDrpDwnBtn().waitForVisible();
        getSelectIntegrationTypeDrpDwnBtn().waitForEnabled();
        QMetryUtility.click(getSelectIntegrationTypeDrpDwnBtn());
        String integrationTypeLoc = "xpath=.//p-multiselectitem//*[text()='" + type + "']";
        driver.findElement(integrationTypeLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(integrationTypeLoc));
    }

    /**
     * This method will select dropdown value.
     * 
     * @param integrationType
     * @param azureProject
     * @author rahul.patil
     */
    public void selectIntegrationProject(String integrationType, String integrationProject) {
        String issueTypeDrpDwnBtn = "xpath=.//*[text()='Select " + integrationType + " Project']";
        driver.findElement(issueTypeDrpDwnBtn).waitForPresent();
        driver.findElement(issueTypeDrpDwnBtn).waitForVisible();
        driver.findElement(issueTypeDrpDwnBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(issueTypeDrpDwnBtn));
        String projectLoc = "xpath=.//p-multiselectitem//*[text()='" + integrationProject + "']";
        driver.findElement(projectLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(projectLoc));
    }

    /**
     * This method will select dropdown value.
     * 
     * @param workspace
     * @author rahul.patil
     */
    public void selectRallyWorkspace(String workspace) {
        getSelectWorkspaceDrpDwnBtn().waitForPresent();
        getSelectWorkspaceDrpDwnBtn().waitForVisible();
        getSelectWorkspaceDrpDwnBtn().waitForEnabled();
        QMetryUtility.click(getSelectWorkspaceDrpDwnBtn());
        String workspaceLoc = "xpath=.//p-multiselectitem//*[text()='" + workspace + "']";
        driver.findElement(workspaceLoc).waitForVisible();
        driver.findElement(workspaceLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(workspaceLoc));
    }

    /**
     * This method will configure integration.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void configureIntegration(ProjectBean projectBean, boolean... isImportEntityInFolder) {
        selectIntegrationType(projectBean.getIntegrationType());
        waitForLoader(getProjectDetailViewLoader());
        selectIntegrationInstance(projectBean.getIntegrationType(), projectBean.getIntegrationInstance());
        waitForLoader(getProjectDetailViewLoader());
        if (projectBean.getIntegrationType().equals("Rally")) {
            selectRallyWorkspace(projectBean.getRallyWorkspace());
            waitForLoader(getProjectDetailViewLoader());
        }
        selectIntegrationProject(projectBean.getIntegrationType(), projectBean.getIntegrationProject());
        waitForLoader(getProjectDetailViewLoader());
        selectIssueTypeForModule(projectBean.getIntegrationType(), projectBean.getModule().split(":")[0],
                projectBean.getIssueType().split(":")[0]);
        selectIssueTypeForModule(projectBean.getIntegrationType(), projectBean.getModule().split(":")[1],
                projectBean.getIssueType().split(":")[1]);
        getBrowseFolderBtn().waitForEnabled();
        QMetryUtility.click(getBrowseFolderBtn());
        waitForLoader(getProjectDetailViewLoader());
        if (isImportEntityInFolder.length >= 1) {
            String folderLoc = "xpath=.//h4[text()='Select Folder']/parent::*/following-sibling::*//*[@aria-label='"
                    + projectBean.getFolderName() + "']";
            driver.findElement(folderLoc).waitForVisible();
            driver.findElement(folderLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(folderLoc));
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        getSelectFolderBtn().waitForVisible();
        getSelectFolderBtn().waitForEnabled();
        //QMetryUtility.click(getSelectFolderBtn());
        getSelectFolderBtn().click();
        getSelectFolderBtn().waitForNotVisible();
        getSaveAndActivateBtn().waitForEnabled();
        getSaveAndActivateBtn().click();
        waitForLoader(getProjectDetailViewLoader());
        getSaveAndActivateBtn().waitForNotVisible();
    }

    /**
     * Method will wait for table to load after operation.
     * 
     * @author rahul.patil
     */
    public void waitForReleaseTableToLoad() {
        do {
        } while (getReleasePageTableLoader().getAttribute("class").contains("disabled"));
        getEntityCountText().waitForEnabled();
    }

    /**
     * This method verifies the release present in list.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyRelease(ProjectBean projectBean) {
        /*
         * getRefreshBtn().waitForEnabled(); QMetryUtility.click(getRefreshBtn());
         */
        waitForReleaseTableToLoad();
        return getTable().getCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName(),
                CommonConstants.COLUMN_RELEASE).verifyText(projectBean.getReleaseName());
    }

    /**
     * This method verifies the cycle present in list.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyCycle(ProjectBean projectBean) {
        getTable().getPlusCircleByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName())
                .waitForVisible();
        QMetryUtility.click(
                getTable().getPlusCircleByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName()));
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
        return verifyValuePresentInList(getCycleTable().getReleaseCycleColumnValues(CommonConstants.COLUMN_CYCLE),
                projectBean.getCycleName());
    }

    /**
     * This method archives the release.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public void archiveRelease(ProjectBean projectBean) {
        unselectShowArchivedReleaseCheckBox();
        getTable().getArchiveButtonByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName())
                .waitForEnabled();
        QMetryUtility.click(
                getTable().getArchiveButtonByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName()));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
    }

    /**
     * This method verifies if release is archived.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyReleaseIsArchived(ProjectBean projectBean) {
        selectShowArchivedReleaseCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
        /*
         * getRefreshBtn().waitForEnabled(); QMetryUtility.click(getRefreshBtn());
         * waitForReleaseTableToLoad();
         */
        return getTable().verifyEntityIsArchived(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName());
    }

    /**
     * This method unarchives the release.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public void unarchiveRelease(ProjectBean projectBean) {
        waitForReleaseTableToLoad();
        selectShowArchivedReleaseCheckBox();
        waitForReleaseTableToLoad();
        getTable().getUnarchiveButtonByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName())
                .waitForEnabled();
        QMetryUtility.click(
                getTable().getUnarchiveButtonByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName()));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
    }

    /**
     * This method verifies if release is unarchived.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyReleaseIsUnarchived(ProjectBean projectBean) {
        unselectShowArchivedReleaseCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
        /*
         * getRefreshBtn().waitForEnabled(); QMetryUtility.click(getRefreshBtn());
         * waitForReleaseTableToLoad();
         */
        return getTable().verifyEntityIsUnarchived(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName());
    }

    /**
     * This method deletes the release.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public void deleteRelease(ProjectBean projectBean) {
        selectShowArchivedReleaseCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
        getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName())
                .waitForEnabled();
        QMetryUtility.click(
                getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName()));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
    }

    /**
     * This method verifies if release is deleted.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyReleaseIsDeleted(ProjectBean projectBean) {
        selectShowArchivedReleaseCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
        QAFWebElement relement = getRefreshBtn();
        relement.waitForVisible();
        relement.waitForEnabled();
        QMetryUtility.click(relement);
        waitForLoader(getProjectDetailViewLoader());
        waitForReleaseTableToLoad();
        return !verifyValuePresentInList(getTable().getReleaseCycleColumnValues(CommonConstants.COLUMN_RELEASE),
                projectBean.getReleaseName());
    }

    /**
     * This method verifies the project present in list.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyProject(ProjectBean projectBean) {
        return getTable().getCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName(),
                CommonConstants.COLUMN_PROJECTS).verifyText(projectBean.getProjectName());
    }

    /**
     * This method archives the cycle.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public void archiveCycle(ProjectBean projectBean) {
        unselectShowArchivedCycleCheckBox();
        waitForCycleTableToLoad();
        getCycleTable().getArchiveButtonByCellValue(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName())
                .waitForVisible();
        QMetryUtility.click(
                getCycleTable().getArchiveButtonByCellValue(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName()));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
    }

    /**
     * This method verifies if cycle is archived.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyCycleIsArchived(ProjectBean projectBean) {
        selectShowArchivedCycleCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
        return getCycleTable().verifyEntityIsArchived(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName());
    }

    /**
     * This method unarchives the cycle.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public void unarchivecycle(ProjectBean projectBean) {
        selectShowArchivedCycleCheckBox();
        waitForCycleTableToLoad();
        getCycleTable().getUnarchiveButtonByCellValue(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName())
                .waitForVisible();
        QMetryUtility.click(getCycleTable().getUnarchiveButtonByCellValue(CommonConstants.COLUMN_CYCLE,
                projectBean.getCycleName()));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
    }

    /**
     * This method verifies if cycle is unarchived.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyCycleIsUnarchived(ProjectBean projectBean) {
        unselectShowArchivedCycleCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
        return getCycleTable().verifyEntityIsUnarchived(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName());
    }

    /**
     * This method deletes the cycle.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public void deleteCycle(ProjectBean projectBean) {
        selectShowArchivedCycleCheckBox();
        waitForCycleTableToLoad();
        getCycleTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName())
                .waitForVisible();
        QMetryUtility.click(
                getCycleTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_CYCLE, projectBean.getCycleName()));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
    }

    /**
     * This method verifies if cycle is deleted.
     * 
     * @param projectBean
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyCycleIsDeleted(ProjectBean projectBean) {
        getTable().expandReleaseForCycle(CommonConstants.COLUMN_RELEASE, projectBean.getReleaseName());
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
        selectShowArchivedCycleCheckBox();
        waitForLoader(getProjectDetailViewLoader());
        waitForCycleTableToLoad();
        return !verifyValuePresentInList(getCycleTable().getReleaseCycleColumnValues(CommonConstants.COLUMN_CYCLE),
                projectBean.getCycleName());
    }

    /**
     * This method verifies if bdd configuration is added
     * 
     * @param url
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyBDDConfiguration(String url) {
        getTable().getCellValue(CommonConstants.COLUMN_REPOSITORY, url, CommonConstants.COLUMN_REPOSITORY)
                .waitForVisible();
        return getTable().getCellValue(CommonConstants.COLUMN_REPOSITORY, url, CommonConstants.COLUMN_REPOSITORY)
                .verifyText(url);
    }

    /**
     * This method verifies deleted BDD configuration
     * 
     * @param url
     * @author rahul.patil, nidhi.shah
     */
    public void deleteBDDConfiguration(String url) {
        getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_REPOSITORY, url).waitForVisible();
        QMetryUtility.click(getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_REPOSITORY, url));
        getYesBtn().waitForEnabled();
        QMetryUtility.click(getYesBtn());
        verifyAlertDialog(ProjectConstants.BDD_DELETE_MESSAGE);
        getCloseMessageBtn().waitForEnabled();
        QMetryUtility.click(getCloseMessageBtn());
    }

    /**
     * This method verifies if bdd configuration is deleted
     * 
     * @param url
     * @author rahul.patil, nidhi.shah
     */
    public boolean verifyBDDConfigurationIsDeleted(String url) {
        if (getBDDNoDataMessage().isPresent()) {
            Reporter.log("No Records present!");
            return true;
        }
        return !verifyValuePresentInList(getTable().getBDDConfigurationColumnValues(CommonConstants.COLUMN_REPOSITORY),
                url);
    }

    /**
     * This method verifies if bdd configuration is with URl is configured or not.
     * 
     * @param url
     * @author rahul.patil
     */
    public boolean checkForBddConfiguration(String url) {
        /* waitForLoader(getProjectDetailViewLoader()); */
        if (!getBDDNoDataMessage().isPresent()) {
            return verifyValuePresentInList(
                    getTable().getBDDConfigurationColumnValues(CommonConstants.COLUMN_REPOSITORY), url);
        }
        return false;
    }

    /**
     * This method will edit name of project.
     * 
     * @param testSuiteBean
     * @author rahul.patil
     */
    public void updateProjectName(ProjectBean projectBean) {

        String projectTitle = "xpath=.//*[@title='" + projectBean.getProjectName() + "']";
        driver.findElement(projectTitle).waitForEnabled();
        QMetryUtility.click(driver.findElement(projectTitle));

        getEditableTxtBox().waitForEnabled();
        getEditableTxtBox().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getEditableTxtBox().sendKeys(Keys.DELETE);
        getEditableTxtBox().sendKeys(projectBean.getUpdatedProjectName());

        String checkUpdatedProjectBtn = "xpath=.//*[@title='" + projectBean.getUpdatedProjectName()
                + "']/parent::div/following-sibling::div//*[contains(@class,'check')]/parent::button";
        driver.findElement(checkUpdatedProjectBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(checkUpdatedProjectBtn));

        String updatedProjectTitle = "xpath=.//*[@title='" + projectBean.getUpdatedProjectName() + "']";
        driver.findElement(updatedProjectTitle).waitForVisible();
        driver.findElement(updatedProjectTitle).verifyVisible();
        waitForLoader(getProjectDetailViewLoader());
    }

    /**
     * This method verifies the edited project present in list.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public boolean verifyEditProject(ProjectBean projectBean) {
        return getTable().getCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getUpdatedProjectName(),
                CommonConstants.COLUMN_PROJECTS).verifyText(projectBean.getUpdatedProjectName())
                && !verifyValuePresentInList(getTable().getListOfProject(), projectBean.getProjectName());
    }

    /**
     * This method will edit name of release.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void updateReleaseName(ProjectBean projectBean) {

        String releaseTitle = "xpath=.//*[@title='" + projectBean.getReleaseName() + "']";
        driver.findElement(releaseTitle).waitForEnabled();
        QMetryUtility.click(driver.findElement(releaseTitle));

        String releaseInput = "xpath=.//*[@title='" + projectBean.getReleaseName()
                + "']/parent::*[contains(@class,'editable-field')]/following-sibling::*//input";
        driver.findElement(releaseInput).waitForEnabled();
        driver.findElement(releaseInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(releaseInput).sendKeys(Keys.DELETE);
        String input = "xpath=.//*[@title='']/parent::*[contains(@class,'editable-field')]/following-sibling::*//input";
        driver.findElement(input).sendKeys(projectBean.getUpdatedReleaseName());

        String checkUpdatedReleaseBtn = "xpath=.//*[@title='" + projectBean.getUpdatedReleaseName()
                + "']/parent::div/following-sibling::div//*[contains(@class,'check')]/parent::button";
        driver.findElement(checkUpdatedReleaseBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(checkUpdatedReleaseBtn));

        String updatedReleaseTitle = "xpath=.//*[@title='" + projectBean.getUpdatedReleaseName() + "']";
        driver.findElement(updatedReleaseTitle).waitForVisible();
        driver.findElement(updatedReleaseTitle).verifyVisible();
    }

    /**
     * This method verifies the edited name release present in list.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public boolean verifyEditRelease(ProjectBean projectBean) {
        getRefreshBtn().waitForEnabled();
        QMetryUtility.click(getRefreshBtn());
        waitForReleaseTableToLoad();
        List<String> releaseList = getTable().getReleaseCycleColumnValues(CommonConstants.COLUMN_RELEASE);
        return !verifyValuePresentInList(releaseList, projectBean.getReleaseName())
                && verifyValuePresentInList(releaseList, projectBean.getUpdatedReleaseName());
    }

    /**
     * This method will edit name of cycle.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void updateCycleName(ProjectBean projectBean) {

        String cycleTitle = "xpath=.//*[@title='" + projectBean.getCycleName() + "']";
        driver.findElement(cycleTitle).waitForEnabled();
        QMetryUtility.click(driver.findElement(cycleTitle));

        String cycleInput = "xpath=.//*[@title='" + projectBean.getCycleName()
                + "']/parent::*[contains(@class,'editable-field')]/following-sibling::*//input";
        driver.findElement(cycleInput).waitForEnabled();
        driver.findElement(cycleInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(cycleInput).sendKeys(Keys.DELETE);
        String input = "xpath=.//*[@title='']/parent::*[contains(@class,'editable-field')]/following-sibling::*//input";
        driver.findElement(input).sendKeys(projectBean.getUpdatedCycleName());

        String checkUpdatedCycleBtn = "xpath=.//*[@title='" + projectBean.getUpdatedCycleName()
                + "']/parent::div/following-sibling::div//*[contains(@class,'check')]/parent::button";
        driver.findElement(checkUpdatedCycleBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(checkUpdatedCycleBtn));

        String updatedCycleTitle = "xpath=.//*[@title='" + projectBean.getUpdatedCycleName() + "']";
        driver.findElement(updatedCycleTitle).waitForVisible();
        driver.findElement(updatedCycleTitle).verifyVisible();
    }

    /**
     * This method verifies the edited cycle present in list.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public boolean verifyEditCycle(ProjectBean projectBean) {
        waitForCycleTableToLoad();
        List<String> cycleList = getCycleTable().getReleaseCycleColumnValues(CommonConstants.COLUMN_CYCLE);
        return !verifyValuePresentInList(cycleList, projectBean.getCycleName())
                && verifyValuePresentInList(cycleList, projectBean.getUpdatedCycleName());
    }

    /**
     * Method will wait for table to load after operation.
     * 
     * @author rahul.patil
     */
    public void waitForProjectsTableToLoad() {
        do {
        } while (getProjectsPageTableLoader().getAttribute("class").contains("disabled"));
    }

    /**
     * Method will select show archived check box.
     * 
     * @param checkBoxName
     * @author rahul.patil
     */
    public void selectShowArchivedProjectCheckBox(boolean isCheck) {
        if (isCheck == true) {
            if (!getShowArchivedProjectCheckBox().isSelected()) {
                getShowArchivedProjectCheckBox().waitForEnabled();
                getShowArchivedProjectCheckBox().click();
            }
        } else {
            if (isCheck == false) {
                if (getShowArchivedProjectCheckBox().isSelected()) {
                    getShowArchivedProjectCheckBox().waitForEnabled();
                    getShowArchivedProjectCheckBox().click();
                }

            }
        }
    }

    /**
     * This method verifies the edited project present in list.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public boolean verifyProjectIsDeleted(ProjectBean projectBean) {
        waitForProjectsTableToLoad();
        return !verifyValuePresentInList(getTable().getListOfProject(), projectBean.getProjectName());
    }

    /**
     * This method will edit name of cycle.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void archiveProject(ProjectBean projectBean) {
        getTable().getArchiveButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName())
                .waitForVisible();
        QMetryUtility.click(
                getTable().getArchiveButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName()));
        getYesBtn().waitForVisible();
        QMetryUtility.click(getYesBtn());
        waitForProjectsTableToLoad();
    }

    /**
     * This method will edit name of cycle.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void deleteProject(ProjectBean projectBean) {
        getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName())
                .waitForVisible();
        QMetryUtility.click(
                getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName()));
        getYesBtn().waitForVisible();
        QMetryUtility.click(getYesBtn());
        waitForProjectsTableToLoad();
    }

    /**
     * This method verifies the edited project present in list.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public boolean verifyProjectIsArchieved(ProjectBean projectBean) {
        selectShowArchivedProjectCheckBox(true);
        waitForProjectsTableToLoad();
        return getTable().verifyEntityIsArchived(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName());
    }

    /**
     * This method will link user to project.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void linkUserToProject(ProjectBean projectBean) {
        getLinkUserBtn().waitForVisible();
        getLinkUserBtn().waitForEnabled();
        QMetryUtility.click(getLinkUserBtn());
        getLinkUserFilter().waitForVisible();
        QMetryUtility.click(getLinkUserFilter());
        getFilterFirstNameTxtBox().waitForVisible();
        getFilterFirstNameTxtBox().sendKeys(projectBean.getUsername());
        getFilterSearchBtn().waitForEnabled();
        QMetryUtility.click(getFilterSearchBtn());
        waitForLoader(getLinkUserPageLoader());
        getLinkUserTable().getCheckBoxByCellValue("Username", projectBean.getUsername()).waitForVisible();
        QMetryUtility.click(getLinkUserTable().getCheckBoxByCellValue("Username", projectBean.getUsername()));
        String roleDrpDwnBtnLoc = "xpath=.//*[text()='" + projectBean.getUsername()
                + "']/parent::td/following-sibling::td//p-multiselect";
        driver.findElement(roleDrpDwnBtnLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(roleDrpDwnBtnLoc));
        String roleTxtBox = "xpath=.//*[text()='" + projectBean.getUsername()
                + "']/parent::td/following-sibling::td//input[@role='textbox']";
        driver.findElement(roleTxtBox).waitForVisible();
        driver.findElement(roleTxtBox).sendKeys(projectBean.getRole());
        String roleLoc = "xpath=.//p-multiselectitem//*[text()='" + projectBean.getRole() + "']";
        driver.findElement(roleLoc).waitForVisible();
        QMetryUtility.click(driver.findElement(roleLoc));
        getLinkSelectedUserBtn().waitForEnabled();
        QMetryUtility.click(getLinkSelectedUserBtn());
    }

    /**
     * This method will link user to project.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void linkUserToProjectwithSelectedRole(ProjectBean projectBean) {
        getLinkUserBtn().waitForVisible();
        getLinkUserBtn().waitForEnabled();
        QMetryUtility.click(getLinkUserBtn());
        getLinkUserFilter().waitForVisible();
        QMetryUtility.click(getLinkUserFilter());
        getFilterFirstNameTxtBox().waitForVisible();
        getFilterFirstNameTxtBox().sendKeys(projectBean.getUsername());
        getFilterSearchBtn().waitForEnabled();
        QMetryUtility.click(getFilterSearchBtn());
        waitForLoader(getLinkUserPageLoader());
        getLinkUserTableSpanish().getCheckBoxByCellValue("Username", projectBean.getUsername()).waitForVisible();
        QMetryUtility.click(getLinkUserTableSpanish().getCheckBoxByCellValue("Username", projectBean.getUsername()));
        String roleDrpDwnBtnLoc = "xpath=.//*[text()='" + projectBean.getUsername()
                + "']/parent::td/following-sibling::td//p-multiselect[@name='role']";
        driver.findElement(roleDrpDwnBtnLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(roleDrpDwnBtnLoc));
        String roleTxtBox = "xpath=.//*[text()='" + projectBean.getUsername()
                + "']/parent::td/following-sibling::td//input[contains(@class,'multiselect')]";
        driver.findElement(roleTxtBox).waitForVisible();
        driver.findElement(roleTxtBox).sendKeys(projectBean.getRole());
        String roleLoc = "xpath=.//p-multiselectitem//*[contains(text(),'" + projectBean.getRole() + "')]";
        driver.findElement(roleLoc).waitForVisible();
        QMetryUtility.click(driver.findElement(roleLoc));
        getLinkSelectedUserBtn().waitForEnabled();
        QMetryUtility.click(getLinkSelectedUserBtn());
    }

    /**
     * This method verifies the project present in list with spanish language.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public boolean verifyProjectSpanish(ProjectBean projectBean) {
        return getTable().getCellValue(CommonConstants.COLUMN_PROJECTS_SPANISH, projectBean.getProjectName(),
                CommonConstants.COLUMN_PROJECTS_SPANISH).verifyText(projectBean.getProjectName());
    }

    /**
     * This method will link user to project with spanish language.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public void linkUserToProjectSpanish(ProjectBean projectBean) {
        getLinkUserBtnSpanish().waitForVisible();
        getLinkUserBtnSpanish().waitForEnabled();
        QMetryUtility.click(getLinkUserBtnSpanish());
        getLinkUserFilterSpanish().waitForVisible();
        QMetryUtility.click(getLinkUserFilterSpanish());
        getFilterFirstNameTxtBox().waitForVisible();
        getFilterFirstNameTxtBox().sendKeys(projectBean.getUsername());
        getFilterSearchBtnSpanish().waitForEnabled();
        QMetryUtility.click(getFilterSearchBtnSpanish());
        waitForLoader(getLinkUserPageLoaderSpanish());
        getLinkUserTableSpanish().getCheckBoxByCellValue("nombre de usuario", projectBean.getUsername())
                .waitForVisible();
        QMetryUtility.click(
                getLinkUserTableSpanish().getCheckBoxByCellValue("nombre de usuario", projectBean.getUsername()));
        String roleDrpDwnBtnLoc = "xpath=.//*[text()='" + projectBean.getUsername()
                + "']/parent::td/following-sibling::td//p-multiselect[@name='role']";
        driver.findElement(roleDrpDwnBtnLoc).waitForEnabled();
        QMetryUtility.click(driver.findElement(roleDrpDwnBtnLoc));
        String roleTxtBox = "xpath=.//*[text()='" + projectBean.getUsername()
                + "']/parent::td/following-sibling::td//input[contains(@class,'multiselect')]";
        driver.findElement(roleTxtBox).waitForVisible();
        driver.findElement(roleTxtBox).sendKeys("Admin");
        String roleLoc = "xpath=.//p-multiselectitem//*[contains(text(),'Admin')]";
        driver.findElement(roleLoc).waitForVisible();
        QMetryUtility.click(driver.findElement(roleLoc));
        getLinkSelectedUserBtnSpanish().waitForEnabled();
        QMetryUtility.click(getLinkSelectedUserBtnSpanish());
    }

    /**
     * This method will test bdd configuration.
     * 
     * @param entityName
     * @author rahul.patil
     */
    public void testBddConfiguration(ProjectBean projectBean) {
        getAddBddConfigBtn().waitForEnabled();
        QMetryUtility.click(getAddBddConfigBtn());
        getVersionControlSystemDrpDwnBtn().waitForEnabled();
        QMetryUtility.click(getVersionControlSystemDrpDwnBtn());
        if (projectBean.getVersionControlSystem().contains("-")) {
            if (projectBean.getVersionControlSystem().contains("GITHUB")) {
                String vcsLoc = "xpath=.//p-multiselectitem//*[text()='GIT']";
                driver.findElement(vcsLoc).waitForEnabled();
                QMetryUtility.click(driver.findElement(vcsLoc));
            } else {
                String vcsLoc = "xpath=.//p-multiselectitem//*[text()='"
                        + projectBean.getVersionControlSystem().split("-")[0] + "']";
                driver.findElement(vcsLoc).waitForEnabled();
                QMetryUtility.click(driver.findElement(vcsLoc));
            }
        } else {
            String vcsLoc = "xpath=.//p-multiselectitem//*[text()='" + projectBean.getVersionControlSystem() + "']";
            driver.findElement(vcsLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(vcsLoc));
        }
        if (projectBean.getVersionControlSystem().contains("BITBUCKET")
                || projectBean.getVersionControlSystem().contains("GITHUB")) {
            String configTypeLoc = "xpath=.//*[@value='" + projectBean.getVersionControlSystem().split("-")[1] + "']";
            driver.findElement(configTypeLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(configTypeLoc));
        }
        getRepositoryUrlTxtBox().waitForEnabled();
        getRepositoryUrlTxtBox().sendKeys(projectBean.getRepoUrl());
        if (projectBean.getVersionControlSystem().contains("BITBUCKET")
                || projectBean.getVersionControlSystem().contains("SVN")) {
            getUserNameTxtBox().waitForEnabled();
            getUserNameTxtBox().sendKeys(projectBean.getUsername());
            getPasswordTxtBox().waitForEnabled();
            getPasswordTxtBox().sendKeys(projectBean.getPassword());
        }
        if (projectBean.getVersionControlSystem().contains("GITLAB")
                || projectBean.getVersionControlSystem().contains("GITHUB")
                || projectBean.getVersionControlSystem().contains("AZUREDEVOPS")) {
            if (projectBean.getVersionControlSystem().contains("Cloud")) {
            } else if (projectBean.getVersionControlSystem().contains("Server")) {
                getServerVCSTypeRadioBtn().waitForEnabled();
                QMetryUtility.click(getServerVCSTypeRadioBtn());
            }
            getAccessTokenTxtBox().waitForEnabled();
            getAccessTokenTxtBox().sendKeys(projectBean.getAccessToken());
        }
        getTestAddBtn().waitForEnabled();
        QMetryUtility.click(getTestAddBtn());
    }

    /**
     * This method will add bdd configuration.
     * 
     * @param entityName
     * @author rahul.patil
     */
    public void editBddConfiguration(ProjectBean projectBean) {
        getTable().getEditButtonByCellValue(CommonConstants.COLUMN_REPOSITORY, projectBean.getRepoUrl())
                .waitForEnabled();
        QMetryUtility.click(
                getTable().getEditButtonByCellValue(CommonConstants.COLUMN_REPOSITORY, projectBean.getRepoUrl()));
        getYesBtn().waitForVisible();
        QMetryUtility.click(getYesBtn());
        getVersionControlSystemDrpDwnBtn().waitForEnabled();
        QMetryUtility.click(getVersionControlSystemDrpDwnBtn());
        if (projectBean.getVersionControlSystem().contains("-")) {
            if (projectBean.getVersionControlSystem().contains("GITHUB")) {
                String vcsLoc = "xpath=.//p-multiselectitem//*[text()='GIT']";
                driver.findElement(vcsLoc).waitForEnabled();
                QMetryUtility.click(driver.findElement(vcsLoc));
            } else {
                String vcsLoc = "xpath=.//p-multiselectitem//*[text()='"
                        + projectBean.getVersionControlSystem().split("-")[0] + "']";
                driver.findElement(vcsLoc).waitForEnabled();
                QMetryUtility.click(driver.findElement(vcsLoc));
            }
        } else {
            String vcsLoc = "xpath=.//p-multiselectitem//*[text()='" + projectBean.getVersionControlSystem() + "']";
            driver.findElement(vcsLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(vcsLoc));
        }
        if (projectBean.getVersionControlSystem().contains("BITBUCKET")
                || projectBean.getVersionControlSystem().contains("GITHUB")) {
            String configTypeLoc = "xpath=.//*[@value='" + projectBean.getVersionControlSystem().split("-")[1] + "']";
            driver.findElement(configTypeLoc).waitForEnabled();
            QMetryUtility.click(driver.findElement(configTypeLoc));
        }
        getRepositoryUrlTxtBox().waitForEnabled();
        getRepositoryUrlTxtBox().clear();
        getRepositoryUrlTxtBox().sendKeys(projectBean.getRepoUrl());
        if (projectBean.getVersionControlSystem().contains("BITBUCKET")
                || projectBean.getVersionControlSystem().contains("SVN")) {
            getUserNameTxtBox().waitForEnabled();
            getUserNameTxtBox().clear();
            getUserNameTxtBox().sendKeys(projectBean.getUsername());
            getPasswordTxtBox().waitForEnabled();
            getPasswordTxtBox().clear();
            getPasswordTxtBox().sendKeys(projectBean.getPassword());
        }
        if (projectBean.getVersionControlSystem().contains("GITLAB")
                || projectBean.getVersionControlSystem().contains("GITHUB")) {
            getAccessTokenTxtBox().waitForEnabled();
            getAccessTokenTxtBox().clear();
            getAccessTokenTxtBox().sendKeys(projectBean.getAccessToken());
        }
        getTestAddBtn().waitForEnabled();
        QMetryUtility.click(getTestAddBtn());
        verifyAlertDialog(BDD_TEST_MESSAGE);
        getCloseMessageBtn().waitForEnabled();
        QMetryUtility.click(getCloseMessageBtn());
        getUpdateBddBtn().waitForEnabled();
        QMetryUtility.click(getUpdateBddBtn());
        verifyAlertDialog(BDD_UPDATE_MESSAGE);
        getCloseMessageBtn().waitForEnabled();
        QMetryUtility.click(getCloseMessageBtn());
    }

    /**
     * This method will return list of values present in version control system drop
     * down.
     * 
     * @author rahul.patil
     */
    public List<String> getVersionControlSystemValues() {
        getVersionControlSystemDrpDwnBtn().waitForVisible();
        QMetryUtility.click(getVersionControlSystemDrpDwnBtn());
        List<String> dropDownValues = new ArrayList<String>();
        for (QAFWebElement valueElement : getDrpDwnValues()) {
            dropDownValues.add(valueElement.getAttribute("aria-label"));
        }
        return dropDownValues;
    }

    /**
     * This method will check for cloud and server radio button for VCS type passed
     * as an argument
     * 
     * @author rahul.patil
     */
    public boolean verifyCloudAndServerTypeForVCS(String versionContolSystem) {
        String vcsLoc = "xpath=.//p-multiselectitem//*[text()='" + versionContolSystem + "']";
        driver.findElement(vcsLoc).waitForVisible();
        QMetryUtility.click(driver.findElement(vcsLoc));
        return getCloudVCSTypeRadioBtn().verifyVisible() && getServerVCSTypeRadioBtn().verifyVisible();
    }

    /**
     * Method will select show only archived version check box.
     * 
     * @param isCheck
     * @author rahul.patil
     */
    public void selectDeriveTestcaseExecutionFromTestcaseStepSatusCheckBox(boolean isCheck) {
        if (isCheck == true) {
            getDeriveExecutionStatusFromTeststepOnOffSwitch().waitForVisible();
            if (!getDeriveExecutionStatusFromTeststepCheckbox().isSelected()) {
                getDeriveExecutionStatusFromTeststepOnOffSwitch().waitForEnabled();
                QMetryUtility.click(getDeriveExecutionStatusFromTeststepOnOffSwitch());
                getDeriveExecutionStatusFromTeststepCheckbox().waitForSelected();
            }
        } else {
            if (isCheck == false) {
                getDeriveExecutionStatusFromTeststepOnOffSwitch().waitForVisible();
                if (getDeriveExecutionStatusFromTeststepCheckbox().isSelected()) {
                    getDeriveExecutionStatusFromTeststepOnOffSwitch().waitForVisible();
                    getDeriveExecutionStatusFromTeststepOnOffSwitch().waitForEnabled();
                    QMetryUtility.click(getDeriveExecutionStatusFromTeststepOnOffSwitch());
                    getDeriveExecutionStatusFromTeststepCheckbox().waitForNotSelected();
                }
            }
        }
    }

    /**
     * This method will edit name of cycle.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void cloneProject(ProjectBean projectBean) {
        getTable().getCloneButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName())
                .waitForVisible();
        QMetryUtility.click(
                getTable().getCloneButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName()));
        getCloneProjectNameTxtBox().waitForVisible();
        getCloneProjectNameTxtBox().clear();
        getCloneProjectNameTxtBox().sendKeys(projectBean.getClonedProjectName());
        getCloneProjectKeyTxtBox().clear();
        getCloneProjectKeyTxtBox().sendKeys(projectBean.getProjectKey());
        getFolderStructureAlongWithDataRadioBtn().waitForEnabled();
        QMetryUtility.click(getFolderStructureAlongWithDataRadioBtn());
        getCloneProjectBtn().waitForEnabled();
        QMetryUtility.click(getCloneProjectBtn());
        getProjectCloneYesContinueBtn().waitForVisible();
        QMetryUtility.click(getProjectCloneYesContinueBtn());
        getCloseMessageBtn().waitForVisible();
        QMetryUtility.click(getCloseMessageBtn());
        waitForNewBtn();
        waitForProjectsTableToLoad();
    }

    /**
     * This method verifies the edited project present in list.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public boolean verifyClonedProject(ProjectBean projectBean) {
        for (int i = 0; i < 35; i++) {
            getRefreshBtn().waitForEnabled();
            QMetryUtility.click(getRefreshBtn());
            waitForProjectsTableToLoad();
            if (!verifyValuePresentInList(getTable().getListOfProject(), projectBean.getClonedProjectName())) {
            } else {
                return true;
            }

        }
        return false;
    }

    /**
     * Method will turn on and off enable rich text switch.
     * 
     * @param isOnSwitch
     * @author rahul.patil
     */
    public void selectEnableRichTextOnOffSwitch(boolean isOnSwitch) {
        if (isOnSwitch == true) {
            getEnableRichTextOnOffSwitch().waitForVisible();
            if (!getEnableRichTextInput().isSelected()) {
                getEnableRichTextOnOffSwitch().waitForEnabled();
                QMetryUtility.click(getEnableRichTextOnOffSwitch());
                getYesBtn().waitForVisible();
                QMetryUtility.click(getYesBtn());
                getEnableRichTextInput().waitForSelected();
            }
        } else {
            if (isOnSwitch == false) {
                getEnableRichTextOnOffSwitch().waitForVisible();
                if (getEnableRichTextInput().isSelected()) {
                    getEnableRichTextOnOffSwitch().waitForVisible();
                    getEnableRichTextOnOffSwitch().waitForEnabled();
                    QMetryUtility.click(getEnableRichTextOnOffSwitch());
                    getYesBtn().waitForVisible();
                    QMetryUtility.click(getYesBtn());
                    getEnableRichTextInput().waitForNotSelected();
                }
            }
        }
    }

    /**
     * Method will turn on and off enable rich text switch.
     * 
     * @param isOnSwitch
     * @author rahul.patil
     */
    public void selectBuildSelectionMandatoryOnOffSwitch(boolean isOnSwitch) {
        if (isOnSwitch == true) {
            getBuildSelectionMandatoryOnOffSwitch().waitForVisible();
            if (!getBuildSelectionMandatoryCheckBox().isSelected()) {
                getBuildSelectionMandatoryOnOffSwitch().waitForEnabled();
                QMetryUtility.click(getBuildSelectionMandatoryOnOffSwitch());
                getBuildSelectionMandatoryCheckBox().waitForSelected();
            }
        } else {
            if (isOnSwitch == false) {
                getBuildSelectionMandatoryOnOffSwitch().waitForVisible();
                if (getBuildSelectionMandatoryCheckBox().isSelected()) {
                    getBuildSelectionMandatoryOnOffSwitch().waitForVisible();
                    getBuildSelectionMandatoryOnOffSwitch().waitForEnabled();
                    QMetryUtility.click(getBuildSelectionMandatoryOnOffSwitch());
                    getBuildSelectionMandatoryCheckBox().waitForNotSelected();
                }
            }
        }
    }

    /**
     * This method will apply filter to projets page.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void applyFilterToProjectsByProjectKey(ProjectBean projectBean) {
        getProjectFilterBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterBtn());
        getFilterProjectKeyTxtBox().waitForVisible();
        getFilterProjectKeyTxtBox().clear();
        getFilterProjectKeyTxtBox().sendKeys(projectBean.getProjectKey());
        getProjectFilterSearchBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterSearchBtn());
        waitForProjectsTableToLoad();
        getProjectFilterBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterBtn());
    }

    /**
     * This method will apply filter to projets page.
     * 
     * @param projectBean
     * @author rahul.patil
     */
    public void applyFilterToProjectsByProjectName(ProjectBean projectBean) {
        getProjectFilterBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterBtn());
        getFilterProjectsTxtBox().waitForVisible();
        getFilterProjectsTxtBox().clear();
        getFilterProjectsTxtBox().sendKeys(projectBean.getProjectName());
        getProjectFilterSearchBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterSearchBtn());
        waitForProjectsTableToLoad();
        getProjectFilterBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterBtn());
    }

    /**
     * This method will apply filter to projets page.
     * 
     * @author rahul.patil
     */
    public void clearProjectsFilter() {
        getProjectFilterBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterBtn());
        getProjectFilterClearBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterClearBtn());
        waitForProjectsTableToLoad();
        getProjectFilterBtn().waitForEnabled();
        QMetryUtility.click(getProjectFilterBtn());
    }

    /**
     * This method will select dropdown value.
     * 
     * @param DropDownLabels
     * @param dropDownValue
     * @author rahul.patil
     */
    public QAFWebElement getAutomationToolDrpDwnOption(String dropDownValue) {
        String locFolder = "xpath=.//label[text()='Select Automation Tool']/following-sibling::p-multiselect[@name='automationTool']//ul[@role='listbox']//li[@aria-label='"
                + dropDownValue + "']";
        return driver.findElement(locFolder);
    }

    /**
     * This method will select dropdown value.
     * 
     * @param DropDownLabels
     * @param dropDownValue
     * @author rahul.patil
     */
    public void selectAutomationTool(String dropDownValue) {
        openAutomationToolOptions();
        QAFWebElement automationToolOption = getAutomationToolDrpDwnOption(dropDownValue);
        if (!automationToolOption.getAttribute("class").contains("highlight")) {
            automationToolOption.waitForVisible();
            QMetryUtility.click(automationToolOption);
            waitForLoader(getProjectDetailViewLoader());
            getCloseMessageBtn().waitForVisible();
            QMetryUtility.click(getCloseMessageBtn());
        }

    }

    /**
     * This method will return list of values present in version control system drop
     * down.
     * 
     * @author rahul.patil
     */
    public List<String> getAutomationToolDropDownValue() {
        List<String> dropDownValues = new ArrayList<String>();
        for (QAFWebElement valueElement : getAutomationToolDropDownValuesLocList()) {
            dropDownValues.add(valueElement.getAttribute("aria-label"));
        }
        return dropDownValues;
    }

    /**
     * This method verifies the project present in list.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public boolean verifyScopeProjectIsHighlighted(ProjectBean projectBean) {
        String loc = "xpath=.//*[text()[normalize-space()='" + projectBean.getProjectName() + "']]//ancestor::tr";
        return driver.findElement(loc).getAttribute("class").contains("scope");
    }

    /**
     * This method verifies the project present in list.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public boolean verifyArchiveBtnAtScopeProject(ProjectBean projectBean) {

        String loc = "xpath=.//*[text()[normalize-space()='" + projectBean.getProjectName() + "']]//ancestor::tr";
        return driver.findElement(loc).getAttribute("class").contains("scope");
    }

    /**
     * This method will select add release or add cycle option.
     * 
     * @param entityName
     * @author priyanka.devaliya
     * @return
     */
    public boolean verifyReleaseAtCycleDrpDwn(List releases) {
        selectAddEntity("Cycle");
        getReleaseDrpDwn().waitForEnabled();
        QMetryUtility.click(getReleaseDrpDwn());
        Iterator iterator = releases.iterator();
        boolean value = true;
        while (iterator.hasNext()) {
            String releaseLoc = "xpath=.//p-multiselectitem//*[text()='" + iterator.next() + "']";
            driver.findElement(releaseLoc).waitForEnabled();
            value = driver.findElement(releaseLoc).verifyPresent();
        }
        return value;
    }

    /*
     * This method will select add release or add cycle option.
     * 
     * @param entityName
     * 
     * @author priyanka.devaliya
     * 
     * @return
     */
    public boolean verifyReleaseNotPresentAtCycleDrpDwn(ProjectBean projectBean) {
        selectAddEntity("Cycle");
        getReleaseDrpDwn().waitForEnabled();
        QMetryUtility.click(getReleaseDrpDwn());

        List<String> columnValues = new ArrayList<>();

        String entityKeyValues = "xpath=.//p-multiselectitem";
        int size = driver.findElements(entityKeyValues).size();
        for (int i = 0; i < size; i++) {
            columnValues.add(driver.findElements(entityKeyValues).get(i).getText());
        }

        return !verifyValuePresentInList(columnValues, projectBean.getReleaseName());
    }

    /**
     * This method will edit description of project.
     * 
     * @param testSuiteBean
     * @author priyanka.devaliya
     */
    public void updateProjectDescription(String description) {

        String projectTitle = "xpath=.//*[@title='None']";
        driver.findElement(projectTitle).waitForEnabled();
        QMetryUtility.click(driver.findElement(projectTitle));

        getEditDescriptionTxtBox().waitForEnabled();
        getEditDescriptionTxtBox().sendKeys(description);
        waitForTableToLoad();

    }

    /**
     * This method will edit description of project.
     * 
     * @param testSuiteBean
     * @author priyanka.devaliya
     */
    public void verifyupdatedProjectDescription(String description) {

        String checkUpdatedDescription = "xpath=.//*[@title='" + description + "']";
        driver.findElement(checkUpdatedDescription).waitForVisible();
        driver.findElement(checkUpdatedDescription).verifyVisible();

    }

    /**
     * This method verifies the edited project present in list.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public boolean verifyEditProjectDescription(ProjectBean projectBean) {
        return getTable().getCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectDescription(),
                CommonConstants.COLUMN_PROJECTS).verifyText(projectBean.getProjectDescription());
    }

    /**
     * This method will add custom field of jira
     * 
     * @param projectName
     * @author priyanka.devaliya
     */
    public void addCustomField(ProjectBean projectBean) {
        String locFolder = "xpath=.//*[text()[normalize-space()='" + projectBean.getIntegrationInstance() + "']]/span";
        driver.findElement(locFolder).waitForVisible();
        driver.findElement(locFolder).waitForEnabled();
        driver.findElement(locFolder).click();
        for (String module : projectBean.getModules()) {
            String jiraFiledSettingLoc = "xpath=.//*[text()[normalize-space() = '" + module
                    + "']]/following-sibling::td//*[@title='Jira Field Settings']";
            driver.findElement(jiraFiledSettingLoc).waitForEnabled();
            driver.findElement(jiraFiledSettingLoc).click();
            getEditJiraConfigTable().getCheckBoxByCellValueWithText(COLUMN_JIRA_FIELD_NAME, projectBean.getFieldValue())
                    .click();
            getSaveJiraConfigCustomFieldBtn().waitForVisible();
            getSaveJiraConfigCustomFieldBtn().waitForEnabled();
            getSaveJiraConfigCustomFieldBtn().click();
        }
    }

    /**
     * This method will edit name of cycle.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public boolean verifyProjectKeyAtHover(ProjectBean projectBean) {
        String projectKey = "xpath=.//*[@title='Project Key: " + projectBean.getProjectKey() + "']";
        driver.findElement(projectKey).waitForEnabled();
        return driver.findElement(projectKey).verifyPresent();

    }

    /**
     * This method will clone Project With Folder Structure.
     * 
     * @param projectBean
     * @author priyanka.devaliya
     */
    public void cloneProjectWithFolderStructure(ProjectBean projectBean) {
        getTable().getCloneButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName())
                .waitForVisible();
        QMetryUtility.click(
                getTable().getCloneButtonByCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName()));
        getCloneProjectNameTxtBox().waitForVisible();
        getCloneProjectNameTxtBox().clear();
        getCloneProjectNameTxtBox().sendKeys(projectBean.getClonedProjectName());
        getCloneProjectKeyTxtBox().clear();
        getCloneProjectKeyTxtBox().sendKeys(projectBean.getProjectKey());
        getFolderStructureRadioBtn().waitForEnabled();
        QMetryUtility.click(getFolderStructureRadioBtn());
        getFolderStructureRadioBtn().waitForSelected();
        getCloneProjectBtn().waitForEnabled();
        QMetryUtility.click(getCloneProjectBtn());
        getProjectCloneYesContinueBtn().waitForVisible();
        QMetryUtility.click(getProjectCloneYesContinueBtn());
        getCloseMessageBtn().waitForVisible();
        QMetryUtility.click(getCloseMessageBtn());
        getLocNewBtn().waitForVisible();
        waitForProjectsTableToLoad();

    }

    public void clickIntegrationInstance(ProjectBean projectBean) {
        String locFolder = "xpath=.//*[text()[normalize-space()='" + projectBean.getIntegrationInstance() + "']]/span";
        driver.findElement(locFolder).waitForVisible();
        driver.findElement(locFolder).waitForEnabled();
        driver.findElement(locFolder).click();
    }

    /**
     * This method will select dropdown value.
     * 
     * @param DropDownLabels
     * @param dropDownValue
     * @author priyanka.devaliya
     */
    public void selectFieldValue(String field, String dropDownValue) {
        String dropDownLoc = "xpath=.//*[contains(text(),'" + field + "')]/parent::*//p-multiselect";
        driver.findElement(dropDownLoc).waitForEnabled();
        driver.findElement(dropDownLoc).waitForVisible();
        driver.findElement(dropDownLoc).click();
        String locFolder = "xpath=.//p-multiselectitem//*[contains(text(),'" + dropDownValue + "')]";
        driver.findElement(locFolder).waitForEnabled();
        driver.findElement(locFolder).click();
    }

    /**
     * This method will select dropdown value.
     * 
     * @param DropDownLabels
     * @param dropDownValue
     * @author priyanka.devaliya
     */
    public boolean verifyField2ValueWithoutSelectingfield1(String field) {
        String dropDownLoc = "xpath=.//*[contains(text(),'" + field + "')]/parent::*//p-multiselect";
        driver.findElement(dropDownLoc).waitForEnabled();
        driver.findElement(dropDownLoc).waitForVisible();
        driver.findElement(dropDownLoc).click();
        String locFolder = "xpath=.//*[text()[normalize-space()='No results found']]";
        driver.findElement(locFolder).waitForVisible();
        return driver.findElement(locFolder).isPresent();
    }

    /**
     * This method will select jira field in project.
     * 
     * @param projectName
     * @param role
     * @author priyanka.devaliya
     */
    public void searchJiraField(String field, String fieldValue) {
        String dropDownLoc = "xpath=.//*[contains(text(),'" + field + "')]/parent::*//p-multiselect";
        driver.findElement(dropDownLoc).waitForEnabled();
        driver.findElement(dropDownLoc).waitForVisible();
        driver.findElement(dropDownLoc).click();
        String roleTxtBox = "xpath=.//*[@placeholder='Search...']";
        driver.findElement(roleTxtBox).waitForVisible();
        driver.findElement(roleTxtBox).sendKeys(fieldValue);
        String roleLoc = "xpath=.//p-multiselectitem//*[contains(text(),'" + fieldValue + "')]";
        driver.findElement(roleLoc).waitForVisible();
        QMetryUtility.click(driver.findElement(roleLoc));
    }

    /**
     * This method will select dropdown value.
     * 
     * @param module
     * @param azureIssueType
     * @author priyanka.devaliya
     */
    public void selectMultipleIssueTypeForModule(String integrationType, String module, List<String> issueTypes) {
        String azureIssueTypeDrpDwnBtn = "xpath=.//*[text()[normalize-space() = '" + module
                + "']]/following-sibling::td//*[text()='Select " + integrationType + " Type']";
        driver.findElement(azureIssueTypeDrpDwnBtn).waitForEnabled();
        QMetryUtility.click(driver.findElement(azureIssueTypeDrpDwnBtn));
        for (String issueType : issueTypes) {
            String issueTypeLoc = "xpath=.//p-multiselectitem//*[text()='" + issueType + "']";
            driver.findElement(issueTypeLoc).waitForVisible();
            driver.findElement(issueTypeLoc).waitForEnabled();
            driver.findElement(issueTypeLoc).click();
        }
    }

    /**
     * This method will select dropdown value.
     * 
     * @author rahul.patil
     */
    public void openAutomationToolOptions() {
        QAFWebElement automationToolOptions = getAutomationToolDropDown();
        automationToolOptions.waitForVisible();
        if (!automationToolOptions.getAttribute("class").contains("open")) {
            automationToolOptions.waitForEnabled();
            QMetryUtility.click(automationToolOptions);
        }

    }

    /**
     * This method will select dropdown value.
     * 
     * @author rahul.patil
     */
    public void closeAutomationToolOptions() {
        QAFWebElement automationToolOptions = getAutomationToolDropDown();
        automationToolOptions.waitForVisible();
        if (automationToolOptions.getAttribute("class").contains("open")) {
            automationToolOptions.waitForEnabled();
            QMetryUtility.click(automationToolOptions);
        }

    }

    /**
     * This method will return element present on workflow CTM tab.
     * 
     * @param fieldLabel
     * @author rahul.patil
     */
    public QAFWebElement getWorkflowCTMTextboxLocByLabel(String fieldLabel) {
        String workflowCTMInputLoc = "xpath=.//label[text()='" + fieldLabel + "']/following-sibling::input";
        return driver.findElement(workflowCTMInputLoc);
    }

    /**
     * This method will return required field loc present on workflow CTM tab.
     * 
     * @param fieldLabel
     * @author rahul.patil
     */
    public QAFWebElement getWorkflowCTMFieldRequiredFieldLoc(String fieldLabel) {
        String workflowCTMInputLoc = "xpath=.//label[text()='" + fieldLabel + "']/parent::*";
        return driver.findElement(workflowCTMInputLoc);
    }

    /**
     * This method will select dropdown value.
     * 
     * @param module
     * @param azureIssueType
     * @author priyanka.devaliya
     */
    public void saveWorksoftCTM(ProjectBean projectBean) {
        getWorkflowCTMTextboxLocByLabel("Worksoft CTM URL").sendKeys(projectBean.getWorkFlowCTMUrl());
        getWorkflowCTMTextboxLocByLabel("Authentication URL").sendKeys(projectBean.getWorkFlowCTMAuthenticationURL());
        getWorkflowCTMTextboxLocByLabel("User Name").sendKeys(projectBean.getWorkFlowCTMUserName());
        getWorkflowCTMTextboxLocByLabel("Password").sendKeys(projectBean.getWorkFlowCTMPassword());
        getWorkflowCTMTextboxLocByLabel("Tenant ID").sendKeys(projectBean.getWorkFlowCTMTenantID());
        getWorkflowCTMTextboxLocByLabel("Client ID").sendKeys(projectBean.getWorkFlowCTMClientID());
        getWorksoftCTMSaveBtn().waitForEnabled();
        QMetryUtility.click(getWorksoftCTMSaveBtn());
    }

    /**
     * Method will select show only archived version check box.
     * 
     * @param isSwitchOn
     * @author rahul.patil
     */
    public void selectEnableRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch(boolean isSwitchOn) {
        if (isSwitchOn == true) {
            getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel().waitForVisible();
            if (!getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch().isSelected()) {
                getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel().waitForEnabled();
                QMetryUtility.click(getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel());
                getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch().waitForSelected();
            }
        } else {
            if (isSwitchOn == false) {
                getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel().waitForVisible();
                if (getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch().isSelected()) {
                    getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel().waitForVisible();
                    getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel().waitForEnabled();
                    QMetryUtility.click(getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitchLabel());
                    getRiskBasedAnalysisInTheProjectForTheBelowEntitiesSwitch().waitForNotSelected();
                }
            }
        }
    }

    /**
     * Method will select show only archived version check box.
     * 
     * @param isSwitchOn
     * @author rahul.patil
     */
    public void enableDefineDependencyBetweenTestcasesSwitch(boolean isSwitchOn) {
        if (isSwitchOn == true) {
            getDefineDependencyBetweenTestcasesOnOffSwitch().waitForVisible();
            if (!getDefineDependencyBetweenTestcasesCheckBox().isSelected()) {
                getDefineDependencyBetweenTestcasesOnOffSwitch().waitForEnabled();
                QMetryUtility.click(getDefineDependencyBetweenTestcasesOnOffSwitch());
                waitForLoader(getProjectDetailViewLoader());
                getDefineDependencyBetweenTestcasesCheckBox().waitForSelected();
            }
        } else {
            if (isSwitchOn == false) {
                getDefineDependencyBetweenTestcasesOnOffSwitch().waitForVisible();
                if (getDefineDependencyBetweenTestcasesCheckBox().isSelected()) {
                    getDefineDependencyBetweenTestcasesOnOffSwitch().waitForVisible();
                    getDefineDependencyBetweenTestcasesOnOffSwitch().waitForEnabled();
                    QMetryUtility.click(getDefineDependencyBetweenTestcasesOnOffSwitch());
                    getAlertDialogMessageTxt().waitForVisible();
                    QMetryUtility.click(getAlertDialogMessageYesBtn());
                    waitForLoader(getProjectDetailViewLoader());
                    getDefineDependencyBetweenTestcasesCheckBox().waitForNotSelected();
                }
            }
        }
    }

    /**
     * Method will select show only archived version check box.
     * 
     * @param isSelect
     * @author rahul.patil
     */
    public void selectAllViewJiraFieldsCheckBox(boolean isSelect) {
        if (isSelect == true) {
            getSelectAllViewJiraFieldsCheckBox().waitForVisible();
            if (!getSelectAllViewJiraFieldsCheckBox().isSelected()) {
                getSelectAllViewJiraFieldsCheckBox().waitForEnabled();
                QMetryUtility.click(getSelectAllViewJiraFieldsCheckBox());
                getSelectAllViewJiraFieldsCheckBox().waitForSelected();
            }
        } else {
            if (isSelect == false) {
                getSelectAllViewJiraFieldsCheckBox().waitForVisible();
                if (getSelectAllViewJiraFieldsCheckBox().isSelected()) {
                    getSelectAllViewJiraFieldsCheckBox().waitForEnabled();
                    QMetryUtility.click(getSelectAllViewJiraFieldsCheckBox());
                    getSelectAllViewJiraFieldsCheckBox().waitForNotSelected();
                }
            }
        }
    }

    /**
     * Method will select show only archived version check box.
     * 
     * @param isSelect
     * @author rahul.patil
     */
    public void selectAllCreateJiraFieldsCheckBox(boolean isSelect) {
        if (isSelect == true) {
            getSelectAllCreateJiraFieldsCheckBox().waitForVisible();
            if (!getSelectAllCreateJiraFieldsCheckBox().isSelected()) {
                getSelectAllCreateJiraFieldsCheckBox().waitForEnabled();
                QMetryUtility.click(getSelectAllCreateJiraFieldsCheckBox());
                getSelectAllCreateJiraFieldsCheckBox().waitForSelected();
            }
        } else {
            if (isSelect == false) {
                getSelectAllCreateJiraFieldsCheckBox().waitForVisible();
                if (getSelectAllCreateJiraFieldsCheckBox().isSelected()) {
                    getSelectAllCreateJiraFieldsCheckBox().waitForEnabled();
                    QMetryUtility.click(getSelectAllCreateJiraFieldsCheckBox());
                    getSelectAllCreateJiraFieldsCheckBox().waitForNotSelected();
                }
            }
        }
    }

    /**
     * Method will select show only archived version check box.
     * 
     * @param isSelect
     * @author rahul.patil
     */
    public void selectAllStoryJiraFieldsCheckBox(boolean isSelect) {
        if (isSelect == true) {
            getSelectAllStoryJiraFieldsCheckBox().waitForVisible();
            if (!getSelectAllStoryJiraFieldsCheckBox().isSelected()) {
                getSelectAllStoryJiraFieldsCheckBox().waitForEnabled();
                QMetryUtility.click(getSelectAllStoryJiraFieldsCheckBox());
                getSelectAllStoryJiraFieldsCheckBox().waitForSelected();
            }
        } else {
            if (isSelect == false) {
                getSelectAllStoryJiraFieldsCheckBox().waitForVisible();
                if (getSelectAllStoryJiraFieldsCheckBox().isSelected()) {
                    getSelectAllStoryJiraFieldsCheckBox().waitForEnabled();
                    QMetryUtility.click(getSelectAllStoryJiraFieldsCheckBox());
                    getSelectAllStoryJiraFieldsCheckBox().waitForNotSelected();
                }
            }
        }
    }

    /**
     * Method will wait for table to load after operation.
     * 
     * @author mdrajib.ali
     */
    public void waitForScheduledTaskPageToLoad() {
        String loaderLoc = "xpath=.//loader/following-sibling::*//div[contains(@class,'page-heading')]";
        do {
        } while (driver.findElement(loaderLoc).getAttribute("class").contains("disabled"));
    }

    /**
     * Method will wait for Project Clone to Complete
     * 
     * @param isSelect
     * @author mdrajib.ali
     */
    public void waitForProjectCloneToComplete() {
        getLocHeaderCmpnnt().getLocIconSchedulerTaskLnk().waitForEnabled();
        QMetryUtility.click(getLocHeaderCmpnnt().getLocIconSchedulerTaskLnk());
        String inProgLoc = "xpath=.//*[text()='Clone']/parent::*/preceding-sibling::*";
        while (driver.findElement(inProgLoc).getAttribute("class").contains("warning")) {
            ProjectPage projectPage=new ProjectPage();
            QMetryUtility.click(projectPage.getRefreshBtn());
            waitForScheduledTaskPageToLoad();
        }
    }
}