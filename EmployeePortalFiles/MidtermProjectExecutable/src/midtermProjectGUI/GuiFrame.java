//Treat this file as the main file. Anytime the app is ran, it should start from here.
package midtermProjectGUI;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

public class GuiFrame extends JFrame {
	static Company job = new Company("Generic Co.");
	public static ArrayList<Employee> list = Company.list;
	public static ArrayList<File> flist = Company.flist;
	private static final long serialVersionUID = 1L;
	
	public static String ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException, Exception{
		list.clear();
		try {
			job.companyFile();
			job.addEmployees(flist.get(0));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFrame frame = new GuiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).printAccountString());
		}
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws IOException 
	 */
	public GuiFrame() throws IOException, Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(job.getCompanyName()+" Employee Terminal");
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Please contact your server admin.");
		lblNewLabel_3.setBounds(45, 134, 338, 20);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setForeground(new Color(188, 22, 22));
		lblNewLabel_3.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblNewLabel_3.setVisible(false);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Please enter your Employee ID");
		lblNewLabel_2.setBounds(45, 83, 338, 20);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(125, 190, 255));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Terminal");
		lblNewLabel_1.setBounds(82, 47, 267, 38);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(125, 190, 255));
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Generic Co. ");
		lblNewLabel.setBounds(10, 11, 416, 46);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(125, 190, 255));
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JTextField textField = new JTextField("");
		textField.setBounds(82, 117, 198, 20);
		textField.setBackground(new Color(125, 190, 255));
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(305, 116, 78, 23);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(125, 190, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = textField.getText();
				
				if(list.size() <= 0) {
					lblNewLabel_2.setText("There are no registered employees.");
					lblNewLabel_3.setVisible(true);
					btnNewButton.setVisible(false);
					btnNewButton.setVisible(false);
					textField.setVisible(false);
					textField.setEnabled(false);
					lblNewLabel_2.setBounds(45, 106, 338, 20);
					lblNewLabel_2.setForeground(new Color(188, 22, 22));
				}
				else {
					if(job.isEmployeeID(ID)) {
						if(job.getClearance(ID) >= 3) {
							try {
								MenuFrame mf = new MenuFrame();
								mf.show();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dispose();
						}
						else {
							lblNewLabel_2.setText("You do not have access clearance.");
							btnNewButton.setVisible(false);
							btnNewButton.setVisible(false);
							textField.setVisible(false);
							textField.setEnabled(false);
							lblNewLabel_2.setBounds(45, 134, 338, 20);
							lblNewLabel_2.setForeground(new Color(188, 22, 22));
						}
					}
					else {
						lblNewLabel_2.setText("You are not a registered employee.");
						btnNewButton.setVisible(false);
						btnNewButton.setVisible(false);
						textField.setVisible(false);
						textField.setEnabled(false);
						lblNewLabel_2.setBounds(45, 134, 338, 20);
						lblNewLabel_2.setForeground(new Color(188, 22, 22));
					}
				}
			}
		});
		contentPane.add(btnNewButton);
		
	}
}
