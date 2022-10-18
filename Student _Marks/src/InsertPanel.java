import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;

public class InsertPanel extends JPanel {
	private JTextField name;
	private JTextField regNo;
	private JTextField m1;
	private String[] Exams={"CA Test 1","CA Test 2","CA Test 3"};
	Main m;
	private JTextField m2;
	private JTextField m3;
	private JTextField m4;
	private JTextField m5;
	private JTextField m6;

	/**
	 * Create the panel.
	 */
	public InsertPanel() {
		setLayout(null);
		m=new Main();
		
		JLabel nameLable = new JLabel("Student Name    :");
		nameLable.setBounds(64, 98, 89, 14);
		add(nameLable);
		
		JLabel regNoLable = new JLabel("Register No        :");
		regNoLable.setBounds(64, 123, 89, 14);
		add(regNoLable);
		
		JLabel exameLable = new JLabel("Select  Exam      :");
		exameLable.setBounds(64, 152, 89, 14);
		add(exameLable);
		
		JLabel m1Lable = new JLabel("S1 Mark   :");
		m1Lable.setBounds(41, 194, 55, 14);
		add(m1Lable);
		
		JButton submit = new JButton("Done");
		submit.setBounds(133, 304, 89, 23);
		add(submit);
		
		name = new JTextField();
		name.setBounds(163, 95, 146, 20);
		add(name);
		name.setColumns(10);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(163, 120, 146, 20);
		add(regNo);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBounds(106, 194, 51, 20);
		add(m1);
		
		JComboBox examComboBox = new JComboBox(Exams);
		examComboBox.setBounds(163, 148, 146, 22);
		add(examComboBox);
		
		JLabel Heading = new JLabel("ADD STUDENT DETAILS");
		Heading.setFont(new Font("Tahoma", Font.BOLD, 12));
		Heading.setBounds(117, 29, 147, 31);
		add(Heading);
		
		m2 = new JTextField();
		m2.setColumns(10);
		m2.setBounds(106, 225, 51, 20);
		add(m2);
		
		JLabel m2Lable = new JLabel("S2 Mark   :");
		m2Lable.setBounds(41, 225, 55, 14);
		add(m2Lable);
		
		m3 = new JTextField();
		m3.setColumns(10);
		m3.setBounds(106, 253, 51, 20);
		add(m3);
		
		JLabel m3Lable = new JLabel("S3 Mark   :");
		m3Lable.setBounds(41, 253, 55, 14);
		add(m3Lable);
		
		m4 = new JTextField();
		m4.setColumns(10);
		m4.setBounds(272, 194, 51, 20);
		add(m4);
		
		JLabel m4Lable = new JLabel("S4 Mark   :");
		m4Lable.setBounds(207, 194, 55, 14);
		add(m4Lable);
		
		m5 = new JTextField();
		m5.setColumns(10);
		m5.setBounds(272, 225, 51, 20);
		add(m5);
		
		JLabel m5Lable = new JLabel("S5 Mark   :");
		m5Lable.setBounds(207, 225, 55, 14);
		add(m5Lable);
		
		m6 = new JTextField();
		m6.setColumns(10);
		m6.setBounds(272, 253, 51, 20);
		add(m6);
		
		JLabel m6Lable = new JLabel("S6 Mark   :");
		m6Lable.setBounds(207, 253, 55, 14);
		add(m6Lable);
		
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length()==0 || regNo.getText().length()==0 || m1.getText().length()==0 || m2.getText().length()==0 || m3.getText().length()==0 || m4.getText().length()==0 || m5.getText().length()==0 || m6.getText().length()==0) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Some thing is emty");
				}
				else if(regNo.getText().length()>10) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Max length of Register number is 10");
				}
				else if(name.getText().length()>20) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Max length of Student Name is 20");
				}
				else {
					int mark1,mark2,mark3,mark4,mark5,mark6;
					try{
						mark1=Integer.parseInt(m1.getText().toString());
						mark2=Integer.parseInt(m2.getText().toString());
						mark3=Integer.parseInt(m3.getText().toString());
						mark4=Integer.parseInt(m4.getText().toString());
						mark5=Integer.parseInt(m5.getText().toString());
						mark6=Integer.parseInt(m6.getText().toString());
					
						if(mark1<=60 && mark1>=0 && mark2<=60 && mark2>=0 && mark3<=60 && mark3>=0 && mark4<=60 && mark4>=0 && mark5<=60 && mark5>=0 && mark6<=60 && mark6>=0) {
							if(name.getText().toString().matches("[a-zA-Z]+")) {
								String test=(String) examComboBox.getSelectedItem();
								m.insert(name.getText(),regNo.getText(),examComboBox.getSelectedItem().toString(),mark1,mark2,mark3,mark4,mark5,mark6);
							}
							else {
								MainFrame.status.setForeground(Color.RED);
								MainFrame.status.setText("Names only contins characters without space");
							}
						}
						else {
							MainFrame.status.setForeground(Color.RED);
							MainFrame.status.setText("Enter valid mark");
						}
					}
					catch(Exception evnt) {
						MainFrame.status.setForeground(Color.RED);
						MainFrame.status.setText("Enter valid mark "+evnt.getMessage());
					}
				}
			}
		});

	}
}
