package org.ytu.hr.core.app;

import org.hibernate.SessionFactory;
import org.ytu.hr.core.models.candidate.Candidate;
import org.ytu.hr.core.util.adress.Address;
import org.ytu.hr.core.util.gender.Gender;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Candidate.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Candidate can = new Candidate(
                    1, 69, 532,
                    "Evren", "Ispiroglu",
                    "ispiroglu@ispiroglu", Gender.Male,
                    new Address(), new Date(2022,05, 01),  new Date(2020,06, 05)
            );

            session.beginTransaction();
            session.save(can);
            session.getTransaction().commit();
            System.out.println("Allam oldu");
        } finally {
            factory.close();
        }
    }

}
