package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student("Sirisha", 2002);
        session.persist(student);

        tx.commit();
        session.close();
        factory.close();
        System.out.println("Student inserted successfully!");
    }
}