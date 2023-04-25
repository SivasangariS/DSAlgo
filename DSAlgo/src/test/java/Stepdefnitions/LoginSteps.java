package Stepdefnitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.qa.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegisterPage;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
	
	@Given("The user is in the Sign in page")
	public void the_user_is_in_the_sign_in_page() {
		homePage.clickOnSignLink();
	}

	@When("The user enters a valid {string} and {string}")
	public void the_user_enters_a_valid_and(String username, String password) {
		loginPage.enterCredentials(username, password);
	}

	// Good Example for writing different assertions for both valid and invalid test cases
	@Then("click login button to verify")
	public void click_login_button_to_verify() {
		boolean isLoginSuccessful=loginPage.doLogin();
		if (isLoginSuccessful) {
			System.out.println("Assert that the user is redirected to the home page");
			assertEquals("https://dsportalapp.herokuapp.com/home", DriverFactory.getDriver().getCurrentUrl(), "User not directed to homePage");
		} else  {
			System.out.println("Assert that an error message is displayed on the login page");
			assertTrue(loginPage.isValidationMessageDisplayed() ,"Validation message is empty");
		}
	}



	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
		loginPage.clickRegisterlink();
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		String Actual_URL=DriverFactory.getDriver().getCurrentUrl();
		String Expected_URL=registerPage.validateRegisterPageURL();
		assertEquals(Actual_URL, Expected_URL, "User is in RegisterPage");

	}

	// Scenario 3 invalid username and password from scenario outline

	@Given("The user is on signin page")
	public void the_user_is_on_signin_page() {
		homePage.clickOnSignLink();
	}

	@When("The user enter invalid {string} and {string}")
	public void the_user_enter_invalid_and(String username, String password) {
		loginPage.enterCredentials(username, password);

	}

	//Scenario 4 invalid input from excel file
	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetName, Integer RowNumber) {

		List<Map<String,String>> testdata =  ExcelReader.readTestData(sheetName);
		String UserName=testdata.get(RowNumber).get("UserName");
		String  Password=testdata.get(RowNumber).get("Password");
		loginPage.enterCredentials(UserName, Password);

	}
	//scenario 5 for sign out link

	@Given("The user is in the Home page with valid  log in")
	public void the_user_is_in_the_home_page_with_valid_log_in() {
		//I'm just writing code using properties file, if not we can provide values directly in the feature file likeGiven The user is on signin page with valid username "Numpysdet84" and password "sdet84batch"
		homePage.clickOnSignLink();
		//String userName = prop.getProperty("username");
		//String passWord = prop.getProperty("password");
		loginPage.enterCredentials("Numpysdet84", "sdet84batch");
		loginPage.doLogin();
	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage()
	{ 
     String HomePageTitle= homePage.getPageTitle();
		assertEquals(HomePageTitle, "NumpyNinja");
	}
	
}
