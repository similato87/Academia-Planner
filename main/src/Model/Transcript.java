package Model;

import java.util.List;

public class Transcript implements Registration 
{
	List<Enrollment> enrollments;
	
	public Transcript(List<Enrollment> enrollments)
	{
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

}
