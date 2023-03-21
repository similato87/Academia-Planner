package builder;

import java.util.Date;

import base.Course;
import base.Enrollment;
import base.Student;
public class EnrollmentBuilder{
    private int id;
    private Student student;
    private Course course;
    private Date termStart;
    private Date termEnd;
    private double grade;
    private String status;
	public EnrollmentBuilder(){}

	public EnrollmentBuilder setId(int id){
        this.id=id;
        return this;
	}

    public EnrollmentBuilder setStudent(Student student){
        this.student=student;
        return this;
    }

    public EnrollmentBuilder setCourse(Course course){
        this.course=course;
        return this;
    }

    public EnrollmentBuilder setTermStart(Date termStart){
        this.termStart=termStart;
        return this;
    }

    public EnrollmentBuilder setTermEnd(Date termEnd){
        this.termEnd=termEnd;
        return this;
    }

    public EnrollmentBuilder setGrade(double grade){
        this.grade=grade;
        return this;
    }

    public EnrollmentBuilder setStatus(String status){
        this.status=status;
        return this;
    }

    public Enrollment build(){
        return new Enrollment(id,student,course,termStart,termEnd,grade,status);
    }
}