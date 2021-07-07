package com.formation.epsi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;
    //Les elements de la page
    By increaseQtyIcon = By.className("qty-increase");
    By decreaseQtyIcon = By.className("qty-decrease");
    By updatecart = By.name("update_cart");
    By qtyInput = By.xpath("(//input[@class='input-text qty text'])[1]");
    By subTotal = By.className("product-subtotal");
    By qtyZone = By.className("product-quantity");
    By productRemove = By.className("product-remove");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseItemQtyAction(int itemIndex) {
        getCartItemByIndex(itemIndex).findElement(increaseQtyIcon).click();
    }


    public void decreaseItemQtyAction(int itemIndex){
        getCartItemByIndex(itemIndex).findElement(decreaseQtyIcon).click();
    }

    public void removeProduct(int itemIndex){
        getCartItemByIndex(itemIndex).findElement(productRemove).click();
    }

    public WebElement getIncreaseButton() {
        return driver.findElement(increaseQtyIcon);

    }

    public WebElement getIncreaseQtyButton(){
        return driver.findElement(increaseQtyIcon);
    }

    public WebElement getDecreaseQtyButton(){
        return driver.findElement(decreaseQtyIcon);
    }


    public WebElement getUpdateButton() {
        return driver.findElement(updatecart);
    }

    public String getItemQtyInputValue(int itemIndex) {
        return getCartItemByIndex(itemIndex).findElement(qtyZone).findElement(qtyInput).getAttribute("value");
    }

    public WebElement getItemTotalPrice(int itemIndex){
        return getCartItemByIndex(itemIndex).findElement(subTotal);
    }

    public WebElement getItemQtyInput(int itemIndex) {
        return getCartItemByIndex(itemIndex).findElement(qtyZone).findElement(qtyInput);
    }

    public void clickOnUpdate() {
        driver.findElement(updatecart).click();
    }

    public WebElement getCartItemByIndex(int index) {
        String xpath = "//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[%s]";
        return driver.findElement(By.xpath(String.format(xpath, index)));
    }
}
