package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageProduct;

public class TestCaseProduct {

	WebDriver driver;
	
	String expectedProductTitle = "BLUE DENIM SUPER OVERSIZED BOYFRIEND SHIRT";

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
	}
	
	@Test
	public void showProductDetailsFromTitle(){
		PageProduct objProduct = new PageProduct(driver);
				
		objProduct.clickOnSearch();
		objProduct.enterSearching();
		objProduct.selectColor();
		objProduct.selectSize();
		objProduct.clickProduct();		
		Assert.assertEquals(expectedProductTitle, objProduct.getProductTitle());
			}
	
	@Test
	public void showProductDetailsFromCard(){
		PageProduct objProduct = new PageProduct(driver);
				
		objProduct.clickOnSearch();
		objProduct.enterSearching();
		objProduct.selectColor();
		objProduct.selectSize();
		objProduct.clickProductCard();
		Assert.assertEquals(expectedProductTitle, objProduct.getProductTitle());
	}
	
	@After
    public void tearDown() {
        driver.quit();
        System.out.println("Fermeture des fenêtres de test");
    }

}
