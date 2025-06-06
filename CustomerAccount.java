import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CustomerAccount {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerAccountUI window = new customerAccountUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public customerAccountUI() {
		initialize();
	}

	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		createAddCustomerButton();
		createBackButton();
		createUserNameLabel();
		createUserNameTF();
		createPassWordLabel();
		createPassWordTF();
		createFNameLabel();
		createFNameTF();
		createAddressLabel();
		createAddressTF();
	}
	
		public void createAddCustomerButton() {
		
		JButton btnNewButton = new JButton("Create ");
		btnNewButton.setBounds(159, 229, 117, 29);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}	
			
		});
		}
		
		public void createBackButton() {
			JButton backBT = new JButton("< Back");
			backBT.setBounds(6, 237, 117, 29);
			frame.getContentPane().add(backBT);
			backBT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					homePage();
				}
			});
			
		}
		
		public void createUserNameLabel() {
			JLabel lblNewLabel = new JLabel("Username");
			lblNewLabel.setBounds(186, 10, 90, 16);
			frame.getContentPane().add(lblNewLabel);
			
		}
	
		public void createPassWordLabel() {
			JLabel lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setBounds(186, 54, 61, 16);
			frame.getContentPane().add(lblNewLabel_1);
		}
		
		public void createFNameLabel() {
			JLabel lblNewLabel_2 = new JLabel("Full Name");
		lblNewLabel_2.setBounds(186, 112, 90, 16);
		frame.getContentPane().add(lblNewLabel_2);
		}
	
		public void createAddressLabel()
		{
				JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(186, 163, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		}
		
		public void createUserNameTF() {
			textField = new JTextField();
			textField.setBounds(123, 23, 188, 26);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
		}
		
		public void createFNameTF() {
			textField_2 = new JTextField();
			textField_2.setBounds(123, 125, 188, 26);
			frame.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
		}
		
		public void createPassWordTF() {
			textField_1 = new JTextField();
			textField_1.setBounds(123, 70, 188, 26);
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
		}
		public void createAddressTF() {
			textField_3 = new JTextField();
			textField_3.setBounds(123, 179, 188, 26);
			frame.getContentPane().add(textField_3);
			textField_3.setColumns(10);
		}
		
		
		public void homePage() {
			frame.dispose();
			VariousQueriesAndScannerFinalProject main = new VariousQueriesAndScannerFinalProject();
			main.initialize();
			main.frame.setVisible(true);
			
		}
		int random = (int) (Math.random()*49 + 1);
		
		public void addCustomer() {
			try {
				Connection connection = Database.connection;
				String query = "INSERT INTO Customers VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement stm = connection.prepareStatement(query);
				
				
				stm.setInt(1,  random);
				stm.setString(2, textField_2.getText()); 
				stm.setString(3, textField.getText()); 
				stm.setString(4, textField_1.getText());
				stm.setString(5, textField_3.getText());
				stm.setInt(6, random);
				stm.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "The new customer was added to the database!", "Customer Added!", JOptionPane.DEFAULT_OPTION);
			} catch (Exception e) {
				System.out.print(e);
			}
		}
	}





	
	
	
