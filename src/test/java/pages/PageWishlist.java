package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageWishlist {
	
	protected WebDriver driver;
	
	static By home  = By.className("home");
	static By rowsOfArticlesCssSelector = By.cssSelector("form#yith-wcwl-form table.wishlist_table tbody.wishlist-items-wrapper");
	static By nameOfProductCssSelector = By.cssSelector("tr td.product-name a");
	
	
	public PageWishlist(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public PageWishlist goToHomePage () {
		driver.findElement(home).click();
		return new PageWishlist(this.driver);
	}
	
	public List<WebElement> getarticles() {
		return driver.findElements(rowsOfArticlesCssSelector);
	}
	
	public boolean isArticlePresentInWishList(String article) {
		List<WebElement> articles = this.getarticles();
		Iterator<WebElement> it = articles.iterator();
		
		while(it.hasNext()) {
			String name = it.next().findElement(nameOfProductCssSelector).getText();
			
			if(name.equalsIgnoreCase(article)) {
				return true;
			}
		}
		
		return false;
	}
}
	
	
