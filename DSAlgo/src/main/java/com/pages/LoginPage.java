package com.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.util.ConfigReader;

public class LoginPage {
	
	private WebDriver driver;
	String LoginPage_URL = ConfigReader.getLoginPageUrl();


	// 1. By Locators: OR
	@FindBy(id="id_username")
	WebElement UserName;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement Loginbtn;
	@FindBy(linkText = "Register!")
	WebElement Registerlink;
	@FindBy(xpath="//div[text()[normalize-space()='Invalid Username and Password']]")
	WebElement ErrorMsg;

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	
	public void enterCredentials(String username, String password) {
		UserName.clear();
		UserName.sendKeys(username);
		Password.clear();
		Password.sendKeys(password);
		
	}
	public String VerifyLoginPage()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void getLoginPage()
	{
		driver.get(LoginPage_URL);
	}
	public boolean doLogin() {
		
		Loginbtn.click();
		if (driver.getCurrentUrl().equals("https://dsportalapp.herokuapp.com/home")) {
	        return true; // The login was successful
	    } else {
	        return false; // The login was unsuccessful
	    }

	
}
	public  boolean isValidationMessageDisplayed()
	{
		//password1.sendKeys(" ");
		String Validation_Message  = UserName.getAttribute("validationMessage");
		System.out.println("####### Validation_Message Username#########"+Validation_Message);
		String Validation_Message1  = Password.getAttribute("validationMessage");
		System.out.println("####### Validation_Message Password#########" +Validation_Message1);
		if (!Validation_Message.isEmpty() || !Validation_Message1.isEmpty()) {
	        return true;
	    } else {
	        return false;
	    }
			}
	
	
	
	public boolean isErrorMessageDisplayed() {
        try {
            return ErrorMsg.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	public RegisterPage clickRegisterlink()
	{
		Registerlink.click();
		return new RegisterPage(driver);
	}


}
