package assignmentsPractice;

import java.sql.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;

public class CalenderPopupCurentDate {
	
	public static void main(String[] args) throws InterruptedException {
		
	/*	Date d = new Date(0);
		String dateNow = d.toString();
		System.out.println(dateNow);
		String[] dArr = d.toString().split("");
		String currentDate = dArr[0]+""+dArr[1]+""+dArr[2]+""+dArr[5];
		System.out.println(currentDate);  */
		
		
		//Launch the browser
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='tabsCircle appendRight5']")).click();
		
		//To Navigate to from and to Element
		
		WebElement src = driver.findElement(By.id("fromCity"));
		WebElement des = driver.findElement(By.id("toCity"));
		
		src.sendKeys("IAD");
		driver.findElement(By.xpath("//p[text()='Washington-Dulles Apt, United States']")).click();
		
		Thread.sleep(2000);
		
		des.sendKeys("Bengalore");
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		

		String nameText = driver.findElement(By.xpath("//p[@data-cy='departureDate']")).getText();
		System.out.println(nameText);
		
		driver.quit();
	
	}

}
