package Controller;

import java.util.ArrayList;
import java.util.HashSet;

import Model.Student;

public class StudentIterator implements Iterator<Student>{
	private int currentPosition = 0;
	private HashSet<Student> stuSet;
	private ArrayList<Student> stuList;
	
	public StudentIterator(HashSet<Student> set) {
		stuSet = set;
		stuList = new ArrayList<>(stuSet);
	}
	
	public Student getNext(){
		if(!hasNext()) {
			return null;
		}
		Student student = stuList.get(currentPosition);
		currentPosition++;
		return student;
	}
	
	public boolean hasNext() {
		return currentPosition < stuList.size();
	}
	
	public void reset() {
		currentPosition = 0;
	}
	
	//Test if the iterator works --> will be deleted at the end
	public static void main(String args[]) {
		HashSet<Student> set = new HashSet<Student>();
		Student s1 = new Student(3650173, "Hannah Day", "Fredericton", "Engineering");
		Student s2 = new Student(3470952, "John Doe", "Fredericton", "Business");
		set.add(s1);
		set.add(s2);
		Iterator<Student> itr = new StudentIterator(set);
		while(itr.hasNext()) {
			System.out.println(itr.getNext());
		}
	}
}

