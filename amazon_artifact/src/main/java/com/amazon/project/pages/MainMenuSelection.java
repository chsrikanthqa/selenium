package com.amazon.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuSelection {

	WebDriver driver;	
	
	public MainMenuSelection(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='All Mobile Phones']")
	WebElement SelectPhonecat;
	public void selectPhonecat() throws InterruptedException {
		SelectPhonecat.click();
		Thread.sleep(3000);
	}
	
}
