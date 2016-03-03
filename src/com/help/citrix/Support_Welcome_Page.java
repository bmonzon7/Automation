package com.help.citrix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Support_Welcome_Page {

	WebDriver driver;
	static int WAIT_TIME = 30;
	
	public Support_Welcome_Page(WebDriver driver){
		this.driver = driver;
		
		//this is the wait factory for finding all the WebElements I will be looking for in the page
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
	}
	
	
	
	/* GoToMeeting */
	@FindBy(how = How.CSS,using = ".productmeeting.product-selectorlogos")
	@CacheLookup
		public WebElement g2Meeting;
	
	/* GoToMyPC */	
	@FindBy(how = How.CSS, using = ".productgotomypc.product-selectorlogos") 
	@CacheLookup
		public WebElement g2MyPC;
	
	
	/* GoToWebinar */
	@FindBy(how=How.CSS, using = ".productwebinar.product-selectorlogos")
		public WebElement g2Web;
	
	/* GoToTraining */
	@FindBy(how=How.CSS, using =".producttraining.product-selectorlogos")
		public WebElement g2Training;
	
	/* GoToTraining */
	@FindBy(how=How.CSS, using =".productopenvoice.product-selectorlogos")
		public WebElement g2Openvoice;
	
	
	/* GoToPodio */
	@FindBy(how=How.CSS, using = ".productpodio.product-selectorlogos")
		public WebElement g2Podio;
	
	/* GoToShareFile */
	@FindBy(how=How.CSS, using = ".productsharefile.product-selectorlogos")
		public WebElement g2ShareFile;
	
	/* GoToShareConnect */
	@FindBy(how=How.CSS, using =".productshareconnect.product-selectorlogos")
		public WebElement g2ShareConn;
	
	/* GoToAssist -->Corporate */
	@FindBy(how=How.CSS, using = "li#sub-productlist.g2a-prdlist.prd-list")
		public WebElement g2AssistDropDown;
	
	/* GoToAssist -->Corporate */
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='g2a-prdlist prd-list']>ul.g2a-products li:nth-of-type(2) >a")
		public WebElement g2AssistCorp;
	
	/* GoToAssist --> Remote Support */
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='g2a-prdlist prd-list']>ul.g2a-products li:nth-of-type(3) >a")
		public WebElement g2AssistRem;
	
	/* GoToAssist --> Service Desk */
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='g2a-prdlist prd-list']>ul.g2a-products li:nth-of-type(4) >a")
		public WebElement g2AssistServ;
	
		/* Top Nav Menu */
	@FindBy(how=How.CSS, using = ".topNav>header")
		public WebElement topNavMenu;
	
	/* Page Title Text */
	@FindBy(how=How.CSS, using = ".section-title")
		public WebElement sectionTitleTxt;
	
	//More Products dropdown selector
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='moreprdct prd-list'] >a.showdropdown")
		public WebElement moreProductsDropDown;

	/* Workspace Cloud */
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='moreprdct prd-list'] >ul.g2a-products li:nth-of-type(1) >a")
	public WebElement g2WsCloud;
	
	/* Concierge */
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='moreprdct prd-list'] >ul.g2a-products li:nth-of-type(2) >a")
	public WebElement g2Concierge;
	
	//Grasshopper link within the MoreProducts
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='moreprdct prd-list']>ul.g2a-products li:nth-of-type(3) >a")
		public WebElement g2Grasshopper;
	
	
	//method to click on the More Products element
	public void clickMoreProducts(){
		
		System.out.println("Inside clickMoreProducts()");
		System.out.println ("WebElement Text Attribute:" + moreProductsDropDown.getText());
		moreProductsDropDown.click();
	}
	
	public void clickG2AssistDropDown(){
		
		System.out.println("Inside clickG2AssistDropDown()");
		System.out.println ("WebElement Text Attribute:" + g2AssistDropDown.getText());
		g2AssistDropDown.click();
	}
	
	/*
		//method to click on the GoToMeetingLogo
		public void clickGoToMeetingLogo(){
			myGoToMeetingLogo.click();
		}
	
	 * 
	//method to click on Grasshopper -Depends on the clickMoreProducts() running first
	public void clickGrasshoper(){
		System.out.println("Inside clickGrasshoper()");
		System.out.println ("WebElement Text Attribute: " + grasshopperLink.getText());
		grasshopperLink.click();
	}
	
	//method to get the href value from the GoToMeeting logo to be used for ensuring it will take you to the right location
		public String getGoToMeetingLogoUrl(){
			String url;
			url = myGoToMeetingLogo.getAttribute("href");
			return url;
		}
*/
		//method to get the Main Page title text
		public String getSectionTitle(){
			String mainPageText;
			mainPageText = sectionTitleTxt.getText();
			return mainPageText;
			
		}
	
	
}
