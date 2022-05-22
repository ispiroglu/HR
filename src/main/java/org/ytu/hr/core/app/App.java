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
        Thread.sleep(8000);

        Session session = HibernateUtil.getSessionFactory().openSession();
       // session.getTransaction().begin();
        Employee testEmployee = session.get(Employee.class,8);

        addAbsentDay(testEmployee);
        addPaidLeave(testEmployee,"20/05/2022","25/05/2022",true);
        isAbsentToday(testEmployee);
     //   addPaidLeave(testEmployee,"20/05/2022","25/05/2022",true);


        session.saveOrUpdate(testEmployee);
       // session.getTransaction().commit();
    }
}
