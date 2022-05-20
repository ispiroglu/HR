package org.ytu.hr.core.recruit;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.adress.Address;
import org.ytu.hr.core.util.gender.Gender;
import org.ytu.hr.core.util.position.Position;

import java.sql.Date;
import java.util.Objects;

public class RecruitEmployee{

    private SessionFactory sessionFactory;
    private Session session;
    Employee e;

    public RecruitEmployee() {
    }

    public boolean RecordEmployeeToDB(Integer EmployeeID,int CandidateID, int CitizenID, int PhoneNumber, String FirstName,
                                      String LastName, String eMail, Gender Gender, Date BirthDate, Date ApplicationDate,
                                      Integer Salary, Address Address, Position Position){

        Employee tmpEmployee;
        tmpEmployee = session.get(Employee.class,EmployeeID);
        if (tmpEmployee != null){
            return false;
        }/*
        else{

        }
*/
        e = new Employee(CandidateID,CitizenID,PhoneNumber,FirstName,LastName,eMail,Gender, Address,BirthDate,ApplicationDate,EmployeeID);
        e.setAbsentDay(0);
        e.setPaidLeave(0);
        e.setSalary(Salary);
        e.setPosition(Position);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();


        return true;
    }



}
