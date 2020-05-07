package frames;

import backgroud.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * This class displays the JFrame for menu and receives all according inputs along with
 * with outputting all required info and performing necessary verification  
 * 
 * @author Hissa Almeadhadi - 201703396
 * Date if Creation: 26/04/2019
 */
public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu(Library library) {
		setTitle("Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 428, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton newMemberBtn = new JButton("New Member");
		newMemberBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NewMember frame = new NewMember(library);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		
		
		newMemberBtn.setBounds(160, 39, 117, 29);
		panel.add(newMemberBtn);
		
		JButton newItemBtn = new JButton("New Item");
		newItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NewItem frame = new NewItem(library);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		newItemBtn.setBounds(160, 80, 117, 29);
		panel.add(newItemBtn);
		
		JButton borrowReturnBtn = new JButton("Borrow/Return");
		borrowReturnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BorrowReturn frame = new BorrowReturn(library);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		borrowReturnBtn.setBounds(160, 115, 117, 29);
		panel.add(borrowReturnBtn);
		
		JButton reportbtn = new JButton("Reports");
		reportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Reports frame = new Reports(library);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		reportbtn.setBounds(160, 156, 117, 29);
		panel.add(reportbtn);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filename = "data.ser";
				FileOutputStream fos =null;
				ObjectOutputStream out =null;
				try {
					fos= new FileOutputStream(filename);
					out= new ObjectOutputStream(fos);
					out.writeObject(library);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				setVisible(false);
				dispose();
			}
		});
		exitbtn.setBounds(160, 197, 117, 29);
		panel.add(exitbtn);
		
		JLabel lblWelcomeToOur = new JLabel("Welcome to our Library System");
		lblWelcomeToOur.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWelcomeToOur.setBounds(134, 14, 184, 14);
		panel.add(lblWelcomeToOur);
	}
}
