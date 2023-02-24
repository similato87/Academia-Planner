package Model;

public class Course {
	private String code;
	private String section;
	private int creditHours;
	private String name;
	private String description;
	private String courseType;
	//Techinically we could have a list of class times in some sort of structure but we might not wanna mess with that at this time.

	public Course(){
	}

	public Course(String code, String section, int creditHours, String name, String description, String courseType){
		this.code=code;
		this.section=section;
		this.creditHours=creditHours;
		this.name=name;
		this.description=description;
		this.courseType=courseType;
	}

	public String getCode(){ return code; }
	public void setCode(String code){ this.code=code; }

	public String getSection(){ return section;	 }
	public void setSection(String section){ this.section=section; }

	public int getCreditHours(){ return creditHours; }
	public void setCreditHours(int creditHours){ this.creditHours=creditHours; }
	
	public String getName(){ return name; }
	public void setName(String name){ this.name=name; }

	public String getDescription(){ return description; }
	public void setDescription(String description){ this.description=description; }

	public String getCourseType(){ return courseType; }
	public void setCourseType(String courseType){ this.courseType=courseType;}

	//Equals method needed?
}
