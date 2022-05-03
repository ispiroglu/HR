package org.ytu.hr.core.app;

import org.ytu.hr.frontend.addEmployeePage.AddEmployePage;
import org.ytu.hr.frontend.loginPage.LoginPage;
import org.ytu.hr.frontend.mainPage.MainPage;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("loginPage");
        frame.setContentPane(new MainPage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
