package com.help.citrix;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class UnityNav {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 15;
	
	public UnityNav(WebDriver driver){
		this.driver = driver;
	
		//page factory
		PageFactory.initElements( new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
		
	}

	//Define TopNav "More from Citrix"
	@FindBy(how=How.CSS, using = "div>.menu.show-for-medium-up")
		public WebElement navMoreCitrix;
	
	
	//define the product search component
	
	//define the article categories
	
	//define the community component
	
	//define the Live Training component
	
	//define the Contact Us component
	
	//Unity Nav -- Support For Other Products link
	@FindBy(how = How.CSS, using = "div [class='secondaryLinkSet link-group'] >ul>li:nth-of-type(1)>a")// "div [class='secondaryLinkSet link-group'] >ul>li[class='more expand']>a")
			WebElement suppOthProdsDropDd;

	//GoToWebinar
	@FindBy(how=How.CSS, using = "li>a.g2w")
	////CacheLookup
	public WebElement g2w;
		
	//GoToWebinar
	@FindBy(how=How.CSS, using = "li>a.g2t")
	//CacheLookup
		public WebElement g2t;
	
	//GoToMeeting
	@FindBy(how=How.CSS, using = "li>a.g2m" )
	//CacheLookup
		public WebElement g2m;
		
	//OpenOvice
	@FindBy(how=How.CSS, using = "li>a.ov")
	//CacheLookup
		public WebElement g2openVoice;
	
	//GoToAssist Remote Support
	@FindBy(how=How.CSS, using = "li:nth-of-type(2) >a.g2a")
	//CacheLookup
		public WebElement g2aRemote;
	
	//GoToAssist Service Desk
	@FindBy(how=How.CSS, using = "li:nth-of-type(5) >a.g2a")
		public WebElement g2aService;
	
	//GoToAssist Corporate
	@FindBy(how=How.CSS, using = "li:nth-of-type(7) >a.g2a")
		public WebElement g2aCorp;
		
	//Podio
	@FindBy(how=How.CSS, using = "li>a.podio")
	//CacheLookup
		public WebElement g2Podio;
	
	//ShareFile
	@FindBy(how=How.CSS, using = "li>a.sf")
	//CacheLookup
		public WebElement g2ShareFile;
		
	//ShareConnect
	@FindBy(how=How.CSS, using = "li>a.sc")
	//CacheLookup
		public WebElement g2ShareConnect;
	
	//GoToMyPC
	@FindBy(how=How.CSS, using = "li>a.g2p")
	//CacheLookup
		public WebElement g2MyPC;
	
	//Concierge
	@FindBy(how=How.CSS, using = "li>a.con")
	//CacheLookup
		public WebElement g2Concierge;
	
	//WorkSpace Cloud
	@FindBy(how=How.CSS, using = "li>a.wc")
	//CacheLookup
		public WebElement g2WsCloud;
	
	//Other Products
	@FindBy(how=How.CSS, using ="li>a.others")
	//CacheLookup
		public WebElement g2OtherProds;
	
	
	//Grasshopper
	@FindBy(how=How.CSS, using = "li>a.grasshopper")
	//CacheLookup
		public WebElement g2Grasshopper;
	
	
	
	//method to click on the Unity Nav -- Support For Other Products Menu
	public void clickSuppOthProds() throws InterruptedException{
		System.out.println("Inside the clickSuppOthProds()");
		//System.out.println("WebElement Text Attrib value: " + suppOthProdsDropDd.getText());
		
		suppOthProdsDropDd.click();
		
		int waitfor = 2000;
		Thread.sleep(waitfor);
		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		// driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public String getUrlg2w(){
		String url;
		url = g2w.getAttribute("href");
		return url;
	}
	
	public String getUrlg2m(){
		String url;
		url = g2m.getAttribute("href");
		return url;
	}
	
	public String getUrlg2t(){
		String url;
		url = g2t.getAttribute("href");
		return url;
	}
	
	public String getUrlOpenV(){
		String url;
		url = g2openVoice.getAttribute("href");
		return url;
	}
		
	public String getUrlg2aRemote(){
		String url;
		url = g2aRemote.getAttribute("href");
		return url;
	}
	
	public String getUrlg2aService(){
		String url;
		url = g2aService.getAttribute("href");
		return url;
	}
	
	public String getUrlg2Corp(){
		String url;
		url = g2aCorp.getAttribute("href");
		return url;
	}
	
	public String getUrlg2Podio(){
		String url;
		url = g2Podio.getAttribute("href");
		return url;
	}
	
	public String getUrlg2ShareFile(){
		String url;
		url = g2ShareFile.getAttribute("href");
		return url;
	}
	
	public String getUrlg2ShareConnect(){
		String url;
		url = g2ShareConnect.getAttribute("href");
		return url;
	}
	
	public String getUrlg2Concierge(){
		String url;
		url = g2Concierge.getAttribute("href");
		return url;
	}
	
	public String getUrlg2MyPC(){
		String url;
		url = g2MyPC.getAttribute("href");
		return url;
	}
	
	public String getUrlg2WsCloud(){
		String url;
		url = g2WsCloud.getAttribute("href");
		return url;
	}
	
	public String getUrlg2Others(){
		String url;
		url = g2OtherProds.getAttribute("href");
		return url;
	}
	
	public String getUrlg2Grasshopper(){
		String url;
		System.out.println("Inside the getUrlg2Grasshopper()");
		url = g2Grasshopper.getAttribute("href");
		return url;
	}
	
	public void clickProducts(WebElement webObject){
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webObject);
	}
		
	public void launchG2W(){
		System.out.println("Inside the launchGT2W()");
	/*
		Actions builder = new Actions(driver);
		builder.moveToElement(gtwUNav).click(gtwUNav);
		builder.perform();
	*/
		clickProducts(g2w);
		
	}
		
	public void launchG2T(){
		System.out.println("Inside the launchG2T()");
		clickProducts(g2t);
	}
	
	public void launchG2M(){
		System.out.println("Inside the launchG2M()");
		clickProducts(g2m);			
	}
		
	public void launchOpenV(){
		System.out.println("Inside the launchOpenV()");
		clickProducts(g2openVoice);
	}
	
	public void launchG2ARemote(){
		System.out.println("Inside the launchG2ARemote()");
		clickProducts(g2aRemote);
	}
	
	public void launchG2AService(){
		System.out.println("Inside launchG2AService()");
		clickProducts(g2aService);
		}
	
	public void launchG2ACorp(){
		System.out.println("Inside launchG2ACorp()");
		clickProducts(g2aCorp);
		}
	
	
	
	//START
	public void launchG2Podio(){
		System.out.println("Inside launchG2Podio()");
		clickProducts(g2Podio);
		}
	
	public void launchG2ShareFile(){
		System.out.println("Inside launchG2ShareFile()");
		clickProducts(g2ShareFile);
		}
	
	public void launchG2ShareConnect(){
		System.out.println("Inside launchG2ShareConnect()");
		clickProducts(g2ShareConnect);
		}
	
	public void launchG2MyPC(){
		System.out.println("Inside launchG2MyPC()");
		clickProducts(g2MyPC);
		}
	
	public void launchG2Concierge(){
		System.out.println("Inside launchG2Concierge()");
		clickProducts(g2Concierge);
		}
	
	public void launchG2WorkspaceCloud(){
		System.out.println("Inside launchG2WorkspaceCloud()");
		clickProducts(g2WsCloud);
		}
	
	public void launchG2Others(){
		System.out.println("Inside launchG2Others()");
		clickProducts(g2OtherProds);
		}
	
	public void launchG2Grasshopper(){
		System.out.println("Inside the launchG2Grasshopper()");
		clickProducts(g2Grasshopper);
	}
	
	public void expandMoreCitrixNav(){
		System.out.println("Inside the expandMoreCitrixNav()");
		clickProducts(navMoreCitrix);
	}
}	


