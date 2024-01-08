package entities;

import java.io.Serializable;

public class Address implements Serializable {
    // number can be 1B or 1/A so i make it a string variable
    private String number;
    private String street;
    private String city;

    public Address(String no, String street, String city) {
        this.number = no;
        this.street = street;
        this.city = city;

    }

    // setter methods
    public void setNumber(String no) {
        this.number = no;

    }

    public void setStreet(String street) {
        this.street = street;

    }

    public void setCity(String city) {
        this.city = city;

    }

    // getter methods
    public String getNumber() {
        return number;

    }

    public String getStreet() {
        return street;

    }

    public String getCity() {
        return city;

    }

    @Override
    public String toString() {
        return number + ", " + street + ", " + city + ".";

    }
}



