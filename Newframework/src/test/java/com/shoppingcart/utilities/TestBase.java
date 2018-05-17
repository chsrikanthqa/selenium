package com.shoppingcart.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class TestBase {

	public static WebDriver driver;
	public static UtilityMethods utility = new UtilityMethods();
	public static SoftAssert sAssert = new SoftAssert();
	

	@Parameters({ "browserName" })
	@BeforeClass
	public void init(String browserName) throws IOException {
		if (System.getProperty("os.name").contains("Window")) {
			if (browserName.equalsIgnoreCase("firefox")) {
				// https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("Firefox browser invoked succesfully");

			} else if (browserName.equalsIgnoreCase("chrome")) {
				// https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Chrome browser invoked succesfully");

			}

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(utility.getPropValue("url"));

		}
	}

/*	@AfterClass
	public void teardown() {
		driver.quit();
	}*/

}
