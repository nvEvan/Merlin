package com.revature.merlintest.testng;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;

import com.revature.merlinserver.service.UserVerificationService;

public class VerificationTest {
	
	@Test
	public void emailVerificationTest() {
		try {
			UserVerificationService.sendVerification("merlintest@mail.com", "bobber");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}