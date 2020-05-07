package backgroud;

import java.io.Serializable;
/**
 * This class is a subclass of Member invoked to create objects of type Employee
 * 
 * @author Norah Alhajri - 201307222
 * Date of Creation: 23/04/2019
 */

public class Employee extends Member implements Serializable{
	
	private String officePhone;
	
	/**
	 * This constructor is takes 3 parameters and passes two of them to the super class to initialize an object of Employee 
	 * @param id the id of the member
	 * @param name the name of the member
	 * @param officePhone the office phone number of the Employee
	 */
	public Employee(int id, String name, String officePhone) {
		super(id, name);
		this.officePhone = officePhone;
	}
	/** 
	 * Used to print objects of Employee else where in the program 
	 */

	@Override
	public String toString() {
		return "Employee = "+super.toString()+ " Office Phone: " + officePhone;
	}
	
	
	
}
