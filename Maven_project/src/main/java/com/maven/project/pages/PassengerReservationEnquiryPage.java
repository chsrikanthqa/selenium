package com.maven.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassengerReservationEnquiryPage {
	WebDriver driver;

	public PassengerReservationEnquiryPage(WebDriver wd) {
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(.//*[@class='table_border_both'])[2]/tbody/tr")
	List<WebElement> trainRouteTable;

	@FindBy(xpath="//tr[2]/td/b")
	WebElement invalidTrainNumberText;
	
	public void validateTrainRouteOnPassengerReservationEnquiryPage() {
		for (int j = 0; j <= trainRouteTable.size(); j++) {
			List<WebElement> trainRouteRow = driver
					.findElements(By.xpath("(.//*[@class='table_border_both'])[2]/tbody/tr[" + j + "]/td"));

			// Thread.sleep(3000);
			for (int i = 1; i <= trainRouteRow.size(); i++) {
				// Thread.sleep(10000);
				WebElement trainRouteCellData = driver.findElement(
						By.xpath("(.//*[@class='table_border_both'])[2]/tbody/tr[" + j + "]/td[" + i + "]"));
				// Thread.sleep(1000);
				System.out.print(trainRouteCellData.getText());
				System.out.print("           ");
			}
			System.out.println();
		}
	}
	
	public String getInvalidTrainNumberText(){
		return invalidTrainNumberText.getText();		
	}
}
