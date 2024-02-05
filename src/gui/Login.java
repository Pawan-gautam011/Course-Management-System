package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.border.MatteBorder;

import exception.InvalidCredintial;
import exception.NullException;
import users.Admin;
import users.Instructor;
import users.Student;

import java.awt.Panel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Login {

	public JFrame frame;
	private JTextField email;
	private JPasswordField password;


	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Downloads\\Course-Management-System-main (1)\\Course-Management-System-main\\assets\\logo.png"));
		frame.setResizable(false);
		frame.setBounds(500, 500, 850, 620);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		ImageIcon icon = new ImageIcon("/logo.png");

		JLabel lblNewLabel = new JLabel("Welcome to Course Management System");
		lblNewLabel.setForeground(new Color(164, 201, 58));
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(165)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(115, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		email = new JTextField();
		email.setBounds(120, 172, 220, 40);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		email.setToolTipText("");
		email.setColumns(10);
		JLabel invalid1 = new JLabel("Invalid");
		invalid1.setBounds(184, 214, 32, 16);
		invalid1.setVisible(false);
		JLabel invalid2 = new JLabel("Invalid");
		invalid2.setBounds(184, 310, 32, 16);
		invalid2.setVisible(false);
		password = new JPasswordField();
		password.setBounds(120, 265, 220, 40);
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.add(email);
		panel_1.add(password);
		String roles[] = { "admin", "instructors", "students" };
		JComboBox comboBox = new JComboBox(roles);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Role..", "admin", "instructors", "students"}));
		comboBox.setBounds(120, 371, 220, 40);
		comboBox.setBackground(new Color(248, 248, 248));
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(comboBox);

		JButton login = new JButton("Log In");
		login.setBounds(242, 443, 100, 34);
		login.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailField = email.getText();
				String passField = new String(password.getPassword());

				Student s = new Student();
				Instructor i = new Instructor();
				Admin a = new Admin();
				try {
					if (comboBox.getSelectedItem().equals("students")) {
						if (s.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else if (comboBox.getSelectedItem().equals("instructors")) {
						if (i.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else if (comboBox.getSelectedItem().equals("admin")) {
						if (a.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Email or Password!!", "Invalid Information!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} catch (NullException e1) {
					JOptionPane.showMessageDialog(null, "Please fill up the empty boxes!!", "Error!!",
							JOptionPane.ERROR_MESSAGE);
					invalid1.setVisible(true);
					invalid2.setVisible(true);
				}

			}
		});
		login.setBackground(new Color(117, 191, 67));
		login.setForeground(new Color(248, 248, 248));
		login.setFont(new Font("Poppins", Font.PLAIN, 16));
		panel_1.add(login);

		JLabel cacc = new JLabel("Enter Email");
		cacc.setBounds(120, 141, 96, 22);
		cacc.setForeground(new Color(33, 210, 13));
		cacc.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(cacc);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Password");
		lblNewLabel_1_1.setBounds(120, 235, 110, 22);
		lblNewLabel_1_1.setForeground(new Color(33, 210, 13));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Select Role");
		lblNewLabel_1_1_1.setBounds(120, 338, 79, 22);
		lblNewLabel_1_1_1.setForeground(new Color(33, 210, 13));
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_1);

		invalid2.setForeground(new Color(255, 0, 0));
		invalid2.setFont(new Font("Poppins", Font.PLAIN, 10));
		panel_1.add(invalid2);

		invalid1.setForeground(new Color(255, 0, 0));
		invalid1.setFont(new Font("Poppins", Font.PLAIN, 10));
		panel_1.add(invalid1);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(125, 443, 100, 34);
		btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAcc();
				System.out.println("Clicked");
				frame.setVisible(false);

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBackground(new Color(117, 191, 67));
		panel_1.add(btnCreate);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(0, 0, 268, 113);
		lblNewLabel_2.setAlignmentX(0.5f);
		Image logo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(logo));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(87, 178, 32, 34);
		Image mail = new ImageIcon(this.getClass().getResource("/mail.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(mail));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(87, 271, 32, 34);
		Image pass = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_3_1.setIcon(new ImageIcon(pass));
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBounds(87, 371, 32, 34);
		Image user = new ImageIcon(this.getClass().getResource("/account.png")).getImage();
		lblNewLabel_3_1_1.setIcon(new ImageIcon(user));
		panel_1.add(lblNewLabel_3_1_1);
	}
}
