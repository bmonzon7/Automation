package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleMeeting_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
	
	public ScheduleMeeting_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
	}
	
	/* Navigation
	 * 
	 * */
		//Left Hand Navigation - Categories 
		@FindBy(how=How.CSS, using = "#jump-menu")
			public List<WebElement> leftNav;
	
		
		//Left Hand Navigation - Selected item'
		@FindBy(how=How.CSS, using = "#jump-menu>li.nav-selected")
			public WebElement selectedCategory;
		
	/* Controls 
	 * 
	 * */
		//TopSearch input box
		@FindBy(how=How.CSS, using="#tags")
			public WebElement topSearchInput;
				
		//Topsearch button
		@FindBy(how=How.CSS, using = ".button.postfix.icon-search")
			public WebElement topSearchButton;
		
		//BottomSearch input box
		@FindBy(how=How.CSS, using ="#gsfn_search_query")
			public WebElement bottomSearchInput;
				
		//BottomSearch button
		@FindBy(how=How.CSS, using = "#continue")
			public WebElement bottomSearchButton;
		
		//Call or email us button
		@FindBy(how=How.CSS, using = ".contactLogos>div>ul>li:nth-of-type(1)>a.contactSupport")
			public WebElement callEmailUsButton;
		
		//Chat with an agent button
		@FindBy(how=How.CSS, using = ".contactLogos>div>ul>li:nth-of-type(2)>a.contactSupport")
			public WebElement chatButton;
		
	
	/* Headers
	 * 
	 */
	
		//Header - Category chosen = Schedule & Start Meetings
		@FindBy(how=How.CSS, using = ".citrix-lt-36px-grey")
		public WebElement pageHeader;
	
	/* Subcategory Headers
	 * 
	 */
		
		//Subcategory headers
		@FindBy(how=How.CSS, using = ".large-6.medium-6.small-12.columns>h2")
			public List<WebElement> subCatHeaders;
		
		//Get help from the community
		@FindBy(how=How.CSS, using = ".large-12.columns>h2")
			public WebElement getHelpCommHeader;
		
		//Still Need Help?
		@FindBy(how=How.CSS, using = ".contactLogos>div>p")
		public WebElement stillNeedHelpHeader;
	
		/* Article Containers
		 * 
		 */
		//Get help from community articles
		@FindBy(how=How.CSS, using = ".gsfn_link")
		public List<WebElement> communityArticles;
	
		
		//Column 1 Articles
		@FindBy(how=How.CSS, using = ".large-6.medium-6.small-12.columns:nth-of-type(1)>h2 +ul:nth-of-type(1)>li>a")
			public List<WebElement> col1Articles;
		
		//Column 2 Articles
		@FindBy(how=How.CSS, using = ".large-6.medium-6.small-12.columns:nth-of-type(2)>h2 +ul:nth-of-type(1)>li>a")
			public List<WebElement> col2Articles;
}
