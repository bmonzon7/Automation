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
	
	//Category - Trying to Join
	@FindBy(how=How.XPATH, using = ".//*[@id='content-body']/div[4]/div/div/div/div/div/div[2]"
			+ "/div/div/section/div[1]/div[1]/h2")
		public WebElement category1NameXPATH;
	
	
	//Category - Trying to Join
		@FindBy(how=How.CSS, using = ".large-6.medium-6.small-12.columns>h2")
			public List<WebElement> categoryList;	
		
	@FindBy(how=How.XPATH, using = "//*[@id='content-body']/div[4]/div/div/div/div/div/div[2]"
			+ "/div/div/section/div[2]/div[1]/h2")
		public WebElement category2ListName;
	
	
	@FindBy(how=How.XPATH, using = ".//*[@id='content-body']/div[4]/div/div/div/div/div/div[2]"
			+ "/div/div/section/div[1]/div[1]/ul/li/a")
		public List<WebElement> category1ArticleList;
	
	
		
	
	//Articles
	@FindBy(how=How.CSS, using = ".article-list>li>a")
		List<WebElement> allArticles;
	
	
	
	
	public GTW_Join_Help_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
	}
	
	
	
}
