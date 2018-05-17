package com.shoppingcart.businessfunctions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.shoppingcart.utilities.TestBase;

public class SearchResultsPage extends TestBase {

	WebDriver driver;
	private WebDriverWait ww;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		ww = new WebDriverWait(driver, 30);
	}

	// Locaters
	private By products = By.xpath("//*[contains(@id,'result_')]");
	private By firstProduct = By.xpath(
			"//h2[contains(.,'Dell Inspiron 15 3565 15-inch Laptop (7th Gen E2-9000/4GB/1TB/Win. 10 /Integrated Graphics), Black')]");

	public void verifyProductCount(SoftAssert sAssert) {
		List<WebElement> dellCount = driver.findElements(products);
		int productSizeActual = dellCount.size();
		int productSizeExpected = 24;
		sAssert.assertEquals(productSizeActual, productSizeExpected, "productCount has not matached");
	}

	public FirstProductDetailsPage clickOnFirstProductInSearchResults() {
		driver.findElement(firstProduct).click();
		try {
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			driver.close();
			driver.switchTo().window(tabs2.get(1)).getTitle();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new FirstProductDetailsPage(driver);

	}

}
