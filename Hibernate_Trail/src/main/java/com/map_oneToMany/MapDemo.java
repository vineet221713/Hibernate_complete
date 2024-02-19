package com.map_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        /*

        Question q1 = new Question();

        q1.setQuestionId(1212);
        q1.setQuestion("what is java");

Answer answer = new Answer();
answer.setAnswerId(343);
answer.setAnswer("java is programing language ");
answer.setQuestion(q1);


Answer answer1 = new Answer();
answer1.setAnswerId(344);
answer1.setAnswer("api to work with object in java  ");
answer1.setQuestion(q1);

Answer answer2 = new Answer();
answer2.setAnswerId(345);
answer2.setAnswer("with the help of this we can do lot of things");
answer2.setQuestion(q1);

List<Answer> list = new ArrayList<>();
list.add(answer);
list.add(answer1);
list.add(answer2);

q1.setAnswer(list);



        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(q1);
//
       s.save(answer);
       s.save(answer1);
       s.save(answer2);


         */
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        Question q = s.get(Question.class,1212);

        System.out.println(q.getQuestion());

        for(Answer a : q.getAnswer()){

            System.out.println(a.getAnswer());
        }

        tx.commit();


        factory.close();
    }
}
