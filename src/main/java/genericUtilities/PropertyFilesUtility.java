package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of reusable methods related to property file
 * @author Kala
 */
public class PropertyFilesUtility {
	
	/**
	 * This method will read the data from the property file and return the value to the caller.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		 String value = p.getProperty(key);
		return value;
	}
	
		

}