package iterator;

import java.util.ArrayList;
import java.util.HashSet;
import base.Course;
public class CourseIterator implements Iterator<Course>{
    private int currentPosition = 0;
	private HashSet<Course> courseSet;
	private ArrayList<Course> courseList;
	
	public CourseIterator(HashSet<Course> set) {
		courseSet = set;
		courseList = new ArrayList<>(courseSet);
	}
	
	public Course getNext(){
		if(!hasNext()) {
			return null;
		}
		Course student = courseList.get(currentPosition);
		currentPosition++;
		return student;
	}
	
	public boolean hasNext() {
		return currentPosition < courseList.size();
	}
	
	public void reset() {
		currentPosition = 0;
	}
}
