package pageobjectmodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.DBCellRecord;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import commonUtils.Logg;
import commonUtils.baseUtil;
import io.cucumber.datatable.DataTable;

public class NewCasePage extends baseUtil{
	final static Logger log=Logg.getLogger(NewCasePage.class);
	//public  static String caseNo;
	WebDriver driver;
	@FindBy(id="title") private WebElement tbTitle;
	@FindBy(name="status") private WebElement ddStatus;
	@FindBy(name="deadline") private WebElement tbDeadline;
	@FindBy(name="closed") private List<WebElement> rbState;
	@FindBy(name="identifier") private WebElement tbIdentifer;
	@FindBy(name="type") private WebElement ddType;
	@FindBy(css="select[name='priority']") private WebElement ddPriority;
	@FindBy(name="assigned_to_user_id") private WebElement ddAssignedTo;
	@FindBy(css="input[value='Lookup']") private List<WebElement> btnLookup;
	//@FindBy(name="node_id") private WebElement ddKnowlegBasedNode;
	@FindBy(xpath="//select[@name='node_id']/option") private List<WebElement> ddKnowLedgeNodeOPtions;
	@FindBy(name="sequence") private WebElement textCaseNo;
	@FindBy(xpath="//td[@colspan='2']/input[@value='Save']") private List<WebElement> btnSave;
	@FindBy(xpath="//td[@class='datatitle']/strong[contains(text(),'Case')]/parent::td/following-sibling::td")
	private WebElement txtcaseNo;
	
	public NewCasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WaitForElementToBeClickable(tbTitle, driver);;
		//caseNo=getTextCaseNo();
		
		
		
		//WaitForFrameToBeAvailableAndSwitchToIt("mainpanel", driver);
	}
	/*
	 * public void pageload() { WaitForElementToBeClickable(tbTitle, driver);; }
	 */
	
	public void setTbTitle(String text) {
		tbTitle.sendKeys(text);
	}

	public void setDdStatus(String text) {
		DropDownSelectionByVisibleText(ddStatus, text);
	}

	public void setTbDeadline(String text) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')", tbDeadline);
		
	}
	public void setRbState(String text) {
		
		for(WebElement ele:rbState) {
			if(ele.getAttribute("value")=="Y" && text.equalsIgnoreCase("closed")) {
				ele.click();
				break;
			}else {
				ele.click();
				break;
			}
		}
			
	}


	public void setTbIdentifer(String text) {
		tbIdentifer.sendKeys(text);
	}
 

	public void setDdType(String text) {
		DropDownSelectionByVisibleText(ddType, text);
	}


	public void setDdPriority(String text) {
		DropDownSelectionByVisibleText(ddPriority, text);
	}

	
	public void setDdAssignedTo(String text) {
		Select select=new Select(ddAssignedTo);
		select.deselectAll();
		DropDownSelectionByVisibleText(ddAssignedTo, text);
	}


	public void ClickBtnLookup(String lookup) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
			 if(lookup.equalsIgnoreCase("Contact")) {
				 
				 js.executeScript("arguments[0].click;", btnLookup.get(0));
				 btnLookup.get(0).click();
			 }else {
				 js.executeScript("arguments[0].click;", btnLookup.get(1));
				 
				 btnLookup.get(1).click();
	 }

	}

	public void setDdKnowlegBasedNode(String text) {
		DropDownSelectByPartVisibleText(ddKnowLedgeNodeOPtions, text);
	}
	public void clickSaveButton() {
		for(WebElement ele:btnSave) {
			ele.click();
			break;
		}
	}

	public String getTextCaseNo() {
		String s=textCaseNo.getAttribute("value").toString();
		return s ;
	}
	public void LeftsideOfCasecreationForm(String title,String Status,String deadline,String status,String identifier) {
		setTbTitle(title);
		setDdStatus(Status);
		setTbDeadline(deadline);
		setDdStatus(status);
		setTbIdentifer(identifier);
	}
	public String getCaseNumberFromCaseCreationTable() {
		return txtcaseNo.getText().trim();
	}
	
	public void verifycaseCreation() {
		//System.out.println("++++++++"+caseNo);
		//Assert.assertTrue(caseNo.equals(txtcaseNo.getText().trim()));
			
	}

	
	

}
