package com.shoppingcart.testscripts;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.shoppingcart.businessfunctions.AmazonStartPage;
import com.shoppingcart.businessfunctions.HomePage;
import com.shoppingcart.businessfunctions.SignInPage1;
import com.shoppingcart.businessfunctions.SignInPage2;
import com.shoppingcart.utilities.TestBase;

public class TC001_LoginAndLogout extends TestBase {

	private String homePageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	private String signInPage1Title = "Amazon Sign I";
	private SignInPage1 signInPage1;
	private String emailId = utility.getExcelCellData(1, 0);
	private SignInPage2 signInPage2;
	private String password = utility.getExcelCellData(1, 1);
	private HomePage homePage;
	private AmazonStartPage amazonStartPage;

	@Test
	public void loginAndLogout() throws IOException {
		amazonStartPage = new AmazonStartPage(driver);
		amazonStartPage.verifyAmazonStartPage();
		signInPage1 = amazonStartPage.clickOnSingInLink();
		signInPage1.verifySignInPage1(signInPage1Title, sAssert);
		signInPage1.enterEmailId(emailId);
		signInPage2 = signInPage1.clickOnContinueBtn();
		signInPage2.verifySignInPage2();
		signInPage2.enterPassword(password);
		homePage = signInPage2.clickOnLoginBtn();
		homePage.verifyHomePage(homePageTitle,sAssert);
		sAssert.assertAll();
	}
}
