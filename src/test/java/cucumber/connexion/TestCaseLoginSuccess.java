package cucumber.connexion;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCaseLoginSuccess {
	
	protected WebDriver driver;
	
	protected By submitLoginButton = By.className("woocommerce-form-login");
	
	protected By dismissCookie = By.cssSelector("p.demo_store a");
	
	protected By myAccountTextInfo = By.cssSelector("div.woocommerce p strong");
	
	protected By loginInput = By.id("username");
	
	protected By passwordInput = By.id("password");
	
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
	
	@After
	public void setDown() {
		this.driver.close();
	}
	
	@Given("^(.*) - Je me trouve sur la page de connexion$")
	public void jeMeTrouveSurLaPageDeConnexionSuccess(String name) {
		this.driver.get("https://shop.demoqa.com/my-account/");
		this.driver.findElement(this.dismissCookie).click();
	}
	
	@When("^(.*) - J entre (.*) dans le champ \"username or email address\"$")
	public void jEntreLeLoginDansLeChampUsernameOrEmailAddressSuccess(String name, String login) {
		this.driver.findElement(loginInput).sendKeys(login);
	}
	
	@And("^(.*) - J entre (.*) dans le champ \"password\"$")
	public void jEntreLeMotDePasseDansLeChampPasswordSuccess(String name, String mot_de_passe) {
		this.driver.findElement(passwordInput).sendKeys(mot_de_passe);
	}
	
	@And("^(.*) - Je clique sur le bouton Log in$")
	public void jeCliqueSurLeBoutonLogInSuccess(String name) {
		this.driver.findElement(submitLoginButton).click();
	}
	
	@Then("^(.*) - Je dois arriver sur la page de mon compte client$")
	public void jeDoisArriverSurLaPageDeMonCompteClientSuccess(String name) {
		Assert.assertTrue(
				this.driver.getCurrentUrl().contains("/my-account")
		);
		
		try {
			Assert.assertTrue(
					this.driver.findElement(submitLoginButton) == null
			);
		}
		catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@And("^(.*) - Je dois être connecté en tant que (.*)$")
	public void jeDoisEtreConnecteEnTantQueSuccess(String name, String login) {
		Assert.assertTrue(
				this.driver.findElement(this.myAccountTextInfo).getText().contains(login)
		);
	}
}
