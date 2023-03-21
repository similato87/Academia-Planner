package iterator;

import java.util.ArrayList;
import java.util.HashSet;

import base.Student;

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
}

