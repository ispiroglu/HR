package org.ytu.hr.core.dayoff;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.ytu.hr.core.models.account.Account;
import org.ytu.hr.core.models.employee.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.ytu.hr.core.util.db.HibernateUtil;

import java.text.Annotation;


public class DayOff {
    public static void main(String[] args) {


        updateEmployee(1,15000);





    }
    public static void updateEmployee(Integer EmployeeID, int salary){

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, EmployeeID);
        employee.setSalary( salary );
        session.update(employee);

        transaction.commit();



        /* Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);

            employee.setSalary( salary );
            session.update(employee);
            transaction.commit();
        }catch (HibernateException e) {
           // if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }*/


    }


}
