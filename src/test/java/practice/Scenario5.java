package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {
	
	public static void main(String[] args) throws Throwable {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		WebElement mouseover = driver.findElement(By.linkText("More"));
		
		Actions act = new Actions(driver);
		act.moveToElement(mouseover).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.name("Vendors")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("vendorname")).sendKeys("Pokeman");
		driver.findElement(By.name("button")).click();
		
		//To validate
		
		String cH = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(cH);
		
		if (cH.contains("Pokeman")) 
		{
			System.out.println("Pass");
			
		} else 
		{
			System.out.println("Fail");

		}
		
		//To logout from the application
		
		WebElement mO = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(mO).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
		
	}

}
