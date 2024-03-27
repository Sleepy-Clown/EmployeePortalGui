package midtermProjectGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;


public class OptionFrame2 extends JFrame{
	static Company job = new Company("Generic Co.");
	public GuiFrame gf =  new GuiFrame();
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = job.flist;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewEmployee;
	private JLabel lblSpecial;
	private JButton btnEnter;
	private JButton btnYes;
	private JButton btnNo;
	String name;
	String id;
	double salary;
	static PrintWriter output;
	private JButton btnBack;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame2 frame = new OptionFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public OptionFrame2() throws IOException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(job.getCompanyName()+" Employee Terminal");

		setContentPane(contentPane);
		
		lblNewEmployee = new JLabel("Please enter employee ID");
		lblNewEmployee.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewEmployee.setForeground(new Color(125, 190, 255));
		lblNewEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEmployee.setBounds(17, 32, 402, 33);
		
		lblSpecial = new JLabel("");
		lblSpecial.setFont(new Font("Rockwell", Font.ITALIC, 11));
		lblSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecial.setBounds(131, 107, 173, 22);
		lblSpecial.setForeground(new Color(255, 0, 0));
		lblSpecial.setVisible(false);
		
		textField = new JTextField("");
		textField.setBackground(new Color(125, 190, 255));
		textField.setBounds(114, 76, 150, 20);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(true);
				lblSpecial.setVisible(false);
				btnYes.setVisible(false);
				btnNo.setVisible(false);
				
				String tf = textField.getText();
				if(!tf.isBlank()) {
					if(!isInteger(tf) || !(tf.length() == 5)) {
						textField.setText("");
						lblNewEmployee.setText("Please enter employee ID");
						lblSpecial.setVisible(true);
						lblSpecial.setText("IDs must contain 5 integers");
					}
					else {
						if(job.isEmployeeID(tf)) {
							lblSpecial.setVisible(false);
							//textField.setText("");
							textField.setVisible(false);
	
							//return i
							lblNewEmployee.setText("Are you sure you want to delete ["+job.getName(tf)+"]?");
							btnEnter.setVisible(false);
							btnYes.setVisible(true);
							btnNo.setVisible(true);
						}
						else {		
							lblSpecial.setVisible(true);
							lblSpecial.setText("Employee does not exist");
							
							actionPerformed(e);
						}
					}
				}
				else
					do{
						actionPerformed(e);
					}while(tf.isBlank());
				}
				
				public boolean isInteger(String obj) { 
				 try { 
				   Integer.valueOf(obj); 
				 } 
				 catch (Exception ex){ // Not a valid integer value 
				   return (false); 
				 } 
				 return (true); 
			}//close isInteger
		});
		
		btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(125, 190, 255));
		btnEnter.setBounds(274, 75, 78, 23);
		
		btnYes = new JButton("Yes");
		btnYes.setBackground(new Color(125, 190, 255));
		btnYes.setBounds(114, 75, 64, 23);
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(job.isEmployeeID(id)) {
					try {
						job.removeEmployee(id);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textField.setText("");
					textField.setVisible(false);
					btnEnter.setVisible(false);
					btnYes.setVisible(false);
					btnNo.setVisible(false);
					lblNewEmployee.setText("Click [Back] to return to menu");
					btnBack.setVisible(true);
				}
				else {
					
				}
			}
		});
		btnYes.setVisible(false);
		
		btnNo = new JButton("No");
		btnNo.setBackground(new Color(125, 190, 255));
		btnNo.setBounds(188, 75, 76, 23);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(true);
				textField.setText("");
				lblSpecial.setVisible(false);
				btnYes.setVisible(false);
				btnNo.setVisible(false);
				btnEnter.setVisible(true);
				lblNewEmployee.setText("Please enter employee ID");
			}
		});
		btnNo.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(192, 192, 192));
		menuBar.setBackground(new Color(0, 52, 104));
		menuBar.setBounds(0, 0, 436, 22);
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setBackground(new Color(0, 54, 108));
		mnNewMenu.setForeground(new Color(192, 192, 192));
		JMenuItem mntmBackBtn = new JMenuItem("Back");
		mntmBackBtn.setForeground(new Color(192, 192, 192));
		mntmBackBtn.setBackground(new Color(0, 54, 108));
		menuBar.add(mnNewMenu);
		mnNewMenu.add(mntmBackBtn);
		contentPane.setLayout(null);
		contentPane.add(lblSpecial);
		contentPane.add(menuBar);
		contentPane.add(lblNewEmployee);
		contentPane.add(textField);
		contentPane.add(btnEnter);
		contentPane.add(btnYes);
		contentPane.add(btnNo);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(125, 190, 255));
		btnBack.setBounds(149, 75, 89, 23);
		contentPane.add(btnBack);
		btnBack.setVisible(false);
		
		btnBack.addActionListener(new BackToMenuFrame());
		mntmBackBtn.addActionListener(new BackToMenuFrame());
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(true);
				lblSpecial.setVisible(false);
				btnYes.setVisible(false);
				btnNo.setVisible(false);
				
				String tf = textField.getText();
				if(!tf.isBlank()) {
					if(!isInteger(tf) || !(tf.length() == 5)) {
						textField.setText("");
						lblNewEmployee.setText("Please enter employee ID");
						lblSpecial.setVisible(true);
						lblSpecial.setText("IDs must contain 5 integers");
					}
					else {
						String num = tf;
						
						if(job.isEmployeeID(num)) {
							lblSpecial.setVisible(false);
							//textField.setText("");
							textField.setVisible(false);
	
							id = num;
							
							//return i
							lblNewEmployee.setText("Are you sure you want to delete ["+job.getName(num)+"]?");
							btnEnter.setVisible(false);
							btnYes.setVisible(true);
							btnNo.setVisible(true);
						}
						else {		
							lblSpecial.setVisible(true);
							lblSpecial.setText("Employee does not exist");
							
							actionPerformed(e);
						}
					}
				}
				else
					do{
						actionPerformed(e);
					}while(tf.isBlank());
				}
				
				public boolean isInteger(String obj) { 
				 try { 
				   Integer.valueOf(obj); 
				 } 
				 catch (Exception ex){ // Not a valid integer value 
				   return (false); 
				 } 
				 return (true); 
			}//close isInteger
		});		
	}
	
	private class BackToMenuFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MenuFrame mf;
			try {
				mf = new MenuFrame();
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
	}
}
