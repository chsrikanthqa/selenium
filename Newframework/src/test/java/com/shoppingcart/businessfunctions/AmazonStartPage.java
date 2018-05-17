package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AmazonStartPage {
	private WebDriver driver;
	private WebDriverWait ww;
	SoftAssert sAssert;
	
	//Locators
	private By signInLink = By.id("nav-link-yourAccount");	


	public AmazonStartPage(WebDriver driver) {
		this.driver = driver;		
		ww = new WebDriverWait(driver, 30);
	}

	public void verifyAmazonStartPage() {
		ww.until(ExpectedConditions.visibilityOfElementLocated(signInLink));		
		Assert.assertTrue(isElementDisplayed(signInLink),"Amazon Start Page has not launched");
	}
	
	public SignInPage1 clickOnSingInLink() {
		driver.findElement(signInLink).click();
		return new SignInPage1(driver);
	}
	
	public boolean isElementDisplayed(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
