package com.qmetry.bean;

/**
 * This class defines ImportBean.
 * 
 * @author rahul.patil
 */
public class ImportBean extends CommonBean {
    String file;
    String sheetName;
    String folderName;
    String summary;
    String sheetField;
    String qmetryField;
    String mapName;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSheetField() {
        return sheetField;
    }

    public void setSheetField(String sheetField) {
        this.sheetField = sheetField;
    }

    public String getQmetryField() {
        return qmetryField;
    }

    public void setQmetryField(String qmetryField) {
        this.qmetryField = qmetryField;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}