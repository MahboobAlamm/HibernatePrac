package org.example;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Laptop lp1 = new Laptop();
        lp1.setlId(101);
        lp1.setlName("Asus");
        lp1.setLmodel("x500");
        lp1.setlYear("2007");

        Laptop lp2 = new Laptop();
        lp2.setlId(102);
        lp2.setlName("Dell");
        lp2.setLmodel("Rt300");
        lp2.setlYear("2046");

        Laptop lp3 = new Laptop();
        lp3.setlId(103);
        lp3.setlName("Lonovo");
        lp3.setLmodel("Fz300");
        lp3.setlYear("2016");

        Student st1 = new Student();
        st1.setsId(1);
        st1.setsName("Mahboob");
        st1.setAge(24);

        Student st2 = new Student();
        st2.setsId(2);
        st2.setsName("Parwez");
        st2.setAge(16);

        st1.setLaptop(List.of(lp1, lp2));
        st2.setLaptop(List.of(lp3, lp2, lp1));
        lp1.setStudents(List.of(st1, st2));
        lp2.setStudents(List.of(st1, st2));
        lp3.setStudents(List.of(st2));


        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.addAnnotatedClass(org.example.Laptop.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        session.persist(lp1);
        session.persist(lp2);
        session.persist(lp3);
        session.persist(st1);
        session.persist(st2);



//        Student st1 = session.find(Student.class, 5); //to get the values using primary key
//        System.out.println(st1.getAge());                //If no value found it will return null, and getting that age from null will throw exception, so handle it explicitly

//          session.merge(st);                               //to upsert the value (Transaction needed)
//          session.remove(st);                              // to remove the value

          transaction.commit();


          //HQL (Hibrnate Querey Language)
        Query<Student> query = session.createQuery("From Student", Student.class);
        List<Student> students = query.getResultList();
        for(Student x : students) {
            System.out.println(x);
        }

        Query<Integer> query1 = session.createQuery("Select age from Student where age = ?1 ");
        query1.setParameter(1, 24);

        List<Integer> ages = query1.getResultList();
        int count = 0;
        for(Integer x : ages) {
            count++;
//            System.out.println(x);
        }
        System.out.println("Total no of people with age equal to 24 : " + count);

    }
}