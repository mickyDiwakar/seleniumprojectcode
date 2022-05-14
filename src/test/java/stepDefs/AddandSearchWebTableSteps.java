package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageobjectmodel.RegisterFormPage;
import pageobjectmodel.ToolsQAWebTablesPage;

public class AddandSearchWebTableSteps {
	WebDriver driver;
	ServiceHooks hooks;
	RegisterFormPage rfp;
	ToolsQAWebTablesPage tqwt;
	public AddandSearchWebTableSteps(ServiceHooks hook) {
		driver=hook.getFinalDriver();
		rfp=new RegisterFormPage(driver);
		tqwt=new ToolsQAWebTablesPage(driver);
		
	}
	
	@And("user click on {string} button in WebTable page")
	public void ClickonAddbutton(String Addbtn) {
	    tqwt.btnclick(Addbtn);
	}

	@And("User enter FirstName,LastName,email, Age,Salary and Depart")
	public void enterTheFieldsonRegForm(DataTable dt) {
	   rfp.setWEfirstName(dt);
	   rfp.setWELastName(dt);
	   rfp.setWEEmailId(dt);
	   rfp.setWEAge(dt);
	   rfp.setWESalary(dt);
	   rfp.setWEDepart(dt);
	   
	}

	@And("user click on {string} button  on reg form page")
	public void clickOnSubmitButton(String submitbtn) {
		rfp.clickbutton(submitbtn);
	}

	@Then("Verify thye new row eneterd")
	public void VerfiytheNewRowEntered() {
		tqwt.VerfiynewRowAdded();
	}


}
