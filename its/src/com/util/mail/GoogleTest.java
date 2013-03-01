package com.util.mail;

import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GoogleTest 
{
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String emailMsgTxt = "Test Message Contents";
	private static final String emailSubjectTxt = "A test from gmail";
	private static final String emailFromAddress = "amol.acura@gmail.com";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private static final String[] sendTo = {"amolash_gadre@yahoo.com"};

	public static void main(String args[]) throws Exception 
	{
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		new GoogleTest().sendSSLMessage(sendTo, emailSubjectTxt,
										emailMsgTxt, emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void sendSSLMessage(String recipients[], String subject, String message, String from) 
	throws MessagingException, IOException
	{
		boolean debug = true;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Session session = Session.getDefaultInstance(props, 
								new javax.mail.Authenticator() 
								{	
									protected PasswordAuthentication getPasswordAuthentication() 
									{
										return new PasswordAuthentication("amol.acura@gmail.com", "coeb2003");
									}
								});
		
		session.setDebug(debug);
		
		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
		
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		
		for (int i = 0; i < recipients.length; i++) 
		{
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		// Setting the Subject and Content Type
		msg.setSubject(subject);
//		msg.setContent(message, "text/plain");
		setContentAndAttachment(msg);
		Transport.send(msg);
	}
	
	private void setContentAndAttachment(Message msg)
	throws MessagingException, IOException
	{
		// create and fill the first message part
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setText("This is a test message with file attachment.");

		// create the second message part
		MimeBodyPart mbp2 = new MimeBodyPart();

		// attach the file to the message
		FileDataSource fds = new FileDataSource("E:\\dcps_issues_1.xls");
		mbp2.setDataHandler(new DataHandler(fds));
		mbp2.setFileName(fds.getName());

		// create the Multipart and add its parts to it
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);
		mp.addBodyPart(mbp2);

		// add the Multipart to the message
		msg.setContent(mp);
		
		// set the Date: header
		msg.setSentDate(new Date());
		
		CountingOutputStream cos = new CountingOutputStream();   
		mbp2.getDataHandler().writeTo(cos);   
		int size = cos.getCount();
		System.out.println("*************** File size: " + size);
	}
}
