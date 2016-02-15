package test.com.help.citrix.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.help.citrix.UnityNav;

import page.factory.helper.BrowserFactory;
import com.help.*;

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
				System.out.println("GoToMeeting url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2w().contains("/webinar"));
				System.out.println("GoToWebinar url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2t().contains("/training"));
				System.out.println("GoToTraining url is correct");

				Assert.assertTrue(unityNavMenu.getUrlOpenV().contains("/openvoice"));
				System.out.println("GoToOpenVoice url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2aRemote().contains("/gotoassistremote"));
				System.out.println("GoToAssist-Remote url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2aService().contains("/gotoassistservicedesk"));
				System.out.println("GoToAssist-Remote url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2Corp().contains("/gotoassistcorporate"));
				System.out.println("GoToAssist-Remote url is correct");
				
				Assert.assertTrue(unityNavMenu.getUrlg2Podio().contains("/podio"));
				System.out.println("GoToPodio url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2ShareFile().contains("/sharefile"));
				System.out.println("GoToShareFile url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2ShareConnect().contains("/shareconnect"));
				System.out.println("GoToShareConnect url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2MyPC().contains("/gotomypc"));
				System.out.println("GoToMyPC url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2Concierge().contains("/concierge"));
				System.out.println("GoToConcierge url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2WsCloud().contains("/workspace-cloud"));
				System.out.println("GoToWorkspaceCloud url is correct");

				Assert.assertTrue(unityNavMenu.getUrlg2Others().contains("/products"));
				System.out.println("Other Products url is correct");

				System.out.println("END Assertions for verifySupportOtherProdsNav()");
				
				//close menu
				unityNavMenu.clickSuppOthProds();
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
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2m));
			unityNavMenu.launchG2M();
			System.out.println("G2M Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2M Url actual is  : " + driver.getCurrentUrl());
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
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2w));
			unityNavMenu.launchG2W();
			System.out.println("G2W Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2W Url actual is  : " + driver.getCurrentUrl());
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
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2t));
			unityNavMenu.launchG2T();
			System.out.println("G2T Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2T Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl + baseProduct));
			
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavGTT()" + ex.toString());
		}
		finally{
			//unityNavMenu.clickSuppOthProds();
		}
	}
	
	@Test
	public void verifyUnityNavOpenVoice(){
		baseProduct = "/openvoice";
		
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2openVoice));
			unityNavMenu.launchOpenV();
			System.out.println("OpenVoice Url expected is: " + baseUrl + baseProduct);
			System.out.println("OpenVoice Url actual is  : " + driver.getCurrentUrl());
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
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2aRemote));
			unityNavMenu.launchG2ARemote();
			System.out.println("G2A Remote Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2A Remote Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavG2ARemote()" + ex.toString());

		}
		finally{}
	}
	
	@Test
	public void verifyUnityNavG2AService(){
		baseProduct = "/gotoassistservicedesk";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2aService));
			unityNavMenu.launchG2AService();
			System.out.println("G2A Service Desk Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2A Service Desk Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavG2AService()" + ex.toString());

		}
		finally{}
		
	}
	
	@Test
	public void verifyUnityNavG2ACorp(){
		baseProduct = "/gotoassistcorporate";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2aCorp));
			unityNavMenu.launchG2ACorp();
			System.out.println("G2A Corporate Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2A Corporate Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavG2ACorp()" + ex.toString());

		}
		finally{}
		
	}
	
	@Test
	public void verifyUnityNavG2Podio(){
		baseProduct = "/redirect/podio";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2Podio));
			unityNavMenu.launchG2Podio();
			System.out.println("G2 Podio Url expected is: " + "https://help.podio.com/hc/en-us");
			System.out.println("G2 Podio Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), ("https://help.podio.com/hc/en-us"));
			System.out.println("Confirmed: I am in the Podio page");
			driver.navigate().back();
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavG2Podio()" + ex.toString());

			
		}
		finally{
			
		}
		
	}
	
	@Test
	public void verifyUnityNavG2ShareFile(){
		baseProduct = "/sharefile";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2ShareFile));
			unityNavMenu.launchG2ShareFile();;
			System.out.println("G2 ShareFile Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2 ShareFile Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			System.out.println("Confirmed: I am in the ShareFile page");
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the verifyUnityNavG2ShareFile()" + ex.toString());

			
		}
		finally{
			
		}
	}

	@Test
	public void verifyUnityNavG2ShareConnect(){
			baseProduct = "/shareconnect";
			try{
				unityNavMenu.clickSuppOthProds();
				//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2ShareConnect));
				unityNavMenu.launchG2ShareConnect();
				System.out.println("G2 ShareConnect Url expected is: " + baseUrl + baseProduct);
				System.out.println("G2 ShareConnect Url actual is  : " + driver.getCurrentUrl());
				Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
				System.out.println("Confirmed: I am in the ShareConnect page");
			}
			catch(Exception ex){
				System.out.println("Something went wrong in the verifyUnityNavG2ShareConnect()" + ex.toString());

				
			}
			finally{
				
			}
			
		}
		
	@Test
	public void verifyUnityNavG2MyPC(){
				baseProduct = "/gotomypc";
				try{
					unityNavMenu.clickSuppOthProds();
					//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2MyPC));
					unityNavMenu.launchG2MyPC();
					System.out.println("G2 MyPC Url expected is: " + baseUrl + baseProduct);
					System.out.println("G2 MyPC Url actual is  : " + driver.getCurrentUrl());
					Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
					System.out.println("Confirmed: I am in the GoToMyPC page");
				}
				catch(Exception ex){
					System.out.println("Something went wrong in the verifySupportOtherProdsNav()" + ex.toString());

					
				}
				finally{
					
				}
	}
			
	@Test
	public void verifyUnityNavG2Concierge(){
		baseProduct = "/concierge";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2Concierge));
			unityNavMenu.launchG2Concierge();
			System.out.println("G2 Concierge Url expected is: " + baseUrl + baseProduct);
			System.out.println("G2 Concierge Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), (baseUrl+baseProduct));
			System.out.println("Confirmed: I am in the Concierge page");
			}
			catch(Exception ex){
				System.out.println("Something went wrong in the verifySupportOtherProdsNav()" + ex.toString());
			}
			finally{
				
			}
	}
			
			
	@Test
	public void verifyUnityNavG2WorkspaceCloud(){
		//baseProduct = "/redirect/workspace-cloud";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2WsCloud));
			unityNavMenu.launchG2WorkspaceCloud();
			System.out.println("G2 Workspace Cloud Url expected is: " + "https://www.citrix.com/products/workspace-cloud/support.html");
			System.out.println("G2 Workspace Cloud Url actual is  : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.citrix.com/products/workspace-cloud/support.html");
			System.out.println("Confirmed: I am in the WorkspaceCloud page");
			driver.navigate().back();
			}
			catch(Exception ex){
				System.out.println("Something went wrong in the verifyUnityNavG2WorkspaceCloud()" + ex.toString());
				
			}
			finally{
				
			}
	}	
		
	@Test
	public void verifyUnityNavG2OtherProducts(){
		//baseProduct = "/products.html";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2OtherProds));
			unityNavMenu.launchG2Others();
			System.out.println("G2 Other Product Url expected is: " +  "https://www.citrix.com/products.html");
			System.out.println("G2 Other Products actual Url is : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), ("https://www.citrix.com/products.html"));
			System.out.println("Confirmed: I am in the other products page");
			driver.navigate().back();
			}
			catch(Exception ex){
				System.out.println("Something went wrong in the verifyUnityNavG2OtherProducts()" + ex.toString());
				
				
			}
			finally{
				
			}
	}
	
	@Test
	public void verifyUnityNavG2Grasshoppper(){
		//baseProduct = "/grasshopper";
		try{
			unityNavMenu.clickSuppOthProds();
			//wait.until(ExpectedConditions.visibilityOf(unityNavMenu.g2OtherProds));
			unityNavMenu.launchG2Grasshopper();
			System.out.println("G2 Grasshopper Url expected is: " +  "https://support.grasshopper.com/home");
			System.out.println("G2 Grasshipper actual Url is : " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), ("https://support.grasshopper.com/home"));
			System.out.println("Confirmed: I am in the Grasshopper page");
			driver.navigate().back();
			}
			catch(Exception ex){
				System.out.println("Something went wrong in the verifyUnityNavG2Grasshoppper()" + ex.toString());
				
				
			}
			finally{
				
			}
	}
			
}
	
	
