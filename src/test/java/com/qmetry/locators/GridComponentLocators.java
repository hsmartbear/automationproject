package com.qmetry.locators;

/**
 * This interface defines GridComponentLocators.
 * 
 * @author rahul.patil
 */
public interface GridComponentLocators extends CommonPageLocators {

    static final String COLUMN_LIST = "column.list";
    static final String COLUMN_LIST_TEXT = "text.cloumn.list";
    static final String SELECT_ALL_ENTITY_CHECK_BOX = "checkbox.select.all.entity";
    static final String SELECTED_ENTITIES_CHECK_BOXES = "checkboxes.selected.entities";
    
    static final String INITIAL_COUNT_LABEL_LOC="table.initial.count.label";
    static final String PAGE_LIMIT_COUNT_LABEL_LOC="table.page.limit.count.label";
    static final String TOTAL_COUNT_LABEL_LOC="table.total.count.label";
    static final String NEXT_PAGE_BTN_LOC="table.button.next.page";
    static final String LAST_PAGE_BTN_LOC="table.button.last.page";
    static final String PREVIOUS_PAGE_BTN_LOC="table.button.previous.page";
    static final String FIRST_PAGE_BTN_LOC="table.button.first.page";
    static final String DATA_GRID_COLUMN_LIST_DATA_TABLE_LOC="column.list.dt";
    static final String RAW_LIST="raw.list";
    static final String COLUMN_LIST_PARAM_LINK_TABLE="column.list.param.link.table";
    static final String COLUMN_LIST_WITH_HIDDEN_FIELD = "column.list.with.hidden.field";
    static final String COLUMN_LIST_WITH_TITLE_ATTRIBUTE = "column.list.with.title.attribute";
    static final String REPORT_COLUMN_LIST = "report.column.list";
    static final String EDIT_ISSUE_JIRA_FIELD_COLUMN_LIST = "edit.issue.jira.field.column.list";
    static final String EDIT_REQUIREMENT_JIRA_FIELD_COLUMN_LIST = "edit.requirement.jira.field.column.list";
}