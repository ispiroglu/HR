package org.ytu.hr.core.app;

import org.hibernate.Session;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.frontend.loginPage.LoginPage;

import static org.ytu.hr.core.dayoff.DayOff.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HibernateUtil.setup();
        LoginPage frame = new LoginPage();
        frame.setVisible(true);
        Thread.sleep(5000);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Employee testEmployee = session.get(Employee.class,1);

        addAbsentDay(testEmployee);
        addPaidLeave(testEmployee);


        session.saveOrUpdate(testEmployee);
        session.getTransaction().commit();


    }
}
