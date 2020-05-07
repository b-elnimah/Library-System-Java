package backgroud;

import java.io.Serializable;

/**
 * This class is used to create objects of date and contains 3 fields Day,Month,Year
 *
 * @author Shaymaa Almohssen - 201704067
 * Date of Creation: 21/04/2019
 */

public class date implements Serializable {
	
	private int day; 
	private int month;
	private int year;
	
	/**
	 * The constructor of this class is passed all the values for its  fields upon creation of an object 
	 * @param day receives the day
	 * @param month receives the month
	 * @param year receives the year
	 */
	public date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	

}
