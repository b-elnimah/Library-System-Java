package backgroud;

import java.io.Serializable;
/**
 * This abstract class is mean to serve the purpose of establish a relationship between Faculty,Employee,and Student
 * so that the later can be stored with the same ArrayList within the Library class
 *  
 * @author Norah Alhajri - 201307222
 * Date of Creation: 23/04/2019
 *
 */

public abstract class Member implements Serializable {
	
	private int id;
	private String name;
	/**
	 *  This constructor is use by the subclass Faculty,Employee, and Student to initialize the values for id and name
	 * @param id the id name of the member
	 * @param name the name of the member
	 */
	public Member(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * This toString is used to print objects of Member elsewhere in the program
	 */
	@Override
	public String toString() {
		return "ID: " + id + " Name: " + name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
