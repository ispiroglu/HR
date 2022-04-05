package org.ytu.hr.core.services;

import org.ytu.hr.core.models.candidate.Candidate;
import org.ytu.hr.core.util.gender.Gender;

import java.util.Date;

public interface ISignUpService {
    Integer getCandidateID();
    Integer getCitizenID();
    Integer getPhoneNumber();
    String getFirstName();
    String getLastName();
    String getEmail();
    Gender getGender();
    Date getBirthDate();
    Date getApplicationDate();
    String getUsername();
    String getPassword();
    Candidate getCandidate();
}
