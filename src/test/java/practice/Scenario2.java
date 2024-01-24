package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
	
	public static void main(String[] args) throws Throwable {
		
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("http://localhost:8888");
	
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	
	driver.findElement(By.partialLinkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys("keyboard");
	driver.findElement(By.name("button")).click();
	
	//validate
	
	String contactHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	System.out.println(contactHeader);
	
	if (contactHeader.contains("keyboard")) 
	{
		System.out.println("Pass");
		
	} else 
	{
		System.out.println("Fail");

	}
				
	//To LogOff the application
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	

	Thread.sleep(1000);
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();
	
	
	
	}

}
