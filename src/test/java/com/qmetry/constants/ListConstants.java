package com.qmetry.constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface defines ListConstants.
 * 
 * @author rahul.patil
 */
public interface ListConstants extends CommonConstants {
    static final String COPY_TEXT = "Copy";
    static final String LIST_VALUES_TEXT = "List Values";
    static final String IMPORT_TEXT = "Import";

    ArrayList<String> riskLikelihoodListNames = new ArrayList<>(
            Arrays.asList("Least", "Between Low and Least", "Low", "Between Medium and Low", "Medium",
                    "Between High and Medium", "High", "Between Very High and High", "Very High"));

    ArrayList<String> extentOfTestingListNames = new ArrayList<>(
            Arrays.asList("Report Bugs Only", "Opportunity", "Cursory", "Broad", "Extensive", "Not Defined"));
}