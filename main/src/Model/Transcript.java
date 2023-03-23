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
		double average_percentage = 0;
		for(Enrollment e: enrollments)
		{
			average_percentage += e.getGrade();
		}


		return average_percentage/enrollments.size();
	}

	public String toString()
	{
		StringBuffer print = new StringBuffer();
		print.append("Transcript of " +student.getName()+"(ID:"+ student.getStudentID()+")"+"\n");

		for (Enrollment e: enrollments)
		{
			RecordAdapter recordAdapter= new RecordAdapter(e);
        		String record = new String();
        		record+=recordAdapter.getCode()+" "+recordAdapter.getCourseName()+" "+recordAdapter.getLetterGrade()+" "+recordAdapter.getPoints();
        		System.out.println(record);
		}
		print.append("Average Percentage: " + this.getGrade()+"\n");
		return String.valueOf(print);
	}

}
