package com.example.MainProjectJspandServlet;

public class Customers {
    private int id;
    private String fname;
    private String sname;
    private String phone;
    private String email;
    private String locid;

    public Customers(int id, String fname, String sname, String phone, String email, String locid) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.phone = phone;
        this.email = email;
        this.locid = locid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocid() {
        return locid;
    }

    public void setLocid(String locid) {
        this.locid = locid;
    }
}
