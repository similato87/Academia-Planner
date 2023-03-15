package Controller;
import java.util.*;
import Model.*;
public class EnrollmentIterator implements Iterator<Enrollment>{
    private int currentPosition = 0;
	private HashSet<Enrollment> enSet;
	private ArrayList<Enrollment> enList;
	
	public EnrollmentIterator(HashSet<Enrollment> set) {
		enSet = set;
		enList = new ArrayList<>(enSet);
	}
	
	public Enrollment getNext(){
		if(!hasNext()) {
			return null;
		}
		Enrollment student = enList.get(currentPosition);
		currentPosition++;
		return student;
	}
	
	public boolean hasNext() {
		return currentPosition < enList.size();
	}
	
	public void reset() {
		currentPosition = 0;
	}
	
}
