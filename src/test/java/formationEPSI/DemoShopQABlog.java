package com.formation.epsi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.formation.epsi.pages.DemoShopService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoShopQABlog {
	private WebDriver driver;

	// 1. Initialization of context
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com/blog/");
		driver.manage().window().maximize();

	}

	@Test
	public void accessOnTheBlog() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		demoShopQAHome.clickOnBlog();
		Assert.assertEquals("Add Color and Life with Accent Furnishings – ToolsQA Demo Site", driver.getTitle());
		Assert.assertEquals("https://shop.demoqa.com/2016/05/04/add-color-and-life-with-accent-furnishings/",
				driver.getCurrentUrl());

	}

	@Test
	public void commentOnBlogWithoutFillCapcha() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		demoShopQAHome.clickOnBlog();
		demoShopQAHome.createCommentary("Tavia", "tavia@mail.com", "this is my commentary");

		Thread.sleep(1000);

		Boolean isCommentary = driver.getPageSource().contains("this is my commentary");
		Assert.assertEquals(false, isCommentary);

		Boolean isError = driver.getPageSource()
				.contains("Error: You entered an incorrect CAPTCHA answer. Please go back and try again!");
		Assert.assertEquals(true, isError);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
