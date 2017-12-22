package com.revature.merlinserver.service;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import com.revature.merlinserver.beans.Token;

/**
 * When a user creates an account this class will send that user a verification email.
 * The verification email will have a generated token link for the user to click.
 * @author Alex
 */
public class UserVerificationService {

	/**
	 * Send the user a verification email.
	 * @param email to send the verification email
	 * @param token object
	 * @return true if email sent successfully
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static boolean sendVerification(String email, Token token) throws InterruptedException, ExecutionException {
		String password =  System.getenv("MerlinEmail");
		final String gmail = "xarxes.merlin@gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		//authenticates the gmail account
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmail, password);
			}
		});

		try {
			String link = "http://localhost:8085/merlinserver/register/authenticate/" + token.getToken();
			String body = 
					  "<h3>Welcome to Merlin!</h3>"
					+ "<h4>Click the following link to activate your account:</h4>" 
					+ "<h4><a href=" + link +">"+link+"</a></h4>";

			//form the message details
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreply@merlin-2a1ae.firebaseapp.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Merlin Account Verification");
			message.setContent(body, "text/html");

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}