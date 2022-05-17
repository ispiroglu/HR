package org.ytu.hr.core.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.ytu.hr.core.models.account.Account;
import org.ytu.hr.core.util.stringUtil.Hash;

public class Login implements ILoginService {
    private Session session;
    private Integer employeeID;
    private final String username;
    private final String password;
    public final boolean loggedIn;


    public Login(String username, String password) {
        this.username = username;
        this.password = Hash.hashString(password);
        loggedIn = isCorrectUser();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Boolean isCorrectUser() {
        boolean isOK = false;

        try {
            session.beginTransaction();
            Query query1 = session.createQuery("from Account where username=:username and password=:password");
            query1.setParameter("username", username);
            query1.setParameter("password", password);
            Account acc = (Account) query1.uniqueResult();

            if (acc != null) {
                isOK = true;
            }
        }
        finally {
            session.close();
        }
        return isOK;
    }
}
