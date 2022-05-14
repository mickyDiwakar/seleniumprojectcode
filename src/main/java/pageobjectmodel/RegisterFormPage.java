package pageobjectmodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import commonUtils.Logg;
import commonUtils.baseUtil;
import io.cucumber.datatable.DataTable;

public class RegisterFormPage extends baseUtil{
	public static String fname;
	static final Logger log=Logg.getLogger(RegisterFormPage.class);
	private WebDriver driver;
	@FindBy(id="firstName") private WebElement WEfirstName;
	@FindBy(id="lastName") private WebElement WELastName;
	@FindBy(css="input#userEmail") private WebElement WEEmailId;
	@FindBy(id="age") private WebElement WEAge;
	@FindBy(css="input[placeholder='Salary']") private WebElement WESalary;
	@FindBy(id="department") private WebElement WEDepart;
	@FindBy(id="submit") private WebElement WeSubmitbtn;
	public RegisterFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void setWEfirstName(DataTable dt) {
		List<List<String>> list=dt.asLists();
		WEfirstName.sendKeys(list.get(0).get(0)); 
	}
	public String getWEfirstName() {
		 return fname=WEfirstName.getAttribute("value");
	}
	public void setWELastName(DataTable dt) {
		List<List<String>> list=dt.asLists();
		WELastName.sendKeys(list.get(0).get(1)); 
	}
	public void setWEEmailId(DataTable dt) {
		List<List<String>> list=dt.asLists();
		WEEmailId.sendKeys(list.get(0).get(2));
	}
	public void setWEAge(DataTable dt) {
		List<List<String>> list=dt.asLists();
		WEAge.sendKeys(list.get(0).get(3));
	}
	public void setWESalary(DataTable dt) {
		List<List<String>> list=dt.asLists();
		WESalary.sendKeys(list.get(0).get(4));
	}
	public void setWEDepart(DataTable dt) {
		List<List<String>> list=dt.asLists();
		WEDepart.sendKeys(list.get(0).get(5));
		
	}
	public void clickbutton(String btnclick) {
		fname=getWEfirstName();
		if(btnclick.equals("Submit")) {
			WeSubmitbtn.click();
			Reporter.log("============================submit button clickedd");
			log.info("******************submit button clicked***********");
		}
		//return fname;
	}

}
