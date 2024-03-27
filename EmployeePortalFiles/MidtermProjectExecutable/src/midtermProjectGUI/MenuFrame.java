package midtermProjectGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuFrame extends JFrame {
	static Company job = new Company("Generic Co.");
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = GuiFrame.flist;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public MenuFrame() throws IOException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(job.getCompanyName()+" Employee Terminal");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(56, 100, 345, 23);
		comboBox.setBackground(new Color(125, 190, 255));
		comboBox.setMaximumRowCount(12);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Please select an option...", 
																	"Add new employee", //1
																	"Remove existing employee from the system", //2
																	"Display all employees", //3
																	"Retrieve specific employee data with ID number", //4
																	"Retrieve employee(s) based on salary range", //5
																	"Sort employees by salary (lowest to highest)", //6
																	"Sort employees by employees' first name (A-Z)", //7
																	"Sort employees by employees' last name (A-Z)", //8
																	"Sort employees by ID number (ascending order)", //9
																	"Clear all employee data", //10
																	"Exit"}));
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(401, 100, 91, 23);
		btnNewButton.setBackground(new Color(125, 190, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = comboBox.getSelectedItem().toString();
				if(x == "Add new employee"){ //1
					try {
						OptionFrame1 of1 = new OptionFrame1();
						of1.show();
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(0);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(x == "Remove existing employee from the system"){ //2
					try{
						OptionFrame2 of2 = new OptionFrame2();
						of2.show();
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(0);
					}
				}
				else if(x == "Display all employees"){ //3
					OptionFrame3 of3;
					try {
						of3 = new OptionFrame3();
						of3.show();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Retrieve specific employee data with ID number"){ //4
					OptionFrame4 of4;
					try {
						of4 = new OptionFrame4();
						of4.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Retrieve employee(s) based on salary range"){ //5
					OptionFrame5 of5;
					try {
						of5 = new OptionFrame5();
						of5.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Sort employees by salary (lowest to highest)"){ //6
					OptionFrame6 of6;
					try {
						of6 = new OptionFrame6();
						of6.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Sort employees by employees' first name (A-Z)"){ //7
					OptionFrame7 of7;
					try {
						of7 = new OptionFrame7();
						of7.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Sort employees by employees' last name (A-Z)"){ //8
					OptionFrame8 of8;
					try {
						of8 = new OptionFrame8();
						of8.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Sort employees by ID number (ascending order)"){ //9
					OptionFrame9 of9;
					try {
						of9 = new OptionFrame9();
						of9.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Clear all employee data"){ //10
					OptionFrame10 of10;
					try {
						of10 = new OptionFrame10();
						of10.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if(x == "Exit") {
					dispose();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Generic Co. ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(125, 190, 255));
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(69, 0, 416, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Terminal");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(125, 190, 255));
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(143, 36, 267, 38);
		contentPane.add(lblNewLabel_1);
		
		GuiFrame gf = new GuiFrame();
		String id = gf.ID;
		
		JLabel lblNewLabel_2 = new JLabel("Welcome "+job.getName(id));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(125, 190, 255));
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(108, 72, 338, 112);
		contentPane.add(lblNewLabel_2);
	}
}
