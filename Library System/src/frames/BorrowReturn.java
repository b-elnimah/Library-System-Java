package frames;

import java.util.Calendar;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backgroud.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
/**
 * This class displays the JFrame for borrow and return and receives all according inputs along with
 * with outputting all required info and performing necessary verification  
 * 
 * @author Hissa Almeadhadi - 201703396
 * Date if Creation: 26/04/2019
 */
public class BorrowReturn extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField nametextfield;
	private JTextField IBSN_ISSNtextfield;
	private JTextField titletextfiled;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Member member;
	private Borrowable item;
	private boolean itemFound=false;
	private boolean memberFound=false;
	private boolean returnSelected=false;
	private boolean borrowSelected=true;
	private boolean safeToReturn=false;
	

	/**
	 * Create the frame.
	 */
	public BorrowReturn(Library library) {

		setTitle("Borrow an item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClickBorrowTo = new JLabel("Click Borrow to check out your book/periodical");
		lblClickBorrowTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClickBorrowTo.setBounds(58, 208, 277, 14);
		panel.add(lblClickBorrowTo);
		lblClickBorrowTo.setVisible(false);
		
		JLabel lblUnavaible = new JLabel("Unavaible");
		lblUnavaible.setForeground(Color.RED);
		lblUnavaible.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnavaible.setBounds(308, 183, 73, 14);
		panel.add(lblUnavaible);
		lblUnavaible.setVisible(false);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(10, 73, 65, 16);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 108, 61, 16);
		panel.add(lblName);
		
		JLabel lblIsbn = new JLabel("IBSN\\ ISSN :");
		lblIsbn.setBounds(10, 141, 100, 16);
		panel.add(lblIsbn);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setBounds(10, 181, 61, 16);
		panel.add(lblNewLabel);
		
		idtextField = new JTextField();
		idtextField.setBounds(80, 66, 208, 26);
		panel.add(idtextField);
		idtextField.setColumns(10);
		
		nametextfield = new JTextField();
		nametextfield.setBounds(80, 101, 208, 26);
		panel.add(nametextfield);
		nametextfield.setColumns(10);
		nametextfield.setEditable(false);
		
		IBSN_ISSNtextfield = new JTextField();
		IBSN_ISSNtextfield.setBounds(80, 134, 208, 26);
		panel.add(IBSN_ISSNtextfield);
		IBSN_ISSNtextfield.setColumns(10);
		
		titletextfiled = new JTextField();
		titletextfiled.setBounds(80, 171, 208, 26);
		panel.add(titletextfiled);
		titletextfiled.setColumns(10);
		titletextfiled.setEditable(false);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(memberFound&&itemFound&&borrowSelected)
				{
					if(!library.changeStatus(IBSN_ISSNtextfield.getText()))
					{
						lblUnavaible.setVisible(true);
					}
					else
					{
						item = library.getBorrowableObject(IBSN_ISSNtextfield.getText());
						member = library.getMemberObject(Integer.parseInt( idtextField.getText()));
						Date pDate = new Date();
						Calendar lCal = Calendar.getInstance();
						lCal.setTime(pDate);
						int lYear = lCal.get(Calendar.YEAR);
						int lMonth = lCal.get(Calendar.MONTH) + 1;
						int lDay = lCal.get(Calendar.DATE);
						date today=new date(lDay,lMonth,lYear);
						Operation operation = new Operation(member, item, today, "Borrow");
						library.addOperation(operation);
						setVisible(false);
						dispose();
					}
				}
			}
		});
		btnBorrow.setBounds(298, 226, 117, 29);
		panel.add(btnBorrow);
		btnBorrow.setVisible(false);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(safeToReturn) {
					library.returnBook(IBSN_ISSNtextfield.getText());
					setVisible(false);
					dispose();
				}
			}
		});
		btnReturn.setBounds(298, 226, 117, 29);
		panel.add(btnReturn);
		btnReturn.setVisible(false);
		
		JButton btnSearch = new JButton("Search");;
		
		JRadioButton rdbtnReturn = new JRadioButton("Return");
		buttonGroup.add(rdbtnReturn);
		rdbtnReturn.setBounds(194, 36, 141, 23);
		panel.add(rdbtnReturn);
		rdbtnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				borrowSelected=false;
				returnSelected=true;
				lblClickBorrowTo.setVisible(false);
				btnBorrow.setVisible(false);
				lblUnavaible.setVisible(false);
				idtextField.setEditable(false);
				btnSearch.setVisible(false);
				
			}
		});
		
		JRadioButton rdbtnBorrow = new JRadioButton("Borrow",true);
		buttonGroup.add(rdbtnBorrow);
		rdbtnBorrow.setBounds(80, 36, 100, 23);
		panel.add(rdbtnBorrow);
		rdbtnBorrow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				borrowSelected=true;
				returnSelected=false;
				lblUnavaible.setVisible(false);
				idtextField.setEditable(true);
				btnSearch.setVisible(true);
				btnReturn.setVisible(false);
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnClose.setBounds(173, 226, 117, 29);
		panel.add(btnClose);
		
		
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =Integer.parseInt( idtextField.getText());
				String name = library.getMember(id);
				nametextfield.setText(name);
				if(!name.equals("Not Found"))
					memberFound=true;
				else
					memberFound=false;
				if(memberFound&&itemFound&&borrowSelected&&rdbtnBorrow.isSelected()) {
					lblClickBorrowTo.setVisible(true);
					btnBorrow.setVisible(true);
				}
				else
				{
					lblClickBorrowTo.setVisible(false);
					btnBorrow.setVisible(false);
				}

			}
		});
		btnSearch.setBounds(298, 65, 117, 29);
		panel.add(btnSearch);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = library.getBorrowableBook(IBSN_ISSNtextfield.getText());
				titletextfiled.setText(output);
				if(!output.equals("Not Found"))
					itemFound=true;
				else
					itemFound=false;
				if(memberFound&&itemFound&&borrowSelected&&rdbtnBorrow.isSelected()) {
					lblClickBorrowTo.setVisible(true);
					btnBorrow.setVisible(true);
					lblUnavaible.setVisible(false);
				}
				else
				{
					lblClickBorrowTo.setVisible(false);
					btnBorrow.setVisible(false);
				}
				if(itemFound&&returnSelected&&rdbtnReturn.isSelected()) {
					if(!library.getOperationName(IBSN_ISSNtextfield.getText()).equals("Not Borrowed")) {
						idtextField.setText(library.getOperationID(IBSN_ISSNtextfield.getText()));
						nametextfield.setText(library.getOperationName(IBSN_ISSNtextfield.getText()));
						btnReturn.setVisible(true);
						safeToReturn=true;
					}
					else
					{
						idtextField.setText("BOOK NOT BORROWED");
						nametextfield.setText("BOOK NOT BORROWED");
					}
				}
				else
				{
					btnReturn.setVisible(false);
				}
				
			}
		});
		btnSearch_1.setBounds(298, 133, 117, 29);
		panel.add(btnSearch_1);
		
		JLabel lblBorrowreturn = new JLabel("Borrow/Return");
		lblBorrowreturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowreturn.setBounds(146, 15, 117, 14);
		panel.add(lblBorrowreturn);
		
	}
}
