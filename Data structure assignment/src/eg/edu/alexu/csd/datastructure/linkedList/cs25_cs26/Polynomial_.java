package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Polynomial_ {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Polynomial_ window = new Polynomial_();
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
	public Polynomial_() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1013, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectThePolynomial = new JLabel("Select the Polynomial");
		lblSelectThePolynomial.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblSelectThePolynomial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThePolynomial.setBounds(20, 10, 246, 28);
		frame.getContentPane().add(lblSelectThePolynomial);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "R"}));
		comboBox.setMaximumRowCount(4);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(20, 48, 246, 39);
		frame.getContentPane().add(comboBox);
		
		JButton btnSet = new JButton("Set a polynomial variable");
		btnSet.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnSet.setBounds(710, 278, 253, 28);
		frame.getContentPane().add(btnSet);
		
		JButton btnNewButton = new JButton("Printa polynomial variable");
		btnNewButton.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(710, 316, 253, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add two polynomials");
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(710, 354, 253, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Subtract two polynomials");
		btnNewButton_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(710, 392, 253, 28);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Multiply two polynomials");
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBounds(710, 430, 253, 28);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Evaluate at some point");
		btnNewButton_4.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(710, 468, 253, 28);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear a polynomial variable");
		btnNewButton_5.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_5.setBounds(710, 506, 253, 28);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Input :");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 125, 100, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(45, 364, 45, 13);
		frame.getContentPane().add(label);
		
		JLabel lblTheResult = new JLabel("The Result of print");
		lblTheResult.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblTheResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheResult.setBounds(20, 318, 680, 102);
		frame.getContentPane().add(lblTheResult);
		
		JLabel lblTheResultOf = new JLabel("The Result of evaluate");
		lblTheResultOf.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblTheResultOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheResultOf.setBounds(45, 430, 655, 104);
		frame.getContentPane().add(lblTheResultOf);
		
		textField = new JTextField();
		textField.setBounds(113, 125, 849, 134);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
