package com.helloselenium.selenium.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	
public WebDriver driver;

@BeforeSuite
public void launchApp(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver.exe");
	
	driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://opensource.demo.orangehrmlive.com/");

WebElement UserName = driver.findElement(By.id("txtUsername"));
UserName.sendKeys("Admin");

//Finding textbox using name locator and then using send keys to write in it
WebElement Password = driver.findElement(By.id("txtPassword"));
Password.sendKeys("admin");

//Finding textbox using name locator and then using send keys to write in it
		WebElement LoginButton = driver.findElement(By.id("btnLogin"));
		LoginButton.click();
		
		
	//verifying whether user is loged in sucessfully by capturing the text present upon login
		if(driver.getPageSource().contains("Welcome John"))
			  {
			    System.out.println("User Login Sucessfull");
			  }
			else
			  {
			    System.out.println("User Login Failed");
			  }
}

/*@BeforeMethod
public void loginadmin(){
	WebElement UserName = driver.findElement(By.id("txtUsername"));
	UserName.sendKeys("Admin");
	
	//Finding textbox using name locator and then using send keys to write in it
	WebElement Password = driver.findElement(By.id("txtPassword"));
	Password.sendKeys("admin");
	
	//Finding textbox using name locator and then using send keys to write in it
			WebElement LoginButton = driver.findElement(By.id("btnLogin"));
			LoginButton.click();
			
			
		//verifying whether user is loged in sucessfully by capturing the text present upon login
			if(driver.getPageSource().contains("Welcome John"))
				  {
				    System.out.println("User Login Sucessfull");
				  }
				else
				  {
				    System.out.println("User Login Failed");
				  }*/
	

@Test(dataProvider = "dp")
public void branchcreation(String branchname,String Address1,String Address2, String Address3, 
		String Area, String ZipCode, String country, String state, String city) throws InterruptedException{
	
	WebElement LoginButton = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
	LoginButton.click();
	
	WebElement LoginButton2 = driver.findElement(By.id("menu_recruitment_viewJobVacancy"));
	LoginButton.click();
	
	WebElement Password = driver.findElement(By.id("txtPassword"));
	Password.sendKeys("admin");
	
	WebElement Password2 = driver.findElement(By.id("txtPassword"));
	Password.sendKeys("btnAdd");
	
	WebElement Password3 = driver.findElement(By.id("txtPassword"));
	Password.sendKeys(branchname);
	
	
	
	
	
	
	
	

	
			
}
@DataProvider
public String[][] dp() throws InvalidFormatException, IOException {
	InputStream f = new FileInputStream("D:\\excelimport.xls");
	Workbook wb = WorkbookFactory.create(f);
	Sheet sheet = wb.getSheet("branch");

	int rCount = sheet.getLastRowNum() + 1;
	int cCount = sheet.getRow(0).getLastCellNum();

	String data[][] = new String[rCount][cCount];

	for (int i = 0; i < rCount; i++) {

		for (int j = 0; j < cCount; j++) {

			data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
		}}
return data;

}
}