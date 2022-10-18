import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPanel extends JPanel {
	
	private String[] Exams={"CA Test 1","CA Test 2","CA Test 3"};
	Main m;

	/**
	 * Create the panel.
	 */
	public ViewPanel() {
		setLayout(null);
		
		JLabel headLable = new JLabel("VIEW STUDENT DETAILS");
		headLable.setBounds(101, 29, 157, 15);
		headLable.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(headLable);
		
		JComboBox comboBox = new JComboBox(Exams);
		comboBox.setBounds(86, 65, 113, 22);
		add(comboBox);
		
		JLabel examtLable = new JLabel("Select Exam");
		examtLable.setHorizontalAlignment(SwingConstants.LEFT);
		examtLable.setBounds(10, 69, 66, 14);
		add(examtLable);
		
		JButton viewButton = new JButton("view");
		viewButton.setBounds(246, 65, 89, 23);
		add(viewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 346, 267);
		add(scrollPane);
		
		JTextArea viewField = new JTextArea();
		viewField.setEditable(false);
		scrollPane.setViewportView(viewField);
		
		m=new Main();
		
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewField.setForeground(Color.BLUE);
				String temp="Name -- Reg no -- s1 -- s2 -- s3 -- s4 -- s5 -- s6\n";
				viewField.setText(temp+m.view(comboBox.getSelectedItem().toString()));
			}
		});

	}
}
