package com.qmetry.constants;

/**
 * This interface defines DataParameterConstants.
 * 
 * @author rahul.patil
 */
public interface DataParameterConstants extends CommonConstants {

    static final String DATA_PARAMETER_CREATE_SUCCESS = "Data_Parameter created successfully.";
    static final String DATA_PARAMETER_CREATE_FAILED = "Data_Parameter could not be created successfully.";
    static final String DATA_PARAMETER_ARCHIVE_SUCCESS = "Data_Parameter archived successfully";
    static final String DATA_PARAMETER_ARCHIVE_FAILED = "Data_Parameter could not be archived successfully";
    static final String DATA_PARAMETER_UNARCHIVE_SUCCESS = "Data_Parameter unarchived successfully";
    static final String DATA_PARAMETER_UNARCHIVE_FAILED = "Data_Parameter could not be unarchived successfully";
    static final String DATA_PARAMETER_DELETE_SUCCESS = "Data_Parameter deleted successfully";
    static final String DATA_PARAMETER_DELETE_FAILED = "Data_Parameter could not be deleted successfully";
    static final String DATA_PARAMETER_EDIT_SUCCESS = "Data_Parameter edited successfully.";
    static final String DATA_PARAMETER_EDIT_FAILED = "Data_Parameter could not be edited successfully.";
    
    //Values
    static final String SELECT_DATAGRID = "selectDataGrid";
    static final String SELECT_FILL_DATA_MANUALLY = "manually";

    //message 
    static final String  DATA_PARAMETER_ARCHIVE_MSG="You have selected 1 Parameters, which will be archived. Are you sure you want to archive?";
    static final String  DATA_PARAMETER_ARCHIVE_USED_DATA_GRID_MSG="You cannot archive a parameter that is currently used within a Data Grid.";
    static final String DATA_PARAMETER_DELETE_MSG="You have selected 1 Parameters, which will be deleted and no longer accessible. Are you sure you want to delete?";
    static final String DATA_PARAMETER_ELETETE_LINKED_TO_TC_MSG="Deleting parameters that are used in any test case(s) is not allowed.";


}