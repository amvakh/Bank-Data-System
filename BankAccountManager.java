import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class BankAccountManager {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JLabel totalLabel;
	int total;
	public int deposit;
	private JTextField customerIDTF;

	public static void main(String[] args) {
        // Entry point of BankAccountManager {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankAccountUI window = new bankAccountUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public bankAccountUI() {
		initialize();
	}

	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		createTotalLabel();
		totalAmount();
		createDepositLabel();
		createWithDrawlLabel();
		createDepositButton();
		createWithDrawlButton();
		createBackButton();
		createDepositTF();
		createWithDrawlTF();
		customerIDLabel();
		createCustomerIDTF();
	}
	
	public void createTotalLabel()
	{
		JLabel moneyTotal = new JLabel("Total");
		moneyTotal.setBounds(174, 20, 61, 16);
		frame.getContentPane().add(moneyTotal);
	}
	
	public void createDepositLabel() {
		JLabel depositLabel = new JLabel("Deposit");
		depositLabel.setBounds(174, 89, 61, 16);
		frame.getContentPane().add(depositLabel);
	}
	
	public void createWithDrawlLabel() {
		JLabel withDrawlLabel = new JLabel("Withdrawl");
		withDrawlLabel.setBounds(174, 183, 88, 16);
		frame.getContentPane().add(withDrawlLabel);
	}
	public void totalAmount() {
		//makes label
		totalLabel = new JLabel("Total Amount: " + Integer.toString(total));
		totalLabel.setBounds(174, 40, 120, 16);
		frame.getContentPane().add(totalLabel);
		//updates label using function
		updateTotalLabel();
		
	}
	public void customerIDLabel() {
		customerIDTF = new JTextField();
		customerIDTF.setBounds(6, 35, 130, 26);
		frame.getContentPane().add(customerIDTF);
		customerIDTF.setColumns(10);
	}
	
	public void createDepositButton() {

		JButton depositBT = new JButton("Deposit");
		depositBT.setBounds(145, 142, 117, 29);
		frame.getContentPane().add(depositBT);
		depositBT.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				//creates int deposit that takes text value from field and converts to int
				int deposit = Integer.parseInt(textField.getText());
				//adds deposit amount from total and saves back into the total
				total += deposit;
				//updates label
				updateTotalLabel();
				depositButton();
				
			}
			
		});
	}
	
	public void depositButton() {
		try {
			Connection connection = Database.connection;
			String query = "UPDATE BankAccounts SET balance = ? WHERE customer_id = ?";
			PreparedStatement stm = connection.prepareStatement(query);
			stm.setInt(1, total + deposit);
			stm.setString(2,  customerIDTF.getText());
			stm.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "New Deposit made!", "Deposit Added!", JOptionPane.DEFAULT_OPTION);
			
		}catch(Exception e) {
			System.out.print(e);
			
		}
	}
	
	
	public void createWithDrawlButton() {
		JButton withdrawlBT = new JButton("Withdrawl");
		withdrawlBT.setBounds(145, 226, 117, 29);
		frame.getContentPane().add(withdrawlBT);
		withdrawlBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//creates int withdrawl that takes text value of field and converts to int
				int withdrawl = Integer.parseInt(textField_1.getText());
				//subtracts withdrawl amount from total and saves back into the total
				total -= withdrawl;
				//updates label
				updateTotalLabel();
			}
		});
	}
	
	public void createBackButton() {
		JButton backBT = new JButton("< Back");
		backBT.setBounds(6, 237, 117, 29);
		frame.getContentPane().add(backBT);
		backBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInPage();
			}
		});
		
	}
	
	public void signInPage()
	{
		frame.dispose();
		signInUI SIP = new signInUI();
		SIP.initialize();
		SIP.frame.setVisible(true);
		
	}
	
	public void updateTotalLabel() {
		totalLabel.setText("Total Amount: " + total);
	}
	
	public void createDepositTF() {
		textField = new JTextField();
		textField.setBounds(133, 107, 142, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void createWithDrawlTF() {
		textField_1 = new JTextField();
		textField_1.setBounds(133, 198, 142, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	
	public void createCustomerIDTF() {
		JLabel customerIDLabel = new JLabel("Customer ID");
		customerIDLabel.setBounds(29, 20, 82, 16);
		frame.getContentPane().add(customerIDLabel);
	}
	
}
