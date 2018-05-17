package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.shoppingcart.utilities.TestBase;

public class FirstProductDetailsPage extends TestBase {

	WebDriver driver;
	WebDriverWait ww;
	Actions action;

	public FirstProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		ww = new WebDriverWait(driver, 60);
		action = new Actions(driver);
	}

	// Locaters
	private By costLbl = By.id("priceblock_ourprice");
	//private By stars = By.xpath("//*[@id='a-popover-content-4']/div/div/div/div[1]/span");
	//private By hoverstar = By.xpath("//*[@id='acrPopover']/span[1]/a/i[1]/span");
	private By cart = By.id("add-to-cart-button");
	private By Title = By.xpath(".//*[@id='expandTitleToggle']/preceding::h1/span");
	private By skip = By.id("siNoCoverage-announce");

	public void verifyFirstProductPageTitle(String expPageTitle, SoftAssert sAssert) {
		String actPageTitle = driver.getTitle();
		System.out.println(actPageTitle);
		sAssert.assertEquals(actPageTitle, expPageTitle, "firstProduct PageTitle is mis-matched");

	}

	public void verifyFirstProductName(String expProductName, SoftAssert sAssert) {

		WebElement actProductName = ww.until(ExpectedConditions.visibilityOfElementLocated(Title));
		sAssert.assertEquals(actProductName.getText(), expProductName, "productName is mis-matched");

	}

	public void verifyFirstProductReview(String expProductStar, SoftAssert sAssert) {
		try {

			
			WebElement reviews = driver.findElement(By.id("acrPopover"));
			Thread.sleep(3000);
			action.moveToElement(reviews).build().perform();
			Thread.sleep(5000);
			WebElement actProductStars = driver.findElement(By.xpath("//span[contains(.,'3.0 out of 5 stars')]"));
			Thread.sleep(2000);
			sAssert.assertEquals(actProductStars.getText(), expProductStar, "First product reviews is mis-matched");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void verifyFirstProductPrice(String expProductPrice, SoftAssert sAssert) {

		String actCost = driver.findElement(costLbl).getText();
		System.out.println(actCost);
		sAssert.assertEquals(actCost, expProductPrice, "product price is mis-matched");
	}

	public ShoppingCartPage clickOnAddToCartBtn() {

		try {
			driver.findElement(cart).click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		ww.until(ExpectedConditions.visibilityOfElementLocated(skip)).click();
		return new ShoppingCartPage(driver);

	}

}
