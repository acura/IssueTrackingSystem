package com.util.mail;

/*
Some SMTP servers require a username and password authentication before you
can use their Server for Sending mail. This is most common with couple
of ISP's who provide SMTP Address to Send Mail.

This Program gives any example on how to do SMTP Authentication
(User and Password verification)

Author : Amol Gadre
Copyright 2011 Acura Softwares
*/

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 ** To use this program, change values for the following three constants,
 ** SMTP_HOST_NAME -- Has your SMTP Host Name
 ** SMTP_AUTH_USER -- Has your SMTP Authentication UserName
 ** SMTP_AUTH_PWD  -- Has your SMTP Authentication Password

 ** Next change values for fields:
 ** emailMsgTxt  -- Message Text for the Email
 ** emailSubjectTxt  -- Subject for email
 ** emailFromAddress -- Email Address whose name will appears as "from" address

 ** Next change value for "emailList".
 ** This String array has List of all Email Addresses to Email Email needs to be sent to.

 ** Next to run the program, execute it as follows,
 ** SendMailUsingAuthentication authProg = new SendMailUsingAuthentication();
 **/

public class SendMailUsingAuthentication
{
	private static final String SMTP_HOST_NAME = "smtp.acurasoftwares.com";
	private static final String SMTP_AUTH_USER = "amol.gadre@acurasoftwares.com";
	private static final String SMTP_AUTH_PWD  = "xxx";

	private static final String emailMsgTxt      = "Online Order Confirmation Message. Also include the Tracking Number.";
	private static final String emailSubjectTxt  = "Order Confirmation Subject";
	private static final String emailFromAddress = "amol.gadre@acurasoftwares.com";

	// Add List of Email address to who email needs to be sent to
	private static final String[] emailList = {"swapnil.rajput@acurasoftwares.com", "info@acurasoftwares.com"};

	public static void main(String args[]) throws Exception
	{
		SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
		smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void postMail(String recipients[ ], String subject,
                         String message , String from) throws MessagingException
	{
		boolean debug = false;

		//Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
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
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}

	/**
	* SimpleAuthenticator is used to do simple authentication
	* when the SMTP server requires it.
	*/
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{
	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = SMTP_AUTH_USER;
	        String password = SMTP_AUTH_PWD;
	        return new PasswordAuthentication(username, password);
	    }
	}

}
