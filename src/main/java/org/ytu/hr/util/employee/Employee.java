package org.ytu.hr.util.employee;

import org.ytu.hr.util.employee.adress.Address;
import org.ytu.hr.util.employee.candidate.Candidate;
import org.ytu.hr.util.employee.gender.Gender;

import java.util.Date;


public class Employee extends Candidate {
    protected final Integer employeeID;
    protected Integer salary;
    protected Integer paidLeave;
    protected Integer absentDay;
    public Employee(Integer citizenID, Integer phoneNumber, String firstName, String lastName, String email, Gender gender, Address address, Date bornDate, Date applicationDate, Integer employeeID) {
        super(citizenID, phoneNumber, firstName, lastName, email, gender, address, bornDate, applicationDate);
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getPaidLeave() {
        return paidLeave;
    }

    public void setPaidLeave(Integer paidLeave) {
        this.paidLeave = paidLeave;
    }

    public Integer getAbsentDay() {
        return absentDay;
    }

    public void setAbsentDay(Integer absentDay) {
        this.absentDay = absentDay;
    }

}