package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFilesUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTandGU {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Create object utility
		
       PropertyFilesUtility pUtil = new PropertyFilesUtility();
       ExcelFileUtility eUtil = new ExcelFileUtility();
       SeleniumUtility sUtil = new SeleniumUtility();
		
		
     //Read all the required data
		
     		//Read all the common data from the property file
     		
       String URL = pUtil.readDataFromPropertyFile("url");
       String USERNAME = pUtil.readDataFromPropertyFile("username");
       String PASSWORD = pUtil.readDataFromPropertyFile("password");


     	 
     	 //Read the test data from the excel sheet
     	 
     	
     	 String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
     	
     	 //Step 1: Launch the browser
     	    WebDriver driver = new ChromeDriver();	
     		sUtil.maximizeWindow(driver);
     		sUtil.addImplicitlyWait(driver);
     		
     	//Step 2: Load the URL
     		driver.get(URL);
     		
     	//Step 3: Login to application
     		
     		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
     	//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
     	//	driver.findElement(By.id("submitButton")).click();
     		
     		LoginPage lp = new LoginPage(driver);
     		lp.loginToApp(USERNAME, PASSWORD);
     		
     		
     		/*LoginPage lp = new LoginPage(driver);
     		 lp.getUsernameEdt().sendKeys(USERNAME);
     		 lp.getPasswordEdt().sendKeys(PASSWORD);
     		 lp.getLoginBtn().click(); */


     		
     	//Step 4: Click on the contacts link
     		
     		driver.findElement(By.linkText("Contacts")).click();
     		
     	//Step 5: Click on the create contact look up image
     		
     		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
     		
     	//Step 6: Enter mandatory field
     		
     		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
     		
     	//Step 7: Save
     		
     		driver.findElement(By.xpath("//input[@type='submit']")).click();
     		
     	//Step 8:Validate
     	//Create new contact with mandatory details	
     	//Contact is successfully created or not
     		
     		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
     		System.out.println(contactHeader);
     		
     		if (contactHeader.contains(LASTNAME)) 
     		{
     			System.out.println("Pass");
     		}
     		else 
     		{
     			System.out.println("Fail");

     		}
     		
     	//Step 9: Logout of application
     		
     		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     		
     		sUtil.mouseOverAction(driver, ele);
     		
     		Thread.sleep(1000);
     		driver.findElement(By.linkText("Sign Out")).click();
     		
     	// Step 10: To close the browser
     		
     		driver.quit();
     		
     	 
		
		
	}

}
