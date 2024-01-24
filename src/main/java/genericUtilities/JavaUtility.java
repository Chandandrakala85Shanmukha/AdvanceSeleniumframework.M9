package genericUtilities;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * This class contains Java Related reusable methods
 * @author Kala
 *
 */
public class JavaUtility {
	/**
	 * This method will return the current date in particular format
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d = new Date();
		//String[] dArr = d.toString().split("");
		//String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
		
		//Date date = new Date();
		int year = LocalDateTime.now().getYear();
		int month = LocalDateTime.now().getMonthValue();
		int date = LocalDateTime.now().getDayOfMonth();
		
		return month + "-" + date + "-" + year;
		
		
		
	}

}
