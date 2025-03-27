package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This interface defines ManageFieldsConstants.
 * 
 * @author rahul.patil
 */
public interface ManageFieldsConstants extends CommonConstants {

        // Custom Verification Messages for report
        static final String UDF_CREATE_SUCCESS = "UDF created successfully.";
        static final String UDF_CREATE_FAILED = "UDF could not be created successfully.";
        static final String UDF_DELETE_SUCCESS = "UDF deleted successfully";
        static final String UDF_DELETE_FAILED = "UDF could not be deleted successfully";
        static final String UDF_PROJECT_UNLINK_SUCCESS = "Project unlinked successfully";
        static final String UDF_PROJECT_UNLINK_FAILED = "Project could not be unlinked successfully";

        ArrayList<String> fieldTypeDropDownValues = new ArrayList<>(
                        Arrays.asList("None", "Process", "Product", "Project"));
        ArrayList<String> riskCategoryDropDownValues = new ArrayList<>(Arrays.asList("None", "Usability", "Performance",
                        "Data Quality", "Localization", "Functionality", "User Interface", "Interoperability",
                        "Security/Privacy", "Standards Compliance", "Packaging/Fulfillment", "Date and Time Handling",
                        "Competitive Inferiority", "States and Transactions", "Networked and Distributed",
                        "Load, Capacity, and Volume", "Operations and Maintenance", "Error Handling and Recovery",
                        "Disaster Handling and Recovery", "Reliability, Availability, and Stability",
                        "Installation, Setup, Upgrade, and Migration",
                        "Portability, Configuration, and Compatibility"));

        ArrayList<String> likelihoodDropDownValues = new ArrayList<>(
                        Arrays.asList("1", "2", "3", "4", "5", "1.5", "2.5", "3.5", "4.5"));

        ArrayList<String> impactDropDownValues = new ArrayList<>(
                        Arrays.asList("1", "2", "3", "4", "5", "1.5", "2.5", "3.5", "4.5"));

        Map<String, String> riskTypeNameAlias = new HashMap<String, String>() {
                {
                        put("None", "None");
                        put("Process", "Process");
                        put("Product", "Product");
                        put("Project", "Project");
                }
        };

        Map<String, String> riskCategoryNameAlias = new HashMap<String, String>() {
                {
                        put("None", "None");
                        put("User Interface", "User Interface");
                        put("Usability", "Usability");
                        put("States and Transactions", "States and Transactions");
                        put("Standards Compliance", "Standards Compliance");
                        put("Security/Privacy", "Security/Privacy");
                        put("Reliability, Availability, and Stability", "Reliability, Availability, and Stability");
                        put("Portability, Configuration, and Compatibility", "Portability, Configuration, and Compatibility");
                        put("Performance", "Performance");
                        put("Packaging/Fulfillment", "Packaging/Fulfillment");
                        put("Operations and Maintenance", "Operations and Maintenance");
                        put("Networked and Distributed", "Networked and Distributed");
                        put("Localization", "Localization");
                        put("Load, Capacity, and Volume", "Load, Capacity, and Volume");
                        put("Interoperability", "Interoperability");
                        put("Installation, Setup, Upgrade, and Migration", "Installation, Setup, Upgrade, and Migration");
                        put("Functionality", "Functionality");
                        put("Error Handling and Recovery", "Error Handling and Recovery");
                        put("Disaster Handling and Recovery", "Disaster Handling and Recovery");
                        put("Date and Time Handling", "Date and Time Handling");
                        put("Data Quality", "Data Quality");
                        put("Competitive Inferiority", "Competitive Inferiority");
                }
        };

        Map<String, String> riskLikelihoodNameAlias = new HashMap<String, String>() {
                {
                        put("Least", "1");
                        put("Between Low and Least", "1.5");
                        put("Low", "2");
                        put("Between Medium and Low", "2.5");
                        put("Medium", "3");
                        put("Between High and Medium", "3.5");
                        put("High", "4");
                        put("Between Very High and High", "4.5");
                        put("Very High", "5");
                }
        };

        Map<String, String> riskImpactNameAlias = new HashMap<String, String>() {
                {
                        put("Least", "1");
                        put("Between Low and Least", "1.5");
                        put("Low", "2");
                        put("Between Medium and Low", "2.5");
                        put("Medium", "3");
                        put("Between High and Medium", "3.5");
                        put("High", "4");
                        put("Between Very High and High", "4.5");
                        put("Very High", "5");
                }
        };


        Map<String, String> extentOfTestingNameAlias = new HashMap<String, String>() {
                {
                        put("Report Bugs Only", "Report Bugs Only");
                        put("Opportunity", "Opportunity");
                        put("Cursory", "Cursory");
                        put("Broad", "Broad");
                        put("Extensive", "Extensive");
                        put("Not Defined", "Not Defined");
                }
        };

        Map<String, String> extentOfTestingNameETRange = new HashMap<String, String>() {
                {
                        put("Report Bugs Only", ">0-5");
                        put("Opportunity", ">5-10");
                        put("Cursory", ">10-15");
                        put("Broad", ">15-20");
                        put("Extensive", ">20-25");
                        put("Not Defined", "Out Of Range");
                }
        };

}