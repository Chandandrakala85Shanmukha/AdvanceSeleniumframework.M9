package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario3 {
	
	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		 WebElement mouseover = driver.findElement(By.linkText("More"));
			
			Actions act = new Actions(driver);
			act.moveToElement(mouseover).perform();
			
			Thread.sleep(2000);
			driver.findElement(By.name("Campaigns")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
						
		driver.findElement(By.name("campaignname")).sendKeys("Marketing");
		driver.findElement(By.name("button")).click();
		
		
		//Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		
		if (contactHeader.contains("Marketing")) 
		{
			System.out.println("Pass");
			
		} else 
		{
			System.out.println("Fail");

		}
		
		//To LogOff the application
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act1 = new Actions(driver);
		act.moveToElement(ele).perform();
		

		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}

}
