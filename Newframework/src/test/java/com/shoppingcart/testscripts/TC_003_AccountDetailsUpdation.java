package com.shoppingcart.testscripts;

import org.testng.annotations.Test;

import com.shoppingcart.businessfunctions.LoginAndSecurityPage;
import com.shoppingcart.businessfunctions.AddNewAddressPage;
import com.shoppingcart.businessfunctions.AmazonStartPage;
import com.shoppingcart.businessfunctions.CustomerHelpPage;
import com.shoppingcart.businessfunctions.HomePage;
import com.shoppingcart.businessfunctions.SignInPage1;
import com.shoppingcart.businessfunctions.SignInPage2;
import com.shoppingcart.utilities.TestBase;

public class TC_003_AccountDetailsUpdation extends TestBase {

	private AmazonStartPage amazonStartPage;
	private SignInPage1 signInPage1;
	private SignInPage2 signInPage2;
	private HomePage homePage;
	private String homePageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	private String signInPage1Title = "Amazon Sign In";
	private String emailId = utility.getExcelCellData(1, 0);
	private String password = utility.getExcelCellData(1, 3);
	private String currentPassword = utility.getExcelCellData(1, 1);
	private String newPassword = utility.getExcelCellData(1, 3);
	private String reEnterNewpassword = utility.getExcelCellData(1, 3);
	private CustomerHelpPage customerHelpPage;
	private LoginAndSecurityPage loginAndSecurityPage;
	private AddNewAddressPage addNewAddressPage;

	@Test
	public void updateAcountDetailsForCustomer() {

		amazonStartPage = new AmazonStartPage(driver);
		amazonStartPage.verifyAmazonStartPage();
		signInPage1 = amazonStartPage.clickOnSingInLink();
		signInPage1.verifySignInPage1(signInPage1Title, sAssert);
		signInPage1.enterEmailId(emailId);
		signInPage2 = signInPage1.clickOnContinueBtn();
		signInPage2.verifySignInPage2();
		signInPage2.enterPassword(password);
		homePage = signInPage2.clickOnLoginBtn();
		homePage.verifyHomePage(homePageTitle, sAssert);
		customerHelpPage = homePage.clickOnHelpLink();
		loginAndSecurityPage = customerHelpPage.clickOnAccountSettingsLink();
		loginAndSecurityPage.verifyLoginAndSecurityTxt();
		loginAndSecurityPage.clickOnNameEditBtn();
		loginAndSecurityPage.clearCustomerNameField();
		loginAndSecurityPage.enterNewCustomerNameField();
		loginAndSecurityPage.clickOnSaveChangesButtonForName();
		/*
		 loginAndSecurityPage.clickOnPasswordEditButton();
		 loginAndSecurityPage.enterCurrentPassword(currentPassword);
		 loginAndSecurityPage.enterNewPassword(newPassword);
		 loginAndSecurityPage.reEnterNewpasswork(reEnterNewpassword);
		  loginAndSecurityPage.clickOnSaveChangesBtnForPassword();
		 */
		loginAndSecurityPage.clickOnDoneBtn();
		addNewAddressPage = loginAndSecurityPage.clickOnAddressTxt();
		addNewAddressPage.clickOnAddressLnk();
		addNewAddressPage.enterFullName();
		addNewAddressPage.enterMobileNumber();
		addNewAddressPage.enterAddress1();
		addNewAddressPage.enterAddress2();
		addNewAddressPage.enterPicode();
		addNewAddressPage.enterCity();
		addNewAddressPage.enterLandMark();
		addNewAddressPage.selectState();
		addNewAddressPage.selectAddressType();
		addNewAddressPage.clickOnAddAddress();

	}

}
