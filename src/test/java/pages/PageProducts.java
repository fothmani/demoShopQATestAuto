package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageProducts {
	
	WebDriver driver;
	By productsElements = By.className("noo-product-item");
	By responseInfo = By.className("woocommerce-info");
	
	public PageProducts(WebDriver driver){
		this.driver = driver;
	}
	
    public String getTextInfoSearchElement() {
    	return driver.findElement(responseInfo).getText();
    }
	
	/**
	 * Get number of Products
	 */
	public int getNumberOfArticles(){
		List<WebElement> listProducts = driver.findElements(productsElements);
		return listProducts.size();
	}
}