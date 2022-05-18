package org.ytu.hr.core.util.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ytu.hr.core.models.account.Account;
import org.ytu.hr.core.models.employee.Employee;

public class HibernateUtil {
    private static class NewThread extends Thread {
        public void run() {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
        }
    }
    private static SessionFactory sessionFactory;

    public static void setup() {
       NewThread t1 = new NewThread();
       t1.start();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
