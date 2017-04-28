package utills;

import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailNotification {
	@Test
	public void emailTest(){
		String from = getPropValue("emailFromUser");
		String password = getPropValue("emailFromPassword");
		String to[] = getPropValues("emailTo");
		String cc[] = getPropValues("emailCc");
		String bcc[] = getPropValues("emailBcc");
		String emailSubject = getPropValue("emailSubject");
		String[] emailBody = getPropValues("emailBody");
		String host = "smtp.gmail.com";
		String port = "465";
		String[] attachmentPath = getPropValues("emailAttachment");
		
		if(to.length==0){
			Reporter.log("No reciever email Id found", true);
			return;
		}

		//Calling sendEmail method to execute sending mail process
		sendEmail(from, password, to, cc, bcc, emailSubject, emailBody, attachmentPath, host, port);
	}
	
	//sendEmail complete process
	public void sendEmail(final String from, final String password, String[] to, String[] cc, String[] bcc, String emailSubject, String[] emailBody, String[] attachmentPath, String host, String port ){
		//Configuration to establish connection with Gmail using Tls
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);	//smtp.gmail.com
		props.put("mail.smtp.port", port);	//465
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		//Creating session for authentication
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Transport transport=session.getTransport();
			MimeMessage message = new MimeMessage(session);

			//Senders set up
			message.setFrom(new InternetAddress(from));

			//Converting string email to Internet Address for "to"
			InternetAddress[] iaTo = getInternetAddresses(to); 
			
			//Reciever's (to) setup
			message.setRecipients(Message.RecipientType.TO, iaTo);
			
			//Set CC for email
			if(cc.length>0){
				//Converting string email to Internet Address for "cc"
				InternetAddress[] iaCc = getInternetAddresses(cc); 
				
				//Recievers (cc) setup
				message.setRecipients(Message.RecipientType.CC, iaCc);
			}

			//Set BCC for email
			if(bcc.length>0){
				//Converting string email to Internet Address for "bcc"
				InternetAddress[] iaBcc = getInternetAddresses(bcc); 
				
				//Reciever's (bcc) setup
				message.setRecipients(Message.RecipientType.BCC, iaBcc);
			}

			//Set Email Subject
			message.setSubject(emailSubject);

			//Set Email Body
			Multipart multipart = new MimeMultipart();
			BodyPart[] messageBodyPart = new BodyPart[emailBody.length];
			for(int i=0;i<emailBody.length;i++){
				messageBodyPart[i] = new MimeBodyPart();
				messageBodyPart[i].setText(emailBody[i]);
				multipart.addBodyPart(messageBodyPart[i]);
			}

			//Set Attachments
			BodyPart[] attachmentBodyPart = new BodyPart[attachmentPath.length];
			for(int i=0;i<attachmentPath.length;i++){
				attachmentBodyPart[i] = new MimeBodyPart();
				DataSource source = new FileDataSource(attachmentPath[i]);
				attachmentBodyPart[i].setDataHandler(new DataHandler(source));
				attachmentBodyPart[i].setFileName(attachmentPath[i]);
				multipart.addBodyPart(attachmentBodyPart[i]);
			}

			// Send the complete message parts
			message.setContent(multipart);

			//Establishing connection with Gmail
			transport.connect();
			
			//Sending the email
			Transport.send(message);

		} catch (MessagingException e) {
			System.out.println("e="+e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//Convert String Email Id's to Internet Addresses
	private static InternetAddress[] getInternetAddresses(String[] emailIds){

		//Creating Internet Addresses for recipient "to"
		String[] recipientList = emailIds;
		InternetAddress[] recipientAddresses = new InternetAddress[recipientList.length];
		int counter = 0;
		for(String recipient : recipientList){
			try {
				recipientAddresses[counter] = new InternetAddress(recipient.trim());
			} catch (AddressException e) {
				e.printStackTrace();
			}
			counter++;
		}
		return recipientAddresses;
	}
	
	//Get value of Key from config.properties file
	public static String getPropValue(String key) 
	{
		FileReader reader = null;
		try {
			reader = new FileReader("./config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		String propValue = prop.getProperty(key);
		return propValue;
	}
	
	//Get Multiple Prop values
	public static String[] getPropValues(String key){
		int totalCount = Integer.parseInt(getPropValue(key+"TotalCount"));
		String[] props = new String[totalCount];
		for(int i=0;i<totalCount;i++){
			props[i] = getPropValue(key + i);
		}
		return props;
	}
	
}
