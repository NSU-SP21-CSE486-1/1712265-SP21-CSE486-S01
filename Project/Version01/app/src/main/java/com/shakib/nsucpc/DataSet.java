package com.shakib.nsucpc;

public class DataSet {
    private String jobTitle;
    private String jobtype;
    private String location;
    private String salary;
    private String deadline;
    private String interviewdate;
    private String jobinformation;
    private String otherbenefits;

    public DataSet() {
    }

    public DataSet(String jobTitle, String jobtype, String location, String salary, String deadline, String interviewdate, String jobinformation, String otherbenefits) {
        this.jobTitle = jobTitle;
        this.jobtype = jobtype;
        this.location = location;
        this.salary = salary;
        this.deadline = deadline;
        this.interviewdate = interviewdate;
        this.jobinformation = jobinformation;
        this.otherbenefits = otherbenefits;
    }
//    jobTitle,spinnervalue,Location,Salary,Information,Otherbenefits, Deadline,interview


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getInterviewdate() {
        return interviewdate;
    }

    public void setInterviewdate(String interviewdate) {
        this.interviewdate = interviewdate;
    }

    public String getJobinformation() {
        return jobinformation;
    }

    public void setJobinformation(String jobinformation) {
        this.jobinformation = jobinformation;
    }

    public String getOtherbenefits() {
        return otherbenefits;
    }

    public void setOtherbenefits(String otherbenefits) {
        this.otherbenefits = otherbenefits;
    }
}


