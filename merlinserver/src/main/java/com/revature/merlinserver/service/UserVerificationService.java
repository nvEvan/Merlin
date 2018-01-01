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
	public static boolean sendVerification(final String email, final String userName, final String token) throws InterruptedException, ExecutionException {
		final String password =  System.getenv("MerlinEmail"), gmail = "xarxes.merlin@gmail.com", host = System.getenv("merlinhost");
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

			link = host + "merlinserver/rest/register/authenticate/" + token;
			body = 
					"<h3>Welcome to Merlin, " + userName + "!</h3>"
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
	 * Update the status of a magical user.
	 * Apprentice's status goes from 'NEW' to 'ACTIVE'
	 * Adept's status goes from 'NEW' to 'PENDING', because they must next be verified by a wizard.
	 * @param user to be updated
	 */
	public static void updateStatus(MagicalUser user) {
		PrivateInfoDao pd = new PrivateInfoDao();
		CodeListDao cd = new CodeListDao();
		CodeList status = null;
		PrivateUserInfo userinfo = null;
		
		//get the private info of the magical user
		pd.open();
		cd.setSession(pd.getSession());
		userinfo = pd.getPrivateInfoByUser(user);
		
		//is it an adept or apprentice updating their account
		if (userinfo.getRole().getId() == 434) {
			status = cd.getCodeListById(424); //pending status
			userinfo.setStatus(status);
			
		} else {
			status = cd.getCodeListById(425); //active status
			userinfo.setStatus(status);
		}

		//set the user's status to active
		userinfo.setStatus(status);

		//update the user's status
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