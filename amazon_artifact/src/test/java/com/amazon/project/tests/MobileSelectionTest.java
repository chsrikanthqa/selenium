package com.amazon.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.project.driver.DriverManager;
import com.amazon.project.pages.HomePage;
import com.amazon.project.pages.MainMenuSelection;
import com.amazon.project.pages.MobileSelectionPage;

public class MobileSelectionTest {

	WebDriver driver;
	HomePage homepage;
	MainMenuSelection mainMenuSelection;
	MobileSelectionPage mobileSelectionPage;
	
	@BeforeTest(alwaysRun = true)	
	public void launchBrowser()  {
		driver=DriverManager.launchBrowser("chrome");
		DriverManager.loadURL("https://www.amazon.in/");
		homepage=new HomePage(driver);
		mainMenuSelection=new MainMenuSelection(driver);
		mobileSelectionPage=new MobileSelectionPage(driver);
		
	}
	
	@Test(priority=1)
	public void gotomainmenu() throws InterruptedException {
		homepage.selectCategory();
	}
	
	@Test(priority=2)
	public void selectPhoneCategory() throws InterruptedException {
		mainMenuSelection.selectPhonecat();
	}
	
	@Test(priority=3)
	public void mobileSelectionRange() throws InterruptedException {
		mobileSelectionPage.selectPriceRange();
		mobileSelectionPage.selectStockIn();
		mobileSelectionPage.sortList();
		mobileSelectionPage.priceList();
		
		
	}
	
}
