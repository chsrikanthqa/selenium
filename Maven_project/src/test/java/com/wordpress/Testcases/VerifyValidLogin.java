package com.wordpress.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.maven.project.driver.DriverManager;
import com.wordpress.pages.LoginPageNew;

public class VerifyValidLogin {
	WebDriver driver;
	
	@Test
	public void checkValidUser() throws InterruptedException
	{

	// This will launch browser and specific url 
	driver = DriverManager.launchBrowser("Chrome");
	DriverManager.loadUrl("http://demosite.center/wordpress/wp-login.php");
	
	// Created Page Object using Page Factory
	LoginPageNew login_page=PageFactory.initElements(driver, LoginPageNew.class);

	// Call the method
	login_page.login_wordpress("admin", "demo123");

	}
}
