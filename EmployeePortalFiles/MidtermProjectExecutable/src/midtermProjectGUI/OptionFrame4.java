package midtermProjectGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class OptionFrame4 extends JFrame {
	static Company job = new Company("Generic Co.");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public GuiFrame gf =  new GuiFrame();
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = GuiFrame.flist;
	private JLabel lblSpecial;
	private JButton btnSubmit, btnReturn;
	private JTextArea textArea;
	private JLabel lblNewEmployee;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame4 frame = new OptionFrame4();
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
	public OptionFrame4() throws IOException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewEmployee = new JLabel("Please enter employee ID");
		lblNewEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEmployee.setForeground(new Color(125, 190, 255));
		lblNewEmployee.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewEmployee.setBounds(17, 35, 402, 33);
		contentPane.add(lblNewEmployee);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(125, 190, 255));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBounds(260, 67, 89, 23);
		contentPane.add(btnSubmit);
		
		textField = new JTextField("");
		textField.setBackground(new Color(125, 190, 255));
		textField.setBounds(100, 68, 150, 20);
		contentPane.add(textField);
		
		lblSpecial = new JLabel("");
		lblSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecial.setFont(new Font("Rockwell", Font.ITALIC, 11));
		lblSpecial.setBounds(73, 101, 289, 23);
		lblSpecial.setForeground(new Color(255, 0, 0));
		lblSpecial.setText("");
		lblSpecial.setVisible(false);
		contentPane.add(lblSpecial);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 52, 104));
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(Color.LIGHT_GRAY);
		mnNewMenu.setBackground(new Color(0, 54, 108));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmBackBtn = new JMenuItem("Back");
		mntmBackBtn.setForeground(Color.LIGHT_GRAY);
		mntmBackBtn.setBackground(new Color(0, 54, 108));
		mnNewMenu.add(mntmBackBtn);
		mntmBackBtn.addActionListener(new BackToMenuFrame());
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 436, 208);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText("");
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBackground(new Color(0, 82, 164));
		textArea.setVisible(false);
		
		btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(125, 190, 255));
		btnReturn.setBounds(347, 241, 89, 23);
		contentPane.add(btnReturn);
		btnReturn.addActionListener(new BackToMenuFrame());
		btnReturn.setVisible(false);
		
		btnSubmit.addActionListener(new doID());
		
		textField.setVisible(true);
		lblSpecial.setVisible(false);
	}
	
	private class doID implements ActionListener {
		public void actionPerformed(ActionEvent e) {
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
						lblNewEmployee.setVisible(false);
						lblSpecial.setVisible(false);
						textField.setVisible(false);
						btnSubmit.setVisible(false);
						btnReturn.setVisible(true);
						textArea.setVisible(true);
						
						textArea.insert(" Employee Name, ID (5-digit number), Annual salary", 0);
						textArea.append(job.printIsEmployeeID(tf));
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


