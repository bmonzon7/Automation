package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contact_Us_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 10;
	
	
	@FindBy(how=How.CSS, using = "")
		public WebElement placeHolder;
	
	@FindBy(how=How.CSS, using="span#sublogo")
		public WebElement productLogo;
	
	@FindBy(how=How.CSS, using="span.prod-name")
		public WebElement productName;
	
	
	@FindBy(how=How.CSS, using = ".row.product-box")
		public List<WebElement> catContainer;
	
	
	@FindBy(how=How.CSS, using = "#productheading")
		public WebElement contactUsPageNoProdSelectedHeader;
	
	@FindBy(how=How.CSS, using = "span.meeting.logos")
		public WebElement g2Meeting;
	
	
	@FindBy(how=How.CSS, using = "span.training.logos")
		public WebElement g2Training;
	
	@FindBy(how=How.CSS, using = "span.webinar.logos")
	public WebElement g2Web;

	@FindBy(how=How.CSS, using = "span.gotoassist.logos")
		public WebElement g2Assist;
	
	@FindBy(how=How.CSS, using = "span.gotoassistcorporate.logos")
		public WebElement g2AssistCorp;
	
	@FindBy(how=How.CSS, using = "span.gotoassistservicedesk.logos")
	public WebElement g2AssistService;
	
	@FindBy(how=How.CSS, using = "span.gotoassistremotesupport.logos")
	public WebElement g2AssistRemote;
	
	@FindBy(how=How.CSS, using = "span.concierge.logos")
		public WebElement g2Concierge;
	
	@FindBy(how=How.CSS, using = "span.gotomypc.logos")
		public WebElement g2MyPC;
	
	@FindBy(how=How.CSS, using = "span.openvoice.logos")
		public WebElement g2OpenVoice;
	
	@FindBy(how=How.CSS, using = "span.sharefile.logos")
		public WebElement g2ShareFile;
	
	@FindBy(how=How.CSS, using = "span.shareconnect.logos")
		public WebElement g2ShareConnect;
	
	@FindBy(how=How.CSS, using = "span.grasshopper.logos")
	public WebElement g2Grasshopper;

	@FindBy(how=How.CSS, using = ".tabs.resp-tabs-list.tooltip-container>li")
		public List<WebElement> toolTipContainer;
	
	@FindBy(how=How.CSS, using = ".tabs.resp-tabs-list.tooltip-container>li.ask-tab.large-4.medium-4.small-12")
		public WebElement askCommToolTip;
 
	@FindBy(how=How.CSS, using = ".tabs.resp-tabs-list.tooltip-container"
			+ ">li.case-tab.large-4.medium-4.small-12")
		public WebElement createTicketToolTip;
	
	@FindBy(how=How.CSS, using = ".tabs.resp-tabs-list.tooltip-container"
			+ ">li.call-tab.large-4.medium-4.small-12")
		public WebElement callToolTip;
	
	@FindBy(how=How.CSS, using = "#switch-alert #switch-text")
		public WebElement alertBanner;
	
	public Contact_Us_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
		
		
		
	}
	
	public String getSupportPageHeader(){
		String txt;
		System.out.println("Inside the getProdHeadingText()");
		txt = contactUsPageNoProdSelectedHeader.getText();
		return txt;
	}
	
	public void verifyToolTipContainer(){
		for (WebElement wE: this.toolTipContainer){
			System.out.println("1. The toolTipContainer WebElementText is: " + wE.getText());
			
			this.askCommToolTip.click();
			System.out.println("2. After askCommToolTip Click "); 
			System.out.println("3. The askCommToolTip WebElement Text is: " + askCommToolTip.getText());
			
			this.createTicketToolTip.click();
			System.out.println("4. After createTicketToolTip Click ");
			System.out.println("5. The createTicketToolTipTitle WebElement Text is: " + createTicketToolTip.getText());
			
			this.callToolTip.click();			
			System.out.println("6. After callToolTip Click ");
			System.out.println("7. The callToolTipTitle WebElement Text is: " + callToolTip.getText());
			System.out.println("");
		
			
		}
	}
}

