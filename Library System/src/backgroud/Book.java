package backgroud;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class used for the creation of book objects
 * 
 * @author Shaymaa Almohssen - 201704067
 * Date of Creation: 21/04/2019 
 *
 */
public class Book extends Borrowable implements Serializable {
	
	private String ISEBN;
	private String title;
	private ArrayList <String> author;
	private int adition;
	/**
	 * The constructor of this class takes 5 parameters and sends one to the super class in order initialize a new Book 
	 *
	 * @param callNumber the call number to be pass to the superclass Borrowable 
	 * @param iSEBN the ISBN of a Book
	 * @param title the title of a Book
	 * @param author the author of a Book
	 * @param adition the edition of a Book
	 */
	public Book(String callNumber, String iSEBN, String title, ArrayList<String> author, int adition) {
		super(callNumber);
		ISEBN = iSEBN;
		this.title = title;
		this.author = author;
		this.adition = adition;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getISEBN_Issn() {
		return ISEBN;
	}
	
	/**
	 * This toString method is used to print objects of book else where in the program
	 */
	@Override
	public String toString() {
		return "Book [ISEBN=" + ISEBN + ", title=" + title + ", author=" + author + ", adition=" + adition + "]";
	}


	
}
