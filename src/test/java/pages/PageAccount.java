package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PageAccount {
	
	/**
	 * The web driver used by the page
	 */
	WebDriver driver;
	
	// ________________________________________________________________________________________________________________________
	
	// Register:
	By r_usernameInput = By.id("reg_username");
	By r_emailInput = By.id("reg_email");
	By r_passwordInput = By.id("reg_password");
	By submitRegisterButton = By.cssSelector("button[name=\"register\"]");
	// ________________________________________________________________________________________________________________________
	
	// Login:
	/**
	 * the id of the user login input
	 */
	By usernameInput = By.id("username");
	/**
	 * the id of the user password input
	 */
	By passwordInput = By.id("password");
	/**
	 * the class name for the form login
	 */
	protected By submitLoginButton = By.className("woocommerce-form-login");
	protected By buttonTag = By.tagName("button");
	
	By getConnectionSuccess = By.cssSelector("div.woocommerce p strong");
	// ________________________________________________________________________________________________________________________

	// Forgotten password:
	/**
	 * the css selector of the link to forgot password
	 */
	By lost_pswd = By.cssSelector("#customer_login > div.u-column1.col-1 > form > p.woocommerce-LostPassword.lost_password > a");
	By pswrd_forget = By.id("user_login");
	By reset_button = By.cssSelector("#post-8 > div > div > form > p:nth-child(4) > button");
    By msg_pswrd_sent = By.cssSelector("#post-8 > div > div > div");
    By fail_pswrd = By.cssSelector("#post-8 > div > div > div.woocommerce-notices-wrapper > ul > li");
	// ________________________________________________________________________________________________________________________
	
    // Logout:

	/**
	 * the class name for the div that wraps text paragraph
	 */
	protected By divTextPClassName = By.className("woocommerce-MyAccount-content");
	/**
	 * the class name for the link within the navigation bar
	 */
	protected By logOutLinkNavBarClassName = By.className("woocommerce-MyAccount-navigation-link--customer-logout");
	/**
	 * the a tag
	 */
	protected By aTag = By.tagName("a");
	/**
	 * the p tag
	 */
	protected By pTag = By.tagName("p");
	
	

	// ________________________________________________________________________________________________________________________

	/**
	 * the css selector of the account link
	 */
	By accountLink = By.cssSelector("a[href=\"https://shop.demoqa.com/my-account/\"]");
	/**
	 * the class name of the dismiss button
	 */
	By dismissCookie = By.cssSelector("p.demo_store a");
	
	By expectedInfoAfterRegister = By.cssSelector("p[class=\"login message\"]");
	By expectedInfoNotRegister = By.cssSelector("ul[class=\"woocommerce-error\"] li");
	
	
	public PageAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Tells if the user is disconnected.
	 * @return true if the page account shows the form to login in. Otherwise it is false.
	 */
	public boolean isDisconnected() {
		try {
			this.driver.findElement(submitLoginButton);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}

	//Fill
	//_________________________________________________________________________________________
	
	public void fillUsernameInputRegister(String content) {
		driver.findElement(r_usernameInput).sendKeys(content);
	}
	
	public void fillEmailInputRegister(String content) {
		driver.findElement(r_emailInput).sendKeys(content);
	}
	
	public void fillPasswordInputRegister(String content) {
		driver.findElement(r_passwordInput).sendKeys(content);
	}
	
	public void fillRegisterForm(String username, String email, String password) {
		this.fillUsernameInputRegister(username);
		this.fillEmailInputRegister(email);
		this.fillPasswordInputRegister(password);
		this.clickSubmitRegisterButton();
	}
	
	/**
	 * Kaddour
	 */
	public void fillUsernameInputLogin(String log) {
		driver.findElement(usernameInput).sendKeys(log);
	}
	/**
	 * Kaddour
	 */
	public void fillPasswordInputLogin(String pswd) {
		driver.findElement(passwordInput).sendKeys(pswd);
	}
	
	public void fillLoginForm(String username, String password) {
		this.fillUsernameInputLogin(username);
		this.fillPasswordInputLogin(password);
		this.clickSubmitLoginButton();
	}
	
	/**
	 * Kaddour
	 */
	public void fillForgetPassword(String username) {
		driver.findElement(pswrd_forget).sendKeys(username);
	}
	
	// Click
	//_________________________________________________________________________________________
	
	public void clickSubmitRegisterButton() {
		driver.findElement(submitRegisterButton).click();
	}
	
	public void clickAccountLink() {
		driver.findElement(accountLink).click();
	}
	
	public void clickDismissCookie() {
		driver.findElement(dismissCookie).click();
	}
	
	/**
	 * Kaddour
	 */
	public void clickSubmitLoginButton() {
		driver.findElement(submitLoginButton).findElement(buttonTag).click();
	}
	/**
	 * Kaddour
	 */
	public void clickLostPassword() {
		driver.findElement(lost_pswd).click();
	}
	/**
	 * Kaddour
	 */
	public void clickResetButton() {
		driver.findElement(reset_button).click();
	}
	/**
	 * Clicks on the log out link within the text p about user informations.
	 */
	public void clickLogOutLinkInsideTextParagraph() {
		this.driver.findElement(this.divTextPClassName)
					.findElement(pTag)
					.findElement(aTag).click();
	}
	/**
	 * Clicks on the log out link within the navigation bar on the left
	 */
	public void clickLogOutLinkWithinLeftNavBar() {
		this.driver.findElement(logOutLinkNavBarClassName).findElement(aTag).click();
	}


	// Getter
	//_________________________________________________________________________________________
	
	
	public String getExpectedInfoAfterRegister() {
		return driver.findElement(expectedInfoAfterRegister).getText();
	}

	public String getExpectedInfoNotRegister() {
		return driver.findElement(expectedInfoNotRegister).getText();
	}
	
	public int getInfoNotRegister() {
		return driver.findElements(expectedInfoNotRegister).size();
	}
	
	/**
	 * Kaddour
	 * @return text return by sucess Login.
	 */
	public String getLoginSucess() {
		return driver.findElement(getConnectionSuccess).getText();
	}
	
	/**
	 * Kaddour
	 * @return
	 */
	public String getMailResetPassword() {
		return driver.findElement(msg_pswrd_sent).getText();
	}
	
	/**
	 * Kaddour
	 * @return
	 */
	public String getInfoConnectionFail() {
		return driver.findElement(fail_pswrd).getText();
	}
}
