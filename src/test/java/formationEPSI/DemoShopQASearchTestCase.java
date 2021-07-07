package formationEPSI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.formationepsi.pages.DemoShopQAHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

public class DemoShopQASearchTestCase {

	WebDriver driver;
	String keyword = "t shirt";
	int expectedNbProducts = 7;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void SearchArticles() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles2() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles3() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles4() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles5() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles6() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}

	@Test
	public void SearchArticles7() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles8() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles9() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	
	@Test
	public void SearchArticles10() {
		DemoShopQAHomePage demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
		Assert.assertEquals("TYPE AND PRESS ENTER TO SEARCH", demoShopQAHome.getLabel());
		demoShopQAHome.fillSearchInput(keyword);
		Assert.assertEquals(expectedNbProducts, demoShopQAHome.nbProducts());
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
