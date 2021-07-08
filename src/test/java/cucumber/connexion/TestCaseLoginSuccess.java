package cucumber.connexion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestCaseLoginSuccess {
	
	protected By submitLoginButton = By.className("woocommerce-form-login");
	
	protected By buttonTag = By.tagName("button");
	
	protected By dismissCookie = By.cssSelector("p.demo_store a");
	
	protected By myAccountTextInfo = By.cssSelector("div.woocommerce p strong");
	
	protected By loginInput = By.id("username");
	
	protected By passwordInput = By.id("password");
	
	
	@Given("^(.*) - SC - Je me trouve sur la page de connexion$")
	public void jeMeTrouveSurLaPageDeConnexionSuccess(String name) {
		BeforeAfterTest.driver.get("https://shop.demoqa.com/my-account/");
		BeforeAfterTest.driver.findElement(this.dismissCookie).click();
	}
	
	@When("^(.*) - SC - J entre (.*) dans le champ \"username or email address\"$")
	public void jEntreLeLoginDansLeChampUsernameOrEmailAddressSuccess(String name, String login) {
		BeforeAfterTest.driver.findElement(loginInput).sendKeys(login);
	}
	
	@And("^(.*) - SC - J entre (.*) dans le champ \"password\"$")
	public void jEntreLeMotDePasseDansLeChampPasswordSuccess(String name, String mot_de_passe) {
		BeforeAfterTest.driver.findElement(passwordInput).sendKeys(mot_de_passe);
	}
	
	@And("^(.*) - SC - Je clique sur le bouton Log in$")
	public void jeCliqueSurLeBoutonLogInSuccess(String name) {
		BeforeAfterTest.driver.findElement(submitLoginButton).findElement(buttonTag).click();
	}
	
	@Then("^(.*) - SC - Je dois arriver sur la page de mon compte client$")
	public void jeDoisArriverSurLaPageDeMonCompteClientSuccess(String name) {
		Assert.assertTrue(
				BeforeAfterTest.driver.getCurrentUrl().contains("/my-account")
		);
		
		try {
			Assert.assertTrue(
					BeforeAfterTest.driver.findElement(submitLoginButton) == null
			);
		}
		catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@And("^(.*) - SC - Je dois être connecté en tant que (.*)$")
	public void jeDoisEtreConnecteEnTantQueSuccess(String name, String login) {
		Assert.assertTrue(
				BeforeAfterTest.driver.findElement(this.myAccountTextInfo).getText().contains(login)
		);
	}
}
