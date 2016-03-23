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

public class Test_SupportWelcome_Page {	
	WebDriver driver;	
	Support_Welcome_Page welcomePg;
	String baseEnv = "ed1";
	String baseProduct = "/support";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	
	
	@BeforeTest
	@Parameters("browser")
	public void setupSupportWelcomePage(String browser){
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
	}
	
	@Test (priority = 1)
	public void verifySupportWelcomeLandingPage(){
		try{
			driver.manage().deleteAllCookies();
			welcomePg = new Support_Welcome_Page(driver);					
		 	Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		 	System.out.println("Confirmed: I am in the Support Welcome Landing Page");
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifySupportWelcomeLandingPage()" + ex.toString());
			throw(ex);
		}
				
		finally{
		//	driver.navigate().back();
			}
	}
		
	
	@Test (priority = 2)
	public void GoToMeetingAndBack(){
		
		try{
			
			welcomePg.g2Meeting.click();			
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			driver.findElement(By.cssSelector("#sublogo")).click();			
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			System.out.println("Confirmed: I went to g2M and now I am in the Support Welcome Landing Page");
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the GoToMeetingAndBack()" + ex.toString());
			throw(ex);
		}	
		finally{
			//driver.navigate().back();
			}
	}
		
	@Test (priority = 3)
	public void verifyMainPageTitleText(){
		String txtPageWelcome = welcomePg.getSectionTitle();
		
		try{			
			Assert.assertEquals(txtPageWelcome, "Welcome to Citrix Support");
			System.out.println("Confirmed: Main Support Page Text");
			//driver.navigate().back();
		}
		catch(AssertionError ex ){
			System.out.println("Something went wrong in the verifyMainPageTitleText()" + ex.toString());
		}
		finally{
			
			}
	}

	@Test (priority = 4) 
	public void verifyg2Grasshopper(){
		String grasshopperUrl = "https://support.grasshopper.com/home";
		try{	
			//close the survey popup
			driver.findElement(By.cssSelector("#sgE-2338346-1-33-image")).click();
			
			welcomePg.moreProductsDropDown.click();				
			welcomePg.g2Grasshopper.click();
			Assert.assertEquals(driver.getCurrentUrl(), grasshopperUrl);	
			System.out.println("The product I am currently testing is: " + driver.getTitle());
			System.out.println("Confirmed: I went to Grasshopper Product page");			
		}
		catch(Exception ex)
		{
			System.out.println("Something went wrong in the verifyg2Grasshopper()" + ex.toString());
		}
		finally{
			driver.navigate().back();
		}

	}
	
	
	@Test (priority = 5)
	public void verifyg2Webinar(){
		baseProduct = "/webinar";
		try{
			welcomePg.g2Web.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToWebinar page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2Webinar() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 6)
	public void verifyg2Training(){
		baseProduct = "/training";
		try{
			welcomePg.g2Training.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToTraining page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2Training() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 7)
	public void verifyg2MyPc(){
		baseProduct = "/gotomypc";
		try{
			welcomePg.g2MyPC.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToMyPC page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2MyPc() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 8)
	public void verifyg2OpenVoice(){
		baseProduct = "/openvoice";
		try{
			welcomePg.g2Openvoice.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToOpenVoice page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2OpenVoice() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 9)
	public void verifyg2Podio(){
		String podioUrl = "https://help.podio.com/hc/en-us";
		
		try{
			welcomePg.g2Podio.click();
			Assert.assertEquals(driver.getCurrentUrl(), podioUrl);
			
			System.out.println("The product I am currently testing is: " + driver.getTitle());
			System.out.println("Confirmed: I went to Podio page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2Podio() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 10)
	public void verifyg2ShareFile(){
		String baseProduct = "/sharefile";
		
		try{
			welcomePg.g2ShareFile.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			System.out.println("The product I am currently testing is: " + driver.getTitle());
			System.out.println("Confirmed: I went to ShareFile page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2ShareFile() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 11)
	public void verifyg2ShareConnect(){
		String baseProduct = "/shareconnect";
		
		try{
			welcomePg.g2ShareConn.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			System.out.println("The product I am currently testing is: " + driver.getTitle());
			System.out.println("Confirmed: I went to ShareConnect page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2ShareConnect() : " + ex.toString());
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	
	@Test (priority = 12)
	public void verifyg2AssistCorporate(){
		String baseProduct = "/gotoassistcorporate";
		
		try{
			Thread.sleep(3000);
			welcomePg.g2AssistDropDown.click();
			welcomePg.g2AssistCorp.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToAssist Corporate page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2AssistCorporate() : " + ex.toString());
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			driver.navigate().back();
		}
	}	

	@Test (priority = 13)
	public void verifyg2AssistRemote(){
		String baseProduct = "/gotoassistremotesupport";
		
		try{
			Thread.sleep(3000);
			welcomePg.g2AssistDropDown.click();
			welcomePg.g2AssistRem.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToAssist Remote Support page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2AssistRemote() : " + ex.toString());
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			driver.navigate().back();
			
		}
	}	
	
	@Test (priority = 14)
	public void verifyg2AssistService(){
		String baseProduct = "/gotoassistservicedesk";
		
		try{
			Thread.sleep(3000);
			welcomePg.g2AssistDropDown.click();			
			welcomePg.g2AssistServ.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to GoToAssist Service Desk page");			
		}
		catch(AssertionError ex){
			System.out.println("Something went wrong in the verifyg2AssistService() : " + ex.toString());
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			driver.navigate().back();
		}
	}	
	
	@Test (priority = 15) 
	public void verifyg2WsCloud(){
		String wsUrl = "https://www.citrix.com/products/workspace-cloud/support.html";
		try{
			Thread.sleep(3000);
			welcomePg.moreProductsDropDown.click();				
			welcomePg.g2WsCloud.click();
			Assert.assertEquals(driver.getCurrentUrl(), wsUrl);
			System.out.println("The product I am currently testing is: " + driver.getTitle());
			System.out.println("Confirmed: I went to Workspace Cloud Product page");			
		}
		catch(AssertionError ex)
		{
			System.out.println("Something went wrong in the verifyg2WsCloud()" + ex.toString());
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			driver.navigate().back();
		}

	}
	
	
	@Test (priority = 16) 
	public void verifyg2WsConcierge(){
		String baseProduct = "/concierge";
		try{
			Thread.sleep(3000);
			welcomePg.moreProductsDropDown.click();				
			welcomePg.g2Concierge.click();
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			String productName = welcomePg.productName.getText();
			System.out.println("The product I am currently testing is: " + productName);
			System.out.println("Confirmed: I went to Concierge Product page");			
		}
		catch(AssertionError ex)
		{
			System.out.println("Something went wrong in the verifyg2Concierge()" + ex.toString());
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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


