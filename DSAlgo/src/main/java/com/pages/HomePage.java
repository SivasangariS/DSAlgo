package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ConfigReader;


public class HomePage {


	private WebDriver driver;
 	//two methods: String App_URL = cg.init_prop().getProperty("url");
	String HomePAGE_URL = ConfigReader.getHomePageUrl();
	


	@FindBy(xpath="//a[@class='nav-item nav-link']/following-sibling::a[1]")
	//@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath ="//a[contains(text(),'Register')]")
	WebElement RegisterLink;

	@FindBy(linkText = "Sign in")
	WebElement SigninLink;

	@FindBy(xpath="//div[text()[normalize-space()='You are not logged in']]")
	private
	WebElement UserNotLoginMsg;

	@FindBy(xpath="//div[text()[normalize-space()='You are logged in']]")
	WebElement LoginMsg;

	@FindBy(xpath="//div[text()[normalize-space()='Logged out successfully']]")
	WebElement LogOutMsg;

	@FindBy(linkText = "Sign out")
	WebElement Signout;

	@FindBy (xpath="//a[@href='data-structures-introduction']")
	WebElement getstart_datastructures;
	@FindBy (xpath="//a[@href='array']")
	WebElement getstart_array;
	@FindBy (xpath="//a[@href='linked-list']")
	WebElement getstart_linkedlist;
	@FindBy (xpath="//a[@href='stack']")
	WebElement getstart_stack;
	@FindBy (xpath="//a[@href='queue']")
	WebElement getstart_queue;
	@FindBy (xpath="//a[@href='tree']")
	WebElement getstart_tree;
	@FindBy (xpath="//a[@href='graph']")
	WebElement getstart_graph;

	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown;

	@FindBy(xpath="//div[@class='dropdown-menu show']/a[1]")
	WebElement Arraysdropdown;

	@FindBy(xpath="//div[@class='dropdown-menu show']/a[2]")
	WebElement LinkedListdropdown;

	@FindBy(xpath="//div[@class='dropdown-menu show']/a[3]")
	WebElement Stackdropdown;

	@FindBy(xpath="//div[@class='dropdown-menu show']/a[4]")
	WebElement Queuedropdown;

	@FindBy(xpath="//div[@class='dropdown-menu show']/a[5]")
	WebElement Treedropdown;

	@FindBy(xpath="//div[@class='dropdown-menu show']/a[6]")
	WebElement Graphdropdown;



	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String gethomepageurl() {

		driver.get(HomePAGE_URL);
		return HomePAGE_URL;

	}


	public String VerifyHomePageTitle() {

		String title = driver.getTitle();
		return title;

	}
	public String verifyHomePageURL(){
		return driver.getCurrentUrl();

	}


	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}

	public RegisterPage clickOnRegisterLink(){
	
		RegisterLink.click();
		return new RegisterPage(driver);

	}

	public LoginPage clickOnSignLink(){
		SigninLink.click();
		return new LoginPage(driver);

	}
	public String verifySigninPageURL()
	{
		return driver.getCurrentUrl();
	}

	public String verifyRegisterPageURL()
	{
		return driver.getCurrentUrl();
	}
	public boolean islogoutmsgdisplayed()
	
	{
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.visibilityOf(LogOutMsg)).isDisplayed();
		
		boolean logout_ms_display= LogOutMsg.isDisplayed();
		return logout_ms_display;
		
	}

	public void clickonSignOutLink()
	{

		Signout.click();
		
	}
	public boolean isSignoutDisplayed()
	{
		return(Signout.isDisplayed());
	}
	public void getStarted_home(String string) {

		switch (string) {
		case "Datastructures":
			System.out.println("Click link on DS");
			getstart_datastructures.click();
			break;
		case "Arrays":

			getstart_array.click();
			break;
		case "Linkedlist":

			getstart_linkedlist.click();
			break;
		case "Stack":

			getstart_stack.click();
			break;
		case "Queue":

			getstart_queue.click();
			break;
		case "Tree":

			getstart_tree.click();
			break;
		case "Graph":

			getstart_graph.click();
			break;
		}
	}

	// Dropdown
	public void clickdropdown(String string) {

		dropdown.click();
		switch (string) {
		case "Arrays":

			Arraysdropdown.click();
			break;
		case "Linkedlist":
			LinkedListdropdown.click();

			break;
		case "Stack":
			Stackdropdown.click();
			break;
		case "Queue":
			Queuedropdown.click();
			break;
		case "Tree":
			Treedropdown.click();
			break;
		case "Graph":
			Graphdropdown.click();
			break;
		}

	}

	public String getUserNotLoginMsg() {
		String str_actual= UserNotLoginMsg.getText();
		return str_actual;

	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickongetstart_DS()
	{
		getstart_datastructures.click();
	}




}
