package createTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
public class CreateContactTestWithLeadSourceWithBaseClass extends BaseClass {
	@Test(groups="RegressionSuite")
	public void CreateContactTestWithLeadSource() throws EncryptedDocumentException, IOException  {
	     //Read the test data from the excel sheet
	     	
	     	 String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
	     	 String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);
	     
	     //Step 4: Click on the contacts link
	     		
	     		HomePage hp = new HomePage(driver);
	     		hp.clickOnContactsLink();
	     
	     //Step 5: Click on the create contact look up image
	     		
	     		ContactsPage cp = new ContactsPage(driver);
	     		cp.clickOnCreateContactLookUpImg();
	     		
	     //Step 6: Enter mandatory field and lead source data 		
	     		
	     		CreateNewContactPage cncp = new CreateNewContactPage(driver);
	       		cncp.CreateNewContact(LASTNAME, LEADSOURCE);
	     	
	     //Step 8:Validate
	     	
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
