package com.formation.epsi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com/shop");
		driver.manage().window().maximize();

	}

	@Test
	public void addArticleToCart() throws InterruptedException {
		driver.findElement(By.xpath(
				"//div[@class='noo-product-item one noo-product-sm-4 not_featured post-1162 product type-product status-publish has-post-thumbnail product_cat-dress product_cat-maxi-dresses product_tag-dress product_tag-maxi product_tag-women has-featured first instock sale shipping-taxable purchasable product-type-variable']//div[@class='owl-item active']"))
				.click();

		new Select(driver.findElement(By.id("pa_size"))).selectByIndex(1);
		new Select(driver.findElement(By.id("pa_color"))).selectByIndex(1);
		driver.findElement(By.id("pa_color")).submit();

		Thread.sleep(1000);

		Assert.assertEquals(true,
				driver.getPageSource().contains("“Black Cross Back Maxi Dress” has been added to your cart."));

		driver.findElement(By.xpath("//i[@class='icon_bag_alt']")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals(true, driver.getPageSource().contains("Black Cross Back Maxi Dress - Beige"));
	}

	@After
	public void tearDown() {
		driver.quit();

	}

}
