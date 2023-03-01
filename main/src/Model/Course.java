package Model;

import Model.Department;
public class Course {
	private String code;
	private String section;
	private int creditHours;
	private String name;
	private String description;
	private Department department;
	private ArrayList<String> prerequisites;
	//Techinically we could have a list of class times in some sort of structure but we might not wanna mess with that at this time.

	public Course(){
		prerequisites=new ArrayList<String>();
	}

	public Course(String code, String section, int creditHours, String name, String description, Department department, ArrayList<String> prerequisites){
		this.code=code;
		this.section=section;
		this.creditHours=creditHours;
		this.name=name;
		this.description=description;
		this.department=department;
		this.prerequisites=prerequisites;
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

	public Department getDepartment(){ return department; }
	public void setDepartment(Department department){ this.department=department;}

	public ArrayList<String> getPreRequisites(){ return prerequisites; }
	public void setPrerequisites(ArrayList<String> prerequisites){ this.prerequisites=prerequisites; }
	//Equals method needed?
}
