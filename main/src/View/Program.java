package View;

import Model.*;

import java.util.*;



public class Program{
	private static String prompt=
			"0.) Exit Program\n"+
					"1.) Add Student\n"+
					"2.) Add Course\n"+
					"3.) Add Student to course(Enrollment)\n"+
					"4.) Generate Transcript\n"+
					"5.) Edit an enrollment\n\n"+
					"Your choice: ";
	public static void main(String[] args) {
		init();
		boolean quit=false;
		Scanner sc=new Scanner(System.in);
		while(!quit){
			System.out.print(prompt);
			int input=-1;
			try{
				input=sc.nextInt();
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}
			//Input is in fact a number

			switch(input){
				case 0:
					quit=true;break;
				case 1:
					newStudent();break;
				case 2:
					newCourse();break;
				case 3:
					addStudentToCourse();break;
				default:
					System.out.println("No option selected. Please try again.\n");
					break;
			}
		}
		sc.close();
	}

	private static void init(){
		Database db=Database.getDB();
		db.addStudent(new Student(3650173, "Hannah Day", "Fredericton", "Engineering"));
		db.addStudent(new Student(3470952, "John Doe", "Fredericton", "Business"));
		db.addStudent(new Student(3456798, "Jane Doe", "Saint John", "Computer Science"));
		db.addStudent(new Student(3579231, "Camila Paez", "Fredericton", "Engineering"));

		String s = "This course introduces concepts of software design patterns and architecture.";
		db.addCourse(new Course("SWE4403", "FR01A", 4, "Software Design Patterns and Architecture", s, new SWEDepartment()));
		db.addCourse(new Course("CS1073", "FR01A", 4, "Java I", "Introduction to Java I", new CSDepartment()));
		db.addCourse(new Course("CS1083", "FR01A", 4, "Java II", "Introduction to Java II", new CSDepartment(), new ArrayList<>(Arrays.asList("Java 1"))));
		db.addCourse(new Course("ECE4403", "FR01A", 4, "Software Design Fundamentals",
				"This course introduces concepts of software design patterns and architecture.", new ECEDepartment()));
	}

	private static void newStudent(){
		//Do stuff
		//Irl there would be validation of data and options over text input.
		Scanner s=new Scanner(System.in);
		//This would be auto generated
		int id=-1;
		while(true){
			System.out.print("Please input the Student's ID: ");
			try{
				id=s.nextInt();
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}
			break;
		}
		//Got the ID

		System.out.print("Please input the Student's Name");
		String name=s.next();
		System.out.print("Please input the Student's Campus");
		String campus=s.next();
		System.out.print("Please input the Student's Progress");
		String program=s.next();
		s.close();

		System.out.println("Adding new student to database.");
		Database.getDB().addStudent(new Student(id,name,campus,program));
	}

	public static void newCourse(){
		Scanner s=new Scanner(System.in);
		System.out.print("Please input the Course's Code");
		String code=s.next();
		System.out.print("Please input the Course's Section");
		String section=s.next();
		int hours=-1;
		while(true){
			System.out.print("Please input the Course's Credit Hours");
			try{
				hours=s.nextInt();
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}
			break;
		}
		System.out.print("Please input the Course's Name");
		String name=s.next();
		System.out.print("Please input the Course's Description");
		String description=s.nextLine();
		System.out.print("Please input the Course's Department");
		String dep=s.next();
		Department department=createDepartment(dep);
		System.out.print("Please input the Course's Prerequisites if there are any\nFormat: Course1 Course2 ...");
		String[] courses=s.nextLine().split(" ");
		ArrayList<String> courseList=new ArrayList<>();
		for(String str: courses){
			Course c=Database.getDB().getCourse(str);
			if(c==null){
				System.out.println("Course "+str+" does not currently exist. Skipping target.");
			}else{
				courseList.add(str);
			}
		}
		s.close();
		System.out.println("Adding new course to Database.");
		Database.getDB().addCourse(new Course(code,section,hours,name,description,department, courseList));
		
	}

	private static void addStudentToCourse(){
		//TBD
	}

	private static Department createDepartment(String departmentType){
		if (departmentType.equalsIgnoreCase("CS")) {
			return new CSDepartmentFactory().createDepartment();
		} else if (departmentType.equalsIgnoreCase("SWE")) {
			return new SWEDepartmentFactory().createDepartment();
		} else if( departmentType.equalsIgnoreCase("ECE")){
			return new ECEDepartmentFactory().createDepartment();
		}
		else {
			throw new IllegalArgumentException("Invalid department type: " + departmentType);
		}
	}
}