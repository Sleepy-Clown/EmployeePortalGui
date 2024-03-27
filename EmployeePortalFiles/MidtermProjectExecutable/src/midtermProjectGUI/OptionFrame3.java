package midtermProjectGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.UIManager;

public class OptionFrame3 extends JFrame {
	static Company job = new Company("Generic Co.");
	public ArrayList<Employee> list = job.list;
	public static ArrayList<File> flist = GuiFrame.flist;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionFrame3 frame = new OptionFrame3();
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
	public OptionFrame3() throws IOException, Exception {		
		setBackground(new Color(0, 64, 128));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setForeground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(job.getCompanyName()+" Employee Terminal");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(192, 192, 192));
		menuBar.setBackground(new Color(0, 52, 108));
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setBackground(new Color(0, 52, 108));
		mnNewMenu.setForeground(new Color(192, 192, 192));
		JMenuItem mntmBackBtn = new JMenuItem("Back");
		mntmBackBtn.setForeground(new Color(192, 192, 192));
		mntmBackBtn.setBackground(new Color(0, 54, 108));
		menuBar.add(mnNewMenu);
		mnNewMenu.add(mntmBackBtn);
		
		mntmBackBtn.addActionListener(new BackToMenuFrame());
		
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(0, 23, 436, 210);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLocation(0, 24);
		textArea.setSize(436, 205);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(0, 82, 164));
		//contentPane.add(textArea);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setText("");
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(125, 190, 255));
		btnReturn.setBounds(347, 240, 89, 23);
		contentPane.add(btnReturn);
		
		textArea.insert(" Number of employees: "+job.getNumberOfEmployees(),0);
		textArea.append("\n\n Clearance Level, Employee Name, ID (5-digit number), Annual salary");
		textArea.append("\n-------------------------------------------------------------");
		for(int i = 0; i < list.size(); i++) {
			textArea.append("\n "+list.get(i).printAccountString());
		}
		
		btnReturn.addActionListener(new BackToMenuFrame());
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
