package stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrendreContact {

    WebDriver driver;
    PrendreContact googleSearch;

    public PrendreContact(WebDriver driver) {
        this.driver = driver;
    }

    @Before
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }




}
