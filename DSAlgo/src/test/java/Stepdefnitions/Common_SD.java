package Stepdefnitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.qa.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Common_SD {
	
		private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		private HomePage homePage = new HomePage(DriverFactory.getDriver());
		
		private static final Logger LOGGER=LogManager.getLogger(Common_SD.class);
		@Given("The user is on Signin page of DS Algo portal")
		public void the_user_is_on_signin_page_of_ds_algo_portal() {
			LOGGER.info("User is on Signin Page and check the title");
			loginPage.getLoginPageTitle();
			String expectedTitle = loginPage.VerifyLoginPage();
			String actualTitle = DriverFactory.getDriver().getCurrentUrl();
			assertEquals(expectedTitle, actualTitle);
		}


		@When("The user enter valid {string} and {string}")
		public void the_user_enter_valid_and(String username, String password) {
			loginPage.enterCredentials(username, password);
		}
		@When("The user click on login button")
		public void the_user_click_on_login_button() {
			boolean isLoginSuccessful=loginPage.doLogin();
			if (isLoginSuccessful) {
				System.out.println("Assert that the user is redirected to the home page");
				assertEquals("https://dsportalapp.herokuapp.com/home", DriverFactory.getDriver().getCurrentUrl(), "User not directed to homePage");
			} else  {
				System.out.println("Assert that an error message is displayed on the login page");
				assertTrue(loginPage.isValidationMessageDisplayed() ,"Validation message is empty");
			}
		}
		
		@Given("The user is on the home page after logged in")
		public void the_user_is_on_the_home_page_after_logged_in() {
			homePage.clickOnSignLink();
			loginPage.enterCredentials("Numpysdet84", "sdet84batch");
			loginPage.doLogin();
		}



}
