package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener interfaces of TestNG
 * @author PRIYA
 */

public class ListenersImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"....Test Script Execution Started....");
		//Create a test Script -recognize each @Test
		test=report.createTest(testScriptName);
				
	}
		

	@Override
	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"....Test Script PASSED....");
		//log the success
		test.log(Status.PASS, testScriptName+"====PASS==");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//screen shot
		//exception for failure
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"....Test Script FAILED....");
		
		//exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		
		test.log(Status.FAIL, testScriptName+"====FAIL=====");
		test.log(Status.INFO, result.getThrowable());
		//screenshot
		String screenshotName = testScriptName+new JavaUtilitiesEx().getSystemDate();
		WebDriverUtility w= new WebDriverUtility();
		try {
			String path = w.captureScreenshot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"....Test Script SKIPPED....");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for skip
		test.log(Status.SKIP, testScriptName+"===Skipped===");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(".....Suite Execution Started.......");
		//Basic Report configuration-//Report-17-10-2023-20-04-20.html
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtilitiesEx().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "FireFox");
		report.setSystemInfo("Base Platform","Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter", "Priya");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(".............Suite Execution Finished...........");
		
		//Report Generation
		report.flush();
		
	}
	

}
