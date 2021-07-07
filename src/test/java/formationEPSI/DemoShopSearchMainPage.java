package formationEPSI;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.formationepsi.pages.DemoShopService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoShopSearchMainPage {
	
	int expectedNbProducts = 7;
	
	/**
	 * @author Tavia
	 * @param
	 * @
	 */
	
	WebDriver driver;	
	String keyword = "Dress";
	String expectedTitle = keyword + "– ToolsQA Demo Site";
	
	//1. Initialisation du contexte
	@Before
	public void setUp() {;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void DemoSearch() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		demoShopQAHome.clickOnsearch();
		demoShopQAHome.inputSearch(keyword);
		Thread.sleep(1000);

		Assert.assertEquals(16, demoShopQAHome.nbProducts());

		
		
	}
	@After
	public void tearDown() {
		driver.quit();
		
	}
	
    

}
