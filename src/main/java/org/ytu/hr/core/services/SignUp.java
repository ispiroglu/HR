package org.ytu.hr.core.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ytu.hr.core.models.account.Account;
import org.ytu.hr.core.models.candidate.Candidate;
import org.ytu.hr.core.util.adress.Address;
import org.ytu.hr.core.util.gender.Gender;

import java.util.Date;
import java.util.Scanner;

public class SignUp implements ISignUpService {
    Scanner kb;
    Candidate candidate;

    public SignUp()
    {
        kb = new Scanner(System.in);
        candidate = new Candidate(getCandidateID(), getCitizenID(), getPhoneNumber(),
                getFirstName(), getLastName(), getEmail(), getGender(), new Address(),
                getBirthDate(), getApplicationDate());

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Candidate.class)
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();

        Session session = sf.getCurrentSession();

        try {

            Candidate candidate = this.getCandidate();
            Account acc = new Account(candidate.getCandidateID(),
                    this.getUsername(), this.getPassword());

            System.out.println(candidate);
            session.beginTransaction();
            session.save(candidate);
            session.getTransaction().commit();
            session = sf.getCurrentSession();
            session.beginTransaction();
            session.save(acc);
            session.getTransaction().commit();
            System.out.println("Allam oldu");
        } finally {
            sf.close();
        }

    }



    @Override
    public Integer getCandidateID() {
        // CandidateID hesaplmamasi yapilacak.
        return null;
    }

    @Override
    public Integer getCitizenID() {
        System.out.println("Lutfen 11 Haneli TC kimlik numaranizi giriniz. ");
        return Integer.parseInt(kb.nextLine());
    }

    @Override
    public Integer getPhoneNumber() {
        System.out.println("Lutfen telefon numaranizi basinda sifir olmadan bitisik bir sekilde giriniz. ");
        return Integer.parseInt(kb.nextLine());
    }

    @Override
    public String getFirstName() {
        System.out.println("Lutfen adinizi giriniz.");
        return kb.nextLine();
    }

    @Override
    public String getLastName() {
        System.out.println("Lutfen soyadinizi giriniz.");
        return kb.nextLine();
    }

    @Override
    public String getEmail() {
        System.out.println("Lutfen emailinizi giriniz.");
        return kb.nextLine();
    }

    @Override
    public Gender getGender() {
        System.out.println("Lutfen cinsiyetinizi giriniz" +
                "0 -> Erkek" +
                "1 -> Kadin");
        return Gender.Male ; // Mock implementation
    }

    @Override
    public Date getBirthDate() {
        System.out.println("Dogum tarihinizi giriniz");
        return new Date(); // Implementation yanlis olabilir.
    }

    @Override
    public Date getApplicationDate() {
        return new Date(); // Sanirim su anki tarih ile bir nesne olusturuyor.
    }

    @Override
    public String getUsername() {
        return candidate.getFirstName() + "_" + candidate.getLastName();
    }

    @Override
    public String getPassword() {
        System.out.println("Sifreniz ne olsun?");
        return kb.nextLine();
    }

    @Override
    public Candidate getCandidate() {
        return candidate;
    }
}
