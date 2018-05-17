package com.shoppingcart.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.shoppingcart.utilities.TestBase;

public class AddNewAddressPage extends TestBase {

	public AddNewAddressPage(WebDriver driver) {

		AddNewAddressPage.driver = driver;
	}

	// locaters
	private By addressLnk = By.xpath(".//*[@id='ya-myab-address-add-link']/div");
	private By fullName = By.id("address-ui-widgets-enterAddressFullName");
	private By mobileNumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
	private By pincode = By.id("address-ui-widgets-enterAddressPostalCode");
	private By streetAdd0 = By.id("address-ui-widgets-enterAddressLine1");
	private By StreetAdd1 = By.id("address-ui-widgets-enterAddressLine2");
	private By landMark = By.id("address-ui-widgets-landmark");
	private By city = By.id("address-ui-widgets-enterAddressCity");
	private By addAddressBtn = By.xpath(".//*[@id='a-autoid-0']/span/input");

	String fName = "KetamSrinivas";
	String mNum = "9014391678";
	String pCode = "500074";
	String sAddres1 = "H.No: 3-9-418/1,P:8/b";
	String sAddres2 = "saraswathiNagar Colony";
	String lMark = "PMR Law College";
	String cityArea = "Hyderabad";

	public void clickOnAddressLnk() {
		driver.findElement(addressLnk).click();
	}

	public void enterFullName() {
		driver.findElement(fullName).sendKeys(fName);
	}

	public void enterMobileNumber() {
		driver.findElement(mobileNumber).sendKeys(mNum);
	}

	public void enterPicode() {
		driver.findElement(pincode).sendKeys(pCode);
	}

	public void enterAddress1() {
		driver.findElement(streetAdd0).sendKeys(sAddres1);
	}

	public void enterAddress2() {
		driver.findElement(StreetAdd1).sendKeys(sAddres2);
	}

	public void enterLandMark() {
		driver.findElement(landMark).sendKeys(lMark);

	}

	public void enterCity() {
		driver.findElement(city).sendKeys(cityArea);

	}

	public void selectState() {
		Select addressDropdown = new Select(
				driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
		addressDropdown.selectByVisibleText("TELANGANA");

	}

	public void selectAddressType() {
		Select addressType = new Select(driver.findElement(
				By.xpath(".//*[@id='address-ui-widgets-enterAddressFormContainer']/div[2]/div[4]/span/select")));
		addressType.selectByVisibleText("Home (7am to 9pm delivery)");
	}

	public void clickOnAddAddress() {
		driver.findElement(addAddressBtn).click();
	}
}
