import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDetails extends JPanel {
	private JTextField markField;
	private JTextField regnoField;
	private String[] Exams={"CA Test 1","CA Test 2","CA Test 3"};
	private String[] subjects={"Subject 1","Subject 2","Subject 3","Subject 4","Subject 5","Subject 6"};
	String[] select= {"Name","Register no"};
	Main m;

	/**
	 * Create the panel.
	 */
	public UpdateDetails() {
		setLayout(null);
		
		JLabel headingLable = new JLabel("UPDATE STUDENT DETAILS");
		headingLable.setFont(new Font("Tahoma", Font.BOLD, 12));
		headingLable.setBounds(102, 29, 168, 31);
		add(headingLable);
		
		JLabel regnoLable = new JLabel("Register No        :");
		regnoLable.setBounds(64, 164, 89, 14);
		add(regnoLable);
		
		JLabel subLable = new JLabel("Subject              :");
		subLable.setBounds(64, 189, 89, 14);
		add(subLable);
		
		JLabel examLable = new JLabel("Select  Exam      :");
		examLable.setBounds(64, 214, 89, 14);
		add(examLable);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(133, 286, 89, 23);
		add(updateButton);
		
		JLabel markLable = new JLabel("Mark                   :");
		markLable.setBounds(64, 239, 89, 14);
		add(markLable);
		
		markField = new JTextField();
		markField.setColumns(10);
		markField.setBounds(163, 236, 146, 20);
		add(markField);
		
		JComboBox examComboBox = new JComboBox(Exams);
		examComboBox.setBounds(163, 210, 146, 22);
		add(examComboBox);
		
		JComboBox subcomboBox = new JComboBox(subjects);
		subcomboBox.setBounds(163, 185, 146, 22);
		add(subcomboBox);
		
		regnoField = new JTextField();
		regnoField.setColumns(10);
		regnoField.setBounds(163, 161, 146, 20);
		add(regnoField);
		
		JTextArea instrLable = new JTextArea();
		instrLable.setForeground(Color.BLUE);
		instrLable.setBackground(UIManager.getColor("MenuBar.background"));
		instrLable.setEditable(false);
		instrLable.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		instrLable.setText("   Enter the Register number of the \r\nstudent to search and update details");
		instrLable.setBounds(74, 71, 235, 48);
		add(instrLable);
		m=new Main();
		
		
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(regnoField.getText().length()==0) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Register number is empty");
				}
				else if(regnoField.getText().length()>10) {
					MainFrame.status.setForeground(Color.RED);
					MainFrame.status.setText("Max length of Reister number is 10");
				}
				else {
					int mark;
					try {
						mark=Integer.parseInt(markField.getText().toString());
						
						if(mark>=0 && mark<=60) {
							m.update(regnoField.getText(),examComboBox.getSelectedItem().toString(),subcomboBox.getSelectedItem().toString(),mark);
						}
						else {
							MainFrame.status.setForeground(Color.RED);
							MainFrame.status.setText("Enetr valid mark");
						}
					}
					catch(Exception f) {
						MainFrame.status.setForeground(Color.RED);
						MainFrame.status.setText("Enetr valid mark");
					}
				}
			}
		});

	}
}
