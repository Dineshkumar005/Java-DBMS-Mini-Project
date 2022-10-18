import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class AboutPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		setLayout(null);
		
		JTextArea txtrVersionJava = new JTextArea();
		txtrVersionJava.setText("Version 1.0\r\n\r\nJAVA Assignment - 3\r\n\r\n    By\r\n          Dineshkumar D\r\n          Kishore K");
		txtrVersionJava.setBackground(UIManager.getColor("MenuBar.background"));
		txtrVersionJava.setBounds(64, 73, 227, 201);
		add(txtrVersionJava);

	}

}
