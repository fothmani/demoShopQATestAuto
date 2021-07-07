package com.formation.epsi;

import com.formation.epsi.pages.CartPage;
import com.formation.epsi.pages.HomePage;
import com.formation.epsi.pages.HomePageActions;
import com.formation.epsi.pages.ProductDetailPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    WebDriver driver;
    String expectedArticleTitle = "PINK DROP SHOULDER OVERSIZED T SHIRT";
    String refProduct = "tjf14987";
    String colorProduct = "Pink";
    String sizeProduct = "36";
    String secondSizeProduct = "40";
    String secondRefProduct = "br312631";
    String secondColorProduct = "Grey";
    ProductDetailPage pdpPage;
    HomePage shopHomePage;
    HomePageActions homePageActions;
    CartPage shopCartPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();
        pdpPage = new ProductDetailPage(driver);
        shopHomePage = new HomePage(driver);
        shopCartPage = new CartPage(driver);

        homePageActions = new HomePageActions(driver);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkoutScenarioTest_oneProduct() {
        String initialQty;
        String newQty;
        String initialTotalPrice;
        String newTotalPrice;

        Assert.assertTrue(shopHomePage.getSearchLink().isDisplayed());
        homePageActions.clickSearchAction();
        Assert.assertTrue(shopHomePage.checkWriteInSearch().isEnabled());
        shopHomePage.writeInSearch(refProduct);
        assertEquals(expectedArticleTitle, pdpPage.checkTitreProduct());

        pdpPage.clickOnColorSelector(colorProduct);
        pdpPage.clickOnChooseSize(sizeProduct);
        pdpPage.clickonAddToCart();
        pdpPage.clickOniconcart();

        Assert.assertTrue(shopCartPage.getIncreaseButton().isEnabled());
        initialQty = shopCartPage.getItemQtyInputValue(1);

        //augmenter quantité +1
        Assert.assertTrue(shopCartPage.getIncreaseQtyButton().isEnabled());
        shopCartPage.increaseItemQtyAction(1);
        newQty = shopCartPage.getItemQtyInputValue(1);

        assertEquals(Integer.parseInt(initialQty) + 1, Integer.parseInt(newQty));


        // update panier
        initialTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);
        Assert.assertTrue(shopCartPage.getUpdateButton().isEnabled());
        shopCartPage.clickOnUpdate();
        newTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);

        // verifier que le montant a changé
        assertEquals(Double.parseDouble(initialTotalPrice) * 2, Double.parseDouble(newTotalPrice), 0d);

        // decrease quantité
        initialQty = newQty;

        Assert.assertTrue(shopCartPage.getDecreaseQtyButton().isEnabled());
        shopCartPage.decreaseItemQtyAction(1);
        newQty = shopCartPage.getItemQtyInputValue(1);
        assertEquals(Integer.parseInt(initialQty) - 1, Integer.parseInt(newQty));


        //update panier
        initialTotalPrice = newTotalPrice;
        Assert.assertTrue(shopCartPage.getUpdateButton().isEnabled());
        shopCartPage.clickOnUpdate();
        newTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);

        //verifier que le prix a changé
        assertEquals(Double.parseDouble(initialTotalPrice) / 2, Double.parseDouble(newTotalPrice), 0d);
    }

    @Test
    public void checkoutScenarioTest_twoProduct() throws InterruptedException {

        String initialQty;
        String newQty;
        String initialTotalPrice;
        String newTotalPrice;

        Assert.assertTrue(shopHomePage.getSearchLink().isDisplayed());
        homePageActions.clickSearchAction();

        Assert.assertTrue(shopHomePage.checkWriteInSearch().isEnabled());
        shopHomePage.writeInSearch(refProduct);

        assertEquals(expectedArticleTitle, pdpPage.checkTitreProduct());

        //add 1st product
        pdpPage.clickOnColorSelector(colorProduct);
        pdpPage.clickOnChooseSize(sizeProduct);
        pdpPage.clickonAddToCart();

        //add second product
        homePageActions.clickSearchAction();
        shopHomePage.writeInSearch(secondRefProduct);
        pdpPage.clickOnColorSelector(secondColorProduct);
        pdpPage.clickOnChooseSize(secondSizeProduct);
        pdpPage.clickonAddToCart();

        //navigate to cart Page
        pdpPage.clickOniconcart();

        Assert.assertTrue(shopCartPage.getIncreaseButton().isEnabled());
        initialQty = shopCartPage.getItemQtyInputValue(1);

        //augmenter quantité +1
        Assert.assertTrue(shopCartPage.getIncreaseQtyButton().isEnabled());
        shopCartPage.increaseItemQtyAction(1);
        newQty = shopCartPage.getItemQtyInputValue(1);

        assertEquals(Integer.parseInt(initialQty) + 1, Integer.parseInt(newQty));


        // update panier
        initialTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);
        Assert.assertTrue(shopCartPage.getUpdateButton().isEnabled());
        shopCartPage.clickOnUpdate();
        newTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);

        // verifier que le montant a changé
        assertEquals(Double.parseDouble(initialTotalPrice) * 2, Double.parseDouble(newTotalPrice), 0d);

        // decrease quantité
        initialQty = newQty;

        Assert.assertTrue(shopCartPage.getDecreaseQtyButton().isEnabled());
        shopCartPage.decreaseItemQtyAction(1);
        newQty = shopCartPage.getItemQtyInputValue(1);
        assertEquals(Integer.parseInt(initialQty) - 1, Integer.parseInt(newQty));


        //update panier
        initialTotalPrice = newTotalPrice;
        Assert.assertTrue(shopCartPage.getUpdateButton().isEnabled());
        shopCartPage.clickOnUpdate();
        newTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);

        //verifier que le prix a changé
        assertEquals(Double.parseDouble(initialTotalPrice) / 2, Double.parseDouble(newTotalPrice), 0d);

        // supprimer produit

        shopCartPage.removeProduct(1);


        // tests  changements quantite sur deuxieme produit

        //augmenter quantité +1
        initialQty = shopCartPage.getItemQtyInputValue(1);
        Assert.assertTrue(shopCartPage.getIncreaseQtyButton().isEnabled());
        shopCartPage.increaseItemQtyAction(1);
        newQty = shopCartPage.getItemQtyInputValue(1);

        assertEquals(Integer.parseInt(initialQty) + 1, Integer.parseInt(newQty));


        // update panier
        initialTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);
        Assert.assertTrue(shopCartPage.getUpdateButton().isEnabled());
        shopCartPage.clickOnUpdate();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        newTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);

        // verifier que le montant a changé
        assertEquals(Double.parseDouble(initialTotalPrice) * 2, Double.parseDouble(newTotalPrice), 0d);

        // decrease quantité
        initialQty = newQty;

        Assert.assertTrue(shopCartPage.getDecreaseQtyButton().isEnabled());
        shopCartPage.decreaseItemQtyAction(1);
        newQty = shopCartPage.getItemQtyInputValue(1);
        assertEquals(Integer.parseInt(initialQty) - 1, Integer.parseInt(newQty));


        //update panier
        initialTotalPrice = newTotalPrice;
        Assert.assertTrue(shopCartPage.getUpdateButton().isEnabled());
        shopCartPage.clickOnUpdate();
        newTotalPrice = shopCartPage.getItemTotalPrice(1).getText().substring(1);

        //verifier que le prix a changé
        assertEquals(Double.parseDouble(initialTotalPrice) / 2, Double.parseDouble(newTotalPrice), 0d);
    }

   
}
