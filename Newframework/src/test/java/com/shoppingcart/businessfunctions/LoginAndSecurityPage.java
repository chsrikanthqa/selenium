package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.shoppingcart.utilities.TestBase;

public class LoginAndSecurityPage extends TestBase {

	public LoginAndSecurityPage(WebDriver driver) {
		LoginAndSecurityPage.driver = driver;
	}

	// Locater
	private By loginSecurityTxt = By.id("ap_cnep_header");
	private By editNameBtn = By.id("auth-cnep-edit-name-button");
	private By customerNameInputField = By.id("ap_customer_name");
	private By saveChangesBtn_Name = By.id("cnep_1C_submit_button");
	private By passwordEditBtn = By.id("auth-cnep-edit-password-button");
	private By currentPasswordFld = By.id("ap_password");
	private By newPasswrd = By.id("ap_password_new");
	private By reEnterNewPassword = By.id("ap_password_new_check");
	private By saveChangesBtn_pass = By.id("cnep_1D_submit_button");
	private By doneBtn = By.id("auth-cnep-done-button");
	private By addressTxt = By.xpath(".//*[@id='a-page']/div[2]/div/div[3]/div[1]/a/div/div");

	String customerNewName = "Ketam Srinivas";

	public void verifyLoginAndSecurityTxt() {
		WebElement ls_Txt = driver.findElement(loginSecurityTxt);
		if (ls_Txt.isDisplayed()) {
			System.out.println("Login and Security Text has displayed");
		} else {
			System.out.println("Login and security Text not displayed");
		}

	}

	public void clickOnNameEditBtn() {
		driver.findElement(editNameBtn).click();
	}

	public void clearCustomerNameField() {
		driver.findElement(customerNameInputField).clear();

	}

	public void enterNewCustomerNameField() {
		driver.findElement(customerNameInputField).sendKeys(customerNewName);
	}

	public void clickOnSaveChangesButtonForName() {
		driver.findElement(saveChangesBtn_Name).click();
	}

	public void clickOnPasswordEditButton() {
		driver.findElement(passwordEditBtn).click();
	}

	public void enterCurrentPassword(String currentPassword) {
		driver.findElement(currentPasswordFld).sendKeys(currentPassword);
	}

	public void enterNewPassword(String newPassword) {
		driver.findElement(newPasswrd).sendKeys(newPassword);

	}

	public void reEnterNewpasswork(String reEnterpassword) {
		driver.findElement(reEnterNewPassword).sendKeys(reEnterpassword);
	}

	public void clickOnSaveChangesBtnForPassword() {
		driver.findElement(saveChangesBtn_pass).click();
		driver.navigate().back();
	}

	public void clickOnDoneBtn() {
		driver.findElement(doneBtn).click();
	}

	public AddNewAddressPage clickOnAddressTxt() {
		driver.findElement(addressTxt).click();
		return new AddNewAddressPage(driver);
	}

}
