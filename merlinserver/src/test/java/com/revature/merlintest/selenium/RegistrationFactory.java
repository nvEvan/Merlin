package com.revature.merlintest.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Factory class used to hold the web elements of the registration page
 * @author Alex
 */
public class RegistrationFactory {
	
	@FindBy(id="emailInput")
	private WebElement emailInput;
	
	@FindBy(id="usernameInput")
	private WebElement usernameInput;
	
	@FindBy(id="password1Input")
	private WebElement password1Input;
	
	@FindBy(id="password2Input")
	private WebElement password2Input;
	
	@FindBy(id="firstNameInput")
	private WebElement firstNameInput;
	
	@FindBy(id="lastNameInput")
	private WebElement lastNameInput;
	
	@FindBy(id="addressInput")
	private WebElement addressInput;
	
	@FindBy(id="stateInput")
	private WebElement stateInput;
	
	@FindBy(id="cityInput")
	private WebElement cityInput;
	
	@FindBy(id="phoneNumberInput")
	private WebElement phoneNumberInput;
	
	@FindBy(id="roleInput")
	private WebElement roleInput;
	
	@FindBy(id="registerInput")
	private WebElement registerInput;
	
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
		this.password2Input.sendKeys(password2);
	}	
	
	public void selectCity(String city) {
		Select sel = new Select(cityInput);
		sel.selectByVisibleText(city);
	}
	
	public void selectState(String state) {
		Select sel = new Select(stateInput);
		sel.selectByVisibleText(state);
	}
	
	public void selectRole(String role) {
		Select sel = new Select(roleInput);
		sel.selectByVisibleText(role);
	}
	
	public void inputPhoneNumber(String phoneNumber) {
		phoneNumberInput.sendKeys(phoneNumber);
	}
	
	public void register() {
		registerInput.click();
	}

	public void inputAddress(String address) {
		addressInput.sendKeys(address);		
	}

	public void inputFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
}