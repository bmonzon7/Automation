package com.help.citrix;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MoreFromCitrixMenu {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
	public MoreFromCitrixMenu(WebDriver driver){
		this.driver = driver;
	
		//page factory
		PageFactory.initElements( new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
	}

	//Define TopNav "More from Citrix"
	@FindBy(how=How.CSS, using = "div>.menu.show-for-medium-up")
		public WebElement navMoreCitrix;

	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(1)>a>span.g2m")
		public WebElement g2Meeting;
	
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(2)>a[href^='http://www.gotowebinar.com']")
		public WebElement g2Webinar;
	
	

}
