package test.com.help.citrix.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.help.citrix.Contact_Us_Page;
import com.help.citrix.GoToMeeting_Page;

import page.factory.helper.BrowserFactory;

public class Test_Contact_Us_Page {
	WebDriver driver;
	Contact_Us_Page Contact_Us_pg;	
	String baseEnv = "";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String baseProduct ="/contact-us";
	String supportUrl = "/support";
	
	
	@BeforeTest 
		@Parameters("browser")	
	public void setupContact_Us_Page(String browser){
		System.out.println("@BeforeTest");		
		driver = BrowserFactory.startBrowser(browser, "about:blank");
		System.out.println("Browser Name = " + browser);
		
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
		driver.get(baseUrl+baseProduct);				
	}
		
	@Test (priority = 0)
	public void verifyPageHeader(){
		try{
			Contact_Us_pg = new Contact_Us_Page(driver);		
			System.out.println("This Page Heading Text is : "+ Contact_Us_pg.getProdHeadingText());
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyPageHeader()");
		}
		finally{}
	}
	
	@Test (priority = 1)
	public void verifyG2M(){
		//baseProduct = "/meeting";
		try{
			Contact_Us_pg.g2Meeting.click();
			GoToMeeting_Page g2Mpg = new GoToMeeting_Page(driver);
			System.out.println("The G2M Logo Url is : " + g2Mpg.g2MeetingPageLogo.getAttribute("href"));
			Assert.assertEquals((baseUrl+supportUrl), g2Mpg.g2MeetingPageLogo.getAttribute("href"));
			
			for (WebElement wE : g2Mpg.allCategories ){
				System.out.println("The text of Element: " + wE.getText());
			}
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2M()");
		}
		finally{
			driver.manage().deleteAllCookies();
			System.out.println("The url to navigate back to is:" + (baseUrl+baseProduct));
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 2)
	public void verifyG2T(){
		try{
			Contact_Us_pg.g2Training.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2T()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 3)
	public void verifyG2W(){
		try{
			Contact_Us_pg.g2Web.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2W()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
		
	@Test (priority = 4)
	public void verifyG2Assist(){
		try{
			Contact_Us_pg.g2Assist.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2Assist()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 5)
	public void verifyG2Co(){
		try{
			Contact_Us_pg.g2Concierge.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2Co()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 6)
	public void verifyG2MyPC(){
		try{
			Contact_Us_pg.g2MyPC.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyG2MyPC()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 7)
	public void verifyg2OpenVoice(){
		try{
			Contact_Us_pg.g2OpenVoice.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyg2OpenVoice()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 8)
	public void verifyg2ShareFile(){
		try{
			Contact_Us_pg.g2ShareFile.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyg2ShareFile()");
		}
		finally{
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl+baseProduct);
		}
	}
	
	@Test (priority = 9)
	public void verifyg2ShareConnect(){
		try{
			Contact_Us_pg.g2ShareConnect.click();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyg2ShareConnect()");
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
