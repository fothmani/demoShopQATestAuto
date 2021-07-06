package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHomePage {

	protected WebDriver driver;

	static By searchElement = By.className("noo-search");
	static By labelElement = By.className("note-search");
	static By articles = By.className("noo-product-item");
	static By dissmiss = By.className("woocommerce-store-notice__dismiss-link");
	static By divTopBarClass = By.className("noo-topbar");
	static By innerProductCard = By.className("noo-product-inner");
	static By ulTopRightBar = By.className("noo-topbar-right");
	static By wishlistspawn = By.className("yith-wcwl-add-button");

	static By popupwrapper = By.id("yith-wcwl-popup-message");
	static By popuptext = By.id("yith-wcwl-message");

	static By searchInputElement = By.name("s");

	static By aTag = By.tagName("a");
	static By h3Tag = By.tagName("h3");
	static By liTag = By.tagName("li");

	static By firstProductInnerCssSelector = By.cssSelector("div.noo-sh-product-html.columns_3.no_masonry.three.row.is-flex div.noo-product-item:first-child div.noo-product-inner");
	static By productLinkCssSelector = By.cssSelector("div.noo-product-thumbnail a");
	static By titleLinkCssSelector = By.cssSelector("h3 a");
	static By addToWishListCssSelector = By.cssSelector("div.noo-product-meta div.yith-wcwl-add-to-wishlist div.yith-wcwl-add-button a");
	static By alreadyAddedProductPopup = By.cssSelector("div.products div.noo-product-item:first-child div.noo-product-inner div.yith-wcwl-wishlistexistsbrowse a");
	static By addedProductPopup = By.cssSelector("div.yith-wcwl-popup-message div.yith-wcwl-message");


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

	/**
	 * DOES NOT WORK - HIDDEN ELEMENTS ARE BADLY HANDLED BY SELENIUM
	 * @return
	 */
	public boolean isPopupProductAddedDisplayed() {
		WebElement popup = driver.findElement(addedProductPopup);

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

	/**
	 *
	 */
	public void click_dismiss() {
		driver.findElement(dissmiss).click();
	}

	/**
	 *
	 * @return
	 */
	public String clickOnAddToWishListForFirstProduct() {
		WebElement innerFirstProductElement = this.driver.findElement(firstProductInnerCssSelector);
		innerFirstProductElement.findElement(addToWishListCssSelector).click();

		return innerFirstProductElement.findElement(titleLinkCssSelector).getText();
	}

	/**
	 *
	 * @return
	 */
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
