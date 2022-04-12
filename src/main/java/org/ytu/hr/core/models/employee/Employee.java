package org.ytu.hr.core.models.employee;

import org.ytu.hr.core.util.adress.Address;
import org.ytu.hr.core.models.candidate.Candidate;
import org.ytu.hr.core.util.gender.Gender;
import org.ytu.hr.core.util.position.Position;

import java.util.Date;


public class Employee extends Candidate {
    protected final Integer employeeID;
    protected Integer salary;
    protected Integer paidLeave; // Bu degeler belki baska bir class icine alinabilir.
    protected Integer absentDay; // Bu degeler belki baska bir class icine alinabilir.
    protected Position position;

    public Employee(Integer candidateID, Integer citizenID, Integer phoneNumber, String firstName, String lastName, String email, Gender gender, Address address, Date bornDate, Date applicationDate, Integer employeeID) {
        super(candidateID, citizenID, phoneNumber, firstName, lastName, email, gender, address, bornDate, applicationDate);
        this.employeeID = employeeID;
    }

    public Employee(Integer candidateID, Integer citizenID, Integer phoneNumber, String firstName, String lastName, String email, Gender gender, Address address, Date birthDate, Date applicationDate, Integer employeeID, Integer salary, Integer paidLeave, Integer absentDay) {
        super(candidateID, citizenID, phoneNumber, firstName, lastName, email, gender, address, birthDate, applicationDate);
        this.employeeID = employeeID;
        this.salary = salary;
        this.paidLeave = paidLeave;
        this.absentDay = absentDay;
    }

    public Employee(Candidate candidate, Integer employeeID, Integer salary, Integer paidLeave, Integer absentDay) {
        super(candidate);
        this.employeeID = employeeID;
        this.salary = salary;
        this.paidLeave = paidLeave;
        this.absentDay = absentDay;
    }

    public Employee(Candidate candidate, Integer employeeID) {
        super(candidate);
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}