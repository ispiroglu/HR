package org.ytu.hr.core.app;

import org.ytu.hr.core.recruit.RecruitEmployee;
import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.frontend.loginPage.LoginPage;

import static org.ytu.hr.core.recruit.RecruitEmployee.RecordEmployeeToDB;

public class App {
    public static void main(String[] args) {
        HibernateUtil.setup();
        LoginPage frame = new LoginPage();
        frame.setVisible(true);/*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RecordEmployeeToDB("3","2","0","0","3","0","11-JUN-2011","25-MAY-2000","0","0");
*/

    }
}
