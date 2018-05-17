package com.shoppingcart.testscripts;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Test {
	
	WebDriver driver;
	
	private String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\shoppingcart\\testdata\\config.properties";
	
	public static void main(String[] args) {
		//System.out.println(new Test().getPropValue("browserType"));
		
		String bTxt = "22.00";
		if(bTxt.contains(".")) {
			String s = bTxt.substring(0, bTxt.indexOf("."));
			System.out.println(s);
		}
	}
	
	public String getPropValue(String key)  {		
		File file = new File(propertyFilePath);
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			return properties.getProperty(key);			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return null;		
	}

}
