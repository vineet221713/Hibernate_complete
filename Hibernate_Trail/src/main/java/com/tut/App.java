package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

      Student st = new Student();
      st.setId(101);
      st.setName("John");
      st.setCity("New York");
      System.out.println(st);


      Address ad = new Address();

      ad.setStreet("street");
      ad.setCity("delhi");
      ad.setOpen(true);
      ad.setAddDate(new Date());
      ad.setX(123);

      //reading image
        FileInputStream fis = new FileInputStream("src/main/resources/img.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(st);

        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("done");
    }
}
