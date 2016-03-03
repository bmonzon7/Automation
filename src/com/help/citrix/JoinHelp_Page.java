package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoinHelp_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
		
	@FindBy(how=How.CSS, using = "h3.join-help-head1")
		public WebElement pageHeading;
	
	@FindBy(how=How.CSS, using = ".icon-s>img[src$='icon-people.png']")
		public WebElement imAttendee;
	
	@FindBy(how=How.CSS, using = ".icon-s>img[src$='icon-person.png']")
		public WebElement imOrganizer;
	
	@FindBy(how=How.CSS, using = "div.text.parbase.section:"
			+ "nth-of-type(1)>p.join-help-change.join-help-attendee +h2+ul>li>a")
		public List<WebElement> attendeeHelpLinks;
	
	@FindBy(how=How.CSS, using = "div.text.parbase.section:"
			+ "nth-of-type(1)>p.join-help-change.join-help-organizer +h2+ul>li>a")
		public List<WebElement> organizerHelpLinks;
		
	public JoinHelp_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
	}
	
	public String getPageHeadingText(){
		String txt;
		System.out.println("Inside the getPageHeadingText()");
		txt = pageHeading.getText();
		return txt;
	}
	
	
}
