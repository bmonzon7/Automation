package com.help.citrix;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GTW_Join_Help_Page {
	WebDriver driver;
	final int WAIT_TIME = 15;
	
	//Page header information
	@FindBy(how=How.CSS, using="")
		public WebElement pageHeader;
		
	
	//Category Container
		@FindBy(how=How.CSS, using = ".row>.large-6.medium-6.small-12.columns>h2")
			public List<WebElement> categoryContainer;	

	//Category Name = "Trying To Join"
	@FindBy(how=How.CSS, using = "h1.citrix-lt-36px-grey +div:nth-of-type(1) div:nth-of-type(1)>ul>li>a")
		public List<WebElement> joinCategoryContainer;
	
	//Category Name = "Videos"
	@FindBy(how=How.CSS, using = "h1.citrix-lt-36px-grey +div:nth-child(2) + div >div:nth-child(1)>ul>li>a")
		public List<WebElement> videoCategoryContainer;
	
	//Category Name = "More Help"
	@FindBy(how=How.CSS, using = "h1.citrix-lt-36px-grey +div:nth-child(2) + div >div:nth-child(2)>ul>li>a")
		public List<WebElement> moreHelpCategoryContainer;
			
	//Category Name = "During Your Webinar"
		@FindBy(how=How.CSS, using = "h1.citrix-lt-36px-grey +div:nth-of-type(1) div:nth-of-type(2)>ul>li>a")
			public List<WebElement> duringWebinarCategoryContainer;	
		
	
	//Articles
	@FindBy(how=How.CSS, using = ".article-list>li>a")
		List<WebElement> allArticles;
	
	
	
	
	public GTW_Join_Help_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
	}
	
	
	
}
