package test.com.help.citrix.com;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.help.citrix.Contact_Us_Page;
import com.help.citrix.GoToMeeting_Page;

import page.factory.helper.BrowserFactory;

public class Test_Contact_Us_Page {
	WebDriver driver;
	Contact_Us_Page contactUsPage;	
	String baseEnv = "";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	//String baseContactUs ="/contact-us";
	String supportUrl = "/support";
	
	@DataProvider
	public Object[][] getData() {
       return new Object[][]{
    	   {1, "/contactus"}, 
    	   {2, "/contact-us"}, 
    	   {3, "/contactus-free"},
    	   {4, "/contactus-paid"}};
       }
	
	@BeforeTest
		@Parameters("browser")
	
	public void setupContact_Us_Page(String browser){
		System.out.println("@BeforeTest");		
		driver = BrowserFactory.startBrowser(browser, "about:blank");
		System.out.println("Browser Name = " + browser);
		contactUsPage = new Contact_Us_Page(driver);
		
		if(!browser.equalsIgnoreCase("Safari")){
			System.out.println("deleting the cookies");
			driver.manage().deleteAllCookies();
						
		}
		
	}

	@Test (dataProvider="getData")
	public void verifyPageHeader( int nontUsed, String baseProduct){
		try{
			
			
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			System.out.println("This Page Heading Text is : "+ contactUsPage.getSupportPageHeader());
			System.out.println("");
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyPageHeader()");
		}
		finally{
			driver.manage().deleteAllCookies();
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyG2M(int nontUsed, String baseProduct){
		//baseProduct = "/meeting";
		try{
			contactUsPage.g2Meeting.click();
			GoToMeeting_Page g2Mpg = new GoToMeeting_Page(driver);
			System.out.println("The G2M Logo Url is : " + g2Mpg.g2MeetingPageLogo.getAttribute("href"));
			Assert.assertEquals((baseUrl+supportUrl), g2Mpg.g2MeetingPageLogo.getAttribute("href"));
			
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
			}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2M()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	
	@Test (dataProvider="getData")
	public void verifyG2T(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2Training.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2T()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	
	@Test (dataProvider="getData")
	public void verifyG2W(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2Web.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2W()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
		
	@Test (dataProvider="getData")
	public void verifyG2AssistCorp(int nontUsed, String baseProduct){
		try{
			driver.get(baseUrl+baseProduct);
			System.out.println("I should be in the Main Support Page: " +
					 driver.getCurrentUrl());
			contactUsPage.g2Assist.click();
			contactUsPage.g2AssistCorp.click();
			String productName = contactUsPage.productName.getText();			
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2AssistCorp()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyG2AssistService(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2Assist.click();
			
			System.out.println("The site that Im testing now is: " + (baseUrl+baseProduct));
			contactUsPage.g2AssistService.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2AssistService()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyG2AssistRemote(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2Assist.click();
				
			System.out.println("The site that Im testing now is: " + (baseUrl+baseProduct));
			contactUsPage.g2AssistRemote.click();
			String productName = contactUsPage.productName.getText();		
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2AssistService()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	
	@Test (dataProvider="getData")
	public void verifyG2Concierge(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2Concierge.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2Concierge()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyG2MyPC(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2MyPC.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
		
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2MyPC()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyg2OpenVoice(int nontUsed, String baseProduct){
		try{
			contactUsPage.g2OpenVoice.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyg2OpenVoice()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyg2ShareFile(int nontUsed, String baseProduct){
		try{
			String winHandleBefore = driver.getWindowHandle();
			contactUsPage.g2ShareFile.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
			// Switch to new window opened
						for(String winHandle : driver.getWindowHandles()){
						    driver.switchTo().window(winHandle);
						}

						// Perform the actions on new window
						currentSite = driver.getCurrentUrl();
						System.out.println("The current site is: " + currentSite);
						
						// Close the new window, if that window no more required
						driver.close();

						// Switch back to original browser (first window)
						driver.switchTo().window(winHandleBefore);	
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyg2ShareFile()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (dataProvider="getData")
	public void verifyg2ShareConnect(int nontUsed, String baseProduct){
		try{
			String winHandleBefore = driver.getWindowHandle();
			contactUsPage.g2ShareConnect.click();
			String productName = contactUsPage.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			
			for(WebElement wE :contactUsPage.catContainer )
			{
				System.out.println("The Category Name is: " + wE.getText());
			}
			
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}

			// Perform the actions on new window
			currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);	
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyg2ShareConnect()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	
	@Test (dataProvider="getData")
	public void verifyg2Grasshopper(int nontUsed, String baseProduct){
		try{
			
			System.out.println("Inside the verifyg2Grasshopper()");
				
			
			driver.get(baseUrl+baseProduct);
			System.out.println("The site that Im testing now is: " + driver.getCurrentUrl());
			
			
			// Store the current window handle
			String winHandleBefore = driver.getWindowHandle();
			contactUsPage.g2Grasshopper.click();
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}

			// Perform the actions on new window
			String currentSite = driver.getCurrentUrl();
			System.out.println("The current site is: " + currentSite);
			
			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);			
		}
		catch(Exception ex){
			 System.out.println("Something went wrong in the verifyg2Grasshopper()");
		  }
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			System.out.println("");
			driver.navigate().to(baseUrl+baseProduct);
		}
	}

	@AfterTest
	public void closeBrowser(){
		try{
			driver.manage().deleteAllCookies();
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
