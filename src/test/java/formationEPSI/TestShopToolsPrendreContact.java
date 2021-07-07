package com.formation;

import com.formationEpsi.pagesObject.DemoShopHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestShopToolsPrendreContact {

    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/");

    }


    @Test
    public void prendreContact() {
        DemoShopHomePage demoShop = new DemoShopHomePage(driver);

        demoShop.attendreBoutonDismiss();
        //assert a faire qui permet de dire que la fenetre s'est bien fermé
        Assert.assertEquals("le champ cliquable", true, demoShop.prendreContactPhone().isEnabled());
        Assert.assertTrue("", demoShop.prendreContactPhone().isDisplayed() && demoShop.prendreContactPhone().isEnabled());
        demoShop.cliquerSurContactTelephone();
        Assert.assertEquals("le champ cliquable", true,demoShop.prendreContactMail().isDisplayed() && demoShop.prendreContactMail().isEnabled() );
        Assert.assertTrue("", demoShop.prendreContactPhone().isEnabled());
        demoShop.cliquerSurContactMail();
    }

