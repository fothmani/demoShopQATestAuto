package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


/**
 *
 */

public class PageProduct {

	protected WebDriver driver;

	protected String url;

	static By addtowishlist = By.className("yith-wcwl-add-button");
	static By pageHeadingSection = By.className("noo-page-heading");
	static By pageHeadingTitle = By.className("page-title");
	static By productsElements = By.className("noo-product-item");
	static By productname = By.className("product_title entry-title");
	static By responseInfo = By.className("woocommerce-info");
	static By searchHeader = By.className("noo-search");
	static By topBarClass = By.className("noo-topbar-right");
	
	static By selectcolor = By.id("pa_color");
	static By selectsize = By.id("pa_size");
	static By popuptext = By.id("yith-wcwl-popup-message");
	static By popupwrapper = By.id("yith-wcwl-message");

	static By searchToolBar = By.name("s");
	static By selectColor = By.name("filter_color");
	static By selectSize = By.name("filter_size");
	
	static By wishlist = By.name("My Wishlist");

	static By aTag = By.tagName("a");
	static By liTag = By.tagName("li");

	static By alreadyAddedProductPopup = By.cssSelector("div.products div.noo-product-item:first-child div.noo-product-inner div.yith-wcwl-wishlistexistsbrowse a");
	static By addedProductPopup = By.cssSelector("div.yith-wcwl-popup-message div.yith-wcwl-message");
	static By linkProduct = By.cssSelector(".products .noo-product-item:nth-child(2) h3 a");
	static By productTitle = By.cssSelector(".product_title");
	static By productCard = By.cssSelector(".noo-product-item.product_cat-shirt .noo-product-thumbnail");


	public PageProduct(WebDriver driver) {
		this.driver = driver;
		this.url = this.driver.getCurrentUrl();
	}


	public boolean isPopupProductAddedDisplayed() {
		WebElement popup = driver.findElement(addedProductPopup);

		System.out.println(popup);
		System.out.println(popup.isDisplayed());
		System.out.println(popup.getText());

		return popup.isDisplayed()
				&& popup.getText().equals("Product added !");
	}

	public boolean isPopupProductAlreadyAddedDisplayed() {
		WebElement popup = driver.findElement(alreadyAddedProductPopup);

		return popup.isDisplayed()
				&& popup.getText().equals("The product is already in the wishlist!");
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

	public void setoptioncolor(String color) {
		Select selectObject = new Select(driver.findElement(selectcolor));
		selectObject.selectByValue(color);
	}

	public void setoptionsize(String size) {
		Select selectObject = new Select(driver.findElement(selectsize));
		selectObject.selectByValue(size);
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

	public void clickOnAddToWishList() {
		driver.findElement(addtowishlist).click();
	}

	public String getProductName() {
		return driver.findElement(pageHeadingSection).findElement(pageHeadingTitle).getText();
	}

	public PageWishlist goToWishlist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)", "");

		driver.findElement(topBarClass).findElements(liTag).get(0).findElement(aTag).click();
		return new PageWishlist(driver);
	}

}
