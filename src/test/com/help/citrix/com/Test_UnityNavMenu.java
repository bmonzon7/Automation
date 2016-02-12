package test.com.help.citrix.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.help.citrix.UnityNav;

import page.factory.helper.BrowserFactory;

public class Test_UnityNavMenu{
	WebDriver driver;
	String baseEnv = "";
	String baseProduct = "";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	
	String browserName = "firefox";
	WebDriverWait wait;
	UnityNav unityNavMenu;
	
	
	
	@BeforeTest
	public void setupSupportWelcomePage(){
		driver = BrowserFactory.startBrowser(browserName, baseUrl);
		wait = new WebDriverWait(driver, 30);
		unityNavMenu = new UnityNav(driver);
		
	}
	
	@Test (priority = 0)
	public void verifySupportOtherProdsNav(){
		try{
			
			baseProduct = "/meeting";
			driver.get(baseUrl+baseProduct);
			
			//open the menu
			unityNavMenu.clickSuppOthProds();
		
			//Assert the links are correct
			//Assert.assertTrue(message, condition);
			System.out.println("START Assertions for verifySupportOtherProdsNav()");
				Assert.assertTrue(unityNavMenu.getUrlg2m().contains("/meeting"));			
				Assert.assertTrue(unityNavMenu.getUrlg2w().contains("/webinar"));			
				Assert.assertTrue(unityNavMenu.getUrlg2t().contains("/training"));			
				Assert.assertTrue(unityNavMenu.getUrlOpenV().contains("/openvoice"));
				Assert.assertTrue(unityNavMenu.getUrlg2aRemote().contains("/gotoassistremote"));					
			System.out.println("END Assertions for verifySupportOtherProdsNav()");
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifySupportOtherProdsNav()" + ex.toString());
		}
		finally{
			//close the menu
			
		}
	}		
		
	@Test 
	public void verifyUnityNavGTM(){
		baseProduct = "/meeting";
		
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchG2M();
			System.out.println("G2M Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2M Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl + baseProduct));
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavGTM()" + ex.toString());
		}
		finally{
			//unityNavMenu.clickSuppOthProds();
		}
	}
	
	@Test
	public void verifyUnityNavGTW(){
		baseProduct = "/webinar";
		
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchG2W();
			System.out.println("G2W Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2W Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl + baseProduct));
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavGTW())" + ex.toString());
		}
		finally{
			//unityNavMenu.clickSuppOthProds();
		}
	}

	@Test
	public void verifyUnityNavGTT(){
		baseProduct = "/training";
		
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchG2T();
			System.out.println("G2T Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2T Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl + baseProduct));
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavGTT()" + ex.toString());
		}
		finally{
			//unityNavMenu.clickSuppOthProds();
		}
	}

	public void verifyUnityNavOpenVoice(){
		baseProduct = "/openvoice";
		
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchOpenV();
			System.out.println("OpenVoice Url expected is: " + baseUrl + baseProduct);
			System.out.println("OpenVoice Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl + baseProduct));
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavOpenVoice()" + ex.toString());
		}
		finally{
			//unityNavMenu.clickSuppOthProds();
		}
	}

	@Test
	public void verifyUnityNavG2ARemote(){
		baseProduct = "/gotoassistremotesupport";
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchG2ARemote();
			System.out.println("G2A Remote Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2A Remote Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		}
		catch(Exception ex){}
		finally{}
	}
	
	@Test
	public void verifyUnityNavG2AService(){
		baseProduct = "/gotoassistservicedesk";
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchG2AService();
			System.out.println("G2A Service Desk Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2A Service Desk Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		}
		catch(Exception ex){}
		finally{}
		
	}
	
	@Test
	public void verifyUnityNavG2ACorp(){
		baseProduct = "/gotoassistcorporate";
		try{
			unityNavMenu.clickSuppOthProds();
			unityNavMenu.launchG2ACorp();
			System.out.println("G2A Corporate Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2A Corporate Url actual is: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		}
		catch(Exception ex){}
		finally{}
		
	}
	
	
	
}
	
	

