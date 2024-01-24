package practice;

import java.util.jar.JarFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;

public class CalenderPopUps1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		//object creation
		
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
	
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox dates inactiveWidget ' ]")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Jan 03 2024']")).click();
		
		String nameText = driver.findElement(By.xpath("//p[@data-cy='departureDate']")).getText();
		System.out.println(nameText);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
	}

}	
