package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectmodel.RegisterDemoPage;

public class RegisterForm {
	 WebDriver driver;
	 private ServiceHooks hook;
	 RegisterDemoPage rdp;
	 public RegisterForm(ServiceHooks hook) {
		 driver=hook.getFinalDriver();
		 rdp=new RegisterDemoPage(driver);
	 }

	    @When("^user enter firstName \"([^\"]*)\"and LastName\"([^\"]*)\" on reg page$")
	    public void user_enter_firstname_somethingand_lastnamesomething_on_reg_page(String fname, String lname) throws Throwable {
	       rdp.setFistName(fname);
	       rdp.setLastName(lname);
	    }

	    @Then("^verify user should be created$")
	    public void verify_user_should_be_created() throws Throwable {
	       
	    }

	    

	    @And("^user enter email\"([^\"]*)\" and Phone\"([^\"]*)\" on reg page$")
	    public void user_enter_emailsomething_and_phonesomething_on_reg_page(String email, String phone) throws Throwable {
	        rdp.setEmail(email);
	        rdp.setPhone(phone);
	    }

	    @And("^user select Gender \"([^\"]*)\" and Hobbies \"([^\"]*)\" on reg page$")
	    public void user_select_gender_something_and_hobbies_something_on_reg_page(String gender, String hobbies) throws Throwable {
	       rdp.setGender(gender);
	       rdp.setHobbies(hobbies);
	    }

	    @And("^User select Country \"([^\"]*)\" and DOB \"([^\"]*)\" on reg page$")
	    public void user_select_country_something_and_dob_something_on_reg_page(String country, String dob) throws Throwable {
	        rdp.setCountryDD(country);
	        rdp.setDobYearDD(dob);
	        rdp.setDobYearMonth(dob);
	        rdp.setDobYearDay(dob);
	    }

	    @And("^user click on \"([^\"]*)\" button on reg page$")
	    public void user_click_on_something_button(String strArg1) throws Throwable {
	        rdp.clickBtnSubmitandRefresh(strArg1);
	    }

}
