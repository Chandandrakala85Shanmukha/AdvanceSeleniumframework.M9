package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;


/**
 * This class consists of all basic configuration annotation of TestNG
 * @author Kala
 *
 */
public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public PropertyFilesUtility pUtil = new PropertyFilesUtility();
	
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"SmokeSuite", "RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("==========DB connection Successfull===============");
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		
	//	if(BROWSER.equalsIgnoreCase("Chrome"))
	//	{
	//		driver = new ChromeDriver();
	//	}
	//	else if(BROWSER.equalsIgnoreCase("Edge"))
	//	{
			
	//		driver = new EdgeDriver();
	//	}
		
				sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		
		System.out.println("==========Browser Launch is Successfull===============");
		
		//For Listeners
		sDriver = driver;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
	   System.out.println("==========Login to App is Successfull===============");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("==========Logout of App is Successfull===============");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		
		driver.quit();
		
		System.out.println("==========Browser closed Successfully===============");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("==========DB close is Successfull===============");
	}

}
