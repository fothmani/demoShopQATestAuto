package com.formation.epsi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage {

    WebDriver driver;

    //Les elements de la page
    By colorselector = By.id("pa_color");
    By sizeselector = By.id("pa_size");
    By addtocart = By.className("single_add_to_cart_button");
    By iconcart = By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]");
    By titreproduct = By.cssSelector(".product_title.entry-title");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkTitreProduct() {

        return driver.findElement(titreproduct).getText();
    }

    public void clickOniconcart() {
        driver.findElement(iconcart).click();
    }

    public void clickOnColorSelector(String colorProduct) {

        Select colorSelect = new Select(driver.findElement(colorselector));

        colorSelect.selectByVisibleText(colorProduct);
    }

    public void clickOnChooseSize(String sizeProduct) {

        Select sizeSelect = new Select(driver.findElement(sizeselector));
        sizeSelect.selectByValue(sizeProduct);
    }

    public void clickonAddToCart() {
        driver.findElement(addtocart).click();
    }
}
