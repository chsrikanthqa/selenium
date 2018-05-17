package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignInPage1 {
	private WebDriver driver;
	private By emailIdTxtField = By.xpath("//*[@id='ap_email']");
	private By continueBtn = By.xpath(".//*[@type='submit']");
	
	public SignInPage1(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifySignInPage1(String pageTitle, SoftAssert sAssert) {
		String pageTitleActual = driver.getTitle();
		System.out.println(pageTitleActual);
		sAssert.assertEquals(pageTitleActual, pageTitle,"SignInPage1 is not displayed");	
	}
	
	public void enterEmailId(String emailId) {
		driver.findElement(emailIdTxtField).sendKeys(emailId);
	}
	
	public SignInPage2 clickOnContinueBtn() {
		driver.findElement(continueBtn).click();
		return new SignInPage2(driver);
	}
}
