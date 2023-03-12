package View;

import Controller.DepartmentFactory;
import Controller.EnrollmentBuilder;
import Controller.EnrollmentProxy;
import Controller.Transcript;
import Model.Course;
import Model.Department;
import Model.Student;
import Model.CSDepartment;

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
        EnrollmentBuilder e1 = new EnrollmentBuilder();
        e1.setId(1);
        e1.setStudent(s1);
        e1.setCourse(c1);
        e1.setGrade(75);
        e1.setStatus("pass");
        e1.setTermStart(new Date());
        TimeUnit.SECONDS.sleep(1);
        e1.setTermEnd(new Date());
        e1.build();
        // modify grades
        EnrollmentProxy ep1 = new EnrollmentProxy("123");
        // todo edit enrollment
//        ep1.editEnrollment("123",);
        // generate transcript
        Transcript t1 = new Transcript();


    }
}
