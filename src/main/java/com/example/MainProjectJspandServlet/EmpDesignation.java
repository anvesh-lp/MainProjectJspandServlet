package com.example.MainProjectJspandServlet;

public class EmpDesignation {
    private String id;
    private String designation;
    private int salary;

    public EmpDesignation(String id, String designation, int salary) {
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    public EmpDesignation(String id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
