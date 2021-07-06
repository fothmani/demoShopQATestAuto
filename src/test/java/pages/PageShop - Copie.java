package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * 
 * @author POEC-LIL-13
 *
 */
public class PageShop {
	
	/**
	 * 
	 */
	protected WebDriver driver;
	
	static By innerProductCard = By.className("noo-product-inner");
	static By articles = By.className("noo-product-item");
	static By divTopBarClass = By.className("noo-topbar");
	static By ulTopRightBar = By.className("noo-topbar-right");
	static By dissmiss = By.className("woocommerce-store-notice__dismiss-link");
	static By wishlistspawn = By.className("yith-wcwl-add-button");
	
	protected By selectColorFilterName = By.name("filter_color");
	protected By selectSizeFilterName = By.name("filter_size");
	protected By selectStyleFilterName = By.name("filter_style");
	
	protected By aTag = By.tagName("a");
	protected By h3Tag = By.tagName("h3");
	protected By liTag = By.tagName("li");

	static By getproducttitle = By.cssSelector("div.products div.noo-product-item:first-child div.noo-product-inner h3 a");
	static By addtowishlist = By.cssSelector("div.products div.noo-product-item:first-child div.noo-product-inner div.noo-product-thumbnail div.yith-wcwl-add-to-wishlist div.yith-wcwl-add-button a");
	static By alreadyaddedtowishlist = By.cssSelector("div.products div.noo-product-item:first-child div.noo-product-inner div.noo-product-thumbnail div.yith-wcwl-add-to-wishlist div.yith-wcwl-wishlistaddedbrowse a");
	static By alreadyAddedProductPopup = By.cssSelector("div.products div.noo-product-item:first-child div.noo-product-inner div.yith-wcwl-wishlistexistsbrowse a");
	static By addedProductPopup = By.cssSelector("div.yith-wcwl-popup-message div.yith-wcwl-message");
	
	/**
	 * 
	 * @param driver
	 */
	public PageShop(WebDriver driver) {
		this.driver = driver;
	}
	

	/**
	 * DOES NOT WORK - HIDDEN ELEMENTS ARE BADLY HANDLED BY SELENIUM
	 * @return
	 */
	public boolean isPopupProductAddedDisplayed() {
		WebElement popup = driver.findElement(addedProductPopup);
		
		System.out.println(popup);
		System.out.println(popup.isDisplayed());
		System.out.println(popup.getText());
		
		return popup.isDisplayed()
				&& popup.getText().equals("Product added !");
	}
	
	/**
	 * DOES NOT WORK - HIDDEN ELEMENTS ARE BADLY HANDLED BY SELENIUM
	 * @return
	 */
	public boolean isPopupProductAlreadyAddedDisplayed() {
		WebElement popup = driver.findElement(alreadyAddedProductPopup);
		
		return popup.isDisplayed()
				&& popup.getText().equals("The product is already in the wishlist!");
	}
	
	public void click_dismiss() {
		driver.findElement(dissmiss).click();
	}
	
	public Select getColorSelectElement() {
		return new Select(this.driver.findElement(selectColorFilterName));
	}
	
	public Select getSizeSelectElement() {
		return new Select(this.driver.findElement(selectSizeFilterName));
	}
	
	public Select getStyleSelectElement() {
		return new Select(this.driver.findElement(selectStyleFilterName));
	}
	
	
	public void setColorToColorSelectionByValue(String value) {
		this.getColorSelectElement().selectByValue(value);
	}
	
	
	public void setSizeToSizeSelectionByValue(String value) {
		this.getSizeSelectElement().selectByValue(value);
	}
	
	public void setStyleToStyleSelectionByValue(String value) {
		this.getStyleSelectElement().selectByValue(value);
	}
	
	public String clickOnAddToWishListForFirstProduct() {
		driver.findElement(addtowishlist).click();
		return driver.findElement(getproducttitle).getText();
	}
	
	public PageWishlist clickOnAddToWishListForFirstProductButAlreadyAdded() {
		driver.findElement(alreadyaddedtowishlist).click();
		return this.createPageWishlist();
	}
	
	public PageProduct clickOnFirstProductCard() {
		driver.findElement(getproducttitle).click();
		return this.createPageProduct();
	}
	
	public PageWishlist goToPageWishlist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)", "");
		
		driver.findElement(divTopBarClass)
		.findElement(ulTopRightBar)
		.findElement(liTag)
		.findElement(aTag)
		.click();
		
		return this.createPageWishlist();
	}
	
	/**
	 * returns an instance of the Class ProductPage.
	 * @return a product page instance.
	 */
	public PageProduct createPageProduct() {
		return new PageProduct(this.driver);
	}
	
	/**
	 * returns an instance of the Class WishlistPage.
	 * @return a wishlist page instance.
	 */
	public PageWishlist createPageWishlist() {
		return new PageWishlist(this.driver);
	}
}
