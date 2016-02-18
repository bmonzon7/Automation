package test.com.help.citrix.com;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.help.citrix.Contact_Us_Page;
//import com.help.citrix.GoToMeeting_Page;
import com.help.citrix.JoinHelp_Page;

import page.factory.helper.BrowserFactory;


public class Test_JoinHelp_Page {
	WebDriver driver;
	JoinHelp_Page joinHelppg;
	String browserName = "chrome";
	String baseEnv = "ed1";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String baseProduct ="/meeting/joinhelp";
	String supportUrl = "/support";
	
	
	@BeforeTest
	public void setupJoinHelp_Page(){
		System.out.println("BEFORE TEST METHOD");
		driver = BrowserFactory.startBrowser(browserName, "about:blank");		
		
		driver.manage().deleteAllCookies();
		driver.get(baseUrl+baseProduct);		
		
	}
	
	@Test
	public void verifyAttendeePage(){
		
		String article1Text = "I’m having trouble downloading the software.";
		String article1Url = "http://support.citrixonline.com/Meeting/all_files/"
				+ "G2M050002#Download?__";
		
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
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(0).getText(), article1Text);
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(0).getAttribute("href").
					contains(article1Url));
		joinHelppg.attendeeHelpLinks.get(0).click();
		driver.navigate().back();
		
		//Verify the 2nd Article
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(1).getText(), article2Text);
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(1).getAttribute("href").
					contains(article2Url));
		joinHelppg.attendeeHelpLinks.get(1).click();
		driver.navigate().back();
		
		//Verify the 3rd Article
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(2).getText(), article3Text);
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(2).getAttribute("href").
					contains(article3Url));
		joinHelppg.attendeeHelpLinks.get(2).click();
		driver.navigate().back();
		
		//Verify the 4th Article
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(3).getText(), article4Text);
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(3).getAttribute("href").
					contains(article4Url));
		joinHelppg.attendeeHelpLinks.get(3).click();
		driver.navigate().back();
				
		//Verify the 5th Article
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(4).getText(), article5Text);
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(4).getAttribute("href").
					contains(article5Url));
		joinHelppg.attendeeHelpLinks.get(4).click();
		driver.navigate().back();
		
		//Verify the 6th Article
		Assert.assertEquals(joinHelppg.attendeeHelpLinks.get(5).getText(), article6Text);
		Assert.assertTrue(joinHelppg.attendeeHelpLinks.get(5).getAttribute("href").
					contains(article6Url));
		joinHelppg.attendeeHelpLinks.get(5).click();
		driver.navigate().back();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyAttendeePage()");
		}
		finally{
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
	
	@Test
	public void verifyOrganizerPage(){
		
		String article1Text = "I’m having trouble downloading the software";
		String article1Url = "http://support.citrixonline.com/Meeting/all_files/"
				+ "G2M050002#Download?__";
		
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
		System.out.println("Verifying Article 1 Text:"+ joinHelppg.organizerHelpLinks.get(0).getText());
		Assert.assertEquals(joinHelppg.organizerHelpLinks.get(0).getText(), article1Text);
		System.out.println("Verifying Article 1 Url: " + joinHelppg.organizerHelpLinks.get(0).getAttribute("href") );
		Assert.assertTrue(joinHelppg.organizerHelpLinks.get(0).getAttribute("href").
					contains(article1Url));
		
		//Verify the 2nd Article
		System.out.println("Verifying Article 2 Text:"+ joinHelppg.organizerHelpLinks.get(1).getText());
		Assert.assertEquals(joinHelppg.organizerHelpLinks.get(1).getText(), article2Text);
		
		System.out.println("Verifying Article 2 Url: " + joinHelppg.organizerHelpLinks.get(1).getAttribute("href") );
		Assert.assertTrue(joinHelppg.organizerHelpLinks.get(1).getAttribute("href").
					contains(article2Url));
		
		//Verify the 3rd Article
		System.out.println("Verifying Article 3 Text:"+ joinHelppg.organizerHelpLinks.get(2).getText());
		Assert.assertEquals(joinHelppg.organizerHelpLinks.get(2).getText(), article3Text);
		System.out.println("Verifying Article 3 Url: " + joinHelppg.organizerHelpLinks.get(2).getAttribute("href") );
		Assert.assertTrue(joinHelppg.organizerHelpLinks.get(2).getAttribute("href").
					contains(article3Url));
		
		//Verify the 4th Article
		System.out.println("Verifying Article 4 Text:"+ joinHelppg.organizerHelpLinks.get(3).getText());
		Assert.assertEquals(joinHelppg.organizerHelpLinks.get(3).getText(), article4Text);
		System.out.println("Verifying Article 4 Url: " + joinHelppg.organizerHelpLinks.get(3).getAttribute("href") );
		Assert.assertTrue(joinHelppg.organizerHelpLinks.get(3).getAttribute("href")
				.contains(article4Url));
				
		//Verify the 5th Article
		System.out.println("Verifying Article 5 Text:"+ joinHelppg.organizerHelpLinks.get(4).getText());
		Assert.assertEquals(joinHelppg.organizerHelpLinks.get(4).getText(), article5Text);
		System.out.println("Verifying Article 5 Url: " + joinHelppg.organizerHelpLinks.get(4).getAttribute("href") );
		Assert.assertTrue(joinHelppg.organizerHelpLinks.get(4).getAttribute("href").
					contains(article5Url));		
		
		//Verify the 6th Article
		System.out.println("Verifying Article 6 Text:"+ joinHelppg.organizerHelpLinks.get(5).getText());
		Assert.assertEquals(joinHelppg.organizerHelpLinks.get(5).getText(), article6Text);
		System.out.println("Verifying Article 6 Url: " + joinHelppg.organizerHelpLinks.get(5).getAttribute("href") );
		Assert.assertTrue(joinHelppg.organizerHelpLinks.get(5).getAttribute("href").
					contains(article6Url));				
		
		
	}
	
	
}
	
	