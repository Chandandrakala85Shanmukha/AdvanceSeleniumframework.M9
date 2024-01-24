package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

    //open the document in Java readable Format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Create object of Properties class from Java.util
		 Properties p = new Properties();
		 
		 //Load the file Input stream properties
		 p.load(fis);
		 
		 //provide the key and read value
		 
		 String value = p.getProperty("url");
		 System.out.println(value);
		 
		

	}

}
