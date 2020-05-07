package backgroud;

import java.io.Serializable;
/**
 * Class is meant to serve as super class for Book and Periodical in order to link them so that they 
 * later can live within the same ArrayList in the Library class
 * 
 * @author Shaymaa Almohssen - 201704067
 * Date of Creation: 21/04/2019
 */

public  abstract class Borrowable implements Serializable {
	
	
	private String callNumber;
	private boolean status;

	/**
	 * This constructor is used by the subclass in order to initialize the inherited callNumber field
	 * Additionally this constructor sets the default value for the status to true thus making  a Borrowable(Book/Periodical) available upon creation
	 * @param callNumber the call number of a Borrowable (Book/Periodical)
	 */
	public Borrowable(String callNumber) {
		this.callNumber = callNumber;
		this.status = true;
	}
 
	/**
	 * Abstract method to be implemented in the subclasses of Borrowable used to return either the ISBN or ISSN depending on the object type (Book/Periodical) invoking it 
	 * @return the ISBN or ISSN of a Book/Periodical
	 */
	public abstract String getISEBN_Issn();
	/**
	 * Abstract method to be implemented in the subclasses of Borrowable used to return either the tile of a Book/Periodical invoking it 
	 * @return the title of a Book/Periodical
	 * 
	 */
	public abstract String getTitle();


	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
