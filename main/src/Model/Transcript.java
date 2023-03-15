package Model;

import java.util.List;

public class Transcript implements Registration 
{
	Student student;
	List<Enrollment> enrollments;
	
	public Transcript(Student student, List<Enrollment> enrollments)
	{
		this.student = student;
		this.enrollments = enrollments;
	}

	public void addEnrollment(Enrollment e)
	{
		enrollments.add(e);
	}
	
	public double getGrade() 
	{
		double gpa = 0;
		for(Registration e: enrollments)
		{
			gpa += e.getGrade();
		}
		return gpa/enrollments.size();
	}

	public String toString()
	{
		System.out.println("Transcript of " + student.getStudentID());
		for (Registration e: enrollments)
		{
			System.out.println(e.getCourse().getName() + "\t" + e.getCourse().getCreditHours() + "\t" + e.getGrade());
		}
		System.out.println("GPA: " + this.getGrade());
	}

}
