package com.maven.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.maven.project.driver.DriverManager;
import com.maven.project.pages.IndianRailHomePage;
import com.maven.project.pages.PassengerReservationEnquiryPage;
import com.maven.project.pages.TrainSchedulePage;

public class TrainReservationTest {

	WebDriver driver;
	IndianRailHomePage indianRailHomePage;
	PassengerReservationEnquiryPage passengerReservationEnquiryPage;
	TrainSchedulePage trainSchedulePage;

	@BeforeMethod(alwaysRun = true)
	public void init() throws InterruptedException {
		driver = DriverManager.launchBrowser("Chrome");
		DriverManager.loadUrl("http://www.indianrail.gov.in");
		indianRailHomePage = new IndianRailHomePage(driver);
		passengerReservationEnquiryPage = new PassengerReservationEnquiryPage(driver);
		trainSchedulePage = new TrainSchedulePage(driver);
	}

	@Test(priority = 1)
	public void validateTrainReservationEnquiryWithValidData() throws InterruptedException {
		indianRailHomePage.clickReserveTrainScheduleLink();
		trainSchedulePage.enterTrainNumber("14553");
		trainSchedulePage.clickGetScheduleBtn();
		passengerReservationEnquiryPage.validateTrainRouteOnPassengerReservationEnquiryPage();

	}

	@Test(priority = 2)
	public void validateTrainReservationEnquiryWithInValidData() throws InterruptedException {
		indianRailHomePage.clickReserveTrainScheduleLink();
		trainSchedulePage.enterTrainNumber("adfadfs");
		trainSchedulePage.clickGetScheduleBtn();
		Assert.assertEquals(passengerReservationEnquiryPage.getInvalidTrainNumberText(),
				"SORRY !!! No Matching Trains Found");
	}
	
	@Test(priority = 3)
	public void validateTrainReservationEnquiryWithEmptyData() throws InterruptedException {
		indianRailHomePage.clickReserveTrainScheduleLink();
		trainSchedulePage.enterTrainNumber("");
		trainSchedulePage.clickGetScheduleBtn();
		Assert.assertEquals(trainSchedulePage.closeAlertAndGetItsText(), "Train Name cannot be left blank.");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
