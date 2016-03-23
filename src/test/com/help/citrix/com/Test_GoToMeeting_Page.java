package test.com.help.citrix.com;

import com.help.citrix.*;
import org.testng.annotations.Test;

import com.help.citrix.Support_Welcome_Page;

import page.factory.helper.BrowserFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_GoToMeeting_Page {	
	WebDriver driver;	
	GoToMeeting_Page g2MeetingPg;
	String baseEnv = "ed1";
	String baseProduct = "/meeting";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	
	
	@BeforeTest
	@Parameters("browser")
	public void setupGoToMeetingPage(String browser){
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
	}
	
	@Test
	public void verifyGoToMeetingPage(){
		g2MeetingPg = new GoToMeeting_Page(driver);
	
		
		//Category Headings
		for (WebElement wE : g2MeetingPg.categoriesHeaders ){
			System.out.println("The Category Heading text is: " + wE.getText());
		}
	
		//Category Articles
		for (WebElement wE : g2MeetingPg.catArticles){
			System.out.println("The Category Article text is: " + wE.getText());
			System.out.println("The Category Article url is: " +wE.getAttribute("href"));
			
			}
		
		//SubCategory Headings
		for(WebElement wE : g2MeetingPg.allSubCategoryHeaders){
			System.out.println("The SubCategory Heading text is: " + wE.getText());
			//System.out.println("The SubCategory Heading url is: " +wE.getAttribute("href"));
			
		}
		//SubCategory Articles
		for(WebElement wE : g2MeetingPg.subCatArticles){
			System.out.println("The SubCategory Article text is: " + wE.getText());
			System.out.println("The SubCategory Article url is: " +wE.getAttribute("href"));
			
		}
		//HowToVideo Articles
		for(WebElement wE : g2MeetingPg.howToVideoArticles){
			System.out.println("The How-To Video Article text is: " + wE.getText());
			System.out.println("The How-To Video Article url is: " +wE.getAttribute("href"));
			}
	
		

		//Icon Header Text
		for(WebElement wE : g2MeetingPg.iconHeader){
			System.out.println("The Icon Header text is: " + wE.getText());
			}
		
		//Icon Header Links - go to each link 
		/* This must be commented out for now because every time I load the tab and return to original tab
		 * the DOM is refreshed and it says it cant find the original link
		 */
		List<String> urls = new ArrayList<String>();
		
		for (int i = 0; i<g2MeetingPg.iconHeaderLink.size(); i++){
			urls.add(g2MeetingPg.iconHeaderLink.get(i).getAttribute("href"));
		}
		
		for(int i = 0; i < urls.size();i++){
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"t");
			driver.get(urls.get(i));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"w");
		}
		
		g2MeetingPg = null;
		
		g2MeetingPg = new GoToMeeting_Page(driver);
		
		for(WebElement wE : g2MeetingPg.iconHeaderLink){
			System.out.println("The Icon Header Link text is: " + wE.getText());
			System.out.println("The Icon Header Link url is: " +wE.getAttribute("href"));
			//wE.click();
			//Trying to work with browser opening new tabs for links - bug being fixed
			/*
			Actions newTab = new Actions(driver);
			newTab.sendKeys(Keys.COMMAND).click(wE).build().perform();
			
			//driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"w");
			//driver.get(wE.getAttribute("href"));
			//String selectAll = Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.TAB);
			//driver.findElement(By.cssSelector("body")).sendKeys(selectAll);
			*/
			
		}
		
		
		//BoxServices
		for(WebElement wE : g2MeetingPg.boxServiceHeadings){
			System.out.println("The Box Service Heading text is: " + wE.getText());
			}	
		
		//BoxServices Links
		for(WebElement wE : g2MeetingPg.boxServiceLinks){
			System.out.println("The Box Service Link text is: " + wE.getText());
			System.out.println("The Box Service Link url is: " +wE.getAttribute("href"));	
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