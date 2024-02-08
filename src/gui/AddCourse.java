package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import courses.CRUDCourse;
import exception.NullException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AddCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Add Course");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setFont(new Font("Poppins", Font.PLAIN, 10));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDCourse c = new CRUDCourse();
				String cn = textField.getText();
				try {
					c.createCourse(cn);
				} catch (NullException e2) {
					JOptionPane.showMessageDialog(null, "Please Fill the Box");
				}
			}
		});
		btnNewButton.setBackground(new Color(117, 191, 64));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(173, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(193))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(61)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(55))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
