package stepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import pageobjectmodel.FullSearchFormPage;
import pageobjectmodel.Homepage;
import pageobjectmodel.NewCasePage;
import pageobjectmodel.contactLookupPage;
import pageobjectmodel.keyCompanyLookuppage;

public class stepsCaseTab {
	WebDriver driver;
	ServiceHooks hooks;
	String LocalcaseNo;
	Homepage homepage;
	NewCasePage newcasepage;
	contactLookupPage contactlookuppage;
	keyCompanyLookuppage keycompanylookuppage;
	FullSearchFormPage fullSearchFormPage;
	
	public stepsCaseTab(ServiceHooks hooks) {
		this.hooks=hooks;
		driver=hooks.getFinalDriver();
		}
	
	
	@And("user select {string} from {string} tab")
	public void user_select_from_case_tab(String string,String string2) {
		homepage=new Homepage(driver);
		homepage.TabSelection(string, string2);
	   
	}

	@And("Capture the CaseNo")
	public void capture_the_CaseNo() {
		newcasepage=new NewCasePage(driver);
		//caseNo=newcasepage.getTextCaseNo();
		//LocalcaseNo=NewCasePage.caseNo;
		LocalcaseNo=newcasepage.getTextCaseNo();
		
	}

	@When("user enter  {string},{string},{string},{string},{string}")
	public void user_enter(String title, String status, String deadline, String state, String identifer) {
			newcasepage.setTbTitle(title);
			newcasepage.setDdStatus(status);
			newcasepage.setTbDeadline(deadline);
			newcasepage.setRbState(state);
			newcasepage.setTbIdentifer(identifer);
	   
	}

	@And("user enter {string},{string},{string}")
	public void user_enter(String type, String priority, String Assingto) {
		newcasepage.setDdType(type);
		newcasepage.setDdPriority(priority);
		newcasepage.setDdAssignedTo(Assingto);
	    
	}

	@And("user enter {string} and {string} from Lookup")
	public void user_enter_and_from_Lookup(String contact, String KeyCompany) {
	   newcasepage.ClickBtnLookup("contact");
	   contactlookuppage=new contactLookupPage(driver);
	   contactlookuppage.selectContactLookUp(contact);
	   newcasepage.ClickBtnLookup("keyComp");
	   keycompanylookuppage=new keyCompanyLookuppage(driver);
	   keycompanylookuppage.selectCompanyLookUp(KeyCompany);
	}

	@And("user select {string}")
	public void user_select(String node) {
	    newcasepage.setDdKnowlegBasedNode(node);
	}

	@And("click on {string} button")
	public void click_on_button(String string) {
	    newcasepage.clickSaveButton();
	}

	@Then("verify that Case Created")
	public void verify_that_Case_Created() {
		System.out.println("---------------------THREAD---------------------------------------------------------------------");
		 System.out.println(LocalcaseNo);
		 System.out.println(newcasepage.getCaseNumberFromCaseCreationTable());
	//newcasepage.verifycaseCreation();
	 Assert.assertTrue(LocalcaseNo.equals(newcasepage.getCaseNumberFromCaseCreationTable()), "caseCreated sucessfully");
  
	}
	
	@When("user enter Title,State Deadline and Deadlinedropdown")
	public void user_enter_Title_State_Deadline_and_Deadlinedropdown(DataTable dt) {
		fullSearchFormPage=new FullSearchFormPage(driver);
	    List<Map<String,String>> d=dt.asMaps(String.class,String.class);
		fullSearchFormPage.setTitle(d.get(0).get("Title"));
	}

	 @And("^Click on \"([^\"]*)\" button in SearchPage$")
	    public void click_on_something_button_in_searchpage(String strArg1) throws Throwable {
	        
	    }

	@And("Search Case with Title edit it Status {string}")
	public void search_Case_with_Title_edit_it_Status(String string) {
	    
	}

	@Then("Verfiy that Case edit done")
	public void verfiy_that_Case_edit_done() {
	    
	}




}
