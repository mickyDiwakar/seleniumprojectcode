package stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConfigfileReader.fileReaderManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageobjectmodel.loginPageOfCogneto;

public class stepDefLoginPageOfCognito {
	public WebDriver driver;
	private ServiceHooks hooks;
	loginPageOfCogneto lpc;
	WebDriverWait Wait;
	public stepDefLoginPageOfCognito(ServiceHooks hooks){
		driver=hooks.getFinalDriver();
		lpc=new loginPageOfCogneto(driver);
	}
	@Given("user launch cogmento url")
	public void user_launch_cogmento_url() {
	    String congmetoURL=fileReaderManager.getfileReaderManagerInstance().getConfigReader().getcogmentourl();
	    driver.get(congmetoURL);
	}
	@And("sign in with valid credentials to cogmento")
	public void sign_in_with_valid_credentials_to_cogmento() {
		
	    lpc.setUserName();
	    lpc.setPassword();
	    lpc.clickLoginButgton();
	}
	
}


