package frames;

import backgroud.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
/**
 * This class displays the JFrame for new item and receives all according inputs along with
 * with outputting all required info and performing necessary verification  
 * 
 * @author Hissa Almeadhadi - 201703396
 * Date if Creation: 26/04/2019
 */


public class NewItem extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField calllNumberTextField;
	private JTextField isbnIssntextField;
	private JTextField titleTextField;
	private JTextField authorIssueTextField;
	private JTextField edtionYearTextField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public NewItem(Library library) {
		setTitle("New Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewItem = new JLabel("New Item");
		lblNewItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewItem.setBounds(183, 11, 79, 23);
		contentPane.add(lblNewItem);
		
		JLabel lblCallNumber = new JLabel("Call Number:");
		lblCallNumber.setBounds(66, 82, 89, 14);
		contentPane.add(lblCallNumber);
		
		JLabel lblIsbnissn = new JLabel("ISBN/ISSN:");
		lblIsbnissn.setBounds(66, 101, 68, 14);
		contentPane.add(lblIsbnissn);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(66, 126, 46, 14);
		contentPane.add(lblTitle);
		
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(66, 151, 46, 14);
		contentPane.add(lblAuthor);
		
		
		JLabel lblEdition = new JLabel("Edition:");
		lblEdition.setBounds(66, 176, 46, 14);
		contentPane.add(lblEdition);
		
		
		calllNumberTextField = new JTextField();
		calllNumberTextField.setBounds(155, 79, 166, 20);
		contentPane.add(calllNumberTextField);
		calllNumberTextField.setColumns(10);
		
		isbnIssntextField = new JTextField();
		isbnIssntextField.setBounds(155, 101, 166, 20);
		contentPane.add(isbnIssntextField);
		isbnIssntextField.setColumns(10);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(155, 126, 166, 20);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		authorIssueTextField = new JTextField();
		authorIssueTextField.setBounds(155, 151, 166, 20);
		contentPane.add(authorIssueTextField);
		authorIssueTextField.setColumns(10);
		
		
		edtionYearTextField = new JTextField();
		edtionYearTextField.setBounds(155, 176, 166, 20);
		contentPane.add(edtionYearTextField);
		edtionYearTextField.setColumns(10);
		
		
		JLabel lblIssue = new JLabel("Issue:");
		lblIssue.setBounds(66, 151, 46, 14);
		contentPane.add(lblIssue);
		lblIssue.setVisible(false);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(66, 176, 46, 14);
		contentPane.add(lblYear);
		lblYear.setVisible(false);
		
		JLabel lblIfEnteringMultiple = new JLabel("If entering multiple authors please seperate using a coma ex. (John,Mark)");
		lblIfEnteringMultiple.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIfEnteringMultiple.setBounds(10, 220, 427, 14);
		contentPane.add(lblIfEnteringMultiple);
		
		
		JRadioButton rdbtnBook = new JRadioButton("Book",true);
		buttonGroup.add(rdbtnBook);
		rdbtnBook.setBounds(122, 44, 89, 23);
		contentPane.add(rdbtnBook);
		rdbtnBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblAuthor.setVisible(true);
				lblEdition.setVisible(true);
				lblIssue.setVisible(false);
				lblYear.setVisible(false);
				lblIfEnteringMultiple.setVisible(true);
				authorIssueTextField.setVisible(true);
				edtionYearTextField.setVisible(true);
			}
		});
		
		JRadioButton rdbtnPeriodical = new JRadioButton("Periodical");
		buttonGroup.add(rdbtnPeriodical);
		rdbtnPeriodical.setBounds(231, 41, 102, 23);
		contentPane.add(rdbtnPeriodical);
		rdbtnPeriodical.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblAuthor.setVisible(false);
				lblEdition.setVisible(false);
				lblIssue.setVisible(true);
				lblYear.setVisible(true);
				lblIfEnteringMultiple.setVisible(false);
				authorIssueTextField.setVisible(true);
				edtionYearTextField.setVisible(true);
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnClose.setBounds(254, 259, 89, 23);
		contentPane.add(btnClose);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBook.isSelected()) {
					String authors=authorIssueTextField.getText();
					ArrayList<String> authoursList= new ArrayList<String>(Arrays.asList(authors.split(",")));
					Borrowable newBook = new Book(calllNumberTextField.getText(),isbnIssntextField.getText(),titleTextField.getText(),authoursList,Integer.parseInt(edtionYearTextField.getText()));
					library.addBorrowable(newBook);
					System.out.println(newBook);
					setVisible(false);
					dispose();
				}
				else if(rdbtnPeriodical.isSelected())
				{
					Borrowable newPeriodical = new Periodical(calllNumberTextField.getText(),isbnIssntextField.getText(),titleTextField.getText(),Integer.parseInt(authorIssueTextField.getText()),Integer.parseInt(edtionYearTextField.getText()));
					library.addBorrowable(newPeriodical);
					setVisible(false);
					dispose();
				}		
			}
		});
		btnAddItem.setBounds(348, 259, 89, 23);
		contentPane.add(btnAddItem);
		
		
		
		
		
		
	}
}
