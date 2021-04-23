package com.example.MainProjectJspandServlet;

public class Employee {
    private String locid;
    private String email;
    private String mobile;
    private String fname;
    private String laname;
    private int eid;
    private String dsgid;

    public Employee(String locid, String email, String mobile, String fname, String laname, int eid, String dsgid) {
        this.locid = locid;
        this.email = email;
        this.mobile = mobile;
        this.fname = fname;
        this.laname = laname;
        this.eid = eid;
        this.dsgid = dsgid;
    }

    public String getLocid() {
        return locid;
    }

    public void setLocid(String locid) {
        this.locid = locid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLaname() {
        return laname;
    }

    public void setLaname(String laname) {
        this.laname = laname;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getDsgid() {
        return dsgid;
    }

    public void setDsgid(String dsgid) {
        this.dsgid = dsgid;
    }
}
