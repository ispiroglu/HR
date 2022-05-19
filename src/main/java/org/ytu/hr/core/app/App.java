package org.ytu.hr.core.app;

import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.frontend.loginPage.LoginPage;

import static org.ytu.hr.core.dayoff.DayOff.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HibernateUtil.setup();
        LoginPage frame = new LoginPage();
        frame.setVisible(true);
        Thread.sleep(5000);

        updateEmployee(1,1111 );
        addAbsentDay(1, 2);
        addPaidLeave(1,18);
    }
}
