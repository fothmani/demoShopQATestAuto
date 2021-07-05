package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageHomePage {
	WebDriver driver;
	By searchElement = By.className("noo-search");
	By searchInputElement = By.name("s");
	By labelElement = By.className("note-search");

	
	public PageHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setSearchInputElement(String strSearch){
		driver.findElement(searchInputElement).sendKeys(strSearch + Keys.ENTER);
	}
	
	public boolean verifySearchInputElement(){
		return driver.findElement(searchInputElement).isEnabled();
	}
	
    //Click on searchElement link
    public void clickSearchElement(){
    	driver.findElement(searchElement).click();
    }
    
    public String getTextInputElement() {
    	return driver.findElement(searchInputElement).getText();
    }
    
    public String getTextLabelElement(){
    	return driver.findElement(labelElement).getText();
    }
}