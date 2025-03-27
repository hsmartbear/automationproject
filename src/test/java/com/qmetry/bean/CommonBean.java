package com.qmetry.bean;

import java.util.HashMap;
import java.util.List;

import com.qmetry.qaf.automation.data.BaseDataBean;

/**
 * This class defines CommonBean.
 * 
 * @author nidhi.shah
 */
public class CommonBean extends BaseDataBean {

  String folderName;
  String updatedFolderName;
  String comment;
  String updatedComment;
  List<String> priorities;
  List<String> filterEntities;
  String fileName;
  List<String> testCases;
  List<String> testSuites;
  List<String> requirements;
  List<String> issues;
  List<String> entities;
  String entityVersion;
  List<String> statuses;
  List<String> platforms;
  String stepDescription;
  String inputData;
  String expectedOutcome;
  List<String> modules;
  HashMap<String, String> udfData;
  HashMap<String, String> udfValueData;
  List<String> labels;
  List<String> owners;
  List<String> stringUDFTypeValues;
  List<String> lookupListUDFTypeValues;
  String versionComment;
  String startingOnDate;
  String endingOnDate;
  String hourScheduleTime;
  String minuteScheduleTime;
  String secondScheduleTime;
  String recurringDailyCount;
  String recurringWeeklyDay;
  String recurringMonthlyDate;
  String destFolderName;
  String sourceFolderName;
  List<String> folderNames;
  List<String> releases;
  List<String> cycles;
  List<String> users;
  List<String> builds;
  String columnName;
  String releaseName;
  String cycleName;
  String columnValue;
  List<String> projects;
  String fieldName;
  String fieldLabel;
  String fieldLength;
  String project;
  String module;
  String fieldType;
  String listName;
  String valueName;
  String valueAlias;
  List<String> udfTypes;
  List<String> listValues;
  HashMap<String, String> listNameAlias;
  String fieldValue;
  List<String> fieldValues;
  List<String> components;
  List<String> fixVersions;
  String workFlowCTMUrl;
  String workFlowCTMAuthenticationURL;
  String workFlowCTMUserName;
  String workFlowCTMPassword;
  String workFlowCTMTenantID;
  String workFlowCTMClientID;
  String description;
  int dateShiftBy;  
  String user;

  public String getWorkFlowCTMClientID() {
    return workFlowCTMClientID;
  }

  public void setWorkFlowCTMClientID(String workFlowCTMClientID) {
    this.workFlowCTMClientID = workFlowCTMClientID;
  }

  public String getWorkFlowCTMTenantID() {
    return workFlowCTMTenantID;
  }

  public void setWorkFlowCTMTenantID(String workFlowCTMTenantID) {
    this.workFlowCTMTenantID = workFlowCTMTenantID;
  }

  public String getWorkFlowCTMPassword() {
    return workFlowCTMPassword;
  }

  public void setWorkFlowCTMPassword(String workFlowCTMPassword) {
    this.workFlowCTMPassword = workFlowCTMPassword;
  }

  public String getWorkFlowCTMUserName() {
    return workFlowCTMUserName;
  }

  public void setWorkFlowCTMUserName(String workFlowCTMUserName) {
    this.workFlowCTMUserName = workFlowCTMUserName;
  }

  public String getWorkFlowCTMAuthenticationURL() {
    return workFlowCTMAuthenticationURL;
  }

  public void setWorkFlowCTMAuthenticationURL(String workFlowCTMAuthenticationURL) {
    this.workFlowCTMAuthenticationURL = workFlowCTMAuthenticationURL;
  }

  public String getWorkFlowCTMUrl() {
    return workFlowCTMUrl;
  }

  public void setWorkFlowCTMUrl(String workFlowCTMUrl) {
    this.workFlowCTMUrl = workFlowCTMUrl;
  }

  public String getFolderName() {
    return folderName;
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }

  public String getUpdatedFolderName() {
    return updatedFolderName;
  }

  public void setUpdatedFolderName(String updatedFolderName) {
    this.updatedFolderName = updatedFolderName;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getUpdatedComment() {
    return updatedComment;
  }

  public void setUpdatedComment(String updatedComment) {
    this.updatedComment = updatedComment;
  }

  public List<String> getPriorities() {
    return priorities;
  }

  public void setPriorities(List<String> priorities) {
    this.priorities = priorities;
  }

  public List<String> getFilterEntities() {
    return filterEntities;
  }

  public void setFilterEntities(List<String> filterEntities) {
    this.filterEntities = filterEntities;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public List<String> getTestCases() {
    return testCases;
  }

  public void setTestCases(List<String> testCases) {
    this.testCases = testCases;
  }

  public List<String> getRequirements() {
    return requirements;
  }

  public void setRequirements(List<String> requirements) {
    this.requirements = requirements;
  }

  public List<String> getIssues() {
    return issues;
  }

  public void setIssues(List<String> issues) {
    this.issues = issues;
  }

  public String getEntityVersion() {
    return entityVersion;
  }

  public void setEntityVersion(String entityVersion) {
    this.entityVersion = entityVersion;
  }

  public List<String> getTestSuites() {
    return testSuites;
  }

  public void setTestSuites(List<String> testSuites) {
    this.testSuites = testSuites;
  }

  public List<String> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<String> statuses) {
    this.statuses = statuses;
  }

  public List<String> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(List<String> platforms) {
    this.platforms = platforms;
  }

  public String getStepDescription() {
    return stepDescription;
  }

  public void setStepDescription(String stepDescription) {
    this.stepDescription = stepDescription;
  }

  public String getInputData() {
    return inputData;
  }

  public void setInputData(String inputData) {
    this.inputData = inputData;
  }

  public String getExpectedOutcome() {
    return expectedOutcome;
  }

  public void setExpectedOutcome(String expectedOutcome) {
    this.expectedOutcome = expectedOutcome;
  }

  public List<String> getModules() {
    return modules;
  }

  public void setModules(List<String> modules) {
    this.modules = modules;
  }

  public HashMap<String, String> getUdfData() {
    return udfData;
  }

  public void setUdfData(HashMap<String, String> udfData) {
    this.udfData = udfData;
  }

  public HashMap<String, String> getUdfValueData() {
    return udfValueData;
  }

  public void setUdfValueData(HashMap<String, String> udfValueData) {
    this.udfValueData = udfValueData;
  }

  public List<String> getLabels() {
    return labels;
  }

  public void setLabels(List<String> labels) {
    this.labels = labels;
  }

  public List<String> getOwners() {
    return owners;
  }

  public void setOwners(List<String> owners) {
    this.owners = owners;
  }

  public List<String> getStringUDFTypeValues() {
    return stringUDFTypeValues;
  }

  public void setStringUDFTypeValues(List<String> stringUDFTypeValues) {
    this.stringUDFTypeValues = stringUDFTypeValues;
  }

  public List<String> getLookupListUDFTypeValues() {
    return lookupListUDFTypeValues;
  }

  public void setLookupListUDFTypeValues(List<String> lookupListUDFTypeValues) {
    this.lookupListUDFTypeValues = lookupListUDFTypeValues;
  }

  public String getVersionComment() {
    return versionComment;
  }

  public void setVersionComment(String versionComment) {
    this.versionComment = versionComment;
  }

  public String getStartingOnDate() {
    return startingOnDate;
  }

  public void setStartingOnDate(String startingOnDate) {
    this.startingOnDate = startingOnDate;
  }

  public String getEndingOnDate() {
    return endingOnDate;
  }

  public void setEndingOnDate(String endingOnDate) {
    this.endingOnDate = endingOnDate;
  }

  public String getHourScheduleTime() {
    return hourScheduleTime;
  }

  public void setHourScheduleTime(String hourScheduleTime) {
    this.hourScheduleTime = hourScheduleTime;
  }

  public String getMinuteScheduleTime() {
    return minuteScheduleTime;
  }

  public void setMinuteScheduleTime(String minuteScheduleTime) {
    this.minuteScheduleTime = minuteScheduleTime;
  }

  public String getSecondScheduleTime() {
    return secondScheduleTime;
  }

  public void setSecondScheduleTime(String secondScheduleTime) {
    this.secondScheduleTime = secondScheduleTime;
  }

  public String getRecurringDailyCount() {
    return recurringDailyCount;
  }

  public void setRecurringDailyCount(String recurringDailyCount) {
    this.recurringDailyCount = recurringDailyCount;
  }

  public String getRecurringWeeklyDay() {
    return recurringWeeklyDay;
  }

  public void setRecurringWeeklyDay(String recurringWeeklyDay) {
    this.recurringWeeklyDay = recurringWeeklyDay;
  }

  public String getRecurringMonthlyDate() {
    return recurringMonthlyDate;
  }

  public void setRecurringMonthlyDate(String recurringMonthlyDate) {
    this.recurringMonthlyDate = recurringMonthlyDate;
  }

  public String getDestFolderName() {
    return destFolderName;
  }

  public void setDestFolderName(String destFolderName) {
    this.destFolderName = destFolderName;
  }

  public String getSorceFolderName() {
    return sourceFolderName;
  }

  public void setSorceFolderName(String sourceFolderName) {
    this.sourceFolderName = sourceFolderName;
  }

  public List<String> getFolderNames() {
    return folderNames;
  }

  public void setFolderNames(List<String> folderNames) {
    this.folderNames = folderNames;
  }

  public List<String> getReleases() {
    return releases;
  }

  public void setReleases(List<String> releases) {
    this.releases = releases;
  }

  public List<String> getCycles() {
    return cycles;
  }

  public void setCycles(List<String> cycles) {
    this.cycles = cycles;
  }

  public List<String> getUsers() {
    return users;
  }

  public void setUsers(List<String> users) {
    this.users = users;
  }

  public List<String> getBuilds() {
    return builds;
  }

  public void setBuilds(List<String> builds) {
    this.builds = builds;
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public String getReleaseName() {
    return releaseName;
  }

  public void setReleaseName(String releaseName) {
    this.releaseName = releaseName;
  }

  public String getCycleName() {
    return cycleName;
  }

  public void setCycleName(String cycleName) {
    this.cycleName = cycleName;
  }

  public String getColumnValue() {
    return columnValue;
  }

  public void setColumnValue(String columnValue) {
    this.columnValue = columnValue;
  }

  public List<String> getProjects() {
    return projects;
  }

  public void setProjects(List<String> projects) {
    this.projects = projects;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFieldLabel() {
    return fieldLabel;
  }

  public void setFieldLabel(String fieldLabel) {
    this.fieldLabel = fieldLabel;
  }

  public String getFieldLength() {
    return fieldLength;
  }

  public void setFieldLength(String fieldLength) {
    this.fieldLength = fieldLength;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getModule() {
    return module;
  }

  public void setModule(String module) {
    this.module = module;
  }

  public String getFieldType() {
    return fieldType;
  }

  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public String getValueName() {
    return valueName;
  }

  public void setValueName(String valueName) {
    this.valueName = valueName;
  }

  public String getValueAlias() {
    return valueAlias;
  }

  public void setValueAlias(String valueAlias) {
    this.valueAlias = valueAlias;
  }

  public List<String> getUDFTypes() {
    return udfTypes;
  }

  public void setUDFTypes(List<String> udfTypes) {
    this.udfTypes = udfTypes;
  }

  public List<String> getListValues() {
    return listValues;
  }

  public void setListValues(List<String> listValues) {
    this.listValues = listValues;
  }

  public HashMap<String, String> getListNameAlias() {
    return listNameAlias;
  }

  public void setListNameAlias(HashMap<String, String> listNameAlias) {
    this.listNameAlias = listNameAlias;
  }

  public String getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }

  public List<String> getFieldValues() {
    return fieldValues;
  }

  public void setFieldValues(List<String> fieldValues) {
    this.fieldValues = fieldValues;
  }

  public List<String> getComponents() {
    return components;
  }

  public void setComponents(List<String> components) {
    this.components = components;
  }

  public List<String> getFixVersions() {
    return fixVersions;
  }

  public void setFixVersions(List<String> fixVersions) {
    this.fixVersions = fixVersions;
  }

  public List<String> getEntities() {
    return entities;
  }

  public void setEntities(List<String> entities) {
    this.entities = entities;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDateShiftBy() {
    return dateShiftBy;
  }

  public void setDateShiftBy(int dateShiftBy) {
    this.dateShiftBy = dateShiftBy;
  }

  public String getUser() {
    return user;
  }
  
  public void setUser(String user) {
    this.user = user;
  }

}