package cucumber.connexion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestCaseLoginFailurePassword {
	
	protected By submitLoginButton = By.className("woocommerce-form-login");

	protected By buttonTag = By.tagName("button");
	
	protected By dismissCookie = By.cssSelector("p.demo_store a");
	
	protected By fail_pswrd = By.cssSelector("#post-8 > div > div > div.woocommerce-notices-wrapper > ul > li");
	
	protected By myAccountTextInfo = By.cssSelector("div.woocommerce p strong");
	
	protected By loginInput = By.id("username");
	
	protected By passwordInput = By.id("password");
	
	
	@Given("^(.*) - FP - Je me trouve sur la page de connexion$")
	public void jeMeTrouveSurLaPageDeConnexionFailurePassword(String name) {
		BeforeAfterTest.driver.get("https://shop.demoqa.com/my-account/");
		BeforeAfterTest.driver.findElement(this.dismissCookie).click();
	}
	
	@When("^(.*) - FP - J entre (.*) dans le champ \"username or email address\"$")
	public void jEntreLeLoginDansLeChampUsernameOrEmailAddressFailurePassword(String name, String login) {
		BeforeAfterTest.driver.findElement(loginInput).sendKeys(login);
	}
	
	@And("^(.*) - FP - J entre (.*) dans le champ \"password\"$")
	public void jEntreLeMotDePasseDansLeChampPasswordFailurePassword(String name, String mot_de_passe) {
		BeforeAfterTest.driver.findElement(passwordInput).sendKeys(mot_de_passe);
	}
	
	@And("^(.*) - FP - Je clique sur le bouton Log in$")
	public void jeCliqueSurLeBoutonLogInFailurePassword(String name) {
		BeforeAfterTest.driver.findElement(submitLoginButton).findElement(buttonTag).click();
	}
	
	@Then("^(.*) - FP - Je dois rester sur la page de connexion$")
	public void jeDoisResterSurLaPageDeConnexionFailurePassword(String name) {
		Assert.assertTrue(
				BeforeAfterTest.driver.getCurrentUrl().contains("/my-account")
		);
		
		try {
			Assert.assertTrue(
					BeforeAfterTest.driver.findElement(submitLoginButton) != null
			);
		}
		catch(NoSuchElementException e) {
			Assert.assertTrue(false);
		}
	}
	
	@And("^(.*) - FP - La page doit afficher le message d erreur (.*)$")
	public void laPageDoitAfficherUnMessageDErreurFailurePassword(String name, String error) {
		Assert.assertTrue(
				BeforeAfterTest.driver.findElement(fail_pswrd).getText().equals(error)
		);
	}
}
