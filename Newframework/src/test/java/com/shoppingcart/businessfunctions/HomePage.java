package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait ww;
	// Locaters
	private By searchTxtBox = By.id("twotabsearchtextbox");
	private By searchBtn = By.xpath("//*[@id='nav-search']/form/div[2]/div/input");
	private By submitBtn = By.xpath("//input[@type='submit']");
	private By link_Txt = By.linkText("Help");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		ww = new WebDriverWait(driver, 60);
	}

	public void verifyHomePage(String pageTitle, SoftAssert sAssert) {
		String pageTitleActual = driver.getTitle();
		Assert.assertEquals(pageTitleActual, pageTitle, "HomePage is not displayed");
	}

	public void searchProductInSearchTxtField(String productData) {

		ww.until(ExpectedConditions.visibilityOfElementLocated(searchTxtBox)).sendKeys(productData);
	}

	public SearchResultsPage clickOnSearchButton() {
		driver.findElement(searchBtn).click();
		return new SearchResultsPage(driver);
	}

	public BooksStoreCategoryPage clickAndSelectCategory() {
		Select searchDropdownBox = new Select(driver.findElement(By.id("searchDropdownBox")));
		searchDropdownBox.selectByVisibleText("Books");
		driver.findElement(submitBtn).click();
		return new BooksStoreCategoryPage(driver);
	}

	public CustomerHelpPage clickOnHelpLink() {
		driver.findElement(link_Txt).click();
		return new CustomerHelpPage(driver);
	}

}
