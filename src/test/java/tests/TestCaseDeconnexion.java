package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageAccount;


/**
 * 
 * @author POEC-LIL-13
 *
 */
public class TestCaseDeconnexion {
	
	/**
	 * The web driver used for the tests
	 */
	protected WebDriver driver;
	
	/**
	 * the user's login
	 */
	protected String userLogin = "test_kadd";
	
	/**
	 * the user's password
	 */
	protected String userPassword = "MDPtest_kadd";
	
	
	/**
	 * Connect the user dedicated to the tests
	 * @param demoshop_login the page account's object.
	 * @return true if the user's connection succeeded. False if it fails.
	 */
	public boolean connectUser(PageAccount demoshop_login) {
		try {
			demoshop_login.clickDismissCookie();
			demoshop_login.clickAccountLink();
			demoshop_login.fillLoginForm(userLogin,userPassword);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		catch(Error e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Sets up driver for the tests with chrome driver
	 */
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	    this.driver = new ChromeDriver();
	    this.driver.get("https://shop.demoqa.com/");
		this.driver.manage().window().maximize();
	}
	
	/**
	 * stops the driver
	 */
	@After
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.driver.close();
	}
	
	/**
	 * Test Case : disconnection by the link within the text paragraph about user.
	 */
	@Test
	public void testCaseDisconnectionByLinkInTextParagraph() throws InterruptedException {
		PageAccount page = new PageAccount(this.driver);
		
		assertTrue(this.connectUser(page));
		
		page.clickLogOutLinkInsideTextParagraph();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(page.isDisconnected());
	}
	
	/**
	 * Test Case : disconnection by the link within the left navigation bar
	 */
	@Test
	public void testCaseDisconnectionByLinkInLeftNavBar() throws InterruptedException {
		PageAccount page = new PageAccount(this.driver);
		
		assertTrue(this.connectUser(page));
		
		page.clickLogOutLinkWithinLeftNavBar();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(page.isDisconnected());
	}
}
