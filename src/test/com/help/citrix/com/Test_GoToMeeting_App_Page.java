package test.com.help.citrix.com;

import com.help.citrix.*;
import org.testng.annotations.Test;

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

public class Test_GoToMeeting_App_Page {	
	WebDriver driver;	
	GoToMeeting_App_Page g2MeetingPg;
	String baseEnv = "";
	String baseProduct = "";
	String baseUrl = "http://www.gotomeeting.com";
	String browserName = "chrome";
	
	@BeforeTest
	
	public void setupGoToMeetingPage(){
		driver = BrowserFactory.startBrowser(browserName, (baseUrl));
		if(!browserName.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
	}
	
	@Test
	public void verifyGoToMeetingAppPage() throws InterruptedException{
		g2MeetingPg = new GoToMeeting_App_Page(driver);
		driver.manage().window().maximize();
		driver.findElement
				(By.cssSelector("div.text.parbase.section.textUnity>p>span.size14px-heavy-white-lineheight20px")).click();
				/*
		g2MeetingPg.headers.click();
		System.out.println("Clicked on Headers");
		Thread.sleep(5000);
			g2MeetingPg.startFreeTrialButton.click();
			
			*/
		/*
		//BoxServices
		for(WebElement wE : g2MeetingPg.toasterMenu){
			System.out.println("The elements in the footer menu are: " + wE.getText());
			}	
		
		*/
	
	}
	
	
	
	
}
