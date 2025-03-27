package com.qmetry.component;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.qmetry.constants.CommonConstants;
import com.qmetry.locators.GridComponentLocators;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.util.QMetryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * This class defines GridComponent.
 * 
 * @author rahul.patil
 */
public class GridComponent extends QAFWebComponent implements GridComponentLocators {

	/**
	 * @param drivlocatorer
	 * @return
	 */
	protected GridComponent(String locator) {
		super(locator);
	}

	public GridComponent() {
		super("");
	}

	@FindBy(locator = COLUMN_LIST)
	private List<QAFWebElement> columnList;

	@FindBy(locator = COLUMN_LIST_TEXT)
	private List<QAFWebElement> columnListText;

	@FindBy(locator = SELECT_ALL_ENTITY_CHECK_BOX)
	private QAFWebElement selectAllEntityCheckbox;

	@FindBy(locator = SELECTED_ENTITIES_CHECK_BOXES)
	private List<QAFWebElement> selectedEntitiesCheckboxes;

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

	@FindBy(locator = DATA_GRID_COLUMN_LIST_DATA_TABLE_LOC)
	private List<QAFWebElement> columnListDT;

	@FindBy(locator = RAW_LIST)
	private List<QAFWebElement> rawList;

	@FindBy(locator = COLUMN_LIST_PARAM_LINK_TABLE)
	private List<QAFWebElement> paramLinkColumnList;

	@FindBy(locator = COLUMN_LIST_WITH_HIDDEN_FIELD)
	private List<QAFWebElement> columnListWithHiddenField;

	@FindBy(locator = COLUMN_LIST_WITH_TITLE_ATTRIBUTE)
	private List<QAFWebElement> columnListWithTitleAttribute;

	@FindBy(locator = REPORT_COLUMN_LIST)
	private List<QAFWebElement> reportColumnList;

	@FindBy(locator = EDIT_ISSUE_JIRA_FIELD_COLUMN_LIST)
	private List<QAFWebElement> editIssueJiraFieldColumnList;

	@FindBy(locator = EDIT_REQUIREMENT_JIRA_FIELD_COLUMN_LIST)
	private List<QAFWebElement> editRequirementJiraFieldColumnList;

	public List<QAFWebElement> getColumnList() {
		return columnList;
	}

	public List<QAFWebElement> getColumnListByText() {
		return columnListText;
	}

	public List<QAFWebElement> getSelectedEntitiesCheckboxes() {
		return selectedEntitiesCheckboxes;
	}

	public QAFWebElement getSelectAllEntityCheckbox() {
		return selectAllEntityCheckbox;
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

	public List<QAFWebElement> getColumnListAtDataTable() {
		return columnListDT;
	}

	public List<QAFWebElement> getRawList() {
		return rawList;
	}

	public List<QAFWebElement> getParamLinkColumnList() {
		return paramLinkColumnList;
	}

	public List<QAFWebElement> getColumnListWithHiddenField() {
		return columnListWithHiddenField;
	}

	public List<QAFWebElement> getColumnListWithTitleAttribute() {
		return columnListWithTitleAttribute;
	}

	public List<QAFWebElement> getReportColumnList() {
		return reportColumnList;
	}

	public List<QAFWebElement> getEditIssueJiraFieldColumnList() {
		return editIssueJiraFieldColumnList;
	}

	public List<QAFWebElement> getEditRequirementJiraFieldColumnList() {
		return editRequirementJiraFieldColumnList;
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnByName(String columnName) {
		int count = 0;
		getColumnList().get(0).waitForPresent();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getAttribute("title") == null) {
			} else {
				if (getColumnList().get(i).getAttribute("title").trim().equals(columnName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnByNameWithHiddenTableHeader(String columnName) {
		int count = 0;
		getParamLinkColumnList().get(0).waitForPresent();
		int size = getParamLinkColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getParamLinkColumnList().get(i).getAttribute("title") == null) {
			} else {
				if (getParamLinkColumnList().get(i).getAttribute("title").trim().equals(columnName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getEditableCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueTDTag(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getTextAreaCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]//textarea";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getOptionsForEntity(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//span[@title='Options']";
		findElement(By.xpath(optionLoc)).waitForVisible();
		findElement(By.xpath(optionLoc)).waitForEnabled();
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public void verifyEntityArchived(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "(./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr)[last()]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		assertTrue("Entity is in unarchived state",
				findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived"));
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public boolean verifyEntityIsArchived(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "(./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr)[last()]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		return findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived");
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public void verifyEntityUnarchived(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "(./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr)[last()]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		assertFalse("Entity is in archived state",
				findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived"));
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public boolean verifyEntityIsUnarchived(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "(./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr)[last()]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		return !findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived");
	}

	/**
	 * Method will return element of row based upon known value of column
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getRowByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCheckBoxByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return list of web element of specified column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getColumnValues(String columnName) {
		int count = getColumnByName(columnName);
		List<String> columnValues = new ArrayList<>();
		if (columnName.equals(CommonConstants.COLUMN_ENTITY_KEY)) {
			String entityKeyValues = "./tbody//td[" + count + "]//*[self::a]";
			int size = findElements(By.xpath(entityKeyValues)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(entityKeyValues)).get(i).getText().trim());
			}
		} else if (columnName.equals("Comment")) {
			String entityKeyValues = "./tbody//td[" + count + "]//*[@title]";
			int size = findElements(By.xpath(entityKeyValues)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(entityKeyValues)).get(i).getText().trim());
			}
		} else if (columnName.equals("Gadget Name")) {
			String entityKeyValues = "./tbody//td[" + count + "]//*[@title]";
			int size = findElements(By.xpath(entityKeyValues)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(entityKeyValues)).get(i).getText().trim());
			}
		} else {
			String locMenuOption = "./tbody//td[" + count + "]//*[self::div or self::a]";
			int size = findElements(By.xpath(locMenuOption)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText().trim());
			}
		}
		return columnValues;
	}

	/**
	 * Method to will return web element of edit button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = 'Edit']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of minus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getMinusCircleByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'minus-circle')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of delete button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getDeleteButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = 'Delete'] or @title='Delete']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getArchiveButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = 'Archive']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of unarchive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getUnarchiveButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = 'Unarchive']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of on of switch corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getOnOffSwitchByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input[@name='onoffswitch']/..";
		findElement(By.xpath(locMenuOption)).waitForEnabled();
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify selected value in text box.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @param textBoxValue
	 * @author rahul.patil
	 */
	public boolean verifySelectedValueForTextBox(String columnName, String columnValue, String requiredColumn,
			String textBoxValue) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locCellValue = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td[" + count1
				+ "]//*[self::div or self::a]";
		findElement(By.xpath(locCellValue)).click();
		String locTestBoxDropDownValue = "./tbody//td[" + count2 + "]//*[text()='" + columnValue
				+ "']/ancestor::tr//td[" + count1 + "]//input/following-sibling::ul//span[text()='" + textBoxValue
				+ "']/parent::li";
		findElement(By.xpath(locTestBoxDropDownValue)).waitForEnabled();
		return findElement(By.xpath(locTestBoxDropDownValue)).getAttribute("class").contains("selected");
	}

	/**
	 * Method will return list of web element of specified column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getReleaseCycleColumnValues(String columnName) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[@title]";
		int size = findElements(By.xpath(locMenuOption)).size();
		List<String> columnValues = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getAttribute("title"));
		}
		return columnValues;
	}

	/**
	 * Method to will expand release for column if not expanded.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public void expandReleaseForCycle(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "(.//tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]//ancestor::tr//*[contains(@class,'fa-minus-circle')])[1]";
		if (!findElement(By.xpath(locMenuOption)).isPresent()) {
			getMinusCircleByCellValue(columnName, columnValue).waitForEnabled();
			QMetryUtility.click(getPlusCircleByCellValue(columnName, columnValue));
		}
	}

	/**
	 * Method will return list of web element of specified column.
	 * 
	 * @param columnName
	 * @author nidhi.shah
	 */
	public List<String> getBDDConfigurationColumnValues(String columnName) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[@title]";
		int size = findElements(By.xpath(locMenuOption)).size();
		List<String> columnValues = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getAttribute("title"));
		}
		return columnValues;
	}

	/**
	 * Method to fetch list of column names.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getColumnNames() {
		List<String> columns = new ArrayList<>();
		getColumnList().get(1).waitForEnabled();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			columns.add(getColumnList().get(i).getAttribute("title").trim());
		}
		return columns;
	}

	/**
	 * Method to fetch list of column names.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getColumnNamesByText() {
		List<String> columns = new ArrayList<>();
		getColumnListByText().get(1).waitForEnabled();
		int size = getColumnListByText().size();
		for (int i = 0; i < size; i++) {
			columns.add(getColumnListByText().get(i).getText().trim());
		}
		return columns;
	}

	/**
	 * Method to fetch list of column names.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public boolean verifyAllEntityCheckBoxSelected() {
		boolean isCheck = true;
		int size = getSelectedEntitiesCheckboxes().size();
		for (int i = 0; i < size; i++) {
			if (getSelectedEntitiesCheckboxes().get(i).isSelected()) {
				continue;
			} else {
				return false;
			}
		}
		return isCheck;
	}

	/**
	 * Method will return webelement of sort button corresponds to column name
	 * passed as argument.
	 * 
	 * @param columnName
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getSortButtonByColumnName(String columnName) {
		String locSortButton = "./thead//th[@title='" + columnName + "']//*[contains(@class,'sort')]";
		return findElement(By.xpath(locSortButton));
	}

	/**
	 * Method to will return web element of download button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getDownloadButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Download']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of entity key link.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getEntityLinkByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//a";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public boolean verifyEntityIsArchived_(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "(./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::span)[last()]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		return findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived");
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public boolean verifyEntityIsUnarchived_(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "(./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr)[last()]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		return !(findElement(By.xpath(optionLoc)).getAttribute("class") == null);
	}

	/**
	 * Method to will return web element of excute button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getExecuteButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String executeBtn = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//em[@title='Execute']";
		return findElement(By.xpath(executeBtn));
	}

	/**
	 * Method will verify selected value in text box.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public void selectExecutionStatusForTestCase(String columnName, String columnValue, String requiredColumn,
			String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//input";
		if (findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus)) {
			Reporter.log(
					"Execution status " + executionStatus + "for test case " + columnValue + " is already selected.");
		} else {
			QMetryUtility.click(findElement(By.xpath(executionStatusInput)));
			String exeStatus = ".//*[text()='" + executionStatus + "']/parent::li";
			findElement(By.xpath(exeStatus)).waitForVisible();
			QMetryUtility.click(findElement(By.xpath(exeStatus)));
		}
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public boolean verifyExecutionStatusForTestCase(String columnName, String columnValue, String requiredColumn,
			String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//input";
		return findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus);
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getChangeLogTableColumnByName(String columnName) {
		int count = 0;
		getColumnList().get(1).waitForEnabled();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getAttribute("data-fieldname").equals(columnName)) {
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
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getChangeLogTableCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getChangeLogTableColumnByName(requiredColumn);
		int count2 = getChangeLogTableColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will select assign for test case run.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @param assigneeName
	 * @author rahul.patil
	 */
	public void selectAssignForTestCaseRun(String columnName, String columnValue, String requiredColumn,
			String assigneeName) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String assigneeInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td[" + count1
				+ "]//input";
		if (findElement(By.xpath(assigneeInput)).getAttribute("title").equals(assigneeName)) {
			Reporter.log("Execution status " + assigneeName + "for test case " + columnValue + " is already selected.");
		} else {
			QMetryUtility.click(findElement(By.xpath(assigneeInput)));
			String exeStatus = ".//*[text()='" + assigneeName + "']/parent::li";
			findElement(By.xpath(exeStatus)).waitForVisible();
			QMetryUtility.click(findElement(By.xpath(exeStatus)));
		}
	}

	/**
	 * Method will verify assign for test case run.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @param assigneeName
	 * @author rahul.patil
	 */
	public boolean verifyAssignOfTestCaseRun(String columnName, String columnValue, String requiredColumn,
			String assigneeName) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String assigneeInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td[" + count1
				+ "]//input";
		return findElement(By.xpath(assigneeInput)).getAttribute("title").equals(assigneeName);
	}

	/**
	 * Method will verify assign for test case run.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @param assigneeName
	 * @author rahul.patil
	 */
	public boolean verifyExecutionTypeOfTestCaseRun(String columnName, String columnValue, String requiredColumn,
			String executionType) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String assigneeInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td[" + count1
				+ "]//input";
		return findElement(By.xpath(assigneeInput)).getAttribute("title").equals(executionType);
	}

	/**
	 * Method to will return web element of plus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getPlusCircleByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'plus-circle')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return list of web element of execution status column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getExecutionStatusColumnValues(String columnName) {
		int count = getColumnByName(columnName);
		List<String> columnValues = new ArrayList<>();
		String entityKeyValues = "./tbody//td[" + count + "]//input";
		int size = findElements(By.xpath(entityKeyValues)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(entityKeyValues)).get(i).getAttribute("title"));
		}
		return columnValues;
	}

	/**
	 * Method to will return web element of sync with latest version button
	 * corresponds to value provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getSyncWithLatestVersionButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Latest version is available, click to Sync']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return list of project name. Call this method when projects page
	 * is visible.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getListOfProject() {
		int count = getColumnByName(CommonConstants.COLUMN_PROJECTS);
		List<String> columnValues = new ArrayList<>();
		String locMenuOption = "./tbody//td[" + count + "]//*[contains(@title,'Project:')]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText());
		}
		return columnValues;
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAddButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()='Add']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to list of email added for notification event.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public List<String> getEmailNotificationReceiverForEvent(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		List<String> columnValues = new ArrayList<>();
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@title,'Email:')]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText().trim());
		}
		return columnValues;
	}

	/**
	 * Method to will return web element of cross button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCrossButtonForEmailNotificationReceiver(String columnName, String columnValue,
			String requiredColumn, String email) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@title,'Email:') and contains(text(),'" + email
				+ "')]/i";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getEntityApprovalStatus(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@class='arrow']/following-sibling::*/*";
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAddGadgetButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Add Gadget']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditDashboardButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Edit Dashboard']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return list of pronect name. Call this method when projects page
	 * is visible.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getSharedDashboardList() {
		List<String> columnValues = new ArrayList<>();
		String locMenuOption = "./tbody//td[3]//a";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getAttribute("title"));
		}
		return columnValues;
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getScheduleButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='List of Schedules']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getEditDeleteDeactivateOperationBtnElement(String columnName, String columnValue,
			String operation) {
		int count = getColumnByName(columnName);
		String optionLoc = "//tbody//td['" + count + "']//*[text()[normalize-space()='" + columnValue
				+ "']]/ancestor::tr/td//a[text()[normalize-space()='" + operation + "']]";

		findElement(By.xpath(optionLoc)).waitForVisible();
		findElement(By.xpath(optionLoc)).waitForEnabled();
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method will verify selected value in text box.
	 * 
	 * @author priyanka.devaliya
	 */
	public void selectExecutionStatusForTestCaseStep(String executionStatus) {

		String executionStatusInput = "//table[contains(@class,'steps-table')]//tbody//td[7]//*[@type='text']";

		if (findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus)) {
			Reporter.log("Execution status " + executionStatus + "for test case step is already selected.");
		} else {
			QMetryUtility.click(findElement(By.xpath(executionStatusInput)));
			String exeStatus = ".//*[text()='" + executionStatus + "']/parent::li";
			findElement(By.xpath(exeStatus)).waitForVisible();
			findElement(By.xpath(exeStatus)).waitForPresent();
			QMetryUtility.click(findElement(By.xpath(exeStatus)));
		}
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellCheckBox(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getRoleModifyCellCheckBox(String columnName, String columnValue, String requiredColumn) {
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = '" + requiredColumn
				+ "']]/preceding-sibling::*/input";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify selected value in text box.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public void selectExecutionStatusForTestStep(String columnName, String columnValue, String requiredColumn,
			String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr/td["
				+ count1 + "]//input";
		if (findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus)) {
			Reporter.log(
					"Execution status " + executionStatus + "for test case " + columnValue + " is already selected.");
		} else {
			QMetryUtility.click(findElement(By.xpath(executionStatusInput)));
			String exeStatus = ".//*[text()='" + executionStatus + "']/parent::li";
			findElement(By.xpath(exeStatus)).waitForVisible();
			QMetryUtility.click(findElement(By.xpath(exeStatus)));
		}
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author nidhi.shah
	 */
	public boolean verifyExecutionStatusForTestStep(String columnName, String columnValue, String requiredColumn,
			String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//input";
		return findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus);
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCloneButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = 'Clone']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public QAFWebElement getTestcaseStepEditableField(String columnName) {
		int count1 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count1 + "]//*[contains(@class,'editable-field')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public QAFWebElement getTestcaseStepInsertImageButton(String columnName) {
		int count1 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count1 + "]//*[@title='Insert Image']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public QAFWebElement getTestcaseStepImage(String columnName) {
		int count1 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count1 + "]//img[@src and @data-attachment-id]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to return row count of table.
	 * 
	 * @author rahul.patil
	 */
	public int getRowCount() {
		String locMenuOption = "./tbody//tr";
		return findElements(By.xpath(locMenuOption)).size();
	}

	/**
	 * Method to return row count of table.
	 * 
	 * @author rahul.patil
	 */
	public int getQmetryInsightTableRowCount() {
		String locMenuOption = "./datatable-body//datatable-body-row";
		return findElements(By.xpath(locMenuOption)).size();
	}

	/**
	 * Method to will return web element of plus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getRadioButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//input[@type='radio']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of minus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getMinusCircleByCellValueAtmodule(String columnValue) {

		String locMenuOption = "./tbody//td//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'minus-circle')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of minus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getmandatorySwitchBtnAtmodule(String columnValue) {

		String locMenuOption = "./tbody//td//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'onoffswitch')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getChangeLogReportCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td['" + count2 + "']//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//div/span";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public void clickOnSharedDashboard(String columnName, String columnValue) {
		// int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[3]//*[text()[normalize-space() = '" + columnValue + "']]";
		QMetryUtility.click(findElement(By.xpath(locMenuOption)));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCloneDashboardButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Clone Dashboard']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getDeleteDashboardButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Delete Dashboard']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of remove user button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getRemoveButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'fa fa-trash')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getModifyCheckBoxByModuleAndColumnValue(String moduleName) {
		String locMenuOption = "./tbody//tr//*[text()='" + moduleName
				+ "']/ancestor::tr//td[3]//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getBuildAtTestRunOfTestcase(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]";
		return findElement(By.xpath(executionStatusInput));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getStepOptionByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'fa-cog')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getShareableTestcaseEntityKeyByCellValue(String columnName, String columnValue,
			String shareableTestcaseEntityKey) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//a[@title='" + shareableTestcaseEntityKey + "']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnNameByText(String columnName) {
		int count = 0;
		String locMenuOption = "./thead//th//*[contains(@class,'text-overflow')]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			if (findElements(By.xpath(locMenuOption)).get(i).getText().trim().equals(columnName)) {
				count = count + 1;
				break;
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to will return web element of entity key link.
	 * 
	 * @param columnValue
	 * @author rahul.patil
	 */
	public String getCommentByVersionOfEntity(String columnValue) {
		int count1 = getColumnByName("Comment");
		String locMenuOption = "./tbody//td[text()[normalize-space() = '" + columnValue + "']]/ancestor::tr//td["
				+ count1 + "]//*[@title]";
		return findElement(By.xpath(locMenuOption)).getAttribute("title");
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnByText(String columnName) {
		int count = 0;
		getColumnListByText().get(0).waitForVisible();
		int size = getColumnListByText().size();
		for (int i = 0; i < size; i++) {
			if (getColumnListByText().get(i).getText().trim().equals(columnName)) {
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
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueByText(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByText(requiredColumn);
		int count2 = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return list of web element of specified column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getColumnValuesByColumnText(String columnName) {
		int count = getColumnByText(columnName);
		List<String> columnValues = new ArrayList<>();
		if (columnName.equals(CommonConstants.COLUMN_ENTITY_KEY)) {
			String entityKeyValues = "./tbody//td[" + count + "]//*[self::a]";
			int size = findElements(By.xpath(entityKeyValues)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(entityKeyValues)).get(i).getText());
			}
		} else if (columnName.equals("Comment")) {
			String entityKeyValues = "./tbody//td[" + count + "]//*[@title]";
			int size = findElements(By.xpath(entityKeyValues)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(entityKeyValues)).get(i).getText());
			}
		} else {
			String locMenuOption = "./tbody//td[" + count + "]//*[self::div or self::a]";
			int size = findElements(By.xpath(locMenuOption)).size();
			for (int i = 0; i < size; i++) {
				columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText());
			}
		}
		return columnValues;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getInlineEditorByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//inline-editor//textarea";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getInlineEditorCheckBtnByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//inline-editor//*[contains(@class,'fa-check')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getInlineEditorRemoveBtnByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//inline-editor//*[contains(@class,'fa-remove')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getInlineEditorTextByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//inline-editor//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of plus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAttachmentButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'paperclip')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getSelectTextLocByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//text-select";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getSelectTextInputLocByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//text-select//input";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public List<String> getListOfSelectTextDropDownByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		List<String> selectTextDrpDwnValues = new ArrayList<>();
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//text-select//li";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			selectTextDrpDwnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText());
		}
		return selectTextDrpDwnValues;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getSelectTextCaretDownLocByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//text-select//*[contains(@class,'caret-down')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getSelectValueFromSelectTextInputLocByCellValue(String columnName, String columnValue,
			String requiredColumn, String value) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//text-select//ul//*[text()='" + value + "']/parent::li";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of plus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAttachmentButtonOfStepByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr/*/div//*[contains(@class,'paperclip')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getSummaryColumnEntityKey(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::a]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getOptionFromOptionsDropDown(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//span[@title='Options']/following-sibling::ul";
		findElement(By.xpath(optionLoc)).waitForVisible();
		findElement(By.xpath(optionLoc)).waitForEnabled();
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method to will return web element of sync with latest version button
	 * corresponds to value provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getSyncTestcaseWithTheLatestVersionOfRequirementButtonByCellValue(String columnName,
			String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Sync Test Case with the latest version of Requirement']/following-sibling::*[@title='Synced with latest version']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of sync with latest version button
	 * corresponds to value provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getSyncRequirementWithTheLatestVersionOfTescaseButtonByCellValue(String columnName,
			String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Sync Requirement with the latest version of Test Case']/following-sibling::*[@title='Synced with latest version']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getScheduleAutomationButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = ".//img[@title='Schedule Automation']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAutomationHistoryButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = ".//em[@title='Automation History']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAutomationScheduleButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//button[text()[normalize-space() = 'Schedule']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getHistoryButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//button[@title='History']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getManageScheduleButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//button[@title='Manage Schedule']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCopyCommandButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Copy']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return webelement of sort button corresponds to column name
	 * passed as argument.
	 * 
	 * @param columnName
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getSortButtonByColumnText(String columnName) {
		String locSortButton = "./thead//*[contains(@class,'text-overflow') and text()='" + columnName
				+ "']/parent::*/following-sibling::*[contains(@class,'sort')]";
		return findElement(By.xpath(locSortButton));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getSuccessBarByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'bg-success')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getScrollElement() {
		String scrollElementLoc = "./parent::*";
		return findElement(By.xpath(scrollElementLoc));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getScheduledAtDateByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@class,'text-date')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getScheduledCompletedDateByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@class,'text-italic')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCheckBoxByCellValueWithText(String columnName, String columnValue) {

		int count = 0;
		getColumnList().get(0).waitForVisible();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getAttribute("class").contains("field-name")) {
				count = count + 1;
				break;
			}
		}
		count++;

		// int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column with data table.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public int getColumnByNameAtDataTable(String columnName) {
		int count = 0;
		getColumnListAtDataTable().get(0).waitForVisible();
		int size = getColumnListAtDataTable().size();
		for (int i = 0; i < size; i++) {
			if (getColumnListAtDataTable().get(i).getAttribute("title") == null) {
			} else {
				if (getColumnListAtDataTable().get(i).getAttribute("title").equals(columnName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method will return list of web element of specified column at Data table .
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public List<String> getColumnValuesAtDataTable(String columnName) {
		int count = getColumnByNameAtDataTable(columnName);

		List<String> columnValues = new ArrayList<>();

		String locMenuOption = ".//datatable-body//datatable-body-cell[" + count + "]/div/*";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText());
		}
		return columnValues;
	}

	/**
	 * Method will return webelement of sort button corresponds to column name
	 * passed as argument.
	 * 
	 * @param columnName
	 * @return QAFWebElement
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getSortButtonByColumnName2(String columnName) {
		String locSortButton = "./thead//th[@title='" + columnName + "']//*[contains(@class,'fa-sort')]/parent::*";
		return findElement(By.xpath(locSortButton));
	}

	/**
	 * Method to will send data to editable field by raw at test step.
	 * 
	 * @param columnName
	 * @param rawValue
	 * @param data
	 * @author priyanka.devaliya
	 */
	public void getEditableFieldByRawAtTestStep(String columnName, String rawValue, String data) {
		int count1 = getColumnByName(columnName);
		int rawcount = getRawByValue(rawValue);
		String locMenuOption = "//table[contains(@class,'steps-table')]/tbody//tr[" + rawcount + "]//td[" + count1
				+ "]//*[contains(@class,'editable-field')]";
		findElement(By.xpath(locMenuOption)).click();
		String operationLoc = "//table[contains(@class,'steps-table')]/tbody//tr[" + rawcount + "]//td[" + count1
				+ "]//*[contains(@class,'editable-field')]/following-sibling::*//textarea";
		findElement(By.xpath(operationLoc)).sendKeys(data);

	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public int getRawByValue(String rawName) {
		int count = 0;
		getRawList().get(0).waitForVisible();
		int size = getRawList().size();
		for (int i = 0; i < size; i++) {
			if (getRawList().get(i).getText() == null) {
			} else {
				if (getRawList().get(i).getText().equals(rawName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCellValueByColumnText(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnNameByText(requiredColumn);
		int count2 = getColumnNameByText(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCheckBoxByCellValueofshareableTC(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = ".//tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public int getColumnByParamName(String columnName) {
		int count = 0;
		String locMenuOption = "./thead//th/p-autocomplete";
		getParamLinkColumnList().get(0).waitForVisible();
		int size = getParamLinkColumnList().size();
		int count1 = 2;
		for (int i = 0; i < size; i++) {

			if (!getParamLinkColumnList().get(i).getAttribute("class").contains("paramHeader")) {
			} else {

				if (findElements(By.xpath(locMenuOption)).get(i - count1).getAttribute("title").equals(columnName)) {

					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getParamValueBoxByColumnName(String columnName) {
		int count = getColumnByParamName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]/p-autocomplete";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of plus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getPlusCircle() {
		String locMenuOption = ".//table[contains(@class,child)]//*[contains(@class,'plus-circle')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueOfshareable(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr[contains(@class,'shareable-tc')]//td[" + count1
				+ "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getLinkParameterIconByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@title,'Parameter Values')]/em";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author pryanka.devaliya
	 */
	public QAFWebElement startOrEditTimerByCellValue(String columnName, String columnValue, String requiredColumn,
			String timerOperation) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		count1 = count1 + 1;
		count2 = count2 + 1;
		String locMenuOption = "./tbody//td[" + count2 + "]//*[contains(text(),'" + columnValue
				+ "')]/ancestor::tr//td[" + count1 + "]//div[contains(@class,'stopwatch')]//div[@title='"
				+ timerOperation + "']";
		// findElement(By.xpath(locMenuOption)).click();

		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify selected value in text box.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public void selectExecutionStatusForTestCaseAtDetailView(String columnName, String columnValue,
			String requiredColumn, String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		count1 = count1 + 1;
		count2 = count2 + 1;
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//input";
		if (findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus)) {
			Reporter.log(
					"Execution status " + executionStatus + "for test case " + columnValue + " is already selected.");
		} else {
			QMetryUtility.click(findElement(By.xpath(executionStatusInput)));
			String exeStatus = ".//*[text()='" + executionStatus + "']/parent::li";
			findElement(By.xpath(exeStatus)).waitForVisible();
			QMetryUtility.click(findElement(By.xpath(exeStatus)));
		}
	}

	/**
	 * Method will verify Execution Status For TestCase at detail view.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public boolean verifyExecutionStatusForTestCaseAtDetailView(String columnName, String columnValue,
			String requiredColumn, String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		count1 = count1 + 1;
		count2 = count2 + 1;

		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//input";
		return findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus);
	}

	/**
	 * Method will verify selected value in text box.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public void selectExecutionStatusForTestStep2(String columnName, String columnValue, String requiredColumn,
			String executionStatus) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr/td["
				+ count1 + "]//input";
		if (findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus)) {
			Reporter.log(
					"Execution status " + executionStatus + "for test case " + columnValue + " is already selected.");
		} else {
			QMetryUtility.click(findElement(By.xpath(executionStatusInput)));
			String exeStatus = ".//*[text()='" + executionStatus + "']/parent::li";
			findElement(By.xpath(exeStatus)).waitForVisible();
			QMetryUtility.click(findElement(By.xpath(exeStatus)));
		}
	}

	/**
	 * Method to will return web element of entity key link.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getEntityLinkByCellValueWithSpace(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text() = '" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//a";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnByNameTest(String columnName) {
		int count = 0;
		getColumnList().get(0).waitForVisible();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getAttribute("title") == null) {
			} else {
				if (getColumnList().get(i).getAttribute("title").trim().equals(columnName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to will return web element of unarchive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getUnlinkButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()='Unlink']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCoOwnerDashboardIconByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + (count + 2) + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Co-Owner']/i[contains(@class,'fa-users')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getShareGadgetButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Share Gadget']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of add button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCoOwnerGadgetIconByCellValue(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + (count + 2) + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Co-Owner']/i[contains(@class,'fa-users')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueByText(String columnName, String columnValue, String requiredColumn,
			int addedCount) {
		int count1 = getColumnByText(requiredColumn);
		int count2 = getColumnByText(columnName);
		String locMenuOption = "./tbody//td[" + (count2 + addedCount) + "]//*[text()[normalize-space() = '"
				+ columnValue + "']]/ancestor::tr//td[" + (count1 + addedCount)
				+ "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return list of pronect name. Call this method when projects page
	 * is visible.
	 * 
	 * @author rahul.patil
	 */
	public List<String> getSharedGadgetList() {
		List<String> columnValues = new ArrayList<>();
		String locMenuOption = "./tbody//td[3]/*[@title]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getAttribute("title"));
		}
		return columnValues;
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getManageAttributesButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[text()[normalize-space() = 'Manage Attributes']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getPlatformAttributesLoc(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@title,'Attributes')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getColumnCheckBox() {
		String locMenuOption = "./thead//th/input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of minus button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditListLinkByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//a[text()='Edit List']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of edit button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditScheduleButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Edit Schedule']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of edit button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getDeleteScheduleButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Delete Schedule']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCellValueForDataTable(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByNameAtDataTable(requiredColumn);
		int count2 = getColumnByNameAtDataTable(columnName);
		String locMenuOption = ".//datatable-body//datatable-body-cell[" + count2 + "]//*[text()[normalize-space() = '"
				+ columnValue + "']]/ancestor::*/datatable-body-row//datatable-body-cell[" + count1
				+ "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of entity key link.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public void getEditDefaultValueOfUdfString(String columnValue, String requiredColumn, String defaultValue) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(CommonConstants.COLUMN_PROJECTS);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[@title]";
		findElement(By.xpath(locMenuOption)).waitForVisible();
		findElement(By.xpath(locMenuOption)).waitForEnabled();
		QMetryUtility.click(findElement(By.xpath(locMenuOption)));

		String locvalue = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input";
		findElement(By.xpath(locvalue)).waitForVisible();
		// QMetryUtility.click(findElement(By.xpath(locvalue)));
		// findElement(By.xpath(locvalue)).click();
		findElement(By.xpath(locvalue)).clear();
		findElement(By.xpath(locvalue)).sendKeys(defaultValue);

		String locCheckBtn = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[@class='fa fa-check']";
		findElement(By.xpath(locCheckBtn)).waitForVisible();
		findElement(By.xpath(locCheckBtn)).waitForEnabled();
		findElement(By.xpath(locCheckBtn)).click();

	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getShareableTCLink(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]//a";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnIndexByText(String columnName) {
		int count = 0;
		getColumnList().get(0).waitForPresent();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getText().trim().equals(columnName)) {
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
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCellValueWithText(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnIndexByText(requiredColumn);
		int count2 = getColumnIndexByText(columnName);
		Reporter.log("##################   count1" + count1);
		Reporter.log("##################   count2" + count2);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueForSTCStepTable(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnIndexByText(requiredColumn);
		int count2 = getColumnIndexByText(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "][text()[normalize-space() = '" + columnValue
				+ "']]/parent::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getReportTableColumnIndex(String columnName) {
		int count = 0;
		getReportColumnList().get(0).waitForPresent();
		int size = getReportColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getReportColumnList().get(i).getAttribute("title") == null) {
			} else {
				if (getReportColumnList().get(i).getAttribute("title").trim().equals(columnName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getOptionsForstep(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'fa-cog')]";

		findElement(By.xpath(optionLoc)).waitForVisible();
		findElement(By.xpath(optionLoc)).waitForEnabled();
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public int getColumnByNameWithHiddenField(String columnName) {
		int count = 0;
		getColumnListWithHiddenField().get(1).waitForVisible();
		int size = getColumnListWithHiddenField().size();
		for (int i = 0; i < size; i++) {
			if (getColumnListWithHiddenField().get(i).getAttribute("title") == null) {
			} else {
				if (getColumnListWithHiddenField().get(i).getAttribute("title").trim().equals(columnName)) {
					count = count + 1;
					break;
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCellValueWithHideField(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByNameWithHiddenField(requiredColumn);
		int count2 = getColumnByNameWithHiddenField(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch list of column names.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getColumnNamesWithTitleAttribute() {
		List<String> columns = new ArrayList<>();
		getColumnListWithTitleAttribute().get(1).waitForEnabled();
		int size = getColumnListWithTitleAttribute().size();
		for (int i = 0; i < size; i++) {
			columns.add(getColumnListWithTitleAttribute().get(i).getAttribute("title").trim());
		}
		return columns;
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @author rahul.patil
	 */
	public QAFWebElement getColumnResizableBarLoc(String columnName) {
		String locMenuOption = ".//th[@title='" + columnName + "']//*[contains(@class,'resizable-bar')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getLinkedEntityVersionByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@title,'Version')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getReportTableCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getReportTableColumnIndex(requiredColumn);
		int count2 = getReportTableColumnIndex(columnName);
		String locMenuOption = "./datatable-body//datatable-body-cell[" + count2 + "]//*[text()[normalize-space() = '"
				+ columnValue + "']]/ancestor::*[contains(@class,'datatable-row')]//datatable-body-cell[" + count1
				+ "]//span";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch list of column names.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getReportTableColumnNames() {
		List<String> columns = new ArrayList<>();
		getReportColumnList().get(0).waitForPresent();
		int size = getReportColumnList().size();
		for (int i = 0; i < size; i++) {
			columns.add(getReportColumnList().get(i).getAttribute("title").trim());
		}
		return columns;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getTitleAttributeCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch list of column names.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public List<String> getColumnNamesAtTHLevel() {
		List<String> columns = new ArrayList<>();
		String locMenuOption = "./thead//th[contains(@class,'pvtAxisLabel')]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columns.add(findElements(By.xpath(locMenuOption)).get(i).getText().trim());
		}
		return columns;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueForRiskTraceabilityReportTable(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByNameAtTHLevel(requiredColumn);
		int count2 = getColumnByNameAtTHLevel(columnName);
		String locMenuOption = "./tbody//th[" + count2 + "]/a[text()[normalize-space() = '" + columnValue
				+ "']]/parent::*/parent::tr/th[" + count1 + "]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getColumnByNameAtTHLevel(String columnName) {
		int count = 0;
		String locMenuOption = "./thead//th[contains(@class,'pvtAxisLabel')]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			if (findElements(By.xpath(locMenuOption)).get(i).getText().trim().equals(columnName)) {
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
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellFlakyScore(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//app-flaky-score/*";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getFlakyScoreByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//app-flaky-score/*";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return webelement of sort button corresponds to column name
	 * passed as argument.
	 * 
	 * @param columnName
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getInfoCircleLocByColumnName(String columnName) {
		String locSortButton = "./thead//th[@title='" + columnName + "']//*[contains(@class,'info-circle')]";
		return findElement(By.xpath(locSortButton));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellSuccessRate(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//app-success-rate/*";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getSuccessRateByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//app-success-rate/*";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellLatestTestExecutionStatus(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//app-latest-test-execution-status//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getLatestTestExecutionStatusByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//app-latest-test-execution-status//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCheckBoxByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getAutoPropageStatusByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input[@type='checkbox']/following-sibling::*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getDependencyCountBoxByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//a[contains(@class,'dependency-count-box')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueWithTableHiddenElement(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByNameWithHiddenTableHeader(requiredColumn);
		int count2 = getColumnByNameWithHiddenTableHeader(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getDependencyCountBoxByCellValueWithTableHiddenElement(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getColumnByNameWithHiddenTableHeader(requiredColumn);
		int count2 = getColumnByNameWithHiddenTableHeader(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//a[contains(@class,'dependency-count-box')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getExecutionByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@class,'cell-execution')]//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of excute button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getPlayCircleByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String executeBtn = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//em[contains(@class,'play-circle') and contains(@class,'text-success')]";
		return findElement(By.xpath(executeBtn));
	}

	/**
	 * This method will return column step description text area .
	 * 
	 * @author priyanka.devaliya
	 * @return
	 */
	public QAFWebElement geteditIconBtn(String columnName, String columnValue) {

		int count = getColumnByName(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'action')]//*[contains(@class,'fa-pencil')]";

		findElement(By.xpath(optionLoc)).waitForVisible();
		findElement(By.xpath(optionLoc)).waitForEnabled();
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getChangeLogTableColumnByNameWithHiddenField(String columnName) {
		int count = 0;
		// getColumnListWithHiddenField().get(1).waitForEnabled();
		int size = getColumnListWithHiddenField().size();
		for (int i = 0; i < size; i++) {
			if (getColumnListWithHiddenField().get(i).getAttribute("data-fieldname") == null) {
			}
			if (getColumnListWithHiddenField().get(i).getAttribute("data-fieldname").equals(columnName)) {
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
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getChangeLogTableCellValueWithHiddenField(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getChangeLogTableColumnByNameWithHiddenField(requiredColumn);
		int count2 = getChangeLogTableColumnByNameWithHiddenField(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of archive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getArchiveButtonByCellValueAtExecution(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title[normalize-space() = 'Archive']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of unarchive button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getUnArchiveButtonByCellValueAtExecution(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title[normalize-space() = 'Unarchive']]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public boolean verifyTestExecutionEntityIsArchived(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/parent::*/parent::*/parent::*/parent::*";
		findElement(By.xpath(optionLoc)).waitForVisible();
		return findElement(By.xpath(optionLoc)).getAttribute("class").contains("archived");
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author priyanka.devaliya
	 */
	public String getTitleOFBtnFromTwoColumnValues(String columnName, String columnValue, String columnName2,
			String columnValue2) {
		int count2 = getColumnByName(columnName2);
		int count1 = getColumnByName(columnName);
		String locMenuOption = ".//tbody//td[" + count1 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue2
				+ "']]//ancestor::tr//.//*[contains(@class,'action-icon inline')]";
		return findElement(By.xpath(locMenuOption)).getAttribute("title");
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public boolean verifyTestRunIsArchived(String columnName1, String columnValue1, String columnName2,
			String columnValue2) {
		int count1 = getColumnByName(columnName1);
		int count2 = getColumnByName(columnName2);
		String optionLoc = "./tbody//td[" + count1 + "]//*[text()[normalize-space() = '" + columnValue1
				+ "']]/parent::*/parent::*/parent::*/parent::*";
		String option = "./tbody//td[" + count1 + "]//*[text()[normalize-space() = '" + columnValue1
				+ "']]/ancestor::tr//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue2
				+ "']]/ancestor::tr";
		findElement(By.xpath(option)).waitForVisible();
		return findElement(By.xpath(option)).getAttribute("class").contains("archived");
	}

	/**
	 * Method will verify archived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public boolean verifyTestExecutionIsArchived(String columnName1, String columnValue1, String columnName2,
			String columnValue2) {
		int count1 = getColumnByText(columnName1);
		int count2 = getColumnByText(columnName2);
		String optionLoc = "./tbody//td[" + count1 + "]//*[text()[normalize-space() = '" + columnValue1
				+ "']]/parent::*/parent::*/parent::*/parent::*";
		String option = "./tbody//td[" + count1 + "]//*[text()[normalize-space() = '" + columnValue1
				+ "']]/ancestor::tr//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue2
				+ "']]/ancestor::tr";
		findElement(By.xpath(option)).waitForVisible();
		return findElement(By.xpath(option)).getAttribute("class").contains("archived");
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCheckBoxByCellValueAtBulkExecuteTestRun(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[1]//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public boolean verifyTestcasePresentAtBulkExecuteTestRun(String columnName, String columnValue) {

		int count = getColumnNameAtPlatformMatrixTable(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue + "']]";
		return findElement(By.xpath(locMenuOption)).isPresent();
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public int getColumnNameAtPlatformMatrixTable(String columnName) {
		int count = 0;
		getColumnList().get(0).waitForPresent();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getText().trim().equals(columnName)) {
				count = count + 1;
				break;
			}
			count++;
		}
		return count;
	}

	/**
	 * Method will verify unarchived state of entity.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public boolean verifyExecutionStatusForTestCaseAtBulkExecute(String columnName, String columnValue,
			String requiredColumn, String executionStatus) {
		int count1 = getColumnNameAtPlatformMatrixTable(requiredColumn);
		int count2 = getColumnNameAtPlatformMatrixTable(columnName);
		String executionStatusInput = "./tbody//td[" + count2 + "]//*[text()='" + columnValue + "']/ancestor::tr//td["
				+ count1 + "]//span[contains(@class,'status')]";
		return findElement(By.xpath(executionStatusInput)).getAttribute("title").equals(executionStatus);
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author priyanka.devaliya
	 */
	public int getAllColumnNames(String columnName) {
		int count = 0;
		getColumnList().get(0).waitForPresent();
		int size = getColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getColumnList().get(i).getText().trim().equals(columnName)) {
				count = count + 1;
				break;
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getCheckBoxByCellValueAtSelectRequirment(String columnName, String columnValue) {
		int count = getAllColumnNames(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of excute button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author priyanka.devaliya
	 */
	public QAFWebElement getExecuteButtonByCellValue2(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String executeBtn = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'play-circle') and @placement]";
		return findElement(By.xpath(executeBtn));
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getEditIssueJiraFiledsColumnNameByText(String columnName) {
		int count = 0;
		int size = getEditIssueJiraFieldColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getEditIssueJiraFieldColumnList().get(i).getText().trim().equals(columnName)) {
				count = count + 1;
				break;
			}
			count++;
		}
		return count;
	}

	/**
	 * Method to fetch index of column.
	 * 
	 * @param columnName
	 * @author rahul.patil
	 */
	public int getEditRequirementJiraFiledsColumnNameByText(String columnName) {
		int count = 0;
		int size = getEditRequirementJiraFieldColumnList().size();
		for (int i = 0; i < size; i++) {
			if (getEditRequirementJiraFieldColumnList().get(i).getText().trim().equals(columnName)) {
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
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getLatestTestExecutionStatusByCellValueWithHiddenHeader(String columnName,
			String columnValue) {
		int count = getColumnByNameWithHiddenTableHeader(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//app-latest-test-execution-status//*[@title]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditIssueFieldsCheckBoxByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getEditIssueJiraFiledsColumnNameByText(requiredColumn);
		int count2 = getEditIssueJiraFiledsColumnNameByText(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditIssueFieldsCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getEditIssueJiraFiledsColumnNameByText(requiredColumn);
		int count2 = getEditIssueJiraFiledsColumnNameByText(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[self::div or self::a or self::span]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getEditRequirementFieldsCheckBoxByCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getEditRequirementJiraFiledsColumnNameByText(requiredColumn);
		int count2 = getEditRequirementJiraFiledsColumnNameByText(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch OLD value of column.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author mdrajib.ali
	 */

	public QAFWebElement getChangeLogTableCellValueOld(String columnName, String columnValue, String requiredColumn) {
		int count1 = getChangeLogTableColumnByName(requiredColumn);
		int count2 = getChangeLogTableColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//del";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch NEW value of column.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author mdrajib.ali
	 */

	public QAFWebElement getChangeLogTableCellValueNew(String columnName, String columnValue, String requiredColumn) {
		int count1 = getChangeLogTableColumnByName(requiredColumn);
		int count2 = getChangeLogTableColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//ins";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will return webelement of sort button corresponds to column passed as
	 * argument.
	 * 
	 * @param columnName
	 * @return QAFWebElement
	 * @author mdrajib.ali
	 */
	public QAFWebElement getSortButtonByColumnDataField(String columnName) {
		String locSortButton = "./thead//th[@data-fieldname='" + columnName + "']//*[contains(@class,'sort')]";
		return findElement(By.xpath(locSortButton));
	}

	/**
	 * Method will return list of web element of specified column from change log
	 * table.
	 * 
	 * @param columnName
	 * @author mdrajib.ali
	 */
	public List<String> getChangeLogTableColumnValues(String columnName) {
		int count = getChangeLogTableColumnByName(columnName);
		List<String> columnValues = new ArrayList<>();
		String locMenuOption = "./tbody//td[" + count + "]//*[self::div or self::a]";
		int size = findElements(By.xpath(locMenuOption)).size();
		for (int i = 0; i < size; i++) {
			columnValues.add(findElements(By.xpath(locMenuOption)).get(i).getText().trim());
		}
		return columnValues;
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCellValueAtSpanTag(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//span";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCheckBoxAtExpandedTCStepByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/parent::td/parent::tr//input[@type='checkbox']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getCopiedStepIconByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'copied-step-icon')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method will verify archived or unarchived state of folder.
	 * 
	 * @param folderName
	 * @author rahul.patil
	 */
	public Select getSelectDropDownByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//select";
		return new Select(findElement(By.xpath(locMenuOption)));
	}

	/**
	 * Method to check box based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getInfoIconByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[contains(@class,'fa-info-circle')]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getChangeLogTableActionColumnCellValue(String columnName, String columnValue,
			String requiredColumn) {
		int count1 = getChangeLogTableColumnByName(requiredColumn);
		int count2 = getChangeLogTableColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "][text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getCheckButtonByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@class,'fa-check')]/parent::button";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to fetch value of column based on known value.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param requiredColumn
	 * @author rahul.patil
	 */
	public QAFWebElement getRemoveButtonByCellValue(String columnName, String columnValue, String requiredColumn) {
		int count1 = getColumnByName(requiredColumn);
		int count2 = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count2 + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//td[" + count1 + "]//*[contains(@class,'fa-remove')]/parent::button";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to web elemnet of setting icon correspont to argument passed.
	 * 
	 * @return QAFWebElement
	 * @author rahul.patil
	 */
	public QAFWebElement getExpandOptionForIntegratedProject(String columnName, String columnValue) {
		int count = getColumnByText(columnName);
		String optionLoc = "./tbody//td[" + count + "]//*[normalize-space(text() = '" + columnValue
				+ "')]/ancestor::tr//em[contains(@class, 'chevron-right')]";
		findElement(By.xpath(optionLoc)).waitForVisible();
		findElement(By.xpath(optionLoc)).waitForEnabled();
		return findElement(By.xpath(optionLoc));
	}

	/**
	 * Method to will return web element of edit button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getScheduleAgentEditButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Edit Schedule']";
		return findElement(By.xpath(locMenuOption));
	}

	/**
	 * Method to will return web element of edit button corresponds to value
	 * provided.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @author rahul.patil
	 */
	public QAFWebElement getScheduleAgentDeleteButtonByCellValue(String columnName, String columnValue) {
		int count = getColumnByName(columnName);
		String locMenuOption = "./tbody//td[" + count + "]//*[text()[normalize-space() = '" + columnValue
				+ "']]/ancestor::tr//*[@title='Delete Schedule']";
		return findElement(By.xpath(locMenuOption));
	}

}