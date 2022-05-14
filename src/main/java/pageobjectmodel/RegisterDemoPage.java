 package pageobjectmodel;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtils.baseUtil;

public class RegisterDemoPage extends baseUtil{
	public WebDriver driver;
	WebDriverWait wait;
	@FindBy(css="input[ng-model='FirstName']") private WebElement FistName;
	@FindBy(css="input[ng-model='LastName']") private WebElement LastName;
	@FindBy(xpath="//input[@ng-model='EmailAdress']") private WebElement weemail;
	@FindBy(xpath="//input[@ng-model='Phone']") private WebElement Phone;
	@FindBy(xpath="//div[@class='col-md-4 col-xs-4 col-sm-4']/parent"
			+ "::div/label[contains(text(),'Gender')]/parent::div/div/label")	private List<WebElement> Gender;
	@FindBy(xpath="//div[@class='form-group']/label[contains(text(),'Hobbies')]"
			+ "/parent::div/div//input") private List<WebElement>Hobbies;
	@FindBy(id="countries")private WebElement CountryDD;
	@FindBy(id="yearbox") private WebElement DobYearDD;
	@FindBy(css="select[placeholder='Month']") private WebElement DobYearMonth;
	@FindBy(id="daybox") private WebElement DobYearDay;
	@FindBy(css="button[class='btn btn-primary']") private List<WebElement> btnSubmitandRefresh;
	public RegisterDemoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setFistName(String fistName) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FistName));
		FistName .sendKeys(fistName);
	}
	public void setLastName(String lastName) {
		LastName.sendKeys(lastName);
	}
	public void setPhone(String phone) {
		Phone.sendKeys(phone);
	}
	public void setEmail(String email) {
		if(email.contains(".") && email.contains("@")) {
			weemail.sendKeys(email);
		}else {
			throw new RuntimeException("email format is incorrect");
		}
	}
	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			Gender.get(0).click();
		}else {
			Gender.get(1).click();
		}
	}
	public void setHobbies(String hobbies) {
		switch(hobbies){
		case "Cricket":
			if(Hobbies.get(0).isEnabled() && !Hobbies.get(0).isSelected()) {
				Hobbies.get(0).click();
			}
			break;
		case "Movies":
			if(Hobbies.get(1).isEnabled() && !Hobbies.get(1).isSelected()) {
				Hobbies.get(1).click();
			}
			break;
		case "Hockey":
			
				if(Hobbies.get(2).isEnabled() && !Hobbies.get(2).isSelected()) {
					Hobbies.get(2).click();
				}
				break;
		default:
			throw new RuntimeException("no match found in Hobbies");
		}
	}
	public void setCountryDD(String country) throws InterruptedException {
		DropDownSelectionByVisibleText(CountryDD, country);
		Thread.sleep(2000);
		
	}
	public void setDobYearDD(String dobYearDD) throws InterruptedException {
		String dobYear=dobYearDD.split("/")[2];
		Select select =new Select(DobYearDD);
		select.selectByVisibleText(dobYear.trim());
		select.getFirstSelectedOption().getText();
		Assert.assertTrue(select.getFirstSelectedOption().getText().equals(dobYear));	
		Thread.sleep(2000);
	}
	public void setDobYearMonth(String dobYearMonth) throws InterruptedException {
		String dobMonth=dobYearMonth.split("/")[1];
		DropDownSelectionByVisibleText(DobYearMonth, dobMonth);
		
		Thread.sleep(2000);
	}
	public void setDobYearDay(String dobYearDay) throws InterruptedException {
		String dobDay=dobYearDay.split("/")[0];
		DropDownSelectionByVisibleText(DobYearDay, dobDay);
		
		Thread.sleep(2000);
	}
	public void clickBtnSubmitandRefresh(String save) {
		String btnclick=save;
		if(btnclick.equalsIgnoreCase("Save")) {
			btnSubmitandRefresh.get(0).click();
		}
		
	}
	
	

}
