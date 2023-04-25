package Stepdefnitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.qa.factory.DriverFactory;
import com.pages.GraphPage;
import com.pages.HomePage;
import com.pages.TryEditorPage;
import com.qa.util.CodeReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Graph_SD {

	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	private TryEditorPage tryEditorPage = new TryEditorPage(DriverFactory.getDriver());
	
	private GraphPage graphPage= new GraphPage(DriverFactory.getDriver());


	@When("The user clicks the graph item from the drop down menu")
	public void the_user_clicks_the_graph_item_from_the_drop_down_menu() {
		homePage.clickdropdown("Graph");
	}

	@Then("The user be directed to Graph Page")
	public void the_user_be_directed_to_graph_page() {
		String Graphtitle=	graphPage.getGraphPageTitle();
		assertEquals(DriverFactory.getDriver().getTitle(), Graphtitle,"GRaph title not matched");
	}
	@Given("The user is on the Graph Page")
	public void the_user_is_on_the_graph_page() {
		graphPage.navigateToGraphGraphPage();
	}
	@When("The user clicks Graph link on Graph page")
	public void the_user_clicks_graph_link_on_graph_page() {
		graphPage.clickOnGraphLink();
	}
	@Then("The user should be redirected to Graph Graph page")
	public void the_user_should_be_redirected_to_graph_graph_page() {
		assertEquals(DriverFactory.getDriver().getTitle(), "Graph","GRaph link title not matched");
	}

	//@TS_graph_04
@Given("The user navigates to Graph Graph page")
public void the_user_navigates_to_graph_graph_page() {
    graphPage.navigateToGraphGraphPage();
}


@When("The user clicks on Tryhere link in Graph Page")
public void the_user_clicks_on_tryhere_link_in_graph_page() {
   graphPage.clickOnGraphTryhereLink();
}
@Then("The user should be directed to Editor page with Run button")
public void the_user_should_be_directed_to_editor_page_with_run_button() {
	assertEquals(DriverFactory.getDriver().getTitle(), "Assessment","tryeditor link title not matched");
}
//TS_05


@Given("The user is in a page having an Editor with a Run button to test")
public void the_user_is_in_a_page_having_an_editor_with_a_run_button_to_test() {
   tryEditorPage.getTotryEditorURL();
}

@When("The user enters valid python code in Editor from sheet {string} and {int}")
public void the_user_enters_valid_python_code_in_editor_from_sheet_and(String sheetName, Integer RowNumber) {
	List<String> codeList = CodeReader.getPythonCodeFromSheet(sheetName, RowNumber);
	tryEditorPage.SendCodeonTextArea(codeList);
}
@When("clicks run button")
public void clicks_run_button() {
	tryEditorPage.clickonRunbtn();
}
@Then("The user is presented with the result after run button is clicked")
public void the_user_is_presented_with_the_result_after_run_button_is_clicked() {
	assertTrue(tryEditorPage.isResultdisplayed(), "Result is not displayed");
	tryEditorPage.getResult();
}
//Ts_6


@When("The user enters invalid python code in Editor from sheet {string} and {int}")
public void the_user_enters_invalid_python_code_in_editor_from_sheet_and(String Sheetname, Integer RowNumber) {
	List<String> codeList = CodeReader.getPythonCodeFromSheet(Sheetname, RowNumber);
	tryEditorPage.SendCodeonTextArea(codeList);
}


@Then("The user gets an error message")
public void the_user_gets_an_error_message() {
	assertFalse(tryEditorPage.getErrorMessage().isEmpty(), "error message is empty");
}
//ts-7

@Given("The user in editor page and navigates to the graph page")
public void the_user_in_editor_page_and_navigates_to_the_graph_page() {
    graphPage.navigateToGraphPage();
}

@When("The user clicks on Graph Representations link")
public void the_user_clicks_on_graph_representations_link() {
	graphPage.clickOnGraphRepresentationsLink();
}
@Then("The user should be redirected to Graph Representations page")
public void the_user_should_be_redirected_to_graph_representations_page() {
	assertEquals(DriverFactory.getDriver().getTitle(), "Graph Representations","Graph Representations link title not matched");
}

//ts-


@Given("The user is in Graph Representations page")
public void the_user_is_in_graph_representations_page() {
   graphPage.navigateToGraphRepresentationsPage();
}



@When("The user clicks on Tryhere link on graph representations page")
public void the_user_clicks_on_tryhere_link_on_graph_representations_page() {
	graphPage.clickOnGraphTryhereLink();
}
@Then("The user navigates to Editor page with Run button")
public void the_user_navigates_to_editor_page_with_run_button() {
	assertEquals(DriverFactory.getDriver().getTitle(), "Assessment","tryeditor link title not matched");
}
}
