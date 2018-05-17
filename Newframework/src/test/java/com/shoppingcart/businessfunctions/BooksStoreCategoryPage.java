package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.shoppingcart.utilities.TestBase;

public class BooksStoreCategoryPage extends TestBase {

	WebDriver driver;

	public BooksStoreCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locaters
	private By priceLbl = By.xpath(".//*[@id='leftNav']/h4[12]");
	private By priceLvl = By.xpath(".//*[@id='leftNav']/ul[13]/div/li[3]/span/a/span");

	public void verifyBooksStorePageTitle(String expBooksStoreTitle, SoftAssert sAssert) {

		String actBookStoreTitle = driver.getTitle();
		sAssert.assertEquals(actBookStoreTitle, expBooksStoreTitle, "BooksStore Title is mis-matched");
	}

	public void verifyPriceTxt(String exppriceTxt, SoftAssert sAssert) {

		String actPriceTxt = driver.findElement(priceLbl).getText();
		sAssert.assertEquals(actPriceTxt, exppriceTxt, "Price text is mis-mactched");

	}

	public Product_Books_RefineByAndResultsPage clickOnPriceRange() {
		driver.findElement(priceLvl).click();
		return new Product_Books_RefineByAndResultsPage(driver);
	}

}
