package com.shoppingcart.testscripts;

import org.testng.annotations.Test;

import com.shoppingcart.businessfunctions.AmazonStartPage;
import com.shoppingcart.businessfunctions.BooksStoreCategoryPage;
import com.shoppingcart.businessfunctions.HomePage;
import com.shoppingcart.businessfunctions.Product_Books_RefineByAndResultsPage;
import com.shoppingcart.businessfunctions.SearchResultsPage;
import com.shoppingcart.businessfunctions.ShoppingCartPage;
import com.shoppingcart.businessfunctions.SignInPage1;
import com.shoppingcart.businessfunctions.SignInPage2;
import com.shoppingcart.businessfunctions.FirstProductDetailsPage;
import com.shoppingcart.utilities.TestBase;

public class TC002_AmazonTestScripts extends TestBase {

	private String homePageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	private String signInPage1Title = "Amazon Sign In";
	private SignInPage1 signInPage1;
	private String emailId = utility.getExcelCellData(1, 0);
	private SignInPage2 signInPage2;
	private String password = utility.getExcelCellData(1, 1);
	private HomePage homePage;
	private AmazonStartPage amazonStartPage;
	private String productData = utility.getExcelCellData(1, 2);
	private SearchResultsPage searchResultsPage;
	private FirstProductDetailsPage firstProductDetailsPage;
	private String firstProductDetailsPageTitle = "Buy Dell Inspiron 15 3565 15-inch Laptop (7th Gen E2-9000/4GB/1TB/Win. 10 /Integrated Graphics),  Online at Low Prices in India - Amazon.in";
	private String expProductNameTitle = "Delll Inspiron 15 3565 15-inch Laptop (7th Gen E2-9000/4GB/1TB/Win. 10 /Integrated Graphics), Black";
	private String expProductReviews = "3.0 out of 5 stars";
	private String expProductCost = "22,490.00";
	private ShoppingCartPage shoppingCartPage;
	private String expShpCartTitle = "Amazon.in Shopping Cart";
	private String expMsgTxt = "Added to Cart";
	private String expSubTotal = "22,490.00";
	private BooksStoreCategoryPage booksStoreCategoryPage;
	private String expBooksStoreTitle = "Books Store Online : Buy Books Online at Best Prices in India | Books Shopping @ Amazon.in";
	private String expPriceText = "Price";
	private Product_Books_RefineByAndResultsPage product_Books_RefineByAndResultsPage;
	private String expRefineBy_PageTitle = "Amazon.in: 200 - 500: Books";

	// @Test
	public void verifyProductDetailsAndAddingCart() {
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
		homePage.searchProductInSearchTxtField(productData);
		searchResultsPage = homePage.clickOnSearchButton();
		searchResultsPage.verifyProductCount(sAssert);
		firstProductDetailsPage = searchResultsPage.clickOnFirstProductInSearchResults();
		firstProductDetailsPage.verifyFirstProductPageTitle(firstProductDetailsPageTitle, sAssert);
		firstProductDetailsPage.verifyFirstProductName(expProductNameTitle, sAssert);
		firstProductDetailsPage.verifyFirstProductReview(expProductReviews, sAssert);
		firstProductDetailsPage.verifyFirstProductPrice(expProductCost, sAssert);
		shoppingCartPage = firstProductDetailsPage.clickOnAddToCartBtn();
		shoppingCartPage.verifyShoppingCartTitle(expShpCartTitle, sAssert);
		shoppingCartPage.verifyAddedToCartMsg(expMsgTxt, sAssert);
		shoppingCartPage.verifyCartSubTotal(expSubTotal, sAssert);
		shoppingCartPage.clickOnCartBtn();
		shoppingCartPage.countCartItem();
		shoppingCartPage.signOutAccount();
		sAssert.assertAll();
	}

	@Test
	public void verifyDisplayedProductCostIsWithInTheGivenRange() {
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
		booksStoreCategoryPage = homePage.clickAndSelectCategory();
		booksStoreCategoryPage.verifyBooksStorePageTitle(expBooksStoreTitle, sAssert);
		booksStoreCategoryPage.verifyPriceTxt(expPriceText, sAssert);
		product_Books_RefineByAndResultsPage = booksStoreCategoryPage.clickOnPriceRange();
		product_Books_RefineByAndResultsPage.verifyProduct_Books_RefineByPageTitle(expRefineBy_PageTitle, sAssert);
		product_Books_RefineByAndResultsPage.verifyBooksCountInProductResultPage(sAssert);
		product_Books_RefineByAndResultsPage.verifyBooksPriceRangeInProductResultPage(200, 500);
		product_Books_RefineByAndResultsPage.verifyBooks_PriceRangeInProductResultPage(300, 600);
		sAssert.assertAll();

	}

}
