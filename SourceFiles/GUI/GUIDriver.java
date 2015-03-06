import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.sql.*;



public class GUIDriver {
	public static Boolean login = false;

	// Current database

	// edited database

	// new instances

	public static void main(String args[]) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		// Get data and turn into hashmap
		System.out.println("Hello");

		UIManager.setLookAndFeel(UIManager
				.getCrossPlatformLookAndFeelClassName());

		Landing landing = new Landing();
		landing.setVisible(true);

		Register register = new Register();
		register.setVisible(false);

		Login login = new Login();
		login.setVisible(false);

		Homepage homepage = new Homepage();
		homepage.setVisible(false);

		CreateEvent creatEvent = new CreateEvent();
		creatEvent.setVisible(false);

		UpdateUser updateUser = new UpdateUser();
		updateUser.setVisible(false);

		EventPage event = new EventPage();
		event.setVisible(false);
		
		EditEvent editEvent = new EditEvent();
		editEvent.setVisible(false);
		
		AddUser addUser = new AddUser();
		addUser.setVisible(false);
		
		SQL conn = new SQL();
		
		try {
			conn.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * Landing functionality
		 */

		landing.getLogin().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				landing.setVisible(false);
				login.setVisible(true);

			}

		});

		landing.getRegister().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				landing.setVisible(false);
				register.setVisible(true);
			}

		});

		/*
		 * Login Functionality
		 */

		login.getLogin().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Method to check if the user is in the database if true it
				 * advances to the homepage
				 * 
				 * if false then it prints a error
				 */

				login.setVisible(false);
				homepage.setVisible(true);

			}

		});

		login.getCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				login.setVisible(false);
				landing.setVisible(true);

			}

		});

		/*
		 * Register functionality
		 */

		register.getRegister().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Get new user instance and it to the data base to be add to
				 * sql server when the program is closed
				 */

				register.setVisible(false);
				landing.setVisible(true);

			}

		});

		register.getCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				register.setVisible(false);
				landing.setVisible(true);

			}

		});

		/*
		 * Homepage Functionality
		 */

		homepage.getCreateEvent().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				homepage.setVisible(false);
				creatEvent.setVisible(true);

			}

		});

		homepage.getEditSettings().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				homepage.setVisible(false);
				updateUser.setVisible(true);

			}

		});

		homepage.getUserEvents().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				homepage.setVisible(false);
				event.setVisible(true);

				if (e.getClickCount() == 2) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					// do some action if appropriate column
				}
			}
		});

		/*
		 * Update User
		 */

		updateUser.getCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Update Canceled");
				updateUser.setVisible(false);
				homepage.setVisible(true);

			}

		});

		updateUser.getEditUser().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "User Updated");
				updateUser.setVisible(false);
				homepage.setVisible(true);

			}

		});

		/*
		 * Create Event Functions
		 */

		creatEvent.getCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Create Cancelled");
				creatEvent.setVisible(false);
				homepage.setVisible(true);

			}

		});

		creatEvent.getCreate().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {


				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Event Created");
				creatEvent.setVisible(false);
				homepage.setVisible(true);

			}

		});
		
		creatEvent.getAddUser().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				 addUser.setVisible(true);

			}

		});
		
		
		/*
		 * Events Page Functions 
		 */
		
		event.getEditSettings().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Edit Settings");
				event.setVisible(false);
				homepage.setVisible(true);

			}

		});
		
		event.getUpdateEvent().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Update Event");
				event.setVisible(false);
				editEvent.setVisible(true);

			}

		});
		
		/*
		 * Edit Event Functionality
		 */
		
		editEvent.getCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Edit Cancelled");
				editEvent.setVisible(false);
				event.setVisible(true);

			}

		});

		editEvent.getEdit().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Event Edited");
				editEvent.setVisible(false);
				event.setVisible(true);

			}

		});
		
		editEvent.getAddUser().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				 addUser.setVisible(true);

			}

		});
		
		/*
		 * Add user functionality
		 */
		
		addUser.getAddUser().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "User Added");
				addUser.setVisible(false);

			}

		});
		
		addUser.getCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * Check if user information is valid
				 */

				JOptionPane.showMessageDialog(null, "Add Canceled");
				addUser.setVisible(false);
			}

		});
	}
}
