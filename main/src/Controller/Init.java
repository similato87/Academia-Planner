package Controller;

public class Init {
	public void main(String args[]) {
	Student s1 = new Student(3650173, "Hannah Day", "Fredericton", "Engineering");
	Student s2 = new Student(3470952, "John Doe", "Fredericton", "Business");
	Student s3 = new Student(3456798, "Jane Doe", "Saint John", "Computer Science");
	Student s4 = new Student(3579231, "Camila Paez", "Fredericton", "Engineering");
	
	String s = "This course introduces concepts of software design patterns and architecture.";
	Course c1 = new Course("SWE4403", "FR01A", 4, "Software Design Patterns and Architecture", s, "SWE");
	Course c2 = new Course("CS1073", "FR01A", 4, "Java I", "Introduction to Java I", "CS");
	Course c3 = new Course("CS1083", "FR01A", 4, "Java II", "Introduction to Java II", "CS");
	Course c4 = new Course("ECE4403", "FR01A", 4, "Software Design Fundamentals",
			"This course introduces concepts of software design patterns and architecture.", "ECE");
	}
}
