package org.ytu.hr.core.app;

import org.hibernate.SessionFactory;
import org.ytu.hr.core.models.candidate.Candidate;
import org.ytu.hr.core.services.Login;
import org.ytu.hr.core.services.SignUp;
import org.ytu.hr.core.util.adress.Address;
import org.ytu.hr.core.util.gender.Gender;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App {
    public static void main(String[] args) {
       /*  SignUp sp = new SignUp();
        System.out.println("SignUp basarili.");*/

        Login login = new Login();
        System.out.println("Login basarili");
        System.out.println("Login -> " + login.getEmployeeID());

        System.out.println("I'm emir");
    }

}
