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

	//g2Meeting
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(1)>a[href^='http://www.gotomeeting.com']")
		public WebElement g2Meeting;
	
	//g2Webinar
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(2)>a[href^='http://www.gotowebinar.com']")
		public WebElement g2Webinar;
	
	//g2Training
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(3)>a[href^='http://www.gototraining.com']")
	public WebElement g2Training;
	
	//g2ShareFile
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(1)>a[href^='http://www.sharefile.com']")
	public WebElement g2ShareFile;
		
	//g2ShareConnect
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(2)>a[href^='http://www.shareconnect.com']")
	public WebElement g2ShareConnect;
	
	//g2MyPC
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(3)>a[href^='http://www.gotomypc.com']")
	public WebElement g2MyPC;
	
	//g2RightSignature
	@FindBy(how=How.CSS, using = ".columns.large-4.medium-4>ul>li:nth-of-type(4)>a[href^='https://rightsignature.com']")
		public WebElement g2RightSign;
	
	
	//g2Assist
	@FindBy(how=How.CSS, using =".columns.large-4.medium-4>ul>li:nth-of-type(1)>a[href^='https://www.gotoassist.com']")
		public WebElement g2Assist;
	
	//g2Concierge
	@FindBy(how=How.CSS, using =".columns.large-4.medium-4>ul>li:nth-of-type(2)>a[href^='https://www.gotoassist.com/remote-support/concierge']")
		public WebElement g2Concierge;
	
	//g2SeeIt
	@FindBy(how=How.CSS, using =".columns.large-4.medium-4>ul>li:nth-of-type(3)>a[href^='https://www.gotoassist.com/remote-support/seeit']")
		public WebElement g2SeeIt;
	
}
