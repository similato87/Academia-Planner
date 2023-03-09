package Controller;

import Model.Student;

public interface Iterator {
	public Student getNext();
	public boolean hasNext();
	public void reset();
}

