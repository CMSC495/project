/*
* This class stores venue related information for the events that a user creates. 
*/
import java.awt.Image;
import java.sql.Date;


public class Venue {
	
	private String venueID;
	private String name;
	private Address address;
	private Image photo;
        
        //default constructor
        public Venue(){
    }
        //constructor to create address with information in it
        public Venue(String a, String b, Address c, Image d){
        
        venueID = a;
	name = b;
	address = c;
	photo = d;
    }
      
        /**
	 * 
	 * toString
	 */
        
       @Override
    public String toString(){
        return venueID+", "+name+", "+address;
    } 
    
        /**
	 * 
	 *  getters
	 */
    
         public String getVenID () {
                return venueID;
}        
        public String getName () {
                return name;
}
        public Address getAddress () {
                return address;
}
        /**
	 * 
	 * setters
	 */
        
        public void setVenID(String venueID) {
		this.venueID = venueID;
	}
        
        public void setName(String name) {
		this.name = name;
	}
        
        public void setAddress(Address address) {
		this.address = address;
	}
}
