package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ConfigReader;

public class ArrayPage {
	private WebDriver driver;
	//private WebDriverWait wait;
	String ArrayPage_URL = ConfigReader.getHomePageUrl();
	String tryEditorURL=ConfigReader.getTryEditorpageurl();
	String ArrayPage_ListURL=ConfigReader.getArraysusingListpageurl();
	String QuestionSearchthearrayURL=ConfigReader.getQuestionSearchthearrayurl();

	@FindBy(linkText = "Arrays in Python")
	WebElement arraysinpython_link;

	@FindBy(linkText = "Arrays Using List")
	WebElement ArraysUsingList_link;

	@FindBy(linkText = "Basic Operations in Lists")
	WebElement BasicOperationsinLists_link;

	@FindBy(linkText = "Applications of Array")
	WebElement ApplicationsofArray_link;

	@FindBy(linkText ="Practice Questions")
	WebElement PracticeQuestionslink;

	@FindBy(linkText ="Search the array")
	WebElement searcharraylink;

	@FindBy(linkText ="Max Consecutive Ones")
	WebElement MaxConsecutiveOneslink;

	@FindBy(linkText ="Find Numbers with Even Number of Digits")
	WebElement FindNumberswithEvenNumberofDigitslink;

	@FindBy(linkText ="Squares of  a Sorted Array")
	WebElement SquaresofaSortedArraylink;


	@FindBy(linkText = "Try here>>>")
	WebElement TryHere;

	@FindBy(xpath="//button[text()='Run']")
	WebElement runbtn;

	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitbtn;
	


	public ArrayPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	public void getArrayPageURL()
	{
		driver.get(ArrayPage_URL);
	}
	public void clickOnTryHereLink(String bname, String dsname) {
		//Loggerload.info("click on " + bname + " button on " + dsname);
		TryHere.click();

	}
	public TryEditorPage clickon_Try_Here()
	{
		TryHere.click();
		return new TryEditorPage( driver);
	}
	public ArraysinPythonPage clickon_arraysinpython_link()
	{
		arraysinpython_link.click();
		return new ArraysinPythonPage(driver);
	}

	public ArraysUsingListPage clickon_ArraysUsingList_link()
	{
		ArraysUsingList_link.click();
		return new ArraysUsingListPage(driver);
	}

	public void clickon_BasicOperation_list()
	{
		BasicOperationsinLists_link.click();
		//return new ArraysUsingListPage(driver);
	}
	public void navigateTotryEditor() {

		driver.get(tryEditorURL);

	}
	public void navigateToarraysusinglist() {

		driver.get(ArrayPage_ListURL);

	}
	public void clickPracticeQue() {

		PracticeQuestionslink.click();

	}
	public void clickSearcharray() {

		searcharraylink.click();

	}
	public String getArrayPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void getQuestionsearcharrayurl()
	{
		driver.get(QuestionSearchthearrayURL);
	}

}
