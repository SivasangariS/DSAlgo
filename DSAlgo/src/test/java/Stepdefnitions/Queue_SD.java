package Stepdefnitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.List;

import com.qa.factory.DriverFactory;
import com.pages.QueuePage;
import com.pages.HomePage;
import com.pages.TryEditorPage;
import com.qa.util.CodeReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Queue_SD {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private TryEditorPage tryEditorPage = new TryEditorPage(DriverFactory.getDriver());
	private QueuePage queuePage= new QueuePage(DriverFactory.getDriver());
	
	@When("The user clicks the Queue item from the drop down menu")
	public void the_user_clicks_the_queue_item_from_the_drop_down_menu() {
		homePage.clickdropdown("Queue");
	}
	
	@Then("The user be directed to Queue Page")
	public void the_user_be_directed_to_queue_page() {
		String Queuetitle=	queuePage.getQueuePageTitle();
		assertEquals(DriverFactory.getDriver().getTitle(),Queuetitle);
	}
	
	@Given("The user is on the Queue Page")
	public void the_user_is_on_the_queue_page() {
		queuePage.navigateToQueuePage();
	}
	
	@When("The user clicks on Implementation of queue in Python link")
	public void the_user_clicks_on_implementation_of_queue_in_python_link() {
		queuePage.clickOnImplementationOfQueueinPythonLink();
	}
	
	@Then("The user should be redirected to Implementation of queue in Python Page")
	public void the_user_should_be_redirected_to_implementation_of_queue_in_python_page() {
		assertEquals(DriverFactory.getDriver().getTitle(),"Implementation of Queue in Python");
	}
	
	@Given("The user is in Implementation of queue  in Python Page")
	public void the_user_is_in_implementation_of_queue_in_python_page() {
	   queuePage.navigateToQueueInPythonPage();
	}

	@When("The user clicks on Try here link")
	public void the_user_clicks_on_try_here_link() {
	   queuePage.clickOnQueueTryhereLink();
	}

	@Given("The user is in Editor Page and navigates to Queue Page")
	public void the_user_is_in_editor_page_and_navigates_to_queue_page() {
	   queuePage.navigateToQueuePage();
	}

	@When("The user clicks on Implementation using collections deque link")
	public void the_user_clicks_on_implementation_using_collections_deque_link() {
	    queuePage.clickOnImplementationUsingCollectionsDequeLink();
	}

	@Then("TThe user should be redirected to Implementation using collections deque page")
	public void t_the_user_should_be_redirected_to_implementation_using_collections_deque_page() {
		assertEquals(DriverFactory.getDriver().getTitle(),"Implementation using collections.deque");
	}

	@Given("The user in implementation using collections page")
	public void the_user_in_implementation_using_collections_page() {
	    queuePage.navigateToQueueImplementationDequePage();
	}

	@When("The user clicks on Tryhere link")
	public void the_user_clicks_on_tryhere_link() {
	    queuePage.clickOnQueueTryhereLink();
	}

	@When("The user enters valid python code in Editor  from sheet {string} and {int}")
	public void the_user_enters_valid_python_code_in_editor_from_sheet_and(String sheetName, Integer RowNumber) {
		List<String> codeList = CodeReader.getPythonCodeFromSheet(sheetName, RowNumber);
		tryEditorPage.SendCodeonTextArea(codeList);
	}

	@When("clicks Run Button")
	public void clicks_run_button() {
	    tryEditorPage.clickonRunbtn();
	}

	@When("The user enters invalid python code in Editor  from sheet {string} and {int}")
	public void the_user_enters_invalid_python_code_in_editor_from_sheet_and(String Sheetname, Integer RowNumber) {
		List<String> codeList = CodeReader.getPythonCodeFromSheet(Sheetname, RowNumber);
		tryEditorPage.SendCodeonTextArea(codeList);
	}

	@Then("The user gets an Error Message")
	public void the_user_gets_an_error_message() {
		assertFalse(tryEditorPage.getErrorMessage().isEmpty(),"error message is empty");
	}

	@Given("The user in editor page and navigates to the Queue page")
	public void the_user_in_editor_page_and_navigates_to_the_queue_page1() {
	    queuePage.navigateToQueuePage();
	}

	@When("The user clicks on Implementation using array link")
	public void the_user_clicks_on_implementation_using_array_link() {
	   queuePage.clickOnImplementationUsingArrayLink();
	}

	@Then("The user should be redirected to Implementation using array page")
	public void the_user_should_be_redirected_to_implementation_using_array_page() {
		assertEquals(DriverFactory.getDriver().getTitle(),"Implementation using array");
	}

	@Given("The user in Implementation using array page")
	public void the_user_in_implementation_using_array_page() {
		queuePage.navigateToQueueImplementationArrayPage();
	}

	@Given("The user in Editor page and navigates to the Queue page")
	public void the_user_in_editor_page_and_navigates_to_the_queue_page() {
	    queuePage.navigateToQueuePage();
	}

	@When("The user clicks on Queue Operations  link")
	public void the_user_clicks_on_queue_operations_link() {
	    queuePage.clickOnQueueOperationsLink();
	}

	@Then("The user should be redirected to Queue Operations page")
	public void the_user_should_be_redirected_to_queue_operations_page() {
		assertEquals(DriverFactory.getDriver().getTitle(),"Queue Operations");
	}

	@Given("The user in Queue Operations page")
	public void the_user_in_queue_operations_page() {
	    queuePage.navigateToQueueOperationPage();
	}

	@Given("The user is in Editor page and navigates to QueueOp page")
	public void the_user_is_in_editor_page_and_navigates_to_queue_op_page() {
		queuePage.navigateToQueueOperationPage();
	}

	@When("The user clicks on Practice Questions")
	public void the_user_clicks_on_practice_questions() {
	    queuePage.clickOnQueuePracQuesLink();
	}

	@Then("The user is directed to Practice page")
	public void the_user_is_directed_to_practice_page() {
		assertEquals(DriverFactory.getDriver().getTitle(),"Practice Questions");
	}

}
