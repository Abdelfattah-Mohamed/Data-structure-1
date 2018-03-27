package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class Polynomial_ {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblTheResult;
	char poly1, poly2;
	String poly;
	int terms = 0;
	static IPolynomialSolver instance = (IPolynomialSolver) new polynomial(null);
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		frame.setBounds(100, 100, 1145, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSelectThePolynomial = new JLabel("Select the Polynomial 1");
		lblSelectThePolynomial.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblSelectThePolynomial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThePolynomial.setBounds(20, 10, 246, 28);
		frame.getContentPane().add(lblSelectThePolynomial);

		JButton btnSet = new JButton("Set a polynomial variable");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[][] term = new int[terms][2];
				for (int i = 0; i < terms; i++) {
					term[i][0] = Integer.parseInt(textField.getText());
					term[i][1] = Integer.parseInt(textField_1.getText());
				}
				instance.setPolynomial(poly1, term);
			}

		});
		btnSet.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnSet.setBounds(710, 278, 253, 28);
		frame.getContentPane().add(btnSet);

		JButton btnNewButton = new JButton("Printa polynomial variable");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTheResult.setText(instance.print(poly1));
			}
		});
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

		JLabel label = new JLabel("");
		label.setBounds(45, 364, 45, 13);
		frame.getContentPane().add(label);

		lblTheResult = new JLabel("The Result of print");
		lblTheResult.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblTheResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheResult.setBounds(20, 609, 680, 102);
		frame.getContentPane().add(lblTheResult);

		JLabel lblTheResultOf = new JLabel("The Result of evaluate");
		lblTheResultOf.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblTheResultOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheResultOf.setBounds(45, 430, 655, 104);
		frame.getContentPane().add(lblTheResultOf);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(114, 126, 462, 65);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JComboBox POLY_1 = new JComboBox();
		POLY_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poly2 = (char) POLY_1.getSelectedItem();
			}
		});
		POLY_1.setToolTipText("");
		POLY_1.setMaximumRowCount(4);
		POLY_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		POLY_1.setBounds(330, 48, 246, 39);
		frame.getContentPane().add(POLY_1);

		JLabel lblSelectThePolynomial_1 = new JLabel("Select the Polynomial 2");
		lblSelectThePolynomial_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblSelectThePolynomial_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThePolynomial_1.setBounds(330, 10, 246, 25);
		frame.getContentPane().add(lblSelectThePolynomial_1);

		textField_1 = new JTextField();
		textField_1.setBounds(114, 203, 462, 65);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblCoff = new JLabel("exponent");
		lblCoff.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoff.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblCoff.setBounds(10, 210, 80, 39);
		frame.getContentPane().add(lblCoff);

		JLabel lblNewLabel = new JLabel("Coeff");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(20, 140, 84, 28);
		frame.getContentPane().add(lblNewLabel);

		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					terms = Integer.parseInt(textField_2.getText());
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "Enter valid number");
				}
			}
		});
		btnPush.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		btnPush.setBounds(635, 155, 136, 39);
		frame.getContentPane().add(btnPush);

		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField_2.setBounds(635, 90, 136, 55);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNoOfTerms = new JLabel("No. of terms");
		lblNoOfTerms.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblNoOfTerms.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoOfTerms.setBounds(625, 48, 136, 32);
		frame.getContentPane().add(lblNoOfTerms);

		JLabel lblYouCanSet = new JLabel("You can set polynomial 1 only");
		lblYouCanSet.setForeground(Color.RED);
		lblYouCanSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouCanSet.setFont(new Font("Serif", Font.ITALIC, 16));
		lblYouCanSet.setBounds(45, 278, 594, 28);
		frame.getContentPane().add(lblYouCanSet);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poly = (String) comboBox.getSelectedItem();
				poly1 = poly.charAt(0);
			}
		});
		comboBox.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "R"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(45, 48, 221, 39);
		frame.getContentPane().add(comboBox);
		
		JLabel lblEvaluateNumber = new JLabel("Evaluate number");
		lblEvaluateNumber.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblEvaluateNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluateNumber.setBounds(809, 48, 165, 32);
		frame.getContentPane().add(lblEvaluateNumber);
		
		textField_3 = new JTextField();
		textField_3.setBounds(809, 91, 165, 102);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField_4.setEditable(false);
		textField_4.setForeground(Color.YELLOW);
		textField_4.setBackground(Color.GRAY);
		textField_4.setBounds(45, 320, 655, 102);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
