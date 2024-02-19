package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student student1 = new Student();

        student1.setId(102);
        student1.setName("Ankit ");
        student1.setCity("Delhi");

     Certificate certificate = new Certificate();
     certificate.setCourse("java");
     certificate.setDuration("6 month");

        student1.setCertificate(certificate);

        Session s = factory.openSession();
          Transaction tx = s.beginTransaction();
          s.save(student1);

        factory.close();
    }
}
