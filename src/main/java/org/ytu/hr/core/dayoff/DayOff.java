package org.ytu.hr.core.dayoff;


import org.hibernate.*;
import org.ytu.hr.core.models.employee.Employee;
import org.hibernate.Session;
import org.ytu.hr.core.util.db.HibernateUtil;

import java.sql.Date;
import java.text.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

/**

    Raporlu olup olmadığını addPaidleave'i çağırırken son parametrenin bool değeri belirler
    is_absentToday(employee) çağırıldığında eğer bugün izin aralığındaysa tablodaki isAbsent'i true yapar.
    yıllık izin, aylık absent_day hala sıfırlanmadı

*/
// izin günü dolduysa da addPaidLeave false döner.
public class DayOff {
    private static final int maxPaidLeave=30;

    public static int addPaidLeave(Employee employee, String startDateStr,String endDateStr,boolean withReport){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //Employee employee = session.get(Employee.class, EmployeeID);

            java.util.Date dateStart =new SimpleDateFormat("dd/MM/yyyy").parse(startDateStr);
            java.util.Date dateEnd =new SimpleDateFormat("dd/MM/yyyy").parse(endDateStr);
           // long daysBetween = Duration.between((Temporal) dateStart, (Temporal) dateEnd).toDays();
            long daysBetween = ChronoUnit.DAYS.between(dateStart.toInstant(), dateEnd.toInstant());
            if(employee.isIs_absent()){        /** KULLANICI ZATEN ŞU AN İZİNDE   */
                session.getTransaction().commit();
                session.close();

                return 2;
            }
            if(employee.getPaidLeave()+ daysBetween<= maxPaidLeave && withReport == false ){       /** RAPORSUZ İZİN EKLENDİ */
                employee.setPaidLeave(employee.getPaidLeave()+(int)daysBetween);
                java.sql.Date tmpStart = new java.sql.Date(dateStart.getTime());
                java.sql.Date tmpEnd = new java.sql.Date(dateEnd.getTime());
                employee.setPaid_leave_start(tmpStart);
                employee.setPaid_leave_end(tmpEnd);

                session.saveOrUpdate(employee);
                session.getTransaction().commit();
                session.close();

                return 0; /** RAPORSUZ İZİN EKLENDİ */
            }
            else if(withReport){  /** RAPORLU İZİN VERİLDİ */
                java.sql.Date tmpStart = new java.sql.Date(dateStart.getTime());
                java.sql.Date tmpEnd = new java.sql.Date(dateEnd.getTime());
                employee.setPaid_leave_start(tmpStart);
                employee.setPaid_leave_end(tmpEnd);

                session.saveOrUpdate(employee);
                session.getTransaction().commit();
                session.close();
                return 1;    /** RAPORLU İZİN VERİLDİ */
        }
            else{       /** GİRİLEN İZİN MAKSİMUM RAPORTSUZ İZİN HAKKINI AŞIYOR */
                session.saveOrUpdate(employee);
                session.getTransaction().commit();
                session.close();
                return 3;   /** GİRİLEN İZİN MAKSİMUM RAPORTSUZ İZİN HAKKINI AŞIYOR */
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            return -1;                  /** BİR HATA MEYDANA GELDİ */
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }

    }
    public static int addAbsentDay(Employee employee){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
           // Employee employee = session.get(Employee.class, EmployeeID);
            if(employee.isIs_absent()){
                session.getTransaction().commit();
                session.close();
                return 1; /** kullanıcı izinde olduğu için gelmedi işaretlenemez */

            }

            employee.setAbsentDay(employee.getAbsentDay()+1);
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
            session.close();

            return 0;      /** kullanıcı gelmedi işaretlendi */

        } catch (HibernateException e) {
            e.printStackTrace();
            return -1;  /** bir hata meydana geldi */
        }

    }

    public static boolean isAbsentToday(Employee employee){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            // Employee employee = session.get(Employee.class, EmployeeID);
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.getTime();
            if(employee.getPaid_leave_start()==null){
                return true;
            }
           if((today.getTime().after(employee.getPaid_leave_start()) && today.getTime().before(employee.getPaid_leave_end()))){
                employee.setIs_absent(true);
           }
           else employee.setIs_absent(false);


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
