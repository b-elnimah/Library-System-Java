package backgroud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
/**
 * This class is where all Borrowable, Member, and Operation objects are saved in their respective ArrayLists
 * functionally this class is the heart of this library system all inputs are received here decided upon with according returns being sent 
 * back to the frames for display to the user 
 * 
 * @author Norah Alhajri - 201307222
 * Date of Creation: 23/04/2019
 *
 */
public class Library implements Serializable {
	/**
	 * ArrayList containing all Member objects in the library
	 */
	private ArrayList<Member> members;
	/**
	 * ArrayList containing all Borrowable objects in the library
	 */
	private ArrayList<Borrowable> borrowableItems;
	/**
	 * ArrayList containing all Operations objects in the library
	 */
	private ArrayList<Operation> borrowingOperations;
	/**
	 * This constructor creates empty ArrayLists for the above mentioned ArrayLists
	 */
	public Library() {
		members = new ArrayList<Member>();
		borrowableItems = new ArrayList<Borrowable>();
		borrowingOperations = new ArrayList<Operation>();
	}
	/**
	 * Upon being called and passed a Member object this method adds said object to the according ArrayList
	 * @param member new member
	 */
	public void addMember(Member member)
	{
		members.add(member);
	}
	/**
	 * Upon being called and passed a Borrowable object this method adds said object to the according ArrayList
	 * @param borrowable new borrowable
	 */
	public void addBorrowable(Borrowable borrowable)
	{
		borrowableItems.add(borrowable);
	}
	/**
	 * Upon being called and passed an Operation object this method adds said object to the according ArrayList
	 * @param operation new operation
	 */
	public void addOperation(Operation operation)
	{
		borrowingOperations.add(operation);
	}
	/**
	 * This method receives an ID and then loops through the members ArrayList trying find a match if an an id is found 
	 * the name belonging to the same object is returned otherwise the function returns "Not Found"
	 * @param ID the id of the member to be found
	 * @return either the members name or "not found"
	 */
	public String getMember(int ID)
	{
		for(int i=0;i<members.size();i++)
		{
			if(ID==members.get(i).getId())
			{
				return members.get(i).getName();
			}
		}
		return "Not Found";
	}
	/**
	 * This method receives an ISBN or ISSN and then loops through the borrowableItems ArrayList trying find a match if the ISBN or ISSN is found 
	 * the title belonging to the same object is returned otherwise the function returns "Not Found"
	 * @param ISBN_ISSN the ISBN or ISSN of the Borrowable to be found
	 * @return either the borroeables title or "not found"
	 */
	public String getBorrowableBook(String ISBN_ISSN)
	{
		for(int i=0;i<borrowableItems.size();i++)
		{
			if(borrowableItems.get(i).getISEBN_Issn().equals(ISBN_ISSN))
				return borrowableItems.get(i).getTitle();		
		}
		
		return "Not Found";
	}
	/**
	 * This method receives an ISBN or ISSN and then loops through the borrowableItems ArrayList trying find a match if the ISBN or ISSN is found 
	 * then it sees if the status of that borrowble is true if it is it sets the status to false and returns true otherwise the function returns false
	 * @param ISBN_ISSN  the ISBN or ISSN of the Borrowable to be found
	 * @return true or false depending on whether the status is true or false in an inverse relationship
	 */
	public boolean changeStatus(String ISBN_ISSN)
	{
		for(int i=0;i<borrowableItems.size();i++)
		{
			if(borrowableItems.get(i).getISEBN_Issn().equals(ISBN_ISSN)&&borrowableItems.get(i).isStatus())
			{
				borrowableItems.get(i).setStatus(false);
				return true;
			}
		}
		return false;
	}
	/**
	 * This method receives an ISBN or ISSN and then loops through the borrowableItems ArrayList trying find a match if the ISBN or ISSN is found 
	 * then function returns that object of borrowable else the method returns null
	 * @param ISBN_ISSN the ISBN or ISSN of the Borrowable to be found
	 * @return a borrowable object or null depending on whether one was found
	 */
	public Borrowable getBorrowableObject(String ISBN_ISSN)
	{
		for(int i=0;i<borrowableItems.size();i++)
		{
			if(borrowableItems.get(i).getISEBN_Issn().equals(ISBN_ISSN))//&&borrowableItems.get(i).isStatus())
			{
				System.out.println("Here");
				return borrowableItems.get(i);
				
			}
		}
			return null;
	}
	/**
	 * This method receives an ID and then loops through the members ArrayList trying find a match if an an id is found 
	 * then the method returns that object of Member otherwise it returns null
	 * @param id the id of the member to be found
	 * @return the member object or null depending on whether one is found
	 */
	public Member getMemberObject(int id)
	{
		for(int i=0;i<members.size();i++)
		{
			if(id==members.get(i).getId())
			{
				System.out.println("returning member");
				return members.get(i);
			}
		}
		return null;
	}
	/**
	 * his method takes  an ISSN or ISBN and then loops through the borrowingOperations ArrayList look to see if the item is found and has 
	 * a status set to false if so it returns the the name of the member that borrowed it
	 * @param ISBN_ISSN the ISSN or ISBN of the borrowable to be found
	 * @return either the name of the member that borrowed the item or not borrowed
	 */
	public String getOperationName(String ISBN_ISSN)
	{
		for(int i=0; i<borrowingOperations.size();i++)
		{
			if(borrowingOperations.get(i).getIbsn_issn().equals(ISBN_ISSN)&&!borrowingOperations.get(i).getStatus())
			{
				return borrowingOperations.get(i).getName();//borrowingOperations.get(i);
			}
		}
		return "Not Borrowed"; //null;
	}
	/**
	 * This method takes  an ISSN or ISBN and then loops through the borrowingOperations ArrayList look to see if the item is found and has 
	 * a status set to false if so it returns the the id of the member that borrowed it
	 * @param ISBN_ISSN the ISSN or ISBN of the borrowable to be found
	 * @return either the id of the member that borrowed the item or not borrowed
	 */
	public String getOperationID(String ISBN_ISSN)
	{
		for(int i=0; i<borrowingOperations.size();i++)
		{
			if(borrowingOperations.get(i).getIbsn_issn().equals(ISBN_ISSN)&&!borrowingOperations.get(i).getStatus())
			{
				return borrowingOperations.get(i).getID();
			}
		}
		return "Not Borrowed"; 
	}
	/**
	This method takes  an ISSN or ISBN and then loops through the borrowingOperations ArrayList look to see if the item is found and has 
	 * a status set to false if so it changes the status to true creates an object of date and creates an object of Operation and adds it to the borrowingOperations ArrayList with required fields
	 * @param ISBN_ISSN the ISSN or IBSN of the book to be returned
	 */
	public void returnBook(String ISBN_ISSN)
	{
		for(int i=0; i<borrowingOperations.size();i++)
		{
			if(borrowingOperations.get(i).getIbsn_issn().equals(ISBN_ISSN)&&!borrowingOperations.get(i).getStatus())
			{
				 borrowingOperations.get(i).setStatus(true);
				 Date pDate = new Date();
				 Calendar lCal = Calendar.getInstance();
				 lCal.setTime(pDate);
				 int lYear = lCal.get(Calendar.YEAR);
				 int lMonth = lCal.get(Calendar.MONTH) + 1;
				 int lDay = lCal.get(Calendar.DATE);
				 date today=new date(lDay,lMonth,lYear);
				 Operation op = new Operation(borrowingOperations.get(i).getMember(), borrowingOperations.get(i).getItem(), today, "Return");
				 borrowingOperations.add(op);
				 break;
			}
		}
		
	}
	/**
	 * This method loops through borrrowingOperations checking for the member id it is given and the status of the corresoniding item 
	 * if the the member if found and the status of the item is false the item is added to an arraylist of borrowables that is then sent returned
	 * @param id the id of the member to be found
	 * @return an arraylist of borroweditems
	 */
	public ArrayList<Borrowable> getBorrowedItemMember(String id){ 
		 ArrayList<Borrowable> borrowedItems = new ArrayList<Borrowable>();
		 for(int i=0 ;i<borrowingOperations.size();i++)
		 {
			 if(borrowingOperations.get(i).getID().equals(id)&& !borrowingOperations.get(i).getStatus())
			 {
				 borrowedItems.add(borrowingOperations.get(i).getItem());
			 }
		 }
		 return borrowedItems;
				 
	}
	/**
	 *  This method loops through borrrowingOperations checking for the day, month and year if a corresponding  item is found 
	 *  the item is added to an arraylist of borrowables that is then sent returned
	 * @param day the day of the operation
	 * @param month the month of the operation
	 * @param year the year of the operation
	 * @return the arraylist of items
	 */
	public ArrayList<Borrowable> getBorrowedIremDate(int day,int month,int year){
		ArrayList<Borrowable> borrowedItems = new ArrayList<Borrowable>();
		for(int i=0;i<borrowingOperations.size();i++)
		{
			if(borrowingOperations.get(i).getDay()== day && borrowingOperations.get(i).getMonth() == month && borrowingOperations.get(i).getYear() == year &&  !borrowingOperations.get(i).getStatus() )
			{
				borrowedItems.add(borrowingOperations.get(i).getItem());
			}
		}
		return borrowedItems;
	}
	/**
	 *This method loops through borrrowingOperations checking for the day, month and year if a corresponding  item is found 
	 *  the type of the item is added to an arraylist of string that is then sent returned
	 * @param day the day of the operation
	 * @param month the month of the operation
	 * @param year the year of the operation
	 * @return an arraylist of types 
	 */
	public ArrayList<String> getType(int day,int month,int year)
	{
		ArrayList<String> borrowedItems = new ArrayList<String>();
		for(int i=0;i<borrowingOperations.size();i++)
		{
			if(borrowingOperations.get(i).getDay()== day && borrowingOperations.get(i).getMonth() == month && borrowingOperations.get(i).getYear() == year &&  !borrowingOperations.get(i).getStatus() )
			{
				borrowedItems.add(borrowingOperations.get(i).getType());
			}
		}
		return borrowedItems;
	}
	/**
	  *This method loops through borrrowingOperations checking for the day, month and year if a corresponding  item is found 
	 *  the name related to the item is added to an arraylist of string that is then sent returned
	 * @param day the day of the operation
	 * @param month the month of the operation
	 * @param year the year of the operation
	 * @return an arraylist of names 
	 */
	public ArrayList<String> getMemNameUsingDate(int day,int month,int year)
	{
		ArrayList<String> borrowedItems = new ArrayList<String>();
		for(int i=0;i<borrowingOperations.size();i++)
		{
			if(borrowingOperations.get(i).getDay()== day && borrowingOperations.get(i).getMonth() == month && borrowingOperations.get(i).getYear() == year &&  !borrowingOperations.get(i).getStatus() )
			{
				borrowedItems.add(borrowingOperations.get(i).getName());
			}
		}
		return borrowedItems;
	}

}
