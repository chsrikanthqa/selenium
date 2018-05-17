package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class SignInPage2 {

	private WebDriver driver;
	private By passwordTxtField = By.id("ap_password");
	private By loginButton = By.id("signInSubmit");
	private WebDriverWait ww;

	public SignInPage2(WebDriver driver) {
		this.driver = driver;
		ww = new WebDriverWait(driver, 30);
	}

	public void verifySignInPage2() {
		ww.until(ExpectedConditions.visibilityOfElementLocated(passwordTxtField));
		Assert.assertTrue(isElementDisplayed(passwordTxtField),"SignInPage2 is not displayed");
	}

	public void enterPassword(String password) {
		ww.until(ExpectedConditions.visibilityOfElementLocated(passwordTxtField));
		driver.findElement(passwordTxtField).sendKeys(password);
	}

	public HomePage clickOnLoginBtn() {
		driver.findElement(loginButton).click();
		return new HomePage(driver);
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
