package midtermProjectGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SpinnerNumberModel;

public class OptionFrame1 extends JFrame {
	static Company job = new Company("Generic Co.");
	public GuiFrame gf = new GuiFrame();
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = GuiFrame.flist;
	public ArrayList<Employee> templist = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmBackBtn;
	private JSpinner spinner, spinner_1;
	private JLabel lblNewEmployee;
	private JLabel lblSpecial;
	private JTextField textField;
	private JLabel lbl$;
	private JButton btnBack;
	private JButton btnBack1;
	private JButton btnBackLevel;
	private JButton btnBackName;
	private JButton btnBackID;
	private JButton btnBackMoney;
	private JButton btnEnterNumber;
	private JButton btnEnterLevel;
	private JButton btnEnterName;
	private JButton btnEnterID;
	private JButton btnEnterMoney;
	int integer;
	int lvl;
	String[] name;
	String id;
	double salary;
	int a = 1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame1 frame = new OptionFrame1();
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
	 */
	public OptionFrame1() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(job.getCompanyName()+" Employee Terminal");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new unclickedText());
		
		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(192, 192, 192));
		menuBar.setBackground(new Color(0, 52, 104));
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		mnNewMenu = new JMenu("Menu");
		mnNewMenu.setBackground(new Color(0, 54, 108));
		mnNewMenu.setForeground(new Color(192, 192, 192));
		mntmBackBtn = new JMenuItem("Back");
		mntmBackBtn.setForeground(new Color(192, 192, 192));
		mntmBackBtn.setBackground(new Color(0, 54, 108));
		menuBar.add(mnNewMenu);
		mnNewMenu.add(mntmBackBtn);
		
		spinner = new JSpinner();
		spinner.setForeground(new Color(0, 0, 0));
		spinner.setBackground(new Color(125, 190, 255));
		spinner.setBounds(193, 92, 30, 20);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, null, 5, 1));
		spinner_1.setForeground(new Color(0, 0, 0));
		spinner_1.setBackground(new Color(125, 190, 255));
		spinner_1.setBounds(193, 92, 30, 20);
		contentPane.add(spinner_1);
		spinner_1.setVisible(false);
		
		lbl$ = new JLabel("$");
		lbl$.setForeground(new Color(125, 190, 255));
		lbl$.setHorizontalAlignment(SwingConstants.CENTER);
		lbl$.setBounds(73, 95, 23, 14);
		contentPane.add(lbl$);
		lbl$.setVisible(false);
		
		textField = new JTextField("");
		textField.setBackground(new Color(125, 190, 255));
		textField.setBounds(89, 92, 198, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addMouseListener(new clickedText());
		textField.setVisible(false);
		textField.setEnabled(false);
		textField.setDisabledTextColor(new Color(128, 128, 128));
		
		btnBack1 = new JButton("Back");
		btnBack1.setForeground(new Color(0, 0, 0));
		btnBack1.setBackground(new Color(125, 190, 255));
		btnBack1.setBounds(298, 126, 73, 23);
		contentPane.add(btnBack1);
		btnBack1.setVisible(false);
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a > 0) {
					a--;
					templist.remove(templist.size()-1);
					
					lbl$.setVisible(true);
					spinner.setVisible(false);
					btnEnterName.setVisible(false);
					btnEnterMoney.setVisible(true);
					btnBack1.setVisible(false);
					btnBackMoney.setVisible(true);
					lblSpecial.setVisible(false);
					lblNewEmployee.setText("Please enter employee ["+a+"]'s salary");
					textField.setText("[######.##]");
					textField.setEnabled(false);
					textField.setDisabledTextColor(new Color(128, 128, 128));
				}
			}
		});
		
		btnBackLevel = new JButton("Back");
		btnBackLevel.setBackground(new Color(125, 190, 255));
		btnBackLevel.setBounds(298, 126, 73, 23);
		contentPane.add(btnBackLevel);
		btnBackLevel.setVisible(false);
		btnBackLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBackLevel) {
					lblSpecial.setVisible(false);
					lblSpecial.setText("");
					lblNewEmployee.setText("Please enter number of new employees");
					spinner.setVisible(true);
					spinner_1.setVisible(false);
					btnEnterNumber.setVisible(true);
					btnEnterLevel.setVisible(false);
					btnBackLevel.setVisible(false);
				}
			}
		});
		
		btnBackName = new JButton("Back");
		btnBackName.setBackground(new Color(125, 190, 255));
		btnBackName.setBounds(298, 126, 73, 23);
		contentPane.add(btnBackName);
		btnBackName.setVisible(false);
		btnBackName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBackName) {
					lblSpecial.setVisible(false);
					lblSpecial.setText("");
					lblNewEmployee.setText("Please enter a clearance level for employee ["+a+"]");
					spinner_1.setVisible(true);
					btnEnterLevel.setVisible(true);
					btnBackLevel.setVisible(true);
					btnEnterName.setVisible(false);
					btnBackName.setVisible(false);
					textField.setVisible(false);
				}
			}
		});

		btnBackID = new JButton("Back");
		btnBackID.setBackground(new Color(125, 190, 255));
		btnBackID.setBounds(298, 126, 73, 23);
		contentPane.add(btnBackID);
		btnBackID.setVisible(false);
		btnBackID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBackID) {
					if(a > 1) { btnBack1.setVisible(true);}
					else { btnBackName.setVisible(true);}
					
					lblSpecial.setVisible(false);
					spinner.setVisible(false);
					btnEnterID.setVisible(false);
					btnEnterName.setVisible(true);
					btnBackID.setVisible(false);
					lblSpecial.setVisible(false);
					textField.setText("First Last");
					textField.setEnabled(false);
					textField.setDisabledTextColor(new Color(192, 192, 192));
					
					lblNewEmployee.setText("Please enter employee ["+a+"]'s name");
				}
			}
		});
		
		btnBackMoney = new JButton("Back");
		btnBackMoney.setBackground(new Color(125, 190, 255));
		btnBackMoney.setBounds(298, 126, 73, 23);
		contentPane.add(btnBackMoney);
		btnBackMoney.setVisible(false);
		btnBackMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBackMoney) {
					spinner.setVisible(false);
					lbl$.setVisible(false);
					lblSpecial.setVisible(false);
					lblNewEmployee.setText("Please enter employee id");
					btnEnterID.setVisible(true);
					btnEnterMoney.setVisible(false);
					btnBackID.setVisible(true);
					btnBackMoney.setVisible(false);
					textField.addMouseListener(new clickedText());
					textField.setText("#####");
					textField.setEnabled(false);
					textField.setDisabledTextColor(new Color(192, 192, 192));
				}
			}
		});
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(125, 190, 255));
//		btnBack.setBounds(122, 91, 89, 23);
		btnBack.setBounds(298, 126, 73, 23);
		contentPane.add(btnBack);
		btnBack.setVisible(false);
		
		lblSpecial = new JLabel("");
		lblSpecial.setFont(new Font("Rockwell", Font.ITALIC, 11));
		lblSpecial.setBounds(83, 64, 270, 20);
		lblSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSpecial);
		lblSpecial.setForeground(new Color(255, 0, 0));
		
		lblNewEmployee = new JLabel("Please enter number of new employees");
		lblNewEmployee.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewEmployee.setForeground(new Color(125, 190, 255));
		lblNewEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEmployee.setBounds(66, 38, 304, 43);
		contentPane.add(lblNewEmployee);

		btnEnterNumber = new JButton("Enter");
		btnEnterNumber.setBackground(new Color(125, 190, 255));
		btnEnterNumber.setBounds(233, 91, 73, 23);
		contentPane.add(btnEnterNumber);
		btnEnterNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSpecial.setVisible(false);
				lblSpecial.setText("");
				lblNewEmployee.setText("Please enter number of new employees");
				spinner.setVisible(true);
				btnEnterNumber.setVisible(true);
				textField.setVisible(false);
					
				if(e.getSource() == btnEnterNumber) {
					integer = Integer.valueOf(spinner.getValue().toString());
					
					if(integer == 0){
						lblSpecial.setVisible(true);
						lblSpecial.setText("Please select a number greater than 0");
					}
					else if(integer < 0){
						lblSpecial.setVisible(true);
						lblSpecial.setText("Please select a number greater than 0");
					}
					else {
						lblSpecial.setVisible(false);
						
						spinner.setVisible(false);
						spinner_1.setVisible(true);
						btnEnterNumber.setVisible(false);
						btnEnterLevel.setVisible(true);
						btnBackLevel.setVisible(true);
						lblSpecial.setVisible(false);
						textField.setVisible(false);
						textField.addMouseListener(new clickedText());
						textField.setText("First Last");
						textField.setEnabled(false);
						textField.setDisabledTextColor(new Color(192, 192, 192));
						
						lblNewEmployee.setText("Please enter a clearance level for employee ["+a+"]");
					}
				}	
			}
		});
		
		btnEnterLevel = new JButton("Enter");
		btnEnterLevel.setBackground(new Color(125, 190, 255));
		btnEnterLevel.setBounds(298, 91, 73, 23);
		contentPane.add(btnEnterLevel);
		btnEnterLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spinner_1.setVisible(true);
				spinner.setVisible(false);
				btnEnterNumber.setVisible(false);
				btnEnterLevel.setVisible(true);
				btnBackLevel.setVisible(true);
				textField.setVisible(false);
				
				if(e.getSource() == btnEnterLevel) {
					int tf = (int) spinner_1.getValue();
					if(!(tf <= 0) && !(tf > 5)) {
						if(!isDouble(Integer.toString(tf))) {
							spinner_1.setValue(0);
//							lblNewEmployee.setText("Please enter employee ["+integer+"]'s name");
							lblSpecial.setVisible(true);
							lblSpecial.setText("Clearance Levels must be numbers");
							}//close if(isDouble(tf))
						else {								
							lvl = tf;
							
							spinner_1.setVisible(false);
							btnEnterName.setVisible(true);
							btnEnterLevel.setVisible(false);
							btnBackLevel.setVisible(false);
							btnBackName.setVisible(true);
							lblSpecial.setVisible(false);
							lblNewEmployee.setText("Please enter a name for employee ["+a+"]");
							textField.addMouseListener(new clickedText());
							textField.setText("First Last");
							textField.setEnabled(false);
							textField.setDisabledTextColor(new Color(128, 128, 128));
							textField.setVisible(true);
						}//close else
					}//close if(!tf.isBlank() && !tf.equalsIgnoreCase("First Last"))
					else {
						if(tf <= 0) {
							do{
								lblSpecial.setVisible(true);
								lblSpecial.setText("Clearance Levels must be Greater than 0");
								actionPerformed(e);
							}while((tf <= 0));
						}
						else {
							do{
							lblSpecial.setVisible(true);
							lblSpecial.setText("Clearance Levels must be Less than or Equal to 5");
							actionPerformed(e);
						}while((tf > 5));
						}
						
					}//close else
				}//close if(e.getSource() == btnEnterLevel)
			}	
			
			public boolean isDouble(String obj) { 
				try { 
					Double.valueOf(obj); 
				} 
				catch (Exception ex){ // Not a valid double value 
					return (false); 
				} 
				return (true); 
			}//close isDouble
		});
		btnEnterLevel.setVisible(false);
		
		btnEnterName = new JButton("Enter");
		btnEnterName.setBackground(new Color(125, 190, 255));
		btnEnterName.setBounds(298, 91, 73, 23);
		contentPane.add(btnEnterName);
		btnEnterName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spinner.setVisible(false);
				btnEnterNumber.setVisible(false);
				btnEnterName.setVisible(true);
				btnBackName.setVisible(true);
				textField.setVisible(true);
				
				if(e.getSource() == btnEnterName) {
					String tf = textField.getText();
					if(!tf.isBlank() && !tf.equalsIgnoreCase("First Last")) {
						if(isDouble(tf)) {
							textField.setText("");
//							lblNewEmployee.setText("Please enter employee ["+integer+"]'s name");
							lblSpecial.setVisible(true);
							lblSpecial.setText("Names cannot contain numbers");
							}
						else {								
							name = textField.getText().split(" ");
							
							spinner.setVisible(false);
							btnEnterID.setVisible(true);
							btnEnterName.setVisible(false);
							btnBackName.setVisible(false);
							btnBackID.setVisible(true);
							lblSpecial.setVisible(false);
							lblNewEmployee.setText("Please enter employee ["+a+"]'s id");
							textField.addMouseListener(new clickedText());
							textField.setText("#####");
							textField.setEnabled(false);
							textField.setDisabledTextColor(new Color(128, 128, 128));
						}
					}
					else {
						do{
							lblSpecial.setVisible(true);
							lblSpecial.setText("Please enter a name for employee ["+a+"]");
							actionPerformed(e);
						}while(tf.isBlank() && tf.equalsIgnoreCase("First Last"));
					}
				}
			}	
			
			public boolean isDouble(String obj) { 
				try { 
					Double.valueOf(obj); 
				} 
				catch (Exception ex){ // Not a valid double value 
					return (false); 
				} 
				return (true); 
			}//close isDouble
		});
		btnEnterName.setVisible(false);
		
		btnEnterID = new JButton("Enter");
		btnEnterID.setBackground(new Color(125, 190, 255));
		btnEnterID.setBounds(298, 91, 73, 23);
		contentPane.add(btnEnterID);
		btnEnterID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnEnterID) {
					String tf = textField.getText();
					if(!tf.isBlank()) {
						if(!isInteger(tf) && !tf.equalsIgnoreCase("#####") && !(tf.length() == 5)) {
							textField.setText("");
							lblNewEmployee.setText("Please enter employee ID");
							lblSpecial.setVisible(true);
							lblSpecial.setText("IDs must contain 5 integers");
						}
						
						else {
							String num = tf;
							id = num;
				//						textField.setText("[######.##]");
							
							lbl$.setVisible(true);
							spinner.setVisible(false);
							btnEnterID.setVisible(false);
							btnEnterMoney.setVisible(true);
							btnBackID.setVisible(false);
							btnBackMoney.setVisible(true);
							lblSpecial.setVisible(false);
							lblNewEmployee.setText("Please enter employee ["+a+"]'s salary");
							textField.addMouseListener(new clickedText());
							textField.setText("[######.##]");
							textField.setEnabled(false);
							textField.setDisabledTextColor(new Color(128, 128, 128));
						}
					}
					else {
						do{
							lblSpecial.setVisible(true);
							lblSpecial.setText("Please enter an id number for employee ["+a+"]");
							actionPerformed(e);
						}while(tf.isBlank() && tf.equalsIgnoreCase("#####"));
					}
				}
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
		btnEnterID.setVisible(false);
		
		btnEnterMoney = new JButton("Enter");
		btnEnterMoney.setBackground(new Color(125, 190, 255));
		btnEnterMoney.setBounds(298, 91, 73, 23);
		contentPane.add(btnEnterMoney);
		btnEnterMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl$.setVisible(true);
				spinner.setVisible(false);
				btnEnterID.setVisible(false);
				btnEnterMoney.setVisible(true);
				btnBackID.setVisible(false);
				btnBackMoney.setVisible(true);
				lblSpecial.setVisible(false);
				
				double num = Double.parseDouble(textField.getText().toString());
				String tf = textField.getText();
				if(!tf.isBlank() && !tf.equalsIgnoreCase("[######.##]")) {
					if(isDouble(tf)) {
						salary = num;
						
						templist.add(new Employee(lvl, name, id, salary));
						
						if(a == integer) {
							list.addAll(templist);
							
							try {
								job.newEmployeesFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							for(int i = 0; i < list.size(); i++) {
								System.out.println(list.get(i).printAccountString());
							}
							
							textField.setText("");
							textField.setVisible(false);
							lbl$.setVisible(false);
							btnEnterMoney.setVisible(false);
							btnBackMoney.setVisible(false);
							btnBack1.setVisible(false);
							btnBack.setBounds(122, 91, 89, 23);
							btnBack.setVisible(true);
							lblNewEmployee.setText("Click [Back] to return to menu");
						}
						
						else {
							a++;
							
							spinner.setVisible(false);
							btnEnterMoney.setVisible(false);
							btnEnterName.setVisible(true);
							btnBack1.setVisible(true);
							lbl$.setVisible(false);
							lblSpecial.setVisible(false);
							textField.setText("First Last");
							textField.setEnabled(false);
							textField.setDisabledTextColor(new Color(128, 128, 128));
							
							lblNewEmployee.setText("Please enter employee ["+a+"]'s name");
						}
					}
					else {
						textField.setText("");
						lblNewEmployee.setText("Please enter employee salary");
						lblSpecial.setVisible(true);
						lblSpecial.setText("Salaries must be a number");
					}
				}
				else {
					do{
						lblSpecial.setVisible(true);
						lblSpecial.setText("Please enter a salary amount for employee ["+a+"]");
						actionPerformed(e);
					}while(tf.isBlank() && tf.equalsIgnoreCase("[######.##]"));
				}
			}
			
			public boolean isDouble(String obj) { 
				 try { 
				   Double.valueOf(obj); 
				 } 
				 catch (Exception ex){ // Not a valid double value 
				   return (false); 
				 } 
				 return (true); 
			}//close isDouble
		});
		btnEnterMoney.setVisible(false);
		
		lblSpecial.setVisible(false);
		
		btnBack.addActionListener(new BackToMenuFrame());
		mntmBackBtn.addActionListener(new BackToMenuFrame());
	}
	
	private class clickedText implements MouseListener{
		public void mouseClicked(MouseEvent e){
			String tf = textField.getText();
			if(tf.equalsIgnoreCase("[######.##]") || 
					tf.equalsIgnoreCase("#####") || tf.equalsIgnoreCase("First Last")) {
				textField.setEnabled(true);
				textField.requestFocus();
				textField.setText("");
			}
			else{
				textField.setEnabled(true);
				textField.requestFocus();
			}
		}
		@Override public void mousePressed(MouseEvent e) {}
		@Override public void mouseReleased(MouseEvent e) {}
		@Override public void mouseEntered(MouseEvent e) {}
		@Override public void mouseExited(MouseEvent e) {}	
	}
	
	private class unclickedText implements MouseListener{
		public void mouseClicked(MouseEvent e){
			String tf = textField.getText();
			if(!(tf.equalsIgnoreCase("[######.##]") || 
					tf.equalsIgnoreCase("#####") || tf.equalsIgnoreCase("First Last"))) {
				textField.setEnabled(false);
				textField.setDisabledTextColor(new Color(0,0,0));
			}
			else
				textField.setEnabled(false);
		}
		@Override public void mousePressed(MouseEvent e) {}
		@Override public void mouseReleased(MouseEvent e) {}
		@Override public void mouseEntered(MouseEvent e) {}
		@Override public void mouseExited(MouseEvent e) {}		
	}
		
	private class BackToMenuFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MenuFrame mf;
			try {
				templist.clear();
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
