package org.ytu.hr.core.app;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.core.util.employee.EmployeeUtil;
import org.ytu.hr.frontend.loginPage.LoginPage;
import org.ytu.hr.frontend.welcomePage.WelcomePage;


public class App {
    public static void main(String[] args) throws InterruptedException {
        HibernateUtil.setup();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.setVisible(true);
        Thread.sleep(8000);
        LoginPage loginPage = new LoginPage();
        welcomePage.dispose();
        loginPage.setVisible(true);
        EmployeeUtil.updateDayOffs();
    }
}
