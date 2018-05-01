package com.maven.project.driver;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.maven.project.utils.Constants;

public class DriverManager {
	private static WebDriver driver = null;
	private static Logger logger = Logger.getLogger(DriverManager.class);

	public static WebDriver launchBrowser(String browser) {
		BasicConfigurator.configure();

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			logger.info("Firefox Browser Launched");
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
			driver = new ChromeDriver();
			logger.info("Chrome Browser Launched");
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", Constants.edgeDriverPath);
			driver = new EdgeDriver();
			logger.info("Edge Browser Launched");
		}
		return driver;
	}

	public static void loadUrl(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}
}
