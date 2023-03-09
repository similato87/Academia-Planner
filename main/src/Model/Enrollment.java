package Model;

import java.util.*;
public class Enrollment implements Registration{
    private int id;
    private Student student;
    private Course course;
    private Date termStart;
    private Date termEnd;
    private double grade;
    //Take from a course grading scheme or a default grading?
    private String letterGrade;
    //Should probably be an enum PASSED,FAILED,WITHDRAWN,INPROGRESS
    private String status;
    HashMap<Double,String> scheme;

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
            //Default scheme
            scheme.put(95.0, "A+");
            scheme.put(90.0, "A");
            scheme.put(85.0, "A-");
            scheme.put(80.0, "B+");
            scheme.put(75.0, "B");
            scheme.put(70.0, "B-");
            scheme.put(65.0, "C+");
            scheme.put(60.0, "C");
            scheme.put(55.0, "C-");
            scheme.put(50.0, "D");
            scheme.put(0.0,"F");
            updateLetterGrade();
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

    public String getLetterGrade(){ return letterGrade; }
    public void updateLetterGrade() {
        double grade=this.grade;
        for(double g: scheme.keySet()){
            if(grade>=g){
                letterGrade=scheme.get(g);
                break;
            }
        }
    }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }
}