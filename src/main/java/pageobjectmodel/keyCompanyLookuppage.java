package pageobjectmodel;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.Logg;

public class keyCompanyLookuppage {
	final static Logger log=Logg.getLogger(contactLookupPage.class);
	WebDriver driver;
	@FindBy(name="search") private WebElement tbSearch;
	@FindBy(css="input.button[value='Search']") private WebElement btnSearch;
	@FindBy(xpath="//td[@class='datatitle']"
			+ "/parent::tr/parent::tbody/child::tr/td/a ") private List<WebElement> col;
	public keyCompanyLookuppage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void selectCompanyLookUp(String text) {
		log.info("------------------Switch to comanay page-----------------");
		Set<String>handle=driver.getWindowHandles();
		String parentwindow=driver.getWindowHandle();
		Iterator<String>it=handle.iterator();
		while(it.hasNext()) {
			String tab=it.next();
			if(!tab.equals(parentwindow)) {
				driver.switchTo().window(tab);
				break;
			}
		}
		tbSearch.clear();
		tbSearch.sendKeys(text);
		btnSearch.click();
		int columncount=col.size();
		for(int i=0;i<columncount;i++) {
			if(col.get(i).getText().contains(text)) {
				col.get(i).click();
				driver.switchTo().window(parentwindow);
				driver.switchTo().frame("mainpanel");
				
				log.info("-----------------sucessfully switchback from keycomp window---------");
				break;
				
			}
		}
	}
	
}
