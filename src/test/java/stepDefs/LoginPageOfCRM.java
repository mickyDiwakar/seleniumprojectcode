 package stepDefs;



import org.openqa.selenium.WebDriver;

import ConfigfileReader.ConfigFileReader;
import ConfigfileReader.fileReaderManager;
import cucumber.api.java.en.*;
import pageobjectmodel.loginPage;

public class LoginPageOfCRM  {
	public WebDriver driver;
	private ServiceHooks hooks;
	loginPage loginpage;
	public LoginPageOfCRM(ServiceHooks hooks) {
		driver=hooks.getFinalDriver();
		loginpage=new loginPage(driver);
		
	}
	
	@Given("^User navigate to CRMPro URL$")
	public void user_navigate_to_CRMPro_URL1() {
		String crmUrl=fileReaderManager.getfileReaderManagerInstance().getConfigReader().geturl();
		driver.get(crmUrl);
	}

	@And("User Enter CRMuserName and CRMPassword")
	public void user_Enter_CRMuserName_and_CRMPassword1() throws InterruptedException  {
	    loginpage.Login();
	}
	
	@Given("^User navigate to demo URL$")
    public void user_navigate_to_demo_url() throws Throwable {
      String DemoUrl=  fileReaderManager.getfileReaderManagerInstance().getConfigReader().getUrlOfDemo();
      driver.get(DemoUrl);
      Thread.sleep(5000);
      
      
    }
	
	@And("^Click on \"([^\"]*)\" button on DemoHomePage$")
	public void click_on_something_button(String strArg1) throws Throwable {
		
		loginpage.skiploginInDemo();
	}
	@Given("user logged in to toolsQA Url")
	public void user_logged_in_to_toolsQA_Url() {
	   driver.get(fileReaderManager.getfileReaderManagerInstance().getConfigReader().getToolsQAUrl());
	}

}
