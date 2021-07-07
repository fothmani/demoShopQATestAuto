package tests;

import org.junit.*;
import org.junit.runner.RunWith;
import java.util.Arrays;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.PageAccount;
import org.junit.experimental.runners.Enclosed;


//@RunWith(Enclosed.class)
public class TestCaseConnectionParameters {	


//	@RunWith(Parameterized.class)
	public static class TheParameterizedPart {

		// Our two parameters
		private String username;
		private String password;
		WebDriver driver;
		PageAccount objAccount;

		// Constructor is initialized with one set of parameters every time
		public TheParameterizedPart(final String username, final String password) 
		{
			this.username = username;
			this.password = password;
		}

//		@Before
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://shop.demoqa.com/");
			driver.manage().window().maximize();
			objAccount = new PageAccount(driver);
		}

//		@After
		public void tearDown() {
			driver.quit();
		}

//		@Parameters
		public static Iterable<Object []> data() 
		{
			return Arrays.asList(new Object[][] {{ "test_kadd", "azert" }, 
				{ "test_kadd", "" }, 
				{ "", "MDPtest_kadd" }, 
				{ "aert", "MDPtest_kadd" } });
		}

//		@Test
		public void test_fail() {
			objAccount.clickDismissCookie();	
			objAccount.clickAccountLink();
			objAccount.fillLoginForm(username, password);

			Boolean connexionFail = objAccount.countInfoConnectionFail() > 0;
			Assert.assertTrue(connexionFail);

		}
	}

//	@RunWith(Parameterized.class)
	public static class otherParameterizedTest {
		private String username;
		private String password;
		WebDriver driver;
		PageAccount objAccount;

		public otherParameterizedTest(final String username, final String password) 
		{
			this.username = username;
			this.password = password;
		}

//		@Before
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://shop.demoqa.com/");
			driver.manage().window().maximize();
			objAccount = new PageAccount(driver);
		}

//		@After
		public void tearDown() {
			driver.quit();
		}


//		@Parameters
		public static Iterable<Object []> data() 
		{
			return Arrays.asList(new Object[][] {{ "test_kadd", "MDPtest_kadd" }, 
				{ "test_kadd@kadd.fr", "MDPtest_kadd" }});
		}

//		@Test
		public void connection_mail_test()  {
			objAccount.clickDismissCookie();		
			objAccount.clickAccountLink();
			objAccount.fillLoginForm(username, password);
			Assert.assertEquals("test_kadd", objAccount.getLoginSucess());
		}
	}
}