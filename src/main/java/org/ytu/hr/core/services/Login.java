package org.ytu.hr.core.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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
        Integer employeeID;
        try {
            session.beginTransaction();
            employeeID = session.get(Login.class, username).getEmployeeID();
            // session.getTransaction().commit();
        } finally {
            session.close();
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
        boolean isOK = false;
        sessionFactory = new Configuration()
                        .configure()
                        .addAnnotatedClass(Login.class)
                        .buildSessionFactory();
        session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            if (Objects.equals(session.get(SignUp.class, username).getPassword(), password))
                isOK = true;
            // session.getTransaction().commit();
        } finally {
            session.close();
        }

        return isOK;
    }
}
