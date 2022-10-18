import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class searchPanel extends JPanel {
	private JTextField m1;
	private JTextField m2;
	private JTextField m3;
	private JTextField m6;
	private JTextField m5;
	private JTextField m4;
	String[] select= {"Name","Register no"};
	private String[] Exams={"CA Test 1","CA Test 2","CA Test 3"};
	private JTextField regNo;
	Main m;
	private JTextField stdName;

	/**
	 * Create the panel.
	 */
	public searchPanel() {
		setLayout(null);
		
		JLabel headingLable = new JLabel("SEARCH STUDENT DETAILS");
		headingLable.setFont(new Font("Tahoma", Font.BOLD, 12));
		headingLable.setBounds(103, 28, 168, 31);
		add(headingLable);
		
		JLabel examLable = new JLabel("Select  Exam      :");
		examLable.setBounds(10, 182, 89, 14);
		add(examLable);
		
		JComboBox examComboBox = new JComboBox(Exams);
		examComboBox.setBounds(109, 178, 146, 22);
		add(examComboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(267, 178, 89, 23);
		add(btnSearch);
		
		JLabel m1Lable = new JLabel("S1 Mark   :");
		m1Lable.setBounds(37, 238, 55, 14);
		add(m1Lable);
		
		m1 = new JTextField();
		m1.setEditable(false);
		m1.setColumns(10);
		m1.setBounds(102, 238, 51, 20);
		add(m1);
		
		JLabel m2Lable = new JLabel("S2 Mark   :");
		m2Lable.setBounds(37, 269, 55, 14);
		add(m2Lable);
		
		m2 = new JTextField();
		m2.setEditable(false);
		m2.setColumns(10);
		m2.setBounds(102, 269, 51, 20);
		add(m2);
		
		JLabel m3Lable = new JLabel("S3 Mark   :");
		m3Lable.setBounds(37, 297, 55, 14);
		add(m3Lable);
		
		m3 = new JTextField();
		m3.setEditable(false);
		m3.setColumns(10);
		m3.setBounds(102, 297, 51, 20);
		add(m3);
		
		m6 = new JTextField();
		m6.setEditable(false);
		m6.setColumns(10);
		m6.setBounds(268, 297, 51, 20);
		add(m6);
		
		m5 = new JTextField();
		m5.setEditable(false);
		m5.setColumns(10);
		m5.setBounds(268, 269, 51, 20);
		add(m5);
		
		JLabel m5Lable = new JLabel("S5 Mark   :");
		m5Lable.setBounds(203, 269, 55, 14);
		add(m5Lable);
		
		m4 = new JTextField();
		m4.setEditable(false);
		m4.setColumns(10);
		m4.setBounds(268, 238, 51, 20);
		add(m4);
		
		JLabel m6Lable = new JLabel("S6 Mark   :");
		m6Lable.setBounds(203, 297, 55, 14);
		add(m6Lable);
		
		JLabel m4Lable = new JLabel("S4 Mark   :");
		m4Lable.setBounds(203, 238, 55, 14);
		add(m4Lable);
		
		JLabel regnoLable = new JLabel("Register No        :");
		regnoLable.setBounds(59, 110, 89, 14);
		add(regnoLable);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(158, 107, 146, 20);
		add(regNo);
		
		JTextArea instrLable = new JTextArea();
		instrLable.setForeground(UIManager.getColor("TextField.selectionBackground"));
		instrLable.setText("Enter the Register number of the \r\n             student to search");
		instrLable.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		instrLable.setEditable(false);
		instrLable.setBackground(SystemColor.menu);
		instrLable.setBounds(80, 58, 218, 48);
		add(instrLable);
		
		JLabel nameLable = new JLabel("Student Name    :");
		nameLable.setBounds(59, 138, 89, 14);
		add(nameLable);
		
		stdName = new JTextField();
		stdName.setEditable(false);
		stdName.setColumns(10);
		stdName.setBounds(158, 135, 146, 20);
		add(stdName);
		
		m=new Main();

		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(regNo.getText().length()==0) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Enter valid register number");
				}
				else if(regNo.getText().length()>10) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Max length of Reister number is 10");
				}
				else {
					stdName.setText(m.search(regNo.getText(), examComboBox.getSelectedItem().toString()));
					
					m1.setText(String.valueOf(m.tempMarks[0]));
					m2.setText(String.valueOf(m.tempMarks[1]));
					m3.setText(String.valueOf(m.tempMarks[2]));
					m4.setText(String.valueOf(m.tempMarks[3]));
					m5.setText(String.valueOf(m.tempMarks[4]));
					m6.setText(String.valueOf(m.tempMarks[5]));
				}
			}
		});
	}
}
