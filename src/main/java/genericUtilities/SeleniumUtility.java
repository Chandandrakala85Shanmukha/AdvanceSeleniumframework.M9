package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all reusable methods related to selenium
 * @author Kala
 *
 */
public class SeleniumUtility {
/**
 * This method will maximize the window
 * @param driver
 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will add 10seconds of implicitly wait
	 * @param driver
	 */
	
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 seconds for elements to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	
	public void handleDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hovering action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click action on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method perform the scroll down action
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;//x ,y co-ordinate  0(x co=ordinnate left),500 y co ordinate right
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	/**
	 * This method perform the scroll up action
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("Window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method perform the scroll Left action
	 * @param driver
	 */
	public void scrollLeftAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(500,0)", "");
	}
	
	/**
	 * This method performs the scroll Right action
	 * @param driver
	 */
	public void scrollRightAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500)", "");
	}
	
	/**
	 * This method will click OK in the alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will click cancel in the alert pop-up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the alert text and return it to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on Index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index	)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on nameOrId
	 * @param driver
	 * @param nameorId
	 */
	public void handleFrame(WebDriver driver, String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	/**
	 * This method will handle frame based on Frame element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 *This method will capture the screenshot and return the path to the caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(".\\Screenshots"+screenShotName+".png");
		Files.copy(src, des);
		
		return des.getAbsolutePath();//extend reports
	}




}



