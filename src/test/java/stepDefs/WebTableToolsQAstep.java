package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectmodel.ToolsQAWebTablesPage;

public class WebTableToolsQAstep {
	WebDriver driver;
	ServiceHooks hook;
	ToolsQAWebTablesPage toolsQaWt;
	Integer rownum;
	Integer age;
	public WebTableToolsQAstep(ServiceHooks hooks) {
		driver=hooks.getFinalDriver();
		toolsQaWt=new ToolsQAWebTablesPage(driver);
	}

	@Then("user fetch firstName from {int}nd row of WebTable")
	public void user_fetch_firstName_from_nd_row_of_WebTable(Integer rownumber) {
		rownum=rownumber;
		toolsQaWt.GetRowValue(rownumber);
	}

	@And("Verify the FirstName is {string}")
	public void verify_the_FirstName_is(String colval) {
		System.out.println(rownum);
		toolsQaWt.verfiythefetchedVlauefromRow(rownum, colval);
	  
	}

	@When("User click on {string} button in {int}nd row WebTable")
	public void user_click_on_button_in_nd_row_WebTable(String actionbtn, Integer rownum) {
		toolsQaWt.ActionbuttonOnWebTable(rownum, actionbtn);
	}

	@And("change the value of age to {int}")
	public void change_the_value_of_age_to(Integer age) {
		this.age=age;
		toolsQaWt.editAgeRowValue(age);
	}

	@Then("Verfiy the {string} of {int}nd row changed in the table")
	public void verfiy_the_of_nd_row_changed_in_the_table(String fiedlName, Integer row) {
		//String age1=age.toString();
		toolsQaWt.VerfiytheTablevalueChanged(fiedlName, row.toString(), age.toString());
	}
	@Then("Verfiy the  {int}nd row got deleted in the table")
	public void verfiy_the_nd_row_got_deleted_in_the_table(Integer row) throws InterruptedException {
		Thread.sleep(2000);
		toolsQaWt.VerfiytheRowDeleted(row);
	}
}
