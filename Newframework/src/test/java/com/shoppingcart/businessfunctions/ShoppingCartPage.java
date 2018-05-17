package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.shoppingcart.utilities.TestBase;

public class ShoppingCartPage extends TestBase {
	WebDriver driver;
	WebDriverWait ww;
	Actions action;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		ww = new WebDriverWait(driver, 60);
		action = new Actions(driver);

	}

	// Locaters
	private By added = By.id("huc-v2-order-row-confirm-text");
	private By subtotal = By.xpath(".//*[@id='hlb-subcart']/div[1]/span/span[2]/span");
	private By cart = By.id("hlb-view-cart-announce");
	// private By count = By.xpath("//span[@id='nav-cart-count']");
	private By youraccount = By.id("nav-link-yourAccount");
//	private By submitBtn = By.xpath("//input[@type='submit']");

	public void verifyShoppingCartTitle(String expShpCart, SoftAssert sAssert) {

		String actShpCart = driver.getTitle();
		sAssert.assertEquals(actShpCart, expShpCart, "shoppingCart Title is Mis-matched");
	}

	public void verifyAddedToCartMsg(String expMsg, SoftAssert sAssert) {

		String actMsg = driver.findElement(added).getText();
		System.out.println(actMsg);
		sAssert.assertEquals(actMsg, expMsg, "addedToCart Message Mis-matched");

	}

	public void verifyCartSubTotal(String expSub, SoftAssert sAssert) {

		String actSubtotal = ww.until(ExpectedConditions.visibilityOfElementLocated(subtotal)).getText();
		System.out.println(actSubtotal);
		sAssert.assertEquals(actSubtotal, expSub, "Expected subtotal is mis-matched");

	}

	public void clickOnCartBtn() {
		driver.findElement(cart).click();

	}

	public void countCartItem() {
		try {
			Thread.sleep(3000);
			String count = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
			System.out.println("addedCart Items are =" + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void signOutAccount() {

		WebElement account_hover = driver.findElement(youraccount);
		try {
			Thread.sleep(6000);
			action.moveToElement(account_hover).build().perform();
			Thread.sleep(5000);
			WebElement signout = driver.findElement(By.id("nav-item-signout-sa"));
			action.moveToElement(signout).click().build().perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

/*	public BooksStoreCategory clickAndSelectCategory() {
		Select searchDropdownBox = new Select(driver.findElement(By.id("searchDropdownBox")));
		searchDropdownBox.selectByVisibleText("Books");
		driver.findElement(submitBtn).click();
		return new BooksStoreCategory(driver);
	}*/

}
