package com.revature.merlintest.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Factory class used to hold the web elements of the registration page
 * @author Alex
 */
public class RegistrationFactory {
	
	@FindBy(id="emailInput")
	WebElement emailInput;
	
	@FindBy(id="usernameInput")
	WebElement usernameInput;
	
	@FindBy(id="password1Input")
	WebElement password1Input;
	
	@FindBy(id="password2Input")
	WebElement password2Input;
	
	@FindBy(id="firstName")
	WebElement firstNameInput;
	
	@FindBy(id="lastName")
	WebElement lastNameInput;
	
	@FindBy(id="address")
	WebElement addressInput;
	
	@FindBy(id="stateInput")
	WebElement stateInput;
	
	@FindBy(id="cityInput")
	WebElement cityInput;
	
	@FindBy(id="phoneNumber")
	WebElement phoneNumberInput;
	
	@FindBy(id="registerInput")
	WebElement registerInput;
	
	/**
	 * 
	 * @param driver
	 */
	public RegistrationFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username) {
		this.usernameInput.sendKeys(username);
	}
	
	public void inputEmail(String email) {
		this.emailInput.sendKeys(email);
	}
	
	public void inputPassword1(String password1) {
		this.password1Input.sendKeys(password1);
	}
	
	public void inputPassword2(String password2) {
		this.password1Input.sendKeys(password2);
	}
	
	
	
	public void inputCity(String city) {

	}
	
	

}