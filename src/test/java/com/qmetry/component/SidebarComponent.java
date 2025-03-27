package com.qmetry.component;

import com.qmetry.locators.SidebarComponentLocators;
import com.qmetry.page.CommonPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.util.QMetryUtility;

import org.openqa.selenium.By;

/**
 * This class defines SidebarComponent.
 * 
 * @author nidhi.shah
 */
public class SidebarComponent extends QAFWebComponent implements SidebarComponentLocators {

    /**
     * @param drivlocatorer
     * @return
     */
    protected SidebarComponent(String locator) {
        super(locator);
    }

    public SidebarComponent() {
        super("");
    }

    /**
     * A enum for Sidebar menu options
     *
     * @author nidhi.shah
     */
    public enum SidebarMenuOptions {
        REQUIREMENTS("Requirements"), TESTCASES("Test Cases"), TESTSUITES("Test Suites"), ISSUES("Issues"),
        PROJECTS("Project Management"), CUSTOMIZATION("Customization"), INTEGRATION("Integration"), BUILDS("Builds"),
        PROJECT_RELEASE_CYCLE("Projects  "), PLATFORMS_ATTRIBUTES("Platforms & Attributes"),
        LABELS("Labels"), USERS("Users"), EXECUTION_STATUS("Execution Status"), MANAGE_FIELDS("Manage Fields"),
        DATAGRID("DataGrid"), DATAPARAMETER("Data Parameter"), TESTCASE("Test Case"), LISTS("Lists"),
        INTEGRATION_CONFIGURATION("Integration Configurations"), INTEGRATIONS("Integrations"), LDAPSAML("LDAP/SAML"),
        ROLES("Roles"), OPEN_API("Open API"), NOTIFICATIONS("Notifications"), APPROVAL_ACCESS("Approval Access"),
        ESIGNATURE("eSignature"), QMETRY_INSIGHT("QMetry Insight"), ADVANCE_QUERY_REPORTS("Advance Query Reports"),
        QMETRY_CUSTOM_DASHBOARD("QMetry Custom Dashboard"), QMETRY_SYSTEM_REPORTS("QMetry System Reports"),
        REQUIREMENT_REPORT("Requirement Report"), TESTCASE_REPORT("Test Case Report"),
        ISSUE_ANALYSIS_REPORT("Issue Analysis Report"), EXECUTION_SUMMARY_REPORT("Execution Summary Report"),
        PLATFORM_REPORT("Platform Report"), TOP_ISSUE_REPORT("Top Issues Report"),
        REUSABILITY_REPORT("Reusability Report"), TRACEABILITY_REPORT("Traceability Report"),
        TEST_EXECUTION_SUMMARY_BY_FOLDER("Test Execution Summary by Folder"),
        RELEASE_CYCLE_REPORT("Release Cycle Report"), QMETRY_CUSTOM_GADGET("QMetry Custom Gadget"),
        TEST_RESULT_LOG_REPORT("Test Result Log Report"), LOGIN_SUMMARY_DASHBOARD("Login Summary Dashboard"),
        APPROVAL_WORKFLOW_REPORT("Approval Workflow Report"), GENERAL_SETTING_AND_AUDIT("General Settings & Audit"),
        MY_DASHBOARD("My Dashboard"), PROJECTS_SPANISH("Proyectos"),
        PROJECT_RELEASE_CYCLE_SPANISH("Proyecto / Lanzamiento / Ciclo "), ESIGNATURE_SPANISH("eFirma"),
        APPROVAL_ACCESS_SPANISH("Acceso de aprobación"), TESTSUITES_SPANISH("Suites de prueb"),
        AUDIT_COMPLIANCE("Audit Compliance"), AUDIT_LOG_REPORT("Audit Log Report"), VISUAL_REPORTS("Visual Reports"),
        CHANGE_LOG_REPORT("Change Log Report"), AUTOMATION_AGENT("Automation Agent"),
        LAYOUT_MANAGEMENT("Layout Management"), ISSUE_TREANDS_REPORT("Issue Trends Report"),
        QMETRY_INTELLIGENCE("QMetry Intelligence"), SEARCH_ASK_ME_ANYTHING("Search - Ask me anything"),
        RISK_TRACEABILITY_FOR_REQUIREMENTS("Risk Traceability for Requirements"),
        RISK_TRACEABILITY_FOR_TESTCASES("Risk Traceability for Test Cases"),
        FLAKY_SCORE_SETTINGS("Flaky Score Settings"), SUCCESS_RATE_SETTINGS("Success Rate Settings"),
        TESTCASES_DEPENDENCY_REPORT("Test Cases Dependency Report"),
        TESTCASE_EXECUTION_DEPENDENCY_REPORT("Test Case Execution Dependency Report");

        private String menuOption;

        private SidebarMenuOptions(String menuOption) {
            this.menuOption = menuOption;
        }

        @Override
        public String toString() {
            return menuOption;
        }
    }

    /**
     * Method to click sidebar option
     * 
     * @param sidebarMenuOptions
     * @author nidhi.shah
     */
    public void selectMenuOption(SidebarMenuOptions sidebarMenuOptions) {
        new CommonPage().openSidebar();
        String locMenuOption = ".//*[@role='navigation']//*[text()='" + sidebarMenuOptions + "']";
        findElement(By.xpath(locMenuOption)).waitForVisible();
        findElement(By.xpath(locMenuOption)).waitForEnabled();
        QMetryUtility.click(findElement(By.xpath(locMenuOption)));
    }

    /**
     * Method to click sidebar option
     * 
     * @param sidebarMenuOptions
     * @author nidhi.shah
     */
    public void selectQmetrySystemReportsMenuOption(SidebarMenuOptions sidebarMenuOptions) {
        new CommonPage().openSidebar();
        String locMenuOption = ".//*[@role='navigation']//a[@title='QMetry System Reports']/following-sibling::*//*[text()='"
                + sidebarMenuOptions + "']";
        findElement(By.xpath(locMenuOption)).waitForVisible();
        findElement(By.xpath(locMenuOption)).waitForEnabled();
        QMetryUtility.click(findElement(By.xpath(locMenuOption)));
    }

    /**
     * Method to verify active tab.
     * 
     * @param sidebarMenuOptions
     * @author rahul.patil
     */
    public boolean verifyActiveTab(SidebarMenuOptions sidebarMenuOptions) {
        String locMenuOption = ".//*[@role='navigation']//*[text()='" + sidebarMenuOptions + "']/parent::li";
        findElement(By.xpath(locMenuOption)).waitForVisible();
        findElement(By.xpath(locMenuOption)).waitForEnabled();
        return findElement(By.xpath(locMenuOption)).getAttribute("class").contains("active");
    }

}