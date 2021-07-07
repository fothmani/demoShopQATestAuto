package com.formation.epsi;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.formation.epsi.pages.DemoShopHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjetDemoShopAuto {
	WebDriver driver;
	String titre = "CART";
	String keyword = "PINK DROP SHOULDER OVERSIZED T SHIRT";
	
	//initialisation
		@Before
		public void setUp() {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("https://shop.demoqa.com/");
			driver.manage().window().maximize();
		}
		
		@Test
		public void supprimerUnArticle() {
			DemoShopHomePage ShopDemo = new DemoShopHomePage(driver);
			ShopDemo.clickOnSearch();
			ShopDemo.fillSearchInput(keyword);
			ShopDemo.choisirColorSizeArticle();
			ShopDemo.clickOnPanier();
			Assert.assertEquals(titre, ShopDemo.titrePage());
			ShopDemo.deleteArticle();
			Assert.assertFalse("Article supprimé", ShopDemo.verifArticleCart());
		}
		
		@Test
		public void viderLePanier() {
			DemoShopHomePage ShopDemo = new DemoShopHomePage(driver);
			ShopDemo.clickOnSearch();
			ShopDemo.fillSearchInput(keyword);
			ShopDemo.choisirColorSizeArticle();
			ShopDemo.clickOnPanier();
			Assert.assertEquals(titre, ShopDemo.titrePage());
			ShopDemo.viderPanier();
			Assert.assertFalse("Article supprimé", ShopDemo.verifArticleCart());
		}

		@After
		public void tearDown() {
			driver.quit();
		}
		
}
