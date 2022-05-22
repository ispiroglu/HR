package org.ytu.hr.core.app;
//bunlar niye kırmızı
import org.ytu.hr.core.util.db.HibernateUtil;
import org.ytu.hr.frontend.loginPage.LoginPage;


public class App {
    public static void main(String[] args) throws InterruptedException {
        HibernateUtil.setup();
        LoginPage frame = new LoginPage();
//neabeans muhabbeti mi bu
        frame.setVisible(true);
        Thread.sleep(8000);

    }
}
