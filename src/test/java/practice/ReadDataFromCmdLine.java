package practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	public void sample()
	{
		String UN = System.getProperty("username");
		System.out.println(UN);
		
		String PSW = System.getProperty("password");
		System.out.println(PSW);
		
	}

}
