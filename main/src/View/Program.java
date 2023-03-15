package View;

import java.util.*;
import Controller.Iterator;
import Model.*;
import javafx.scene.chart.PieChart.Data;
import Controller.*;
public class Program{
	private static String prompt=
		"\n0.) Exit Program\n"+
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
				case 4:
					createTranscript();break;
				case 5:
					editEnrollment();break;
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

		System.out.print("Please input the Student's Name: ");
		String name=s.next();
		System.out.print("Please input the Student's Campus: ");
		String campus=s.next();
		System.out.print("Please input the Student's Program: ");
		String program=s.next();

		System.out.println("Adding new student to database.");
		Database.getDB().addStudent(new Student(id,name,campus,program));
	}

	public static void newCourse(){
		Database connection=Database.getDB();
		Scanner s=new Scanner(System.in);
		System.out.print("Please input the Course's Code: ");
		String code=s.next();
		System.out.print("Please input the Course's Section: ");
		String section=s.next();
		int hours=-1;
		while(true){
			System.out.print("Please input the Course's Credit Hours: ");
			try{
				hours=s.nextInt();
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}break;
		}
		System.out.print("Please input the Course's Name: ");
		//Consume the newline that have remained from s.next
		s.nextLine();
		String name=s.nextLine();

		System.out.print("Please input the Course's Description: ");
		//Consume the newline that have remained from s.next
		s.nextLine();
		String description=s.nextLine();

		System.out.print("Please input the Course's Department: ");
		String dep=s.next();
		Department department=DepartmentFactory.createDepartment(dep);
		if(connection.getCourseMap().isEmpty()){
			System.out.println("Adding new course to Database.");
			Database.getDB().addCourse(new Course(code,section,hours,name,description,department));
			return;
		}
		System.out.print("Please input the Course's Prerequisites if there are any\nFormat: Course1 Course2 ...");
		//Consume the newline that have remained from s.next
		s.nextLine();
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
		System.out.println("Adding new course to Database.");
		Database.getDB().addCourse(new Course(code,section,hours,name,description,department, courseList));			
	}

	private static void addStudentToCourse(){
		Database connection=Database.getDB();
		Iterator<Student> itr = new StudentIterator(connection.getStudentMap());
		while(itr.hasNext()) {
            Student val=itr.getNext();
            System.out.println(val.getStudentID());
		}
		Student student=null;
		Scanner s=new Scanner(System.in);
		while(true){
			System.out.print("Please input the desired student's id: ");
			try{
				int id=s.nextInt();
				Student trial=connection.getStudent(id);
				if(trial==null){
					throw new IllegalArgumentException();
				}
				student=trial;
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}catch (IllegalArgumentException e){
				System.out.println("Id given does not correspond to any current student. Please try again.");
			}
			break;
		}
		//We have properly selected the students
		Iterator<Course> citr=new CourseIterator(connection.getCourseMap());
		while(citr.hasNext()) {
            Course val=citr.getNext();
            System.out.println(val.getCode());
		}
		Course course=null;
		while(true){
			System.out.print("Please input the desired course code: ");
			try{
				String code=s.next();
				Course trial=Database.getDB().getCourse(code);
				if(trial==null){
					throw new IllegalArgumentException();
				}
				course=trial;
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}catch (IllegalArgumentException e){
				System.out.println("Id given does not correspond to any current course. Please try again.");
			}
			break;
		}
		Enrollment e=new EnrollmentBuilder()
			.setId(connection.getEnrollments().size())
			.setStudent(student)
			.setCourse(course)
			.setGrade(0)
			.setStatus("INPROGRESS")
			.build();
		connection.addEnrollment(e);
	}

	public static void createTranscript(){
		Database connection=Database.getDB();
		Iterator<Student> itr = new StudentIterator(connection.getStudentMap());
		while(itr.hasNext()) {
            Student val=itr.getNext();
            System.out.println(val.getStudentID());
		}
		Student student=null;
		Scanner s=new Scanner(System.in);
		while(true){
			System.out.print("Please input the desired student's id: ");
			try{
				int id=s.nextInt();
				Student trial=connection.getStudent(id);
				if(trial==null){
					throw new IllegalArgumentException();
				}
				student=trial;
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}catch (IllegalArgumentException e){
				System.out.println("Id given does not correspond to any current student. Please try again.");
			}
			break;
		}
		Transcript t=new Transcript(student, connection.findAllEnrollmentsFromStudent(student));
		System.out.println(t.toString());
	}

	public static void editEnrollment(){
		Database connection=Database.getDB();
		EnrollmentProxy enrollmentProxy=new EnrollmentProxy("1234");
		Scanner s=new Scanner(System.in);
		System.out.println("Please input the admin password: ");
		String pass=s.next();

		Iterator<Enrollment> itr=new EnrollmentIterator(connection.getEnrollments());
		while(itr.hasNext()) {
            Enrollment val=itr.getNext();
            System.out.println(val.getID());
		}
		Enrollment enrollment=null;
		while(true){
			System.out.print("Please input the desired enrollment id: ");
			try{
				int id=s.nextInt();
				Enrollment trial=connection.getEnrollment(id);
				if(trial==null){
					throw new IllegalArgumentException();
				}
				enrollment=trial;
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}catch (IllegalArgumentException e){
				System.out.println("Id given does not correspond to any current student. Please try again.");
			}
			break;
		}
		double newGrade=-1;
		while(true){
			System.out.println("What is the new grade: ");
			try{
				newGrade=s.nextDouble();
			}catch (InputMismatchException e){
				System.out.println("No number detected. Please try again.");
				continue;
			}
			break;
		}
		System.out.println("Attempting to edit Enrollment"+enrollment.getID());
		try{
			enrollmentProxy.editEnrollment(pass, enrollment, newGrade);
		}catch(SecurityException e){
			System.out.println("Failed to authenticate. Returning to main menu");
		}
	}
}