package commonUtils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConfigfileReader.ConfigFileReader;
import ConfigfileReader.fileReaderManager;

public abstract class baseUtil {
	WebDriver driver;
	WebDriverWait wait;
	public  ConfigFileReader configFileReader;
	
	public baseUtil() {
		configFileReader=fileReaderManager.getfileReaderManagerInstance().getConfigReader();
		
		
	}
	public void clickOn(WebElement ele) {
		ele.click();
	}
	public void WaitForElementTobeVisible(WebElement ele,WebDriver driver) {
		wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public void WaitForFrameToBeAvailableAndSwitchToIt(String ele,WebDriver driver) {
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}
	public void WaitForFrameToBeAvailableAndSwitchToIt(WebElement ele,WebDriver driver) {
		wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}
	
	public void WaitForElementToBeClickable(WebElement ele,WebDriver driver) {
		wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void DropDownSelectionByVisibleText(WebElement ele,String text) {
		Select select=new Select(ele);
		select.selectByVisibleText(text);
	}
	public void DropDwnSelectionByValue(WebElement ele,String text) {
		Select select=new Select(ele);
		select.selectByValue(text);
	
	}
	public void DropDownSelectionByIndex(WebElement ele,int id) {
		Select select =new Select(ele);
		select.deselectByIndex(id);
	}
	public void DropDownSelectByPartVisibleText(List<WebElement> partlinkWebElement,String text) {
		
		for(WebElement option:partlinkWebElement) {
			if(option.getText().contains(text)) {
				option.click();
			}
		}
		
		
	}

}
