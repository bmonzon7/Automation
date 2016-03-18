package excelExportAndFileIO; 

import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 
/*
 * 
 * Author: Byron R. Monzon
 * Description: This reads an excel file using the List type using ExcelDataFields as the objects inside the List
 * For creating the DataSource for TestNG and selenium I need an Object[]type
 * 
 * 
 */

public class ReadExcelFile_List {
	
	
	public static List<ExcelDataFields> readExcelData(String fileName) {
        List<ExcelDataFields> excelDataInputs = new ArrayList<ExcelDataFields>();
        
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);
             
            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
             
            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();
             
            //loop through each of the sheets
            for(int i=0; i < numberOfSheets; i++){
                 
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);
                 
                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                	String sTestName = "";
                	String sCategoryName = "";
                	String sArticleName ="";
                	String sArticleURL = "";
                     
                    //Get the row object
                    Row row = rowIterator.next();
                     
                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();
                      
                    while (cellIterator.hasNext()) 
                    {
                        //Get the Cell object
                        Cell cell = cellIterator.next();
                         
                        //check the cell type and process accordingly
                        switch(cell.getCellType()){
                        case Cell.CELL_TYPE_STRING:
                            if(sTestName.equalsIgnoreCase("")){
                            	sTestName = cell.getStringCellValue().trim();
                            }else if(sCategoryName.equalsIgnoreCase("")){
                                //2nd column
                            	sCategoryName = cell.getStringCellValue().trim();
                            	}
                            else if(sArticleName.equalsIgnoreCase("")){
                                //2nd column
                            	sArticleName = cell.getStringCellValue().trim();
                            	}
                            else if(sArticleURL.equalsIgnoreCase("")){
                                //2nd column
                            	sArticleURL = cell.getStringCellValue().trim();
                            	}
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println("Random data::"+cell.getNumericCellValue());
                        }
                    } //end of cell iterator
                    
                     
                    ExcelDataFields c = new ExcelDataFields(sTestName, sCategoryName, sArticleName, sArticleURL);
                    excelDataInputs.add(c);
                } //end of rows iterator
                 
                 
            } //end of sheets for loop
             
            //close file input stream
            fis.close();
             
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return excelDataInputs;
                
	}

 		
	@Test
	public void testDataProvider(){
		List<ExcelDataFields> list = readExcelData(System.getProperty("user.dir")+
        		"//src//excelExportAndFileIO//dataExcel.xlsx");
   
	for (int i = 1; i<list.size(); i++){
		System.out.println(list.get(i));
        System.out.println("sTestName = " + list.get(i).getTestName());
		System.out.println("sCategoryName = " + list.get(i).getCategoryName());
		System.out.println("sArticleName = " + list.get(i).getArticleName());
		System.out.println("sArticleUrl = " + list.get(i).getArticleUrl());
		}
	
	}  
}
	