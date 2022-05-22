package org.ytu.hr.core.dayoff;


import org.hibernate.*;
import org.ytu.hr.core.models.employee.Employee;
import org.hibernate.Session;
import org.ytu.hr.core.util.db.HibernateUtil;

import java.sql.Date;
import java.text.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

// izin günü dolduysa addPaidLeave false döner.
public class DayOff {
    private static final int maxPaidLeave=30;

    public static boolean addPaidLeave(Employee employee, String startDateStr,String endDateStr){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //Employee employee = session.get(Employee.class, EmployeeID);
            java.util.Date dateStart =new SimpleDateFormat("dd/MM/yyyy").parse(startDateStr);
            java.util.Date dateEnd =new SimpleDateFormat("dd/MM/yyyy").parse(endDateStr);
            long daysBetween = DAYS.between((Temporal) dateStart, (Temporal) dateEnd);
            System.out.println(daysBetween);


            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            java.util.Date date = formatter.parse(startDateStr);
            java.sql.Date tmpDate = new java.sql.Date(date.getTime());
            employee.setBirthDate(tmpDate);





            if(employee.getPaidLeave()+ 1<= maxPaidLeave ){
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
        } catch (ParseException e) {
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
