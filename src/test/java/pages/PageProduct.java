package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


/**
 * 
 */

public class PageProduct {

	WebDriver driver;
	By searchHeader = By.className("noo-search");
	By searchToolBar = By.name("s");
	By selectColor = By.name("filter_color");
	By selectSize = By.name("filter_size");
	By linkProduct = By.cssSelector(".products .noo-product-item:nth-child(2) h3 a");
	By productTitle = By.cssSelector(".product_title"); 
	By productCard = By.cssSelector(".noo-product-item.product_cat-shirt .noo-product-thumbnail");
	By productsElements = By.className("noo-product-item");
	By responseInfo = By.className("woocommerce-info");
	
	public PageProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnSearch() {
		driver.findElement(searchHeader).click();
	}
	
	public void enterSearching() {
		driver.findElement(searchToolBar).sendKeys("shirt" + Keys.ENTER);
	}
	
	public void selectColor() {
		Select color = new Select(driver.findElement(selectColor));
		color.selectByIndex(2);
	}
	
	public void selectSize() {
		Select size = new Select(driver.findElement(selectSize));
		size.selectByIndex(2);
	}
	
	public void clickProduct() {
		driver.findElement(linkProduct).click();
	}
	
	public String getProductTitle() {
		return driver.findElement(productTitle).getText();
	}
	
	public void clickProductCard() {
		driver.findElement(productCard).click();
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
