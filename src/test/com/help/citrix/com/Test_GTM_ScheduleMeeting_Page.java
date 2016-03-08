package test.com.help.citrix.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.help.citrix.GTM_ScheduleMeeting_Page;

import page.factory.helper.BrowserFactory;

public class Test_GTM_ScheduleMeeting_Page {
	WebDriver driver;	
	GTM_ScheduleMeeting_Page scheduleMtngPage;
	String baseEnv = "ed1";
	String baseProduct = "/meeting/schedulemeeting";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	
	
	@BeforeTest
	@Parameters("browser")
	public void setupScheduleMeetingPage(String browser){
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
	}
	
	@Test (priority=0)
	public void verifyScheuleMeetingPage(){
		scheduleMtngPage = new GTM_ScheduleMeeting_Page(driver);
	
		
		//Left Hand Navigation - Categories
		for (WebElement wE : scheduleMtngPage.leftNav ){
			System.out.println("The left hand nav Categories are: " + wE.getText());
			System.out.println("");
		}
	
		//Left hand Nav - Category Selected
		System.out.println("The Selected Category is: " + scheduleMtngPage.selectedCategory.getText());
		System.out.println("");
		
		
		///The page header is 
		System.out.println("The Header Text for the page is is: " + scheduleMtngPage.pageHeader.getText());
		System.out.println("");
		
		
		
		//get Subcategory headings
		
		//Left Hand Navigation - Categories
		for (WebElement wE : scheduleMtngPage.subCatHeaders ){
			System.out.println("The Category Header Text is: " + wE.getText());
			System.out.println("");
			}
		
		//Get Help from Community header
		System.out.println("The Get Help from Community Header Text is: " + scheduleMtngPage.getHelpCommHeader.getText());
		System.out.println("");
		
		//Still need help header
		System.out.println("The Sill need Help? header Text is: " + scheduleMtngPage.stillNeedHelpHeader.getText());
		System.out.println("");
		
		/* Article Containers
		 * 
		 */
		//Community Help articles
		for (WebElement wE : scheduleMtngPage.communityArticles){
			System.out.println("The Community Help Article(s) Text is: " + wE.getText());
			System.out.println("The Community Help Article(s) Url is: " + wE.getAttribute("href"));
			System.out.println("");
			
			}
		
				
		//Column 1 Articles
		for (WebElement wE : scheduleMtngPage.col1Articles){
			System.out.println("The Column1 Article(s) Text is: " + wE.getText());
			System.out.println("The Column1 Article(s) Url is: " + wE.getAttribute("href"));
			System.out.println("");
			}
		
		
		//Column 2 Articles
		for (WebElement wE : scheduleMtngPage.col2Articles){
			System.out.println("The Column2 Article(s) Text is: " + wE.getText());
			System.out.println("The Column2 Article(s) Url is: " + wE.getAttribute("href"));
			System.out.println("");
			}
	
		
		/* verify controls
		 * 
		 * 
		 */
		
		
		//TopSearch input box
		System.out.println("Top Search Input Box Text is: " + scheduleMtngPage.topSearchInput.getAttribute("placeholder"));
		System.out.println("");
		
		//TopSearch input box button
		System.out.println("Top Search Input Button is: " + scheduleMtngPage.topSearchButton.getText());
		System.out.println("");
		
		//Bottom Search input box
		System.out.println("Bottom Search input box Text is: " + scheduleMtngPage.bottomSearchInput.getAttribute("placeholder"));
		System.out.println("");		
		
		//Bottom Search input box button
		System.out.println("Bottom Search Input Button Text is: " + scheduleMtngPage.bottomSearchButton.getText());
		System.out.println("");
		
		//Call or email us button
		System.out.println("Call or email us button Text is: " + scheduleMtngPage.callEmailUsButton.getText());
		System.out.println("");
		
		//Chat with an agent button
		System.out.println("Chat with an agent Button Text is: " + scheduleMtngPage.chatButton.getText());
		System.out.println("");
		//System.out.println("");
		//System.out.println("");
		
	}	
		
	@Test (priority=1)
	public void clickCallorEmailUs(){
		try{
			scheduleMtngPage.clickCallUsButton();
			System.out.println("The Call or Email Us button took me to page: " +  driver.getCurrentUrl());		
			Assert.assertTrue(driver.getCurrentUrl().contains("citrix.com/contactus"));
			System.out.println("");
			
			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the clickCallUsButton()");
			System.out.println("");
		}
		finally{
			driver.navigate().back();
		}
	}
	
	@Test (priority=2)
	public void clickChat(){
		
		try{
			scheduleMtngPage.clickChatButton();
			System.out.println("The Chat button took me to page: " +  driver.getCurrentUrl());
			Assert.assertTrue(driver.getCurrentUrl().contains("http://www.gotoassist.com/sb/gtm"));
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");		
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the clickChatButton()");
			System.out.println("");
		}
		finally{
			driver.navigate().back();
		}
		
	}
	
	@AfterTest
	public void closeBrowser(){
		try{
			driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception in trying to close Browser: " + e.toString());
			
			throw(e);
		}
		finally{
			
		}
	}
	
	
	
}