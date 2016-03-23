package page.factory.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataProviderExcel {
	/*
	WebDriver driver;	
	GTW_Join_Help_Page gtwJoinHelp;	
	String baseEnv = "ed1";
	String baseProduct = "/webinar/join";
	String baseUrl = "http://help" + baseEnv +".citrix.com";
	String browser="Firefox";
	*/
	
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
		   
		   //get the first row as the row/colum name (.i.e., TestCaseName)
		   titleRow = currentSheet.getRow(0);
		   
		   //get the number for columns
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

 /*
	//This is the piece to include in your tests to read the excel data into your tests
 
 @DataProvider(name="articleData") // This returns 2 objects[string test case name][hashmap data]
 public Object[][] loginData() throws IOException{
	 String excelFilePath = System.getProperty("user.dir")+"//src//excelExportAndFileIO//dataExcel.xlsx";
	 String sheetName = "QA_Worksheet1";
	 
 return DataProviderExcel.readExcelData(excelFilePath,sheetName);

 }
 */
  

}

		 
		 
		 
		
