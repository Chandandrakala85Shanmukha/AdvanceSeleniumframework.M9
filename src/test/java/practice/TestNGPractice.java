package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = 3)
	public void create()
	{
		System.out.println("create");
	}
	@Test(priority = -2)
	public void modify()
	{
		System.out.println("modify");
	}
	@Test(priority = -3)
	public void delete()
	{
		System.out.println("delete");
	}
	
	@Test(invocationCount = -3)//this method will be disabled
	public void test1()
	{
		System.out.println("test1");
	}
	
	@Test(enabled = true)//this method will be disabled. default value of enabled is true
	public void test2()
	{
		System.out.println("test2");
	}
	@Test
	public void trail1()
	{
		Assert.fail();
		System.out.println("trail1");
	}
	@Test(dependsOnMethods = "trail1")
	public void trail2()
	{
		System.out.println("trail2");
	}
	@Test
	public void trail3()
	{
		System.out.println("trail3");
	}

}
