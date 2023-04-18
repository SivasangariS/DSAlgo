package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String validateRegisterPageTitle() {
		return driver.getCurrentUrl();
	}
}
