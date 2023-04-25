package Stepdefnitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;


import com.qa.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.RegisterPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_SD {

	RegisterPage registerPage= new RegisterPage(DriverFactory.getDriver());
	HomePage homePage= new HomePage(DriverFactory.getDriver());

@Given("The user opens Register Page")
public void the_user_opens_register_page() {
	System.out.println("##### User enters Register Page######");
	registerPage.getRegisterPage();
}

@When("The user clicks {string} button with all fields empty")
public void the_user_clicks_button_with_all_fields_empty(String registerbtn) {
	registerPage.clickRegisterbtn();
}

@Then("It should display an error {string} below Username textbox")
public void it_should_display_an_error_below_username_textbox(String HTMLValidation_Message) {
    String actual_ErrorMessage= registerPage.getValidationMessage_username();
   System.out.println(" ######" +actual_ErrorMessage);
   //assertTrue(registerPage.isUserNameEmpty(), "Username Field is Empty - required attribute is validated");
  assertEquals(actual_ErrorMessage, HTMLValidation_Message);
   
  }
//****************Code for Scenario 2 only username , other fields empty*******************************//

@When("The user clicks {string} button after entering username with other fields empty")
public void the_user_clicks_button_after_entering_username_with_other_fields_empty(String string, DataTable dataTable) {
	List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	// Get the value of the Username field from the DataTable
	String usernameValue = data.get(0).get("username");
	// Find the Username textbox element and enter the value
	registerPage.sendUserName(usernameValue);
	// Click the Register button
	registerPage.clickRegisterbtn();

}

@Then("It should display an error {string} below Password textbox")
public void it_should_display_an_error_below_password_textbox(String HTMLValidation_Message) {
	 String actual_ErrorMessage= registerPage.getValidationMessage_password1();
	   System.out.println(" ######" +actual_ErrorMessage);
	   assertTrue(registerPage.isPassword1Empty(), "Password Field is Empty - required attribute is validated");
	  assertEquals(actual_ErrorMessage, HTMLValidation_Message);
}

//****************Code for Scenario 3 only username , password1 and password2 is empty*******************************//

@When("The user clicks {string} button after entering {string} and {string} with Password Confirmation field empty")
public void the_user_clicks_button_after_entering_and_with_password_confirmation_field_empty(String registerbtn, String username, String password1, io.cucumber.datatable.DataTable dataTable) {
	registerPage.enterUserName(dataTable);
	registerPage.enterPassword(dataTable);
	registerPage.clickRegisterbtn();

}

@Then("It should display an error {string} below Password Confirmation textbox")
public void it_should_display_an_error_below_password_confirmation_textbox(String HTMLValidation_Message) {
	String actual_ErrorMessage= registerPage.getValidationMessage_password2();
	   System.out.println(" ######" +actual_ErrorMessage);
	   assertTrue(registerPage.isPassword1Empty(), "Password Field is Empty - required attribute is validated");
	//  assertEquals(actual_ErrorMessage, HTMLValidation_Message);
	  org.junit.Assert.assertEquals(actual_ErrorMessage, HTMLValidation_Message);
    
}

//***********code for scenario 4 username with special characters*********************//

@When("The user enters a {string} with characters other than Letters, digits and {string}")
public void the_user_enters_a_with_characters_other_than_letters_digits_and(String username, String specialcharacters,io.cucumber.datatable.DataTable dataTable) {
	registerPage.enterUserName(dataTable);
	registerPage.enterPassword(dataTable);
	registerPage.enterPasswordconfirmation(dataTable);
	registerPage.clickRegisterbtn();
    
}

@Then("It should display an error message {string}")
public void it_should_display_an_error_message(String errormessage) {
	String actual_ErrorMessage= registerPage.getErrorMessage();
	 System.out.println(" ######" +actual_ErrorMessage);
	 assertEquals(actual_ErrorMessage, errormessage);
	 // assertEquals(actual_ErrorMessage, "password_mismatch:The two password fields didn’t match.");
	 
}

//***********code for scenario 5 username already exsits*********************//

@When("The user enters a valid existing {string}\"with \"password\" and \"password confirmation\"")
public void the_user_enters_a_valid_existing_with_password_and_password_confirmation(String string, io.cucumber.datatable.DataTable dataTable) {
  registerPage.enterUserName(dataTable);
  registerPage.enterPassword(dataTable);
  registerPage.enterPasswordconfirmation(dataTable);
  registerPage.clickRegisterbtn();
}

//************code for scenario 6 *****************//
// The step "The user clicks "Register" button after entering valid "username" and different passwords in "password" and "password confirmation" fields" is undefined. You can implement it using the snippet(s) below:

@When("The user clicks {string} button after entering valid {string} and different passwords in {string} and {string} fields")
public void the_user_clicks_button_after_entering_valid_and_different_passwords_in_and_fields(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {
    registerPage.enterUserName(dataTable);
    registerPage.enterPassword(dataTable);
    registerPage.enterPasswordconfirmation(dataTable);
    registerPage.clickRegisterbtn();
}
//********code for scenario 7 The user enters a valid username and password with characters less than 8************************//
@When("The user enters a valid username and password with characters less than {int}")
public void the_user_enters_a_valid_username_and_password_with_characters_less_than(Integer int1, io.cucumber.datatable.DataTable dataTable) {
	registerPage.enterUserName(dataTable);
	registerPage.enterPassword(dataTable);
	registerPage.enterPasswordconfirmation(dataTable);
	registerPage.clickRegisterbtn();

}

//code for scenario 8: The step "The user enters a valid "username" and "password" with only numbers" is undefined. You can implement it using the snippet(s) below:

@When("The user enters a valid {string} and {string} with only numbers")
public void the_user_enters_a_valid_and_with_only_numbers(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	registerPage.enterUserName(dataTable);
	registerPage.enterPassword(dataTable);
	registerPage.enterPasswordconfirmation(dataTable);
	registerPage.clickRegisterbtn();
   
}

//code for scenario 9 The step "The user enters a valid "username" and "password" similar to username"


@When("The user enters a valid {string} and {string} similar to username")
public void the_user_enters_a_valid_and_similar_to_username(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
  registerPage.enterUserName(dataTable);
  registerPage.enterPassword(dataTable);
  registerPage.enterPasswordconfirmation(dataTable);
  registerPage.clickRegisterbtn();
}

//code for scenario 10 : The step "The user enters a valid "username" and commonly used password "password"" is undefined. You can implement it using the snippet(s) below:

@When("The user enters a valid {string} and commonly used password {string}")
public void the_user_enters_a_valid_and_commonly_used_password(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	registerPage.enterUserName(dataTable);
	  registerPage.enterPassword(dataTable);
	  registerPage.enterPasswordconfirmation(dataTable);
	  registerPage.clickRegisterbtn();
}




//code for scenario 11 valid data
@When("The user enters a valid {string} and {string} and {string}")
public void the_user_enters_a_valid_and_and(String username, String password, String passwordconfirmation, DataTable UserRegisterdata) {
registerPage.enterUserName(UserRegisterdata);
registerPage.enterPassword(UserRegisterdata);
registerPage.enterPasswordconfirmation(UserRegisterdata);
registerPage.clickRegisterbtn();
}
@Then("The user should be redirected to Homepage with the message {string}")
public void the_user_should_be_redirected_to_homepage_with_the_message(String successmsg) {
String expectedURL=DriverFactory.getDriver().getCurrentUrl();
String actualURL=homePage.gethomepageurl();
assertEquals(actualURL,expectedURL);
}





	
}
