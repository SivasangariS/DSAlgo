package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ConfigReader;

public class TryEditorPage {
	private WebDriver driver;
	
	@FindBy(xpath="//textarea[@id='editor']/following-sibling::div[1]")
	WebElement Textarea;
	@FindBy(xpath="//button[text()='Run']")
	WebElement Run;
	@FindBy(xpath="//pre[@id='output']")
	WebElement Result;
	String tryEditorURL=ConfigReader.getTryEditorpageurl();
	
	public TryEditorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void getTotryEditorURL() {

		driver.get(tryEditorURL);

	}
	
	public void clickonRunbtn()
	{
		Run.click();
	}
	public void SendCodeonTextArea(List<String> codeList) {
		Actions act= new Actions(driver);
		// TODO Auto-generated method stub
		for (String code : codeList) {
			
			act.moveToElement(Textarea).sendKeys(code).build().perform();
			act.moveToElement(Textarea).sendKeys("\n").build().perform();;
	    }
		
		

	}
	public boolean isResultdisplayed()
	{
     return Result.isDisplayed();
	}
	
	public String getResult()
	{
		String result=Result.getText();
		return result;
	}
	public String getErrorMessage() {
		String errorMsg = driver.switchTo().alert().getText();
		System.out.println("###########Alert Message is ############### "+ errorMsg );
		driver.switchTo().alert().accept();
		return errorMsg;

	}
}
