package com.maven.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndianRailHomePage {
	WebDriver driver;

	public IndianRailHomePage(WebDriver wd) {
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Reserved Train Schedule")
	WebElement reservedTrainScheduleLink;

	public void clickReserveTrainScheduleLink() throws InterruptedException{
		reservedTrainScheduleLink.click();
		Thread.sleep(3000);
	}

}
