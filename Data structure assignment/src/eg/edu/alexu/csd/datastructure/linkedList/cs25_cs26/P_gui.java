package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

import java.awt.Font;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class P_gui {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblTheResult;
	char poly1, poly2;
	String poly;
	int terms = 0;
	Vector<Integer> v = new Vector<>();
	Vector<Integer> w = new Vector<>();
	static IPolynomialSolver instance = (IPolynomialSolver) new Polynomial();
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_gui window = new P_gui();
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
	public P_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1016, 728);
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

				try {
					String text = textField.getText();
					int co = 0;
					String[] str = new String[text.length() + 1];
					for (int i = 0; i < text.length(); i++) {
						if (str[co] == null) {
							str[co] = "";
						}
						if (text.charAt(i) == ' ') {
							co++;
						} else {
							str[co] += text.charAt(i);
						}
					}
					for (int i = 0; str[i] != null; i++) {
						v.add(Integer.parseInt(str[i]));
						str[i] = null;
					}
					String text1 = textField_1.getText();
					co = 0;
					String[] str1 = new String[text1.length() + 1];
					for (int i = 0; i < text1.length(); i++) {
						if (str1[co] == null) {
							str1[co] = "";
						}
						if (text1.charAt(i) == ' ') {
							co++;
						} else {
							str1[co] += text1.charAt(i);
						}
					}
					for (int i = 0; str1[i] != null; i++) {
						w.add(Integer.parseInt(str1[i]));
						str1[i] = null;
					}
					
					int[][] term = new int[v.size()][2];
					for (int i = 0; i < v.size(); i++) {
						term[i][0] = v.get(i);
						term[i][1] = w.get(i);
					}
					v.clear();
					w.clear();
					instance.setPolynomial(poly1, term);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "please enter the valid numbers OR chose polynomial symbol");
				}

				
			}
		});
		btnSet.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnSet.setBounds(610, 364, 253, 40);
		frame.getContentPane().add(btnSet);

		JButton btnNewButton = new JButton("Print a polynomial variable");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTheResult.setText(instance.print(poly1));
			}
		});
		btnNewButton.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(610, 413, 253, 40);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add two polynomials");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					instance.add(poly1, poly2);
					lblTheResult.setText(instance.print('R'));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "please set the polynomial");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(610, 463, 253, 40);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Subtract two polynomials");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					instance.subtract(poly1, poly2);
					lblTheResult.setText(instance.print('R'));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "please set the polynomial");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(610, 513, 253, 40);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Multiply two polynomials");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					instance.multiply(poly1, poly2);
					lblTheResult.setText(instance.print('R'));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "please set the polynomial");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBounds(610, 563, 253, 40);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblTheResultOf = new JLabel("The Result of evaluate");
		lblTheResultOf.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblTheResultOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheResultOf.setBounds(788, 91, 175, 102);
		frame.getContentPane().add(lblTheResultOf);
		
		JButton btnNewButton_4 = new JButton("Evaluate");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float x = (instance).evaluatePolynomial(poly1, Float.parseFloat(textField_3.getText()));
					lblTheResultOf.setText(Float.toString(x));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "please enter the valid numbers OR set the polynomial");
				}
			}
		});
		btnNewButton_4.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(628, 225, 253, 40);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Clear a polynomial variable");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.clearPolynomial(poly1);
			}
		});
		btnNewButton_5.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_5.setBounds(610, 613, 253, 40);
		frame.getContentPane().add(btnNewButton_5);

		JLabel label = new JLabel("");
		label.setBounds(45, 364, 45, 13);
		frame.getContentPane().add(label);

		lblTheResult = new JLabel("The Result of print");
		lblTheResult.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblTheResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheResult.setBounds(20, 364, 556, 283);
		frame.getContentPane().add(lblTheResult);

		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.ITALIC, 20));
		textField.setBounds(114, 126, 462, 65);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JComboBox POLY_1 = new JComboBox();
		POLY_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poly = (String) POLY_1.getSelectedItem();
				poly2 = poly.charAt(0);
			}
		});
		POLY_1.setModel(new DefaultComboBoxModel(new String[] { "", "A", "B", "C" }));
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
		textField_1.setFont(new Font("Serif", Font.ITALIC, 20));
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

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poly = (String) comboBox.getSelectedItem();
				poly1 = poly.charAt(0);
			}
		});
		comboBox.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "A", "B", "C", "R" }));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(45, 48, 221, 39);
		frame.getContentPane().add(comboBox);

		JLabel lblEvaluateNumber = new JLabel("Evaluate number");
		lblEvaluateNumber.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblEvaluateNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluateNumber.setBounds(610, 48, 165, 32);
		frame.getContentPane().add(lblEvaluateNumber);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		textField_3.setBounds(610, 95, 165, 102);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblOnlyPoly = new JLabel("Only Poly 1");
		lblOnlyPoly.setForeground(Color.RED);
		lblOnlyPoly.setFont(new Font("Serif", Font.ITALIC, 15));
		lblOnlyPoly.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlyPoly.setBounds(873, 373, 90, 25);
		frame.getContentPane().add(lblOnlyPoly);
		
		JLabel label_1 = new JLabel("Only Poly 1");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Serif", Font.ITALIC, 15));
		label_1.setBounds(873, 422, 90, 25);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("Only Poly 1");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Serif", Font.ITALIC, 15));
		label_3.setBounds(873, 622, 90, 25);
		frame.getContentPane().add(label_3);
		
		JLabel lblPoly = new JLabel("Poly 1 & 2");
		lblPoly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoly.setForeground(Color.RED);
		lblPoly.setFont(new Font("Serif", Font.ITALIC, 15));
		lblPoly.setBounds(873, 580, 90, 25);
		frame.getContentPane().add(lblPoly);
		
		JLabel label_2 = new JLabel("Poly 1 & 2");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Serif", Font.ITALIC, 15));
		label_2.setBounds(873, 479, 90, 25);
		frame.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("Poly 1 & 2");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Serif", Font.ITALIC, 15));
		label_4.setBounds(873, 530, 90, 25);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Only Poly 1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Serif", Font.ITALIC, 15));
		label_5.setBounds(900, 234, 90, 25);
		frame.getContentPane().add(label_5);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, POLY_1, textField, textField_1, btnSet, btnNewButton, btnNewButton_1, btnNewButton_2, lblTheResultOf, btnNewButton_3, btnNewButton_5, btnNewButton_4, textField_3, lblNewLabel, lblCoff, label, lblTheResult, lblSelectThePolynomial_1, lblEvaluateNumber, lblOnlyPoly, label_1, label_3, lblPoly, label_2, label_4, label_5, lblSelectThePolynomial}));
	}
}
