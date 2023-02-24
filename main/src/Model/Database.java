package Model;

import java.util.*;
public class Database{
    private static Database instance;
    private HashMap<Integer,Student> students;
    private HashMap<String,Course> courses;
    //We could use this as a 'logging' feature or something. The history of the session's actions.
    private HashMap<Integer,Enrollment> enrollments;


    private Database(){
        this.students=new HashMap<Integer,Student>();
    }

    public static Database getDB(){
        //No need to multithread so single access instance is okay.
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }

    public Student getStudent(int id){
        return students.get(id);
    }

    //Could possibly return students.values() for a collection of Students if we want to observe all students instead of the map directly
    public HashMap getStudentMap(){
        return students;
    }

    //Same thing with courses.
    public HashMap getCourseMap(){
        return courses;
    }

    public Course getCourse(String courseCode){
        return courses.get(courseCode);
    }

    //Same with enrollments
    public HashMap getEnrollments(){
        return enrollments;
    }
}
