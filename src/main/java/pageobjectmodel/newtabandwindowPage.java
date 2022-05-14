package pageobjectmodel;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonUtils.Logg;

public class newtabandwindowPage {
	final static Logger log=Logg.getLogger(newtabandwindowPage.class);
	public WebDriver driver;
	@FindBy(xpath="//h2/Strong") WebElement txtHeader;
	public newtabandwindowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void VerfiythenewTab(String StrText) {
	String ParentWindow= driver.getWindowHandle();
	Set<String>handle=driver.getWindowHandles();
	for(String s:handle) {
		if(!s.equals(ParentWindow)) {
			driver.switchTo().window(s);
			Assert.assertEquals(StrText, txtHeader.getText().trim());
			driver.close();
			driver.switchTo().window(ParentWindow);
			break;
		}
	}
		
	}

public void verfiynewWindow(String strText) {
	String ParentWindow=driver.getWindowHandle();
	Set<String> childWindow=driver.getWindowHandles();
	Iterator<String>handle=childWindow.iterator();
	while(handle.hasNext()) {
		String child=handle.next();
		if(!child.equals(ParentWindow)) {
			driver.switchTo().window(child);
			Assert.assertEquals(strText, txtHeader.getText().trim());
			driver.close();
			driver.switchTo().window(ParentWindow);
			break;
		}
	}
}

public void verifymultipleWindow(String strText) {
	String parentWindow=driver.getWindowHandle();
	Set<String>childWindow=driver.getWindowHandles();
	Iterator<String>handle=childWindow.iterator();
	while(handle.hasNext()) {
		String ChildTab=handle.next();
		if(!(ChildTab.equalsIgnoreCase(parentWindow))) {
			driver.switchTo().window(ChildTab);
			if(txtHeader.getText().trim().equalsIgnoreCase(strText)) {
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
			
			
		}
	}
}
}
