package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoToMeeting_App_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
			
	@FindBy(how=How.CSS, using = ".toasterBar.active")
		public List<WebElement> toasterMenu;
	
	@FindBy(how=How.CSS, using = "div.text.parbase.section.textUnity>p>span.size14px-heavy-white-lineheight20px")
	  	public WebElement headers;
		
	@FindBy(how=How.CSS, using = ".button.filledPrimary")
		public WebElement startFreeTrialButton;
	
	
	public GoToMeeting_App_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
	}
	
		
	
}
