package org.ytu.hr.core.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.ytu.hr.core.models.account.Account;


import java.util.Objects;
import java.util.Scanner;

public class Login implements ILoginService {
    private SessionFactory sessionFactory;
    private Session session;
    private final Scanner kb;
    private Integer employeeID;
    private final String username;
    private final String password;
    public final boolean loggedIn;

    public Login()
    {
        kb = new Scanner(System.in);

        username = getUsername();
        password = getPassword();
        loggedIn = isCorrectUser();
    }

    @Override
    public Integer getEmployeeID() {
        if (!loggedIn) {
            System.out.println("Sifreniz yanlis.");
            return null;
        }
        return employeeID;
    }

    @Override
    public String getUsername() {
        System.out.println("Username girin");
        return kb.nextLine();
    }

    @Override
    public String getPassword() {
        System.out.println("Sifre girin");
        return kb.nextLine();
    }

    @Override
    public Boolean isCorrectUser() {
        /*
        * .addAnnotatedClass(Login.class)
        * */
        boolean isOK = false;
        sessionFactory = new Configuration()
                        .configure()
                        .addAnnotatedClass(Account.class)
                        .buildSessionFactory();
        session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query query1 = session.createQuery("from Account where username=:username and password=:password");
            query1.setParameter("username", username);
            query1.setParameter("password", password);

            System.out.println("----------------------------------");

            Account acc = (Account) query1.uniqueResult();


            if (acc != null) {
                isOK = true;
                employeeID = acc.getCandidateID();
            }


            // session.getTransaction().commit();
        } finally {
            session.close();
        }

        return isOK;
    }
}
