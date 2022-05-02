package org.ytu.hr.core.app;

import org.ytu.hr.core.services.Login;
import org.ytu.hr.core.services.SignUp;

public class App {
    public static void main(String[] args) {
        SignUp sp = new SignUp();
        System.out.println("SignUp basarili.");


        Login login = new Login();
        System.out.println("Login basarili");
        System.out.println("Login -> " + login.getEmployeeID());
    }
}
