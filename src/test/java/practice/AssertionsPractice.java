package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractice {
	
	@Test
	public void sample()
	{
		String s = "sample";
		
		System.out.println("Step1");
		System.out.println("Step2");
		
		//Assert.assertEquals(0, 1);//fail
		
		Assert.assertTrue(s.contains("s"));
		
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	
	public void sample1()
	{
		String s = "sample";
		
		System.out.println("Step1");
		System.out.println("Step2");
		
		//Assert.assertEquals(0, 1);//fail
		
		Assert.assertTrue(s.contains("s"));
		
		System.out.println("Step3");
		System.out.println("Step4");
	}

}
