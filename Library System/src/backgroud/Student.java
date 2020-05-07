package backgroud;

import java.io.Serializable;
/**
 * This class is invoked to create objects of type Student
 * 
 * @author Norah Alhajri - 201307222
 * Date of Creation: 23/04/2019
 *
 */
public class Student extends Member implements Serializable {
	
	private String major;
	/**
	 * This constructor initializes the fields for the Student class
	 * @param id the students id sent to the superclass for assignment
	 * @param name the students name sent to the superclass for assignment
	 * @param major the students major
	 */
	public Student(int id, String name, String major) {
		super(id, name);
		this.major = major;
	}
	/**
	 * this toString is to print objects of student elsewhere in the program
	 */
	@Override
	public String toString() {
		return "Student = "+ super.toString()+" Major: " + major;
	}
	

	
	
	
	
	

}
