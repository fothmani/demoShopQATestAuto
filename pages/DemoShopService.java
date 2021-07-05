package com.formation.epsi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemoShopService {

	public WebDriver driver;

	// The elements on the main page
	public static final By SearchButton = By.className("noo-search");
	public static final By Search = By.className("noo-search");
	public static final By inputSearch = By.name("s");
	public static final By nbProducts = By.className("noo-product-item");

	// The elements in the filters
	public static final By filter_color = By
			.cssSelector(".noo_woocommerce-catalog .noo-shop-filter:nth-child(2) .noo-woo-filter");
	public static final By color_list = By.id("pa_color");
	public static final By filter_article_size = By.id("pa_size");
	public static final By size_list = By
			.cssSelector(".noo_woocommerce-catalog .noo-shop-filter:nth-child(3) .noo-woo-filter");
	public static final By filter_grid = By
			.cssSelector(".noo_woocommerce-catalog .noo-shop-filter:nth-child(4) .noo-woo-filter");

	public static final By filter_sorting = By.xpath(
			"//body/div[@id='noo-site']/div[@class='noo-container-shop noo-shop-wrap']/div[@class='noo-container-catalog']/div[@class='noo-catalog']/form[@class='woocommerce-ordering']/select[1]");

	public static final By first_element_catalogue = By.cssSelector(
			"div[class='noo-product-item one noo-product-sm-4 not_featured post-1162 product type-product status-publish has-post-thumbnail product_cat-dress product_cat-maxi-dresses product_tag-dress product_tag-maxi product_tag-women has-featured first instock sale shipping-taxable purchasable product-type-variable'] div[class='owl-item active'] img[class='product-one-thumb']");

	public static final int BLACK_INDEX = 2;
	public static final int BLUE_INDEX = 3;
	public static final String sizecloth_small = "Small";
	public static final String filterstyle = "Grid";
	public static final String filter_sorting_by_popularity = "Sort by popularity";

	// The elements in the blog and commentary
	public static final By blog_title = By.linkText("Add Color and Life with Accent Furnishings");
	public static final By clickName = By.className("comment-form-author noo-md-6");
	public static final By inputName = By.id("author");
	public static final By clickEmail = By.cssSelector(".comment-form-email noo-md-6.email:nth-child(1)");
	public static final By inputEmail = By.name("email");

	// The elements for the promotion code
	public static final String nameOfArticle = ("PINK DROP SHOULDER OVERSIZED T SHIRT");
	public static final By articleColor = By.id("pa_color");
	public static final String color_pink = "Pink";
	public static final By articleSize = By.id("pa_size");
	public static final int size_36 = 36;
	public static final By clickAddToCart = By.className("single_add_to_cart_button button alt");
	public static final By clickCartIcon = By.className("icon_bag_alt");
	public static final By clickOnPromoCode = By.id("noo_coupon_code");

	public static final int PINK_INDEX = 1;
	public static final int SIZE_INDEX = 1;

	// Call the constructors with the webDriver in argument
	public DemoShopService(WebDriver driver) {
		this.driver = driver;
	}

	// The actions

	public void clickOnsearch() {
		driver.findElement(SearchButton).click();

	}

	public void clickOnBlog() {
		driver.findElement(blog_title).click();
	}

	public void clickOnName() {
		driver.findElement(clickName).click();
	}

	public void clickOnCatalogueElement() {
		driver.findElement(first_element_catalogue).click();
	}

	public void clickOnEmail() {
		driver.findElement(clickEmail).click();

	}

	public void clickOnColor() {
		driver.findElement(articleColor).click();

	}

	public void clickOnSize() {
		driver.findElement(articleSize).click();
	}

	public void clickOnAddToCart() {
		driver.findElement(clickAddToCart).click();
	}

	/**
	 * Clicking on the Cart Icon
	 */
	public void clickOnCartIcon() {
		driver.findElement(clickCartIcon).click();
	}

	public void inputSearch(String keyword) {
		driver.findElement(inputSearch).sendKeys(keyword + Keys.RETURN);

	}

	public void inputPromoCode(String code) {
		driver.findElement(clickOnPromoCode).sendKeys(code + Keys.RETURN);

	}

	public int nbProducts() {
		List<WebElement> productsElements = driver.findElements(nbProducts);
		return productsElements.size();

	}

	public void filterColor(int coloritem) {
		Select filterdropdown = new Select(driver.findElement(filter_color));
		filterdropdown.selectByIndex(coloritem);
	}

	public void selectFilterSize(String sizecloth) throws InterruptedException {
		Select sizeDropdown = new Select(driver.findElement(size_list));
		sizeDropdown.selectByVisibleText(sizecloth);

	}

	public void selectFilterStyle(String filterstyle) {
		Select GridDropdown = new Select(driver.findElement(filter_grid));
		GridDropdown.selectByVisibleText(filterstyle);

	}

	/**
	 * Select the products by sorting
	 */

	public void select_filter_default_sorting(String defaultSorting) {
		Select SortingDropdown = new Select(driver.findElement(filter_sorting));
		SortingDropdown.selectByVisibleText(defaultSorting);
	}

	/**
	 * The method of the colors
	 * 
	 * @return the value of the select filter color
	 */
	public String getValueColorFilter() {
		Select filter_value_dropdown = new Select(driver.findElement(filter_color));
		return filter_value_dropdown.getFirstSelectedOption().getAttribute("value");

	}

	/**
	 * Method to check the values of the sizes
	 * 
	 * @return the value of the select filter size
	 */
	public String getValueSizeFilter() {
		Select filter_value_dropdown = new Select(driver.findElement(size_list));
		return filter_value_dropdown.getFirstSelectedOption().getAttribute("value");
	}

	/**
	 * Method to get the values of the filter grid
	 * 
	 * @return the value of the select filter grid
	 */
	public String getValueStyleFilter() {
		Select filter_value_dropdown = new Select(driver.findElement(filter_grid));
		return filter_value_dropdown.getFirstSelectedOption().getAttribute("value");

	}

	/**
	 * Method to get the sorting's option based on popularity
	 * 
	 * @return the text of the sorting's option
	 */
	public String getTextDefautSorting() {
		Select filter_value_dropdown = new Select(driver.findElement(filter_sorting));
		return filter_value_dropdown.getFirstSelectedOption().getText();
	}

	/**
	 * Method to check if the article page have a "small" size
	 * 
	 * @return String
	 */
	public String getSmallSizeArticle() {
		String size = "";
		Select filter_value_dropdown = new Select(driver.findElement(filter_article_size));
		List<WebElement> options = filter_value_dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement option = options.get(i);
			String text = option.getText();
			if (text.equals(sizecloth_small)) {
				size = text;
				break;
			}
		}
		return size;

	}

	/**
	 * Method to create a commentary on the blog page
	 *
	 */

	public void createCommentary(String name, String mail, String commentary) {
		WebElement nameField = driver.findElement(By.id("author"));
		nameField.sendKeys(name);

		WebElement mailField = driver.findElement(By.id("email"));
		mailField.sendKeys(mail);

		WebElement commentaryField = driver.findElement(By.id("comment"));
		commentaryField.sendKeys(commentary);
		commentaryField.submit();

		// validate the commentary with an error message
		driver.findElement(By.xpath("//input[@id='submit']")).click();

	}

	/**
	 * Method to select the color of the article on the product page
	 */
	public void color_on_the_product_page(int colorchoice) {
		Select article_color_dropdown = new Select(driver.findElement(articleColor));
		article_color_dropdown.selectByIndex(colorchoice);
	}

	/**
	 * Method to get the value of the color "pink" from HTML
	 * 
	 * @return the value of the color "pink"
	 */
	public String getValueColorArticle() {
		Select article_color_value_dropdown = new Select(driver.findElement(articleColor));
		return article_color_value_dropdown.getFirstSelectedOption().getAttribute("value");
	}

	/**
	 * Method to select the size of the article on the product page
	 */
	public void size_on_the_product_page(String sizechoice) throws InterruptedException {
		Select article_size_dropdown = new Select(driver.findElement(articleSize));
		article_size_dropdown.selectByVisibleText(sizechoice);
	}

	/**
	 * Method to get the value of the size 36 from HTML
	 * 
	 * @return the value of the size 36
	 */
	public String getValueSizeArticle() {
		Select article_size_value_dropdown = new Select(driver.findElement(articleSize));
		return article_size_value_dropdown.getFirstSelectedOption().getAttribute("value");
	}

	/**
	 * Method to check the invalid coupon code with an error message
	 */
	public void insertCoupon(String code) {
		WebElement codeField = driver.findElement(By.id("noo_coupon_code"));
		codeField.sendKeys(code);

	}

}
