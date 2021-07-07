package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCaseLoginValidCredentials {
protected WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
	
	@Given("Je suis sur la page d'accueil de Google")
	public void jeSuisSurLaPageAccueil() {
		
	}
	
	@When("^Je saisis le texte (.*)$")
	public void jeSaisisLeTexte(String text) {
		//TODO
	}
	
	@And("J'appuie sur la touche entrée du clavier")
	public void jAppuieSurLaToucheEntreeDuClavier() {
		//TODO
	}
	
	@Then("Je dois être redirigé vers la page \"\"")
	public void jeDoisEtreRedirigeVersLaPage() {
		//TODO
	}
}
