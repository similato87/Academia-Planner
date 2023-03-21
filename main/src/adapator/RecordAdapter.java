package adapator;

import base.Course;
import base.Enrollment;

import java.util.HashMap;

public class RecordAdapter implements Record {
	private Enrollment enrollment;
	private Course course;
	HashMap<String,Double> ptScheme;
	private int creditHours;
	
	private String letterGrade;
	private double points;
	
	private String status;
	
	public RecordAdapter(Enrollment enrollment) {
		this.enrollment=enrollment;
		this.course= enrollment.getCourse();
		this.creditHours = course.getCreditHours();
		ptScheme= new HashMap<String,Double>();

		setPointScheme();
		updateLG();

		calculatePoints();

	}
	
	private void setPointScheme() {
		ptScheme.put("A+", 4.3);
        ptScheme.put("A", 4.0);
        ptScheme.put("A-", 3.7);
        ptScheme.put("B+", 3.3);
        ptScheme.put("B", 3.0);
        ptScheme.put("B-", 2.7);
        ptScheme.put("C+", 2.3);
        ptScheme.put("C", 2.0);
        ptScheme.put("C-", 1.7);
	}
	
	private void updateLG() {
		status = enrollment.getStatus();
		if (status == "WITHDRAWN") {letterGrade = "W";}
		if (status == "INPROGRESS") {letterGrade = "INP";}
		else {
			HashMap<Double, String> scheme = course.getScheme();

			double grade=enrollment.getGrade();
	        	for(double g: scheme.keySet()){

	        		if(grade>=g){

	        			letterGrade=scheme.get(grade);

						break;
	        		}
	        	}
		}
	}
	
	private void calculatePoints() {
		for(String g: ptScheme.keySet()){
    		if(letterGrade == g){

    			points=ptScheme.get(letterGrade)*creditHours;
    			break;
    		}
    	}
	}
	
	
	@Override
	public String getCode() {return course.getCode();}	
	
	@Override
	public String getCourseName() {return course.getName();}
		
	
	@Override
	public String getLetterGrade() {return letterGrade;}
	
	@Override
	public double getCreditHrs() {return creditHours;}
		
	@Override
	public double getPoints() {return points;}
}
