import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;


@SuppressWarnings("serial")
public class CreateEvent extends JFrame {

	// Labels for frames
	private JLabel eventNameLabel;
	private JLabel venueNameLabel;
	private JLabel startTimeLabel;
	private JLabel endTimeLabel;
	private JLabel eventInfoLabel;
	private JLabel eventDateLabel;
	private JLabel addUserLabel;
	private JLabel photoLabel;

	// Entry fields
	private JTextField eventName;
	private JTextField eventVenue;
	private DateFormat format;
	private JFormattedTextField startTime;
	private JFormattedTextField endTime;
	private JTextPane eventInfo;
	private JFormattedTextField eventDate;
	private JButton addUser; 
	private JButton fileButton;
	private JButton create;
	private JButton cancel;

	public CreateEvent() {

		new JFrame("Frame");
		setTitle("Create Event");
		setSize(300, 320);
		createPanel();
		pack();
	}

	public void createPanel() {

		// Create panel
		JPanel formPanel = new JPanel(new SpringLayout());

		/*
		 * Add name row
		 */
		eventNameLabel = new JLabel("Name: ", JLabel.TRAILING);
		formPanel.add(eventNameLabel);

		eventName = new JTextField(20);
		eventNameLabel.setLabelFor(eventName);
		formPanel.add(eventName);

		/*
		 * Add venue name row
		 */
		venueNameLabel = new JLabel("Venue: ", JLabel.TRAILING);
		formPanel.add(venueNameLabel);

		eventVenue = new JTextField(20);
		venueNameLabel.setLabelFor(eventVenue);
		formPanel.add(eventVenue);

		/*
		 * Add start time row
		 */
		format = new SimpleDateFormat("hh:mm");

		startTimeLabel = new JLabel("Start Time: ", JLabel.TRAILING);
		formPanel.add(startTimeLabel);

		startTime =  new JFormattedTextField(format);
		startTimeLabel.setLabelFor(startTime);
		formPanel.add(startTime);

		/*
		 * Add end time row
		 */
		endTimeLabel = new JLabel("Start Time: ", JLabel.TRAILING);
		formPanel.add(endTimeLabel);

		endTime =  new JFormattedTextField(format);
		endTimeLabel.setLabelFor(endTime);
		formPanel.add(endTime);

		/*
		 * Add info text pane
		 */
		eventInfoLabel = new JLabel("Info: ", JLabel.TRAILING);
		formPanel.add(eventInfoLabel);

		eventInfo = new JTextPane();
		eventInfoLabel.setLabelFor(eventInfo);
		formPanel.add(eventInfo);

		/*
		 * Add event date row 
		 */
		format = new SimpleDateFormat("yyyy--MMMM--dd");

		eventDateLabel = new JLabel("Event Date: ", JLabel.TRAILING);
		formPanel.add(eventDateLabel);

		eventDate =  new JFormattedTextField(format);
		eventDateLabel.setLabelFor(eventDate);
		formPanel.add(eventDate);

		/*
		 * Add user row 
		 */
		addUserLabel = new JLabel("Add User", JLabel.TRAILING);
		formPanel.add(addUserLabel);

		addUser = new JButton("Add User");
		
		//Action listener for add user
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					
				//Button Action -> open add user frame
			}
		});
		addUserLabel.setLabelFor(addUser);
		formPanel.add(addUser);

		/*
		 * Add file chooser button row
		 */
		photoLabel = new JLabel("Choose Photo", JLabel.TRAILING);
		formPanel.add(photoLabel);

		fileButton = new JButton("Photo File");
		
		//Action lister for file chooser
		fileButton.addActionListener(new ActionListener() {
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
		create = new JButton("Create");
		registerCancel.add(create);
		cancel = new JButton("Cancel");
		registerCancel.add(cancel);
		formPanel.add(new JPanel());
		formPanel.add(registerCancel);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(formPanel, 9, 2, // rows, cols
				6, 6, // initX, initY
				6, 6);

		add(formPanel);
	}
	
	public JButton getCreate() {
		return create;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JButton getAddUser() {
		return addUser;
	}
}

