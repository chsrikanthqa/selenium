package com.amazon.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSelectionPage {
	WebDriver driver;	
	
	public MobileSelectionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="low-price")
	WebElement selectLowPrice;
	@FindBy(id="high-price")
	WebElement selectHighrprice;
	@FindBy(xpath="//span[contains(@class,'a-button a-spacing-top-m')]/span[1]/input[@class='a-button-input']")
	WebElement submit1;
	public void selectPriceRange() throws InterruptedException {
		selectLowPrice.sendKeys("2000");
		selectHighrprice.sendKeys("10000");
		submit1.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement stockIn;
	public void selectStockIn() throws InterruptedException {
		stockIn.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//select[@id='sort']")
	WebElement ClickOnSortList;
	@FindBy(xpath="//select[@id='sort']/option[2]")
	WebElement SelectSortOption;
	public void sortList() {
		ClickOnSortList.click();
		SelectSortOption.click();
	}
	
	@FindBy(xpath="//ul[@id='s-results-list-atf']//a/span[1]")
	List<WebElement> price;
	public void priceList() {
		System.out.println(price.size());
		
		for(WebElement list:price) {
			/*System.out.println(list.getText());
			System.out.println(list.getTagName());*/
			
			if(list.getText().equals("2000")) {
				System.out.println("Working");
				System.out.println(list.getText());
			}
				else {
					System.out.println("Not Working");
				}
			
		}
	}
}
