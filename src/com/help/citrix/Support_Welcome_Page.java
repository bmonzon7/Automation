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
	//Setup the Find by structure for the products in the Welcome to Support 
	//Using the How
	
	// These are all the elements I will be looking for in the Page
	
	/* GoToMyPC webelement using the by CSS*/	
	@FindBy(how = How.CSS, using = ".productgotomypc.product-selectorlogos") 
	@CacheLookup
		WebElement myGoToPCLogo;
	
	/* GoToMeeting by CSS*/
	@FindBy(how = How.CSS,using = ".productmeeting.product-selectorlogos")
	@CacheLookup
	public	
		WebElement myGoToMeetingLogo;
	
	@FindBy(how=How.CSS, using = ".topNav>header")
		WebElement topNavMenu;
	
	@FindBy(how=How.CSS, using = ".section-title")
		WebElement sectionTitleTxt;
	
	//More Products dropdown selector
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='moreprdct prd-list'] >a.showdropdown")
		WebElement moreProductsDropDown;

	
	//Grasshopper link within the MoreProducts
	@FindBy(how=How.CSS, using = "li[id='sub-productlist'][class='moreprdct prd-list'] "
			+ ">ul.g2a-products li:nth-of-type(3) >a")
		WebElement grasshopperLink;
	
	
	//method to click on the GoToMeetingLogo
	public void clickGoToMeetingLogo(){
		myGoToMeetingLogo.click();
	}
	
	//method to get the href value from the GoToMeeting logo to be used for ensuring it will take you to the right location
	public String getGoToMeetingLogoUrl(){
		String url;
		url = myGoToMeetingLogo.getAttribute("href");
		return url;
	}

	//method to get the Main Page title text
	public String getSectionTitle(){
		String mainPageText;
		mainPageText = sectionTitleTxt.getText();
		return mainPageText;
		
	}
	
	//method to click on the More Products element
	public void clickMoreProducts(){
		
		System.out.println("Inside clickMoreProducts()");
		System.out.println ("WebElement Text Attribute:" + moreProductsDropDown.getText());
		moreProductsDropDown.click();
	}
	
	//method to click on Grasshopper -Depends on the clickMoreProducts() running first
	public void clickGrasshoper(){
		System.out.println("Inside clickGrasshoper()");
		System.out.println ("WebElement Text Attribute: " + grasshopperLink.getText());
		grasshopperLink.click();
	}
	
	
	
	
}
