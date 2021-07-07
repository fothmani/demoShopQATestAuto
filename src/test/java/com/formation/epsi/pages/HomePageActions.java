package com.formation.epsi.pages;

import com.formation.epsi.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageActions {

    WebDriver driver;

    public void clickSearchAction() {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchLink();
    }

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
    }
}
