package excelExportAndFileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelFile_Object {
 
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

 
 @DataProvider(name="loginData")
 public Object[][] loginData() throws IOException{
 
 return ReadExcelFile_Object.readExcelData(System.getProperty("user.dir")+"//src//excelExportAndFileIO//dataExcel.xlsx","QA_Worksheet1");

 }
 
 @Test(dataProvider="loginData")
 public void getTestData_From_Excel(String usnm, HashMap data) {
	 	
	 Iterator entries = data.entrySet().iterator();
	 while (entries.hasNext()) {
		 HashMap.Entry entry = (HashMap.Entry) entries.next();
		    String key = (String)entry.getKey();
		    String value = (String)entry.getValue();
		    System.out.println("Key = " + key + ", Value = " + value);
		}
	
	 
	 
 }


}
