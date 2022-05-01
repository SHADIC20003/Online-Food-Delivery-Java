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
    	  
    }
    
    void sendEmail(String SubjectString, String MessageString)
    {
    	Session session = Session.getDefaultInstance(properties);
    	
    	try {
    	MimeMessage message = new MimeMessage(session);
    	
    	message.setFrom(new InternetAddress(from));
    	
    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    	
    	message.setSubject(SubjectString);
    	
    	message.setText(MessageString);
    	
    	Transport.send(message);
    	   	
    	}catch(MessagingException mex) {
    		mex.printStackTrace();
    	}
    }

}