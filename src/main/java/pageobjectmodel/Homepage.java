package pageobjectmodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.Logg;
import commonUtils.baseUtil;

public class Homepage extends baseUtil{
	 final static Logger log = Logg.getLogger(Homepage.class);
	WebDriver driver;
	@FindBy(xpath="//ul[@class='mlddm']/li/a") private List<WebElement> tabSelection;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitForFrameToBeAvailableAndSwitchToIt("mainpanel", driver);
	}
	///home page tab selection from main panel frame
	public void TabSelection(String subTab,String tab) {
		log.info("-------------------------Tab selection stat________________");
		
		Actions action=new Actions(driver);
		int flag=0;
 		for(WebElement ele:tabSelection) {
			if(ele.getAttribute("title").trim().equalsIgnoreCase(tab)){
				action.moveToElement(ele).build().perform();
				List<WebElement> subTabElement=driver.
						findElements(By.xpath("//ul[@class='mlddm']/li/a[@title='"+tab+"']/parent::li/ul/li/a"));
				for(WebElement ele1:subTabElement) {
					if(ele1.getAttribute("title").equals(subTab)) {
						ele1.click();
						flag=1;
						log.info("------------------Tab selected from Home page-------------------------------");
						break;
						
					}
				}
				
			}
			if(flag==1) {
				break;
			}
		}
		
		//action.moveToElement(((WebElement) tabSelection).getAttribute("title"));
		
		
	}
	

}
