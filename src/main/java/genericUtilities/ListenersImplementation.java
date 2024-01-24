package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * This class provides Implementation for ITestListener Interface of TestNG
 * @author Kala
 */
public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		//Start of @Test -> Test Method -> Method Name
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("--------Test Execution Started--------");
		
		//For extent report to recognize the @Test
		 test = report.createTest(methodName);
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("----------Test PAss---------");
		
		//For logging the status of the test in the extent report
			test.log(Status.PASS, methodName+"----------Test PAss---------");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------Test Fail---------");
		System.out.println(result.getThrowable());// Print the Exception
		
		//For logging the status of the test in the extent report
		test.log(Status.FAIL, methodName+"----------Test Fail---------");
		test.log(Status.INFO, result.getThrowable());
		
		
		//Capture the screen shot
		
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		String screenShotName = methodName+"-"+ j.getSystemDate();
		
		try {
			String path = s.captureScreenShot(BaseClass.sDriver, screenShotName);
			
			//For attaching the screenshot for extent reports
			test.addScreenCaptureFromPath(path);
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------Test Skip---------");
		
		System.out.println(result.getThrowable());
		
		//For logging the status of the extent reports
		
		test.log(Status.SKIP, methodName+"---------Test Skip---------");
		test.log(Status.INFO, result.getThrowable());
		
	}
	
	public void onTestFailedWithSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		
		System.out.println("----------Suite Execution Started---------");
		
		//Extent Report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Execution Report");
		esr.config().setReportName("Vtiger Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Paltform", "Windows");
		report.setSystemInfo("Base environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter", "Kala");
		
	}
	
	public void onFinish(ITestContext context) {
		
		System.out.println("-----------Suite execution finished----------");
		
		//Extent Report Generation
		report.flush();
		
	}

}
