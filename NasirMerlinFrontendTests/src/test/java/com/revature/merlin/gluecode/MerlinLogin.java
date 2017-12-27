package com.revature.merlin.gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MerlinLogin {
	
	private static WebDriver driver;
	
	@Given("^I am the login page of Merlin$")
	public void i_am_the_login_page_of_Merlin() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://localhost:4200/home");
	}

	@When("^I login with my \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_my_and(String username, String password) throws Throwable {
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    
	}

	@Then("^I will be directed to the login page$")
	public void i_will_be_directed_to_the_login_page() throws Throwable {
	    driver.findElement(By.id("login")).click();

	}
	
	@After
	public void endResults(){
		driver.quit();
	}



}
