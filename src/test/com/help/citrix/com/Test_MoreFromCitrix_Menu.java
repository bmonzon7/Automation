	package test.com.help.citrix.com;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.help.citrix.MoreFromCitrixMenu;
import page.factory.helper.BrowserFactory;


	public class Test_MoreFromCitrix_Menu{
		WebDriver driver;
		String baseEnv = "";
		String baseProduct = "";
		String baseUrl = "http://help" + baseEnv +".citrix.com/support";		
		MoreFromCitrixMenu moreCitrixNav;
		
	
		@BeforeTest
		@Parameters("browser")
		public void setupMoreFromCitrixMenu(String browser) {			
			int waitfor = 5000;			
			try{
				driver = BrowserFactory.startBrowser(browser, "about:blank");			
				if(!browser.equalsIgnoreCase("Safari")){					
					driver.manage().deleteAllCookies();
				}
				Thread.sleep(waitfor);
				driver.get(baseUrl);
				moreCitrixNav = new MoreFromCitrixMenu(driver);
			}
			catch (Exception ex){}
		}
		
		@Test (priority = 0) //(enabled=false)
		public void g2Meeting(){
			baseProduct = "gotomeeting.com";			
			int waitfor = 2000;
			try {
				
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for G2M is: " + moreCitrixNav.g2Meeting.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2Meeting.getAttribute("href").contains(baseProduct));				
				moreCitrixNav.g2Meeting.click();
								
			} catch (InterruptedException ex) {				
				ex.printStackTrace();
			}
			finally{
				driver.navigate().back();
			}
		}
	
		@Test (priority = 1)
		public void g2WebinarNav(){
			baseProduct = "gotowebinar.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for G2W is: " + moreCitrixNav.g2Webinar.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2Webinar.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2Webinar.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 2)
		public void g2Training(){
			baseProduct = "gototraining.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for G2T is: " + moreCitrixNav.g2Training.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2Training.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2Training.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 3)
		public void g2ShareFile(){
			baseProduct = "sharefile.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for ShareFile is: " + moreCitrixNav.g2ShareFile.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2ShareFile.getAttribute("href").contains(baseProduct));				
				moreCitrixNav.g2ShareFile.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 4)
		public void g2ShareConnect(){
			baseProduct = "shareconnect.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for Connect is: " + moreCitrixNav.g2ShareConnect.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2ShareConnect.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2ShareConnect.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 5)
		public void g2MyPC(){
			baseProduct = "gotomypc.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for GoToMyPC is: " + moreCitrixNav.g2MyPC.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2MyPC.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2MyPC.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 6)
		public void g2RightSignature(){
			baseProduct = "rightsignature.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for RightSignature is: " + moreCitrixNav.g2RightSign.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2RightSign.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2RightSign.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 7)
		public void g2Assist(){
			baseProduct = "gotoassist.com";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for GoToAssist is: " + moreCitrixNav.g2Assist.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2Assist.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2Assist.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 8)
		public void g2Concierge(){
			baseProduct = "/concierge";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for Concierge is: " + moreCitrixNav.g2Concierge.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2Concierge.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2Concierge.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			finally{				
				driver.navigate().back();
			}
		}
		
		@Test (priority = 9)
		public void g2SeeIt(){
			baseProduct = "/seeit";			
			
			int waitfor = 2000;
			try {
				moreCitrixNav.navMoreCitrix.click();
				Thread.sleep(waitfor);
				System.out.println("The value of href for Concierge is: " + moreCitrixNav.g2SeeIt.getAttribute("href"));
				Assert.assertTrue(moreCitrixNav.g2SeeIt.getAttribute("href").contains(baseProduct));
				moreCitrixNav.g2SeeIt.click();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
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