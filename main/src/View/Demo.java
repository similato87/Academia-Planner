package View;


import Controller.EnrollmentBuilder;
import Controller.EnrollmentProxy;
import Controller.RecordAdapter;
import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        // init two student
        Student s1 = new Student(3333333, "John Doe", "Fredericton", "Business");
        Student s2 = new Student(4444444, "Mary Smith", "Saint John", "Computer Science");

        // Yuzhuo Factory method

        Department csdprt = new CSDepartmentFactory().createDepartment();
        Department swedprt = new SWEDepartmentFactory().createDepartment();

        // init three course to show different prerequsites and departments
        Course c1 = new Course("CS1073", "FR01A", 4, "Java I", "Introduction to Java I", csdprt);
        Course c2 = new Course("CS1083", "FR01A", 4, "Java II", "Introduction to Java II", csdprt);
        Course c3 = new Course("SWE4403", "FR01A", 4, "Software Design Patterns and Architecture", "GoF software design patterns", swedprt);

        // Luc builder
        EnrollmentBuilder enrollmentBuilder = new EnrollmentBuilder();
        enrollmentBuilder.setId(1);
        enrollmentBuilder.setStudent(s1);
        enrollmentBuilder.setCourse(c1);
        enrollmentBuilder.setGrade(80.0);
        enrollmentBuilder.setStatus("pass");
        enrollmentBuilder.setTermStart(new Date());
        TimeUnit.SECONDS.sleep(1);
        enrollmentBuilder.setTermEnd(new Date());
        Enrollment e1 = enrollmentBuilder.build();
        // modify grades


        // Yuzhuo proxy
        EnrollmentProxy ep1 = new EnrollmentProxy("123");
        ep1.editGrade("123",e1,90.0);



        // Hannah decorator
        RecordAdapter recordAdapter= new RecordAdapter(e1);
        String record = new String();
        record+=recordAdapter.getCode()+" "+recordAdapter.getCourseName()+" "+recordAdapter.getLetterGrade()+" "+recordAdapter.getPoints();
        System.out.println(record);

        // Madison composite
        Enrollment e2 = new Enrollment(1, s1, c2, new Date(), new Date(), 70, "pass");
        Enrollment e3 = new Enrollment(1, s1, c3, new Date(), new Date(), 85, "pass");
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        enrollments.add(e1);
        enrollments.add(e2);
        enrollments.add(e3);
        Transcript t = new Transcript(s1,enrollments);
        System.out.println(t.toString());

        // Camila iterator
        // Luc Singleton
        Database db = Database.getDB();
        db.addStudent(s1);
        db.addStudent(s2);
        db.addCourse(c1);
        db.addCourse(c2);
        db.addCourse(c3);
        System.out.println("Search for student with ID: 3333333")
        System.out.println(db.getStudent(3333333));
        System.out.println("Search for course with code: CS1073")
        System.out.println(db.getCourse("CS1073"));



    }
}
