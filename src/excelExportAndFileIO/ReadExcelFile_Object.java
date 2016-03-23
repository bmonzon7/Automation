package excelExportAndFileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.help.citrix.GTW_Join_Help_Page;

import page.factory.helper.BrowserFactory;
import test.com.help.citrix.com.*;

public class ReadExcelFile_Object {
	WebDriver driver;	
	GTW_Join_Help_Page gtwJoinHelp;	
	String baseEnv = "ed1";
	String baseProduct = "/webinar/join";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String browser="Firefox";
	
	//This is the dataprovider object returned by DataProvider
	//Returns the Object[String testcaseName][HashMap data]
 public static Object[][] readExcelData(String path, String sheetName) throws IOException{
	 Object[][] data = null;
	
	 //create the wrkbook object
	 XSSFWorkbook wrkbook = null;
	 //create the sheet object
	 XSSFSheet currentSheet = null;
	 //create the title row data
	 XSSFRow  titleRow = null;
		// Create the input stream for Excel file 
	   InputStream excelfile = null;
	   
	 try{

		 excelfile = new FileInputStream(path);
		
		 	//Create the XSSF workbook and sheet object/variables
		   wrkbook = new XSSFWorkbook(excelfile);
		   currentSheet = wrkbook.getSheet(sheetName);
		 
		
		   //Get the Last ROW and Column number  
		   int lastRow = currentSheet.getLastRowNum();
		   titleRow = currentSheet.getRow(0);
		   int lastCol = titleRow.getLastCellNum();
		
		   //Create an Object variable with size as Number of rows and 2 columns and HashMap for storing excel data
		   data = new Object[lastRow][2];
	
		   // Here we are storing the test case name in first index and row data as HashMap in second index   
			HashMap<String, String> rowdata = new HashMap<String, String>();
		
			//Iterate the through the rows and columns to fetch the data   
		   for(int row=1; row<=lastRow; row++){
		    XSSFRow currentRow = currentSheet.getRow(row);
		    Cell firstCell = currentRow.getCell(0);
		 
		    for(int col=0; col<lastCol-1; col++){
		     rowdata.put(titleRow.getCell(col+1).getStringCellValue(), currentRow.getCell(col+1).getStringCellValue());
		    }
		    data[row-1][0] = firstCell.getStringCellValue();
		    data[row-1][1] = rowdata.clone();
		    rowdata.clear();
		   }
 }
	 catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	 catch (IOException e) {
		e.printStackTrace();
		e.printStackTrace();
		}
	 wrkbook.close();
	 return data;
 }

@AfterTest
public void closeAll(){
	
	try {
		driver.close();
	} catch (Exception e) {
		System.out.println("Exception Data" + e.getMessage());
		e.printStackTrace();
	}
	
}

 		
@BeforeTest
	public void getFirstCategoryInfo(){		
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
		gtwJoinHelp = new GTW_Join_Help_Page(driver);
	}
	
 
 @DataProvider(name="loginData") /* This returns 2 objects[string testcase name][hashmap data]*/
 public Object[][] loginData() throws IOException{
 
 return ReadExcelFile_Object.readExcelData(System.getProperty("user.dir")+"//src//excelExportAndFileIO//dataExcel.xlsx","QA_Worksheet1");

 }
 
 /*
 @Test(dataProvider="loginData")
 public void getTestData_From_Excel(String usnm, HashMap<String, String> data) {
	
	 
	// Iterator<String> keySetIterator = data.keySet().iterator();
	 //while(keySetIterator.hasNext()){
		// String key = keySetIterator.next();
		 //System.out.print("Key: " + key + " Value: " + data.get(key));
		 //System.out.println("");
	 //}
	
	 
	 Iterator entries = data.entrySet().iterator();
	 while (entries.hasNext()) {
		 HashMap.Entry entry = (HashMap.Entry) entries.next();
		    String key = (String)entry.getKey();
		    String value = (String)entry.getValue();
		    System.out.println("Key = " + key + ", Value = " + value);
		}
	
	 
	 
 }
*/

 @Test(dataProvider="loginData") 
 public void testCategoryNames(String usnm, HashMap<String, String> data){
	 
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

		 
		 
		 
		
