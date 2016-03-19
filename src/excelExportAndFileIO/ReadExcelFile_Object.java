package excelExportAndFileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.help.citrix.GTW_Join_Help_Page;

import page.factory.helper.BrowserFactory;
import test.com.help.citrix.com.*;

public class ReadExcelFile_Object {
	WebDriver driver;	
	GTW_Join_Help_Page gtwJoinHelp;	
	String baseEnv = "stage";
	String baseProduct = "/webinar/join";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String browser="Firefox";
	
 public static Object[][] readExcelData(String path, String sheetName) throws IOException{
	 Object[][] data = null;
	 try{

		// Create the input stream for Excel file 
		   InputStream excelfile = new FileInputStream(path);
		
		// Create the XSSF workbook and sheet object/variables
		   XSSFWorkbook wrkbook = new XSSFWorkbook(excelfile);
		   XSSFSheet currentSheet = wrkbook.getSheet(sheetName);
		 
		
		// Get the Last ROW and Column number  
		   int lastRow = currentSheet.getLastRowNum();
		   XSSFRow  titleRow = currentSheet.getRow(0);
		   int lastCol = titleRow.getLastCellNum();
		// Create an Object variable with size as Number of rows and 2 columns and HashMap for storing excel data
		
		// Here we are storing the test case name in first index and row data as HashMap in second index   
		   data = new Object[lastRow][2];
		   HashMap<String, String> rowdata = new HashMap<String, String>();
		
		// Iterate the through the rows and columns to fetch the data   
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
	 return data;
 }

 
 		
@BeforeTest
	public void getFirstCategoryInfo(){		
		driver = BrowserFactory.startBrowser(browser, (baseUrl+baseProduct));
		if(!browser.equalsIgnoreCase("Safari")){			
			driver.manage().deleteAllCookies();
		}
		gtwJoinHelp = new GTW_Join_Help_Page(driver);
	}
	
 
 @DataProvider(name="loginData")
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
	 
	 
	 int i = 0;
	 
	 if (usnm.contains("Join Page Trying to Join")){
		 i = 0;		
	 }
	 
	 
	 for (Map.Entry<String, String> entry : data.entrySet()){
		 String key = entry.getKey();
		 String value = entry.getValue();
	
		  if (key.equalsIgnoreCase("CategoryName") || key.equalsIgnoreCase("ArticleName") || key.equalsIgnoreCase("ArticleURL")){
		    	//System.out.println("The css object category text is: " + gtwJoinHelp.category1Name.getText());
		    	if (key.equalsIgnoreCase("CategoryName")){
		    		System.out.println("The categories match " + value.equalsIgnoreCase(gtwJoinHelp.categoryList.get(i).getText()));	
		    	}
		    	else if (!key.equalsIgnoreCase("CategoryName"))
		    	{
		    		System.out.println("This is not a Category Value:");
		    	}
		    	
		    	if (key.equalsIgnoreCase("ArticleName")){
		    		for (WebElement wE : gtwJoinHelp.category1ArticleList){
		    			String articleName = wE.getText();
		    			if (articleName.equalsIgnoreCase(value.toString())){
		    				System.out.println("Article matched " + articleName);
		    			}		    			
		    		}
		    	}
		    		
	    		if (key.equalsIgnoreCase("ArticleURL")){
		    		for (WebElement wE : gtwJoinHelp.category1ArticleList){
		    			String articleURL = wE.getAttribute("href");
		    			if (articleURL.contains(value.trim())){
		    				System.out.println("Article URL matched " + articleURL);
		    			}	
		    			else{
		    				System.out.println("Article URL did not match");
		    			}
		    	}
	    	}
		    	}
		  }
	 }
 }

	    	
		    	/*
		    	if (key.equalsIgnoreCase("ArticleURL")){		    	 
		    	 String tmpArticleURL = gtwJoinHelp.category1ArticleList.get(i).getAttribute("href").toString();
		    	 String expectedArticleURL = value.toString();
		    	  boolean stringMatches = StringUtils.containsAny(expectedArticleURL, tmpArticleURL);
		    	 
		    	 if (!stringMatches){
		    		 System.out.println("Did not match");
		    	 }
		    	 else{
		    		 System.out.println("MATCH __ The Article URLs matches: ");
		    	 }	 
		    	}
		    	*/
		 

