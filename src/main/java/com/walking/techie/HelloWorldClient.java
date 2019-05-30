package com.walking.techie;

import com.walking.techie.entity.Message;
import com.walking.techie.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HelloWorldClient {
  public static void main(String[] args) {
    // get session factory of an application
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Open a session
    Session session = sessionFactory.openSession();

    // Begin a unit of work and return the associated Transaction object.
    Transaction transaction = session.beginTransaction();

    Message message = new Message("Hello world with hibernate using JPA annotations");

    // save the message object into table
    session.save(message);

    // commit the transaction
    transaction.commit();

    // End the session by releasing the JDBC connection and cleaning up.
    session.close();
  }
}
