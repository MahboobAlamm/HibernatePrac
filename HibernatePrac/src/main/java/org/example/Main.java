package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student st = new Student();
        st.setsId(1);
        st.setsName("Mahboob");
        st.setAge(24);

        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(org.example.Student.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transation = session.beginTransaction();
        session.persist(st);
        transation.commit();
    }
}