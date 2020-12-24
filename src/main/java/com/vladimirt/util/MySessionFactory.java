package com.vladimirt.util;

import com.vladimirt.model.MyUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class MySessionFactory {

    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(MyUser.class);
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();

    }

    public static Session getSession(){

        return sessionFactory.openSession();
    }



}
