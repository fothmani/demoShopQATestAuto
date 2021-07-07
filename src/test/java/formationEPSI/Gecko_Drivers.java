package formationEPSI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gecko_Drivers {

	public static void main(String[] args) {

		// Appel de la racine du projet
		// String projectPath = System.getProperty("user.dir");
		// System.out.println(projectPath);

		// Ajout de firefox webdriver (geckodriver)
		// System.setProperty("webdriver.gecko.driver", projectPath +
		// "/drivers/geckodriver/geckodriver.exe");

		// webdriverManager
		WebDriverManager.firefoxdriver().setup();

		// instanciation de l'objet
		WebDriver driver = new FirefoxDriver();

		// naviguer vers l'url
		// driver.get("https://www.google.fr");
		driver.get("https://shop.demoqa.com/");

		// recherche sur la page
		WebElement Search = driver.findElement(By.className("noo-search"));
		Search.click();
		
		// id de l'element chercher
		WebElement inputSearch = driver.findElement(By.name("s"));
		inputSearch.sendKeys("dress" + Keys.RETURN);
		
		//stocker le résultat dans une liste
		 List<WebElement> productsElements = driver.findElements(By.className("noo-product-item"));
		 System.out.println("Le nombre d'articles doit être égale à" + productsElements.size());
		 
		//fermature du driver;
		 driver.close();

	}
	
}
