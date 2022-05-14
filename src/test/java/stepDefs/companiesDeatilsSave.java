package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageobjectmodel.companiesPage;

public class companiesDeatilsSave {
	public WebDriver driver;
	private ServiceHooks hooks;
	companiesPage compPage;
	public companiesDeatilsSave(ServiceHooks hooks) {
		driver=hooks.getFinalDriver();
		compPage=new companiesPage(driver);
	}
	@When("user add companies from {string} tab")
	public void user_add_companies_from_companies_tab(String tabName,DataTable dt) {
		compPage.TabSelection(tabName);
		compPage.setpriority(dt);
		compPage.setstatus( dt);
	}

	@And("user click on {string} button")
	public void user_click_on_button(String string) {
	    compPage.buttonSave();
	}

	@Then("verify companies details added got saved")
	public void verify_companies_details_added_got_saved() {
	    
	}



}
