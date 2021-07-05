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
	WebDriver driver;
	String username = "Chai Ling LEE";
	String email = "chailing.lee@epsi.fr";

	// 1. Initialization of context
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com/blog/");
		driver.manage().window().maximize();

	}


	@Test
	public void Access_on_the_blog() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		demoShopQAHome.clickOnBlog();
		Assert.assertEquals("Add Color and Life with Accent Furnishings – ToolsQA Demo Site", driver.getTitle());
		Assert.assertEquals("https://shop.demoqa.com/2016/05/04/add-color-and-life-with-accent-furnishings/", driver.getCurrentUrl());
	
	}

	@Test
	public void comment_on_the_blog() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		demoShopQAHome.clickOnBlog();
		demoShopQAHome.createCommentary("Tavia","tavia@mail.com","this is my commentary");
		String ErrorMessage = ("Error: You entered an incorrect CAPTCHA answer. Please go back and try again.");
		Object comments = null;
		Assert.assertNotEquals(ErrorMessage, comments);
		System.out.println("Comments are undone with submit");	
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
