package com.coderzero;

import com.coderzero.model.*;
import com.coderzero.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {
//        createCourse();
//        createFresher();
//        getCourse(1);
        createdFresherAndGroup();
    }
private static void createdFresherAndGroup(){
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
        Fresher fresher = new Fresher();
        fresher.setName("Bon James");
        Fresher fresher1 = new Fresher();
        fresher1.setName("Jack James");
        List<Fresher> freshers = new ArrayList<Fresher>();
        freshers.add(fresher);
        freshers.add(fresher1);

        Group group1 = new Group();
        group1.setName("Group Java");
        Group group2 = new Group();
        group2.setName("Group Mongo");
        List<Group> groups = new ArrayList<Group>();
        groups.add(group1);
        groups.add(group2);

        fresher.setMy_groups(groups);
        fresher1.setMy_groups(groups);
        group1.setMy_freshers(freshers);
        group2.setMy_freshers(freshers);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(fresher1);
        session.save(fresher);
        session.save(group1);
        session.save(group2);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    private static void createFresher() {
        SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
        try {
            Fresher fresher = new Fresher();
            fresher.setName("John White");
            Address address = new Address();
            address.setDistrict("11 District");
            address.setStreet("Lac long qua");
            fresher.setAddress(address);
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(address);
            session.save(fresher);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void createAddress() {
        SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
        try {
            Address address = new Address();
            address.setStreet("Lac long quan");
            address.setDistrict("11 District");
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void getCourse(int id) {
        SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
//        session.save(course);
//        session.getTransaction().commit();
            Course course = (Course) session.get(Course.class, id);
            System.out.println(course.getName());
            System.out.println(course.getSyllabusList());
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createCourse() {
        try {
            List<Syllabus> syllabusList = new ArrayList<Syllabus>();
            Syllabus syllabus = new Syllabus();
            Syllabus syllabus1 = new Syllabus();
            syllabus.setTrainingTime(10);
            syllabus.setContent("Spring mvc");
            syllabus1.setTrainingTime(20);
            syllabus1.setContent("Spring boot");
            syllabusList.add(syllabus);
            syllabusList.add(syllabus1);
            Course course = new Course();
//            course.setId(1);
            course.setName("Mongo");
            course.setSyllabusList(syllabusList);
            SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            sessionFactory.close();
//            System.out.println(course);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
