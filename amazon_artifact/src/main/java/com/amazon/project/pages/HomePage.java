package com.amazon.project.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="nav-link-shopall")
	////a[@id='nav-link-shopall']//span[@class='nav-icon nav-arrow']")
	WebElement mainMenu;
	
		/*Following is to hover onto weelement but didn't work*/
	
		/*@FindBy(xpath="//span[text()='Kindle E-Readers & eBooks']")
			////div[contains(@class,'nav-template')]//span[contains(@class,'nav-hasPanel')][3]//span[text()='Kindle E-Readers & eBooks']")
			////div[contains(@class,'nav-template')]//span[text()='Kindle E-Readers & eBooks']")
		WebElement mainMenu_cat;
	
		@FindBy(xpath="//span[text()='Kindle']")
		WebElement mainMenu_SubCat;*/
	
	public void selectCategory() throws InterruptedException {
		mainMenu.click();
		Thread.sleep(3000);
		/*act.moveToElement(mainMenu_cat).click().build().perform();
		Thread.sleep(3000);
		act.moveToElement(mainMenu_SubCat).click().build().perform();*/
	}
	
	
	@FindBy(xpath="//a[text()='All Mobile Phones']")
	WebElement SelectPhonecat;
	public void selectPhonecat() throws InterruptedException {
		SelectPhonecat.click();
		Thread.sleep(3000);
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
