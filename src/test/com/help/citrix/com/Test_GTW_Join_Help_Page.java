/*
package test.com.help.citrix.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import excelExportAndFileIO.ReadExcelFile;


import com.help.citrix.GTW_Join_Help_Page;

import page.factory.helper.BrowserFactory;



public class Test_GTW_Join_Help_Page {	
	WebDriver driver;	
	GTW_Join_Help_Page gtwJoinHelp;	
	String baseEnv = "ed1";
	String baseProduct = "/webinar/join";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String browser="Firefox";

	
	
	
	@BeforeTest
	public void getFirstCategoryInfo(){		
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
		gtwJoinHelp = new GTW_Join_Help_Page(driver);
	}
	

	@Test (priority = 0)
	public void verifyFirstCategory(){
		System.out.println("The inner text for the first category is: " + gtwJoinHelp.category1NameXPATH.getText());
			
		System.out.println("");
		System.out.println("The Category 1 Article Names are: ");
		System.out.println("-------------------------------------------------------");
		
		for (WebElement wE : gtwJoinHelp.category1ArticleList){
									
			//compare link name
			System.out.println(wE.getText());	
			
			//compare link address
			System.out.println("The Article URL is: " + wE.getAttribute("href"));
			
			System.out.println("");
		}
		System.out.println("");
		
	}
	
	@Test (priority = 1)
	public void goThroughTheArticles(){
		System.out.println("Inside the goThroughTheArticles()");
		for (int i = 0; i < gtwJoinHelp.category1ArticleList.size(); i++){
			System.out.println("The Category 1 Article " + i + " Names is: ");
			System.out.println(gtwJoinHelp.category1ArticleList.get(i).getText());	
			gtwJoinHelp.category1ArticleList.get(i).click();
			System.out.println("The Article URL is: " + driver.getCurrentUrl());
			driver.navigate().back();
			System.out.println("");
		}
		
		//gtwJoinHelp.category1ArticleList.get(1).click();
		//System.out.println("The Article URL is: " + driver.getCurrentUrl());
		//driver.navigate().back();
	}
	
	/*
	@Test (priority = 1)
	public void gotoCategory1Articles(){
		for (WebElement wE:gtwJoinHelp.category1ArticleList){			
			wE.click();
			System.out.println("The Article URL is: " + driver.getCurrentUrl());
			driver.navigate().back();
			
		}
	}
	
}

	*/
