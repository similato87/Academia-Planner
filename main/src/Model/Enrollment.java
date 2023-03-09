package Model;

import java.util.*;
public class Enrollment implements Registration
{
    private int id;
    private Student student;
    private Course course;
    private Date termStart;
    private Date termEnd;
    private double grade;
    //Should probably be an enum WITHDRAWN,INPROGRESS
    private String status;

    public Enrollment(){
    }

    public Enrollment(int id, Student student, Course course,
        Date termStart, Date termEnd, double grade, String status){
            this.id=id;
            this.student=student;
            this.course=course;
            this.termStart=termStart;
            this.termEnd=termEnd;
            this.grade=grade;
            this.status=status;
    }
    public int getID(){ return id;}
    //Should probably not be modified
    public void setID(int id){ this.id=id; }

    public Student getStudent(){ return student; }
    //Should also probably not be modified
    public void setStudent(Student student){ this.student=student; }

    public Course getCourse(){ return course; }
    public void setCourse(Course course){ this.course=course; }

    //The following are good things we should allow people to update. Term dates grades and course status are all things that can change.
    public Date getTermStart(){ return termStart; }
    public void setTermStart(Date start){ this.termStart=start; }

    public Date getTermEnd(){ return termEnd; }
    public void setTermEnd(Date end){ this.termEnd=end; }


    public double getGrade(){ return grade; }
    public void setGrade(double grade){ this.grade=grade; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }
}