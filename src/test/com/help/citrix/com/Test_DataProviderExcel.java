package test.com.help.citrix.com;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.help.citrix.*;
import page.factory.helper.*;

public class Test_DataProviderExcel {
	WebDriver driver;	
	GTW_Join_Help_Page gtwJoinHelp;	
	String baseEnv = "ed1";
	String baseProduct = "/webinar/join";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String browser="Firefox";
	
	@DataProvider(name="articleData") /* This returns 2 objects[string testcase name][hashmap data]*/
	 public Object[][] loginData() throws IOException{
	 
		String excelFilePath = System.getProperty("user.dir")+
				"//src//excelExportAndFileIO//dataExcel.xlsx";
		
		 String sheetName = "QA_Worksheet1";
		 
	 return DataProviderExcel.readExcelData(excelFilePath, sheetName);

	 }
	
	@BeforeTest
	public void prepareForTests(){		
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
		gtwJoinHelp = new GTW_Join_Help_Page(driver);
	}
	
	@Test(dataProvider="articleData") 
	 public void testArticles(String usnm, HashMap<String, String> data){
		 
		 List<WebElement> catCotainer = null;
		 String testCaseName = usnm;
		 boolean bFound = false;
		 
		 System.out.println("Test Case Name: " + testCaseName);
		 for (Map.Entry<String, String> entry : data.entrySet()){
			 String key = entry.getKey();
			 String value = entry.getValue();
		
			 switch(key.trim()){
			 case "CategoryName":
				 bFound = false;
				 
				 while (!bFound){
					 for (int j = 0; j < gtwJoinHelp.categoryContainer.size(); j++){
						String categoryName = gtwJoinHelp.categoryContainer.get(j).getText();
						
						
						
		    			if ((categoryName.equalsIgnoreCase("Trying To Join")) && (value.trim().equals(categoryName))){
		    				System.out.println("Category Name from Excel: " + value.trim());
		    				System.out.println("Category Name Expected:   " + categoryName);
		    				catCotainer = gtwJoinHelp.joinCategoryContainer;
		    				bFound = true;
		    				break;
		    			}
		    				
		    			else if ((categoryName.equalsIgnoreCase("Videos")) && (value.trim().equals(categoryName))){
		    				System.out.println("Category Name from Excel: " + value.trim());
		    				System.out.println("Category Name Expected:   " + categoryName);
		    				catCotainer = gtwJoinHelp.videoCategoryContainer;
		    				bFound = true;
		    				break;
		    			}	    				
		    			else if ((categoryName.equalsIgnoreCase("During Your Webinar")) && (value.trim().equals(categoryName))){
		    				System.out.println("Category Name from Excel: " + value.trim());
		    				System.out.println("Category Name Expected:   " + categoryName);
		    				catCotainer = gtwJoinHelp.duringWebinarCategoryContainer;
		    				bFound = true;
		    				break;
		    			}
		    			else if ((categoryName.equalsIgnoreCase("More Help")) && (value.trim().equals(categoryName))){
		    				System.out.println("Category Name from Excel: " + value.trim());
		    				System.out.println("Category Name Expected:   " + categoryName);
		    				catCotainer = gtwJoinHelp.moreHelpCategoryContainer;
		    				bFound = true;
		    				break;
		    			} 
		    					  			
		    			else if (bFound == true && j == (gtwJoinHelp.categoryContainer.size()-1)){
		    				System.out.println("Category Name did not match expected article:  " + value.trim());
		    				System.out.println("");
		    				Assert.fail("Article Category Mismatch - Category Expected is not found on web page");
		    				break;
		    			}
					 }
					 break;
				 }   	
			break;	
			 case "ArticleName":
				 bFound = false;
				 
				 while (!bFound){
					for(int j = 0; j < catCotainer.size(); j++){
						String articleName = catCotainer.get(j).getText();
						if (articleName.equalsIgnoreCase(value.trim())){		    				
		    				bFound = true;	
		    				System.out.println("Article Name Matched: ");
		    				System.out.println("Article Name from Excel:  " + value.trim());
		    				System.out.println("Article Name Expected:    " + articleName);
		    				
		    				break;
		    				}    			
		    			 if(bFound == false &&  j == (catCotainer.size()-1)){
		    				System.out.println("Article Name Did Not Match: ");
		    				System.out.println("");
		    				Assert.fail("Article Name Mismatch - Expected Article Name is not found on web page");
		    				break;
		    			 	}
		    			
					}
					break;
				 }	
				break; 
			 case "ArticleURL":
				 bFound = false;						 
				 while (!bFound){
					for(int j = 0; j < catCotainer.size(); j++){
						String articleURL = catCotainer.get(j).getAttribute("href");
						if (articleURL.contains(value.trim())){		    				
		    				bFound = true;	
		    				System.out.println("Article URL Matched: ");
		    				System.out.println("Article URL from Excel:  " + value.trim());
		    				System.out.println("Article URL Expected:    " + articleURL);
		    				break;
		    				}    			
		    			 if(bFound == false &&  j == (catCotainer.size()-1)){
		    				System.out.println("Article URL Did Not Match: ");
		    				System.out.println("");
		    				Assert.fail("Article URL Mismatch - Expected Article URL is not found on web page");
		    				break;
		    			 	}
		    			 }
				 break;
			 }
			break;		 
		 }
		 
		}
		 System.out.println("");
	 }
	}
	
	
	
