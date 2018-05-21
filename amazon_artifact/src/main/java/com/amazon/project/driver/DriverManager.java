package com.amazon.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static WebDriver driver;
	
	public static WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webDriver.firefox.driver", "geckodriver.exe");
			//System.setProperty("webDriver.firefox.driver",System.getProperty("FIREFOX_WEB_DRIVER_PATH"));
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		return driver;
	}
	
	public static void loadURL(String URL) {
		driver.get(URL);
	}
	
}
