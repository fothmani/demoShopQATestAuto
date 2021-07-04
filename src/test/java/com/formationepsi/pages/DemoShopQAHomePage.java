package com.formationepsi.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DemoShopQAHomePage {

	WebDriver driver;
	// les élements de la page
	By searchLink = By.className("noo-search");
	By searchInputElement = By.name("s");
	By productElement = By.className("noo-product-item");
	By searchLabel = By.className("note-search");

	// Appel de constructeur avec le webDriver en argument
	public DemoShopQAHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Les actions
	public void clickOnsearch() {
		driver.findElement(searchLink).click();
	}

	public void fillSearchInput(String keyword) {
		driver.findElement(searchInputElement).sendKeys(keyword + Keys.RETURN);
	}

	public int nbProducts() {
		List<WebElement> productsElements = driver.findElements(productElement);
		return productsElements.size();
	}

	public String getLabel() {
		return driver.findElement(searchLabel).getText();
	}

}
