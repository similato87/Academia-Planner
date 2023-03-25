package Model;

import java.util.*;
import Controller.*;
import Controller.Iterator;
public class Database{
    private static Database instance;
    private HashSet<Student> students;
    private HashSet<Course> courses;
    //We could use this as a 'logging' feature or something. The history of the session's actions.
    private HashSet<Enrollment> enrollments;
    //Transcript probably good here too


    private Database(){
        this.students=new HashSet<>();
        this.courses=new HashSet<>();
        this.enrollments=new HashSet<>();
    }

    public static Database getDB(){
        //No need to multithread so single access instance is okay.
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }

    public Student getStudent(int id){
        Iterator<Student> itr = new StudentIterator(students);
		while(itr.hasNext()) {
            Student val=itr.getNext();
            if(val.getStudentID()==id){
                return val;
            }
		}
        return null;
    }

    public void addStudent(Student s){
        students.add(s);
    }

    //Could possibly return students.values() for a collection of Students if we want to observe all students instead of the map directly
    public HashSet<Student> getStudentMap(){
        return students;
    }

    //Same thing with courses.
    public HashSet<Course> getCourseMap(){
        return courses;
    }

    public Course getCourse(String courseCode){
        Iterator<Course> itr=new CourseIterator(courses);
        while(itr.hasNext()) {
            Course val=itr.getNext();
            if(val.getCode().equals(courseCode)){
                return val;
            }
		}
        return null;
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    //Same with enrollments
    public HashSet<Enrollment> getEnrollments(){
        return enrollments;
    }

    public void addEnrollment(Enrollment e){
        enrollments.add(e);
    }

    public List<Enrollment> findAllEnrollmentsFromStudent(Student s){
        ArrayList<Enrollment> studentEnrolls=new ArrayList<>();
        for(Enrollment e: enrollments){
            if(e.getStudent().equals(s)){
                studentEnrolls.add(e);
            }
        }
        return studentEnrolls;
    }

    public Enrollment getEnrollment(int id){
        Iterator<Enrollment> itr=new EnrollmentIterator(enrollments);
        while(itr.hasNext()) {
            Enrollment val=itr.getNext();
            if(val.getID()==id){
                return val;
            }
		}
        return null;
    }
}
