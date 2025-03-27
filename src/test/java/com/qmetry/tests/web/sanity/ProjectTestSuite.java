package com.qmetry.tests.web.sanity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import com.qmetry.bean.BuildBean;
import com.qmetry.bean.LabelBean;
import com.qmetry.bean.LoginBean;
import com.qmetry.bean.PlatformBean;
import com.qmetry.bean.ProjectBean;
import com.qmetry.component.SidebarComponent.SidebarMenuOptions;
import com.qmetry.constants.CommonConstants;
import com.qmetry.constants.ProjectConstants;
import com.qmetry.constants.TestDataSetupConstants;
import com.qmetry.page.BuildsPage;
import com.qmetry.page.LabelPage;
import com.qmetry.page.LoginPage;
import com.qmetry.page.PlatformPage;
import com.qmetry.page.ProjectPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.RandomStringGenerator;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.tests.webservice.TestDataSetupTestSuite;
import com.qmetry.util.QMetryUtility;

/**
 * This class defines the ProjectTestSuite.
 * 
 * @author nidhi.shah
 */
public class ProjectTestSuite extends WebDriverTestCase {

	LoginBean loginBean;
	LoginPage loginPage;
	ProjectPage projectPage;
	ProjectBean projectBean;
	BuildBean buildBean;
	BuildsPage buildPage;
	LabelBean labelBean;
	LabelPage labelPage;
	PlatformBean platformBean;
	PlatformPage platformPage;

	/**
	 * @throws Exception
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
	}

	/**
	 * @Updatedby nidhi.shah Removed Create Project API Call. Project that is
	 *            created as part of this TC, will be used throughout the execution.
	 *            Added Random data geberation on TC level. Added try - catch to
	 *            create a project using API to continue with rest of the execution.
	 */
	@MetaData("{'summary':'Create project and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" })
	public void project_create() {
		projectBean = new ProjectBean();
		projectPage = new ProjectPage();
		loginPage = new LoginPage();
		loginBean = new LoginBean();
		try {
			Reporter.log("---------------- Create Project ----------------");
			projectBean.fillFromConfig("data.createproject");
			String randomData = RandomStringGenerator.get(4, RandomizerTypes.LETTERS_ONLY)
					+ RandomStringGenerator.get(4, RandomizerTypes.MIXED)
					+ RandomStringGenerator.get(2, RandomizerTypes.DIGITS_ONLY);
			projectBean.setProjectKey(randomData);
			projectBean.setProjectName(projectBean.getProjectName() + "_" + randomData);

			ConfigurationManager.getBundle().setProperty(TestDataSetupConstants.PROJECT_NAME,
					projectBean.getProjectName());
			ConfigurationManager.getBundle().setProperty(TestDataSetupConstants.PROJECT_KEY,
					projectBean.getProjectKey());

			ProjectPage.storeProperties(TestDataSetupConstants.PROJECT_NAME, projectBean.getProjectName());
			ProjectPage.storeProperties(TestDataSetupConstants.PROJECT_KEY, projectBean.getProjectKey());

			loginBean.fillFromConfig("data.login");
			getDriver().get("/");
			loginPage.login(loginBean);
			loginPage.verifyLogin();
			projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
			projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECT_RELEASE_CYCLE);
			projectPage.clickOnNew();
			projectPage.createProject(projectBean);
			assertTrue(projectPage.verifyProject(projectBean), ProjectConstants.PROJECT_CREATE_FAILED,
					ProjectConstants.PROJECT_CREATE_SUCCESS);

			/*projectBean = TestDataSetupTestSuite.createProject();*/
			loginPage.getLocHeaderCmpnnt().logout();
		} catch (Exception e) {
			Reporter.log("Project creation has been failed from UI", MessageTypes.Fail);
			projectBean = TestDataSetupTestSuite.createProject();

			ConfigurationManager.getBundle().setProperty(TestDataSetupConstants.PROJECT_NAME,
					projectBean.getProjectName());
			ConfigurationManager.getBundle().setProperty(TestDataSetupConstants.PROJECT_KEY,
					projectBean.getProjectKey());
			ConfigurationManager.getBundle().setProperty(TestDataSetupConstants.PROJECT_ID, projectBean.getProjectID());

			ProjectPage.storeProperties(TestDataSetupConstants.PROJECT_NAME, projectBean.getProjectName());
			ProjectPage.storeProperties(TestDataSetupConstants.PROJECT_KEY, projectBean.getProjectKey());
			ProjectPage.storeProperties(TestDataSetupConstants.PROJECT_ID, projectBean.getProjectID());
		}
	}

	/**
	 * @Updatedby nidhi.shah Added respective methods for operations and
	 *            verifications and updated TC accordingly.
	 */
	@MetaData("{'summary':'Create, archive, unarchive and delete release and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" }, priority = 13)
	public void release_create_edit_archive_unarchive_delete() {
		projectBean = new ProjectBean();
		projectPage = new ProjectPage();
		loginPage = new LoginPage();
		loginBean = new LoginBean();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		projectPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		projectPage.getMyDashboardText().waitForVisible();
		projectBean.setProjectName(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));

		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECT_RELEASE_CYCLE);
		projectPage.getTable().getCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName(),
				CommonConstants.COLUMN_PROJECTS).click();
		projectPage.verifyProjectName(projectBean.getProjectName());
		projectPage.switchToTab(ProjectConstants.TAB_RELEASE_CYCLE);

		Reporter.log("******************** Create Release ********************");
		projectBean.fillFromConfig("data.createRelease");
		String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		projectBean.setReleaseName(projectBean.getReleaseName() + randomData);
		projectPage.createRelease(projectBean);
		assertTrue(projectPage.verifyRelease(projectBean), ProjectConstants.RELEASE_CREATE_FAILED,
				ProjectConstants.RELEASE_CREATE_SUCCESS);

		Reporter.log("******************** Edit Release Name********************");
		projectBean.fillFromConfig("data.updateReleaseName");
		String randomData1 = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		projectBean.setUpdatedReleaseName(projectBean.getUpdatedReleaseName() + randomData1);
		projectPage.updateReleaseName(projectBean);
		assertTrue(projectPage.verifyEditRelease(projectBean), ProjectConstants.RELEASE_NAME_EDIT_FAILED,
				ProjectConstants.RELEASE_NAME_EDIT_SUCCESS);

		Reporter.log("******************** Archive Release ********************");
		projectBean.setReleaseName(projectBean.getUpdatedReleaseName());
		projectPage.archiveRelease(projectBean);
		assertTrue(projectPage.verifyReleaseIsArchived(projectBean), ProjectConstants.RELEASE_ARCHIVE_FAILED,
				ProjectConstants.RELEASE_ARCHIVE_SUCCESS);

		Reporter.log("******************** Unarchive Release ********************");
		ProjectPage projectPage1 = new ProjectPage();
		projectPage1.unarchiveRelease(projectBean);
		assertTrue(projectPage1.verifyReleaseIsUnarchived(projectBean), ProjectConstants.RELEASE_UNARCHIVE_FAILED,
				ProjectConstants.RELEASE_UNARCHIVE_SUCCESS);

		Reporter.log("******************** Archive Release ********************");
		ProjectPage projectPage2 = new ProjectPage();
		projectPage2.archiveRelease(projectBean);
		assertTrue(projectPage2.verifyReleaseIsArchived(projectBean), ProjectConstants.RELEASE_ARCHIVE_FAILED,
				ProjectConstants.RELEASE_ARCHIVE_SUCCESS);

		Reporter.log("******************** Delete Release ********************");
		ProjectPage projectPage3 = new ProjectPage();
		projectPage3.deleteRelease(projectBean);
		assertTrue(projectPage3.verifyReleaseIsDeleted(projectBean), ProjectConstants.RELEASE_DELETE_FAILED,
				ProjectConstants.RELEASE_DELETE_SUCCESS);

		projectPage3.getLocHeaderCmpnnt().logout();
	}

	/**
	 * @Updatedby nidhi.shah Added respective methods for operations and
	 *            verifications and updated TC accordingly.
	 */
	@MetaData("{'summary':'Create, archive, unarchive and delete cycle and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" }, priority = 12)
	public void cycle_create_edit_archive_unarchive_delete() {
		projectBean = new ProjectBean();
		projectPage = new ProjectPage();
		loginPage = new LoginPage();
		loginBean = new LoginBean();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		projectPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		projectPage.getMyDashboardText().waitForVisible();
		projectBean.setProjectName(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));

		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECT_RELEASE_CYCLE);
		projectPage.getTable().getCellValue("Projects", projectBean.getProjectName(), "Projects").click();
		projectPage.verifyProjectName(projectBean.getProjectName());
		projectPage.switchToTab(ProjectConstants.TAB_RELEASE_CYCLE);

		Reporter.log("******************** Create Release ********************");
		projectBean.fillFromConfig("data.createRelease");
		String _randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		projectBean.setReleaseName(projectBean.getReleaseName() + _randomData);
		projectPage.createRelease(projectBean);
		assertTrue(projectPage.verifyRelease(projectBean), ProjectConstants.RELEASE_CREATE_FAILED,
				ProjectConstants.RELEASE_CREATE_SUCCESS);

		Reporter.log("******************** Create Cycle ********************");
		projectBean.fillFromConfig("data.createCycle");
		String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		projectBean.setCycleName(projectBean.getCycleName() + randomData);
		projectPage.createCycle(projectBean);
		assertTrue(projectPage.verifyCycle(projectBean), ProjectConstants.CYCLE_CREATE_FAILED,
				ProjectConstants.CYCLE_CREATE_SUCCESS);

		Reporter.log("******************** Edit cycle Name********************");
		projectBean.fillFromConfig("data.updateCycleName");
		String randomData1 = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		projectBean.setUpdatedCycleName(projectBean.getUpdatedCycleName() + randomData1);
		projectPage.updateCycleName(projectBean);
		assertTrue(projectPage.verifyEditCycle(projectBean), ProjectConstants.CYCLE_NAME_EDIT_FAILED,
				ProjectConstants.CYCLE_NAME_EDIT_SUCCESS);

		Reporter.log("******************** Archive Cycle ********************");
		projectBean.setCycleName(projectBean.getUpdatedCycleName());
		projectPage.archiveCycle(projectBean);
		assertTrue(projectPage.verifyCycleIsArchived(projectBean), ProjectConstants.CYCLE_ARCHIVE_FAILED,
				ProjectConstants.CYCLE_ARCHIVE_SUCCESS);

		Reporter.log("******************** Unarchive Cycle ********************");
		ProjectPage projectPage1 = new ProjectPage();
		projectPage1.unarchivecycle(projectBean);
		assertTrue(projectPage1.verifyCycleIsUnarchived(projectBean), ProjectConstants.CYCLE_UNARCHIVE_FAILED,
				ProjectConstants.CYCLE_UNARCHIVE_SUCCESS);

		Reporter.log("******************** Archive Cycle ********************");
		ProjectPage projectPage2 = new ProjectPage();
		projectPage2.archiveCycle(projectBean);
		assertTrue(projectPage2.verifyCycleIsArchived(projectBean), ProjectConstants.CYCLE_ARCHIVE_FAILED,
				ProjectConstants.CYCLE_ARCHIVE_SUCCESS);

		Reporter.log("******************** Delete Cycle ********************");
		ProjectPage projectPage3 = new ProjectPage();
		projectPage3.deleteCycle(projectBean);
		assertTrue(projectPage3.verifyCycleIsDeleted(projectBean), ProjectConstants.CYCLE_DELETE_FAILED,
				ProjectConstants.CYCLE_DELETE_SUCCESS);

		projectPage3.getLocHeaderCmpnnt().logout();
	}

	/**
	 * @Updatedby nidhi.shah Added respective methods for operations and
	 *            verifications and updated TC accordingly.
	 */
	@MetaData("{'summary':'Create, archive and unarchive build and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" }, priority = 1)
	public void build_create_edit_archive_unarchive() {
		buildBean = new BuildBean();
		buildPage = new BuildsPage();
		loginPage = new LoginPage();
		loginBean = new LoginBean();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		buildPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		buildPage.getMyDashboardText().waitForVisible();

		buildPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		buildPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.BUILDS);
		buildPage.clickOnNew();
		buildBean.fillFromConfig("data.createbuild");
		String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		buildBean.setBuildName(buildBean.getBuildName() + randomData);

		Reporter.log("******************** Create Build ********************");
		buildPage.createBuild(buildBean);
		assertTrue(buildPage.verifyBuild(buildBean), ProjectConstants.BUILD_CREATE_FAILED,
				ProjectConstants.BUILD_CREATE_SUCCESS);

		Reporter.log("******************** Edit build Name********************");
		buildBean.fillFromConfig("data.updateBuildName");
		String randomData1 = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		buildBean.setUpdatedBuildName(buildBean.getUpdatedBuildName() + randomData1);
		buildPage.updateBuildName(buildBean);
		buildPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.BUILDS);
		assertTrue(buildPage.verifyEditBuild(buildBean), ProjectConstants.BUILD_NAME_EDIT_FAILED,
				ProjectConstants.BUILD_NAME_EDIT_SUCCESS);

		Reporter.log("******************** Archive Build ********************");
		buildBean.setBuildName(buildBean.getUpdatedBuildName());
		buildPage.archiveBuild(buildBean);
		assertTrue(buildPage.verifyBuildIsArchived(buildBean), ProjectConstants.BUILD_ARCHIVE_FAILED,
				ProjectConstants.BUILD_ARCHIVE_SUCCESS);

		Reporter.log("******************** Unarchive Build ********************");
		buildPage.unarchiveBuild(buildBean);
		assertTrue(buildPage.verifyBuildIsUnarchived(buildBean), ProjectConstants.BUILD_UNARCHIVE_FAILED,
				ProjectConstants.BUILD_UNARCHIVE_SUCCESS);

		loginPage.getLocHeaderCmpnnt().logout();
	}

	/**
	 * @Updatedby nidhi.shah Added respective methods for operations and
	 *            verifications and updated TC accordingly.
	 */
	@MetaData("{'summary':'Create, archive, unarchive and delete label and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" }, priority = 2)
	public void label_create_edit_archive_unarchive_delete() {
		loginPage = new LoginPage();
		loginBean = new LoginBean();
		labelBean = new LabelBean();
		labelPage = new LabelPage();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		labelPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		labelPage.getMyDashboardText().waitForVisible();

		labelPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		labelPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.LABELS);
		labelPage.clickOnNew();
		labelBean.fillFromConfig("data.createlabel");
		String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		labelBean.setLabelAlias(labelBean.getLabelAlias() + randomData);
		labelBean.setLabelName(labelBean.getLabelName() + randomData);

		Reporter.log("******************** Create Label ********************");
		labelPage.createLabel(labelBean);
		assertTrue(labelPage.verifyLabel(labelBean), ProjectConstants.LABEL_CREATE_FAILED,
				ProjectConstants.LABEL_CREATE_SUCCESS);

		Reporter.log("******************** Edit label Name********************");
		labelBean.fillFromConfig("data.updateLabelAlias");
		String randomData1 = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		labelBean.setUpdatedLabelAlias(labelBean.getUpdatedLabelAlias() + randomData1);
		labelPage.updateLabelAlias(labelBean);
		assertTrue(labelPage.verifyEditLabel(labelBean), ProjectConstants.LABEL_NAME_EDIT_FAILED,
				ProjectConstants.LABEL_NAME_EDIT_SUCCESS);

		Reporter.log("******************** Archive Label ********************");
		labelBean.setLabelAlias(labelBean.getUpdatedLabelAlias());
		labelPage.archiveLabel(labelBean);
		assertTrue(labelPage.verifyLabelIsArchived(labelBean), ProjectConstants.LABEL_ARCHIVE_FAILED,
				ProjectConstants.LABEL_ARCHIVE_SUCCESS);

		Reporter.log("******************** Unarchive Label ********************");
		labelPage.unarchiveLabel(labelBean);
		assertTrue(labelPage.verifyLabelIsUnarchived(labelBean), ProjectConstants.LABEL_UNARCHIVE_FAILED,
				ProjectConstants.LABEL_UNARCHIVE_SUCCESS);

		Reporter.log("******************** Archive Label ********************");
		labelPage.archiveLabel(labelBean);
		assertTrue(labelPage.verifyLabelIsArchived(labelBean), ProjectConstants.LABEL_ARCHIVE_FAILED,
				ProjectConstants.LABEL_ARCHIVE_SUCCESS);

		Reporter.log("******************** Delete Label ********************");
		labelPage.deleteLabel(labelBean);
		assertTrue(labelPage.verifyLabelIsDeleted(labelBean), ProjectConstants.LABEL_DELETE_FAILED,
				ProjectConstants.LABEL_DELETE_SUCCESS);

		loginPage.getLocHeaderCmpnnt().logout();

	}

	/**
	 * @Updatedby nidhi.shah Added respective methods for operations and
	 *            verifications and updated TC accordingly.
	 */
	@MetaData("{'summary':'Create, archive, unarchive and delete platform and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" }, priority = 3)
	public void platform_create_edit_archive_unarchive_delete() {
		loginPage = new LoginPage();
		loginBean = new LoginBean();
		platformBean = new PlatformBean();
		platformPage = new PlatformPage();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		platformPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		platformPage.getMyDashboardText().waitForVisible();

		platformPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		platformPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PLATFORMS_ATTRIBUTES);
		platformPage.clickOnNew();
		platformBean.fillFromConfig("data.createplatform");
		String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		platformBean.setPlatformName(platformBean.getPlatformName() + randomData);

		Reporter.log("******************** Create Platform ********************");
		platformPage.createPlatform(platformBean);
		assertTrue(platformPage.verifyPlatform(platformBean), ProjectConstants.PLATFORM_CREATE_FAILED,
				ProjectConstants.PLATFORM_CREATE_SUCCESS);

		Reporter.log("******************** Edit platform Name********************");
		platformBean.fillFromConfig("data.updatePlatformName");
		String randomData1 = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		platformBean.setUpdatedPlatformName(platformBean.getUpdatedPlatformName() + randomData1);
		platformPage.updatePlatformName(platformBean);
		assertTrue(platformPage.verifyEditPlatform(platformBean), ProjectConstants.PLATFORM_NAME_EDIT_FAILED,
				ProjectConstants.PLATFORM_NAME_EDIT_SUCCESS);

		Reporter.log("******************** Archive Platform ********************");
		platformBean.setPlatformName(platformBean.getUpdatedPlatformName());
		platformPage.archivePlatform(platformBean);
		assertTrue(platformPage.verifyPlatformIsArchived(platformBean), ProjectConstants.PLATFORM_ARCHIVE_FAILED,
				ProjectConstants.PLATFORM_ARCHIVE_SUCCESS);

		Reporter.log("******************** Unrchive Platform ********************");
		platformPage.unarchivePlatform(platformBean);
		assertTrue(platformPage.verifyPlatformIsUnarchived(platformBean), ProjectConstants.PLATFORM_UNARCHIVE_FAILED,
				ProjectConstants.PLATFORM_UNARCHIVE_SUCCESS);

		Reporter.log("******************** Archive Platform ********************");
		platformPage.archivePlatform(platformBean);
		assertTrue(platformPage.verifyPlatformIsArchived(platformBean), ProjectConstants.PLATFORM_ARCHIVE_FAILED,
				ProjectConstants.PLATFORM_ARCHIVE_SUCCESS);

		Reporter.log("******************** Delete Platform ********************");
		platformPage.deletePlatform(platformBean);
		assertTrue(platformPage.verifyPlatformIsDeleted(platformBean), ProjectConstants.PLATFORM_DELETE_FAILED,
				ProjectConstants.PLATFORM_DELETE_SUCCESS);

		loginPage.getLocHeaderCmpnnt().logout();
	}

	/**
	 * @Updatedby nidhi.shah Added respective methods for operations and
	 *            verifications and updated TC accordingly.
	 * @param data
	 */
	@QAFDataProvider(dataFile = "resources/testdata/bdd_data.xls", sheetName = "bdd_data", key = "bdd")
	@MetaData("{'summary':'Add BDD Configuration and verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, groups = { "sanity-primary", "project", "sanity" }, priority = 4)
	public void addBddConfigurationAndVerify(Map<String, String> data) {
		projectBean = new ProjectBean();
		projectPage = new ProjectPage();
		loginPage = new LoginPage();
		loginBean = new LoginBean();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		projectPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		projectPage.getMyDashboardText().waitForVisible();
		projectBean.setProjectName(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		projectBean.setVersionControlSystem(data.get("VCSType"));
		projectBean.setRepoUrl(data.get("URL"));
		projectBean.setUsername(data.get("Username"));
		projectBean.setPassword(data.get("Password"));
		projectBean.setAccessToken(data.get("AccessToken"));

		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECT_RELEASE_CYCLE);
		projectPage.getTable().getCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName(),
				CommonConstants.COLUMN_PROJECTS).click();
		projectPage.verifyProjectName(projectBean.getProjectName());
		projectPage.switchToTab(ProjectConstants.TAB_BDD_CONFIGURATION);

		Reporter.log("******************** Add Configuration ********************");
		projectPage.addBddConfiguration(projectBean);
		assertTrue(projectPage.verifyBDDConfiguration(data.get("URL")), ProjectConstants.BDD_CONFIGURATION_ADD_FAILED,
				ProjectConstants.BDD_CONFIGURATION_ADD_SUCCESS);

		Reporter.log("******************** Delete Configuration ********************");
		projectPage.deleteBDDConfiguration(data.get("URL"));
		assertTrue(projectPage.verifyBDDConfigurationIsDeleted(data.get("URL")),
				ProjectConstants.BDD_CONFIGURATION_DELETE_FAILED, ProjectConstants.BDD_CONFIGURATION_DELETE_SUCCESS);

		loginPage.getLocHeaderCmpnnt().logout();
	}

	@MetaData("{'summary':'Edit project name And Verify', 'module':'project', 'testcaseID':'TBD', 'author':'rahul.patil'}")
	@Test(enabled = true, priority = 11)
	public void project_edit_archive_delete() {
		projectBean = new ProjectBean();
		projectPage = new ProjectPage();
		loginPage = new LoginPage();
		loginBean = new LoginBean();
		projectBean = TestDataSetupTestSuite.createProject();

		loginBean.fillFromConfig("data.login");
		getDriver().get("/");
		loginPage.login(loginBean);
		loginPage.verifyLogin();

		loginPage.getMyDashboardText().waitForVisible();
		projectPage.getLocHeaderCmpnnt()
				.switchToProject(ConfigurationManager.getBundle().getString(TestDataSetupConstants.PROJECT_NAME));
		projectPage.getMyDashboardText().waitForVisible();

		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECT_RELEASE_CYCLE);

		projectPage.getTable().getCellValue(CommonConstants.COLUMN_PROJECTS, projectBean.getProjectName(),
				CommonConstants.COLUMN_PROJECTS).click();
		projectPage.verifyProjectName(projectBean.getProjectName());

		Reporter.log("---------------- Edit Project name ----------------");
		projectBean.fillFromConfig("data.updateProjectName");
		String randomData = RandomStringGenerator.get(1, RandomizerTypes.LETTERS_ONLY)
				+ RandomStringGenerator.get(3, RandomizerTypes.MIXED)
				+ RandomStringGenerator.get(1, RandomizerTypes.DIGITS_ONLY);
		projectBean.setUpdatedProjectName(projectBean.getUpdatedProjectName() + randomData);
		projectPage.updateProjectName(projectBean);

		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECTS);
		projectPage.getLocSidebarCmpnnt().selectMenuOption(SidebarMenuOptions.PROJECT_RELEASE_CYCLE);
		assertTrue(projectPage.verifyEditProject(projectBean), ProjectConstants.PROJECT_NAME_EDIT_FAILED,
				ProjectConstants.PROJECT_NAME_EDIT_SUCCESS);

		Reporter.log("******************** Archive project ********************");
		projectBean.setProjectName(projectBean.getUpdatedProjectName());
		projectPage.archiveProject(projectBean);
		assertTrue(projectPage.verifyProjectIsArchieved(projectBean), ProjectConstants.PROJECT_ARCHIVE_FAILED,
				ProjectConstants.PROJECT_ARCHIVE_SUCCESS);

		Reporter.log("******************** Delete project ********************");
		projectPage.deleteProject(projectBean);
		assertTrue(
				projectPage.verifyAlertDialog(
						"Project (" + projectBean.getUpdatedProjectName() + ") deletion has been begun."),
				ProjectConstants.PROJECT_DELETE_FAILED, ProjectConstants.PROJECT_DELETE_SUCCESS);
		QMetryUtility.click(projectPage.getCloseMessageBtn());
		assertTrue(projectPage.verifyProjectIsDeleted(projectBean), ProjectConstants.PROJECT_DELETE_FAILED,
				ProjectConstants.PROJECT_DELETE_SUCCESS);

		/* projectPage.getLocHeaderCmpnnt().logout(); */

	}
}
