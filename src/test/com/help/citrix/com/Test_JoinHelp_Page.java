package test.com.help.citrix.com;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import com.help.citrix.Contact_Us_Page;
//import com.help.citrix.GoToMeeting_Page;
import com.help.citrix.JoinHelp_Page;

import page.factory.helper.BrowserFactory;


public class Test_JoinHelp_Page {
	WebDriver driver;
	JoinHelp_Page joinHelppg;
	//String browserName = "firefox";
	String baseEnv = "stage";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String baseProduct ="/meeting/joinhelp";
	String supportUrl = "/support";
	
	
	@BeforeTest
	@Parameters("browser")
	public void setupJoinHelp_Page(String browser){
		System.out.println("@BeforeTest");
		driver = BrowserFactory.startBrowser(browser, "about:blank");		
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
		driver.get(baseUrl+baseProduct);	
		
	}
	
	@Test
	public void verifyAttendeePage(){
		
		String article1Text = "I’m having trouble downloading the software.";
		/* This was updated per Victorias Request - Redirect to JoinHelp Download page*/
		//String article1Url = "http://support.citrixonline.com/en_US/Meeting/all_files/G2M030004?__";
		String article1Url = "http://help.citrix.com/meeting/joinhelp/download";
		
		String article2Text = "I’m having trouble connecting online using the Web App.";
		String article2Url = "http://support.citrixonline.com/en_US/meeting/"
				+ "all_files/G2M090027?__";
		
		String article3Text = "I’m waiting for the organizer. What’s going on?";
		String article3Url = "http://support.citrixonline.com/en_US/Meeting/knowledge_articles/"
				+ "000161527?__";
		
		String article4Text = "I’m having audio issues.";
		String article4Url = "http://help.citrix.com/meeting/audio";
		
		String article5Text = "I’m new—how do I get started?";
		String article5Url = "http://support.citrixonline.com/en_US/Meeting/video/"
				+ "G2MV00036?__";
		
		String article6Text = "See other topics.";
		String article6Url = "http://help.citrix.com/meeting";
		
		/* REGEX START
		Pattern pattern = Pattern.compile("http://(.*?)");
		
		Matcher matcher = pattern.matcher(article1Url);
		if (matcher.find()){
			System.out.println("The match: " + matcher.group(0));
		}
		REGEX END */
		try{
		joinHelppg = new JoinHelp_Page(driver);
		joinHelppg.imAttendee.click();
	
		//Verify the 1st Article
		System.out.println("Verifying Attendee Article 1 Text:"+ joinHelppg.attendeeHelpLinks.get(0).getText());
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(0).getText(), article1Text);
		System.out.println("Verifying Attendee Article 1 Url: " + joinHelppg.attendeeHelpLinks.get(0).getAttribute("href") );
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(0).getAttribute("href").
					contains(article1Url));
		joinHelppg.attendeeHelpLinks.get(0).click();
		driver.navigate().back();
		//joinHelppg.imAttendee.click();
		
		//Verify the 2nd Article
		System.out.println("Verifying Attendee Article 2 Text:"+ joinHelppg.attendeeHelpLinks.get(1).getText());
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(1).getText(), article2Text);
		System.out.println("Verifying Attendee Article 2 Url: " + joinHelppg.attendeeHelpLinks.get(1).getAttribute("href") );
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(1).getAttribute("href").
					contains(article2Url));
		joinHelppg.attendeeHelpLinks.get(1).click();
		driver.navigate().back();
		//joinHelppg.imAttendee.click();
		
		//Verify the 3rd Article
		System.out.println("Verifying Attendee Article 3 Text:"+ joinHelppg.attendeeHelpLinks.get(2).getText());
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(2).getText(), article3Text);
		System.out.println("Verifying Attendee Article 3 Url: " + joinHelppg.attendeeHelpLinks.get(2).getAttribute("href") );
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(2).getAttribute("href").
					contains(article3Url));
		joinHelppg.attendeeHelpLinks.get(2).click();
		driver.navigate().back();
		//joinHelppg.imAttendee.click();
		
		//Verify the 4th Article
		System.out.println("Verifying Attendee Article 4 Text:"+ joinHelppg.attendeeHelpLinks.get(3).getText());
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(3).getText(), article4Text);
		System.out.println("Verifying Attendee Article 4 Url: " + joinHelppg.attendeeHelpLinks.get(3).getAttribute("href") );
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(3).getAttribute("href").
					contains(article4Url));
		joinHelppg.attendeeHelpLinks.get(3).click();
		driver.navigate().back();
		//joinHelppg.imAttendee.click();
				
		//Verify the 5th Article
		System.out.println("Verifying Attendee Article 5 Text:"+ joinHelppg.attendeeHelpLinks.get(4).getText());
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(4).getText(), article5Text);
		System.out.println("Verifying Attendee Article 5 Url: " + joinHelppg.attendeeHelpLinks.get(4).getAttribute("href") );
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(4).getAttribute("href").
					contains(article5Url));
		joinHelppg.attendeeHelpLinks.get(4).click();
		driver.navigate().back();
		//joinHelppg.imAttendee.click();
		
		//Verify the 6th Article
		System.out.println("Verifying Attendee Article 6 Text:"+ joinHelppg.attendeeHelpLinks.get(5).getText());
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(5).getText(), article6Text);
		System.out.println("Verifying Attendee Article 6 Url: " + joinHelppg.attendeeHelpLinks.get(5).getAttribute("href") );
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(5).getAttribute("href").
					contains(article6Url));
		joinHelppg.attendeeHelpLinks.get(5).click();
		driver.navigate().back();
		System.out.println("Clearing All Cookies");
		driver.manage().deleteAllCookies();
		//joinHelppg.imAttendee.click();
		
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyAttendeePage()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);	
		}
	/*	
		for(int i=0;  i< joinHelppg.attendeeHelpLinks.size(); i++){
			System.out.println("The article" + 
					i + "text is: " + joinHelppg.attendeeHelpLinks.get(i).getText());
		}
	*/	
		/*
		for(WebElement eX : joinHelppg.attendeeHelpLinks){
			System.out.println(eX.getText());
			System.out.println("Article Link = " + eX.getAttribute("href"));
			
		}
		*/
	}
	
	@Test //(enabled = false)
	public void verifyOrganizerPage(){
		
		try{
			String article1Text = "I’m having trouble downloading the software";
			/* This was updated per Victorias Request - Redirect to JoinHelp Download page*/
			//String article1Url = "http://support.citrixonline.com/en_US/Meeting/all_files/G2M030004?__";
			String article1Url = "http://help.citrix.com/meeting/joinhelp/download";
			
			
			
			String article2Text = "I’m having trouble connecting online using the Web App.";
			String article2Url = "http://support.citrixonline.com/en_US/Meeting/all_files/G2M090008?__";
			
			String article3Text = "I forgot my password.";
			String article3Url = "http://support.citrixonline.com/en_US/meeting/all_files/G2M010004?__";
			
			String article4Text = "I’m having audio issues.";
			String article4Url = "http://help.citrix.com/meeting/audio";
			
			String article5Text = "I’m new—how do I get started?";
			String article5Url = "http://support.citrixonline.com/en_US/meeting/all_files/G2M010022?__";
			
			String article6Text = "See other topics.";
			String article6Url = "http://help.citrix.com/meeting";
					
			joinHelppg.imOrganizer.click();
		
			//Verify the 1st Article
			System.out.println("Verifying Organizer Article 1 Text:"+ joinHelppg.organizerHelpLinks.get(0).getText());
			Assert.assertEquals(joinHelppg.organizerHelpLinks.get(0).getText(), article1Text);
			System.out.println("Verifying Organizer Article 1 Url: " + joinHelppg.organizerHelpLinks.get(0).getAttribute("href") );
			Assert.assertTrue(joinHelppg.organizerHelpLinks.get(0).getAttribute("href").
						contains(article1Url));
				joinHelppg.organizerHelpLinks.get(0).click();
				driver.navigate().back();
				//joinHelppg.imOrganizer.click();
			
			//Verify the 2nd Article
			System.out.println("Verifying Organizer Article 2 Text:"+ joinHelppg.organizerHelpLinks.get(1).getText());
			Assert.assertEquals(joinHelppg.organizerHelpLinks.get(1).getText(), article2Text);
			
			System.out.println("Verifying Organizer Article 2 Url: " + joinHelppg.organizerHelpLinks.get(1).getAttribute("href") );
			Assert.assertTrue(joinHelppg.organizerHelpLinks.get(1).getAttribute("href").
						contains(article2Url));
			joinHelppg.organizerHelpLinks.get(1).click();
			driver.navigate().back();
			//joinHelppg.imOrganizer.click();
		
			
			//Verify the 3rd Article
			System.out.println("Verifying Organizer Article 3 Text:"+ joinHelppg.organizerHelpLinks.get(2).getText());
			Assert.assertEquals(joinHelppg.organizerHelpLinks.get(2).getText(), article3Text);
			System.out.println("Verifying Organizer Article 3 Url: " + joinHelppg.organizerHelpLinks.get(2).getAttribute("href") );
			Assert.assertTrue(joinHelppg.organizerHelpLinks.get(2).getAttribute("href").
						contains(article3Url));
			joinHelppg.organizerHelpLinks.get(2).click();
			driver.navigate().back();
			//joinHelppg.imOrganizer.click();
		
			
			//Verify the 4th Article
			System.out.println("Verifying Organizer Article 4 Text:"+ joinHelppg.organizerHelpLinks.get(3).getText());
			Assert.assertEquals(joinHelppg.organizerHelpLinks.get(3).getText(), article4Text);
			System.out.println("Verifying Organizer Article 4 Url: " + joinHelppg.organizerHelpLinks.get(3).getAttribute("href") );
			Assert.assertTrue(joinHelppg.organizerHelpLinks.get(3).getAttribute("href")
					.contains(article4Url));
			joinHelppg.organizerHelpLinks.get(3).click();
			driver.navigate().back();
			//joinHelppg.imOrganizer.click();
			
			//Verify the 5th Article
			System.out.println("Verifying Organizer Article 5 Text:"+ joinHelppg.organizerHelpLinks.get(4).getText());
			Assert.assertEquals(joinHelppg.organizerHelpLinks.get(4).getText(), article5Text);
			System.out.println("Verifying Organizer Article 5 Url: " + joinHelppg.organizerHelpLinks.get(4).getAttribute("href") );
			Assert.assertTrue(joinHelppg.organizerHelpLinks.get(4).getAttribute("href").
						contains(article5Url));		
			joinHelppg.organizerHelpLinks.get(4).click();
			driver.navigate().back();
			//joinHelppg.imOrganizer.click();
			
			//Verify the 6th Article
			System.out.println("Verifying Organizer Article 6 Text:"+ joinHelppg.organizerHelpLinks.get(5).getText());
			Assert.assertEquals(joinHelppg.organizerHelpLinks.get(5).getText(), article6Text);
			System.out.println("Verifying Organizer Article 6 Url: " + joinHelppg.organizerHelpLinks.get(5).getAttribute("href") );
			Assert.assertTrue(joinHelppg.organizerHelpLinks.get(5).getAttribute("href").
						contains(article6Url));		
			joinHelppg.organizerHelpLinks.get(5).click();
			driver.navigate().back();
			//joinHelppg.imOrganizer.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyAttendeePage()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);	
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
	
	