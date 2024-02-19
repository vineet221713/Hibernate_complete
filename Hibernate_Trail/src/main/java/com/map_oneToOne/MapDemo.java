package com.map_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question q1 = new Question();

        q1.setQuestionId(1212);
        q1.setQuestion("what is java");

Answer answer = new Answer();
answer.setAnswerId(343);
answer.setAnswer("java is programing language ");
answer.setQuestion(q1);

       q1.setAnswer(answer);

        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("what is collection f/w");

Answer answer1 = new Answer();
answer1.setAnswerId(344);
answer1.setAnswer("api to work with object in java  ");
answer1.setQuestion(q2);

        q2.setAnswer(answer1);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(q1);
        s.save(q2);
        s.save(answer);
        s.save(answer1);

        tx.commit();


        factory.close();
    }
}
