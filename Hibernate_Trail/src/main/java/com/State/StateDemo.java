package com.State;

import com.tut.Certificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

    public static void main(String[] args) {
        //transint
        //persist
        //detached
        //remove
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student = new Student();

        student.setName("new name ");
        student.setCity("new city ");
        student.setId(1414);
        student.setCertificate(new Certificate("java hibernate cource ","2 month"));

        // now student become in transist state

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);

        //student object go in persisternce state
        student.setName("John");

        tx.commit();
        session.close();
        student.setName("sachin");

    }
}
