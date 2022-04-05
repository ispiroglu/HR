package org.ytu.hr.models.candidate;

import org.ytu.hr.util.adress.Address;
import org.ytu.hr.util.gender.Gender;

import java.util.Date;

public class Candidate {
    private final Integer candidateID;
    protected final Integer citizenID;
    protected Integer phoneNumber;
    protected final String firstName;
    protected final String lastName;
    protected String email;
    protected final Gender gender;
    protected Address address;
    protected final Date birthDate;
    protected final Date applicationDate;



    public Candidate(Integer candidateID, Integer citizenID, Integer phoneNumber,
                     String firstName, String lastName, String email,
                     Gender gender, Address address, Date birthDate, Date applicationDate) {
        this.candidateID = candidateID;
        this.citizenID = citizenID;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.applicationDate = applicationDate;
    }

    public Candidate (Candidate candidate) {
        this.candidateID = candidate.candidateID;
        this.citizenID = candidate.citizenID;
        this.phoneNumber = candidate.phoneNumber;
        this.firstName = candidate.firstName;
        this.lastName = candidate.lastName;
        this.email = candidate.email;
        this.gender = candidate.gender;
        this.address = candidate.address;
        this.birthDate = candidate.birthDate;
        this.applicationDate = candidate.applicationDate;
    }

    public Integer getCandidateID() {
        return candidateID;
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

    public Date getBirthDate() {
        return birthDate;
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
