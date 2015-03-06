import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel loginPanel;
	private JLabel emailLabel;
	private JTextField email;
	private JButton login;
	private JButton cancel;
        private JTextField password;

	public Login() {

		new JFrame();
		setTitle("Login");
		setSize(200, 200);
		createPanel();
	}

	public void createPanel() {

		// Initialize Fields
		loginPanel = new JPanel(new GridBagLayout());

		// Set Constraints
		GridBagConstraints gbc = new GridBagConstraints();

		/*
		 * Add Fields
		 */

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		emailLabel = new JLabel("Email: ");
		loginPanel.add(emailLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		email = new JTextField();
		loginPanel.add(email, gbc);
                
                gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=1;
		emailLabel = new JLabel("Pass: ");
		loginPanel.add(emailLabel,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=3;
		password = new JTextField();
		loginPanel.add(password,gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		login = new JButton("Login");
		loginPanel.add(login, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		cancel = new JButton("Cancel");
		loginPanel.add(cancel, gbc);

		add(loginPanel);
		cancel.addActionListener(new CancelButtonListener());
		login.addActionListener(new LoginButtonListener());
	}

	private class LoginButtonListener implements ActionListener {
            boolean verification=false;
            public LoginButtonListener() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
                    
                    Component frame = null;
            
            if (email.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "Please Enter Email to login!");else {
                if (password.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "Please Enter A Password to login!");else {
                        //code to verify Email and password goes here (if password equals)...   
                    GUIDriver.login = true;
                }
            }	
		}
	}

	private class CancelButtonListener implements ActionListener {
		public CancelButtonListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	public JButton getLogin() {
		return login;
	}

	public JButton getCancel() {
		return cancel;
	}

}
