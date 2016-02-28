package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoToMeeting_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
		
	
	@FindBy(how=How.CSS, using = "div.topNav>div.secondary-link-group>a")
		public WebElement g2MeetingPageLogo;
	
	@FindBy(how=How.CSS, using = ".text.parbase.section>p")
		public List<WebElement> categoriesHeaders;
	
	@FindBy(how=How.CSS, using = ".citrix-lt-28px.darkGrey")
		public List<WebElement> allSubCategoryHeaders;

	@FindBy(how=How.CSS, using = "div.additional-resources>p>a")
		public List<WebElement> catArticles;

	@FindBy(how=How.CSS, using = "div.text.parbase.section>p>a")
		public List<WebElement> subCatArticles;

	//How To Videos
	@FindBy(how=How.CSS, using = ".training-videos>p>a")
		public List<WebElement> howToVideoArticles;
	
	//BoxService -- Community, Register for Live Training, Contact Support
	@FindBy(how=How.CSS, using = ".boxservice>div.servicelist>h2")
	
		public List<WebElement> boxServiceHeadings;
	
	//BoxService -- hyperlinks
	@FindBy(how=How.CSS, using = ".boxservice>div.servicelist>a")
		public List<WebElement> boxServiceLinks;
	
	//Icon Header section
	@FindBy(how=How.CSS, using = "ul.icon-heading>li>a>h3")
	@CacheLookup
		public List<WebElement> iconHeader;

	//Icon Header Link section
	@FindBy(how=How.CSS, using = "ul.icon-heading>li>a")
	@CacheLookup
	public List<WebElement> iconHeaderLink;

	
	@FindBy(how=How.CSS, using ="input[name=search]")
	public WebElement gt2SearchBox;
	
	@FindBy(how=How.CSS, using =".button.postfix.icon-search")
	public WebElement gt2SearchBtn;


	
	public GoToMeeting_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
	}
	
	
	
	
}
