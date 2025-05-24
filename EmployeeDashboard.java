// EmployeeDashboard.java
// Refactored version — variables, method names, and class structure updated for clarity
// Original logic preserved

// EmployeeDashboard.java
// Refactored version - retains original logic with updated structure and naming

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeDashboard {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        // Entry point of EmployeeDashboard {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeePageUI window = new employeePageUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public employeePageUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 34, 61, 16);
		frame.getContentPane().add(lblNewLabel);
	}
}