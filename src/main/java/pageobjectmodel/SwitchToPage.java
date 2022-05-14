package pageobjectmodel;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtils.Logg;
import commonUtils.baseUtil;

public class SwitchToPage extends baseUtil{
	final static Logger log= Logg.getLogger(SwitchToPage.class);
	public WebDriver driver;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li/a") private List<WebElement> WEtabselection;
	@FindBy(xpath="//li/a[text()='SwitchTo']/parent::li//ul/li/a") private List<WebElement> WESwitchTo ;
	@FindBy(xpath="//li/a[@href='#OKTab']") private WebElement WEAlertWitOkbtn;
	@FindBy(xpath="//li/a[@href='#CancelTab']") private WebElement WEAlertWitOkCancelbtn;
	@FindBy(xpath="//li/a[@href='#Textbox']") private WebElement WEAlertWittextbtn;
	@FindBy(css="button[onclick='alertbox()']") private WebElement alertBoxbtn ;
	@FindBy(css="button[onclick='confirmbox()']") private WebElement confirmBoxbtn ;
	@FindBy(css="button[onclick='promptbox()']") private WebElement promptBoxbtn ;
	@FindBy(xpath="//a[text()='Open New Tabbed Windows ']") private WebElement WEnewTabbtn;
	@FindBy(xpath="//a[text()='Open New Seperate Windows']") private WebElement WEnewSepTabbtn;
	@FindBy(xpath="//a[text()='Open Seperate Multiple Windows']") private WebElement WEnewsepMulTabbtn;
	@FindBy(xpath="//button[contains(text(),'click')]")private List<WebElement> ClickBtntab;
	@FindBy(xpath="//div[@id='dismiss-button']") private WebElement btnclose;
	@FindBy(xpath="//a[@href='#Single']") private WebElement btnSingleFrame;
	@FindBy(xpath="//a[@href='#Multiple']") private WebElement btnmultiFrame;
	@FindBy(css="input[type='text']") private WebElement singleandMultiFrametxtbox;
	@FindBy(xpath="//iframe[@src='MultipleFrames.html']") private WebElement iframeWEOuter;
	@FindBy(xpath="//iframe[@src='SingleFrame.html']") private WebElement iframeWEInner;
	public SwitchToPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void tabSelection(String Tab) {
		for(WebElement s:WEtabselection) {
			if(s.getText().trim().equalsIgnoreCase(Tab)) {
				Actions action =new Actions(driver);
				action.moveToElement(s).build().perform();
				break;
			}
			
		}
	}
	public void clickonTabAttribute(String subtab) throws InterruptedException {
		for(WebElement ele:WESwitchTo) {
			if(ele.getText().trim().equalsIgnoreCase(subtab)) {
				ele.click();
				break;
			}
		}
		//Thread.sleep(3000);
		//driver.switchTo().alert().dismiss();
		
	}
	public void clickonbtn(String btn) {
		WaitForElementToBeClickable(WEAlertWitOkbtn, driver);
		if(WEAlertWitOkbtn.getText().contains(btn)) {
			WEAlertWitOkbtn.click();
			alertBoxbtn.click();
			
		}else if(WEAlertWitOkCancelbtn.getText().contains(btn)) {
			WEAlertWitOkCancelbtn.click();
			confirmBoxbtn.click();
		}else {
			WEAlertWittextbtn.click();
			promptBoxbtn.click();
		}
	
	}
	public void alertcheck(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void alertwithOkcheck() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		String s=driver.findElement(By.id("demo")).getText();
		Assert.assertEquals(s, "You Pressed Cancel");
		log.info("*********************sucessfully alert canceled*************");
	}
	public void promptalertVerfiy() {
		Alert alert=driver.switchTo().alert();
		String alerttext=alert.getText();
		System.out.println(alerttext);
		alert.sendKeys("test");
		alert.accept();
		String str=driver.findElement(By.id("demo1")).getText();
		Assert.assertTrue(str.contains("test"));
		log.info("**********************sucessfully alerts are selected**********************");
		
	}
	
	public void newTabtest() {
		WEnewTabbtn.click();
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(ClickBtntab.get(0)));
		ClickBtntab.get(0).click();
		log.info("****************************click button clicked*********************");
	}
	public void newWindow() throws InterruptedException {
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(WEnewSepTabbtn));
		
		WEnewSepTabbtn.click();
		Thread.sleep(2000);
		ClickBtntab.get(1).click();
		log.info("****************************click button clicked*********************");
	}
	public void newMutiTabSelection() {
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(WEnewsepMulTabbtn));
		WEnewsepMulTabbtn.click();
		ClickBtntab.get(2).click();
		log.info("****************************click button clicked*********************");
	}
	public void ClickonBtnForFrames(String button) {
		if(button.contains("Single")) {
			btnSingleFrame.click();
		}else {
			btnmultiFrame.click();
		}
	}
	public void enterText(String txt) {
		singleandMultiFrametxtbox.sendKeys(txt);
	}
	public void SwitchToFrame(String button,String txt) {
		ClickonBtnForFrames( button);
		if(txt.equalsIgnoreCase("Single")) {
			driver.switchTo().frame("SingleFrame");
			enterText( txt);
			driver.switchTo().defaultContent();
		}else {
			driver.switchTo().frame(iframeWEOuter);
			driver.switchTo().frame(iframeWEInner);
			enterText(txt);
			driver.switchTo().defaultContent();
			btnSingleFrame.click();
		}
		
	}
	
}
