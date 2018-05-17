package com.shoppingcart.businessfunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.shoppingcart.utilities.TestBase;

public class Product_Books_RefineByAndResultsPage extends TestBase {
	WebDriver driver;
	WebDriverWait ww;

	public Product_Books_RefineByAndResultsPage(WebDriver driver) {
		this.driver = driver;
		ww = new WebDriverWait(driver, 60);
	}

	// Locaters
	private By books = By.xpath(".//*[contains(@id,'result_')]");
	private By lowPrice = By.id("low-price");
	private By highPrice = By.id("high-price");
	private By goBtn = By.id("a-autoid-4");

	public void verifyProduct_Books_RefineByPageTitle(String expRefine_PageTitle, SoftAssert sAssert) {
		String actRefine_PageTitle = driver.getTitle();
		sAssert.assertEquals(actRefine_PageTitle, expRefine_PageTitle, "Expected page title mis-matched");

	}

	public void verifyBooksCountInProductResultPage(SoftAssert sAssert) {

		List<WebElement> booksCount = driver.findElements(books);
		sAssert.assertEquals(booksCount.size(), 18, "Count mis-matched in priceRange");

	}

	public void verifyBooksPriceRangeInProductResultPage(int minRange, int maxRange) { // yet to check it

		List<WebElement> books = driver
				.findElements(By.xpath(".//*[contains(@id,'result_')]//div[2]/div[1]/div[2]/a/span[1]"));
		int bsize = books.size();
		System.out.println("numberOfBookPriceArefound = " + bsize);
		/*
		 * for (int i = 0; i < books.size(); i++) {
		 * System.out.println(books.get(i).getText()); }
		 */

		for (WebElement ele : books) {
			String bTxt = ele.getText().trim();
			if (bTxt.contains(".")) {
				bTxt = bTxt.substring(0, bTxt.indexOf("."));
				// System.out.println(bTxt);
			}
			int price = Integer.parseInt(bTxt);
			if (price >= 200 && price <= 500) {
				System.out.println(price);

			}
		}

	}

	public void verifyBooks_PriceRangeInProductResultPage(int minPrice, int maxPrice) {
		driver.findElement(lowPrice).clear();
		driver.findElement(lowPrice).sendKeys("300");
		driver.findElement(highPrice).clear();
		driver.findElement(highPrice).sendKeys("600");
		driver.findElement(goBtn).click();

		List<WebElement> books = driver
				.findElements(By.xpath(".//*[contains(@id,'result_')]//div[2]/div[1]/div[2]/a/span[1]"));
		int bsize = books.size();

		System.out.println("numberOfBookPriceArefound = " + bsize);

		for (WebElement ele : books) {
			String bTxt = ele.getText().trim();
			if (bTxt.contains(".")) {
				bTxt = bTxt.substring(0, bTxt.indexOf("."));
				// System.out.println(bTxt);
			}
			int price = Integer.parseInt(bTxt);
			if (price >= 300 && price <= 600) {
				System.out.println(price);

			}
		}
	}
}
