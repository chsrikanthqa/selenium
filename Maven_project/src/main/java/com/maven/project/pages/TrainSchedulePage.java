package com.maven.project.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainSchedulePage {

	WebDriver driver;
	  private boolean acceptNextAlert = true;

	public TrainSchedulePage(WebDriver wd) {
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "lccp_trnname")
	WebElement trainNumberTB;

	public void enterTrainNumber(String trainNumber){
		trainNumberTB.sendKeys(trainNumber);
	}
	
	@FindBy(className = "btn_style")
	WebElement getScheduleBtn;

	public void clickGetScheduleBtn() throws InterruptedException{
		getScheduleBtn.click();
		Thread.sleep(3000);
	}
	
	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
}
