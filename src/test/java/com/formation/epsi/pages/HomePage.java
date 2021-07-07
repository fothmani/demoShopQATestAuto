package com.formation.epsi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    //Les elements de la page
    By searchlink = By.className("noo-search");
    By inputsearch = By.name("s");

    // Appel de constructeur avec le webDriver en argument
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Les actions

    public WebElement getSearchLink() {

        return driver.findElement(searchlink);
    }

    public void clickOnSearchLink() {

        driver.findElement(searchlink).click();
    }

    public void writeInSearch(String idProduct) {

        driver.findElement(inputsearch).sendKeys(idProduct + Keys.ENTER);
    }

    public WebElement getwriteInSearch() {

        return driver.findElement(inputsearch);
    }

    public WebElement checkWriteInSearch() {

        return driver.findElement(inputsearch);
    }
}
