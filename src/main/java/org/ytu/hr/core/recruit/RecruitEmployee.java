package org.ytu.hr.core.recruit;


import org.ytu.hr.core.models.employee.Employee;
import java.sql.Date;

public class RecruitEmployee{
    Employee e;

    public RecruitEmployee() {
        e = new Employee();
    }

    public boolean RecordEmployeeToDB(Integer EmployeeID, Long CitizenID, Long PhoneNumber, String FirstName,
                                   String LastName, String eMail, String Gender, String Province, String District,
                                   Date BirthDate, Date ApplicationDate, Integer Salary,String Position){
        e.setEmployeeID(EmployeeID);
        e.setCitizenID(CitizenID);
        e.setPhoneNumber(PhoneNumber);
        e.setFirstName(FirstName);
        e.setLastName(LastName);
        e.setEmail(eMail);
        e.setGender(Gender);
        e.setProvince(Province);
        e.setDistrict(District);
        e.setBirthDate(BirthDate);
        e.setApplicationDate(ApplicationDate);
        e.setSalary(Salary);
        e.setPosition(Position);






        return true;
    }



}
