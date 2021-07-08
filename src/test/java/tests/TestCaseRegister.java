package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageAccount;

public class TestCaseRegister {
	
	WebDriver driver;
	PageAccount accountObj;
	
	// DATASET :
	String validUsername = "Franciscabrouul";
	String validEmail = "franciscabroull@franciscabroiul.fr";
	String validPassword = "Un1Mdp2Pas3Complexe4";
	
	String validUsernameNotRegistered = "Davido";
	String validEmailNotRegistered = "Davido@Davido.fr";
	
	String invalidUsername = "TestUffusername\"";
	String invalidEmail = "testFormatioon@testFormation";
	
	// Expected String :
	String expectedInfoAfterRegister = "Your session has expired because it has been over 60 minutes since your last login. Please log back in to continue.";
	String expectedInfoAlreadyRegister = "Error: An account is already registered with your email address. Please log in.";
	String expectedInfoInvalidUsername = "Error: Please enter a valid account username.";
	String expectedInfoInvalidEmail = "Error: Please provide a valid email address.";
	
	/**
	 * Executed before Test
	 */
	@Before
    public void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();
    	accountObj = new PageAccount(driver);
    }
	
	/**
	 * Executed after Test
	 */
	@After
    public void tearDown(){
		driver.quit();
    }
	
	/**
	 * Test register Account
	 */
	@Test
	public void testRegisterWithValidData() {
		accountObj.clickDismissCookie();
		accountObj.clickAccountLink();
		accountObj.fillRegisterForm(validUsername, validEmail, validPassword);
		
		if(accountObj.getInfoNotRegister() != 0) {
			System.out.println("testCreateAccount(): Account already created");
			Assert.assertEquals(expectedInfoAlreadyRegister, accountObj.getExpectedInfoNotRegister());
		}
		else {
			System.out.println("testCreateAccount(): Account created");
			Assert.assertEquals(expectedInfoAfterRegister, accountObj.getExpectedInfoAfterRegister());
		}
	}
	
	/**
	 * Test register account with invalid Username
	 */
	@Test
	public void testRegisterWithInvalidUsername() {
		accountObj.clickDismissCookie();
		accountObj.clickAccountLink();
		accountObj.fillRegisterForm(invalidUsername, validEmailNotRegistered, validPassword);
		
		if(accountObj.getInfoNotRegister() != 0) {
			Assert.assertEquals(expectedInfoInvalidUsername, accountObj.getExpectedInfoNotRegister());
		}
	}
	
	/**
	 * Test register account with invalid Email
	 */
	@Test
	public void testRegisterWithInvalidEmail() {
		accountObj.clickDismissCookie();
		accountObj.clickAccountLink();
		accountObj.fillRegisterForm(validUsernameNotRegistered, invalidEmail, validPassword);
		
		if(accountObj.getInfoNotRegister() != 0) {
			Assert.assertEquals(expectedInfoInvalidEmail, accountObj.getExpectedInfoNotRegister());
		}
	}
}
