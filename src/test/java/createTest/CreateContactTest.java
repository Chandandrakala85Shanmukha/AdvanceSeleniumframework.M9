package createTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFilesUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest {
	
	@Test
	public void ContactTest() throws IOException, InterruptedException {
	
	//Create object utility
	       PropertyFilesUtility pUtil = new PropertyFilesUtility();
	       ExcelFileUtility eUtil = new ExcelFileUtility();
	       SeleniumUtility sUtil = new SeleniumUtility();
	
	 //Read all the required data
	 //Read all the common data from the property file
	     		
	       String URL = pUtil.readDataFromPropertyFile("url");
	       String USERNAME = pUtil.readDataFromPropertyFile("username");
	       String PASSWORD = pUtil.readDataFromPropertyFile("password");

	 //Read the test data from the excel sheet
	     	
	     	 String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
	     	
	 //Step 1: Launch the browser
	     	    WebDriver driver = new ChromeDriver();	
	     		sUtil.maximizeWindow(driver);
	     		sUtil.addImplicitlyWait(driver);
	     		
	  //Step 2: Load the URL
	     		driver.get(URL);
	     	
	     		LoginPage lp = new LoginPage(driver);
	     		lp.loginToApp(USERNAME, PASSWORD);
	     	
	  //Step 4: Click on the contacts link
	     		
	     		HomePage hp = new HomePage(driver);
	     		hp.clickOnContactsLink();
	  
	   //Step 5: Click on the create contact look up image
	     		
	     		ContactsPage cp = new ContactsPage(driver);
	     		cp.clickOnCreateContactLookUpImg();
	     		
	   //Step 6: Enter mandatory file  		
	     		
	     		CreateNewContactPage cncp = new CreateNewContactPage(driver);
	     		cncp.CreateNewContact(LASTNAME);
	     	
	    //Step 8:Validate
	     	
	     		ContactInfoPage cip = new ContactInfoPage(driver);
	     		String contactHeader = cip.CaptureHeaderText();
	    	
	            System.out.println(contactHeader);
	            if (contactHeader.contains(LASTNAME)) 
	     		{
	     			System.out.println("Pass");
	     		}
	     		else 
	     		{
	     			System.out.println("Fail");

	     		} 
	     		
	    //Step 9: Logout of application
	     		
	     		HomePage hpl = new HomePage(driver);
	     		hpl.logoutOfApp(driver);
	     		
	    // Step 10: To close the browser
	     		
	     		driver.quit();
	     
	}

}
