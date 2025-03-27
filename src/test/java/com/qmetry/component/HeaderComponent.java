package com.qmetry.component;

import com.qmetry.locators.HeaderComponentLocators;
import com.qmetry.page.CommonPage;
import com.qmetry.page.LoginPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.annotations.PageIdentifier;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.util.QMetryUtility;

import org.openqa.selenium.By;

/**
 * This class defines HeaderComponent.
 * 
 * @author nidhi.shah
 */
public class HeaderComponent extends QAFWebComponent implements HeaderComponentLocators {
    /**
     * @param locator
     * @return
     */
    protected HeaderComponent(String locator) {
        super(locator);
    }

    public HeaderComponent() {
        super("");
    }

    @FindBy(locator = ICON_SCHEDULERTASK_LOC)
    private QAFWebElement locIconSchedulerTask;

    @FindBy(locator = ICON_BELL_LOC)
    private QAFWebElement locIconBell;

    @FindBy(locator = ICON_COMMENTS_LOC)
    private QAFWebElement locIconComments;

    @FindBy(locator = ICON_HELP_LOC)
    private QAFWebElement locIconHelp;

    @FindBy(locator = LOGO_QTM_PROFESSIONAL_LOC)
    private QAFWebElement locQtmLogo;

    @FindBy(locator = ICON_BARS_LOC)
    private QAFWebElement locIconBars;

    @PageIdentifier
    @FindBy(locator = INPUT_SEARCHBOX_LOC)
    private QAFWebElement locInputSearchBox;

    @FindBy(locator = USER_DROPDOWN_CLOSED_LOC)
    private QAFWebElement locDropdownClosed;

    @FindBy(locator = USER_DROPDOWN_OPENED_LOC)
    private QAFWebElement locDropdownOpened;

    @FindBy(locator = USER_NAME_LOC)
    private QAFWebElement locUsername;

    @FindBy(locator = PROJECT_DROPDOWN_LOC)
    private QAFWebElement locProjectDrpDwn;

    @FindBy(locator = PROJECT_SEARCH_TXT_BOX_LOC)
    private QAFWebElement locProjectSearchTxtBox;

    public QAFWebElement getLocIconSchedulerTaskLnk() {
        return locIconSchedulerTask;
    }

    public QAFWebElement getLocIconBellLnk() {
        return locIconBell;
    }

    public QAFWebElement getLocIconCommentsLnk() {
        return locIconComments;
    }

    public QAFWebElement getLocIconHelpLnk() {
        return locIconHelp;
    }

    public QAFWebElement getLocQtmLogoImg() {
        return locQtmLogo;
    }

    public QAFWebElement getLocIconBarsLnk() {
        return locIconBars;
    }

    public QAFWebElement getLocInputSearchBoxTxtBox() {
        return locInputSearchBox;
    }

    public QAFWebElement getLocDropdownClosedDrpdwn() {
        return locDropdownClosed;
    }

    public QAFWebElement getLocDropdownOpenedDrpdwn() {
        return locDropdownOpened;
    }

    public QAFWebElement getLocUsernameLnk() {
        return locUsername;
    }

    public QAFWebElement getProjectDrpDwn() {
        return locProjectDrpDwn;
    }

    public QAFWebElement getProjectSearchTxtBox() {
        return locProjectSearchTxtBox;
    }

    /**
     * Enum for dropdown options
     * 
     * @author nidhi.shah
     */
    public enum UserNameDropDownOptions {
        ABOUT("About"), PROFILE("Profile"), LOG_OUT("Log out");

        private String menuOption;

        private UserNameDropDownOptions(String menuOption) {
            this.menuOption = menuOption;
        }

        @Override
        public String toString() {
            return menuOption;
        }
    }

    /**
     * A method to check if dropdown is opened.
     * 
     * @return Boolean
     * @author nidhi.shah
     */
    public Boolean isDropdownOpened() {
        return getLocDropdownOpenedDrpdwn().isPresent();
    }

    /**
     * A method to Open the dropdown.
     *
     * @author nidhi.shah
     */
    public void openDropdown() {
        if (!isDropdownOpened()) {
            getLocUsernameLnk().waitForEnabled();
            QMetryUtility.click(getLocUsernameLnk());
        }
        getLocDropdownOpenedDrpdwn().waitForPresent();
        getLocDropdownOpenedDrpdwn().verifyPresent();
    }

    /**
     * A method to close the dropdown.
     *
     * @author nidhi.shah
     */
    public void closeDropdown() {
        if (isDropdownOpened()) {
            getLocUsernameLnk().waitForEnabled();
            getLocUsernameLnk().click();
        }
        getLocDropdownClosedDrpdwn().waitForPresent();
        getLocDropdownClosedDrpdwn().verifyPresent();
    }

    /**
     * A method to logout.
     *
     * @author nidhi.shah
     */
    public void logout() {
        CommonPage commonPage = new CommonPage();
        LoginPage loginPage = new LoginPage();
        openDropdown();
        String locMenuOption = ".//ul//*[text()='" + UserNameDropDownOptions.LOG_OUT.toString() + "']";
        findElement(By.xpath(locMenuOption)).waitForVisible();
        QMetryUtility.click(findElement(By.xpath(locMenuOption)));
        commonPage.getYesLogoutBtn().waitForEnabled();
        QMetryUtility.click(commonPage.getYesLogoutBtn());
        loginPage.getLocLoginBtn().waitForVisible();
        loginPage.getLocLoginBtn().verifyVisible();
    }

    /**
     * A method swich to specified project.
     *
     * @author nidhi.shah
     */
    public void switchToProject(String projectName) {
        getProjectDrpDwn().waitForVisible();
        getProjectDrpDwn().waitForEnabled();
        QMetryUtility.click(getProjectDrpDwn());
        getProjectSearchTxtBox().waitForVisible();
        getProjectSearchTxtBox().waitForEnabled();
        getProjectSearchTxtBox().clear();
        getProjectSearchTxtBox().sendKeys(projectName);
        String locProject = ".//p-multiselectitem//*[contains(text(),'" + projectName + "')]";
        findElement(By.xpath(locProject)).waitForVisible();
        findElement(By.xpath(locProject)).waitForEnabled();
        QMetryUtility.click(findElement(By.xpath(locProject)));
    }
}