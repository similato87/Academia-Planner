package View;

import Controller.DepartmentFactory;
import Controller.EnrollmentBuilder;
import Controller.EnrollmentProxy;
import Model.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        // init two student
        Student s1 = new Student(3333333, "John Doe", "Fredericton", "Business");
        Student s2 = new Student(4444444, "Mary Smith", "Saint John", "Computer Science");

        // create department
        Department csdprt = DepartmentFactory.createDepartment("CS");
        Department swedprt = DepartmentFactory.createDepartment("SWE");

        // init three course to show different prerequsites and departments
        Course c1 = new Course("CS1073", "FR01A", 4, "Java I", "Introduction to Java I", csdprt);
        Course c2 = new Course("CS1083", "FR01A", 4, "Java II", "Introduction to Java II", csdprt);
        Course c3 = new Course("SWE4403", "FR01A", 4, "Software Design Patterns and Architecture", "GoF software design patterns", swedprt);

        // add enrollment
        EnrollmentBuilder enrollmentBuilder = new EnrollmentBuilder();
        enrollmentBuilder.setId(1);
        enrollmentBuilder.setStudent(s1);
        enrollmentBuilder.setCourse(c1);
        enrollmentBuilder.setGrade(75);
        enrollmentBuilder.setStatus("pass");
        enrollmentBuilder.setTermStart(new Date());
        TimeUnit.SECONDS.sleep(1);
        enrollmentBuilder.setTermEnd(new Date());
        Enrollment e1 = enrollmentBuilder.build();
        // modify grades
        
        EnrollmentProxy ep1 = new EnrollmentProxy("123");
        // todo edit enrollment
//        ep1.editEnrollment("123",);
        // generate transcript
//        Transcript t1 = new Transcript();


        RecordAdapter recordAdapter= new RecordAdapter(e1);
        String record = new String();
        record+=recordAdapter.getCode()+" "+recordAdapter.getCourseName()+" "+recordAdapter.getLetterGrade()+" "+recordAdapter.getPoints();
        System.out.println(record);





    }
}
