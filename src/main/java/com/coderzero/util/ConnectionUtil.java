package com.coderzero.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionUtil {
    private static SessionFactory  sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        if(null == sessionFactory){
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(com.coderzero.model.Course.class);
            configuration.addAnnotatedClass(com.coderzero.model.Fresher.class);
            configuration.addAnnotatedClass(com.coderzero.model.Address.class);
            configuration.addAnnotatedClass(com.coderzero.model.Group.class);
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
         return sessionFactory;
    }
}
