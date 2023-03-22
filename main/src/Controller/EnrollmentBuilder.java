package Controller;

import java.util.Date;

import Model.Course;
import Model.Enrollment;
import Model.Student;
public class EnrollmentBuilder{
    private int id;
    private Student student;
    private Course course;
    private Date termStart;
    private Date termEnd;
    private double grade;
    private String status;
    private Enrollment e;
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
        e = new Enrollment(id,student,course,termStart,termEnd,grade,status);
	return e;
    }
}
