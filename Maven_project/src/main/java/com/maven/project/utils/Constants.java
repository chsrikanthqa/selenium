package com.maven.project.utils;

import java.io.File;

public class Constants {
	public static final String driversPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "Drivers" + File.separator;
	public static final String chromeDriverPath = driversPath + "chromedriver.exe";
	public static final String edgeDriverPath = driversPath + "MicrosoftWebDriver.exe";
}
