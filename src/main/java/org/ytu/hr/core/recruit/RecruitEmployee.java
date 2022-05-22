package org.ytu.hr.core.recruit;


import org.hibernate.Session;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.core.util.employee.EmployeeUtil;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;



public class RecruitEmployee{



    public RecruitEmployee() {
    }



    /*
        IF RecordEmployeeToDB returns 0, Employee already exists!
                              returns 1, there is an employee with same ID
                              returns 2, there is an employee with same eMail
                              returns 3, there is an employee with same PhoneNumber
                              returns -1, employee added to DB with no problem
        !!!!UPDATE allEmployees list after this method has called

     */

    public static int RecordEmployeeToDB( String CitizenID, String PhoneNumber, String FirstName,
                                      String LastName, String eMail, String Gender, String BirthDate, String ApplicationDate,
                                      String Salary, String Position,String Province,String District){
        Employee e;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List<Employee> allEmployees = EmployeeUtil.getAllEmployees();
        String employeeCount = Integer.toString(allEmployees.size());
         for (Employee a: allEmployees){
            if(Objects.equals(a.getCitizenID(), Long.parseLong(CitizenID)))
                return 1;
            else if(Objects.equals(a.getEmail(), eMail))
                return 2;
            else if(  Objects.equals(a.getPhoneNumber(), Long.parseLong(PhoneNumber))){
                return 3;
            }
        }
        e = new Employee();
        e.setEmployeeID(Integer.parseInt(employeeCount));
        e.setCitizenID(Long.parseLong(CitizenID));
        e.setPhoneNumber(Long.parseLong(PhoneNumber));
        e.setFirstName(FirstName);
        e.setLastName(LastName);
        e.setEmail(eMail);
        e.setGender(Gender);

        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            java.util.Date date = formatter.parse(BirthDate);
            java.sql.Date tmpDate = new java.sql.Date(date.getTime());
            e.setBirthDate(tmpDate);

            date = formatter.parse(ApplicationDate);
            tmpDate =  new java.sql.Date(date.getTime());
            e.setApplicationDate(tmpDate);

            e.setAbsentDay(0);
            e.setPaidLeave(0);
            e.setSalary(Integer.parseInt(Salary));
            e.setPosition(Position);
            e.setProvince(Province);
            e.setDistrict(District);
            session.saveOrUpdate(e);
            allEmployees.add(e);
            session.getTransaction().commit();
            session.close();
        }
        catch (java.text.ParseException exception){
            System.out.println("Data format not valid, valid format: dd-MMM-yyyy \n");
            exception.printStackTrace();
        }


        return -1;
    }



}
