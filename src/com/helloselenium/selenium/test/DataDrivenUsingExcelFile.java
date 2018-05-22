package com.helloselenium.selenium.test;
 
import java.io.*;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class DataDrivenUsingExcelFile{
 
 public static void main(String[] args) { 
	 
	//Creating a driver object referencing WebDriver interface
			WebDriver driver;
			
			//Setting webdriver.gecko.driver property
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver.exe");
			
			//Instantiating driver object and launching browser
			driver = new ChromeDriver();
 
        
 
        driver.get("http://www.google.com");
 
        driver.manage().window().maximize();  
       
        WebElement searchbox = driver.findElement(By.name("q"));
 
 try {
    
  FileInputStream file = new FileInputStream(new File("D:\\excelimport.xls")); 
  HSSFWorkbook workbook = new HSSFWorkbook(file);
 
  HSSFSheet sheet = workbook.getSheetAt(0);
 
for (int i=1; i <= sheet.getLastRowNum(); i++){
 
        String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
 
        searchbox.sendKeys(keyword);
 
        searchbox.submit();       
  
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
 
}
 
  workbook.close();
  file.close();
 
 } catch (FileNotFoundException fnfe) {
  fnfe.printStackTrace();
 } catch (IOException ioe) {
  ioe.printStackTrace();
 }
 }
}