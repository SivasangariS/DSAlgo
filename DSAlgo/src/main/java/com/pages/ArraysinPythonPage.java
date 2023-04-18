package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArraysinPythonPage {

private WebDriver driver;
	
	@FindBy(linkText = "Try here>>>")
	WebElement TryHere;
	
	
	public ArraysinPythonPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public TryEditorPage clickon_Try_Here()
	{
		TryHere.click();
		return new TryEditorPage(driver);
	}
	
}
