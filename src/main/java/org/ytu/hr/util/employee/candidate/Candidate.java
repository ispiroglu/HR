package org.ytu.hr.util.employee.candidate;

import org.ytu.hr.util.employee.adress.Address;
import org.ytu.hr.util.employee.gender.Gender;

import java.util.Date;

public class Candidate {
    protected final Integer citizenID;;
    protected Integer phoneNumber;
    protected final String firstName;
    protected final String lastName;
    protected String email;
    protected final Gender gender;
    protected Address address;
    protected final Date bornDate;
    protected final Date applicationDate;


    public Candidate(Integer citizenID, Integer phoneNumber, String firstName, String lastName, String email, Gender gender, Address address, Date bornDate, Date applicationDate) {
        this.citizenID = citizenID;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.bornDate = bornDate;
        this.applicationDate = applicationDate;
    }

    public Integer getCitizenID() {
        return citizenID;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
