package org.ytu.hr.models.candidate;

import org.ytu.hr.util.adress.Address;
import org.ytu.hr.util.gender.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private final Integer candidateID;
    @Column(name = "citizen_id")
    protected final Integer citizenID;
    @Column(name = "phone_number")
    protected Integer phoneNumber;
    @Column(name = "first_name")
    protected final String firstName;
    @Column(name = "last_name")
    protected final String lastName;
    @Column
    protected String email;
    @Column
    protected final Gender gender;
    //@Column(name = "my_adress")
    // protected Address address;
    @Column(name = "birth_date")
    protected final Date birthDate;
    @Column(name = "application_date")
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
        // this.address = address;
        this.birthDate = birthDate;
        this.applicationDate = applicationDate;
    }

    public Candidate(int candidateID, int citizenID, int phoneNumber,
                     String firstName, String lastName, String email,
                     Gender gender, Address address, Date birthDate, Date applicationDate) {
        this.candidateID = candidateID;
        this.citizenID = citizenID;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        // this.address = address;
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
        // this.address = candidate.address;
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

    /*
    public Address getAddress() {
        return address;
    }
    */

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

    /*
    public void setAddress(Address address) {
        this.address = address;
    }
    */

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID=" + candidateID +
                ", citizenID=" + citizenID +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + //address +
                ", birthDate=" + birthDate +
                ", applicationDate=" + applicationDate +
                '}';
    }
}
