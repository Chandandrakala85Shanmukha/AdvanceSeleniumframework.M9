package practice;

import java.io.IOException;

import org.apache.logging.log4j.util.PropertiesUtil;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFilesUtility;
import genericUtilities.SeleniumUtility;

public class Scenario4WithDDTandGU {
	
	public static void main(String[] args) throws IOException {
		
		
		//To create a object utility
		
		PropertyFilesUtility pUtil = new PropertyFilesUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read all the required data
		
	 	//Read all the common data from the property file
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read the test data from the excel sheet
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 13, 2);
		
		
		
	}

}
