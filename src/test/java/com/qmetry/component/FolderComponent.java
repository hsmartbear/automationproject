package com.qmetry.component;

import java.util.ArrayList;
import java.util.List;

import com.qmetry.locators.FolderComponentLocators;
import com.qmetry.page.CommonPage.Options;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.util.QMetryUtility;

import org.openqa.selenium.By;

/**
 * This class defines FolderComponent.
 * 
 * @author rahul.patil
 */
public class FolderComponent extends QAFWebComponent implements FolderComponentLocators {

    /**
     * @param drivlocatorer
     * @return
     */
    protected FolderComponent(String locator) {
        super(locator);
    }

    public FolderComponent() {
        super("");
    }

    @FindBy(locator = ROOT_FOLDER_LOC)
    private QAFWebElement locRootFolder;

    @FindBy(locator = FOLDER_OPERATION_DRP_DWN_LOC)
    private QAFWebElement locFolderOperationDrpDwn;

    @FindBy(locator = FOLDER_NAME_LIST_LOC)
    private List<QAFWebElement> locFolderNameList;

    @FindBy(locator = FOLDER_SORT_OPERATION_DRP_DWN_LOC)
    private QAFWebElement locFolderSortOperationDrpDwn;

    public QAFWebElement getRootFolder() {
        return locRootFolder;
    }

    public QAFWebElement getFolderOperationDrpDwn() {
        return locFolderOperationDrpDwn;
    }

    public List<QAFWebElement> getFolderNameList() {
        return locFolderNameList;
    }

    public QAFWebElement getFolderSortOperationDrpDwn() {
        return locFolderSortOperationDrpDwn;
    }

    /**
     * Method will verify archived or unarchived state of folder.
     * 
     * @param folderName
     * @author rahul.patil
     */
    public void verifyFolderArchived(String folderName) {
        String folderLoc = "xpath=.//*[text()='" + folderName + "']//ancestor::li[contains(@class,'p-treenode-leaf')]";
        findElement(folderLoc).waitForVisible();
        if (findElement(folderLoc).getAttribute("class").contains("archived")) {
            Reporter.log(folderName + " folder is in archived state", MessageTypes.Pass);
        } else {
            Reporter.log(folderName + " folder is in unarchived state", MessageTypes.Fail);
        }
    }

    /**
     * Method will verify archived or unarchived state of folder.
     * 
     * @param folderName
     * @author rahul.patil
     */
    public void verifyFolderUnarchived(String folderName) {
        String folderLoc = "xpath=.//*[text()='" + folderName + "']//ancestor::li[contains(@class,'p-treenode-leaf')]";
        findElement(folderLoc).waitForVisible();
        if (!findElement(folderLoc).getAttribute("class").contains("archived")) {
            Reporter.log(folderName + " folder is in unarchived state", MessageTypes.Pass);
        } else {
            Reporter.log(folderName + " folder is in archived state", MessageTypes.Fail);
        }
    }

    /**
     * Method will verify archived or unarchived state of folder.
     * 
     * @param folderName
     * @author rahul.patil
     */
    public boolean isFolderArchived(String folderName) {
        String folderLoc = "xpath=.//*[text()='" + folderName + "']//ancestor::*[@role and @aria-label]/parent::*";
        findElement(folderLoc).waitForVisible();
        return findElement(folderLoc).getAttribute("class").contains("archived");
    }

    /**
     * A method to select an option from the 'Option' menu
     * 
     * @param option
     */
    public void selectFolderOption(Options option) {
        String _option = option.toString();
        getFolderOperationDrpDwn().waitForEnabled();
        QMetryUtility.click(getFolderOperationDrpDwn());
        String eleOption = ".//a[text()='" + _option + "']";
        findElement(By.xpath(eleOption)).waitForVisible();
        findElement(By.xpath(eleOption)).waitForEnabled();
        QMetryUtility.click(findElement(By.xpath(eleOption)));

    }

    /**
     * Method will return list of available folder name.
     * 
     * @author rahul.patil
     */
    public List<String> getFolderList() {
        List<String> folderNameList = new ArrayList<>();
        if (getFolderNameList().get(0).isPresent())
            for (int i = 0; i < getFolderNameList().size(); i++) {
                folderNameList.add(getFolderNameList().get(i).getText());
            }
        return folderNameList;
    }

    /**
     * A method to select an option from the 'Option' menu
     * 
     * @param option
     */
    public void selectFolderSortOption(Options option) {
        String _option = option.toString();
        getFolderSortOperationDrpDwn().waitForEnabled();
        QMetryUtility.click(getFolderSortOperationDrpDwn());
        String eleOption = ".//*[text()='" + _option + "']/preceding-sibling::input[@type='radio']";
        findElement(By.xpath(eleOption)).waitForVisible();
        findElement(By.xpath(eleOption)).waitForEnabled();
        QMetryUtility.click(findElement(By.xpath(eleOption)));

    }

    /**
     * A method to select an option from the 'Option' menu
     * 
     * @param option
     */
    public void selectFolderFilterOption(Options option, boolean isSelect) {
        String _option = option.toString();
        getFolderSortOperationDrpDwn().waitForEnabled();
        QMetryUtility.click(getFolderSortOperationDrpDwn());
        String eleOption = ".//*[text()='" + _option + "']/preceding-sibling::input[@type='checkbox']";
        findElement(By.xpath(eleOption)).waitForVisible();
        findElement(By.xpath(eleOption)).waitForEnabled();
        if (isSelect == true) {
            if (!findElement(By.xpath(eleOption)).isSelected()) {
                findElement(By.xpath(eleOption)).waitForEnabled();
                findElement(By.xpath(eleOption)).click();
            } else {
                getFolderSortOperationDrpDwn().waitForEnabled();
                QMetryUtility.click(getFolderSortOperationDrpDwn());
            }

        } else {
            if (isSelect == false) {
                if (findElement(By.xpath(eleOption)).isSelected()) {
                    findElement(By.xpath(eleOption)).waitForEnabled();
                    findElement(By.xpath(eleOption)).click();
                } else {
                    getFolderSortOperationDrpDwn().waitForEnabled();
                    QMetryUtility.click(getFolderSortOperationDrpDwn());
                }
            }
        }
    }

    /**
     * Method will return list of available folder name.
     * 
     * @author rahul.patil
     */
    public List<String> getChildFolderList(String parentFolderName) {
        List<String> columnNames = new ArrayList<>();
        String headerLoc = "xpath=.//*[@role='treeitem' and @aria-label='" + parentFolderName
                + "']/following-sibling::*[contains(@class,'children')]//*[@role='treeitem']";
        findElements(headerLoc).get(0).waitForVisible();
        int size = findElements(headerLoc).size();
        for (int i = 0; i < size; i++) {
            columnNames.add(findElements(headerLoc).get(i).getAttribute("aria-label"));
        }
        return columnNames;
    }

    /**
     * Method will return list of available folder name.
     * 
     * @author rahul.patil
     */
    public void goToChildFolder(String parentFolderName, String childFolderName) {
        String locFolder = "xpath=.//*[@role='treeitem' and @aria-label='" + parentFolderName
                + "']/following-sibling::*[contains(@class,'children')]//*[@role='treeitem' and @aria-label='"
                + childFolderName + "']";
        findElement(locFolder).verifyVisible();
        findElement(locFolder).click();
    }

}