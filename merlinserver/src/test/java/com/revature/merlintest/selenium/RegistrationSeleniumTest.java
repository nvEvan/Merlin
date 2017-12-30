package com.revature.merlintest.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Automated test of registering a new user.
 * @author Alex
 */
public class RegistrationSeleniumTest {

	/**Set a max wait of 7 seconds for elements to show.*/
	private static final long TimeOut = 7;
	private static WebDriver driver;
	private static String url = "http://localhost:4200/register";

	public static void main(String...args) {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);	
		driver.get(url);
		
		//Create our registration factory holding all web elements and methods
		RegistrationFactory rf = new RegistrationFactory(driver);
		
		//Input all of the user information
		rf.selectState("California");
		rf.selectCity("Oakland");
		rf.inputUsername("3:38PM");
		rf.inputEmail("merlintest@mail.com");
		rf.inputFirstName("new");
		rf.inputLastName("user");
		rf.inputPassword1("123");
		rf.inputPassword2("123");
		rf.inputPhoneNumber("123123123");
		rf.selectRole("APPRENTICE");
		rf.inputAddress("merlin");
		rf.register();
	}
}