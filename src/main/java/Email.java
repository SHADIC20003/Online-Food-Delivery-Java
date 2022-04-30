import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email{
	
	String to;

    String from;
    
    String host = "localhost";
 
    Properties properties = System.getProperties();

    
    
    Email(String to, String from){
    	
    	this.from = from;
    	
    	this.to = to;
    	
    	properties.setProperty("mail.smtp.host", host);
    	
    	Session session = Session.getDefaultInstance(properties);
    	
    }
    
    

}