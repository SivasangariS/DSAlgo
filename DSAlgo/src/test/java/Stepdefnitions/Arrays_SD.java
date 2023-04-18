package Stepdefnitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.qa.factory.DriverFactory;
import com.pages.ArrayPage;
import com.qa.pages.ArraysUsingListPage;
import com.pages.ArraysinPythonPage;
import com.qa.pages.BasicOperationPage;
import com.pages.HomePage;
import com.qa.pages.LoginPage;
import com.pages.RegisterPage;
import com.pages.StartPage;
import com.pages.TryEditorPage;
import com.qa.util.CodeReader;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Arrays_SD {


	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private StartPage startPage = new StartPage(DriverFactory.getDriver());
	private RegisterPage registerPage= new RegisterPage(DriverFactory.getDriver());
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private ArrayPage arrayPage= new ArrayPage(DriverFactory.getDriver());
	private ArraysinPythonPage arrayPythonPage= new ArraysinPythonPage(DriverFactory.getDriver());
	private ArraysUsingListPage arraylistnPage= new ArraysUsingListPage(DriverFactory.getDriver());
	private TryEditorPage tryeditorPage= new TryEditorPage(DriverFactory.getDriver());
	private BasicOperationPage basicoperationPage = new BasicOperationPage(DriverFactory.getDriver());


	@Given("The user is on sign in Page")
	public void the_user_is_on_sign_in_page() {
		startPage.getdsalgopageurl();
		startPage.StartBtnClick();
		homePage.clickOnSignLink();

	}


	@When("The user enter valid {string} and {string} to login")
	public void the_user_enter_valid_and_to_login(String uname, String pwd) {
		loginPage.enterCredentials(uname, pwd);
		loginPage.doLogin();

	}

	@Then("user should be redirected to homePage with the message {string}")
	public void user_should_be_redirected_to_home_page_with_the_message(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(homePage.isSignoutDisplayed(),"User not logged in ");
	}

	//TS_AR1
	@Given("The user is on the {string}")
	public void the_user_is_on_the(String string) {
		homePage.gethomepageurl();
	}
	@When("The user selecting Arrays from the drop down menu")
	public void the_user_selecting_arrays_from_the_drop_down_menu() {

		homePage.clickdropdown("Arrays");
	}

	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String page) {
		String actual_url=DriverFactory.getDriver().getCurrentUrl();
		String expectedurl=ConfigReader.getArrayPageURL();
		assertEquals(actual_url, expectedurl, "Array Page is not displayed");


	}
	//TS_AR2

	@Given("The user is on the {string} after logged in")
	public void the_user_is_on_the_after_logged_in(String page) {
		if(page.equals("Array page"))

			homePage.clickdropdown("Arrays");
		else if (page.equals("Arrays in Python page"))
		{
			homePage.clickdropdown("Arrays");
			arrayPage.clickon_arraysinpython_link();
		}
		else if(page.equals("Arrays Using List page"))
		{
			homePage.clickdropdown("Arrays");
			arrayPage.clickon_ArraysUsingList_link();
		}
		else if(page.equals("Arrays in Python page"))
		{
			homePage.clickdropdown("Arrays");
			arrayPage.clickon_arraysinpython_link();
		}
		else if(page.equals("Basic Operations in Lists"))
		{
			homePage.clickdropdown("Arrays");
			arrayPage.clickon_BasicOperation_list();
		}
		else if(page.equals("Practice page"))
		{
			homePage.clickdropdown("Arrays");
			arrayPage.clickon_arraysinpython_link();
			arrayPage.clickPracticeQue();
		}
	}
	@When("The user clicks {string} button")
	public void the_user_clicks_button(String string) {
		if(string.equals("Arrays in Python"))
		{
			arrayPage.clickon_arraysinpython_link();
		}else if(string.equals("Arraysusinglist"))
		{
			arrayPage.clickon_ArraysUsingList_link();
		}
		else {
			throw new IllegalArgumentException("Invalid button name: " + string);
		}




	}

	@Then("The user should be directed to {string}")
	public void the_user_should_be_directed_to(String string) {
		String ArrayinPythonPageURL=ConfigReader.getArrayinPythonPageURL();
		String ExpectedURL=DriverFactory.getDriver().getCurrentUrl();
		assertEquals(ArrayinPythonPageURL, ExpectedURL, "ArrrayPageURL not matched");

	}
	//TS_AR3  --->tricky testcase, since in ayyarypythonpage i used the object first, lets see 
	@When("The user clicks {string} button on {string}")
	public void the_user_clicks_button_on(String trybtn, String page) {
		arrayPythonPage.clickon_Try_Here();
	}
	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		String ExpectedURL=ConfigReader.getTryEditorpageurl();
		String ActualURL=DriverFactory.getDriver().getCurrentUrl();
		assertEquals(ActualURL, ExpectedURL, "Tryeditor URL not matched");

	}
	//TS-AR4
	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
		tryeditorPage.getTotryEditorURL();
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String Sheetname, Integer RowNumber) {
		List<String> codeList = CodeReader.getPythonCodeFromSheet(Sheetname, RowNumber);
		tryeditorPage.SendCodeonTextArea(codeList);

	}
	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
		tryeditorPage.clickonRunbtn();
	}
	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		assertTrue(tryeditorPage.isResultdisplayed(), "Result is not displayed");
		tryeditorPage.getResult();

	}
	//TS-AR5
	@When("The user enter Invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_syntax_in_try_editor_from_sheet_and(String Sheetname, Integer RowNumber) {
		List<String> codeList = CodeReader.getPythonCodeFromSheet(Sheetname, RowNumber);
		tryeditorPage.SendCodeonTextArea(codeList);

	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
		assertFalse(tryeditorPage.getErrorMessage().isEmpty(), "error message is empty");
	}

	//TS_AR6
	@When("The user clicks Arrays Using List link")
	public void the_user_clicks_arrays_using_list_link() {
		arrayPage.clickon_ArraysUsingList_link();
	}


	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
		String ExpectedURL=ConfigReader.getArraysusingListpageurl();
		String ActualURL=DriverFactory.getDriver().getCurrentUrl();
		assertEquals(ActualURL, ExpectedURL, "Arraysusinglist URL not matched");

	}
	//TS_AR7


	@When("The user clicks {string} button on the {string}")
	public void the_user_clicks_button_on_the(String trybtn, String ayrrayusinglistpage) {
		arraylistnPage.clickon_Try_Here();

	}
	//TS_AR10

	@When("The user clicks Basic Operations in Lists link")
	public void the_user_clicks_basic_operations_in_lists_link() {
		arrayPage.clickon_BasicOperation_list();
	}
	

		@Then("The user should be redirected to Basic Operations in Lists page")
		public void the_user_should_be_redirected_to_basic_operations_in_lists_page() {
         String act_title= arrayPage.getArrayPageTitle();
         assertEquals(act_title, "Basic Operations in Lists" ,"Title not matched");
		}



//TS_AR11
	  @When("The user clicks {string} button on {string} page")
		public void the_user_clicks_button_on_page(String trybtn, String basicopPage) {
		  basicoperationPage.clickon_Try_Here();
		}

	  @When("The user clicks Practice Questions link")
	  public void the_user_clicks_practice_questions_link() {
	     arrayPage.clickPracticeQue();
	  }

	  @Then("The user should be redirected to Practice page")
	  public void the_user_should_be_redirected_to_practice_page() {
		  String Title = arrayPage.getArrayPageTitle();
		assertEquals(Title, "Practice Questions", "Title do not match");
	  }

	  @When("The user clicks the Search the array link")
	  public void the_user_clicks_the_search_the_array_link() {
	      arrayPage.clickSearcharray();
	  }

	  @Then("The user should be redirected to question page contains an tryEditor with Run and Submit buttons")
	  public void the_user_should_be_redirected_to_question_page_contains_an_try_editor_with_run_and_submit_buttons() {
		  String Title = arrayPage.getArrayPageTitle();
			assertEquals(Title, "Assessment", "Title do not match");
	  }

	  @Given("The user is on {string} page of {string} after logged in")
	  public void the_user_is_on_page_of_after_logged_in(String quePage, String searcharr) {
	      arrayPage.getQuestionsearcharrayurl();
	  }

	  @When("The user enter valid python code in tryEditor from sheet {string} and {int} for the question")
	  public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and_for_the_question(String sheetName, Integer RowNumber) {
		  List<String> codeList = CodeReader.getPythonCodeFromSheet(sheetName, RowNumber);
			tryeditorPage.SendCodeonTextArea(codeList);
	  }
	
}
