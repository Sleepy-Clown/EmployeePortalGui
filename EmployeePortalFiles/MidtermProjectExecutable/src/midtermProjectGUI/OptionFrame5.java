package midtermProjectGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;

public class OptionFrame5 extends JFrame {
	static Company job = new Company("Generic Co.");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public GuiFrame gf =  new GuiFrame();
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = GuiFrame.flist;
	private JLabel lblNewEmployee, lblSpecial, lblHigh$, 
					lblLow$, lblHighest, lblLowest;
	private JSpinner spinnerHigh, spinnerLow;
	private JButton btnSubmit, btnReturn;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame5 frame = new OptionFrame5();
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
	public OptionFrame5() throws IOException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewEmployee = new JLabel("Please enter the highest and lowest \r\nsalary points");
		lblNewEmployee.setForeground(new Color(125, 190, 255));
		lblNewEmployee.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEmployee.setBounds(42, 33, 352, 37);
		contentPane.add(lblNewEmployee);
		
		lblSpecial = new JLabel("");
		lblSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecial.setFont(new Font("Rockwell", Font.ITALIC, 11));
		lblSpecial.setBounds(73, 67, 289, 37);
		lblSpecial.setForeground(new Color(255, 0, 0));
		lblSpecial.setText("");
		lblSpecial.setVisible(false);
		contentPane.add(lblSpecial);
		
		spinnerHigh = new JSpinner();
		spinnerHigh.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(10)));
		spinnerHigh.setBackground(new Color(125, 190, 255));
		spinnerHigh.setForeground(new Color(0, 0, 0));
		spinnerHigh.setToolTipText("Highest Salary Point");
		spinnerHigh.setBounds(120, 123, 81, 20);
		contentPane.add(spinnerHigh);
		
		spinnerLow = new JSpinner();
		spinnerLow.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(10)));
		spinnerLow.setBackground(new Color(125, 190, 255));
		spinnerLow.setForeground(new Color(0, 0, 0));
		spinnerLow.setToolTipText("Lowest Salary Point");
		spinnerLow.setBounds(237, 123, 81, 20);
		contentPane.add(spinnerLow);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(125, 190, 255));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBounds(173, 159, 89, 23);
		contentPane.add(btnSubmit);
		
		lblHigh$ = new JLabel("$");
		lblHigh$.setFont(new Font("Serif", Font.PLAIN, 12));
		lblHigh$.setForeground(new Color(125, 190, 255));
		lblHigh$.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHigh$.setBounds(76, 123, 41, 14);
		contentPane.add(lblHigh$);
		
		lblLow$ = new JLabel("-    $");
		lblLow$.setFont(new Font("Serif", Font.PLAIN, 12));
		lblLow$.setForeground(new Color(125, 190, 255));
		lblLow$.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLow$.setBounds(186, 123, 49, 14);
		contentPane.add(lblLow$);
		
		lblHighest = new JLabel("Highest");
		lblHighest.setFont(new Font("Serif", Font.PLAIN, 12));
		lblHighest.setForeground(new Color(125, 190, 255));
		lblHighest.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighest.setBounds(134, 106, 49, 14);
		contentPane.add(lblHighest);
		
		lblLowest = new JLabel("Lowest");
		lblLowest.setFont(new Font("Serif", Font.PLAIN, 12));
		lblLowest.setForeground(new Color(125, 190, 255));
		lblLowest.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowest.setBounds(252, 106, 49, 14);
		contentPane.add(lblLowest);
		
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
		
		btnSubmit.addActionListener(new doNumbers());
	}
	
	private class doNumbers implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Numbers(e);
		}
			
		public void Numbers(ActionEvent e) {
			int high = Integer.parseInt(spinnerHigh.getValue().toString());
			int low = Integer.parseInt(spinnerLow.getValue().toString());
			
			if(high > low) {
				lblNewEmployee.setVisible(false);
				lblSpecial.setVisible(false);
				spinnerHigh.setVisible(false);
				spinnerLow.setVisible(false);
				btnSubmit.setVisible(false);
				lblHigh$.setVisible(false);
				lblLow$.setVisible(false);
				lblHighest.setVisible(false);
				lblLowest.setVisible(false);
				textArea.setVisible(true);
				btnReturn.setVisible(true);
				
				int count = job.numberInSalaryRange(high, low);
				textArea.insert(" Number of employees withing the salary range: "+count,0);
				textArea.append("\n Employee Name, ID (5-digit number), Annual salary");
					
				textArea.append(job.printInSalaryRange(high, low));
			}
			else {
				if(high == 0) {
					do {
						lblSpecial.setText("Highest salary point must be greater than 0");
						lblSpecial.setVisible(true);
						Numbers(e);
					}while(high == 0);
				}
				else {
					do {
						lblSpecial.setText("Highest salary point must be greater than the lowest salary point");
						lblSpecial.setVisible(true);
						Numbers(e);
					}while(high <= low);
				}
			}
		}
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
