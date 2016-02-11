package page.factory.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			//set the chromdriver property
			 System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver");			 
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();		
		driver.get(url);
		return driver;
		
	}

}
