package io.ao9.hb04OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb04OneToManyUni.entity.Course;
import io.ao9.hb04OneToManyUni.entity.Instructor;
import io.ao9.hb04OneToManyUni.entity.InstructorDetail;
import io.ao9.hb04OneToManyUni.entity.Review;

public class ReadDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-04-one-to-many-uni.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("get course");
            int id = 10;
            Course tempCourse = session.get(Course.class, id);
            
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}