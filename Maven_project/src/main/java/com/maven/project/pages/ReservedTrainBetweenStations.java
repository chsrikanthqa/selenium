package com.maven.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservedTrainBetweenStations {
	WebDriver driver;

	public ReservedTrainBetweenStations(WebDriver wd) {
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id = "sourceStation")
	WebElement enterSourceStation;
	
	@FindBy(xpath="//ul[@id='ui-id-1']/li[1]/a")
	WebElement clickOnFirstRecord;

	public void sourceStationTextBox(String sourceStationtext) throws InterruptedException{
		enterSourceStation.sendKeys(sourceStationtext);
		Thread.sleep(3000);
		clickOnFirstRecord .click();
		Thread.sleep(3000);
	}
	
	@FindBy(id = "destinationStation")
	WebElement enterDestinationStation;
	
	@FindBy(xpath="//ul[@id='ui-id-2']/li[1]/a")
	WebElement clickOnFirstRecordSZM;


	public void destinationStationTextBox(String sourceStationtext) throws InterruptedException{
		enterDestinationStation.sendKeys(sourceStationtext);
		Thread.sleep(3000);
		clickOnFirstRecordSZM .click();
		Thread.sleep(3000);
	}
	
	@FindBy(id = "modal1")
	WebElement goBtn;

	public void clickOnGoBtn() throws InterruptedException{
		goBtn.click();
		Thread.sleep(7000);
		
	}
	
}
