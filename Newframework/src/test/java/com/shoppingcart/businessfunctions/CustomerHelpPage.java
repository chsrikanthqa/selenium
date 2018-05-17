package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.shoppingcart.utilities.TestBase;

public class CustomerHelpPage extends TestBase {

	public CustomerHelpPage(WebDriver driver) {
		CustomerHelpPage.driver = driver;
	}

	// Locaters
	private By ackSettng_Txt = By.linkText("Account Settings");

	public LoginAndSecurityPage clickOnAccountSettingsLink() {

		WebElement ackset = driver.findElement(ackSettng_Txt);
		if (ackset.isDisplayed()) {
			System.out.println("Account setting text is displayed");
			ackset.click();
		} else {
			System.out.println("Not found the Account settign text");
		}
		return new LoginAndSecurityPage(driver);

	}

}
