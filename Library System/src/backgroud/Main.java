package backgroud;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;


import frames.*;
/**
 * This class contains the main method that is the required start point for any Java program.
 * 
 * @author Hissa Almeadhadi - 201703396
 * Date: 24/04/2019
 *
 */
public class Main implements Serializable {
	/**
	 * The main method main creates an object of type Library then attempts to load an assignment for it from a 
	 * 
	 * from a serialized file that contains that object if one has been previously saved
	 * otherwise the program prints to the console that no information is available to load
	 * the main then creates an object of the Menu (Jframe) and passes it either the empty object or or the same object that was assigned from the file
	 * thus effectively resuming the program from a previous saved run 
	 * it then sets the menu frame to visible effectively displaying for the user to interact with 
	 * 
	 * 
	 * @param args required array of arguments for the main function normally used to change configuration of the program between runs but not used in our system
	 * @throws Exception this is to catch any possible errors that may occur in attempting to open the data.ser file
	 */

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		Library library=new Library();
		
		FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("data.ser");
            in = new ObjectInputStream(fis);
            library = (Library) in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No Information avaible yet!");
        }
		
		Menu frame = new Menu(library);
		frame.setVisible(true);

	}

}
