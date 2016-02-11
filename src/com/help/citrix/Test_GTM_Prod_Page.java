package com.help.citrix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.factory.helper.BrowserFactory;

public class Test_GTM_Prod_Page{
	WebDriver driver;
	String baseUrl = "http://helped1.citrix.com/meeting";
	String browserName = "firefox";
	WebDriverWait wait;
	GTM_Product_Page gtmProdPage;
	
	
	
	@BeforeTest
	public void setupSupportWelcomePage(){
		driver = BrowserFactory.startBrowser(browserName, baseUrl);
		wait = new WebDriverWait(driver, 30);
	}
	
	
}
