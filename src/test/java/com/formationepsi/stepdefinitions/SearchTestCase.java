package com.formationepsi.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.formationepsi.pages.DemoShopQAHomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTestCase {

	WebDriver driver;
	DemoShopQAHomePage demoShopQAHome;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("^I am in the homepage$")
	public void I_am_in_the_homepage() {
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
	}

	@When("^I click on the button Search$")
	public void I_click_on_the_search_button() {
		demoShopQAHome = new DemoShopQAHomePage(driver);
		demoShopQAHome.clickOnsearch();
	}

	@Then("^An input text should be displayed with label \"(.*)\" in order to search for my article$")
	public void verify_display_input_search(String expectedLabel) {
		Assert.assertEquals(expectedLabel, demoShopQAHome.getLabel());
	}

	@When("^I enter (.*) in the search text and hit the enter of the keyboard$")
	public void I_enter_keyword(String keyword) {
		demoShopQAHome.fillSearchInput(keyword);
	}

	@Then("^I should have (\\d+) articles displayed$")
	public void check_number_of_articles_displayed(int expectedNbArticles) {
		Assert.assertEquals(expectedNbArticles, demoShopQAHome.nbProducts());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
