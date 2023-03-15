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
		for(Enrollment e: enrollments)
		{
			gpa += e.getGrade();
		}
		return gpa/enrollments.size();
	}

	public String toString()
	{
		StringBuffer print = new StringBuffer();
		print.append("Transcript of " + student.getStudentID());

		for (Enrollment e: enrollments)
		{
			print.append(e.getCourse().getName() + "\t" + e.getCourse().getCreditHours() + "\t" + e.getGrade());
		}
		print.append("GPA: " + this.getGrade());
		return String.valueOf(print);
	}

}
