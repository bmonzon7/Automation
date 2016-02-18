package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoToMeeting_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
		
	@FindBy(how=How.CSS, using = "h3#categoryheading")
		public WebElement catHeading;
	
	@FindBy(how=How.CSS, using = "div.topNav>div.secondary-link-group>a")
		public WebElement g2MeetingPageLogo;
	
	@FindBy(how=How.CSS, using = "#contact-list>li[data-for=Categories]")
		public List<WebElement> allCategories;
		
	public GoToMeeting_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
	}
	
	public String getCatHeadingText(){
		String txt;
		System.out.println("Inside the getCatHeadingText()");
		txt = catHeading.getText();
		return txt;
	}
	
	
}
