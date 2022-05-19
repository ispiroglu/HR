package org.ytu.hr.core.dayoff;


import org.hibernate.*;
import org.ytu.hr.core.models.employee.Employee;
import org.hibernate.Session;
import org.ytu.hr.core.util.db.HibernateUtil;

import java.text.Annotation;


public class DayOff {
    private static final int maxPaidLeave=30;

    public static void updateEmployee(Integer EmployeeID, int salary){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Employee employee = session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public static void addPaidLeave(Integer EmployeeID, int days){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Employee employee = session.get(Employee.class, EmployeeID);
            if(employee.getPaidLeave()+days <= maxPaidLeave ){
                employee.setPaidLeave(employee.getPaidLeave()+days);
            }
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public static void addAbsentDay(Integer EmployeeID, int days){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Employee employee = session.get(Employee.class, EmployeeID);
            employee.setAbsentDay(employee.getAbsentDay()+days);
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
