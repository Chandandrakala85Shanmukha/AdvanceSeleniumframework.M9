package assignmentsPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VTigerScenario3 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
				
		WebElement table = driver.findElement(By.xpath("//table[@class='lvt small']"));
		table.findElements(By.xpath("(//td[@class='lvtCol'])[4]"));
		
	/*	 List<String> tableHeadingTexts = new ArrayList<String>();
		
		for(WebElement heading : tableHeadings)
		{
			String tableHeadingText = heading.getText();
			
			tableHeadingTexts.add(tableHeadingText);
		}  
		
		String columnName = "Last Name";
		int columnIndex = tableHeadingTexts.indexOf(columnName); */
		
		
		List<WebElement> columnDatas = table.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a"));
		
		for(WebElement columnData : columnDatas)
		{
			System.out.println(columnData.getText());
		}
		
		
		driver.quit();
		
		
	}

}
