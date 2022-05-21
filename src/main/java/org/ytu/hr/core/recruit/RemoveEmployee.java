package org.ytu.hr.core.recruit;

import org.hibernate.Session;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;

import java.util.List;


public class RemoveEmployee {
    //RETURNS TRUE, EMPLOYEE WITH GIVEN ID REMOVED
    //RETURNS FALSE, INVALID EMPLOYEE ID
    public static boolean RemoveEmployeeFromDB(int EmployeeID){

        //Employee e;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List<Employee> allEmployees = session.createQuery("select a FROM Employee a", Employee.class).getResultList();
        for(Employee e: allEmployees){
            if(e.getEmployeeID() == EmployeeID){
                session.remove(e);
                session.getTransaction().commit();
                return true;
            }
        }
        session.close();
        return false;
    }
}
