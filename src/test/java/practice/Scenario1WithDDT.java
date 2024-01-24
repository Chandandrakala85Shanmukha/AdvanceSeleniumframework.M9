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

import objectRepository.LoginPage;

public class Scenario1WithDDT {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Read all the required data
		
		//Read all the common data from the property file
		
	 FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	 Properties p = new Properties();
	 p.load(fisp);
	 String URL = p.getProperty("url");
	 String USERNAME = p.getProperty("username");
	 String PASSWORD = p.getProperty("password");
	 
	 //Read the test data from the excel sheet
	 
	FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fise);
	 String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	
	 //Step 1: Launch the browser
	    WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//Step 2: Load the URL
		driver.get(URL);
		
	//Step 3: Login to application
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		
		
		
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
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
	// Step 10: To close the browser
		
		driver.quit();
		
	 
		
		
		
	}

}
