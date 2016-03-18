package excelExportAndFileIO; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ReadExcelFile {
    
    //Main function is calling readExcel function to read data from excel file
    public static void main(String...strings) throws IOException{

   //Create a object of ReadExcelFile class
    ReadExcelFile objExcelFile = new ReadExcelFile();

   //Prepare the path of excel file
    String filePath = System.getProperty("user.dir")+"//src//excelExportAndFileIO//";
    
   System.out.println ("The filePath value is : " + System.getProperty("user.dir")
   		+"\\src\\excelExportAndFileIO");
   //Call read file method of the class to read data

   objExcelFile.readExcel(filePath,"ExportExcel.xlsx","QA_Worksheet1");
   }
	
    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
     //Create a object of File class to open xlsx file
    //filePath = "//Users//byron//git//Automation//src//excelExportAndFileIO//";
    fileName = "ExportExcel.xlsx";	
    File file =   new File(filePath+fileName);
 
    //Create an object of FileInputStream class to read excel file
     FileInputStream inputStream = new FileInputStream(file);
     Workbook excelWorkbook = null;
     
     //Find the file extension by spliting file name in substring and getting only extension name
     String fileExtensionName = fileName.substring(fileName.indexOf("."));
     
     //Check condition if the file is xlsx file
     if(fileExtensionName.equals(".xlsx")){ //If it is xlsx file then create object of XSSFWorkbook class
    	 excelWorkbook = new XSSFWorkbook(inputStream);
     }
 
     //Check condition if the file is xls file 
    else if(fileExtensionName.equals(".xls")){//If it is xls file then create object of XSSFWorkbook class
         excelWorkbook = new HSSFWorkbook(inputStream);
     }
 
    //Read sheet inside the workbook by its name
     Sheet excelWorkSheet = excelWorkbook.getSheet(sheetName);
 
    //Find number of rows in excel file
     int rowCount = excelWorkSheet.getLastRowNum()-excelWorkSheet.getFirstRowNum();
 
    //Create a loop over all the rows of excel file to read it
     for (int i = 0; i < rowCount+1; i++) {
         Row row = excelWorkSheet.getRow(i);
 
         //Create a loop to print cell values in a row
         for (int j = 0; j < row.getLastCellNum(); j++) {
             //Print excel data in console
             System.out.print(row.getCell(j).getStringCellValue()+"|| ");
         }
         System.out.println();
     }      
    } 
     
 

 
}