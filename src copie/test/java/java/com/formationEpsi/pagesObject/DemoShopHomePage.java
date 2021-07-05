package java.com.formationEpsi.pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DemoShopHomePage {

    WebDriver driver;


    //éléments de la page
    By searchLink = By.className("noo-search");
    By searchInputTest = By.name("s");
    By nbrArticle = By.className("noo-product-inner");
    By telephone = By.cssSelector("a[href='tel:+(099)999-9999']");
    By mail = By.cssSelector("a[href='mailto:nomail@toolsqa.com']");
    By boutonDismiss = By.cssSelector(".woocommerce-store-notice__dismiss-link");

    //appel de constructeuravec le webDriver en argument
    public DemoShopHomePage(WebDriver driver){
        this.driver = driver;
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

    public void clickOnSearch (){
        driver.findElement(searchLink).click();
    }

    public WebElement searchClick(){
        return driver.findElement(searchLink);
    }





    public void fillSearchInput(String keyword){
        driver.findElement(searchInputTest).sendKeys(keyword + Keys.RETURN);
    }

    public int nbProducts(){
        List<WebElement> nbrArticles = driver.findElements(nbrArticle);
        return nbrArticles.size();
    }

}
