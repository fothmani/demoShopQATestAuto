package com.formation.epsi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.formation.epsi.pages.DemoShopService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoShopQACodePromo {

	int expectedNbProducts = 16;

	/**
	 * @author Tavia
	 * @param @
	 */

	WebDriver driver;
	String code = "SDINPH";

	// 1. Initialisation du contexte
	@Before
	public void setUp() {
		;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com");
		driver.manage().window().maximize();

	}

	@Test
	public void useWrongCoupon() throws InterruptedException {
		driver.get("https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/");
		driver.manage().window().maximize();

		WebElement elementSize = driver.findElement(By.id("pa_size"));
		Select selectSize = new Select(elementSize);
		selectSize.selectByIndex(1);

		WebElement elementColor = driver.findElement(By.id("pa_color"));
		Select selectColor = new Select(elementColor);
		selectColor.selectByIndex(1);

		elementColor.submit();

		Thread.sleep(2000);
		driver.get("https://shop.demoqa.com/cart/");

		WebElement couponField = driver.findElement(By.id("noo_coupon_code"));
		couponField.sendKeys("coupon");

		driver.findElement(By.xpath("//button[normalize-space()='Apply Coupon']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Coupon \"coupon\" does not exist!']"));

	}

	@Test
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

		// check if the bill is pass.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='woocommerce-thankyou-order-received']"));

	}

	@After
	public void tearDown() {
		driver.quit();

	}

}