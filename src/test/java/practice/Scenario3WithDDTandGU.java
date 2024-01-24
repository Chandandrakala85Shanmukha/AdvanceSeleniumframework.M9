package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFilesUtility;
import genericUtilities.SeleniumUtility;

public class Scenario3WithDDTandGU {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//To create a object utility
		
		PropertyFilesUtility pUtil = new PropertyFilesUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
       //Read all the required data
		
 	   //Read all the common data from the property file
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read the test data from the excel sheet
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 10, 2);
		
//Step 1: Launch the browser
        
        WebDriver driver = new ChromeDriver();
        sUtil.maximizeWindow(driver);
        sUtil.addImplicitlyWait(driver);
        
//Step 2: Load the URL
        
 		driver.get(URL);
 		
//Step 3: Login to application
 		
 		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 		driver.findElement(By.id("submitButton")).click();
		
//Step 4: Click on the (mouse over)more link		
 		
 		 WebElement mouseover = driver.findElement(By.linkText("More"));
 		 sUtil.mouseOverAction(driver, mouseover);
 		Thread.sleep(2000);
		driver.findElement(By.name("Campaigns")).click();
		
//Step 5: Click on the create Products look up image		
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
//Step 6: Enter mandatory field
		
		driver.findElement(By.name("campaignname")).sendKeys(LASTNAME);
		
//Step 7: Save		
		driver.findElement(By.name("button")).click();
		
//Step 8:Validate
	     //Create new contact with mandatory details	
	     //Contact is successfully created or not
		
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		
		if (contactHeader.contains(LASTNAME)) 
		{
			System.out.println("Pass");
			
		} else 
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
