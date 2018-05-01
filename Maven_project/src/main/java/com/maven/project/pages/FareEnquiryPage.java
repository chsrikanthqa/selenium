package com.maven.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FareEnquiryPage {

	WebDriver driver;

	public FareEnquiryPage(WebDriver wd) {
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Fare Enquiry")
	@CacheLookup
	WebElement fareEnquiryLink1;

	public void clickFareEnquiryLink1(){
		fareEnquiryLink1.click();
	}
	
	@FindBy(id = "lccp_trnno")
	WebElement tarinNumber;

	public void trainNumberTextbox(String trainNumber){
		tarinNumber.sendKeys(trainNumber);
	}
	
	@FindBy(name = "lccp_day")
	WebElement ticketbookingDateTextBox;

	public void dateTextBoxClear(){
		ticketbookingDateTextBox.clear();
	}
	
	@FindBy(name = "lccp_day")
	WebElement enterDate;

	public void dateTextBox(String date){
		enterDate.sendKeys(date);
	}
	
	@FindBy(name = "lccp_month")
	WebElement ticketbookingMonthTextBox;

	public void monthTextBoxClear(){
		ticketbookingMonthTextBox.clear();
	}
	
	@FindBy(name = "lccp_month")
	WebElement enterMonth;

	public void MonthTextBox(String date){
		enterMonth.sendKeys(date);
	}
	
	@FindBy(id = "lccp_srccode")
	WebElement sourceStationCodeText;

	public void sourceStationCodeTextBox(String sourceCode){
		sourceStationCodeText.sendKeys(sourceCode);
	}
	
	@FindBy(id = "lccp_dstncode")
	WebElement destinationStationCodeText;

	public void destinationStationCodeTextBox(String destinationCode){
		destinationStationCodeText.sendKeys(destinationCode);
	}
	
	@FindBy(name = "lccp_classopt")
	WebElement seatClassDropDown1;

	public void compartmentClass1(){
		Select objClass = new Select(seatClassDropDown1);
		objClass.selectByIndex(0);
	}
	
	@FindBy(name = "lccp_age")
	WebElement travellerAge;

	public void passengersAge(){
		Select objAge = new Select(travellerAge);
		objAge.selectByIndex(1);
	}
	
	@FindBy(name = "lccp_frclass1")
	WebElement quota;

	public void bookingQuota(){
		Select objQuota = new Select(quota);
		objQuota.selectByIndex(2);
	}
	
	@FindBy(name = "lccp_conc")
	WebElement concessionDropDown;

	public void consession(){
		Select objConcession = new Select(concessionDropDown);
		objConcession.selectByIndex(2);
	}
	
	@FindBy(className = "btn_style")
	WebElement clickGetFareBtn;
	
	public void getFareBtn() throws InterruptedException{
		clickGetFareBtn.click();
		Thread.sleep(5000);
	}
	
	
}
