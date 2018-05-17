package com.shoppingcart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UtilityMethods extends TestBase{
	public static Properties config;
	public FileInputStream fis;
	public FileInputStream fileInput;
	private String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\shoppingcart\\testdata\\config.properties";
	private File propfile = new File(propertyFilePath);
	private String excelPath = System.getProperty("user.dir")
			+ "\\src\\test\\java\\com\\shoppingcart\\testdata\\loginCredentials.xls";
	public File excelFile = new File(excelPath);

	public HSSFSheet excelSheet;
	public HSSFWorkbook workBook;
	

	public String getPropValue(String key) {
		File file = new File(propertyFilePath);

		try {
			fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			return properties.getProperty(key);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public String getExcelCellData(int row, int col) {
		try {
			File excelFileRead = new File(excelPath);
			fis = new FileInputStream(excelFileRead);
			workBook = new HSSFWorkbook(fis);
			fis.close();
			HSSFSheet sht = workBook.getSheet("Sheet1");
			String cellValue = sht.getRow(row).getCell(col).getStringCellValue();
			return cellValue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

public void SwithcBetweenBrowserTabs() {
	
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL.SHIFT.TAB);
}

}
