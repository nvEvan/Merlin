package com.revature.merlintest.junit;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;

import com.revature.merlinserver.service.UserVerificationService;

public class VerificationTest {
	
	/**
	 * Test that emails are successfully sent
	 */
	@Test
	public void sendEmailTest() {
		String token = UUID.randomUUID().toString();		
		try {
			boolean success = UserVerificationService.sendVerification("merlintest@mail.com", "username", token);
			Assert.assertTrue(success);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}