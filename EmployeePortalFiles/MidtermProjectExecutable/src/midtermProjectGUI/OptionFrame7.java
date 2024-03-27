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

import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JScrollPane;

public class OptionFrame7 extends JFrame {

	static Company job = new Company("Generic Co.");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public GuiFrame gf =  new GuiFrame();
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = GuiFrame.flist;
	private JMenuBar menuBar;
	private JTextArea textArea;
	private JButton btnReturn;
	private JButton btnConfirm, btnConfirm_1;
	private JEditorPane dtrpnWouldYouLike, dtrpnEmployeeListSorted;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame7 frame = new OptionFrame7();
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
	public OptionFrame7() throws IOException, Exception {
		setBackground(new Color(0, 64, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 180, 180);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		job.sortByFirstName();
		
		dtrpnEmployeeListSorted = new JEditorPane();
		dtrpnEmployeeListSorted.setText("Employee list sorted.");
		dtrpnEmployeeListSorted.setForeground(new Color(125, 190, 255));
		dtrpnEmployeeListSorted.setFont(new Font("Perpetua", Font.PLAIN, 14));
		dtrpnEmployeeListSorted.setEditable(false);
		dtrpnEmployeeListSorted.setBackground(new Color(0, 64, 128));
		dtrpnEmployeeListSorted.setBounds(0, 22, 166, 22);
		contentPane.add(dtrpnEmployeeListSorted);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 166, 22);
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 52, 108));
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(Color.LIGHT_GRAY);
		mnNewMenu.setBackground(new Color(0, 54, 108));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmBackBtn = new JMenuItem("Back");
		mntmBackBtn.setForeground(Color.LIGHT_GRAY);
		mntmBackBtn.setBackground(new Color(0, 54, 108));
		mnNewMenu.add(mntmBackBtn);
		
		btnConfirm = new JButton("Yes");
		btnConfirm.setBounds(10, 98, 68, 23);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(new doConfirm());
		
		btnConfirm_1 = new JButton("No");
		btnConfirm_1.setBounds(88, 98, 68, 23);
		contentPane.add(btnConfirm_1);
		btnConfirm_1.addActionListener(new BackToMenuFrame());
		
		dtrpnWouldYouLike = new JEditorPane();
		dtrpnWouldYouLike.setEditable(false);
		dtrpnWouldYouLike.setText("Would you like to display       current employee list?");
		dtrpnWouldYouLike.setFont(new Font("Perpetua", Font.PLAIN, 14));
		dtrpnWouldYouLike.setForeground(new Color(125, 190, 255));
		dtrpnWouldYouLike.setBackground(new Color(0, 64, 128));
		dtrpnWouldYouLike.setBounds(0, 44, 166, 65);
		contentPane.add(dtrpnWouldYouLike);
		
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
		btnReturn.setBounds(347, 240, 89, 23);
		contentPane.add(btnReturn);
		btnReturn.addActionListener(new BackToMenuFrame());
	}
	
	private class doConfirm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dtrpnWouldYouLike.setVisible(false);
			dtrpnEmployeeListSorted.setVisible(false);
			btnConfirm.setVisible(false);
			btnConfirm_1.setVisible(false);
			btnReturn.setVisible(true);
			textArea.setVisible(true);
			menuBar.setBounds(0, 0, 436, 22);
			setBounds(100, 100, 450, 300);
			
			textArea.insert(" Number of employees: "+job.getNumberOfEmployees(),0);
			textArea.append("\n\n Employee Name, ID (5-digit number), Annual salary");
			textArea.append("\n-------------------------------------------------------------");
			for(int i = 0; i < list.size(); i++) {
				textArea.append("\n "+list.get(i).printAccountString());
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
