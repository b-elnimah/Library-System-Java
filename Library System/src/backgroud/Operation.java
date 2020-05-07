package backgroud;

import java.io.Serializable;
/**
 * This class is invoked whenever there is a borrow or return event that occurs in the program its purpose is to link the event with the item (Borrowable), the date (date) the event occurred,
 * type (String "borrow"/"return"), and member that is of concern objects of this class are saved in an ArrayList in the Library class.
 * 
 *
 * 
 *  Additionally this class serves as a pass through to access the methods of Member, Item, and date that are passed to this class as they are declared private within its body
 *  therefore the only for instance to use the getName function of Member there is a function within this class that invokes it for the respective Member object within the class and then returns it 
 *  to where the pass through function was called the same lies true for any other functions of Borrawable(and its subclasses), Member (and its subclasses), as well as date.
 *
 * @author Shaymaa Almohssen - 201704067
 * Date of Creation: 21/04/2019
 */

public class Operation implements Serializable {

	private Member member;
	private Borrowable item;
	private date borrowrdDate;
	private String type;
	
	/**
	 * This constructor is used to initialize objects of Operation
	 * 
	 * @param member an object of type Member
	 * @param item an object of type Borrowable
	 * @param borrowrdDate an object of type date
	 * @param type the type of operation occurring 
	 */
	public Operation(Member member, Borrowable item, date borrowrdDate, String type) {
		
		this.member = member;
		this.item = item;
		this.borrowrdDate = borrowrdDate;
		this.type = type;
	}
	

	public Member getMember() {
		return member;
	}
	public Borrowable getItem() {
		return item;
	}
	public String getIbsn_issn()
	{
		return item.getISEBN_Issn();
	}
	public boolean getStatus()
	{
		return item.isStatus();
	}
	public void setStatus(boolean status)
	{
		item.setStatus(status);
	}
	public String getName()
	{
		return member.getName();
	}
	public String getID()
	{
		return Integer.toString(member.getId());
	}
	public date getBorrowrdDate() {
		return borrowrdDate;
	}
	public int getDay()
	{
		return borrowrdDate.getDay();
	}
	public int getMonth()
	{
		return borrowrdDate.getMonth();
	}
	public int getYear() {
		return borrowrdDate.getYear();
	}
	public String getType() {
		return type;
	}
	
	/**
	 * This toString is meant to print objects of Operation elsewhere in the program
	 */
	@Override
	public String toString() {
		return "Operation [member=" + member + ", item=" + item + ", borrowrdDate=" + borrowrdDate + ", type=" + type
				+ "]";
	} 
	
	
}
