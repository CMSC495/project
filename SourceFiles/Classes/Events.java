import java.awt.Image;
import java.sql.Date;
import java.util.LinkedHashMap;


public class Events {

	private String eventID;
	private String name;
	private Venue venue;
	private Date startTime;
	private Date endTime;
	private String info;
	private Date date;
	private Image photo;
	private LinkedHashMap <String, User> host;
	private LinkedHashMap <String, User> invited;
	private LinkedHashMap <String, User> attended;
}