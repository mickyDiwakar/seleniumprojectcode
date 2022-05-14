package pageobjectmodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtils.Logg;
import commonUtils.baseUtil;

public class ToolsQAWebTablesPage extends baseUtil {
	final static Logger log=Logg.getLogger(ToolsQAWebTablesPage.class);
	private WebDriver driver;
	@FindBy(xpath="//div[@class='category-cards']/child::div//div[@class='card-body']/h5") private List<WebElement> WEdemoHomePageIconSelection;
	@FindBy(xpath="//div[@class='header-text']/span") private List<WebElement> WEItem;
	@FindBy(xpath="//div/ul[@class='menu-list']/li/span") List<WebElement> WESubItemSelection;
	@FindBy(xpath="//div[@class='rt-thead -header']/following-sibling::div/div[@class='rt-tr-group']/div[@role='row']") List<WebElement> Row;
	@FindBy(xpath="//div[@class='rt-thead -header']/following-sibling::div/div[@class='rt-tr-group'][1]/div[@role='row']/div") private List<WebElement> Col;
	@FindBy(id="age") private WebElement WEage;
	@FindBy(css="button#submit")WebElement Submitbtn;
	@FindBy(id="addNewRecordButton") private WebElement Addbtn;
	public ToolsQAWebTablesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void ClickHomePageIconSelection(String s) {
		for(WebElement ele:WEdemoHomePageIconSelection) {
			System.out.println(ele.getText());
			if(ele.getText().trim().equalsIgnoreCase(s)) {
				ele.click();
				break;
			}
		}
	}
	public void ClickItemSelection(String s) {
		for(WebElement ele:WEItem) {
			if(ele.getText().equalsIgnoreCase(s)) {
				ele.click();
				break;
			}
		}
	}
	public void ClickSubItemSelection(String s) {
		for(WebElement ele:WESubItemSelection) {
			if(ele.getText().equalsIgnoreCase(s)) {
				ele.click();
				break;
			}
		}
	}
	public String GetRowValue(int rowNumber) {
		int row=Row.size();
		int col=Col.size();
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='rt-thead -header']/following-sibling::div/div[@class='rt-tr-group']["+rowNumber+"]/div[@role='row']/div"));
		// System.out.println(ele.get(0).getText().toString());
		return ele.get(0).getText().toString();
	}
	public void verfiythefetchedVlauefromRow(int rowNumber,String s) {
		String fetchvalue=GetRowValue(rowNumber);
		if(fetchvalue.trim().equals(s)){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
	public void ActionbuttonOnWebTable(int row,String buttonName) {
		
		List<WebElement>actionbutton=driver.findElements(By.xpath("//div[@class='rt-thead -header']"
				+ "/following-sibling::div/div[@class='rt-tr-group']["+row+"]/div[@role='row']/div[7]/div/span"));
		switch (buttonName.toLowerCase()) {
		case "edit":
			actionbutton.get(0).click();
			break;
		case "delete":
			actionbutton.get(1).click();
			break;
		}
		
	}
	public void editAgeRowValue(int age) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(WEage));
		WEage.clear();
		WEage.sendKeys(String.valueOf(age));
		Submitbtn.click();
		
	}
	public void VerfiytheTablevalueChanged(String fiedlName,String row,String newValue) {
		switch(fiedlName) {
		case "Age":
			WebElement ele=driver.findElement(By.xpath("//div[@class='rt-thead -header']/following-sibling::div/div[@class='rt-tr-group']["+row+"]/div[@role='row']/div[3]"));
			//System.out.println(ele.getText().toString());
			Assert.assertEquals(ele.getText(), newValue);
			break;
		}		
	}
	public void VerfiytheRowDeleted(int rownum) {
		//int i;
		int flag=0;
		WaitForElementTobeVisible(Row.get(0), driver);
		for( int i=1;i<=Row.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='rt-thead -header']/following-sibling::div/"
					+ "div[@class='rt-tr-group']["+i+"]/div[@role='row']/div[6]"));
			System.out.println(ele.getText());
			if(! ele.getText().equalsIgnoreCase("Compliance")) {
				Assert.assertTrue(true);
				flag=1;
				break;
			}
		}
		if( flag!=1) {
			Assert.assertTrue(false);
		}
	}
	public void btnclick(String btnName) {
		if(btnName.equals("Add")) {
			Addbtn.click();
			log.info("*******************Add button Clicked on Webtable page****************");
		}
	}
	public void VerfiynewRowAdded() {
		System.out.println(RegisterFormPage.fname);
		int flag=0;
		for(int i=1;i<=Row.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='rt-thead -header']/following-sibling::div/"
					+ "div[@class='rt-tr-group']["+i+"]/div[@role='row']/div[1]"));
			if(ele.getText().equalsIgnoreCase(RegisterFormPage.fname)) {
				Assert.assertTrue(true);
				flag=1;
				break;
			}
			
		}
		if(flag!=1) {
			Assert.assertTrue(false);
		}
	}
}
