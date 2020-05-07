package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backgroud.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class displays the JFrame for reports and receives all according inputs along with
 * with outputting all required info and performing necessary verification  
 * 
 * @author Hissa Almeadhadi - 201703396
 * Date if Creation: 26/04/2019
 */
public class Reports extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField idTextField;
	private boolean searchByID =true;
	private boolean searchBydate=false;
	private JTextField daytextfield;
	private JTextField mounthtextField;
	private JTextField yeartextField_1;

	
	/**
	 * Create the frame.
	 */
	public Reports(Library library) {
		setTitle("Reports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReports.setBounds(277, 1, 55, 26);
		contentPane.add(lblReports);
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(49, 84, 46, 14);
		contentPane.add(idlabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(83, 81, 425, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(48, 83, 36, 16);
		contentPane.add(lblDay);
		lblDay.setVisible(false);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(185, 83, 61, 16);
		contentPane.add(lblMonth);
		lblMonth.setVisible(false);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(345, 83, 61, 16);
		contentPane.add(lblYear);
		lblYear.setVisible(false);
		
		daytextfield = new JTextField();
		daytextfield.setBounds(83, 78, 75, 26);
		contentPane.add(daytextfield);
		daytextfield.setColumns(10);
		daytextfield.setVisible(false);
		
		mounthtextField = new JTextField();
		mounthtextField.setBounds(258, 78, 75, 26);
		contentPane.add(mounthtextField);
		mounthtextField.setColumns(10);
		mounthtextField.setVisible(false);
		
		yeartextField_1 = new JTextField();
		yeartextField_1.setBounds(402, 78, 101, 26);
		contentPane.add(yeartextField_1);
		yeartextField_1.setColumns(10);
		yeartextField_1.setVisible(false);
		
		JRadioButton rdbtnBorrowedByMember = new JRadioButton("Borrowed by Member",true);
		rdbtnBorrowedByMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByID =true;
				searchBydate=false;
				idlabel.setVisible(true);
				idTextField.setVisible(true);
				lblDay.setVisible(false);
				daytextfield.setVisible(false);
				mounthtextField.setVisible(false);
				lblMonth.setVisible(false);
				yeartextField_1.setVisible(false);
				lblYear.setVisible(false);
				
			}
			
		});
		buttonGroup.add(rdbtnBorrowedByMember);
		rdbtnBorrowedByMember.setBounds(73, 44, 259, 23);
		contentPane.add(rdbtnBorrowedByMember);
		
		JRadioButton rdbtnBorrowedByDate = new JRadioButton("Borrowed by Date");
		rdbtnBorrowedByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByID =false;
				searchBydate=true;
				idlabel.setVisible(false);
				idTextField.setVisible(false);
				lblDay.setVisible(true);
				daytextfield.setVisible(true);
				mounthtextField.setVisible(true);
				lblMonth.setVisible(true);
				yeartextField_1.setVisible(true);
				lblYear.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnBorrowedByDate);
		rdbtnBorrowedByDate.setBounds(349, 44, 207, 23);
		contentPane.add(rdbtnBorrowedByDate);
		
		
		
		TextArea reportTextArea = new TextArea();
		reportTextArea.setBounds(10, 120, 647, 270);
		contentPane.add(reportTextArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(searchByID&&!library.getBorrowedItemMember(idTextField.getText()).isEmpty())
				{
					String output=new String();
					for(int i=0;i<library.getBorrowedItemMember(idTextField.getText()).size();i++) {
						output += library.getBorrowedItemMember(idTextField.getText());
						output+="\n";
					}
					
					reportTextArea.setText(output);
				}
				else if (searchByID&&library.getBorrowedItemMember(idTextField.getText()).isEmpty())
				{
					reportTextArea.setText("Nothing to Show");
				}
				if(searchBydate&&!library.getBorrowedIremDate(Integer.parseInt(daytextfield.getText()), Integer.parseInt(mounthtextField.getText()), Integer.parseInt(yeartextField_1.getText())).isEmpty())
				{
					String output = new String();
					for(int i=0; i<library.getBorrowedIremDate(Integer.parseInt(daytextfield.getText()), Integer.parseInt(mounthtextField.getText()), Integer.parseInt(yeartextField_1.getText())).size();i++) {
						output+= library.getBorrowedIremDate(Integer.parseInt(daytextfield.getText()), Integer.parseInt(mounthtextField.getText()), Integer.parseInt(yeartextField_1.getText()));
						output+=library.getType(Integer.parseInt(daytextfield.getText()), Integer.parseInt(mounthtextField.getText()), Integer.parseInt(yeartextField_1.getText()));
						output+=library.getMemNameUsingDate(Integer.parseInt(daytextfield.getText()), Integer.parseInt(mounthtextField.getText()), Integer.parseInt(yeartextField_1.getText()));
						output+="\n";
					}
					reportTextArea.setText(output);
				}
				else if(searchBydate&&library.getBorrowedIremDate(Integer.parseInt(daytextfield.getText()), Integer.parseInt(mounthtextField.getText()), Integer.parseInt(yeartextField_1.getText())).isEmpty())
				{
					
					reportTextArea.setText("Nothing to Show");
				}
			}
		});
		btnSearch.setBounds(516, 74, 141, 35);
		contentPane.add(btnSearch);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnClose.setBounds(516, 396, 141, 35);
		contentPane.add(btnClose);
		
		
		
		
	}
}
