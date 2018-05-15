package com.amazon.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.project.driver.DriverManager;
import com.amazon.project.pages.HomePage;

public class AmazonHomePageLaunch {

	WebDriver driver;
	HomePage homepage;
	
	
	@BeforeTest(alwaysRun = true)	
	public void launchBrowser()  {
		driver=DriverManager.launchBrowser("chrome");
		DriverManager.loadURL("https://www.amazon.in/");
		homepage=new HomePage(driver);
		
	}
	
	@Test
	public void gotomainmenu() throws InterruptedException {
		homepage.selectCategory();
		homepage.selectPhonecat();
		homepage.selectPriceRange();
		homepage.selectStockIn();
		homepage.sortList();
		homepage.priceList();
	}
	
}
