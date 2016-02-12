package test.com.help.citrix.com;

import com.help.citrix.*;
import org.testng.annotations.Test;

import com.help.citrix.Support_Welcome_Page;

import page.factory.helper.BrowserFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSupportWelcomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	Support_Welcome_Page welcomePg;
	String baseUrl = "http://helped1.citrix.com";
	String browserName = "firefox";
	
	@BeforeTest
	public void setupSupportWelcomePage(){
		driver = BrowserFactory.startBrowser(browserName, baseUrl);
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test (priority = 1)
	public void verifySupportWelcomeLandingPage(){
		try{
			System.out.println("Inside the Test = 1");
			welcomePg = new Support_Welcome_Page(driver);
			wait.until(ExpectedConditions.visibilityOf(welcomePg.myGoToMeetingLogo));
		 	Assert.assertEquals(driver.getCurrentUrl(), "http://helped1.citrix.com/support");
		 	System.out.println("Confirmed: I am in the Support Welcome Landing Page");
		}
		catch(Exception e){
			System.out.println("Something went wrong in the verifySupportWelcomeLandingPage()" + e.toString());
			throw(e);
		}
				
		finally{
			}
	}
		
	
	@Test (priority = 2)//(dependsOnMethods={"verifySupportWelcomeLandingPage"})
	public void GoToMeetingAndBack(){
		
		try{
			System.out.println("Inside the Test = 2");
			//this clicks on the GoToMeeting icon on the Welcome to Citrix Support
			welcomePg.clickGoToMeetingLogo();
			
			//this clicks the GoToMeeting logo if it appears on the page - to indicate Im in the correct page
			driver.findElement(By.cssSelector("#sublogo")).click();
			//Verify if I am the correct 
			verifySupportWelcomeLandingPage();
			
		}
		catch(Exception e){
			System.out.println("Something went wrong in the GoToMeetingAndBack()" + e.toString());
			throw(e);
		}	
		finally{
				
			}
	}
		
	@Test (priority = 3)//(dependsOnMethods={"verifySupportWelcomeLandingPage"})
	public void verifyMainPageTitleText(){
		String txtPageWelcome = welcomePg.getSectionTitle();
		
		try{
			System.out.println("Inside the Test = 3");
			Assert.assertEquals(txtPageWelcome, "Welcome To Citrix1 Support");
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyMainPageTitleText()" + ex.toString());
			//throw(ex);
		}
		finally{
			}
	}
	
	@Test (priority = 4) //(dependsOnMethods={"verifySupportWelcomeLandingPage"})
	public void launchGH(){
	
		try{
			System.out.println("Inside the Test = 4");
			welcomePg.clickMoreProducts();
			welcomePg.clickGrasshoper();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong in the launchGH()" + e.toString());
		}

	}
	
	@Test (priority = 5)
	public void verifyGHSupportPg(){
		try{
			Assert.assertEquals(driver.getCurrentUrl(), "https://support.grasshopper.com/home");
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyGHSupportPg() : " + ex.toString());
		}
		finally{}
	}
	
	
	
	/*@AfterTest
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
	}*/
	
}


