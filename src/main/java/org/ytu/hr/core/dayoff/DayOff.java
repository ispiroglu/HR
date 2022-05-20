package org.ytu.hr.core.dayoff;


import org.hibernate.*;
import org.ytu.hr.core.models.employee.Employee;
import org.hibernate.Session;
import org.ytu.hr.core.util.db.HibernateUtil;

import java.text.Annotation;

// izin günü dolduysa addPaidLeave false döner.
public class DayOff {
    private static final int maxPaidLeave=30;

    public static boolean addPaidLeave(Employee employee){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //Employee employee = session.get(Employee.class, EmployeeID);
            if(employee.getPaidLeave()+1 <= maxPaidLeave ){
                employee.setPaidLeave(employee.getPaidLeave()+1);
                session.saveOrUpdate(employee);
                session.getTransaction().commit();
                session.close();

                return true;
            }
            else{
                session.saveOrUpdate(employee);
                session.getTransaction().commit();
                session.close();
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static boolean addAbsentDay(Employee employee){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
           // Employee employee = session.get(Employee.class, EmployeeID);
            employee.setAbsentDay(employee.getAbsentDay()+1);
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
            session.close();

            return true;

        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }
}
