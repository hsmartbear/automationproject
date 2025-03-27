package com.qmetry.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import com.qmetry.bean.CommonBean;
import com.qmetry.bean.ManageFieldsBean;
import com.qmetry.bean.ProjectBean;
import com.qmetry.component.DetailViewFilterComponent;
import com.qmetry.component.DetailViewPopUpFilterComponent;
import com.qmetry.component.FilterComponent;
import com.qmetry.component.FolderComponent;
import com.qmetry.component.GridComponent;
import com.qmetry.component.HeaderComponent;
import com.qmetry.component.PaginationComponent;
import com.qmetry.component.SidebarComponent;
import com.qmetry.component.FilterComponent.CheckBoxLabels;
import com.qmetry.component.SidebarComponent.SidebarMenuOptions;
import com.qmetry.constants.CommonConstants;
import com.qmetry.constants.TestDataSetupConstants;
import com.qmetry.locators.CommonPageLocators;
import com.qmetry.page.ManageFieldsPage.udfModuleOptions;
import com.qmetry.page.ManageFieldsPage.udfTypeOptions;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.RandomStringGenerator;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.util.DateUtility;
import com.qmetry.util.QMetryUtility;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;

/**
 * This class defines CommonPage.
 * 
 * @author nidhi.shah
 */
public class CommonPage extends WebDriverBaseTestPage<WebDriverTestPage>
		implements CommonPageLocators, CommonConstants {

	private static String dataProperties = System.getProperty("user.dir").replace("\\", "/")
			+ "/resources/web/data.properties";
	private static String udfDataProperties = System.getProperty("user.dir").replace("\\", "/")
			+ "/resources/web/udfdata.properties";
	private static String testDataProperties = System.getProperty("user.dir").replace("\\", "/")
			+ "/resources/web/testdata.properties";
	private static String commonProperties = System.getProperty("user.dir").replace("\\", "/")
			+ "/resources/web/common.properties";

	/**
	 * A constructor to be used to maximize the browser window
	 * 
	 * @param driver
	 * @return
	 */
	public CommonPage() {
		driver.manage().window().maximize();
	}

	@FindBy(locator = NEW_LOC)
	private QAFWebElement locNewButton;

	@FindBy(locator = HEADER_LOC)
	private HeaderComponent locHeader;

	@FindBy(locator = SIDEBAR_LOC)
	private SidebarComponent locSidebar;

	@FindBy(locator = SIDEBAR_CLOSED_LOC)
	private QAFWebElement locSidebarClosed;

	@FindBy(locator = SIDEBAR_OPENED_LOC)
	private QAFWebElement locSidebarOpened;

	@FindBy(locator = TABLE)
	private GridComponent table;

	@FindBy(locator = FILTER_LOC)
	private FilterComponent locFilter;

	@FindBy(locator = FILTER_BUTTON_LOC)
	private QAFWebElement locFilterButton;

	@FindBy(locator = LINK_TEST_CASE_TABLE)
	private GridComponent linkTestCasetable;

	@FindBy(locator = LINK_PLATFORM_TABLE)
	private GridComponent linkPlatformTable;

	@FindBy(locator = FOLDER_COMPONENT_LOC)
	private FolderComponent locFoldeComponent;

	@FindBy(locator = CREATE_NEW_FOLDER_BUTTON_LOC)
	private QAFWebElement locCreateNewFolderBtn;

	@FindBy(locator = FOLDER_NAME_TXT_BOX_LOC)
	private QAFWebElement locFolderNameTxtBox;

	@FindBy(locator = CREATE_FOLDER_BUTTON_LOC)
	private QAFWebElement locCreateFolderBtn;

	@FindBy(locator = NEXT_BUTTON_LOC)
	private QAFWebElement locNextBtn;

	@FindBy(locator = CLONE_BUTTON_LOC)
	private QAFWebElement locCloneBtn;

	@FindBy(locator = MAIN_OPTION_DROPDOWN_LOC)
	private QAFWebElement locMainOPtionDropDown;

	@FindBy(locator = GO_BACK_BUTTON_LOC)
	private QAFWebElement locGoBackBtn;

	@FindBy(locator = GO_TO_SCHEDULED_TASKS_BUTTON_LOC)
	private QAFWebElement locGoToScheduledTasksBtn;

	@FindBy(locator = BULK_OPERATION_MESSAGE_LOC)
	private QAFWebElement locBulkOperationMessage;

	@FindBy(locator = SCHEDULED_TASK_ACTIVITY_LOC)
	private List<QAFWebElement> locScheduledTaskActivity;

	@FindBy(locator = YES_BUTTON_LOC)
	private QAFWebElement locYesBtn;

	@FindBy(locator = CLOSE_BUTTON_LOC)
	private QAFWebElement locCloseBtn;

	@FindBy(locator = MY_DASHBOARD_TEXT_LOC)
	private QAFWebElement locMyDashboardText;

	@FindBy(locator = FOLDER_BUTTON_LOC)
	private QAFWebElement locFolderButton;

	@FindBy(locator = CLOSE_MESSAGE_BUTTON_LOC)
	private QAFWebElement locCloseMessagebtn;

	@FindBy(locator = REFRESH_BUTTON_LOC)
	private QAFWebElement locRefreshBtn;

	@FindBy(locator = ENTITY_COUNT_TEXT_LOC)
	private QAFWebElement locEntityCountText;

	@FindBy(locator = YES_LOGOUT_BTN_LOC)
	private QAFWebElement locYesLogoutBtn;

	@FindBy(locator = EDIT_FOLDER_BTN_LOC)
	private QAFWebElement locEditFolderBtn;

	@FindBy(locator = ARCHIVE_FOLDER_BTN_LOC)
	private QAFWebElement locArchiveFolderBtn;

	@FindBy(locator = UNARCHIVE_FOLDER_BTN_LOC)
	private QAFWebElement locUnarchiveFolderBtn;

	@FindBy(locator = UPDATE_FOLDER_BTN_LOC)
	private QAFWebElement locUpdateFolderBtn;

	@FindBy(locator = NO_RECORDS_TEXT_LOC)
	private QAFWebElement locNoRecordsTxt;

	@FindBy(locator = TABLE_LOADER_LOC)
	private QAFWebElement locTableLoader;

	@FindBy(locator = NO_DATA_AVAILABLE_TEXT_LOC)
	private QAFWebElement locNoDataAvailableText;

	@FindBy(locator = ADD_COMMENT_BTN_LOC)
	private QAFWebElement locAddCommentBtn;

	@FindBy(locator = COMMENT_TXT_BOX_LOC)
	private QAFWebElement locCommentTxtBox;

	@FindBy(locator = CHECK_COMMENT_BTN_LOC)
	private QAFWebElement locCheckCommnetBtn;

	@FindBy(locator = ADD_ATTACHMENT_BTN_LOC)
	private QAFWebElement locAddAttachmentBtn;

	@FindBy(locator = SELECT_FILE_TXT_BOX_LOC)
	private QAFWebElement locSelectFileTxtBox;

	@FindBy(locator = ADD_FILE_BTN_LOC)
	private QAFWebElement locAddFileBtn;

	@FindBy(locator = ARRANGE_COLUMN_BTN_LOC)
	private QAFWebElement locArrangeColumnBtn;

	@FindBy(locator = SAVE_ARRANGE_COLUMN_BTN_LOC)
	private QAFWebElement locSaveArrangeColumnBtn;

	@FindBy(locator = RESTORE_DEFAULT_COLUMNS_BTN_LOC)
	private QAFWebElement locRestoreDefaultColumnsBtn;

	@FindBy(locator = ARRANGE_COLUMN_CHECK_LOC)
	private QAFWebElement locArrangeColumnCheck;

	@FindBy(locator = EDITABLE_TXT_BOX_LOC)
	private QAFWebElement locEditableTxtBox;

	@FindBy(locator = OPEN_API_KEY_LOC)
	private QAFWebElement locOpenAPIKey;

	@FindBy(locator = DELETE_FOLDER_BTN_LOC)
	private QAFWebElement locDeleteFolderBtn;

	@FindBy(locator = DETAIL_VIEW_LOADER_LOC)
	private QAFWebElement locDetailViewLoader;

	@FindBy(locator = ARCHIVE_SELECTED_VERSION_BTN_LOC)
	private QAFWebElement locArchiveSelectedVersionBtn;

	@FindBy(locator = UNARCHIVE_SELECTED_VERSION_BTN_LOC)
	private QAFWebElement locUnarchiveSelectedVersionBtn;

	@FindBy(locator = SHOW_ONLY_ARCHIVED_VERSION_CHECK_BOX_LOC)
	private QAFWebElement locShowOnlyArchivedVersionCheckBox;

	@FindBy(locator = COMMENT_VALUE_LIST_LOC)
	private List<QAFWebElement> locCommentValueList;

	@FindBy(locator = REVIEW_ENTITY_BTN_LOC)
	private QAFWebElement locReviewEntityBtn;

	@FindBy(locator = REVIEW_ACCEPT_BTN_LOC)
	private QAFWebElement locReviewAcceptBtn;

	@FindBy(locator = APPROVE_ENTITY_BTN_LOC)
	private QAFWebElement locApproveEntityBtn;

	@FindBy(locator = APPROVE_ACCEPT_BTN_LOC)
	private QAFWebElement locApproveAcceptBtn;

	@FindBy(locator = MY_DASHBOARD_TEXT_SPANISH_LOC)
	private QAFWebElement locMyDashboardTextSpanish;

	@FindBy(locator = NEW_SPANISH_LOC)
	private QAFWebElement locNewButtonSpanish;

	@FindBy(locator = LINK_TEST_CASE_TABLE_SPANISH)
	private GridComponent linkTestCasetableSpanish;

	@FindBy(locator = REFRESH_BUTTON_LOC_SPANISH)
	private QAFWebElement locRefreshBtnSpanish;

	@FindBy(locator = DROPDOWN_VALUES_LOC)
	private List<QAFWebElement> locDropdownValues;

	@FindBy(locator = EXECUTION_RUNS_TABLE_LOC)
	private GridComponent locExecutionRunsTable;

	@FindBy(locator = CANCEL_EXECUTION_WINDOW_BTN_LOC)
	private QAFWebElement locCancelExecutionWindowBtn;

	@FindBy(locator = QQBOT_PREDICTION_HEADER_LOC)
	private QAFWebElement locQQBotPredictionHeader;

	@FindBy(locator = CLOSE_QQBOT_PREDICTION_SECTION_BTN_LOC)
	private QAFWebElement locCloseQQBotPredictionSectionBtn;

	@FindBy(locator = DOWNLOAD_EXPORT_FILE_BTN_LOC)
	private QAFWebElement locDownloadExportFileBtn;

	@FindBy(locator = INSERT_IMAGE_BTN_LOC)
	private QAFWebElement locInsertImageBtn;

	@FindBy(locator = UPLOAD_IMAGE_BTN_LOC)
	private QAFWebElement locUploadImageBtn;

	@FindBy(locator = LINK_IMAGE_BTN_LOC)
	private QAFWebElement locLinkImageBtn;

	@FindBy(locator = IMAGE_URL_TEXT_BOX_LOC)
	private QAFWebElement locImageURLTextBox;

	@FindBy(locator = SUBMIT_IMAGE_URL_BTN_LOC)
	private QAFWebElement locSubmitImageURLBtn;

	@FindBy(locator = UPLOADING_IMAGE_TEXT_LOC)
	private QAFWebElement locUploadingImageText;

	@FindBy(locator = CREATE_SHAREABLE_TESTCASE_BTN_LOC)
	private QAFWebElement locCreateShareableTestcaseBtn;

	@FindBy(locator = DOWNLOAD_FILE_BTN_LOC)
	private QAFWebElement locDownloadFileBtn;

	@FindBy(locator = CANCEL_ARRANGE_COLUMN_BTN_LOC)
	private QAFWebElement locCancelArrangeColumnBtn;

	@FindBy(locator = ARRANGE_COLUMN_NAME_TXT_BOX_LOC)
	private QAFWebElement locArrangeColumnNameTxtBox;

	@FindBy(locator = SEARCH_BTN_LOC)
	private QAFWebElement locSearchBtn;

	@FindBy(locator = CLEAR_BTN_LOC)
	private QAFWebElement locClearBtn;

	@FindBy(locator = SELECT_ALL_COLUMNS_BTN_LOC)
	private QAFWebElement locSelectAllColumnsBtn;

	@FindBy(locator = CLEAR_ALL_COLUMNS_BTN_LOC)
	private QAFWebElement locClearAllColumnsBtn;

	@FindBy(locator = ATTACHMENT_URL_TXT_BOX_LOC)
	private QAFWebElement locAttachmentURLTxtBox;

	@FindBy(locator = ATTACHMENT_WINDOW_CLOSE_BTN_LOC)
	private QAFWebElement locAttachmentWindowCloseBtn;

	@FindBy(locator = ENTITY_VERSION_DROPDOWN_BTN_LOC)
	private QAFWebElement locEntityVersionDrpDwnBtn;

	@FindBy(locator = EDIT_BTN_LOC)
	private QAFWebElement locEditBtn;

	@FindBy(locator = LINK_SHAREABLE_TESTCASE_HEADER_LOC)
	private QAFWebElement locLinkShareableTestcase;

	@FindBy(locator = LINK_SHAREABLE_TESTCASE_TABLE_LOC)
	private GridComponent locLinkShareableTestcaseTable;

	@FindBy(locator = LINK_AND_CLOSE_SHAREABLE_TESTCASE_BTN_LOC)
	private GridComponent locLinkAndCloseShareableTestcaseBtn;

	@FindBy(locator = NO_BUTTON_LOC)
	private QAFWebElement locNoBtn;

	@FindBy(locator = CLEAR_SORTING_BTN_LOC)
	private QAFWebElement locClearSortingBtn;

	@FindBy(locator = CANCEL_BUTTON_LOC)
	private QAFWebElement locCancelBtn;

	@FindBy(locator = CLEAR_ENTITY_DETAILS_WINDOW_FILTER_BTN_LOC)
	private QAFWebElement locClearEntityDetailsWindowFilterBtn;

	@FindBy(locator = ENTITY_DETAILS_WINDOW_FILTER_BTN_LOC)
	private QAFWebElement locEntityDetailsWindowFilterBtn;

	@FindBy(locator = ENTITY_DETAILS_WINDOW_SEARCH_FILTER_BTN_LOC)
	private QAFWebElement locEntityDetailsWindowSearchFilterBtn;

	@FindBy(locator = VERSION_COMMENT_TEXT_AREA_LOC)
	private QAFWebElement locVersionCommentTextArea;

	@FindBy(locator = DELETE_SELECTED_VERSION_BTN_LOC)
	private QAFWebElement locDeleteSelectedVersionBtn;

	@FindBy(locator = CLEAR_ALL_VERSION_BTN_LOC)
	private QAFWebElement locClearAllVersionBtn;

	@FindBy(locator = SELECTED_VERSIONS_TEXT_LOC)
	private QAFWebElement locSelectedVersionsText;

	/** adding new code --priyanka.devaliya */

	@FindBy(locator = FILTER_BTN_AT_PAGE_LOC)
	private QAFWebElement locFilterBtnAtPage;

	@FindBy(locator = SELECT_PROJECT_DRP_DWN)
	private QAFWebElement locSelectProjectDrpDwn;

	@FindBy(locator = FILTER_POP_UP_LOC)
	private FilterComponent locFilterPopUp;

	@FindBy(locator = SELECT_BTN)
	private QAFWebElement locBtnSelect;

	@FindBy(locator = PREVIOUS_RECORD_BTN)
	private QAFWebElement locPreviousRecordBtn;

	@FindBy(locator = NEXT_RECORD_BTN)
	private QAFWebElement locNextRecordBtn;

	@FindBy(locator = WATCHERS_TABLE)
	private GridComponent locWatchersTable;

	@FindBy(locator = WATCHERS_LIST_DRP_DWN_TOGGLE_BTN_LOC)
	private QAFWebElement locWatchersListDrpDwnToggleBtn;

	@FindBy(locator = STOP_WATCHING_BTN_LOC)
	private QAFWebElement locStopWatchingBtn;

	@FindBy(locator = START_WATCHING_BTN_LOC)
	private QAFWebElement locStartWatchingBtn;

	@FindBy(locator = EYE_SLASH_POINTER_BTN_LOC)
	private QAFWebElement locEyeSlashPointerBtn;

	@FindBy(locator = EYE_POINTER_BTN_LOC)
	private QAFWebElement locEyePointerBtn;

	@FindBy(locator = MANAGE_WATCHERS_DRP_DWN_BTN_LOC)
	private QAFWebElement locManageWatchersDrpDwnBtn;

	@FindBy(locator = ADD_WATCHERS_BTN_LOC)
	private QAFWebElement locAddWatchersBtn;

	@FindBy(locator = USER_LIST_DRP_DWN_LOC)
	private QAFWebElement locUserListDrpDwn;

	@FindBy(locator = ADD_BTN_LOC)
	private QAFWebElement locAddBtn;

	@FindBy(locator = CLOSE_WATCHERS_LIST_BTN)
	private QAFWebElement locCloseWatchersListBtn;

	@FindBy(locator = WATCHERS_LABEL)
	private QAFWebElement locWatchersLabel;

	@FindBy(locator = REMOVE_SELECTED_BTN)
	private QAFWebElement locRemoveSelectedBtn;

	@FindBy(locator = POPUP_FILTER)
	private QAFWebElement locPopUpFilter;

	@FindBy(locator = POPUP_REFRESH_BTN)
	private QAFWebElement locPopUpRefreshBtn;

	@FindBy(locator = DETAIL_VIEW_CLOSE_BTN)
	private QAFWebElement locDetailViewCloseBtn;

	@FindBy(locator = FILTER_TEXT_BTN)
	private QAFWebElement locFilterTxtBtn;

	@FindBy(locator = OK_BTN)
	private QAFWebElement locOkBtn;

	@FindBy(locator = PAGINATION_ITEM_COUNT_LABEL_LOC)
	private QAFWebElement locPaginationItemCountLabel;

	@FindBy(locator = PAGE_LIMIT_TXT_BOX_LOC)
	private QAFWebElement locPageLimitTxtBox;

	@FindBy(locator = SAVE_BTN_LOC)
	private QAFWebElement locSaveBtn;

	@FindBy(locator = INITIAL_COUNT_LABEL_LOC)
	private QAFWebElement locInitialCountLabel;

	@FindBy(locator = PAGE_LIMIT_COUNT_LABEL_LOC)
	private QAFWebElement locPageLimitCountLabel;

	@FindBy(locator = TOTAL_COUNT_LABEL_LOC)
	private QAFWebElement locTotalCountLabel;

	@FindBy(locator = NEXT_PAGE_BTN_LOC)
	private QAFWebElement locNextPageBtn;

	@FindBy(locator = LAST_PAGE_BTN_LOC)
	private QAFWebElement locLastPageBtn;

	@FindBy(locator = PREVIOUS_PAGE_BTN_LOC)
	private QAFWebElement locPreviousPageBtn;

	@FindBy(locator = FIRST_PAGE_BTN_LOC)
	private QAFWebElement locFirstPageBtn;

	@FindBy(locator = GO_TO_BTN_LOC)
	private QAFWebElement locGoTOBtn;

	@FindBy(locator = PAGING_TXT_BOX)
	private QAFWebElement locPagingTxtBox;

	@FindBy(locator = NO_RESULT_FOUND_TEXT_LOC)
	private QAFWebElement locNoResultFoundText;

	@FindBy(locator = FILTER_USER_TXT_BOX_LOC)
	private QAFWebElement locFilterUserTxtBox;

	@FindBy(locator = SEARCH_USER_TXT_BOX)
	private QAFWebElement locSearchUserTxtBox;

	@FindBy(locator = SEARCH_WATCHER_BTN_LOC)
	private QAFWebElement locSearchWatcherBtn;

	@FindBy(locator = DELETE_ICON_BTN)
	private QAFWebElement locDeleteIconBtn;

	@FindBy(locator = ARCHIVE_ICON_BTN)
	private QAFWebElement locArchiveIconBtn;

	@FindBy(locator = UNARCHIVE_ICON_BTN)
	private QAFWebElement locUnarchiveIconBtn;

	@FindBy(locator = SEARCH_PROJECT_TXT_BOX)
	private QAFWebElement locSearchProjectTxtBox;

	@FindBy(locator = FILTER_SUMMARY_AT_FORM)
	private QAFWebElement locFilterSummaryAtForm;

	@FindBy(locator = FILTER_AT_POP_UP_LOC)
	private FilterComponent locFilterAtPopUp;

	@FindBy(locator = CLEAR_FILTER_AT_FORM_LOC)
	private QAFWebElement locClearFilterAtForm;

	@FindBy(locator = ADD_MORE_FILTER_AT_FORM_LOC)
	private QAFWebElement locAddMoreFilterAtForm;

	@FindBy(locator = SELECT_ATTACHMENT_TXT_BOX_LOC)
	private QAFWebElement locSelectAttachmentTxtBox;

	@FindBy(locator = SUBMIT_BTN)
	private QAFWebElement locSubmitBtn;

	@FindBy(locator = CANCEL_BTN_AT_POP_UP)
	private QAFWebElement locCancelBtnAtPopUp;

	@FindBy(locator = ENTITY_FILTER_BTN_LOC)
	private QAFWebElement locEntityFilterBtn;

	@FindBy(locator = CANCEL_ADD_NEW_FOLDER_FORM_BTN_LOC)
	private QAFWebElement locCancelAddNewFolderFormBtn;

	@FindBy(locator = CANCEL_EDIT_FOLDER_FORM_BTN_LOC)
	private QAFWebElement locCancelEditFolderFormBtn;

	@FindBy(locator = BREADCRUMB_LOC)
	private QAFWebElement locBreadcrumb;

	@FindBy(locator = CLONE_FOLDER_STRUCTURE_SOURCE_MODULE_LOC)
	private QAFWebElement locCloneFolderStructureSourceModule;

	@FindBy(locator = PAGINATION_COMPONENT_LOC)
	private PaginationComponent paginationComponent;

	@FindBy(locator = DETAIL_VIEW_FILTER_BTN_LOC)
	private QAFWebElement locDetailViewFilterBtn;

	@FindBy(locator = DETAIL_VIEW_FILTER_COMPONENT_LOC)
	private DetailViewFilterComponent locDetailViewFilterComponent;

	@FindBy(locator = ENTITY_DETAIL_WINDOW_FILTER_SHOW_ARCHIVED_CHECK_BOX_LOC)
	private QAFWebElement locEntityDetailWindowFilterShowArchivedCheckBox;

	@FindBy(locator = TABLE)
	private QAFWebElement locTable;

	@FindBy(locator = SUBMIT_ATTACHMENTS_BTN_LOC)
	private QAFWebElement locSubmitAtachmentsBtn;

	@FindBy(locator = ATTACHMENTS_DIALOG_BOX_LOADER_LOC)
	private QAFWebElement locAttachmentsDialogBoxLoader;

	@FindBy(locator = CLOSE_ATTACHMENTS_DIALOG_BOX_BTN_LOC)
	private QAFWebElement locCloseAttachmentsDialogBoxBtn;

	@FindBy(locator = ATTACHMENTS_DIALOG_BOX_TABLE_LOC)
	private GridComponent locAttachmentsDialogBoxTable;

	@FindBy(locator = SELECTED_DATE_CALENDER_TEXT_LOC)
	private QAFWebElement locSelectedDateCalenderText;

	@FindBy(locator = CALENDER_MONTH_SELECT_LOC)
	private QAFWebElement locCalenderMonthSelect;

	@FindBy(locator = CALENDER_YEAR_SELECT_LOC)
	private QAFWebElement locCalenderYearSelect;

	@FindBy(locator = REQUEST_CHANGE_BTN_LOC)
	private QAFWebElement locRequestChangeBtn;

	@FindBy(locator = REQUEST_CHANGE_BTN_AT_BULK_OPERATION_LOC)
	private QAFWebElement locRequestChangeAtBulkOperationBtn;

	@FindBy(locator = REQUEST_CHANGE_HEADER_LOC)
	private QAFWebElement locRequestChangeHeader;

	@FindBy(locator = REQUEST_CHANGE_ADDITIONAL_REMARK_TEXTAREA_LOC)
	private QAFWebElement locRequestChangeAdditionalRemarkTxtArea;

	@FindBy(locator = REQUEST_CHANGE_ACCEPT_BTN_LOC)
	private QAFWebElement locRequestChangeAcceptBtn;

	@FindBy(locator = SHOW_ARCHIVED_RECORDS_CHECK_BOX_LOC_LOC)
	private QAFWebElement locShowArchivedRecordsCheckBox;

	@FindBy(locator = DATA_TABLE)
	private GridComponent dataTable;

	@FindBy(locator = CLEAR_ALL_BUTTON_LOC)
	private QAFWebElement locClearAllBtn;

	@FindBy(locator = SELECT_ALL_BUTTON_LOC)
	private QAFWebElement locSelectAllBtn;

	@FindBy(locator = PAGINATION_ITEM_COUNT_LABEL_AT_DETAIL_VIEW_LOC)
	private QAFWebElement locPaginationItemCountLabelATDetailView;

	@FindBy(locator = INITIAL_COUNT_LABEL_AT_DETAIL_VIEW_LOC)
	private QAFWebElement locInitialCountLabelATDetailView;

	@FindBy(locator = PAGE_LIMIT_COUNT_LABEL_AT_DETAIL_VIEW_LOC)
	private QAFWebElement locPageLimitCountLabelATDetailView;

	@FindBy(locator = TOTAL_COUNT_LABEL_AT_DETAIL_VIEW_LOC)
	private QAFWebElement locTotalCountLabelATDetailView;

	@FindBy(locator = SAVE_ARRANGE_STEP_COLUMN_BTN_LOC)
	private QAFWebElement locSaveArrangeStepColumnBtn;

	@FindBy(locator = RESTORE_DEFAULT_STEP_COLUMNS_BTN_LOC)
	private QAFWebElement locRestoreDefaultStepColumnsBtn;

	@FindBy(locator = FINISH_BUTTON_LOC)
	private QAFWebElement locFinishBtn;

	@FindBy(locator = MENU_SIDE_BAR_LOC)
	private QAFWebElement locMenuSideBar;

	@FindBy(locator = COLLAPSE_MENU_ICON)
	private QAFWebElement locCollpaseMenuIcon;

	@FindBy(locator = EXPAND_MENU_ICON)
	private QAFWebElement locExpandMenuIcon;

	@FindBy(locator = PREVIEW_ATTACHMENT)
	private QAFWebElement locPreviewAttachment;

	@FindBy(locator = DOWNLOAD_ATTACHMENT_BTN)
	private QAFWebElement locDownloadAttachment;

	@FindBy(locator = DELETE_ATTACHMENT_BTN)
	private QAFWebElement locDeleteAttachment;

	@FindBy(locator = CLOSE_PREVIEW_ATTACHMENT_BTN)
	private QAFWebElement locClosePreviewAttachmentBtn;

	@FindBy(locator = NEXT_ATTACHMENT_PAGE)
	private QAFWebElement locNextAttachmentPage;

	@FindBy(locator = QQBOT_PREDICTION_AUTO_DISPLAY_SWITCH)
	private QAFWebElement locQQbotPredicationAutoDisplaySwitch;

	@FindBy(locator = INPUT_QQBOT_PREDICTION_AUTO_DISPLAY)
	private QAFWebElement locInputQQbotPredicationAutoDisplay;

	@FindBy(locator = MATCHING_PERCENT_TXT_LOC)
	private QAFWebElement locMatchingPercentTxt;

	@FindBy(locator = QQBOT_LOC)
	private QAFWebElement locQQBot;

	@FindBy(locator = CLEAR_TABLE_SORTING_BTN_LOC)
	private QAFWebElement locClearTableSortingBtn;

	@FindBy(locator = CLEAR_TABLE_FILTER_BTN_LOC)
	private QAFWebElement locClearTableFilterBtn;

	@FindBy(locator = MOVE_FOLDER_BTN_LOC)
	private QAFWebElement locMoveFolderBtn;

	@FindBy(locator = COPY_FOLDER_BTN_LOC)
	private QAFWebElement locCopyFolderBtn;

	@FindBy(locator = CLOSE_ACCEPT_BTN_LOC)
	private QAFWebElement locCloseAcceptBtn;

	@FindBy(locator = DETAIL_VIEW_TAB_FILTER_COMPONENT_LOC)
	private GridComponent locDetailViewTabFilterComponent;

	@FindBy(locator = LINK_BY_ENTITY_KEY_BTN_LOC)
	private QAFWebElement locLinkByEntityKeyBtn;

	@FindBy(locator = EDIT_SOURCE_COMMENT_BTN_LOC)
	private QAFWebElement locEditSourceBtn;

	@FindBy(locator = SELECT_FILTER_FOLDER_BTN_LOC)
	private QAFWebElement locSelectFilterFolderBtn;

	@FindBy(locator = RICH_TEXT_EDITOR_TEXTAREA_LOC)
	private QAFWebElement locRichTextEditorTextarea;

	@FindBy(locator = MENTIONED_USER_LIST_LOC)
	private List<QAFWebElement> locMentionedUserList;

	@FindBy(locator = CHECK_COMMENT_RICH_TEXT_EDITOR_BUTTON_LOC)
	private QAFWebElement locCheckCommentRichTxtEditorBtn;

	@FindBy(locator = SHARE_ENTITY_HEADER_LOC)
	private QAFWebElement locShareEntityHeader;

	@FindBy(locator = SHARE_ENTITY_EMAIL_TEXT_BOX_LOC)
	private QAFWebElement locShareEntityEmailTxtBox;

	@FindBy(locator = SHARE_ENTITY_COMMENT_TXT_AREA_LOC)
	private QAFWebElement locShareEntityCommentTxtArea;

	@FindBy(locator = SHARE_ENTITY_COPY_LINK_BTN_LOC)
	private QAFWebElement locShareEntityCopyLinkBtn;

	@FindBy(locator = SHARE_ENTITY_BTN_LOC)
	private QAFWebElement locShareEntityBtn;

	@FindBy(locator = SHARE_ENTITY_EMAIL_LABEL_LOC)
	private QAFWebElement locShareEntityEmailLabel;

	@FindBy(locator = DATA_TABLE_AT_CUSTOM_DASHBOARD)
	private GridComponent locDataTableAtCustomDashboard;

	@FindBy(locator = APPROVE_BTN_AT_POP_UP)
	private QAFWebElement locApproveBtnAtPopUP;

	@FindBy(locator = TABLE_MODULE_AT_UDF)
	private GridComponent locTableModuleAtUDF;

	@FindBy(locator = LINK_TABLE_AT_POP_UP)
	private DetailViewPopUpFilterComponent locLinkTableAtPopUp;

	@FindBy(locator = YES_BTN_WITH_TEXT)
	private QAFWebElement locYesBtnWithText;

	@FindBy(locator = LINK_BY_ENTITY_KEYS_TEXT_AREA_LOC)
	private QAFWebElement locLinkByEntityKeysTextArea;

	@FindBy(locator = LINK_ENTITY_KEY_BTN_AT_POPUP)
	private QAFWebElement locLinkEntityKeyBtnAtPopUp;

	@FindBy(locator = RESET_BTN_ATTACHMENT)
	private QAFWebElement locResetAttachmentBtn;

	@FindBy(locator = TESTCASE_TAB_AT_SEARCH)
	private QAFWebElement locTestcaseTabAtSearch;

	@FindBy(locator = DOWNLOAD_ALL_BTN)
	private QAFWebElement locDownloadAllBtn;

	@FindBy(locator = INSERT_LINK_BTN)
	private QAFWebElement locInsertLinkBtn;

	@FindBy(locator = URL_LINK_TXT_BOX)
	private QAFWebElement locUrlLinkTxtBox;

	@FindBy(locator = OPEN_IN_NEW_TAB_CHECK_BOX)
	private QAFWebElement locOpenInNewTabCheckBox;

	@FindBy(locator = SKIP_DUPLICATE_LINKAGE_CHECK_BOX_LOC)
	private QAFWebElement locSkipDuplicateLinkageCheckBox;

	@FindBy(locator = URL_TEXT_TXT_BOX)
	private QAFWebElement locUrlTextTxtBox;

	@FindBy(locator = LINK_BTN)
	private QAFWebElement locLinkBtn;

	@FindBy(locator = FILTER_BTN_AT_DETAILS)
	private QAFWebElement locFilterBtnAtDetails;

	@FindBy(locator = LINK_TESTCASE_MODEL_ARRANGE_COLUMN_BTN)
	private QAFWebElement locLinkTestcaseModelArrangeColumnBtn;

	@FindBy(locator = LINK_ISSUES_MODEL_ARRANGE_COLUMN_BTN)
	private QAFWebElement locLinkIssuesModelArrangeColumnBtn;

	@FindBy(locator = LINK_ISSUES_WINDOW_CLOSE_BTN)
	private QAFWebElement locLinkIssuesWindowCloseBtn;

	@FindBy(locator = ASSIGN_ISSUES_MODEL_ARRANGE_COLUMN_BTN)
	private QAFWebElement locAssignIssuesModelArrangeColumnBtn;

	@FindBy(locator = LINK_TESTSUITE_MODEL_ARRANGE_COLUMN_BTN)
	private QAFWebElement locLinkTestsuiteModelArrangeColumnBtn;

	@FindBy(locator = LINK_TESTSUITES_WINDOW_CLOSE_BTN)
	private QAFWebElement locLinkTestsuitesWindowCloseBtn;

	@FindBy(locator = LINK_TESTCASES_WINDOW_CLOSE_BTN)
	private QAFWebElement locLinkTestcasesWindowCloseBtn;

	@FindBy(locator = LINK_ISSUES_MODEL_CLEAR_SORTING_BTN)
	private QAFWebElement locLinkIssuesModelClearSortingBtn;

	@FindBy(locator = LINK_ASSIGN_ISSUES_TO_TESTRUN_MODEL_CLEAR_SORTING_BTN)
	private QAFWebElement locAssignIssuesToTestrunModelClearSortingBtn;

	@FindBy(locator = CLOSE_EXECUTION_WINDOW_BTN_LOC)
	private QAFWebElement locCloseExecutionWindowBtn;

	@FindBy(locator = LINK_REQUIREMENTS_MODEL_ARRANGE_COLUMN_BTN)
	private QAFWebElement locLinkRequirementsModelArrangeColumnBtn;

	@FindBy(locator = LINK_REQUIREMENTS_WINDOW_CLOSE_BTN)
	private QAFWebElement locLinkRequirementsWindowCloseBtn;

	@FindBy(locator = ARRANGE_COLUMN_FIELD_TXT_BOX_LOC)
	private QAFWebElement locArrangeColumnFieldTxtBox;

	@FindBy(locator = SELECT_REQUIREMENTS_HEADER_LOC)
	private QAFWebElement locSelectRequirementsHeader;

	@FindBy(locator = SELECT_TESTCASES_HEADER_LOC)
	private QAFWebElement locSelectTestcasesHeader;

	@FindBy(locator = SELECT_APPLY_BTN_LOC)
	private QAFWebElement locSelectApplyBtn;

	@FindBy(locator = HELP_LIST_INFO_LOC)
	private QAFWebElement locHelpListInfo;

	@FindBy(locator = INFO_ICON_CIRCLE)
	private QAFWebElement locInfoIconCircle;

	@FindBy(locator = POPOVER_CONTENT)
	private QAFWebElement locPopOverContent;

	@FindBy(locator = FLAKY_SCORE_TEST_EXECUTIONS_AND_ISSUES)
	private QAFWebElement locFlakyScoreTestExecutionsAndIssuesHeader;

	@FindBy(locator = FLAKY_SCORE_TEST_EXECUTIONS_AND_ISSUES_WINDOW_CLOSE_BTN)
	private QAFWebElement locFlakyScoreTestExecutionsAndIssuesWindowCloseBtn;

	@FindBy(locator = LINK_TESTCASE_MODEL_REFRESH_BTN)
	private QAFWebElement locLinkTestcaseModelRefreshBtn;

	@FindBy(locator = TESTCASE_DETAIL_VIEW_FLAKY_SCORE_APP)
	private QAFWebElement locTestCaseDetailViewFlakyScoreApp;

	@FindBy(locator = TESTCASE_DETAIL_VIEW_SUCCESS_RATE_APP)
	private QAFWebElement locTestCaseDetailViewSuccessRateApp;

	@FindBy(locator = PERMISSION_TO_ACCESS_THIS_MODULE_TEXT)
	private QAFWebElement locPermissionToAccessModuleText;

	@FindBy(locator = ALERT_DIALOG_MESSAGE_TEXT)
	private QAFWebElement locAlertDialogMessageTxt;

	@FindBy(locator = ALERT_DIALOG_MESSAGE_NO_BTN)
	private QAFWebElement locAlertDialogMessageNoBtn;

	@FindBy(locator = ALERT_DIALOG_MESSAGE_YES_BTN)
	private QAFWebElement locAlertDialogMessageYesBtn;

	@FindBy(locator = UNLINK_SELECTED_BTN_LOC)
	private QAFWebElement locUnlinkSelectedBtn;

	@FindBy(locator = LINK_TESTCASE_WINDOW_PROJECTS_DRP_DWN_LOC)
	private QAFWebElement locLinkTestcaseWindowProjectsDrpDwn;

	@FindBy(locator = LINK_TESTCASE_WINDOW_PROJECT_TXT_BOX_LOC)
	private QAFWebElement locLinkTestcaseWindowProjectTxtBox;

	@FindBy(locator = BTN_YES_CONTINUE)
	private QAFWebElement locBtnYesContinue;

	@FindBy(locator = Btn_CLOSE_ANNOUNENCEMENT_MSG_BTN)
	private QAFWebElement locCloseAnnounencementMSgBtn;

	@FindBy(locator = DESCRIPTION_TXT_BOX)
	private QAFWebElement locDescriptionTxtBox;

	@FindBy(locator = SELECT_TESTSUITES_HEADER_LOC)
	private QAFWebElement locSelectTestsuitesHeader;

	@FindBy(locator = CREATE_FORM_LABEL_LIST_LOC)
	private List<QAFWebElement> locCreateFormLabelList;

	@FindBy(locator = DETAIL_TAB_FIELD_LABEL_LIST_LOC)
	private List<QAFWebElement> locDetailTabFieldLabelList;

	@FindBy(locator = GENERATE_TESTCASE_BTN_LOC)
	private QAFWebElement locGenerateTestcaseBtn;

	@FindBy(locator = GENERATE_DETAILS_AND_STEPS_BTN_LOC)
	private QAFWebElement locGenerateDetailsAndStepsBtn;

	@FindBy(locator = SYSTEM_FIELD_SECTION_DETAILS_TAB)
	private QAFWebElement locSystemFieldSectionDetailsTab;

	@FindBy(locator = TESTCASE_EXPAND_TABLE_LOC)
	private GridComponent locTestcaseExpandTable;

	@FindBy(locator = CHANGE_LOG_TABLE_LOADER)
	private QAFWebElement locChangeLogTableLoader;

	@FindBy(locator = WATCHER_USER_LIST_DRP_DWN_BTN)
	private QAFWebElement locWatcherUserListDrpDwnBtn;

	@FindBy(locator = WATCHER_TABLE)
	private GridComponent watcherTable;

	@FindBy(locator = DETAIL_WINDOW_CREATED_ON_DATE_TXT)
	private QAFWebElement locdetailWindowCreatedOnDatetxt;

	@FindBy(locator = DETAIL_WINDOW_UPDATED_ON_DATE_TXT)
	private QAFWebElement locdetailWindowUpdatedOnDatetxt;

	@FindBy(locator = SELECT_FOLDER_HEADER_LOC)
	private QAFWebElement locSelectFolderHeader;

	@FindBy(locator = DETAIL_WINDOW_CREATED_ON_USER_TXT)
	private QAFWebElement locdetailWindowCreatedOnUserTxt;

	@FindBy(locator = DETAIL_WINDOW_UPDATED_ON_USER_TXT)
	private QAFWebElement locdetailWindowUpdatedOnUserTxt;

	@FindBy(locator = DETAIL_WINDOW_CREATED_ON_COMPLETE_TXT)
	private QAFWebElement locdetailWindowCreatedOnCompleteTxt;

	@FindBy(locator = DETAIL_WINDOW_UPDATED_ON_COMPLETE_TXT)
	private QAFWebElement locdetailWindowUpdatedOnCompleteTxt;

	@FindBy(locator = ADD_ATTACHMENT_TIP_MESSAGE_TEXT)
	private QAFWebElement locAddAttachmentTipMessageTxt;

	@FindBy(locator = ADD_ATTACHMENT_DISPLAY_MESSAGE_TEXT)
	private QAFWebElement locAddAttachmentDisplayMessageTxt;

	@FindBy(locator = MAIL_ZIP_ATTACHMENT)
	private QAFWebElement locMailZipAttachment;

	@FindBy(locator = EXPORT_WITH_COMMENTS_CHECK_BOX)
	private QAFWebElement locExportWithCommentsCheckBox;

	/*
	 * @FindBy(locator = EDIT_SOURCE_COMMENT_BTN_LOC) private QAFWebElement
	 * locEditSourceBtn;
	 * 
	 * @FindBy(locator = EDIT_SOURCE_COMMENT_BTN_LOC) private QAFWebElement
	 * locEditSourceBtn;
	 * 
	 * @FindBy(locator = EDIT_SOURCE_COMMENT_BTN_LOC) private QAFWebElement
	 * locEditSourceBtn;
	 */

	public QAFWebElement getLocNewBtn() {
		return locNewButton;
	}

	public HeaderComponent getLocHeaderCmpnnt() {
		return locHeader;
	}

	public SidebarComponent getLocSidebarCmpnnt() {
		return locSidebar;
	}

	public QAFWebElement getLocSidebarClosedDrpdwn() {
		return locSidebarClosed;
	}

	public QAFWebElement getLocSidebarOpenedDrpdwn() {
		return locSidebarOpened;
	}

	public GridComponent getTable() {
		return table;
	}

	public QAFWebElement getLocTable() {
		return locTable;
	}

	public FilterComponent getLocFilter() {
		return locFilter;
	}

	public QAFWebElement getLocFilterButton() {
		return locFilterButton;
	}

	public GridComponent getLinkTestCaseTable() {
		return linkTestCasetable;
	}

	public GridComponent getLinkPlatformTable() {
		return linkPlatformTable;
	}

	public FolderComponent getFolderComponent() {
		return locFoldeComponent;
	}

	public QAFWebElement getCreateNewFolderBtn() {
		return locCreateNewFolderBtn;
	}

	public QAFWebElement getFolderNameTxtBox() {
		return locFolderNameTxtBox;
	}

	public QAFWebElement getCreateFolderBtn() {
		return locCreateFolderBtn;
	}

	public QAFWebElement getNextBtn() {
		return locNextBtn;
	}

	public QAFWebElement getCloneBtn() {
		return locCloneBtn;
	}

	public QAFWebElement getMainOPtionDropDown() {
		return locMainOPtionDropDown;
	}

	public QAFWebElement getGoBackBtn() {
		return locGoBackBtn;
	}

	public QAFWebElement getGoToScheduledTasksBtn() {
		return locGoToScheduledTasksBtn;
	}

	public QAFWebElement getBulkOperationMessage() {
		return locBulkOperationMessage;
	}

	public List<QAFWebElement> getScheduledTaskActivity() {
		return locScheduledTaskActivity;
	}

	public QAFWebElement getYesBtn() {
		return locYesBtn;
	}

	public QAFWebElement getCloseBtn() {
		return locCloseBtn;
	}

	public QAFWebElement getMyDashboardText() {
		return locMyDashboardText;
	}

	public QAFWebElement getLocFolderBtn() {
		return locFolderButton;
	}

	public QAFWebElement getCloseMessageBtn() {
		return locCloseMessagebtn;
	}

	public QAFWebElement getRefreshBtn() {
		return locRefreshBtn;
	}

	public QAFWebElement getEntityCountText() {
		return locEntityCountText;
	}

	public QAFWebElement getYesLogoutBtn() {
		return locYesLogoutBtn;
	}

	public QAFWebElement getEditFolderBtn() {
		return locEditFolderBtn;
	}

	public QAFWebElement getArchiveFolderBtn() {
		return locArchiveFolderBtn;
	}

	public QAFWebElement getUnarchiveFolderBtn() {
		return locUnarchiveFolderBtn;
	}

	public QAFWebElement getUpdateFolderBtn() {
		return locUpdateFolderBtn;
	}

	public QAFWebElement getNoRecordsTxt() {
		return locNoRecordsTxt;
	}

	public QAFWebElement getTableLoader() {
		return locTableLoader;
	}

	public QAFWebElement getNoDataAvailableText() {
		return locNoDataAvailableText;
	}

	public QAFWebElement getAddCommentBtn() {
		return locAddCommentBtn;
	}

	public QAFWebElement getCommentTxtBox() {
		return locCommentTxtBox;
	}

	public QAFWebElement getCheckCommnetBtn() {
		return locCheckCommnetBtn;
	}

	public QAFWebElement getAddAttachmentBtn() {
		return locAddAttachmentBtn;
	}

	public QAFWebElement getSelectFileTxtBox() {
		return locSelectFileTxtBox;
	}

	public QAFWebElement getAddFileBtn() {
		return locAddFileBtn;
	}

	public QAFWebElement getArrangeColumnBtn() {
		return locArrangeColumnBtn;
	}

	public QAFWebElement getSaveArrangeColumnBtn() {
		return locSaveArrangeColumnBtn;
	}

	public QAFWebElement getRestoreDefaultColumnsBtn() {
		return locRestoreDefaultColumnsBtn;
	}

	public QAFWebElement getArrangeColumnCheck() {
		return locArrangeColumnCheck;
	}

	public QAFWebElement getEditableTxtBox() {
		return locEditableTxtBox;
	}

	public QAFWebElement getOpenAPIKeySpn() {
		return locOpenAPIKey;
	}

	public QAFWebElement getDeleteFolderBtn() {
		return locDeleteFolderBtn;
	}

	public QAFWebElement getDetailViewLoader() {
		return locDetailViewLoader;
	}

	public QAFWebElement getArchiveSelectedVersionBtn() {
		return locArchiveSelectedVersionBtn;
	}

	public QAFWebElement getUnarchiveSelectedVersionBtn() {
		return locUnarchiveSelectedVersionBtn;
	}

	public QAFWebElement getShowOnlyArchivedVersionCheckBox() {
		return locShowOnlyArchivedVersionCheckBox;
	}

	public List<QAFWebElement> getCommentValueList() {
		return locCommentValueList;
	}

	public QAFWebElement getReviewEntityBtn() {
		return locReviewEntityBtn;
	}

	public QAFWebElement getReviewAcceptBtn() {
		return locReviewAcceptBtn;
	}

	public QAFWebElement getApproveEntityBtn() {
		return locApproveEntityBtn;
	}

	public QAFWebElement getApproveAcceptBtn() {
		return locApproveAcceptBtn;
	}

	public QAFWebElement getMyDashboardTextSpanish() {
		return locMyDashboardTextSpanish;
	}

	public QAFWebElement getLocNewBtnSpanish() {
		return locNewButtonSpanish;
	}

	public GridComponent getLinkTestCaseTableSpanish() {
		return linkTestCasetableSpanish;
	}

	public QAFWebElement getRefreshBtnSpanish() {
		return locRefreshBtnSpanish;
	}

	public List<QAFWebElement> getDrpDwnValues() {
		return locDropdownValues;
	}

	public GridComponent getExecutionRunsTable() {
		return locExecutionRunsTable;
	}

	public QAFWebElement getCancelExecutionWindowBtn() {
		return locCancelExecutionWindowBtn;
	}

	public QAFWebElement getQQBotPredictionHeader() {
		return locQQBotPredictionHeader;
	}

	public QAFWebElement getCloseQQBotPredictionSectionBtn() {
		return locCloseQQBotPredictionSectionBtn;
	}

	public QAFWebElement getDownloadExportFileBtn() {
		return locDownloadExportFileBtn;
	}

	public QAFWebElement getInsertImageBtn() {
		return locInsertImageBtn;
	}

	public QAFWebElement getUploadImageBtn() {
		return locUploadImageBtn;
	}

	public QAFWebElement getLinkImageBtn() {
		return locLinkImageBtn;
	}

	public QAFWebElement getImageURLTextBox() {
		return locImageURLTextBox;
	}

	public QAFWebElement getSubmitImageURLBtn() {
		return locSubmitImageURLBtn;
	}

	public QAFWebElement getUploadingImageText() {
		return locUploadingImageText;
	}

	public QAFWebElement getCreateShareableTestcaseBtn() {
		return locCreateShareableTestcaseBtn;
	}

	public QAFWebElement getDownloadFileBtn() {
		return locDownloadFileBtn;
	}

	public QAFWebElement getCancelArrangeColumnBtn() {
		return locCancelArrangeColumnBtn;
	}

	public QAFWebElement getArrangeColumnNameTxtBox() {
		return locArrangeColumnNameTxtBox;
	}

	public QAFWebElement getSearchBtn() {
		return locSearchBtn;
	}

	public QAFWebElement getClearBtn() {
		return locClearBtn;
	}

	public QAFWebElement getSelectAllColumnsBtn() {
		return locSelectAllColumnsBtn;
	}

	public QAFWebElement getClearAllColumnsBtn() {
		return locClearAllColumnsBtn;
	}

	public QAFWebElement getAttachmentURLTxtBox() {
		return locAttachmentURLTxtBox;
	}

	public QAFWebElement getAttachmentWindowCloseBtn() {
		return locAttachmentWindowCloseBtn;
	}

	public QAFWebElement getEntityVersionDrpDwnBtn() {
		return locEntityVersionDrpDwnBtn;
	}

	public QAFWebElement getEditBtn() {
		return locEditBtn;
	}

	public QAFWebElement getLinkShareableTestcaseHeader() {
		return locLinkShareableTestcase;
	}

	public GridComponent getLinkShareableTestcaseTable() {
		return locLinkShareableTestcaseTable;
	}

	public GridComponent getLinkAndCloseShareableTestcaseBtn() {
		return locLinkAndCloseShareableTestcaseBtn;
	}

	public QAFWebElement getNoBtn() {
		return locNoBtn;
	}

	public QAFWebElement getClearSortingBtn() {
		return locClearSortingBtn;
	}

	public QAFWebElement getCancelBtn() {
		return locCancelBtn;
	}

	public QAFWebElement getClearEntityDetailsWindowFilterBtn() {
		return locClearEntityDetailsWindowFilterBtn;
	}

	public QAFWebElement getEntityDetailsWindowFilterBtn() {
		return locEntityDetailsWindowFilterBtn;
	}

	public QAFWebElement getEntityDetailsWindowSearchFilterBtn() {
		return locEntityDetailsWindowSearchFilterBtn;
	}

	public QAFWebElement getVersionCommentTextArea() {
		return locVersionCommentTextArea;
	}

	public QAFWebElement getDeleteSelectedVersionBtn() {
		return locDeleteSelectedVersionBtn;
	}

	public QAFWebElement getClearAllVersionBtn() {
		return locClearAllVersionBtn;
	}

	public QAFWebElement getSelectedVersionsText() {
		return locSelectedVersionsText;
	}

	public QAFWebElement getFilterBtnAtPage() {
		return locFilterBtnAtPage;
	}

	public QAFWebElement getSelectProjectDrpDwn() {
		return locSelectProjectDrpDwn;
	}

	public FilterComponent getFilterPopUp() {
		return locFilterPopUp;
	}

	public QAFWebElement getSelectBtn() {
		return locBtnSelect;
	}

	public QAFWebElement getPreviousRecordBtn() {
		return locPreviousRecordBtn;
	}

	public QAFWebElement getNextRecordBtn() {
		return locNextRecordBtn;
	}

	public GridComponent getWatchersTable() {
		return locWatchersTable;
	}

	public QAFWebElement getWatchersListDrpDwnToggleBtn() {
		return locWatchersListDrpDwnToggleBtn;
	}

	public QAFWebElement getStopWatchingBtn() {
		return locStopWatchingBtn;
	}

	public QAFWebElement getStartWatchingBtn() {
		return locStartWatchingBtn;
	}

	public QAFWebElement getEyeSlashPointerBtn() {
		return locEyeSlashPointerBtn;
	}

	public QAFWebElement getEyePointerBtn() {
		return locEyePointerBtn;
	}

	public QAFWebElement getManageWatchersDrpDwnBtn() {
		return locManageWatchersDrpDwnBtn;
	}

	public QAFWebElement getAddWatchersBtn() {
		return locAddWatchersBtn;
	}

	public QAFWebElement getUserListDrpDwn() {
		return locUserListDrpDwn;
	}

	public QAFWebElement getAddBtn() {
		return locAddBtn;
	}

	public QAFWebElement getCloseWatchersListBtn() {
		return locCloseWatchersListBtn;
	}

	public QAFWebElement getWatchersLabel() {
		return locWatchersLabel;
	}

	public QAFWebElement getRemoveSelectedBtn() {
		return locRemoveSelectedBtn;
	}

	public QAFWebElement getPopUpFilter() {
		return locPopUpFilter;
	}

	public QAFWebElement getPopUpRefreshBtn() {
		return locPopUpRefreshBtn;
	}

	public QAFWebElement getDetailViewCloseBtn() {
		return locDetailViewCloseBtn;
	}

	public QAFWebElement getFilterTxtBtn() {
		return locFilterTxtBtn;
	}

	public QAFWebElement getOkBtn() {
		return locOkBtn;
	}

	public QAFWebElement getPaginationItemCountLabel() {
		return locPaginationItemCountLabel;
	}

	public QAFWebElement getPageLimitTxtBox() {
		return locPageLimitTxtBox;
	}

	public QAFWebElement getSaveBtn() {
		return locSaveBtn;
	}

	public QAFWebElement getInitialCountLabel() {
		return locInitialCountLabel;
	}

	public QAFWebElement getPageLimitCountLabel() {
		return locPageLimitCountLabel;
	}

	public QAFWebElement getTotalCountLabel() {
		return locTotalCountLabel;
	}

	public QAFWebElement getNextPageBtn() {
		return locNextPageBtn;
	}

	public QAFWebElement getLastPageBtn() {
		return locLastPageBtn;
	}

	public QAFWebElement getPreviousPageBtn() {
		return locPreviousPageBtn;
	}

	public QAFWebElement getFirstPageBtn() {
		return locFirstPageBtn;
	}

	public QAFWebElement getGoToBtn() {
		return locGoTOBtn;
	}

	public QAFWebElement getPagingTxtBox() {
		return locPagingTxtBox;
	}

	public QAFWebElement getNoResultFoundText() {
		return locNoResultFoundText;
	}

	public QAFWebElement getFilterUserTxtBox() {
		return locFilterUserTxtBox;
	}

	public QAFWebElement getSearchUserTxtBox() {
		return locSearchUserTxtBox;
	}

	public QAFWebElement getSearchWatcherBtn() {
		return locSearchWatcherBtn;
	}

	public QAFWebElement getclearSortingBtn() {
		return locClearSortingBtn;
	}

	public QAFWebElement getDeleteIconBtn() {
		return locDeleteIconBtn;
	}

	public QAFWebElement getArchiveIconBtn() {
		return locArchiveIconBtn;
	}

	public QAFWebElement getUnarchiveIconBtn() {
		return locUnarchiveIconBtn;
	}

	public QAFWebElement getSearchProjectTxtBox() {
		return locSearchProjectTxtBox;
	}

	public QAFWebElement getFilterSummaryAtForm() {
		return locFilterSummaryAtForm;
	}

	public FilterComponent getFilterAtPopUp() {
		return locFilterAtPopUp;
	}

	public QAFWebElement getclearFilterBtnAtForm() {
		return locClearFilterAtForm;
	}

	public QAFWebElement getAddMoreFilterAtForm() {
		return locAddMoreFilterAtForm;
	}

	public QAFWebElement getSelectAttachmentTxtBox() {
		return locSelectAttachmentTxtBox;
	}

	public QAFWebElement getSubmitBtn() {
		return locSubmitBtn;
	}

	public QAFWebElement getCancelBtnAtPopUp() {
		return locCancelBtnAtPopUp;
	}

	public QAFWebElement getEntityFilterBtn() {
		return locEntityFilterBtn;
	}

	public QAFWebElement getCancelAddNewFolderFormBtn() {
		return locCancelAddNewFolderFormBtn;
	}

	public QAFWebElement getCancelEditFolderFormBtn() {
		return locCancelEditFolderFormBtn;
	}

	public QAFWebElement getLocBreadcrumb() {
		return locBreadcrumb;
	}

	public QAFWebElement getCloneFolderStructureSourceModule() {
		return locCloneFolderStructureSourceModule;
	}

	public PaginationComponent getPaginationComponent() {
		return paginationComponent;
	}

	public QAFWebElement getDetailViewFilterBtn() {
		return locDetailViewFilterBtn;
	}

	public DetailViewFilterComponent getDetailViewFilterComponent() {
		return locDetailViewFilterComponent;
	}

	public QAFWebElement getEntityDetailWindowFilterShowArchivedCheckBox() {
		return locEntityDetailWindowFilterShowArchivedCheckBox;
	}

	public QAFWebElement getSubmitAtachmentsBtn() {
		return locSubmitAtachmentsBtn;
	}

	public QAFWebElement getAttachmentsDialogBoxLoader() {
		return locAttachmentsDialogBoxLoader;
	}

	public QAFWebElement getCloseAttachmentsDialogBoxBtn() {
		return locCloseAttachmentsDialogBoxBtn;
	}

	public GridComponent getAttachmentsDialogBoxTable() {
		return locAttachmentsDialogBoxTable;
	}

	public QAFWebElement getSelectedDateCalenderText() {
		return locSelectedDateCalenderText;
	}

	public QAFWebElement getCalenderMonthSelect() {
		return locCalenderMonthSelect;
	}

	public QAFWebElement getCalenderYearSelect() {
		return locCalenderYearSelect;
	}

	public QAFWebElement getRequestChangeBtn() {
		return locRequestChangeBtn;
	}

	public QAFWebElement getRequestChangeAtBulkOperationBtn() {
		return locRequestChangeAtBulkOperationBtn;
	}

	public QAFWebElement getRequestChangeHeader() {
		return locRequestChangeHeader;
	}

	public QAFWebElement getRequestChangeAdditionalRemarkTxtArea() {
		return locRequestChangeAdditionalRemarkTxtArea;
	}

	public QAFWebElement getRequestChangeAcceptBtn() {
		return locRequestChangeAcceptBtn;
	}

	public QAFWebElement getShowArchivedRecordsCheckBox() {
		return locShowArchivedRecordsCheckBox;
	}

	public GridComponent getDataTable() {
		return dataTable;
	}

	public QAFWebElement getClearAllBtn() {
		return locClearAllBtn;
	}

	public QAFWebElement getSelectAllBtn() {
		return locSelectAllBtn;
	}

	public QAFWebElement getPaginationItemCountLabelATDetailView() {
		return locPaginationItemCountLabelATDetailView;
	}

	public QAFWebElement getInitialCountLabelATDetailView() {
		return locInitialCountLabelATDetailView;
	}

	public QAFWebElement getPageLimitCountLabelATDetailView() {
		return locPageLimitCountLabelATDetailView;
	}

	public QAFWebElement getTotalCountLabelATDetailView() {
		return locTotalCountLabelATDetailView;
	}

	public QAFWebElement getSaveArrangeStepColumnBtn() {
		return locSaveArrangeStepColumnBtn;
	}

	public QAFWebElement getRestoreDefaultStepColumnsBtn() {
		return locRestoreDefaultStepColumnsBtn;
	}

	public QAFWebElement getFinishBtn() {
		return locFinishBtn;
	}

	public QAFWebElement getMenuSideBar() {
		return locMenuSideBar;
	}

	public QAFWebElement getCollapseMenuIcon() {
		return locCollpaseMenuIcon;
	}

	public QAFWebElement getExpandMenuIcon() {
		return locExpandMenuIcon;
	}

	public QAFWebElement getPreviewAttachment() {
		return locPreviewAttachment;
	}

	public QAFWebElement getDownloadAttachment() {
		return locDownloadAttachment;
	}

	public QAFWebElement getDeleteAttachment() {
		return locDeleteAttachment;
	}

	public QAFWebElement getClosePreviewAttachmentBtn() {
		return locClosePreviewAttachmentBtn;
	}

	public QAFWebElement getNextAttachmentPage() {
		return locNextAttachmentPage;
	}

	public QAFWebElement getQQbotPredicationAutoDisplaySwitch() {
		return locQQbotPredicationAutoDisplaySwitch;
	}

	public QAFWebElement getInputQQbotPredicationAutoDisplay() {
		return locInputQQbotPredicationAutoDisplay;
	}

	public QAFWebElement getMatchingPercentTxt() {
		return locMatchingPercentTxt;
	}

	public QAFWebElement getQQBot() {
		return locQQBot;
	}

	public QAFWebElement getClearTableSortingBtn() {
		return locClearTableSortingBtn;
	}

	public QAFWebElement getClearTableFilterBtn() {
		return locClearTableFilterBtn;
	}

	public QAFWebElement getMoveFolderBtn() {
		return locMoveFolderBtn;
	}

	public QAFWebElement getCopyFolderBtn() {
		return locCopyFolderBtn;
	}

	public QAFWebElement getCloseAcceptBtn() {
		return locCloseAcceptBtn;
	}

	public QAFWebElement getLinkByEntityKeyBtn() {
		return locLinkByEntityKeyBtn;
	}

	public QAFWebElement getEditSourceBtn() {
		return locEditSourceBtn;
	}

	public QAFWebElement getSelectFilterFolderBtn() {
		return locSelectFilterFolderBtn;
	}

	public QAFWebElement getRichTextEditorTextarea() {
		return locRichTextEditorTextarea;
	}

	public List<QAFWebElement> getMentionedUserList() {
		return locMentionedUserList;
	}

	public QAFWebElement getCheckCommentRichTxtEditorBtn() {
		return locCheckCommentRichTxtEditorBtn;
	}

	public QAFWebElement getShareEntityHeader() {
		return locShareEntityHeader;
	}

	public QAFWebElement getShareEntityEmailTxtBox() {
		return locShareEntityEmailTxtBox;
	}

	public QAFWebElement getShareEntityCommentTxtArea() {
		return locShareEntityCommentTxtArea;
	}

	public QAFWebElement getShareEntityCopyLinkBtn() {
		return locShareEntityCopyLinkBtn;
	}

	public QAFWebElement getShareEntityBtn() {
		return locShareEntityBtn;
	}

	public QAFWebElement getShareEntityEmailLabel() {
		return locShareEntityEmailLabel;
	}

	public QAFWebElement getApproveBtnAtPopUP() {
		return locApproveBtnAtPopUP;
	}

	public GridComponent getDataTableAtCustomDashboard() {
		return locDataTableAtCustomDashboard;
	}

	public GridComponent getModuleTableAtUDF() {
		return locTableModuleAtUDF;
	}

	public DetailViewPopUpFilterComponent getLinkTableAtPopUp() {
		return locLinkTableAtPopUp;
	}

	public QAFWebElement getYesBtnWithText() {
		return locYesBtnWithText;
	}

	public QAFWebElement getLinkByEntityKeysTextArea() {
		return locLinkByEntityKeysTextArea;
	}

	public QAFWebElement getLinkEntityKeyBtnAtPopUp() {
		return locLinkEntityKeyBtnAtPopUp;
	}

	public QAFWebElement getResetAttachmentBtn() {
		return locResetAttachmentBtn;
	}

	public QAFWebElement getTestcaseTabAtSearch() {
		return locTestcaseTabAtSearch;
	}

	public QAFWebElement getDownloadAllBtn() {
		return locDownloadAllBtn;
	}

	public QAFWebElement getInsertLinkBtn() {
		return locInsertLinkBtn;
	}

	public QAFWebElement getUrlLinkTxtBox() {
		return locUrlLinkTxtBox;
	}

	public QAFWebElement getUrlTextTxtBox() {
		return locUrlTextTxtBox;
	}

	public QAFWebElement getOpenInNewTabCheckBox() {
		return locOpenInNewTabCheckBox;
	}

	public QAFWebElement getSkipDuplicateLinkageCheckBox() {
		return locSkipDuplicateLinkageCheckBox;
	}

	public QAFWebElement getLinkBtn() {
		return locLinkBtn;
	}

	public QAFWebElement getFilterBtnAtDetails() {
		return locFilterBtnAtDetails;
	}

	public QAFWebElement getLinkTestcaseModelArrangeColumnBtn() {
		return locLinkTestcaseModelArrangeColumnBtn;
	}

	public QAFWebElement getLinkIssuesModelArrangeColumnBtn() {
		return locLinkIssuesModelArrangeColumnBtn;
	}

	public QAFWebElement getLinkIssuesWindowCloseBtn() {
		return locLinkIssuesWindowCloseBtn;
	}

	public QAFWebElement getAssignIssuesModelArrangeColumnBtn() {
		return locAssignIssuesModelArrangeColumnBtn;
	}

	public QAFWebElement getLinkTestsuiteModelArrangeColumnBtn() {
		return locLinkTestsuiteModelArrangeColumnBtn;
	}

	public QAFWebElement getLinkTestsuitesWindowCloseBtn() {
		return locLinkTestsuitesWindowCloseBtn;
	}

	public QAFWebElement getLinkTestcasesWindowCloseBtn() {
		return locLinkTestcasesWindowCloseBtn;
	}

	public QAFWebElement getLinkIssuesModelClearSortingBtn() {
		return locLinkIssuesModelClearSortingBtn;
	}

	public QAFWebElement getAssignIssuesToTestrunModelClearSortingBtn() {
		return locAssignIssuesToTestrunModelClearSortingBtn;
	}

	public QAFWebElement getCloseExecutionWindowBtn() {
		return locCloseExecutionWindowBtn;
	}

	public QAFWebElement getLinkRequirementsModelArrangeColumnBtn() {
		return locLinkRequirementsModelArrangeColumnBtn;
	}

	public QAFWebElement getLinkRequirementsWindowCloseBtn() {
		return locLinkRequirementsWindowCloseBtn;
	}

	public QAFWebElement getArrangeColumnFieldTxtBox() {
		return locArrangeColumnFieldTxtBox;
	}

	public QAFWebElement getSelectRequirementsHeader() {
		return locSelectRequirementsHeader;
	}

	public QAFWebElement getSelectTestcasesHeader() {
		return locSelectTestcasesHeader;
	}

	public QAFWebElement getSelectApplyBtn() {
		return locSelectApplyBtn;
	}

	public QAFWebElement getHelpListInfo() {
		return locHelpListInfo;
	}

	public QAFWebElement getInfoIconCircle() {
		return locInfoIconCircle;
	}

	public QAFWebElement getPopOverContent() {
		return locPopOverContent;
	}

	public QAFWebElement getFlakyScoreTestExecutionsAndIssuesHeader() {
		return locFlakyScoreTestExecutionsAndIssuesHeader;
	}

	public QAFWebElement getFlakyScoreTestExecutionsAndIssuesWindowCloseBtn() {
		return locFlakyScoreTestExecutionsAndIssuesWindowCloseBtn;
	}

	public QAFWebElement getLinkTestcaseModelRefreshBtn() {
		return locLinkTestcaseModelRefreshBtn;
	}

	public QAFWebElement getTestCaseDetailViewFlakyScoreApp() {
		return locTestCaseDetailViewFlakyScoreApp;
	}

	public QAFWebElement getTestCaseDetailViewSuccessRateApp() {
		return locTestCaseDetailViewSuccessRateApp;
	}

	public QAFWebElement getPermissionToAccessModuleText() {
		return locPermissionToAccessModuleText;
	}

	public QAFWebElement getAlertDialogMessageTxt() {
		return locAlertDialogMessageTxt;
	}

	public QAFWebElement getAlertDialogMessageNoBtn() {
		return locAlertDialogMessageNoBtn;
	}

	public QAFWebElement getAlertDialogMessageYesBtn() {
		return locAlertDialogMessageYesBtn;
	}

	public QAFWebElement getUnlinkSelectedBtn() {
		return locUnlinkSelectedBtn;
	}

	public QAFWebElement getLinkTestcaseWindowProjectsDrpDwn() {
		return locLinkTestcaseWindowProjectsDrpDwn;
	}

	public QAFWebElement getLinkTestcaseWindowProjectTxtBox() {
		return locLinkTestcaseWindowProjectTxtBox;
	}

	public QAFWebElement getYesContinueBtn() {
		return locBtnYesContinue;
	}

	public QAFWebElement getCloseAnnounencementMSgBtn() {
		return locCloseAnnounencementMSgBtn;
	}

	public QAFWebElement getDescriptionTxtBox() {
		return locDescriptionTxtBox;
	}

	public QAFWebElement getSelectTestsuitesHeader() {
		return locSelectTestsuitesHeader;
	}

	public List<QAFWebElement> getCreateFormLabelList() {
		return locCreateFormLabelList;
	}

	public List<QAFWebElement> getDetailTabdLabelList() {
		return locDetailTabFieldLabelList;
	}

	public QAFWebElement getGenerateTestcaseBtn() {
		return locGenerateTestcaseBtn;
	}

	public QAFWebElement getGenerateDetailsAndStepsBtn() {
		return locGenerateDetailsAndStepsBtn;
	}

	public QAFWebElement getSystemFieldsSectionDetailsTab() {
		return locSystemFieldSectionDetailsTab;
	}

	public GridComponent getTestcaseExpandTable() {
		return locTestcaseExpandTable;
	}

	public QAFWebElement getChangeLogTableLoader() {
		return locChangeLogTableLoader;
	}

	public QAFWebElement getWatcherUserListDrpDwnBtn() {
		return locWatcherUserListDrpDwnBtn;
	}

	public GridComponent getWatcherTable() {
		return watcherTable;
	}

	public QAFWebElement getDetailWindowCreatedOnDateTxt() {
		return locdetailWindowCreatedOnDatetxt;
	}

	public QAFWebElement getDetailWindowUpdatedOnDateTxt() {
		return locdetailWindowUpdatedOnDatetxt;
	}

	public QAFWebElement getSelectFolderHeader() {
		return locSelectFolderHeader;
	}

	public QAFWebElement getDetailWindowCreatedOnUserTxt() {
		return locdetailWindowCreatedOnUserTxt;
	}

	public QAFWebElement getDetailWindowUpdatedOnUserTxt() {
		return locdetailWindowUpdatedOnUserTxt;
	}

	public QAFWebElement getDetailWindowCreatedOnCompleteTxt() {
		return locdetailWindowCreatedOnCompleteTxt;
	}

	public QAFWebElement getDetailWindowUpdatedOnCompleteTxt() {
		return locdetailWindowUpdatedOnCompleteTxt;
	}

	public QAFWebElement getAddAttachmentTipMessage() {
		return locAddAttachmentTipMessageTxt;
	}

	public QAFWebElement getAddAttachmentDisplayMessage() {
		return locAddAttachmentDisplayMessageTxt;
	}

	public QAFWebElement getMailZipAttachment() {
		return locMailZipAttachment;
	}

	public QAFWebElement getExportWithCommentsCheckBox() {
		return locExportWithCommentsCheckBox;
	}

	/**
	 * @param locator
	 * @param args
	 */
	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	/**
	 * A method to generate a random string based on the given size
	 * 
	 * @param size
	 * @return String
	 * @author nidhi.shah
	 */
	public static String generateRandomString(int size) {
		return RandomStringGenerator.get(size);
	}

	/**
	 * A method to verify Toast message.
	 * 
	 * @param message
	 * @return Boolean
	 * @author nidhi.shah
	 */
	public Boolean verifyToastMessage(String message) {
		return true;
	}

	/**
	 * A method to check if sidebar is expanded
	 * 
	 * @author nidhi.shah
	 */
	public Boolean isSidebarOpened() {
		return getLocSidebarOpenedDrpdwn().isPresent();
	}

	/**
	 * A method to Expand the sidebar
	 * 
	 * @author nidhi.shah
	 */
	public void openSidebar() {
		if (!isSidebarOpened()) {
			getLocHeaderCmpnnt().getLocIconBarsLnk().waitForEnabled();
			QMetryUtility.click(getLocHeaderCmpnnt().getLocIconBarsLnk());
		}
		getLocSidebarOpenedDrpdwn().waitForPresent();
		getLocSidebarOpenedDrpdwn().verifyPresent();
	}

	/**
	 * A method to close the Sidebar
	 * 
	 * @author nidhi.shah
	 */
	public void closeSidebar() {
		if (isSidebarOpened()) {
			getLocHeaderCmpnnt().getLocIconBarsLnk().waitForEnabled();
			getLocHeaderCmpnnt().getLocIconBarsLnk().click();
		}
		getLocSidebarClosedDrpdwn().waitForPresent();
		getLocSidebarClosedDrpdwn().verifyPresent();
	}

	/**
	 * This method will print the precondition log.
	 * 
	 * @param status as boolean (true for start and false for end)
	 * @author rahul.patil
	 */
	public void preConditionLog(boolean status) {
		if (status) {
			Reporter.log("Precondition: Start", MessageTypes.Warn);
		} else {
			Reporter.log("Precondition: End", MessageTypes.Warn);
		}
	}

	/**
	 * This method will check for value in list.
	 * 
	 * @param listValues
	 * @param requiredValue
	 * @author rahul.patil
	 */
	public void verifyValueInList(List<String> listValues, String requiredValue) {
		if (listValues.contains(requiredValue)) {
			Reporter.log("List contains required value", MessageTypes.Pass);
		} else {
			Reporter.log("List does not contains required value", MessageTypes.Fail);
		}
	}

	/**
	 * This method will check for value not in list.
	 * 
	 * @param listValues
	 * @param requiredValue
	 * @author rahul.patil
	 */
	public void verifyValueNotInList(List<String> listValues, String requiredValue) {
		if (!listValues.contains(requiredValue)) {
			Reporter.log("List does not contains required value", MessageTypes.Pass);
		} else {
			Reporter.log("List contains required value", MessageTypes.Fail);
		}
	}

	/**
	 * This method will check for value not in list.
	 * 
	 * @param listValues
	 * @param requiredValue
	 * @author nidhi.shah
	 */
	public boolean verifyValuePresentInList(List<String> listValues, String requiredValue) {
		return listValues.contains(requiredValue);
	}

	/**
	 * Method will create folder in root folder.
	 * 
	 * @param folderName
	 * @author rahul.patil
	 */
	public void createFolderInRootFolder(String folderName) {
		expandFolderStructure();
		getCreateNewFolderBtn().waitForEnabled();
		QMetryUtility.click(getCreateNewFolderBtn());
		getFolderNameTxtBox().waitForVisible();
		getFolderNameTxtBox().waitForEnabled();
		getFolderNameTxtBox().clear();
		getFolderNameTxtBox().sendKeys(folderName);
		getCreateFolderBtn().waitForEnabled();
		QMetryUtility.click(getCreateFolderBtn());
		getCreateFolderBtn().waitForNotVisible();
		getLocNewBtn().waitForVisible();
	}

	/**
	 * A method verifies if folder is present
	 * 
	 * @param requirementBean
	 * @author rahul.patil, nidhi.shah
	 */
	public boolean verifyFolder(String folderName) {
		getFolder(folderName).waitForEnabled();
		return getFolder(folderName).verifyText(folderName);
	}

	/**
	 * This method with navigate to sub folder based on folder name provided as an
	 * argument
	 * 
	 * @param folderName
	 * @author rahul.patil
	 */
	public QAFWebElement getFolder(String folderName) {
		String locFolder = "xpath=.//*[@title='" + folderName + "']";
		driver.findElement(locFolder).waitForEnabled();
		return driver.findElement(locFolder);
	}

	/**
	 * A method to right click on specified element.
	 * 
	 * @param loc
	 */
	public void rightClickOnElement(String loc) {
		Actions action = new Actions(driver);
		WebElement ele = (WebElement) $(loc);
		action.contextClick(ele).perform();
	}

	/**
	 * A method to right click on specified element.
	 * 
	 * @param loc
	 */
	public void rightClickOnFolder() {
		String locFolder = "xpath=.//*[@role='treeitem' and contains(@class,'highlight')]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).waitForEnabled();
		QMetryUtility.moveMouseOnElement(driver.findElement(locFolder));
		rightClickOnElement(locFolder);
	}

	/**
	 * This method will select operation for folder.
	 * 
	 * @param operationName
	 * @author rahul.patil
	 */
	public void selectOperationForFolder(String operationName) {
		rightClickOnFolder();
		String locOp = "xpath=.//*[text()='" + operationName + "']//parent::a";
		driver.findElement(locOp).waitForEnabled();
		driver.findElement(locOp).click();

	}

	/**
	 * A enum for Destination Clone Module
	 *
	 * @author rahul.patil
	 * 
	 *         updated by priyanka.devaliya -- given generic name to reuse
	 *         [DestinationCloneModule--moduleOptions]
	 */
	public enum moduleOptions {
		REQUIREMENT("Requirement"), TESTCASE("Test Case"), TESTSUITE("Test Suite"), ISSUES("Issue");

		private String menuOption;

		private moduleOptions(String menuOption) {
			this.menuOption = menuOption;
		}

		@Override
		public String toString() {
			return menuOption;
		}
	}

	/**
	 * A method to select an option from the 'Option' menu
	 * 
	 * @param option
	 */
	public void selectOption(Options option) {
		String _option = option.toString();
		getMainOPtionDropDown().waitForVisible();
		if (getMainOPtionDropDown().getAttribute("aria-expanded").equals("false")) {
			getMainOPtionDropDown().waitForEnabled();
			QMetryUtility.click(getMainOPtionDropDown());
		}
		String eleOption = ".//a[text()='" + _option + "']";
		driver.findElement(By.xpath(eleOption)).waitForVisible();
		driver.findElement(By.xpath(eleOption)).waitForEnabled();
		QMetryUtility.click(driver.findElement(By.xpath(eleOption)));

	}

	/**
	 * A method to select an option from the 'Option' menu
	 * 
	 * @param option
	 */
	public List<String> getOptionsList() {
		getMainOPtionDropDown().waitForEnabled();
		QMetryUtility.click(getMainOPtionDropDown());
		List<String> columnValues = new ArrayList<>();
		String eleOptions = ".//*[@title='Options' and @aria-expanded]/following-sibling::*/li";
		int size = driver.findElements(By.xpath(eleOptions)).size();
		for (int i = 0; i < size; i++) {
			if (driver.findElements(By.xpath(eleOptions)).get(i).getAttribute("class").contains("dropdown-divider")) {
				break;
			} else {
				columnValues.add(driver.findElements(By.xpath(eleOptions)).get(i).getText());
			}
		}
		return columnValues;
	}

	/**
	 * A enum for Options
	 *
	 * @author rahul.patil
	 */
	public enum Options {
		IMPORT("Import"), BULKOPERATION("Bulk Operations"), EXPORT("Export"), ARCHIVE("Archive"),
		UNARCHIVE("Unarchive"), DELETE("Delete"), EDIT("Edit"), UPDATE_CREDENTIALS("Update Credentials"),
		CREATE_REQUIREMENT_FROM_ISSUE("Create Requirement from Issue"),
		CREATE_TEST_CASE_FROM_REQUIREMENT("Create Test Case from Requirement"),
		CREATE_TEST_SUITE_FROM_REQUIREMENT("Create Test Suite from Requirement"),
		CREATE_TEST_SUITE_FROM_TEST_CASE("Create Test Suite from Test Case"), TEST_RESULT_LOG("Test Result Log"),
		CHANGE_LOG("Change Log"), CREATE_NEW_VERSION("Create New Version"),
		EXPORT_AS_XLSX_FORMAT("Export as XLSX Format"), SHARE_AS_CHILD_TESTCASE("Share as Child Test Case"),
		MOVE_OR_COPY("Move/Copy"), CREATE_TEST_SUITE_FROM_FOLDER("Create Test Suite from Folder"),
		SORT_BY_NAME_A_TO_Z("Sort by Name - A-Z"), SORT_BY_NAME_Z_TO_A("Sort by Name - Z-A"),
		SORT_BY_DATE_NEWEST_FIRST("Sort by Date - Newest First"),
		SORT_BY_DATE_OLDEST_FIRST("Sort by Date - Oldest First"), HIDE_EMPTY_FOLDERS("Hide Empty Folders"),
		INCLUDE_ENTITIES_FROM_SUB_FOLDER("Include Entities from Sub-Folder"), CREATE_DATAGRID("Create DataGrid"),
		INSERT_ROW("Insert Row"), INSERT_SHAREBLE_TEST_CASE("Insert Shareable Test Case"), REMOVE_ROW("Remove Row"),
		DUPLICATE_RAW("Duplicate Row"), MOVE_TO_BOTTOM("Move to Bottom"), BULK_MOVE_COPY("Bulk Move/Copy"),
		CLONE_FOLDER_STRUCTURE("Clone Folder Structure"), COPY("Copy"), Move("Move"),
		EXPORT_AS_CSV_FORMAT("Export as CSV Format"), GENERATE_TESTCASE_USING_QI("Generate Test Cases Using QI"),
		COPY_STEPS_FROM_AN_EXISTING_TESTCASE("Copy Steps from an Existing Test Case");

		private String menuOption;

		private Options(String menuOption) {
			this.menuOption = menuOption;
		}

		@Override
		public String toString() {
			return menuOption;
		}
	}

	/**
	 * A enum for Bulk Operations
	 *
	 * @author rahul.patil
	 */
	public enum BulkOperations {
		EDIT("Edit"), COPY("Copy"), MOVE("Move"), ARCHIVE("Archive"), UNARCHIVE("Unarchive"), DELETE("Delete"),
		EXPORT("Export"), ARCHIVESFOLDERS("Archive Folders"), UNARCHIVESFOLDERS("Unarchive Folders"),
		EXECUTION_STATUS("Execution Status"), EXECUTION_TYPE("Execution Type"), ASSIGNEE("Assignee"), ISSUES("Issues"),
		SYNC_WITH_LATEST_VERSION("Sync with Latest Version"), MOVE_FOLDERS("Move Folders"),
		COPY_FOLDERS("Copy Folders"), SHARE("Share"), PUSH("Push"), PULL("Pull"), REVIEW("Review"), APPROVE("Approve"),
		REQUEST_CHANGE_APPROVAL("Request change - Approval"), REQUEST_CHANGE_CLOSURE("Request change - Closure"),
		CLOSED("Closed"), APPROVED("Approved"), REQUEST_CHANGE("Request change"), PLANNED_DATE("Planned Date");

		private String menuOption;

		private BulkOperations(String menuOption) {
			this.menuOption = menuOption;
		}

		@Override
		public String toString() {
			return menuOption;
		}
	}

	/**
	 * A method to select bulk operation.
	 * 
	 * @param operation
	 * @param option
	 */
	public void selectBulkOperation(BulkOperations operation) {
		String _option = operation.toString();
		String eleOption = ".//*[text()[normalize-space() = '" + _option + "']]/input";
		driver.findElement(By.xpath(eleOption)).waitForVisible();
		if (!driver.findElement(By.xpath(eleOption)).isSelected()) {
			driver.findElement(By.xpath(eleOption)).waitForEnabled();
			driver.findElement(By.xpath(eleOption)).click();
		}

	}

	/**
	 * A method to select bulk operation.
	 * 
	 * @param operation
	 * @param option
	 * @return
	 */
	public QAFWebElement getBulkOperationOption(BulkOperations operation) {
		String _option = operation.toString();
		String eleOption = ".//*[text()[normalize-space() = '" + _option + "']]/input";
		return driver.findElement(By.xpath(eleOption));

	}

	/**
	 * A method will verify latest scheduled task actitvity
	 * 
	 * @param activity
	 * @param module
	 */
	public boolean verifyScheduledTaskActivity(String activity, String module) {
		getGoToScheduledTasksBtn().waitForEnabled();
		QMetryUtility.click(getGoToScheduledTasksBtn());
		return getScheduledTaskActivity().get(0).verifyText(activity)
				&& getScheduledTaskActivity().get(1).verifyText("(" + module + ")");
	}

	/**
	 * A method to click on a 'New' button of all modules.
	 * 
	 * @param loc
	 */
	public void clickOnNew() {
		try {
			getLocNewBtn().waitForEnabled();
			QMetryUtility.click(getLocNewBtn());
		} catch (TimeoutException e) {
			driver.navigate().refresh();
			getLocNewBtn().waitForEnabled();
			QMetryUtility.click(getLocNewBtn());
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			getLocNewBtn().waitForEnabled();
			QMetryUtility.click(getLocNewBtn());
		} catch (Exception e) {
			driver.navigate().refresh();
			getLocNewBtn().waitForEnabled();
			QMetryUtility.click(getLocNewBtn());
		}
	}

	/**
	 * A method to click on a 'New' button of all modules.
	 * 
	 * @param loc
	 */
	public void waitForNewBtn() {
		try {
			getLocNewBtn().waitForEnabled();
		} catch (TimeoutException e) {
			driver.navigate().refresh();
			getLocNewBtn().waitForEnabled();
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			getLocNewBtn().waitForEnabled();
		} catch (Exception e) {
			driver.navigate().refresh();
			getLocNewBtn().waitForEnabled();
		}
	}

	/**
	 * This method will store the provided properties in data.properties file under
	 * specified environment.
	 * 
	 * @param properties as Map<String, String>
	 */
	public static void storeProperties(String key, Object value) {
		String filePath = dataProperties;
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			// Load the file into properties object
			Properties currentProperties = new Properties();
			currentProperties.load(fileInputStream);
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				// Set the properties value
				currentProperties.remove(key);
				currentProperties.setProperty(key, String.valueOf(value));
				currentProperties.store(fileOutputStream, null);
			}
			ConfigurationManager.addBundle(dataProperties);
		} catch (IOException ioException) {
			ioException.fillInStackTrace();
		}
	}

	/**
	 * This method will store the provided properties in data.properties file under
	 * specified environment.
	 * 
	 * @param properties as Map<String, String>
	 */
	public static void storeUDFProperties(String key, Object value) {
		String filePath = udfDataProperties;
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			// Load the file into properties object
			Properties currentProperties = new Properties();
			currentProperties.load(fileInputStream);
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				// Set the properties value
				currentProperties.remove(key);
				currentProperties.setProperty(key, String.valueOf(value));
				currentProperties.store(fileOutputStream, null);
			}
			ConfigurationManager.addBundle(dataProperties);
		} catch (IOException ioException) {
			ioException.fillInStackTrace();
		}
	}

	/**
	 * This method will store the provided properties in data.properties file under
	 * specified environment.
	 * 
	 * @param properties as Map<String, String>
	 */
	public static void storeProperties(String key, Object value, String filePath_) {
		String filePath = filePath_;
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			// Load the file into properties object
			Properties currentProperties = new Properties();
			currentProperties.load(fileInputStream);
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				// Set the properties value
				currentProperties.setProperty(key, String.valueOf(value));
				currentProperties.store(fileOutputStream, null);
			}
			ConfigurationManager.addBundle(dataProperties);
		} catch (IOException ioException) {
			ioException.fillInStackTrace();
		}
	}

	/**
	 * This method with navigate to tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author rahul.patil updated with add contains before class to resuse
	 */
	public void navigateToTab(String tabName) {
		String tabToNav = "xpath=.//*[contains(@class,'ui-tabview-nav')]//*[text()[normalize-space()='" + tabName
				+ "']]";
		driver.findElement(tabToNav).waitForVisible();
		driver.findElement(tabToNav).waitForEnabled();
		driver.findElement(tabToNav).click();
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author rahul.patil
	 */
	public void waitForTableToLoad() {
		/*
		 * do { } while (!getTable().getColumnList().get(1).getAttribute("style").
		 * contains("position: relative"));
		 */
		getRefreshBtn().waitForVisible();
		getRefreshBtn().waitForEnabled();
		getRefreshBtn().click();
		getEntityCountText().waitForVisible();
		getEntityCountText().waitForEnabled();
	}

	/**
	 * This method will store the provided properties in data.properties file under
	 * specified environment.
	 * 
	 * @param properties as Map<String, String>
	 */
	public static void storeTestDataProperties(String key, Object value) {
		String filePath = testDataProperties;
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			// Load the file into properties object
			Properties currentProperties = new Properties();
			currentProperties.load(fileInputStream);
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				// Set the properties value
				currentProperties.setProperty(key, String.valueOf(value));
				currentProperties.store(fileOutputStream, null);
			}
			ConfigurationManager.addBundle(testDataProperties);
		} catch (IOException ioException) {
			ioException.fillInStackTrace();
		}
	}

	/**
	 * This method will verify pop up message after operation.
	 * 
	 * @param message
	 * @author rahul.patil
	 */
	public void verifyMessageText(String message) {
		String locFolder = "xpath=.//*[text()='" + message + "']";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).verifyVisible();
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author rahul.patil
	 */
	public void waitForHorizontalBarToLoad() {
		String locFolder = "xpath=.//*[contains(@class,'show-horizontal-bar')]";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author rahul.patil
	 */
	public void waitForCommentOperation() {
		String locFolder = "xpath=.//comments//*[contains(@class,'relative')]";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * Method will edit folder and verify.
	 * 
	 * @param commonBean
	 * @author rahul.patil
	 */
	public void editFolder(CommonBean commonBean) {
		getFolder(commonBean.getFolderName()).click();
		waitForHorizontalBarToLoad();
		getEditFolderBtn().waitForEnabled();
		getEditFolderBtn().click();
		getFolderNameTxtBox().waitForVisible();
		getFolderNameTxtBox().waitForEnabled();
		getFolderNameTxtBox().clear();
		getFolderNameTxtBox().sendKeys(commonBean.getUpdatedFolderName());
		getUpdateFolderBtn().waitForEnabled();
		getUpdateFolderBtn().click();
		getUpdateFolderBtn().waitForNotVisible();
		waitForHorizontalBarToLoad();
	}

	/**
	 * Method to wait for a loader to be hidden.
	 * 
	 * @param element
	 * @author nidhi.shah
	 */
	public void waitForLoader(QAFWebElement element) {
		do {

		} while (!(Boolean) driver.executeScript("return arguments[0].hasAttribute(\"hidden\");", element));
	}

	/**
	 * Method to wait for a loader to be hidden.
	 * 
	 * @param element
	 * @author nidhi.shah
	 */
	public void waitForTabLoader() {
		String locFolder = "xpath=.//loader[contains(@class,'inside-tab-loader')]";
		do {

		} while (!(Boolean) driver.executeScript("return arguments[0].hasAttribute(\"hidden\");",
				driver.findElement(locFolder)));
	}

	/**
	 * This method will verify list of values present in a list.
	 * 
	 * @param listValues
	 * @param requiredValues
	 * @author rahul.patil
	 * @return boolean
	 */
	public boolean verifyValuesPresentInList(List<String> listValues, List<String> requiredValues) {
		boolean flag = true;
		for (String value : requiredValues) {
			if (!listValues.contains(value.trim())) {
				return false;
			}
		}
		return flag;
	}

	/**
	 * This method will check if all the values in a list is same as value passed sa
	 * second argument in method.
	 * 
	 * @param listValues
	 * @param value
	 * @author rahul.patil
	 * @return boolean
	 */
	public boolean verifySameValuePresentInList(List<String> listValues, String value) {
		boolean flag = true;
		for (String listValue : listValues) {
			if (!listValue.equals(value)) {
				return false;
			}
		}
		return flag;
	}

	/**
	 * This method will add comment for entity.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public void addComment(String comment) {
		getAddCommentBtn().waitForEnabled();
		QMetryUtility.click(getAddCommentBtn());
		getCommentTxtBox().waitForVisible();
		getCommentTxtBox().waitForEnabled();
		getCommentTxtBox().sendKeys(comment);
		getCheckCommnetBtn().waitForEnabled();
		QMetryUtility.click(getCheckCommnetBtn());
		waitForCommentOperation();
		waitForTabLoader();
	}

	/**
	 * This method will edit comment.
	 * 
	 * @param comment
	 * @param updatedComment
	 * @author rahul.patil
	 */
	public void editComment(String comment, String updatedComment) {
		String commentEditLoc = "xpath=.//*[text()='" + comment
				+ "']/parent::div/../preceding-sibling::div//*[contains(@class,'pencil')]";
		driver.findElement(commentEditLoc).waitForVisible();
		driver.findElement(commentEditLoc).waitForEnabled();
		QMetryUtility.click(driver.findElement(commentEditLoc));
		getCommentTxtBox().waitForVisible();
		getCommentTxtBox().waitForEnabled();
		getCommentTxtBox().clear();
		getCommentTxtBox().sendKeys(updatedComment);
		getCheckCommnetBtn().waitForEnabled();
		QMetryUtility.click(getCheckCommnetBtn());
		waitForCommentOperation();
	}

	/**
	 * This method will edit comment.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public QAFWebElement getEditCommentButton(String comment) {
		String commentEditLoc = "xpath=.//*[text()='" + comment
				+ "']/parent::div/../preceding-sibling::div//*[contains(@class,'pencil')]";
		return driver.findElement(commentEditLoc);
	}

	/**
	 * This method will delete specified comment.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public void deleteComment(String comment) {
		String commentDeleteLoc = "xpath=.//*[text()='" + comment
				+ "']/parent::div/../preceding-sibling::div//*[contains(@class,'trash')] | .//*[text()='" + comment
				+ "']/ancestor::div[contains(@class,'table')]/preceding-sibling::div//*[contains(@class,'trash')]";
		driver.findElement(commentDeleteLoc).waitForVisible();
		driver.findElement(commentDeleteLoc).waitForEnabled();
		QMetryUtility.click(driver.findElement(commentDeleteLoc));
		getYesBtn().waitForVisible();
		getYesBtn().waitForEnabled();
		QMetryUtility.click(getYesBtn());
		waitForCommentOperation();
	}

	/**
	 * This method will edit comment.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public QAFWebElement getDeleteCommentButton(String comment) {
		String commentDeleteLoc = "xpath=.//*[text()='" + comment
				+ "']/parent::div/../preceding-sibling::div//*[contains(@class,'trash')] | .//*[text()='" + comment
				+ "']/ancestor::div[contains(@class,'table')]/preceding-sibling::div//*[contains(@class,'trash')]";
		return driver.findElement(commentDeleteLoc);
	}

	/**
	 * This method will verify comment is vailable in comment page or not.
	 * 
	 * @return boolean
	 * @param comment
	 * @author rahul.patil
	 */
	public boolean verifyComment(String comment) {
		waitForLoader(getDetailViewLoader());
		String commentLoc = "xpath=.//*[text()='" + comment + "']";
		return driver.findElement(commentLoc).verifyVisible();
	}

	/**
	 * This method will add attachment for entity based upon file provided as an
	 * argument.
	 * 
	 * @param file
	 * @author rahul.patil
	 */
	public void addAttachment(String file) {
		getAddAttachmentBtn().waitForVisible();
		getAddAttachmentBtn().waitForEnabled();
		QMetryUtility.click(getAddAttachmentBtn());
		getSelectFileTxtBox().waitForEnabled();
		getSelectFileTxtBox().sendKeys(file);
		getAddFileBtn().waitForEnabled();
		QMetryUtility.click(getAddFileBtn());
		getAddFileBtn().waitForNotVisible();
		waitForTabLoader();
	}

	/**
	 * This method will check if the list is in acending order or not and returns a
	 * boolean response.
	 * 
	 * @param listValues
	 * @author rahul.patil
	 * @return boolean
	 */
	public boolean isListInAscendingOrder(List<String> listValues) {
		// List<String> sortedList = listValues; // Creates a shallow copy
		List<String> sortedList = new ArrayList<>(listValues); // Creates a deep copy
		Collections.sort(sortedList);
		return sortedList.equals(listValues);
	}

	/**
	 * This method will check if the list is in acending order or not and returns a
	 * boolean response.
	 * 
	 * @param listValues
	 * @author rahul.patil
	 * @return boolean
	 */
	public boolean isListInDescendingOrder(List<String> listValues) {
		// List<String> sortedList = listValues; // Creates a shallow copy
		List<String> sortedList = new ArrayList<>(listValues); // Creates a deep copy
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(listValues);
	}

	/**
	 * A method to Expand the filter
	 * 
	 * @author rahul.patil
	 */
	public void expandFilter() {
		getLocFilterButton().waitForVisible();
		getLocFilterButton().waitForEnabled();
		if (getLocFilterButton().getAttribute("title").equals("Expand Filters")) {
			getLocFilterButton().waitForEnabled();
			QMetryUtility.click(getLocFilterButton());
			getLocFilterButton().waitForAttribute("title", "Collapse Filters");
		}
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void expandArrangeColumns() {
		getArrangeColumnCheck().waitForVisible();
		if (!getArrangeColumnCheck().getAttribute("aria-expanded").contains("true")) {
			getArrangeColumnCheck().waitForVisible();
			getArrangeColumnCheck().waitForEnabled();
			QMetryUtility.click(getArrangeColumnCheck());
		}

	}

	/**
	 * A method to restore default column arrangmnet.
	 * 
	 * @author rahul.patil
	 */
	public void restoreDefaultColumns() {
		expandArrangeColumns();
		getRestoreDefaultColumnsBtn().waitForVisible();
		getRestoreDefaultColumnsBtn().waitForEnabled();
		QMetryUtility.click(getRestoreDefaultColumnsBtn());
	}

	/**
	 * This method checks the show archive checkbox
	 * 
	 * @author rahul.patil, nidhi.shah
	 */
	public void enableShowArchivedEntities() {
		getLocFilterButton().waitForEnabled();
		QMetryUtility.click(getLocFilterButton());
		getLocFilter().selectCheckBoxByName(CheckBoxLabels.SHOW_ARCHIVED_ITEMS.toString());
		getLocNewBtn().waitForVisible();
		getLocFilterButton().waitForEnabled();
		QMetryUtility.click(getLocFilterButton());
		waitForHorizontalBarToLoad();
		/* waitForLoader(getTableLoader()); */
	}

	/**
	 * A method to move to folder
	 * 
	 * @param folderName
	 * @author rahul.patil, nidhi.shah
	 */
	public void goToFolder(String folderName) {
		getFolder(folderName).waitForEnabled();
		QMetryUtility.click(getFolder(folderName));
	}

	/**
	 * A method to update property value
	 * 
	 * @param propertyValues
	 * @author nidhi.shah
	 */
	public static void updatePropertyValue(Map<String, String> propertyValues) throws ConfigurationException {
		PropertiesConfiguration properties = new PropertiesConfiguration(commonProperties);
		for (Map.Entry mapElement : propertyValues.entrySet()) {
			String key = (String) mapElement.getKey();
			properties.setProperty(key, mapElement.getValue());
		}
		properties.save();
		for (Map.Entry mapElement : propertyValues.entrySet()) {
			String key = (String) mapElement.getKey();
			ConfigurationManager.getBundle().setProperty(key, mapElement.getValue());
		}
	}

	/**
	 * A method to update login credentials
	 * 
	 * @param isNewClient
	 * @author nidhi.shah
	 */
	public static void setUserData(Boolean isNewClient) throws ConfigurationException {
		Map<String, String> userData = new HashMap<>();
		if (isNewClient) {
			userData.put("user.username", ConfigurationManager.getBundle().getString("new.username"));
			userData.put("user.alias", ConfigurationManager.getBundle().getString("new.username"));
			userData.put("user.password", ConfigurationManager.getBundle().getString("new.password"));
			userData.put("user.orgCode", ConfigurationManager.getBundle().getString("new.orgName"));
			userData.put("user.open.api.key", ConfigurationManager.getBundle().getString("new.open.api.key"));
		} else {
			userData.put("user.username", ConfigurationManager.getBundle().getString("default.username"));
			userData.put("user.alias", ConfigurationManager.getBundle().getString("default.alias"));
			userData.put("user.password", ConfigurationManager.getBundle().getString("default.password"));
			userData.put("user.orgCode", ConfigurationManager.getBundle().getString("default.orgCode"));
			userData.put("user.open.api.key", ConfigurationManager.getBundle().getString("default.open.api.key"));
		}
		updatePropertyValue(userData);
	}

	/**
	 * A method to get Open API Key text
	 * 
	 * @return string
	 * @author nidhi.shah
	 */
	public String getOpenAPIKey() {
		getOpenAPIKeySpn().waitForVisible();
		return getOpenAPIKeySpn().getText();
	}

	/**
	 * This method will delete attachment for entity based upon file provided as an
	 * argument.
	 * 
	 * @param file
	 * @author rahul.patil
	 */
	public void deleteAttachment(String file) {
		getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_ATTACHMENT_NAME, file).waitForVisible();
		QMetryUtility.clickUsingJavaScript(
				getTable().getDeleteButtonByCellValue(CommonConstants.COLUMN_ATTACHMENT_NAME, file));
		getYesBtn().waitForVisible();
		getYesBtn().waitForEnabled();
		QMetryUtility.click(getYesBtn());
	}

	/**
	 * A method verifies if folder updated folder is present
	 * 
	 * @param commonBean
	 * @author rahul.patil
	 */
	public boolean verifyEditFolder(CommonBean commonBean) {
		getFolder(commonBean.getUpdatedFolderName()).waitForEnabled();
		return getFolder(commonBean.getUpdatedFolderName()).verifyText(commonBean.getUpdatedFolderName());
	}

	/**
	 * A method will apply show archived entity filter for module.
	 * 
	 * @author rahul.patil
	 */
	public void applyShowArchivedItemFilter() {
		expandFilter();
		getLocFilter().selectCheckBoxByName(CheckBoxLabels.SHOW_ARCHIVED_ITEMS.toString());
		waitForHorizontalBarToLoad();
	}

	/**
	 * A method to Expand the folder structure.
	 * 
	 * @author rahul.patil
	 */
	public void expandFolderStructure() {
		getLocFolderBtn().waitForVisible();
		if (getLocFolderBtn().getAttribute("title").equals("Expand Tree")) {
			getLocFolderBtn().waitForVisible();
			getLocFolderBtn().waitForEnabled();
			QMetryUtility.click(getLocFolderBtn());
		}
	}

	/**
	 * This method will select column and save arrange column setting.
	 * 
	 * @param columnNames
	 * @author rahul.patil
	 */
	public void checkColumnAndSave(HashMap<String, Boolean> data) {
		for (String key : data.keySet()) {
			if (Boolean.valueOf(data.get(key)) == true) {
				String locColumn = "xpath=.//label[text()[normalize-space() = '" + key + "']]/input";
				driver.findElement(locColumn).waitForVisible();
				if (!driver.findElement(locColumn).isSelected()) {
					driver.findElement(locColumn).waitForEnabled();
					QMetryUtility.click(driver.findElement(locColumn));
				}
			} else if (Boolean.valueOf(data.get(key)) == false) {
				String locColumn = "xpath=.//label[text()[normalize-space() = '" + key + "']]/input";
				driver.findElement(locColumn).waitForVisible();
				if (driver.findElement(locColumn).isSelected()) {
					driver.findElement(locColumn).waitForEnabled();
					QMetryUtility.click(driver.findElement(locColumn));
				}
			}
		}
		getSaveArrangeColumnBtn().waitForEnabled();
		QMetryUtility.click(getSaveArrangeColumnBtn());

	}

	/**
	 * This method will select column and save arrange column setting.
	 * 
	 * @param columnNames
	 * @author rahul.patil
	 */
	public void checkColumnAndCancel(HashMap<String, Boolean> data) {
		for (String key : data.keySet()) {
			if (Boolean.valueOf(data.get(key)) == true) {
				String locColumn = "xpath=.//label[text()[normalize-space() = '" + key + "']]/input";
				driver.findElement(locColumn).waitForVisible();
				if (!driver.findElement(locColumn).isSelected()) {
					driver.findElement(locColumn).waitForEnabled();
					QMetryUtility.click(driver.findElement(locColumn));
				}
			} else if (Boolean.valueOf(data.get(key)) == false) {
				String locColumn = "xpath=.//label[text()[normalize-space() = '" + key + "']]/input";
				driver.findElement(locColumn).waitForVisible();
				if (driver.findElement(locColumn).isSelected()) {
					driver.findElement(locColumn).waitForEnabled();
					QMetryUtility.click(driver.findElement(locColumn));
				}
			}
		}
		getCancelArrangeColumnBtn().waitForEnabled();
		QMetryUtility.click(getCancelArrangeColumnBtn());

	}

	/**
	 * A method will navigate to project root folder.
	 * 
	 * @param projectName
	 * @author rahul.patil
	 */
	public void navigateToProjectRootFolder(String projectName) {
		expandFolderStructure();
		getFolder(projectName).waitForEnabled();
		QMetryUtility.click(getFolder(projectName));
		waitForHorizontalBarToLoad();
	}

	/**
	 * Method will verify archived or unarchived state of folder.
	 * 
	 * @param folderName
	 * @author rahul.patil
	 */
	public boolean isFolderArchived(String folderName) {
		String folderLoc = "xpath=.//*[text()='" + folderName + "']//ancestor::li[contains(@class,'p-treenode-leaf')]";
		driver.findElement(folderLoc).waitForVisible();
		return driver.findElement(folderLoc).getAttribute("class").contains("archived");
	}

	/**
	 * Method will select show only archived version check box.
	 * 
	 * @param isCheck
	 * @author rahul.patil
	 */
	public void selectShowOnlyArchivedVersionCheckBox(boolean isCheck) {
		if (isCheck == true) {
			getShowOnlyArchivedVersionCheckBox().waitForVisible();
			if (!getShowOnlyArchivedVersionCheckBox().isSelected()) {
				getShowOnlyArchivedVersionCheckBox().waitForEnabled();
				waitForTabLoader();
				getShowOnlyArchivedVersionCheckBox().click();
				getShowOnlyArchivedVersionCheckBox().waitForSelected();
			}
		} else {
			if (isCheck == false) {
				getShowOnlyArchivedVersionCheckBox().waitForVisible();
				if (getShowOnlyArchivedVersionCheckBox().isSelected()) {
					getShowOnlyArchivedVersionCheckBox().waitForVisible();
					getShowOnlyArchivedVersionCheckBox().waitForEnabled();
					waitForTabLoader();
					getShowOnlyArchivedVersionCheckBox().click();
					getShowOnlyArchivedVersionCheckBox().waitForNotSelected();
				}
			}
		}
	}

	/**
	 * Method to select check box of entity version in versions tab.
	 * 
	 * @param version
	 * @author rahul.patil
	 */
	public QAFWebElement getCheckBoxEntityVersion(String version) {
		String locEntityVersionCheckBox = ".//table/tbody//*[contains(@title,'" + version
				+ "')]/ancestor::tr//input[@type='checkbox']";
		return driver.findElement(By.xpath(locEntityVersionCheckBox));
	}

	/**
	 * Method will verify unarchived state of entity version.
	 * 
	 * @param version
	 * @author rahul.patil
	 */
	public boolean verifyEntityVersionIsUnarchived(String version) {
		String optionLoc = ".//table/tbody//*[contains(@title,'" + version + "')]/ancestor::tr";
		driver.findElement(By.xpath(optionLoc)).waitForVisible();
		return !driver.findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived");
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param version
	 * @author rahul.patil
	 */
	public boolean verifyEntityVersionIsArchived(String version) {
		String optionLoc = "xpath=.//table/tbody//*[contains(@title,'" + version + "')]/ancestor::tr";
		driver.findElement(optionLoc).waitForVisible();
		return driver.findElement(optionLoc).getAttribute("class").contains("archived");
	}

	/**
	 * Method to archive entity version.
	 * 
	 * @param version
	 * @author rahul.patil
	 */
	public void archiveEntityVersion(String version) {
		getArchiveSelectedVersionBtn().waitForVisible();
		getCheckBoxEntityVersion(version).waitForVisible();
		getCheckBoxEntityVersion(version).waitForEnabled();
		QMetryUtility.click(getCheckBoxEntityVersion(version));
		getArchiveSelectedVersionBtn().waitForEnabled();
		QMetryUtility.click(getArchiveSelectedVersionBtn());
		getYesBtn().waitForEnabled();
		QMetryUtility.click(getYesBtn());
		getRefreshBtn().waitForEnabled();
		QMetryUtility.click(getRefreshBtn());
		waitForLoader(getDetailViewLoader());
	}

	/**
	 * Method to unarchive entity version.
	 * 
	 * @param version
	 * @author rahul.patil
	 */
	public void unArchiveEntityVersion(String version) {
		getUnarchiveSelectedVersionBtn().waitForVisible();
		getCheckBoxEntityVersion(version).waitForVisible();
		getCheckBoxEntityVersion(version).waitForEnabled();
		QMetryUtility.click(getCheckBoxEntityVersion(version));
		getUnarchiveSelectedVersionBtn().waitForEnabled();
		QMetryUtility.click(getUnarchiveSelectedVersionBtn());
		getYesBtn().waitForEnabled();
		QMetryUtility.click(getYesBtn());
		waitForLoader(getDetailViewLoader());
		getRefreshBtn().waitForEnabled();
		QMetryUtility.click(getRefreshBtn());
		waitForLoader(getDetailViewLoader());
	}

	/**
	 * Method to unarchive entity version.
	 * 
	 * @param version
	 * @author rahul.patil
	 */
	public void deleteEntityVersion(String version) {
		getDeleteSelectedVersionBtn().waitForVisible();
		getCheckBoxEntityVersion(version).waitForVisible();
		getCheckBoxEntityVersion(version).waitForEnabled();
		QMetryUtility.click(getCheckBoxEntityVersion(version));
		getDeleteSelectedVersionBtn().waitForEnabled();
		QMetryUtility.click(getDeleteSelectedVersionBtn());
		getYesBtn().waitForEnabled();
		QMetryUtility.click(getYesBtn());
		waitForLoader(getDetailViewLoader());
		getRefreshBtn().waitForEnabled();
		QMetryUtility.click(getRefreshBtn());
		waitForLoader(getDetailViewLoader());
	}

	/**
	 * This method will verify comment is deleted or not.
	 * 
	 * @return boolean
	 * @author rahul.patil
	 */
	public boolean verifyCommentIsDeleted(String comment) {
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
		getRefreshBtn().waitForEnabled();
		QMetryUtility.click(getRefreshBtn());
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
		if (!getNoDataAvailableText().isPresent()) {
			return !verifyValuePresentInList(getCommentValues(), comment);
		}
		return true;
	}

	/**
	 * Method will return list of comment value.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getCommentValues() {
		List<String> columnValues = new ArrayList<>();
		for (int i = 0; i < getCommentValueList().size(); i++) {
			columnValues.add(getCommentValueList().get(i).getText());

		}
		return columnValues;
	}

	/**
	 * This method will verify updated comment is available in comment page.
	 * 
	 * @return boolean
	 * @param comment
	 * @param updatedComment
	 * @author rahul.patil
	 */
	public boolean verifyEditComment(String comment, String updatedComment) {
		waitForLoader(getDetailViewLoader());
		getRefreshBtn().waitForEnabled();
		QMetryUtility.click(getRefreshBtn());
		waitForLoader(getDetailViewLoader());
		List<String> values = getCommentValues();
		return verifyValuePresentInList(values, updatedComment) && !verifyValuePresentInList(values, comment);
	}

	/**
	 * This method will verify filter applied or not for issue type.
	 * 
	 * @author rahul.patil
	 */
	public boolean verifyUDFValue(HashMap<String, String> data) {
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
		/*
		 * getRefreshBtn().waitForEnabled(); QMetryUtility.click(getRefreshBtn());
		 */
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
		boolean flag = true;
		for (String key : data.keySet()) {
			String optionLoc = ".//*[@title='" + key + "']/following-sibling::*//*[@title]";
			driver.findElement(By.xpath(optionLoc)).waitForVisible();
			if (!driver.findElement(By.xpath(optionLoc)).verifyText(String.valueOf(data.get(key)))) {
				return false;
			}
		}
		return flag;
	}

	/**
	 * This method will verify filter applied or not for issue type.
	 * 
	 * @author rahul.patil
	 */
	public HashMap<String, String> fillUDFData(HashMap<String, String> data) {
		HashMap<String, String> udfValueData = new HashMap<String, String>();
		HashMap<String, String> udfData = data;
		for (String key : udfData.keySet()) {
			if (key.equals(udfTypeOptions.STRING.toString())) {
				String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
						+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
						+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
				String operationLoc = "xpath=.//*[text()='" + String.valueOf(udfData.get(key))
						+ "']/following-sibling::input[@type='text']";
				driver.findElement(operationLoc).waitForEnabled();
				driver.findElement(operationLoc).clear();
				driver.findElement(operationLoc).sendKeys(randomData);
				udfValueData.put(String.valueOf(udfData.get(key)), randomData);
			}
			if (key.equals(udfTypeOptions.LARGETEXT.toString())) {
				String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
						+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
						+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
				String operationLoc = "xpath=.//*[text()[normalize-space() = '" + String.valueOf(udfData.get(key))
						+ "']]/following-sibling::*/textarea";
				driver.findElement(operationLoc).waitForEnabled();
				driver.findElement(operationLoc).sendKeys(randomData);
				udfValueData.put(String.valueOf(udfData.get(key)), randomData);
			}
			if (key.equals(udfTypeOptions.LOOKUPLIST.toString())) {
				String operationLoc = "xpath=.//*[text()='" + String.valueOf(udfData.get(key))
						+ "']/following-sibling::*";
				driver.findElement(operationLoc).waitForEnabled();
				driver.findElement(operationLoc).click();
				String locFolder = "xpath=.//p-multiselectitem//*[text()='Value_alias']";
				driver.findElement(locFolder).waitForEnabled();
				driver.findElement(locFolder).click();
				udfValueData.put(String.valueOf(udfData.get(key)), "Value_alias");
			}
			if (key.equals(udfTypeOptions.MULTILOOKUPLIST.toString())) {
				String operationLoc = "xpath=.//*[text()='" + String.valueOf(udfData.get(key))
						+ "']/following-sibling::*";
				driver.findElement(operationLoc).waitForEnabled();
				driver.findElement(operationLoc).click();
				String locFolder = "xpath=.//p-multiselectitem//*[text()='Value_alias']";
				driver.findElement(locFolder).waitForEnabled();
				driver.findElement(locFolder).click();
				udfValueData.put(String.valueOf(udfData.get(key)), "Value_alias");
			}
			if (key.equals(udfTypeOptions.NUMBER.toString())) {
				String randomData = RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
				String operationLoc = "xpath=.//*[text()='" + String.valueOf(udfData.get(key))
						+ "']/following-sibling::input[@type='number']";
				driver.findElement(operationLoc).waitForEnabled();
				driver.findElement(operationLoc).clear();
				driver.findElement(operationLoc).sendKeys(randomData);
				udfValueData.put(String.valueOf(udfData.get(key)), randomData);
			}
			if (key.equals(udfTypeOptions.DATETIMEPICKER.toString())) {
				String operationLoc = "xpath=.//*[text()='" + String.valueOf(udfData.get(key))
						+ "']/following-sibling::*//input";
				driver.findElement(operationLoc).waitForEnabled();
				driver.findElement(operationLoc).clear();
				driver.findElement(operationLoc).sendKeys(DateUtility.getDate(2, "MM-dd-yyyy"));
				udfValueData.put(String.valueOf(udfData.get(key)), DateUtility.getDate(2, "MM-dd-yyyy"));
			}
		}
		return udfValueData;
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public String getEntityApprovalStatus() {
		String optionLoc = "xpath=.//*[contains(@class,'approval-status-txt')]";
		return driver.findElement(optionLoc).getText();
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public String getEntityApprovalWarningStatus() {
		String optionLoc = "xpath=.//*[contains(@class,'approval-status-txt') and (contains(@class, 'btn-warning'))]";
		return driver.findElement(optionLoc).getText();
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public void reviewEntity() {
		getReviewEntityBtn().waitForVisible();
		getReviewEntityBtn().waitForEnabled();
		QMetryUtility.click(getReviewEntityBtn());
		getYesBtn().waitForVisible();
		QMetryUtility.click(getYesBtn());
		getReviewAcceptBtn().waitForVisible();
		getReviewAcceptBtn().waitForEnabled();
		QMetryUtility.click(getReviewAcceptBtn());
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public void approveEntity() {
		getApproveEntityBtn().waitForVisible();
		getApproveEntityBtn().waitForEnabled();
		QMetryUtility.click(getApproveEntityBtn());
		getYesBtn().waitForVisible();
		QMetryUtility.click(getYesBtn());
		getApproveAcceptBtn().waitForVisible();
		getApproveAcceptBtn().waitForEnabled();
		QMetryUtility.click(getApproveAcceptBtn());
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author rahul.patil
	 */
	public void waitForDetailWindowFieldLoader() {
		String optionLoc = "xpath=.//*[contains(@class,'details-tab')]";
		do {
		} while (driver.findElement(optionLoc).getAttribute("class").contains("disabled"));
	}

	/**
	 * This method will verify message after operation.
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 */
	public boolean verifyNotificationAtBellIcon(String projectName) {
		String message = "Project(" + projectName + ") updated successfully.";
		String locFolder = "xpath=.//*[contains(@class,'notification-box')]//*[text()='" + message + "']";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).waitForPresent();
		return driver.findElement(locFolder).verifyText(message);
	}

	/**
	 * This method will verify message after operation.
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 */
	public boolean verifyNotification() {
		String message = "You do not have sufficient rights to perform this operation.";
		String locFolder = "xpath=.//*[text()[normalize-space()='" + message + "']]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).waitForPresent();
		boolean verifiedMessage = driver.findElement(locFolder).verifyText(message);
		driver.findElement(locFolder).waitForNotPresent();
		return verifiedMessage;
	}

	/**
	 * A method to click on a 'New' button of all modules.
	 * 
	 * @param loc
	 */
	public void clickOnNewSpanish() {
		try {
			getLocNewBtnSpanish().waitForEnabled();
			QMetryUtility.click(getLocNewBtnSpanish());
		} catch (TimeoutException e) {
			driver.navigate().refresh();
			getLocNewBtnSpanish().waitForEnabled();
			QMetryUtility.click(getLocNewBtnSpanish());
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			getLocNewBtnSpanish().waitForEnabled();
			QMetryUtility.click(getLocNewBtnSpanish());
		} catch (Exception e) {
			driver.navigate().refresh();
			getLocNewBtnSpanish().waitForEnabled();
			QMetryUtility.click(getLocNewBtnSpanish());
		}
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * 
	 */
	public void waitForTableToLoadSpanish() {
		/*
		 * do { } while (!getTable().getColumnList().get(1).getAttribute("style").
		 * contains("position: relative"));
		 */
		getRefreshBtn().waitForVisible();
		getRefreshBtn().waitForEnabled();
		QMetryUtility.click(getRefreshBtn());
		getEntityCountText().waitForVisible();
		getEntityCountText().waitForEnabled();
	}

	/**
	 * This method will verify pop up message after operation.
	 * 
	 * @param message
	 * @author rahul.patil
	 */
	public boolean verifyAlertDialog(String message) {
		String locFolder = "xpath=.//*[@role='alert']";
		driver.findElement(locFolder).waitForVisible();
		return driver.findElement(locFolder).getAttribute("aria-label").equals(message);
	}

	/**
	 * This method will verify pop up message after operation.
	 * 
	 * @param message
	 * @author rahul.patil
	 */
	public boolean verifyNotificationMessage(String message) {
		String locFolder = "xpath=.//*[contains(@class,'notification-box')]//*[text()='" + message + "']";
		driver.findElement(locFolder).waitForVisible();
		return driver.findElement(locFolder).verifyText(message);
	}

	public boolean isElementPresent(QAFWebElement qafWebElement) {
		try {
			qafWebElement.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author nidhi.shah
	 */
	public void yopmailLogin(String mail) {
		Reporter.log("Yopmail Login", MessageTypes.Info);
		driver.get(ConfigurationManager.getBundle().getString("yopmail.url"));
		ClientRegistrationPage clientRegistrationPage = new ClientRegistrationPage();
		clientRegistrationPage.getEmailTxtBox().waitForEnabled();
		clientRegistrationPage.getEmailTxtBox().clear();
		clientRegistrationPage.getEmailTxtBox().sendKeys(mail);
		clientRegistrationPage.getCheckInboxBtn().waitForEnabled();
		clientRegistrationPage.getCheckInboxBtn().click();
		clientRegistrationPage.getEmailAliasTxt().verifyVisible();
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author nidhi.shah
	 */
	public void closeQQBotPredictionSection() {
		if (getQQBotPredictionHeader().isPresent()) {
			getCloseQQBotPredictionSectionBtn().waitForEnabled();
			QMetryUtility.click(getCloseQQBotPredictionSectionBtn());
		}

	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param sourcelocator
	 * @param destinationlocator
	 */
	public void dragAndDropElement(WebElement sourcelocator, WebElement destinationlocator) {
		Actions action = new Actions(new WebDriverTestBase().getDriver());
		/* action.dragAndDrop(sourcelocator, destinationlocator).build().perform(); */

		Action dragAndDrop = action.clickAndHold(sourcelocator).moveToElement(destinationlocator)
				.release(destinationlocator).build();
		dragAndDrop.perform();
	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param sourcelocator
	 * @param destinationlocator
	 */
	public void delectAllFilesStartWithFilenameFromDirectory(String fileLocation, String partialFileName) {
		File directory = new File(fileLocation);
		File[] files = directory.listFiles();
		for (File f : files) {
			if (f.getName().startsWith(partialFileName)) {
				f.delete();
			}
		}
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getSDFInsertImageButtonByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/following-sibling::*//*[@title='Insert Image'] | .//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/ancestor::*[contains(@class,'bulk-label')]/following-sibling::*//*[@title='Insert Image']";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getUDFInsertImageButtonByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/following-sibling::*//*[@title='Insert Image'] | .//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/ancestor::*[contains(@class,'bulk-label')]/following-sibling::*//*[@title='Insert Image']";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailsTabSDFInsertImageButtonByLabel(String label) {
		String locFolder1 = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*";
		driver.findElement(locFolder1).waitForVisible();
		driver.findElement(locFolder1).waitForEnabled();
		QMetryUtility.click(driver.findElement(locFolder1));
		String locFolder = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*//*[@title='Insert Image']";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailsTabSDFCheckButtonByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*//*[contains(@class,'fa-check')]/parent::*";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailsTabUDFInsertImageButtonByLabel(String label) {
		String locFolder1 = "xpath=.//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*";
		driver.findElement(locFolder1).waitForVisible();
		driver.findElement(locFolder1).waitForEnabled();
		QMetryUtility.click(driver.findElement(locFolder1));
		String locFolder = "xpath=.//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*//*[@title='Insert Image']";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getSDFImageByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/following-sibling::*//img[@src and @data-attachment-id] | .//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/ancestor::*[contains(@class,'bulk-label')]/following-sibling::*//img[@src and @data-attachment-id]";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getUDFImageByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/following-sibling::*//img[@src and @data-attachment-id] | .//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[text()='"
				+ label
				+ "']/ancestor::*[contains(@class,'bulk-label')]/following-sibling::*//img[@src and @data-attachment-id]";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailsTabSDFImageByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*//img[@src and @data-attachment-id]";
		return driver.findElement(locFolder);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailsTabUDFImageByLabel(String label) {
		String locFolder = "xpath=.//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::p-accordiontab//*[@title='"
				+ label + "']/following-sibling::*//img[@src and @data-attachment-id]";
		return driver.findElement(locFolder);
	}

	/**
	 * This method checks the show archive checkbox
	 * 
	 * @author rahul.patil, nidhi.shah
	 */
	public void enableShowOnlyShareableEntities() {
		waitForHorizontalBarToLoad();
		getLocFilterButton().waitForVisible();
		getLocFilterButton().waitForEnabled();
		QMetryUtility.click(getLocFilterButton());
		getLocFilter().selectCheckBoxByName(CheckBoxLabels.SHOW_ONLY_SHAREABLE.toString());
		waitForHorizontalBarToLoad();
		getLocNewBtn().waitForVisible();
		getLocFilterButton().waitForEnabled();
		getLocFilterButton().click();
		waitForHorizontalBarToLoad();
		/* waitForLoader(getTableLoader()); */
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 * 
	 *         changed xpath from .//label[@title='" + label +
	 *         "']/preceding-sibling::* to new one as locator is changed
	 */
	public QAFWebElement getArrangeColumnCheckboxByLabel(String label) {
		String locArrangeColumnCheckbox = "xpath=.//label[@title='" + label + "']//input";
		return driver.findElement(locArrangeColumnCheckbox);
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public boolean verityArrangeColumnCheckBoxChecked(String label) {
		return getArrangeColumnCheckboxByLabel(label).isSelected();
	}

	/**
	 * A method to log into created email account of a yopmail
	 * 
	 * @author rahul.patil
	 */
	public boolean verityArrangeColumnCheckBoxUnChecked(String label) {
		return !getArrangeColumnCheckboxByLabel(label).isSelected();
	}

	/**
	 * This method will verify message .
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 */
	public void verifyInfoMessage(String message) {
		String locFolder = "xpath=.//*[contains(text()," + "\"" + message + "\"" + ")]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).verifyVisible();
	}

	/**
	 * This method will verify notification after operation.
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 */
	public boolean verifyNotification(String message) {
		String locFolder = "xpath=.//*[text()[normalize-space()='" + message + "']]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).waitForPresent();
		boolean verifiedMessage = driver.findElement(locFolder).verifyText(message);
		driver.findElement(locFolder).waitForNotPresent();
		return verifiedMessage;
	}

	/**
	 * Method to fetch whole raw values.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public List<String> getColumnsValueList() {
		List<String> columnNames = new ArrayList<>();
		String headerLoc = "xpath=.//datatable-body-cell";
		driver.findElements(headerLoc).get(0).waitForVisible();
		int size = driver.findElements(headerLoc).size();
		for (int i = 0; i < size; i++) {
			columnNames.add(driver.findElements(headerLoc).get(i).getText());
		}

		return columnNames;
	}

	/**
	 * 
	 * A method will drag and drop element to destination point.
	 * 
	 * 
	 * 
	 * @param sourcelocator
	 * 
	 * @param destinationlocator
	 * 
	 */

	public void deleteAllFilesStartWithFilenameFromDirectory(String fileLocation, String partialFileName) {

		File directory = new File(fileLocation);
		File[] files = directory.listFiles();
		for (File f : files) {
			if (f.getName().startsWith(partialFileName)) {
				f.delete();
			}
		}
	}

	/**
	 * This method will verify pop up message after operation.
	 * 
	 * @param message
	 * @author rahul.patil
	 */
	public boolean verifyMessageContainsText(String message) {
		String locFolder = "xpath=.//*[contains(text(),'" + message + "')]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).verifyVisible();
		return driver.findElement(locFolder).verifyVisible();
	}

	/**
	 * 
	 * 
	 * This method will verify value present in CSV file.
	 * 
	 * @author rahul.patil
	 * @throws FileNotFoundException
	 * 
	 */

	public boolean verifyValueInCSVFile(String filePath, String value) throws FileNotFoundException {

		ArrayList<String> values = new ArrayList<>();
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNext()) {
			values.add(scanner.next().toString().trim().replace(",", ""));
		}

		for (String csvValue : values) {
			if (csvValue.equals(value)) {
				scanner.close();
				return true;
			}

		}
		scanner.close();
		return false;
	}

	/**
	 * This method will verify message after operation.
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 */
	public boolean verifyNotificationOfTestcaseShared(ProjectBean projectBean) {
		String message = "Test Case successfully shared to other Project(" + projectBean.getProjectName() + ").";
		String locFolder = "xpath=.//*[contains(text(),'" + message + "')]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).waitForPresent();
		boolean verifiedMessage = driver.findElement(locFolder).verifyText(message);
		driver.findElement(locFolder).waitForNotPresent();
		return verifiedMessage;
	}

	/**
	 * This method will appy Qmetry filter to requirement by priority.
	 * 
	 * @author rahul.patil
	 * @throws IOException
	 */
	public void updateValueFromTestcaseFileByColumnName(String filePath, String columnName, String value)
			throws IOException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int cols = sheet.getRow(1).getLastCellNum();
		int columnCount = 0;
		XSSFRow row = sheet.getRow(0);
		for (int c = 0; c < cols; c++) {
			XSSFCell cell = row.getCell(c);
			if (cell.getStringCellValue().equals(columnName)) {
				columnCount = c;
				break;
			}
		}
		XSSFRow row1 = sheet.getRow(1);
		row1.createCell(columnCount).setCellValue(value);
		// row1.getCell(columnCount).setCellValue(value);
		fileInputStream.close();
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnByName(String columnName) {
		int count = 0;
		String headerLoc = "xpath=.//datatable-header-cell";
		driver.findElements(headerLoc).get(0).waitForVisible();
		int size = driver.findElements(headerLoc).size();
		for (int i = 0; i < size; i++) {
			if (driver.findElements(headerLoc).get(i).getText().equals(columnName)) {
				count = count + 1;
				break;
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public String getColumnValue(String requiredColumn) {
		int count = getColumnByName(requiredColumn);
		String locMenuOption = "xpath=.//datatable-body-cell[" + count + "]";
		return driver.findElement(locMenuOption).getText();
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void collapseArrangeColumns() {
		getArrangeColumnCheck().waitForVisible();
		if (getArrangeColumnCheck().getAttribute("class").contains("open")) {
			getArrangeColumnBtn().waitForVisible();
			getArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getArrangeColumnBtn());
		}
	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param sourcelocator
	 * @param destinationlocator
	 */
	public boolean verifyFilePresentInDirectory(String fileLocation, String partialFileName) {
		File directory = new File(fileLocation);
		File[] files = directory.listFiles();
		for (File f : files) {
			if (f.getName().startsWith(partialFileName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks the show archive checkbox
	 * 
	 * @author rahul.patil
	 */
	public boolean verifyArrangeColumnStatus(ArrayList<String> columnStatus, boolean isChecked) {
		if (isChecked == true) {
			for (String columnName : columnStatus) {
				if (verityArrangeColumnCheckBoxChecked(columnName) == false) {
					return false;
				}
			}
		} else if (isChecked == false) {
			for (String columnName : columnStatus) {
				if (verityArrangeColumnCheckBoxUnChecked(columnName) == false) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method with navigate to tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author rahul.patil
	 */
	public void closeQQBotSection() {
		// String tabToNav = "xpath=.//*[text()='QQbot Prediction']";
		String tabToNav = "xpath=.//*[text()[normalize-space() = 'QQbot Prediction']]";
		if (driver.findElement(tabToNav).isPresent()) {
			String qq = "xpath=.//*[@title='QQBot']";
			if (driver.findElement(qq).isPresent()) {
			} else {
				// String tabToadaNav = "xpath=.//*[text()='QQbot
				// Prediction']/ancestor::section/preceding-sibling::*/*[contains(@class,'fa-close')]";
				String tabToadaNav = "xpath=.//*[text()[normalize-space() = 'QQbot Prediction']]/ancestor::section/preceding-sibling::*";
				driver.findElement(tabToadaNav).click();
				driver.findElement(qq).waitForVisible();
			}
		}
	}

	/**
	 * This method with navigate to tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author rahul.patil
	 */
	public QAFWebElement getTooltipEntityOperation(String operation) {
		String tabToNav = "xpath=.//*[contains(@class,'tooltip')]//*[@title='" + operation + "']";
		return driver.findElement(tabToNav);

	}

	/**
	 * This method will appy Qmetry filter to requirement by priority.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getListOfAddMoreFilterOptions() {
		expandFilter();
		getLocFilter().clearFilter();
		waitForHorizontalBarToLoad();
		getLocFilter().getAddMoreFiltersBtn().waitForVisible();
		getLocFilter().getAddMoreFiltersBtn().waitForEnabled();
		QMetryUtility.click(getLocFilter().getAddMoreFiltersBtn());
		List<String> filterOptions = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//*[@role='listbox']//ancestor::li";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			filterOptions.add(driver.findElements(filterOptionsLoc).get(i).getAttribute("aria-label"));
		}
		return filterOptions;
	}

	/**
	 * This method with navigate to tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author rahul.patil
	 */
	public boolean verifyEntitySummaryFromDetailsView(String summary) {
		String tabToNav = "xpath=.//h2[contains(@class,'summary-name')]//*[contains(@class,'text-overflow')]";
		return driver.findElement(tabToNav).verifyAttribute("title", summary);

	}

	/**
	 * This method with navigate to tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author rahul.patil
	 */
	public List<String> getEntityDetailsWindowTabs() {
		List<String> columnValues = new ArrayList<>();
		String listOfTbsLoc = ".//*[contains(@class,'ui-tabview-nav')]/*";
		int size = driver.findElements(By.xpath(listOfTbsLoc)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(driver.findElements(By.xpath(listOfTbsLoc)).get(i).getText());
		}
		return columnValues;

	}

	/**
	 * This method with navigate to tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author rahul.patil
	 */
	public QAFWebElement getEntityDetailsWindowOperationTool(String operation) {
		String toolTipEntityOperationLoc = "xpath=.//*[contains(@class,'wide-tooltip')]//*[@title='" + operation + "']";
		return driver.findElement(toolTipEntityOperationLoc);
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getDropdownMenu() {
		List<String> dropDownMenus = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//ul[contains(@class,'dropdown-menu')]/li[@role='menuitem']";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			dropDownMenus.add(driver.findElements(filterOptionsLoc).get(i).getText().trim());
		}
		return dropDownMenus;
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement selectDropdownMenu(String menu) {
		String filterOptionsLoc = "xpath=.//ul[contains(@class,'dropdown-menu')]//li[@role='menuitem']/a[text()[normalize-space() = '"
				+ menu + "']]";
		return driver.findElement(filterOptionsLoc);
	}

	/**
	 * This method will expand entity details window filter.
	 * 
	 * @author rahul.patil
	 */
	public void expandEntityDetailsWindowFilter() {
		if (getEntityDetailsWindowFilterBtn().isPresent()) {
			getEntityDetailsWindowFilterBtn().waitForVisible();
			QMetryUtility.click(getEntityDetailsWindowFilterBtn());
			waitForFilterToLoad();
		}
	}

	/**
	 * This method will clear entity details window filter.
	 * 
	 * @author rahul.patil
	 */
	public void clearEntityDetailsWindowFilter() {
		getClearEntityDetailsWindowFilterBtn().waitForVisible();
		QMetryUtility.click(getClearEntityDetailsWindowFilterBtn());
		waitForFilterToLoad();
	}

	/**
	 * This method will clear entity details window filter.
	 * 
	 * @author rahul.patil
	 */
	public void performFilterOperationOnDetailsWindowsEntity(String filterBy, String filterValue) {
		String filterOptionsLoc = "xpath=.//*[text()='" + filterBy + "']/following-sibling::*";
		if (driver.findElement(filterOptionsLoc).getTagName().equals("input")) {
			driver.findElement(filterOptionsLoc).sendKeys(filterValue);
		} else if (driver.findElement(filterOptionsLoc).getTagName().equals("p-multiselect")) {
			filterOptionsLoc = "xpath=.//*[text()='" + filterBy + "']/following-sibling::*/*";
			driver.findElement(filterOptionsLoc).waitForVisible();
			if (!driver.findElement(filterOptionsLoc).getAttribute("class").contains("open")) {
				driver.findElement(filterOptionsLoc).waitForVisible();
				driver.findElement(filterOptionsLoc).waitForEnabled();
				QMetryUtility.click(driver.findElement(filterOptionsLoc));
			}
			String value = "xpath=.//p-multiselectitem//*[contains(text(),'" + filterValue + "')]";
			driver.findElement(value).waitForEnabled();
			QMetryUtility.click(driver.findElement(value));
			QMetryUtility.click(driver.findElement(filterOptionsLoc));
		}
		waitForFilterToLoad();
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public String getEntityFolderPathFromDetailWindow() {
		String filterOptionsLoc = "xpath=.//*[contains(@class,'breadcrumb')]//*[@title and contains(@class,'ellipsis')]";
		return driver.findElement(filterOptionsLoc).getAttribute("title");
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public String getEntityVersionFromDetailWindow() {
		String filterOptionsLoc = "xpath=.//p-multiselect[@name='version']/*";
		return driver.findElement(filterOptionsLoc).getText();
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public void selectEntityVersionFromDetailWindow(String version) {
		String filterOptionsLoc = "xpath=.//p-multiselect[@name='version']/*";
		if (!driver.findElement(filterOptionsLoc).getAttribute("class").contains("open")) {
			driver.findElement(filterOptionsLoc).waitForEnabled();
			QMetryUtility.click(driver.findElement(filterOptionsLoc));
		}
		String filterOptionsLoc1 = "xpath=.//p-multiselect[@name='version']/*//*[@onoverlayanimationend]//p-multiselectitem/li[contains(@aria-label,'"
				+ version + "')]";
		driver.findElement(filterOptionsLoc1).waitForEnabled();
		QMetryUtility.click(driver.findElement(filterOptionsLoc1));
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author rahul.patil
	 */
	public void waitForFilterToLoad() {
		String locFolder = "xpath=(.//*[contains(@class,'inside-tab-loader')]/following-sibling::*)[1]";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getFolderRightClickDropdownMenu() {
		List<String> dropDownMenus = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//*[contains(@class,'contextmenu')]//li[contains(@class,'menuitem')]";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			dropDownMenus.add(driver.findElements(filterOptionsLoc).get(i).getText());
		}
		return dropDownMenus;
	}

	/**
	 * This method with select folder to perform clone operation
	 * 
	 * @param module
	 * @author rahul.patil
	 */
	public List<String> getDestinationModulesForFolderCloneOperation() {
		String locButtonDropDown = "xpath=(.//label[text()='Destination Module']/following-sibling::p-multiselect)[1]";
		driver.findElement(locButtonDropDown).waitForEnabled();
		driver.findElement(locButtonDropDown).click();
		String dropDown = "xpath=.//ul[@role='listbox']";
		driver.findElement(dropDown).waitForVisible();
		String firstModule = "xpath=(.//*[@role='listbox']//li)[1]";
		if (driver.findElement(firstModule).getAttribute("class").contains("highlight")) {
			driver.findElement(firstModule).waitForEnabled();
			driver.findElement(firstModule).click();
		}
		String moduleList = "xpath=.//*[@role='listbox']//li";
		int size = driver.findElements(moduleList).size();
		List<String> dropDownMenus = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			dropDownMenus.add(driver.findElements(moduleList).get(i).getAttribute("aria-label"));
		}
		return dropDownMenus;
	}

	/**
	 * This method will verify list of values present in a list.
	 * 
	 * @param listValues
	 * @param requiredValues
	 * @author rahul.patil
	 * @return boolean
	 */
	public boolean verifyList(List<String> listValues, List<String> requiredValues) {
		boolean flag = true;
		for (int i = 0; i < listValues.size(); i++) {
			if (!listValues.get(i).equals(requiredValues.get(i))) {
				return false;
			}
		}
		return flag;
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void switchAttachmentView(String view) {
		String filterOptionsLoc = "xpath=.//*[contains(@class,'attachment-view-icons')]//*[@title='" + view
				+ "']/parent::*";
		if (!driver.findElement(filterOptionsLoc).getAttribute("class").contains("active")) {
			driver.findElement(filterOptionsLoc).waitForVisible();
			driver.findElement(filterOptionsLoc).waitForEnabled();
			QMetryUtility.click(driver.findElement(filterOptionsLoc));
			// waitForTabLoader();
		}
	}

	public void expandFolder(String folderName) {
		String locSubFolder = "xpath=.//*[@aria-label='" + folderName + "']//*[contains(@class,'right')]";
		if (driver.findElement(locSubFolder).isPresent()) {
			driver.findElement(locSubFolder).waitForVisible();
			driver.findElement(locSubFolder).waitForEnabled();
			QMetryUtility.click(driver.findElement(locSubFolder));
		}

	}

	public void expandFolderWithExpandAvailability(String folderName) {
		String locSubFolder = "xpath=.//*[@aria-label='" + folderName + "']//*[contains(@class,'right')]";
		String locExpand = "xpath=.//*[@aria-label='" + folderName + "']";
		if (driver.findElement(locExpand).getAttribute("aria-expanded").equals("false")) {
			driver.findElement(locSubFolder).waitForVisible();
			driver.findElement(locSubFolder).waitForEnabled();
			QMetryUtility.click(driver.findElement(locSubFolder));
		}

	}

	public QAFWebElement getCloneFolderStructureSourceModuleFolder(String folderName) {
		String locSubFolder = "xpath=(.//label[text()='Source Module'])[1]/parent::*/following-sibling::*//*[@role='treeitem' and @aria-label='"
				+ folderName + "']";
		return driver.findElement(locSubFolder);
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getCloneFolderStructureSourceModuleFolderList() {
		List<String> dropDownMenus = new ArrayList<>();
		String filterOptionsLoc = "xpath=(.//label[text()='Source Module'])[1]/parent::*/following-sibling::*//*[@role='treeitem' and @aria-label]";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			dropDownMenus.add(driver.findElements(filterOptionsLoc).get(i).getText());
		}
		return dropDownMenus;
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public void jiraLogin() {
		String filterOptionsLoc = "xpath=.//a[text()='Log In']";
		driver.findElement(filterOptionsLoc).waitForVisible();
		driver.findElement(filterOptionsLoc).click();
		String userLoc = "xpath=.//input[@id='login-form-username']";
		driver.findElement(userLoc).waitForVisible();
		driver.findElement(userLoc).sendKeys("admin");
		String passLoc = "xpath=.//input[@id='login-form-password']";
		driver.findElement(passLoc).waitForVisible();
		driver.findElement(passLoc).sendKeys("ispl123#");
		String Loc = "xpath=.//input[@id='login-form-submit']";
		driver.findElement(Loc).waitForVisible();
		driver.findElement(Loc).click();
	}

	/**
	 * This method will wait for table to enable . Not applicable for all table .
	 * Before using it, check for class contains disabled text.
	 * 
	 * @author rahul.patil
	 */
	public void waitForTableToEnable() {
		do {
		} while (getLocTable().getAttribute("class").contains("disabled"));
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getTabList() {
		List<String> tablists = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//ul[contains(@class,'tabview-nav')]/li";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			tablists.add(driver.findElements(filterOptionsLoc).get(i).getText());
		}
		return tablists;
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public int getPositionOfTab(List<String> tabList, String tabName) {
		int position = 0;
		for (int i = 0; i < tabList.size(); i++) {
			if (tabList.get(i).equals(tabName)) {
				position = i + 1;
				break;
			}
		}
		return position;
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public String getSelectedDateFromCalender() {
		getSelectedDateCalenderText().waitForVisible();
		String dateValue = getSelectedDateCalenderText().getText();
		if (dateValue.length() == 1) {
			dateValue = "0" + dateValue;
		}
		return dateValue + " " + new Select(getCalenderMonthSelect()).getFirstSelectedOption().getText() + " "
				+ new Select(getCalenderYearSelect()).getFirstSelectedOption().getText();
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 * @throws IOException
	 */
	/*
	 * public String getPDFFileText(String fileWithLocation) throws IOException { //
	 * Loading an existing document File file = new File(fileWithLocation);
	 * PDDocument document = PDDocument.load(file);
	 * 
	 * // Instantiate PDFTextStripper class PDFTextStripper pdfStripper = new
	 * PDFTextStripper();
	 * 
	 * // Retrieving text from PDF document String pdfText =
	 * pdfStripper.getText(document);
	 * 
	 * // Closing the document document.close();
	 * 
	 * return pdfText;
	 * 
	 * }
	 */

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public void requestChangeForEntity(String remark) {
		getRequestChangeBtn().waitForVisible();
		getRequestChangeBtn().waitForEnabled();
		QMetryUtility.click(getRequestChangeBtn());
		getRequestChangeHeader().waitForVisible();
		getRequestChangeAdditionalRemarkTxtArea().sendKeys(remark);
		getRequestChangeAcceptBtn().waitForVisible();
		getRequestChangeAcceptBtn().waitForEnabled();
		QMetryUtility.click(getRequestChangeAcceptBtn());
		getRequestChangeAcceptBtn().waitForNotVisible();
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public boolean isVerticalScrollBarPresentForElement(QAFWebElement element) {
		String JS_ELEMENT_IS_SCROLLABLE = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Boolean isScrollable = (Boolean) jse.executeScript(JS_ELEMENT_IS_SCROLLABLE, element);
		return isScrollable;
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement element1() {
		String filterOptionsLoc = "xpath=.//*[text()[normalize-space() = 'System Fields'] and @data-draggable]/ancestor::*[@role='tab']/following-sibling::*[@role='tabpanel']//*[@title='Execution Command']";
		return driver.findElement(filterOptionsLoc);
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement element2(String value) {
		String filterOptionsLoc = "xpath=.//*[text()[normalize-space() = 'User Defined Fields'] and @data-draggable]/ancestor::*[@role='tab']/following-sibling::*[@role='tabpanel']//*[@title='"
				+ value + "']/ancestor::*[@data-container-type='field']/following-sibling::*";
		return driver.findElement(filterOptionsLoc);
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getDetailTabSDFList() {
		List<String> tablists = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//*[text()[normalize-space() = 'System Fields']]/ancestor::div[contains(@class,'p-accordion-header')]/following-sibling::*//*[contains(@class,'text-label')]";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			tablists.add(driver.findElements(filterOptionsLoc).get(i).getAttribute("title"));
		}
		return tablists;
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getDetailTabUDFList() {
		List<String> tablists = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//*[text()[normalize-space() = 'User Defined Fields']]/ancestor::div[contains(@class,'p-accordion-header')]/following-sibling::*//*[contains(@class,'text-label')]";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			tablists.add(driver.findElements(filterOptionsLoc).get(i).getAttribute("title"));
		}
		return tablists;
	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param sourcelocator
	 * @param destinationlocator
	 */
	public String getFileNamePresentInDirectoryWithKnownPartialFileName(String fileLocation, String partialFileName) {
		File directory = new File(fileLocation);
		File[] files = directory.listFiles();
		String fileName = null;
		for (File f : files) {
			if (f.getName().startsWith(partialFileName)) {
				fileName = f.getName();
				return fileName;
			}
		}
		return fileName;
	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param fileLocation
	 * @param value
	 * @throws IOException
	 */
	public String getTextFileContent(String fileLocation) throws IOException {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileLocation)));
		return data;
	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param regex
	 * @param value
	 */
	public boolean isInputStringMachesWithRegex(String regex, String value) {
		return Pattern.matches(regex, value);
	}

	public boolean verifyPaginationbyInput(String no) {
		String loc = "xpath=.//*[contains(@class,'page-link')][text()='" + no + "']//parent::li";
		return driver.findElement(loc).getAttribute("class").contains("active");
	}

	/**
	 * This method with navigate in tab based on name provided as argument.
	 * 
	 * @param tabName
	 * @author priyanka.devaliya
	 */
	public void navigateInTab(String tabName) {
		String tabToNav = "xpath=.//*[@class='p-tabview-nav']//*[text()='" + tabName + "']/parent::a";
		driver.findElement(tabToNav).waitForVisible();
		driver.findElement(tabToNav).waitForEnabled();
		driver.findElement(tabToNav).click();
	}

	/**
	 * This method with select user to add as watcher
	 * 
	 * @param username
	 * @author priyanka.devaliya
	 */
	public void selectUsersToAddAsWatcher(List user) {
		Iterator iterator = user.iterator();
		while (iterator.hasNext()) {
			String locUsername = "xpath=.//span[text()[normalize-space()='" + iterator.next() + "']]";
			driver.findElement(locUsername).waitForEnabled();
			QMetryUtility.click(driver.findElement(locUsername));
		}
	}

	/**
	 * This method will wait for watchers table .
	 * 
	 * @param tabName
	 * @author priyanka.devaliya
	 */
	public void waitForwatcherTableToEnable() {
		String loc = "xpath=.//table/parent::div";
		driver.findElement(loc).waitForVisible();
		driver.findElement(loc).waitForEnabled();
	}

	/**
	 * This method will click on bulk move btn.
	 * 
	 * @param folderName
	 * @author priyanka.devaliya
	 */
	public void click_on_bulk_move(String folderName) {
		String loc = "xpath=.//*[@aria-label='" + folderName + "']";
		rightClickOnElement(loc);
		String stext = "xpath=.//*[text()='Bulk Move']";
		driver.findElement(stext).click();

	}

	/**
	 * This method will click on bulk copy btn.
	 * 
	 * @param folderName
	 * @author priyanka.devaliya
	 */
	public void click_on_bulk_copy(String folderName) {
		String loc = "xpath=.//*[@aria-label='" + folderName + "']";
		rightClickOnElement(loc);
		String stext = "xpath=.//*[text()='Bulk Copy']";
		driver.findElement(stext).click();

	}

	/**
	 * This method will verify pop up message after operation.
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 * @return
	 */
	public boolean verifyTextValuePresent(String value) {
		String locFolder = "xpath=.//*[contains(text(),'" + value + "')]";
		driver.findElement(locFolder).waitForVisible();
		return driver.findElement(locFolder).verifyVisible();

	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author priyanka.devaliya
	 */
	public void waitForReleaseCycleTableToLoad() {
		String locFolder = "xpath=//app-release-cycle-association/loader/following-sibling::*";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author priyanka.devaliya
	 */
	public void rightclickOnsidebar(String sidebarMenuOptions) {
		String locMenuOption = ".//*[@role='navigation']//*[text()='" + sidebarMenuOptions + "']";
		driver.findElement(By.xpath(locMenuOption)).waitForVisible();
		driver.findElement(By.xpath(locMenuOption)).waitForEnabled();
		String clicklnk = Keys.chord(Keys.CONTROL, Keys.ENTER);
		driver.findElement(By.xpath(locMenuOption)).sendKeys(clicklnk);
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author priyanka.devaliya
	 */
	public void switchToWindow(String oldTab) {
		driver.close();
		driver.switchTo().window(oldTab);
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	/**
	 * A method to go to copied sorce folder
	 * 
	 * @param folderName
	 * @author priyanka.devaliya
	 */
	public void goTocopiedSourceFolder(String folderName) {
		String locFolder = "xpath=(.//*[@title='" + folderName + "'])[2]";
		driver.findElement(locFolder).waitForVisible();
		driver.findElement(locFolder).waitForEnabled();
		QMetryUtility.click(driver.findElement(locFolder));
	}

	/**
	 * This method will select column and save arrange column setting.
	 * 
	 * @param columnNames
	 * @author priyanka.devaliya
	 */
	public void checkColumnAndSaveForStep(HashMap<String, Boolean> data) {
		for (String key : data.keySet()) {
			if (Boolean.valueOf(data.get(key)) == true) {
				String locColumn = "xpath=.//div[@aria-hidden='false']//label[text()[normalize-space() = '" + key
						+ "']]/input";
				driver.findElement(locColumn).waitForVisible();
				if (!driver.findElement(locColumn).isSelected()) {
					driver.findElement(locColumn).waitForEnabled();
					QMetryUtility.click(driver.findElement(locColumn));
				}
			} else if (Boolean.valueOf(data.get(key)) == false) {
				String locColumn = "xpath=.//div[@aria-hidden='false']//label[text()[normalize-space() = '" + key
						+ "']]/input";
				driver.findElement(locColumn).waitForVisible();
				if (driver.findElement(locColumn).isSelected()) {
					driver.findElement(locColumn).waitForEnabled();
					QMetryUtility.click(driver.findElement(locColumn));
				}
			}
		}
		getSaveArrangeStepColumnBtn().waitForEnabled();
		QMetryUtility.click(getSaveArrangeStepColumnBtn());

	}

	/**
	 * This method will verify pop up message after operation.
	 * 
	 * @param message
	 * @author priyanka.devaliya
	 * @return
	 */
	public boolean verifyMessageContainText(String message) {
		String locFolder = "xpath=.//*[contains(text(),'" + message + "')]";
		driver.findElement(locFolder).waitForVisible();
		return driver.findElement(locFolder).verifyVisible();

	}

	/**
	 * This method will retrive contenet of CSV file in key value pair.
	 * 
	 * @param filePath
	 * @param columnList
	 * @author priyanka.devaliya
	 * @return
	 */
	public HashMap<Integer, HashMap<String, String>> getCSVFileContent(String filePath, ArrayList<String> columnList)
			throws FileNotFoundException {
		ArrayList<String> values = new ArrayList<>();
		HashMap<Integer, List<String>> csvFileData = new HashMap<>();
		HashMap<Integer, HashMap<String, String>> finalData = new HashMap<>();
		Scanner scanner = new Scanner(new File(filePath));
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			String value = scanner.next().trim();
			values.add(value);
		}
		scanner.close();
		int recordCount = (values.size() / columnList.size()) - 1;
		if (values.subList(0, columnList.size()).equals(columnList)) {
			for (int i = 1; i <= recordCount; i++) {
				csvFileData.put(i, values.subList((columnList.size() * i), (columnList.size() * (1 + i))));
			}
		}
		for (int i = 0; i < csvFileData.size(); i++) {
			HashMap<String, String> data = new HashMap<>();
			for (int j = 0; j < columnList.size() - 1; j++) {
				data.put(columnList.get(j), csvFileData.get(i + 1).get(j));
			}
			finalData.put(i + 1, data);
		}
		return finalData;
	}

	/**
	 * This method will get related data from hashap.
	 * 
	 * @param data
	 * @param key
	 * @param value
	 * @author rahul.patil
	 * @return
	 */
	public HashMap<String, String> getRelatedDataFromList(HashMap<Integer, HashMap<String, String>> data, String key,
			String value) {
		for (Integer dataValues : data.keySet()) {
			if (data.get(dataValues).get(key).equals(value)) {
				return data.get(dataValues);
			}
		}
		return null;
	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param sourcelocator
	 * @param destinationlocator
	 * @return
	 */
	public boolean verifyDownloadedFilenameFromDirectory(String fileLocation, String FileName) {
		File directory = new File(fileLocation);
		File[] files = directory.listFiles();
		boolean flag = false;
		for (File f : files) {
			if (f.getName().startsWith(FileName)) {
				Reporter.log("############" + f.getName());
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void VerifyScrollBar() throws Exception {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		if (test == true) {
			System.out.print("Scrollbar is present.");
		} else if (test == false) {
			System.out.print("Scrollbar is not present.");
		}
	}

	/**
	 * A method to check if sidebar is expanded
	 * 
	 * @author priyanka.devaliya
	 */
	public Boolean isExpanded() {
		return getCollapseMenuIcon().isPresent();
	}

	/**
	 * A method to check if sidebar is collapsed
	 * 
	 * @author priyanka.devaliya
	 */
	public Boolean isCollapsed() {
		return getExpandMenuIcon().isPresent();
	}

	/**
	 * A method to Expand the sidebar
	 * 
	 * @author priyanka.devaliya
	 */
	public void expandSidebar() {
		if (!isExpanded()) {
			getExpandMenuIcon().waitForEnabled();
			QMetryUtility.click(getExpandMenuIcon());
		}
		getCollapseMenuIcon().waitForPresent();
		getCollapseMenuIcon().verifyPresent();

	}

	/**
	 * A method to close the Sidebar
	 * 
	 * @author priyanka.devaliya
	 */
	public void collapseSidebar() {
		if (isExpanded()) {
			getCollapseMenuIcon().waitForEnabled();
			getCollapseMenuIcon().click();
		}
		getExpandMenuIcon().waitForPresent();
		getExpandMenuIcon().verifyPresent();
	}

	public void openNewTab() {
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open()");

		// getting all the window handles currently available
		// switching to the opened tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// opening the URL saved
		driver.get("https://qtm8-qacloud.qmetry.com/");

	}

	public void quit() {
		driver.quit();
	}

	/**
	 * Method to click sidebar option
	 * 
	 * @param sidebarMenuOptions
	 * @author priyanka.devaliya
	 */
	public void selectMenuOptionByIcon(String sidebarMenuOptions) {
		String locMenuOption = ".//*[@role='navigation']//*[@title='" + sidebarMenuOptions + "']";
		driver.findElement(By.xpath(locMenuOption)).waitForVisible();
		driver.findElement(By.xpath(locMenuOption)).waitForEnabled();
		QMetryUtility.click(driver.findElement(By.xpath(locMenuOption)));
	}

	/**
	 * This method will add attachment for entity based upon file provided as an
	 * argument.
	 * 
	 * @param file
	 * @author priyanka.devaliya
	 */
	public void addAttachmentWithPreview(String file) {
		getAddAttachmentBtn().waitForVisible();
		getAddAttachmentBtn().waitForEnabled();
		QMetryUtility.click(getAddAttachmentBtn());
		getSelectFileTxtBox().waitForEnabled();
		getSelectFileTxtBox().sendKeys(file);
		getPreviewAttachment().waitForVisible();
		getPreviewAttachment().waitForEnabled();
		getPreviewAttachment().click();
		getClosePreviewAttachmentBtn().waitForVisible();
		getClosePreviewAttachmentBtn().waitForEnabled();
		getClosePreviewAttachmentBtn().click();
		getAddFileBtn().waitForEnabled();
		QMetryUtility.click(getAddFileBtn());
		getAddFileBtn().waitForNotVisible();
		waitForTabLoader();
	}

	public void deleteAttachmentAtStripView(String file) {
		String locdelete = ".//*[contains(@title,'" + file
				+ "')]/ancestor::*/*[contains(@class,'item-actions')]//*[@title='Delete']";
		driver.findElement(By.xpath(locdelete)).waitForVisible();
		driver.findElement(By.xpath(locdelete)).waitForEnabled();
		driver.findElement(By.xpath(locdelete)).click();
		getYesBtn().waitForEnabled();
		getYesBtn().click();

	}

	public QAFWebElement downloadAttachmentAtStripView(String file) {
		String locdelete = ".//*[contains(@title,'" + file
				+ "')]/ancestor::*/*[contains(@class,'item-actions')]//*[@title='Download']";
		// driver.findElement(By.xpath(locdelete)).waitForVisible();
		driver.findElement(By.xpath(locdelete)).waitForEnabled();
		return driver.findElement(By.xpath(locdelete));

	}

	public void hoverAtPreview(String file) {
		String locdelete = ".//*[contains(@title,'" + file + "')]";
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.xpath(locdelete)).waitForVisible();
		driver.findElement(By.xpath(locdelete)).waitForEnabled();
		QMetryUtility.moveMouseOnElement(driver.findElement(By.xpath(locdelete)));

	}

	public void preivewAttachmentAtListView(String file) {
		String locdelete = ".//*[contains(@title,'" + file + "')]";
		driver.findElement(By.xpath(locdelete)).waitForVisible();
		driver.findElement(By.xpath(locdelete)).waitForEnabled();
		QMetryUtility.click(driver.findElement(By.xpath(locdelete)));

	}

	public void preivewAttachmentAtStripView(String file) {
		String locdelete = ".//*[contains(@title,'" + file + "')]";
		driver.findElement(By.xpath(locdelete)).waitForVisible();
		driver.findElement(By.xpath(locdelete)).waitForEnabled();
		QMetryUtility.click(driver.findElement(By.xpath(locdelete)));

	}

	public boolean verifyAttachmentIconAtThumbnail(String attachmentIcon) {
		String locIcon = ".//*[contains(@class,'" + attachmentIcon + "')]";
		driver.findElement(By.xpath(locIcon)).waitForVisible();
		driver.findElement(By.xpath(locIcon)).waitForEnabled();

		return driver.findElement(By.xpath(locIcon)).isDisplayed();
	}

	/**
	 * This method will add attachment for entity based upon file provided as an
	 * argument.
	 * 
	 * @param file
	 * @author priyanka.devaliya
	 */
	public void addAttachmentWithPreview(String file, String attachmentIcon) {
		getAddAttachmentBtn().waitForVisible();
		getAddAttachmentBtn().waitForEnabled();
		QMetryUtility.click(getAddAttachmentBtn());
		getSelectFileTxtBox().waitForEnabled();
		getSelectFileTxtBox().sendKeys(file);
		getPreviewAttachment().waitForVisible();
		getPreviewAttachment().waitForEnabled();
		getPreviewAttachment().click();
		int fileLength = file.split("/").length;
		String fileName = file.split("/")[fileLength - 1];
		verifypreviewFileOpened(fileName);
		getClosePreviewAttachmentBtn().waitForVisible();
		getClosePreviewAttachmentBtn().waitForEnabled();
		getClosePreviewAttachmentBtn().click();
		verifyAttachmentIconAtThumbnail(attachmentIcon);
		getAddFileBtn().waitForEnabled();
		QMetryUtility.click(getAddFileBtn());
		getAddFileBtn().waitForNotVisible();
		waitForTabLoader();
	}

	public boolean verifypreviewFileOpened(String fileName) {
		String loctxt = ".//div[contains(@class,'mediaViewPopUpCHFileData')]//*[contains(text(),'" + fileName + "')]";
		driver.findElement(By.xpath(loctxt)).waitForVisible();
		return driver.findElement(By.xpath(loctxt)).isDisplayed();

	}

	/**
	 * A enum for Options
	 *
	 * @author priyanka.devaliya
	 */
	public enum AttachmentIcons {
		IMAGE("asv-item-img"), TXT_CODE("attachment-icon-code"), MISC("attachment-icon-misc"),
		EXCEL("attachment-icon-excel"), VIDEO("attachment-icon-media"), WORD("attachment-icon-word"),
		PDF("attachment-icon-pdf");

		private String attachmentIcon;

		private AttachmentIcons(String attachmentIcon) {
			this.attachmentIcon = attachmentIcon;
		}

		@Override
		public String toString() {
			return attachmentIcon;
		}
	}

	public QAFWebElement getQQBotBulbCount(String count) {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String loc = "xpath=.//*[@title='QQBot']/parent::*//*[contains(@class,'bulb')][text()[normalize-space()='"
				+ count + "']]";
		driver.findElement(loc).waitForVisible();
		driver.findElement(loc).waitForEnabled();
		return driver.findElement(loc);
	}

	public void selectQQbotPredictionToAutoDisplay(boolean isCheck) {
		if (isCheck == true) {
			getQQbotPredicationAutoDisplaySwitch().waitForVisible();
			if (!getInputQQbotPredicationAutoDisplay().isSelected()) {
				getQQbotPredicationAutoDisplaySwitch().waitForEnabled();
				QMetryUtility.click(getQQbotPredicationAutoDisplaySwitch());
				getYesBtn().waitForVisible();
				QMetryUtility.click(getYesBtn());
				getQQbotPredicationAutoDisplaySwitch().waitForEnabled();
				getInputQQbotPredicationAutoDisplay().waitForSelected();
			}
		} else {
			if (isCheck == false) {
				getQQbotPredicationAutoDisplaySwitch().waitForVisible();
				if (getInputQQbotPredicationAutoDisplay().isSelected()) {
					getQQbotPredicationAutoDisplaySwitch().waitForVisible();
					getQQbotPredicationAutoDisplaySwitch().waitForEnabled();
					QMetryUtility.click(getQQbotPredicationAutoDisplaySwitch());
					getInputQQbotPredicationAutoDisplay().waitForNotSelected();
				}
			}
		}
	}

	public QAFWebElement getDuplicateEntityKey(String entityKey) {
		String locEntityKey = ".//a[text()[normalize-space() ='" + entityKey + "']]";
		driver.findElement(By.xpath(locEntityKey)).waitForVisible();
		driver.findElement(By.xpath(locEntityKey)).waitForEnabled();
		return driver.findElement(By.xpath(locEntityKey));
	}

	public QAFWebElement getDuplicateMatchingPercentage(String entityKey) {
		String locEntityKey = ".//a[text()[normalize-space() ='" + entityKey + "']]/parent::*/span";
		driver.findElement(By.xpath(locEntityKey)).waitForVisible();
		driver.findElement(By.xpath(locEntityKey)).waitForEnabled();
		return driver.findElement(By.xpath(locEntityKey));
	}

	public QAFWebElement navigateToDuplicateTab() {
		String locDuplicateTab = ".//*[contains(text(),'QQbot has predicted that following')]";
		driver.findElement(By.xpath(locDuplicateTab)).waitForVisible();
		driver.findElement(By.xpath(locDuplicateTab)).waitForEnabled();
		driver.findElement(By.xpath(locDuplicateTab)).click();
		return driver.findElement(By.xpath(locDuplicateTab));
	}

	/**
	 * Method to wait for a loader to be hidden.
	 * 
	 * @param element
	 * @author priyanka.devaliya
	 */
	public void waitForQQBotTabLoader() {
		String locFolder = "xpath=.//*[contains(@class,'similar-entity-holder')]/div";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * Archive duplicate
	 * 
	 * @param entityKey
	 * @author priyanka.devaliya
	 */
	public void ArchiveDuplicate(String entityKey) {
		// String locEntity = "xpath=.//a[text()[normalize-space() ='" + entityKey
		// + "']]/ancestor::*/preceding-sibling::*/*[@title='Archive']/parent::*";
		String locEntity = "xpath=.//*[@title='Archive']";
		driver.findElement(locEntity).waitForVisible();
		driver.findElement(locEntity).waitForEnabled();
		QMetryUtility.click(driver.findElement(locEntity));
		// QMetryUtility.click(driver.findElement(locEntity));
		getYesBtn().waitForVisible();
		getYesBtn().waitForEnabled();
		getYesBtn().click();
	}

	/**
	 * Archive entity at QQBOT
	 * 
	 * @param entityKey
	 * @author priyanka.devaliya
	 */
	public boolean verifyArchivedEntityAtQQBOtTab(String entityKey) {
		String locEntityKey = ".//*[text()[normalize-space() ='" + entityKey + "']]";
		return driver.findElement(By.xpath(locEntityKey)).isDisplayed();
	}

	/**
	 * This method will perform copy operation on folder.
	 * 
	 * @param sourceFolderName
	 * @param destinationFolderName
	 * @author rahul.patil
	 */
	public void performCopyOperationOnFolder(String sourceFolderName, String destinationFolderName) {
		selectOperationForFolder("Bulk Move/Copy");
		String eleOption = "xpath=.//*[@title='" + sourceFolderName + "']";
		driver.findElement(eleOption).waitForVisible();
		driver.findElement(eleOption).waitForEnabled();
		QMetryUtility.clickUsingActions(driver.findElement(eleOption));
		getNextBtn().waitForEnabled();
		QMetryUtility.clickUsingActions(getNextBtn());
		String destFolder = "xpath=.//*[@title='" + destinationFolderName + "']";
		driver.findElement(destFolder).waitForVisible();
		driver.findElement(destFolder).waitForEnabled();
		QMetryUtility.clickUsingActions(driver.findElement(destFolder));
		getCopyFolderBtn().waitForEnabled();
		QMetryUtility.click(getCopyFolderBtn());
	}

	/**
	 * This method will perform copy operation on folder.
	 * 
	 * @param sourceFolderName
	 * @param destinationFolderName
	 * @author rahul.patil
	 */
	public void performMoveOperationOnFolder(String sourceFolderName, String destinationFolderName) {
		selectOperationForFolder("Bulk Move/Copy");
		String eleOption = "xpath=.//*[@title='" + sourceFolderName + "']";
		driver.findElement(eleOption).waitForVisible();
		driver.findElement(eleOption).waitForEnabled();
		QMetryUtility.clickUsingActions(driver.findElement(eleOption));
		getNextBtn().waitForEnabled();
		QMetryUtility.clickUsingActions(getNextBtn());
		String destFolder = "xpath=.//*[@title='" + destinationFolderName + "']";
		driver.findElement(destFolder).waitForVisible();
		driver.findElement(destFolder).waitForEnabled();
		QMetryUtility.clickUsingActions(driver.findElement(destFolder));
		getMoveFolderBtn().waitForEnabled();
		QMetryUtility.click(getMoveFolderBtn());
	}

	/**
	 * This method will perform copy operation on folder.
	 * 
	 * @author rahul.patil
	 */
	public void closeAdminMessage() {
		String adminMsgCloseButton = "xpath=.//*[contains(@class,'site-administration-msg')]/span";
		if (driver.findElement(adminMsgCloseButton).isPresent()
				&& driver.findElement(adminMsgCloseButton).isDisplayed()) {
			driver.findElement(adminMsgCloseButton).waitForVisible();
			driver.findElement(adminMsgCloseButton).waitForEnabled();
			QMetryUtility.click(driver.findElement(adminMsgCloseButton));
		}
	}

	/**
	 * This method will add comment for entity.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public void addCommentForExternalIssue(String comment) {
		getAddCommentBtn().waitForEnabled();
		QMetryUtility.click(getAddCommentBtn());
		getEditSourceBtn().click();
		getCommentTxtBox().waitForVisible();
		getCommentTxtBox().waitForEnabled();
		getCommentTxtBox().sendKeys(comment);
		getCheckCommnetBtn().waitForEnabled();
		QMetryUtility.click(getCheckCommnetBtn());
		waitForCommentOperation();
		waitForTabLoader();
	}

	/**
	 * This method will add comment for entity.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public void selectDate(String date) {
		String dateValue = date.split(" ")[0];
		if (dateValue.startsWith("0")) {
			dateValue = Character.toString(dateValue.charAt(1));
		}
		String day = "xpath=.//*[contains(@class,'p-datepicker')]//*[contains(@class,'p-datepicker')]//*[text()='"
				+ dateValue + "' and not(contains(@class,'disabled'))]";
		driver.findElement(day).waitForVisible();
		QMetryUtility.click(driver.findElement(day));
	}

	/**
	 * This method will select dropdown value.
	 * 
	 * @param DropDownLabels
	 * @param dropDownValue
	 * @author rahul.patil
	 */
	public void selectQmetryFilterAdvancedFilters(List<String> advancedFilterNames) {
		getLocFilter().expandQmetryAdvancedFilterList();
		for (String value : advancedFilterNames) {
			String valueLoc = "xpath=.//*[@role='listbox']//*[text()='" + value + "']/ancestor::li";
			driver.findElement(valueLoc).waitForEnabled();
			QMetryUtility.click(driver.findElement(valueLoc));
		}
		getLocFilter().collapseQmetryAdvancedFilterList();
	}

	/**
	 * This method will select dropdown value.
	 * 
	 * @param userAlias
	 * @author rahul.patil
	 */
	public QAFWebElement getUserFromMentionedList(String userAlias) {
		String valueLoc = "xpath=.//mention-list//a[text()[normalize-space() = '" + userAlias + "']]";
		return driver.findElement(valueLoc);
	}

	/**
	 * This method verifies add requirement event email receiver.
	 * 
	 * @param platformBean
	 * @author rahul.patil
	 */
	public boolean verifyTaggedUserAddCommentMailReceived(String entityKey) {
		ClientRegistrationPage clientRegistrationPage = new ClientRegistrationPage();
		String rqEmailText = "xpath=.//*[text()='[QMetry] "
				+ ConfigurationManager.getBundle().getString("user.username") + " "
				+ ConfigurationManager.getBundle().getString("user.lastname") + " has added a comment in " + entityKey
				+ "']";
		return clientRegistrationPage.waitForEmail(rqEmailText);
	}

	/**
	 * This method verifies add requirement event email receiver.
	 * 
	 * @param platformBean
	 * @author rahul.patil
	 */
	public boolean verifyTaggedUserEditCommentMailReceived(String entityKey) {
		ClientRegistrationPage clientRegistrationPage = new ClientRegistrationPage();
		String rqEmailText = "xpath=.//*[text()='[QMetry] "
				+ ConfigurationManager.getBundle().getString("user.username") + " "
				+ ConfigurationManager.getBundle().getString("user.lastname") + " has updated the comment in "
				+ entityKey + "']";
		return clientRegistrationPage.waitForEmail(rqEmailText);
	}

	/**
	 * This method verifies add requirement event email receiver.
	 * 
	 * @param platformBean
	 * @author rahul.patil
	 */
	public boolean verifyTaggedUserDeleteCommentMailReceived(String entityKey) {
		ClientRegistrationPage clientRegistrationPage = new ClientRegistrationPage();
		String rqEmailText = "xpath=.//*[text()='[QMetry] "
				+ ConfigurationManager.getBundle().getString("user.username") + " "
				+ ConfigurationManager.getBundle().getString("user.lastname") + " has deleted a comment in " + entityKey
				+ "']";
		return clientRegistrationPage.waitForEmail(rqEmailText);
	}

	/**
	 * This method verifies add requirement event email receiver.
	 * 
	 * @param platformBean
	 * @author rahul.patil
	 */
	public boolean verifyTaggedUserBulkEditCommentMailReceived(String entityKey, String module) {
		ClientRegistrationPage clientRegistrationPage = new ClientRegistrationPage();
		String rqEmailText = "xpath=.//a[@href and text()='" + entityKey + "']";
		if (clientRegistrationPage.waitForEmail(rqEmailText)) {
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.id("ifmail")));
			String header = "xpath=.//*[text()='[QMetry] " + ConfigurationManager.getBundle().getString("user.username")
					+ " " + ConfigurationManager.getBundle().getString("user.lastname")
					+ " has mentioned you in several " + module + "(s)']";
			if (driver.findElement(header).isPresent()) {
				return true;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will verify Highlighted folder. verifyHighlightedFolder
	 * 
	 * @param folderName
	 * @author priyanka.devaliya
	 */
	public boolean verifyFolderIsSelected(String folderName) {

		String selectedFolder = "xpath=.//*[@aria-label='" + folderName + "']";
		driver.findElement(selectedFolder).waitForVisible();
		return driver.findElement(selectedFolder).getAttribute("aria-selected").equals("true");
	}

	/**
	 * This method will verify Highlighted folder.
	 * 
	 * @param folderName
	 * @author priyanka.devaliya
	 */
	public boolean verifyFolderIsExpanded(String folderName) {

		String selectedFolder = "xpath=.//*[@aria-label='" + folderName + "']";
		driver.findElement(selectedFolder).waitForVisible();
		return driver.findElement(selectedFolder).getAttribute("aria-expanded").equals("true");
	}

	/**
	 * A method to verify specific Parent Issue.
	 *
	 * @author priyanka.devaliya
	 */
	public boolean verifyParentIssueAtDetailScreen(String value) {
		String locParentKey = "xpath=.//*[@title='Parent Issue']/parent::*/following-sibling::*//*[text()[normalize-space()='"
				+ value + "']]";
		driver.findElement(locParentKey).waitForVisible();
		driver.findElement(locParentKey).waitForEnabled();
		return driver.findElement(locParentKey).isDisplayed();

	}

	/*
	 * A method to verify folder count.
	 *
	 * @author priyanka.devaliya
	 */
	public boolean verifyFolderCount(String folderName, String count) {
		String locFolderCount = "xpath=.//*[@title='" + folderName + "']/following-sibling::*";
		driver.findElement(locFolderCount).waitForVisible();

		Reporter.log("*****************" + folderName + "*********" + driver.findElement(locFolderCount).getText());
		return driver.findElement(locFolderCount).getText().equals("(" + count + ")");

	}

	public boolean verifyUdfDefaultValueAtCreateScreen(String fieldType, String value) {

		String operationLoc = "xpath=.//*[text()='" + fieldType + "']/following-sibling::*";
		driver.findElement(operationLoc).waitForEnabled();
		return driver.findElement(operationLoc).getText().equals(value);

	}

	/**
	 * This method will verify filter applied or not for issue type.
	 * 
	 * @author priyanka.devaliya
	 */
	public boolean verifyUDFValue(String fieldType, String value) {
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
		/*
		 * getRefreshBtn().waitForEnabled(); QMetryUtility.click(getRefreshBtn());
		 */
		waitForLoader(getDetailViewLoader());
		waitForTabLoader();
		boolean flag = true;

		String optionLoc = ".//*[@title='" + fieldType + "']/following-sibling::*//*[@title]";
		driver.findElement(By.xpath(optionLoc)).waitForVisible();
		if (!driver.findElement(By.xpath(optionLoc)).verifyText(value)) {
			return false;
		}
		return flag;
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author priyanka.devaliya
	 */
	public void waitForscreenToLoad() {
		String locFolder = "xpath=.//*[contains(@class,'all-holder')]";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * This method will verify Field With Value At Detail Tab
	 * 
	 * @author priyanka.devaliya
	 */
	public boolean verifyFieldWithValueAtDetailTab(String field, String value) {
		String field_Value = "xpath=.//*[contains(text(),'" + field
				+ "')]/parent::*/following-sibling::*//span[@title='" + value + "']";
		return driver.findElement(field_Value).isDisplayed();

	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author priyanka.devaliya
	 */
	public void requestChangeAtBulkOperation(String remark) {
		getRequestChangeAtBulkOperationBtn().waitForVisible();
		getRequestChangeAtBulkOperationBtn().waitForEnabled();
		QMetryUtility.click(getRequestChangeAtBulkOperationBtn());
		getYesBtn().waitForVisible();
		getYesBtn().waitForEnabled();
		getYesBtn().click();
		getRequestChangeHeader().waitForVisible();
		getRequestChangeAdditionalRemarkTxtArea().sendKeys(remark);
		getRequestChangeAcceptBtn().waitForVisible();
		getRequestChangeAcceptBtn().waitForEnabled();
		QMetryUtility.click(getRequestChangeAcceptBtn());
		getRequestChangeAcceptBtn().waitForNotVisible();
	}

	/**
	 * A method will verify latest scheduled task actitvity
	 * 
	 * @param activity
	 * @param module
	 */
	public void clickDownloadBtnAtScheduledTaskActivity() {

		QAFWebElement firstraw = getScheduledTaskActivity().get(0);
		firstraw.waitForVisible();
		WebElement downloadBtn = firstraw.findElement(By.xpath(
				"/following-sibling::span[text()='Download']/ancestor::*[@class='table']//*[contains(@class,'fa fa-download')]"));

		downloadBtn.click();

	}

	public void addHyperLink(String link, String text) {
		getInsertLinkBtn().waitForVisible();
		getInsertLinkBtn().waitForEnabled();
		getInsertLinkBtn().click();
		getUrlLinkTxtBox().waitForVisible();
		getUrlLinkTxtBox().sendKeys(link);
		getUrlTextTxtBox().waitForVisible();
		getUrlTextTxtBox().sendKeys(text);
		getSubmitImageURLBtn().waitForEnabled();
		getSubmitImageURLBtn().click();

	}

	public boolean verifyLinkAddedAtTextArea(String link, String text) {
		String textarea = "xpath=.//*[@id='ngxEditorTextarea']/a";
		driver.findElement(textarea).getAttribute("href").equals(link);
		return driver.findElement(textarea).getText().equals(text);
	}

	public boolean verifyLinkOpenInNewTab(String text) {

		String tab1 = driver.getWindowHandle();
		String textarea = "xpath=.//a[text()='" + text + "']";
		driver.findElement(textarea).click();
		QMetryUtility.switchToNewWindow();
		getMyDashboardText().waitForVisible();
		boolean value = getMyDashboardText().verifyVisible();
		switchToWindow(tab1);
		return value;

	}

	/**
	 * 
	 * @param isCheck
	 * @author priyanka.devaliya This is method to select skip Duplicate Likage
	 *         CheckBox
	 */

	public void skipDuplicateLikageCheckBox(boolean isCheck) {
		if (isCheck == true) {
			getSkipDuplicateLinkageCheckBox().waitForEnabled();
			if (!getSkipDuplicateLinkageCheckBox().isSelected()) {
				getSkipDuplicateLinkageCheckBox().click();
			}
		}
		if (isCheck == false) {
			getSkipDuplicateLinkageCheckBox().waitForEnabled();
			if (getSkipDuplicateLinkageCheckBox().isSelected()) {
				getSkipDuplicateLinkageCheckBox().click();
			}
		}
	}

	/**
	 * A method will verify latest scheduled task actitvity
	 * 
	 * @param activity
	 * @param module
	 */
	public void clickDownloadBtnAtScheduledActivity() {

		String download = "xpath=//*[contains(@class,'fa fa-download')]";
		driver.findElement(download).waitForVisible();
		driver.findElement(download).waitForEnabled();
		driver.findElement(download).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method will select check box based on name provided.
	 * 
	 * @param checkBoxName
	 * @author priyanka.devaliya
	 */
	public void DeSelectCheckBoxByName(String checkBoxName) {
		String checkBoxLoc = ".//*[text()='" + checkBoxName + "']/preceding-sibling::input";
		driver.findElement(By.xpath(checkBoxLoc)).waitForVisible();
		if (driver.findElement(By.xpath(checkBoxLoc)).isSelected()) {
			driver.findElement(By.xpath(checkBoxLoc)).waitForEnabled();
			QMetryUtility.click(driver.findElement(By.xpath(checkBoxLoc)));
			driver.findElement(By.xpath(checkBoxLoc)).waitForNotSelected();
		}
	}

	// /**
	// * Method will select check box based on name provided.
	// *
	// * @param checkBoxName
	// * @author priyanka.devaliya
	// */
	// public QAFWebElement getCombinedViewTableOfSelectedSection(String
	// sectionName) {
	// String tableName = ".//*[text()='" + sectionName
	// + "']/ancestor::*[@role='tab']/parent::*/following-sibling::*//table";
	// driver.findElement(By.xpath(tableName)).waitForVisible();
	// return driver.findElement(By.xpath(tableName));

	// }
	// }

	// /**
	// * Method will select check box based on name provided.
	// *
	// * @param checkBoxName
	// * @author priyanka.devaliya
	// */
	// public QAFWebElement getCombinedViewTableOfSelectedSection(String
	// sectionName) {
	// String tableName = ".//*[text()='" + sectionName
	// + "']/ancestor::*[@role='tab']/parent::*/following-sibling::*//table";
	// driver.findElement(By.xpath(tableName)).waitForVisible();
	// return driver.findElement(By.xpath(tableName));

	// }
	// }

	/**
	 * This method will add comment for entity.
	 * 
	 * @param comment
	 * @author rahul.patil
	 */
	public void selectYearMonthDate(String date) {
		new Select(getCalenderYearSelect()).selectByVisibleText(date.split(" ")[2]);
		new Select(getCalenderMonthSelect()).selectByVisibleText(date.split(" ")[1]);
		String dateValue = date.split(" ")[0];
		if (dateValue.startsWith("0")) {
			dateValue = Character.toString(dateValue.charAt(1));
		}
		String day = "xpath=.//*[contains(@class,'p-datepicker')]//*[contains(@class,'p-datepicker')]//*[text()='"
				+ dateValue + "' and not(contains(@class,'disabled'))]";
		driver.findElement(day).waitForVisible();
		QMetryUtility.click(driver.findElement(day));
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getCreateNewEntityDropDownLoc(String label) {
		String dropDownLoc = "xpath=.//*[contains(text(),'" + label + "')]/following-sibling::p-multiselect";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getCreateNewEntityDropDownEmptyLoc(String label) {
		String dropDownLoc = "xpath=.//*[contains(text(),'" + label
				+ "')]/following-sibling::p-multiselect//li[contains(@class,'p-multiselect-empty-message') and text()[normalize-space()='No results found']]";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailViewDropDownLoc(String label) {
		String dropDownLoc = "xpath=.//*[@title='" + label + "']/following-sibling::*";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailViewDropDownEmptyLoc(String label) {
		String dropDownLoc = "xpath=.//*[@title='" + label
				+ "']/following-sibling::*//p-multiselect//li[contains(@class,'p-multiselect-empty-message') and text()[normalize-space()='No results found']]";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * Method will return list of comment value.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getArrangeColumnList() {
		String dropDownLoc = "xpath=.//*[@title='Arrange Columns']/following-sibling::*//label";
		List<String> columnValues = new ArrayList<>();
		for (int i = 0; i < driver.findElements(dropDownLoc).size(); i++) {
			columnValues.add(driver.findElements(dropDownLoc).get(i).getAttribute("title").trim());

		}
		return columnValues;
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void expandLinkTestcaseModelArrangeColumn() {
		getLinkTestcaseModelArrangeColumnBtn().waitForVisible();
		if (!getLinkTestcaseModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkTestcaseModelArrangeColumnBtn().waitForVisible();
			getLinkTestcaseModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkTestcaseModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void collapseLinkTestcaseModelArrangeColumn() {
		getLinkTestcaseModelArrangeColumnBtn().waitForVisible();
		if (getLinkTestcaseModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkTestcaseModelArrangeColumnBtn().waitForVisible();
			getLinkTestcaseModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkTestcaseModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void expandLinkIssuesModelArrangeColumn() {
		getLinkIssuesModelArrangeColumnBtn().waitForVisible();
		if (!getLinkIssuesModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkIssuesModelArrangeColumnBtn().waitForVisible();
			getLinkIssuesModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkIssuesModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void collapseLinkIssuesModelArrangeColumn() {
		getLinkIssuesModelArrangeColumnBtn().waitForVisible();
		if (getLinkIssuesModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkIssuesModelArrangeColumnBtn().waitForVisible();
			getLinkIssuesModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkIssuesModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void expandAssignIssuesModelArrangeColumn() {
		getAssignIssuesModelArrangeColumnBtn().waitForVisible();
		if (!getAssignIssuesModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getAssignIssuesModelArrangeColumnBtn().waitForVisible();
			getAssignIssuesModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getAssignIssuesModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void collapseAssignIssuesModelArrangeColumn() {
		getAssignIssuesModelArrangeColumnBtn().waitForVisible();
		if (getAssignIssuesModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getAssignIssuesModelArrangeColumnBtn().waitForVisible();
			getAssignIssuesModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getAssignIssuesModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void expandLinkTestsuitesModelArrangeColumn() {
		getLinkTestsuiteModelArrangeColumnBtn().waitForVisible();
		if (!getLinkTestsuiteModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkTestsuiteModelArrangeColumnBtn().waitForVisible();
			getLinkTestsuiteModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkTestsuiteModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void collapseLinkTestsuitesModelArrangeColumn() {
		getLinkTestsuiteModelArrangeColumnBtn().waitForVisible();
		if (getLinkTestsuiteModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkTestsuiteModelArrangeColumnBtn().waitForVisible();
			getLinkTestsuiteModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkTestsuiteModelArrangeColumnBtn());
		}

	}

	/**
	 * Method will return list of comment value.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getListBoxValues() {
		String listBoxLoc = "xpath=.//ul[@role='listbox']";
		driver.findElement(listBoxLoc).waitForVisible();
		String dropDownLoc = "xpath=.//ul[@role='listbox']/p-multiselectitem/li";
		List<String> columnValues = new ArrayList<>();
		for (int i = 0; i < driver.findElements(dropDownLoc).size(); i++) {
			columnValues.add(driver.findElements(dropDownLoc).get(i).getAttribute("aria-label"));

		}
		return columnValues;
	}

	/**
	 * Method will return list of comment value.
	 * 
	 * @author rahul.patil
	 */
	public void selectListBoxValue(String value) {
		String listBoxLoc = "xpath=.//ul[@role='listbox']";
		driver.findElement(listBoxLoc).waitForVisible();
		String dropDownLoc = "xpath=.//ul[@role='listbox']//p-multiselectitem/li[@aria-label='" + value + "']";
		driver.findElement(dropDownLoc).click();
	}

	/**
	 * Method will return list of comment value.
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getListBoxValueLoc(String dropDownLabel) {
		String dropDownLoc = "xpath=.//label[text()[normalize-space() = '" + dropDownLabel
				+ "']]/following-sibling::*/p-multiselect//*[contains(@class,'p-multiselect-label')]";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getDetailViewRiskBasedAnalysisSectionFieldValue(String fieldLabel) {
		String dropDownLoc = "xpath=.//*[text()[normalize-space() = 'Risk Analysis']]/ancestor::div[contains(@class,'p-accordion-header')]/following-sibling::*//*[@title='"
				+ fieldLabel + "']/following-sibling::*";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * Method will wait for table to load after operation.
	 * 
	 * @author priyanka.devaliya
	 */
	public void waitForDetailTabToLoad() {
		String locFolder = "xpath=.//*[contains(@class,'details-tab')]";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));
	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void expandLinkRequirementsModelArrangeColumn() {
		getLinkRequirementsModelArrangeColumnBtn().waitForVisible();
		if (!getLinkRequirementsModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkRequirementsModelArrangeColumnBtn().waitForVisible();
			getLinkRequirementsModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkRequirementsModelArrangeColumnBtn());
		}

	}

	/**
	 * A method to Expand the arrange columns function.
	 * 
	 * @author rahul.patil
	 */
	public void collapseLinkRequirementsModelArrangeColumn() {
		getLinkRequirementsModelArrangeColumnBtn().waitForVisible();
		if (getLinkRequirementsModelArrangeColumnBtn().getAttribute("aria-expanded").contains("true")) {
			getLinkRequirementsModelArrangeColumnBtn().waitForVisible();
			getLinkRequirementsModelArrangeColumnBtn().waitForEnabled();
			QMetryUtility.click(getLinkRequirementsModelArrangeColumnBtn());
		}

	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getEntityDetailsTabSectionLoc(String fieldLabel) {
		String dropDownLoc = "xpath=.//a[@role='tab']//*[text()[normalize-space() = '" + fieldLabel + "']]";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt test execution data corresponds to test
	 * suite key.
	 * 
	 * @param testSuiteEntityKey
	 * @param fieldLabel
	 * @author rahul.patil
	 */
	public QAFWebElement getFlakyScoreTestExecutionData(String testSuiteEntityKey, String fieldLabel) {
		String dropDownLoc = "xpath=.//*[@class='qtm__testExecutionSuitItem']//a[text()='" + testSuiteEntityKey
				+ "']/ancestor::*[@class='qtm__testExecutionSTItem']/following-sibling::*//label[text()='" + fieldLabel
				+ ":']/following-sibling::*";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getAlertDialogMessage(String operation) {
		String dropDownLoc = "xpath=.//h2[text()='" + operation + "']/following-sibling::*[@id='swal2-html-container']";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getAlertDialogYesButton(String operation) {
		String dropDownLoc = "xpath=.//h2[text()='" + operation
				+ "']/following-sibling::*[@id='swal2-html-container']/following-sibling::*[contains(@class,'actions')]/button[contains(@class,'confirm') and text()='Yes']";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getAlertDialogNoButton(String operation) {
		String dropDownLoc = "xpath=.//h2[text()='" + operation
				+ "']/following-sibling::*[@id='swal2-html-container']/following-sibling::*[contains(@class,'actions')]/button[contains(@class,'cancel') and text()='No']";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getAlertDialogOkButton(String operation) {
		String dropDownLoc = "xpath=.//h2[text()='" + operation
				+ "']/following-sibling::*[@id='swal2-html-container']/following-sibling::*[contains(@class,'actions')]/button[contains(@class,'confirm') and text()='OK']";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getAlertDialogCheckbox(String operation) {
		String dropDownLoc = "xpath=.//h2[text()='" + operation
				+ "']/following-sibling::label[contains(@class,'checkbox')]/input[@type='checkbox']";
		return driver.findElement(dropDownLoc);
	}

	/**
	 * This method will return webelemnt of dropdown present on create entity page.
	 * 
	 * @param label
	 * @author rahul.patil
	 */
	public QAFWebElement getAlertDialogCheckboxMessage(String operation) {
		String dropDownLoc = "xpath=.//h2[text()='" + operation
				+ "']/following-sibling::label[contains(@class,'checkbox')]/input[@type='checkbox']/following-sibling::*";
		return driver.findElement(dropDownLoc);
	}

	public void setUDFProject(List<String> modules, List<String> fieldNameList, String projectName,
			String lookUpListValue, String multiLookUpListValue) {
		ManageFieldsPage manageFieldsPage = new ManageFieldsPage();
		manageFieldsPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.CUSTOMIZATION);
		manageFieldsPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.MANAGE_FIELDS);
		manageFieldsPage.waitForPageToLoad();
		for (String fieldName : fieldNameList) {
			Reporter.log("******************** Remove Project ********************");
			ManageFieldsPage manageFieldsPage1 = new ManageFieldsPage();
			ManageFieldsBean manageFieldsBean1 = new ManageFieldsBean();
			manageFieldsBean1.setFieldName(fieldName);
			manageFieldsBean1.setProject(projectName);

			manageFieldsPage1.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.MANAGE_FIELDS);
			manageFieldsPage1.applyFieldNameFilterOnUdf(manageFieldsBean1);
			manageFieldsPage1.clickOnEditUDF(manageFieldsBean1);

			CreateUDFPage createUDFPage1 = new CreateUDFPage();
			manageFieldsBean1.setProject(projectName);
			modules.add(udfModuleOptions.TESTCASE.toString());
			manageFieldsBean1.setModules(modules);
			createUDFPage1.addAnotherProjectToUDF(manageFieldsBean1);
			createUDFPage1.waitForLoader(createUDFPage1.getEditManageFiledLoader());

			if (fieldName.equals(
					ConfigurationManager.getBundle().getString(TestDataSetupConstants.UDF_LOOKUPLIST_FIELD_NAME))) {

				createUDFPage1.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.MANAGE_FIELDS);
				manageFieldsPage1.waitForPageToLoad();
				ManageFieldsPage manageFieldsPage2 = new ManageFieldsPage();
				manageFieldsPage2.applyFieldNameFilterOnUdf(manageFieldsBean1);
				manageFieldsPage2.clickOnEditUDF(manageFieldsBean1);
				createUDFPage1.getProjectMappingTable()
						.getEditListLinkByCellValue("Projects",
								ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME))
						.waitForVisible();
				QMetryUtility.click(createUDFPage1.getProjectMappingTable().getEditListLinkByCellValue("Projects",
						ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME)));

				createUDFPage1.getAddNewValueBtn().waitForEnabled();
				QMetryUtility.click(createUDFPage1.getAddNewValueBtn());
				createUDFPage1.getListFieldName().waitForEnabled();
				createUDFPage1.getListFieldName().sendKeys("look_up_name" + lookUpListValue);
				createUDFPage1.getFieldAliasTxtBox().waitForEnabled();
				createUDFPage1.getFieldAliasTxtBox().sendKeys(lookUpListValue);
				createUDFPage1.getSaveListValueBtn().waitForEnabled();
				QMetryUtility.click(createUDFPage1.getSaveListValueBtn());
				ListsPage listsPage1 = new ListsPage();
				listsPage1.waitForLoader(listsPage1.getEditListsLoader());
				QMetryUtility.click(listsPage1.getCloseEditListWindowBtn());
			}

			if (fieldName.equals(ConfigurationManager.getBundle()
					.getString(TestDataSetupConstants.UDF_MULTI_LOOKUPLIST_FIELD_NAME))) {

				createUDFPage1.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.MANAGE_FIELDS);
				manageFieldsPage1.waitForPageToLoad();
				ManageFieldsPage manageFieldsPage3 = new ManageFieldsPage();
				manageFieldsPage3.applyFieldNameFilterOnUdf(manageFieldsBean1);
				manageFieldsPage3.clickOnEditUDF(manageFieldsBean1);
				createUDFPage1.getProjectMappingTable()
						.getEditListLinkByCellValue("Projects",
								ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME))
						.waitForVisible();
				QMetryUtility.click(createUDFPage1.getProjectMappingTable().getEditListLinkByCellValue("Projects",
						ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME)));

				createUDFPage1.getAddNewValueBtn().waitForEnabled();
				QMetryUtility.click(createUDFPage1.getAddNewValueBtn());
				createUDFPage1.getListFieldName().waitForEnabled();
				createUDFPage1.getListFieldName().sendKeys("multi_look_up_name" + multiLookUpListValue);
				createUDFPage1.getFieldAliasTxtBox().waitForEnabled();
				createUDFPage1.getFieldAliasTxtBox().sendKeys(multiLookUpListValue);
				createUDFPage1.getSaveListValueBtn().waitForEnabled();
				QMetryUtility.click(createUDFPage1.getSaveListValueBtn());
				ListsPage listsPage2 = new ListsPage();
				listsPage2.waitForLoader(listsPage2.getEditListsLoader());
				QMetryUtility.click(listsPage2.getCloseEditListWindowBtn());
			}

			createUDFPage1.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.MANAGE_FIELDS);
			manageFieldsPage1.waitForPageToLoad();
		}

	}

	/**
	 * A method swich to specified project.
	 *
	 * @author rahul.patil
	 */
	public void switchProjectToLinktestCases(String projectName) {
		getLinkTestcaseWindowProjectsDrpDwn().waitForVisible();
		getLinkTestcaseWindowProjectsDrpDwn().waitForEnabled();
		QMetryUtility.click(getLinkTestcaseWindowProjectsDrpDwn());
		getLinkTestcaseWindowProjectTxtBox().waitForVisible();
		getLinkTestcaseWindowProjectTxtBox().waitForEnabled();
		getLinkTestcaseWindowProjectTxtBox().clear();
		getLinkTestcaseWindowProjectTxtBox().sendKeys(projectName);
		String locProject = ".//p-multiselectitem//*[contains(text(),'" + projectName + "')]";
		driver.findElement(By.xpath(locProject)).waitForVisible();
		QMetryUtility.click(driver.findElement(By.xpath(locProject)));
	}

	/**
	 * 
	 * 
	 * @author priyanka.devaliya
	 */
	public void waitForplatformMatrixTableTOLoad() {

		String locFolder = "xpath=.//*[contains(@class,'platform-matrix-table')]";
		do {
		} while (driver.findElement(locFolder).getAttribute("class").contains("disabled"));

	}

	/**
	 * A method will drag and drop element to destination point.
	 * 
	 * @param sourcelocator
	 * @param destinationlocator
	 */
	public List<String> getFileNameListPresentInDirectory(String fileLocation) {
		List<String> list = new ArrayList<>();
		File directory = new File(fileLocation);
		File[] files = directory.listFiles();
		for (File f : files) {
			list.add(f.getName());
		}
		return list;
	}

	/**
	 * A method to select an option from the 'Option' menu
	 * 
	 * @param option
	 */
	public List<String> getCreateFormFieldLabelList() {
		List<String> columnValues = new ArrayList<>();
		int size = getCreateFormLabelList().size();
		for (int i = 0; i < size; i++) {
			columnValues.add(getCreateFormLabelList().get(i).getText().trim());
		}
		return columnValues;
	}

	/**
	 * A method to select an option from the 'Option' menu
	 * 
	 * @param option
	 */
	public List<String> getDetailTabFieldLabelList() {
		List<String> columnValues = new ArrayList<>();
		int size = getDetailTabdLabelList().size();
		for (int i = 0; i < size; i++) {
			columnValues.add(getDetailTabdLabelList().get(i).getText().trim());
		}
		return columnValues;
	}

	/**
	 * This method will return list of dropdown menu. Call this method when dropdown
	 * is open
	 * 
	 * @author rahul.patil
	 */
	public List<String> getDetailTabJiraFieldList() {
		List<String> tablists = new ArrayList<>();
		String filterOptionsLoc = "xpath=.//*[text()[normalize-space() = 'Jira Fields']]/ancestor::div[contains(@class,'p-accordion-header')]/following-sibling::*//*[contains(@class,'text-label')]/*";
		int size = driver.findElements(filterOptionsLoc).size();
		for (int i = 0; i < size; i++) {
			tablists.add(driver.findElements(filterOptionsLoc).get(i).getAttribute("title"));
		}
		return tablists;
	}

	/**
	 * Method will select show only archived version check box.
	 * 
	 * @param isCheck
	 * @author priyanka.devaliya
	 */
	public void selectCheckBox(QAFWebElement element, boolean isSelect) {
		if (isSelect == true) {
			element.waitForVisible();
			if (!element.isSelected()) {
				QMetryUtility.click(element);
				element.waitForSelected();
			}
		} else {
			if (isSelect == false) {
				if (element.isSelected()) {
					QMetryUtility.click(element);
					element.waitForNotSelected();
				}
			}
		}
	}

	/**
	 * This method will select dropdown value.
	 * 
	 * @author rahul.patil
	 */
	public void chooseFolderToApplyDetailViewPopUpFilter(DetailViewPopUpFilterComponent compo, String folderName) {
		QMetryUtility.click(compo.getDetailViewPopUpChooseFolderBtn());
		String folderLoc = "xpath=.//*[text()='" + folderName + "' and @title='" + folderName + "']";
		driver.findElement(folderLoc).waitForVisible();
		QMetryUtility.click(driver.findElement(folderLoc));
		getSelectFilterFolderBtn().waitForEnabled();
		QMetryUtility.click(getSelectFilterFolderBtn());
		getSelectFilterFolderBtn().waitForNotVisible();
	}

	/**
	 * This method checks the show archive checkbox
	 * 
	 * @author rahul.patil, nidhi.shah
	 */
	public void disableShowOnlyShareableEntities() {
		waitForHorizontalBarToLoad();
		getLocFilterButton().waitForVisible();
		getLocFilterButton().waitForEnabled();
		QMetryUtility.click(getLocFilterButton());
		getLocFilter().deselectCheckBoxByName(CheckBoxLabels.SHOW_ONLY_SHAREABLE.toString());
		waitForHorizontalBarToLoad();
		getLocNewBtn().waitForVisible();
		getLocFilterButton().waitForEnabled();
		getLocFilterButton().click();
		waitForHorizontalBarToLoad();
		/* waitForLoader(getTableLoader()); */
	}

	/**
	 * A method to select an option from the 'Option' menu
	 * 
	 * @param option
	 */
	public List<String> getListFromWeblist(List<WebElement> list) {
		List<String> columnValues = new ArrayList<>();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			columnValues.add(list.get(i).getText().trim());
		}
		return columnValues;
	}

	/**
	 * This method will verify Field With Text Value At Detail Tab
	 * 
	 * @author rahul.patil
	 */

	public boolean verifyFieldWithTextValueAtDetailTab(String field, String value) {
		String field_Value = "xpath=.//*[text()[normalize-space()='" + field
				+ "']]/parent::*/following-sibling::*//*[text()='" + value + "']";
		return driver.findElement(field_Value).isDisplayed();
	}

	/**
	 * Method will verify if List has ONLY one type of element.
	 * 
	 * @param columnName
	 * @author mdrajib.ali
	 */
	public boolean areAllValuesSame(List<String> listValues) {
		Set<String> setValues = new HashSet<>(listValues);
		return (setValues.size() == 1);
	}

	/**
	 * Method will wait for change log table to load after operation.
	 * 
	 * @author mdrajib.ali
	 */
	public void waitForChangeLogTableToLoad() {
		do {
		} while (getChangeLogTableLoader().getAttribute("class").contains("disabled"));
	}

	/**
	 * This method will add watcher
	 * 
	 * @param user
	 * @return boolean
	 * @author mdrajib.ali
	 */
	public void addWatcher(String user) {
		QMetryUtility.click(getWatchersListDrpDwnToggleBtn());
		QMetryUtility.click(getManageWatchersDrpDwnBtn());
		getAddWatchersBtn().waitForVisible();
		getAddWatchersBtn().waitForEnabled();
		QMetryUtility.click(getAddWatchersBtn());
		QMetryUtility.click(getWatcherUserListDrpDwnBtn());
		selectUserToAddAsWatcher(user);
		QMetryUtility.click(getAddBtn());
		getAddWatchersBtn().waitForEnabled();
		QMetryUtility.click(getCloseWatchersListBtn());
	}

	/**
	 * This method with select user to add as watcher
	 * 
	 * @param username
	 * @author mdrajib.ali
	 */
	public void selectUserToAddAsWatcher(String user) {
		String locUsername = "xpath=.//span[text()[normalize-space()='" + user + "']]";
		QMetryUtility.click(driver.findElement(locUsername));
	}

	/**
	 * This method with verify that user is present in watchers list
	 * 
	 * @param username
	 * @author mdrajib.ali
	 */
	public boolean verifyUserPresentInWatchersList(String user) {
		String locUser = "xpath=.//*[text()='Manage Watchers']/preceding-sibling::*//*[@title='" + user + "']";
		driver.findElement(locUser).waitForVisible();
		boolean isUserPresent = driver.findElement(locUser).verifyText(user);
		return isUserPresent;
	}

	/**
	 * This method will NOT select dropdown value.
	 * 
	 * @param DropDownLabels
	 * @param dropDownValue
	 * @author mdrajib.ali
	 */
	public void clickCloseButtonOnDetailWindowTextBox(String label, String dropDownValue) {
		String dropDownLoc = "xpath=.//*[@title='" + label + "']/following-sibling::*//*[@title]";
		driver.findElement(dropDownLoc).waitForEnabled();
		driver.findElement(dropDownLoc).waitForVisible();
		driver.findElement(dropDownLoc).click();
		String locFolder = "xpath=.//*[@title='" + label
				+ "']/following-sibling::*//*[@title]/parent::*/following-sibling::*//input";
		driver.findElement(locFolder).waitForEnabled();
		driver.findElement(locFolder).click();
		driver.findElement(locFolder).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		driver.findElement(locFolder).sendKeys(dropDownValue);
		String locCloseBtn = "xpath=.//*[@title='" + label
				+ "']/following-sibling::*//*[@title]/parent::*/following-sibling::*//*[contains(@class,'fa-remove')]/parent::*";
		driver.findElement(locCloseBtn).waitForEnabled();
		driver.findElement(locCloseBtn).click();
		waitForDetailWindowFieldLoader();
	}

	/**
	 * This method will verify the dropdown value.
	 * 
	 * @param DropDownLabels
	 * @param dropDownValue
	 * @author mdrajib.ali
	 */
	public boolean isValuePresentInDetailsTabFieldDropdown(String label, String dropDownValue) {
		String dropDownLoc = "xpath=.//*[@title='" + label + "']/following-sibling::*//*[@title]";
		driver.findElement(dropDownLoc).waitForVisible();
		driver.findElement(dropDownLoc).waitForEnabled();
		driver.findElement(dropDownLoc).click();
		String locValue = "xpath=.//p-multiselectitem//*[text()='" + dropDownValue + "']";
		boolean isValuePresent = driver.findElement(locValue).isDisplayed();
		return isValuePresent;
	}

	/**
	 * Method will return list of comment value.
	 * 
	 * @author rahul.patil
	 */
	public void sendKeysOnListTextBox(String value) {
		String listBoxLoc = "xpath=.//input[@role='textbox' and contains(@class,'p-inputtext')]";
		driver.findElement(listBoxLoc).clear();
		driver.findElement(listBoxLoc).sendKeys(value);
	}

	/**
	 * This method will select folder.
	 * 
	 * @author rahul.patil
	 */
	public void selectFolder(String folderName) {
		getSelectFolderHeader().waitForVisible();
		String folderLoc = "xpath=.//*[text()='" + folderName + "' and @title='" + folderName + "']";
		driver.findElement(folderLoc).waitForVisible();
		QMetryUtility.click(driver.findElement(folderLoc));
		getSelectFilterFolderBtn().waitForEnabled();
		QMetryUtility.click(getSelectFilterFolderBtn());
		getSelectFilterFolderBtn().waitForNotVisible();
	}

	/**
	 * This method will verify warning after operation.
	 * 
	 * @param warningMessage
	 * @author mdrajib.ali
	 */
	public boolean verifyAddAttachmentWarningMessage(String warningMessage) {
		String locWrnMsg = "xpath=.//*[text()[normalize-space()='" + warningMessage + "']]";
		driver.findElement(locWrnMsg).waitForVisible();
		driver.findElement(locWrnMsg).waitForPresent();
		return driver.findElement(locWrnMsg).verifyText(warningMessage);
	}

	/**
	 * This method will verify file name against warning message after operation.
	 * 
	 * @param warningMessage
	 * @param fileName
	 * @author mdrajib.ali
	 */
	public boolean verifyAddAttachmentWarningFile(String warningMessage, String fileName) {
		String locFileName = "xpath=.//*[text()[normalize-space()='" + warningMessage
				+ "']]/following-sibling::*[text()[normalize-space()='" + fileName + "']]";
		driver.findElement(locFileName).waitForVisible();
		driver.findElement(locFileName).waitForPresent();
		return driver.findElement(locFileName).verifyText(fileName);
	}

	/**
	 * This method will delete an attachment file
	 * 
	 * @param fileName
	 * @author mdrajib.ali
	 */
	public void deleteAttachedFile(String fileName) {
		String locFileName = "xpath=.//*[text()[normalize-space()='" + fileName + "']]";
		String locDtlBtn = "xpath=.//*[text()[normalize-space()='" + fileName
				+ "']]/ancestor::*[2]/following-sibling::*//*[@title='Delete']";
		QMetryUtility.moveMouseOnElement(driver.findElement(locFileName));
		driver.findElement(locDtlBtn).click();
	}

	/**
	 * This method will extract file name from file location
	 * 
	 * @param fileLoc
	 * @author mdrajib.ali
	 */
	public String getFileName(String fileLoc) {
		return fileLoc.split("/")[(fileLoc.split("/").length) - 1];
	}

	public String getDateAfterDays(int numberOfDays, String dateFormat) {
		// Get the current date
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays); // Add or subtract the number of days

		Date resultDate = calendar.getTime(); // Get the updated date

		// Format the result date according to the provided date format
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(resultDate);
	}

	/**
	 * This method will check sorting
	 * 
	 * @param listValues
	 * @author mdrajib.ali
	 */
	public boolean AreEntitiesInAscendingOrder(List<String> listValues) {
		List<String> sortedList = new ArrayList<>(listValues);
		sortedList.sort(getComparator());
		return sortedList.equals(listValues);
	}

	/**
	 * This method will check sorting
	 * 
	 * @param listValues
	 * @author mdrajib.ali
	 */
	public boolean AreEntitiesInDescendingOrder(List<String> listValues) {
		List<String> sortedList = new ArrayList<>(listValues);
		sortedList.sort(getComparator().reversed());
		return sortedList.equals(listValues);
	}

	/**
	 * This method will compare
	 * 
	 * @param listValues
	 * @author mdrajib.ali
	 */

	private Comparator<String> getComparator() {
		return new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				try {
					int num1 = Integer.parseInt(s1.replaceAll("\\D+", ""));
					int num2 = Integer.parseInt(s2.replaceAll("\\D+", ""));
					return Integer.compare(num1, num2);
				} catch (NumberFormatException e) {
					return s1.compareTo(s2);
				}
			}
		};
	}

	/**
	 * This method will drag and drop column
	 * 
	 * @param sourceColumn
	 * @param destinationColumn
	 * @author mdrajib.ali
	 */
	public void changeColumnOrder(String sourceColumn, String destinationColumn) {
		WebElement sourceLocator = driver
				.findElement("xpath=.//label[text()[normalize-space() = '" + sourceColumn + "']]/input");
		WebElement destinationLocator = driver
				.findElement("xpath=.//label[text()[normalize-space() = '" + destinationColumn + "']]/input");
		dragAndDropElement(sourceLocator, destinationLocator);
		getSaveArrangeColumnBtn().waitForEnabled();
		QMetryUtility.click(getSaveArrangeColumnBtn());
	}

	/**
	 * This method will check column moved
	 * 
	 * @param sourceColumn
	 * @param destinationColumn
	 * @author mdrajib.ali
	 */
	public boolean verifyColumnMoved(String sourceColumn, String destinationColumn) {
		int sourceIndex = getTable().getColumnByName(sourceColumn);
		int destinationIndex = getTable().getColumnByName(destinationColumn);
		return sourceIndex == destinationIndex + 1 || sourceIndex == destinationIndex - 1;
	}

}