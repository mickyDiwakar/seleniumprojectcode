package DriverManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import ConfigfileReader.fileReaderManager;
import Constant.Constant;

public class WebDriverManager {
	private WebDriver driver;
	private static String browser;
	private static String environment;
	
	public WebDriverManager() {
		browser=fileReaderManager.getfileReaderManagerInstance().getConfigReader().getBrowser();
		environment=fileReaderManager.getfileReaderManagerInstance().getConfigReader().getEnvironment();
		
	}

	
	public WebDriver DriverCreation() throws IOException {

		if (driver == null) {
			driver = createDriver();
			//DriverFactory.getDriverFactoryInstance().setDriver(driver);

		}
		return driver;
	}
	 
	private WebDriver createDriver() throws IOException   {
		switch(environment.toUpperCase()){
			case "LOCAL":
				driver=createLocalDriver();
				break;
			case "REMOTE":
				driver=createRemoteDriver();
			
		}
		return driver;
		
	}
	private WebDriver createLocalDriver() {
		switch(browser.toLowerCase()) {
		case "chrome":
			System.setProperty(Constant.CHROMEDRIVERPROPERTY, Constant.CHROMEDRIVERPATH);
			ChromeOptions capabilitycrome = new ChromeOptions();
			capabilitycrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilitycrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			driver=new ChromeDriver(capabilitycrome);
			break;
		case "firefox":
			System.setProperty(Constant.FFDRIVERPROPERTY, Constant.FFDRIVERPATH);
			FirefoxOptions capabilityFF =new FirefoxOptions();
			capabilityFF.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilityFF.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			driver=new FirefoxDriver(capabilityFF);
			break;
		case "ie":
			System.setProperty(Constant.IEDRIVERPROPERTY, Constant.IEDRIVERPATH);
			driver=new InternetExplorerDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait((fileReaderManager.getfileReaderManagerInstance().getConfigReader().getImplictwait()),TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(fileReaderManager.getfileReaderManagerInstance().getConfigReader().getpageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
	}
	
	private WebDriver createRemoteDriver() throws IOException {
		DesiredCapabilities cap;
		String nodeurl="http://192.168.43.118:4444/wd/hub"; 
		switch(browser.toLowerCase()) {
		case "chrome":
			cap=new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
			ChromeOptions chromeoptions=new ChromeOptions();
			chromeoptions.merge(cap);
			driver=new RemoteWebDriver(new URL(nodeurl),chromeoptions);
			break;
		case "fireFox":
			
			cap=new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
			FirefoxOptions firefoxOptions=new FirefoxOptions();
			firefoxOptions.merge(cap);
			driver=new RemoteWebDriver(new URL(nodeurl),firefoxOptions);
				break;
		case "ie":
			cap=new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
			InternetExplorerOptions internetExplorerOptions=new InternetExplorerOptions();
			internetExplorerOptions.merge(cap);
			driver=new RemoteWebDriver(new URL(nodeurl),internetExplorerOptions);
				break;
		}
		driver.manage().timeouts().implicitlyWait((fileReaderManager.getfileReaderManagerInstance().getConfigReader().getImplictwait()),TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(fileReaderManager.getfileReaderManagerInstance().getConfigReader().getpageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}

}
