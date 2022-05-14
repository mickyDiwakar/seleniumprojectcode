package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectmodel.SwitchToPage;
import pageobjectmodel.newtabandwindowPage;

public class SwitchToSteps {
	WebDriver driver;
	ServiceHooks hook;
	SwitchToPage stp;
	newtabandwindowPage nwp;
	 public SwitchToSteps(ServiceHooks hook) {
		driver=hook.getFinalDriver();
		 stp=new SwitchToPage(driver);
		 nwp=new newtabandwindowPage(driver);
	}

	@And("Select {string} in SwitchTo Tab")
	public void select_in_SwitchTo_Tab(String subtab) throws InterruptedException {
	  stp.clickonTabAttribute(subtab);
	}

	@And("click on {string} tab and click red button")
	public void click_on_tab_and_click_red_button(String btntxt) {
	   stp.clickonbtn(btntxt);
	}

	@Then("verfiy the text of Alert and click {string}")
	public void verfiy_the_text_of_Alert_and_click(String Str) {
	    stp.alertcheck();
	}

	@And("click on {string} tab and click deepblue button")
	public void click_on_tab_and_click_deepblue_button(String btntxt) {
		stp.clickonbtn(btntxt);
	}

	@When("click on {string} tab and click blue button")
	public void click_on_tab_and_click_blue_button(String btntxt) {
		stp.clickonbtn(btntxt);
	}
	@And("verfiy the text of Alert and click {string} button")
	public void verfiy_the_text_of_Alert_and_click_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   stp.alertwithOkcheck();
	}

	@And("verfiy the text of Alert and enter the valueand click ok")
	public void verfiy_the_text_of_Alert_and_enter_the_valueand_click_ok() {
	    // Write code here that turns the phrase above into concrete actions
	    stp.promptalertVerfiy();
	}

@And("Click {string} tab in WindowSwitchPage and Click {string} button")
public void click_tab_in_WindowSwitchPage_and_Click_button(String string, String string2) {
    stp.newTabtest();
}

@Then("Verfiy a new Tab open with text {string}")
public void verfiy_a_new_Tab_open_with_text(String StrText) throws Throwable {
    nwp.VerfiythenewTab(StrText);
}

@And("Select {string} tab in WindowSwitchPage and Click on {string} button")
public void select_tab_in_WindowSwitchPage_and_Click_on_button(String string, String string2) throws InterruptedException {
    stp.newWindow();;
}

@Then("Verfiy a new Window open with text {string}")
public void verfiy_a_new_Window_open_with_text(String strText) {
    nwp.verfiynewWindow(strText);
}

@And("Click on {string} tab in WindowSwitchPage and Click {string} button")
public void click_on_tab_in_WindowSwitchPage_and_Click_button(String string, String string2) {
   stp.newMutiTabSelection();;
}

@Then("Verfiy a mutiple window open switch to tab contains {string}")
public void verfiy_a_mutiple_window_open_switch_to_tab_contains(String strText) {
    nwp.verifymultipleWindow(strText);
}
@Then("Click on {string} and enter Text {string}")
public void click_on_and_enter_Text(String button, String txt) {
    stp.SwitchToFrame(button, txt);
}

@When("Click on {string} and enter text {string}")
public void click_on_and_enter_text(String button, String txt) {
	 stp.SwitchToFrame(button, txt);
}

@Then("Click on {string} on Frame")
public void click_on(String btn) {
    stp.ClickonBtnForFrames(btn);
}

}
