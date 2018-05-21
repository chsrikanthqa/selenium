package com.amazon.project.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;	
	
	public HomePage(WebDriver wd) {
		this.driver=wd;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="nav-link-shopall")  ////a[@id='nav-link-shopall']//span[@class='nav-icon nav-arrow']")
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
	
	

	
}
