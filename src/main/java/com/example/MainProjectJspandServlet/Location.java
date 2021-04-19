package com.example.MainProjectJspandServlet;

public class Location {
    private String id;
    private int zipcode;
    private String city;
    private String street;

    public Location(String id, int zipcode, String city, String street) {
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
