package com.canddella.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	
	
	
	public static void sendMail(String mailID, String subject, String content) {

		String senderEmail = "solutionsgympro@gmail.com";
		String senderPassword = "pfrfxrgbjxtikfnt";

		// Recipient's email
		String recipientEmail = mailID;

		// Email properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Create a Session with authentication
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {
			// Create a message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject(subject);
			message.setText(content);

			// Send the message
			Transport.send(message);

			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void sendMailToMultiple(String[] mails, String subject, String content) {

		String senderEmail = "solutionsgympro@gmail.com";
		String senderPassword = "pfrfxrgbjxtikfnt";

		// Recipient's email
		String [] recipientEmails = mails;

		// Email properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Create a Session with authentication
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {
			// Create a message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			InternetAddress [] internetAddresses = new InternetAddress[recipientEmails.length];
			for(int i=0;i<recipientEmails.length;i++)
			{
				internetAddresses[i]= new InternetAddress(recipientEmails[i]);
			}
			message.setRecipients(Message.RecipientType.TO, internetAddresses);
			message.setSubject(subject);
			message.setText(content);

			// Send the message
			Transport.send(message);

			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
