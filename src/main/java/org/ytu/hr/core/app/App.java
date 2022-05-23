package org.ytu.hr.core.app;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.core.util.employee.EmployeeUtil;
import org.ytu.hr.frontend.loginPage.LoginPage;



public class App {
    public static void main(String[] args) throws InterruptedException {
        HibernateUtil.setup();
        Thread.sleep(8000);
        EmployeeUtil.updateDayOffs();
        LoginPage frame = new LoginPage();
        frame.setVisible(true);



    }
}
