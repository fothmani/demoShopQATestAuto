package formationEPSI;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.formationepsi.pages.DemoShopService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoShopeQAFilter {

	WebDriver driver;
	String keyword = "Dress";
	String expectedTitle = keyword + "-Recherche Demo Shop";

	// 1. Initialization of the context
	@Before
	public void setUp() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://shop.demoqa.com/shop/");
		driver.manage().window().maximize();

	}

	@Test
	public void filter_color_test() {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		//Select the black color
		demoShopQAHome.filterColor(DemoShopService.BLACK_INDEX);
		String value = demoShopQAHome.getValueColorFilter();
		System.out.println(value);
		Assert.assertEquals("59", value);
		
		//Select the blue color
		demoShopQAHome.filterColor(DemoShopService.BLUE_INDEX);
		value = demoShopQAHome.getValueColorFilter();
		Assert.assertEquals("61", value);
	}

	@Test
	public void filter_size_test() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		//Select the small size of the article
		demoShopQAHome.selectFilterSize(DemoShopService.sizecloth_small);
		String value = demoShopQAHome.getValueSizeFilter();
		Assert.assertEquals("64", value);
		//click on the article
		demoShopQAHome.clickOnCatalogueElement();
		
		String size = demoShopQAHome.getSmallSizeArticle();
		Assert.assertEquals(DemoShopService.sizecloth_small, size);

	}

	@Test
	public void filter_grid_test() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		//selecting the style of the page
		demoShopQAHome.selectFilterStyle(DemoShopService.filterstyle);
		String value = demoShopQAHome.getValueStyleFilter();
		Assert.assertEquals("Grid", value);

	}

	@Test
	public void filter_default_sorting() throws InterruptedException {
		DemoShopService demoShopQAHome = new DemoShopService(driver);
		//selecting the products'popularity
		demoShopQAHome.select_filter_default_sorting(DemoShopService.filter_sorting_by_popularity);
		String value = demoShopQAHome.getTextDefautSorting();

		Assert.assertEquals(DemoShopService.filter_sorting_by_popularity, value);
	}

	@After
	public void tearDown() {
		driver.quit();

	}

}
