package createTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFilesUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;


@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactTestWithBaseClass extends BaseClass {
	
		@Test(groups="SmokeSuite")
		public void ContactTest() throws IOException, InterruptedException {
		
		 //Read the test data from the excel sheet
		      String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		  //Step 1: Click on the contacts link
		     		
		     		HomePage hp = new HomePage(driver);
		     		hp.clickOnContactsLink();
		  
		   //Step 2: Click on the create contact look up image
		     		
		     		ContactsPage cp = new ContactsPage(driver);
		     		cp.clickOnCreateContactLookUpImg();
		     		
		   //Step 3: Enter mandatory file  		
		     		
		     		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		     		cncp.CreateNewContact(LASTNAME);
		     	
		    //Step 4:Validate
		     	
		     		ContactInfoPage cip = new ContactInfoPage(driver);
		     		String contactHeader = cip.CaptureHeaderText();
		    	    Assert.assertTrue(contactHeader.contains(LASTNAME));
		            System.out.println(contactHeader);
		       }
		@Test
		public void demoTst()
		{
			Assert.fail();
			System.out.println("Hi");
		}
	}



