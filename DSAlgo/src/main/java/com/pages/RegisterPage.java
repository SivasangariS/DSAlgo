package com.pages;


//import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;

public class RegisterPage {
	private WebDriver driver;
	//two methods: String App_URL = cg.init_prop().getProperty("url");
	String RegisterPAGE_URL = ConfigReader.getRegisterPageUrl();
	//Page Factory - OR:
	@FindBy(id="id_username")
	WebElement username;

	@FindBy(id="id_password1")
	WebElement password1;

	@FindBy(id="id_password2")
	WebElement password2;

	@FindBy(xpath="//input[@value='Register']")
	WebElement Registerbtn;

	@FindBy(linkText = "Login")
	WebElement loginlink;

	@FindBy(xpath="//div[text()[normalize-space()='password_mismatch:The two password fields didn’t match.']]")
	WebElement Errormsg;	

	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Actions:

	public void getRegisterPage()
	{
		driver.get(RegisterPAGE_URL);
	}
	public String validateRegisterPageURL(){
		return driver.getCurrentUrl();
	}

	public void clickRegisterbtn()
	{
		Registerbtn.click();

	}

	public void sendUserName(String uname)
	{
		username.clear(); 
		username.sendKeys(uname);
	}

	public void sendPassword1(String pwd1)
	{
		password1.clear();
		password1.sendKeys(pwd1);
	}

	public void sendPassword2(String pwd2)
	{
		password2.clear();
		password2.sendKeys(pwd2);
	}
	public boolean isUserNameEmpty()
	{			
		// Text box is not empty or not required

		/* if(username.getAttribute("required").isEmpty())
			 {
				 return true;
				}
			return false; */

		String requiredAttribute = username.getAttribute("required");
		if (requiredAttribute != null && requiredAttribute.equals("true")) {
			String usernameText = username.getText();
			if (usernameText == null || usernameText.isEmpty()) {
				return true; // Username is empty and required
			}
		}
		return false; // Username is not empty or not required
	}

	public boolean isPassword1Empty()
	{
		String requiredAttribute = password1.getAttribute("required");
		if (requiredAttribute != null && requiredAttribute.equals("true")) {
			String password1Text = password1.getText();
			if (password1Text == null || password1Text.isEmpty()) {
				return true; // Password is empty and required
			}
		}
		return false; // Password is not empty or not required
	}

	public boolean isPassword2Empty()
	{
		String requiredAttribute = password2.getAttribute("required");
		if (requiredAttribute != null && requiredAttribute.equals("true")) {
			String password2Text = password2.getText();
			if (password2Text == null || password2Text.isEmpty()) {
				return true; // Password is empty and required
			}
		}
		return false; // Password is not empty or not required
	}

	public  String getValidationMessage_username()
	{
		//username.sendKeys(""); 
		String Validation_Message = username.getAttribute("validationMessage");
		System.out.println("Validation Message is " + Validation_Message);
		return Validation_Message;
	}

	public  String getValidationMessage_password1()
	{
		//password1.sendKeys(" ");
		String Validation_Message  = password1.getAttribute("validationMessage");
		System.out.println("Validation Message for pwd1 is " + Validation_Message);
		return Validation_Message;
	}
	public  String getValidationMessage_password2()
	{
		//password2.sendKeys("");
		
		String Validation_Message = password2.getAttribute("validationMessage");
		return Validation_Message;
	}
	public String getErrorMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.visibilityOf(Errormsg));
		String errormessage= Errormsg.getText();
		return errormessage;
	}

	public void enterUserName(DataTable UserRegiserData)
	{
		List<Map<String, String>> data = UserRegiserData.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String usernameValue = row.get("username");
			try {
				WebDriverWait wait = new WebDriverWait(driver,(30));
				wait.until(ExpectedConditions.visibilityOf(username)); 
				username.sendKeys(usernameValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void enterPassword(DataTable UserRegiserData)
	{
		List<Map<String, String>> data = UserRegiserData.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String passwordValue = row.get("password");
			WebDriverWait wait = new WebDriverWait(driver,(30));
			wait.until(ExpectedConditions.visibilityOf(password1)); 
			
			password1.sendKeys(passwordValue);

		}
	}

	public void enterPasswordconfirmation(DataTable UserRegiserData)
	{
		List<Map<String, String>> data = UserRegiserData.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String password2Value = row.get("password confirmation");
			password2.sendKeys(password2Value);

		}
	}


}
