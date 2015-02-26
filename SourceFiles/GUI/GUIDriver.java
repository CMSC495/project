import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class GUIDriver {
	
	public static void main (String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		
		System.out.println("Hello");
	      UIManager.setLookAndFeel(
	              UIManager.getCrossPlatformLookAndFeelClassName());		
		Landing landing = new Landing();
		landing.setVisible(true);
		
		Register register = new Register();
		register.setVisible(true);
		
		Login login = new Login ();
		login.setVisible(true);
		
		Homepage homepage = new Homepage();
		homepage.setVisible(true);
		
		CreateEvent creatEvent = new CreateEvent();
		creatEvent.setVisible(true);
		
		EventPage event = new EventPage();
		event.setVisible(true);
		
	}

}
