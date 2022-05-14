package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;
import pageobjectmodel.SwitchToPage;
import pageobjectmodel.ToolsQAWebTablesPage;

public class tabSelectionPage {
	WebDriver driver;
	ServiceHooks hook;
	SwitchToPage stp;
	ToolsQAWebTablesPage toolsQaWt;
	 public tabSelectionPage(ServiceHooks hook) {
		driver=hook.getFinalDriver();
		stp=new SwitchToPage(driver);
		toolsQaWt=new ToolsQAWebTablesPage(driver);
	}
	
	@When("user click on {string} Tab")
	public void user_click_on_Tab(String tab) {
	    stp.tabSelection(tab);
	}
	@When("user click on {string} and {string} on toolsqa page")
	public void user_click_on_on_toolsqa_page(String Homepagelemen,String subele) {
		toolsQaWt.ClickHomePageIconSelection(Homepagelemen);
		toolsQaWt.ClickItemSelection(subele);
		toolsQaWt.ClickItemSelection(subele);
		toolsQaWt.ClickSubItemSelection(subele);
	}

}
