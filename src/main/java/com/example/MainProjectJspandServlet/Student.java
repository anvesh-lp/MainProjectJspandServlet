package com.example.MainProjectJspandServlet;

public class Student {
    private int id;
    private String name;
    private int marks;
    private String status;

    public Student(int id, String name, int marks, String status) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.status = status;
    }

    public Student(String name, int marks, String status) {
        this.name = name;
        this.marks = marks;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}
