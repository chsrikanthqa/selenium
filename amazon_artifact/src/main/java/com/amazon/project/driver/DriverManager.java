package com.amazon.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static WebDriver driver;
	
	public static WebDriver launchBrowser(String browser) {
		if (browser.equals("firefox")) {
			System.setProperty("webDriver.firefox.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browser.equals("chrome")) {
			System.setProperty("webDriver.chrome.driver", "D:\\Education\\softwares\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		return driver;
	}
	
	public static void loadURL(String URL) {
		driver.get(URL);
	}
	
}
