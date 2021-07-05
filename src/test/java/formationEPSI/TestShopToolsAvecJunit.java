package com.formation;

import com.formationEpsi.pagesObject.DemoShopHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestShopToolsAvecJunit {
    WebDriver driver;
    String keyword ="dress";


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://shop.demoqa.com/");

        }

    @Test
    public void rechercheArticle(){
       // DemoShopHomePage demoShopHomePage = new DemoShopHomePage(driver);
        DemoShopHomePage demoShopHomePage = new DemoShopHomePage(driver);
        Assert.assertEquals("le champ cliquable",true,demoShopHomePage.searchClick().isEnabled());
        demoShopHomePage.clickOnSearch();
        Assert.assertEquals(true, demoShopHomePage.cliquerDansBarre().isEnabled());
        demoShopHomePage.fillSearchInput(keyword);
        //Assert.assertTrue("dress", demoShopHomePage.cliquerDansBarre().isDisplayed());
        //Thread.sleep(1000); on attend le résultat pour quil compte
        demoShopHomePage.nbProducts();
        Assert.assertEquals(16,demoShopHomePage.nbProducts());

    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
