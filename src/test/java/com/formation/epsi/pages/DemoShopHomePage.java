package com.formation.epsi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DemoShopHomePage {
	
	WebDriver driver;
	//les éléments HTML de la page
	By searchLink = By.className("noo-search");
	By searchInputText = By.className("form-control");
	By produit = By.className("noo-product-inner");
	By clickPanier = By.className("cart-name-and-total");
	By titrePagePanier = By.className("page-title");
	By article = By.cssSelector("a[href='https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/?attribute_pa_color=pink&attribute_pa_size=37']");
	By suppArticle = By.className("icon_close_alt2");
	By articleTshirtcatal = By.cssSelector("a (href='https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/')");
	By selectColorArticleTshirt = By.id("pa_color");
	By selectColorRose = By.className("attached enabled");
	By selectSizeArticleTshirt = By.id("pa_size");
	By selectSize37 = By.className("attached enabled");
	By clickAddCart = By.className("single_add_to_cart_button");
	By clearCartBouton = By.className("empty-cart");
	//elise
    By searchInputTest = By.name("s");
    By nbrArticle = By.className("noo-product-inner");
    By telephone = By.cssSelector("a[href='tel:+(099)999-9999']");
    By mail = By.cssSelector("a[href='mailto:nomail@toolsqa.com']");
    By boutonDismiss = By.cssSelector(".woocommerce-store-notice__dismiss-link");
	
	
	//Appel de constructeur avec le webdriver en argument
	public DemoShopHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//les actions
	
	public void clickOnArticlecatal() {
		driver.findElement(articleTshirtcatal).click();
	}
	
	public void choisirColorSizeArticle() {
		driver.findElement(selectColorArticleTshirt).click();
		Select colorRose = new Select(driver.findElement(selectColorArticleTshirt));
		colorRose.selectByIndex(1); 
		driver.findElement(selectSizeArticleTshirt).click();
		Select size37 = new Select(driver.findElement(selectSizeArticleTshirt));
		size37.selectByIndex(2); 
		driver.findElement(clickAddCart).click();
	}
	
	public void clickOnPanier() {
		driver.findElement(clickPanier).click();
	}
	
	public String titrePage() {
		return driver.findElement(titrePagePanier).getText();
	}
	
	public Boolean verifArticleCart() {
		return driver.findElement(suppArticle).isDisplayed();
	}
	
	public void deleteArticle() {
		driver.findElement(suppArticle).click();
	}
	
	public void nomArticle() {
		driver.findElement(article);
	}
	
	public void clickOnSearch() {
		driver.findElement(searchLink).click();
	}
	
	public WebElement searchKeyword() {
		return driver.findElement(searchInputText);
	}
	public void fillSearchInput(String keyword){
		driver.findElement(searchInputText).sendKeys(keyword + Keys.RETURN);
	}
	public void viderPanier(){
		driver.findElement(clearCartBouton).click();
	}
	
	// prendre contact
    public void cliquerSurContactTelephone(){
        driver.findElement(telephone).click();
    }

    public void cliquerSurContactMail(){
        driver.findElement(mail).click();
    }

    public void attendreBoutonDismiss(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-store-notice__dismiss-link")));
        driver.findElement(boutonDismiss).click();

    }

    public WebElement prendreContactPhone(){
        return driver.findElement(telephone);
    }

    public WebElement prendreContactMail(){
        return driver.findElement(mail);
    }

    // barre de recherche

    public WebElement cliquerDansBarre() {
        return driver.findElement(searchInputTest);
    }

    public WebElement searchClick(){
        return driver.findElement(searchLink);
    }

    public int nbProducts(){
        List<WebElement> nbrArticles = driver.findElements(nbrArticle);
        return nbrArticles.size();
    }

}
