import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class UpdateUser extends JFrame {
	
	private JPanel loginPanel;
	private JLabel emailLabel;
	private JTextField email;
	private JButton editUser;
	private JButton cancel;
	
	
	public UpdateUser (){
		
		new JFrame();
		setTitle("Update User");
		setSize(200,200);
		createPanel();
	}

	public void createPanel (){
		
		//Initialize Fields
		loginPanel = new JPanel(new GridBagLayout());
		
		//Set Constraints
		GridBagConstraints gbc = new GridBagConstraints();
		
		/*
		 * Add Fields
		 */
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=0;
		emailLabel = new JLabel("Email: ");
		loginPanel.add(emailLabel,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=3;
		email = new JTextField();
		loginPanel.add(email,gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=2;
		editUser = new JButton("Update User");
		loginPanel.add(editUser,gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		cancel = new JButton ("Cancel");
		loginPanel.add(cancel,gbc);
		
		add(loginPanel);

	}
}
