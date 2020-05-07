package frames;

import backgroud.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
/**
 * This class displays the JFrame for new member and receives all according inputs along with
 * with outputting all required info and performing necessary verification  
 * 
 * @author Hissa Almeadhadi - 201703396
 * Date if Creation: 26/04/2019
 */
public class NewMember extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField idTextFeild;
	private JTextField extraInfoFeild;
	private JTextField depttextField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public NewMember(Library library) {
		
		setTitle("Add a New Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 422, 305);
		contentPane.add(panel);
		
		JLabel memberLabel = new JLabel("Member Type:");
		memberLabel.setBounds(46, 56, 146, 22);
		panel.add(memberLabel);
		
		JComboBox memberComboBox = new JComboBox();
		memberComboBox.setBounds(143, 54, 160, 27);
		panel.add(memberComboBox);
		memberComboBox.addItem("");
		memberComboBox.addItem("Student");
		memberComboBox.addItem("Employee");
		memberComboBox.addItem("Faculty");
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(46, 107, 61, 16);
		panel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(143, 102, 160, 27);
		panel.add(nameTextField);
		
		JLabel IDLabel = new JLabel("ID:");
		IDLabel.setBounds(46, 147, 49, 22);
		panel.add(IDLabel);
		
		idTextFeild = new JTextField();
		idTextFeild.setColumns(10);
		idTextFeild.setBounds(143, 143, 160, 26);
		panel.add(idTextFeild);
		
		JLabel majorLabel = new JLabel("Major:");
		
		extraInfoFeild = new JTextField();
		extraInfoFeild.setColumns(10);
		extraInfoFeild.setBounds(143, 178, 160, 26);
		panel.add(extraInfoFeild);
		extraInfoFeild.setVisible(false);
		
		majorLabel.setEnabled(true);
		majorLabel.setBounds(46, 179, 69, 24);
		panel.add(majorLabel);
		majorLabel.setVisible(false);
		
		JLabel lblOfficePhone = new JLabel("Office Phone:");
		lblOfficePhone.setBounds(46, 178, 146, 26);
		panel.add(lblOfficePhone);
		lblOfficePhone.setVisible(false);
		
		JLabel deptLabel = new JLabel("Dept:");
		deptLabel.setBounds(46, 215, 92, 26);
		panel.add(deptLabel);
		deptLabel.setVisible(false);
		
		depttextField = new JTextField();
		depttextField.setBounds(143, 214, 160, 29);
		panel.add(depttextField);
		depttextField.setColumns(10);
		depttextField.setVisible(false);
		
		JLabel lblMembers = new JLabel("Members");
		lblMembers.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMembers.setBounds(157, 11, 84, 34);
		panel.add(lblMembers);
		
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnClose.setBounds(311, 271, 89, 23);
		panel.add(btnClose);
		
		
		memberComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String memberSelection = (String) memberComboBox.getSelectedItem();
				if(memberSelection=="Student")
				{
					lblOfficePhone.setVisible(false);
					extraInfoFeild.setVisible(true);
					majorLabel.setVisible(true);
					deptLabel.setVisible(false);
					depttextField.setVisible(false);
					
				}
				else if(memberSelection == "Employee") {
					lblOfficePhone.setVisible(true);
					extraInfoFeild.setVisible(true);
					majorLabel.setVisible(false);
					deptLabel.setVisible(false);
					depttextField.setVisible(false);
				}
				else if(memberSelection =="Faculty") {
					lblOfficePhone.setVisible(true);
					extraInfoFeild.setVisible(true);
					majorLabel.setVisible(false);
					deptLabel.setVisible(true);
					depttextField.setVisible(true);
					
				}
			}
		
		});
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String memberSelection = (String) memberComboBox.getSelectedItem();
				if(memberSelection=="Student")
				{
					Member newStudent = new Student (Integer.parseInt(idTextFeild.getText()),nameTextField.getText(),extraInfoFeild.getText());
					library.addMember(newStudent);
					System.out.println(newStudent);
					setVisible(false);
					dispose();
					
				}
				else if(memberSelection == "Employee") {
					Member newEmployee = new Employee (Integer.parseInt(idTextFeild.getText()),nameTextField.getText(),extraInfoFeild.getText());
					library.addMember(newEmployee);
					System.out.println(newEmployee);
					setVisible(false);
					dispose();
				}
				else if(memberSelection =="Faculty") {
					
					Member newFaculity = new Faculty (Integer.parseInt(idTextFeild.getText()),nameTextField.getText(),extraInfoFeild.getText(),depttextField.getText());
					library.addMember(newFaculity);
					System.out.println(newFaculity);
					setVisible(false);
					dispose();
				}
				
			}
		});
		btnAddMember.setBounds(193, 271, 108, 23);
		panel.add(btnAddMember);
		
	}
}
