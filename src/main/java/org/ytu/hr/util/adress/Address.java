package org.ytu.hr.util.adress;

public class Address {
    public Integer zipCode;
    public String country;
    public String city;
    public String street;

    public Address(){

    }
    public Address(Integer zipCode, String country, String city, String street) {
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {
        return "Address{" +
                "zipCode=" + zipCode +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
