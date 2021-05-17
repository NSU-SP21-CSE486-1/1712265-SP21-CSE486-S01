package com.shakib.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class DataSet {

    private String name;
    private String id;
    private String schoolName;
    private String deptName;

    public DataSet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public DataSet(String name, String id, String schoolName, String deptName) {
        this.name = name;
        this.id = id;
        this.schoolName = schoolName;
        this.deptName = deptName;
    }
}
