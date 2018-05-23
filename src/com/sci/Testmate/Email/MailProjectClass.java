package com.sci.Testmate.Email;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import com.sci.Testmate.Common.Constants;


public class MailProjectClass {
	public static void sendmail() {
	    final String username = "sudheer.medasani@sciits.com";
	    final String password = "sudheer@143";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "Outlook.office365.com");
	    props.put("mail.smtp.port", "587");	    

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("sudheer.medasani@sciits.com"));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("sudheer.medasani@sciits.com"));
	        message.setSubject("VNS Results");
	        message.setText("Extent Report Results");

	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        String fileName = System.getProperty("user.dir")+"//ExtResults//TestResults-"+Constants.gettime()+".html";
	        messageBodyPart = new MimeBodyPart();
	        DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName.substring(fileName.lastIndexOf("/")+ 1, fileName.length()));
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

	        message.setContent(multipart);

	        System.out.println("Mail Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }

	}

