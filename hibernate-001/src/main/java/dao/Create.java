package dao;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.SessionFactoryProvider;

public class Create {
    public static void main(String[] args) {
        // Get SessionFactory instance
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();

        // Open session and handle transactions
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            Employee emp = new Employee(101, "John Doe");
            session.save(emp);

            t.commit();
            System.out.println("Employee saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
