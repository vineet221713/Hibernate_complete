package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        //get,Load
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        Session session = factory.openSession();
//
//        Student student= (Student)session.get(Student.class,101);
//
//        System.out.println(student);

        SessionFactory factory = null;
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            factory = cfg.buildSessionFactory();

            Session session = factory.openSession();

            Student student = (Student) session.get(Student.class, 101);
            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close the session
            Session session = factory.openSession();
            session.close();
        }

    }


}
