package tests;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageHome;
import pages.PageProduct;
import pages.PageShop;
import pages.PageWishlist;


/**
 *
 * @author POEC-LIL-13
 *
 */
public class TestCaseWishlist {

	/**
	 *
	 */
	protected WebDriver driver;


	/**
	 * Initialisation du contexte de test
	 * Nettoyage de la wish list avant les tests
	 */
//	@Before
	public void setup() {
		// Appel de webdriver manager
		WebDriverManager.chromedriver().setup();

		// Instanciation de l'objet
		driver = new ChromeDriver();

		// Mettre le browser en plein �cran
		driver.manage().window().maximize();

		// Naviguer vers l'url
		driver.get("http://shop.demoqa.com/wishlist/");
	}

	/**
	 * set the start page of the current test
	 * @param url
	 */
	public void setStartPage(String url) {
		// Naviguer vers l'url
		driver.get("http://shop.demoqa.com/"+url);
	}

	/**
	 * Sleeps some time
	 * @param time the time in milliseconds
	 */
	public void sleepSomeTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fermer la fen�tre du navigateur
	 */
//	@After
	public void tearDown() {
		// D�lai pour laisser la page se charger compl�tement avant de la fermer
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Fermer la fen�tre
		driver.close();
	}

	/**
	 * Add an article to the wish list by the home page
	 */
//	@Test
	public void testAddToWishlistHome() {
		this.setStartPage("");

		PageHome pagehome = new PageHome(this.driver);
		pagehome.click_dismiss();

		String productname = pagehome.clickOnAddToWishListForFirstProduct();
		this.sleepSomeTime(1000);
//		assertTrue(pagehome.isPopupProductAddedDisplayed());

		PageWishlist pagewishlist = pagehome.goToPageWishlist();
		assertTrue(pagewishlist.isArticlePresentInWishList(productname));
	}

	/**
	 * Add an article to the wish list by the shop page
	 */
//	@Test
	public void testAddToWishlistShop() {
		this.setStartPage("shop/");

		PageShop pageshop = new PageShop(this.driver);
		pageshop.click_dismiss();

		String productname = pageshop.clickOnAddToWishListForFirstProduct();
		this.sleepSomeTime(1000);
//		assertTrue(pageshop.isPopupProductAddedDisplayed());

		PageWishlist pagewishlist = pageshop.goToPageWishlist();
		assertTrue(pagewishlist.isArticlePresentInWishList(productname));
	}

	/**
	 * Add an article to the wish list by the product page
	 */
//	@Test
	public void testAddToWishlistProduct() {
		this.setStartPage("shop/");

		PageShop pageshop = new PageShop(this.driver);
		pageshop.click_dismiss();

		PageProduct pageproduct = pageshop.clickOnFirstProductCard();
		pageproduct.clickOnAddToWishList();
		this.sleepSomeTime(1000);
//		assertTrue(pageproduct.isPopupProductAddedDisplayed());

		String productname = pageproduct.getProductName();
		PageWishlist pagewishlist = pageproduct.goToWishlist();
		assertTrue(pagewishlist.isArticlePresentInWishList(productname));
	}

	/**
	 * Cas non passant : l'article est d�j� pr�sent dans la wish list
	 */
//	@Test
	public void testAddToWishlistProductAlreadyThereFromShop() {
		this.setStartPage("shop/");

		PageShop pageshop = new PageShop(this.driver);
		pageshop.click_dismiss();

		String productname = pageshop.clickOnAddToWishListForFirstProduct();
		this.sleepSomeTime(3000);
		PageWishlist pagewishlist = pageshop.clickOnAddToWishListForFirstProductButAlreadyAdded();

		assertTrue(pagewishlist.isArticlePresentInWishList(productname));
	}

}
