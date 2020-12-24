package com.vladimirt.repository;

import com.vladimirt.model.MyUser;
import com.vladimirt.util.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MyUserRepository {


    public void createUser(MyUser user){

        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

    }

    public List<MyUser> getAll() {
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        List<MyUser> users = session.createQuery("from com.vladimirt.model.MyUser").list();
        tx.commit();
        session.close();
        return users;
    }


    public void deleteUser(MyUser user) {
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();
    }

    public MyUser findById(String id) {
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        MyUser user = session.find(MyUser.class, id);
        tx.commit();
        session.close();
        return user;
    }
}
