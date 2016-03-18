package test.com.help.citrix.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import excelExportAndFileIO.*;


public class Test_Excel_DataProvider {
		private String sTestCaseName;
		private int iTestCaseRow;
		WebDriver driver;

	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://helpstage.citrix.com/webinar/join");	 
	  }	

	  @Test(dataProvider = "dataExcelProvider")
	  public void readExcelData(String userName, String paswword) {
		    
			System.out.println("Category Name = " + userName);
			System.out.println("Article Name = " + paswword);
		
	  }

	  @AfterMethod
	  public void afterMethod() {
		   driver.close();
	  }

	  @DataProvider
	  public Object[][] dataExcelProvider() throws Exception{
	    // Setting up the Test Data Excel file
		String filePath = System.getProperty("user.dir")+"//src//excelExportAndFileIO//dataExcel2.xls";
	 	ExcelUtils.setExcelFile(filePath, "Sheet1");
	 	
	 	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
	    // Fetching the Test Case row number from the Test Data Sheet
	    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 	
	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

	 	Object[][] testObjArray = ExcelUtils.getTableArray(filePath,"Sheet1",iTestCaseRow);
    	return (testObjArray);

			}

	}