package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFilesUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException {
		
		PropertyFilesUtility pUtil = new PropertyFilesUtility();
		String value = pUtil.readDataFromPropertyFile("url");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Contacts",1,2);
		System.out.println(data);
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		
		
	}

}
