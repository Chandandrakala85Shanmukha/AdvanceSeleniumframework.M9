package assignmentsPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPopUpAnyDate {
	
	public static void main(String[] args) throws InterruptedException {
		
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
		
		driver.findElement(By.xpath("(//div[@class='DayPicker-Day'])[24]")).click();
		String anyDate = driver.findElement(By.xpath("//p[@data-cy='departureDate']")).getText();
		System.out.println(anyDate);
		
		driver.quit();
		
	}

}
