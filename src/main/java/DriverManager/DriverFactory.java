package DriverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	//private WebDriver driver;
		ThreadLocal<WebDriver>driver=new ThreadLocal<WebDriver>() {
		@Override
		protected WebDriver initialValue() {
			try {
				return new WebDriverManager().DriverCreation();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	};
	private static DriverFactory factory=null;
	private DriverFactory() {}
	
	public static DriverFactory getDriverFactoryInstance() {
		
		return (factory==null)?new DriverFactory():factory;
		
	}

	
	
	public WebDriver getDriver() {
		return driver.get();
	}
	public void setDriver(WebDriver driverparam) {
		driver.set(driverparam);
	}

}
