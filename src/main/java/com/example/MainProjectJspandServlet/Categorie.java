package com.example.MainProjectJspandServlet;

public class Categorie {
    private String id;
    private String name;
    private int pno;

    public Categorie(String id, String name, int pno) {
        this.id = id;
        this.name = name;
        this.pno = pno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }
}
