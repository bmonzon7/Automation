package test.com.help.citrix.com;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.help.citrix.MoreFromCitrixMenu;
import page.factory.helper.BrowserFactory;


	public class TestMoreFromCitrixMenu{
		WebDriver driver;
		String baseEnv = "";
		String baseProduct = "";
		String baseUrl = "http://help" + baseEnv +".citrix.com";
		
		String browserName = "firefox";
		WebDriverWait wait;
		MoreFromCitrixMenu moreCitrixNav;
		
	
		@BeforeTest
		public void setupMoreFromCitrixMenu(){
		driver = BrowserFactory.startBrowser(browserName, baseUrl);
		wait = new WebDriverWait(driver, 30);
		moreCitrixNav = new MoreFromCitrixMenu(driver);
		}
		
		@Test (enabled=false)
		public void g2MeetingNav(){
		moreCitrixNav.navMoreCitrix.click();
		moreCitrixNav.g2Meeting.click();
		driver.navigate().back();
		}
		
		@Test
		public void g2WebinarNav(){
			baseProduct = "gotowebinar.com";
			moreCitrixNav.navMoreCitrix.click();
			System.out.println("The value of href for G2W is: " + moreCitrixNav.g2Webinar.getAttribute("href"));
			Assert.assertTrue(moreCitrixNav.g2Webinar.getAttribute("href").contains(baseProduct));
			moreCitrixNav.g2Webinar.click();
		}
}