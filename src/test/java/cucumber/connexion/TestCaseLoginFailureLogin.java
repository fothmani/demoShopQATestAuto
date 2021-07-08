package cucumber.connexion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestCaseLoginFailureLogin {
	
	protected By submitLoginButton = By.className("woocommerce-form-login");
	
	protected By buttonTag = By.tagName("button");
	
	protected By dismissCookie = By.cssSelector("p.demo_store a");
	
	protected By fail_pswrd = By.cssSelector("#post-8 > div > div > div.woocommerce-notices-wrapper > ul > li");
	
	protected By myAccountTextInfo = By.cssSelector("div.woocommerce p strong");
	
	protected By loginInput = By.id("username");
	
	protected By passwordInput = By.id("password");
	
	
	@Given("^(.*) - FL - Je me trouve sur la page de connexion$")
	public void jeMeTrouveSurLaPageDeConnexionFailureLogin(String name) {
		BeforeAfterTest.driver.get("https://shop.demoqa.com/my-account/");
		BeforeAfterTest.driver.findElement(this.dismissCookie).click();
	}
	
	@When("^(.*) - FL - J entre (.*) dans le champ \"username or email address\"$")
	public void jEntreLeLoginDansLeChampUsernameOrEmailAddressFailureLogin(String name, String login) {
		BeforeAfterTest.driver.findElement(loginInput).sendKeys(login);
	}
	
	@And("^(.*) - FL - J entre (.*) dans le champ \"password\"$")
	public void jEntreLeMotDePasseDansLeChampPasswordFailureLogin(String name, String mot_de_passe) {
		BeforeAfterTest.driver.findElement(passwordInput).sendKeys(mot_de_passe);
	}
	
	@And("^(.*) - FL - Je clique sur le bouton Log in$")
	public void jeCliqueSurLeBoutonLogInFailureLogin(String name) {
		BeforeAfterTest.driver.findElement(submitLoginButton).findElement(buttonTag).click();
	}
	
	@Then("^(.*) - FL - Je dois rester sur la page de connexion$")
	public void jeDoisResterSurLaPageDeConnexionFailureLogin(String name) {
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
	
	@And("^(.*) - FL - La page doit afficher le message d erreur (.*)$")
	public void laPageDoitAfficherUnMessageDErreurFailureLogin(String name, String error) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(
				BeforeAfterTest.driver.findElement(fail_pswrd).getText().equals(error)
		);
	}
}
