import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class Register extends JFrame {

	// Labels for frames
	private JLabel firstLabel;
	private JLabel lastLabel;
	private JLabel emailLabel;
	private JLabel dobLabel;
	private JLabel genderLabel;
	private JLabel passLabel;
	private JLabel rePassLabel;
	private JLabel photoLabel;

	// Entry fields
	private JTextField first;
	private JTextField last;
	private JTextField email;
	private DateFormat format;
	private JFormattedTextField dateTextField;
	private JComboBox<String> gender;
	private JTextField pass;
	private JTextField rePass;
	private JButton fileButton;
	
        private final JButton register = new JButton(new AbstractAction("Register") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            Component frame = null;
            // add Action
            if (first.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "First Name Must be Entered!");else {
                if (last.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "Last Name Must be Entered!");else{
                    if (email.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "Email Must be Entered!");else{
                        if (dateTextField.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "Date of Birth Must be Entered!");else{
                            if (gender.getSelectedItem().equals(""))JOptionPane.showMessageDialog(frame,
                    "Gender Must be Selected!");else{
                            if (pass.getText().equals("")||rePass.getText().equals(""))JOptionPane.showMessageDialog(frame,
                    "Password Fields cannot be Empty!");else{   
                                if (pass.getText().equals(rePass.getText())){JOptionPane.showMessageDialog(frame,
                    "Registration Successful!");
                                        //code to add user to the dB would go here***
                                        }else{
                                   JOptionPane.showMessageDialog(frame,
                    "Passwords do not Match!");
                }
                }
                }
                }
                }
                }
            }
        }
    });
	private JButton cancel;

	// Set up panel
	private JPanel formPanel;

	public Register() {

		new JFrame("Frame");
		setTitle("Register");
		setSize(300, 320);
		createPanel();
	}

	public void createPanel() {

		// Create panel
		formPanel = new JPanel(new SpringLayout());

		/*
		 * Add first row
		 */
		firstLabel = new JLabel("First", JLabel.TRAILING);
		formPanel.add(firstLabel);

		first = new JTextField(20);
		firstLabel.setLabelFor(first);
		formPanel.add(first);

		/*
		 * Add last name row
		 */
		lastLabel = new JLabel("Last", JLabel.TRAILING);
		formPanel.add(lastLabel);

		last = new JTextField(20);
		lastLabel.setLabelFor(last);
		formPanel.add(last);

		/*
		 * Add email row
		 */
		emailLabel = new JLabel("Email", JLabel.TRAILING);
		formPanel.add(emailLabel);

		email = new JTextField(20);
		emailLabel.setLabelFor(email);
		formPanel.add(email);

		/*
		 * Add DOB row
		 */
		dobLabel = new JLabel("DOB(MM/DD/YYYY)", JLabel.TRAILING);
		formPanel.add(dobLabel);

		format = new SimpleDateFormat("MM/DD/YYYY");
		dateTextField = new JFormattedTextField(format);
		dobLabel.setLabelFor(dateTextField);
		formPanel.add(dateTextField);

		/*
		 * Add gender row
		 */
		genderLabel = new JLabel("Gender", JLabel.TRAILING);
		formPanel.add(genderLabel);

		String[] genderOptions = { "", "Female","Male" };
		gender = new JComboBox<String>(genderOptions);
		genderLabel.setLabelFor(gender);
		formPanel.add(gender);

		/*
		 * Add password row
		 */
		passLabel = new JLabel("Password", JLabel.TRAILING);
		formPanel.add(passLabel);

		pass = new JTextField(20);
		passLabel.setLabelFor(pass);
		formPanel.add(pass);

		/*
		 * Add re enter pass row
		 */
		rePassLabel = new JLabel("Re-Enter", JLabel.TRAILING);
		formPanel.add(rePassLabel);

		rePass = new JTextField(20);
		rePassLabel.setLabelFor(rePass);
		formPanel.add(rePass);

		/*
		 * Add file chooser button row
		 */
		photoLabel = new JLabel("Choose Photo", JLabel.TRAILING);
		formPanel.add(photoLabel);

		fileButton = new JButton("Photo File");
		
		//Action lister for file chooser
		fileButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent ae) {

				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getName());
				}
			}
		});
		photoLabel.setLabelFor(fileButton);
		formPanel.add(fileButton);
		
		/*
		 * Add register and cancel button
		 * 
		 */
		
		JPanel registerCancel = new JPanel (new GridLayout(1,2));
		registerCancel.add(register);
		cancel = new JButton("Cancel");
		registerCancel.add(cancel);
		formPanel.add(new JPanel());
		formPanel.add(registerCancel);




		// Lay out the panel.
		SpringUtilities.makeCompactGrid(formPanel, 9, 2, // rows, cols
				6, 6, // initX, initY
				6, 6);

		add(formPanel);
                cancel.addActionListener(new CancelButtonListener());
	} 
        
    private class CancelButtonListener implements ActionListener {
        public CancelButtonListener(){
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            dispose();
        }
	}

}
