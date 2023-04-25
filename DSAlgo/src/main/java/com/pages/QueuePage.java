package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

public class QueuePage {
	WebDriver driver = DriverFactory.getDriver();
	public QueuePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	String homepage = ConfigReader.getHomePageUrl();
	String queueurl = ConfigReader.getQueueUrl();
	String queueimplementationpythonurl = ConfigReader.getQueueImplementationPythonUrl();
	String queueimplementationdequeurl = ConfigReader.getQueueimplementationDequeUrl();
	String queueimplementationarrayurl = ConfigReader.getQueueImplementationArrayUrl();
	String queueoperationurl = ConfigReader.getQueueOperationUrl();
	String queuepracticeurl = ConfigReader.getQueuePracticeUrl();
	
	// homepage
		@FindBy(xpath = "//a[contains(text(), 'Data Structures')]")WebElement dropdown;
		@FindBy(xpath = "//a[normalize-space()='Queue']")WebElement dropdown_queue;
		
	// Queue page
		@FindBy(xpath= "//a[contains(text(),'Implementation of Queue in Python')]")WebElement impqinpython;
		@FindBy(xpath= "//a[contains(text(),'Implementation using collections.deque')]")WebElement impqdeque;
		@FindBy(xpath= "//a[contains(text(),'Implementation using array')]")WebElement impqarray;
		@FindBy(xpath= "//a[contains(text(),'Queue Operations')]")WebElement impqop;
		
		@FindBy(xpath= "//a[contains(text(),'Try here>>>')]")WebElement qtry;
		@FindBy(xpath= "//a[contains(text(),'Practice Questions')]")WebElement qpractice;
		@FindBy(xpath = "//textarea[@tabindex='-1']")WebElement editorInput;
		@FindBy(xpath = "//button[@type='button']")WebElement runButton;
		@FindBy(id = "output")WebElement output;
		
		public void dropdown_queue() {
			dropdown.click();
			//Loggerload.info("user clicked on Data Structure dropdown");
			dropdown_queue.click();
			//Loggerload.info("user selected graph from data structures dropdown");
		}
		
		public String getQueuePageTitle() {
			String title = driver.getTitle();
			return title;
		}
		
		public void navigateToHomePage() {
			driver.get(homepage);
			//Loggerload.info("user is in home page");
		}
		public void navigateToQueuePage() {
			driver.get(queueurl);
			//Loggerload.info("user is in Queue page");
		}
		
		public void navigateToQueueInPythonPage() {
			driver.get(queueimplementationpythonurl);
			//Loggerload.info("user is in Queue Implementation in Python page");
		}
		
		public void navigateToQueueImplementationDequePage() {
			driver.get(queueimplementationdequeurl);
			//Loggerload.info("user is in Queue Implementation using collection Deque page");
		}
		
		public void navigateToQueueImplementationArrayPage() {
			driver.get(queueimplementationarrayurl);
			//Loggerload.info("user is in Queue Implementation using Array page");
		}
		
		public void navigateToQueueOperationPage() {
			driver.get(queueoperationurl);
			//Loggerload.info("user is in Queue Operation page");
		}
				
		public void clickOnQueuePracQuesLink() {
			qpractice.click();
			//Loggerload.info("User clicked on Queue Practice Questions link");
		}
		
		public void clickOnQueueTryhereLink() {
			qtry.click();
			//Loggerload.info("User clicked on Queue Try here link");
		}
		
		public void clickOnImplementationUsingCollectionsDequeLink() {
			impqinpython.click();
			//Loggerload.info("User clicked on Implementation using collections.deque link");
		}
		
		public void clickOnImplementationOfQueueinPythonLink() {
			impqdeque.click();
			//Loggerload.info("User clicked on Implementation Of Queue in Python link");
		}
		
		public void clickOnImplementationUsingArrayLink() {
			impqarray.click();
			//Loggerload.info("User clicked on Implementation of Queue Using Array link");
		}
		
		public void clickOnQueueOperationsLink() {
			impqop.click();
			//Loggerload.info("User clicked on Queue Operations link");
		}
		
}
