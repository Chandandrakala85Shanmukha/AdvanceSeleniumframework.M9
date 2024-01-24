package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	@FindBy(name="leadsource")
	private WebElement LeadSourceDropDown;
	
	//Initialization
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return LeadSourceDropDown;
	}
	
	//Business Logic
	/**
	 * This method will create a new contact with Mandatory field
	 * @param LASTNAME
	 */
	
	public void CreateNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	public void CreateNewContact(String LASTNAME, String LEADSOURCE)
	{
		LastNameEdt.sendKeys(LASTNAME);
		handleDropDown(LeadSourceDropDown, LEADSOURCE);
		SaveBtn.click();
		
	}

}
