package excelExportAndFileIO;

public class ExcelDataFields {

	private String testName;
    private String categoryName;
    private String articleName;
    private String articleURL;
    
     
    public ExcelDataFields(String testName, String categoryName, String articleName, String articleURL ){
        this.testName=testName;
        this.categoryName=categoryName;
        this.articleName = articleName;
        this.articleURL = articleURL;
        
    }
     
    public String getTestName() {
        return testName;
    }
   
    public String getCategoryName() {
        return categoryName;
    }
    
    public String getArticleName() {
        return articleName;
    }
    
    public String getArticleUrl() {
        return articleURL;
    }
    /*
    @Override
    public String toString(){
        return testName + "::" + categoryName + "::" + articleName + "::" + articleURL;
    }
    */
}
