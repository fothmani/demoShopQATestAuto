package formationEPSI;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.formationepsi.pages.DemoShopService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoShopQACodePromo {

	int expectedNbProducts = 16;

	/**
	 * @author Tavia
	 * @param @
	 */

	WebDriver driver;

	// 1. Initialisation du contexte
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com");
		driver.manage().window().maximize();

	}

	@Test
	public void useWrongCoupon() throws InterruptedException {
		DemoShopService demService = new DemoShopService(driver);

		// select article
		driver.get("https://shop.demoqa.com/shop");
		demService.clickOnCatalogueElement();

		// check if the prices of the article are there
		Boolean isContainPrice = driver.getPageSource().contains("20.00");
		Assert.assertEquals(true, isContainPrice);

		// choose the size and color of the article
		WebElement elementSize = driver.findElement(By.id("pa_size"));
		Select selectSize = new Select(elementSize);
		selectSize.selectByIndex(1);

		WebElement elementColor = driver.findElement(By.id("pa_color"));
		Select selectColor = new Select(elementColor);
		selectColor.selectByIndex(1);

		// add the product to the cart
		elementColor.submit();

		// check the cart's quantity, price and the "addMessage"
		Thread.sleep(1000);
		Boolean isQuantityOk = driver.getPageSource().contains("Cart(1)");
		Assert.assertEquals(true, isQuantityOk);

		String priceBasket = driver.findElement(By.xpath("//a[@title='View cart']//bdi[1]")).getText();
		Assert.assertEquals("₹21.00", priceBasket);

		Boolean isMessageAdd = driver.getPageSource()
				.contains("“Black Cross Back Maxi Dress” has been added to your cart.");
		Assert.assertEquals(true, isMessageAdd);

		// click to the cart's icon
		driver.findElement(By.xpath("//i[@class='icon_bag_alt']")).click();

		// control the elements on the page
		Boolean isCouponMesage = driver.getPageSource().contains("Enter your code if you have one");
		Assert.assertEquals(true, isCouponMesage);

		Boolean isSubTotal = driver.getPageSource().contains("Subtotal");
		Assert.assertEquals(true, isSubTotal);

		// enter the promotion's code
		WebElement couponField = driver.findElement(By.id("noo_coupon_code"));
		couponField.sendKeys("azerty");

		// submit the promotion's code
		driver.findElement(By.xpath("//button[normalize-space()='Apply Coupon']")).click();

		// check the error message
		WebElement errorMsgWebElement = driver
				.findElement(By.xpath("//li[normalize-space()='Coupon \"azerty\" does not exist!']"));
		Assert.assertNotNull(errorMsgWebElement);

	}

	
	public void commandProduct() throws InterruptedException {
		driver.get("https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/");

		WebElement elementSize = driver.findElement(By.id("pa_size"));
		Select selectSize = new Select(elementSize);
		selectSize.selectByIndex(1);

		WebElement elementColor = driver.findElement(By.id("pa_color"));
		Select selectColor = new Select(elementColor);
		selectColor.selectByIndex(1);

		elementColor.submit();

		Thread.sleep(2000);
		// Enter the payment's information
		driver.get("https://shop.demoqa.com/cart/");

		driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("billing_first_name")).sendKeys("Jean");
		driver.findElement(By.id("billing_last_name")).sendKeys("Francois");
		driver.findElement(By.id("billing_address_1")).sendKeys("1 street");
		driver.findElement(By.id("billing_city")).sendKeys("Bombay");
		driver.findElement(By.id("billing_postcode")).sendKeys("356006");
		driver.findElement(By.id("billing_phone")).sendKeys("0606060606");
		driver.findElement(By.id("billing_email")).sendKeys("a@hotmail.fr" + Keys.RETURN);

		driver.findElement(By.id("place_order")).submit();

		// To check if the bill is passed.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='woocommerce-thankyou-order-received']"));

	}

	@After
	public void tearDown() {
		driver.quit();

	}

}