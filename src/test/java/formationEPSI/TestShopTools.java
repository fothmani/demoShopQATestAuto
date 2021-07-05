package com.formation;

import com.formationEpsi.pagesObject.DemoShopHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.formationEpsi.pagesObject.DemoShopHomePage;

public class TestShopTools {

    public static void main(String[] args) {
        //String projectPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://shop.demoqa.com/");

        /*WebElement searchLink = driver.findElement(By.className("noo-search"));
        searchLink.click();
        WebElement searchInputText = driver.findElement(By.name("s"));
        searchInputText.sendKeys("dress");
        searchInputText.submit();
        List<WebElement> nbrArticle = driver.findElements(By.className("noo-product-inner"));
        System.out.println(nbrArticle.size());
        */
        DemoShopHomePage demoShopHomePage = new DemoShopHomePage(driver);
        demoShopHomePage.clickOnSearch();
        demoShopHomePage.fillSearchInput("dress");
        //Thread.sleep(1000); on attend le résultat pour quil compte
        demoShopHomePage.nbProducts();

    }
}
