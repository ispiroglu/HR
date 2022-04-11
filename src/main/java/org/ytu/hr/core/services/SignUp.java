package org.ytu.hr.core.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ytu.hr.core.models.account.Account;
import org.ytu.hr.core.models.candidate.Candidate;
import org.ytu.hr.core.util.adress.Address;
import org.ytu.hr.core.util.gender.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SignUp implements ISignUpService {
    Scanner kb;
    Candidate candidate;

    public SignUp()
    {
        kb = new Scanner(System.in);

        // Signup nesnesini olustururkenki olusturulan candidate bilgilerinin alinmasi
        // Arayuz eklendiginde arayuz formu tamamlanip gonderildiginde yapilcaktir.
        // Signup form'u gonderilince signup nesnesi calistirilacak ve
        // signup nesnesinin paramtreleri formdan okunacak.

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

            session.beginTransaction();
            session.save(candidate);
            session.save(acc);
            session.getTransaction().commit();
        } finally {
            sf.close();
        }

    }

    @Override
    public Integer getCandidateID() {

        return candidate != null ? candidate.getCandidateID() : null ;
    }

    @Override
    public Long getCitizenID() {
        System.out.println("Lutfen 11 Haneli TC kimlik numaranizi giriniz. ");
        return Long.parseLong(kb.nextLine());
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
        System.out.println("Lutfen cinsiyetinizi giriniz - Kadin(1) | Erkek(2)");
        return switch (Integer.parseInt(kb.nextLine())) {
            case 1 -> Gender.Female;
            case 2 -> Gender.Male;
            default -> null;
        };
    }

    @Override
    public Date getBirthDate() {
        System.out.println("Dogum tarihinizi giriniz");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = dateFormat.parse(kb.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    @Override
    public Date getApplicationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        long millis=System.currentTimeMillis();

        // creating a new object of the class Date

        return new java.sql.Date(millis);
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
