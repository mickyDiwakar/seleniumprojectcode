package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.baseUtil;

public class loginPageOfCogneto extends baseUtil {
	public  WebDriver driver;
	@FindBy(name="email") private WebElement userName;
	@FindBy(css="input[name='password']") private WebElement password;
	@FindBy(xpath="//div[text()='Login']")private WebElement loginbtn;
	public loginPageOfCogneto(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public void setUserName() {
		userName.sendKeys(configFileReader.getCognetoUserName());
	}

	

	public void setPassword() {
		try {
			if(password.isEnabled()) {
				password.sendKeys(configFileReader.getCognetoPassworde());
			}
		}catch(Exception e){
			throw new RuntimeException("unable to enter password");
		}
	}
	public void clickLoginButgton() {
		loginbtn.click();
	}
	
}
