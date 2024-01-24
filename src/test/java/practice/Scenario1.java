package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("http://localhost:8888");
			
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.xpath("(//select[@class='small'])[2]")).click();
			driver.findElement(By.xpath("//option[contains(text(),'Mrs.')]")).click();
			driver.findElement(By.name("firstname")).sendKeys("Firstname");
			driver.findElement(By.name("lastname")).sendKeys("lastname");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			//Validate
			String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			System.out.println(contactHeader);
			
			if (contactHeader.contains("lastname")) 
			{
				System.out.println("Pass");
			}
			else 
			{
				System.out.println("Fail");

			}
				
			//Logout of Application
			
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			
			Thread.sleep(1000);
			driver.findElement(By.linkText("Sign Out")).click();
			
			//To close the browser
			
			driver.quit();
			
			
		
	
	
	
	
	
	}
	
	
	
}
