package org.ytu.hr.core.models.employee;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Employee")
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_ID")
    private Integer employeeID;
    @Column(name = "citizen_ID")
    private Long citizenID;
    @Column(name = "phone_number")
    private Long phoneNumber;
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
    private Date birthDate;
    @Column(name = "application_date")
    private Date applicationDate;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "paid_leave")
    private Integer paidLeave;
    @Column(name = "absent_day")
    private Integer absentDay;
    @Column(name = "position")
    private String position;

//    @Column(name = "is_absent")
//    private boolean isAbsent;


    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Long getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(Long citizenID) {
        this.citizenID = citizenID;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", citizenID=" + citizenID +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
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