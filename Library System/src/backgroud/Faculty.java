package backgroud;

import java.io.Serializable;
/**
 * This class is a subclass of Member invoked to create objects of type Faculty
 * 
 * @author Norah Alhajri - 201307222
 * Date of Creation: 23/04/2019
 */
public class Faculty extends Member implements Serializable{
	private String officePhone;
	private String dept;
	
	/**
	 * 
	 * @param id the id number of the faculty sent to the superclass Member for initialization
	 * @param name the name of the faculty sent to the superclass Member for initialization
	 * @param officePhone the office telephone number for a faculty 
	 * @param dept the department of a faculty
	 */
	public Faculty(int id, String name, String officePhone, String dept) {
		super(id, name);
		this.officePhone = officePhone;
		this.dept = dept;
	}
	
	/**
	 * This toString is used to print objects of Faculty elsewhere in the program
	 */
	@Override
	public String toString() {
		return "Faculty = "+ super.toString()+" Office Phone: " + officePhone + " Dept: " + dept ;
	}
	
	
	
}
