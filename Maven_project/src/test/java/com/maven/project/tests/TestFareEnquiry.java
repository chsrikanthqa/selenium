package com.maven.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.maven.project.driver.DriverManager;
import com.maven.project.pages.FareEnquiryPage;
import com.maven.project.pages.ReservedTrainBetweenStations;

public class TestFareEnquiry {
	WebDriver driver;
	FareEnquiryPage fareEnquiryPage;
	ReservedTrainBetweenStations reservedTrainBetweenStations;
	
	@BeforeMethod(alwaysRun = true)	
	@Parameters("browser")
	public void init(String browser) throws InterruptedException {
		driver = DriverManager.launchBrowser(browser);
		DriverManager.loadUrl("http://www.indianrail.gov.in");
		fareEnquiryPage = new FareEnquiryPage(driver);
		reservedTrainBetweenStations = new ReservedTrainBetweenStations(driver);
	}
	
	
	
	@Test
	public void validatefareEnquiryPageWithValidData() throws InterruptedException {
		fareEnquiryPage.clickFareEnquiryLink1();
		fareEnquiryPage.trainNumberTextbox("14553");
		fareEnquiryPage.dateTextBoxClear();
		fareEnquiryPage.dateTextBox("20");
		fareEnquiryPage.monthTextBoxClear();
		fareEnquiryPage.MonthTextBox("6");
		fareEnquiryPage.sourceStationCodeTextBox("DLI");
		fareEnquiryPage.destinationStationCodeTextBox("SZM");
		fareEnquiryPage.compartmentClass1();
		fareEnquiryPage.passengersAge();
		fareEnquiryPage.bookingQuota();
		fareEnquiryPage.consession();
		fareEnquiryPage.getFareBtn();
		reservedTrainBetweenStations.sourceStationTextBox("DLI");
		reservedTrainBetweenStations.destinationStationTextBox("SZM");
		reservedTrainBetweenStations.clickOnGoBtn();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
