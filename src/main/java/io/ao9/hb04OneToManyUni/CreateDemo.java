package io.ao9.hb04OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb04OneToManyUni.entity.Course;
import io.ao9.hb04OneToManyUni.entity.Instructor;
import io.ao9.hb04OneToManyUni.entity.InstructorDetail;
import io.ao9.hb04OneToManyUni.entity.Review;

public class CreateDemo {
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

            System.out.println("create instructor");
            Instructor tempInstructor = new Instructor("John", "Smith", "js@123.com");

            System.out.println("create and set instructorDetail");            
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "hobby");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            System.out.println("save instructor");
            session.save(tempInstructor);

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}