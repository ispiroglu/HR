package org.ytu.hr.core.models.employee;

import org.ytu.hr.core.util.gender.Gender;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Employee")
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private  Integer employeeID;
    @Column(name = "citizen_id")
    private  Long citizenID;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "first_name")
    private  String firstName;
    @Column(name = "last_name")
    private  String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String  gender;
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "birth_date")
    private  Date birthDate;
    @Column(name = "application_date")
    private  Date applicationDate;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "paid_leave")
    private Integer paidLeave;
    @Column(name = "absent_day")
    private Integer absentDay;
    @Column(name = "position")
    private String position;

    public Employee() {

    }

    public Employee(Integer candidateID, Long citizenID, Integer phoneNumber, String firstName, String lastName, String email, String gender, String province, String district, Date birthDate, Date applicationDate, Integer salary, Integer paidLeave, Integer absentDay, String position) {
        this.employeeID = candidateID;
        this.citizenID = citizenID;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.province = province;
        this.district = district;
        this.birthDate = birthDate;
        this.applicationDate = applicationDate;
        this.salary = salary;
        this.paidLeave = paidLeave;
        this.absentDay = absentDay;
        this.position = position;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public Long getCitizenID() {
        return citizenID;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        employeeID = 1;
        citizenID = 1L;
        gender = "Male";
        birthDate = new Date();
        applicationDate = new Date();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "candidateID=" + employeeID +
                ", citizenID=" + citizenID +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", birthDate=" + birthDate +
                ", applicationDate=" + applicationDate +
                ", salary=" + salary +
                ", paidLeave=" + paidLeave +
                ", absentDay=" + absentDay +
                ", position='" + position + '\'' +
                '}';
    }
}