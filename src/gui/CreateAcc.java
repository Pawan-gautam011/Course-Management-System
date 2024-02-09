package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import auth.Validation;
import courses.Courses;
import exception.InvalidFormat;
import exception.NullException;
import users.Instructor;
import users.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;

public class CreateAcc {

	private JFrame frame;
	private JPanel panel_1;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JTextField phone;
	private JComboBox rolesSelect;
	private JComboBox course;
	private JButton btnCreate;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Create the application.
	 */
	public CreateAcc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Downloads\\Course-Management-System-main (1)\\Course-Management-System-main\\assets\\logo.png"));
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(500, 500, 850, 620);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		username = new JTextField();
		username.setBounds(386, 129, 170, 34);
		username.setToolTipText("");
		username.setColumns(10);
		username.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		email = new JTextField();
		email.setBounds(629, 131, 200, 34);
		email.setToolTipText("");
		email.setColumns(10);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		password = new JPasswordField();
		password.setBounds(386, 232, 170, 34);
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		phone = new JTextField();
		phone.setBounds(629, 234, 200, 34);
		phone.setToolTipText("");
		phone.setColumns(10);
		phone.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		rolesSelect = new JComboBox(new Object[] { "Student", "Instructor" });
		rolesSelect.setModel(new DefaultComboBoxModel(new String[] {"Select your mode..", "", "Student", "Instructor"}));
		rolesSelect.setBounds(386, 329, 170, 34);
		rolesSelect.setForeground(Color.BLACK);
		rolesSelect.setFont(new Font("Poppins", Font.PLAIN, 14));
		rolesSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		rolesSelect.setBackground(new Color(248, 248, 248));

		ArrayList<Courses> cor = new ArrayList<Courses>();
		Courses c = new Courses();
		cor = c.getCourse();
		// cor.toArray();

		course = new JComboBox(new Object[] {});
		course.setModel(new DefaultComboBoxModel(new String[] {"Select Courses.."}));
		course.setSelectedIndex(0);
		course.setBounds(629, 331, 200, 34);
		for (int i = 0; i < cor.size(); i++) {
			course.addItem(cor.get(i).course_name);
		}
		course.setForeground(Color.BLACK);
		course.setFont(new Font("Poppins", Font.PLAIN, 14));
		course.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		course.setBackground(new Color(248, 248, 248));

		Student s = new Student();
		btnCreate = new JButton("Create");
		btnCreate.setBounds(536, 413, 121, 34);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructor i = new Instructor();
				String uname = username.getText();
				String p = new String(password.getPassword());
				String em = email.getText();
				String ph = phone.getText();
				Validation v = new Validation();
				int courseId = c.getCourseId(course.getSelectedItem().toString());
				try {
					if (v.emailCheck(em) && v.phoneCheck(ph) && v.passCheck(p)){
						if(rolesSelect.getSelectedItem().equals("Student")) {
						s.studentRegister(uname,courseId, em, p, ph, 1);
						}else {
							i.addInstructor(uname, em, ph, p);
						}
					}
					
				} catch (NullException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				} catch (InvalidFormat ex1) {
					JOptionPane.showMessageDialog(null, "Invalid Email or Phone Number or Password Format");
				}

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCreate.setBackground(new Color(0, 64, 0));

		btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(623, 502, 72, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
			}
		});
		btnNewButton.setForeground(new Color(82, 171, 39));
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(0, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setBounds(386, 98, 150, 20);
		lblNewLabel_1.setForeground(new Color(82, 171, 39));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));

		JLabel lblNewLabel_1_1 = new JLabel("Enter Email");
		lblNewLabel_1_1.setBounds(629, 98, 150, 22);
		lblNewLabel_1_1.setForeground(new Color(82, 171, 39));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));

		JLabel lblNewLabel_1_2 = new JLabel("Enter Password");
		lblNewLabel_1_2.setBounds(386, 200, 150, 22);
		lblNewLabel_1_2.setForeground(new Color(82, 171, 39));
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));

		JLabel lblNewLabel_1_3 = new JLabel("Enter Phone Number");
		lblNewLabel_1_3.setBounds(629, 202, 200, 22);
		lblNewLabel_1_3.setForeground(new Color(82, 171, 39));
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.PLAIN, 20));

		lblNewLabel_2 = new JLabel("Select Role");
		lblNewLabel_2.setBounds(386, 296, 150, 22);
		lblNewLabel_2.setForeground(new Color(82, 171, 39));
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));

		lblNewLabel_3 = new JLabel("Select Course");
		lblNewLabel_3.setBounds(629, 298, 219, 22);
		lblNewLabel_3.setForeground(new Color(82, 171, 39));
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		lblNewLabel = new JLabel("Create  your");
		lblNewLabel.setBounds(10, 253, 473, 82);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 60));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Account");
		lblNewLabel_5.setBounds(79, 344, 273, 59);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 55));
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		panel_1.add(lblNewLabel_5);
		panel_1.add(rolesSelect);
		panel_1.add(lblNewLabel_2);
		panel_1.add(phone);
		panel_1.add(password);
		panel_1.add(lblNewLabel_1_1);
		panel_1.add(email);
		panel_1.add(username);
		panel_1.add(lblNewLabel_1);
		panel_1.add(lblNewLabel_1_2);
		panel_1.add(lblNewLabel_1_3);
		panel_1.add(btnCreate);
		panel_1.add(btnNewButton);
		panel_1.add(course);
		panel_1.add(lblNewLabel_3);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_6 = new JLabel("Already have Account?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(450, 503, 160, 34);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(368, 0, 500, 580);
		panel_1.add(panel);
		panel.setLayout(null);
		frame.setVisible(true);

		String[] roles = { "Teacher", "Student" };
	}
}
