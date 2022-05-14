package pageobjectmodel;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonUtils.Logg;
import commonUtils.baseUtil;
import io.cucumber.datatable.DataTable;

public class companiesPage extends baseUtil {
	final static Logger log=Logg.getLogger(companiesPage.class);
	WebDriver driver;
	@FindBy(css="input[name='name']") private WebElement txtboxName;
	@FindBy(xpath="//input[@aria-autocomplete='list']/parent::div/div/i") private List<WebElement> DDPhone;
	@FindBy(xpath="//input[@placeholder='Number']") private WebElement Numbertxt;
	@FindBy(xpath="//input[@placeholder='Home, Work, Mobile...']") private WebElement HomeWork;
	@FindBy(name="priority") private WebElement ddPriorty;
	@FindBy(xpath="//div[@name='status']") private WebElement DDStatus;
	@FindBy(xpath="//div[@class='item']/child::button") private List<WebElement> cancelSavebutton;
	@FindBy(xpath="//button[@class='ui tiny basic icon button']/i[@class='add icon']") private List<WebElement> AddButton;
	public companiesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void TabSelection(String tab) {
		WebElement tabSel=driver.findElement(By.xpath("//div[@id='main-nav']/div/a[@href='/"+tab+"']"));
		WebElement tabbuttonforAdd=driver.findElement(By.xpath("//a[@href='/"+tab+"']/following-sibling::button[@class='ui mini basic icon button']"));
		Actions action=new Actions(driver);
		action.moveToElement(tabSel).build().perform();
		tabbuttonforAdd.click();
		
	}
	public void setName(DataTable dt) {
		List<Map<String,String>> data=dt.asMaps(String.class, String.class);
		txtboxName.sendKeys(data.get(0).get("Name"));
	}
	public void setPhone(DataTable dt) {
		List<Map<String,String>> data=dt.asMaps(String.class, String.class);
		String Phone=data.get(0).get("Phone");
		String DDValue=Phone.split(" ")[0];
		String Number =Phone.split(" ")[1].toString().trim();
		String Home=Phone.split(" ")[2].toString().trim();
		//Select select= new Select(DDPhone.get(1));
		//select.selectByVisibleText(DDValue);
		Numbertxt.sendKeys(Number);
		HomeWork.sendKeys(Home);
	}
	public void setpriority(DataTable dt) {
		List<Map<String,String>> data=dt.asMaps(String.class, String.class);
		String prio= data.get(0).get("priority");
		ddPriorty.click();
		driver.findElement(By.xpath("//div[@name='priority']/span[text()='"+prio+"']")).click();
 		//Select select =new Select(ddPriorty);
		//select.selectByVisibleText(prio);
		//DropDownSelectionByVisibleText(ddPriorty, data.get(0).get("priority"));
	}
	public void setstatus(DataTable dt) {
		List<List<String>> data=dt.asLists(String.class);
		DropDownSelectionByVisibleText(DDStatus, data.get(0).get(3));
		
	}
	public void buttonSave() {
		cancelSavebutton.get(0).click();
	}
	
}
