package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageAccount;

public class TestCaseConnection {

	WebDriver driver;
	PageAccount objAccount;
	
//	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
		objAccount = new PageAccount(driver);
	}
	
//	@After
	public void tearDown() {
		driver.quit();
	}
	

	
//	@Test
	public void connection_user_test()  {
		objAccount.clickDismissCookie();	
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("test_kadd", "MDPtest_kadd");
		
		Assert.assertEquals("test_kadd", objAccount.getLoginSucess());
	}
	
//	@Test
	public void connection_mail_test()  {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("test_kadd@kadd.fr", "MDPtest_kadd");
		
		Assert.assertEquals("test_kadd", objAccount.getLoginSucess());
	}
		
//	@Test
	public void lost_password_test() {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.clickLostPassword();
		objAccount.fillForgetPassword("kadd_test");
		objAccount.clickResetButton();
		
		Assert.assertEquals("Password reset email has been sent.", objAccount.getMailResetPassword());
	}
	
	
	
//	@Test
	public void connection_password_empty_test() {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("test_kadd", "");
		
		Assert.assertEquals("Error: The password field is empty.", objAccount.getInfoConnectionFail());
	}
	
//	@Test
	public void connection_password_wrong_test() {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("test_kadd", "qsx");
		
		Assert.assertEquals("ERROR: The username or password you entered is incorrect. Lost your password?", objAccount.getInfoConnectionFail());
	}
		
//	@Test
	public void connection_login_wrong_test() {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("osef", "MDPtest_kadd");

		Assert.assertEquals("ERROR: The username or password you entered is incorrect. Lost your password?", objAccount.getInfoConnectionFail());
	}
	
//	@Test
	public void connection_mail_wrong_test() {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("osef@chicken.fr", "MDPtest_kadd");

		Assert.assertEquals("ERROR: The username or password you entered is incorrect. Lost your password?", objAccount.getInfoConnectionFail());
	}
	
//	@Test
	public void connection_login_empty_test() {
		objAccount.clickDismissCookie();		
		objAccount.clickAccountLink();
		objAccount.fillLoginForm("", "MDPtest_kadd");

		Assert.assertEquals("Error: Username is required.", objAccount.getInfoConnectionFail());
	}
}



