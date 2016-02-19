package page.factory.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("firefox")){
			
			//To create the Profile for Firefox run this in the MAC terminal:
			///			Applications/Firefox.app/Contents/MacOS/firefox-bin -P
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffProfile = profile.getProfile("selenium");
			driver = new FirefoxDriver(ffProfile);
		}
		
		else if(browserName.equalsIgnoreCase("chrome")){
			//set the chromdriver property
			 System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver");			 
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Safari")){
			SafariOptions options = new SafariOptions();
			options.setUseCleanSession(true);

			 // For use with SafariDriver:
			System.setProperty("webdriver.safari.noinstall", "true"); 
			driver = new SafariDriver(options);
		}
		//driver.manage().window().maximize();		
		driver.get(url);
		return driver;
		
	}

}
