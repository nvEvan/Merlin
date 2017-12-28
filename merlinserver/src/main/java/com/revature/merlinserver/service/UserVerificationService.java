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

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.dao.CodeListDao;
import com.revature.merlinserver.dao.PrivateInfoDao;

/**
 * When a user creates an account this class will send that user a verification email.
 * The verification email will have a generated token link for the user to click.
 * @author Alex
 */
public class UserVerificationService {

	/**
	 * Send the user a verification email.
	 * @param email to send the verification email
	 * @param token for the user
	 * @return true if email sent successfully
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static boolean sendVerification(final String email, final String token) throws InterruptedException, ExecutionException {
		final String password =  System.getenv("MerlinEmail"), gmail = "xarxes.merlin@gmail.com";
		Properties props = new Properties();
		Session session = null;
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		//authenticates the gmail account
		session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmail, password);
			}
		});

		try {
			String link = "", body = "";
			Message message = null;
			
			link = "http://localhost:8085/merlinserver/register/authenticate/" + token;
			body = 
					  "<h3>Welcome to Merlin!</h3>"
					+ "<h4>Click the following link to activate your account:</h4>" 
					+ "<h4><a href=" + link +">" + link + "</a></h4>";

			//form the message details
			message = new MimeMessage(session);
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

	/**
	 * Update the status of a magical user to active.
	 * @param token
	 * @param user
	 */
	public static void updateStatus(MagicalUser user) {
		PrivateInfoDao pd = new PrivateInfoDao();
		CodeListDao cd = new CodeListDao();
		
		//get the private info of the magical user
		pd.open();
		PrivateUserInfo userinfo = pd.getPrivateInfoByUser(user);
		pd.close();
		
		//get the active status
		cd.open();
		CodeList status = cd.getCodeListById(425); //id 425 = active status
		cd.close();
		
		//set the user's status to active
		userinfo.setStatus(status);
		
		//update the user's status
		pd.open();
		pd.update(userinfo);
		pd.close();
	}

	/**
	 * This method will check that the given user is a user that has not yet been verified.
	 * @param user to be checked
	 * @return true if the user is new
	 */
	public static boolean userIsNew(final MagicalUser user) {
		PrivateInfoDao pd = new PrivateInfoDao();
		boolean userIsNew;
		
		pd.open();
		userIsNew = pd.isUserNew(user);
		pd.close();
		
		return userIsNew;
	}
}