package tests;

import org.junit.Assert;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.PageHomePage;
import pages.PageProduct;

public class TestCaseSearchBar {
	
	WebDriver driver;
	PageHomePage objHomePage;
	PageProduct objProducts;
	
	String keyword;
	String expectedLabel = "TYPE AND PRESS ENTER TO SEARCH";
	String expectedSearchInfo= "No products were found matching your selection.";
	int expectedNbArticle;
	
	/**
	 * Executed before Test
	 */
	@Before
    public void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();
    }
	
	/**
	 * Executed after Test
	 */
	@After
    public void tearDown(){
		driver.quit();
    }
	
	
	@Test
	public void testSearch() {
		keyword = "dress";
		expectedNbArticle = 16;
		// Instance of POM homepage
		objHomePage = new PageHomePage(driver);
		// Rechercher l'element search et cliquer dessus
		objHomePage.clickSearchElement();
		
		// Check if label is present, check if Input is enabled
		Assert.assertEquals(expectedLabel, objHomePage.getTextLabelElement());
		Assert.assertTrue("The input search should be enabled", objHomePage.verifySearchInputElement());
		
		// Rechercher l'input de recherche, écrire "dress" dedans, et presser ENTRER
		objHomePage.setSearchInputElement(keyword);
		
		objProducts = new PageProduct(driver);
		Assert.assertEquals(expectedNbArticle, objProducts.getNumberOfArticles());
	}
	
	@Test
	public void testSearchNotPassing() {
		keyword = "test";
		
		// Instance of POM homepage
		objHomePage = new PageHomePage(driver);
		// Rechercher l'element search et cliquer dessus
		objHomePage.clickSearchElement();
		
		// Check if label is present, check if Input is enabled
		Assert.assertEquals(expectedLabel, objHomePage.getTextLabelElement());
		Assert.assertTrue("The input search should be enabled", objHomePage.verifySearchInputElement());
		
		// Rechercher l'input de recherche, écrire "dress" dedans, et presser ENTRER
		objHomePage.setSearchInputElement(keyword);
		
		objProducts = new PageProduct(driver);
		Assert.assertEquals(expectedSearchInfo, objProducts.getTextInfoSearchElement());
	}
}
