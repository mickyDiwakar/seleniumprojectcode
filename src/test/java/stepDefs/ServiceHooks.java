package stepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.WebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;



public class ServiceHooks {
	
	
	  public WebDriver driver; 
	  WebDriverManager wdm;
	  
	@Before
	public void setUp() {
		System.out.println("********************scenaro started"); 
		// wdm=new	WebDriverManager();
		// DriverFactory.getDriverFactoryInstance().setDriver(wdm.DriverCreation());
		driver = DriverFactory.getDriverFactoryInstance().getDriver();

	}

	public WebDriver getFinalDriver() {

		return driver;

	}

	@After
	public void tearDown(Scenario scenario) {
		
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, scenario.getName() + "image/png");

		}
		if (driver != null) {
			driver.quit();

		}

	}
	 

}
