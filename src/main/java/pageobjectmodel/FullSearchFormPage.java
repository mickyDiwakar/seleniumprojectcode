package pageobjectmodel;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import commonUtils.Logg;
import commonUtils.baseUtil;
import io.cucumber.datatable.DataTable;

public class FullSearchFormPage extends baseUtil {
	final static Logger log=Logg.getLogger(FullSearchFormPage.class);
	WebDriver driver;
	@FindBy(name="cs_keyword") private WebElement txtTitle;
	@FindBy(name="cs_closed") private WebElement ddState;
	@FindBy(name="cs_deadline_operator") private WebElement ddDeadline;
	@FindBy(id="fieldId_cs_deadline") private WebElement txtDeadline;
	@FindBy(css="input[value='Search Cases']") private WebElement btnSearchCases;
	
	public FullSearchFormPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//List<Map<String,String>>data=
		
	}
	
	public void setTitle(String title) {
		txtTitle.sendKeys(title);
	}
	public void setState(String state) {
		DropDownSelectionByVisibleText(ddState, state);
		}
	public void setDeadline(String whenDD,String dateofDd) {
		DropDownSelectionByVisibleText(ddDeadline, whenDD);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateofDd+"')", txtDeadline);
	}
	public void buttonClick() {
		btnSearchCases.click();
	}
	
	public void SearchaCase(DataTable dt) {
		
		/*setTitle(title);
		setState(state);
		setDeadline(whenDD, dateofDd);
		buttonClick();*/
	}
	

}
