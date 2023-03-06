package Model;

import java.util.List;

public class Transcript implements Registration 
{
	List<Registration> enrollments;
	
	public Transcript(List<Registration> enrollments)
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
		for(Registration e: enrollments)
		{
			gpa += e.getGrade();
		}
		return gpa/enrollments.size();
	}

}
