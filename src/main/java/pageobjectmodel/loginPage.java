package pageobjectmodel;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.baseUtil;

public class loginPage extends baseUtil{
	public WebDriver driver;
	@FindBy(name="username") private WebElement txtboxuserName;
	@FindBy(name="password") private WebElement txtboxpassword;
	@FindBy(css="input[value='Login']") private WebElement btnLogin;
	@FindBy(id="btn2") private WebElement SkipLogin;
	
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//WaitForPageLoad(btnLogin,driver);
	}
	
	public void setUserName() {
		txtboxuserName.sendKeys(configFileReader.getCRMUserName());
	}
	public void setPassword() {
		String s=configFileReader.getCRMPassword();
		System.out.println(s);
		byte[] password=Base64.getDecoder().decode(s.getBytes());
		txtboxpassword.sendKeys(new String(password));
		
	}
	public void clickLoginbutton() throws InterruptedException {
		//WaitForElementTobeVisible(btnLogin, driver);
		Thread.sleep(4000);
		btnLogin.click();
	}
	
	
	public void Login() throws InterruptedException {
		setUserName();
		setPassword();
		clickLoginbutton();
	}
	public void skiploginInDemo() {
		SkipLogin.click();
		
	}
}